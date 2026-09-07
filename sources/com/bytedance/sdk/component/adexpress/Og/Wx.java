package com.bytedance.sdk.component.adexpress.Og;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class Wx {
    private String BF;
    private long BSW;
    private boolean Bzk;
    private int DX;
    private boolean IG;
    private String JG;
    private String KZx;
    private int ML;
    private JSONObject Mc;
    private ML Og;
    private String SD;
    private int SGo;
    private int Sd;
    private Map<String, String> Sn;
    private int TV;
    private int TX;
    private double WQf;
    private int WV;
    private String Wx;
    private int XT;
    private Bzk ZZv;
    private String aBv;
    private boolean du;
    private JSONObject eG;
    private String lT;
    private boolean oX;
    private String omh;
    private JSONObject pA;
    private final boolean rB;
    private JSONObject roi;
    private int vZF;
    private int yFO;

    public Wx(pA pAVar) {
        this.pA = pAVar.pA;
        this.Og = pAVar.Og;
        this.KZx = pAVar.KZx;
        this.ZZv = pAVar.ZZv;
        this.ML = pAVar.ML;
        this.JG = pAVar.JG;
        this.SD = pAVar.SD;
        this.omh = pAVar.omh;
        this.Bzk = pAVar.Bzk;
        this.SGo = pAVar.SGo;
        this.BSW = pAVar.BSW;
        this.WV = pAVar.WV;
        this.Wx = pAVar.Wx;
        this.Sn = pAVar.Sn;
        this.DX = pAVar.DX;
        this.oX = pAVar.oX;
        this.aBv = pAVar.aBv;
        this.XT = pAVar.XT;
        this.yFO = pAVar.yFO;
        this.vZF = pAVar.vZF;
        this.Sd = pAVar.Sd;
        this.TX = pAVar.TX;
        this.BF = pAVar.BF;
        this.WQf = pAVar.WQf;
        this.TV = pAVar.TV;
        this.du = pAVar.du;
        this.eG = pAVar.eG;
        this.roi = pAVar.roi;
        this.Mc = pAVar.Mc;
        this.IG = pAVar.IG;
        this.lT = pAVar.lT;
        this.rB = pAVar.rB;
    }

    public boolean pA() {
        return this.du;
    }

    public double Og() {
        return this.WQf;
    }

    public JSONObject KZx() {
        ML ml;
        if (this.pA == null && (ml = this.Og) != null) {
            this.pA = ml.pA();
        }
        return this.pA;
    }

    public String ZZv() {
        return this.KZx;
    }

    public Bzk ML() {
        return this.ZZv;
    }

    public int JG() {
        return this.ML;
    }

    public int SD() {
        return this.TV;
    }

    public boolean omh() {
        return this.Bzk;
    }

    public long Bzk() {
        return this.BSW;
    }

    public int SGo() {
        return this.WV;
    }

    public Map<String, String> BSW() {
        return this.Sn;
    }

    public int WV() {
        return this.DX;
    }

    public boolean Wx() {
        return this.oX;
    }

    public String Sn() {
        return this.aBv;
    }

    public int DX() {
        return this.XT;
    }

    public int oX() {
        return this.yFO;
    }

    public int aBv() {
        return this.vZF;
    }

    public JSONObject XT() {
        return this.eG;
    }

    public JSONObject yFO() {
        return this.roi;
    }

    public JSONObject vZF() {
        return this.Mc;
    }

    public int Sd() {
        return this.Sd;
    }

    public int TX() {
        return this.TX;
    }

    public boolean BF() {
        return this.IG;
    }

    public String WQf() {
        return this.lT;
    }

    public boolean TV() {
        return this.rB;
    }

    public static class pA {
        private String BF;
        private long BSW;
        private boolean Bzk;
        private int DX;
        private boolean IG;
        private String JG;
        private String KZx;
        private int ML;
        private JSONObject Mc;
        private ML Og;
        private String SD;
        private int SGo;
        private int Sd;
        private Map<String, String> Sn;
        private int TV;
        private int TX;
        private double WQf;
        private int WV;
        private String Wx;
        private int XT;
        private Bzk ZZv;
        private String aBv;
        private JSONObject eG;
        private String lT;
        private boolean oX;
        private String omh;
        private JSONObject pA;
        private JSONObject roi;
        private int vZF;
        private int yFO;
        private boolean du = true;
        private boolean rB = true;

        public pA pA(ML ml) {
            this.Og = ml;
            return this;
        }

        public pA pA(boolean z) {
            this.du = z;
            return this;
        }

        public pA pA(String str) {
            this.KZx = str;
            return this;
        }

        public pA pA(Bzk bzk) {
            this.ZZv = bzk;
            return this;
        }

        public pA pA(int i) {
            this.ML = i;
            return this;
        }

        public pA Og(String str) {
            this.JG = str;
            return this;
        }

        public pA KZx(String str) {
            this.SD = str;
            return this;
        }

        public pA ZZv(String str) {
            this.omh = str;
            return this;
        }

        public pA Og(boolean z) {
            this.Bzk = z;
            return this;
        }

        public pA KZx(boolean z) {
            this.rB = z;
            return this;
        }

        public pA Og(int i) {
            this.SGo = i;
            return this;
        }

        public pA pA(long j) {
            this.BSW = j;
            return this;
        }

        public pA KZx(int i) {
            this.WV = i;
            return this;
        }

        public pA pA(Map<String, String> map) {
            this.Sn = map;
            return this;
        }

        public pA ZZv(int i) {
            this.DX = i;
            return this;
        }

        public pA ZZv(boolean z) {
            this.oX = z;
            return this;
        }

        public pA ML(String str) {
            this.aBv = str;
            return this;
        }

        public pA ML(int i) {
            this.TV = i;
            return this;
        }

        public pA ML(boolean z) {
            this.IG = z;
            return this;
        }

        public pA JG(String str) {
            this.lT = str;
            return this;
        }

        public Wx pA() {
            return new Wx(this);
        }

        public pA pA(double d) {
            this.WQf = d;
            return this;
        }
    }
}
