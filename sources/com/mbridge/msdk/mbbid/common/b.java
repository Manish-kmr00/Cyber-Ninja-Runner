package com.mbridge.msdk.mbbid.common;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.e0;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.r0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.v0;
import com.mbridge.msdk.mbbid.out.BidConstants;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import com.safedk.android.analytics.brandsafety.l;
import com.smaato.sdk.video.vast.model.Ad;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: BidCommon.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, String> f5175a = new HashMap();
    public static JSONArray b;

    public static String a(Context context, String str) {
        HashMap map = new HashMap();
        map.put(BidConstants.BID_FILTER_KEY_UNIT_ID, str);
        return a(context, map);
    }

    public static boolean b(Context context, String str) {
        int i;
        int i2;
        int i3;
        int i4;
        JSONArray jSONArray = b;
        int i5 = 2;
        if (jSONArray == null || jSONArray.length() == 0) {
            a(str, 2);
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        int i6 = 0;
        while (true) {
            try {
                if (i6 >= b.length()) {
                    i2 = 0;
                    i = 0;
                    break;
                }
                JSONObject jSONObjectOptJSONObject = b.optJSONObject(i6);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("key_tpl");
                    String strOptString2 = jSONObjectOptJSONObject.optString("key_value");
                    long jLongValue = ((Long) v0.a(context, strOptString2, 0L)).longValue();
                    if (a(strOptString, strOptString2)) {
                        try {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            try {
                                if (jLongValue <= 0 || jCurrentTimeMillis - jLongValue >= ((long) jSONObjectOptJSONObject.optInt("ttl")) * 1000) {
                                    a(context, strOptString2, jCurrentTimeMillis);
                                    i2 = 0;
                                    i4 = 1;
                                } else {
                                    try {
                                        double dOptDouble = jSONObjectOptJSONObject.optDouble("rate");
                                        i2 = (dOptDouble == 0.0d || dOptDouble * 100.0d < ((double) new Random().nextInt(100))) ? 2 : 1;
                                        i5 = i2;
                                        i4 = 2;
                                    } catch (Exception e) {
                                        e = e;
                                        i3 = 2;
                                        i = i3;
                                        jSONObject = jSONObjectOptJSONObject;
                                        if (MBridgeConstans.DEBUG) {
                                            o0.b("BidCommon", e.getMessage());
                                        }
                                        i2 = 0;
                                    }
                                }
                                i = i4;
                                jSONObject = jSONObjectOptJSONObject;
                                break;
                            } catch (Exception e2) {
                                e = e2;
                                i3 = 1;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            i3 = 0;
                        }
                    }
                }
                i6++;
            } catch (Exception e4) {
                e = e4;
                i = 0;
            }
        }
        a(i5, jSONObject, i, i2);
        a(str, i5);
        return i5 == 1;
    }

    public static String a(Context context, Map<String, String> map) {
        String md5;
        String str;
        f5175a = map;
        try {
            if (com.mbridge.msdk.foundation.controller.c.m().d() == null) {
                com.mbridge.msdk.foundation.controller.c.m().b(context);
            }
            if (b == null) {
                b = h.b().b(com.mbridge.msdk.foundation.controller.c.m().b()).i0();
            }
            md5 = SameMD5.getMD5(t0.d());
            try {
                if (b(context, md5)) {
                    return "";
                }
                Map<String, String> map2 = f5175a;
                if (map2 == null || !map2.containsKey(BidConstants.BID_FILTER_KEY_UNIT_ID)) {
                    str = "";
                } else {
                    str = f5175a.get(BidConstants.BID_FILTER_KEY_UNIT_ID);
                }
                return a(context, str, md5);
            } catch (Exception unused) {
                return a(context, "", md5);
            }
        } catch (Exception unused2) {
            md5 = "";
        }
    }

    public static String a(Context context, String str, String str2) {
        long jA;
        StringBuffer stringBuffer = new StringBuffer();
        if (context != null) {
            try {
                if (com.mbridge.msdk.foundation.controller.c.m().d() == null) {
                    com.mbridge.msdk.foundation.controller.c.m().b(context);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("BidCommon", e.getMessage());
                }
            }
        }
        g gVarD = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (gVarD == null) {
            gVarD = h.b().a();
        }
        stringBuffer.append(f.d()).append(l.ad);
        stringBuffer.append(a.a(1, gVarD, context)).append(l.ad);
        stringBuffer.append(a.a(2, gVarD, context)).append(l.ad);
        stringBuffer.append(l.ad);
        stringBuffer.append(l.ad);
        stringBuffer.append(k0.s()).append(l.ad);
        stringBuffer.append(k0.t()).append(l.ad);
        stringBuffer.append(k0.s(context)).append(l.ad);
        stringBuffer.append(MBConfiguration.SDK_VERSION).append(l.ad);
        stringBuffer.append(k0.n(context)).append(VastAttributes.HORIZONTAL_POSITION).append(k0.m(context)).append(l.ad);
        stringBuffer.append(k0.i()).append(l.ad);
        stringBuffer.append(a.a(3, gVarD, context)).append(l.ad);
        stringBuffer.append(t0.b(20)).append(l.ad);
        stringBuffer.append(System.currentTimeMillis()).append(l.ad);
        stringBuffer.append(com.mbridge.msdk.foundation.same.a.d).append(l.ad);
        stringBuffer.append(k0.v()).append(l.ad);
        stringBuffer.append(k0.h()).append(l.ad);
        stringBuffer.append(a.a(4, gVarD, context)).append(l.ad);
        stringBuffer.append(a.a(5, gVarD, context)).append(l.ad);
        stringBuffer.append(a.a(6, gVarD, context)).append(l.ad);
        stringBuffer.append(r0.c()).append(l.ad);
        stringBuffer.append(r0.a()).append(l.ad);
        try {
            jA = j0.a();
        } catch (Exception unused) {
            jA = 0;
        }
        if (jA > 0) {
            stringBuffer.append(jA).append(l.ad);
        } else {
            stringBuffer.append("").append(l.ad);
        }
        stringBuffer.append(l.ad);
        stringBuffer.append(l.ad);
        stringBuffer.append(com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)).append(l.ad);
        stringBuffer.append(com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM));
        stringBuffer.append(l.ad).append(k0.j());
        stringBuffer.append(l.ad).append(gVarD != null ? gVarD.a() : "");
        stringBuffer.append(l.ad);
        stringBuffer.append(t0.a());
        stringBuffer.append(l.ad);
        String strC = t0.c();
        if (TextUtils.isEmpty(strC)) {
            strC = "";
        }
        stringBuffer.append(strC);
        stringBuffer.append(l.ad);
        stringBuffer.append(t0.c(str));
        stringBuffer.append(l.ad);
        if (gVarD != null && gVarD.s0() == 1 && com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            stringBuffer.append(a.a(7, gVarD, context));
        }
        stringBuffer.append(l.ad);
        stringBuffer.append(k0.D());
        stringBuffer.append(l.ad);
        stringBuffer.append(k0.D(context));
        stringBuffer.append(l.ad);
        stringBuffer.append(k0.B() + "");
        stringBuffer.append(l.ad);
        stringBuffer.append(k0.e(com.mbridge.msdk.foundation.controller.c.m().i()) + "");
        stringBuffer.append(l.ad);
        stringBuffer.append(k0.C());
        stringBuffer.append(l.ad);
        stringBuffer.append(com.mbridge.msdk.foundation.controller.authoritycontroller.b.i() ? "1" : "2");
        stringBuffer.append(l.ad);
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            stringBuffer.append(a.a(8, gVarD, context));
        }
        stringBuffer.append(l.ad).append("");
        stringBuffer.append(l.ad).append("");
        stringBuffer.append(l.ad).append("");
        stringBuffer.append(l.ad).append("1");
        stringBuffer.append(l.ad).append(com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c());
        stringBuffer.append(l.ad);
        if (k0.y() != 0) {
            stringBuffer.append(k0.y() + "");
        }
        if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
            stringBuffer.append(l.ad).append(1);
        } else {
            stringBuffer.append(l.ad).append("");
        }
        stringBuffer.append(l.ad).append("");
        stringBuffer.append(l.ad).append(str2);
        stringBuffer.append(l.ad).append(k0.r(context));
        stringBuffer.append(l.ad).append(k0.q(context));
        stringBuffer.append(l.ad).append(f.e());
        stringBuffer.append(l.ad).append(f.a());
        stringBuffer.append(l.ad).append(com.mbridge.msdk.util.c.b);
        stringBuffer.append(l.ad).append("");
        stringBuffer.append(l.ad).append(e0.a().b());
        stringBuffer.append(l.ad).append(k0.k(context));
        stringBuffer.append(l.ad).append(k0.u(context));
        stringBuffer.append(l.ad).append(k0.o(context));
        return i0.b(stringBuffer.toString());
    }

    public static void a(Context context, String str, long j) {
        v0.b(context, str, Long.valueOf(j));
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        for (String str3 : str.split("-")) {
            if (!TextUtils.isEmpty(str3) && str3.length() > 2 && str3.startsWith("{") && str3.endsWith("}")) {
                String strSubstring = str3.substring(1, str3.length() - 1);
                Map<String, String> map = f5175a;
                if (map != null && map.containsKey(strSubstring)) {
                    String strValueOf = String.valueOf(f5175a.get(strSubstring));
                    if (!TextUtils.isEmpty(strValueOf)) {
                        str = str.replace(str3, strValueOf + "");
                    }
                } else if (BidConstants.BID_FILTER_KEY_NETWORK.equals(str3)) {
                    str = str.replace(str3, k0.s(com.mbridge.msdk.foundation.controller.c.m().d()) + "");
                }
            }
        }
        return str.equals(str2);
    }

    private static void a(int i, JSONObject jSONObject, int i2, int i3) {
        try {
            Context contextD = com.mbridge.msdk.foundation.controller.c.m().d();
            if (contextD != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("key", "2000122");
                jSONObject2.put("filter", i);
                jSONObject2.put("network_type", k0.s(contextD));
                jSONObject2.put("timeout", i2);
                if (jSONObject != null && jSONObject.length() > 0) {
                    jSONObject2.put("hitNode", jSONObject);
                }
                jSONObject2.put("hitRate", i3);
                Map<String, String> map = f5175a;
                if (map != null) {
                    if (map.containsKey(BidConstants.BID_FILTER_KEY_UNIT_ID)) {
                        jSONObject2.put(MBridgeConstans.PROPERTIES_UNIT_ID, f5175a.get(BidConstants.BID_FILTER_KEY_UNIT_ID));
                    }
                    if (f5175a.containsKey(BidConstants.BID_FILTER_KEY_PLACEMENT_ID)) {
                        jSONObject2.put("placementId", f5175a.get(BidConstants.BID_FILTER_KEY_PLACEMENT_ID));
                    }
                    if (f5175a.containsKey(BidConstants.BID_FILTER_KEY_AD_TYPE)) {
                        jSONObject2.put(Ad.AD_TYPE, f5175a.get(BidConstants.BID_FILTER_KEY_AD_TYPE));
                    }
                }
                d.b().a(jSONObject2);
            }
        } catch (Throwable th) {
            o0.b("BidCommon", th.getMessage());
        }
    }

    private static void a(String str, int i) {
        e eVar = new e();
        eVar.a("filter", Integer.valueOf(i));
        eVar.a("lrid", str);
        d.b().b("2000124", eVar);
    }
}
