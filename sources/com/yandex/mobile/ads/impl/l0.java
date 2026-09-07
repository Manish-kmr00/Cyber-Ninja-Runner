package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9464a;
    private final o0 b;
    private final g0 c;
    private final c32 d;
    private final a e;

    public l0(Context context, o3 adConfiguration, n0 interactionEventListener, Context applicationContext, o0 activityInteractionTracker, g0 activityBackgroundListener, c32 strongReferenceKeepingManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(interactionEventListener, "interactionEventListener");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(activityInteractionTracker, "activityInteractionTracker");
        Intrinsics.checkNotNullParameter(activityBackgroundListener, "activityBackgroundListener");
        Intrinsics.checkNotNullParameter(strongReferenceKeepingManager, "strongReferenceKeepingManager");
        this.f9464a = applicationContext;
        this.b = activityInteractionTracker;
        this.c = activityBackgroundListener;
        this.d = strongReferenceKeepingManager;
        this.e = new a(this);
    }

    public /* synthetic */ l0(Context context, o3 o3Var, o8 o8Var, n0 n0Var, j80 j80Var) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        o0 o0Var = new o0(context, o3Var, o8Var, n0Var, j80Var);
        i0 i0VarA = h0.a();
        int i = c32.d;
        this(context, o3Var, n0Var, applicationContext, o0Var, i0VarA, c32.a.a());
    }

    public final void g() {
        this.b.b(o0.a.d);
    }

    public final void f() {
        this.b.a(o0.a.d);
    }

    public final void c() {
        this.b.b(o0.a.e);
    }

    public final void b() {
        this.b.a(o0.a.e);
    }

    public final void e() {
        this.d.b(tq0.d, this);
        this.c.b(this.f9464a, (r0) this.e);
        this.c.b(this.f9464a, this.e);
        this.b.b(o0.a.c);
    }

    public final void d() {
        this.b.a(o0.a.c);
        this.c.a(this.f9464a, (r0) this.e);
        this.c.a(this.f9464a, this.e);
        this.d.a(tq0.d, this);
    }

    public final void a() {
        this.c.b(this.f9464a, (r0) this.e);
        this.c.b(this.f9464a, this.e);
    }

    public final void a(t71 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.b.a(reportParameterManager);
    }

    public static final class a implements r0, er1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l0 f9465a;
        private WeakReference<Activity> b;
        private String c;

        public a(l0 activityInteractionController) {
            Intrinsics.checkNotNullParameter(activityInteractionController, "activityInteractionController");
            this.f9465a = activityInteractionController;
        }

        @Override // com.yandex.mobile.ads.impl.er1
        public final void a(Activity activity, Bundle bundle) {
            String string;
            Intrinsics.checkNotNullParameter(activity, "activity");
            String str = "onCreated, activity = " + activity;
            op0.a(new Object[0]);
            if (bundle == null || (string = bundle.getString("monetization_ads_activity_id")) == null || !Intrinsics.areEqual(string, this.c)) {
                return;
            }
            this.f9465a.d();
        }

        @Override // com.yandex.mobile.ads.impl.r0
        public final void b(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            String str = "onResume, activity = " + activity;
            boolean z = false;
            op0.a(new Object[0]);
            int i = iw1.l;
            cu1 cu1VarA = iw1.a.a().a(activity);
            boolean z2 = cu1VarA != null && cu1VarA.q0();
            Intent intent = activity.getIntent();
            if (intent != null && intent.getBooleanExtra("monetization_ads_activity_click", false)) {
                z = true;
            }
            WeakReference<Activity> weakReference = this.b;
            if ((weakReference == null || !Intrinsics.areEqual(activity, weakReference.get()) || z2) && (!z2 || z)) {
                return;
            }
            this.f9465a.d();
        }

        @Override // com.yandex.mobile.ads.impl.r0
        public final void a(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            String str = "onPause, activity = " + activity;
            op0.a(new Object[0]);
            if (this.b == null) {
                this.b = new WeakReference<>(activity);
            }
        }

        @Override // com.yandex.mobile.ads.impl.er1
        public final void b(Activity activity, Bundle bundle) {
            WeakReference<Activity> weakReference;
            Intrinsics.checkNotNullParameter(activity, "activity");
            String str = "onSaveInstanceState, activity = " + activity;
            op0.a(new Object[0]);
            if (bundle == null || (weakReference = this.b) == null || !Intrinsics.areEqual(activity, weakReference.get())) {
                return;
            }
            String string = UUID.randomUUID().toString();
            this.c = string;
            bundle.putString("monetization_ads_activity_id", string);
        }
    }
}
