package io.appmetrica.analytics.impl;

import com.safedk.android.analytics.events.CrashEvent;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class Ea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashSet f11121a;

    static {
        HashSet hashSet = new HashSet();
        f11121a = hashSet;
        hashSet.add("get_ad");
        hashSet.add(CrashEvent.e);
        hashSet.add("report_ad");
        hashSet.add("startup");
        hashSet.add("diagnostic");
    }

    public static ArrayList a(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
            if (jSONObjectOptJSONObject != null) {
                return AbstractC4288mb.a(jSONObjectOptJSONObject.getJSONArray("urls"));
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
