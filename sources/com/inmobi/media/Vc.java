package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class Vc extends Tc {
    public final C3313b7 e;
    public Ba f;
    public final L4 g;
    public final String h;
    public boolean i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Vc(C3313b7 mNativeAdContainer, Ba ba, L4 l4) {
        super(mNativeAdContainer);
        Intrinsics.checkNotNullParameter(mNativeAdContainer, "mNativeAdContainer");
        this.e = mNativeAdContainer;
        this.f = ba;
        this.g = l4;
        this.h = "InMobi";
    }

    @Override // com.inmobi.media.Tc
    public final void a(byte b) {
    }

    @Override // com.inmobi.media.Tc
    public final void a(View childView, FriendlyObstructionPurpose obstructionCode) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
    }

    @Override // com.inmobi.media.Tc
    public final void a(HashMap map) {
    }

    @Override // com.inmobi.media.Tc
    public final void e() {
    }

    @Override // com.inmobi.media.Tc
    public final void a(Context context, byte b) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.inmobi.media.Tc
    public final void a(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
    }

    @Override // com.inmobi.media.Tc
    public final View a(View view, ViewGroup parent, boolean z) {
        Context contextJ;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.i || (contextJ = this.e.j()) == null) {
            return null;
        }
        AdConfig adConfig = this.d;
        C3313b7 c3313b7 = this.e;
        C3625x7 c3625x7 = c3313b7.b;
        Intrinsics.checkNotNull(c3625x7, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeDataModel");
        this.b = new F7(contextJ, adConfig, c3313b7, c3625x7, this.g);
        L4 l4 = this.g;
        if (l4 != null) {
            ((M4) l4).b(this.h, "Ad markup loaded into the container will be inflated into a View.");
        }
        F7 f7 = this.b;
        this.c = new WeakReference(f7 != null ? f7.a(view, parent, z, this.f) : null);
        C3313b7 c3313b8 = this.e;
        c3313b8.getClass();
        U3.a(new R6(c3313b8, c3313b8), "EndCardBuilderTask");
        return b();
    }

    @Override // com.inmobi.media.Tc
    public final void a() {
        if (this.i) {
            return;
        }
        this.i = true;
        F7 f7 = this.b;
        if (f7 != null) {
            L7 l7 = f7.e;
            l7.n = true;
            l7.i.clear();
            l7.p = null;
            T7 t7 = l7.j;
            if (t7 != null) {
                t7.destroy();
            }
            l7.j = null;
            if (!f7.f3070a) {
                f7.f3070a = true;
            }
        }
        this.b = null;
        Ba ba = this.f;
        if (ba != null) {
            ba.b();
        }
        this.f = null;
        super.a();
    }
}
