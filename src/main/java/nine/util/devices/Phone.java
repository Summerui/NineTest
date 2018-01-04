package main.java.nine.util.devices;

public class Phone {
    private int code;
    private Device device;

    public Device getDevice() { return device; }
    public void setDevice(Device device) {
        this.device = device;
    }
    public int getCode() { return code; }
    public void setCode(int code) {
        this.code = code;
    }
}