package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.safedk.android.analytics.brandsafety.FileUploadManager;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class BSW {
    private static volatile BSW pA;
    private final com.bytedance.sdk.openadsdk.common.pA.Og KZx;
    private final Context Og;
    private final Map<yFO, Long> ZZv = Collections.synchronizedMap(new HashMap());

    public void pA(String str, yFO yfo) {
        if (com.bytedance.sdk.openadsdk.common.pA.pA()) {
            com.bytedance.sdk.openadsdk.common.pA.pA("sp_reward_video").pA(str, yfo);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strKZx = this.KZx.KZx(str);
        String strIj = yfo != null ? yfo.Ij() : "";
        if (TextUtils.isEmpty(strKZx) || TextUtils.isEmpty(strIj) || strKZx.equals(strIj)) {
            this.KZx.Bzk(str);
        }
    }

    public void pA() {
        File[] fileArrListFiles;
        String str;
        File[] fileArrListFiles2;
        if (com.bytedance.sdk.openadsdk.common.pA.pA()) {
            com.bytedance.sdk.openadsdk.common.pA.pA("sp_reward_video").Og();
            return;
        }
        try {
            boolean zSD = com.bytedance.sdk.openadsdk.core.Bzk.SD("sp_reward_video");
            if (zSD) {
                str = FileUploadManager.i;
            } else {
                str = "shared_prefs";
            }
            File file = new File(this.Og.getDataDir(), str);
            if (file.exists() && file.isDirectory() && (fileArrListFiles2 = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.BSW.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null) {
                        return file2.getName().contains("sp_reward_video");
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : fileArrListFiles2) {
                    if (zSD) {
                        try {
                            com.bytedance.sdk.component.utils.JG.KZx(file2);
                        } catch (Throwable unused) {
                        }
                    } else {
                        this.Og.deleteSharedPreferences(file2.getName().replace(".xml", ""));
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            File cacheDir = this.Og.getCacheDir();
            if (cacheDir == null || !cacheDir.exists() || !cacheDir.isDirectory() || (fileArrListFiles = cacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.BSW.2
                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    if (file3 != null) {
                        return file3.getName().contains("reward_video_cache");
                    }
                    return false;
                }
            })) == null) {
                return;
            }
            for (File file3 : fileArrListFiles) {
                try {
                    com.bytedance.sdk.component.utils.JG.KZx(file3);
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable unused4) {
        }
    }

    public void pA(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
        yFO yfoJG;
        if (com.bytedance.sdk.openadsdk.common.pA.pA()) {
            com.bytedance.sdk.openadsdk.common.pA.pA("sp_reward_video").pA(adSlot, pAVar);
            return;
        }
        if (pAVar == null || pAVar.SGo() || adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm()) || (yfoJG = pAVar.JG()) == null || yfoJG.JEI() == 2) {
            return;
        }
        String strOg = pAVar.Og();
        synchronized (pAVar) {
            if (!pAVar.SGo()) {
                try {
                    this.KZx.pA(adSlot, pAVar.Wx().toString(), strOg);
                } catch (Throwable unused) {
                    pAVar.BSW();
                }
            }
        }
    }

    public static BSW pA(Context context) {
        if (pA == null) {
            synchronized (BSW.class) {
                if (pA == null) {
                    pA = new BSW(context);
                }
            }
        }
        return pA;
    }

    private BSW(Context context) {
        this.Og = context == null ? aBv.pA() : context.getApplicationContext();
        this.KZx = new com.bytedance.sdk.openadsdk.common.pA.Og("sp_reward_video");
    }

    public String pA(yFO yfo) {
        if (com.bytedance.sdk.openadsdk.common.pA.pA()) {
            return com.bytedance.sdk.openadsdk.common.pA.pA("sp_reward_video").pA(yfo);
        }
        if (yfo == null || yfo.Bf() == null || TextUtils.isEmpty(yfo.Bf().BSW())) {
            return null;
        }
        return pA(yfo.Bf().BSW(), yfo.Bf().Sn(), yfo.FK());
    }

    public String pA(String str, String str2, int i) {
        File filePA;
        if (com.bytedance.sdk.openadsdk.common.pA.pA()) {
            return com.bytedance.sdk.openadsdk.common.pA.pA("sp_reward_video").pA(str, str2, i);
        }
        if (!TextUtils.isEmpty(str) && (filePA = pA(str2, i)) != null && filePA.exists() && filePA.isFile() && filePA.length() > 0) {
            return filePA.getAbsolutePath();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.model.pA pA(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.model.pA pAVarKZx;
        if (com.bytedance.sdk.openadsdk.common.pA.pA()) {
            com.bytedance.sdk.openadsdk.common.pA pAVarPA = com.bytedance.sdk.openadsdk.common.pA.pA("sp_reward_video");
            com.bytedance.sdk.openadsdk.core.model.pA pAVarPA2 = pAVarPA.pA(str, 10500000L);
            if (z && pAVarPA2 != null && ML.Og() == 2 && pAVarPA.KZx(str)) {
                return null;
            }
            return pAVarPA2;
        }
        long jML = this.KZx.ML(str);
        boolean zJG = this.KZx.JG(str);
        boolean zOmh = this.KZx.omh(str);
        int iOg = ML.Og();
        if (System.currentTimeMillis() - jML < 10500000 && !zJG && (!z || iOg != 2 || !zOmh)) {
            try {
                String strOg = this.KZx.Og(str);
                if (!TextUtils.isEmpty(strOg)) {
                    JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(strOg);
                    if (jSONObjectJsonObjectInit.has("cypher")) {
                        jSONObjectJsonObjectInit = aBv.KZx().pA(jSONObjectJsonObjectInit);
                    }
                    if (jSONObjectJsonObjectInit.has("creatives")) {
                        pAVarKZx = com.bytedance.sdk.openadsdk.core.model.pA.KZx(jSONObjectJsonObjectInit);
                    } else {
                        yFO yfoPA = com.bytedance.sdk.openadsdk.core.Og.pA(jSONObjectJsonObjectInit);
                        com.bytedance.sdk.openadsdk.core.model.pA pAVar = new com.bytedance.sdk.openadsdk.core.model.pA();
                        pAVar.pA(yfoPA);
                        pAVarKZx = pAVar;
                    }
                    if (pAVarKZx != null && pAVarKZx.ML()) {
                        Iterator<yFO> it = pAVarKZx.ZZv().iterator();
                        while (it.hasNext()) {
                            if (!Og(it.next())) {
                                it.remove();
                            }
                        }
                        if (pAVarKZx.ML()) {
                            return pAVarKZx;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private boolean Og(yFO yfo) {
        if (yfo != null) {
            return WQf.KZx(yfo) || yfo.Bf() != null;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final boolean z, final yFO yfo, final long j, String str) {
        Long lRemove = this.ZZv.remove(yfo);
        final long jElapsedRealtime = lRemove == null ? 0L : SystemClock.elapsedRealtime() - lRemove.longValue();
        final String str2 = z ? "load_video_success" : "load_video_error";
        final String str3 = (z || str == null) ? null : str;
        com.bytedance.sdk.openadsdk.Sn.KZx.pA(str2, false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.BSW.3
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA(str2).Og(gbA.pA(z, yfo, jElapsedRealtime, j, str3).toString());
            }
        });
    }

    public void pA(final yFO yfo, final com.bytedance.sdk.openadsdk.common.pA.InterfaceC0223pA<Object> interfaceC0223pA) {
        if (!com.bytedance.sdk.openadsdk.core.Wx.ML.pA.pA()) {
            interfaceC0223pA.pA(true, null);
            return;
        }
        if (com.bytedance.sdk.openadsdk.common.pA.pA()) {
            com.bytedance.sdk.openadsdk.common.pA.pA("sp_reward_video").pA(yfo, interfaceC0223pA);
            return;
        }
        this.ZZv.put(yfo, Long.valueOf(SystemClock.elapsedRealtime()));
        if (yfo == null || yfo.Bf() == null || TextUtils.isEmpty(yfo.Bf().BSW())) {
            if (interfaceC0223pA != null) {
                interfaceC0223pA.pA(false, null);
            }
            pA(false, yfo, -1L, null);
        } else {
            String strBSW = yfo.Bf().BSW();
            File filePA = pA(yfo.Bf().Sn(), yfo.FK());
            com.bytedance.sdk.component.SD.Og.pA pAVarZZv = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().ZZv();
            pAVarZZv.Og(strBSW);
            pAVarZZv.pA(filePA.getParent(), filePA.getName());
            pAVarZZv.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.BSW.4
                @Override // com.bytedance.sdk.component.SD.pA.pA
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og) {
                    if (og.JG() && og.ML() != null && og.ML().exists()) {
                        com.bytedance.sdk.openadsdk.common.pA.InterfaceC0223pA interfaceC0223pA2 = interfaceC0223pA;
                        if (interfaceC0223pA2 != null) {
                            interfaceC0223pA2.pA(true, null);
                        }
                        BSW.this.pA(true, yfo, og.pA(), og.Og());
                        return;
                    }
                    com.bytedance.sdk.openadsdk.common.pA.InterfaceC0223pA interfaceC0223pA3 = interfaceC0223pA;
                    if (interfaceC0223pA3 != null) {
                        interfaceC0223pA3.pA(false, null);
                    }
                    BSW.this.pA(false, yfo, og.pA(), og.Og());
                }

                @Override // com.bytedance.sdk.component.SD.pA.pA
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
                    com.bytedance.sdk.openadsdk.common.pA.InterfaceC0223pA interfaceC0223pA2 = interfaceC0223pA;
                    if (interfaceC0223pA2 != null) {
                        interfaceC0223pA2.pA(false, null);
                    }
                    BSW.this.pA(false, yfo, -2L, iOException.getMessage());
                }
            });
        }
    }

    private File pA(String str, int i) {
        return new File(CacheDirFactory.getICacheDir(i).pA(), str);
    }

    public void pA(String str) {
        if (com.bytedance.sdk.openadsdk.common.pA.pA()) {
            com.bytedance.sdk.openadsdk.common.pA.pA("sp_reward_video").Og(str);
        } else {
            this.KZx.SD(str);
        }
    }
}
