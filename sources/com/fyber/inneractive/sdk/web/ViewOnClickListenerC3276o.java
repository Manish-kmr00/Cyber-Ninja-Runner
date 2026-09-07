package com.fyber.inneractive.sdk.web;

import android.view.View;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.web.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class ViewOnClickListenerC3276o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I f2416a;

    public ViewOnClickListenerC3276o(I i) {
        this.f2416a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/web/o;->onClick(Landroid/view/View;)V");
        CreativeInfoManager.onViewClicked(com.safedk.android.utils.h.p, view);
        safedk_o_onClick_c06d7a4dcd7b0368031f607e07fcfe21(view);
    }

    public void safedk_o_onClick_c06d7a4dcd7b0368031f607e07fcfe21(View p0) {
        this.f2416a.o();
    }
}
