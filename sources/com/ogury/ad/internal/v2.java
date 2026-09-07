package com.ogury.ad.internal;

import android.app.Activity;
import android.app.Application;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class v2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f7418a;
    public a b;

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f7419a;
        public final /* synthetic */ v2 b;

        public a(h hVar, v2 v2Var) {
            this.f7419a = hVar;
            this.b = v2Var;
        }

        @Override // com.ogury.ad.internal.b, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f7419a.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.b.a();
            h hVar = this.f7419a;
            activity.addContentView(hVar, hVar.getLayoutParams());
        }
    }

    public v2(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.f7418a = application;
    }

    public final void a(h adLayout) {
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        a aVar = new a(adLayout, this);
        this.b = aVar;
        this.f7418a.registerActivityLifecycleCallbacks(aVar);
    }

    public final void a() {
        this.f7418a.unregisterActivityLifecycleCallbacks(this.b);
    }
}
