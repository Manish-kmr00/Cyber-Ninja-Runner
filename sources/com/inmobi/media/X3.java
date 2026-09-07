package com.inmobi.media;

import android.content.Context;
import android.content.SharedPreferences;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.RootConfig;
import com.inmobi.sdk.InMobiSdk;
import io.bidmachine.IABSharedPreference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class X3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final X3 f3234a = new X3();
    public static JSONObject b;
    public static JSONObject c;
    public static JSONObject d;
    public static RootConfig e;

    public static final JSONObject c() {
        String string;
        int i;
        JSONObject jSONObject;
        String string2;
        String string3;
        Context contextD = C3517pb.d();
        SharedPreferences sharedPreferences = contextD != null ? contextD.getSharedPreferences((contextD != null ? contextD.getPackageName() : null) + "_preferences", 0) : null;
        if (sharedPreferences != null) {
            try {
                Intrinsics.checkNotNullExpressionValue("X3", "TAG");
                string = sharedPreferences.getString("IABTCF_TCString", null);
                try {
                    i = sharedPreferences.getInt("IABTCF_gdprApplies", -1);
                } catch (Exception unused) {
                    i = -1;
                }
            } catch (Exception unused2) {
                string = null;
            }
            if (string != null) {
                try {
                    jSONObject = new JSONObject();
                    jSONObject.put(InMobiSdk.IM_GDPR_CONSENT_IAB, string);
                    if (i != -1) {
                        jSONObject.put("gdpr", String.valueOf(i));
                    }
                } catch (JSONException unused3) {
                    jSONObject = null;
                }
            } else {
                jSONObject = null;
            }
            if (jSONObject == null) {
                try {
                    Intrinsics.checkNotNullExpressionValue("X3", "TAG");
                    string2 = sharedPreferences.getString(IABSharedPreference.IAB_CONSENT_STRING, null);
                    try {
                        string3 = sharedPreferences.getString(IABSharedPreference.IAB_SUBJECT_TO_GDPR, null);
                    } catch (Exception unused4) {
                        string3 = null;
                    }
                } catch (Exception unused5) {
                    string2 = null;
                }
                if (string2 != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(InMobiSdk.IM_GDPR_CONSENT_IAB, string2);
                        if (string3 != null) {
                            jSONObject2.put("gdpr", string3);
                        }
                        jSONObject = jSONObject2;
                    } catch (JSONException unused6) {
                        jSONObject = null;
                    }
                } else {
                    jSONObject = null;
                }
            }
            if (jSONObject != null) {
                return jSONObject;
            }
        }
        JSONObject jSONObject3 = c;
        if (jSONObject3 == null) {
            return b;
        }
        if (b != null) {
            jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = c;
            Iterator<String> itKeys = jSONObject4 != null ? jSONObject4.keys() : null;
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        JSONObject jSONObject5 = c;
                        jSONObject3.put(next, jSONObject5 != null ? jSONObject5.opt(next) : null);
                    } catch (JSONException unused7) {
                    }
                }
            }
            JSONObject jSONObject6 = b;
            Iterator<String> itKeys2 = jSONObject6 != null ? jSONObject6.keys() : null;
            if (itKeys2 != null) {
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    try {
                        JSONObject jSONObject7 = b;
                        jSONObject3.put(next2, jSONObject7 != null ? jSONObject7.opt(next2) : null);
                    } catch (JSONException unused8) {
                    }
                }
            }
        }
        return jSONObject3;
    }

    @JvmStatic
    public static /* synthetic */ void d() {
    }

    public static final byte e() {
        JSONObject jSONObjectC = c();
        if (jSONObjectC == null) {
            return (byte) -1;
        }
        if (jSONObjectC.has(InMobiSdk.IM_GDPR_CONSENT_IAB)) {
            return (byte) 1;
        }
        if (!jSONObjectC.has(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE)) {
            return (byte) -1;
        }
        try {
            return jSONObjectC.getBoolean(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE) ? (byte) 1 : (byte) 0;
        } catch (JSONException unused) {
            return (byte) -1;
        }
    }

    @JvmStatic
    public static /* synthetic */ void f() {
    }

    @JvmStatic
    public static final void h() {
        HashMap map = AbstractC3351e3.f3298a;
        Config configA = AbstractC3351e3.a(C3517pb.b(), "root");
        Intrinsics.checkNotNull(configA, "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig");
        e = (RootConfig) configA;
    }

    @JvmStatic
    public static final void i() {
        b = null;
        c = null;
        d = null;
        e = null;
    }

    public final void a(JSONObject jSONObject) {
        d = jSONObject;
    }

    public final JSONObject b() {
        return d;
    }

    public final JSONObject g() {
        return b;
    }

    public final void j() {
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        e = (RootConfig) B4.a("root", "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig", null);
    }

    public static /* synthetic */ boolean a(X3 x3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return x3.a(z);
    }

    public static final void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            b = jSONObject;
        }
    }

    public final boolean a(boolean z) {
        if (e == null) {
            j();
        }
        byte bE = e();
        RootConfig rootConfig = e;
        return bE == 1 || Intrinsics.areEqual(rootConfig != null ? Boolean.valueOf(rootConfig.shouldTransmitRequest()) : null, Boolean.TRUE) || z;
    }

    public final boolean a() {
        return a(this, false, 1, null);
    }

    @JvmStatic
    public static final void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            c = jSONObject;
        }
    }
}
