package com.bytedance.sdk.openadsdk.core.WV.KZx;

import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes7.dex */
public class KZx {
    private final Map<Og, String> Og;
    private final List<String> pA;

    public KZx(List<String> list) {
        this.pA = list;
        HashMap map = new HashMap();
        this.Og = map;
        map.put(Og.CACHEBUSTING, Og());
    }

    public List<String> pA() {
        ArrayList arrayList = new ArrayList();
        for (String strReplaceAll : this.pA) {
            if (!TextUtils.isEmpty(strReplaceAll)) {
                for (Og og : Og.values()) {
                    String str = this.Og.get(og);
                    if (str == null) {
                        str = "";
                    }
                    strReplaceAll = strReplaceAll.replaceAll("\\[" + og.name() + "\\]", str);
                }
                arrayList.add(strReplaceAll);
            }
        }
        return arrayList;
    }

    public KZx pA(com.bytedance.sdk.openadsdk.core.WV.pA.pA pAVar) {
        if (pAVar != null) {
            this.Og.put(Og.ERRORCODE, pAVar.pA());
        }
        return this;
    }

    public KZx pA(long j) {
        if (j >= 0) {
            String strOg = Og(j);
            if (!TextUtils.isEmpty(strOg)) {
                this.Og.put(Og.CONTENTPLAYHEAD, strOg);
            }
        }
        return this;
    }

    public KZx pA(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLEncoder.encode(str, "UTF-8");
            } catch (Throwable unused) {
            }
            this.Og.put(Og.ASSETURI, str);
        }
        return this;
    }

    private String Og() {
        return String.format(Locale.US, "%08d", Long.valueOf(Math.round(Math.random() * 1.0E8d)));
    }

    private String Og(long j) {
        return String.format(Locale.getDefault(), "%02d:%02d:%02d.%03d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(j)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) % TimeUnit.MINUTES.toSeconds(1L)), Long.valueOf(j % 1000));
    }
}
