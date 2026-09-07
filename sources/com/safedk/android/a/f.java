package com.safedk.android.a;

import com.safedk.android.SafeDK;
import com.safedk.android.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes7.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7950a = f.class.getSimpleName();
    private HttpURLConnection b;

    public f(URLConnection uRLConnection) {
        this.b = (HttpURLConnection) uRLConnection;
    }

    public void a(boolean z) {
        this.b.setUseCaches(z);
    }

    public void a(String str) throws ProtocolException {
        this.b.setRequestMethod(str);
    }

    public void a(String str, String str2) {
        this.b.setRequestProperty(str, str2);
    }

    public void b(boolean z) {
        this.b.setDoOutput(z);
    }

    public OutputStream a() throws IOException {
        return this.b.getOutputStream();
    }

    public void c(boolean z) {
        this.b.setInstanceFollowRedirects(z);
    }

    public int b() throws IOException {
        return this.b.getResponseCode();
    }

    public URL c() {
        return this.b.getURL();
    }

    public void a(int i) {
        this.b.setConnectTimeout(i);
    }

    public void d() {
        this.b.disconnect();
    }

    public InputStream e() throws IOException {
        return this.b.getInputStream();
    }

    public void f() throws IOException {
        if (SafeDK.getInstance().t()) {
            Logger.e(f7950a, "SafeDK network activity in offline mode ");
            Logger.printStackTrace();
        }
        this.b.connect();
    }

    public String b(String str) {
        return this.b.getHeaderField(str);
    }

    public InputStream g() {
        return this.b.getErrorStream();
    }

    public void d(boolean z) {
        this.b.setDoInput(z);
    }

    public void b(int i) {
        this.b.setReadTimeout(i);
    }
}
