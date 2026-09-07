package sg.bigo.ads.controller.c;

import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class p implements sg.bigo.ads.api.core.c.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f13427a;
    private final int b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final int g;
    private final String[] h;
    private final String[] i;

    public p(JSONObject jSONObject) {
        this.f13427a = jSONObject;
        this.b = jSONObject.optInt("type", 0);
        this.c = jSONObject.optString("value", "");
        this.d = jSONObject.optString("name", "");
        this.e = jSONObject.optString(CommonUrlParts.UUID, "");
        this.f = jSONObject.optInt("replace", 0);
        this.g = jSONObject.optInt("norepeat", 0);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("reg");
        if (jSONArrayOptJSONArray == null) {
            this.h = new String[0];
            this.i = new String[0];
            return;
        }
        this.h = new String[jSONArrayOptJSONArray.length()];
        this.i = new String[jSONArrayOptJSONArray.length()];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                this.h[i] = jSONObjectOptJSONObject.optString("token", "");
                this.i[i] = jSONObjectOptJSONObject.optString("value", "");
            }
        }
    }

    @Override // sg.bigo.ads.api.core.c.f
    public final JSONObject a() {
        return this.f13427a;
    }
}
