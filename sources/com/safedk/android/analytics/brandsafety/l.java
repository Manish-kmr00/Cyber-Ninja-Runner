package com.safedk.android.analytics.brandsafety;

import android.os.SystemClock;
import android.text.TextUtils;
import com.safedk.android.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l implements com.safedk.android.utils.f {
    public static final String A = "fgr";
    public static final String B = "vst";
    public static final String C = "adr";
    public static final String D = "fsc";
    public static final String E = "fsr";
    public static final String F = "web";
    public static final String G = "vhc";
    public static final String H = "mrl";
    public static final String I = "url";
    public static final String J = "cuo";
    public static final String K = "typ";
    public static final String L = "vad";
    public static final String M = "mth";
    public static final String N = "ntw";
    public static final String O = "api";
    public static final String P = "org";
    public static final String Q = "dec";
    public static final String R = "cnt";
    public static final String S = "ads";
    public static final String T = "cls";
    public static final String U = "tchrcnt";
    public static final String V = "tchintrvl";
    public static final String W = "lvl";
    public static final String X = "can";
    public static final String Y = "fin";
    public static final String Z = "med";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8111a = "pre";
    public static final String aa = "low";
    public static final String ab = "crt";
    public static final String ac = "||";
    public static final String ad = "|";
    public static final String ae = "=";
    public static final String af = "[...]";
    private static final String ag = "ImpressionLog";
    private static final int ah = 60;
    public static final String b = "pr2";
    public static final String c = "prd";
    public static final String d = "mwl";
    public static final String e = "mdl";
    public static final String f = "mwd";
    public static final String g = "mdd";
    public static final String h = "mck";
    public static final String i = "mdh";
    public static final String j = "mfd";
    public static final String k = "mrv";
    public static final String l = "add";
    public static final String m = "cim";
    public static final String n = "clk";
    public static final String o = "vib";
    public static final String p = "vie";
    public static final String q = "ppl";
    public static final String r = "lad";
    public static final String s = "lar";
    public static final String t = "img";
    public static final String u = "jsm";
    public static final String v = "wnr";
    public static final String w = "int";
    public static final String x = "rid";
    public static final String y = "exp";
    public static final String z = "bgr";
    private long ai = Long.MAX_VALUE;
    private long aj = Long.MAX_VALUE;
    private final Map<Long, List<String>> ak = new TreeMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8112a;
        public String b;

        public a(String str, String str2) {
            this.f8112a = str;
            this.b = str2;
        }
    }

    public l() {
    }

    public l(l lVar) {
        a(lVar);
    }

    public synchronized void a(l lVar) {
        if (lVar != null) {
            this.ai = Math.min(this.ai, lVar.ai);
            this.aj = Math.min(this.aj, lVar.aj);
            synchronized (lVar) {
                for (Map.Entry<Long, List<String>> entry : lVar.ak.entrySet()) {
                    List<String> arrayList = this.ak.get(entry.getKey());
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                        this.ak.put(entry.getKey(), arrayList);
                    }
                    arrayList.addAll(entry.getValue());
                }
            }
        }
    }

    private StringBuilder c(String str, a[] aVarArr) {
        StringBuilder sb = new StringBuilder(str);
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                String strA = aVar.b;
                if (aVar.f8112a.equals("url")) {
                    strA = a(aVar.b, 60);
                }
                sb.append(ad).append(aVar.f8112a).append("=").append(strA);
            }
        }
        return sb;
    }

    public synchronized void a(Long l2, Long l3, String str, a... aVarArr) {
        this.ai = Math.min(this.ai, l2.longValue());
        this.aj = Math.min(this.aj, l3.longValue());
        try {
            if (!TextUtils.isEmpty(str)) {
                StringBuilder sbC = c(str, aVarArr);
                List<String> arrayList = this.ak.get(l3);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.ak.put(l3, arrayList);
                } else if (!arrayList.contains(sbC.toString())) {
                }
                arrayList.add(sbC.toString());
                Logger.d(ag, "add event: " + ((Object) sbC) + " at: " + l2 + ", count: " + arrayList.size());
            }
        } catch (NullPointerException e2) {
            Logger.d(ag, "add event failed: type=" + str + ", logEvents=" + this.ak + ", timeElapsed=" + l3);
        }
    }

    public void a(String str, a... aVarArr) {
        a(Long.valueOf(System.currentTimeMillis()), Long.valueOf(SystemClock.elapsedRealtime()), str, aVarArr);
    }

    public synchronized void b(Long l2, Long l3, String str, a... aVarArr) {
        this.ai = Math.min(this.ai, l2.longValue());
        this.aj = Math.min(this.aj, l3.longValue());
        if (!TextUtils.isEmpty(str)) {
            int iB = 0;
            StringBuilder sbC = c(str, aVarArr);
            for (List<String> list : this.ak.values()) {
                for (String str2 : list) {
                    if (str2.contains(sbC.toString())) {
                        iB = b(str2);
                        list.remove(str2);
                        break;
                    }
                }
                iB = iB;
            }
            sbC.append(ad).append(R).append("=").append(iB + 1);
            List<String> arrayList = this.ak.get(l3);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.ak.put(l3, arrayList);
            }
            arrayList.add(sbC.toString());
            Logger.d(ag, "add cumulative event: " + ((Object) sbC) + " at: " + l2 + ", count: " + arrayList.size());
        }
    }

    public void b(String str, a... aVarArr) {
        b(Long.valueOf(System.currentTimeMillis()), Long.valueOf(SystemClock.elapsedRealtime()), str, aVarArr);
    }

    private int b(String str) {
        try {
            String[] strArrSplit = str.split("cnt=");
            if (strArrSplit.length > 1) {
                return Integer.parseInt(strArrSplit[1]);
            }
        } catch (Exception e2) {
            Logger.d(ag, "get cumulative event counter, failed to parse event count from: " + str);
        }
        return 0;
    }

    private String a(String str, int i2) {
        if (str != null && str.length() > i2) {
            return str.substring(0, ((i2 * 2) / 3) - 3) + af + str.substring((str.length() - (i2 / 3)) + 2);
        }
        return str;
    }

    public synchronized boolean a(String str) {
        boolean z2;
        Iterator<List<String>> it = this.ak.values().iterator();
        while (it.hasNext()) {
            Iterator<String> it2 = it.next().iterator();
            while (it2.hasNext()) {
                if (it2.next().contains(str)) {
                    z2 = true;
                }
            }
        }
        z2 = false;
        return z2;
    }

    public int a() {
        return this.ak.size();
    }

    public synchronized String toString() {
        StringBuilder sb;
        boolean z2;
        boolean z3 = true;
        sb = new StringBuilder();
        for (Map.Entry<Long, List<String>> entry : this.ak.entrySet()) {
            for (String str : entry.getValue()) {
                if (z3) {
                    sb.append(this.ai);
                    z2 = false;
                } else {
                    sb.append(ac).append(entry.getKey().longValue() - this.aj);
                    z2 = z3;
                }
                sb.append(ad).append(str);
                z3 = z2;
            }
        }
        return sb.toString();
    }

    @Override // com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("referenceTimeMillis", this.ai);
        jSONObject.put("referenceTimeElapsed", this.aj);
        if (!this.ak.isEmpty()) {
            jSONObject.put("logEvents", com.safedk.android.utils.d.a(this.ak));
        }
        return jSONObject;
    }

    @Override // com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.ai = jSONObject.optLong("referenceTimeMillis", 0L);
            this.aj = jSONObject.optLong("referenceTimeElapsed", 0L);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("logEvents");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.ak.put(Long.valueOf(Long.parseLong(next)), com.safedk.android.utils.d.b(jSONObjectOptJSONObject.getJSONArray(next)));
                }
            }
        }
    }
}
