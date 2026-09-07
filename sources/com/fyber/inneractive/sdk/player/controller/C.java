package com.fyber.inneractive.sdk.player.controller;

import android.view.View;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes13.dex */
public final class C implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E f1950a;

    public C(E e) {
        this.f1950a = e;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/player/controller/C;->onClick(Landroid/view/View;)V");
        CreativeInfoManager.onViewClicked(com.safedk.android.utils.h.p, view);
        safedk_C_onClick_ad059ba5e60d791cfc950753b95a8f00(view);
    }

    public void safedk_C_onClick_ad059ba5e60d791cfc950753b95a8f00(View p0) {
        this.f1950a.b.dismiss();
        v vVar = this.f1950a.f1952a;
        vVar.b.d(vVar.f1967a);
    }
}
