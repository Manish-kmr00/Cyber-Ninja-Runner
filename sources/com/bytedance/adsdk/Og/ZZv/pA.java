package com.bytedance.adsdk.Og.ZZv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes6.dex */
public class pA implements ZZv {
    private final HttpURLConnection pA;

    public pA(HttpURLConnection httpURLConnection) {
        this.pA = httpURLConnection;
    }

    @Override // com.bytedance.adsdk.Og.ZZv.ZZv
    public boolean pA() {
        try {
            return this.pA.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.bytedance.adsdk.Og.ZZv.ZZv
    public InputStream Og() throws IOException {
        return this.pA.getInputStream();
    }

    @Override // com.bytedance.adsdk.Og.ZZv.ZZv
    public String KZx() {
        return this.pA.getContentType();
    }

    @Override // com.bytedance.adsdk.Og.ZZv.ZZv
    public String ZZv() {
        try {
            if (pA()) {
                return null;
            }
            return "Unable to fetch " + this.pA.getURL() + ". Failed with " + this.pA.getResponseCode() + "\n" + pA(this.pA);
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.pA.disconnect();
    }

    private String pA(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line).append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }
}
