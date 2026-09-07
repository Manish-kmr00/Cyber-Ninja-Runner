package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import com.safedk.android.analytics.events.CrashEvent;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreutils.internal.parsing.RemoteConfigJsonUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class Al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ea f11063a;
    public final C4063da b;
    public final C4519vi c;
    public final C4341oe d;
    public final C4249km e;
    public final C4453t2 f;
    public final A3 g;
    public final C4403r2 h;
    public final C4313nb i;
    public final C4175hm j;
    public final C4414rd k;
    public final K9 l;

    public Al() {
        this(new C4313nb(), new Ea(), new C4063da(), new C4519vi(), new C4341oe(), new C4249km(), new A3(), new C4453t2(), new C4403r2(), new C4175hm(), new C4414rd(), new K9());
    }

    public final void a(Fl fl, C4263lb c4263lb) {
        long jOptLong;
        long jOptLong2;
        String string;
        ArrayList arrayListA;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        JSONObject jSONObjectOptJSONObject4 = c4263lb.optJSONObject("queries");
        if (jSONObjectOptJSONObject4 != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject4.optJSONObject("list")) != null && (jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("host")) != null) {
            fl.g = jSONObjectOptJSONObject3.optString("url", null);
        }
        Object jSONObject = new JSONObject();
        try {
            jSONObject = c4263lb.get("distribution_customization");
        } catch (Throwable unused) {
        }
        JSONObject jSONObjectOptJSONObject5 = ((JSONObject) jSONObject).optJSONObject("clids");
        if (jSONObjectOptJSONObject5 != null) {
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObjectOptJSONObject5.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject5.optJSONObject(next);
                if (jSONObjectOptJSONObject6 != null && jSONObjectOptJSONObject6.has("value")) {
                    map.put(next, jSONObjectOptJSONObject6.getString("value"));
                }
            }
            fl.j = AbstractC4199im.a((Map) map);
        }
        JSONObject jSONObjectOptJSONObject7 = c4263lb.optJSONObject(CommonUrlParts.LOCALE);
        String string2 = "";
        fl.m = (jSONObjectOptJSONObject7 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject7.optJSONObject("country")) == null || !jSONObjectOptJSONObject.optBoolean("reliable", false)) ? "" : jSONObjectOptJSONObject.optString("value", "");
        JSONObject jSONObjectOptJSONObject8 = c4263lb.optJSONObject("time");
        if (jSONObjectOptJSONObject8 != null) {
            try {
                fl.l = Long.valueOf(jSONObjectOptJSONObject8.getLong("max_valid_difference_seconds"));
            } catch (Throwable unused2) {
            }
        }
        Yl yl = new Yl();
        JSONObject jSONObjectOptJSONObject9 = c4263lb.optJSONObject("stat_sending");
        if (jSONObjectOptJSONObject9 != null) {
            yl.f11441a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(jSONObjectOptJSONObject9, "disabled_reporting_interval_seconds", yl.f11441a);
        }
        this.e.getClass();
        fl.p = new C4224jm(yl.f11441a);
        this.b.getClass();
        Ul ul = new Ul();
        try {
            Object jSONObject2 = new JSONObject();
            try {
                jSONObject2 = c4263lb.get("features");
            } catch (Throwable unused3) {
            }
            JSONObject jSONObjectOptJSONObject10 = ((JSONObject) jSONObject2).optJSONObject("list");
            if (jSONObjectOptJSONObject10 != null) {
                A4 a4 = new A4();
                a4.f11052a = C4063da.a(jSONObjectOptJSONObject10, "permissions_collecting", ul.f11382a);
                a4.b = C4063da.a(jSONObjectOptJSONObject10, "features_collecting", ul.b);
                a4.c = C4063da.a(jSONObjectOptJSONObject10, "google_aid", ul.c);
                a4.d = C4063da.a(jSONObjectOptJSONObject10, "sim_info", ul.d);
                a4.e = C4063da.a(jSONObjectOptJSONObject10, "huawei_oaid", ul.e);
                a4.f = jSONObjectOptJSONObject10.has("ssl_pinning") ? Boolean.valueOf(jSONObjectOptJSONObject10.getJSONObject("ssl_pinning").getBoolean("enabled")) : null;
                fl.b = new C4(a4);
            }
        } catch (Throwable unused4) {
        }
        this.f11063a.getClass();
        try {
            Object jSONObject3 = new JSONObject();
            try {
                jSONObject3 = c4263lb.get("query_hosts");
            } catch (Throwable unused5) {
            }
            JSONObject jSONObjectOptJSONObject11 = ((JSONObject) jSONObject3).optJSONObject("list");
            if (jSONObjectOptJSONObject11 != null) {
                try {
                    string = jSONObjectOptJSONObject11.getJSONObject("get_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused6) {
                    string = "";
                }
                if (!TextUtils.isEmpty(string)) {
                    fl.d = string;
                }
                ArrayList arrayListA2 = Ea.a(jSONObjectOptJSONObject11, CrashEvent.e);
                if (!In.a((Collection) arrayListA2)) {
                    fl.e = arrayListA2;
                }
                try {
                    string2 = jSONObjectOptJSONObject11.getJSONObject("report_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused7) {
                }
                if (!TextUtils.isEmpty(string2)) {
                    fl.f = string2;
                }
                ArrayList arrayListA3 = Ea.a(jSONObjectOptJSONObject11, "startup");
                if (!In.a((Collection) arrayListA3)) {
                    fl.c = arrayListA3;
                }
                ArrayList arrayListA4 = Ea.a(jSONObjectOptJSONObject11, "diagnostic");
                if (!In.a((Collection) arrayListA4)) {
                    fl.n = arrayListA4;
                }
                HashMap map2 = new HashMap();
                Iterator<String> itKeys2 = jSONObjectOptJSONObject11.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    if (!Ea.f11121a.contains(next2) && (arrayListA = Ea.a(jSONObjectOptJSONObject11, next2)) != null) {
                        map2.put(next2, arrayListA);
                    }
                }
                fl.o = map2;
            }
        } catch (Throwable unused8) {
        }
        this.c.getClass();
        Zl zl = new Zl();
        JSONObject jSONObjectOptJSONObject12 = c4263lb.optJSONObject("retry_policy");
        int iOptInt = zl.w;
        int iOptInt2 = zl.x;
        if (jSONObjectOptJSONObject12 != null) {
            iOptInt = jSONObjectOptJSONObject12.optInt("max_interval_seconds", iOptInt);
            iOptInt2 = jSONObjectOptJSONObject12.optInt("exponential_multiplier", zl.x);
        }
        fl.q = new RetryPolicyConfig(iOptInt, iOptInt2);
        this.d.getClass();
        if (fl.b.f11083a) {
            JSONObject jSONObjectOptJSONObject13 = c4263lb.optJSONObject("permissions_collecting");
            Wl wl = new Wl();
            if (jSONObjectOptJSONObject13 != null) {
                jOptLong = jSONObjectOptJSONObject13.optLong("check_interval_seconds", wl.f11408a);
                jOptLong2 = jSONObjectOptJSONObject13.optLong("force_send_interval_seconds", wl.b);
            } else {
                jOptLong = wl.f11408a;
                jOptLong2 = wl.b;
            }
            fl.k = new C4291me(jOptLong, jOptLong2);
        }
        C4428s2 c4428s2 = this.f.f11772a;
        Ql ql = new Ql();
        JSONObject jSONObjectOptJSONObject14 = c4263lb.optJSONObject("auto_inapp_collecting");
        if (jSONObjectOptJSONObject14 != null) {
            ql.f11318a = jSONObjectOptJSONObject14.optInt("send_frequency_seconds", ql.f11318a);
            ql.b = jSONObjectOptJSONObject14.optInt("first_collecting_inapp_max_age_seconds", ql.b);
        }
        c4428s2.getClass();
        fl.r = new BillingConfig(ql.f11318a, ql.b);
        A3 a3 = this.g;
        a3.getClass();
        Rl rl = new Rl();
        JSONObject jSONObjectOptJSONObject15 = c4263lb.optJSONObject("cache_control");
        if (jSONObjectOptJSONObject15 != null) {
            rl.f11336a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(jSONObjectOptJSONObject15, "last_known_location_ttl", rl.f11336a);
        }
        a3.f11051a.getClass();
        fl.s = new C4554x3(rl.f11336a);
        this.h.getClass();
        C4403r2.a(fl, c4263lb);
        C4175hm c4175hm = this.j;
        c4175hm.getClass();
        JSONObject jSONObjectOptJSONObject16 = c4263lb.optJSONObject("startup_update");
        Xl xl = new Xl();
        Integer numA = AbstractC4288mb.a(jSONObjectOptJSONObject16, "interval_seconds", null);
        if (numA != null) {
            xl.f11423a = numA.intValue();
        }
        c4175hm.f11589a.getClass();
        fl.u = new C4125fm(xl.f11423a);
        Map<String, C4066dd> mapC = this.k.f11749a.c();
        C4390qd c4390qd = new C4390qd(c4263lb);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, C4066dd> entry : mapC.entrySet()) {
            Object objInvoke = c4390qd.invoke(entry);
            if (objInvoke != null) {
                linkedHashMap.put(entry.getKey(), objInvoke);
            }
        }
        fl.v = linkedHashMap;
        J9 j9 = this.l.f11221a;
        Tl tl = new Tl();
        JSONObject jSONObjectOptJSONObject17 = c4263lb.optJSONObject("external_attribution");
        if (jSONObjectOptJSONObject17 != null) {
            tl.f11368a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(jSONObjectOptJSONObject17, "collecting_interval_seconds", tl.f11368a);
        }
        j9.getClass();
        fl.w = new I9(tl.f11368a);
    }

    public Al(C4313nb c4313nb, Ea ea, C4063da c4063da, C4519vi c4519vi, C4341oe c4341oe, C4249km c4249km, A3 a3, C4453t2 c4453t2, C4403r2 c4403r2, C4175hm c4175hm, C4414rd c4414rd, K9 k9) {
        this.f11063a = ea;
        this.b = c4063da;
        this.c = c4519vi;
        this.d = c4341oe;
        this.e = c4249km;
        this.g = a3;
        this.f = c4453t2;
        this.h = c4403r2;
        this.i = c4313nb;
        this.j = c4175hm;
        this.k = c4414rd;
        this.l = k9;
    }
}
