package com.amazon.device.ads;

import androidx.browser.trusted.sharing.ShareTarget;
import com.json.b9;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.d;
import com.safedk.android.internal.partials.AmazonPublisherServicesNetworkBridge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONException;

/* JADX INFO: loaded from: classes13.dex */
class DtbHttpClient {
    private String message;
    private int responseCode;
    private String url;
    private boolean secure = true;
    private boolean isQueryParamsEnabled = false;
    private String response = null;
    private HashMap<String, Object> params = new HashMap<>();
    private HashMap<String, Object> headers = new HashMap<>();

    private enum HTTPMethod {
        POST,
        GET
    }

    protected String getResponse() {
        return this.response;
    }

    protected String getErrorMessage() {
        return this.message;
    }

    protected int getResponseCode() {
        return this.responseCode;
    }

    protected DtbHttpClient(String str) {
        this.url = str;
    }

    protected void addParam(String str, String str2) {
        this.params.put(str, str2);
    }

    protected void addHeader(String str, String str2) {
        this.headers.put(str, str2);
    }

    protected HashMap<String, Object> getParams() {
        return this.params;
    }

    protected void setParams(HashMap<String, Object> map) {
        this.params = map;
    }

    protected HashMap<String, Object> getHeaders() {
        return this.headers;
    }

    protected void setHeaders(HashMap<String, Object> map) {
        this.headers = map;
    }

    protected String getUrl() {
        return this.url;
    }

    protected void setUrl(String str) {
        this.url = str;
    }

    public void setUseSecure(boolean z) {
        this.secure = z;
    }

    public void enableQueryParams() {
        this.isQueryParamsEnabled = true;
    }

    protected void executePOST(int i) throws JSONException, IOException {
        String str = (this.secure ? "https://" : d.v) + this.url;
        DtbLog.debug("POST URL:" + str);
        executeRequest(HTTPMethod.POST, new URL(str), i);
    }

    public boolean isHttpStatusCodeOK() {
        return this.responseCode == 200;
    }

    private String getQueryParams() {
        String str = "";
        if (!this.params.isEmpty()) {
            for (String str2 : this.params.keySet()) {
                if (this.params.get(str2) != null) {
                    String str3 = str2 + "=" + DtbCommonUtils.getURLEncodedString(this.params.get(str2).toString());
                    if (str.length() > 1) {
                        str = str + b9.i.c + str3;
                    } else {
                        str = str + str3;
                    }
                }
            }
        }
        return str;
    }

    private String getParamsAsJsonString() throws JSONException {
        return DtbCommonUtils.getParamsAsJsonString(this.params);
    }

    protected void executeGET(int i) throws JSONException, IOException {
        String str = this.params.isEmpty() ? "" : "?" + getQueryParams();
        String str2 = this.url;
        if (!str2.startsWith("https://") && !this.url.startsWith(d.v)) {
            str2 = (this.secure ? "https://" : d.v) + this.url;
        }
        DtbLog.debug("GET URL:" + str2);
        DtbLog.debug("with params: " + str);
        executeRequest(HTTPMethod.GET, new URL(str2 + str), i);
    }

    private void executeRequest(HTTPMethod hTTPMethod, URL url, int i) throws JSONException, IOException {
        String paramsAsJsonString;
        HttpURLConnection httpURLConnectionCreateDefaultConnection = createDefaultConnection(url, i);
        StringBuilder sb = new StringBuilder();
        for (String str : this.headers.keySet()) {
            String string = this.headers.get(str) != null ? this.headers.get(str).toString() : "";
            httpURLConnectionCreateDefaultConnection.setRequestProperty(str, string);
            sb.append(str + ":" + string + " ");
        }
        DtbLog.debug("with headers:[" + ((Object) sb) + b9.i.e);
        if (hTTPMethod == HTTPMethod.POST) {
            httpURLConnectionCreateDefaultConnection.setDoOutput(true);
            if (!this.params.isEmpty()) {
                if (this.isQueryParamsEnabled) {
                    httpURLConnectionCreateDefaultConnection.setRequestProperty("content-type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
                    paramsAsJsonString = getQueryParams();
                } else {
                    httpURLConnectionCreateDefaultConnection.setRequestProperty("content-type", "application/json; charset=utf-8");
                    paramsAsJsonString = getParamsAsJsonString();
                }
                DtbLog.debug("with json params:[" + paramsAsJsonString + b9.i.e);
                OutputStream outputStreamUrlConnectionGetOutputStream = AmazonPublisherServicesNetworkBridge.urlConnectionGetOutputStream(httpURLConnectionCreateDefaultConnection);
                outputStreamUrlConnectionGetOutputStream.write(paramsAsJsonString.getBytes());
                outputStreamUrlConnectionGetOutputStream.flush();
                outputStreamUrlConnectionGetOutputStream.close();
            }
        }
        try {
            try {
                InputStream inputStreamUrlConnectionGetInputStream = AmazonPublisherServicesNetworkBridge.urlConnectionGetInputStream(httpURLConnectionCreateDefaultConnection);
                if (inputStreamUrlConnectionGetInputStream == null) {
                    return;
                }
                this.responseCode = AmazonPublisherServicesNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnectionCreateDefaultConnection);
                this.message = httpURLConnectionCreateDefaultConnection.getResponseMessage();
                this.response = convertStreamToString(inputStreamUrlConnectionGetInputStream);
                inputStreamUrlConnectionGetInputStream.close();
                DtbLog.debug("Response :" + this.response);
            } catch (Exception e) {
                this.response = null;
                DtbLog.debug("Error while connecting to remote server: " + httpURLConnectionCreateDefaultConnection.getURL().toString() + " with error:" + e.getMessage());
            }
        } finally {
            AmazonPublisherServicesNetworkBridge.httpUrlConnectionDisconnect(httpURLConnectionCreateDefaultConnection);
        }
    }

    private HttpURLConnection createDefaultConnection(URL url, int i) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(1000);
        httpURLConnection.setReadTimeout(i);
        return httpURLConnection;
    }

    private static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line + "\n");
                } catch (IOException e) {
                    DtbLog.debug("Error converting stream to string. Ex=" + e);
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                throw th;
            }
        }
        inputStream.close();
        return sb.toString();
        try {
            inputStream.close();
        } catch (IOException unused2) {
        }
        return sb.toString();
    }
}
