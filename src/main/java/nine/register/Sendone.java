package main.java.nine.register;

public class Sendone {
    private String wua;
    private boolean isRoot;
    private Long wuaTS;
    private String requestId;
    private Extra extra;
    private String umidToken;
    private boolean isSimulator;

    public String getWua() {
        return wua;
    }

    public void setWua(String wua) {
        this.wua = wua;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public Long getWuaTS() {
        return wuaTS;
    }

    public void setWuaTS(Long wuaTS) {
        this.wuaTS = wuaTS;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public String getUmidToken() {
        return umidToken;
    }

    public void setUmidToken(String umidToken) {
        this.umidToken = umidToken;
    }

    public boolean isSimulator() {
        return isSimulator;
    }

    public void setSimulator(boolean simulator) {
        isSimulator = simulator;
    }
}
