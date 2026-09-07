package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.o0;
import org.json.JSONArray;

/* JADX INFO: compiled from: DomainReport.java */
/* JADX INFO: loaded from: classes11.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f5004a = "DomainReport";

    public static boolean a(com.mbridge.msdk.setting.g gVar, String str) {
        if (gVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            int iK = gVar.K();
            JSONArray jSONArrayI = gVar.I();
            JSONArray jSONArrayH = gVar.H();
            if (jSONArrayH != null) {
                for (int i = 0; i < jSONArrayH.length(); i++) {
                    if (str.contains(jSONArrayH.getString(i))) {
                        return false;
                    }
                }
            }
            if (iK != 2) {
                return true;
            }
            if (jSONArrayI != null) {
                for (int i2 = 0; i2 < jSONArrayI.length(); i2++) {
                    if (str.contains(jSONArrayI.getString(i2))) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            o0.b(f5004a, e.getMessage());
            return true;
        }
    }
}
