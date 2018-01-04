package main.java.nine.register;

import com.alibaba.fastjson.JSON;
import main.java.nine.util.devices.Phone;

public class RegisterPostJson {
        private Client getClient(){
            Client client = new Client();
            client.setAppId(112);
            client.setOs("android");

            return client;
        }

        private Extra getExtra(){
            Extra extra = new Extra();
            Phone phone = new Phone();
            extra.setMac(phone.getDevice().getMacAddress());
            extra.setMachine(phone.getDevice().getModel());
            extra.setUserAgent(phone.getDevice().getUserAgent());
            extra.setSdkver(phone.getDevice().getSdk());
            extra.setImei(phone.getDevice().getImei());
            extra.setVersion("4.6.1.1");
            extra.setOs("Android");
            return extra;
        }


}
