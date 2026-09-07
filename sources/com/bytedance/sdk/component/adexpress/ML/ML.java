package com.bytedance.sdk.component.adexpress.ML;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.pA.du;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes11.dex */
public class ML {
    private static volatile ML Bzk = null;
    private static int JG = 10;
    private static final byte[] ML = new byte[0];
    private static int omh = 10;
    private final AtomicBoolean SD = new AtomicBoolean(false);
    private List<com.bytedance.sdk.component.Bzk.ZZv> pA = new ArrayList();
    private List<com.bytedance.sdk.component.Bzk.ZZv> Og = new ArrayList();
    private Map<Integer, KZx> KZx = new HashMap();
    private Map<Integer, ZZv> ZZv = new HashMap();

    private ML() {
        com.bytedance.sdk.component.adexpress.pA.pA.KZx KZx = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx();
        if (KZx != null) {
            JG = KZx.SGo();
            omh = KZx.BSW();
        }
    }

    public static ML pA() {
        if (Bzk == null) {
            synchronized (ML.class) {
                if (Bzk == null) {
                    Bzk = new ML();
                }
            }
        }
        return Bzk;
    }

    public com.bytedance.sdk.component.Bzk.ZZv pA(Context context, String str) {
        if (ZZv() <= 0) {
            return null;
        }
        if (com.bytedance.sdk.component.adexpress.ZZv.ML.pA(str) && ZZv() <= 1) {
            new Object[]{"get WebView from newengine pool; but ad type is does not meet the requirement ", Integer.valueOf(ZZv())};
            return null;
        }
        com.bytedance.sdk.component.Bzk.ZZv zZvRemove = this.Og.remove(0);
        if (zZvRemove == null) {
            return null;
        }
        try {
            Context context2 = zZvRemove.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context.getApplicationContext());
                zZvRemove.setRecycler(false);
                new Object[]{"get WebView from newengine pool; current available count: ", Integer.valueOf(ZZv())};
            }
            return zZvRemove;
        } catch (Throwable unused) {
            new Object[]{"get WebView from newengine pool exception; current available count: ", Integer.valueOf(ZZv())};
            return null;
        }
    }

    public void pA(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        if (zZv == null) {
            return;
        }
        if (this.Og.size() >= omh) {
            try {
                Context context = zZv.getContext();
                if (context instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
                }
                zZv.WV();
                return;
            } catch (Throwable th) {
                new Object[]{"WebView newengine pool is full，destroy webview ", th.getMessage()};
                return;
            }
        }
        if (this.Og.contains(zZv)) {
            return;
        }
        try {
            Context context2 = zZv.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context2.getApplicationContext());
                zZv.setRecycler(true);
                this.Og.add(zZv);
                new Object[]{"recycle WebView newengine，current available count: ", Integer.valueOf(ZZv())};
            }
        } catch (Throwable th2) {
            new Object[]{"recycle WebView newengine fail，current available count: ", Integer.valueOf(ZZv()), "exception is ", th2.getMessage()};
        }
    }

    public void Og(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        if (zZv == null) {
            return;
        }
        SD(zZv);
        zZv.b_("SDK_INJECT_GLOBAL");
        JG(zZv);
        pA(zZv);
    }

    public com.bytedance.sdk.component.Bzk.ZZv Og(Context context, String str) {
        if (KZx() <= 0) {
            return null;
        }
        if (com.bytedance.sdk.component.adexpress.ZZv.ML.pA(str) && KZx() <= 1) {
            new Object[]{"get WebView from pool; but ad type is does not meet the requirement ", Integer.valueOf(KZx())};
            return null;
        }
        com.bytedance.sdk.component.Bzk.ZZv zZvRemove = this.pA.remove(0);
        if (zZvRemove == null) {
            return null;
        }
        try {
            Context context2 = zZvRemove.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context.getApplicationContext());
                zZvRemove.setRecycler(false);
                new Object[]{"get WebView from pool; current available count: ", Integer.valueOf(KZx())};
            }
            return zZvRemove;
        } catch (Throwable unused) {
            new Object[]{"get WebView from pool exception; current available count: ", Integer.valueOf(KZx())};
            return null;
        }
    }

    public void KZx(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        if (zZv == null) {
            return;
        }
        SD(zZv);
        zZv.b_("SDK_INJECT_GLOBAL");
        JG(zZv);
        ZZv(zZv);
    }

    public void ZZv(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        if (zZv == null) {
            return;
        }
        if (this.pA.size() >= JG) {
            try {
                Context context = zZv.getContext();
                if (context instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
                }
                zZv.WV();
                return;
            } catch (Throwable th) {
                new Object[]{"WebView pool is full，destroy webview ", th.getMessage()};
                return;
            }
        }
        if (this.pA.contains(zZv)) {
            return;
        }
        try {
            Context context2 = zZv.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context2.getApplicationContext());
                zZv.setRecycler(true);
                this.pA.add(zZv);
                new Object[]{"recycle WebView，current available count: ", Integer.valueOf(KZx())};
            }
        } catch (Throwable th2) {
            new Object[]{"recycle WebView fail，current available count: ", Integer.valueOf(KZx()), "exception is ", th2.getMessage()};
        }
    }

    public boolean ML(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        if (zZv == null) {
            return false;
        }
        try {
            Context context = zZv.getContext();
            if (context instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
            }
            zZv.WV();
            return true;
        } catch (Throwable th) {
            new Object[]{"WebView abandon failed ", th.getMessage()};
            return true;
        }
    }

    public void Og() {
        for (com.bytedance.sdk.component.Bzk.ZZv zZv : this.pA) {
            if (zZv != null) {
                try {
                    Context context = zZv.getContext();
                    if (context instanceof MutableContextWrapper) {
                        ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
                    }
                    zZv.WV();
                } catch (Throwable th) {
                    new Object[]{"WebView clear failed ", th.getMessage()};
                }
            }
        }
        this.pA.clear();
        for (com.bytedance.sdk.component.Bzk.ZZv zZv2 : this.Og) {
            if (zZv2 != null) {
                try {
                    Context context2 = zZv2.getContext();
                    if (context2 instanceof MutableContextWrapper) {
                        ((MutableContextWrapper) context2).setBaseContext(context2.getApplicationContext());
                    }
                    zZv2.WV();
                } catch (Throwable th2) {
                    new Object[]{"WebView newengine clear failed ", th2.getMessage()};
                }
            }
        }
        this.Og.clear();
    }

    public int KZx() {
        return this.pA.size();
    }

    public int ZZv() {
        return this.Og.size();
    }

    private void SD(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        try {
            zZv.removeAllViews();
            zZv.KZx();
            zZv.setWebChromeClient(null);
            zZv.setWebViewClient(null);
            zZv.setDownloadListener(null);
            zZv.setJavaScriptEnabled(true);
            zZv.setCacheMode(-1);
            zZv.setSupportZoom(false);
            zZv.setUseWideViewPort(true);
            zZv.setJavaScriptCanOpenWindowsAutomatically(true);
            zZv.setDomStorageEnabled(true);
            zZv.setBuiltInZoomControls(false);
            zZv.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            zZv.setLoadWithOverviewMode(false);
            zZv.setDefaultTextEncodingName("UTF-8");
            zZv.setDefaultFontSize(16);
        } catch (Throwable unused) {
        }
    }

    public void pA(com.bytedance.sdk.component.Bzk.ZZv zZv, Og og) {
        if (zZv == null || og == null) {
            return;
        }
        KZx kZx = this.KZx.get(Integer.valueOf(zZv.hashCode()));
        if (kZx != null) {
            kZx.pA(og);
        } else {
            kZx = new KZx(og);
            this.KZx.put(Integer.valueOf(zZv.hashCode()), kZx);
        }
        zZv.pA(kZx, "SDK_INJECT_GLOBAL");
    }

    public void JG(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        if (zZv == null) {
            return;
        }
        KZx kZx = this.KZx.get(Integer.valueOf(zZv.hashCode()));
        if (kZx != null) {
            kZx.pA(null);
        }
        zZv.b_("SDK_INJECT_GLOBAL");
    }

    public void pA(WebView webView, du duVar, String str) {
        if (webView == null || duVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        ZZv zZv = this.ZZv.get(Integer.valueOf(webView.hashCode()));
        if (zZv != null) {
            zZv.pA(duVar);
        } else {
            zZv = new ZZv(duVar);
            this.ZZv.put(Integer.valueOf(webView.hashCode()), zZv);
        }
        PangleNetworkBridge.onAddedJavascriptInterface(webView, zZv, str);
    }

    public void pA(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        ZZv zZv = this.ZZv.get(Integer.valueOf(webView.hashCode()));
        if (zZv != null) {
            zZv.pA(null);
        }
        webView.removeJavascriptInterface(str);
    }

    public void pA(int i) {
        synchronized (ML) {
            JG = i;
        }
    }

    public void Og(int i) {
        synchronized (ML) {
            omh = i;
        }
    }
}
