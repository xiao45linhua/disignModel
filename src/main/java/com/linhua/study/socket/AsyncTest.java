package com.linhua.study.socket;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import java.util.concurrent.Future;

/**
 * @author linhua
 * @date 2020/11/23
 * @description
 */
public class AsyncTest {

    CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
//    client.start();
    HttpGet request = new HttpGet("http://localhost:8080");

    Future<HttpResponse> future = client.execute(request, null);
//    HttpResponse response = future.get();
//    client.close();
}
