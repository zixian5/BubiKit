package kit.http;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class Verifier implements HostnameVerifier {
    public Verifier() {
    }

    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
}