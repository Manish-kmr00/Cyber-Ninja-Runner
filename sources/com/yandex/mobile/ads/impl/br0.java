package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class br0<V extends ViewGroup> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8534a;
    private final Class<V> b;
    private final y00<V> c;
    private final z00 d;

    public br0(int i, yq designComponentBinder, z00 designConstraint) {
        Intrinsics.checkNotNullParameter(ExtendedNativeAdView.class, "layoutViewClass");
        Intrinsics.checkNotNullParameter(designComponentBinder, "designComponentBinder");
        Intrinsics.checkNotNullParameter(designConstraint, "designConstraint");
        this.f8534a = i;
        this.b = ExtendedNativeAdView.class;
        this.c = designComponentBinder;
        this.d = designConstraint;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof br0)) {
            return false;
        }
        br0 br0Var = (br0) obj;
        return this.f8534a == br0Var.f8534a && Intrinsics.areEqual(this.b, br0Var.b) && Intrinsics.areEqual(this.c, br0Var.c) && Intrinsics.areEqual(this.d, br0Var.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (Integer.hashCode(this.f8534a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "LayoutDesign(layoutId=" + this.f8534a + ", layoutViewClass=" + this.b + ", designComponentBinder=" + this.c + ", designConstraint=" + this.d + ")";
    }

    public final int c() {
        return this.f8534a;
    }

    public final Class<V> d() {
        return this.b;
    }

    public final y00<V> a() {
        return this.c;
    }

    public final z00 b() {
        return this.d;
    }
}
