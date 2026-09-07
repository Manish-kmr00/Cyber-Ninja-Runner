package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;

/* JADX INFO: loaded from: classes3.dex */
public final class T9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11362a;
    public final C4573xm b;
    public final C4380q3 c;
    public final SafePackageManager d;

    public T9(Context context, C4573xm c4573xm, C4380q3 c4380q3, SafePackageManager safePackageManager) {
        this.f11362a = context;
        this.b = c4573xm;
        this.c = c4380q3;
        this.d = safePackageManager;
    }

    public T9(Context context) {
        this(context, new C4573xm(context, "io.appmetrica.analytics.build_id"), new C4380q3(context, "io.appmetrica.analytics.is_offline"), new SafePackageManager());
    }
}
