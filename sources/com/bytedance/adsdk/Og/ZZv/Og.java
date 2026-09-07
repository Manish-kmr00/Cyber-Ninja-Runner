package com.bytedance.adsdk.Og.ZZv;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes9.dex */
public class Og implements JG {
    @Override // com.bytedance.adsdk.Og.ZZv.JG
    public ZZv pA(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new pA(httpURLConnection);
    }
}
