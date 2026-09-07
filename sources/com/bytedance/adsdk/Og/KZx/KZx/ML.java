package com.bytedance.adsdk.Og.KZx.KZx;

import com.bytedance.adsdk.Og.KZx.pA.BSW;
import com.bytedance.adsdk.Og.KZx.pA.WV;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class ML {
    private final com.bytedance.adsdk.Og.KZx.Og.pA BF;
    private final int BSW;
    private final WV Bzk;
    private final float DX;
    private final long JG;
    private final String KZx;
    private final pA ML;
    private final com.bytedance.adsdk.Og.SD Og;
    private final String SD;
    private final int SGo;
    private final Og Sd;
    private final float Sn;
    private final boolean TX;
    private final com.bytedance.adsdk.Og.ML.SGo WQf;
    private final int WV;
    private final float Wx;
    private final BSW XT;
    private final long ZZv;
    private final com.bytedance.adsdk.Og.KZx.pA.SGo aBv;
    private final float oX;
    private final List<com.bytedance.adsdk.Og.KZx.Og.omh> omh;
    private final List<com.bytedance.adsdk.Og.KZx.Og.KZx> pA;
    private final List<com.bytedance.adsdk.Og.SD.pA<Float>> vZF;
    private final com.bytedance.adsdk.Og.KZx.pA.Og yFO;

    public enum Og {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public enum pA {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public ML(List<com.bytedance.adsdk.Og.KZx.Og.KZx> list, com.bytedance.adsdk.Og.SD sd, String str, long j, pA pAVar, long j2, String str2, List<com.bytedance.adsdk.Og.KZx.Og.omh> list2, WV wv, int i, int i2, int i3, float f, float f2, float f3, float f4, com.bytedance.adsdk.Og.KZx.pA.SGo sGo, BSW bsw, List<com.bytedance.adsdk.Og.SD.pA<Float>> list3, Og og, com.bytedance.adsdk.Og.KZx.pA.Og og2, boolean z, com.bytedance.adsdk.Og.KZx.Og.pA pAVar2, com.bytedance.adsdk.Og.ML.SGo sGo2) {
        this.pA = list;
        this.Og = sd;
        this.KZx = str;
        this.ZZv = j;
        this.ML = pAVar;
        this.JG = j2;
        this.SD = str2;
        this.omh = list2;
        this.Bzk = wv;
        this.SGo = i;
        this.BSW = i2;
        this.WV = i3;
        this.Wx = f;
        this.Sn = f2;
        this.DX = f3;
        this.oX = f4;
        this.aBv = sGo;
        this.XT = bsw;
        this.vZF = list3;
        this.Sd = og;
        this.yFO = og2;
        this.TX = z;
        this.BF = pAVar2;
        this.WQf = sGo2;
    }

    com.bytedance.adsdk.Og.SD pA() {
        return this.Og;
    }

    float Og() {
        return this.Wx;
    }

    float KZx() {
        return this.Sn / this.Og.aBv();
    }

    List<com.bytedance.adsdk.Og.SD.pA<Float>> ZZv() {
        return this.vZF;
    }

    public long ML() {
        return this.ZZv;
    }

    public String JG() {
        return this.KZx;
    }

    public String SD() {
        return this.SD;
    }

    float omh() {
        return this.DX;
    }

    float Bzk() {
        return this.oX;
    }

    List<com.bytedance.adsdk.Og.KZx.Og.omh> SGo() {
        return this.omh;
    }

    public pA BSW() {
        return this.ML;
    }

    Og WV() {
        return this.Sd;
    }

    long Wx() {
        return this.JG;
    }

    List<com.bytedance.adsdk.Og.KZx.Og.KZx> Sn() {
        return this.pA;
    }

    WV DX() {
        return this.Bzk;
    }

    int oX() {
        return this.WV;
    }

    int aBv() {
        return this.BSW;
    }

    int XT() {
        return this.SGo;
    }

    com.bytedance.adsdk.Og.KZx.pA.SGo yFO() {
        return this.aBv;
    }

    BSW vZF() {
        return this.XT;
    }

    com.bytedance.adsdk.Og.KZx.pA.Og Sd() {
        return this.yFO;
    }

    public String toString() {
        return pA("");
    }

    public boolean TX() {
        return this.TX;
    }

    public com.bytedance.adsdk.Og.KZx.Og.pA BF() {
        return this.BF;
    }

    public com.bytedance.adsdk.Og.ML.SGo WQf() {
        return this.WQf;
    }

    public String pA(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(JG()).append("\n");
        ML mlPA = this.Og.pA(Wx());
        if (mlPA != null) {
            sb.append("\t\tParents: ").append(mlPA.JG());
            ML mlPA2 = this.Og.pA(mlPA.Wx());
            while (mlPA2 != null) {
                sb.append("->").append(mlPA2.JG());
                mlPA2 = this.Og.pA(mlPA2.Wx());
            }
            sb.append(str).append("\n");
        }
        if (!SGo().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(SGo().size()).append("\n");
        }
        if (XT() != 0 && aBv() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(XT()), Integer.valueOf(aBv()), Integer.valueOf(oX())));
        }
        if (!this.pA.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            Iterator<com.bytedance.adsdk.Og.KZx.Og.KZx> it = this.pA.iterator();
            while (it.hasNext()) {
                sb.append(str).append("\t\t").append(it.next()).append("\n");
            }
        }
        return sb.toString();
    }
}
