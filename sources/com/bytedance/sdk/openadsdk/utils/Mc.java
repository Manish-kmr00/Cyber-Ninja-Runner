package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.json.m5;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class Mc {
    public static void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, Double d) {
        if (yfo == null || yfo.tZW() == null) {
            return;
        }
        Map<String, Object> mapTZW = yfo.tZW();
        try {
            Object obj = yfo.tZW().get(TTAdConstant.SDK_BIDDING_TYPE);
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) mapTZW.get(m5.A);
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d != null) {
                    strReplace = strReplace.replace("${AUCTION_BID_TO_WIN}", String.valueOf(d));
                }
                com.bytedance.sdk.openadsdk.core.aBv.KZx().pA(strReplace);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.utils.WV.Og("report Win error");
        }
    }

    public static void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, Double d, String str, String str2) {
        if (yfo == null || yfo.tZW() == null) {
            return;
        }
        Map<String, Object> mapTZW = yfo.tZW();
        try {
            Object obj = yfo.tZW().get(TTAdConstant.SDK_BIDDING_TYPE);
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) mapTZW.get(m5.z);
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d != null) {
                    strReplace = strReplace.replace("${AUCTION_PRICE}", String.valueOf(d));
                }
                if (str != null) {
                    strReplace = strReplace.replace("${AUCTION_LOSS}", str);
                }
                if (str2 != null) {
                    strReplace = strReplace.replace("${AUCTION_WINNER}", str2);
                }
                com.bytedance.sdk.openadsdk.core.aBv.KZx().pA(strReplace);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.utils.WV.Og("report Loss error");
        }
    }
}
