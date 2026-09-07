package com.bytedance.adsdk.ugeno.KZx;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.ZZv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class Og {
    public static String pA(String str, JSONObject jSONObject) {
        pA pAVarKZx;
        pA.InterfaceC0173pA interfaceC0173pAPA;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                return (!str.startsWith("${") || !str.endsWith("}") || (pAVarKZx = ZZv.pA().KZx()) == null || (interfaceC0173pAPA = pAVarKZx.pA(str.substring(2, str.length() + (-1)))) == null) ? str : (String) interfaceC0173pAPA.pA(jSONObject);
            } catch (Throwable unused) {
            }
        }
        return str;
    }
}
