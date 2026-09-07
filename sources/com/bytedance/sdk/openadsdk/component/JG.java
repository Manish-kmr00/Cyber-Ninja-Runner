package com.bytedance.sdk.openadsdk.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.sdk.component.ML.BSW;
import com.bytedance.sdk.component.ML.oX;
import com.bytedance.sdk.component.ML.omh;
import com.bytedance.sdk.component.utils.DX;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.TX;
import com.bytedance.sdk.openadsdk.core.model.du;
import com.bytedance.sdk.openadsdk.core.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.qmB;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class JG {
    private static volatile JG pA;
    private final yFO<com.bytedance.sdk.openadsdk.ZZv.pA> KZx;
    private final Map<String, AtomicInteger> ML = new ConcurrentHashMap();
    private final com.bytedance.sdk.openadsdk.Og.Og Og;
    private final Context ZZv;

    interface KZx {
        void pA();

        void pA(int i, String str);
    }

    public interface Og {
        void pA();

        void pA(com.bytedance.sdk.openadsdk.aBv.pA.Og og);
    }

    public interface ZZv {
        void pA(Bitmap bitmap);
    }

    private JG(Context context) {
        if (context != null) {
            this.ZZv = context.getApplicationContext();
        } else {
            this.ZZv = aBv.pA();
        }
        this.Og = new com.bytedance.sdk.openadsdk.Og.Og(10, 8, true);
        this.KZx = aBv.KZx();
        com.bytedance.sdk.openadsdk.common.pA.pA("tt_openad_materialMeta", new com.bytedance.sdk.openadsdk.common.pA.Og("tt_openad_materialMeta") { // from class: com.bytedance.sdk.openadsdk.component.JG.1
            @Override // com.bytedance.sdk.openadsdk.common.pA.Og
            protected String pA(String str) {
                return "tt_openad_materialMeta";
            }

            @Override // com.bytedance.sdk.openadsdk.common.pA.Og
            public String Og(String str) {
                return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og("tt_openad_materialMeta", "material".concat(String.valueOf(str)), null);
            }

            @Override // com.bytedance.sdk.openadsdk.common.pA.Og
            public String ZZv(String str) {
                return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og("tt_openad_materialMeta", "ad_slot".concat(String.valueOf(str)), null);
            }

            @Override // com.bytedance.sdk.openadsdk.common.pA.Og
            public void pA(AdSlot adSlot, String str, String str2) {
                String codeId = adSlot.getCodeId();
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad_materialMeta", "material".concat(String.valueOf(codeId)), str);
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad_materialMeta", "ad_slot".concat(String.valueOf(codeId)), adSlot.toJsonObj().toString());
            }
        });
    }

    public static JG pA(Context context) {
        if (pA == null) {
            synchronized (JG.class) {
                if (pA == null) {
                    pA = new JG(context);
                }
            }
        }
        return pA;
    }

    public static void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, ZZv zZv) {
        pA(yfo, zZv, 0);
    }

    public static void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, final ZZv zZv, final int i) {
        String strSGo = yfo.Bf().SGo();
        if (TextUtils.isEmpty(strSGo)) {
            return;
        }
        com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(strSGo).pA(yfo.Bf().KZx()).Og(yfo.Bf().Og()).ML(Vgu.ZZv(aBv.pA())).ZZv(Vgu.KZx(aBv.pA())).KZx(2).pA(new omh() { // from class: com.bytedance.sdk.openadsdk.component.JG.3
            @Override // com.bytedance.sdk.component.ML.omh
            public Bitmap pA(Bitmap bitmap) {
                return i <= 0 ? bitmap : com.bytedance.sdk.component.adexpress.ZZv.pA.pA(aBv.pA(), bitmap, i);
            }
        }).pA(new com.bytedance.sdk.openadsdk.Bzk.Og(yfo, strSGo, new oX<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.component.JG.2
            @Override // com.bytedance.sdk.component.ML.oX
            public void pA(int i2, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.ML.oX
            public void pA(BSW<Bitmap> bsw) {
                ZZv zZv2;
                if (bsw == null || bsw.Og() == null || bsw.KZx() == null || (zZv2 = zZv) == null) {
                    return;
                }
                zZv2.pA(bsw.Og());
            }
        }));
    }

    public void pA(final AdSlot adSlot) {
        if (adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm())) {
            return;
        }
        AtomicInteger atomicInteger = this.ML.get(adSlot.getCodeId());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
        }
        new Object[]{"local Requesting:", atomicInteger};
        int iKZx = atomicInteger.get() + KZx(adSlot);
        if (iKZx > 0) {
            new Object[]{Integer.valueOf(iKZx), ",The number of preloads exceeds the limit ", 1};
            return;
        }
        atomicInteger.incrementAndGet();
        this.ML.put(adSlot.getCodeId(), atomicInteger);
        final du duVar = new du();
        duVar.pA(qmB.Og());
        TX tx = new TX();
        tx.SGo = duVar;
        tx.ZZv = 2;
        tx.omh = 2;
        this.KZx.pA(adSlot, tx, 3, new yFO.pA() { // from class: com.bytedance.sdk.openadsdk.component.JG.4
            @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
            public void pA(int i, String str) {
                JG.this.Og(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
            public void pA(com.bytedance.sdk.openadsdk.core.model.pA pAVar, com.bytedance.sdk.openadsdk.core.model.Og og) {
                if (pAVar == null || pAVar.ZZv() == null || pAVar.ZZv().size() == 0) {
                    og.pA(-3);
                    com.bytedance.sdk.openadsdk.core.model.Og.pA(og);
                    return;
                }
                com.bytedance.sdk.openadsdk.core.model.yFO yfo = pAVar.ZZv().get(0);
                if (yfo != null && yfo.zi()) {
                    com.bytedance.sdk.openadsdk.component.ML.pA pAVar2 = new com.bytedance.sdk.openadsdk.component.ML.pA(yfo.Wf(), yfo, pAVar);
                    JG.this.pA(pAVar2);
                    com.bytedance.sdk.openadsdk.component.ZZv.pA.pA(pAVar2.Og(), 1, duVar);
                    JG.this.Og(adSlot);
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.model.yFO.ML(yfo)) {
                    JG.this.pA(yfo, adSlot, duVar, pAVar);
                } else {
                    JG.this.Og(yfo, adSlot, duVar, pAVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(AdSlot adSlot) {
        AtomicInteger atomicInteger = this.ML.get(adSlot.getCodeId());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
        } else {
            atomicInteger.decrementAndGet();
        }
        this.ML.put(adSlot.getCodeId(), atomicInteger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final com.bytedance.sdk.openadsdk.core.model.yFO yfo, final AdSlot adSlot, final du duVar, final com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
        final int iWf = yfo.Wf();
        pA(yfo, adSlot, duVar, new KZx() { // from class: com.bytedance.sdk.openadsdk.component.JG.5
            @Override // com.bytedance.sdk.openadsdk.component.JG.KZx
            public void pA() {
                com.bytedance.sdk.openadsdk.component.ML.pA pAVar2 = new com.bytedance.sdk.openadsdk.component.ML.pA(iWf, yfo, pAVar);
                JG.this.pA(pAVar2);
                com.bytedance.sdk.openadsdk.component.ZZv.pA.pA(pAVar2.Og(), 1, duVar);
                JG.this.Og(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.component.JG.KZx
            public void pA(int i, String str) {
                JG.this.Og(adSlot);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(final com.bytedance.sdk.openadsdk.core.model.yFO yfo, final AdSlot adSlot, final du duVar, final com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
        final int iWf = yfo.Wf();
        pA(yfo, duVar, new Og() { // from class: com.bytedance.sdk.openadsdk.component.JG.6
            @Override // com.bytedance.sdk.openadsdk.component.JG.Og
            public void pA(com.bytedance.sdk.openadsdk.aBv.pA.Og og) {
                com.bytedance.sdk.openadsdk.component.ML.pA pAVar2 = new com.bytedance.sdk.openadsdk.component.ML.pA(iWf, yfo, pAVar);
                JG.this.pA(pAVar2);
                com.bytedance.sdk.openadsdk.component.ZZv.pA.pA(pAVar2.Og(), 1, duVar);
                JG.this.Og(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.component.JG.Og
            public void pA() {
                JG.this.Og(adSlot);
            }
        });
    }

    public void pA(final com.bytedance.sdk.openadsdk.core.model.yFO yfo, AdSlot adSlot, final du duVar, final KZx kZx) {
        final qmB qmbOg = qmB.Og();
        final int iWf = yfo.Wf();
        com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogBf = yfo.Bf();
        String strBSW = ogBf.BSW();
        String strSn = ogBf.Sn();
        if (TextUtils.isEmpty(strSn)) {
            strSn = com.bytedance.sdk.component.utils.ML.pA(strBSW);
        }
        final File filePA = com.bytedance.sdk.openadsdk.component.SD.pA.pA(strSn);
        if (filePA.exists()) {
            com.bytedance.sdk.openadsdk.component.SD.pA.pA(filePA);
            pA(iWf);
            long jZZv = qmbOg.ZZv();
            if (duVar != null) {
                duVar.pA(jZZv);
                duVar.pA(1);
            }
            kZx.pA();
            pA(yfo, (ZZv) null);
            return;
        }
        if (aBv.ZZv().du(String.valueOf(iWf)) && !DX.ZZv(aBv.pA())) {
            kZx.pA(100, "OnlyWifi");
            return;
        }
        com.bytedance.sdk.openadsdk.core.Wx.pA.Og ogPA = com.bytedance.sdk.openadsdk.core.model.yFO.pA(filePA.getParent(), yfo);
        ogPA.pA("material_meta", yfo);
        ogPA.pA("ad_slot", adSlot);
        com.bytedance.sdk.openadsdk.core.Wx.ML.pA.pA(ogPA, new com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA() { // from class: com.bytedance.sdk.openadsdk.component.JG.7
            @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
            public void Og(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx2, int i) {
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
            public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx2, int i) {
                JG.this.pA(iWf);
                long jZZv2 = qmbOg.ZZv();
                com.bytedance.sdk.openadsdk.component.ZZv.pA.Og(yfo, jZZv2, true);
                du duVar2 = duVar;
                if (duVar2 != null) {
                    duVar2.pA(jZZv2);
                    duVar.pA(2);
                }
                kZx.pA();
                JG.pA(yfo, (ZZv) null);
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
            public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx2, int i, String str) {
                long jZZv2 = qmbOg.ZZv();
                com.bytedance.sdk.openadsdk.component.ZZv.pA.Og(yfo, jZZv2, false);
                du duVar2 = duVar;
                if (duVar2 != null) {
                    duVar2.pA(jZZv2);
                }
                kZx.pA(i, str);
                try {
                    if (filePA.exists() && filePA.isFile()) {
                        com.bytedance.sdk.component.utils.JG.KZx(filePA);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void pA(final com.bytedance.sdk.openadsdk.core.model.yFO yfo, final du duVar, final Og og) {
        final qmB qmbOg = qmB.Og();
        final int iWf = yfo.Wf();
        com.bytedance.sdk.openadsdk.core.model.DX dx = yfo.IIF().get(0);
        String strSD = dx.SD();
        String strPA = dx.pA();
        int iOg = dx.Og();
        int iKZx = dx.KZx();
        String strPA2 = TextUtils.isEmpty(strSD) ? com.bytedance.sdk.component.utils.ML.pA(strPA) : strSD;
        if (TextUtils.isEmpty(strPA2)) {
            if (og != null) {
                og.pA();
                return;
            }
            return;
        }
        File fileOg = com.bytedance.sdk.openadsdk.component.SD.pA.Og(strPA2);
        if (pA(strPA, strSD)) {
            KZx(iWf);
            long jZZv = qmbOg.ZZv();
            if (duVar != null) {
                duVar.pA(jZZv);
                duVar.pA(1);
            }
            og.pA(null);
            return;
        }
        com.bytedance.sdk.openadsdk.utils.DX.pA(new com.bytedance.sdk.openadsdk.aBv.pA(strPA, dx.SD()), iOg, iKZx, new com.bytedance.sdk.openadsdk.utils.DX.pA() { // from class: com.bytedance.sdk.openadsdk.component.JG.8
            @Override // com.bytedance.sdk.openadsdk.utils.DX.pA
            public void pA(com.bytedance.sdk.openadsdk.aBv.pA.Og og2) {
                if (og2.ZZv()) {
                    JG.this.KZx(iWf);
                    long jZZv2 = qmbOg.ZZv();
                    com.bytedance.sdk.openadsdk.component.ZZv.pA.pA(yfo, jZZv2, true);
                    du duVar2 = duVar;
                    if (duVar2 != null) {
                        duVar2.pA(jZZv2);
                        duVar.pA(2);
                    }
                    og.pA(og2);
                    return;
                }
                com.bytedance.sdk.openadsdk.component.ZZv.pA.pA(yfo, qmbOg.ZZv(), false);
                og.pA();
            }

            @Override // com.bytedance.sdk.openadsdk.utils.DX.pA
            public void pA() {
                com.bytedance.sdk.openadsdk.component.ZZv.pA.pA(yfo, qmbOg.ZZv(), false);
                og.pA();
            }
        }, fileOg.getParent());
    }

    public void pA(int i) {
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad", "video_has_cached".concat(String.valueOf(i)), Boolean.TRUE);
    }

    public boolean Og(int i) {
        return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad", "video_has_cached".concat(String.valueOf(i)), false);
    }

    public void KZx(int i) {
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad", "image_has_cached".concat(String.valueOf(i)), Boolean.TRUE);
    }

    public boolean ZZv(int i) {
        return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad", "image_has_cached".concat(String.valueOf(i)), false);
    }

    public void pA(com.bytedance.sdk.openadsdk.component.ML.pA pAVar) {
        if (pAVar.Og() == null || com.bytedance.sdk.openadsdk.core.model.yFO.JG(pAVar.Og())) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad", "material_expiration_time" + pAVar.pA(), Long.valueOf(pAVar.Og().Qj()));
        Og(pAVar);
    }

    public com.bytedance.sdk.openadsdk.core.model.yFO ML(int i) {
        com.bytedance.sdk.openadsdk.core.model.yFO yfoJG;
        if (com.bytedance.sdk.openadsdk.common.pA.pA()) {
            com.bytedance.sdk.openadsdk.core.model.pA pAVarPA = com.bytedance.sdk.openadsdk.common.pA.pA("tt_openad_materialMeta").pA(String.valueOf(i), false);
            yfoJG = pAVarPA != null ? pAVarPA.JG() : null;
        } else {
            yfoJG = JG(i);
        }
        long jPA = com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad", "material_expiration_time".concat(String.valueOf(i)), -1L);
        if (System.currentTimeMillis() / 1000 < jPA && yfoJG != null) {
            return yfoJG;
        }
        if (yfoJG != null || jPA != -1) {
            SD(i);
            if (yfoJG != null) {
                com.bytedance.sdk.openadsdk.component.ZZv.pA.pA(yfoJG);
            }
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.model.yFO JG(int i) {
        String strOg = com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og("tt_openad_materialMeta", "material".concat(String.valueOf(i)), null);
        if (!TextUtils.isEmpty(strOg)) {
            try {
                JSONObject jSONObjectPA = aBv.KZx().pA(PangleNetworkBridge.jsonObjectInit(strOg));
                if (jSONObjectPA.has("creatives")) {
                    return com.bytedance.sdk.openadsdk.core.model.pA.KZx(jSONObjectPA).JG();
                }
                return com.bytedance.sdk.openadsdk.core.Og.pA(jSONObjectPA);
            } catch (Exception e) {
                WV.pA("TTAppOpenAdCacheManager", e.getMessage());
            }
        }
        return null;
    }

    private void Og(com.bytedance.sdk.openadsdk.component.ML.pA pAVar) {
        xy.pA(new pA(pAVar), 5);
    }

    public String pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (yfo != null && yfo.Bf() != null && !TextUtils.isEmpty(yfo.Bf().BSW())) {
            String strBSW = yfo.Bf().BSW();
            String strSn = yfo.Bf().Sn();
            if (TextUtils.isEmpty(strSn)) {
                strSn = com.bytedance.sdk.component.utils.ML.pA(strBSW);
            }
            File filePA = com.bytedance.sdk.openadsdk.component.SD.pA.pA(strSn);
            if (filePA.exists() && filePA.isFile()) {
                return filePA.getAbsolutePath();
            }
        }
        return null;
    }

    public boolean Og(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (yfo == null || yfo.IIF() == null || yfo.IIF().size() == 0 || TextUtils.isEmpty(yfo.IIF().get(0).pA())) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.model.DX dx = yfo.IIF().get(0);
        return pA(dx.pA(), dx.SD());
    }

    public boolean pA(String str, String str2) {
        boolean z;
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = com.bytedance.sdk.component.utils.ML.pA(str);
            }
            File fileOg = com.bytedance.sdk.openadsdk.component.SD.pA.Og(str2);
            InputStream inputStreamPA = com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(str, str2);
            if (inputStreamPA != null) {
                try {
                    inputStreamPA.close();
                } catch (IOException e) {
                    WV.pA("TTAppOpenAdCacheManager", e.getMessage());
                }
                z = true;
            } else {
                z = false;
            }
            if (z || !(com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(str, str2, fileOg.getParent()) || new File(fileOg.getPath() + ".0").exists())) {
                return z;
            }
            return true;
        } catch (Exception e2) {
            WV.pA("TTAppOpenAdCacheManager", e2.getMessage());
            return false;
        }
    }

    public void pA(File file) {
        try {
            this.Og.pA(file);
        } catch (IOException e) {
            WV.pA("TTAppOpenAdCacheManager", "trimFileCache fail", e);
        }
    }

    public void SD(int i) {
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad_materialMeta", "material".concat(String.valueOf(i)));
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad", "material_expiration_time".concat(String.valueOf(i)));
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad", "video_has_cached".concat(String.valueOf(i)));
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad", "image_has_cached".concat(String.valueOf(i)));
    }

    public void pA() {
        File[] fileArrListFiles;
        try {
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad_materialMeta");
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad");
        } catch (Throwable unused) {
        }
        try {
            File cacheDir = this.ZZv.getCacheDir();
            if (cacheDir == null || !cacheDir.exists() || !cacheDir.isDirectory() || (fileArrListFiles = cacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.JG.9
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file == null) {
                        return false;
                    }
                    String name = file.getName();
                    return name.contains("openad_image_cache") || name.contains("openad_video_cache");
                }
            })) == null) {
                return;
            }
            for (File file : fileArrListFiles) {
                try {
                    com.bytedance.sdk.component.utils.JG.KZx(file);
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
        }
    }

    public String Og() {
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            return name + "/openad_image_cache/";
        }
        return name + "//openad_image_cache/";
    }

    private int KZx(AdSlot adSlot) {
        long jPA = com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad", "material_expiration_time" + adSlot.getCodeId(), -1L);
        new Object[]{"local cache number : ", Integer.valueOf(jPA == -1 ? 0 : 1)};
        return jPA == -1 ? 0 : 1;
    }

    private class pA extends com.bytedance.sdk.component.omh.omh {
        private final com.bytedance.sdk.openadsdk.component.ML.pA Og;

        public pA(com.bytedance.sdk.openadsdk.component.ML.pA pAVar) {
            super("App Open Ad Write Cache");
            this.Og = pAVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.bytedance.sdk.openadsdk.common.pA.pA()) {
                    com.bytedance.sdk.openadsdk.common.pA.pA("tt_openad_materialMeta").pA(this.Og.Og().rB(), this.Og.KZx());
                } else {
                    com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tt_openad_materialMeta", "material" + this.Og.pA(), com.bytedance.sdk.component.utils.pA.pA(this.Og.Og().jO()).toString());
                }
            } catch (Throwable unused) {
            }
        }
    }
}
