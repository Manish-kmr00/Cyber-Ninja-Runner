package com.bytedance.sdk.component.pA;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public class SGo {
    Wx Bzk;
    boolean DX;
    boolean JG;
    Context ML;
    pA Og;
    boolean SD;
    Sn SGo;
    boolean Sn;
    omh ZZv;
    BSW.pA oX;
    boolean omh;
    WebView pA;
    String KZx = "IESJSBridge";
    String BSW = "host";
    final Set<String> WV = new LinkedHashSet();
    final Set<String> Wx = new LinkedHashSet();

    SGo(WebView webView) {
        this.pA = webView;
    }

    SGo() {
    }

    public SGo pA(pA pAVar) {
        this.Og = pAVar;
        return this;
    }

    public SGo pA(String str) {
        this.KZx = str;
        return this;
    }

    public SGo pA(WV wv) {
        this.ZZv = omh.pA(wv);
        return this;
    }

    public SGo pA(boolean z) {
        this.JG = z;
        return this;
    }

    public SGo Og(boolean z) {
        this.SD = z;
        return this;
    }

    public SGo pA() {
        this.DX = true;
        return this;
    }

    public aBv Og() {
        KZx();
        return new aBv(this);
    }

    private void KZx() {
        if ((this.pA == null && !this.Sn && this.Og == null) || ((TextUtils.isEmpty(this.KZx) && this.pA != null) || this.ZZv == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }
}
