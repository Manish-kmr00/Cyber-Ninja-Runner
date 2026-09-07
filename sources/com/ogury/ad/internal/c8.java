package com.ogury.ad.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f7275a;
    public final String b;
    public final d0 c;
    public final m8 d;
    public final o1 e;
    public final q7 f;
    public final a9 g;
    public final n h;
    public final List<b4> i;

    public c8(Long l, String str, d0 d0Var, m8 m8Var, o1 o1Var, q7 q7Var, a9 a9Var, n nVar, List list) {
        this.f7275a = l;
        this.b = str;
        this.c = d0Var;
        this.d = m8Var;
        this.e = o1Var;
        this.f = q7Var;
        this.g = a9Var;
        this.h = nVar;
        this.i = list;
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        JSONObject jSONObject7;
        JSONObject jSONObject8;
        JSONObject jSONObject9;
        JSONObject jSONObject10;
        JSONObject jSONObject11;
        JSONObject jSONObject12;
        JSONObject jSONObject13;
        JSONObject jSONObject14;
        JSONObject jSONObject15;
        Intrinsics.checkNotNullParameter(this, "<this>");
        JSONObject jSONObject16 = new JSONObject();
        Long l = this.f7275a;
        if (l != null) {
            jSONObject16.put("sent_at", l.longValue());
        }
        d0 d0Var = this.c;
        JSONArray jSONArrayPut = null;
        if (d0Var != null) {
            Intrinsics.checkNotNullParameter(d0Var, "<this>");
            jSONObject = new JSONObject();
            f3.a(jSONObject, "asset_key", d0Var.f7277a);
            f3.a(jSONObject, "asset_type", d0Var.b);
            f3.a(jSONObject, "bundle_id", d0Var.c);
            f3.a(jSONObject, "version", d0Var.d);
            f3.a(jSONObject, "instance_token", d0Var.e);
        } else {
            jSONObject = null;
        }
        f3.a(jSONObject16, "app", jSONObject);
        m8 m8Var = this.d;
        if (m8Var != null) {
            Intrinsics.checkNotNullParameter(m8Var, "<this>");
            jSONObject2 = new JSONObject();
            f3.a(jSONObject2, "module_version", m8Var.f7358a);
        } else {
            jSONObject2 = null;
        }
        f3.a(jSONObject16, "sdk", jSONObject2);
        o1 o1Var = this.e;
        if (o1Var != null) {
            Intrinsics.checkNotNullParameter(o1Var, "<this>");
            jSONObject3 = new JSONObject();
            f3.a(jSONObject3, "os", o1Var.f7371a);
            f3.a(jSONObject3, CommonUrlParts.OS_VERSION, o1Var.b);
            f3.a(jSONObject3, CommonUrlParts.MANUFACTURER, o1Var.c);
            f3.a(jSONObject3, "model", o1Var.d);
            j8 j8Var = o1Var.e;
            if (j8Var != null) {
                jSONObject10 = new JSONObject();
                Integer num = j8Var.f7332a;
                if (num != null) {
                    jSONObject10.put("height", num.intValue());
                }
                Integer num2 = j8Var.b;
                if (num2 != null) {
                    jSONObject10.put("width", num2.intValue());
                }
                Float f = j8Var.c;
                if (f != null) {
                    jSONObject10.put("density", f);
                }
                f3.a(jSONObject10, "orientation", j8Var.d);
                f3.a(jSONObject10, "layout_size", j8Var.e);
                f3.a(jSONObject10, "ui_mode", j8Var.f);
            } else {
                jSONObject10 = null;
            }
            f3.a(jSONObject3, "screen", jSONObject10);
            o8 o8Var = o1Var.f;
            if (o8Var != null) {
                jSONObject11 = new JSONObject();
                f3.a(jSONObject11, "time_zone", o8Var.f7377a);
                t3 t3Var = o8Var.b;
                if (t3Var != null) {
                    jSONObject15 = new JSONObject();
                    f3.a(jSONObject15, "country", t3Var.f7404a);
                    f3.a(jSONObject15, POBConstants.KEY_LANGUAGE, t3Var.b);
                } else {
                    jSONObject15 = null;
                }
                f3.a(jSONObject11, CommonUrlParts.LOCALE, jSONObject15);
                f3.a(jSONObject11, "device_id", o8Var.c);
                Boolean bool = o8Var.d;
                if (bool != null) {
                    jSONObject11.put("is_ad_tracking_enabled", bool.booleanValue());
                }
            } else {
                jSONObject11 = null;
            }
            f3.a(jSONObject3, "settings", jSONObject11);
            z8 z8Var = o1Var.i;
            if (z8Var != null) {
                jSONObject12 = new JSONObject();
                f3.a(jSONObject12, "architecture", z8Var.f7476a);
                Boolean bool2 = z8Var.b;
                if (bool2 != null) {
                    jSONObject12.put("hpe_experience", bool2.booleanValue());
                }
            } else {
                jSONObject12 = null;
            }
            f3.a(jSONObject3, "system", jSONObject12);
            o5 o5Var = o1Var.g;
            if (o5Var != null) {
                jSONObject13 = new JSONObject();
                f3.a(jSONObject13, "mobile_country", o5Var.f7373a);
                f3.a(jSONObject13, "connectivity", o5Var.b);
            } else {
                jSONObject13 = null;
            }
            f3.a(jSONObject3, "network", jSONObject13);
            da daVar = o1Var.h;
            if (daVar != null) {
                jSONObject14 = new JSONObject();
                f3.a(jSONObject14, "user_agent", daVar.f7285a);
            } else {
                jSONObject14 = null;
            }
            f3.a(jSONObject3, com.ironsource.b9.h.K, jSONObject14);
        } else {
            jSONObject3 = null;
        }
        f3.a(jSONObject16, "device", jSONObject3);
        q7 q7Var = this.f;
        if (q7Var != null) {
            jSONObject4 = new JSONObject();
            f3.a(jSONObject4, "gpp", q7Var.b);
            f3.a(jSONObject4, "gpp_sid", q7Var.c);
            f3.a(jSONObject4, "tcf", q7Var.f7390a);
            Map<String, ?> map = q7Var.d;
            JSONObject jSONObject17 = new JSONObject();
            Intrinsics.checkNotNullParameter(jSONObject17, "<this>");
            if (map != null) {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    jSONObject17.putOpt(entry.getKey(), entry.getValue());
                }
            }
            f3.a(jSONObject4, "publisher_data", jSONObject17);
            Boolean bool3 = q7Var.e;
            if (bool3 != null) {
                jSONObject4.put("is_child_under_coppa", bool3.booleanValue());
            }
            Boolean bool4 = q7Var.f;
            if (bool4 != null) {
                jSONObject4.put("is_under_age_of_gdpr_consent", bool4.booleanValue());
            }
        } else {
            jSONObject4 = null;
        }
        f3.a(jSONObject16, "privacy_compliancy", jSONObject4);
        a9 a9Var = this.g;
        if (a9Var != null) {
            jSONObject5 = new JSONObject();
            f3.a(jSONObject5, "ad_content_threshold", a9Var.f7262a);
        } else {
            jSONObject5 = null;
        }
        f3.a(jSONObject16, "targeting", jSONObject5);
        f3.a(jSONObject16, "request_id", this.b);
        n nVar = this.h;
        if (nVar != null) {
            jSONObject6 = new JSONObject();
            f3.a(jSONObject6, "name", nVar.f7359a);
            f3.a(jSONObject6, "type", nVar.b);
            k kVar = nVar.c;
            f3.a(jSONObject6, Reporting.Key.CLICK_SOURCE_TYPE_AD, kVar != null ? f3.a(kVar) : null);
            w6 w6Var = nVar.d;
            if (w6Var != null) {
                jSONObject7 = new JSONObject();
                b7 b7Var = w6Var.f7431a;
                if (b7Var != null) {
                    jSONObject9 = new JSONObject();
                    Integer num3 = b7Var.b;
                    if (num3 != null) {
                        jSONObject9.put("width", num3.intValue());
                    }
                    Integer num4 = b7Var.f7269a;
                    if (num4 != null) {
                        jSONObject9.put("height", num4.intValue());
                    }
                    Float f2 = b7Var.c;
                    if (f2 != null) {
                        jSONObject9.put("scaler", f2);
                    }
                } else {
                    jSONObject9 = null;
                }
                f3.a(jSONObject7, "overlay_max_size", jSONObject9);
            } else {
                jSONObject7 = null;
            }
            f3.a(jSONObject6, "overlay", jSONObject7);
            e6 e6Var = nVar.e;
            if (e6Var != null) {
                jSONObject8 = new JSONObject();
                Boolean bool5 = e6Var.f7290a;
                if (bool5 != null) {
                    jSONObject8.put("is_compliant", bool5.booleanValue());
                }
                Integer num5 = e6Var.b;
                if (num5 != null) {
                    jSONObject8.put("integration_version", num5.intValue());
                }
            } else {
                jSONObject8 = null;
            }
            f3.a(jSONObject6, CampaignEx.KEY_OMID, jSONObject8);
        } else {
            jSONObject6 = null;
        }
        f3.a(jSONObject16, "ad_sync", jSONObject6);
        List<b4> list = this.i;
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = list.iterator();
            jSONArrayPut = jSONArray;
            while (it.hasNext()) {
                jSONArrayPut = jSONArrayPut.put(f3.a((b4) it.next()));
                Intrinsics.checkNotNullExpressionValue(jSONArrayPut, "put(...)");
            }
        }
        if (jSONArrayPut != null && jSONArrayPut.length() != 0) {
            jSONObject16.put("events", jSONArrayPut);
        }
        return jSONObject16;
    }
}
