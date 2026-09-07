package com.ogury.core.internal.network;

import com.ogury.core.internal.f;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: NetworkCall.kt */
/* JADX INFO: loaded from: classes10.dex */
public final class a implements Call {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetworkRequest f7498a;
    public final int b;
    public final int c;

    public a(NetworkRequest request, int i, int i2) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.f7498a = request;
        this.b = i;
        this.c = i2;
    }

    public static String a(HttpURLConnection httpURLConnection, boolean z) {
        byte[] bytes;
        if (httpURLConnection.getContentLength() == 0) {
            return "";
        }
        InputStream inputStream = !z ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
        try {
            try {
                Intrinsics.checkNotNull(inputStream);
                bytes = ByteStreamsKt.readBytes(inputStream);
                CloseableKt.closeFinally(inputStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        } catch (Exception unused) {
            bytes = new byte[0];
        }
        Intrinsics.checkNotNullParameter(httpURLConnection, "<this>");
        String headerField = httpURLConnection.getHeaderField("Content-Encoding");
        if (headerField != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = headerField.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "gzip")) {
                Intrinsics.checkNotNullParameter(bytes, "<this>");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(bytes)), "UTF-8"));
                try {
                    return TextStreamsKt.readText(bufferedReader);
                } finally {
                    CloseableUtilKt.closeSafely(bufferedReader);
                }
            }
        }
        return new String(bytes, Charsets.UTF_8);
    }

    @Override // com.ogury.core.internal.network.Call
    public final NetworkResponse execute() {
        try {
            HttpURLConnection httpURLConnectionA = a(new URL(this.f7498a.getUrl()));
            for (Map.Entry<String, String> entry : this.f7498a.getHeaders().loadHeaders().entrySet()) {
                httpURLConnectionA.setRequestProperty(entry.getKey(), entry.getValue());
            }
            a(httpURLConnectionA);
            int responseCode = httpURLConnectionA.getResponseCode();
            if (responseCode >= 200 && responseCode <= 299) {
                return new NetworkResponse.Success(a(httpURLConnectionA, false), httpURLConnectionA.getHeaderFields());
            }
            return new NetworkResponse.Failure(a(httpURLConnectionA, true), httpURLConnectionA.getHeaderFields(), new NetworkException(responseCode));
        } catch (Exception e) {
            return new NetworkResponse.Failure("", null, e);
        }
    }

    public final void a(HttpURLConnection httpURLConnection) {
        byte[] bytes;
        if (this.f7498a.getBody().length() > 0) {
            OutputStream outputStream = null;
            try {
                HeadersLoader headers = this.f7498a.getHeaders();
                Intrinsics.checkNotNullParameter(headers, "<this>");
                if (Intrinsics.areEqual(headers.loadHeaders().get("Content-Encoding"), "gzip")) {
                    bytes = f.a(this.f7498a.getBody());
                } else {
                    bytes = this.f7498a.getBody().getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                }
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bytes);
                CloseableUtilKt.closeSafely(outputStream);
            } catch (Throwable th) {
                if (outputStream != null) {
                    CloseableUtilKt.closeSafely(outputStream);
                }
                throw th;
            }
        }
    }

    public final HttpURLConnection a(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.setReadTimeout(this.b);
        httpURLConnection.setConnectTimeout(this.c);
        httpURLConnection.setRequestMethod(this.f7498a.getMethod());
        httpURLConnection.setDoOutput(this.f7498a.getBody().length() > 0);
        return httpURLConnection;
    }
}
