package com.ogury.ad.internal;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class y6 implements z6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q6 f7451a;
    public final x6 b;
    public FragmentActivity c;
    public final Application d;
    public final a e;
    public final FragmentManager.OnBackStackChangedListener f;
    public final b g;

    public static final class a extends FragmentManager.FragmentLifecycleCallbacks {
        public a() {
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public final void onFragmentPaused(FragmentManager fm, Fragment f) {
            Intrinsics.checkNotNullParameter(fm, "fm");
            Intrinsics.checkNotNullParameter(f, "f");
            FragmentActivity activity = f.getActivity();
            FragmentManager supportFragmentManager = activity != null ? activity.getSupportFragmentManager() : null;
            if (supportFragmentManager != null) {
                y6.this.a(supportFragmentManager);
            }
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public final void onFragmentResumed(FragmentManager fm, Fragment f) {
            Intrinsics.checkNotNullParameter(fm, "fm");
            Intrinsics.checkNotNullParameter(f, "f");
            FragmentActivity activity = f.getActivity();
            FragmentManager supportFragmentManager = activity != null ? activity.getSupportFragmentManager() : null;
            if (supportFragmentManager != null) {
                y6.this.a(supportFragmentManager);
            }
        }
    }

    public static final class b extends com.ogury.ad.internal.b {
        public b() {
        }

        @Override // com.ogury.ad.internal.b, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity instanceof FragmentActivity) {
                y6 y6Var = y6.this;
                FragmentActivity fragmentActivity = (FragmentActivity) activity;
                y6Var.getClass();
                fragmentActivity.getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(y6Var.e);
                fragmentActivity.getSupportFragmentManager().removeOnBackStackChangedListener(y6Var.f);
                q6 q6Var = y6Var.f7451a;
                if (q6Var.f7389a.getParent() == null || q6Var.b.e()) {
                    return;
                }
                q6Var.b.h();
                q6Var.f7389a.d();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity instanceof FragmentActivity) {
                y6 y6Var = y6.this;
                FragmentActivity fragmentActivity = (FragmentActivity) activity;
                y6Var.c = fragmentActivity;
                fragmentActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(y6Var.e, true);
                fragmentActivity.getSupportFragmentManager().addOnBackStackChangedListener(y6Var.f);
            }
        }
    }

    public y6(Activity activity, q6 adLayoutController, x6 overlayFragmentFilter, g9 topActivityMonitor) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adLayoutController, "adLayoutController");
        Intrinsics.checkNotNullParameter(overlayFragmentFilter, "overlayFragmentFilter");
        Intrinsics.checkNotNullParameter(topActivityMonitor, "topActivityMonitor");
        this.f7451a = adLayoutController;
        this.b = overlayFragmentFilter;
        this.c = (FragmentActivity) activity;
        this.d = activity.getApplication();
        this.e = new a();
        this.f = new FragmentManager.OnBackStackChangedListener() { // from class: com.ogury.ad.internal.y6$$ExternalSyntheticLambda0
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChanged() {
                y6.a(this.f$0);
            }
        };
        this.g = new b();
    }

    public final void a(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        ArrayList fragments = new ArrayList();
        l2.a(fragments, fragmentManager);
        x6 x6Var = this.b;
        x6Var.getClass();
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        Iterator it = fragments.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                Iterator it2 = fragments.iterator();
                while (it2.hasNext()) {
                    String strA = h7.a(it2.next());
                    List<String> list = x6Var.f7441a.f7336a;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it3 = list.iterator();
                        while (it3.hasNext()) {
                            if (StringsKt.startsWith$default(strA, (String) it3.next(), false, 2, (Object) null)) {
                                this.f7451a.a(this.c);
                                return;
                            }
                        }
                    }
                }
                break;
            }
            String strA2 = h7.a(it.next());
            List<String> list2 = x6Var.f7441a.b;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it4 = list2.iterator();
                while (it4.hasNext()) {
                    if (Intrinsics.areEqual((String) it4.next(), strA2)) {
                        break loop0;
                    }
                }
            }
        }
        q6 q6Var = this.f7451a;
        if (q6Var.f7389a.getParent() == null || q6Var.b.e()) {
            return;
        }
        q6Var.b.h();
        q6Var.f7389a.d();
    }

    @Override // com.ogury.ad.internal.z6
    public final void b() {
        Activity activity = g9.b.get();
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        if (fragmentActivity == null) {
            fragmentActivity = this.c;
        }
        this.c = fragmentActivity;
        fragmentActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.e, true);
        fragmentActivity.getSupportFragmentManager().addOnBackStackChangedListener(this.f);
        FragmentManager supportFragmentManager = this.c.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        a(supportFragmentManager);
    }

    @Override // com.ogury.ad.internal.z6
    public final void c() {
        this.d.registerActivityLifecycleCallbacks(this.g);
    }

    public static final void a(y6 y6Var) {
        FragmentManager supportFragmentManager = y6Var.c.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        y6Var.a(supportFragmentManager);
    }

    @Override // com.ogury.ad.internal.z6
    public final void a() {
        this.d.unregisterActivityLifecycleCallbacks(this.g);
        FragmentActivity fragmentActivity = this.c;
        fragmentActivity.getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this.e);
        fragmentActivity.getSupportFragmentManager().removeOnBackStackChangedListener(this.f);
        q6 q6Var = this.f7451a;
        if (q6Var.f7389a.getParent() == null || q6Var.b.e()) {
            return;
        }
        q6Var.b.h();
        q6Var.f7389a.d();
    }
}
