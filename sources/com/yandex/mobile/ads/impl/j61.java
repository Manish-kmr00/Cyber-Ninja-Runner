package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vd2 f9290a;
    private final k31 b;

    public /* synthetic */ j61() {
        this(new vd2(), new k31());
    }

    public j61(vd2 aspectRatioProvider, k31 multiBannerRatioProvider) {
        Intrinsics.checkNotNullParameter(aspectRatioProvider, "aspectRatioProvider");
        Intrinsics.checkNotNullParameter(multiBannerRatioProvider, "multiBannerRatioProvider");
        this.f9290a = aspectRatioProvider;
        this.b = multiBannerRatioProvider;
    }

    public final ut a(ax0 ax0Var) {
        ut utVar;
        if (ax0Var != null) {
            db2 db2VarC = ax0Var.c();
            List<uj0> listA = ax0Var.a();
            su0 su0VarB = ax0Var.b();
            if (db2VarC != null) {
                vd2 vd2Var = this.f9290a;
                rb2<gb1> videoAdInfo = db2VarC.b();
                vd2Var.getClass();
                Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
                gb1 gb1VarD = videoAdInfo.d();
                return new ut(gb1VarD.getAdHeight() != 0 ? gb1VarD.getAdWidth() / gb1VarD.getAdHeight() : 1.7777778f);
            }
            if (listA != null && listA.size() > 1) {
                this.b.getClass();
                utVar = new ut((float) k31.a(listA));
            } else if (su0VarB != null) {
                utVar = new ut(su0VarB.a());
            }
            return utVar;
        }
        return null;
    }
}
