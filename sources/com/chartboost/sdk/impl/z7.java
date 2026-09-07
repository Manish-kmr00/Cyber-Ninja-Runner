package com.chartboost.sdk.impl;

import android.os.Build;
import com.chartboost.sdk.privacy.model.DataUseConsent;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class z7 {
    public static Integer j;
    public static final String k = Build.VERSION.RELEASE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f1208a;
    public final JSONObject b;
    public final JSONArray c;
    public final JSONObject d;
    public final JSONObject e;
    public final JSONObject f;
    public final f9 g;
    public final o h;
    public final t7 i;

    public z7(f9 f9Var, o oVar, t7 t7Var) {
        j = f9Var.e();
        this.g = f9Var;
        this.h = oVar;
        this.i = t7Var;
        this.b = new JSONObject();
        this.c = new JSONArray();
        this.d = new JSONObject();
        this.e = new JSONObject();
        this.f = new JSONObject();
        this.f1208a = new JSONObject();
        q();
        n();
        o();
        m();
        p();
        r();
    }

    public final void q() {
        JSONObject jSONObject = this.f1208a;
        Object obj = JSONObject.NULL;
        z1.a(jSONObject, "id", obj);
        z1.a(this.f1208a, POBConstants.TEST_MODE, obj);
        z1.a(this.f1208a, "cur", new JSONArray().put("USD"));
        z1.a(this.f1208a, POBConstants.KEY_AT, 2);
    }

    public JSONObject h() {
        return this.f1208a;
    }

    public final void n() {
        r5 r5VarC = this.g.c();
        z1.a(this.b, POBConstants.KEY_DEVICE_TYPE, j);
        z1.a(this.b, "w", Integer.valueOf(this.g.b().getDeviceWidth()));
        z1.a(this.b, "h", Integer.valueOf(this.g.b().getDeviceHeight()));
        z1.a(this.b, POBConstants.KEY_IFA, r5VarC.getCom.ironsource.fe.Q0 java.lang.String());
        z1.a(this.b, "osv", k);
        z1.a(this.b, "lmt", Integer.valueOf(r5VarC.getTrackingState().getValue()));
        z1.a(this.b, "connectiontype", Integer.valueOf(i()));
        z1.a(this.b, "os", "Android");
        z1.a(this.b, "geo", a());
        z1.a(this.b, "ip", JSONObject.NULL);
        z1.a(this.b, POBConstants.KEY_LANGUAGE, this.g.d);
        z1.a(this.b, "ua", ab.b.a());
        z1.a(this.b, "make", this.g.k);
        z1.a(this.b, "model", this.g.f1016a);
        z1.a(this.b, "carrier", this.g.n);
        z1.a(this.b, "ext", a(r5VarC, this.i));
        z1.a(this.f1208a, "device", this.b);
    }

    public final void o() {
        JSONObject jSONObject = new JSONObject();
        Object obj = JSONObject.NULL;
        z1.a(jSONObject, "id", obj);
        JSONObject jSONObject2 = new JSONObject();
        z1.a(jSONObject2, "w", this.h.getWidth());
        z1.a(jSONObject2, "h", this.h.getHeight());
        z1.a(jSONObject2, "btype", obj);
        z1.a(jSONObject2, "battr", obj);
        z1.a(jSONObject2, POBConstants.KEY_POSITION, obj);
        z1.a(jSONObject2, "topframe", obj);
        z1.a(jSONObject2, "api", obj);
        JSONObject jSONObject3 = new JSONObject();
        z1.a(jSONObject3, "placementtype", j());
        z1.a(jSONObject3, "playableonly", obj);
        z1.a(jSONObject3, "allowscustomclosebutton", obj);
        z1.a(jSONObject2, "ext", jSONObject3);
        z1.a(jSONObject, "banner", jSONObject2);
        z1.a(jSONObject, POBConstants.KEY_INTERSTITIAL, l());
        z1.a(jSONObject, POBConstants.KEY_TAG_ID, this.h.getLocation());
        z1.a(jSONObject, POBConstants.KEY_DISPLAY_MANAGER, "Chartboost-Android-SDK");
        z1.a(jSONObject, POBConstants.KEY_DISPLAY_MANAGER_VERSION, this.g.g);
        z1.a(jSONObject, "bidfloor", obj);
        z1.a(jSONObject, "bidfloorcur", "USD");
        z1.a(jSONObject, POBConstants.KEY_SECURE, 1);
        this.c.put(jSONObject);
        z1.a(this.f1208a, POBConstants.KEY_IMPRESSION, this.c);
    }

    public final void m() {
        z1.a(this.d, "id", this.g.h);
        JSONObject jSONObject = this.d;
        Object obj = JSONObject.NULL;
        z1.a(jSONObject, "name", obj);
        z1.a(this.d, POBConstants.KEY_BUNDLE, this.g.f);
        z1.a(this.d, POBConstants.KEY_STORE_URL, obj);
        JSONObject jSONObject2 = new JSONObject();
        z1.a(jSONObject2, "id", obj);
        z1.a(jSONObject2, "name", obj);
        z1.a(this.d, "publisher", jSONObject2);
        z1.a(this.d, "cat", obj);
        z1.a(this.f1208a, "app", this.d);
    }

    public final void p() {
        Integer numB = b();
        if (numB != null) {
            z1.a(this.e, "coppa", numB);
        }
        JSONObject jSONObject = new JSONObject();
        z1.a(jSONObject, "gdpr", Integer.valueOf(e()));
        z1.a(jSONObject, "gpp", g());
        z1.a(jSONObject, "gpp_sid", f());
        for (DataUseConsent dataUseConsent : d()) {
            if (!dataUseConsent.getPrivacyStandardName().equals("coppa")) {
                z1.a(jSONObject, dataUseConsent.getPrivacyStandardName(), dataUseConsent.getConsent());
            }
        }
        z1.a(this.e, "ext", jSONObject);
        z1.a(this.f1208a, POBConstants.KEY_REGS, this.e);
    }

    public final void r() {
        z1.a(this.f, "id", JSONObject.NULL);
        z1.a(this.f, "geo", a());
        String strK = k();
        if (strK != null) {
            z1.a(this.f, "consent", strK);
        }
        JSONObject jSONObject = new JSONObject();
        z1.a(jSONObject, "consent", Integer.valueOf(c()));
        z1.a(jSONObject, POBConstants.KEY_IMP_DEPTH, Integer.valueOf(this.h.getImpDepth()));
        z1.a(this.f, "ext", jSONObject);
        z1.a(this.f1208a, POBConstants.KEY_USER, this.f);
    }

    public final JSONObject a(r5 r5Var, t7 t7Var) {
        JSONObject jSONObject = new JSONObject();
        if (r5Var.getSetId() != null) {
            z1.a(jSONObject, "appsetid", r5Var.getSetId());
        }
        if (r5Var.getSetIdScope() != null) {
            z1.a(jSONObject, "appsetidscope", r5Var.getSetIdScope());
        }
        f8 f8VarC = t7Var.c();
        if (t7Var.g() && f8VarC != null) {
            z1.a(jSONObject, "omidpn", f8VarC.a());
            z1.a(jSONObject, "omidpv", f8VarC.b());
        }
        return jSONObject;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        Object obj = JSONObject.NULL;
        z1.a(jSONObject, "lat", obj);
        z1.a(jSONObject, POBConstants.KEY_LONGITUDE, obj);
        z1.a(jSONObject, "country", this.g.c);
        z1.a(jSONObject, "type", 2);
        return jSONObject;
    }

    public final String j() {
        if (this.h.getCom.smaato.sdk.video.vast.model.Ad.AD_TYPE java.lang.String() == u.b.g) {
            b7.b("INTERSTITIAL NOT COMPATIBLE WITH OPENRTB", null);
        } else if (this.h.getCom.smaato.sdk.video.vast.model.Ad.AD_TYPE java.lang.String() == u.c.g) {
            b7.b("REWARDED_VIDEO NOT COMPATIBLE WITH OPENRTB", null);
        }
        return this.h.getCom.smaato.sdk.video.vast.model.Ad.AD_TYPE java.lang.String().getName().toLowerCase(Locale.ROOT);
    }

    public final Integer l() {
        return Integer.valueOf(this.h.getCom.smaato.sdk.video.vast.model.Ad.AD_TYPE java.lang.String().getIsFullScreen() ? 1 : 0);
    }

    public final Collection<DataUseConsent> d() {
        f9 f9Var = this.g;
        if (f9Var != null) {
            return f9Var.f().i();
        }
        return new ArrayList();
    }

    public final String k() {
        f9 f9Var = this.g;
        if (f9Var != null) {
            return f9Var.f().getTcfString();
        }
        return null;
    }

    public final String g() {
        f9 f9Var = this.g;
        if (f9Var != null) {
            return f9Var.f().getGppString();
        }
        return null;
    }

    public final String f() {
        f9 f9Var = this.g;
        if (f9Var != null) {
            return f9Var.f().getGppSid();
        }
        return null;
    }

    public final int c() {
        f9 f9Var = this.g;
        if (f9Var == null || f9Var.f().getOpenRtbConsent() == null) {
            return 0;
        }
        return this.g.f().getOpenRtbConsent().intValue();
    }

    public final int e() {
        f9 f9Var = this.g;
        if (f9Var == null || f9Var.f().getOpenRtbGdpr() == null) {
            return 0;
        }
        return this.g.f().getOpenRtbGdpr().intValue();
    }

    public final Integer b() {
        f9 f9Var = this.g;
        if (f9Var != null) {
            return f9Var.f().getOpenRtbCoppa();
        }
        return null;
    }

    public final int i() {
        return this.g.g().getOpenRTBConnectionType().getValue();
    }
}
