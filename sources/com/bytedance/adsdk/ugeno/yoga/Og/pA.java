package com.bytedance.adsdk.ugeno.yoga.Og;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.Og.KZx;
import com.bytedance.adsdk.ugeno.ZZv;
import com.bytedance.adsdk.ugeno.yoga.DX;
import com.bytedance.adsdk.ugeno.yoga.JG;
import com.bytedance.adsdk.ugeno.yoga.ML;
import com.bytedance.adsdk.ugeno.yoga.Og;
import com.bytedance.adsdk.ugeno.yoga.SD;
import com.bytedance.adsdk.ugeno.yoga.WV;
import com.bytedance.adsdk.ugeno.yoga.oX;
import com.bytedance.adsdk.ugeno.yoga.omh;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class pA extends com.bytedance.adsdk.ugeno.Og.pA<omh> {
    private oX KZx;
    private JG Og;
    private SD ZZv;
    private Og guZ;
    private Og npn;
    private WV rjD;

    public pA(Context context) {
        super(context);
        this.Og = JG.ROW;
        this.KZx = oX.NO_WRAP;
        this.ZZv = SD.FLEX_START;
        this.guZ = Og.STRETCH;
        this.npn = Og.STRETCH;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    /* JADX INFO: renamed from: fN, reason: merged with bridge method [inline-methods] */
    public omh ZZv() {
        omh omhVar = new omh(this.ML);
        omhVar.pA(this);
        this.rjD = omhVar.getYogaNode();
        return omhVar;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    protected void WQf() {
        if (this.JBA) {
            ZZv.pA().Og().pA(this.WV, this.Gx, new com.bytedance.adsdk.ugeno.pA.InterfaceC0181pA() { // from class: com.bytedance.adsdk.ugeno.yoga.Og.pA.1
                @Override // com.bytedance.adsdk.ugeno.pA.InterfaceC0181pA
                public void pA(Bitmap bitmap) {
                    final Bitmap bitmapPA;
                    if (bitmap == null || (bitmapPA = com.bytedance.adsdk.ugeno.SD.omh.pA(pA.this.ML, bitmap, (int) pA.this.HSv)) == null) {
                        return;
                    }
                    com.bytedance.adsdk.ugeno.SD.omh.pA(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.Og.pA.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pA.this.pA(new BitmapDrawable(bitmapPA));
                        }
                    });
                }
            });
            return;
        }
        ImageView imageView = new ImageView(this.ML);
        ZZv.pA().Og().pA(this.WV, this.Gx, imageView, this.omh.getWidth(), this.omh.getHeight());
        if (!this.agB || this.Bf == ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView.setScaleType(this.Bf);
        }
        omh.pA pAVar = new omh.pA(-1, -1);
        pAVar.JG(DX.ABSOLUTE.pA());
        if (this.omh instanceof omh) {
            ((omh) this.omh).addView(imageView, 0, pAVar);
            pA(imageView);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    protected void pA(Drawable drawable) {
        ImageView imageView = new ImageView(this.ML);
        imageView.setImageDrawable(drawable);
        if (!this.agB || this.Bf == ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView.setScaleType(this.Bf);
        }
        omh.pA pAVar = new omh.pA(-1, -1);
        pAVar.JG(DX.ABSOLUTE.pA());
        if (this.omh instanceof omh) {
            ((omh) this.omh).addView(imageView, 0, pAVar);
            pA(imageView);
        }
    }

    private void pA(final ImageView imageView) {
        this.omh.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.Og.pA.2
            @Override // java.lang.Runnable
            public void run() {
                WV wvPA;
                if (pA.this.omh == null || (wvPA = ((omh) pA.this.omh).pA(imageView)) == null) {
                    return;
                }
                wvPA.ZZv(pA.this.omh.getWidth());
                wvPA.JG(pA.this.omh.getHeight());
                pA.this.omh.requestLayout();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.Og.pA, com.bytedance.adsdk.ugeno.Og.KZx
    public void Og() {
        super.Og();
        this.rjD.pA(this.Og);
        this.rjD.pA(this.KZx);
        this.rjD.pA(this.ZZv);
        this.rjD.pA(this.guZ);
        this.rjD.KZx(this.npn);
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    protected void BSW() {
        if (this.qmB) {
            this.rjD.Og(ML.ALL, this.Mc);
        }
        if (this.gbA) {
            this.rjD.Og(ML.LEFT, this.IG);
        }
        if (this.Vgu) {
            this.rjD.Og(ML.RIGHT, this.lT);
        }
        if (this.CIG) {
            this.rjD.Og(ML.TOP, this.rB);
        }
        if (this.SzT) {
            this.rjD.Og(ML.BOTTOM, this.xy);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Og.pA
    public void pA(KZx kZx) {
        super.pA(kZx);
    }

    @Override // com.bytedance.adsdk.ugeno.Og.pA
    public void pA(KZx kZx, ViewGroup.LayoutParams layoutParams) {
        if (kZx == null) {
            return;
        }
        this.pA.add(kZx);
        View viewBzk = kZx.Bzk();
        if (viewBzk != null) {
            ((omh) this.omh).addView(viewBzk, layoutParams);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Og.pA
    /* JADX INFO: renamed from: dmv, reason: merged with bridge method [inline-methods] */
    public C0184pA KZx() {
        return new C0184pA(this);
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void pA(String str, String str2) {
        super.pA(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.guZ = Og.pA(str2);
                break;
            case "flexDirection":
                this.Og = JG.pA(str2);
                break;
            case "alignContent":
                this.npn = Og.pA(str2);
                break;
            case "flexWrap":
                this.KZx = oX.pA(str2);
                break;
            case "justifyContent":
                this.ZZv = SD.pA(str2);
                break;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.yoga.Og.pA$pA, reason: collision with other inner class name */
    public static class C0184pA extends com.bytedance.adsdk.ugeno.Og.pA.C0174pA {
        private boolean Bf;
        private boolean CIG;
        private boolean FQ;
        private boolean Gx;
        private boolean HSv;
        public float IG;
        public int Mc;
        private boolean SzT;
        public float Vgu;
        public int du;
        public float eG;
        public int gbA;
        public int lT;
        public int qmB;
        public int rB;
        public float roi;
        public int xy;

        public C0184pA(com.bytedance.adsdk.ugeno.Og.pA pAVar) {
            super(pAVar);
            this.du = 1;
            this.eG = 0.0f;
            this.roi = 1.0f;
            this.Mc = Og.AUTO.pA();
            this.IG = -1.0f;
            this.lT = DX.RELATIVE.pA();
        }

        @Override // com.bytedance.adsdk.ugeno.Og.pA.C0174pA
        public void pA(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.pA(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasis":
                    this.CIG = true;
                    this.IG = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, -1.0f);
                    break;
                case "bottom":
                    this.FQ = true;
                    this.xy = (int) com.bytedance.adsdk.ugeno.SD.omh.pA(context, com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0));
                    break;
                case "top":
                    this.SzT = true;
                    this.rB = (int) com.bytedance.adsdk.ugeno.SD.omh.pA(context, com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0));
                    break;
                case "left":
                    this.Gx = true;
                    this.qmB = (int) com.bytedance.adsdk.ugeno.SD.omh.pA(context, com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0));
                    break;
                case "order":
                    this.du = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 1);
                    break;
                case "ratio":
                    this.HSv = true;
                    this.Vgu = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                    break;
                case "right":
                    this.Bf = true;
                    this.gbA = (int) com.bytedance.adsdk.ugeno.SD.omh.pA(context, com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0));
                    break;
                case "position":
                    this.lT = DX.pA(str2).pA();
                    break;
                case "flexShrink":
                    this.roi = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 1.0f);
                    break;
                case "flexGrow":
                    this.eG = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                    break;
                case "alignSelf":
                    this.Mc = Og.pA(str2).pA();
                    break;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.Og.pA.C0174pA
        /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
        public omh.pA pA() {
            omh.pA pAVar = new omh.pA((int) this.pA, (int) this.Og);
            pAVar.WV((int) (this.vZF ? this.JG : this.ML));
            pAVar.Sn((int) (this.Sd ? this.SD : this.ML));
            pAVar.BSW((int) (this.TX ? this.omh : this.ML));
            pAVar.Wx((int) (this.BF ? this.Bzk : this.ML));
            pAVar.pA(this.du);
            pAVar.ML(this.Mc);
            pAVar.Og(this.eG);
            pAVar.KZx(this.roi);
            pAVar.oX(this.KZx);
            pAVar.aBv(this.ZZv);
            if (this.CIG) {
                pAVar.ZZv(this.IG);
            }
            pAVar.JG(this.lT);
            if (this.SzT) {
                pAVar.SD(this.rB);
            }
            if (this.FQ) {
                pAVar.Bzk(this.xy);
            }
            if (this.Gx) {
                pAVar.omh(this.qmB);
            }
            if (this.Bf) {
                pAVar.SGo(this.gbA);
            }
            if (this.HSv && KZx()) {
                float f = this.Vgu;
                if (f > 0.0f) {
                    pAVar.DX(f);
                }
            }
            return pAVar;
        }

        public boolean KZx() {
            if (this.pA == -1.0f && this.Og == -1.0f) {
                return false;
            }
            return this.pA == -2.0f || this.Og == -2.0f;
        }

        @Override // com.bytedance.adsdk.ugeno.Og.pA.C0174pA
        public String toString() {
            return "LayoutParams{mOrder=" + this.du + ", mFlexGrow=" + this.eG + ", mFlexShrink=" + this.roi + ", mAlignSelf=" + this.Mc + ", mFlexBasis=" + this.IG + ", mPosition=" + this.lT + ", mTop=" + this.rB + ", mBottom=" + this.xy + ", mLeft=" + this.qmB + ", mRight=" + this.gbA + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
