package com.smaato.sdk.core.network;

import android.webkit.URLUtil;
import com.safedk.android.internal.partials.SmaatoNetworkBridge;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
class HttpCaller implements Interceptor {
    static final HttpCaller INSTANCE = new HttpCaller();

    HttpCaller() {
    }

    @Override // com.smaato.sdk.core.network.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String string = chain.request().uri().toString();
        if (URLUtil.isHttpUrl(string) || URLUtil.isHttpsUrl(string)) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
            httpURLConnection.setConnectTimeout((int) chain.connectTimeoutMillis());
            httpURLConnection.setReadTimeout((int) chain.readTimeoutMillis());
            httpURLConnection.setInstanceFollowRedirects(chain.request().followRedirects());
            httpURLConnection.setRequestMethod(chain.request().method());
            for (Map.Entry<String, List<String>> entry : chain.request().headers()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    httpURLConnection.addRequestProperty(entry.getKey(), it.next());
                }
            }
            Request.Body body = chain.request().body();
            if (body != null) {
                httpURLConnection.setDoOutput(true);
                body.writeTo(SmaatoNetworkBridge.urlConnectionGetOutputStream(httpURLConnection));
            }
            int iHttpUrlConnectionGetResponseCode = SmaatoNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
            String contentEncoding = httpURLConnection.getContentEncoding();
            int contentLength = httpURLConnection.getContentLength();
            Headers headersOf = Headers.of(httpURLConnection.getHeaderFields());
            List<String> listValues = headersOf.values("Content-Type");
            try {
                return Response.builder().request(chain.request()).responseCode(iHttpUrlConnectionGetResponseCode).headers(headersOf).mimeType(!listValues.isEmpty() ? MimeType.parse(listValues.get(0)) : null).connection(httpURLConnection).body(HttpBody.builder().source(new BufferedInputStream(SmaatoNetworkBridge.urlConnectionGetInputStream(httpURLConnection))).contentLength(contentLength).build()).encoding(contentEncoding).build();
            } catch (Exception e) {
                throw new HttpNoResponseBodyException(e, iHttpUrlConnectionGetResponseCode, headersOf);
            }
        }
        throw new MalformedURLException("expected http(s) scheme, got " + chain.request().uri().getScheme());
    }
}
