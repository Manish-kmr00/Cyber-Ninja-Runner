package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class jl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o41 f9328a;
    private final ja1 b;
    private final bc1 c;
    private final zb1 d;
    private final o51 e;
    private final n81 f;
    private final sa g;
    private final uu1 h;
    private final c41 i;
    private final s9 j;

    public jl(o41 nativeAdBlock, b71 nativeValidator, bc1 nativeVisualBlock, zb1 nativeViewRenderer, o51 nativeAdFactoriesProvider, n81 forceImpressionConfigurator, i71 adViewRenderingValidator, uu1 sdkEnvironmentModule, c41 c41Var, s9 adStructureType) {
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        Intrinsics.checkNotNullParameter(nativeValidator, "nativeValidator");
        Intrinsics.checkNotNullParameter(nativeVisualBlock, "nativeVisualBlock");
        Intrinsics.checkNotNullParameter(nativeViewRenderer, "nativeViewRenderer");
        Intrinsics.checkNotNullParameter(nativeAdFactoriesProvider, "nativeAdFactoriesProvider");
        Intrinsics.checkNotNullParameter(forceImpressionConfigurator, "forceImpressionConfigurator");
        Intrinsics.checkNotNullParameter(adViewRenderingValidator, "adViewRenderingValidator");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adStructureType, "adStructureType");
        this.f9328a = nativeAdBlock;
        this.b = nativeValidator;
        this.c = nativeVisualBlock;
        this.d = nativeViewRenderer;
        this.e = nativeAdFactoriesProvider;
        this.f = forceImpressionConfigurator;
        this.g = adViewRenderingValidator;
        this.h = sdkEnvironmentModule;
        this.i = c41Var;
        this.j = adStructureType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jl)) {
            return false;
        }
        jl jlVar = (jl) obj;
        return Intrinsics.areEqual(this.f9328a, jlVar.f9328a) && Intrinsics.areEqual(this.b, jlVar.b) && Intrinsics.areEqual(this.c, jlVar.c) && Intrinsics.areEqual(this.d, jlVar.d) && Intrinsics.areEqual(this.e, jlVar.e) && Intrinsics.areEqual(this.f, jlVar.f) && Intrinsics.areEqual(this.g, jlVar.g) && Intrinsics.areEqual(this.h, jlVar.h) && Intrinsics.areEqual(this.i, jlVar.i) && this.j == jlVar.j;
    }

    public final int hashCode() {
        int iHashCode = (this.h.hashCode() + ((this.g.hashCode() + ((this.f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.f9328a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        c41 c41Var = this.i;
        return this.j.hashCode() + ((iHashCode + (c41Var == null ? 0 : c41Var.hashCode())) * 31);
    }

    public final String toString() {
        return "BinderConfiguration(nativeAdBlock=" + this.f9328a + ", nativeValidator=" + this.b + ", nativeVisualBlock=" + this.c + ", nativeViewRenderer=" + this.d + ", nativeAdFactoriesProvider=" + this.e + ", forceImpressionConfigurator=" + this.f + ", adViewRenderingValidator=" + this.g + ", sdkEnvironmentModule=" + this.h + ", nativeData=" + this.i + ", adStructureType=" + this.j + ")";
    }

    public final o41 d() {
        return this.f9328a;
    }

    public final ja1 g() {
        return this.b;
    }

    public final bc1 i() {
        return this.c;
    }

    public final zb1 h() {
        return this.d;
    }

    public final o51 e() {
        return this.e;
    }

    public final n81 c() {
        return this.f;
    }

    public final sa b() {
        return this.g;
    }

    public final uu1 j() {
        return this.h;
    }

    public final c41 f() {
        return this.i;
    }

    public final s9 a() {
        return this.j;
    }
}
