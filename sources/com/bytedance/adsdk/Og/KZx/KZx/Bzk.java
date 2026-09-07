package com.bytedance.adsdk.Og.KZx.KZx;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.LongSparseArray;
import com.bytedance.adsdk.Og.KZx.Og.oX;
import com.bytedance.adsdk.Og.KZx.pA.BSW;
import com.bytedance.adsdk.Og.pA.Og.DX;
import com.bytedance.adsdk.Og.vZF;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class Bzk extends com.bytedance.adsdk.Og.KZx.KZx.pA {
    private com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> BF;
    private final Paint BSW;
    private final Matrix Bzk;
    private final DX DX;
    private final StringBuilder SD;
    private final Paint SGo;
    private com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> Sd;
    private final List<pA> Sn;
    private com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> TV;
    private com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> TX;
    private com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> WQf;
    private final Map<com.bytedance.adsdk.Og.KZx.ZZv, List<com.bytedance.adsdk.Og.pA.pA.ZZv>> WV;
    private final LongSparseArray<String> Wx;
    private com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> XT;
    private final com.bytedance.adsdk.Og.SD aBv;
    private com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> du;
    private com.bytedance.adsdk.Og.pA.Og.pA<Typeface, Typeface> eG;
    private final com.bytedance.adsdk.Og.Bzk oX;
    private final RectF omh;
    private com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> vZF;
    private com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> yFO;

    Bzk(com.bytedance.adsdk.Og.Bzk bzk, ML ml) {
        super(bzk, ml);
        this.SD = new StringBuilder(2);
        this.omh = new RectF();
        this.Bzk = new Matrix();
        int i = 1;
        this.SGo = new Paint(i) { // from class: com.bytedance.adsdk.Og.KZx.KZx.Bzk.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.BSW = new Paint(i) { // from class: com.bytedance.adsdk.Og.KZx.KZx.Bzk.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.WV = new HashMap();
        this.Wx = new LongSparseArray<>();
        this.Sn = new ArrayList();
        this.oX = bzk;
        this.aBv = ml.pA();
        DX dxPA = ml.yFO().pA();
        this.DX = dxPA;
        dxPA.pA(this);
        pA(dxPA);
        BSW bswVZF = ml.vZF();
        if (bswVZF != null && bswVZF.pA != null) {
            com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVarPA = bswVZF.pA.pA();
            this.XT = pAVarPA;
            pAVarPA.pA(this);
            pA(this.XT);
        }
        if (bswVZF != null && bswVZF.Og != null) {
            com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVarPA2 = bswVZF.Og.pA();
            this.vZF = pAVarPA2;
            pAVarPA2.pA(this);
            pA(this.vZF);
        }
        if (bswVZF != null && bswVZF.KZx != null) {
            com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA3 = bswVZF.KZx.pA();
            this.TX = pAVarPA3;
            pAVarPA3.pA(this);
            pA(this.TX);
        }
        if (bswVZF == null || bswVZF.ZZv == null) {
            return;
        }
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA4 = bswVZF.ZZv.pA();
        this.WQf = pAVarPA4;
        pAVarPA4.pA(this);
        pA(this.WQf);
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.pA, com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(RectF rectF, Matrix matrix, boolean z) {
        super.pA(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.aBv.ZZv().width(), this.aBv.ZZv().height());
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.pA
    public void Og(Canvas canvas, Matrix matrix, int i) {
        super.Og(canvas, matrix, i);
        com.bytedance.adsdk.Og.KZx.Og ogSD = this.DX.SD();
        com.bytedance.adsdk.Og.KZx.KZx kZx = this.aBv.DX().get(ogSD.Og);
        if (kZx == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        pA(ogSD, matrix);
        if (this.oX.TV()) {
            pA(ogSD, matrix, kZx, canvas);
        } else {
            pA(ogSD, kZx, canvas);
        }
        canvas.restore();
    }

    private void pA(com.bytedance.adsdk.Og.KZx.Og og, Matrix matrix) {
        com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVar = this.yFO;
        if (pAVar != null) {
            this.SGo.setColor(pAVar.SD().intValue());
        } else {
            com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVar2 = this.XT;
            if (pAVar2 != null) {
                this.SGo.setColor(pAVar2.SD().intValue());
            } else {
                this.SGo.setColor(og.omh);
            }
        }
        com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVar3 = this.Sd;
        if (pAVar3 != null) {
            this.BSW.setColor(pAVar3.SD().intValue());
        } else {
            com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVar4 = this.vZF;
            if (pAVar4 != null) {
                this.BSW.setColor(pAVar4.SD().intValue());
            } else {
                this.BSW.setColor(og.Bzk);
            }
        }
        int iIntValue = ((this.ZZv.pA() == null ? 100 : this.ZZv.pA().SD().intValue()) * 255) / 100;
        this.SGo.setAlpha(iIntValue);
        this.BSW.setAlpha(iIntValue);
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVar5 = this.BF;
        if (pAVar5 != null) {
            this.BSW.setStrokeWidth(pAVar5.SD().floatValue());
            return;
        }
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVar6 = this.TX;
        if (pAVar6 != null) {
            this.BSW.setStrokeWidth(pAVar6.SD().floatValue());
        } else {
            this.BSW.setStrokeWidth(og.SGo * com.bytedance.adsdk.Og.JG.JG.pA());
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0053  */
    /* JADX WARN: Code duplicated, block: B:17:0x005e  */
    /* JADX WARN: Code duplicated, block: B:18:0x0060  */
    /* JADX WARN: Code duplicated, block: B:22:0x007c A[LOOP:1: B:20:0x0076->B:22:0x007c, LOOP_END] */
    private void pA(com.bytedance.adsdk.Og.KZx.Og og, Matrix matrix, com.bytedance.adsdk.Og.KZx.KZx kZx, Canvas canvas) {
        float fFloatValue;
        float fFloatValue2;
        float f;
        int i;
        int i2;
        float f2;
        List<pA> listPA;
        int i3;
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVar = this.du;
        if (pAVar != null) {
            fFloatValue = pAVar.SD().floatValue();
        } else {
            fFloatValue = og.KZx;
        }
        float f3 = fFloatValue / 100.0f;
        float fPA = com.bytedance.adsdk.Og.JG.JG.pA(matrix);
        List<String> listPA2 = pA(og.pA);
        int size = listPA2.size();
        float f4 = og.ML / 10.0f;
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVar2 = this.TV;
        if (pAVar2 != null) {
            fFloatValue2 = pAVar2.SD().floatValue();
        } else {
            com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVar3 = this.WQf;
            if (pAVar3 != null) {
                fFloatValue2 = pAVar3.SD().floatValue();
            }
            f = f4;
            i = -1;
            i2 = 0;
            while (i2 < size) {
                String str = listPA2.get(i2);
                if (og.Wx == null) {
                    f2 = 0.0f;
                } else {
                    f2 = og.Wx.x;
                }
                int i4 = i2;
                listPA = pA(str, f2, kZx, f3, f, true);
                i3 = 0;
                while (i3 < listPA.size()) {
                    pA pAVar4 = listPA.get(i3);
                    int i5 = i + 1;
                    canvas.save();
                    pA(canvas, og, i5, pAVar4.Og);
                    pA(pAVar4.pA, og, kZx, canvas, fPA, f3, f);
                    canvas.restore();
                    i3++;
                    listPA = listPA;
                    i = i5;
                }
                i2 = i4 + 1;
            }
        }
        f4 += fFloatValue2;
        f = f4;
        i = -1;
        i2 = 0;
        while (i2 < size) {
            String str2 = listPA2.get(i2);
            if (og.Wx == null) {
                f2 = 0.0f;
            } else {
                f2 = og.Wx.x;
            }
            int i6 = i2;
            listPA = pA(str2, f2, kZx, f3, f, true);
            i3 = 0;
            while (i3 < listPA.size()) {
                pA pAVar5 = listPA.get(i3);
                int i7 = i + 1;
                canvas.save();
                pA(canvas, og, i7, pAVar5.Og);
                pA(pAVar5.pA, og, kZx, canvas, fPA, f3, f);
                canvas.restore();
                i3++;
                listPA = listPA;
                i = i7;
            }
            i2 = i6 + 1;
        }
    }

    private void pA(String str, com.bytedance.adsdk.Og.KZx.Og og, com.bytedance.adsdk.Og.KZx.KZx kZx, Canvas canvas, float f, float f2, float f3) {
        for (int i = 0; i < str.length(); i++) {
            com.bytedance.adsdk.Og.KZx.ZZv zZv = this.aBv.Sn().get(com.bytedance.adsdk.Og.KZx.ZZv.pA(str.charAt(i), kZx.pA(), kZx.KZx()));
            if (zZv != null) {
                pA(zZv, f2, og, canvas);
                canvas.translate((((float) zZv.Og()) * f2 * com.bytedance.adsdk.Og.JG.JG.pA()) + f3, 0.0f);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0094  */
    /* JADX WARN: Code duplicated, block: B:23:0x009f  */
    /* JADX WARN: Code duplicated, block: B:24:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:28:0x00bd A[LOOP:1: B:26:0x00b7->B:28:0x00bd, LOOP_END] */
    private void pA(com.bytedance.adsdk.Og.KZx.Og og, com.bytedance.adsdk.Og.KZx.KZx kZx, Canvas canvas) {
        float fFloatValue;
        float fFloatValue2;
        float fPA;
        List<String> listPA;
        int size;
        int i;
        int i2;
        float f;
        List<pA> listPA2;
        int i3;
        Typeface typefacePA = pA(kZx);
        if (typefacePA == null) {
            return;
        }
        String strOg = og.pA;
        vZF vzfWQf = this.oX.WQf();
        if (vzfWQf != null) {
            strOg = vzfWQf.Og(Bzk(), strOg);
        }
        this.SGo.setTypeface(typefacePA);
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVar = this.du;
        if (pAVar != null) {
            fFloatValue = pAVar.SD().floatValue();
        } else {
            fFloatValue = og.KZx;
        }
        this.SGo.setTextSize(com.bytedance.adsdk.Og.JG.JG.pA() * fFloatValue);
        this.BSW.setTypeface(this.SGo.getTypeface());
        this.BSW.setTextSize(this.SGo.getTextSize());
        float f2 = og.ML / 10.0f;
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVar2 = this.TV;
        if (pAVar2 != null) {
            fFloatValue2 = pAVar2.SD().floatValue();
        } else {
            com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVar3 = this.WQf;
            if (pAVar3 != null) {
                fFloatValue2 = pAVar3.SD().floatValue();
            }
            fPA = ((f2 * com.bytedance.adsdk.Og.JG.JG.pA()) * fFloatValue) / 100.0f;
            listPA = pA(strOg);
            size = listPA.size();
            i = -1;
            i2 = 0;
            while (i2 < size) {
                String str = listPA.get(i2);
                if (og.Wx == null) {
                    f = 0.0f;
                } else {
                    f = og.Wx.x;
                }
                int i4 = i2;
                listPA2 = pA(str, f, kZx, 0.0f, fPA, false);
                for (i3 = 0; i3 < listPA2.size(); i3++) {
                    pA pAVar4 = listPA2.get(i3);
                    i++;
                    canvas.save();
                    pA(canvas, og, i, pAVar4.Og);
                    pA(pAVar4.pA, og, canvas, fPA);
                    canvas.restore();
                }
                i2 = i4 + 1;
            }
        }
        f2 += fFloatValue2;
        fPA = ((f2 * com.bytedance.adsdk.Og.JG.JG.pA()) * fFloatValue) / 100.0f;
        listPA = pA(strOg);
        size = listPA.size();
        i = -1;
        i2 = 0;
        while (i2 < size) {
            String str2 = listPA.get(i2);
            if (og.Wx == null) {
                f = 0.0f;
            } else {
                f = og.Wx.x;
            }
            int i5 = i2;
            listPA2 = pA(str2, f, kZx, 0.0f, fPA, false);
            while (i3 < listPA2.size()) {
                pA pAVar5 = listPA2.get(i3);
                i++;
                canvas.save();
                pA(canvas, og, i, pAVar5.Og);
                pA(pAVar5.pA, og, canvas, fPA);
                canvas.restore();
            }
            i2 = i5 + 1;
        }
    }

    private void pA(Canvas canvas, com.bytedance.adsdk.Og.KZx.Og og, int i, float f) {
        PointF pointF = og.WV;
        PointF pointF2 = og.Wx;
        float fPA = com.bytedance.adsdk.Og.JG.JG.pA();
        float f2 = (i * og.JG * fPA) + (pointF == null ? 0.0f : (og.JG * 0.6f * fPA) + pointF.y);
        float f3 = pointF == null ? 0.0f : pointF.x;
        float f4 = pointF2 != null ? pointF2.x : 0.0f;
        int i2 = AnonymousClass3.pA[og.ZZv.ordinal()];
        if (i2 == 1) {
            canvas.translate(f3, f2);
        } else if (i2 == 2) {
            canvas.translate((f3 + f4) - f, f2);
        } else {
            if (i2 != 3) {
                return;
            }
            canvas.translate((f3 + (f4 / 2.0f)) - (f / 2.0f), f2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.Og.KZx.KZx.Bzk$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] pA;

        static {
            int[] iArr = new int[com.bytedance.adsdk.Og.KZx.Og.pA.values().length];
            pA = iArr;
            try {
                iArr[com.bytedance.adsdk.Og.KZx.Og.pA.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                pA[com.bytedance.adsdk.Og.KZx.Og.pA.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                pA[com.bytedance.adsdk.Og.KZx.Og.pA.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private Typeface pA(com.bytedance.adsdk.Og.KZx.KZx kZx) {
        Typeface typefaceSD;
        com.bytedance.adsdk.Og.pA.Og.pA<Typeface, Typeface> pAVar = this.eG;
        if (pAVar != null && (typefaceSD = pAVar.SD()) != null) {
            return typefaceSD;
        }
        Typeface typefacePA = this.oX.pA(kZx);
        return typefacePA != null ? typefacePA : kZx.ZZv();
    }

    private List<String> pA(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void pA(String str, com.bytedance.adsdk.Og.KZx.Og og, Canvas canvas, float f) {
        int length = 0;
        while (length < str.length()) {
            String strPA = pA(str, length);
            length += strPA.length();
            pA(strPA, og, canvas);
            canvas.translate(this.SGo.measureText(strPA) + f, 0.0f);
        }
    }

    private List<pA> pA(String str, float f, com.bytedance.adsdk.Og.KZx.KZx kZx, float f2, float f3, boolean z) {
        float fMeasureText;
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            if (z) {
                com.bytedance.adsdk.Og.KZx.ZZv zZv = this.aBv.Sn().get(com.bytedance.adsdk.Og.KZx.ZZv.pA(cCharAt, kZx.pA(), kZx.KZx()));
                if (zZv != null) {
                    fMeasureText = ((float) zZv.Og()) * f2 * com.bytedance.adsdk.Og.JG.JG.pA();
                }
            } else {
                fMeasureText = this.SGo.measureText(str.substring(i4, i4 + 1));
            }
            float f7 = fMeasureText + f3;
            if (cCharAt == ' ') {
                z2 = true;
                f6 = f7;
            } else if (z2) {
                z2 = false;
                i3 = i4;
                f5 = f7;
            } else {
                f5 += f7;
            }
            f4 += f7;
            if (f > 0.0f && f4 >= f && cCharAt != ' ') {
                i++;
                pA pAVarOg = Og(i);
                if (i3 == i2) {
                    String strSubstring = str.substring(i2, i4);
                    String strTrim = strSubstring.trim();
                    pAVarOg.pA(strTrim, (f4 - f7) - ((strTrim.length() - strSubstring.length()) * f6));
                    i2 = i4;
                    i3 = i2;
                    f4 = f7;
                    f5 = f4;
                } else {
                    String strSubstring2 = str.substring(i2, i3 - 1);
                    String strTrim2 = strSubstring2.trim();
                    pAVarOg.pA(strTrim2, ((f4 - f5) - ((strSubstring2.length() - strTrim2.length()) * f6)) - f6);
                    f4 = f5;
                    i2 = i3;
                }
            }
        }
        if (f4 > 0.0f) {
            i++;
            Og(i).pA(str.substring(i2), f4);
        }
        return this.Sn.subList(0, i);
    }

    private pA Og(int i) {
        for (int size = this.Sn.size(); size < i; size++) {
            this.Sn.add(new pA());
        }
        return this.Sn.get(i - 1);
    }

    private void pA(com.bytedance.adsdk.Og.KZx.ZZv zZv, float f, com.bytedance.adsdk.Og.KZx.Og og, Canvas canvas) {
        List<com.bytedance.adsdk.Og.pA.pA.ZZv> listPA = pA(zZv);
        for (int i = 0; i < listPA.size(); i++) {
            Path pathZZv = listPA.get(i).ZZv();
            pathZZv.computeBounds(this.omh, false);
            this.Bzk.reset();
            this.Bzk.preTranslate(0.0f, (-og.SD) * com.bytedance.adsdk.Og.JG.JG.pA());
            this.Bzk.preScale(f, f);
            pathZZv.transform(this.Bzk);
            if (og.BSW) {
                pA(pathZZv, this.SGo, canvas);
                pA(pathZZv, this.BSW, canvas);
            } else {
                pA(pathZZv, this.BSW, canvas);
                pA(pathZZv, this.SGo, canvas);
            }
        }
    }

    private void pA(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void pA(String str, com.bytedance.adsdk.Og.KZx.Og og, Canvas canvas) {
        if (og.BSW) {
            pA(str, this.SGo, canvas);
            pA(str, this.BSW, canvas);
        } else {
            pA(str, this.BSW, canvas);
            pA(str, this.SGo, canvas);
        }
    }

    private void pA(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.bytedance.adsdk.Og.pA.pA.ZZv> pA(com.bytedance.adsdk.Og.KZx.ZZv zZv) {
        if (this.WV.containsKey(zZv)) {
            return this.WV.get(zZv);
        }
        List<oX> listPA = zZv.pA();
        int size = listPA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.bytedance.adsdk.Og.pA.pA.ZZv(this.oX, this, listPA.get(i), this.aBv));
        }
        this.WV.put(zZv, arrayList);
        return arrayList;
    }

    private String pA(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!KZx(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.Wx.indexOfKey(j) >= 0) {
            return this.Wx.get(j);
        }
        this.SD.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.SD.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.SD.toString();
        this.Wx.put(j, string);
        return string;
    }

    private boolean KZx(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    private static class pA {
        private float Og;
        private String pA;

        private pA() {
            this.pA = "";
            this.Og = 0.0f;
        }

        void pA(String str, float f) {
            this.pA = str;
            this.Og = f;
        }
    }
}
