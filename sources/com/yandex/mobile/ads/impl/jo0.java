package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class jo0 implements kc2<do0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final et f9339a;
    private final long b;
    private final kz1 c;
    private final m10 d;
    private final qb2 e;
    private final bm0 f;

    public jo0(p2 adBreak, et adBreakPosition, long j, kz1 skipInfoParser, m10 disableSkipChecker, qb2 videoAdIdProvider, bm0 instreamAdInfoProvider) {
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(adBreakPosition, "adBreakPosition");
        Intrinsics.checkNotNullParameter(skipInfoParser, "skipInfoParser");
        Intrinsics.checkNotNullParameter(disableSkipChecker, "disableSkipChecker");
        Intrinsics.checkNotNullParameter(videoAdIdProvider, "videoAdIdProvider");
        Intrinsics.checkNotNullParameter(instreamAdInfoProvider, "instreamAdInfoProvider");
        this.f9339a = adBreakPosition;
        this.b = j;
        this.c = skipInfoParser;
        this.d = disableSkipChecker;
        this.e = videoAdIdProvider;
        this.f = instreamAdInfoProvider;
    }

    @Override // com.yandex.mobile.ads.impl.kc2
    public final do0 a(eb2 videoAd, ru creative, aw0 vastMediaFile, rc2 adPodInfo, String str, String str2, JSONObject jSONObject) {
        Object next;
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(creative, "creative");
        Intrinsics.checkNotNullParameter(vastMediaFile, "vastMediaFile");
        Intrinsics.checkNotNullParameter(adPodInfo, "adPodInfo");
        kz1 kz1Var = this.c;
        if (this.d.a()) {
            kz1Var = null;
        }
        gd2 gd2VarA = kz1Var != null ? kz1Var.a(creative) : null;
        un0 un0Var = new un0(this.f9339a, vastMediaFile.f(), vastMediaFile.h(), vastMediaFile.d(), vastMediaFile.e(), Integer.valueOf(vastMediaFile.b()), vastMediaFile.a());
        List<aw0> listG = creative.g();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listG, 10));
        for (aw0 aw0Var : listG) {
            arrayList.add(new un0(this.f9339a, aw0Var.f(), aw0Var.h(), aw0Var.d(), aw0Var.e(), Integer.valueOf(aw0Var.b()), aw0Var.a()));
        }
        long jD = creative.d();
        qb2 qb2Var = this.e;
        long j = this.b;
        qb2Var.getClass();
        String strA = qb2.a(j, adPodInfo, videoAd);
        this.f.getClass();
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(creative, "creative");
        Iterator<T> it = videoAd.l().a().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((r70) next).a(), "bannerId"));
        r70 r70Var = (r70) next;
        return new do0(strA, un0Var, arrayList, adPodInfo, gd2VarA, new zl0(videoAd.g(), creative.f(), r70Var != null ? r70Var.b() : null, str, str2), jSONObject, jD);
    }
}
