package com.fyber.inneractive.sdk.activities;

import android.view.View;
import android.webkit.WebView;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInternalBrowserActivity f1613a;

    public j(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.f1613a = inneractiveInternalBrowserActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/activities/j;->onClick(Landroid/view/View;)V");
        CreativeInfoManager.onViewClicked(com.safedk.android.utils.h.p, view);
        safedk_j_onClick_de0d2565025937b8ee6b9157ff655a60(view);
    }

    public void safedk_j_onClick_de0d2565025937b8ee6b9157ff655a60(View p0) {
        WebView webView = this.f1613a.e;
        if (webView == null || !webView.canGoForward()) {
            return;
        }
        this.f1613a.e.goForward();
    }
}
