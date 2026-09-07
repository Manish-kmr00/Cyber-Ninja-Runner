package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionResolutionStrategy;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider;
import io.appmetrica.analytics.coreutils.internal.permission.AlwaysAllowPermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.permission.SinglePermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class Rc implements Om {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11328a;
    public final PermissionResolutionStrategy b;
    public final CellularNetworkTypeExtractor c;
    public final CachedDataProvider.CachedData d;

    public Rc(Context context) {
        this.f11328a = context;
        this.b = AndroidUtils.isApiAchieved(29) ? new SinglePermissionStrategy(C4486ua.j().i(), "android.permission.READ_PHONE_STATE") : new AlwaysAllowPermissionStrategy();
        this.c = new CellularNetworkTypeExtractor(context);
        long millis = TimeUnit.SECONDS.toMillis(20L);
        this.d = new CachedDataProvider.CachedData(millis, millis * ((long) 2), "mobile-connection");
    }

    @Override // io.appmetrica.analytics.impl.Om
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final synchronized Qc a() {
        Qc qc;
        qc = (Qc) this.d.getData();
        if (qc == null || this.d.shouldUpdateData()) {
            qc = new Qc(this.b.hasNecessaryPermissions(this.f11328a) ? this.c.getNetworkType() : "unknown");
            this.d.setData(qc);
        }
        return qc;
    }
}
