package io.appmetrica.analytics.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;

/* JADX INFO: loaded from: classes13.dex */
public final class C5 {
    public final EnumC4490ue a(Context context) {
        SafePackageManager safePackageManager = AbstractC4515ve.f11816a;
        return (EnumC4490ue) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", EnumC4490ue.UNDEFINED, new C4465te());
    }
}
