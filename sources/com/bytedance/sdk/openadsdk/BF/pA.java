package com.bytedance.sdk.openadsdk.BF;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.WV;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class pA {
    private static int pA(int i) {
        int i2 = 2;
        if (i != 2) {
            i2 = 3;
            if (i != 3) {
                i2 = 4;
                if (i != 4) {
                    i2 = 5;
                    if (i != 5 && i != 15) {
                        return -1;
                    }
                }
            }
        }
        return i2;
    }

    public static List<String> pA(List<String> list, boolean z) {
        String strPA = WV.pA(aBv.pA());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(strPA)) {
                next = next.replace("{UID}", strPA).replace("__UID__", strPA);
            }
            if (z) {
                next = pA(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    private static String pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.replace("[ss_random]", String.valueOf(new SecureRandom().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("TrackAdUrlUtils", e.getMessage());
            return str;
        }
    }

    public static List<String> pA(List<String> list, boolean z, yFO yfo) {
        String strPA = WV.pA(aBv.pA());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(strPA)) {
                next = next.replace("{UID}", strPA).replace("__UID__", strPA);
            }
            if (next.contains("__CID__") && yfo != null && !TextUtils.isEmpty(yfo.nCO())) {
                next = next.replace("__CID__", yfo.nCO());
            }
            if (next.contains("__CTYPE__") && yfo != null) {
                next = next.replace("__CTYPE__", String.valueOf(pA(yfo.RS())));
            }
            if (next.contains("__GAID__")) {
                next = next.replace("__GAID__", com.bytedance.sdk.openadsdk.XT.pA.Og.pA.pA().Og());
            }
            if (next.contains("__OS__")) {
                next = next.replace("__OS__", "0");
            }
            if (next.contains("__UA1__")) {
                next = next.replace("__UA1__", URLEncoder.encode(gbA.KZx()));
            }
            if (z) {
                next = pA(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }
}
