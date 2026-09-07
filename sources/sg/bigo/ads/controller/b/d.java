package sg.bigo.ads.controller.b;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.core.r;

/* JADX INFO: loaded from: classes11.dex */
public final class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f13404a;
    public final sg.bigo.ads.common.h.a.a e;
    public final sg.bigo.ads.core.d.a.a f;
    public final sg.bigo.ads.core.b.a.a g;

    public d(Context context) {
        super(context);
        this.f13404a = new r();
        this.e = new sg.bigo.ads.common.h.a.a();
        this.f = new sg.bigo.ads.core.d.a.a();
        this.g = new sg.bigo.ads.core.b.a.a();
    }

    @Override // sg.bigo.ads.common.e
    public final void a(Context context) {
        super.a(context);
        if (!TextUtils.isEmpty(this.w)) {
            try {
                d(new JSONObject(this.w));
            } catch (JSONException unused) {
            }
        }
        if (!TextUtils.isEmpty(this.v)) {
            try {
                a(new JSONObject(this.v));
            } catch (JSONException unused2) {
            }
        }
        if (!TextUtils.isEmpty(this.u)) {
            try {
                b(new JSONObject(this.u));
            } catch (JSONException unused3) {
            }
        }
        if (TextUtils.isEmpty(this.x)) {
            return;
        }
        try {
            c(new JSONObject(this.x));
        } catch (JSONException unused4) {
        }
    }

    @Override // sg.bigo.ads.controller.b.e
    protected final void a(JSONObject jSONObject) {
        this.f13404a.a(jSONObject);
    }

    @Override // sg.bigo.ads.common.e
    public final String b() {
        return "GlobalConfigData";
    }

    @Override // sg.bigo.ads.controller.b.e
    protected final void b(JSONObject jSONObject) {
        this.e.a(jSONObject);
    }

    @Override // sg.bigo.ads.controller.b.e
    protected final void c(JSONObject jSONObject) {
        this.f.a(jSONObject);
    }

    @Override // sg.bigo.ads.controller.b.e
    protected final void d(JSONObject jSONObject) {
        this.g.a(jSONObject);
    }

    @Override // sg.bigo.ads.api.a.h
    public final r m() {
        return this.f13404a;
    }

    public final String toString() {
        return "GlobalConfigData{huaweiAdIdInfo=" + this.h + ", googleAdIdInfo=" + this.i + ", location=" + this.j + ", state=" + this.m + ", configId=" + this.n + ", interval=" + this.o + ", token='" + this.p + "', antiBan='" + this.q + "', strategy=" + this.r + ", abflags='" + this.s + "', country='" + this.t + "', creatives='" + this.u + "', trackConfig='" + this.v + "', callbackConfig='" + this.w + "', reportConfig='" + this.x + "', appCheckConfig='" + this.y + "', uid='" + this.z + "', maxRequestNum=" + this.A + ", negFeedbackState=" + this.B + ", omUrl='" + this.C + "', globalSwitch=" + this.E.f13111a + ", bannerJsUrl='" + this.D + "', reqCountry='" + this.L + "', appFlag='" + this.N + "'}";
    }
}
