package com.json;

import android.content.Context;
import android.text.TextUtils;
import com.json.mediationsdk.logger.IronLog;
import com.json.sdk.utils.IronSourceStorageUtils;
import com.json.sdk.utils.Logger;
import com.json.sdk.utils.SDKUtils;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class ya {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4615a = "ya";

    public static JSONObject a(Context context) {
        SDKUtils.loadGoogleAdvertiserInfo(context);
        String advertiserId = SDKUtils.getAdvertiserId();
        String limitAdTracking = SDKUtils.getLimitAdTracking();
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        try {
            if (!TextUtils.isEmpty(advertiserId)) {
                Logger.i(f4615a, "add AID");
                jSONObjectJsonObjectInit.put("deviceIds[AID]", SDKUtils.encodeString(advertiserId));
            }
            if (!TextUtils.isEmpty(limitAdTracking)) {
                Logger.i(f4615a, "add LAT");
                jSONObjectJsonObjectInit.put(b9.i.M, Boolean.parseBoolean(limitAdTracking));
            }
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return jSONObjectJsonObjectInit;
    }

    private static void a(Context context, JSONObject jSONObject) {
        nf nfVarF = mm.S().f();
        try {
            if (a(b9.i.m0)) {
                jSONObject.put(SDKUtils.encodeString(b9.i.m0), nfVarF.c(context));
            }
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void a(JSONObject jSONObject) {
        nf nfVarF = mm.S().f();
        try {
            a(jSONObject, b9.i.H, String.valueOf(nfVarF.d()));
            a(jSONObject, b9.i.I, String.valueOf(nfVarF.k()));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void a(JSONObject jSONObject, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            jSONObject.put(str, SDKUtils.encodeString(str2));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static boolean a(String str) {
        return SDKUtils.getControllerConfigAsJSONObject().optBoolean(str);
    }

    public static JSONObject b(Context context) {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        a(jSONObjectJsonObjectInit);
        d(context, jSONObjectJsonObjectInit);
        c(jSONObjectJsonObjectInit);
        b(context, jSONObjectJsonObjectInit);
        g(context, jSONObjectJsonObjectInit);
        e(context, jSONObjectJsonObjectInit);
        b(jSONObjectJsonObjectInit);
        f(context, jSONObjectJsonObjectInit);
        c(context, jSONObjectJsonObjectInit);
        a(context, jSONObjectJsonObjectInit);
        h(context, jSONObjectJsonObjectInit);
        return jSONObjectJsonObjectInit;
    }

    private static void b(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString(b9.i.Y), mm.S().f().y(context));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void b(JSONObject jSONObject) {
        nf nfVarF = mm.S().f();
        try {
            if (a(b9.i.i0)) {
                jSONObject.put(SDKUtils.encodeString(b9.i.i0), nfVarF.c());
            }
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public static JSONObject c(Context context) {
        nf nfVarF = mm.S().f();
        za zaVarB = za.b(context);
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        try {
            String strD = zaVarB.d();
            if (strD != null) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.k), SDKUtils.encodeString(strD));
            }
            String strC = zaVarB.c();
            if (strC != null) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.l), SDKUtils.encodeString(strC));
            }
            String strE = zaVarB.e();
            if (strE != null) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.m), SDKUtils.encodeString(strE));
            }
            String strF = zaVarB.f();
            if (strF != null) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.n), strF.replaceAll("[^0-9/.]", ""));
            }
            String strF2 = zaVarB.f();
            if (strF2 != null) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.o), SDKUtils.encodeString(strF2));
            }
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.p), String.valueOf(zaVarB.a()));
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.q), SDKUtils.encodeString(SDKUtils.getSDKVersion()));
            if (zaVarB.b() != null && zaVarB.b().length() > 0) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.r), SDKUtils.encodeString(zaVarB.b()));
            }
            String language = context.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.x), SDKUtils.encodeString(language.toUpperCase(Locale.getDefault())));
            }
            if (a(b9.i.j0)) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.j0), SDKUtils.encodeString(String.valueOf(nfVarF.h(context))));
            }
            String strG = c4.g(context);
            if (!TextUtils.isEmpty(strG)) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString("bundleId"), SDKUtils.encodeString(strG));
            }
            String strValueOf = String.valueOf(nfVarF.h());
            if (!TextUtils.isEmpty(strValueOf)) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.K), SDKUtils.encodeString(strValueOf));
            }
            String strValueOf2 = String.valueOf(nfVarF.f());
            if (!TextUtils.isEmpty(strValueOf2)) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.O), SDKUtils.encodeString(strValueOf2));
            }
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString("gpi"), dp.d(context));
            jSONObjectJsonObjectInit.put("mcc", x8.b(context));
            jSONObjectJsonObjectInit.put("mnc", x8.c(context));
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.S), x8.f(context));
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.R), SDKUtils.encodeString(x8.g(context)));
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.V), c4.f(context));
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.X), c4.d(context));
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString("appVersion"), SDKUtils.encodeString(c4.b(context)));
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString("stid"), dp.c(context));
            String strE2 = c4.e(context);
            if (!TextUtils.isEmpty(strE2)) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.c0), SDKUtils.encodeString(strE2));
            }
            jSONObjectJsonObjectInit.put(b9.i.d0, SDKUtils.encodeString(String.valueOf(nfVarF.j())));
            jSONObjectJsonObjectInit.put(b9.i.e0, SDKUtils.encodeString(String.valueOf(nfVarF.q())));
            String strN = nfVarF.n(context);
            if (!TextUtils.isEmpty(strN)) {
                jSONObjectJsonObjectInit.put("icc", strN);
            }
            String strB = nfVarF.b();
            if (!TextUtils.isEmpty(strB)) {
                jSONObjectJsonObjectInit.put("tz", SDKUtils.encodeString(strB));
            }
            jSONObjectJsonObjectInit.put("uxt", IronSourceStorageUtils.isUxt());
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return jSONObjectJsonObjectInit;
    }

    private static void c(Context context, JSONObject jSONObject) {
        nf nfVarF = mm.S().f();
        try {
            if (a(b9.i.l0)) {
                jSONObject.put(SDKUtils.encodeString(b9.i.l0), nfVarF.l(context));
            }
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void c(JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString(b9.i.y), SDKUtils.encodeString(String.valueOf(mm.S().f().o())));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void d(Context context, JSONObject jSONObject) {
        try {
            String strB = y8.b(context);
            String strD = y8.d(context);
            if (!TextUtils.isEmpty(strD)) {
                jSONObject.put(SDKUtils.encodeString(b9.i.u), SDKUtils.encodeString(strD));
            }
            if (!TextUtils.isEmpty(strB) && !strB.equals("none")) {
                jSONObject.put(SDKUtils.encodeString(b9.i.t), SDKUtils.encodeString(strB));
            }
            jSONObject.put(SDKUtils.encodeString(b9.i.v), y8.e(context));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void e(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString(b9.i.P), za.b(context).a(context));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void f(Context context, JSONObject jSONObject) {
        nf nfVarF = mm.S().f();
        try {
            if (a(b9.i.k0)) {
                jSONObject.put(SDKUtils.encodeString(b9.i.k0), nfVarF.J(context));
            }
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void g(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString(fe.U0), mm.S().f().q(context));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void h(Context context, JSONObject jSONObject) {
        nf nfVarF = mm.S().f();
        try {
            if (a(b9.i.n0)) {
                jSONObject.put(SDKUtils.encodeString(b9.i.n0), nfVarF.d(context));
            }
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }
}
