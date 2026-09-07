package com.bytedance.sdk.component.pA;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class aBv {
    static BF pA;
    private volatile boolean JG;
    private final WebView KZx;
    private final List<Sn> ML;
    private final pA Og;
    private final SGo ZZv;

    public static SGo pA(WebView webView) {
        return new SGo(webView);
    }

    public aBv pA(String str, ML<?, ?> ml) {
        return pA(str, (String) null, ml);
    }

    public aBv pA(String str, String str2, ML<?, ?> ml) {
        Og();
        this.Og.SD.pA(str, ml);
        return this;
    }

    public aBv pA(String str, ZZv.Og og) {
        return pA(str, (String) null, og);
    }

    public aBv pA(String str, String str2, ZZv.Og og) {
        Og();
        this.Og.SD.pA(str, og);
        return this;
    }

    public void pA() {
        if (this.JG) {
            return;
        }
        this.Og.Og();
        this.JG = true;
        Iterator<Sn> it = this.ML.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    aBv(SGo sGo) {
        ArrayList arrayList = new ArrayList();
        this.ML = arrayList;
        this.JG = false;
        this.ZZv = sGo;
        if (sGo.omh && pA != null) {
            throw null;
        }
        if (sGo.pA != null && sGo.Og == null) {
            this.Og = new du();
        } else {
            this.Og = sGo.Og;
        }
        this.Og.pA(sGo, (TX) null);
        this.KZx = sGo.pA;
        arrayList.add(sGo.SGo);
        TV.pA(sGo.SD);
    }

    private void Og() {
        if (this.JG) {
            Bzk.pA(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
