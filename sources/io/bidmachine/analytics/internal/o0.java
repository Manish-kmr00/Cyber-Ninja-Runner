package io.bidmachine.analytics.internal;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes13.dex */
public enum o0 {
    Get("GET"),
    Post("POST");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12144a;

    o0(String str) {
        this.f12144a = str;
    }

    public final void a(URLConnection uRLConnection) throws ProtocolException {
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).setRequestMethod(this.f12144a);
        }
    }
}
