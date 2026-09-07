package com.inmobi.media;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: renamed from: com.inmobi.media.e8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3356e8 extends C3389h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3301a;
    public final String b;
    public final String c;
    public final ArrayList d;
    public final ArrayList e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3356e8(C3389h ad, JSONArray jSONArray, String videoUrl, String videoDuration, String str, ArrayList trackers, ArrayList companionAds) {
        super(ad, jSONArray);
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        Intrinsics.checkNotNullParameter(videoDuration, "videoDuration");
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        Intrinsics.checkNotNullParameter(companionAds, "companionAds");
        this.f3301a = videoUrl;
        this.b = videoDuration;
        this.c = str;
        this.d = trackers;
        this.e = companionAds;
    }
}
