package com.bytedance.adsdk.ugeno.Bzk.JG;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.adjust.sdk.Constants;
import com.bytedance.adsdk.ugeno.Og.KZx;
import com.bytedance.adsdk.ugeno.SD.omh;
import com.google.common.base.Ascii;
import com.safedk.android.analytics.reporters.b;

/* JADX INFO: loaded from: classes4.dex */
public class Og extends KZx<pA> {
    private float BDQ;
    private float FK;

    @Deprecated
    private float GbR;
    protected int KZx;
    protected int Og;
    private float PU;

    @Deprecated
    private TextUtils.TruncateAt Xj;
    private float ZZv;
    private float aj;
    private boolean bA;
    private int dGZ;
    private int guZ;
    private float ka;

    @Deprecated
    private float lgT;
    private int npn;
    protected String pA;
    private int qQU;
    private int rjD;
    private float sPI;
    private int uhO;
    private TextUtils.TruncateAt vkV;

    public Og(Context context) {
        super(context);
        this.Og = ViewCompat.MEASURED_STATE_MASK;
        this.ZZv = 12.0f;
        this.npn = Integer.MAX_VALUE;
        this.dGZ = 2;
        this.KZx = 3;
        this.vkV = TextUtils.TruncateAt.END;
        this.PU = -1.0f;
        this.ka = 400.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public pA ZZv() {
        pA pAVar = new pA(this.ML);
        pAVar.pA(this);
        return pAVar;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void Og() {
        super.Og();
        if (TextUtils.equals("null", this.pA)) {
            this.pA = "";
        }
        SD(this.pA);
        ((pA) this.omh).setTextSize(1, this.ZZv);
        ((pA) this.omh).setTextColor(this.Og);
        ((pA) this.omh).setLines(this.rjD);
        ((pA) this.omh).setMaxLines(this.npn);
        ((pA) this.omh).setGravity(this.dGZ);
        ((pA) this.omh).setIncludeFontPadding(false);
        pA(this.qQU);
        if (roi()) {
            pA(this.vkV);
        } else {
            pA(this.Xj);
        }
        if (this.PU > 0.0f) {
            if (roi()) {
                fN();
            } else {
                KZx();
            }
        }
        ((pA) this.omh).setBreakStrategy(0);
        if (roi()) {
            if (this.bA) {
                if (this.BDQ <= 0.0f) {
                    this.BDQ = 1.0E-5f;
                }
                ((pA) this.omh).setShadowLayer(this.BDQ, this.aj, this.sPI, this.uhO);
            }
        } else {
            ((pA) this.omh).setShadowLayer(this.BDQ, this.lgT, this.GbR, this.uhO);
        }
        if (this.guZ == 1) {
            ((pA) this.omh).setTypeface(Typeface.DEFAULT, this.guZ);
        } else if (Build.VERSION.SDK_INT >= 28) {
            ((pA) this.omh).setTypeface(Typeface.create(Typeface.DEFAULT, (int) this.ka, this.guZ == 2));
        } else if (this.ka >= 500.0f) {
            ((pA) this.omh).setTypeface(Typeface.DEFAULT, 1);
        }
        if (omh.pA(this.ML, this.ZZv) > 0.0f) {
            ((pA) this.omh).setLetterSpacing(this.FK / omh.pA(this.ML, this.ZZv));
        }
    }

    private void KZx() {
        ((pA) this.omh).setLineSpacing(0.0f, this.PU);
    }

    private void fN() {
        if (this.PU <= 3.0f) {
            ((pA) this.omh).setLineSpacing(0.0f, this.PU);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int iRound = Math.round(omh.pA(this.ML, (this.PU - (this.ZZv * 1.2f)) / 2.0f));
            ((pA) this.omh).setPadding(((pA) this.omh).getPaddingLeft(), ((pA) this.omh).getPaddingTop() + iRound, ((pA) this.omh).getPaddingRight(), ((pA) this.omh).getPaddingBottom() + iRound);
            ((pA) this.omh).setLineHeight(Math.round(omh.pA(this.ML, this.PU)));
        }
    }

    public void SD(String str) {
        this.pA = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals("null", str)) {
            this.pA = "";
        }
        ((pA) this.omh).setText(this.pA);
    }

    public void pA(int i) {
        this.qQU = i;
        if (i == Integer.MAX_VALUE) {
            return;
        }
        ((pA) this.omh).setPaintFlags(i);
    }

    public void pA(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((pA) this.omh).setEllipsize(truncateAt);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void pA(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.pA(str, str2);
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1621067310:
                if (str.equals("shadowRadius")) {
                    b = 0;
                }
                break;
            case -1589741021:
                if (str.equals("shadowColor")) {
                    b = 1;
                }
                break;
            case -1230714651:
                if (str.equals("shadowOffsetX")) {
                    b = 2;
                }
                break;
            case -1230714650:
                if (str.equals("shadowOffsetY")) {
                    b = 3;
                }
                break;
            case -1065511464:
                if (str.equals("textAlign")) {
                    b = 4;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    b = 5;
                }
                break;
            case -1048634236:
                if (str.equals("textStyle")) {
                    b = 6;
                }
                break;
            case -1021145689:
                if (str.equals("shadowBlur")) {
                    b = 7;
                }
                break;
            case -1003668786:
                if (str.equals("textSize")) {
                    b = 8;
                }
                break;
            case -879295043:
                if (str.equals("textDecoration")) {
                    b = 9;
                }
                break;
            case -756368940:
                if (str.equals("shadowDx")) {
                    b = 10;
                }
                break;
            case -756368939:
                if (str.equals("shadowDy")) {
                    b = Ascii.VT;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    b = Ascii.FF;
                }
                break;
            case -515807685:
                if (str.equals("lineHeight")) {
                    b = Ascii.CR;
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    b = Ascii.SO;
                }
                break;
            case 102977279:
                if (str.equals(b.d)) {
                    b = Ascii.SI;
                }
                break;
            case 188702929:
                if (str.equals("ellipsis")) {
                    b = Ascii.DLE;
                }
                break;
            case 390232059:
                if (str.equals("maxLines")) {
                    b = 17;
                }
                break;
            case 1554823821:
                if (str.equals("ellipsize")) {
                    b = Ascii.DC2;
                }
                break;
            case 2111078717:
                if (str.equals("letterSpacing")) {
                    b = 19;
                }
                break;
        }
        switch (b) {
            case 0:
            case 7:
                this.BDQ = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case 1:
                this.uhO = com.bytedance.adsdk.ugeno.SD.pA.pA(str2);
                this.bA = true;
                break;
            case 2:
                this.aj = omh.pA(this.ML, com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f));
                break;
            case 3:
                this.sPI = omh.pA(this.ML, com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f));
                break;
            case 4:
                this.dGZ = BSW(str2);
                break;
            case 5:
                this.Og = com.bytedance.adsdk.ugeno.SD.pA.pA(str2);
                break;
            case 6:
                this.guZ = SGo(str2);
                break;
            case 8:
                this.ZZv = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case 9:
                this.qQU = WV(str2);
                break;
            case 10:
                this.lgT = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case 11:
                this.GbR = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case 12:
                float fPA = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, -1.0f);
                this.ka = fPA;
                if (fPA < 1.0f || fPA > 1000.0f) {
                    this.ka = 400.0f;
                }
                break;
            case 13:
                this.PU = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 1.0f);
                break;
            case 14:
                this.pA = str2;
                break;
            case 15:
                this.rjD = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0);
                break;
            case 16:
                this.vkV = Bzk(str2);
                break;
            case 17:
                int iPA = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, Integer.MAX_VALUE);
                this.npn = iPA > 0 ? iPA : Integer.MAX_VALUE;
                break;
            case 18:
                this.Xj = omh(str2);
                break;
            case 19:
                this.FK = omh.pA(this.ML, com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f));
                break;
        }
    }

    private TextUtils.TruncateAt omh(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.Xj = TextUtils.TruncateAt.MIDDLE;
                break;
            case "end":
                this.Xj = TextUtils.TruncateAt.END;
                break;
            case "start":
                this.Xj = TextUtils.TruncateAt.START;
                break;
            default:
                this.Xj = null;
                break;
        }
        return this.Xj;
    }

    private TextUtils.TruncateAt Bzk(String str) {
        if (TextUtils.equals(str, "none")) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    private int SGo(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -1178781136) {
            if (iHashCode != -1039745817) {
                if (iHashCode == 3029637 && str.equals("bold")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals(Constants.NORMAL)) {
                b = 2;
            } else {
                b = -1;
            }
        } else if (str.equals("italic")) {
            b = 1;
        } else {
            b = -1;
        }
        if (b != 0) {
            return b != 1 ? 0 : 2;
        }
        return 1;
    }

    private int BSW(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 17;
            case "left":
                return 3;
            case "right":
                return 5;
            default:
                return 2;
        }
    }

    private int WV(String str) {
        str.hashCode();
        switch (str) {
            case "underline":
                return 8;
            case "strikethrough":
                return 16;
            case "none":
            default:
                return Integer.MAX_VALUE;
        }
    }
}
