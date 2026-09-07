package com.bytedance.adsdk.ugeno.ML;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
class ZZv {
    static final /* synthetic */ boolean KZx = true;
    private long[] JG;
    private boolean[] ML;
    long[] Og;
    private final com.bytedance.adsdk.ugeno.ML.pA ZZv;
    int[] pA;

    int Og(long j) {
        return (int) (j >> 32);
    }

    long Og(int i, int i2) {
        return (((long) i) & 4294967295L) | (((long) i2) << 32);
    }

    int pA(long j) {
        return (int) j;
    }

    ZZv(com.bytedance.adsdk.ugeno.ML.pA pAVar) {
        this.ZZv = pAVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    int[] pA(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.ZZv.getFlexItemCount();
        List<Og> listOg = Og(flexItemCount);
        Og og = new Og();
        if (view != null && (layoutParams instanceof com.bytedance.adsdk.ugeno.ML.Og)) {
            og.Og = ((com.bytedance.adsdk.ugeno.ML.Og) layoutParams).KZx();
        } else {
            og.Og = 1;
        }
        if (i != -1 && i != flexItemCount && i < this.ZZv.getFlexItemCount()) {
            og.pA = i;
            while (i < flexItemCount) {
                listOg.get(i).pA++;
                i++;
            }
        } else {
            og.pA = flexItemCount;
        }
        listOg.add(og);
        return pA(flexItemCount + 1, listOg, sparseIntArray);
    }

    int[] pA(SparseIntArray sparseIntArray) {
        int flexItemCount = this.ZZv.getFlexItemCount();
        return pA(flexItemCount, Og(flexItemCount), sparseIntArray);
    }

    private List<Og> Og(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            com.bytedance.adsdk.ugeno.ML.Og og = (com.bytedance.adsdk.ugeno.ML.Og) this.ZZv.pA(i2).getLayoutParams();
            Og og2 = new Og();
            og2.Og = og.KZx();
            og2.pA = i2;
            arrayList.add(og2);
        }
        return arrayList;
    }

    boolean Og(SparseIntArray sparseIntArray) {
        int flexItemCount = this.ZZv.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View viewPA = this.ZZv.pA(i);
            if (viewPA != null && ((com.bytedance.adsdk.ugeno.ML.Og) viewPA.getLayoutParams()).KZx() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    private int[] pA(int i, List<Og> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (Og og : list) {
            iArr[i2] = og.pA;
            sparseIntArray.append(og.pA, og.Og);
            i2++;
        }
        return iArr;
    }

    void pA(pA pAVar, int i, int i2) {
        pA(pAVar, i, i2, Integer.MAX_VALUE, 0, -1, (List<KZx>) null);
    }

    void Og(pA pAVar, int i, int i2) {
        pA(pAVar, i2, i, Integer.MAX_VALUE, 0, -1, (List<KZx>) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void pA(pA pAVar, int i, int i2, int i3, int i4, int i5, List<KZx> list) {
        int i6;
        int i7;
        List<KZx> list2;
        int i8;
        View view;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = i2;
        int i16 = i5;
        boolean zPA = this.ZZv.pA();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<KZx> arrayList = list == null ? new ArrayList() : list;
        pAVar.pA = arrayList;
        int i17 = i16 == -1 ? 1 : 0;
        int iPA = pA(zPA);
        int iOg = Og(zPA);
        int iKZx = KZx(zPA);
        int iZZv = ZZv(zPA);
        KZx kZx = new KZx();
        int i18 = i4;
        kZx.DX = i18;
        int i19 = iOg + iPA;
        kZx.ML = i19;
        int flexItemCount = this.ZZv.getFlexItemCount();
        int i20 = i17;
        int i21 = Integer.MIN_VALUE;
        int i22 = 0;
        int iCombineMeasuredStates = 0;
        int i23 = 0;
        while (i18 < flexItemCount) {
            View viewOg = this.ZZv.Og(i18);
            if (viewOg == null) {
                if (pA(i18, flexItemCount, kZx)) {
                    pA(arrayList, kZx, i18, i22);
                }
            } else {
                if (viewOg.getVisibility() == 8) {
                    kZx.Bzk++;
                    kZx.omh++;
                    if (pA(i18, flexItemCount, kZx)) {
                        pA(arrayList, kZx, i18, i22);
                    }
                } else {
                    if (viewOg instanceof CompoundButton) {
                        pA((CompoundButton) viewOg);
                    }
                    com.bytedance.adsdk.ugeno.ML.Og og = (com.bytedance.adsdk.ugeno.ML.Og) viewOg.getLayoutParams();
                    int i24 = flexItemCount;
                    if (og.JG() == 4) {
                        kZx.Sn.add(Integer.valueOf(i18));
                    }
                    int iPA2 = pA(og, zPA);
                    if (og.WV() != -1.0f && mode == 1073741824) {
                        iPA2 = Math.round(size * og.WV());
                    }
                    if (zPA) {
                        int iPA3 = this.ZZv.pA(i, i19 + KZx(og, true) + ZZv(og, true), iPA2);
                        int iOg2 = this.ZZv.Og(i15, iKZx + iZZv + ML(og, true) + JG(og, true) + i22, Og(og, true));
                        viewOg.measure(iPA3, iOg2);
                        pA(i18, iPA3, iOg2, viewOg);
                        i7 = iPA3;
                    } else {
                        int iPA4 = this.ZZv.pA(i15, iKZx + iZZv + ML(og, false) + JG(og, false) + i22, Og(og, false));
                        int iOg3 = this.ZZv.Og(i, KZx(og, false) + i19 + ZZv(og, false), iPA2);
                        viewOg.measure(iPA4, iOg3);
                        pA(i18, iPA4, iOg3, viewOg);
                        i7 = iOg3;
                    }
                    pA(viewOg, i18);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewOg.getMeasuredState());
                    int i25 = kZx.ML;
                    int i26 = i22;
                    int i27 = i19;
                    KZx kZx2 = kZx;
                    int i28 = size;
                    int i29 = i18;
                    list2 = arrayList;
                    int i30 = i7;
                    if (pA(viewOg, mode, i28, i25, ZZv(og, zPA) + pA(viewOg, zPA) + KZx(og, zPA), og, i29, i23, arrayList.size())) {
                        if (kZx2.Og() > 0) {
                            pA(list2, kZx2, i29 > 0 ? i29 - 1 : 0, i26);
                            i22 = kZx2.SD + i26;
                        } else {
                            i22 = i26;
                        }
                        if (zPA) {
                            if (og.Og() == -1) {
                                com.bytedance.adsdk.ugeno.ML.pA pAVar2 = this.ZZv;
                                i8 = i2;
                                i18 = i29;
                                view = viewOg;
                                view.measure(i30, pAVar2.Og(i8, pAVar2.getPaddingTop() + this.ZZv.getPaddingBottom() + og.Sn() + og.oX() + i22, og.Og()));
                                pA(view, i18);
                            } else {
                                i8 = i2;
                                view = viewOg;
                                i18 = i29;
                            }
                        } else {
                            i8 = i2;
                            view = viewOg;
                            i18 = i29;
                            if (og.pA() == -1) {
                                com.bytedance.adsdk.ugeno.ML.pA pAVar3 = this.ZZv;
                                view.measure(pAVar3.pA(i8, pAVar3.getPaddingLeft() + this.ZZv.getPaddingRight() + og.Wx() + og.DX() + i22, og.pA()), i30);
                                pA(view, i18);
                            }
                        }
                        kZx = new KZx();
                        i10 = 1;
                        kZx.omh = 1;
                        i9 = i27;
                        kZx.ML = i9;
                        kZx.DX = i18;
                        i12 = Integer.MIN_VALUE;
                        i11 = 0;
                    } else {
                        i8 = i2;
                        view = viewOg;
                        i18 = i29;
                        kZx = kZx2;
                        i9 = i27;
                        i10 = 1;
                        kZx.omh++;
                        i11 = i23 + 1;
                        i22 = i26;
                        i12 = i21;
                    }
                    kZx.aBv = (kZx.aBv ? 1 : 0) | (og.ZZv() != 0.0f ? i10 : 0);
                    kZx.XT = (kZx.XT ? 1 : 0) | (og.ML() != 0.0f ? i10 : 0);
                    int[] iArr = this.pA;
                    if (iArr != null) {
                        iArr[i18] = list2.size();
                    }
                    kZx.ML += pA(view, zPA) + KZx(og, zPA) + ZZv(og, zPA);
                    kZx.SGo += og.ZZv();
                    kZx.BSW += og.ML();
                    this.ZZv.pA(view, i18, i11, kZx);
                    int iMax = Math.max(i12, Og(view, zPA) + ML(og, zPA) + JG(og, zPA) + this.ZZv.pA(view));
                    kZx.SD = Math.max(kZx.SD, iMax);
                    if (zPA) {
                        if (this.ZZv.getFlexWrap() != 2) {
                            kZx.WV = Math.max(kZx.WV, view.getBaseline() + og.Sn());
                        } else {
                            kZx.WV = Math.max(kZx.WV, (view.getMeasuredHeight() - view.getBaseline()) + og.oX());
                        }
                    }
                    i13 = i24;
                    if (pA(i18, i13, kZx)) {
                        pA(list2, kZx, i18, i22);
                        i22 += kZx.SD;
                    }
                    i14 = i5;
                    if (i14 != -1 && list2.size() > 0 && list2.get(list2.size() - i10).oX >= i14 && i18 >= i14 && i20 == 0) {
                        i22 = -kZx.pA();
                        i20 = i10;
                    }
                    if (i22 > i3 && i20 != 0) {
                        i6 = iCombineMeasuredStates;
                        pAVar.Og = i6;
                    } else {
                        i23 = i11;
                        i21 = iMax;
                    }
                }
                i18++;
                flexItemCount = i13;
                i15 = i8;
                i19 = i9;
                arrayList = list2;
                size = size;
                i16 = i14;
                mode = mode;
            }
            size = size;
            mode = mode;
            i8 = i15;
            i14 = i16;
            list2 = arrayList;
            i9 = i19;
            i13 = flexItemCount;
            i18++;
            flexItemCount = i13;
            i15 = i8;
            i19 = i9;
            arrayList = list2;
            size = size;
            i16 = i14;
            mode = mode;
        }
        i6 = iCombineMeasuredStates;
        pAVar.Og = i6;
    }

    private void pA(CompoundButton compoundButton) {
        com.bytedance.adsdk.ugeno.ML.Og og = (com.bytedance.adsdk.ugeno.ML.Og) compoundButton.getLayoutParams();
        int iSD = og.SD();
        int iOmh = og.omh();
        Drawable drawablePA = com.bytedance.adsdk.ugeno.SD.ML.pA(compoundButton);
        int minimumWidth = drawablePA == null ? 0 : drawablePA.getMinimumWidth();
        int minimumHeight = drawablePA != null ? drawablePA.getMinimumHeight() : 0;
        if (iSD == -1) {
            iSD = minimumWidth;
        }
        og.pA(iSD);
        if (iOmh == -1) {
            iOmh = minimumHeight;
        }
        og.Og(iOmh);
    }

    private int pA(boolean z) {
        if (z) {
            return this.ZZv.getPaddingStart();
        }
        return this.ZZv.getPaddingTop();
    }

    private int Og(boolean z) {
        if (z) {
            return this.ZZv.getPaddingEnd();
        }
        return this.ZZv.getPaddingBottom();
    }

    private int KZx(boolean z) {
        if (z) {
            return this.ZZv.getPaddingTop();
        }
        return this.ZZv.getPaddingStart();
    }

    private int ZZv(boolean z) {
        if (z) {
            return this.ZZv.getPaddingBottom();
        }
        return this.ZZv.getPaddingEnd();
    }

    private int pA(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private int Og(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int pA(com.bytedance.adsdk.ugeno.ML.Og og, boolean z) {
        if (z) {
            return og.pA();
        }
        return og.Og();
    }

    private int Og(com.bytedance.adsdk.ugeno.ML.Og og, boolean z) {
        if (z) {
            return og.Og();
        }
        return og.pA();
    }

    private int KZx(com.bytedance.adsdk.ugeno.ML.Og og, boolean z) {
        if (z) {
            return og.Wx();
        }
        return og.Sn();
    }

    private int ZZv(com.bytedance.adsdk.ugeno.ML.Og og, boolean z) {
        if (z) {
            return og.DX();
        }
        return og.oX();
    }

    private int ML(com.bytedance.adsdk.ugeno.ML.Og og, boolean z) {
        if (z) {
            return og.Sn();
        }
        return og.Wx();
    }

    private int JG(com.bytedance.adsdk.ugeno.ML.Og og, boolean z) {
        if (z) {
            return og.oX();
        }
        return og.DX();
    }

    private boolean pA(View view, int i, int i2, int i3, int i4, com.bytedance.adsdk.ugeno.ML.Og og, int i5, int i6, int i7) {
        if (this.ZZv.getFlexWrap() == 0) {
            return false;
        }
        if (og.BSW()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.ZZv.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int iPA = this.ZZv.pA(view, i5, i6);
        if (iPA > 0) {
            i4 += iPA;
        }
        return i2 < i3 + i4;
    }

    private boolean pA(int i, int i2, KZx kZx) {
        return i == i2 - 1 && kZx.Og() != 0;
    }

    private void pA(List<KZx> list, KZx kZx, int i, int i2) {
        kZx.Wx = i2;
        this.ZZv.pA(kZx);
        kZx.oX = i;
        list.add(kZx);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    private void pA(View view, int i) {
        boolean z;
        com.bytedance.adsdk.ugeno.ML.Og og = (com.bytedance.adsdk.ugeno.ML.Og) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < og.SD()) {
            measuredWidth = og.SD();
        } else {
            if (measuredWidth > og.Bzk()) {
                measuredWidth = og.Bzk();
            } else {
                z = false;
            }
            if (measuredHeight < og.omh()) {
                measuredHeight = og.omh();
            } else if (measuredHeight > og.SGo()) {
                measuredHeight = og.SGo();
            } else {
                z2 = z;
            }
            if (z2) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                pA(i, iMakeMeasureSpec, iMakeMeasureSpec2, view);
            }
        }
        z = true;
        if (measuredHeight < og.omh()) {
            measuredHeight = og.omh();
        } else if (measuredHeight > og.SGo()) {
            measuredHeight = og.SGo();
        } else {
            z2 = z;
        }
        if (z2) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            view.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
            pA(i, iMakeMeasureSpec3, iMakeMeasureSpec4, view);
        }
    }

    void pA(int i, int i2) {
        pA(i, i2, 0);
    }

    void pA(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        KZx(this.ZZv.getFlexItemCount());
        if (i3 >= this.ZZv.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.ZZv.getFlexDirection();
        int flexDirection2 = this.ZZv.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.ZZv.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.ZZv.getPaddingLeft();
            paddingRight = this.ZZv.getPaddingRight();
        } else if (flexDirection2 == 2 || flexDirection2 == 3) {
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.ZZv.getLargestMainSize();
            }
            paddingLeft = this.ZZv.getPaddingTop();
            paddingRight = this.ZZv.getPaddingBottom();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        int i4 = paddingLeft + paddingRight;
        int[] iArr = this.pA;
        List<KZx> flexLinesInternal = this.ZZv.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i5 = iArr != null ? iArr[i3] : 0; i5 < size2; i5++) {
            KZx kZx = flexLinesInternal.get(i5);
            if (kZx.ML < size && kZx.aBv) {
                pA(i, i2, kZx, size, i4, false);
            } else if (kZx.ML > size && kZx.XT) {
                Og(i, i2, kZx, size, i4, false);
            }
        }
    }

    private void KZx(int i) {
        boolean[] zArr = this.ML;
        if (zArr == null) {
            this.ML = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.ML = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void pA(int i, int i2, KZx kZx, int i3, int i4, boolean z) {
        int i5;
        int iMax;
        double d;
        int i6;
        double d2;
        float f = 0.0f;
        if (kZx.SGo <= 0.0f || i3 < kZx.ML) {
            return;
        }
        int i7 = kZx.ML;
        float f2 = (i3 - kZx.ML) / kZx.SGo;
        kZx.ML = i4 + kZx.JG;
        if (!z) {
            kZx.SD = Integer.MIN_VALUE;
        }
        int i8 = 0;
        float f3 = 0.0f;
        boolean z2 = false;
        int i9 = 0;
        while (i8 < kZx.omh) {
            int i10 = kZx.DX + i8;
            View viewOg = this.ZZv.Og(i10);
            if (viewOg == null || viewOg.getVisibility() == 8) {
                i5 = i7;
            } else {
                com.bytedance.adsdk.ugeno.ML.Og og = (com.bytedance.adsdk.ugeno.ML.Og) viewOg.getLayoutParams();
                int flexDirection = this.ZZv.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i11 = i7;
                    int measuredWidth = viewOg.getMeasuredWidth();
                    long[] jArr = this.JG;
                    if (jArr != null) {
                        measuredWidth = pA(jArr[i10]);
                    }
                    int measuredHeight = viewOg.getMeasuredHeight();
                    long[] jArr2 = this.JG;
                    i5 = i11;
                    if (jArr2 != null) {
                        measuredHeight = Og(jArr2[i10]);
                    }
                    if (!this.ML[i10] && og.ZZv() > 0.0f) {
                        float fZZv = measuredWidth + (og.ZZv() * f2);
                        if (i8 == kZx.omh - 1) {
                            fZZv += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(fZZv);
                        if (iRound > og.Bzk()) {
                            iRound = og.Bzk();
                            this.ML[i10] = true;
                            kZx.SGo -= og.ZZv();
                            z2 = true;
                        } else {
                            f3 += fZZv - iRound;
                            double d3 = f3;
                            if (d3 > 1.0d) {
                                iRound++;
                                d = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                iRound--;
                                d = d3 + 1.0d;
                            }
                            f3 = (float) d;
                        }
                        int iOg = Og(i2, og, kZx.Wx);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewOg.measure(iMakeMeasureSpec, iOg);
                        int measuredWidth2 = viewOg.getMeasuredWidth();
                        int measuredHeight2 = viewOg.getMeasuredHeight();
                        pA(i10, iMakeMeasureSpec, iOg, viewOg);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i9, measuredHeight + og.Sn() + og.oX() + this.ZZv.pA(viewOg));
                    kZx.ML += measuredWidth + og.Wx() + og.DX();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewOg.getMeasuredHeight();
                    long[] jArr3 = this.JG;
                    if (jArr3 != null) {
                        measuredHeight3 = Og(jArr3[i10]);
                    }
                    int measuredWidth3 = viewOg.getMeasuredWidth();
                    long[] jArr4 = this.JG;
                    if (jArr4 != null) {
                        measuredWidth3 = pA(jArr4[i10]);
                    }
                    if (this.ML[i10] || og.ZZv() <= f) {
                        i6 = i7;
                    } else {
                        float fZZv2 = measuredHeight3 + (og.ZZv() * f2);
                        if (i8 == kZx.omh - 1) {
                            fZZv2 += f3;
                            f3 = f;
                        }
                        int iRound2 = Math.round(fZZv2);
                        if (iRound2 > og.SGo()) {
                            iRound2 = og.SGo();
                            this.ML[i10] = true;
                            kZx.SGo -= og.ZZv();
                            i6 = i7;
                            z2 = true;
                        } else {
                            f3 += fZZv2 - iRound2;
                            i6 = i7;
                            double d4 = f3;
                            if (d4 > 1.0d) {
                                iRound2++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound2--;
                                d2 = d4 + 1.0d;
                            }
                            f3 = (float) d2;
                        }
                        int iPA = pA(i, og, kZx.Wx);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewOg.measure(iPA, iMakeMeasureSpec2);
                        measuredWidth3 = viewOg.getMeasuredWidth();
                        int measuredHeight4 = viewOg.getMeasuredHeight();
                        pA(i10, iPA, iMakeMeasureSpec2, viewOg);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i9, measuredWidth3 + og.Wx() + og.DX() + this.ZZv.pA(viewOg));
                    kZx.ML += measuredHeight3 + og.Sn() + og.oX();
                    i5 = i6;
                }
                kZx.SD = Math.max(kZx.SD, iMax);
                i9 = iMax;
            }
            i8++;
            i7 = i5;
            f = 0.0f;
        }
        int i12 = i7;
        if (!z2 || i12 == kZx.ML) {
            return;
        }
        pA(i, i2, kZx, i3, i4, true);
    }

    private void Og(int i, int i2, KZx kZx, int i3, int i4, boolean z) {
        int i5;
        int iMax;
        int i6 = kZx.ML;
        float f = 0.0f;
        if (kZx.BSW <= 0.0f || i3 > kZx.ML) {
            return;
        }
        float f2 = (kZx.ML - i3) / kZx.BSW;
        kZx.ML = i4 + kZx.JG;
        if (!z) {
            kZx.SD = Integer.MIN_VALUE;
        }
        int i7 = 0;
        float f3 = 0.0f;
        boolean z2 = false;
        int i8 = 0;
        while (i7 < kZx.omh) {
            int i9 = kZx.DX + i7;
            View viewOg = this.ZZv.Og(i9);
            if (viewOg == null || viewOg.getVisibility() == 8) {
                i5 = i7;
            } else {
                com.bytedance.adsdk.ugeno.ML.Og og = (com.bytedance.adsdk.ugeno.ML.Og) viewOg.getLayoutParams();
                int flexDirection = this.ZZv.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i5 = i7;
                    int measuredWidth = viewOg.getMeasuredWidth();
                    long[] jArr = this.JG;
                    if (jArr != null) {
                        measuredWidth = pA(jArr[i9]);
                    }
                    int measuredHeight = viewOg.getMeasuredHeight();
                    long[] jArr2 = this.JG;
                    if (jArr2 != null) {
                        measuredHeight = Og(jArr2[i9]);
                    }
                    if (!this.ML[i9] && og.ML() > 0.0f) {
                        float fML = measuredWidth - (og.ML() * f2);
                        if (i5 == kZx.omh - 1) {
                            fML += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(fML);
                        if (iRound < og.SD()) {
                            iRound = og.SD();
                            this.ML[i9] = true;
                            kZx.BSW -= og.ML();
                            z2 = true;
                        } else {
                            f3 += fML - iRound;
                            double d = f3;
                            if (d > 1.0d) {
                                iRound++;
                                f3 -= 1.0f;
                            } else if (d < -1.0d) {
                                iRound--;
                                f3 += 1.0f;
                            }
                        }
                        int iOg = Og(i2, og, kZx.Wx);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewOg.measure(iMakeMeasureSpec, iOg);
                        int measuredWidth2 = viewOg.getMeasuredWidth();
                        int measuredHeight2 = viewOg.getMeasuredHeight();
                        pA(i9, iMakeMeasureSpec, iOg, viewOg);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i8, measuredHeight + og.Sn() + og.oX() + this.ZZv.pA(viewOg));
                    kZx.ML += measuredWidth + og.Wx() + og.DX();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewOg.getMeasuredHeight();
                    long[] jArr3 = this.JG;
                    if (jArr3 != null) {
                        measuredHeight3 = Og(jArr3[i9]);
                    }
                    int measuredWidth3 = viewOg.getMeasuredWidth();
                    long[] jArr4 = this.JG;
                    if (jArr4 != null) {
                        measuredWidth3 = pA(jArr4[i9]);
                    }
                    if (this.ML[i9] || og.ML() <= f) {
                        i5 = i7;
                    } else {
                        float fML2 = measuredHeight3 - (og.ML() * f2);
                        if (i7 == kZx.omh - 1) {
                            fML2 += f3;
                            f3 = f;
                        }
                        int iRound2 = Math.round(fML2);
                        if (iRound2 < og.omh()) {
                            iRound2 = og.omh();
                            this.ML[i9] = true;
                            kZx.BSW -= og.ML();
                            i5 = i7;
                            z2 = true;
                        } else {
                            f3 += fML2 - iRound2;
                            i5 = i7;
                            double d2 = f3;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f3 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f3 += 1.0f;
                            }
                        }
                        int iPA = pA(i, og, kZx.Wx);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewOg.measure(iPA, iMakeMeasureSpec2);
                        measuredWidth3 = viewOg.getMeasuredWidth();
                        int measuredHeight4 = viewOg.getMeasuredHeight();
                        pA(i9, iPA, iMakeMeasureSpec2, viewOg);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i8, measuredWidth3 + og.Wx() + og.DX() + this.ZZv.pA(viewOg));
                    kZx.ML += measuredHeight3 + og.Sn() + og.oX();
                }
                kZx.SD = Math.max(kZx.SD, iMax);
                i8 = iMax;
            }
            i7 = i5 + 1;
            f = 0.0f;
        }
        if (!z2 || i6 == kZx.ML) {
            return;
        }
        Og(i, i2, kZx, i3, i4, true);
    }

    private int pA(int i, com.bytedance.adsdk.ugeno.ML.Og og, int i2) {
        com.bytedance.adsdk.ugeno.ML.pA pAVar = this.ZZv;
        int iPA = pAVar.pA(i, pAVar.getPaddingLeft() + this.ZZv.getPaddingRight() + og.Wx() + og.DX() + i2, og.pA());
        int size = View.MeasureSpec.getSize(iPA);
        if (size > og.Bzk()) {
            return View.MeasureSpec.makeMeasureSpec(og.Bzk(), View.MeasureSpec.getMode(iPA));
        }
        return size < og.SD() ? View.MeasureSpec.makeMeasureSpec(og.SD(), View.MeasureSpec.getMode(iPA)) : iPA;
    }

    private int Og(int i, com.bytedance.adsdk.ugeno.ML.Og og, int i2) {
        com.bytedance.adsdk.ugeno.ML.pA pAVar = this.ZZv;
        int iOg = pAVar.Og(i, pAVar.getPaddingTop() + this.ZZv.getPaddingBottom() + og.Sn() + og.oX() + i2, og.Og());
        int size = View.MeasureSpec.getSize(iOg);
        if (size > og.SGo()) {
            return View.MeasureSpec.makeMeasureSpec(og.SGo(), View.MeasureSpec.getMode(iOg));
        }
        return size < og.omh() ? View.MeasureSpec.makeMeasureSpec(og.omh(), View.MeasureSpec.getMode(iOg)) : iOg;
    }

    void Og(int i, int i2, int i3) {
        int mode;
        int size;
        int flexDirection = this.ZZv.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            mode = mode2;
            size = size2;
        } else if (flexDirection == 2 || flexDirection == 3) {
            mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        List<KZx> flexLinesInternal = this.ZZv.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.ZZv.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).SD = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.ZZv.getAlignContent();
                if (alignContent == 1) {
                    int i5 = size - sumOfCrossSize;
                    KZx kZx = new KZx();
                    kZx.SD = i5;
                    flexLinesInternal.add(0, kZx);
                    return;
                }
                if (alignContent == 2) {
                    this.ZZv.setFlexLines(pA(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize < size) {
                        float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                        ArrayList arrayList = new ArrayList();
                        int size4 = flexLinesInternal.size();
                        float f = 0.0f;
                        while (i4 < size4) {
                            arrayList.add(flexLinesInternal.get(i4));
                            if (i4 != flexLinesInternal.size() - 1) {
                                KZx kZx2 = new KZx();
                                if (i4 == flexLinesInternal.size() - 2) {
                                    kZx2.SD = Math.round(f + size3);
                                    f = 0.0f;
                                } else {
                                    kZx2.SD = Math.round(size3);
                                }
                                f += size3 - kZx2.SD;
                                if (f > 1.0f) {
                                    kZx2.SD++;
                                    f -= 1.0f;
                                } else if (f < -1.0f) {
                                    kZx2.SD--;
                                    f += 1.0f;
                                }
                                arrayList.add(kZx2);
                            }
                            i4++;
                        }
                        this.ZZv.setFlexLines(arrayList);
                        return;
                    }
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.ZZv.setFlexLines(pA(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    KZx kZx3 = new KZx();
                    kZx3.SD = size5;
                    for (KZx kZx4 : flexLinesInternal) {
                        arrayList2.add(kZx3);
                        arrayList2.add(kZx4);
                        arrayList2.add(kZx3);
                    }
                    this.ZZv.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i4 < size7) {
                        KZx kZx5 = flexLinesInternal.get(i4);
                        float f3 = kZx5.SD + size6;
                        if (i4 == flexLinesInternal.size() - 1) {
                            f3 += f2;
                            f2 = 0.0f;
                        }
                        int iRound = Math.round(f3);
                        f2 += f3 - iRound;
                        if (f2 > 1.0f) {
                            iRound++;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            iRound--;
                            f2 += 1.0f;
                        }
                        kZx5.SD = iRound;
                        i4++;
                    }
                }
            }
        }
    }

    private List<KZx> pA(List<KZx> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        KZx kZx = new KZx();
        kZx.SD = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(kZx);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(kZx);
            }
        }
        return arrayList;
    }

    void pA() {
        pA(0);
    }

    void pA(int i) {
        View viewOg;
        if (i >= this.ZZv.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.ZZv.getFlexDirection();
        if (this.ZZv.getAlignItems() == 4) {
            int[] iArr = this.pA;
            List<KZx> flexLinesInternal = this.ZZv.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
                KZx kZx = flexLinesInternal.get(i2);
                int i3 = kZx.omh;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = kZx.DX + i4;
                    if (i4 < this.ZZv.getFlexItemCount() && (viewOg = this.ZZv.Og(i5)) != null && viewOg.getVisibility() != 8) {
                        com.bytedance.adsdk.ugeno.ML.Og og = (com.bytedance.adsdk.ugeno.ML.Og) viewOg.getLayoutParams();
                        if (og.JG() == -1 || og.JG() == 4) {
                            if (flexDirection == 0 || flexDirection == 1) {
                                pA(viewOg, kZx.SD, i5);
                            } else if (flexDirection == 2 || flexDirection == 3) {
                                Og(viewOg, kZx.SD, i5);
                            } else {
                                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                            }
                        }
                    }
                }
            }
            return;
        }
        for (KZx kZx2 : this.ZZv.getFlexLinesInternal()) {
            for (Integer num : kZx2.Sn) {
                View viewOg2 = this.ZZv.Og(num.intValue());
                if (flexDirection == 0 || flexDirection == 1) {
                    pA(viewOg2, kZx2.SD, num.intValue());
                } else if (flexDirection == 2 || flexDirection == 3) {
                    Og(viewOg2, kZx2.SD, num.intValue());
                } else {
                    throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                }
            }
        }
    }

    private void pA(View view, int i, int i2) {
        int measuredWidth;
        com.bytedance.adsdk.ugeno.ML.Og og = (com.bytedance.adsdk.ugeno.ML.Og) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - og.Sn()) - og.oX()) - this.ZZv.pA(view), og.omh()), og.SGo());
        long[] jArr = this.JG;
        if (jArr != null) {
            measuredWidth = pA(jArr[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        pA(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
    }

    private void Og(View view, int i, int i2) {
        int measuredHeight;
        com.bytedance.adsdk.ugeno.ML.Og og = (com.bytedance.adsdk.ugeno.ML.Og) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - og.Wx()) - og.DX()) - this.ZZv.pA(view), og.SD()), og.Bzk());
        long[] jArr = this.JG;
        if (jArr != null) {
            measuredHeight = Og(jArr[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        pA(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
    }

    void pA(View view, KZx kZx, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.ML.Og og = (com.bytedance.adsdk.ugeno.ML.Og) view.getLayoutParams();
        int alignItems = this.ZZv.getAlignItems();
        if (og.JG() != -1) {
            alignItems = og.JG();
        }
        int i5 = kZx.SD;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.ZZv.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - og.oX(), i3, i6 - og.oX());
                    return;
                } else {
                    view.layout(i, (i2 - i5) + view.getMeasuredHeight() + og.Sn(), i3, (i4 - i5) + view.getMeasuredHeight() + og.Sn());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + og.Sn()) - og.oX()) / 2;
                if (this.ZZv.getFlexWrap() != 2) {
                    int i7 = i2 + measuredHeight;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - measuredHeight;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.ZZv.getFlexWrap() != 2) {
                    int iMax = Math.max(kZx.WV - view.getBaseline(), og.Sn());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((kZx.WV - view.getMeasuredHeight()) + view.getBaseline(), og.oX());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.ZZv.getFlexWrap() != 2) {
            view.layout(i, i2 + og.Sn(), i3, i4 + og.Sn());
        } else {
            view.layout(i, i2 - og.oX(), i3, i4 - og.oX());
        }
    }

    void pA(View view, KZx kZx, boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.ML.Og og = (com.bytedance.adsdk.ugeno.ML.Og) view.getLayoutParams();
        int alignItems = this.ZZv.getAlignItems();
        if (og.JG() != -1) {
            alignItems = og.JG();
        }
        int i5 = kZx.SD;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - og.DX(), i2, ((i3 + i5) - view.getMeasuredWidth()) - og.DX(), i4);
                    return;
                } else {
                    view.layout((i - i5) + view.getMeasuredWidth() + og.Wx(), i2, (i3 - i5) + view.getMeasuredWidth() + og.Wx(), i4);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + com.bytedance.adsdk.ugeno.SD.JG.pA(marginLayoutParams)) - com.bytedance.adsdk.ugeno.SD.JG.Og(marginLayoutParams)) / 2;
                if (!z) {
                    view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                    return;
                } else {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z) {
            view.layout(i + og.Wx(), i2, i3 + og.Wx(), i4);
        } else {
            view.layout(i - og.DX(), i2, i3 - og.DX(), i4);
        }
    }

    private void pA(int i, int i2, int i3, View view) {
        long[] jArr = this.Og;
        if (jArr != null) {
            jArr[i] = Og(i2, i3);
        }
        long[] jArr2 = this.JG;
        if (jArr2 != null) {
            jArr2[i] = Og(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private static class Og implements Comparable<Og> {
        int Og;
        int pA;

        private Og() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public int compareTo(Og og) {
            int i = this.Og;
            int i2 = og.Og;
            return i != i2 ? i - i2 : this.pA - og.pA;
        }

        public String toString() {
            return "Order{order=" + this.Og + ", index=" + this.pA + AbstractJsonLexerKt.END_OBJ;
        }
    }

    static class pA {
        int Og;
        List<KZx> pA;

        pA() {
        }

        void pA() {
            this.pA = null;
            this.Og = 0;
        }
    }
}
