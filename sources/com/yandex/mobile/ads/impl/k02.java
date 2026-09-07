package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9368a;
    private final String b;
    private final String c;
    private final String d;
    private final ti e;
    private final c02 f;
    private final List<c02> g;

    public k02() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k02)) {
            return false;
        }
        k02 k02Var = (k02) obj;
        return Intrinsics.areEqual(this.f9368a, k02Var.f9368a) && Intrinsics.areEqual(this.b, k02Var.b) && Intrinsics.areEqual(this.c, k02Var.c) && Intrinsics.areEqual(this.d, k02Var.d) && Intrinsics.areEqual(this.e, k02Var.e) && Intrinsics.areEqual(this.f, k02Var.f) && Intrinsics.areEqual(this.g, k02Var.g);
    }

    public final int hashCode() {
        String str = this.f9368a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        ti tiVar = this.e;
        int iHashCode5 = (iHashCode4 + (tiVar == null ? 0 : tiVar.hashCode())) * 31;
        c02 c02Var = this.f;
        int iHashCode6 = (iHashCode5 + (c02Var == null ? 0 : c02Var.hashCode())) * 31;
        List<c02> list = this.g;
        return iHashCode6 + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "SmartCenterSettings(colorWizButton=" + this.f9368a + ", colorWizButtonText=" + this.b + ", colorWizBack=" + this.c + ", colorWizBackRight=" + this.d + ", backgroundColors=" + this.e + ", smartCenter=" + this.f + ", smartCenters=" + this.g + ")";
    }

    public /* synthetic */ k02(int i) {
        this(null, null, null, null, null, null, null);
    }

    public k02(String str, String str2, String str3, String str4, ti tiVar, c02 c02Var, List<c02> list) {
        this.f9368a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = tiVar;
        this.f = c02Var;
        this.g = list;
    }

    public final ti a() {
        return this.e;
    }

    public final c02 b() {
        return this.f;
    }

    public final List<c02> c() {
        return this.g;
    }
}
