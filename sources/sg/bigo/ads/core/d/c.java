package sg.bigo.ads.core.d;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.g;
import sg.bigo.ads.common.n.d;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class c {
    private static final c e = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sg.bigo.ads.core.d.a.a f13548a;
    public sg.bigo.ads.core.d.b.b b;
    public final AtomicBoolean c = new AtomicBoolean(false);
    public g d;

    private c() {
    }

    public static c a() {
        return e;
    }

    private static boolean a(String str) {
        return "06002007".equals(str) && sg.bigo.ads.common.x.a.p();
    }

    private void b(final String str, final Map<String, String> map) {
        d.a(3, new Runnable() { // from class: sg.bigo.ads.core.d.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    sg.bigo.ads.common.g.b.b bVarA = sg.bigo.ads.core.d.b.b.b(str, map).a(c.this.d, 0L);
                    HashMap map2 = new HashMap();
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("event_id", bVarA.b);
                    jSONObject.put("event_info", bVarA.c);
                    jSONArray.put(jSONObject);
                    map2.put("sdk_events", jSONArray);
                    a aVarA = a.a();
                    if (aVarA.f13534a != null) {
                        aVarA.f13534a.a(map2, null);
                    }
                } catch (JSONException unused) {
                }
            }
        });
    }

    public final void a(String str, Map<String, String> map) {
        String str2;
        String strConcat;
        if (a(str) || "06002066".equals(str)) {
            b(str, map);
            return;
        }
        if (this.f13548a != null) {
            if (sg.bigo.ads.common.x.a.p()) {
                return;
            }
            if (!this.c.get()) {
                strConcat = "please execute initStatic first";
            } else if (q.a((CharSequence) str) || map == null) {
                str2 = "eventId is empty or events is null, eventId =";
            } else {
                if (this.f13548a.a(str)) {
                    sg.bigo.ads.core.d.b.b bVar = this.b;
                    if (bVar != null) {
                        bVar.a(str, map);
                        return;
                    }
                    return;
                }
                str2 = "not hit report eventId=";
            }
            sg.bigo.ads.common.t.a.a(0, "Stats", strConcat);
        }
        str2 = "mConfig is null, eventId =";
        strConcat = str2.concat(String.valueOf(str));
        sg.bigo.ads.common.t.a.a(0, "Stats", strConcat);
    }
}
