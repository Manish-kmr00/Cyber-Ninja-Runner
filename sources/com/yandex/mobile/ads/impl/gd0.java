package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.impl.wd0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class gd0<T extends wd0<T>> extends mg0 {
    private final pg0 A;
    private final bd0 B;
    private zc0<T> C;
    private zc0<T> D;
    private T E;
    private final hd0<T> y;
    private final qd0<T> z;

    protected abstract zc0<T> a(ad0 ad0Var);

    @Override // com.yandex.mobile.ads.impl.bk
    protected final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.y.a(error);
    }

    public /* synthetic */ gd0(Context context, o3 o3Var, uu1 uu1Var, hd0 hd0Var, g5 g5Var, qd0 qd0Var, pg0 pg0Var) {
        this(context, o3Var, uu1Var, hd0Var, g5Var, qd0Var, pg0Var, new bd0(uu1Var));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd0(Context context, o3 adConfiguration, uu1 sdkEnvironmentModule, hd0<T> fullScreenLoadEventListener, g5 adLoadingPhasesManager, qd0<T> fullscreenAdContentFactory, pg0 htmlAdResponseReportManager, bd0 adResponseControllerFactoryCreator) {
        super(context, adConfiguration, adLoadingPhasesManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(fullScreenLoadEventListener, "fullScreenLoadEventListener");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(fullscreenAdContentFactory, "fullscreenAdContentFactory");
        Intrinsics.checkNotNullParameter(htmlAdResponseReportManager, "htmlAdResponseReportManager");
        Intrinsics.checkNotNullParameter(adResponseControllerFactoryCreator, "adResponseControllerFactoryCreator");
        this.y = fullScreenLoadEventListener;
        this.z = fullscreenAdContentFactory;
        this.A = htmlAdResponseReportManager;
        this.B = adResponseControllerFactoryCreator;
        a(i9.f9190a.a());
    }

    @Override // com.yandex.mobile.ads.impl.bk
    public final void e() {
        if (oa.a((qo) this)) {
            return;
        }
        Context contextL = l();
        zc0[] zc0VarArr = {this.D, this.C};
        for (int i = 0; i < 2; i++) {
            zc0 zc0Var = zc0VarArr[i];
            if (zc0Var != null) {
                zc0Var.a(contextL);
            }
        }
        super.e();
    }

    @Override // com.yandex.mobile.ads.impl.bk
    protected final void s() {
        T t = this.E;
        if (t != null) {
            this.y.a(t);
        } else {
            this.y.a(w7.m());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.mobile.ads.impl.bk, com.yandex.mobile.ads.impl.qq1.b
    public void a(o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        super.a((o8<T>) adResponse);
        this.A.a(adResponse);
        this.A.a(f());
        zc0<T> zc0VarA = a(this.B.a(adResponse));
        this.D = this.C;
        this.C = zc0VarA;
        this.E = (T) this.z.a(adResponse, f(), zc0VarA);
        Context contextA = p0.a();
        if (contextA != null) {
            op0.a(new Object[0]);
        }
        if (contextA == null) {
            contextA = l();
        }
        zc0VarA.a(contextA, adResponse);
    }

    @Override // com.yandex.mobile.ads.impl.bk
    protected final void r() {
        w3 error = w7.q();
        Intrinsics.checkNotNullParameter(error, "error");
        this.y.a(error);
    }
}
