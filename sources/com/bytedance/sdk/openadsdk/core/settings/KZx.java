package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.utils.lT;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class KZx {
    private static final ConcurrentHashMap<String, Og> pA = new ConcurrentHashMap<>();

    public static void pA(boolean z) {
        String strPA;
        File fileOg = Og();
        if (!fileOg.exists()) {
            if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                strPA = com.bytedance.sdk.openadsdk.multipro.ZZv.pA.Og("tt_sdk_settings", "ad_slot_conf", null);
            } else {
                strPA = lT.pA("tt_sdk_settings", aBv.pA()).pA("ad_slot_conf", (String) null);
            }
            if (TextUtils.isEmpty(strPA)) {
                return;
            }
            try {
                HashMap<String, Og> mapOg = Og(new JSONArray(strPA));
                if (mapOg.isEmpty()) {
                    return;
                }
                ConcurrentHashMap<String, Og> concurrentHashMap = pA;
                concurrentHashMap.clear();
                concurrentHashMap.putAll(mapOg);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        try {
            HashMap<String, Og> mapOg2 = Og(new JSONArray(new String(com.bytedance.sdk.component.utils.JG.ZZv(fileOg))));
            if (mapOg2.isEmpty()) {
                return;
            }
            for (Map.Entry<String, Og> entry : mapOg2.entrySet()) {
                String key = entry.getKey();
                Og value = entry.getValue();
                if (value.qmB && !z) {
                    Og og = pA.get(key);
                    if (og != null) {
                        og.Bf = value.Gx;
                    }
                } else {
                    pA.put(key, value);
                }
            }
        } catch (Exception unused2) {
        }
    }

    private static HashMap<String, Og> Og(JSONArray jSONArray) {
        HashMap<String, Og> map = new HashMap<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Og ogPA = pA(jSONArray.getJSONObject(i));
                if (ogPA != null) {
                    map.put(ogPA.pA, ogPA);
                }
            } catch (Exception unused) {
            }
        }
        return map;
    }

    private static File Og() {
        return new File(aBv.pA().getFilesDir(), "tt_ads_conf");
    }

    private static Og pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new Og(jSONObject);
    }

    public static Og pA(String str) {
        Og og = pA.get(str);
        return og == null ? Og(str) : og;
    }

    private static Og Og(String str) {
        return new Og(str, 1);
    }

    public static void pA(JSONArray jSONArray) throws Throwable {
        if (jSONArray == null) {
            return;
        }
        File fileOg = Og();
        File file = new File(fileOg.getParent(), fileOg.getName() + ".tmp");
        FileWriter fileWriter = null;
        try {
            try {
                if (file.exists()) {
                    file.delete();
                }
                FileWriter fileWriter2 = new FileWriter(file);
                try {
                    fileWriter2.write(jSONArray.toString());
                    file.renameTo(fileOg);
                    lT.pA("tt_sdk_settings", aBv.pA()).pA("ad_slot_conf");
                    if (file.exists()) {
                        file.delete();
                    }
                    com.bytedance.sdk.openadsdk.utils.BSW.pA(fileWriter2);
                } catch (Exception e) {
                    e = e;
                    fileWriter = fileWriter2;
                    Log.e("SdkSettings.AdSlot", "saveAdSlotToLocal: ", e);
                    if (file.exists()) {
                        file.delete();
                    }
                    com.bytedance.sdk.openadsdk.utils.BSW.pA(fileWriter);
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    if (file.exists()) {
                        file.delete();
                    }
                    com.bytedance.sdk.openadsdk.utils.BSW.pA(fileWriter);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            HashMap<String, Og> mapOg = Og(jSONArray);
            if (mapOg.isEmpty()) {
                return;
            }
            for (Map.Entry<String, Og> entry : mapOg.entrySet()) {
                String key = entry.getKey();
                Og value = entry.getValue();
                if (value.qmB) {
                    Og og = pA.get(key);
                    if (og != null) {
                        og.Bf = value.Gx;
                    }
                } else {
                    pA.put(key, value);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void pA() {
        File fileOg = Og();
        if (fileOg.exists()) {
            fileOg.delete();
        }
    }
}
