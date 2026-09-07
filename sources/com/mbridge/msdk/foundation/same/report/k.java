package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.k0;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import org.json.JSONObject;

/* JADX INFO: compiled from: ReportUtilDiff.java */
/* JADX INFO: loaded from: classes11.dex */
public class k {
    public static JSONObject a(Context context, com.mbridge.msdk.setting.g gVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            String strP = k0.p();
            if (!TextUtils.isEmpty(strP)) {
                jSONObject.put(CommonUrlParts.MANUFACTURER, strP);
            }
            int iM = k0.m();
            if (iM != -1) {
                jSONObject.put("sdkint", iM);
            }
            String strX = k0.x(context);
            if (!TextUtils.isEmpty(strX)) {
                jSONObject.put("is24H", strX);
            }
            String strX2 = k0.x();
            if (!TextUtils.isEmpty(strX2)) {
                jSONObject.put("totalram", strX2);
            }
            String strY = k0.y(context);
            if (!TextUtils.isEmpty(strY)) {
                jSONObject.put("totalmemory", strY);
            }
            jSONObject.put("adid_limit", com.mbridge.msdk.foundation.tools.f.a() + "");
            jSONObject.put("adid_limit_dev", com.mbridge.msdk.foundation.controller.authoritycontroller.b.j() ? "1" : "0");
        }
        if (gVar.s0() == 1 && !TextUtils.isEmpty(com.mbridge.msdk.foundation.tools.f.e()) && com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            jSONObject.put("az_aid_info", com.mbridge.msdk.foundation.tools.f.e());
        }
        return jSONObject;
    }

    public static void a(com.mbridge.msdk.foundation.same.net.wrapper.e eVar, Context context) {
    }
}
