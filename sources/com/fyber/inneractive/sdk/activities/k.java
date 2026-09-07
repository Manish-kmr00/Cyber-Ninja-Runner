package com.fyber.inneractive.sdk.activities;

import android.view.View;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.util.IAlog;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInternalBrowserActivity f1614a;

    public k(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.f1614a = inneractiveInternalBrowserActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/activities/k;->onClick(Landroid/view/View;)V");
        CreativeInfoManager.onViewClicked(com.safedk.android.utils.h.p, view);
        safedk_k_onClick_ba5f94c7940c4319420d8dfee82a8dac(view);
    }

    public void safedk_k_onClick_ba5f94c7940c4319420d8dfee82a8dac(View p0) {
        WebView webView = this.f1614a.e;
        if (webView != null) {
            webView.reload();
            int i = IAlog.f2345a;
            IAlog.d("%s %s", "AD_INTERNAL_BROWSER_REFRESH", this.f1614a.e.getUrl());
        }
    }
}
