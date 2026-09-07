package com.bytedance.sdk.openadsdk.core.Wx.KZx;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.JG;
import com.bytedance.sdk.component.utils.ML;
import com.bytedance.sdk.component.utils.Sn;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.component.utils.eG;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.bytedance.sdk.openadsdk.yFO.pA.ZZv;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.cc;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.d;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import com.vungle.ads.internal.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class pA {
    private static volatile pA pA;
    private String Og;
    private final Map<yFO, Og> KZx = new ConcurrentHashMap();
    private final Map<String, JSONObject> ZZv = new ConcurrentHashMap();
    private final AtomicBoolean ML = new AtomicBoolean(false);
    private final Set<String> JG = Collections.synchronizedSet(new HashSet());
    private final ConcurrentHashMap<String, com.bytedance.sdk.component.SD.Og.pA> SD = new ConcurrentHashMap<>();
    private final Map<String, String> omh = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.Wx.KZx.pA$pA, reason: collision with other inner class name */
    public interface InterfaceC0236pA {
    }

    public static pA pA() {
        if (pA == null) {
            synchronized (pA.class) {
                if (pA == null) {
                    pA = new pA();
                }
            }
        }
        return pA;
    }

    private pA() {
    }

    public boolean pA(yFO yfo) {
        if (this.ML.get() && yfo != null && yfo.Bf() != null && yfo.Bf().Wx() != null) {
            try {
                if (!TextUtils.isEmpty(this.omh.get(ML.pA(yfo.Bf().Wx())))) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void Og() {
        if (this.ML.get()) {
            return;
        }
        xy.pA(new omh("PlayableCache_init") { // from class: com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.1
            @Override // java.lang.Runnable
            public void run() {
                File[] fileArrListFiles;
                try {
                    String strZZv = pA.this.ZZv();
                    if (!TextUtils.isEmpty(strZZv)) {
                        File file = new File(strZZv);
                        if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                            for (File file2 : fileArrListFiles) {
                                if (file2 != null) {
                                    try {
                                        File filePA = pA.pA(file2);
                                        if (filePA != null && filePA.exists()) {
                                            pA.this.omh.put(file2.getName(), filePA.getAbsolutePath());
                                        }
                                        pA.this.pA(pA.this.ZZv(filePA), true);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
                com.bytedance.sdk.openadsdk.yFO.pA.KZx.pA().pA(pA.this.omh);
                pA.this.ML.set(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject pA(File file, boolean z) {
        byte[] bArrZZv;
        String strOg;
        try {
            if (!ML(file) || (bArrZZv = JG.ZZv(file)) == null || bArrZZv.length <= 0) {
                return null;
            }
            if (TextUtils.equals(file.getName(), "tt_open_ad_sdk_check_res.dat")) {
                strOg = com.bytedance.sdk.component.utils.pA.KZx(new String(bArrZZv));
            } else {
                strOg = com.bytedance.sdk.component.ZZv.pA.Og(new String(bArrZZv), com.bytedance.sdk.openadsdk.core.pA.Og());
            }
            if (TextUtils.isEmpty(strOg)) {
                return null;
            }
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(strOg);
            if (z && jSONObjectJsonObjectInit.length() > 0) {
                this.ZZv.put(file.getParentFile().getName(), jSONObjectJsonObjectInit);
            }
            return jSONObjectJsonObjectInit;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File ZZv(File file) {
        File file2 = new File(file, "tt_open_ad_sdk_check_res.dat");
        return ML(file2) ? file2 : new File(file, "tt_open_ad_sdk_check_res.dat");
    }

    private boolean ML(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead();
    }

    public WebResourceResponse pA(String str, String str2, String str3) {
        File filePA;
        try {
            WebResourceResponse webResourceResponsePA = com.bytedance.sdk.openadsdk.yFO.pA.KZx.pA().pA(str3);
            if (webResourceResponsePA != null) {
                return webResourceResponsePA;
            }
            if (this.ML.get() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                try {
                    if ((str3.startsWith(d.v) || str3.startsWith("https://")) && str3.contains("?")) {
                        str3 = str3.split("\\?")[0];
                        if (str3.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                            str3 = str3.substring(0, str3.length() - 1);
                        }
                    }
                } catch (Throwable unused) {
                }
                String strPA = Sn.pA(aBv.pA(), str3);
                com.bytedance.sdk.openadsdk.Sn.KZx.KZx(strPA, str3);
                if (TextUtils.isEmpty(strPA)) {
                    return null;
                }
                String strPA2 = ML.pA(str);
                if (TextUtils.isEmpty(strPA2)) {
                    return null;
                }
                String str4 = this.omh.get(strPA2);
                if (!TextUtils.isEmpty(str4)) {
                    filePA = new File(str4);
                } else {
                    filePA = pA(new File(ZZv(), strPA2));
                    if (filePA != null && filePA.exists()) {
                        this.omh.put(strPA2, filePA.getAbsolutePath());
                    }
                }
                if (filePA != null && filePA.exists()) {
                    String strPA3 = pA(str2);
                    if (TextUtils.isEmpty(strPA3)) {
                        return null;
                    }
                    String strReplace = str3.replace(strPA3, "");
                    if (!TextUtils.isEmpty(strReplace) && !strReplace.startsWith("https://") && !strReplace.startsWith(d.v)) {
                        File file = new File(filePA, strReplace);
                        if (file.exists() && pA(strPA2, strReplace, file) && file.getCanonicalPath().startsWith(filePA.getCanonicalPath())) {
                            return new WebResourceResponse(strPA, cc.N, new FileInputStream(file));
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            WV.pA("PlayableCache", "playable intercept error: ", th);
        }
        return null;
    }

    public static File pA(File file) {
        File[] fileArrListFiles;
        if (file != null && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                if (file2 != null && file2.isFile() && Constants.AD_INDEX_FILE_NAME.equals(file2.getName())) {
                    return file;
                }
            }
            for (File file3 : fileArrListFiles) {
                if (file3 != null && file3.isDirectory()) {
                    return pA(file3);
                }
            }
        }
        return null;
    }

    private String pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("\\?");
        if (strArrSplit != null && strArrSplit.length == 2) {
            String str2 = strArrSplit[0];
            if (str2 != null && str2.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                str = str.substring(0, strArrSplit.length - 1);
            }
            String str3 = strArrSplit[0];
            if (str3 != null && str3.endsWith(Constants.AD_INDEX_FILE_NAME)) {
                str = strArrSplit[0];
            }
        }
        return str.replace(Constants.AD_INDEX_FILE_NAME, "");
    }

    private boolean pA(String str, String str2, File file) {
        if (file != null && file.exists()) {
            JSONObject jSONObject = this.ZZv.get(str);
            if (jSONObject == null) {
                return true;
            }
            String strOptString = jSONObject.optString(str2);
            if (strOptString != null && strOptString.equalsIgnoreCase(ML.pA(file))) {
                return true;
            }
        }
        return false;
    }

    public void pA(final yFO yfo, final InterfaceC0236pA interfaceC0236pA) {
        File file;
        if (ZZv.pA().Og() && yfo != null && WQf.JG(yfo) && yfo.rB() != null && !TextUtils.isEmpty(yfo.rB().getBidAdm())) {
            com.bytedance.sdk.openadsdk.core.Wx.KZx.Og.pA(yfo, -705, "server bidding pre render");
            pA(interfaceC0236pA, false);
            return;
        }
        if (yfo == null || yfo.Bf() == null || TextUtils.isEmpty(yfo.Bf().Wx())) {
            com.bytedance.sdk.openadsdk.core.Wx.KZx.Og.pA(yfo, -701, (String) null);
            pA(interfaceC0236pA, false);
            return;
        }
        final String strWx = yfo.Bf().Wx();
        if (this.JG.contains(strWx)) {
            return;
        }
        this.KZx.put(yfo, new Og().pA(System.currentTimeMillis()));
        com.bytedance.sdk.openadsdk.core.Wx.KZx.Og.pA(yfo);
        String strPA = ML.pA(strWx);
        final File file2 = new File(ZZv(), strPA);
        String str = this.omh.get(strPA);
        if (TextUtils.isEmpty(str)) {
            file = pA(file2);
            if (file != null && file.exists()) {
                this.omh.put(strPA, file.getAbsolutePath());
            }
        } else {
            file = new File(str);
        }
        if (file != null && file.exists()) {
            com.bytedance.sdk.openadsdk.core.Wx.KZx.Og.pA(yfo, -702, (String) null);
            KZx(file2);
            this.KZx.remove(yfo);
            pA(interfaceC0236pA, true);
            return;
        }
        try {
            JG.KZx(file2);
        } catch (Throwable unused) {
        }
        this.JG.add(strWx);
        File file3 = new File(ML(), strPA + ".zip");
        com.bytedance.sdk.component.SD.Og.pA pAVarZZv = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().ZZv();
        this.SD.put(strWx, pAVarZZv);
        pAVarZZv.Og(strWx);
        pAVarZZv.pA(file3.getParent(), file3.getName());
        pAVarZZv.pA(7);
        pAVarZZv.pA("playable_download");
        pAVarZZv.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.2
            @Override // com.bytedance.sdk.component.SD.pA.pA
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, final com.bytedance.sdk.component.SD.Og og) {
                pA.this.JG.remove(strWx);
                pA.this.SD.remove(strWx);
                final Og og2 = (Og) pA.this.KZx.remove(yfo);
                if (og2 != null) {
                    og2.Og(System.currentTimeMillis());
                }
                if (og.JG() && og.ML() != null && og.ML().exists()) {
                    xy.Og(new omh("downloadZip") { // from class: com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z;
                            long jPA;
                            long jOg;
                            try {
                                Og og3 = og2;
                                if (og3 != null) {
                                    og3.KZx(System.currentTimeMillis());
                                }
                                eG.pA(og.ML().getAbsolutePath(), file2.getAbsolutePath());
                                Og og4 = og2;
                                if (og4 != null) {
                                    og4.ZZv(System.currentTimeMillis());
                                }
                                Og og5 = og2;
                                if (og5 != null) {
                                    jPA = og5.pA();
                                    jOg = og2.Og();
                                } else {
                                    jPA = 0;
                                    jOg = 0;
                                }
                                com.bytedance.sdk.openadsdk.core.Wx.KZx.Og.pA(yfo, jPA, jOg);
                                pA.Og(file2);
                                z = true;
                                try {
                                    File filePA = pA.pA(file2);
                                    if (filePA != null && filePA.exists()) {
                                        pA.this.omh.put(file2.getName(), filePA.getAbsolutePath());
                                    }
                                    pA.this.pA(pA.this.ZZv(filePA), true);
                                } catch (Throwable unused2) {
                                }
                            } catch (Throwable th) {
                                WV.pA("PlayableCache", "unzip error: ", th);
                                com.bytedance.sdk.openadsdk.core.Wx.KZx.Og.pA(yfo, -704, th.getMessage());
                                z = false;
                            }
                            try {
                                og.ML().delete();
                            } catch (Throwable unused3) {
                            }
                            pA.this.pA(interfaceC0236pA, z);
                        }
                    });
                } else {
                    com.bytedance.sdk.openadsdk.core.Wx.KZx.Og.pA(yfo, og.pA() != 0 ? og.pA() : -700, (String) null);
                    pA.this.pA(interfaceC0236pA, false);
                }
            }

            @Override // com.bytedance.sdk.component.SD.pA.pA
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
                pA.this.JG.remove(strWx);
                pA.this.SD.remove(strWx);
                pA.this.KZx.remove(yfo);
                com.bytedance.sdk.openadsdk.core.Wx.KZx.Og.pA(yfo, -700, iOException.getMessage());
                pA.this.pA(interfaceC0236pA, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final InterfaceC0236pA interfaceC0236pA, final boolean z) {
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.3
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    public static void Og(File file) {
        KZx(file);
        try {
            Bzk.Og().Sn().pA(file);
        } catch (Throwable unused) {
        }
    }

    public static void KZx(File file) {
        try {
            if (!file.exists() || file.setLastModified(System.currentTimeMillis())) {
                return;
            }
            file.renameTo(file);
            file.lastModified();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ZZv() {
        File file = new File(ML(), "games");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private String ML() {
        if (TextUtils.isEmpty(this.Og)) {
            try {
                File file = new File(aBv.pA().getCacheDir(), "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.Og = file.getAbsolutePath();
            } catch (Throwable th) {
                WV.pA("PlayableCache", "init root path error: ".concat(String.valueOf(th)));
            }
        }
        return this.Og;
    }

    private static class Og {
        long KZx;
        long Og;
        long ZZv;
        long pA;

        private Og() {
        }

        public long pA() {
            return this.Og - this.pA;
        }

        public long Og() {
            return this.ZZv - this.KZx;
        }

        public Og pA(long j) {
            this.pA = j;
            return this;
        }

        public Og Og(long j) {
            this.Og = j;
            return this;
        }

        public Og KZx(long j) {
            this.KZx = j;
            return this;
        }

        public Og ZZv(long j) {
            this.ZZv = j;
            return this;
        }
    }

    public void Og(yFO yfo) {
        if (yfo == null || yfo.Bf() == null || TextUtils.isEmpty(yfo.Bf().Wx()) || !com.bytedance.sdk.openadsdk.vZF.pA.pA("can_cancel_playable", false)) {
            return;
        }
        com.bytedance.sdk.component.SD.Og.pA pAVar = this.SD.get(yfo.Bf().Wx());
        if (pAVar != null) {
            pAVar.Og();
        }
    }

    public Map<String, String> KZx() {
        return this.omh;
    }
}
