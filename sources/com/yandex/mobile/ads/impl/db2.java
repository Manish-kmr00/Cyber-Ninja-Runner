package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class db2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<rb2<gb1>> f8677a;
    private final sf2 b;
    private final uj0 c;

    public db2(List<rb2<gb1>> videoAdsInfo, sf2 sf2Var, uj0 uj0Var) {
        Intrinsics.checkNotNullParameter(videoAdsInfo, "videoAdsInfo");
        this.f8677a = videoAdsInfo;
        this.b = sf2Var;
        this.c = uj0Var;
    }

    public static db2 a(db2 db2Var, List videoAdsInfo) {
        sf2 sf2Var = db2Var.b;
        uj0 uj0Var = db2Var.c;
        db2Var.getClass();
        Intrinsics.checkNotNullParameter(videoAdsInfo, "videoAdsInfo");
        return new db2(videoAdsInfo, sf2Var, uj0Var);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof db2)) {
            return false;
        }
        db2 db2Var = (db2) obj;
        return Intrinsics.areEqual(this.f8677a, db2Var.f8677a) && Intrinsics.areEqual(this.b, db2Var.b) && Intrinsics.areEqual(this.c, db2Var.c);
    }

    public final int hashCode() {
        int iHashCode = this.f8677a.hashCode() * 31;
        sf2 sf2Var = this.b;
        int iHashCode2 = (iHashCode + (sf2Var == null ? 0 : sf2Var.hashCode())) * 31;
        uj0 uj0Var = this.c;
        return iHashCode2 + (uj0Var != null ? uj0Var.hashCode() : 0);
    }

    public final String toString() {
        return "Video(videoAdsInfo=" + this.f8677a + ", videoSettings=" + this.b + ", preview=" + this.c + ")";
    }

    public final List<rb2<gb1>> c() {
        return this.f8677a;
    }

    public final sf2 d() {
        return this.b;
    }

    public final uj0 a() {
        return this.c;
    }

    public final rb2<gb1> b() {
        return (rb2) CollectionsKt.first((List) this.f8677a);
    }
}
