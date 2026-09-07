package com.monetization.ads.mediation.interstitial;

import android.app.Activity;
import android.content.Context;
import com.yandex.mobile.ads.impl.cy0;
import com.yandex.mobile.ads.impl.dz0;
import com.yandex.mobile.ads.impl.eg1;
import com.yandex.mobile.ads.impl.g5;
import com.yandex.mobile.ads.impl.gd0;
import com.yandex.mobile.ads.impl.hy0;
import com.yandex.mobile.ads.impl.ly0;
import com.yandex.mobile.ads.impl.mx0;
import com.yandex.mobile.ads.impl.nx0;
import com.yandex.mobile.ads.impl.o3;
import com.yandex.mobile.ads.impl.o8;
import com.yandex.mobile.ads.impl.op0;
import com.yandex.mobile.ads.impl.vx0;
import com.yandex.mobile.ads.impl.wd0;
import com.yandex.mobile.ads.impl.zc0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T extends wd0<T>> implements zc0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gd0<T> f7233a;
    private final nx0<MediatedInterstitialAdapter, MediatedInterstitialAdapter.MediatedInterstitialAdapterListener> b;
    private final b c;
    private final a<T> d;
    private final cy0 e;

    public c(gd0<T> loadController, o8<String> adResponse, dz0 mediationData) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(mediationData, "mediationData");
        this.f7233a = loadController;
        o3 o3VarF = loadController.f();
        hy0 hy0Var = new hy0(o3VarF);
        cy0 cy0Var = new cy0(o3VarF, adResponse);
        this.e = cy0Var;
        ly0 ly0Var = new ly0(new vx0(mediationData.c(), hy0Var, cy0Var));
        g5 g5VarI = loadController.i();
        eg1 eg1Var = new eg1(loadController, mediationData, g5VarI);
        b bVar = new b();
        this.c = bVar;
        nx0<MediatedInterstitialAdapter, MediatedInterstitialAdapter.MediatedInterstitialAdapterListener> nx0Var = new nx0<>(o3VarF, g5VarI, bVar, cy0Var, ly0Var, eg1Var);
        this.b = nx0Var;
        this.d = new a<>(loadController, nx0Var);
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final void a(Context context, o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.b.a(context, this.d);
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final String getAdInfo() {
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final Object a(T contentController, Activity activity) {
        Object objM7904constructorimpl;
        mx0<T> mx0VarA;
        Intrinsics.checkNotNullParameter(contentController, "contentController");
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            Result.Companion companion = Result.INSTANCE;
            MediatedInterstitialAdapter mediatedInterstitialAdapterA = this.c.a();
            if (mediatedInterstitialAdapterA != null) {
                this.d.a(contentController);
                this.f7233a.j().c();
                mediatedInterstitialAdapterA.showInterstitial(activity);
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

    @Override // com.yandex.mobile.ads.impl.zc0
    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f7233a.j().d();
        this.b.a(context);
    }
}
