package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C4278m1;

/* JADX INFO: loaded from: classes12.dex */
public class AppMetricaInitializerJsInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C4278m1 f11890a;

    public AppMetricaInitializerJsInterface(C4278m1 c4278m1) {
        this.f11890a = c4278m1;
    }

    @JavascriptInterface
    public void init(String str) {
        this.f11890a.c(str);
    }
}
