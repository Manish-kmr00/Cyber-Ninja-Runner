package com.bytedance.sdk.component.adexpress.ML;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes8.dex */
public class KZx {
    private WeakReference<Og> pA;

    public KZx(Og og) {
        this.pA = new WeakReference<>(og);
    }

    public void pA(Og og) {
        this.pA = new WeakReference<>(og);
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<Og> weakReference = this.pA;
        if (weakReference != null && weakReference.get() != null) {
            return this.pA.get().adInfo();
        }
        return "";
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<Og> weakReference = this.pA;
        if (weakReference != null && weakReference.get() != null) {
            return this.pA.get().appInfo();
        }
        return "";
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<Og> weakReference = this.pA;
        if (weakReference != null && weakReference.get() != null) {
            return this.pA.get().getTemplateInfo();
        }
        return "";
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<Og> weakReference = this.pA;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pA.get().renderDidFinish(str);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<Og> weakReference = this.pA;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pA.get();
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<Og> weakReference = this.pA;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pA.get().muteVideo(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<Og> weakReference = this.pA;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pA.get().dynamicTrack(str);
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<Og> weakReference = this.pA;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pA.get().changeVideoState(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<Og> weakReference = this.pA;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pA.get().clickEvent(str);
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<Og> weakReference = this.pA;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pA.get().skipVideo();
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<Og> weakReference = this.pA;
        if (weakReference != null && weakReference.get() != null) {
            return this.pA.get().getCurrentVideoState();
        }
        return "";
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<Og> weakReference = this.pA;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pA.get().initRenderFinish();
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<Og> weakReference = this.pA;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pA.get().pA(str);
    }

    @JavascriptInterface
    public void chooseAdResult(String str) {
        WeakReference<Og> weakReference = this.pA;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pA.get().chooseAdResult(str);
    }

    @JavascriptInterface
    public String getData(String str) {
        WeakReference<Og> weakReference = this.pA;
        if (weakReference != null && weakReference.get() != null) {
            return this.pA.get().getData(str);
        }
        return "";
    }
}
