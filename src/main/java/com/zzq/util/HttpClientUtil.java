package com.zzq.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpClientUtil {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            service.submit( new GetPage() );
        }
        service.shutdown();
    }

}
class GetPage implements Runnable{

    @Override
    public void run() {
        try {
            Date startDate = new Date();
            String url = "http://www.blobfish.cn/";

            // 创建 httpClient 对象
            HttpClient httpClient = HttpClients.createDefault();
            // 创建 url
            URIBuilder builder = new URIBuilder(url);
            builder.addParameter("username","xxx");
            URI uri = builder.build();

            // 创建 httpGet 请求
            HttpGet httpGet = new HttpGet(uri);

            // 执行请求
            HttpResponse response = httpClient.execute(httpGet);

            System.out.println( response.getStatusLine().getStatusCode() );
            // 处理返回数据
            if( response.getStatusLine().getStatusCode() == 200 ){
                System.out.println( "用时：" + (new Date().getTime() - startDate.getTime()) );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
