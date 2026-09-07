package sg.bigo.ads.api.core;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements sg.bigo.ads.api.a.e {
    public sg.bigo.ads.api.a.f[] e;
    public sg.bigo.ads.api.a.f f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f13108a = 0;
    public String b = "en";
    public String c = "";
    public String d = "";
    public String g = "";
    public String h = "";
    public int i = 0;
    public int j = 0;
    public sg.bigo.ads.api.a.e.b l = new sg.bigo.ads.api.a.e.b();
    public sg.bigo.ads.api.a.e.a m = new sg.bigo.ads.api.a.e.a();
    public sg.bigo.ads.api.a.e.c[] k = new sg.bigo.ads.api.a.e.c[0];

    private void a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new k(jSONObjectOptJSONObject));
                }
            }
            k[] kVarArr = new k[arrayList.size()];
            this.e = kVarArr;
            this.e = (sg.bigo.ads.api.a.f[]) arrayList.toArray(kVarArr);
        }
    }

    @Override // sg.bigo.ads.api.a.e
    public final String a() {
        return this.c;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f13108a = jSONObject.optLong("form_id", 0L);
            this.c = jSONObject.optString("title", "");
            this.b = jSONObject.optString("ad_lang", "en");
            this.d = jSONObject.optString("description", "");
            this.g = jSONObject.optString("purpose", "");
            this.i = jSONObject.optInt("color", 0);
            this.j = jSONObject.optInt("form_style_id", 0);
            this.h = jSONObject.optString("extra", "");
            a(jSONObject);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("icon");
            if (jSONObjectOptJSONObject != null) {
                this.f = new k(jSONObjectOptJSONObject);
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("questions");
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject2 != null) {
                        arrayList.add(new sg.bigo.ads.api.a.e.c(jSONObjectOptJSONObject2));
                    }
                }
                sg.bigo.ads.api.a.e.c[] cVarArr = new sg.bigo.ads.api.a.e.c[arrayList.size()];
                this.k = cVarArr;
                this.k = (sg.bigo.ads.api.a.e.c[]) arrayList.toArray(cVarArr);
            }
            sg.bigo.ads.api.a.e.b bVar = this.l;
            String strOptString = jSONObject.optString("privacy", "");
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    bVar.f13091a = jSONObject2.optString("name", "");
                    bVar.b = jSONObject2.optString("url", "");
                } catch (JSONException unused) {
                }
            }
            sg.bigo.ads.api.a.e.a aVar = this.m;
            String strOptString2 = jSONObject.optString("feedback", "");
            if (TextUtils.isEmpty(strOptString2)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(strOptString2);
            aVar.f13090a = jSONObject3.optString("title", "");
            aVar.b = jSONObject3.optString("description", "");
            aVar.c = jSONObject3.optString("cta", "");
            aVar.d = jSONObject3.optString("land_url", "");
        } catch (JSONException unused2) {
        }
    }

    @Override // sg.bigo.ads.api.a.e
    public final String b() {
        return this.d;
    }

    @Override // sg.bigo.ads.api.a.e
    public final long c() {
        return this.f13108a;
    }

    @Override // sg.bigo.ads.api.a.e
    public final int d() {
        return this.i;
    }

    @Override // sg.bigo.ads.api.a.e
    public final String e() {
        return this.b;
    }

    @Override // sg.bigo.ads.api.a.e
    public final int f() {
        return this.j;
    }

    @Override // sg.bigo.ads.api.a.e
    public final String g() {
        return this.h;
    }

    @Override // sg.bigo.ads.api.a.e
    public final String h() {
        return this.g;
    }

    @Override // sg.bigo.ads.api.a.e
    public final sg.bigo.ads.api.a.f[] i() {
        return this.e;
    }

    @Override // sg.bigo.ads.api.a.e
    public final sg.bigo.ads.api.a.f j() {
        sg.bigo.ads.api.a.f[] fVarArr = this.e;
        if (fVarArr == null || fVarArr.length <= 0) {
            return null;
        }
        return fVarArr[0];
    }

    @Override // sg.bigo.ads.api.a.e
    public final sg.bigo.ads.api.a.f k() {
        return this.f;
    }

    @Override // sg.bigo.ads.api.a.e
    public final sg.bigo.ads.api.a.e.b l() {
        return this.l;
    }

    @Override // sg.bigo.ads.api.a.e
    public final sg.bigo.ads.api.a.e.c[] m() {
        return this.k;
    }

    @Override // sg.bigo.ads.api.a.e
    public final sg.bigo.ads.api.a.e.a n() {
        return this.m;
    }
}
