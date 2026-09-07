package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.SignalsConfig;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.uc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC3588uc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JSONObject f3447a = new JSONObject();
    public static final LinkedHashSet b = new LinkedHashSet();
    public static C3644yc c;

    public static void a() {
        synchronized (f3447a) {
            c = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (f3447a) {
            C3644yc c3644yc = c;
            z = (c3644yc == null || c3644yc.A.get()) ? false : true;
        }
        return z;
    }

    public static void c() {
        C3644yc c3644yc;
        synchronized (f3447a) {
            if (b() && (c3644yc = c) != null) {
                c3644yc.A.compareAndSet(false, true);
            }
            Unit unit = Unit.INSTANCE;
        }
        d();
    }

    public static void d() {
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        SignalsConfig.UnifiedIdServiceConfig unifiedIdServiceConfig = ((SignalsConfig) B4.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getUnifiedIdServiceConfig();
        synchronized (f3447a) {
            String url = unifiedIdServiceConfig.getUrl();
            LinkedHashMap linkedHashMap2 = C3578u2.f3440a;
            Config configA = C3549s2.a("signals", C3517pb.b(), null);
            Intrinsics.checkNotNull(configA, "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig");
            C3644yc c3644yc = new C3644yc(url, new C3545rc(((SignalsConfig) configA).getIncludeIds()), C3517pb.b(), unifiedIdServiceConfig.getMaxRetries(), unifiedIdServiceConfig.getRetryInterval(), unifiedIdServiceConfig.getTimeout());
            c = c3644yc;
            R4 r4 = new R4(new C3602vc(c3644yc, b), c3644yc);
            HashMap map = new HashMap();
            Ob ob = Ob.f3160a;
            Ob.b("UnifiedIdNetworkCallRequested", map, Sb.SDK);
            ((ScheduledThreadPoolExecutor) S3.b.getValue()).submit(r4);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static void e() {
        synchronized (f3447a) {
            C3644yc c3644yc = c;
            if (c3644yc != null) {
                c3644yc.A.compareAndSet(false, true);
            }
            c = null;
            b.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
