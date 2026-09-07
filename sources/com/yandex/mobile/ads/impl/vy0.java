package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import com.monetization.ads.mediation.rewarded.MediatedRewardedAdapter;
import com.monetization.ads.mediation.rewarded.MediatedRewardedAdapterListener;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class vy0 implements zc0<ur1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gd0<ur1> f10518a;
    private final nx0<MediatedRewardedAdapter, MediatedRewardedAdapterListener> b;
    private final xy0 c;
    private final cs1 d;
    private final cy0 e;

    public vy0(gd0<ur1> loadController, o8<String> adResponse, dz0 mediationData) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(mediationData, "mediationData");
        this.f10518a = loadController;
        o3 o3VarF = loadController.f();
        hy0 hy0Var = new hy0(o3VarF);
        cy0 cy0Var = new cy0(o3VarF, adResponse);
        this.e = cy0Var;
        wy0 wy0Var = new wy0(new vx0(mediationData.c(), hy0Var, cy0Var));
        g5 g5VarI = loadController.i();
        eg1 eg1Var = new eg1(loadController, mediationData, g5VarI);
        xy0 xy0Var = new xy0();
        this.c = xy0Var;
        nx0<MediatedRewardedAdapter, MediatedRewardedAdapterListener> nx0Var = new nx0<>(o3VarF, g5VarI, xy0Var, cy0Var, wy0Var, eg1Var);
        this.b = nx0Var;
        this.d = new cs1(loadController, nx0Var);
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10518a.j().d();
        this.b.a(context);
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final String getAdInfo() {
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final void a(Context context, o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.b.a(context, this.d);
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final Object a(wd0 wd0Var, Activity activity) {
        Object objM7904constructorimpl;
        mx0<T> mx0VarA;
        ur1 contentController = (ur1) wd0Var;
        Intrinsics.checkNotNullParameter(contentController, "contentController");
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            Result.Companion companion = Result.INSTANCE;
            MediatedRewardedAdapter mediatedRewardedAdapterA = this.c.a();
            if (mediatedRewardedAdapterA != null) {
                this.d.a(contentController);
                this.f10518a.j().c();
                mediatedRewardedAdapterA.showRewardedAd(activity);
            }
            objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null && (mx0VarA = this.b.a()) != 0) {
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            op0.c(new Object[0]);
            this.e.a(applicationContext, mx0VarA.c(), MapsKt.mapOf(TuplesKt.to("reason", MapsKt.mapOf(TuplesKt.to("exception_in_adapter", thM7907exceptionOrNullimpl.toString())))), mx0VarA.a().b().getNetworkName());
        }
        return objM7904constructorimpl;
    }
}
