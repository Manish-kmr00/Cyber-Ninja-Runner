package com.ogury.ad.internal;

import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ogury.ad.interstitial.ui.InterstitialActivity;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b2 implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f7266a;
    public final a3 b;
    public final a2 c;

    public b2(o adType) {
        InterstitialActivity.a interstitialShowCommand = InterstitialActivity.d;
        a2 expandCacheStore = a2.f7257a;
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(interstitialShowCommand, "interstitialShowCommand");
        Intrinsics.checkNotNullParameter(expandCacheStore, "expandCacheStore");
        this.f7266a = adType;
        this.b = interstitialShowCommand;
        this.c = expandCacheStore;
    }

    @Override // com.ogury.ad.internal.r
    public final void a(j4 adController, h adLayout) {
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(adController, "adController");
        ViewParent parent = adLayout.getParent();
        FrameLayout frameLayout = parent instanceof FrameLayout ? (FrameLayout) parent : null;
        if (frameLayout == null) {
            return;
        }
        adLayout.d();
        adController.a(3);
        adController.h();
        adLayout.setupDrag(false);
        if (this.f7266a.c()) {
            adLayout.setLeft(0);
            adLayout.setTop(0);
        }
        a2 a2Var = this.c;
        z1 item = new z1(this.f7266a, frameLayout, adLayout, adController);
        a2Var.getClass();
        Intrinsics.checkNotNullParameter(item, "item");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        a2.b.put(string, item);
        c cVar = adController.v;
        if (cVar == null) {
            return;
        }
        this.b.a(adController.f7328a, string, cVar, adController.w);
    }
}
