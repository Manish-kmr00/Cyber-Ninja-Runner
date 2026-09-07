package com.bytedance.sdk.openadsdk.aBv;

import android.content.Context;
import android.location.Address;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.WV;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class Og implements com.bytedance.sdk.component.SD.KZx.Og {
    public static String pA = "sp_multi_ttadnet_config";
    private final Context Og;

    @Override // com.bytedance.sdk.component.SD.KZx.Og
    public int ZZv() {
        return BuildConfig.VERSION_CODE;
    }

    @Override // com.bytedance.sdk.component.SD.KZx.Og
    public Address pA(Context context) {
        return null;
    }

    public Og(Context context) {
        this.Og = context;
    }

    @Override // com.bytedance.sdk.component.SD.KZx.Og
    public int pA() {
        return Integer.parseInt("1371");
    }

    @Override // com.bytedance.sdk.component.SD.KZx.Og
    public String Og() {
        return "pangle_sdk";
    }

    @Override // com.bytedance.sdk.component.SD.KZx.Og
    public String KZx() {
        return "android";
    }

    @Override // com.bytedance.sdk.component.SD.KZx.Og
    public String ML() {
        return WV.pA(this.Og);
    }

    @Override // com.bytedance.sdk.component.SD.KZx.Og
    public String pA(Context context, String str, String str2) {
        return com.bytedance.sdk.openadsdk.multipro.ZZv.pA.Og(pA, str, str2);
    }

    @Override // com.bytedance.sdk.component.SD.KZx.Og
    public void pA(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA(pA, entry.getKey(), (Integer) value);
                    } else if (value instanceof Long) {
                        com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA(pA, entry.getKey(), (Long) value);
                    } else if (value instanceof Float) {
                        com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA(pA, entry.getKey(), (Float) value);
                    } else if (value instanceof Boolean) {
                        com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA(pA, entry.getKey(), (Boolean) value);
                    } else if (value instanceof String) {
                        com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA(pA, entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.SD.KZx.Og
    public String[] JG() {
        String[] strArr = {"tnc16-useast1a.isnssdk.com", "tnc16-useast1a.byteoversea.com", "tnc16-alisg.isnssdk.com", "tnc16-alisg.byteoversea.com"};
        String strCIG = aBv.ZZv().CIG();
        if (!TextUtils.isEmpty(strCIG)) {
            return ("SG".equals(strCIG) || "CN".equals(strCIG)) ? new String[]{"tnc16-alisg.isnssdk.com", "tnc16-alisg.byteoversea.com", "tnc16-useast1a.isnssdk.com", "tnc16-useast1a.byteoversea.com"} : strArr;
        }
        int iOX = gbA.oX();
        return (iOX == 2 || iOX == 1) ? new String[]{"tnc16-alisg.isnssdk.com", "tnc16-alisg.byteoversea.com", "tnc16-useast1a.isnssdk.com", "tnc16-useast1a.byteoversea.com"} : strArr;
    }
}
