package com.json;

import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ce {
    public static final String b = "userId";
    public static final String c = "appKey";
    private static ce d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f3579a = IronSourceNetworkBridge.jsonObjectInit();

    private ce() {
    }

    public static synchronized ce a() {
        if (d == null) {
            d = new ce();
        }
        return d;
    }

    public synchronized String a(String str) {
        return this.f3579a.optString(str);
    }

    public synchronized void a(String str, Object obj) {
        try {
            this.f3579a.put(str, obj);
        } catch (Exception e) {
            o9.d().a(e);
        }
    }

    public synchronized void a(Map<String, Object> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                a(str, map.get(str));
            }
        }
    }

    public synchronized JSONObject b() {
        return this.f3579a;
    }
}
