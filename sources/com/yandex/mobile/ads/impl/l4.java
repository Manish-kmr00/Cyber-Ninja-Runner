package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9475a;
    private final dt b;
    private final w2 c;
    private final pj0 d;
    private final gm0 e;
    private final zm0 f;
    private final hc2<do0> g;
    private final x2 h;
    private final gg2 i;

    public final k4 a(rb2<do0> videoAdInfo) {
        sc2 sc2Var;
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        x2 x2Var = this.h;
        w2 adBreakPosition = this.c;
        x2Var.getClass();
        Intrinsics.checkNotNullParameter(adBreakPosition, "adBreakPosition");
        int iOrdinal = adBreakPosition.ordinal();
        if (iOrdinal == 0) {
            sc2Var = sc2.b;
        } else if (iOrdinal == 1) {
            sc2Var = sc2.c;
        } else if (iOrdinal == 2) {
            sc2Var = sc2.d;
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            sc2Var = sc2.e;
        }
        fg2 fg2VarA = this.i.a(this.f9475a, videoAdInfo, sc2Var);
        id2 id2Var = new id2();
        Context context = this.f9475a;
        uu1 uu1VarD = this.b.d();
        gm0 gm0Var = this.e;
        zm0 zm0Var = this.f;
        dt dtVar = this.b;
        pj0 pj0Var = this.d;
        hc2<do0> hc2Var = this.g;
        o3 o3Var = new o3(qs.h, uu1VarD);
        do0 do0VarD = videoAdInfo.d();
        zn0 zn0Var = new zn0(do0VarD, gm0Var);
        so0 so0Var = new so0(zm0Var);
        ro0 ro0Var = new ro0(dtVar, videoAdInfo, id2Var, so0Var, new lg2(so0Var), new to0(id2Var, dtVar, videoAdInfo));
        vc2 vc2Var = new vc2();
        bo0 bo0Var = new bo0(hc2Var);
        n92 n92Var = new n92(context, o3Var, zn0Var, so0Var, videoAdInfo, ro0Var, id2Var, fg2VarA, vc2Var, bo0Var, null);
        hj0 hj0Var = new hj0(context);
        g5 g5Var = new g5();
        return new k4(videoAdInfo, new ao0(context, uu1VarD, gm0Var, zm0Var, dtVar, videoAdInfo, id2Var, fg2VarA, pj0Var, hc2Var, o3Var, do0VarD, zn0Var, so0Var, ro0Var, vc2Var, bo0Var, n92Var, hj0Var, g5Var, new qn0(hj0Var, g5Var), new om0(do0VarD, so0Var, zn0Var, zm0Var, id2Var), new am0(do0VarD, new ub2(do0VarD)), new ul0(dtVar)), this.d, id2Var, fg2VarA);
    }

    public /* synthetic */ l4(Context context, dt dtVar, w2 w2Var, pj0 pj0Var, gm0 gm0Var, zm0 zm0Var, hc2 hc2Var) {
        this(context, dtVar, w2Var, pj0Var, gm0Var, zm0Var, hc2Var, new x2(), new gg2(dtVar.d().d()));
    }

    public l4(Context context, dt adBreak, w2 adBreakPosition, pj0 imageProvider, gm0 adPlayerController, zm0 adViewsHolderManager, hc2<do0> playbackEventsListener, x2 adBreakPositionConverter, gg2 videoTrackerCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(adBreakPosition, "adBreakPosition");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(adPlayerController, "adPlayerController");
        Intrinsics.checkNotNullParameter(adViewsHolderManager, "adViewsHolderManager");
        Intrinsics.checkNotNullParameter(playbackEventsListener, "playbackEventsListener");
        Intrinsics.checkNotNullParameter(adBreakPositionConverter, "adBreakPositionConverter");
        Intrinsics.checkNotNullParameter(videoTrackerCreator, "videoTrackerCreator");
        this.f9475a = context;
        this.b = adBreak;
        this.c = adBreakPosition;
        this.d = imageProvider;
        this.e = adPlayerController;
        this.f = adViewsHolderManager;
        this.g = playbackEventsListener;
        this.h = adBreakPositionConverter;
        this.i = videoTrackerCreator;
    }
}
