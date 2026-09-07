package com.fyber.inneractive.sdk.activities;

import com.fyber.inneractive.sdk.click.q;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements com.fyber.inneractive.sdk.click.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInternalBrowserActivity f1611a;

    public h(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.f1611a = inneractiveInternalBrowserActivity;
    }

    @Override // com.fyber.inneractive.sdk.click.o
    public final void a(com.fyber.inneractive.sdk.click.b bVar) {
        if (bVar.f1653a != q.FAILED) {
            InneractiveInternalBrowserActivity.a(this.f1611a, bVar);
            this.f1611a.finish();
        }
    }
}
