package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class Le extends AbstractC4564xd implements Yn {
    public static final long d = 0;
    public static final int e = -1;
    public static final String f = "";
    public static final String g = "";
    public static final String q = "SESSION_";
    public static final Ne h = new Ne("PERMISSIONS_CHECK_TIME", null);
    public static final Ne i = new Ne("PROFILE_ID", null);
    public static final Ne j = new Ne("APP_ENVIRONMENT", null);
    public static final Ne k = new Ne("APP_ENVIRONMENT_REVISION", null);
    public static final Ne l = new Ne("LAST_APP_VERSION_WITH_FEATURES", null);
    public static final Ne m = new Ne("APPLICATION_FEATURES", null);
    public static final Ne n = new Ne("CERTIFICATES_SHA1_FINGERPRINTS", null);
    public static final Ne o = new Ne("VITAL_DATA", null);
    public static final Ne p = new Ne("SENT_EXTERNAL_ATTRIBUTIONS", null);
    public static final Ne r = new Ne("MAIN_REPORTER_EVENTS_TRIGGER_CONDITION_MET", null);

    public Le(Oa oa) {
        super(oa);
    }

    public final Le a(C4028c0 c4028c0) {
        synchronized (this) {
            b(j.b, c4028c0.f11486a);
            b(k.b, c4028c0.b);
        }
        return this;
    }

    public final void b(boolean z) {
        b(r.b, z);
    }

    @Override // io.appmetrica.analytics.impl.Me
    public final Set<String> c() {
        return this.f11258a.a();
    }

    public final C4028c0 d() {
        C4028c0 c4028c0;
        synchronized (this) {
            c4028c0 = new C4028c0(this.f11258a.getString(j.b, JsonUtils.EMPTY_JSON), this.f11258a.getLong(k.b, 0L));
        }
        return c4028c0;
    }

    public final String e() {
        return this.f11258a.getString(m.b, "");
    }

    public final List<String> f() {
        String str = n.b;
        List listEmptyList = Collections.emptyList();
        String[] strArr = listEmptyList == null ? null : (String[]) listEmptyList.toArray(new String[listEmptyList.size()]);
        String string = this.f11258a.getString(str, null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                strArr = new String[jSONArray.length()];
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    strArr[i2] = jSONArray.optString(i2);
                }
            } catch (Throwable unused) {
            }
        }
        if (strArr == null) {
            return null;
        }
        return Arrays.asList(strArr);
    }

    public final int g() {
        return this.f11258a.getInt(l.b, -1);
    }

    public final long h() {
        return this.f11258a.getLong(h.b, 0L);
    }

    public final Le i(String str) {
        return (Le) b(m.b, str);
    }

    public final Le j(String str) {
        return (Le) b(i.b, str);
    }

    public final String h(String str) {
        return this.f11258a.getString(new Ne(q, str).b, "");
    }

    public final String i() {
        return this.f11258a.getString(i.b, null);
    }

    public final Map<Integer, String> j() {
        HashMap map = new HashMap();
        try {
            String string = this.f11258a.getString(p.b, null);
            if (string != null) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(Integer.valueOf(Integer.parseInt(next)), jSONObject.getString(next));
                }
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    public final Le e(String str, String str2) {
        return (Le) b(new Ne(q, str).b, str2);
    }

    public final Le a(long j2) {
        return (Le) b(h.b, j2);
    }

    public final Le a(int i2) {
        return (Le) b(l.b, i2);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4564xd
    public final String f(String str) {
        return new Ne(str, null).b;
    }

    public final Le a(List<String> list) {
        return (Le) a(n.b, list);
    }

    public final boolean a(boolean z) {
        return this.f11258a.getBoolean(r.b, z);
    }

    @Override // io.appmetrica.analytics.impl.Yn
    public final String a() {
        return this.f11258a.getString(o.b, null);
    }

    @Override // io.appmetrica.analytics.impl.Yn
    public final void a(String str) {
        b(o.b, str);
    }

    public final void a(Map<Integer, String> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey().toString(), entry.getValue());
            } catch (Throwable unused) {
            }
        }
        b(p.b, jSONObject.toString());
    }
}
