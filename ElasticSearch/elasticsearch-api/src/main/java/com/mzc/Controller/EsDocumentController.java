package com.mzc.Controller;

import com.alibaba.fastjson.JSON;
import com.mzc.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author MaZhiCheng
 * @date 2021/7/11 - 22:21
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */
@Api(description = "ES文档操作")
@RestController
@RequestMapping("esdocument")
public class EsDocumentController {


    @Autowired
    private RestHighLevelClient restHighLevelClient;


    //测试添加文档
    @GetMapping("adddoc")
    public String addDocument() throws IOException {
        //创建对象
        User user = new User("马志成",18,"腹有诗书气自华","java开发 编程 直男 单身");
        //创建请求
        IndexRequest request = new IndexRequest("java_test");
        //规则    put/jikemis/_doc/1
        request.id("1");
        request.timeout("1ms");
        //将我们的数据放入请求
        IndexRequest source = request.source(JSON.toJSONString(user), XContentType.JSON);
        //客户端发送请求,获取响应的结果
        IndexResponse indexResponse = restHighLevelClient.index(source, RequestOptions.DEFAULT);
        System.out.println(indexResponse.toString());
        System.out.println(indexResponse.status());
        return indexResponse.toString();
    }

    //获取文档,判断是否存在
    @GetMapping("existdoc")
    public String getExistDocument() throws IOException {
        GetRequest getRequest = new GetRequest("java_test", "1");
        //不获取返回的_sources的上下文
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");
        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
        if(exists){
            return "文档存在！";
        }else {
            return "文档不存在！";
        }
    }

    //获取文档的信息
    @GetMapping("getdoc")
    public String getDocument() throws IOException {
        GetRequest getRequest = new GetRequest("java_test", "1");
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(getResponse.getSourceAsString());//打印文档的内容
        System.out.println(getResponse);
        return getResponse.getSourceAsString();
    }

    //更新文档的信息
    @GetMapping("updatedoc")
    public String updateDocument() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("java_test", "1");
        updateRequest.timeout("1ms");
        User user = new User("马志成",22,"腹有诗书气自华","java开发 编程 直男 单身");
        updateRequest.doc(JSON.toJSON(user),XContentType.JSON);
        UpdateResponse updateResponse = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(updateResponse);
        System.out.println(updateResponse.status());
        return updateResponse.toString();

    }

    //删除文档的信息
    @GetMapping("deletedoc")
    public String deleteDocument() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("java_test", "1");
        deleteRequest.timeout("1ms");
        DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(deleteResponse.status());
        return deleteResponse.toString();

    }

    //真实的项目一般会批量插入数据
    @GetMapping("bulkdoc")
    public String BulkRequest() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10ms");
        ArrayList<User> userlits = new ArrayList<>();
        userlits.add(new User("曾家豪",22,"腹有诗书气自华","java开发 编程 直男 单身"));
        userlits.add(new User("高雅函",22,"腹有诗书气自华1","java开发 编程 直男 单身"));
        userlits.add(new User("李潭",23,"腹有诗书气自华2","java开发 编程 直男 单身"));
        userlits.add(new User("谢伟业",22,"腹有诗书气自华3","java开发 编程 直男 单身"));
        userlits.add(new User("柳陶鑫",23,"腹有诗书气自华4","java开发 编程 直男 单身"));

        //批处理请求
        for (int i = 0; i < userlits.size(); i++) {
            bulkRequest.add(new IndexRequest("java_test")
            .id(""+(i+1))
            .source(JSON.toJSONString(userlits.get(i)),XContentType.JSON)
            );
        }
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulkResponse.hasFailures());
        if(bulkResponse.hasFailures()){
            return "批量插入数据成功!";
        }else{
            return "批量插入数据失败!";
        }
    }


    //查询操作测试
    @GetMapping("essearch")
    @ApiOperation(value = "按条件搜寻")
    public String esSearch(String name,String value) throws IOException {
        SearchRequest searchRequest = new SearchRequest("java_test");
        //构建搜索条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();


        //构建查询的条件，我们可以使用QueryBuilders实现
        /*
        QueryBuilders.termQuery:精确匹配查询
        QueryBuilders.matchAllQuery:匹配所有
         */
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery(name, value);
//        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        sourceBuilder.query(termQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(searchResponse.getHits()));
        for (SearchHit documentFields : searchResponse.getHits().getHits()) {
            System.out.println(documentFields.getSourceAsMap());
        }

        return JSON.toJSONString(searchResponse.getHits());
    }





}
