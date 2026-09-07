package com.bytedance.adsdk.ugeno.ML;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.SD.SD;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class ML extends ViewGroup implements com.bytedance.adsdk.ugeno.ML.pA {
    private int BSW;
    private int Bzk;
    private ZZv DX;
    private int JG;
    private int KZx;
    private int ML;
    private int Og;
    private Drawable SD;
    private int SGo;
    private SparseIntArray Sn;
    private int WV;
    private int[] Wx;
    private ZZv.pA XT;
    private int ZZv;
    private com.bytedance.adsdk.ugeno.KZx aBv;
    private List<KZx> oX;
    private Drawable omh;
    private int pA;

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public int pA(View view) {
        return 0;
    }

    public ML(Context context) {
        super(context, null);
        this.JG = -1;
        this.DX = new ZZv(this);
        this.oX = new ArrayList();
        this.XT = new ZZv.pA();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.KZx kZx = this.aBv;
        if (kZx != null) {
            int[] iArrPA = kZx.pA(i, i2);
            pA(iArrPA[0], iArrPA[1]);
        } else {
            pA(i, i2);
        }
        com.bytedance.adsdk.ugeno.KZx kZx2 = this.aBv;
        if (kZx2 != null) {
            kZx2.ML();
        }
    }

    private void pA(int i, int i2) {
        if (this.Sn == null) {
            this.Sn = new SparseIntArray(getChildCount());
        }
        if (this.DX.Og(this.Sn)) {
            this.Wx = this.DX.pA(this.Sn);
        }
        int i3 = this.pA;
        if (i3 == 0 || i3 == 1) {
            Og(i, i2);
        } else {
            if (i3 == 2 || i3 == 3) {
                KZx(i, i2);
                return;
            }
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.pA);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public View pA(int i) {
        return getChildAt(i);
    }

    public View KZx(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.Wx;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public View Og(int i) {
        return KZx(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.Sn == null) {
            this.Sn = new SparseIntArray(getChildCount());
        }
        this.Wx = this.DX.pA(view, i, layoutParams, this.Sn);
        super.addView(view, i, layoutParams);
    }

    private void Og(int i, int i2) {
        this.oX.clear();
        this.XT.pA();
        this.DX.pA(this.XT, i, i2);
        this.oX = this.XT.pA;
        this.DX.pA(i, i2);
        if (this.ZZv == 3) {
            for (KZx kZx : this.oX) {
                int iMax = Integer.MIN_VALUE;
                for (int i3 = 0; i3 < kZx.omh; i3++) {
                    View viewKZx = KZx(kZx.DX + i3);
                    if (viewKZx != null && viewKZx.getVisibility() != 8) {
                        pA pAVar = (pA) viewKZx.getLayoutParams();
                        if (this.Og != 2) {
                            iMax = Math.max(iMax, viewKZx.getMeasuredHeight() + Math.max(kZx.WV - viewKZx.getBaseline(), pAVar.topMargin) + pAVar.bottomMargin);
                        } else {
                            iMax = Math.max(iMax, viewKZx.getMeasuredHeight() + pAVar.topMargin + Math.max((kZx.WV - viewKZx.getMeasuredHeight()) + viewKZx.getBaseline(), pAVar.bottomMargin));
                        }
                    }
                }
                kZx.SD = iMax;
            }
        }
        this.DX.Og(i, i2, getPaddingTop() + getPaddingBottom());
        this.DX.pA();
        pA(this.pA, i, i2, this.XT.Og);
    }

    private void KZx(int i, int i2) {
        this.oX.clear();
        this.XT.pA();
        this.DX.Og(this.XT, i, i2);
        this.oX = this.XT.pA;
        this.DX.pA(i, i2);
        this.DX.Og(i, i2, getPaddingLeft() + getPaddingRight());
        this.DX.pA();
        pA(this.pA, i, i2, this.XT.Og);
    }

    private void pA(int i, int i2, int i3, int i4) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else if (i == 2 || i == 3) {
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i2, i4);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else {
            throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i3, i4);
        } else if (mode2 == 1073741824) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else {
            throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public int getLargestMainSize() {
        Iterator<KZx> it = this.oX.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().ML);
        }
        return iMax;
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public int getSumOfCrossSize() {
        int i;
        int i2;
        int size = this.oX.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            KZx kZx = this.oX.get(i4);
            if (ZZv(i4)) {
                if (pA()) {
                    i2 = this.BSW;
                } else {
                    i2 = this.WV;
                }
                i3 += i2;
            }
            if (JG(i4)) {
                if (pA()) {
                    i = this.BSW;
                } else {
                    i = this.WV;
                }
                i3 += i;
            }
            i3 += kZx.SD;
        }
        return i3;
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public boolean pA() {
        int i = this.pA;
        return i == 0 || i == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        com.bytedance.adsdk.ugeno.KZx kZx = this.aBv;
        if (kZx != null) {
            kZx.JG();
        }
        int iPA = SD.pA(this);
        int i5 = this.pA;
        if (i5 == 0) {
            pA(iPA == 1, i, i2, i3, i4);
        } else if (i5 == 1) {
            pA(iPA != 1, i, i2, i3, i4);
        } else if (i5 == 2) {
            z2 = iPA == 1;
            pA(this.Og == 2 ? !z2 : z2, false, i, i2, i3, i4);
        } else if (i5 == 3) {
            z2 = iPA == 1;
            pA(this.Og == 2 ? !z2 : z2, true, i, i2, i3, i4);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.pA);
        }
        com.bytedance.adsdk.ugeno.KZx kZx2 = this.aBv;
        if (kZx2 != null) {
            kZx2.pA(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:44:0x00de  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:49:0x0105  */
    /* JADX WARN: Code duplicated, block: B:52:0x010e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0116  */
    /* JADX WARN: Code duplicated, block: B:55:0x011b  */
    /* JADX WARN: Code duplicated, block: B:59:0x0124 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x0126  */
    /* JADX WARN: Code duplicated, block: B:61:0x0157  */
    /* JADX WARN: Code duplicated, block: B:62:0x0181  */
    /* JADX WARN: Code duplicated, block: B:64:0x018e  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:68:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:69:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:71:0x0200  */
    /* JADX WARN: Code duplicated, block: B:72:0x020b  */
    private void pA(boolean z, int i, int i2, int i3, int i4) {
        float measuredWidth;
        int i5;
        float f;
        float f2;
        float fMax;
        int i6;
        int i7;
        View viewKZx;
        int i8;
        int i9;
        int i10;
        char c;
        pA pAVar;
        float f3;
        float f4;
        float f5;
        int i11;
        char c2;
        int i12;
        pA pAVar2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i13 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.oX.size();
        int i14 = 0;
        while (i14 < size) {
            KZx kZx = this.oX.get(i14);
            if (ZZv(i14)) {
                int i15 = this.BSW;
                paddingBottom -= i15;
                paddingTop += i15;
            }
            int i16 = this.KZx;
            char c3 = 4;
            int i17 = 1;
            if (i16 != 0) {
                if (i16 == 1) {
                    measuredWidth = (i13 - kZx.ML) + paddingRight;
                    i5 = kZx.ML - paddingLeft;
                } else if (i16 == 2) {
                    measuredWidth = paddingLeft + ((i13 - kZx.ML) / 2.0f);
                    f = (i13 - paddingRight) - ((i13 - kZx.ML) / 2.0f);
                    f2 = 0.0f;
                } else if (i16 == 3) {
                    measuredWidth = paddingLeft;
                    int iOg = kZx.Og();
                    f2 = (i13 - kZx.ML) / (iOg != 1 ? iOg - 1 : 1.0f);
                    f = i13 - paddingRight;
                } else if (i16 == 4) {
                    int iOg2 = kZx.Og();
                    f2 = iOg2 != 0 ? (i13 - kZx.ML) / iOg2 : 0.0f;
                    float f6 = f2 / 2.0f;
                    measuredWidth = paddingLeft + f6;
                    f = (i13 - paddingRight) - f6;
                } else if (i16 == 5) {
                    int iOg3 = kZx.Og();
                    f2 = iOg3 != 0 ? (i13 - kZx.ML) / (iOg3 + 1) : 0.0f;
                    measuredWidth = paddingLeft + f2;
                    f = (i13 - paddingRight) - f2;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.KZx);
                }
                fMax = Math.max(f2, 0.0f);
                i6 = 0;
                while (i6 < kZx.omh) {
                    i7 = kZx.DX + i6;
                    viewKZx = KZx(i7);
                    if (viewKZx != null) {
                        i8 = paddingLeft;
                        i9 = i17;
                        i10 = i6;
                        c = c3;
                    } else if (viewKZx.getVisibility() != 8) {
                        pAVar = (pA) viewKZx.getLayoutParams();
                        f3 = measuredWidth + pAVar.leftMargin;
                        f4 = f - pAVar.rightMargin;
                        if (ZZv(i7, i6)) {
                            int i18 = this.WV;
                            float f7 = i18;
                            f3 += f7;
                            i11 = i18;
                            f5 = f4 - f7;
                        } else {
                            f5 = f4;
                            i11 = 0;
                        }
                        if (i6 == kZx.omh - i17) {
                            c2 = 4;
                            i12 = (this.SGo & 4) > 0 ? this.WV : 0;
                            if (this.Og == 2) {
                                i8 = paddingLeft;
                                i9 = i17;
                                i10 = i6;
                                pAVar2 = pAVar;
                                c = c2;
                                if (z) {
                                    this.DX.pA(viewKZx, kZx, Math.round(f5) - viewKZx.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewKZx.getMeasuredHeight());
                                } else {
                                    this.DX.pA(viewKZx, kZx, Math.round(f3), paddingTop, Math.round(f3) + viewKZx.getMeasuredWidth(), paddingTop + viewKZx.getMeasuredHeight());
                                }
                            } else if (z) {
                                i9 = i17;
                                i10 = i6;
                                i8 = paddingLeft;
                                pAVar2 = pAVar;
                                c = c2;
                                this.DX.pA(viewKZx, kZx, Math.round(f5) - viewKZx.getMeasuredWidth(), paddingBottom - viewKZx.getMeasuredHeight(), Math.round(f5), paddingBottom);
                            } else {
                                i8 = paddingLeft;
                                i9 = i17;
                                i10 = i6;
                                pAVar2 = pAVar;
                                c = c2;
                                this.DX.pA(viewKZx, kZx, Math.round(f3), paddingBottom - viewKZx.getMeasuredHeight(), Math.round(f3) + viewKZx.getMeasuredWidth(), paddingBottom);
                            }
                            measuredWidth = f3 + viewKZx.getMeasuredWidth() + fMax + pAVar2.rightMargin;
                            float measuredWidth2 = f5 - ((viewKZx.getMeasuredWidth() + fMax) + pAVar2.leftMargin);
                            if (z) {
                                kZx.pA(viewKZx, i12, 0, i11, 0);
                            } else {
                                kZx.pA(viewKZx, i11, 0, i12, 0);
                            }
                            f = measuredWidth2;
                        } else {
                            c2 = 4;
                        }
                        if (this.Og == 2) {
                            i8 = paddingLeft;
                            i9 = i17;
                            i10 = i6;
                            pAVar2 = pAVar;
                            c = c2;
                            if (z) {
                                this.DX.pA(viewKZx, kZx, Math.round(f5) - viewKZx.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewKZx.getMeasuredHeight());
                            } else {
                                this.DX.pA(viewKZx, kZx, Math.round(f3), paddingTop, Math.round(f3) + viewKZx.getMeasuredWidth(), paddingTop + viewKZx.getMeasuredHeight());
                            }
                        } else if (z) {
                            i9 = i17;
                            i10 = i6;
                            i8 = paddingLeft;
                            pAVar2 = pAVar;
                            c = c2;
                            this.DX.pA(viewKZx, kZx, Math.round(f5) - viewKZx.getMeasuredWidth(), paddingBottom - viewKZx.getMeasuredHeight(), Math.round(f5), paddingBottom);
                        } else {
                            i8 = paddingLeft;
                            i9 = i17;
                            i10 = i6;
                            pAVar2 = pAVar;
                            c = c2;
                            this.DX.pA(viewKZx, kZx, Math.round(f3), paddingBottom - viewKZx.getMeasuredHeight(), Math.round(f3) + viewKZx.getMeasuredWidth(), paddingBottom);
                        }
                        measuredWidth = f3 + viewKZx.getMeasuredWidth() + fMax + pAVar2.rightMargin;
                        float measuredWidth3 = f5 - ((viewKZx.getMeasuredWidth() + fMax) + pAVar2.leftMargin);
                        if (z) {
                            kZx.pA(viewKZx, i12, 0, i11, 0);
                        } else {
                            kZx.pA(viewKZx, i11, 0, i12, 0);
                        }
                        f = measuredWidth3;
                    } else {
                        i8 = paddingLeft;
                        i9 = i17;
                        i10 = i6;
                        c = 4;
                    }
                    i6 = i10 + 1;
                    paddingLeft = i8;
                    i17 = i9;
                    c3 = c;
                }
                paddingTop += kZx.SD;
                paddingBottom -= kZx.SD;
                i14++;
                paddingLeft = paddingLeft;
            } else {
                measuredWidth = paddingLeft;
                i5 = i13 - paddingRight;
            }
            f = i5;
            f2 = 0.0f;
            fMax = Math.max(f2, 0.0f);
            i6 = 0;
            while (i6 < kZx.omh) {
                i7 = kZx.DX + i6;
                viewKZx = KZx(i7);
                if (viewKZx != null) {
                    i8 = paddingLeft;
                    i9 = i17;
                    i10 = i6;
                    c = c3;
                } else if (viewKZx.getVisibility() != 8) {
                    pAVar = (pA) viewKZx.getLayoutParams();
                    f3 = measuredWidth + pAVar.leftMargin;
                    f4 = f - pAVar.rightMargin;
                    if (ZZv(i7, i6)) {
                        int i19 = this.WV;
                        float f8 = i19;
                        f3 += f8;
                        i11 = i19;
                        f5 = f4 - f8;
                    } else {
                        f5 = f4;
                        i11 = 0;
                    }
                    if (i6 == kZx.omh - i17) {
                        c2 = 4;
                        if ((this.SGo & 4) > 0) {
                        }
                        if (this.Og == 2) {
                            i8 = paddingLeft;
                            i9 = i17;
                            i10 = i6;
                            pAVar2 = pAVar;
                            c = c2;
                            if (z) {
                                this.DX.pA(viewKZx, kZx, Math.round(f5) - viewKZx.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewKZx.getMeasuredHeight());
                            } else {
                                this.DX.pA(viewKZx, kZx, Math.round(f3), paddingTop, Math.round(f3) + viewKZx.getMeasuredWidth(), paddingTop + viewKZx.getMeasuredHeight());
                            }
                        } else if (z) {
                            i9 = i17;
                            i10 = i6;
                            i8 = paddingLeft;
                            pAVar2 = pAVar;
                            c = c2;
                            this.DX.pA(viewKZx, kZx, Math.round(f5) - viewKZx.getMeasuredWidth(), paddingBottom - viewKZx.getMeasuredHeight(), Math.round(f5), paddingBottom);
                        } else {
                            i8 = paddingLeft;
                            i9 = i17;
                            i10 = i6;
                            pAVar2 = pAVar;
                            c = c2;
                            this.DX.pA(viewKZx, kZx, Math.round(f3), paddingBottom - viewKZx.getMeasuredHeight(), Math.round(f3) + viewKZx.getMeasuredWidth(), paddingBottom);
                        }
                        measuredWidth = f3 + viewKZx.getMeasuredWidth() + fMax + pAVar2.rightMargin;
                        float measuredWidth4 = f5 - ((viewKZx.getMeasuredWidth() + fMax) + pAVar2.leftMargin);
                        if (z) {
                            kZx.pA(viewKZx, i12, 0, i11, 0);
                        } else {
                            kZx.pA(viewKZx, i11, 0, i12, 0);
                        }
                        f = measuredWidth4;
                    } else {
                        c2 = 4;
                    }
                    if (this.Og == 2) {
                        i8 = paddingLeft;
                        i9 = i17;
                        i10 = i6;
                        pAVar2 = pAVar;
                        c = c2;
                        if (z) {
                            this.DX.pA(viewKZx, kZx, Math.round(f5) - viewKZx.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewKZx.getMeasuredHeight());
                        } else {
                            this.DX.pA(viewKZx, kZx, Math.round(f3), paddingTop, Math.round(f3) + viewKZx.getMeasuredWidth(), paddingTop + viewKZx.getMeasuredHeight());
                        }
                    } else if (z) {
                        i9 = i17;
                        i10 = i6;
                        i8 = paddingLeft;
                        pAVar2 = pAVar;
                        c = c2;
                        this.DX.pA(viewKZx, kZx, Math.round(f5) - viewKZx.getMeasuredWidth(), paddingBottom - viewKZx.getMeasuredHeight(), Math.round(f5), paddingBottom);
                    } else {
                        i8 = paddingLeft;
                        i9 = i17;
                        i10 = i6;
                        pAVar2 = pAVar;
                        c = c2;
                        this.DX.pA(viewKZx, kZx, Math.round(f3), paddingBottom - viewKZx.getMeasuredHeight(), Math.round(f3) + viewKZx.getMeasuredWidth(), paddingBottom);
                    }
                    measuredWidth = f3 + viewKZx.getMeasuredWidth() + fMax + pAVar2.rightMargin;
                    float measuredWidth5 = f5 - ((viewKZx.getMeasuredWidth() + fMax) + pAVar2.leftMargin);
                    if (z) {
                        kZx.pA(viewKZx, i12, 0, i11, 0);
                    } else {
                        kZx.pA(viewKZx, i11, 0, i12, 0);
                    }
                    f = measuredWidth5;
                } else {
                    i8 = paddingLeft;
                    i9 = i17;
                    i10 = i6;
                    c = 4;
                }
                i6 = i10 + 1;
                paddingLeft = i8;
                i17 = i9;
                c3 = c;
            }
            paddingTop += kZx.SD;
            paddingBottom -= kZx.SD;
            i14++;
            paddingLeft = paddingLeft;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:49:0x0105  */
    /* JADX WARN: Code duplicated, block: B:52:0x0111  */
    /* JADX WARN: Code duplicated, block: B:54:0x0119  */
    /* JADX WARN: Code duplicated, block: B:55:0x011e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0124 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0126  */
    /* JADX WARN: Code duplicated, block: B:60:0x0155  */
    /* JADX WARN: Code duplicated, block: B:61:0x017d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0187  */
    /* JADX WARN: Code duplicated, block: B:64:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:67:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:68:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:70:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:71:0x0205  */
    private void pA(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        float f2;
        float f3;
        float fMax;
        int i6;
        int i7;
        View viewKZx;
        int i8;
        boolean z3;
        char c;
        pA pAVar;
        float f4;
        float f5;
        float f6;
        float f7;
        int i9;
        char c2;
        int i10;
        pA pAVar2;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i11 = i4 - i2;
        int i12 = (i3 - i) - paddingRight;
        int size = this.oX.size();
        for (int i13 = 0; i13 < size; i13++) {
            KZx kZx = this.oX.get(i13);
            if (ZZv(i13)) {
                int i14 = this.WV;
                paddingLeft += i14;
                i12 -= i14;
            }
            int i15 = this.KZx;
            char c3 = 4;
            boolean z4 = true;
            if (i15 != 0) {
                if (i15 == 1) {
                    f = (i11 - kZx.ML) + paddingBottom;
                    i5 = kZx.ML - paddingTop;
                } else if (i15 == 2) {
                    f = ((i11 - kZx.ML) / 2.0f) + paddingTop;
                    f2 = (i11 - paddingBottom) - ((i11 - kZx.ML) / 2.0f);
                    f3 = 0.0f;
                } else if (i15 == 3) {
                    f = paddingTop;
                    int iOg = kZx.Og();
                    f3 = (i11 - kZx.ML) / (iOg != 1 ? iOg - 1 : 1.0f);
                    f2 = i11 - paddingBottom;
                } else if (i15 == 4) {
                    int iOg2 = kZx.Og();
                    f3 = iOg2 != 0 ? (i11 - kZx.ML) / iOg2 : 0.0f;
                    float f8 = f3 / 2.0f;
                    f = paddingTop + f8;
                    f2 = (i11 - paddingBottom) - f8;
                } else if (i15 == 5) {
                    int iOg3 = kZx.Og();
                    f3 = iOg3 != 0 ? (i11 - kZx.ML) / (iOg3 + 1) : 0.0f;
                    f = paddingTop + f3;
                    f2 = (i11 - paddingBottom) - f3;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.KZx);
                }
                fMax = Math.max(f3, 0.0f);
                i6 = 0;
                while (i6 < kZx.omh) {
                    i7 = kZx.DX + i6;
                    viewKZx = KZx(i7);
                    if (viewKZx != null) {
                        i8 = i6;
                        z3 = z4;
                        c = c3;
                    } else if (viewKZx.getVisibility() != 8) {
                        pAVar = (pA) viewKZx.getLayoutParams();
                        f4 = f + pAVar.topMargin;
                        f5 = f2 - pAVar.bottomMargin;
                        if (ZZv(i7, i6)) {
                            int i16 = this.BSW;
                            float f9 = i16;
                            f6 = f4 + f9;
                            i9 = i16;
                            f7 = f5 - f9;
                        } else {
                            f6 = f4;
                            f7 = f5;
                            i9 = 0;
                        }
                        if (i6 == kZx.omh - 1) {
                            c2 = 4;
                            i10 = (this.Bzk & 4) > 0 ? this.BSW : 0;
                            if (z) {
                                i8 = i6;
                                z3 = true;
                                pAVar2 = pAVar;
                                c = c2;
                                if (z2) {
                                    this.DX.pA(viewKZx, kZx, false, paddingLeft, Math.round(f7) - viewKZx.getMeasuredHeight(), paddingLeft + viewKZx.getMeasuredWidth(), Math.round(f7));
                                } else {
                                    this.DX.pA(viewKZx, kZx, false, paddingLeft, Math.round(f6), paddingLeft + viewKZx.getMeasuredWidth(), Math.round(f6) + viewKZx.getMeasuredHeight());
                                }
                            } else if (z2) {
                                i8 = i6;
                                z3 = true;
                                pAVar2 = pAVar;
                                c = c2;
                                this.DX.pA(viewKZx, kZx, true, i12 - viewKZx.getMeasuredWidth(), Math.round(f7) - viewKZx.getMeasuredHeight(), i12, Math.round(f7));
                            } else {
                                i8 = i6;
                                z3 = true;
                                pAVar2 = pAVar;
                                c = c2;
                                this.DX.pA(viewKZx, kZx, true, i12 - viewKZx.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewKZx.getMeasuredHeight());
                            }
                            pA pAVar3 = pAVar2;
                            float measuredHeight = f6 + viewKZx.getMeasuredHeight() + fMax + pAVar3.bottomMargin;
                            float measuredHeight2 = f7 - ((viewKZx.getMeasuredHeight() + fMax) + pAVar3.topMargin);
                            if (z2) {
                                kZx.pA(viewKZx, 0, i10, 0, i9);
                            } else {
                                kZx.pA(viewKZx, 0, i9, 0, i10);
                            }
                            f = measuredHeight;
                            f2 = measuredHeight2;
                        } else {
                            c2 = 4;
                        }
                        if (z) {
                            i8 = i6;
                            z3 = true;
                            pAVar2 = pAVar;
                            c = c2;
                            if (z2) {
                                this.DX.pA(viewKZx, kZx, false, paddingLeft, Math.round(f7) - viewKZx.getMeasuredHeight(), paddingLeft + viewKZx.getMeasuredWidth(), Math.round(f7));
                            } else {
                                this.DX.pA(viewKZx, kZx, false, paddingLeft, Math.round(f6), paddingLeft + viewKZx.getMeasuredWidth(), Math.round(f6) + viewKZx.getMeasuredHeight());
                            }
                        } else if (z2) {
                            i8 = i6;
                            z3 = true;
                            pAVar2 = pAVar;
                            c = c2;
                            this.DX.pA(viewKZx, kZx, true, i12 - viewKZx.getMeasuredWidth(), Math.round(f7) - viewKZx.getMeasuredHeight(), i12, Math.round(f7));
                        } else {
                            i8 = i6;
                            z3 = true;
                            pAVar2 = pAVar;
                            c = c2;
                            this.DX.pA(viewKZx, kZx, true, i12 - viewKZx.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewKZx.getMeasuredHeight());
                        }
                        pA pAVar4 = pAVar2;
                        float measuredHeight3 = f6 + viewKZx.getMeasuredHeight() + fMax + pAVar4.bottomMargin;
                        float measuredHeight4 = f7 - ((viewKZx.getMeasuredHeight() + fMax) + pAVar4.topMargin);
                        if (z2) {
                            kZx.pA(viewKZx, 0, i10, 0, i9);
                        } else {
                            kZx.pA(viewKZx, 0, i9, 0, i10);
                        }
                        f = measuredHeight3;
                        f2 = measuredHeight4;
                    } else {
                        i8 = i6;
                        z3 = true;
                        c = 4;
                    }
                    i6 = i8 + 1;
                    z4 = z3;
                    c3 = c;
                }
                paddingLeft += kZx.SD;
                i12 -= kZx.SD;
            } else {
                f = paddingTop;
                i5 = i11 - paddingBottom;
            }
            f2 = i5;
            f3 = 0.0f;
            fMax = Math.max(f3, 0.0f);
            i6 = 0;
            while (i6 < kZx.omh) {
                i7 = kZx.DX + i6;
                viewKZx = KZx(i7);
                if (viewKZx != null) {
                    i8 = i6;
                    z3 = z4;
                    c = c3;
                } else if (viewKZx.getVisibility() != 8) {
                    pAVar = (pA) viewKZx.getLayoutParams();
                    f4 = f + pAVar.topMargin;
                    f5 = f2 - pAVar.bottomMargin;
                    if (ZZv(i7, i6)) {
                        int i17 = this.BSW;
                        float f10 = i17;
                        f6 = f4 + f10;
                        i9 = i17;
                        f7 = f5 - f10;
                    } else {
                        f6 = f4;
                        f7 = f5;
                        i9 = 0;
                    }
                    if (i6 == kZx.omh - 1) {
                        c2 = 4;
                        if ((this.Bzk & 4) > 0) {
                        }
                        if (z) {
                            i8 = i6;
                            z3 = true;
                            pAVar2 = pAVar;
                            c = c2;
                            if (z2) {
                                this.DX.pA(viewKZx, kZx, false, paddingLeft, Math.round(f7) - viewKZx.getMeasuredHeight(), paddingLeft + viewKZx.getMeasuredWidth(), Math.round(f7));
                            } else {
                                this.DX.pA(viewKZx, kZx, false, paddingLeft, Math.round(f6), paddingLeft + viewKZx.getMeasuredWidth(), Math.round(f6) + viewKZx.getMeasuredHeight());
                            }
                        } else if (z2) {
                            i8 = i6;
                            z3 = true;
                            pAVar2 = pAVar;
                            c = c2;
                            this.DX.pA(viewKZx, kZx, true, i12 - viewKZx.getMeasuredWidth(), Math.round(f7) - viewKZx.getMeasuredHeight(), i12, Math.round(f7));
                        } else {
                            i8 = i6;
                            z3 = true;
                            pAVar2 = pAVar;
                            c = c2;
                            this.DX.pA(viewKZx, kZx, true, i12 - viewKZx.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewKZx.getMeasuredHeight());
                        }
                        pA pAVar5 = pAVar2;
                        float measuredHeight5 = f6 + viewKZx.getMeasuredHeight() + fMax + pAVar5.bottomMargin;
                        float measuredHeight6 = f7 - ((viewKZx.getMeasuredHeight() + fMax) + pAVar5.topMargin);
                        if (z2) {
                            kZx.pA(viewKZx, 0, i10, 0, i9);
                        } else {
                            kZx.pA(viewKZx, 0, i9, 0, i10);
                        }
                        f = measuredHeight5;
                        f2 = measuredHeight6;
                    } else {
                        c2 = 4;
                    }
                    if (z) {
                        i8 = i6;
                        z3 = true;
                        pAVar2 = pAVar;
                        c = c2;
                        if (z2) {
                            this.DX.pA(viewKZx, kZx, false, paddingLeft, Math.round(f7) - viewKZx.getMeasuredHeight(), paddingLeft + viewKZx.getMeasuredWidth(), Math.round(f7));
                        } else {
                            this.DX.pA(viewKZx, kZx, false, paddingLeft, Math.round(f6), paddingLeft + viewKZx.getMeasuredWidth(), Math.round(f6) + viewKZx.getMeasuredHeight());
                        }
                    } else if (z2) {
                        i8 = i6;
                        z3 = true;
                        pAVar2 = pAVar;
                        c = c2;
                        this.DX.pA(viewKZx, kZx, true, i12 - viewKZx.getMeasuredWidth(), Math.round(f7) - viewKZx.getMeasuredHeight(), i12, Math.round(f7));
                    } else {
                        i8 = i6;
                        z3 = true;
                        pAVar2 = pAVar;
                        c = c2;
                        this.DX.pA(viewKZx, kZx, true, i12 - viewKZx.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewKZx.getMeasuredHeight());
                    }
                    pA pAVar6 = pAVar2;
                    float measuredHeight7 = f6 + viewKZx.getMeasuredHeight() + fMax + pAVar6.bottomMargin;
                    float measuredHeight8 = f7 - ((viewKZx.getMeasuredHeight() + fMax) + pAVar6.topMargin);
                    if (z2) {
                        kZx.pA(viewKZx, 0, i10, 0, i9);
                    } else {
                        kZx.pA(viewKZx, 0, i9, 0, i10);
                    }
                    f = measuredHeight7;
                    f2 = measuredHeight8;
                } else {
                    i8 = i6;
                    z3 = true;
                    c = 4;
                }
                i6 = i8 + 1;
                z4 = z3;
                c3 = c;
            }
            paddingLeft += kZx.SD;
            i12 -= kZx.SD;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.omh == null && this.SD == null) {
            return;
        }
        if (this.Bzk == 0 && this.SGo == 0) {
            return;
        }
        int iPA = SD.pA(this);
        int i = this.pA;
        if (i == 0) {
            pA(canvas, iPA == 1, this.Og == 2);
            return;
        }
        if (i == 1) {
            pA(canvas, iPA != 1, this.Og == 2);
            return;
        }
        if (i == 2) {
            boolean z = iPA == 1;
            if (this.Og == 2) {
                z = !z;
            }
            Og(canvas, z, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z2 = iPA == 1;
        if (this.Og == 2) {
            z2 = !z2;
        }
        Og(canvas, z2, true);
    }

    private void pA(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.oX.size();
        for (int i3 = 0; i3 < size; i3++) {
            KZx kZx = this.oX.get(i3);
            for (int i4 = 0; i4 < kZx.omh; i4++) {
                int i5 = kZx.DX + i4;
                View viewKZx = KZx(i5);
                if (viewKZx != null && viewKZx.getVisibility() != 8) {
                    pA pAVar = (pA) viewKZx.getLayoutParams();
                    if (ZZv(i5, i4)) {
                        if (z) {
                            left = viewKZx.getRight() + pAVar.rightMargin;
                        } else {
                            left = (viewKZx.getLeft() - pAVar.leftMargin) - this.WV;
                        }
                        pA(canvas, left, kZx.Og, kZx.SD);
                    }
                    if (i4 == kZx.omh - 1 && (this.SGo & 4) > 0) {
                        if (z) {
                            right = (viewKZx.getLeft() - pAVar.leftMargin) - this.WV;
                        } else {
                            right = viewKZx.getRight() + pAVar.rightMargin;
                        }
                        pA(canvas, right, kZx.Og, kZx.SD);
                    }
                }
            }
            if (ZZv(i3)) {
                if (z2) {
                    i2 = kZx.ZZv;
                } else {
                    i2 = kZx.Og - this.BSW;
                }
                Og(canvas, paddingLeft, i2, iMax);
            }
            if (JG(i3) && (this.Bzk & 4) > 0) {
                if (z2) {
                    i = kZx.Og - this.BSW;
                } else {
                    i = kZx.ZZv;
                }
                Og(canvas, paddingLeft, i, iMax);
            }
        }
    }

    private void Og(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.oX.size();
        for (int i3 = 0; i3 < size; i3++) {
            KZx kZx = this.oX.get(i3);
            for (int i4 = 0; i4 < kZx.omh; i4++) {
                int i5 = kZx.DX + i4;
                View viewKZx = KZx(i5);
                if (viewKZx != null && viewKZx.getVisibility() != 8) {
                    pA pAVar = (pA) viewKZx.getLayoutParams();
                    if (ZZv(i5, i4)) {
                        if (z2) {
                            top = viewKZx.getBottom() + pAVar.bottomMargin;
                        } else {
                            top = (viewKZx.getTop() - pAVar.topMargin) - this.BSW;
                        }
                        Og(canvas, kZx.pA, top, kZx.SD);
                    }
                    if (i4 == kZx.omh - 1 && (this.Bzk & 4) > 0) {
                        if (z2) {
                            bottom = (viewKZx.getTop() - pAVar.topMargin) - this.BSW;
                        } else {
                            bottom = viewKZx.getBottom() + pAVar.bottomMargin;
                        }
                        Og(canvas, kZx.pA, bottom, kZx.SD);
                    }
                }
            }
            if (ZZv(i3)) {
                if (z) {
                    i2 = kZx.KZx;
                } else {
                    i2 = kZx.pA - this.WV;
                }
                pA(canvas, i2, paddingTop, iMax);
            }
            if (JG(i3) && (this.SGo & 4) > 0) {
                if (z) {
                    i = kZx.pA - this.WV;
                } else {
                    i = kZx.KZx;
                }
                pA(canvas, i, paddingTop, iMax);
            }
        }
    }

    private void pA(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.omh;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.WV + i, i3 + i2);
        this.omh.draw(canvas);
    }

    private void Og(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.SD;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.BSW + i2);
        this.SD.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof pA;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof pA) {
            return new pA((pA) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new pA((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new pA(layoutParams);
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public int getFlexDirection() {
        return this.pA;
    }

    public void setFlexDirection(int i) {
        if (this.pA != i) {
            this.pA = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public int getFlexWrap() {
        return this.Og;
    }

    public void setFlexWrap(int i) {
        if (this.Og != i) {
            this.Og = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.KZx;
    }

    public void setJustifyContent(int i) {
        if (this.KZx != i) {
            this.KZx = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public int getAlignItems() {
        return this.ZZv;
    }

    public void setAlignItems(int i) {
        if (this.ZZv != i) {
            this.ZZv = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public int getAlignContent() {
        return this.ML;
    }

    public void setAlignContent(int i) {
        if (this.ML != i) {
            this.ML = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public int getMaxLine() {
        return this.JG;
    }

    public void setMaxLine(int i) {
        if (this.JG != i) {
            this.JG = i;
            requestLayout();
        }
    }

    public List<KZx> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.oX.size());
        for (KZx kZx : this.oX) {
            if (kZx.Og() != 0) {
                arrayList.add(kZx);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public int pA(View view, int i, int i2) {
        int i3;
        int i4;
        if (pA()) {
            i3 = ZZv(i, i2) ? this.WV : 0;
            if ((this.SGo & 4) <= 0) {
                return i3;
            }
            i4 = this.WV;
        } else {
            i3 = ZZv(i, i2) ? this.BSW : 0;
            if ((this.Bzk & 4) <= 0) {
                return i3;
            }
            i4 = this.BSW;
        }
        return i3 + i4;
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public void pA(KZx kZx) {
        if (pA()) {
            if ((this.SGo & 4) > 0) {
                kZx.ML += this.WV;
                kZx.JG += this.WV;
                return;
            }
            return;
        }
        if ((this.Bzk & 4) > 0) {
            kZx.ML += this.BSW;
            kZx.JG += this.BSW;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public int pA(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public int Og(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public void pA(View view, int i, int i2, KZx kZx) {
        if (ZZv(i, i2)) {
            if (pA()) {
                kZx.ML += this.WV;
                kZx.JG += this.WV;
            } else {
                kZx.ML += this.BSW;
                kZx.JG += this.BSW;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public void setFlexLines(List<KZx> list) {
        this.oX = list;
    }

    @Override // com.bytedance.adsdk.ugeno.ML.pA
    public List<KZx> getFlexLinesInternal() {
        return this.oX;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.SD;
    }

    public Drawable getDividerDrawableVertical() {
        return this.omh;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.SD) {
            return;
        }
        this.SD = drawable;
        if (drawable != null) {
            this.BSW = drawable.getIntrinsicHeight();
        } else {
            this.BSW = 0;
        }
        Og();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.omh) {
            return;
        }
        this.omh = drawable;
        if (drawable != null) {
            this.WV = drawable.getIntrinsicWidth();
        } else {
            this.WV = 0;
        }
        Og();
        requestLayout();
    }

    public int getShowDividerVertical() {
        return this.SGo;
    }

    public int getShowDividerHorizontal() {
        return this.Bzk;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.SGo) {
            this.SGo = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.Bzk) {
            this.Bzk = i;
            requestLayout();
        }
    }

    private void Og() {
        if (this.SD == null && this.omh == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean ZZv(int i, int i2) {
        if (ML(i, i2)) {
            if (pA()) {
                return (this.SGo & 1) != 0;
            }
            return (this.Bzk & 1) != 0;
        }
        if (pA()) {
            return (this.SGo & 2) != 0;
        }
        return (this.Bzk & 2) != 0;
    }

    private boolean ML(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View viewKZx = KZx(i - i3);
            if (viewKZx != null && viewKZx.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean ZZv(int i) {
        if (i >= 0 && i < this.oX.size()) {
            if (ML(i)) {
                if (pA()) {
                    return (this.Bzk & 1) != 0;
                }
                return (this.SGo & 1) != 0;
            }
            if (pA()) {
                return (this.Bzk & 2) != 0;
            }
            if ((this.SGo & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean ML(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.oX.get(i2).Og() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean JG(int i) {
        if (i >= 0 && i < this.oX.size()) {
            for (int i2 = i + 1; i2 < this.oX.size(); i2++) {
                if (this.oX.get(i2).Og() > 0) {
                    return false;
                }
            }
            if (pA()) {
                return (this.Bzk & 4) != 0;
            }
            if ((this.SGo & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    public static class pA extends ViewGroup.MarginLayoutParams implements Og {
        public static final Parcelable.Creator<pA> CREATOR = new Parcelable.Creator<pA>() { // from class: com.bytedance.adsdk.ugeno.ML.ML.pA.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public pA createFromParcel(Parcel parcel) {
                return new pA(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public pA[] newArray(int i) {
                return new pA[i];
            }
        };
        private int Bzk;
        private int JG;
        private float KZx;
        private float ML;
        private float Og;
        private int SD;
        private boolean SGo;
        private int ZZv;
        private int omh;
        private int pA;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public pA(pA pAVar) {
            super((ViewGroup.MarginLayoutParams) pAVar);
            this.pA = 1;
            this.Og = 0.0f;
            this.KZx = 0.0f;
            this.ZZv = -1;
            this.ML = -1.0f;
            this.JG = -1;
            this.SD = -1;
            this.omh = ViewCompat.MEASURED_SIZE_MASK;
            this.Bzk = ViewCompat.MEASURED_SIZE_MASK;
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
        }

        public pA(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.pA = 1;
            this.Og = 0.0f;
            this.KZx = 0.0f;
            this.ZZv = -1;
            this.ML = -1.0f;
            this.JG = -1;
            this.SD = -1;
            this.omh = ViewCompat.MEASURED_SIZE_MASK;
            this.Bzk = ViewCompat.MEASURED_SIZE_MASK;
        }

        public pA(int i, int i2) {
            super(new ViewGroup.LayoutParams(i, i2));
            this.pA = 1;
            this.Og = 0.0f;
            this.KZx = 0.0f;
            this.ZZv = -1;
            this.ML = -1.0f;
            this.JG = -1;
            this.SD = -1;
            this.omh = ViewCompat.MEASURED_SIZE_MASK;
            this.Bzk = ViewCompat.MEASURED_SIZE_MASK;
        }

        public pA(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.pA = 1;
            this.Og = 0.0f;
            this.KZx = 0.0f;
            this.ZZv = -1;
            this.ML = -1.0f;
            this.JG = -1;
            this.SD = -1;
            this.omh = ViewCompat.MEASURED_SIZE_MASK;
            this.Bzk = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public int pA() {
            return this.width;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public int Og() {
            return this.height;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public int KZx() {
            return this.pA;
        }

        public void KZx(int i) {
            this.pA = i;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public float ZZv() {
            return this.Og;
        }

        public void pA(float f) {
            this.Og = f;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public float ML() {
            return this.KZx;
        }

        public void Og(float f) {
            this.KZx = f;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public int JG() {
            return this.ZZv;
        }

        public void ZZv(int i) {
            this.ZZv = i;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public int SD() {
            return this.JG;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public void pA(int i) {
            this.JG = i;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public int omh() {
            return this.SD;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public void Og(int i) {
            this.SD = i;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public int Bzk() {
            return this.omh;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public int SGo() {
            return this.Bzk;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public boolean BSW() {
            return this.SGo;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public float WV() {
            return this.ML;
        }

        public void KZx(float f) {
            this.ML = f;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public int Wx() {
            return this.leftMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public int Sn() {
            return this.topMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public int DX() {
            return this.rightMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.ML.Og
        public int oX() {
            return this.bottomMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.pA);
            parcel.writeFloat(this.Og);
            parcel.writeFloat(this.KZx);
            parcel.writeInt(this.ZZv);
            parcel.writeFloat(this.ML);
            parcel.writeInt(this.JG);
            parcel.writeInt(this.SD);
            parcel.writeInt(this.omh);
            parcel.writeInt(this.Bzk);
            parcel.writeByte(this.SGo ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        protected pA(Parcel parcel) {
            super(0, 0);
            this.pA = 1;
            this.Og = 0.0f;
            this.KZx = 0.0f;
            this.ZZv = -1;
            this.ML = -1.0f;
            this.JG = -1;
            this.SD = -1;
            this.omh = ViewCompat.MEASURED_SIZE_MASK;
            this.Bzk = ViewCompat.MEASURED_SIZE_MASK;
            this.pA = parcel.readInt();
            this.Og = parcel.readFloat();
            this.KZx = parcel.readFloat();
            this.ZZv = parcel.readInt();
            this.ML = parcel.readFloat();
            this.JG = parcel.readInt();
            this.SD = parcel.readInt();
            this.omh = parcel.readInt();
            this.Bzk = parcel.readInt();
            this.SGo = parcel.readByte() != 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }

    public void pA(com.bytedance.adsdk.ugeno.Og.KZx kZx) {
        this.aBv = kZx;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.KZx kZx = this.aBv;
        if (kZx != null) {
            kZx.SD();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.KZx kZx = this.aBv;
        if (kZx != null) {
            kZx.omh();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.KZx kZx = this.aBv;
        if (kZx != null) {
            kZx.Og(i, i2, i3, i4);
        }
    }
}
