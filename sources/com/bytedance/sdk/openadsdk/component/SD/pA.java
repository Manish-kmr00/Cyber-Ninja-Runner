package com.bytedance.sdk.openadsdk.component.SD;

import android.content.Context;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.component.JG;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.multipro.Og;
import com.bytedance.sdk.openadsdk.utils.BSW;
import com.facebook.internal.NativeProtocol;
import java.io.File;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class pA {
    public static File pA(String str) {
        return new File(CacheDirFactory.getICacheDir(0).Og() + File.separator + str);
    }

    public static String pA() {
        return BSW.pA();
    }

    public static File Og(String str) {
        return pA(aBv.pA(), JG.pA(aBv.pA()).Og(), str);
    }

    public static File pA(Context context, String str, String str2) {
        return com.bytedance.sdk.component.utils.JG.pA(context, Og.KZx(), str, str2);
    }

    public static void pA(File file) {
        if (file == null) {
            return;
        }
        try {
            com.bytedance.sdk.component.utils.JG.Og(file);
        } catch (Throwable unused) {
        }
    }

    public static void pA(Context context) {
        try {
            JG.pA(context).pA();
        } catch (Throwable unused) {
        }
    }

    public static String Og() {
        return com.bytedance.sdk.component.utils.JG.pA(aBv.pA(), Og.KZx(), JG.pA(aBv.pA()).Og()).getAbsolutePath();
    }

    public static void pA(JSONObject jSONObject, int i, boolean z) {
        try {
            String strJG = Bzk.Og().JG();
            int iSD = Bzk.Og().SD();
            JSONObject jSONObject2 = jSONObject.getJSONObject(Reporting.Key.CREATIVE);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, strJG);
            if (!z) {
                jSONObject3.put("app_icon_id", "@".concat(String.valueOf(iSD)));
            } else if (Bzk.Og().SD() != 0) {
                jSONObject3.put("app_icon_id", "local://pag_open_icon_id");
            }
            jSONObject2.put("open_app_info", jSONObject3);
            if (jSONObject2.optJSONObject("video") == null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("video_duration", aBv.ZZv().BF(String.valueOf(i)));
                jSONObject2.put("video", jSONObject4);
            }
        } catch (Exception e) {
            WV.pA("TTAppOpenUtils", e.getMessage());
        }
    }

    public static int pA(yFO yfo, int i) {
        return i - yfo.lgT();
    }
}
