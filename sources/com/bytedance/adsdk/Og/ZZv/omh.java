package com.bytedance.adsdk.Og.ZZv;

import android.content.Context;
import android.util.Pair;
import com.bytedance.adsdk.Og.WV;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes12.dex */
public class omh {
    private final JG Og;
    private final SD pA;

    public omh(SD sd, JG jg) {
        this.pA = sd;
        this.Og = jg;
    }

    public WV<com.bytedance.adsdk.Og.SD> pA(Context context, String str, String str2) {
        com.bytedance.adsdk.Og.SD sdOg = Og(context, str, str2);
        if (sdOg != null) {
            return new WV<>(sdOg);
        }
        return KZx(context, str, str2);
    }

    private com.bytedance.adsdk.Og.SD Og(Context context, String str, String str2) {
        SD sd;
        Pair<KZx, InputStream> pairPA;
        WV<com.bytedance.adsdk.Og.SD> wvOg;
        if (str2 == null || (sd = this.pA) == null || (pairPA = sd.pA(str)) == null) {
            return null;
        }
        KZx kZx = (KZx) pairPA.first;
        InputStream inputStream = (InputStream) pairPA.second;
        if (kZx == KZx.ZIP) {
            wvOg = com.bytedance.adsdk.Og.omh.pA(context, new ZipInputStream(inputStream), str2);
        } else {
            wvOg = com.bytedance.adsdk.Og.omh.Og(inputStream, str2);
        }
        if (wvOg.pA() != null) {
            return wvOg.pA();
        }
        return null;
    }

    private WV<com.bytedance.adsdk.Og.SD> KZx(Context context, String str, String str2) {
        ZZv zZv = null;
        try {
            try {
                ZZv zZvPA = this.Og.pA(str);
                if (zZvPA.pA()) {
                    WV<com.bytedance.adsdk.Og.SD> wvPA = pA(context, str, zZvPA.Og(), zZvPA.KZx(), str2);
                    wvPA.pA();
                    if (zZvPA != null) {
                        try {
                            zZvPA.close();
                        } catch (IOException unused) {
                        }
                    }
                    return wvPA;
                }
                WV<com.bytedance.adsdk.Og.SD> wv = new WV<>(new IllegalArgumentException(zZvPA.ZZv()));
                if (zZvPA != null) {
                    try {
                        zZvPA.close();
                    } catch (IOException unused2) {
                    }
                }
                return wv;
            } catch (Exception e) {
                WV<com.bytedance.adsdk.Og.SD> wv2 = new WV<>(e);
                if (0 != 0) {
                    try {
                        zZv.close();
                    } catch (IOException unused3) {
                    }
                }
                return wv2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    zZv.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    private WV<com.bytedance.adsdk.Og.SD> pA(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        WV<com.bytedance.adsdk.Og.SD> wvPA;
        KZx kZx;
        SD sd;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            KZx kZx2 = KZx.ZIP;
            wvPA = pA(context, str, inputStream, str3);
            kZx = kZx2;
        } else {
            kZx = KZx.JSON;
            wvPA = pA(str, inputStream, str3);
        }
        if (str3 != null && wvPA.pA() != null && (sd = this.pA) != null) {
            sd.pA(str, kZx);
        }
        return wvPA;
    }

    private WV<com.bytedance.adsdk.Og.SD> pA(Context context, String str, InputStream inputStream, String str2) throws IOException {
        SD sd;
        if (str2 == null || (sd = this.pA) == null) {
            return com.bytedance.adsdk.Og.omh.pA(context, new ZipInputStream(inputStream), (String) null);
        }
        return com.bytedance.adsdk.Og.omh.pA(context, new ZipInputStream(new FileInputStream(sd.pA(str, inputStream, KZx.ZIP))), str);
    }

    private WV<com.bytedance.adsdk.Og.SD> pA(String str, InputStream inputStream, String str2) throws IOException {
        SD sd;
        if (str2 == null || (sd = this.pA) == null) {
            return com.bytedance.adsdk.Og.omh.Og(inputStream, (String) null);
        }
        return com.bytedance.adsdk.Og.omh.Og(new FileInputStream(sd.pA(str, inputStream, KZx.JSON).getAbsolutePath()), str);
    }
}
