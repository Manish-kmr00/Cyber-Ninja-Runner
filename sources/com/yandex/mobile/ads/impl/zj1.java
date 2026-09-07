package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class zj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j0 f10822a;
    private final wj1 b;
    private final q1 c;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.y);
        p0.startActivity(p1);
    }

    public final boolean a(Context context, List<vj1> preferredPackages) {
        Activity activity;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preferredPackages, "preferredPackages");
        Activity activityA = p0.a();
        if (activityA != null) {
            context = activityA;
        } else {
            this.f10822a.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
            Context baseContext = context;
            int i = 0;
            while (true) {
                if (baseContext instanceof ContextWrapper) {
                    int i2 = i + 1;
                    if (i < 10) {
                        if (baseContext instanceof Activity) {
                            activity = (Activity) baseContext;
                            break;
                        }
                        baseContext = ((ContextWrapper) baseContext).getBaseContext();
                        i = i2;
                    }
                }
                activity = null;
                break;
            }
            if (activity != null) {
                context = activity;
            }
        }
        for (vj1 vj1Var : preferredPackages) {
            try {
                this.b.getClass();
                Intent intentA = wj1.a(context, vj1Var);
                if (vj1Var.c() == uy.d) {
                    this.c.a(context, intentA);
                    return true;
                }
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intentA);
                return true;
            } catch (Exception unused) {
                op0.b(vj1Var.d());
            }
        }
        return false;
    }

    public /* synthetic */ zj1(o3 o3Var, o8 o8Var) {
        this(o3Var, o8Var, new j0(), new wj1(), new q1(o3Var, o8Var));
    }

    public zj1(o3 adConfiguration, o8<?> adResponse, j0 activityContextProvider, wj1 preferredPackageIntentCreator, q1 adActivityResultLauncher) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(activityContextProvider, "activityContextProvider");
        Intrinsics.checkNotNullParameter(preferredPackageIntentCreator, "preferredPackageIntentCreator");
        Intrinsics.checkNotNullParameter(adActivityResultLauncher, "adActivityResultLauncher");
        this.f10822a = activityContextProvider;
        this.b = preferredPackageIntentCreator;
        this.c = adActivityResultLauncher;
    }
}
