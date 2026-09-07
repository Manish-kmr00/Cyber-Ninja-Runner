package com.monetization.ads.mediation.appopenad;

import android.app.Activity;
import android.content.Context;
import com.yandex.mobile.ads.impl.cy0;
import com.yandex.mobile.ads.impl.mx0;
import com.yandex.mobile.ads.impl.nx0;
import com.yandex.mobile.ads.impl.o8;
import com.yandex.mobile.ads.impl.op0;
import com.yandex.mobile.ads.impl.wd0;
import com.yandex.mobile.ads.impl.zc0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b<T extends wd0<T>> implements zc0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nx0<MediatedAppOpenAdAdapter, MediatedAppOpenAdAdapter.MediatedAppOpenAdAdapterListener> f7218a;
    private final c b;
    private final a<T> c;
    private final cy0 d;

    public b(nx0<MediatedAppOpenAdAdapter, MediatedAppOpenAdAdapter.MediatedAppOpenAdAdapterListener> mediatedAdController, c mediatedAppOpenAdLoader, a<T> mediatedAppOpenAdAdapterListener, cy0 mediatedAdapterReporter) {
        Intrinsics.checkNotNullParameter(mediatedAdController, "mediatedAdController");
        Intrinsics.checkNotNullParameter(mediatedAppOpenAdLoader, "mediatedAppOpenAdLoader");
        Intrinsics.checkNotNullParameter(mediatedAppOpenAdAdapterListener, "mediatedAppOpenAdAdapterListener");
        Intrinsics.checkNotNullParameter(mediatedAdapterReporter, "mediatedAdapterReporter");
        this.f7218a = mediatedAdController;
        this.b = mediatedAppOpenAdLoader;
        this.c = mediatedAppOpenAdAdapterListener;
        this.d = mediatedAdapterReporter;
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final void a(Context context, o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f7218a.a(context, this.c);
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
            MediatedAppOpenAdAdapter mediatedAppOpenAdAdapterA = this.b.a();
            if (mediatedAppOpenAdAdapterA != null) {
                this.c.a(contentController);
                mediatedAppOpenAdAdapterA.showAppOpenAd(activity);
            }
            objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null && (mx0VarA = this.f7218a.a()) != 0) {
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            op0.c(new Object[0]);
            this.d.a(applicationContext, mx0VarA.c(), MapsKt.mapOf(TuplesKt.to("reason", MapsKt.mapOf(TuplesKt.to("exception_in_adapter", thM7907exceptionOrNullimpl.toString())))), mx0VarA.a().b().getNetworkName());
        }
        return objM7904constructorimpl;
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f7218a.a(context);
    }
}
