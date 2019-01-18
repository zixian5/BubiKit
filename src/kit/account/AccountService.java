package kit.account;

import com.google.gson.Gson;
import kit.http.HttpKit;
import kit.model.request.AccountGetInfoRequest;
import kit.model.response.AccountGetInfoResponse;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private String url;

    public AccountService(String url) throws Exception {
        if (url == null)
        {
            throw new Exception("The url is null");
        }
        this.url = url;
    }

    public AccountGetInfoResponse getAccountInfo(AccountGetInfoRequest request) throws Exception {
        if(request.getAddress() == null)
        {
            throw new Exception("The address can't be null");
        }

        Map<String,String> params = new HashMap<>();

        params.put("address",request.getAddress());

        if(request.getKey() != null){
            params.put("key",request.getKey());
        }

        if((request.getCode() == null && request.getIssure()!=null)||(request.getCode() != null && request.getIssure() == null)){
            throw  new Exception("The code and issuer must be same");
        }

        if(request.getIssure() != null){
            params.put("code",request.getCode());
            params.put("issuer",request.getIssure());
        }

        String path = url+"/getAccount";

        String response = HttpKit.get(path,params);
        return new Gson().fromJson(response,AccountGetInfoResponse.class);
    }
}
