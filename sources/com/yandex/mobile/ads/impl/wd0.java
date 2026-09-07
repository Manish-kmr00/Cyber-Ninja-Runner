package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.yandex.mobile.ads.impl.wd0;
import java.io.Serializable;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class wd0<T extends wd0<T>> extends a62 {
    private final o3 k;
    private final sc0 l;
    private final zc0<T> m;
    private final w4 n;
    private final ld0 o;
    private final g5 p;
    private final c32 q;
    private final t7 r;
    private kd0 s;

    @Override // com.yandex.mobile.ads.impl.a62
    protected final boolean a(int i) {
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.a62
    protected final boolean k() {
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.a62
    public final boolean l() {
        return true;
    }

    protected abstract T o();

    @Override // com.yandex.mobile.ads.impl.n0
    public final void onReturnedToApplication() {
    }

    public /* synthetic */ wd0(Context context, o8 o8Var, o3 o3Var, sc0 sc0Var, zc0 zc0Var, w4 w4Var) {
        ld0 ld0Var = new ld0();
        g5 g5Var = new g5();
        int i = c32.d;
        c32 c32VarA = c32.a.a();
        pg0 pg0Var = new pg0();
        pg0Var.a((o8<String>) o8Var);
        pg0Var.a(o3Var);
        this(context, o8Var, o3Var, sc0Var, zc0Var, w4Var, ld0Var, g5Var, c32VarA, new t7(context, o8Var, o3Var, g5Var, pg0Var));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wd0(Context context, o8<String> adResponse, o3 adConfiguration, sc0 fullScreenAdVisibilityValidator, zc0<T> fullScreenController, w4 adInfoMapper, ld0 fullScreenTrackingController, g5 adLoadingPhasesManager, c32 strongReferenceKeepingManager, t7 adRenderingResultReporter) {
        super(context, fullScreenAdVisibilityValidator, adResponse, adConfiguration);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(fullScreenAdVisibilityValidator, "fullScreenAdVisibilityValidator");
        Intrinsics.checkNotNullParameter(fullScreenController, "fullScreenController");
        Intrinsics.checkNotNullParameter(adInfoMapper, "adInfoMapper");
        Intrinsics.checkNotNullParameter(fullScreenTrackingController, "fullScreenTrackingController");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(strongReferenceKeepingManager, "strongReferenceKeepingManager");
        Intrinsics.checkNotNullParameter(adRenderingResultReporter, "adRenderingResultReporter");
        this.k = adConfiguration;
        this.l = fullScreenAdVisibilityValidator;
        this.m = fullScreenController;
        this.n = adInfoMapper;
        this.o = fullScreenTrackingController;
        this.p = adLoadingPhasesManager;
        this.q = strongReferenceKeepingManager;
        this.r = adRenderingResultReporter;
        o1.b.a().a("window_type_fullscreen", new h1());
    }

    public final void q() {
        kd0 kd0Var = this.s;
        if (kd0Var != null) {
            kd0Var.onAdShown();
        }
    }

    public final void p() {
        h();
        this.q.a(tq0.c, this);
        kd0 kd0Var = this.s;
        if (kd0Var != null) {
            kd0Var.onAdDismissed();
        }
    }

    @Override // com.yandex.mobile.ads.impl.nk0.a
    public final void a(t4 t4Var) {
        kd0 kd0Var = this.s;
        if (kd0Var != null) {
            kd0Var.a(t4Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.n0
    public final void onLeftApplication() {
        kd0 kd0Var = this.s;
        if (kd0Var != null) {
            kd0Var.onAdClicked();
        }
    }

    public final ps n() {
        w4 w4Var = this.n;
        Context context = e();
        o8<T> adResponse = d();
        o3 adConfiguration = this.k;
        String adInfo = this.m.getAdInfo();
        w4Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        String strP = adResponse.p();
        if (strP == null && (strP = adConfiguration.c()) == null) {
            strP = "";
        }
        zy1 zy1VarM = adResponse.M();
        if (zy1VarM.getWidth() == 0 || zy1VarM.getHeight() == 0) {
            zy1VarM = null;
        }
        return new ps(strP, zy1VarM != null ? new h9(zy1VarM.c(context), zy1VarM.a(context)) : null, adInfo);
    }

    @Override // com.yandex.mobile.ads.impl.a62, com.yandex.mobile.ads.impl.q3
    public void a(int i, Bundle bundle) {
        String str = "onReceiveResult(), resultCode = " + i + ", clazz = " + getClass();
        op0.d(new Object[0]);
        Map<String, String> map = null;
        map = null;
        if (i == 0) {
            if (bundle != null) {
                Serializable serializable = bundle.getSerializable("extra_tracking_parameters");
                if (serializable instanceof Map) {
                    map = (Map) serializable;
                }
            }
            this.p.a(f5.f);
            this.r.a();
            q();
            ld0 ld0Var = this.o;
            o8<T> o8VarD = d();
            ld0Var.getClass();
            if (o8VarD == null || o8VarD.v() != fs.c) {
                a(map);
                return;
            }
            return;
        }
        if (i == 16) {
            if (bundle != null) {
                Parcelable parcelable = bundle.getParcelable("impression_data_key");
                a(parcelable instanceof t4 ? (t4) parcelable : null);
                return;
            } else {
                a((t4) null);
                return;
            }
        }
        if (i == 17) {
            kd0 kd0Var = this.s;
            if (kd0Var != null) {
                kd0Var.onAdClicked();
                return;
            }
            return;
        }
        if (i == 2) {
            this.l.a(0);
            b(0);
        } else if (i == 3) {
            this.l.a(8);
            b(8);
        } else if (i == 4) {
            p();
        } else if (i != 5) {
            super.a(i, bundle);
        }
    }

    public final void a(kd0 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.s = listener;
    }

    public final Object a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        g();
        Result.Companion companion = Result.INSTANCE;
        Result.m7904constructorimpl(ResultKt.createFailure(r6.a()));
        synchronized (this) {
        }
        g5 g5Var = this.p;
        f5 f5Var = f5.f;
        ak.a(g5Var, f5Var, "adLoadingPhaseType", f5Var, null);
        c32 c32Var = this.q;
        tq0 tq0Var = tq0.c;
        c32Var.b(tq0Var, this);
        Object objA = this.m.a(o(), activity);
        if (Result.m7907exceptionOrNullimpl(objA) != null) {
            this.p.a(f5Var);
            if (!oa.a((qo) this)) {
                this.q.a(tq0Var, this);
                this.m.a(e());
                super.c();
            }
        }
        return objA;
    }
}
