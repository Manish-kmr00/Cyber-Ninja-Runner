package io.bidmachine.iab.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class IabElementStyle implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f12238a;
    private Integer b;
    private Boolean c;
    private Boolean d;
    private Integer e;
    private Integer f;
    private String g;
    private Float h;
    private Float i;
    private Integer j;
    private Integer k;
    private Integer l;
    private Integer m;
    private Integer n;
    private Integer o;
    private Integer p;
    private Integer q;
    private String r;
    private Float s;
    private Float t;
    private Float u;
    private Integer v;
    private Float w;

    public IabElementStyle() {
    }

    public void applyAlignment(FrameLayout.LayoutParams layoutParams) {
        layoutParams.gravity = positionAsGravity();
    }

    public void applyMargin(Context context, ViewGroup.MarginLayoutParams layoutParams) {
        layoutParams.leftMargin = getMarginLeft(context).intValue();
        layoutParams.topMargin = getMarginTop(context).intValue();
        layoutParams.rightMargin = getMarginRight(context).intValue();
        layoutParams.bottomMargin = getMarginBottom(context).intValue();
    }

    public void applyPadding(Context context, View view) {
        view.setPadding(getPaddingLeft(context).intValue(), getPaddingTop(context).intValue(), getPaddingRight(context).intValue(), getPaddingBottom(context).intValue());
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        if (r0 != 17) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void applyRelativeAlignment(android.widget.RelativeLayout.LayoutParams r4) {
        /*
            r3 = this;
            java.lang.Integer r0 = r3.getHorizontalPosition()
            int r0 = r0.intValue()
            r1 = 1
            r2 = 17
            if (r0 == r1) goto L1c
            r1 = 3
            if (r0 == r1) goto L19
            r1 = 5
            if (r0 == r1) goto L16
            if (r0 == r2) goto L1c
            goto L21
        L16:
            r0 = 11
            goto L1e
        L19:
            r0 = 9
            goto L1e
        L1c:
            r0 = 14
        L1e:
            r4.addRule(r0)
        L21:
            java.lang.Integer r0 = r3.getVerticalPosition()
            int r0 = r0.intValue()
            r1 = 16
            if (r0 == r1) goto L3e
            if (r0 == r2) goto L3e
            r1 = 48
            if (r0 == r1) goto L3b
            r1 = 80
            if (r0 == r1) goto L38
            goto L43
        L38:
            r0 = 12
            goto L40
        L3b:
            r0 = 10
            goto L40
        L3e:
            r0 = 15
        L40:
            r4.addRule(r0)
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.bidmachine.iab.utils.IabElementStyle.applyRelativeAlignment(android.widget.RelativeLayout$LayoutParams):void");
    }

    public IabElementStyle copyWith(IabElementStyle copyFrom) {
        IabElementStyle iabElementStyle = new IabElementStyle();
        iabElementStyle.merge(this);
        iabElementStyle.merge(copyFrom);
        return iabElementStyle;
    }

    public String getContent() {
        return this.r;
    }

    public Integer getFillColor() {
        Integer num = this.b;
        return num != null ? num : Integer.valueOf(Assets.BACKGROUND_COLOR);
    }

    public Float getFontSize(Context context) {
        Float f = this.w;
        return Float.valueOf(Utils.dpToPx(context, f != null ? f.floatValue() : 16.0f));
    }

    public Integer getFontStyle() {
        Integer num = this.v;
        if (num != null) {
            return num;
        }
        return 0;
    }

    public Integer getHeight(Context context) {
        int iIntValue;
        Float f = this.u;
        if (f != null) {
            iIntValue = (f.floatValue() == -1.0f || this.u.floatValue() == -2.0f) ? this.u.intValue() : Utils.dpToPx(context, this.u.floatValue());
        } else {
            iIntValue = -2;
        }
        return Integer.valueOf(iIntValue);
    }

    public Float getHideAfter() {
        return this.i;
    }

    public Integer getHorizontalPosition() {
        Integer num = this.e;
        if (num != null) {
            return num;
        }
        return 3;
    }

    public Integer getMarginBottom(Context context) {
        Integer num = this.q;
        return Integer.valueOf(num != null ? Utils.dpToPx(context, num.intValue()) : 0);
    }

    public Integer getMarginLeft(Context context) {
        Integer num = this.n;
        return Integer.valueOf(num != null ? Utils.dpToPx(context, num.intValue()) : 0);
    }

    public Integer getMarginRight(Context context) {
        Integer num = this.p;
        return Integer.valueOf(num != null ? Utils.dpToPx(context, num.intValue()) : 0);
    }

    public Integer getMarginTop(Context context) {
        Integer num = this.o;
        return Integer.valueOf(num != null ? Utils.dpToPx(context, num.intValue()) : 0);
    }

    public Float getOpacity() {
        Float f = this.h;
        return f != null ? f : Float.valueOf(1.0f);
    }

    public Integer getPaddingBottom(Context context) {
        Integer num = this.m;
        return Integer.valueOf(num != null ? Utils.dpToPx(context, num.intValue()) : 0);
    }

    public Integer getPaddingLeft(Context context) {
        Integer num = this.j;
        return Integer.valueOf(num != null ? Utils.dpToPx(context, num.intValue()) : 0);
    }

    public Integer getPaddingRight(Context context) {
        Integer num = this.k;
        return Integer.valueOf(num != null ? Utils.dpToPx(context, num.intValue()) : 0);
    }

    public Integer getPaddingTop(Context context) {
        Integer num = this.l;
        return Integer.valueOf(num != null ? Utils.dpToPx(context, num.intValue()) : 0);
    }

    public Integer getStrokeColor() {
        Integer num = this.f12238a;
        return num != null ? num : Integer.valueOf(Assets.MAIN_ASSETS_COLOR);
    }

    public Float getStrokeWidth(Context context) {
        Float f = this.s;
        return Float.valueOf(f != null ? Utils.dpToPx(context, f.floatValue()) : 0.0f);
    }

    public String getStyle() {
        return this.g;
    }

    public Integer getVerticalPosition() {
        Integer num = this.f;
        if (num != null) {
            return num;
        }
        return 48;
    }

    public Integer getWidth(Context context) {
        int iIntValue;
        Float f = this.t;
        if (f != null) {
            iIntValue = (f.floatValue() == -1.0f || this.t.floatValue() == -2.0f) ? this.t.intValue() : Utils.dpToPx(context, this.t.floatValue());
        } else {
            iIntValue = -2;
        }
        return Integer.valueOf(iIntValue);
    }

    public boolean hasFillColor() {
        return this.b != null;
    }

    public boolean hasStrokeColor() {
        return this.f12238a != null;
    }

    public Boolean isOutlined() {
        Boolean bool = this.c;
        return bool != null ? bool : Boolean.FALSE;
    }

    public Boolean isVisible() {
        Boolean bool = this.d;
        return bool != null ? bool : Boolean.TRUE;
    }

    public void merge(IabElementStyle style) {
        if (style == null) {
            return;
        }
        Integer num = style.f12238a;
        if (num != null) {
            this.f12238a = num;
        }
        Integer num2 = style.b;
        if (num2 != null) {
            this.b = num2;
        }
        Boolean bool = style.c;
        if (bool != null) {
            this.c = bool;
        }
        Boolean bool2 = style.d;
        if (bool2 != null) {
            this.d = bool2;
        }
        Integer num3 = style.e;
        if (num3 != null) {
            this.e = num3;
        }
        Integer num4 = style.f;
        if (num4 != null) {
            this.f = num4;
        }
        String str = style.g;
        if (str != null) {
            this.g = str;
        }
        Float f = style.h;
        if (f != null) {
            this.h = f;
        }
        Float f2 = style.i;
        if (f2 != null) {
            this.i = f2;
        }
        Integer num5 = style.j;
        if (num5 != null) {
            this.j = num5;
        }
        Integer num6 = style.k;
        if (num6 != null) {
            this.k = num6;
        }
        Integer num7 = style.l;
        if (num7 != null) {
            this.l = num7;
        }
        Integer num8 = style.m;
        if (num8 != null) {
            this.m = num8;
        }
        Integer num9 = style.n;
        if (num9 != null) {
            this.n = num9;
        }
        Integer num10 = style.p;
        if (num10 != null) {
            this.p = num10;
        }
        Integer num11 = style.o;
        if (num11 != null) {
            this.o = num11;
        }
        Integer num12 = style.q;
        if (num12 != null) {
            this.q = num12;
        }
        String str2 = style.r;
        if (str2 != null) {
            this.r = str2;
        }
        Float f3 = style.s;
        if (f3 != null) {
            this.s = f3;
        }
        Float f4 = style.t;
        if (f4 != null) {
            this.t = f4;
        }
        Float f5 = style.u;
        if (f5 != null) {
            this.u = f5;
        }
        Integer num13 = style.v;
        if (num13 != null) {
            this.v = num13;
        }
        Float f6 = style.w;
        if (f6 != null) {
            this.w = f6;
        }
    }

    public int positionAsGravity() {
        return getVerticalPosition().intValue() | getHorizontalPosition().intValue();
    }

    public void setContent(String content) {
        this.r = content;
    }

    public void setFillColor(Integer fillColor) {
        this.b = fillColor;
    }

    public void setFontSize(Float fontSize) {
        this.w = fontSize;
    }

    public void setFontStyle(Integer fontStyle) {
        this.v = fontStyle;
    }

    public void setHeight(Number height) {
        this.u = height != null ? Float.valueOf(height.floatValue()) : null;
    }

    public void setHideAfter(Float hideAfter) {
        this.i = hideAfter;
    }

    public void setHorizontalPosition(Integer horizontalPosition) {
        this.e = horizontalPosition;
    }

    public void setMargin(Integer left, Integer top, Integer right, Integer bottom) {
        this.n = left;
        this.o = top;
        this.p = right;
        this.q = bottom;
    }

    public void setMarginBottom(Integer margin) {
        this.q = margin;
    }

    public void setMarginLeft(Integer margin) {
        this.n = margin;
    }

    public void setMarginRight(Integer margin) {
        this.p = margin;
    }

    public void setMarginTop(Integer margin) {
        this.o = margin;
    }

    public void setOpacity(Float opacity) {
        this.h = opacity;
    }

    public void setOutlined(Boolean outlined) {
        this.c = outlined;
    }

    public void setPadding(Integer left, Integer top, Integer right, Integer bottom) {
        this.j = left;
        this.l = top;
        this.k = right;
        this.m = bottom;
    }

    public void setPaddingBottom(Integer padding) {
        this.m = padding;
    }

    public void setPaddingLeft(Integer padding) {
        this.j = padding;
    }

    public void setPaddingRight(Integer padding) {
        this.k = padding;
    }

    public void setPaddingTop(Integer padding) {
        this.l = padding;
    }

    public void setStrokeColor(Integer strokeColor) {
        this.f12238a = strokeColor;
    }

    public void setStrokeWidth(Float strokeWidth) {
        this.s = strokeWidth;
    }

    public void setStyle(String style) {
        this.g = style;
    }

    public void setVerticalPosition(Integer verticalPosition) {
        this.f = verticalPosition;
    }

    public void setVisible(Boolean visible) {
        this.d = visible;
    }

    public void setWidth(Number width) {
        this.t = width != null ? Float.valueOf(width.floatValue()) : null;
    }

    public IabElementStyle(IabElementStyle copyFrom) {
        merge(copyFrom);
    }

    public void setMargin(String value) {
        if (TextUtils.isEmpty(value)) {
            setMargin(null, null, null, null);
            return;
        }
        String[] strArrSplit = value.split(" ");
        if (strArrSplit.length == 1) {
            int iIntValue = Utils.convertCssSizeToPx(strArrSplit[0]).intValue();
            setMargin(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue));
            return;
        }
        if (strArrSplit.length == 2) {
            int iIntValue2 = Utils.convertCssSizeToPx(strArrSplit[0]).intValue();
            int iIntValue3 = Utils.convertCssSizeToPx(strArrSplit[1]).intValue();
            setMargin(Integer.valueOf(iIntValue3), Integer.valueOf(iIntValue2), Integer.valueOf(iIntValue3), Integer.valueOf(iIntValue2));
        } else {
            if (strArrSplit.length == 3) {
                int iIntValue4 = Utils.convertCssSizeToPx(strArrSplit[0]).intValue();
                int iIntValue5 = Utils.convertCssSizeToPx(strArrSplit[1]).intValue();
                setMargin(Integer.valueOf(iIntValue5), Integer.valueOf(iIntValue4), Integer.valueOf(iIntValue5), Integer.valueOf(Utils.convertCssSizeToPx(strArrSplit[2]).intValue()));
                return;
            }
            if (strArrSplit.length == 4) {
                setMargin(Integer.valueOf(Utils.convertCssSizeToPx(strArrSplit[3]).intValue()), Integer.valueOf(Utils.convertCssSizeToPx(strArrSplit[0]).intValue()), Integer.valueOf(Utils.convertCssSizeToPx(strArrSplit[1]).intValue()), Integer.valueOf(Utils.convertCssSizeToPx(strArrSplit[2]).intValue()));
            }
        }
    }

    public void setPadding(String value) {
        if (TextUtils.isEmpty(value)) {
            setPadding(null, null, null, null);
            return;
        }
        String[] strArrSplit = value.split(" ");
        if (strArrSplit.length == 1) {
            int iIntValue = Utils.convertCssSizeToPx(strArrSplit[0]).intValue();
            setPadding(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue));
            return;
        }
        if (strArrSplit.length == 2) {
            int iIntValue2 = Utils.convertCssSizeToPx(strArrSplit[0]).intValue();
            int iIntValue3 = Utils.convertCssSizeToPx(strArrSplit[1]).intValue();
            setPadding(Integer.valueOf(iIntValue3), Integer.valueOf(iIntValue2), Integer.valueOf(iIntValue3), Integer.valueOf(iIntValue2));
        } else {
            if (strArrSplit.length == 3) {
                int iIntValue4 = Utils.convertCssSizeToPx(strArrSplit[0]).intValue();
                int iIntValue5 = Utils.convertCssSizeToPx(strArrSplit[1]).intValue();
                setPadding(Integer.valueOf(iIntValue5), Integer.valueOf(iIntValue4), Integer.valueOf(iIntValue5), Integer.valueOf(Utils.convertCssSizeToPx(strArrSplit[2]).intValue()));
                return;
            }
            if (strArrSplit.length == 4) {
                setPadding(Integer.valueOf(Utils.convertCssSizeToPx(strArrSplit[3]).intValue()), Integer.valueOf(Utils.convertCssSizeToPx(strArrSplit[0]).intValue()), Integer.valueOf(Utils.convertCssSizeToPx(strArrSplit[1]).intValue()), Integer.valueOf(Utils.convertCssSizeToPx(strArrSplit[2]).intValue()));
            }
        }
    }
}
