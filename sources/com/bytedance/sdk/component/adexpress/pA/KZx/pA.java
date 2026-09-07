package com.bytedance.sdk.component.adexpress.pA.KZx;

import android.text.TextUtils;
import android.util.Pair;
import com.json.b9;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class pA {
    private Map<String, pA> JG = new ConcurrentHashMap();
    private String KZx;
    private Og ML;
    private String Og;
    private List<C0204pA> ZZv;
    private String pA;

    public Map<String, pA> pA() {
        return this.JG;
    }

    public String Og() {
        return this.pA;
    }

    public void pA(String str) {
        this.pA = str;
    }

    public String KZx() {
        return this.Og;
    }

    public void Og(String str) {
        this.Og = str;
    }

    public String ZZv() {
        return this.KZx;
    }

    public void KZx(String str) {
        this.KZx = str;
    }

    public void pA(Og og) {
        this.ML = og;
    }

    public Og ML() {
        return this.ML;
    }

    public List<C0204pA> JG() {
        if (this.ZZv == null) {
            this.ZZv = new ArrayList();
        }
        return this.ZZv;
    }

    public void pA(List<C0204pA> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.ZZv = list;
    }

    public boolean SD() {
        return (TextUtils.isEmpty(ZZv()) || TextUtils.isEmpty(KZx()) || TextUtils.isEmpty(Og())) ? false : true;
    }

    public JSONObject omh() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", Og());
            jSONObject.putOpt("version", KZx());
            jSONObject.putOpt(b9.h.Z, ZZv());
            JSONArray jSONArray = new JSONArray();
            if (JG() != null) {
                for (C0204pA c0204pA : JG()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0204pA.pA());
                    jSONObject2.putOpt("md5", c0204pA.Og());
                    jSONObject2.putOpt("level", Integer.valueOf(c0204pA.KZx()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.JG.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z = false;
                for (String str : this.JG.keySet()) {
                    pA pAVar = this.JG.get(str);
                    if (pAVar != null) {
                        jSONObject3.put(str, pAVar.omh());
                        z = true;
                    }
                }
                if (z) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            Og ogML = ML();
            if (ogML != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", ogML.pA);
                jSONObject4.put("md5", ogML.Og);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> listOg = ogML.Og();
                if (listOg != null) {
                    for (Pair<String, String> pair : listOg) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String Bzk() {
        JSONObject jSONObjectOmh;
        if (!SD() || (jSONObjectOmh = omh()) == null) {
            return null;
        }
        return jSONObjectOmh.toString();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.pA.KZx.pA$pA, reason: collision with other inner class name */
    public static class C0204pA {
        private int KZx;
        private String Og;
        private String pA;

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof C0204pA) {
                String str2 = this.pA;
                if (str2 != null) {
                    C0204pA c0204pA = (C0204pA) obj;
                    if (str2.equals(c0204pA.pA()) && (str = this.Og) != null && str.equals(c0204pA.Og())) {
                        return true;
                    }
                }
                return false;
            }
            return super.equals(obj);
        }

        public String pA() {
            return this.pA;
        }

        public void pA(String str) {
            this.pA = str;
        }

        public String Og() {
            return this.Og;
        }

        public void Og(String str) {
            this.Og = str;
        }

        public int KZx() {
            return this.KZx;
        }

        public void pA(int i) {
            this.KZx = i;
        }
    }

    public static class Og {
        private List<Pair<String, String>> KZx;
        private String Og;
        private String pA;

        public String pA() {
            return this.pA;
        }

        public void pA(String str) {
            this.pA = str;
        }

        public void Og(String str) {
            this.Og = str;
        }

        public void pA(List<Pair<String, String>> list) {
            this.KZx = list;
        }

        public List<Pair<String, String>> Og() {
            return this.KZx;
        }
    }

    public static pA ZZv(String str) {
        if (str == null) {
            return null;
        }
        try {
            return pA(PangleNetworkBridge.jsonObjectInit(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static pA pA(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        pA pAVar = new pA();
        pAVar.pA(jSONObject.optString("name"));
        pAVar.Og(jSONObject.optString("version"));
        pAVar.KZx(jSONObject.optString(b9.h.Z));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                C0204pA c0204pA = new C0204pA();
                c0204pA.pA(jSONObjectOptJSONObject2.optString("url"));
                c0204pA.Og(jSONObjectOptJSONObject2.optString("md5"));
                c0204pA.pA(jSONObjectOptJSONObject2.optInt("level"));
                arrayList.add(c0204pA);
            }
        }
        pAVar.pA(arrayList);
        try {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("engines");
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    pA pAVarPA = pA(jSONObjectOptJSONObject3.optJSONObject(next));
                    if (pAVarPA != null) {
                        pAVar.pA().put(next, pAVarPA);
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (jSONObject.has("resources_archive") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            Og og = new Og();
            og.pA(jSONObjectOptJSONObject.optString("url"));
            og.Og(jSONObjectOptJSONObject.optString("md5"));
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("map");
            if (jSONObjectOptJSONObject4 != null) {
                Iterator<String> itKeys2 = jSONObjectOptJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    arrayList2.add(new Pair<>(next2, jSONObjectOptJSONObject4.optString(next2)));
                }
                og.pA(arrayList2);
            }
            pAVar.pA(og);
        }
        if (pAVar.SD()) {
            return pAVar;
        }
        return null;
    }
}
