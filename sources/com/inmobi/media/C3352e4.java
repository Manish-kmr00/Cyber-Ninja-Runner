package com.inmobi.media;

import android.view.View;

/* JADX INFO: renamed from: com.inmobi.media.e4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3352e4 implements InterfaceC3510p4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3380g4 f3299a;

    public C3352e4(C3380g4 c3380g4) {
        this.f3299a = c3380g4;
    }

    @Override // com.inmobi.media.InterfaceC3510p4
    public final void a(View view, Object obj) {
        if (view instanceof Ba) {
            L4 l4 = this.f3299a.f;
            if (l4 != null) {
                ((M4) l4).a("HtmlAdTracker", "fireImpression");
            }
            ((Ba) view).k();
        }
    }
}
