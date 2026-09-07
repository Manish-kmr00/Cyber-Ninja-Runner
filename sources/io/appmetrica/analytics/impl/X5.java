package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;

/* JADX INFO: loaded from: classes7.dex */
public abstract class X5 extends BaseRequestConfig.ComponentLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SafePackageManager f11413a;

    public X5(Context context, String str) {
        this(context, str, new SafePackageManager());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Y5 load(W5 w5) {
        Y5 y5 = (Y5) super.load(w5);
        String packageName = getContext().getPackageName();
        ApplicationInfo applicationInfo = this.f11413a.getApplicationInfo(getContext(), getPackageName(), 0);
        if (applicationInfo != null) {
            int i = applicationInfo.flags;
            y5.f11431a = (i & 2) != 0 ? "1" : "0";
            y5.b = (i & 1) == 0 ? "0" : "1";
        } else if (TextUtils.equals(packageName, getPackageName())) {
            y5.f11431a = (getContext().getApplicationInfo().flags & 2) != 0 ? "1" : "0";
            y5.b = (getContext().getApplicationInfo().flags & 1) == 0 ? "0" : "1";
        } else {
            y5.f11431a = "0";
            y5.b = "0";
        }
        Hl hl = w5.f11402a;
        y5.c = hl;
        y5.setRetryPolicyConfig(hl.t);
        return y5;
    }

    public X5(Context context, String str, SafePackageManager safePackageManager) {
        super(context, str);
        this.f11413a = safePackageManager;
    }
}
