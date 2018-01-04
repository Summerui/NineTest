package main.java.nine.util.devices;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Model {
    public String phone_get() {
        String strResult = null;
        HttpGet request = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            request = new HttpGet("http://mm.gzmtx.cn:8085/service/randomDevice.do?t=json");
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                strResult = EntityUtils.toString(response.getEntity());
            } else {
                throw new IOException("get请求提交失败:" + "http://mm.gzmtx.cn:8085/service/randomDevice.do?t=json");
            }
        } catch (IOException e) {
            System.out.println("err" + e);
        }
        return strResult;
    }
}
