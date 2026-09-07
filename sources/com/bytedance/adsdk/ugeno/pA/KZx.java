package com.bytedance.adsdk.ugeno.pA;

import android.text.TextUtils;
import android.util.Pair;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.adjust.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class KZx {
    public static int pA(int i) {
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return 1;
        }
        return i - 1;
    }

    public static Og pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Og og = new Og();
        og.Og(jSONObject.optLong("delay"));
        og.pA(jSONObject.optLong("duration"));
        og.pA(jSONObject.optInt("playCount", 1));
        og.pA(jSONObject.optString("playDirection"));
        og.pA(ZZv(jSONObject.optString("transformOrigin")));
        og.Og(jSONObject.optString("timingFunction", "linear"));
        og.pA(jSONObject.optJSONObject("effect"));
        og.pA(pA(jSONObject.optJSONArray("keyframes")));
        return og;
    }

    public static Map<String, TreeMap<Float, String>> pA(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                float fOptDouble = (float) jSONObjectOptJSONObject.optDouble("offset");
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    TreeMap treeMap = (TreeMap) map.get(next);
                    if (!TextUtils.equals(next, "offset")) {
                        if (map.containsKey(next) && treeMap != null) {
                            treeMap.put(Float.valueOf(fOptDouble), jSONObjectOptJSONObject.optString(next));
                        } else {
                            TreeMap treeMap2 = new TreeMap();
                            new Pair(Float.valueOf(fOptDouble), jSONObjectOptJSONObject.optString(next));
                            treeMap2.put(Float.valueOf(fOptDouble), jSONObjectOptJSONObject.optString(next));
                            map.put(next, treeMap2);
                        }
                    }
                }
            }
        }
        return map;
    }

    public static int pA(String str) {
        int iHashCode = str.hashCode();
        if (iHashCode == -1408024454) {
            return str.equals("alternate") ? 2 : 1;
        }
        if (iHashCode != -1039745817) {
            return 1;
        }
        str.equals(Constants.NORMAL);
        return 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0032  */
    public static Interpolator Og(String str) {
        byte b;
        switch (str) {
            case "ease_in":
                b = 0;
                break;
            case "linear":
                b = 3;
                break;
            case "ease_out":
                b = 2;
                break;
            case "ease_in_out":
                b = 1;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return new AccelerateInterpolator();
        }
        if (b == 1) {
            return new AccelerateDecelerateInterpolator();
        }
        if (b == 2) {
            return new DecelerateInterpolator();
        }
        return new LinearInterpolator();
    }

    public static float[] KZx(String str) {
        float[] fArr = {0.0f, 0.0f};
        JSONArray jSONArrayPA = com.bytedance.adsdk.ugeno.SD.Og.pA(str, (JSONArray) null);
        if (jSONArrayPA != null && jSONArrayPA.length() == 2) {
            fArr[0] = (float) jSONArrayPA.optDouble(0);
            fArr[1] = (float) jSONArrayPA.optDouble(1);
        }
        return fArr;
    }

    public static Og.pA ZZv(String str) {
        JSONArray jSONArrayPA;
        if (TextUtils.isEmpty(str) || (jSONArrayPA = com.bytedance.adsdk.ugeno.SD.Og.pA(str, (JSONArray) null)) == null || jSONArrayPA.length() != 2) {
            return null;
        }
        Og.pA pAVar = new Og.pA();
        pAVar.pA = jSONArrayPA.optString(0);
        pAVar.Og = jSONArrayPA.optString(1);
        return pAVar;
    }

    public static int pA(String str, int i) {
        int i2 = i / 2;
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        str.hashCode();
        switch (str) {
            case "bottom":
            case "right":
                return i;
            case "center":
                return i2;
            case "top":
            case "left":
                return 0;
            default:
                if (str.endsWith("%")) {
                    try {
                        return (int) ((i * Float.parseFloat(str.substring(0, str.length() - 1))) / 100.0f);
                    } catch (NumberFormatException unused) {
                        return i2;
                    }
                }
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException unused2) {
                    return i2;
                }
        }
    }
}
