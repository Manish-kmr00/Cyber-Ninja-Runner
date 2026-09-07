package sg.bigo.ads.core.b;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class b {
    private static final b c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sg.bigo.ads.core.b.b.a f13513a;
    public final AtomicBoolean b = new AtomicBoolean(false);

    private b() {
    }

    public static b a() {
        return c;
    }

    public final void a(String str, Map<String, Object> map) {
        if (sg.bigo.ads.common.x.a.p()) {
            return;
        }
        if (!this.b.get()) {
            sg.bigo.ads.common.t.a.a(0, 3, "Callback", "please execute init first");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.putOpt(entry.getKey(), entry.getValue());
            }
        } catch (JSONException unused) {
        }
        this.f13513a.a(str, jSONObject);
    }
}
