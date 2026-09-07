package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class xe2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rb2<?> f10649a;
    private final kg2 b;

    public xe2(rb2<?> videoAdInfo, kg2 videoViewProvider) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        this.f10649a = videoAdInfo;
        this.b = videoViewProvider;
    }

    public final Map<String, Object> a() {
        ip1 ip1Var = new ip1(new LinkedHashMap(), 2);
        View view = this.b.getView();
        Integer numValueOf = view != null ? Integer.valueOf(view.getHeight()) : null;
        Integer numValueOf2 = view != null ? Integer.valueOf(view.getWidth()) : null;
        aw0 aw0VarC = this.f10649a.c();
        if (numValueOf == null || numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        ip1Var.b(numValueOf, "view_container_height");
        if (numValueOf2 == null || numValueOf2.intValue() <= 0) {
            numValueOf2 = null;
        }
        ip1Var.b(numValueOf2, "view_container_width");
        ip1Var.b(aw0VarC.d() > 0 ? Integer.valueOf(aw0VarC.d()) : null, "video_height");
        ip1Var.b(aw0VarC.h() > 0 ? Integer.valueOf(aw0VarC.h()) : null, "video_width");
        ip1Var.b(aw0VarC.c(), "video_codec");
        ip1Var.b(aw0VarC.e(), "video_mime_type");
        ip1Var.b(aw0VarC.g(), "video_vmaf");
        return MapsKt.mapOf(TuplesKt.to("video_playback_info", ip1Var.b()));
    }
}
