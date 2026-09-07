package com.bytedance.sdk.openadsdk.core.ZZv;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.JG;
import com.bytedance.sdk.component.utils.ML;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.Sn.pA.ZZv;
import com.bytedance.sdk.openadsdk.core.Wx.KZx.KZx;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.multipro.Og;
import com.vungle.ads.internal.protos.Sdk;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pA {
    private final List<String> pA = new CopyOnWriteArrayList();
    private final KZx Og = new KZx(5, 5, true);
    private final ConcurrentHashMap<String, Long> KZx = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ZZv.pA$pA, reason: collision with other inner class name */
    private static class C0241pA {
        private static final pA pA = new pA();
    }

    public static pA pA() {
        return C0241pA.pA;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
        List<yFO> listZZv = pAVar.ZZv();
        if (listZZv == null || listZZv.size() == 0) {
            return;
        }
        for (int i = 0; i < listZZv.size(); i++) {
            yFO yfo = listZZv.get(i);
            if (yfo != null) {
                pA(yfo);
            }
        }
    }

    public InputStream pA(String str) {
        File fileOg = Og(str);
        if (fileOg != null && pA(fileOg)) {
            try {
                return new FileInputStream(fileOg);
            } catch (Exception e) {
                WV.pA("MusicCacheManager", e.getMessage());
            }
        }
        return null;
    }

    private void pA(yFO yfo) {
        yFO.pA pAVarCIG;
        String strBSW;
        if (yfo == null || (pAVarCIG = yfo.CIG()) == null || (strBSW = pAVarCIG.BSW()) == null || !strBSW.contains("music_url")) {
            return;
        }
        KZx();
        String strZZv = pAVarCIG.ZZv();
        if (TextUtils.isEmpty(strZZv)) {
            try {
                new JSONObject().put("result", 0);
            } catch (JSONException e) {
                WV.pA("MusicCacheManager", e.getMessage());
            }
            pA(0, -1L, Sdk.SDKError.Reason.AD_NO_FILL_VALUE, "music url string is null");
            return;
        }
        File fileOg = Og(strZZv);
        if (fileOg == null) {
            return;
        }
        new Object[]{"music cache file is:", fileOg.getPath()};
        if (pA(fileOg)) {
            new Object[]{"has music cache:", Boolean.TRUE};
            pA(2, -1L, -1, null);
        } else {
            new Object[]{"has music cache:", Boolean.FALSE};
            pA(yfo, strZZv, fileOg);
        }
    }

    public File Og(String str) {
        String str2;
        String strPA = ML.pA(str);
        if (strPA == null) {
            return null;
        }
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (Og.KZx()) {
            str2 = name + "/music/";
        } else {
            str2 = name + "//music/";
        }
        new Object[]{"cachePath is:", str2, ", musicCacheName is:", strPA};
        return JG.pA(aBv.pA(), Og.KZx(), str2, strPA);
    }

    private boolean pA(File file) {
        return file.exists() && file.length() != 0;
    }

    private void pA(yFO yfo, String str, File file) {
        if (KZx(str)) {
            this.KZx.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
            com.bytedance.sdk.component.SD.Og.pA pAVarZZv = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().ZZv();
            pAVarZZv.Og(str);
            pAVarZZv.pA(file.getParent(), file.getName());
            pAVarZZv.KZx(str);
            this.pA.add(str);
            pAVarZZv.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.openadsdk.core.ZZv.pA.1
                @Override // com.bytedance.sdk.component.SD.pA.pA
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og) {
                    new Object[]{"get response header:", og.KZx()};
                    new Object[]{"download music response, response is:", Integer.valueOf(og.pA())};
                    String strKZx = kZx.KZx();
                    Long l = (Long) pA.this.KZx.get(strKZx);
                    if (og.JG() && og.ML() != null && og.ML().exists()) {
                        new Object[]{"download music success, ", "file is:", og.ML()};
                        if (l != null) {
                            pA.this.KZx.remove(strKZx);
                            pA.this.pA(1, SystemClock.elapsedRealtime() - l.longValue(), -1, null);
                        }
                        try {
                            JG.Og(og.ML());
                        } catch (IOException e) {
                            WV.pA("MusicCacheManager", e.getMessage());
                        }
                    }
                    if (og.JG() || l == null) {
                        return;
                    }
                    pA.this.pA(0, SystemClock.elapsedRealtime() - l.longValue(), -2, "http response status code isn't 200");
                }

                @Override // com.bytedance.sdk.component.SD.pA.pA
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
                    Long l = (Long) pA.this.KZx.get(kZx.KZx());
                    if (l != null) {
                        pA.this.pA(0, SystemClock.elapsedRealtime() - l.longValue(), -2, "http response status code isn't 200");
                    }
                }
            });
        }
    }

    private boolean KZx(String str) {
        return !this.pA.contains(str);
    }

    public void Og() {
        File filePA = pA(aBv.pA(), Og.KZx());
        new Object[]{"trimMusicFileCache, dir is ", filePA.getAbsolutePath()};
        try {
            this.Og.pA(filePA);
        } catch (IOException e) {
            WV.pA("MusicCacheManager", "trimFileCache fail", e);
        }
    }

    private File pA(Context context, boolean z) {
        String str;
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (Og.KZx()) {
            str = name + "/music";
        } else {
            str = name + "//music";
        }
        new Object[]{"cachePath is:", str};
        return JG.pA(context, z, str);
    }

    public void KZx() {
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("music_preload_start", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.core.ZZv.pA.2
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                ZZv zZvPA = ZZv.Og().pA("music_preload_start");
                new Object[]{"report music_preload_start", zZvPA.pA()};
                return zZvPA;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final int i, final long j, final int i2, final String str) {
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("music_preload_finish", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.core.ZZv.pA.3
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", i);
                long j2 = j;
                if (j2 != -1) {
                    jSONObject.put("load_duration", j2);
                }
                ZZv zZvOg = ZZv.Og().pA("music_preload_finish").Og(jSONObject.toString());
                if (!TextUtils.isEmpty(str)) {
                    zZvOg.Og(i2);
                    zZvOg.JG(str);
                }
                new Object[]{"report music_preload_finish", zZvOg.pA()};
                return zZvOg;
            }
        });
    }

    public void pA(final boolean z) {
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("music_cache", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.core.ZZv.pA.4
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", z);
                ZZv zZvOg = ZZv.Og().pA("music_cache").Og(jSONObject.toString());
                new Object[]{"report music_cache", zZvOg.pA()};
                return zZvOg;
            }
        });
    }
}
