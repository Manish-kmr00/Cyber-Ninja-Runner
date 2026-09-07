package com.bytedance.sdk.component.JG.pA.JG;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.JG.pA.omh;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.d;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class KZx implements Og {
    private final ML Og;
    private final Context pA;

    public KZx(Context context, ML ml) {
        this.pA = context;
        this.Og = ml;
    }

    public Context pA() {
        Context context = this.pA;
        return context == null ? omh.SD().JG() : context;
    }

    @Override // com.bytedance.sdk.component.JG.pA.JG.Og
    public void pA(String str, List<String> list, boolean z, Map<String, String> map, int i, String str2) {
        com.bytedance.sdk.component.JG.pA.ML mlOX = omh.SD().oX();
        if (mlOX == null || omh.SD().JG() == null || mlOX.ZZv() == null || !mlOX.KZx() || list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            mlOX.ZZv().execute(new pA(new ZZv(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), it.next(), z, i, str2), str, map));
        }
    }

    @Override // com.bytedance.sdk.component.JG.pA.JG.Og
    public Runnable pA(final ZZv zZv, final String str, final Map<String, String> map) {
        if (zZv == null || TextUtils.isEmpty(zZv.pA())) {
            return null;
        }
        return new Runnable() { // from class: com.bytedance.sdk.component.JG.pA.JG.KZx.1
            @Override // java.lang.Runnable
            public void run() {
                if (KZx.this.Og.pA(zZv.pA()) != null) {
                    new pA(zZv, str, map).run();
                }
            }
        };
    }

    @Override // com.bytedance.sdk.component.JG.pA.JG.Og
    public void pA(final String str, final boolean z) {
        com.bytedance.sdk.component.JG.pA.ML mlOX = omh.SD().oX();
        if (mlOX == null || omh.SD().JG() == null || !mlOX.KZx()) {
            return;
        }
        com.bytedance.sdk.component.JG.pA.ML.ML ml = new com.bytedance.sdk.component.JG.pA.ML.ML("trackFailedUrls") { // from class: com.bytedance.sdk.component.JG.pA.JG.KZx.2
            @Override // java.lang.Runnable
            public void run() {
                KZx.this.pA(KZx.this.Og.pA(), str, z);
            }
        };
        ml.pA(1);
        if (mlOX.ZZv() != null) {
            mlOX.ZZv().execute(ml);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(List<ZZv> list, String str, boolean z) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.JG.pA.ML mlOX = omh.SD().oX();
        for (ZZv zZv : list) {
            if (mlOX != null && mlOX.ZZv() != null) {
                zZv.pA(z);
                mlOX.ZZv().execute(new pA(zZv, str, null));
            }
        }
    }

    private class pA extends com.bytedance.sdk.component.JG.pA.ML.ML {
        private final String KZx;
        private final ZZv Og;
        private final Map<String, String> ZZv;

        private pA(ZZv zZv, String str, Map<String, String> map) {
            super("AdsStats");
            this.Og = zZv;
            this.KZx = str;
            this.ZZv = map;
        }

        private String KZx(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            return ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.KZx)) ? str.replace("{UID}", this.KZx).replace("__UID__", this.KZx) : str;
        }

        boolean pA(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith(d.v) || str.startsWith("https://");
        }

        String Og(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(KZx.KZx().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception unused) {
                return str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.JG.pA.ML.ZZv zZvPA;
            com.bytedance.sdk.component.JG.pA.ML mlOX = omh.SD().oX();
            if (mlOX == null || omh.SD().JG() == null || !mlOX.KZx() || !pA(this.Og.Og())) {
                return;
            }
            if (this.Og.ZZv() >= mlOX.KZx(this.Og.JG())) {
                KZx.this.Og.KZx(this.Og);
                return;
            }
            try {
                mlOX.Wx();
                if (this.Og.BSW()) {
                    KZx.this.Og.pA(this.Og);
                }
                if (mlOX.pA(KZx.this.pA())) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String strOg = this.Og.Og();
                    if (mlOX.JG() == 0) {
                        strOg = KZx(this.Og.Og());
                        if (this.Og.KZx()) {
                            strOg = Og(strOg);
                        }
                    }
                    com.bytedance.sdk.component.JG.pA.ML.KZx kZxSGo = mlOX.SGo();
                    if (kZxSGo == null) {
                        return;
                    }
                    kZxSGo.pA("User-Agent", mlOX.Bzk());
                    kZxSGo.pA("csj_client_source_from", "1");
                    if (this.ZZv != null) {
                        JSONObject jSONObject = new JSONObject();
                        for (Map.Entry<String, String> entry : this.ZZv.entrySet()) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                        kZxSGo.pA("csj_extra_info", jSONObject.toString());
                    }
                    kZxSGo.pA(strOg);
                    try {
                        zZvPA = kZxSGo.pA();
                        try {
                            mlOX.pA(zZvPA.pA());
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        zZvPA = null;
                    }
                    ZZv zZv = this.Og;
                    zZv.pA(zZv.ZZv() + 1);
                    if (zZvPA != null && zZvPA.pA()) {
                        KZx.this.Og.KZx(this.Og);
                        this.Og.Og();
                        mlOX.pA(true, 200, System.currentTimeMillis() - jCurrentTimeMillis, this.Og);
                        return;
                    }
                    if (zZvPA != null) {
                        this.Og.Og(zZvPA.Og());
                        this.Og.KZx(zZvPA.KZx());
                    }
                    if (zZvPA != null && zZvPA.Og() == 8848) {
                        zZvPA.KZx();
                        KZx.this.Og.KZx(this.Og);
                    } else {
                        this.Og.Og();
                        if (this.Og.ZZv() >= mlOX.KZx(this.Og.JG())) {
                            KZx.this.Og.KZx(this.Og);
                            this.Og.Og();
                        } else {
                            KZx.this.Og.Og(this.Og);
                        }
                    }
                    mlOX.pA(false, this.Og.omh(), System.currentTimeMillis() - jCurrentTimeMillis, this.Og);
                }
            } catch (Throwable unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Random KZx() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }
}
