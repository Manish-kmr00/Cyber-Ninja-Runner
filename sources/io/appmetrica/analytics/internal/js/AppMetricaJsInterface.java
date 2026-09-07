package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C4278m1;

/* JADX INFO: loaded from: classes13.dex */
public class AppMetricaJsInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C4278m1 f11891a;

    public AppMetricaJsInterface(C4278m1 c4278m1) {
        this.f11891a = c4278m1;
    }

    @JavascriptInterface
    public void reportEvent(String str, String str2) {
        this.f11891a.d(str, str2);
    }
}
