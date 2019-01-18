package kit;

import kit.account.AccountService;

public class SDK {
    private String url;
    private AccountService accountService;

    public SDK(String url) throws Exception {
        if (url == null)
        {
            throw new Exception("The url is null");
        }
        this.url = url;
        accountService = new AccountService(url);
    }

    public AccountService getAccountService(){
        return accountService;
    }

}
