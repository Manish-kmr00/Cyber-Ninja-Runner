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
public final class Wc extends Tc {
    public final C3398h8 e;
    public final L4 f;
    public boolean g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Wc(C3398h8 mNativeVideoAdContainer, L4 l4) {
        super(mNativeVideoAdContainer);
        Intrinsics.checkNotNullParameter(mNativeVideoAdContainer, "mNativeVideoAdContainer");
        this.e = mNativeVideoAdContainer;
        this.f = l4;
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
        if (this.g || (contextJ = this.e.j()) == null) {
            return null;
        }
        AdConfig adConfig = this.d;
        C3398h8 c3398h8 = this.e;
        C3625x7 c3625x7 = c3398h8.b;
        Intrinsics.checkNotNull(c3625x7, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeDataModel");
        F7 f7 = new F7(contextJ, adConfig, c3398h8, c3625x7, this.f);
        this.b = f7;
        this.c = new WeakReference(f7.a(view, parent, false, null));
        C3398h8 c3398h9 = this.e;
        c3398h9.getClass();
        U3.a(new R6(c3398h9, c3398h9), "EndCardBuilderTask");
        return b();
    }

    @Override // com.inmobi.media.Tc
    public final void a() {
        if (this.g) {
            return;
        }
        this.g = true;
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
        super.a();
    }
}
