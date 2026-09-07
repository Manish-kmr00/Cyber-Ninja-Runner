package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class Pk implements Om {
    public static final long d = TimeUnit.SECONDS.toMillis(20);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11299a;
    public final PermissionExtractor b;
    public final CachedDataProvider.CachedData c;

    public Pk(Context context) {
        long j = d;
        this.c = new CachedDataProvider.CachedData(j, j, "sim-info");
        this.f11299a = context;
        this.b = C4486ua.j().i();
    }

    public final Kk b() {
        return new Kk((Integer) SystemServiceUtils.accessSystemServiceByNameSafely(this.f11299a, "phone", "getting SimMcc", "TelephonyManager", new Lk()), (Integer) SystemServiceUtils.accessSystemServiceByNameSafely(this.f11299a, "phone", "getting SimMnc", "TelephonyManager", new Mk()), ((Boolean) SystemServiceUtils.accessSystemServiceByNameSafelyOrDefault(this.f11299a, "phone", "getting NetworkRoaming", "TelephonyManager", Boolean.FALSE, new Ok(this))).booleanValue(), (String) SystemServiceUtils.accessSystemServiceByNameSafely(this.f11299a, "phone", "getting SimOperatorName", "TelephonyManager", new Nk()));
    }

    @Override // io.appmetrica.analytics.impl.Om
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final synchronized List<Kk> a() {
        List<Kk> list;
        List<Kk> list2 = (List) this.c.getData();
        if (list2 == null || (list2.isEmpty() && this.c.shouldUpdateData())) {
            list = list2;
            list = list2;
            ArrayList arrayList = new ArrayList();
            if (C4486ua.E.u.b().n.d) {
                if (AndroidUtils.isApiAchieved(23)) {
                    if (this.b.hasPermission(this.f11299a, "android.permission.READ_PHONE_STATE")) {
                        arrayList.addAll(Qk.a(this.f11299a));
                    }
                    if (arrayList.size() == 0) {
                        arrayList.add(b());
                    }
                } else {
                    arrayList.add(b());
                }
            }
            this.c.setData(arrayList);
            list = arrayList;
        }
        return list;
    }
}
