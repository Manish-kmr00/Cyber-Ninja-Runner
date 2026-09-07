package com.monetization.ads.mediation.banner;

import android.app.Activity;
import android.content.Context;
import com.yandex.mobile.ads.impl.cy0;
import com.yandex.mobile.ads.impl.dj;
import com.yandex.mobile.ads.impl.dz0;
import com.yandex.mobile.ads.impl.eg1;
import com.yandex.mobile.ads.impl.ey0;
import com.yandex.mobile.ads.impl.g5;
import com.yandex.mobile.ads.impl.gy0;
import com.yandex.mobile.ads.impl.nx0;
import com.yandex.mobile.ads.impl.o3;
import com.yandex.mobile.ads.impl.o8;
import com.yandex.mobile.ads.impl.op0;
import com.yandex.mobile.ads.impl.p0;
import com.yandex.mobile.ads.impl.vx0;
import com.yandex.mobile.ads.impl.zi;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements dj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zi f7222a;
    private final o8<String> b;
    private final a c;
    private final nx0<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> d;

    public c(zi loadController, o8<String> adResponse, dz0 mediationData) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(mediationData, "mediationData");
        this.f7222a = loadController;
        this.b = adResponse;
        o3 o3VarF = loadController.f();
        gy0 gy0Var = new gy0(o3VarF);
        cy0 cy0Var = new cy0(o3VarF, adResponse);
        ey0 ey0Var = new ey0(new vx0(mediationData.c(), gy0Var, cy0Var));
        g5 g5VarI = loadController.i();
        nx0<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> nx0Var = new nx0<>(o3VarF, g5VarI, new b(), cy0Var, ey0Var, new eg1(loadController, mediationData, g5VarI));
        this.d = nx0Var;
        this.c = new a(loadController, nx0Var, new d(loadController.C(), loadController.f().r()));
    }

    @Override // com.yandex.mobile.ads.impl.dj
    public final void a(Context context, o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Activity activityA = p0.a();
        if (activityA != null) {
            op0.a(new Object[0]);
        }
        if (activityA != null) {
            context = activityA;
        }
        this.d.a(context, this.c);
    }

    @Override // com.yandex.mobile.ads.impl.dj
    public final String getAdInfo() {
        return this.b.e();
    }

    @Override // com.yandex.mobile.ads.impl.dj
    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f7222a.j().d();
        this.d.a(context);
    }
}
