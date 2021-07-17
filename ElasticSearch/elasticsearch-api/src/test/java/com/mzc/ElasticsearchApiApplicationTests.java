package com.mzc;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * es高级客户端API测试
 */

@SpringBootTest
class ElasticsearchApiApplicationTests {

//    @Autowired
//    private RestHighLevelClient restHighLevelClient;
//
//   //测试索引的创建
//    @Test
//    void testIndex() throws IOException {
//        //1.创建索引请求
//        CreateIndexRequest request = new CreateIndexRequest("java_test");
//        //2.客户端执行创建请求createIndexResponse,请求后获得响应
//        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
//        System.out.println(createIndexResponse);
//    }

}
