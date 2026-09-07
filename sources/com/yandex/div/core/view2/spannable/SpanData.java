package com.yandex.div.core.view2.spannable;

import com.yandex.div2.DivFontWeight;
import com.yandex.div2.DivLineStyle;
import com.yandex.div2.DivSizeUnit;
import com.yandex.div2.DivTextAlignmentVertical;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpanData.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0080\b\u0018\u0000 [2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001[BÅ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u001dJ\u0011\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0000H\u0096\u0002J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010@\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010B\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010D\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010H\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\t\u0010O\u001a\u00020\rHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jê\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020T2\b\u0010=\u001a\u0004\u0018\u00010UHÖ\u0003J\t\u0010V\u001a\u00020\u0003HÖ\u0001J\u0006\u0010W\u001a\u00020TJ\"\u0010X\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003J\t\u0010Z\u001a\u00020\tHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b-\u0010'R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b1\u0010'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b5\u0010'R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b8\u0010'R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b9\u0010'R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b:\u0010'R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b;\u00104¨\u0006\\"}, d2 = {"Lcom/yandex/div/core/view2/spannable/SpanData;", "", "start", "", "end", "alignmentVertical", "Lcom/yandex/div2/DivTextAlignmentVertical;", "baselineOffset", "fontFamily", "", "fontFeatureSettings", "fontSize", "fontSizeUnit", "Lcom/yandex/div2/DivSizeUnit;", "fontWeight", "Lcom/yandex/div2/DivFontWeight;", "fontWeightValue", "letterSpacing", "", "lineHeight", "strike", "Lcom/yandex/div2/DivLineStyle;", "textColor", "textShadow", "Lcom/yandex/div/core/view2/spannable/ShadowData;", "topOffset", "topOffsetStart", "topOffsetEnd", "underline", "(IILcom/yandex/div2/DivTextAlignmentVertical;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/yandex/div2/DivSizeUnit;Lcom/yandex/div2/DivFontWeight;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Lcom/yandex/div2/DivLineStyle;Ljava/lang/Integer;Lcom/yandex/div/core/view2/spannable/ShadowData;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/yandex/div2/DivLineStyle;)V", "getAlignmentVertical", "()Lcom/yandex/div2/DivTextAlignmentVertical;", "getBaselineOffset", "()I", "getEnd", "getFontFamily", "()Ljava/lang/String;", "getFontFeatureSettings", "getFontSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFontSizeUnit", "()Lcom/yandex/div2/DivSizeUnit;", "getFontWeight", "()Lcom/yandex/div2/DivFontWeight;", "getFontWeightValue", "getLetterSpacing", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLineHeight", "getStart", "getStrike", "()Lcom/yandex/div2/DivLineStyle;", "getTextColor", "getTextShadow", "()Lcom/yandex/div/core/view2/spannable/ShadowData;", "getTopOffset", "getTopOffsetEnd", "getTopOffsetStart", "getUnderline", "compareTo", "other", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IILcom/yandex/div2/DivTextAlignmentVertical;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/yandex/div2/DivSizeUnit;Lcom/yandex/div2/DivFontWeight;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Lcom/yandex/div2/DivLineStyle;Ljava/lang/Integer;Lcom/yandex/div/core/view2/spannable/ShadowData;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/yandex/div2/DivLineStyle;)Lcom/yandex/div/core/view2/spannable/SpanData;", "equals", "", "", "hashCode", "isEmpty", "mergeWith", "span", "toString", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class SpanData implements Comparable<SpanData> {
    private static final int DEFAULT_BASELINE_OFFSET = 0;
    private final DivTextAlignmentVertical alignmentVertical;
    private final int baselineOffset;
    private final int end;
    private final String fontFamily;
    private final String fontFeatureSettings;
    private final Integer fontSize;
    private final DivSizeUnit fontSizeUnit;
    private final DivFontWeight fontWeight;
    private final Integer fontWeightValue;
    private final Double letterSpacing;
    private final Integer lineHeight;
    private final int start;
    private final DivLineStyle strike;
    private final Integer textColor;
    private final ShadowData textShadow;
    private final Integer topOffset;
    private final Integer topOffsetEnd;
    private final Integer topOffsetStart;
    private final DivLineStyle underline;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DivSizeUnit DEFAULT_FONT_SIZE_UNIT = DivSizeUnit.SP;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getFontWeightValue() {
        return this.fontWeightValue;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Double getLetterSpacing() {
        return this.letterSpacing;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Integer getLineHeight() {
        return this.lineHeight;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final DivLineStyle getStrike() {
        return this.strike;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getTextColor() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final ShadowData getTextShadow() {
        return this.textShadow;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Integer getTopOffset() {
        return this.topOffset;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Integer getTopOffsetStart() {
        return this.topOffsetStart;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Integer getTopOffsetEnd() {
        return this.topOffsetEnd;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final DivLineStyle getUnderline() {
        return this.underline;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final DivTextAlignmentVertical getAlignmentVertical() {
        return this.alignmentVertical;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBaselineOffset() {
        return this.baselineOffset;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFontFamily() {
        return this.fontFamily;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getFontSize() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final DivSizeUnit getFontSizeUnit() {
        return this.fontSizeUnit;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final DivFontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final SpanData copy(int start, int end, DivTextAlignmentVertical alignmentVertical, int baselineOffset, String fontFamily, String fontFeatureSettings, Integer fontSize, DivSizeUnit fontSizeUnit, DivFontWeight fontWeight, Integer fontWeightValue, Double letterSpacing, Integer lineHeight, DivLineStyle strike, Integer textColor, ShadowData textShadow, Integer topOffset, Integer topOffsetStart, Integer topOffsetEnd, DivLineStyle underline) {
        Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
        return new SpanData(start, end, alignmentVertical, baselineOffset, fontFamily, fontFeatureSettings, fontSize, fontSizeUnit, fontWeight, fontWeightValue, letterSpacing, lineHeight, strike, textColor, textShadow, topOffset, topOffsetStart, topOffsetEnd, underline);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpanData)) {
            return false;
        }
        SpanData spanData = (SpanData) other;
        return this.start == spanData.start && this.end == spanData.end && this.alignmentVertical == spanData.alignmentVertical && this.baselineOffset == spanData.baselineOffset && Intrinsics.areEqual(this.fontFamily, spanData.fontFamily) && Intrinsics.areEqual(this.fontFeatureSettings, spanData.fontFeatureSettings) && Intrinsics.areEqual(this.fontSize, spanData.fontSize) && this.fontSizeUnit == spanData.fontSizeUnit && this.fontWeight == spanData.fontWeight && Intrinsics.areEqual(this.fontWeightValue, spanData.fontWeightValue) && Intrinsics.areEqual((Object) this.letterSpacing, (Object) spanData.letterSpacing) && Intrinsics.areEqual(this.lineHeight, spanData.lineHeight) && this.strike == spanData.strike && Intrinsics.areEqual(this.textColor, spanData.textColor) && Intrinsics.areEqual(this.textShadow, spanData.textShadow) && Intrinsics.areEqual(this.topOffset, spanData.topOffset) && Intrinsics.areEqual(this.topOffsetStart, spanData.topOffsetStart) && Intrinsics.areEqual(this.topOffsetEnd, spanData.topOffsetEnd) && this.underline == spanData.underline;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end)) * 31;
        DivTextAlignmentVertical divTextAlignmentVertical = this.alignmentVertical;
        int iHashCode2 = (((iHashCode + (divTextAlignmentVertical == null ? 0 : divTextAlignmentVertical.hashCode())) * 31) + Integer.hashCode(this.baselineOffset)) * 31;
        String str = this.fontFamily;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fontFeatureSettings;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.fontSize;
        int iHashCode5 = (((iHashCode4 + (num == null ? 0 : num.hashCode())) * 31) + this.fontSizeUnit.hashCode()) * 31;
        DivFontWeight divFontWeight = this.fontWeight;
        int iHashCode6 = (iHashCode5 + (divFontWeight == null ? 0 : divFontWeight.hashCode())) * 31;
        Integer num2 = this.fontWeightValue;
        int iHashCode7 = (iHashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Double d = this.letterSpacing;
        int iHashCode8 = (iHashCode7 + (d == null ? 0 : d.hashCode())) * 31;
        Integer num3 = this.lineHeight;
        int iHashCode9 = (iHashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        DivLineStyle divLineStyle = this.strike;
        int iHashCode10 = (iHashCode9 + (divLineStyle == null ? 0 : divLineStyle.hashCode())) * 31;
        Integer num4 = this.textColor;
        int iHashCode11 = (iHashCode10 + (num4 == null ? 0 : num4.hashCode())) * 31;
        ShadowData shadowData = this.textShadow;
        int iHashCode12 = (iHashCode11 + (shadowData == null ? 0 : shadowData.hashCode())) * 31;
        Integer num5 = this.topOffset;
        int iHashCode13 = (iHashCode12 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.topOffsetStart;
        int iHashCode14 = (iHashCode13 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.topOffsetEnd;
        int iHashCode15 = (iHashCode14 + (num7 == null ? 0 : num7.hashCode())) * 31;
        DivLineStyle divLineStyle2 = this.underline;
        return iHashCode15 + (divLineStyle2 != null ? divLineStyle2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SpanData(start=");
        sb.append(this.start).append(", end=").append(this.end).append(", alignmentVertical=").append(this.alignmentVertical).append(", baselineOffset=").append(this.baselineOffset).append(", fontFamily=").append(this.fontFamily).append(", fontFeatureSettings=").append(this.fontFeatureSettings).append(", fontSize=").append(this.fontSize).append(", fontSizeUnit=").append(this.fontSizeUnit).append(", fontWeight=").append(this.fontWeight).append(", fontWeightValue=").append(this.fontWeightValue).append(", letterSpacing=").append(this.letterSpacing).append(", lineHeight=");
        sb.append(this.lineHeight).append(", strike=").append(this.strike).append(", textColor=").append(this.textColor).append(", textShadow=").append(this.textShadow).append(", topOffset=").append(this.topOffset).append(", topOffsetStart=").append(this.topOffsetStart).append(", topOffsetEnd=").append(this.topOffsetEnd).append(", underline=").append(this.underline).append(')');
        return sb.toString();
    }

    public SpanData(int i, int i2, DivTextAlignmentVertical divTextAlignmentVertical, int i3, String str, String str2, Integer num, DivSizeUnit fontSizeUnit, DivFontWeight divFontWeight, Integer num2, Double d, Integer num3, DivLineStyle divLineStyle, Integer num4, ShadowData shadowData, Integer num5, Integer num6, Integer num7, DivLineStyle divLineStyle2) {
        Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
        this.start = i;
        this.end = i2;
        this.alignmentVertical = divTextAlignmentVertical;
        this.baselineOffset = i3;
        this.fontFamily = str;
        this.fontFeatureSettings = str2;
        this.fontSize = num;
        this.fontSizeUnit = fontSizeUnit;
        this.fontWeight = divFontWeight;
        this.fontWeightValue = num2;
        this.letterSpacing = d;
        this.lineHeight = num3;
        this.strike = divLineStyle;
        this.textColor = num4;
        this.textShadow = shadowData;
        this.topOffset = num5;
        this.topOffsetStart = num6;
        this.topOffsetEnd = num7;
        this.underline = divLineStyle2;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getEnd() {
        return this.end;
    }

    public final DivTextAlignmentVertical getAlignmentVertical() {
        return this.alignmentVertical;
    }

    public final int getBaselineOffset() {
        return this.baselineOffset;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    public final Integer getFontSize() {
        return this.fontSize;
    }

    public final DivSizeUnit getFontSizeUnit() {
        return this.fontSizeUnit;
    }

    public final DivFontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final Integer getFontWeightValue() {
        return this.fontWeightValue;
    }

    public final Double getLetterSpacing() {
        return this.letterSpacing;
    }

    public final Integer getLineHeight() {
        return this.lineHeight;
    }

    public final DivLineStyle getStrike() {
        return this.strike;
    }

    public final Integer getTextColor() {
        return this.textColor;
    }

    public final ShadowData getTextShadow() {
        return this.textShadow;
    }

    public final Integer getTopOffset() {
        return this.topOffset;
    }

    public final Integer getTopOffsetStart() {
        return this.topOffsetStart;
    }

    public final Integer getTopOffsetEnd() {
        return this.topOffsetEnd;
    }

    public final DivLineStyle getUnderline() {
        return this.underline;
    }

    public static /* synthetic */ SpanData mergeWith$default(SpanData spanData, SpanData spanData2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = spanData2.start;
        }
        if ((i3 & 4) != 0) {
            i2 = spanData2.end;
        }
        return spanData.mergeWith(spanData2, i, i2);
    }

    public final SpanData mergeWith(SpanData span, int start, int end) {
        Intrinsics.checkNotNullParameter(span, "span");
        DivTextAlignmentVertical divTextAlignmentVertical = span.alignmentVertical;
        if (divTextAlignmentVertical == null) {
            divTextAlignmentVertical = this.alignmentVertical;
        }
        DivTextAlignmentVertical divTextAlignmentVertical2 = divTextAlignmentVertical;
        int i = span.baselineOffset;
        if (i == 0) {
            i = this.baselineOffset;
        }
        int i2 = i;
        String str = span.fontFamily;
        if (str == null) {
            str = this.fontFamily;
        }
        String str2 = str;
        String str3 = span.fontFeatureSettings;
        if (str3 == null) {
            str3 = this.fontFeatureSettings;
        }
        String str4 = str3;
        Integer num = span.fontSize;
        if (num == null) {
            num = this.fontSize;
        }
        Integer num2 = num;
        DivSizeUnit divSizeUnit = span.fontSizeUnit;
        if (divSizeUnit == DEFAULT_FONT_SIZE_UNIT) {
            divSizeUnit = this.fontSizeUnit;
        }
        DivSizeUnit divSizeUnit2 = divSizeUnit;
        DivFontWeight divFontWeight = span.fontWeight;
        if (divFontWeight == null) {
            divFontWeight = this.fontWeight;
        }
        DivFontWeight divFontWeight2 = divFontWeight;
        Integer num3 = span.fontWeightValue;
        if (num3 == null) {
            num3 = this.fontWeightValue;
        }
        Integer num4 = num3;
        Double d = span.letterSpacing;
        if (d == null) {
            d = this.letterSpacing;
        }
        Double d2 = d;
        Integer num5 = span.lineHeight;
        if (num5 == null) {
            num5 = this.lineHeight;
        }
        Integer num6 = num5;
        DivLineStyle divLineStyle = span.strike;
        if (divLineStyle == null) {
            divLineStyle = this.strike;
        }
        DivLineStyle divLineStyle2 = divLineStyle;
        Integer num7 = span.textColor;
        if (num7 == null) {
            num7 = this.textColor;
        }
        Integer num8 = num7;
        ShadowData shadowData = span.textShadow;
        if (shadowData == null) {
            shadowData = this.textShadow;
        }
        ShadowData shadowData2 = shadowData;
        Integer num9 = span.topOffset;
        Integer num10 = num9 == null ? this.topOffset : num9;
        Integer num11 = num9 != null ? span.topOffsetStart : this.topOffsetStart;
        Integer num12 = num9 != null ? span.topOffsetEnd : this.topOffsetEnd;
        DivLineStyle divLineStyle3 = span.underline;
        if (divLineStyle3 == null) {
            divLineStyle3 = this.underline;
        }
        return new SpanData(start, end, divTextAlignmentVertical2, i2, str2, str4, num2, divSizeUnit2, divFontWeight2, num4, d2, num6, divLineStyle2, num8, shadowData2, num10, num11, num12, divLineStyle3);
    }

    public final boolean isEmpty() {
        return this.alignmentVertical == null && this.baselineOffset == 0 && this.fontFamily == null && this.fontFeatureSettings == null && this.fontSize == null && this.fontSizeUnit == DEFAULT_FONT_SIZE_UNIT && this.fontWeight == null && this.fontWeightValue == null && this.letterSpacing == null && this.lineHeight == null && this.strike == null && this.textColor == null && this.textShadow == null && this.topOffset == null && this.topOffsetStart == null && this.topOffsetEnd == null && this.underline == null;
    }

    @Override // java.lang.Comparable
    public int compareTo(SpanData other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.start - other.start;
    }

    /* JADX INFO: compiled from: SpanData.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000bJ%\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div/core/view2/spannable/SpanData$Companion;", "", "()V", "DEFAULT_BASELINE_OFFSET", "", "DEFAULT_FONT_SIZE_UNIT", "Lcom/yandex/div2/DivSizeUnit;", "empty", "Lcom/yandex/div/core/view2/spannable/SpanData;", "start", "end", "empty$div_release", "lineHeight", "lineHeight$div_release", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SpanData empty$div_release(int start, int end) {
            return new SpanData(start, end, null, 0, null, null, null, SpanData.DEFAULT_FONT_SIZE_UNIT, null, null, null, null, null, null, null, null, null, null, null);
        }

        public final SpanData lineHeight$div_release(int start, int end, int lineHeight) {
            return new SpanData(start, end, null, 0, null, null, null, SpanData.DEFAULT_FONT_SIZE_UNIT, null, null, null, Integer.valueOf(lineHeight), null, null, null, null, null, null, null);
        }
    }
}
