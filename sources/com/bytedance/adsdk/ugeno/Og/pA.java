package com.bytedance.adsdk.ugeno.Og;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.SD.omh;
import com.google.common.base.Ascii;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes5.dex */
public class pA<E extends ViewGroup> extends KZx {
    protected List<KZx<View>> pA;

    public pA(Context context) {
        this(context, null);
    }

    public pA(Context context, pA pAVar) {
        super(context, pAVar);
        this.pA = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void Og() {
        super.Og();
    }

    public void pA(KZx kZx) {
        if (kZx == null) {
            return;
        }
        this.pA.add(kZx);
        View viewBzk = kZx.Bzk();
        if (viewBzk != null) {
            ((ViewGroup) this.omh).addView(viewBzk);
        }
    }

    public void pA(KZx kZx, ViewGroup.LayoutParams layoutParams) {
        if (kZx == null) {
            return;
        }
        this.pA.add(kZx);
        View viewBzk = kZx.Bzk();
        if (viewBzk != null) {
            ((ViewGroup) this.omh).addView(viewBzk, layoutParams);
        }
    }

    public List<KZx<View>> pA() {
        return this.pA;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public KZx pA(String str) {
        KZx<T> KZx;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.Sn)) {
            return this;
        }
        for (KZx<View> kZx : this.pA) {
            if (kZx != null && (KZx = kZx.KZx(str)) != 0) {
                return KZx;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public KZx Og(String str) {
        KZx<T> kZxZZv;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.DX)) {
            return this;
        }
        for (KZx<View> kZx : this.pA) {
            if (kZx != null && (kZxZZv = kZx.ZZv(str)) != 0) {
                return kZxZZv;
            }
        }
        return null;
    }

    public C0174pA KZx() {
        return new C0174pA(this);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.Og.pA$pA, reason: collision with other inner class name */
    public static class C0174pA {
        protected boolean BF;
        protected float BSW;
        protected float Bzk;
        protected boolean DX;
        protected float JG;
        protected float ML;
        protected float SD;
        protected float SGo;
        protected boolean Sd;
        protected float Sn;
        protected pA TV;
        protected boolean TX;
        protected ViewGroup.LayoutParams WQf;
        protected float WV;
        protected float Wx;
        protected boolean XT;
        protected boolean aBv;
        protected boolean oX;
        protected float omh;
        protected boolean vZF;
        protected boolean yFO;
        protected float pA = -2.0f;
        protected float Og = -2.0f;
        protected float KZx = 0.0f;
        protected float ZZv = 0.0f;

        public C0174pA(pA pAVar) {
            this.TV = pAVar;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public void pA(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -1501175880:
                    if (str.equals("paddingLeft")) {
                        b = 0;
                    }
                    break;
                case -1375815020:
                    if (str.equals("minWidth")) {
                        b = 1;
                    }
                    break;
                case -1221029593:
                    if (str.equals("height")) {
                        b = 2;
                    }
                    break;
                case -1081309778:
                    if (str.equals(VastAttributes.MARGIN)) {
                        b = 3;
                    }
                    break;
                case -1044792121:
                    if (str.equals("marginTop")) {
                        b = 4;
                    }
                    break;
                case -806339567:
                    if (str.equals(VastAttributes.PADDING)) {
                        b = 5;
                    }
                    break;
                case -289173127:
                    if (str.equals("marginBottom")) {
                        b = 6;
                    }
                    break;
                case -133587431:
                    if (str.equals("minHeight")) {
                        b = 7;
                    }
                    break;
                case 90130308:
                    if (str.equals("paddingTop")) {
                        b = 8;
                    }
                    break;
                case 113126854:
                    if (str.equals("width")) {
                        b = 9;
                    }
                    break;
                case 202355100:
                    if (str.equals("paddingBottom")) {
                        b = 10;
                    }
                    break;
                case 713848971:
                    if (str.equals("paddingRight")) {
                        b = Ascii.VT;
                    }
                    break;
                case 975087886:
                    if (str.equals("marginRight")) {
                        b = Ascii.FF;
                    }
                    break;
                case 1970934485:
                    if (str.equals("marginLeft")) {
                        b = Ascii.CR;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    this.BSW = omh.pA(context, str2);
                    this.oX = true;
                    break;
                case 1:
                    this.KZx = omh.pA(context, str2);
                    break;
                case 2:
                    if (TextUtils.equals(str2, "match_parent")) {
                        pA pAVar = this.TV;
                        if (pAVar != null && pAVar.roi() && this.TV.xy() == -2 && !this.TV.FQ()) {
                            this.Og = -2.0f;
                        } else {
                            this.Og = -1.0f;
                        }
                    } else if (TextUtils.equals(str2, "wrap_content")) {
                        this.Og = -2.0f;
                    } else {
                        this.Og = omh.pA(context, str2);
                    }
                    break;
                case 3:
                    this.ML = omh.pA(context, str2);
                    break;
                case 4:
                    this.omh = omh.pA(context, str2);
                    this.TX = true;
                    break;
                case 5:
                    this.SGo = omh.pA(context, str2);
                    this.DX = true;
                    break;
                case 6:
                    this.Bzk = omh.pA(context, str2);
                    this.BF = true;
                    break;
                case 7:
                    this.ZZv = omh.pA(context, str2);
                    break;
                case 8:
                    this.WV = omh.pA(context, str2);
                    this.XT = true;
                    break;
                case 9:
                    if (TextUtils.equals(str2, "match_parent")) {
                        pA pAVar2 = this.TV;
                        if (pAVar2 != null && pAVar2.roi() && this.TV.rB() == -2 && !this.TV.FQ()) {
                            this.pA = -2.0f;
                        } else {
                            this.pA = -1.0f;
                        }
                    } else if (TextUtils.equals(str2, "wrap_content")) {
                        this.pA = -2.0f;
                    } else {
                        this.pA = omh.pA(context, str2);
                    }
                    break;
                case 10:
                    this.Sn = omh.pA(context, str2);
                    this.yFO = true;
                    break;
                case 11:
                    this.Wx = omh.pA(context, str2);
                    this.aBv = true;
                    break;
                case 12:
                    this.SD = omh.pA(context, str2);
                    this.Sd = true;
                    break;
                case 13:
                    this.JG = omh.pA(context, str2);
                    this.vZF = true;
                    break;
            }
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.pA + ", mHeight=" + this.Og + ", mMargin=" + this.ML + ", mMarginLeft=" + this.JG + ", mMarginRight=" + this.SD + ", mMarginTop=" + this.omh + ", mMarginBottom=" + this.Bzk + ", mParams=" + this.WQf + AbstractJsonLexerKt.END_OBJ;
        }

        public ViewGroup.LayoutParams pA() {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) this.pA, (int) this.Og);
            marginLayoutParams.leftMargin = (int) (this.vZF ? this.JG : this.ML);
            marginLayoutParams.rightMargin = (int) (this.Sd ? this.SD : this.ML);
            marginLayoutParams.topMargin = (int) (this.TX ? this.omh : this.ML);
            marginLayoutParams.bottomMargin = (int) (this.BF ? this.Bzk : this.ML);
            return marginLayoutParams;
        }
    }
}
