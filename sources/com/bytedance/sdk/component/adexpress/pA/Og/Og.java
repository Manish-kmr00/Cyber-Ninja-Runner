package com.bytedance.sdk.component.adexpress.pA.Og;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.adexpress.ZZv.SGo;
import com.bytedance.sdk.component.utils.WV;
import com.json.cc;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class Og {
    static Object pA = new Object();

    public static void pA() {
        ML.Og();
    }

    public static void Og() {
        try {
            omh.ZZv();
            File fileOmh = ML.omh();
            if (fileOmh == null || !fileOmh.exists()) {
                return;
            }
            if (fileOmh.getParentFile() != null) {
                com.bytedance.sdk.component.utils.JG.KZx(fileOmh.getParentFile());
            } else {
                com.bytedance.sdk.component.utils.JG.KZx(fileOmh);
            }
        } catch (Throwable unused) {
        }
    }

    public static String KZx() {
        return JG.KZx();
    }

    public static com.bytedance.sdk.component.adexpress.pA.KZx.Og pA(String str) {
        return SD.pA().pA(str);
    }

    public static void pA(com.bytedance.sdk.component.adexpress.pA.KZx.ZZv zZv) {
        SD.pA().pA(zZv, zZv.JG);
    }

    public static Set<String> Og(String str) {
        return SD.pA().Og(str);
    }

    public static com.bytedance.sdk.component.adexpress.pA.KZx.Og KZx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.pA.KZx.Og ogPA = SD.pA().pA(str);
        if (ogPA != null) {
            ogPA.pA(Long.valueOf(System.currentTimeMillis()));
            pA(ogPA);
        }
        return ogPA;
    }

    private static void pA(final com.bytedance.sdk.component.adexpress.pA.KZx.Og og) {
        com.bytedance.sdk.component.adexpress.ZZv.ZZv.pA(new com.bytedance.sdk.component.omh.omh("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.pA.Og.Og.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (Og.pA) {
                    JG.pA().pA(og, true);
                }
            }
        }, 10);
    }

    public static com.bytedance.sdk.component.adexpress.pA.KZx.pA ZZv() {
        return ML.Og().JG();
    }

    @Deprecated
    private static String JG() {
        com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVarZZv = ZZv();
        if (pAVarZZv == null) {
            return null;
        }
        return pAVarZZv.ZZv();
    }

    public static String ZZv(String str) {
        com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar;
        com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVarZZv = ZZv();
        if (pAVarZZv == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            Map<String, com.bytedance.sdk.component.adexpress.pA.KZx.pA> mapPA = pAVarZZv.pA();
            if (mapPA == null || mapPA.size() <= 0 || (pAVar = mapPA.get(str)) == null) {
                return null;
            }
            return pAVar.ZZv();
        }
        return JG();
    }

    public static boolean ML() {
        return ML.Og().ML();
    }

    public static pA pA(String str, SGo.pA pAVar, String str2, String str3) {
        File fileJG;
        pA pAVar2 = new pA();
        if (TextUtils.isEmpty(str3)) {
            fileJG = null;
        } else {
            fileJG = Og(str3, str);
            if (fileJG != null) {
                pAVar2.pA(1);
            }
        }
        if (fileJG == null && (fileJG = SD(str)) != null) {
            pAVar2.pA(3);
        }
        if (fileJG == null && (fileJG = JG(str)) != null) {
            pAVar2.pA(2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!pA(str, str3)) {
                pAVar2.pA(4);
            }
        } else if (!ML(str)) {
            pAVar2.pA(6);
        }
        pAVar2.Og();
        if (fileJG != null) {
            try {
                pAVar2.pA(new WebResourceResponse(pAVar.pA(), cc.N, new FileInputStream(fileJG)));
            } catch (Throwable th) {
                WV.pA("TTDynamic", "get html WebResourceResponse error", th);
            }
        }
        return pAVar2;
    }

    private static boolean pA(String str, String str2) {
        com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVarZZv;
        com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar;
        if (!ML() || (pAVarZZv = ZZv()) == null) {
            return false;
        }
        Map<String, com.bytedance.sdk.component.adexpress.pA.KZx.pA> mapPA = pAVarZZv.pA();
        if (mapPA.size() == 0 || (pAVar = mapPA.get(str2)) == null) {
            return false;
        }
        for (com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA c0204pA : pAVar.JG()) {
            if (c0204pA != null && TextUtils.equals(str, c0204pA.pA())) {
                return true;
            }
        }
        return false;
    }

    private static boolean ML(String str) {
        com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVarZZv;
        List<com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA> listJG;
        if (!ML() || (pAVarZZv = ZZv()) == null || (listJG = pAVarZZv.JG()) == null) {
            return false;
        }
        for (com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA c0204pA : listJG) {
            if (c0204pA != null && TextUtils.equals(str, c0204pA.pA())) {
                return true;
            }
        }
        return false;
    }

    private static File JG(String str) {
        if (!ML()) {
            return null;
        }
        for (com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA c0204pA : ZZv().JG()) {
            if (c0204pA.pA() != null && c0204pA.pA().equals(str)) {
                File file = new File(ML.omh(), com.bytedance.sdk.component.utils.ML.pA(c0204pA.pA()));
                String strPA = com.bytedance.sdk.component.utils.ML.pA(file);
                if (c0204pA.Og() == null || !c0204pA.Og().equals(strPA)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    private static File SD(String str) {
        List<Pair<String, String>> listOg;
        com.bytedance.sdk.component.adexpress.pA.KZx.pA.Og ogML = ZZv().ML();
        if (ogML == null || (listOg = ogML.Og()) == null || listOg.size() <= 0) {
            return null;
        }
        for (Pair<String, String> pair : listOg) {
            if (pair.second != null && ((String) pair.second).equals(str)) {
                return new File(ML.omh(), (String) pair.first);
            }
        }
        return null;
    }

    private static File Og(String str, String str2) {
        com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar;
        com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVarZZv = ZZv();
        if (pAVarZZv == null || !ML()) {
            return null;
        }
        Map<String, com.bytedance.sdk.component.adexpress.pA.KZx.pA> mapPA = pAVarZZv.pA();
        if (mapPA.size() == 0 || (pAVar = mapPA.get(str)) == null) {
            return null;
        }
        for (com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA c0204pA : pAVar.JG()) {
            if (c0204pA.pA() != null && c0204pA.pA().equals(str2)) {
                File file = new File(ML.omh(), com.bytedance.sdk.component.utils.ML.pA(c0204pA.pA()));
                String strPA = com.bytedance.sdk.component.utils.ML.pA(file);
                if (c0204pA.Og() == null || !c0204pA.Og().equals(strPA)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    public static boolean pA(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    public static boolean Og(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("xTemplate")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    public static boolean KZx(JSONObject jSONObject) {
        Object objOpt;
        if (jSONObject == null) {
            return false;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject == null || (objOpt = jSONObjectOptJSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
