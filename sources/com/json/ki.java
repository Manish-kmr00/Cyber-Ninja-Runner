package com.json;

import com.json.mediationsdk.utils.IronSourceConstants;
import com.safedk.android.analytics.brandsafety.l;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public class ki {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e2 f3837a;

    public ki(e2 e2Var) {
        this.f3837a = e2Var;
    }

    public void a() {
        this.f3837a.a(b2.INIT_SUCCESS, null);
    }

    public void a(int i, String str) {
        HashMap map = new HashMap();
        map.put("errorCode", Integer.valueOf(i));
        map.put("reason", str);
        this.f3837a.a(b2.INIT_FAILED, map);
    }

    public void a(long j) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        this.f3837a.a(b2.INIT_ENDED, map);
    }

    public void a(String str, String str2) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_EXT1, str + l.ad + str2);
        this.f3837a.a(b2.INIT_STARTED, map);
    }
}
