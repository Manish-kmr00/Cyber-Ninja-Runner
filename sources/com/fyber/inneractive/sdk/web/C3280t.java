package com.fyber.inneractive.sdk.web;

import android.window.OnBackInvokedCallback;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.web.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3280t implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I f2422a;

    public C3280t(I i) {
        this.f2422a = i;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        I i = this.f2422a;
        if (i.p()) {
            IAlog.e("back button pressed while ad is expanded, ad will be collapsed.", new Object[0]);
            i.o();
        }
    }
}
