package com.bytedance.sdk.openadsdk.DX;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.WV;
import com.google.common.base.Ascii;
import com.json.m5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pA implements Comparable<pA> {
    private int KZx;
    private int ML;
    private final String Og;
    private int SD;
    private long Sn;
    private final ArrayList<Long> pA = new ArrayList<>();
    private final ArrayList<Long> ZZv = new ArrayList<>();
    private final ArrayList<Long> JG = new ArrayList<>();
    private final ArrayList<Long> omh = new ArrayList<>();
    private final HashMap<String, Og> Bzk = new HashMap<>();
    private int SGo = 0;
    private int BSW = 0;
    private final HashMap<String, Og> WV = new HashMap<>();
    private int Wx = 0;
    private final ArrayList<String> DX = new ArrayList<>();

    public pA(String str) {
        this.Og = str;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void pA(String str, String str2) {
        Og og;
        Og og2;
        Og og3;
        Og og4;
        Og og5;
        Og og6;
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1908685858:
                if (str.equals("landingContinue")) {
                    b = 0;
                }
                break;
            case -1769688545:
                if (str.equals("landingPause")) {
                    b = 1;
                }
                break;
            case -1766371189:
                if (str.equals("landingStart")) {
                    b = 2;
                }
                break;
            case -1643912491:
                if (str.equals("feed_over")) {
                    b = 3;
                }
                break;
            case -1643892427:
                if (str.equals("feed_play")) {
                    b = 4;
                }
                break;
            case 3529469:
                if (str.equals(m5.v)) {
                    b = 5;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    b = 6;
                }
                break;
            case 533457448:
                if (str.equals("feed_continue")) {
                    b = 7;
                }
                break;
            case 566194974:
                if (str.equals("feed_break")) {
                    b = 8;
                }
                break;
            case 578633749:
                if (str.equals("feed_pause")) {
                    b = 9;
                }
                break;
            case 695109002:
                if (str.equals("landingFinish")) {
                    b = 10;
                }
                break;
            case 702698279:
                if (str.equals("videoPercent30")) {
                    b = Ascii.VT;
                }
                break;
            case 1338624943:
                if (str.equals("videoForceBreak")) {
                    b = Ascii.FF;
                }
                break;
            case 1671642405:
                if (str.equals("dislike")) {
                    b = Ascii.CR;
                }
                break;
            case 1912965437:
                if (str.equals("play_error")) {
                    b = Ascii.SO;
                }
                break;
        }
        switch (b) {
            case 0:
                if (!TextUtils.isEmpty(str2) && (og = this.WV.get(str2)) != null) {
                    og.ZZv(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 1:
                if (!TextUtils.isEmpty(str2) && (og2 = this.WV.get(str2)) != null) {
                    og2.KZx(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 2:
                if (!TextUtils.isEmpty(str2) && this.WV.get(str2) == null) {
                    Og og7 = new Og();
                    this.WV.put(str2, og7);
                    og7.pA(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 3:
            case 8:
            case 12:
            case 14:
                if (!TextUtils.isEmpty(str2) && (og3 = this.Bzk.get(str2)) != null && og3.pA() != Og.ML) {
                    og3.Og(SystemClock.elapsedRealtime());
                    if (com.bytedance.sdk.openadsdk.JG.pA.pA().DX()) {
                        this.SGo = (int) (((long) this.SGo) + og3.pA(this.Sn, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case 4:
                this.JG.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (com.bytedance.sdk.openadsdk.JG.pA.pA().omh()) {
                    this.SD++;
                }
                if (!TextUtils.isEmpty(str2) && this.Bzk.get(str2) == null) {
                    Og og8 = new Og();
                    this.Bzk.put(str2, og8);
                    og8.pA(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 5:
                this.pA.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (com.bytedance.sdk.openadsdk.JG.pA.pA().JG()) {
                    this.KZx++;
                }
                break;
            case 6:
                if (!this.DX.contains(str2)) {
                    if (this.DX.size() > 50) {
                        this.DX.subList(0, 25).clear();
                    }
                    this.DX.add(str2);
                    this.ZZv.add(Long.valueOf(SystemClock.elapsedRealtime()));
                    if (com.bytedance.sdk.openadsdk.JG.pA.pA().SD()) {
                        this.ML++;
                    }
                    break;
                }
                break;
            case 7:
                if (!TextUtils.isEmpty(str2) && (og4 = this.Bzk.get(str2)) != null) {
                    og4.ZZv(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 9:
                if (!TextUtils.isEmpty(str2) && (og5 = this.Bzk.get(str2)) != null) {
                    og5.KZx(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 10:
                if (!TextUtils.isEmpty(str2) && (og6 = this.WV.get(str2)) != null && og6.pA() != Og.ML) {
                    og6.Og(SystemClock.elapsedRealtime());
                    if (com.bytedance.sdk.openadsdk.JG.pA.pA().Sn()) {
                        this.Wx = (int) (((long) this.Wx) + og6.pA(this.Sn, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case 11:
                if (com.bytedance.sdk.openadsdk.JG.pA.pA().aBv()) {
                    this.BSW++;
                }
                break;
            case 13:
                this.omh.add(Long.valueOf(SystemClock.elapsedRealtime()));
                break;
        }
    }

    public JSONObject pA(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            pA(jSONObject2, jSONObject);
            Og(jSONObject2, jSONObject);
        } catch (Throwable th) {
            WV.Og(th.getMessage());
        }
        return jSONObject2;
    }

    private void pA(String str, JSONObject jSONObject, ArrayList<Long> arrayList, int[] iArr, long j, JSONObject jSONObject2) throws JSONException {
        int size = arrayList.size() - 1;
        int i = 0;
        for (int i2 : iArr) {
            long j2 = j - (((long) i2) * 60000);
            while (size >= 0 && arrayList.get(size).longValue() >= j2) {
                i++;
                size--;
            }
            if (i != 0) {
                jSONObject.put(str + i2, i);
                int iOptInt = jSONObject2.optInt(str + i2) + i;
                if (iOptInt != 0) {
                    jSONObject2.put(str + i2, iOptInt);
                }
            }
        }
        while (size >= 0) {
            arrayList.remove(0);
            size--;
        }
    }

    private void pA(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        int i;
        int i2;
        int i3;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        pA("show_c_", jSONObject, this.pA, com.bytedance.sdk.openadsdk.JG.pA.pA().Bzk(), jElapsedRealtime, jSONObject2);
        pA("click_c_", jSONObject, this.ZZv, com.bytedance.sdk.openadsdk.JG.pA.pA().SGo(), jElapsedRealtime, jSONObject2);
        pA("v_play_c_", jSONObject, this.JG, com.bytedance.sdk.openadsdk.JG.pA.pA().BSW(), jElapsedRealtime, jSONObject2);
        pA("dislike_c_", jSONObject, this.omh, com.bytedance.sdk.openadsdk.JG.pA.pA().oX(), jElapsedRealtime, jSONObject2);
        if (com.bytedance.sdk.openadsdk.JG.pA.pA().JG() && (i3 = this.KZx) != 0) {
            jSONObject.put("show_c_s", i3);
            int iOptInt = jSONObject2.optInt("show_c_s") + this.KZx;
            if (iOptInt != 0) {
                jSONObject2.put("show_c_s", iOptInt);
            }
        }
        if (com.bytedance.sdk.openadsdk.JG.pA.pA().SD() && (i2 = this.ML) != 0) {
            jSONObject.put("click_c_s", i2);
            int iOptInt2 = jSONObject2.optInt("click_c_s") + this.ML;
            if (iOptInt2 != 0) {
                jSONObject2.put("click_c_s", iOptInt2);
            }
        }
        if (!com.bytedance.sdk.openadsdk.JG.pA.pA().omh() || (i = this.SD) == 0) {
            return;
        }
        jSONObject.put("v_play_c_s", i);
        int iOptInt3 = jSONObject2.optInt("v_play_c_s") + this.SD;
        if (iOptInt3 != 0) {
            jSONObject2.put("v_play_c_s", iOptInt3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0107 A[PHI: r10 r14
  0x0107: PHI (r10v3 int) = (r10v2 int), (r10v5 int), (r10v5 int) binds: [B:34:0x00e6, B:39:0x00fa, B:41:0x00ff] A[DONT_GENERATE, DONT_INLINE]
  0x0107: PHI (r14v2 long) = (r14v1 long), (r14v4 long), (r14v4 long) binds: [B:34:0x00e6, B:39:0x00fa, B:41:0x00ff] A[DONT_GENERATE, DONT_INLINE]] */
    private void Og(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        int i;
        int i2;
        int i3;
        long j;
        HashSet hashSet;
        HashSet hashSet2;
        HashSet hashSet3;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        int[] iArrWV = com.bytedance.sdk.openadsdk.JG.pA.pA().WV();
        long j2 = 60000;
        if (iArrWV != null) {
            int i4 = 0;
            while (i4 < iArrWV.length) {
                int i5 = iArrWV[i4];
                long j3 = jElapsedRealtime - (((long) i5) * j2);
                Iterator<String> it = this.WV.keySet().iterator();
                long j4 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    Iterator<String> it2 = it;
                    Og og = this.WV.get(next);
                    if (og != null) {
                        long jPA = og.pA(j3, jElapsedRealtime);
                        j4 += jPA;
                        if (jPA <= 0 && i4 == iArrWV.length - 1) {
                            hashSet4.add(next);
                        }
                    }
                    it = it2;
                }
                if (j4 != 0) {
                    jSONObject.put("lp_stay_t_".concat(String.valueOf(i5)), j4);
                    hashSet2 = hashSet4;
                    hashSet3 = hashSet5;
                    long jOptInt = ((long) jSONObject2.optInt("lp_stay_t_".concat(String.valueOf(i5)))) + j4;
                    if (jOptInt != 0) {
                        jSONObject2.put("lp_stay_t_".concat(String.valueOf(i5)), jOptInt);
                    }
                } else {
                    hashSet2 = hashSet4;
                    hashSet3 = hashSet5;
                }
                i4++;
                hashSet4 = hashSet2;
                hashSet5 = hashSet3;
                j2 = 60000;
            }
        }
        HashSet hashSet6 = hashSet4;
        HashSet hashSet7 = hashSet5;
        int[] iArrWx = com.bytedance.sdk.openadsdk.JG.pA.pA().Wx();
        if (iArrWx != null) {
            int i6 = 0;
            while (i6 < iArrWx.length) {
                int i7 = iArrWx[i6];
                long j5 = jElapsedRealtime - (((long) i7) * 60000);
                Iterator<String> it3 = this.Bzk.keySet().iterator();
                int i8 = 0;
                long j6 = 0;
                while (it3.hasNext()) {
                    String next2 = it3.next();
                    Iterator<String> it4 = it3;
                    Og og2 = this.Bzk.get(next2);
                    if (og2 != null) {
                        long jPA2 = og2.pA(j5, jElapsedRealtime);
                        j6 += jPA2;
                        if (jPA2 > 20000) {
                            i8++;
                        }
                        if (jPA2 > 0 || i6 != iArrWx.length - 1) {
                            hashSet = hashSet7;
                        } else {
                            hashSet = hashSet7;
                            hashSet.add(next2);
                        }
                    } else {
                        hashSet = hashSet7;
                    }
                    hashSet7 = hashSet;
                    it3 = it4;
                }
                HashSet hashSet8 = hashSet7;
                if (j6 != 0) {
                    jSONObject.put("v_stay_t_".concat(String.valueOf(i7)), j6);
                    j = jElapsedRealtime;
                    long jOptInt2 = ((long) jSONObject2.optInt("v_stay_t_".concat(String.valueOf(i7)))) + j6;
                    if (jOptInt2 != 0) {
                        jSONObject2.put("v_stay_t_".concat(String.valueOf(i7)), jOptInt2);
                    }
                } else {
                    j = jElapsedRealtime;
                }
                if (i8 != 0) {
                    jSONObject.put("v_20s_play_c_".concat(String.valueOf(i7)), i8);
                    int iOptInt = jSONObject2.optInt("v_20s_play_c_".concat(String.valueOf(i7))) + i8;
                    if (iOptInt != 0) {
                        jSONObject2.put("v_20s_play_c_".concat(String.valueOf(i7)), iOptInt);
                    }
                }
                i6++;
                hashSet7 = hashSet8;
                jElapsedRealtime = j;
            }
        }
        HashSet hashSet9 = hashSet7;
        if (!hashSet6.isEmpty()) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                this.WV.remove((String) it5.next());
            }
        }
        if (!hashSet9.isEmpty()) {
            Iterator it6 = hashSet9.iterator();
            while (it6.hasNext()) {
                this.Bzk.remove((String) it6.next());
            }
        }
        if (com.bytedance.sdk.openadsdk.JG.pA.pA().DX() && (i3 = this.SGo) != 0) {
            jSONObject.put("v_stay_t_s", i3);
            int iOptInt2 = jSONObject2.optInt("v_stay_t_s") + this.SGo;
            if (iOptInt2 != 0) {
                jSONObject2.put("v_stay_t_s", iOptInt2);
            }
        }
        if (com.bytedance.sdk.openadsdk.JG.pA.pA().Sn() && (i2 = this.Wx) != 0) {
            jSONObject.put("lp_stay_t_s", i2);
            int iOptInt3 = jSONObject2.optInt("lp_stay_t_s") + this.Wx;
            if (iOptInt3 != 0) {
                jSONObject2.put("lp_stay_t_s", iOptInt3);
            }
        }
        if (!com.bytedance.sdk.openadsdk.JG.pA.pA().aBv() || (i = this.BSW) == 0) {
            return;
        }
        jSONObject.put("v_30p_play_c_s", i);
        int iOptInt4 = jSONObject2.optInt("v_30p_play_c_s") + this.BSW;
        if (iOptInt4 != 0) {
            jSONObject2.put("v_30p_play_c_s", iOptInt4);
        }
    }

    public void pA() {
        this.Sn = SystemClock.elapsedRealtime();
        this.BSW = 0;
        this.ML = 0;
        this.KZx = 0;
        this.Wx = 0;
        this.SGo = 0;
        this.SD = 0;
    }

    public String Og() {
        return this.Og;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public int compareTo(pA pAVar) {
        return pAVar.KZx - this.KZx;
    }
}
