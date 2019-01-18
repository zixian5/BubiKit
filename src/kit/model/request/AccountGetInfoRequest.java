package kit.model.request;

public class AccountGetInfoRequest {
    private String address;
    private String key;
    private String code;
    private String issure;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIssure() {
        return issure;
    }

    public void setIssure(String issure) {
        this.issure = issure;
    }
}
