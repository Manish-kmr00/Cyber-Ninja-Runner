package io.appmetrica.analytics.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes13.dex */
public final class E9 implements IExecutionPolicy {
    public static final EnumSet c = EnumSet.of(EnumC4490ue.OFFLINE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C5 f11120a = new C5();
    public final Context b;

    public E9(Context context) {
        this.b = context;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final boolean canBeExecuted() {
        C5 c5 = this.f11120a;
        Context context = this.b;
        c5.getClass();
        SafePackageManager safePackageManager = AbstractC4515ve.f11816a;
        return !c.contains((EnumC4490ue) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", EnumC4490ue.UNDEFINED, new C4465te()));
    }
}
