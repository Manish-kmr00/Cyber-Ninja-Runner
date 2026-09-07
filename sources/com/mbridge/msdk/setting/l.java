package com.mbridge.msdk.setting;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import java.util.ArrayList;

/* JADX INFO: compiled from: UnitSetting.java */
/* JADX INFO: loaded from: classes12.dex */
public class l extends c {
    public static l N() {
        return new l();
    }

    public static l h(String str) {
        l lVar = new l();
        try {
            lVar.e(str);
            lVar.r(1);
            lVar.x(1);
            lVar.z(5);
            lVar.b(1);
            lVar.c(1);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b("UnitSetting", e.getMessage());
            }
        }
        return lVar;
    }

    public static l i(String str) {
        l lVar = new l();
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(8);
        arrayList2.add(8);
        lVar.r(1);
        lVar.e(str);
        lVar.a(arrayList);
        lVar.b(arrayList2);
        lVar.x(1);
        lVar.b(-2);
        lVar.c(-2);
        lVar.z(5);
        lVar.d(3600L);
        lVar.k(2);
        lVar.d(1);
        lVar.u(100);
        lVar.g(0);
        lVar.i(1);
        lVar.m(0);
        lVar.v(60);
        lVar.p(10);
        lVar.q(60);
        return lVar;
    }

    public static l j(String str) {
        l lVar = new l();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(1);
            lVar.a(arrayList);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(30);
            lVar.b(arrayList2);
            lVar.e(str);
            lVar.r(1);
            lVar.x(1);
            lVar.b(-2);
            lVar.c(-2);
            lVar.z(5);
            lVar.d(3600L);
            lVar.k(2);
            lVar.d(3);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b("UnitSetting", e.getMessage());
            }
        }
        return lVar;
    }

    public static l k(String str) {
        l lVarN = N();
        lVarN.d(0);
        return lVarN;
    }

    public static l l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return c.a(MintegralNetworkBridge.jsonObjectInit(str));
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b("UnitSetting", "parseSetting", e);
            }
            return null;
        }
    }
}
