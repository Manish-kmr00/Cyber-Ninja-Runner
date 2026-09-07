package com.bytedance.adsdk.Og.KZx.KZx;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.Og.KZx.Og.Sn;
import com.bytedance.adsdk.Og.pA.Og.oX;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class pA implements com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA, com.bytedance.adsdk.Og.pA.pA.ML {
    private pA BF;
    private final RectF DX;
    private final Matrix IG;
    BlurMaskFilter JG;
    final ML KZx;
    float ML;
    private Paint Mc;
    final com.bytedance.adsdk.Og.Bzk Og;
    private com.bytedance.adsdk.Og.pA.Og.omh Sd;
    private final Paint Sn;
    private List<pA> TV;
    private com.bytedance.adsdk.Og.pA.Og.ZZv TX;
    private pA WQf;
    private final Paint Wx;
    private final RectF XT;
    final oX ZZv;
    private final RectF aBv;
    private final List<com.bytedance.adsdk.Og.pA.Og.pA<?, ?>> du;
    private boolean eG;
    private float lT;
    private final RectF oX;
    final Matrix pA;
    private boolean roi;
    private final String vZF;
    private final RectF yFO;
    private final Path SD = new Path();
    private final Matrix omh = new Matrix();
    private final Matrix Bzk = new Matrix();
    private final Paint SGo = new com.bytedance.adsdk.Og.pA.pA(1);
    private final Paint BSW = new com.bytedance.adsdk.Og.pA.pA(1, PorterDuff.Mode.DST_IN);
    private final Paint WV = new com.bytedance.adsdk.Og.pA.pA(1, PorterDuff.Mode.DST_OUT);

    @Override // com.bytedance.adsdk.Og.pA.pA.KZx
    public void pA(List<com.bytedance.adsdk.Og.pA.pA.KZx> list, List<com.bytedance.adsdk.Og.pA.pA.KZx> list2) {
    }

    static pA pA(Og og, ML ml, com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.SD sd, Context context) {
        switch (AnonymousClass2.pA[ml.BSW().ordinal()]) {
            case 1:
                return new SD(bzk, ml, og, sd);
            case 2:
                return new Og(bzk, ml, sd.Og(ml.SD()), sd, context);
            case 3:
                return new omh(bzk, ml);
            case 4:
                if (pA(bzk, ml, "text:")) {
                    return new KZx(bzk, ml, context);
                }
                if (pA(bzk, ml, "videoview:")) {
                    return new SGo(bzk, ml, context);
                }
                return new ZZv(bzk, ml);
            case 5:
                return new JG(bzk, ml);
            case 6:
                return new Bzk(bzk, ml);
            default:
                new StringBuilder("Unknown layer type ").append(ml.BSW());
                return null;
        }
    }

    private static boolean pA(com.bytedance.adsdk.Og.Bzk bzk, ML ml, String str) {
        com.bytedance.adsdk.Og.SGo sGoJG;
        if (bzk == null || ml == null || str == null || (sGoJG = bzk.JG(ml.SD())) == null) {
            return false;
        }
        return str.equals(sGoJG.SGo());
    }

    pA(com.bytedance.adsdk.Og.Bzk bzk, ML ml) {
        com.bytedance.adsdk.Og.pA.pA pAVar = new com.bytedance.adsdk.Og.pA.pA(1);
        this.Wx = pAVar;
        this.Sn = new com.bytedance.adsdk.Og.pA.pA(PorterDuff.Mode.CLEAR);
        this.DX = new RectF();
        this.oX = new RectF();
        this.aBv = new RectF();
        this.XT = new RectF();
        this.yFO = new RectF();
        this.pA = new Matrix();
        this.du = new ArrayList();
        this.eG = true;
        this.ML = 0.0f;
        this.IG = new Matrix();
        this.lT = 1.0f;
        this.Og = bzk;
        this.KZx = ml;
        this.vZF = ml.JG() + "#draw";
        if (ml.WV() == ML.Og.INVERT) {
            pAVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            pAVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        oX oXVarSGo = ml.DX().SGo();
        this.ZZv = oXVarSGo;
        oXVarSGo.pA((com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA) this);
        if (ml.SGo() != null && !ml.SGo().isEmpty()) {
            com.bytedance.adsdk.Og.pA.Og.omh omhVar = new com.bytedance.adsdk.Og.pA.Og.omh(ml.SGo());
            this.Sd = omhVar;
            Iterator<com.bytedance.adsdk.Og.pA.Og.pA<Sn, Path>> it = omhVar.Og().iterator();
            while (it.hasNext()) {
                it.next().pA(this);
            }
            for (com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVar2 : this.Sd.KZx()) {
                pA(pAVar2);
                pAVar2.pA(this);
            }
        }
        WV();
    }

    void pA(boolean z) {
        if (z && this.Mc == null) {
            this.Mc = new com.bytedance.adsdk.Og.pA.pA();
        }
        this.roi = z;
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA
    public void pA() {
        Wx();
    }

    ML Og() {
        return this.KZx;
    }

    void pA(pA pAVar) {
        this.BF = pAVar;
    }

    boolean KZx() {
        return this.BF != null;
    }

    void Og(pA pAVar) {
        this.WQf = pAVar;
    }

    private void WV() {
        if (!this.KZx.ZZv().isEmpty()) {
            com.bytedance.adsdk.Og.pA.Og.ZZv zZv = new com.bytedance.adsdk.Og.pA.Og.ZZv(this.KZx.ZZv());
            this.TX = zZv;
            zZv.pA();
            this.TX.pA(new com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA() { // from class: com.bytedance.adsdk.Og.KZx.KZx.pA.1
                @Override // com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA
                public void pA() {
                    pA pAVar = pA.this;
                    pAVar.Og(pAVar.TX.Bzk() == 1.0f);
                }
            });
            Og(this.TX.SD().floatValue() == 1.0f);
            pA(this.TX);
            return;
        }
        Og(true);
    }

    private void Wx() {
        this.Og.invalidateSelf();
    }

    public void pA(com.bytedance.adsdk.Og.pA.Og.pA<?, ?> pAVar) {
        if (pAVar == null) {
            return;
        }
        this.du.add(pAVar);
    }

    public Matrix ZZv() {
        return this.IG;
    }

    public String ML() {
        ML ml = this.KZx;
        if (ml != null) {
            return ml.SD();
        }
        return null;
    }

    public void pA(RectF rectF, Matrix matrix, boolean z) {
        this.DX.set(0.0f, 0.0f, 0.0f, 0.0f);
        DX();
        this.pA.set(matrix);
        if (z) {
            List<pA> list = this.TV;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.pA.preConcat(this.TV.get(size).ZZv.ZZv());
                }
            } else {
                pA pAVar = this.WQf;
                if (pAVar != null) {
                    this.pA.preConcat(pAVar.ZZv.ZZv());
                }
            }
        }
        this.pA.preConcat(this.ZZv.ZZv());
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        Integer numSD;
        com.bytedance.adsdk.Og.ML.pA(this.vZF);
        if (!this.eG || this.KZx.TX()) {
            com.bytedance.adsdk.Og.ML.Og(this.vZF);
            return;
        }
        DX();
        com.bytedance.adsdk.Og.ML.pA("Layer#parentMatrix");
        this.IG.set(matrix);
        this.omh.reset();
        this.omh.set(matrix);
        for (int size = this.TV.size() - 1; size >= 0; size--) {
            this.omh.preConcat(this.TV.get(size).ZZv.ZZv());
        }
        com.bytedance.adsdk.Og.ML.Og("Layer#parentMatrix");
        com.bytedance.adsdk.Og.pA.Og.pA<?, Integer> pAVarPA = this.ZZv.pA();
        int iIntValue = (int) ((((i / 255.0f) * ((pAVarPA == null || (numSD = pAVarPA.SD()) == null) ? 100 : numSD.intValue())) / 100.0f) * 255.0f);
        if (!KZx() && !SD()) {
            this.omh.preConcat(this.ZZv.ZZv());
            com.bytedance.adsdk.Og.ML.pA("Layer#drawLayer");
            Og(canvas, this.omh, iIntValue);
            com.bytedance.adsdk.Og.ML.Og("Layer#drawLayer");
            KZx(com.bytedance.adsdk.Og.ML.Og(this.vZF));
            return;
        }
        com.bytedance.adsdk.Og.ML.pA("Layer#computeBounds");
        pA(this.DX, this.omh, false);
        Og(this.DX, matrix);
        this.omh.preConcat(this.ZZv.ZZv());
        pA(this.DX, this.omh);
        this.oX.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.Bzk);
        if (!this.Bzk.isIdentity()) {
            Matrix matrix2 = this.Bzk;
            matrix2.invert(matrix2);
            this.Bzk.mapRect(this.oX);
        }
        if (!this.DX.intersect(this.oX)) {
            this.DX.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        com.bytedance.adsdk.Og.ML.Og("Layer#computeBounds");
        if (this.DX.width() >= 1.0f && this.DX.height() >= 1.0f) {
            com.bytedance.adsdk.Og.ML.pA("Layer#saveLayer");
            this.SGo.setAlpha(255);
            com.bytedance.adsdk.Og.JG.JG.pA(canvas, this.DX, this.SGo);
            com.bytedance.adsdk.Og.ML.Og("Layer#saveLayer");
            pA(canvas);
            com.bytedance.adsdk.Og.ML.pA("Layer#drawLayer");
            Og(canvas, this.omh, iIntValue);
            com.bytedance.adsdk.Og.ML.Og("Layer#drawLayer");
            if (SD()) {
                pA(canvas, this.omh);
            }
            if (KZx()) {
                com.bytedance.adsdk.Og.ML.pA("Layer#drawMatte");
                com.bytedance.adsdk.Og.ML.pA("Layer#saveLayer");
                com.bytedance.adsdk.Og.JG.JG.pA(canvas, this.DX, this.Wx, 19);
                com.bytedance.adsdk.Og.ML.Og("Layer#saveLayer");
                pA(canvas);
                this.BF.pA(canvas, matrix, iIntValue);
                com.bytedance.adsdk.Og.ML.pA("Layer#restoreLayer");
                canvas.restore();
                com.bytedance.adsdk.Og.ML.Og("Layer#restoreLayer");
                com.bytedance.adsdk.Og.ML.Og("Layer#drawMatte");
            }
            com.bytedance.adsdk.Og.ML.pA("Layer#restoreLayer");
            canvas.restore();
            com.bytedance.adsdk.Og.ML.Og("Layer#restoreLayer");
        }
        if (this.roi && (paint = this.Mc) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.Mc.setColor(-251901);
            this.Mc.setStrokeWidth(4.0f);
            canvas.drawRect(this.DX, this.Mc);
            this.Mc.setStyle(Paint.Style.FILL);
            this.Mc.setColor(1357638635);
            canvas.drawRect(this.DX, this.Mc);
        }
        KZx(com.bytedance.adsdk.Og.ML.Og(this.vZF));
    }

    private void KZx(float f) {
        this.Og.du().KZx().pA(this.KZx.JG(), f);
    }

    private void pA(Canvas canvas) {
        com.bytedance.adsdk.Og.ML.pA("Layer#clearLayer");
        canvas.drawRect(this.DX.left - 1.0f, this.DX.top - 1.0f, this.DX.right + 1.0f, this.DX.bottom + 1.0f, this.Sn);
        com.bytedance.adsdk.Og.ML.Og("Layer#clearLayer");
    }

    private void pA(RectF rectF, Matrix matrix) {
        this.aBv.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (SD()) {
            int size = this.Sd.pA().size();
            for (int i = 0; i < size; i++) {
                com.bytedance.adsdk.Og.KZx.Og.omh omhVar = this.Sd.pA().get(i);
                Path pathSD = this.Sd.Og().get(i).SD();
                if (pathSD != null) {
                    this.SD.set(pathSD);
                    this.SD.transform(matrix);
                    int i2 = AnonymousClass2.Og[omhVar.pA().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        return;
                    }
                    if ((i2 == 3 || i2 == 4) && omhVar.ZZv()) {
                        return;
                    }
                    this.SD.computeBounds(this.yFO, false);
                    if (i == 0) {
                        this.aBv.set(this.yFO);
                    } else {
                        RectF rectF2 = this.aBv;
                        rectF2.set(Math.min(rectF2.left, this.yFO.left), Math.min(this.aBv.top, this.yFO.top), Math.max(this.aBv.right, this.yFO.right), Math.max(this.aBv.bottom, this.yFO.bottom));
                    }
                }
            }
            if (rectF.intersect(this.aBv)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.Og.KZx.KZx.pA$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] Og;
        static final /* synthetic */ int[] pA;

        static {
            int[] iArr = new int[com.bytedance.adsdk.Og.KZx.Og.omh.pA.values().length];
            Og = iArr;
            try {
                iArr[com.bytedance.adsdk.Og.KZx.Og.omh.pA.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Og[com.bytedance.adsdk.Og.KZx.Og.omh.pA.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Og[com.bytedance.adsdk.Og.KZx.Og.omh.pA.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Og[com.bytedance.adsdk.Og.KZx.Og.omh.pA.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ML.pA.values().length];
            pA = iArr2;
            try {
                iArr2[ML.pA.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                pA[ML.pA.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                pA[ML.pA.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                pA[ML.pA.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                pA[ML.pA.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                pA[ML.pA.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                pA[ML.pA.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private void Og(RectF rectF, Matrix matrix) {
        if (KZx() && this.KZx.WV() != ML.Og.INVERT) {
            this.XT.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.BF.pA(this.XT, matrix, true);
            if (rectF.intersect(this.XT)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public float JG() {
        return this.lT;
    }

    protected void pA(int i) {
        this.lT = ((this.ZZv.pA() != null ? this.ZZv.pA().SD().intValue() : 100) / 100.0f) * (i / 255.0f);
    }

    public void Og(Canvas canvas, Matrix matrix, int i) {
        pA(i);
    }

    private void pA(Canvas canvas, Matrix matrix) {
        com.bytedance.adsdk.Og.ML.pA("Layer#saveLayer");
        com.bytedance.adsdk.Og.JG.JG.pA(canvas, this.DX, this.BSW, 19);
        if (Build.VERSION.SDK_INT < 28) {
            pA(canvas);
        }
        com.bytedance.adsdk.Og.ML.Og("Layer#saveLayer");
        for (int i = 0; i < this.Sd.pA().size(); i++) {
            com.bytedance.adsdk.Og.KZx.Og.omh omhVar = this.Sd.pA().get(i);
            com.bytedance.adsdk.Og.pA.Og.pA<Sn, Path> pAVar = this.Sd.Og().get(i);
            com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVar2 = this.Sd.KZx().get(i);
            int i2 = AnonymousClass2.Og[omhVar.pA().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.SGo.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.SGo.setAlpha(255);
                        canvas.drawRect(this.DX, this.SGo);
                    }
                    if (omhVar.ZZv()) {
                        KZx(canvas, matrix, pAVar, pAVar2);
                    } else {
                        pA(canvas, matrix, pAVar);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (omhVar.ZZv()) {
                            Og(canvas, matrix, pAVar, pAVar2);
                        } else {
                            pA(canvas, matrix, pAVar, pAVar2);
                        }
                    }
                } else if (omhVar.ZZv()) {
                    ML(canvas, matrix, pAVar, pAVar2);
                } else {
                    ZZv(canvas, matrix, pAVar, pAVar2);
                }
            } else if (Sn()) {
                this.SGo.setAlpha(255);
                canvas.drawRect(this.DX, this.SGo);
            }
        }
        com.bytedance.adsdk.Og.ML.pA("Layer#restoreLayer");
        canvas.restore();
        com.bytedance.adsdk.Og.ML.Og("Layer#restoreLayer");
    }

    private boolean Sn() {
        if (this.Sd.Og().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.Sd.pA().size(); i++) {
            if (this.Sd.pA().get(i).pA() != com.bytedance.adsdk.Og.KZx.Og.omh.pA.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void pA(Canvas canvas, Matrix matrix, com.bytedance.adsdk.Og.pA.Og.pA<Sn, Path> pAVar, com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVar2) {
        this.SD.set(pAVar.SD());
        this.SD.transform(matrix);
        this.SGo.setAlpha((int) (pAVar2.SD().intValue() * 2.55f));
        canvas.drawPath(this.SD, this.SGo);
    }

    private void Og(Canvas canvas, Matrix matrix, com.bytedance.adsdk.Og.pA.Og.pA<Sn, Path> pAVar, com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVar2) {
        com.bytedance.adsdk.Og.JG.JG.pA(canvas, this.DX, this.SGo);
        canvas.drawRect(this.DX, this.SGo);
        this.SD.set(pAVar.SD());
        this.SD.transform(matrix);
        this.SGo.setAlpha((int) (pAVar2.SD().intValue() * 2.55f));
        canvas.drawPath(this.SD, this.WV);
        canvas.restore();
    }

    private void pA(Canvas canvas, Matrix matrix, com.bytedance.adsdk.Og.pA.Og.pA<Sn, Path> pAVar) {
        this.SD.set(pAVar.SD());
        this.SD.transform(matrix);
        canvas.drawPath(this.SD, this.WV);
    }

    private void KZx(Canvas canvas, Matrix matrix, com.bytedance.adsdk.Og.pA.Og.pA<Sn, Path> pAVar, com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVar2) {
        com.bytedance.adsdk.Og.JG.JG.pA(canvas, this.DX, this.WV);
        canvas.drawRect(this.DX, this.SGo);
        this.WV.setAlpha((int) (pAVar2.SD().intValue() * 2.55f));
        this.SD.set(pAVar.SD());
        this.SD.transform(matrix);
        canvas.drawPath(this.SD, this.WV);
        canvas.restore();
    }

    private void ZZv(Canvas canvas, Matrix matrix, com.bytedance.adsdk.Og.pA.Og.pA<Sn, Path> pAVar, com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVar2) {
        com.bytedance.adsdk.Og.JG.JG.pA(canvas, this.DX, this.BSW);
        this.SD.set(pAVar.SD());
        this.SD.transform(matrix);
        this.SGo.setAlpha((int) (pAVar2.SD().intValue() * 2.55f));
        canvas.drawPath(this.SD, this.SGo);
        canvas.restore();
    }

    private void ML(Canvas canvas, Matrix matrix, com.bytedance.adsdk.Og.pA.Og.pA<Sn, Path> pAVar, com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVar2) {
        com.bytedance.adsdk.Og.JG.JG.pA(canvas, this.DX, this.BSW);
        canvas.drawRect(this.DX, this.SGo);
        this.WV.setAlpha((int) (pAVar2.SD().intValue() * 2.55f));
        this.SD.set(pAVar.SD());
        this.SD.transform(matrix);
        canvas.drawPath(this.SD, this.WV);
        canvas.restore();
    }

    boolean SD() {
        com.bytedance.adsdk.Og.pA.Og.omh omhVar = this.Sd;
        return (omhVar == null || omhVar.Og().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(boolean z) {
        if (z != this.eG) {
            this.eG = z;
            Wx();
        }
    }

    public boolean omh() {
        return this.eG;
    }

    void pA(float f) {
        this.ZZv.pA(f);
        if (this.Sd != null) {
            for (int i = 0; i < this.Sd.Og().size(); i++) {
                this.Sd.Og().get(i).pA(f);
            }
        }
        com.bytedance.adsdk.Og.pA.Og.ZZv zZv = this.TX;
        if (zZv != null) {
            zZv.pA(f);
        }
        pA pAVar = this.BF;
        if (pAVar != null) {
            pAVar.pA(f);
        }
        for (int i2 = 0; i2 < this.du.size(); i2++) {
            this.du.get(i2).pA(f);
        }
    }

    private void DX() {
        if (this.TV != null) {
            return;
        }
        if (this.WQf == null) {
            this.TV = Collections.emptyList();
            return;
        }
        this.TV = new ArrayList();
        for (pA pAVar = this.WQf; pAVar != null; pAVar = pAVar.WQf) {
            this.TV.add(pAVar);
        }
    }

    public String Bzk() {
        return this.KZx.JG();
    }

    public com.bytedance.adsdk.Og.KZx.Og.pA SGo() {
        return this.KZx.BF();
    }

    public BlurMaskFilter Og(float f) {
        if (this.ML == f) {
            return this.JG;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.JG = blurMaskFilter;
        this.ML = f;
        return blurMaskFilter;
    }

    public com.bytedance.adsdk.Og.ML.SGo BSW() {
        return this.KZx.WQf();
    }
}
