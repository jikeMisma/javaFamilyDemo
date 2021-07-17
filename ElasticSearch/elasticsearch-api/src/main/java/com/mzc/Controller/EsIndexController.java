package com.mzc.Controller;

import io.swagger.annotations.Api;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author MaZhiCheng
 * @date 2021/7/11 - 21:56
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Api(description = "ES索引操作")
@RestController
@RequestMapping("esindex")
public class EsIndexController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    //测试索引的创建
    @GetMapping("createindex")
    public String testIndex() throws IOException {
        //1.创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("java_test");
        //2.客户端执行创建请求createIndexResponse,请求后获得响应
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
        return createIndexResponse.toString();
    }

    //测试获取索引，判断其是否存在
    @GetMapping("existindex")
    public String existIndex() throws IOException {
        //1.创建索引请求
        GetIndexRequest request = new GetIndexRequest("java_test");
        //2.客户端执行创建请求createIndexResponse,请求后获得响应
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
        if (exists){
            return "索引存在1";
        }else {
            return "索引不存在1";
        }

    }

    //测试删除索引
    @GetMapping("deleteindex")
    public String deleteIndex() throws IOException {
        //1.创建索引请求
        DeleteIndexRequest request = new DeleteIndexRequest("java_test");
        //2.客户端执行创建请求createIndexResponse,请求后获得响应
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(delete);
        return delete.toString();
    }

}
