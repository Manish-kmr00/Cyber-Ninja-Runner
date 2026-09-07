package com.mbridge.msdk.out.reveue;

import android.content.Context;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.same.report.metrics.e;

/* JADX INFO: loaded from: classes9.dex */
public class MBridgeRevenueManager {
    public static void track(Context context, MBridgeRevenueParamsEntity mBridgeRevenueParamsEntity) {
        if (c.m().d() == null) {
            c.m().b(context);
        }
        try {
            e eVar = new e();
            eVar.a("name", mBridgeRevenueParamsEntity.getMediationName());
            com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
            cVar.a("m_start_ad_rev", eVar);
            d.b().a("m_start_ad_rev", cVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.mbridge.msdk.foundation.same.report.e.c().b(mBridgeRevenueParamsEntity.getReportData());
    }
}
