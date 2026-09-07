package com.bytedance.sdk.openadsdk.core.omh;

import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class ZZv {
    private static volatile ZZv KZx;
    private static int Og;
    private final List<ML> pA = new ArrayList();

    public static ZZv pA() {
        if (KZx == null) {
            synchronized (ZZv.class) {
                if (KZx == null) {
                    KZx = new ZZv();
                }
            }
        }
        return KZx;
    }

    public ML Og() {
        ML mlRemove;
        if (KZx() > 0 && (mlRemove = this.pA.remove(0)) != null) {
            return mlRemove;
        }
        return null;
    }

    public void pA(ML ml) {
        if (ml != null) {
            Og(ml);
        }
    }

    public void Og(ML ml) {
        if (ml != null) {
            if (this.pA.size() >= Og) {
                ml.WV();
            } else {
                if (this.pA.contains(ml)) {
                    return;
                }
                KZx(ml);
                this.pA.add(ml);
            }
        }
    }

    public int KZx() {
        return this.pA.size();
    }

    public void KZx(ML ml) {
        if (ml == null || ml.getWebView() == null) {
            return;
        }
        if (ml.getParent() != null) {
            ((ViewGroup) ml.getParent()).removeView(ml);
        }
        try {
            ml.removeAllViews();
            ml.KZx();
            ml.setWebChromeClient(null);
            ml.setWebViewClient(null);
            ml.setDownloadListener(null);
            ml.setDefaultTextEncodingName("UTF-8");
            ml.setAllowFileAccess(false);
            ml.setJavaScriptEnabled(true);
            ml.setCacheMode(-1);
            ml.setDatabaseEnabled(true);
            ml.setSupportZoom(false);
            ml.getWebView().setLayerType(0, null);
            ml.setBackgroundColor(0);
            ml.getWebView().setHorizontalScrollBarEnabled(false);
            ml.getWebView().setHorizontalScrollbarOverlay(false);
            ml.getWebView().setVerticalScrollBarEnabled(false);
            ml.getWebView().setVerticalScrollbarOverlay(false);
            com.bytedance.sdk.openadsdk.core.widget.pA.KZx.pA(ml);
            ml.SGo();
            ml.setMixedContentMode(0);
        } catch (Exception unused) {
        }
    }
}
