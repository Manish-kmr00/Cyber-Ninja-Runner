package com.bytedance.sdk.openadsdk.Sn;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.Sn.pA.ZZv;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.utils.TX;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.json.b9;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class KZx {
    private static volatile KZx pA;

    private boolean KZx(ZZv zZv) {
        return zZv == null;
    }

    private KZx() {
    }

    public static KZx pA() {
        if (pA == null) {
            synchronized (KZx.class) {
                if (pA == null) {
                    pA = new KZx();
                }
            }
        }
        return pA;
    }

    public static void pA(final yFO yfo) {
        if (yfo == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        pA("bidding_receive", false, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.1
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("reveice_ts", jCurrentTimeMillis);
                if (yfo.FHA() == 3) {
                    jSONObject.put("is_icon_only", yfo.zi() ? 1 : 0);
                }
                return ZZv.Og().pA("bidding_receive").Og(jSONObject.toString());
            }
        });
    }

    public static void pA(yFO yfo, final long j) {
        if (yfo == null) {
            return;
        }
        pA("bidding_load", false, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.12
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", j);
                return ZZv.Og().pA("bidding_load").Og(jSONObject.toString());
            }
        });
    }

    public static void pA(final String str, final com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA pAVar) {
        if (pAVar == null) {
            return;
        }
        pA(str, false, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.18
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObjectKZx = pAVar.KZx();
                if (jSONObjectKZx == null) {
                    jSONObjectKZx = new JSONObject();
                }
                com.bytedance.sdk.openadsdk.ZZv.ML.Og.KZx kZxZZv = pAVar.ZZv();
                if (kZxZZv != null) {
                    kZxZZv.pA(jSONObjectKZx);
                }
                return ZZv.Og().pA(str).pA(pAVar.pA().FHA()).Og(jSONObjectKZx.toString());
            }
        });
    }

    public static void Og(final yFO yfo) {
        if (gbA.pA(yfo) == null || TextUtils.isEmpty(yfo.Gag())) {
            return;
        }
        pA("download_gecko_start", false, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.19
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", yfo.dC());
                jSONObject.put("channel_name", yfo.Gag());
                return ZZv.Og().pA("download_gecko_start").pA(yfo.FHA()).Og(jSONObject.toString());
            }
        });
    }

    public static void pA(final yFO yfo, final JSONObject jSONObject) {
        if (gbA.pA(yfo) == null || TextUtils.isEmpty(yfo.Gag())) {
            return;
        }
        pA("download_gecko_end", false, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.20
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", yfo.dC());
                jSONObject2.put("channel_name", yfo.Gag());
                jSONObject2.put("data", jSONObject);
                return ZZv.Og().pA("download_gecko_end").pA(yfo.FHA()).Og(jSONObject2.toString());
            }
        });
    }

    public void pA(final ZZv zZv) {
        if (KZx(zZv)) {
            return;
        }
        zZv.pA("express_ad_render");
        aBv.ML().pA(new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.21
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                return zZv;
            }
        });
    }

    public void Og(final ZZv zZv) {
        if (KZx(zZv)) {
            return;
        }
        zZv.pA("show_backup_endcard");
        aBv.ML().pA(new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.22
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                return zZv;
            }
        });
    }

    public void pA(final String str) {
        pA("click_playable_test_tool", false, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.2
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                } catch (Throwable unused) {
                }
                return ZZv.Og().pA("click_playable_test_tool").Og(jSONObject.toString());
            }
        });
    }

    public void Og(final String str) {
        pA("close_playable_test_tool", false, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.3
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                } catch (Throwable unused) {
                }
                return ZZv.Og().pA("close_playable_test_tool").Og(jSONObject.toString());
            }
        });
    }

    public void pA(final String str, final int i, final String str2) {
        pA("use_playable_test_tool_error", false, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.4
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                    jSONObject.put("error_code", i);
                    jSONObject.put("error_message", str2);
                } catch (Throwable unused) {
                }
                return ZZv.Og().pA("use_playable_test_tool_error").Og(jSONObject.toString());
            }
        });
    }

    public void pA(final long j, final long j2) {
        final long j3 = j2 - j;
        pA("general_label", false, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.5
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                int i = !Sn.Og.get() ? 1 : 0;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("starttime", j);
                    jSONObject.put("endtime", j2);
                    jSONObject.put("start_type", i);
                } catch (Throwable unused) {
                }
                return ZZv.Og().pA("general_label").omh(String.valueOf(j3)).Og(jSONObject.toString());
            }
        });
    }

    public static void Og() {
        xy.KZx(new omh("showFailLog") { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    KZx.pA().pA("show_fail_log", new JSONObject());
                } catch (Throwable th) {
                    WV.pA("StatsLogManager", th.getMessage());
                }
            }
        });
    }

    public static void KZx(final String str) {
        xy.KZx(new omh("adOpenShowFailLog") { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("reason", str);
                    KZx.pA().pA("show_fail_log", jSONObject);
                } catch (Throwable th) {
                    WV.pA("StatsLogManager", th.getMessage());
                }
            }
        });
    }

    public void pA(final String str, final JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            return;
        }
        pA(str, false, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.8
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                return ZZv.Og().pA(str).Og(jSONObject.toString());
            }
        });
    }

    public void pA(final String str, final String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        pA(str, false, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.9
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                return ZZv.Og().pA(str).Og(str2);
            }
        });
    }

    public void KZx() {
        pA("blind_mode_status", true, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.10
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                return ZZv.Og().pA("blind_mode_status");
            }
        });
    }

    public void pA(final JSONObject jSONObject) {
        if (jSONObject == null) {
            TX.pA("adRevenuePangle", "You must pass adRevenue json to pangle");
            return;
        }
        Object objOpt = jSONObject.opt("device_ad_mediation_platform");
        if (!(objOpt instanceof String) || TextUtils.isEmpty((String) objOpt)) {
            TX.pA("adRevenuePangle", "You must pass device_ad_mediation_platform to pangle");
        } else {
            TX.pA("adRevenuePangle", "pangle", "You successfully passed the parameters to pangle. The parameters are:", jSONObject);
            pA("ad_revenue", true, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.11
                @Override // com.bytedance.sdk.openadsdk.Sn.Og
                public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                    try {
                        jSONObject.put("event", 272);
                        jSONObject.put(CommonUrlParts.UUID, com.bytedance.sdk.openadsdk.core.WV.KZx(aBv.pA()));
                        String strPA = "";
                        try {
                            if (com.bytedance.sdk.openadsdk.core.WV.pA(aBv.pA()) != null) {
                                strPA = com.bytedance.sdk.openadsdk.core.WV.pA(aBv.pA());
                            }
                        } catch (Throwable th) {
                            th.getMessage();
                        }
                        jSONObject.put("device_id", strPA);
                        jSONObject.put("platform", "android");
                        jSONObject.put("partner", "PangleSDK");
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                    return ZZv.Og().pA("ad_revenue").Og(jSONObject.toString());
                }
            });
        }
    }

    public static void ZZv() {
        pA("disk_log", false, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.13
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                File file = new File(CacheDirFactory.getRootDir());
                long j = 0;
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        long jPA = KZx.pA(file2);
                        j += jPA;
                        jSONObject.put(file2.getName(), jPA);
                    }
                }
                if (j < 524288000) {
                    return null;
                }
                return ZZv.Og().pA("disk_log").Og(jSONObject.toString());
            }
        });
    }

    public static long pA(File file) {
        if (file.isFile()) {
            return file.length();
        }
        long jPA = 0;
        for (File file2 : file.listFiles()) {
            jPA += pA(file2);
        }
        return jPA;
    }

    public static void Og(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                final ZZv zZvOg = ZZv.Og().pA(str).Og(str2);
                aBv.ML().pA(new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.14
                    @Override // com.bytedance.sdk.openadsdk.Sn.Og
                    public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                        return zZvOg;
                    }
                }, false);
            }
        } catch (Throwable th) {
            WV.pA("StatsLogManager", th.getMessage());
        }
    }

    public static void pA(String str, boolean z, Og og) {
        int iOg = oX.vkV().Og(str);
        new Object[]{"type=", str, "  ", Integer.valueOf(iOg)};
        if (TextUtils.isEmpty(str) || iOg == 0 || og == null) {
            return;
        }
        boolean z2 = iOg == 100;
        if (!z2) {
            z2 = ((int) ((Math.random() * 100.0d) + 1.0d)) <= iOg;
        }
        if (z2) {
            aBv.ML().pA(og, z);
        }
    }

    public static void pA(long j, long j2, final String str, final int i) {
        if (j == 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        final long j3 = jElapsedRealtime - j;
        final long j4 = jElapsedRealtime - j2;
        final long j5 = j2 - j;
        pA("ad_show_cost_time", false, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.15
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", j3);
                jSONObject.put("renderDuration", j4);
                jSONObject.put("showToRenderDuration", j5);
                jSONObject.put("tag", str);
                jSONObject.put("renderType", i);
                return ZZv.Og().pA("ad_show_cost_time").Og(jSONObject.toString());
            }
        });
    }

    public static void pA(int i, String str) {
        pA(i, str, 0, (String) null);
    }

    public static void pA(final int i, final String str, final int i2, final String str2) {
        pA("ipv6_req", false, (Og) new Og<com.bytedance.sdk.openadsdk.Sn.pA.KZx>() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.16
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                String str3;
                JSONObject jSONObject = new JSONObject();
                int i3 = i;
                if (i3 == 1) {
                    str3 = "success";
                } else if (i3 != -1) {
                    str3 = "start";
                } else {
                    jSONObject.put("error_code", i2);
                    jSONObject.put("error_msg", str2);
                    str3 = b9.f.e;
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("url", str);
                }
                jSONObject.put("status", str3);
                return ZZv.Og().pA("ipv6_req").Og(jSONObject.toString());
            }
        });
    }

    public static void KZx(final String str, final String str2) {
        pA("playable_url_mime", false, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.KZx.17
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    String str3 = str;
                    Object obj = "not validate";
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "not validate";
                    }
                    jSONObject.put("original_mime", str3);
                    String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str2));
                    if (!TextUtils.isEmpty(mimeTypeFromExtension)) {
                        obj = mimeTypeFromExtension;
                    }
                    jSONObject.put("new_mime", obj);
                    jSONObject.put("url", str2);
                    jSONObject.put("is_same", str3.equals(obj) ? 1 : 0);
                } catch (Throwable unused) {
                }
                return ZZv.Og().pA("playable_url_mime").Og(jSONObject.toString());
            }
        });
    }
}
