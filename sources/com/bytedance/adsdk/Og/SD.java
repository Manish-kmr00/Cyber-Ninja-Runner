package com.bytedance.adsdk.Og;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes11.dex */
public class SD {
    private float BSW;
    private List<com.bytedance.adsdk.Og.KZx.KZx.ML> Bzk;
    private List<com.bytedance.adsdk.Og.KZx.JG> JG;
    private Map<String, List<com.bytedance.adsdk.Og.KZx.KZx.ML>> KZx;
    private Map<String, com.bytedance.adsdk.Og.KZx.KZx> ML;
    private SparseArray<com.bytedance.adsdk.Og.KZx.ZZv> SD;
    private Rect SGo;
    private boolean Sn;
    private float WV;
    private float Wx;
    private pA XT;
    private Map<String, SGo> ZZv;
    private KZx oX;
    private LongSparseArray<com.bytedance.adsdk.Og.KZx.KZx.ML> omh;
    private Og yFO;
    private final XT pA = new XT();
    private final HashSet<String> Og = new HashSet<>();
    private int DX = 0;
    private String aBv = "";

    public static class KZx {
        public String JG;
        public String KZx;
        public int[] ML;
        public String Og;
        public JSONArray SD;
        public String ZZv;
        public int pA;
    }

    public static class Og {
        public JSONArray KZx;
        public int[][] Og;
        public String pA;
    }

    public static class pA {
        public String JG;
        public Map<String, Object> KZx;
        public int ML;
        public Map<String, Object> Og;
        public JSONArray SD;
        public int ZZv;
        public int pA;
    }

    public void pA(Rect rect, float f, float f2, float f3, List<com.bytedance.adsdk.Og.KZx.KZx.ML> list, LongSparseArray<com.bytedance.adsdk.Og.KZx.KZx.ML> longSparseArray, Map<String, List<com.bytedance.adsdk.Og.KZx.KZx.ML>> map, Map<String, SGo> map2, SparseArray<com.bytedance.adsdk.Og.KZx.ZZv> sparseArray, Map<String, com.bytedance.adsdk.Og.KZx.KZx> map3, List<com.bytedance.adsdk.Og.KZx.JG> list2, KZx kZx, String str, pA pAVar, Og og) {
        this.SGo = rect;
        this.BSW = f;
        this.WV = f2;
        this.Wx = f3;
        this.Bzk = list;
        this.omh = longSparseArray;
        this.KZx = map;
        this.ZZv = map2;
        this.SD = sparseArray;
        this.ML = map3;
        this.JG = list2;
        this.oX = kZx;
        this.aBv = str;
        this.XT = pAVar;
        this.yFO = og;
    }

    public void pA(String str) {
        this.Og.add(str);
    }

    public void pA(boolean z) {
        this.Sn = z;
    }

    public void pA(int i) {
        this.DX += i;
    }

    public boolean pA() {
        return this.Sn;
    }

    public int Og() {
        return this.DX;
    }

    public void Og(boolean z) {
        this.pA.pA(z);
    }

    public XT KZx() {
        return this.pA;
    }

    public com.bytedance.adsdk.Og.KZx.KZx.ML pA(long j) {
        return this.omh.get(j);
    }

    public Rect ZZv() {
        return this.SGo;
    }

    public float ML() {
        return (long) ((aBv() / this.Wx) * 1000.0f);
    }

    public float JG() {
        return this.BSW;
    }

    public float SD() {
        return this.WV;
    }

    public float pA(float f) {
        return com.bytedance.adsdk.Og.JG.ML.pA(this.BSW, this.WV, f);
    }

    public KZx omh() {
        return this.oX;
    }

    public String Bzk() {
        return this.aBv;
    }

    public Og SGo() {
        return this.yFO;
    }

    public pA BSW() {
        return this.XT;
    }

    public float WV() {
        return this.Wx;
    }

    public List<com.bytedance.adsdk.Og.KZx.KZx.ML> Wx() {
        return this.Bzk;
    }

    public List<com.bytedance.adsdk.Og.KZx.KZx.ML> Og(String str) {
        return this.KZx.get(str);
    }

    public SparseArray<com.bytedance.adsdk.Og.KZx.ZZv> Sn() {
        return this.SD;
    }

    public Map<String, com.bytedance.adsdk.Og.KZx.KZx> DX() {
        return this.ML;
    }

    public com.bytedance.adsdk.Og.KZx.JG KZx(String str) {
        int size = this.JG.size();
        for (int i = 0; i < size; i++) {
            com.bytedance.adsdk.Og.KZx.JG jg = this.JG.get(i);
            if (jg.pA(str)) {
                return jg;
            }
        }
        return null;
    }

    public Map<String, SGo> oX() {
        return this.ZZv;
    }

    public float aBv() {
        return this.WV - this.BSW;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.bytedance.adsdk.Og.KZx.KZx.ML> it = this.Bzk.iterator();
        while (it.hasNext()) {
            sb.append(it.next().pA("\t"));
        }
        return sb.toString();
    }
}
