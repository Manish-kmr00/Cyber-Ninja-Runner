package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.instream.InstreamAdBreakType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class to0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final id2 f10322a;
    private final dt b;
    private final rb2<do0> c;
    private final xn0 d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ to0(id2 id2Var, dt dtVar, rb2 rb2Var) {
        this(id2Var, dtVar, rb2Var, xn0.a.a());
        int i = xn0.g;
    }

    public final boolean a() {
        hd2 hd2Var;
        rc2 rc2VarB = this.c.d().b();
        if (!this.d.d() || rc2VarB.a() <= 1) {
            String strE = this.b.e();
            int iHashCode = strE.hashCode();
            if (iHashCode == -1183812830 ? strE.equals(InstreamAdBreakType.INROLL) : iHashCode == 830323571 ? strE.equals(InstreamAdBreakType.PAUSEROLL) : iHashCode == 1055572677 && strE.equals(InstreamAdBreakType.MIDROLL)) {
                hd2Var = rc2VarB.a() == 1 ? hd2.e : hd2.c;
            } else {
                hd2Var = hd2.c;
            }
        } else {
            hd2Var = hd2.e;
        }
        return this.f10322a.a(hd2Var);
    }

    public to0(id2 statusController, dt adBreak, rb2<do0> videoAdInfo, xn0 instreamSettings) {
        Intrinsics.checkNotNullParameter(statusController, "statusController");
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(instreamSettings, "instreamSettings");
        this.f10322a = statusController;
        this.b = adBreak;
        this.c = videoAdInfo;
        this.d = instreamSettings;
    }
}
