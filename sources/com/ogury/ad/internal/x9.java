package com.ogury.ad.internal;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class x9 implements l3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w9 f7443a;

    public x9(w9 w9Var) {
        this.f7443a = w9Var;
    }

    @Override // com.ogury.ad.internal.l3
    public final void a(c ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.f7443a.k = ad;
    }

    @Override // com.ogury.ad.internal.l3
    public final void b(c ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        l7 l7Var = this.f7443a.m;
        if (l7Var != null) {
            l7Var.a(ad);
        }
        w9 w9Var = this.f7443a;
        int i = w9Var.f;
        int i2 = w9Var.g;
        if (i + i2 == w9Var.e) {
            w9Var.g = i2 + 1;
            w9Var.f = i - 1;
            return;
        }
        w9Var.g = i2 + 1;
        o3 o3Var = w9Var.j;
        if (o3Var != null) {
            o3Var.a();
        }
        w9 w9Var2 = this.f7443a;
        int i3 = w9Var2.f;
        if (w9Var2.g + i3 != w9Var2.e || w9Var2.h) {
            return;
        }
        if (i3 <= 0) {
            w9Var2.a(ad, l7.b.UNLOAD, (String) null);
            return;
        }
        w9Var2.b.clear();
        w9Var2.i.removeCallbacksAndMessages(null);
        l7 l7Var2 = w9Var2.m;
        if (l7Var2 != null) {
            l7Var2.b(ad);
        }
    }

    @Override // com.ogury.ad.internal.l3
    public final void c(c ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        w9 w9Var = this.f7443a;
        int i = w9Var.f;
        if (w9Var.g + i == w9Var.e) {
            return;
        }
        w9Var.f = i + 1;
        o3 o3Var = w9Var.j;
        if (o3Var != null) {
            o3Var.a();
        }
        w9 w9Var2 = this.f7443a;
        int i2 = w9Var2.f;
        if (w9Var2.g + i2 != w9Var2.e || w9Var2.h) {
            return;
        }
        if (i2 <= 0) {
            w9Var2.a(ad, l7.b.OTHER, w9Var2.n);
            return;
        }
        w9Var2.b.clear();
        w9Var2.i.removeCallbacksAndMessages(null);
        l7 l7Var = w9Var2.m;
        if (l7Var != null) {
            l7Var.b(ad);
        }
    }

    @Override // com.ogury.ad.internal.l3
    public final void a(c ad, String errorMessage, boolean z) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        if (!z) {
            w9 w9Var = this.f7443a;
            l7.b bVar = l7.b.TIMEOUT;
            w9Var.a(ad, l7.b.HTML_EMBEDDING_ERROR, errorMessage);
        } else {
            w9 w9Var2 = this.f7443a;
            w9Var2.a(w9Var2.a() + " -- " + errorMessage);
        }
    }

    @Override // com.ogury.ad.internal.l3
    public final void a(w9.a loadPhase) {
        Intrinsics.checkNotNullParameter(loadPhase, "loadPhase");
        this.f7443a.d.add(loadPhase);
    }

    @Override // com.ogury.ad.internal.l3
    public final void a(c ad, boolean z, Uri failingUri) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(failingUri, "failingUri");
        u3 u3Var = u3.f7411a;
        String str = "onRenderProcessGone ------> " + ad.j() + " " + ad.i();
        u3Var.getClass();
        u3.a(str);
        if (ad.j() == ad.i()) {
            u3.a("Ad reload attempts exceeded ------> removing timeout handler");
        }
        w9.a(this.f7443a);
        this.f7443a.h = true;
        l7 l7VarB = this.f7443a.b();
        if (l7VarB != null) {
            l7VarB.a(ad, z, failingUri);
        }
    }
}
