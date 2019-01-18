package kit.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class HttpKit {
    private static final String DEFAULT_CHARSET = "UTF-8";
    public static boolean enableSSL = false;

    public HttpKit() {
    }

    public static String get(String url, Boolean https) throws NoSuchAlgorithmException, NoSuchProviderException, IOException, KeyManagementException {
        StringBuffer bufferRes = null;
        TrustManager[] tm = new TrustManager[]{new MyX509TrustManager()};
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        sslContext.init((KeyManager[])null, tm, new SecureRandom());
        SSLSocketFactory ssf = sslContext.getSocketFactory();
        URL urlGet = new URL(url);
        HttpsURLConnection http = (HttpsURLConnection)urlGet.openConnection();
        http.setConnectTimeout(25000);
        http.setReadTimeout(25000);
        http.setRequestMethod("GET");
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        http.setSSLSocketFactory(ssf);
        http.setHostnameVerifier(new Verifier());
        http.setDoOutput(true);
        http.setDoInput(true);
        http.connect();
        InputStream in = http.getInputStream();
        BufferedReader read = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        String valueString = null;
        bufferRes = new StringBuffer();

        while((valueString = read.readLine()) != null) {
            bufferRes.append(valueString);
        }

        read.close();
        in.close();
        if (http != null) {
            http.disconnect();
        }

        return bufferRes.toString();
    }

    public static String get(String url) throws NoSuchAlgorithmException, NoSuchProviderException, IOException, KeyManagementException {
        System.out.println(url);
        if (enableSSL) {
            return get(url, true);
        } else {
            StringBuffer bufferRes = null;
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection)urlGet.openConnection();
            http.setConnectTimeout(25000);
            http.setReadTimeout(25000);
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            http.connect();
            InputStream in = http.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String valueString = null;
            bufferRes = new StringBuffer();

            while((valueString = read.readLine()) != null) {
                bufferRes.append(valueString);
            }

            read.close();
            in.close();
            if (http != null) {
                http.disconnect();
            }

            return bufferRes.toString();
        }
    }

    public static String get(String url, Map<String, String> params) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
        return get(initParams(url, params));
    }

    public static String post(String url, String params, Boolean https) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
        StringBuffer bufferRes = null;
        TrustManager[] tm = new TrustManager[]{new MyX509TrustManager()};
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        sslContext.init((KeyManager[])null, tm, new SecureRandom());
        SSLSocketFactory ssf = sslContext.getSocketFactory();
        URL urlGet = new URL(url);
        HttpsURLConnection http = (HttpsURLConnection)urlGet.openConnection();
        http.setConnectTimeout(50000);
        http.setReadTimeout(50000);
        http.setRequestMethod("POST");
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        http.setSSLSocketFactory(ssf);
        http.setHostnameVerifier(new Verifier());
        http.setDoOutput(true);
        http.setDoInput(true);
        http.connect();
        OutputStream out = http.getOutputStream();
        out.write(params.getBytes("UTF-8"));
        out.flush();
        out.close();
        InputStream in = http.getInputStream();
        BufferedReader read = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        String valueString = null;
        bufferRes = new StringBuffer();

        while((valueString = read.readLine()) != null) {
            bufferRes.append(valueString);
        }

        read.close();
        in.close();
        if (http != null) {
            http.disconnect();
        }

        return bufferRes.toString();
    }

    public static String post(String url, String params) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
        if (enableSSL) {
            return post(url, params, true);
        } else {
            StringBuffer bufferRes = null;
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection)urlGet.openConnection();
            http.setConnectTimeout(50000);
            http.setReadTimeout(50000);
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type", "application/json");
            http.setDoOutput(true);
            http.setDoInput(true);
            http.connect();
            OutputStream out = http.getOutputStream();
            out.write(params.getBytes("UTF-8"));
            out.flush();
            out.close();
            InputStream in = http.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String valueString = null;
            bufferRes = new StringBuffer();

            while((valueString = read.readLine()) != null) {
                bufferRes.append(valueString);
            }

            read.close();
            in.close();
            if (http != null) {
                http.disconnect();
            }

            return bufferRes.toString();
        }
    }

    private static String initParams(String url, Map<String, String> params) {
        if (null != params && !params.isEmpty()) {
            StringBuilder sb = new StringBuilder(url);
            if (url.indexOf("?") == -1) {
                sb.append("?");
            } else {
                sb.append("&");
            }

            boolean first = true;
            Iterator var4 = params.entrySet().iterator();

            while(true) {
                String value;
                do {
                    if (!var4.hasNext()) {
                        return sb.toString();
                    }

                    Entry<String, String> entry = (Entry)var4.next();
                    if (first) {
                        first = false;
                    } else {
                        sb.append("&");
                    }

                    String key = (String)entry.getKey();
                    value = (String)entry.getValue();
                    sb.append(key).append("=");
                    try {
                        sb.append(URLEncoder.encode(value, "UTF-8"));
                    } catch (UnsupportedEncodingException var9) {
                        var9.printStackTrace();
                    }
                } while(value != null && !value.isEmpty());

            }
        } else {
            return url;
        }
    }

    public static void main(String[] args) throws Exception {
    }
}