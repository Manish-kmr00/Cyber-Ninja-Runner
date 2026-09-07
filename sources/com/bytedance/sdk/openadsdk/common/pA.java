package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class pA {
    private final Map<yFO, Long> JG = Collections.synchronizedMap(new HashMap());
    private final Context KZx;
    private final String ML;
    private final Og ZZv;
    private static final HashMap<String, pA> pA = new HashMap<>();
    private static final HashMap<String, Og> Og = new HashMap<>();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.common.pA$pA, reason: collision with other inner class name */
    public interface InterfaceC0223pA<T> {
        void pA(boolean z, T t);
    }

    private pA(Context context, String str) {
        this.KZx = context;
        Og og = Og.get(str);
        this.ZZv = og == null ? new Og(str) : og;
        this.ML = str;
    }

    public static boolean pA() {
        return com.bytedance.sdk.openadsdk.vZF.pA.pA("material_cache_disk_format", 0) == 1;
    }

    public static pA pA(String str) {
        pA pAVar;
        HashMap<String, pA> map = pA;
        pA pAVar2 = map.get(str);
        if (pAVar2 != null) {
            return pAVar2;
        }
        synchronized (pA.class) {
            pAVar = map.get(str);
            if (pAVar == null) {
                pAVar = new pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), str);
                map.put(str, pAVar);
            }
        }
        return pAVar;
    }

    public static void pA(String str, Og og) {
        Og.put(str, og);
    }

    public void pA(String str, yFO yfo) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strKZx = this.ZZv.KZx(str);
        String strIj = yfo != null ? yfo.Ij() : "";
        if (TextUtils.isEmpty(strKZx) || TextUtils.isEmpty(strIj) || strKZx.equals(strIj)) {
            this.ZZv.Bzk(str);
        }
    }

    public void Og() {
        String str;
        File[] fileArrListFiles;
        try {
            boolean zSD = com.bytedance.sdk.openadsdk.core.Bzk.SD(this.ML);
            if (zSD) {
                str = FileUploadManager.i;
            } else {
                str = "shared_prefs";
            }
            File file = new File(this.KZx.getDataDir(), str);
            if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.common.pA.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null) {
                        return file2.getName().contains(pA.this.ML);
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : fileArrListFiles) {
                    if (zSD) {
                        try {
                            com.bytedance.sdk.component.utils.JG.KZx(file2);
                        } catch (Throwable unused) {
                        }
                    } else {
                        this.KZx.deleteSharedPreferences(file2.getName().replace(".xml", ""));
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            File file3 = new File(KZx());
            if (file3.exists() && file3.isDirectory()) {
                com.bytedance.sdk.component.utils.JG.KZx(file3);
            }
        } catch (Throwable unused3) {
        }
    }

    public void pA(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
        yFO yfoJG;
        if (pAVar == null || adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm()) || (yfoJG = pAVar.JG()) == null || yfoJG.JEI() == 2) {
            return;
        }
        try {
            this.ZZv.pA(adSlot, pAVar.Sn(), pAVar.Og());
        } catch (Throwable unused) {
        }
    }

    public String pA(yFO yfo) {
        if (yfo == null || yfo.Bf() == null || TextUtils.isEmpty(yfo.Bf().BSW())) {
            return null;
        }
        return pA(yfo.Bf().BSW(), yfo.Bf().Sn(), yfo.FK());
    }

    public String pA(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.component.utils.ML.pA(str);
        }
        File filePA = pA(str2, i);
        if (filePA == null || !filePA.exists() || !filePA.isFile() || filePA.length() <= 0) {
            return null;
        }
        return filePA.getAbsolutePath();
    }

    public com.bytedance.sdk.openadsdk.core.model.pA pA(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.model.pA pAVarKZx;
        AdSlot adSlotOg;
        yFO yfoJG;
        try {
            String strOg = this.ZZv.Og(str);
            if (!TextUtils.isEmpty(strOg)) {
                JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(strOg);
                if (jSONObjectJsonObjectInit.has("cypher")) {
                    jSONObjectJsonObjectInit = com.bytedance.sdk.openadsdk.core.aBv.KZx().pA(jSONObjectJsonObjectInit);
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
                    if (z) {
                        Iterator<yFO> it = pAVarKZx.ZZv().iterator();
                        while (it.hasNext()) {
                            if (!Og(it.next())) {
                                it.remove();
                            }
                        }
                    }
                    if (pAVarKZx.ML()) {
                        String strZZv = this.ZZv.ZZv(str);
                        if (!TextUtils.isEmpty(strZZv) && (adSlotOg = com.bytedance.sdk.openadsdk.core.Og.Og(PangleNetworkBridge.jsonObjectInit(strZZv))) != null && (yfoJG = pAVarKZx.JG()) != null) {
                            yfoJG.pA(adSlotOg);
                        }
                        return pAVarKZx;
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.model.pA pA(String str, long j) {
        long jML = this.ZZv.ML(str);
        boolean zJG = this.ZZv.JG(str);
        if (System.currentTimeMillis() - jML >= j || zJG) {
            return null;
        }
        return pA(str, true);
    }

    private boolean Og(yFO yfo) {
        if (yfo != null) {
            return WQf.XT(yfo) || yfo.Bf() != null;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final boolean z, final yFO yfo, final long j, String str) {
        Long lRemove = this.JG.remove(yfo);
        final long jElapsedRealtime = lRemove == null ? 0L : SystemClock.elapsedRealtime() - lRemove.longValue();
        final String str2 = z ? "load_video_success" : "load_video_error";
        final String str3 = (z || str == null) ? null : str;
        com.bytedance.sdk.openadsdk.Sn.KZx.pA(str2, false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.common.pA.2
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA(str2).Og(gbA.pA(z, yfo, jElapsedRealtime, j, str3).toString());
            }
        });
    }

    public void pA(final yFO yfo, final InterfaceC0223pA<Object> interfaceC0223pA) {
        this.JG.put(yfo, Long.valueOf(SystemClock.elapsedRealtime()));
        if (yfo.Bf() == null || TextUtils.isEmpty(yfo.Bf().BSW())) {
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
            pAVarZZv.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.openadsdk.common.pA.3
                @Override // com.bytedance.sdk.component.SD.pA.pA
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og) {
                    if (og.JG() && og.ML() != null && og.ML().exists()) {
                        InterfaceC0223pA interfaceC0223pA2 = interfaceC0223pA;
                        if (interfaceC0223pA2 != null) {
                            interfaceC0223pA2.pA(true, null);
                        }
                        pA.this.pA(true, yfo, og.pA(), og.Og());
                        return;
                    }
                    InterfaceC0223pA interfaceC0223pA3 = interfaceC0223pA;
                    if (interfaceC0223pA3 != null) {
                        interfaceC0223pA3.pA(false, null);
                    }
                    pA.this.pA(false, yfo, og.pA(), og.Og());
                }

                @Override // com.bytedance.sdk.component.SD.pA.pA
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
                    InterfaceC0223pA interfaceC0223pA2 = interfaceC0223pA;
                    if (interfaceC0223pA2 != null) {
                        interfaceC0223pA2.pA(false, null);
                    }
                    pA.this.pA(false, yfo, -2L, iOException.getMessage());
                }
            });
        }
    }

    private File pA(String str, int i) {
        return new File(CacheDirFactory.getICacheDir(i).pA(), str);
    }

    private String KZx() {
        return CacheDirFactory.getICacheDir(0).pA();
    }

    public void Og(String str) {
        this.ZZv.SD(str);
    }

    public boolean KZx(String str) {
        return this.ZZv.omh(str);
    }

    public static class Og {
        protected final String pA;
        private final HashSet<String> omh = new HashSet<>();
        String Og = "material_data";
        String KZx = "has_played";
        String ZZv = "create_time";
        String ML = "in_use_process";
        String JG = "req_id";
        String SD = "ad_slot";

        public Og(String str) {
            this.pA = TextUtils.isEmpty(str) ? "" : str;
        }

        protected String pA(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.pA + "_cache_" + str;
        }

        public String Og(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og(pA(str), this.Og, null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public String KZx(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og(pA(str), this.JG, null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public String ZZv(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og(pA(str), this.SD, null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public long ML(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA(pA(str), this.ZZv, 0L);
            } catch (Throwable unused) {
                return 0L;
            }
        }

        public boolean JG(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA(pA(str), this.KZx, true);
            } catch (Throwable unused) {
                return true;
            }
        }

        public void SD(String str) {
            try {
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA(pA(str), this.ML, com.bytedance.sdk.component.utils.aBv.Og(com.bytedance.sdk.openadsdk.core.aBv.pA()));
                this.omh.add(str);
            } catch (Throwable unused) {
            }
        }

        public boolean omh(String str) {
            try {
                String strPA = pA(str);
                String strOg = com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og(strPA, this.ML, "");
                if (TextUtils.isEmpty(strOg)) {
                    return false;
                }
                if (strOg.equals(com.bytedance.sdk.component.utils.aBv.Og(com.bytedance.sdk.openadsdk.core.aBv.pA())) && !this.omh.contains(str)) {
                    com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA(strPA, this.ML, "");
                    return false;
                }
            } catch (Throwable unused) {
            }
            return true;
        }

        public void pA(AdSlot adSlot, String str, String str2) {
            try {
                String codeId = adSlot.getCodeId();
                String strPA = pA(codeId);
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA(strPA, this.KZx, Boolean.FALSE);
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA(strPA, this.ZZv, Long.valueOf(System.currentTimeMillis()));
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA(strPA, this.Og, str);
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA(strPA, this.ML, "");
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA(strPA, this.JG, str2);
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA(strPA, this.SD, adSlot.toJsonObj().toString());
                this.omh.remove(codeId);
            } catch (Throwable unused) {
            }
        }

        public void Bzk(String str) {
            try {
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA(pA(str));
                this.omh.remove(str);
            } catch (Throwable unused) {
            }
        }
    }
}
