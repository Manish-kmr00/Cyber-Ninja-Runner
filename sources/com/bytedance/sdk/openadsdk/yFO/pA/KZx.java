package com.bytedance.sdk.openadsdk.yFO.pA;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.eG;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.settings.WV;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public class KZx {
    private static volatile KZx pA;
    private String KZx;
    private final Set<String> ML = Collections.synchronizedSet(new HashSet());
    private String Og;
    private String ZZv;

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

    public void pA(Map<String, String> map) {
        File[] fileArrListFiles;
        if (WV.pA() && com.bytedance.sdk.openadsdk.vZF.pA.pA("plb_res_enable", 0) == 1) {
            String strJG = JG();
            if (!TextUtils.isEmpty(strJG)) {
                File file = new File(strJG);
                if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                    for (File file2 : fileArrListFiles) {
                        if (file2 != null) {
                            try {
                                File filePA = com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA(file2);
                                if (filePA != null && filePA.exists()) {
                                    map.put(file2.getName(), filePA.getAbsolutePath());
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
            int iPA = com.bytedance.sdk.openadsdk.vZF.pA.pA("plb_res_delay_fetch_time", 0);
            if (iPA <= 0) {
                KZx();
            } else {
                Sn.Og().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.yFO.pA.KZx.1
                    @Override // java.lang.Runnable
                    public void run() {
                        KZx.this.KZx();
                    }
                }, iPA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZx() {
        xy.pA(new omh("pag_plb_res_check") { // from class: com.bytedance.sdk.openadsdk.yFO.pA.KZx.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.yFO.Og.pA pAVarOg = com.bytedance.sdk.openadsdk.yFO.Og.pA.Og(com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og("pag_plb_config", "model", ""));
                if (pAVarOg != null) {
                    KZx.this.pA(pAVarOg, null, 0);
                }
            }
        });
    }

    public void Og() {
        if (WV.pA() && com.bytedance.sdk.openadsdk.vZF.pA.pA("plb_res_enable", 0) == 1) {
            long jCurrentTimeMillis = System.currentTimeMillis() - com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("pag_plb_config", "last_update_time", 0L);
            final String strPA = com.bytedance.sdk.openadsdk.vZF.pA.pA("plb_res", "");
            long jPA = com.bytedance.sdk.openadsdk.vZF.pA.pA("plb_res_fetch_interval", 3600000);
            if (jPA <= 0 || jPA > 259200000) {
                jPA = 3600000;
            }
            if (jCurrentTimeMillis < jPA || TextUtils.isEmpty(strPA)) {
                return;
            }
            int iPA = com.bytedance.sdk.openadsdk.vZF.pA.pA("plb_res_delay_fetch_time", 0);
            if (iPA <= 0) {
                Og(strPA);
            } else {
                Sn.Og().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.yFO.pA.KZx.3
                    @Override // java.lang.Runnable
                    public void run() {
                        KZx.this.Og(strPA);
                    }
                }, iPA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(final String str) {
        xy.pA(new omh("pag_plb_update_config") { // from class: com.bytedance.sdk.openadsdk.yFO.pA.KZx.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.SD.Og.Og ogKZx = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().KZx();
                try {
                    ogKZx.Og(com.bytedance.sdk.openadsdk.omh.ZZv.pA(ogKZx, str));
                    com.bytedance.sdk.component.SD.Og ogPA = ogKZx.pA();
                    if (ogPA == null || !ogPA.JG()) {
                        return;
                    }
                    String strZZv = ogPA.ZZv();
                    com.bytedance.sdk.openadsdk.yFO.Og.pA pAVarOg = com.bytedance.sdk.openadsdk.yFO.Og.pA.Og(strZZv);
                    com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("pag_plb_config", "last_update_time", Long.valueOf(System.currentTimeMillis()));
                    if (pAVarOg != null) {
                        com.bytedance.sdk.openadsdk.yFO.Og.pA pAVarOg2 = com.bytedance.sdk.openadsdk.yFO.Og.pA.Og(com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og("pag_plb_config", "model", ""));
                        if (pAVarOg2 == null || !pAVarOg.pA().equals(pAVarOg2.pA())) {
                            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("pag_plb_config", "model", strZZv);
                            KZx.this.pA(pAVarOg, pAVarOg2, 1);
                        }
                    }
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.WV.pA("PlayableResManager", e.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pA(com.bytedance.sdk.openadsdk.yFO.Og.pA pAVar, com.bytedance.sdk.openadsdk.yFO.Og.pA pAVar2, int i) {
        List<com.bytedance.sdk.openadsdk.yFO.Og.pA.C0259pA> listKZx = null;
        pA(pAVar.Og(), pAVar2 == null ? null : pAVar2.Og(), 1, i);
        List<com.bytedance.sdk.openadsdk.yFO.Og.pA.C0259pA> listKZx2 = pAVar.KZx();
        if (pAVar2 != null) {
            listKZx = pAVar2.KZx();
        }
        pA(listKZx2, listKZx, 2, i);
    }

    private void pA(List<com.bytedance.sdk.openadsdk.yFO.Og.pA.C0259pA> list, List<com.bytedance.sdk.openadsdk.yFO.Og.pA.C0259pA> list2, int i, int i2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String strML = i == 1 ? ML() : JG();
        for (com.bytedance.sdk.openadsdk.yFO.Og.pA.C0259pA c0259pA : list) {
            String strPA = c0259pA.pA();
            String strPA2 = com.bytedance.sdk.component.ML.KZx.KZx.KZx.pA(strPA);
            if (!TextUtils.isEmpty(strPA2)) {
                if (i == 1) {
                    strPA2 = strPA2 + KZx(strPA);
                }
                String str = strPA2;
                File file = new File(strML, str);
                boolean zExists = file.exists();
                if (i2 == 1) {
                    if (zExists && list2 != null && list2.contains(c0259pA)) {
                        new Object[]{"file exists, no need to download: tp= ", Integer.valueOf(i), ", url=", strPA};
                        com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.KZx(file);
                    } else {
                        pA(strPA, strML, str, i, file, zExists);
                    }
                } else if (zExists) {
                    new Object[]{"file exists, no need to download: tp= ", Integer.valueOf(i), ", url=", strPA};
                } else {
                    pA(strPA, strML, str, i, file, zExists);
                }
            }
        }
    }

    private void pA(final String str, final String str2, final String str3, final int i, final File file, final boolean z) {
        String strConcat;
        if (this.ML.contains(str)) {
            new Object[]{"Downloading, no repeat downloading, url: ", str};
            return;
        }
        if (i == 2) {
            strConcat = str3 + ".zip";
        } else {
            strConcat = z ? "tmp".concat(String.valueOf(str3)) : str3;
        }
        this.ML.add(str);
        com.bytedance.sdk.component.SD.Og.pA pAVarZZv = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().ZZv();
        pAVarZZv.Og(str);
        pAVarZZv.pA(str2, strConcat);
        final com.bytedance.sdk.component.SD.Og ogPA = pAVarZZv.pA();
        this.ML.remove(str);
        if (ogPA == null || !ogPA.JG() || ogPA.ML() == null || !ogPA.ML().exists()) {
            File file2 = new File(str2 + File.separator + str3 + ".tmp");
            if (file2.exists()) {
                try {
                    file2.delete();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            return;
        }
        if (i == 2) {
            xy.Og(new omh("downloadZip") { // from class: com.bytedance.sdk.openadsdk.yFO.pA.KZx.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (z) {
                            file.delete();
                        }
                        String str4 = str2 + File.separator + str3;
                        eG.pA(ogPA.ML().getAbsolutePath(), str4);
                        File file3 = new File(str4);
                        File filePA = com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA(file3);
                        if (filePA != null && filePA.exists()) {
                            com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().KZx().put(file3.getName(), filePA.getAbsolutePath());
                        }
                        com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.Og(file3);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.WV.pA("PlayableResManager", "unzip error: ", th, "tp=", Integer.valueOf(i), ", url=", str);
                    }
                    try {
                        ogPA.ML().delete();
                    } catch (Throwable unused2) {
                    }
                }
            });
        } else if (z) {
            file.delete();
            ogPA.ML().renameTo(file);
        }
    }

    private static String KZx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("?");
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf);
        }
        int iLastIndexOf = str.lastIndexOf(".");
        if (iLastIndexOf == -1) {
            return "";
        }
        return "." + str.substring(iLastIndexOf + 1);
    }

    private String ZZv() {
        if (TextUtils.isEmpty(this.Og)) {
            try {
                File file = new File(aBv.pA().getCacheDir(), "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.Og = file.getAbsolutePath();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("PlayableResManager", "init root path error: ".concat(String.valueOf(th)));
            }
        }
        return this.Og;
    }

    private String ML() {
        if (TextUtils.isEmpty(this.KZx)) {
            String str = ZZv() + File.separator + "common";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.KZx = str;
        }
        return this.KZx;
    }

    private String JG() {
        if (TextUtils.isEmpty(this.ZZv)) {
            String str = ZZv() + File.separator + "pregames";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.ZZv = str;
        }
        return this.ZZv;
    }

    public WebResourceResponse pA(String str) {
        if (WV.pA() && com.bytedance.sdk.openadsdk.vZF.pA.pA("plb_res_enable", 0) == 1) {
            String strPA = com.bytedance.sdk.component.ML.KZx.KZx.KZx.pA(str);
            if (TextUtils.isEmpty(strPA)) {
                return null;
            }
            File file = new File(ML(), strPA + KZx(str));
            if (file.exists()) {
                try {
                    return new WebResourceResponse(com.bytedance.sdk.component.utils.Sn.pA(aBv.pA(), str), "UTF-8", new FileInputStream(file));
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }
}
