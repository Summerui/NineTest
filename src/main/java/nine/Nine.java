package main.java.nine;

import com.alibaba.fastjson.JSON;
import main.java.nine.register.Extra;
import main.java.nine.register.Sendone;
import main.java.nine.util.Utdid;
import main.java.nine.util.devices.Model;
import main.java.nine.util.devices.Phone;

import java.util.UUID;


public class Nine {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Utdid utdid = new Utdid();
        Model model = new Model();
        Phone phone = JSON.parseObject(model.phone_get(),Phone.class);
        Sendone sendone = new Sendone();
        Extra extra = new Extra();
        extra.setOs("Android");
        extra.setMac(phone.getDevice().getMacAddress());
        extra.setMachine(phone.getDevice().getModel());
        extra.setUserAgent(phone.getDevice().getUserAgent());
        extra.setSdkver(phone.getDevice().getSdk());
        extra.setImei(phone.getDevice().getImei());
        extra.setVersion("4.6.1.1");
        sendone.setRoot(false);
        sendone.setSimulator(false);
        sendone.setWua(String.valueOf(time));
        sendone.setWuaTS(time);
        sendone.setExtra(extra);
        sendone.setRequestId(UUID.randomUUID().toString());
        System.out.println(JSON.toJSON(sendone));
    }
}