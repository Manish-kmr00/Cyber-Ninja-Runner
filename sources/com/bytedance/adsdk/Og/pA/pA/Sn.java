package com.bytedance.adsdk.Og.pA.pA;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class Sn implements com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA, BSW, Wx {
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, Float> BSW;
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, Float> Bzk;
    private boolean DX;
    private final boolean JG;
    private final com.bytedance.adsdk.Og.Bzk KZx;
    private final boolean ML;
    private final String Og;
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, Float> SD;
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, Float> SGo;
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, Float> WV;
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, Float> Wx;
    private final com.bytedance.adsdk.Og.KZx.Og.SGo.pA ZZv;
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, PointF> omh;
    private final Path pA = new Path();
    private final Og Sn = new Og();

    public Sn(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, com.bytedance.adsdk.Og.KZx.Og.SGo sGo) {
        this.KZx = bzk;
        this.Og = sGo.pA();
        com.bytedance.adsdk.Og.KZx.Og.SGo.pA pAVarOg = sGo.Og();
        this.ZZv = pAVarOg;
        this.ML = sGo.SGo();
        this.JG = sGo.BSW();
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA = sGo.KZx().pA();
        this.SD = pAVarPA;
        com.bytedance.adsdk.Og.pA.Og.pA<PointF, PointF> pAVarPA2 = sGo.ZZv().pA();
        this.omh = pAVarPA2;
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA3 = sGo.ML().pA();
        this.Bzk = pAVarPA3;
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA4 = sGo.SD().pA();
        this.BSW = pAVarPA4;
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA5 = sGo.Bzk().pA();
        this.Wx = pAVarPA5;
        if (pAVarOg == com.bytedance.adsdk.Og.KZx.Og.SGo.pA.STAR) {
            this.SGo = sGo.JG().pA();
            this.WV = sGo.omh().pA();
        } else {
            this.SGo = null;
            this.WV = null;
        }
        pAVar.pA(pAVarPA);
        pAVar.pA(pAVarPA2);
        pAVar.pA(pAVarPA3);
        pAVar.pA(pAVarPA4);
        pAVar.pA(pAVarPA5);
        if (pAVarOg == com.bytedance.adsdk.Og.KZx.Og.SGo.pA.STAR) {
            pAVar.pA(this.SGo);
            pAVar.pA(this.WV);
        }
        pAVarPA.pA(this);
        pAVarPA2.pA(this);
        pAVarPA3.pA(this);
        pAVarPA4.pA(this);
        pAVarPA5.pA(this);
        if (pAVarOg == com.bytedance.adsdk.Og.KZx.Og.SGo.pA.STAR) {
            this.SGo.pA(this);
            this.WV.pA(this);
        }
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA
    public void pA() {
        Og();
    }

    private void Og() {
        this.DX = false;
        this.KZx.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.KZx
    public void pA(List<KZx> list, List<KZx> list2) {
        for (int i = 0; i < list.size(); i++) {
            KZx kZx = list.get(i);
            if (kZx instanceof TX) {
                TX tx = (TX) kZx;
                if (tx.Og() == com.bytedance.adsdk.Og.KZx.Og.yFO.pA.SIMULTANEOUSLY) {
                    this.Sn.pA(tx);
                    tx.pA(this);
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.Wx
    public Path ZZv() {
        if (this.DX) {
            return this.pA;
        }
        this.pA.reset();
        if (this.ML) {
            this.DX = true;
            return this.pA;
        }
        int i = AnonymousClass1.pA[this.ZZv.ordinal()];
        if (i == 1) {
            KZx();
        } else if (i == 2) {
            ML();
        }
        this.pA.close();
        this.Sn.pA(this.pA);
        this.DX = true;
        return this.pA;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.Og.pA.pA.Sn$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] pA;

        static {
            int[] iArr = new int[com.bytedance.adsdk.Og.KZx.Og.SGo.pA.values().length];
            pA = iArr;
            try {
                iArr[com.bytedance.adsdk.Og.KZx.Og.SGo.pA.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                pA[com.bytedance.adsdk.Og.KZx.Og.SGo.pA.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void KZx() {
        float f;
        float f2;
        double d;
        float fSin;
        float f3;
        float f4;
        float f5;
        float fFloatValue = this.SD.SD().floatValue();
        com.bytedance.adsdk.Og.pA.Og.pA<?, Float> pAVar = this.Bzk;
        double radians = Math.toRadians((pAVar == null ? 0.0d : pAVar.SD().floatValue()) - 90.0d);
        double d2 = fFloatValue;
        float f6 = (float) (6.283185307179586d / d2);
        if (this.JG) {
            f6 *= -1.0f;
        }
        float f7 = f6 / 2.0f;
        float f8 = fFloatValue - ((int) fFloatValue);
        if (f8 != 0.0f) {
            radians += (double) ((1.0f - f8) * f7);
        }
        float fFloatValue2 = this.BSW.SD().floatValue();
        float fFloatValue3 = this.SGo.SD().floatValue();
        com.bytedance.adsdk.Og.pA.Og.pA<?, Float> pAVar2 = this.WV;
        float fFloatValue4 = pAVar2 != null ? pAVar2.SD().floatValue() / 100.0f : 0.0f;
        com.bytedance.adsdk.Og.pA.Og.pA<?, Float> pAVar3 = this.Wx;
        float fFloatValue5 = pAVar3 != null ? pAVar3.SD().floatValue() / 100.0f : 0.0f;
        if (f8 != 0.0f) {
            f3 = ((fFloatValue2 - fFloatValue3) * f8) + fFloatValue3;
            double d3 = f3;
            float fCos = (float) (d3 * Math.cos(radians));
            fSin = (float) (d3 * Math.sin(radians));
            this.pA.moveTo(fCos, fSin);
            d = radians + ((double) ((f6 * f8) / 2.0f));
            f = fCos;
            f2 = f7;
        } else {
            double d4 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d4);
            float fSin2 = (float) (d4 * Math.sin(radians));
            this.pA.moveTo(fCos2, fSin2);
            f = fCos2;
            f2 = f7;
            d = radians + ((double) f2);
            fSin = fSin2;
            f3 = 0.0f;
        }
        double dCeil = Math.ceil(d2) * 2.0d;
        int i = 0;
        float f9 = f2;
        float f10 = f;
        boolean z = false;
        while (true) {
            double d5 = i;
            if (d5 < dCeil) {
                float f11 = z ? fFloatValue2 : fFloatValue3;
                float f12 = (f3 == 0.0f || d5 != dCeil - 2.0d) ? f9 : (f6 * f8) / 2.0f;
                if (f3 == 0.0f || d5 != dCeil - 1.0d) {
                    f3 = f11;
                }
                double d6 = f3;
                double d7 = dCeil;
                float fCos3 = (float) (d6 * Math.cos(d));
                float fSin3 = (float) (d6 * Math.sin(d));
                if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                    this.pA.lineTo(fCos3, fSin3);
                    f4 = fFloatValue4;
                    f5 = fFloatValue5;
                } else {
                    f4 = fFloatValue4;
                    double dAtan2 = (float) (Math.atan2(fSin, f10) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin4 = (float) Math.sin(dAtan2);
                    f5 = fFloatValue5;
                    double dAtan3 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan3);
                    float fSin5 = (float) Math.sin(dAtan3);
                    float f13 = z ? f4 : f5;
                    float f14 = z ? f5 : f4;
                    float f15 = (z ? fFloatValue3 : fFloatValue2) * f13 * 0.47829f;
                    float f16 = fCos4 * f15;
                    float f17 = f15 * fSin4;
                    float f18 = (z ? fFloatValue2 : fFloatValue3) * f14 * 0.47829f;
                    float f19 = fCos5 * f18;
                    float f20 = f18 * fSin5;
                    if (f8 != 0.0f) {
                        if (i == 0) {
                            f16 *= f8;
                            f17 *= f8;
                        } else if (d5 == d7 - 1.0d) {
                            f19 *= f8;
                            f20 *= f8;
                        }
                    }
                    this.pA.cubicTo(f10 - f16, fSin - f17, fCos3 + f19, fSin3 + f20, fCos3, fSin3);
                }
                d += (double) f12;
                z = !z;
                i++;
                f10 = fCos3;
                fSin = fSin3;
                fFloatValue5 = f5;
                fFloatValue4 = f4;
                f3 = f3;
                f6 = f6;
                dCeil = d7;
            } else {
                PointF pointFSD = this.omh.SD();
                this.pA.offset(pointFSD.x, pointFSD.y);
                this.pA.close();
                return;
            }
        }
    }

    private void ML() {
        int iFloor = (int) Math.floor(this.SD.SD().floatValue());
        com.bytedance.adsdk.Og.pA.Og.pA<?, Float> pAVar = this.Bzk;
        double radians = Math.toRadians((pAVar == null ? 0.0d : pAVar.SD().floatValue()) - 90.0d);
        double d = iFloor;
        float fFloatValue = this.Wx.SD().floatValue() / 100.0f;
        float fFloatValue2 = this.BSW.SD().floatValue();
        double d2 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d2);
        float fSin = (float) (Math.sin(radians) * d2);
        this.pA.moveTo(fCos, fSin);
        double d3 = (float) (6.283185307179586d / d);
        double d4 = radians + d3;
        double dCeil = Math.ceil(d);
        int i = 0;
        while (i < dCeil) {
            float fCos2 = (float) (Math.cos(d4) * d2);
            double d5 = dCeil;
            float fSin2 = (float) (d2 * Math.sin(d4));
            if (fFloatValue != 0.0f) {
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan3 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f = fFloatValue2 * fFloatValue * 0.25f;
                this.pA.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (((float) Math.cos(dAtan3)) * f), fSin2 + (f * ((float) Math.sin(dAtan3))), fCos2, fSin2);
            } else {
                this.pA.lineTo(fCos2, fSin2);
            }
            d4 += d3;
            i++;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d5;
            d2 = d2;
            d3 = d3;
        }
        PointF pointFSD = this.omh.SD();
        this.pA.offset(pointFSD.x, pointFSD.y);
        this.pA.close();
    }
}
