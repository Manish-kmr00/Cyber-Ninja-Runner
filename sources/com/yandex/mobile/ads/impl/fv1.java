package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes8.dex */
public final class fv1 implements Runnable {
    private static final CopyOnWriteArrayList<hv1> f = new CopyOnWriteArrayList<>();
    private final uu1 b;
    private final CoroutineScope c;
    private final hv1.a d;
    private final Context e;

    public fv1(Context context, uu1 sdkEnvironmentModule, CoroutineScope coroutineScope, hv1.a sdkInitializationListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(sdkInitializationListener, "sdkInitializationListener");
        this.b = sdkEnvironmentModule;
        this.c = coroutineScope;
        this.d = sdkInitializationListener;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.e = applicationContext;
    }

    @Override // java.lang.Runnable
    public final void run() {
        hv1 hv1Var = new hv1(this.e, this.b, this.c, new g5(), null, null, 2097136);
        f.add(hv1Var);
        hv1Var.a(dl0.c, new a(hv1Var, this));
    }

    public static final class a implements hv1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ hv1 f8927a;
        final /* synthetic */ fv1 b;

        a(hv1 hv1Var, fv1 fv1Var) {
            this.f8927a = hv1Var;
            this.b = fv1Var;
        }

        @Override // com.yandex.mobile.ads.impl.hv1.a
        public final void a(w3 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            fv1.f.remove(this.f8927a);
            this.b.d.a(error);
        }

        @Override // com.yandex.mobile.ads.impl.hv1.a
        public final void a(jc advertisingConfiguration, l50 environmentConfiguration) {
            Intrinsics.checkNotNullParameter(advertisingConfiguration, "advertisingConfiguration");
            Intrinsics.checkNotNullParameter(environmentConfiguration, "environmentConfiguration");
            fv1.f.remove(this.f8927a);
            this.b.d.a(advertisingConfiguration, environmentConfiguration);
        }
    }
}
