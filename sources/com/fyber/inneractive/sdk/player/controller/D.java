package com.fyber.inneractive.sdk.player.controller;

import android.view.View;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes13.dex */
public final class D implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E f1951a;

    public D(E e) {
        this.f1951a = e;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/player/controller/D;->onClick(Landroid/view/View;)V");
        CreativeInfoManager.onViewClicked(com.safedk.android.utils.h.p, view);
        safedk_D_onClick_8087ec01c0fb9c9952508d138969a3a1(view);
    }

    public void safedk_D_onClick_8087ec01c0fb9c9952508d138969a3a1(View p0) {
        this.f1951a.b.dismiss();
        this.f1951a.f1952a.getClass();
    }
}
