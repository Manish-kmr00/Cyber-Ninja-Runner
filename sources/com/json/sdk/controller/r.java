package com.json.sdk.controller;

import android.webkit.JavascriptInterface;

/* JADX INFO: loaded from: classes13.dex */
class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private s f4349a;
    private boolean b = false;

    r(s sVar) {
        this.f4349a = sVar;
    }

    @JavascriptInterface
    public String getTokenForMessaging() {
        if (this.b) {
            return "";
        }
        this.b = true;
        return this.f4349a.b();
    }
}
