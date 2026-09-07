package sg.bigo.ads.core.d.a;

import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13535a = 10;
    public int b = 900000;
    public final HashMap<String, C0892a> c;

    /* JADX INFO: renamed from: sg.bigo.ads.core.d.a.a$a, reason: collision with other inner class name */
    public static class C0892a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f13536a;
        boolean b;
        public boolean c;
        public int d;

        public static C0892a a(String str) {
            C0892a c0892a = new C0892a();
            c0892a.f13536a = str;
            c0892a.b = true;
            c0892a.c = true;
            c0892a.d = BrandSafetyUtils.g;
            return c0892a;
        }

        public final void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                sg.bigo.ads.common.t.a.a(0, "Stats", "eventConfig is null.");
                return;
            }
            this.f13536a = jSONObject.optString("event_id");
            this.b = jSONObject.optInt("status") == 1;
            this.c = jSONObject.optInt("delay") == 1;
            int iOptInt = jSONObject.optInt("expired") * 1000;
            this.d = iOptInt;
            if (iOptInt == 0) {
                this.d = BrandSafetyUtils.g;
            }
        }
    }

    public a() {
        HashMap<String, C0892a> map = new HashMap<>();
        this.c = map;
        b();
        map.put("06002002", C0892a.a("06002002"));
        map.put("06002007", C0892a.a("06002007"));
    }

    private void b() {
        this.f13535a = 10;
        this.b = 900000;
        this.c.clear();
    }

    public final int a() {
        return Math.round(this.f13535a * 0.8f);
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            b();
            return;
        }
        this.f13535a = jSONObject.optInt("delay_num", 10);
        int iOptInt = jSONObject.optInt("delay_interval") * 1000;
        this.b = iOptInt;
        if (iOptInt == 0) {
            this.b = 900000;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("event_config");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            C0892a c0892a = new C0892a();
            c0892a.a(jSONArrayOptJSONArray.optJSONObject(i));
            if (q.b((CharSequence) c0892a.f13536a)) {
                this.c.put(c0892a.f13536a, c0892a);
            }
        }
    }

    public final boolean a(String str) {
        C0892a c0892a = this.c.get(str);
        if (c0892a == null) {
            return false;
        }
        return c0892a.b;
    }
}
