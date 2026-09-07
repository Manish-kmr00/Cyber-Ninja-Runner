package com.bytedance.adsdk.Og;

import android.graphics.Bitmap;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes6.dex */
public class SGo {
    private Bitmap BSW;
    private final int[][] Bzk;
    private final String JG;
    private final String KZx;
    private final String ML;
    private final int Og;
    private final List<pA> SD;
    private final JSONArray SGo;
    private final String ZZv;
    private final String omh;
    private final int pA;

    public static class pA {
        public int JG;
        public String KZx;
        public int ML;
        public int Og;
        public String SD;
        public String ZZv;
        public int pA;
    }

    public SGo(int i, int i2, String str, String str2, String str3, String str4, List<pA> list, String str5, int[][] iArr, JSONArray jSONArray) {
        this.pA = i;
        this.Og = i2;
        this.KZx = str;
        this.ZZv = str2;
        this.ML = str3;
        this.JG = str4;
        this.SD = list;
        this.omh = str5;
        this.Bzk = iArr;
        this.SGo = jSONArray;
    }

    public int pA() {
        return this.pA;
    }

    public int Og() {
        return this.Og;
    }

    public List<pA> KZx() {
        return this.SD;
    }

    public String ZZv() {
        return this.JG;
    }

    public String ML() {
        return this.omh;
    }

    public int[][] JG() {
        return this.Bzk;
    }

    public JSONArray SD() {
        return this.SGo;
    }

    public String omh() {
        return this.KZx;
    }

    public String Bzk() {
        return this.ZZv;
    }

    public String SGo() {
        return this.ML;
    }

    public Bitmap BSW() {
        return this.BSW;
    }

    public void pA(Bitmap bitmap) {
        this.BSW = bitmap;
    }
}
