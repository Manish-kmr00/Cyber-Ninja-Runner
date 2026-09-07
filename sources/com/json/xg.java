package com.json;

import android.webkit.JavascriptInterface;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes9.dex */
public class xg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ah f4588a;

    xg(ah ahVar) {
        this.f4588a = ahVar;
    }

    @JavascriptInterface
    public void receiveMessageFromExternal(String str) {
        Logger.d("IronSource|SafeDK: Execution> Lcom/ironsource/xg;->receiveMessageFromExternal(Ljava/lang/String;)V");
        CreativeInfoManager.onReceiveMessageFromExternal(h.f, this, str);
        safedk_xg_receiveMessageFromExternal_04a8197f17101df4951df92a29817078(str);
    }

    @JavascriptInterface
    public void safedk_xg_receiveMessageFromExternal_04a8197f17101df4951df92a29817078(String p0) {
        this.f4588a.handleMessageFromAd(p0);
    }
}
