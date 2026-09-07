package sg.bigo.ads.controller.c;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class n implements sg.bigo.ads.api.core.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f13425a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String[] g;
    String[] h;
    String i;

    public n(JSONObject jSONObject) {
        this.f13425a = jSONObject.optString("icon");
        this.b = jSONObject.optString("title");
        this.c = jSONObject.optString("rate");
        this.d = jSONObject.optString("comments");
        this.e = jSONObject.optString("downloads");
        this.f = jSONObject.optString("description");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("genre");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            this.g = new String[jSONArrayOptJSONArray.length()];
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                this.g[i] = jSONArrayOptJSONArray.optString(i);
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("img");
        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
            this.h = new String[jSONArrayOptJSONArray2.length()];
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                this.h[i2] = jSONArrayOptJSONArray2.optString(i2);
            }
        }
        this.i = jSONObject.optString("name");
    }

    @Override // sg.bigo.ads.api.core.c.d
    public final String a() {
        return this.f13425a;
    }

    @Override // sg.bigo.ads.api.core.c.d
    public final String b() {
        return this.b;
    }

    @Override // sg.bigo.ads.api.core.c.d
    public final String c() {
        return this.f;
    }

    @Override // sg.bigo.ads.api.core.c.d
    public final String[] d() {
        return this.g;
    }

    @Override // sg.bigo.ads.api.core.c.d
    public final String[] e() {
        return this.h;
    }

    @Override // sg.bigo.ads.api.core.c.d
    public final String f() {
        return this.i;
    }
}
