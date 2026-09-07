package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class do0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8717a;
    private final un0 b;
    private final List<un0> c;
    private final rc2 d;
    private final gd2 e;
    private final zl0 f;
    private final JSONObject g;
    private final long h;

    public do0(String videoAdId, un0 recommendedMediaFile, ArrayList mediaFiles, rc2 adPodInfo, gd2 gd2Var, zl0 adInfo, JSONObject jSONObject, long j) {
        Intrinsics.checkNotNullParameter(videoAdId, "videoAdId");
        Intrinsics.checkNotNullParameter(recommendedMediaFile, "recommendedMediaFile");
        Intrinsics.checkNotNullParameter(mediaFiles, "mediaFiles");
        Intrinsics.checkNotNullParameter(adPodInfo, "adPodInfo");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f8717a = videoAdId;
        this.b = recommendedMediaFile;
        this.c = mediaFiles;
        this.d = adPodInfo;
        this.e = gd2Var;
        this.f = adInfo;
        this.g = jSONObject;
        this.h = j;
    }

    public final un0 f() {
        return this.b;
    }

    public final List<un0> e() {
        return this.c;
    }

    public final rc2 b() {
        return this.d;
    }

    public final gd2 g() {
        return this.e;
    }

    public final zl0 a() {
        return this.f;
    }

    public final JSONObject d() {
        return this.g;
    }

    public final long c() {
        return this.h;
    }

    public final String toString() {
        return this.f8717a;
    }
}
