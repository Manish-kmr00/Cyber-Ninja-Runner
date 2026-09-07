package com.bytedance.sdk.component.adexpress.dynamic.ZZv;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.component.adexpress.dynamic.ML.BSW;
import com.json.b9;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class SD {
    private String JG;
    public JSONObject KZx;
    private ML ML;
    public String Og;
    private JG ZZv;
    public int pA;

    public SD(ML ml) {
        this.ML = ml;
        this.pA = ml.pA();
        this.Og = ml.KZx();
        this.KZx = ml.ML().bU();
        this.JG = ml.ZZv();
        if (com.bytedance.sdk.component.adexpress.ZZv.KZx() == 1) {
            this.ZZv = ml.SD();
        } else {
            this.ZZv = ml.ML();
        }
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            this.ZZv = ml.ML();
        }
    }

    public int pA() {
        return (int) this.ZZv.Sn();
    }

    public int Og() {
        return (int) this.ZZv.aBv();
    }

    public int KZx() {
        return (int) this.ZZv.DX();
    }

    public int ZZv() {
        return (int) this.ZZv.oX();
    }

    public float ML() {
        return this.ZZv.XT();
    }

    public String JG() {
        if (this.pA == 0) {
            if (!TextUtils.isEmpty(this.Og)) {
                return this.Og;
            }
            return this.KZx.optString(com.bytedance.sdk.component.adexpress.ZZv.omh.KZx(com.bytedance.sdk.component.adexpress.ZZv.pA()));
        }
        return "";
    }

    public int SD() {
        return pA(this.ZZv.TX());
    }

    public int omh() {
        String strSd = this.ZZv.Sd();
        if ("left".equals(strSd)) {
            return 17;
        }
        if ("center".equals(strSd)) {
            return 4;
        }
        return "right".equals(strSd) ? 3 : 2;
    }

    public int Bzk() {
        int iOmh = omh();
        if (iOmh == 4) {
            return 17;
        }
        return iOmh == 3 ? GravityCompat.END : GravityCompat.START;
    }

    public String SGo() {
        int i = this.pA;
        if (i == 2 || i == 13) {
            return this.Og;
        }
        return "";
    }

    public String BSW() {
        if (this.pA == 1) {
            return this.Og;
        }
        return "";
    }

    public String WV() {
        return this.JG;
    }

    public double Wx() {
        if (this.pA == 11) {
            try {
                double d = Double.parseDouble(this.Og);
                return !com.bytedance.sdk.component.adexpress.ZZv.Og() ? (int) d : d;
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public double Sn() {
        return this.ZZv.yFO();
    }

    public float DX() {
        return this.ZZv.BSW();
    }

    public int oX() {
        return pA(this.ZZv.du());
    }

    public float aBv() {
        return this.ZZv.WV();
    }

    public int XT() {
        return this.ZZv.PU();
    }

    public int yFO() {
        return this.ZZv.uhO();
    }

    public boolean vZF() {
        return this.ZZv.ka();
    }

    public String Sd() {
        return this.ZZv.WQf();
    }

    public void pA(float f) {
        this.ZZv.pA(f);
    }

    public boolean TX() {
        return this.ZZv.Bf();
    }

    public int BF() {
        return this.ZZv.HSv();
    }

    public String WQf() {
        return this.ZZv.CIG();
    }

    public String TV() {
        return this.ZZv.Qd();
    }

    public long du() {
        return this.ZZv.xt();
    }

    public int eG() {
        String strCIG = this.ZZv.CIG();
        if ("skip-with-time-skip-btn".equals(this.ML.Og()) || EventConstants.SKIP.equals(this.ML.Og()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.ML.Og())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.ML.Og()) && !"skip-with-time".equals(this.ML.Og())) {
            if (this.pA == 10 && TextUtils.equals(this.ZZv.SzT(), "click")) {
                return 5;
            }
            if (sk() && tZW()) {
                return 0;
            }
            if (sk()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.ML.Og())) {
                return 3;
            }
            if (!TextUtils.isEmpty(strCIG) && !strCIG.equals("none")) {
                if (strCIG.equals("video") || (this.ML.pA() == 7 && TextUtils.equals(strCIG, Constants.NORMAL))) {
                    return (com.bytedance.sdk.component.adexpress.ZZv.Og() && this.ML.ML() != null && this.ML.ML().lgT()) ? 11 : 4;
                }
                if (strCIG.equals(Constants.NORMAL)) {
                    return 1;
                }
                return (strCIG.equals(Reporting.Key.CREATIVE) || "slide".equals(this.ZZv.SzT())) ? 2 : 0;
            }
        }
        return 0;
    }

    private boolean sk() {
        return (com.bytedance.sdk.component.adexpress.ZZv.Og() && (this.ML.Og().contains("logo-union") || this.ML.Og().contains("logounion") || this.ML.Og().contains("logoad"))) || "logo-union".equals(this.ML.Og()) || "logounion".equals(this.ML.Og()) || "logoad".equals(this.ML.Og());
    }

    public int roi() {
        return pA(this.ZZv.BF());
    }

    public double Mc() {
        return this.ZZv.omh();
    }

    public int IG() {
        return this.ZZv.KZx();
    }

    public int lT() {
        return this.ZZv.Og();
    }

    public int rB() {
        return this.ZZv.ML();
    }

    public int xy() {
        return this.ZZv.ZZv();
    }

    public int qmB() {
        return this.ZZv.Bzk();
    }

    public String gbA() {
        return this.ZZv.SGo();
    }

    public String Vgu() {
        return this.ZZv.SzT();
    }

    private boolean tZW() {
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.Og) && this.Og.contains("adx:")) || BSW.Og();
    }

    public static int pA(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (str.equals(b9.h.T)) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(StringUtils.COMMA)) != null) {
            try {
                if (strArrSplit.length == 4) {
                    return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2]));
                }
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }

    public static float[] Og(String str) {
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(StringUtils.COMMA);
        if (strArrSplit != null && strArrSplit.length == 4) {
            return new float[]{Float.parseFloat(strArrSplit[0]), Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[2]), Float.parseFloat(strArrSplit[3])};
        }
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    public boolean pA(int i) {
        ML ml = this.ML;
        if (ml == null) {
            return false;
        }
        if (i == 1) {
            this.ZZv = ml.SD();
        } else {
            this.ZZv = ml.ML();
        }
        return this.ZZv != null;
    }

    public boolean CIG() {
        return this.ZZv.Itl();
    }

    public int SzT() {
        return this.ZZv.RS();
    }

    public int FQ() {
        return this.ZZv.tM();
    }

    public String Gx() {
        return this.ZZv.Vgu();
    }

    public boolean Bf() {
        return this.ZZv.xkn();
    }

    public int HSv() {
        return this.ZZv.SD();
    }

    public int JBA() {
        return this.ZZv.vkV();
    }

    public int agB() {
        return this.ZZv.GbR();
    }

    public int fN() {
        return this.ZZv.mK();
    }

    public int dmv() {
        return this.ZZv.slz();
    }

    public boolean fJy() {
        return this.ZZv.guZ();
    }

    public String YkC() {
        return this.ZZv.Mc();
    }

    public String dC() {
        return this.ZZv.npn();
    }

    public String IIF() {
        return this.ZZv.aj();
    }

    public boolean vA() {
        return this.ZZv.Wx();
    }

    public boolean PV() {
        return this.ZZv.lT();
    }

    public String cFQ() {
        return this.ZZv.IG();
    }

    public int lx() {
        return this.ZZv.rB();
    }

    public int SXO() {
        return this.ZZv.xy();
    }

    public double fw() {
        return this.ZZv.qmB();
    }

    public double gy() {
        return this.ZZv.gbA();
    }

    public int nCO() {
        return this.ZZv.rjD();
    }

    public String bU() {
        return this.ZZv.FK();
    }

    public String Wo() {
        return this.ZZv.Uz();
    }

    public boolean Itl() {
        return this.ZZv.uQ();
    }

    public int tM() {
        return this.ZZv.Lm();
    }

    public int RS() {
        return this.ZZv.FGT();
    }

    public int QI() {
        return this.ZZv.jO();
    }

    public boolean Gag() {
        return this.ZZv.guZ();
    }

    public String Qj() {
        return this.ZZv.TV();
    }
}
