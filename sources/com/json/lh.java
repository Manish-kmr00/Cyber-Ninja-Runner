package com.json;

import android.util.Log;
import com.json.mediationsdk.logger.IronLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class lh {
    private static lh b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private kc f3865a;

    private lh() {
    }

    private static lh a() {
        if (b == null) {
            b = new lh();
        }
        return b;
    }

    public static void a(ec ecVar, jh jhVar) {
        if (ecVar != null) {
            try {
                a().f3865a = new kc(ecVar, jhVar);
            } catch (Exception e) {
                o9.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }
    }

    public static void a(er.a aVar) {
        a(aVar, new HashMap());
    }

    public static void a(er.a aVar, Map<String, Object> map) {
        kc kcVar = a().f3865a;
        if (kcVar == null) {
            Log.d(cc.f3578a, cc.U);
            return;
        }
        if (map != null) {
            map.put("eventid", Integer.valueOf(aVar.b));
        }
        kcVar.a(aVar.f3673a, map);
    }
}
