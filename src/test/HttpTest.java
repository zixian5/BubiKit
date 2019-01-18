package test;

import kit.SDK;
import kit.http.HttpKit;
import kit.model.request.AccountGetInfoRequest;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class HttpTest {

    public static void main(String[] args) throws Exception {
        String url = "http://127.0.0.1:29333";

        SDK sdk =new SDK(url);

        AccountGetInfoRequest request = new AccountGetInfoRequest();
        request.setAddress("a0018e4200a5c9e9b92bff8ca1c080f5a04619ca9f533f");
        request.setKey("hello");
        System.out.println(sdk.getAccountService().getAccountInfo(request));

    }
}
