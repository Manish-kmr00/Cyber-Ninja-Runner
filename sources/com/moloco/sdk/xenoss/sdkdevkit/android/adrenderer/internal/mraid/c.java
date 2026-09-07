package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i f6628a;

    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i a() {
        return this.f6628a;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i b() {
        return this.f6628a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && Intrinsics.areEqual(this.f6628a, ((c) obj).f6628a);
    }

    public int hashCode() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i iVar = this.f6628a;
        if (iVar == null) {
            return 0;
        }
        return iVar.hashCode();
    }

    public String toString() {
        return "MraidAdData(dec=" + this.f6628a + ')';
    }

    public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i iVar) {
        this.f6628a = iVar;
    }

    public final c a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i iVar) {
        return new c(iVar);
    }

    public static /* synthetic */ c a(c cVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i iVar, int i, Object obj) {
        if ((i & 1) != 0) {
            iVar = cVar.f6628a;
        }
        return cVar.a(iVar);
    }

    public /* synthetic */ c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i iVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : iVar);
    }
}
