package com.bytedance.sdk.component.adexpress.ML;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.pA.du;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes13.dex */
public class ZZv {
    private WeakReference<du> pA;

    public ZZv(du duVar) {
        this.pA = new WeakReference<>(duVar);
    }

    public void pA(du duVar) {
        this.pA = new WeakReference<>(duVar);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<du> weakReference = this.pA;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pA.get().invokeMethod(str);
    }
}
