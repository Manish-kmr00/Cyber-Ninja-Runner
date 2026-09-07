package com.yandex.div.core.view2.spannable;

import com.yandex.div2.DivFontWeight;
import com.yandex.div2.DivSizeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextData.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010)\u001a\u00020\u0005HÆ\u0003Jp\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u000e\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u001f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u00061"}, d2 = {"Lcom/yandex/div/core/view2/spannable/TextData;", "", "text", "", "fontSize", "", "fontSizeValue", "fontSizeUnit", "Lcom/yandex/div2/DivSizeUnit;", "fontFamily", "fontWeight", "Lcom/yandex/div2/DivFontWeight;", "fontWeightValue", "lineHeight", "textColor", "(Ljava/lang/String;IILcom/yandex/div2/DivSizeUnit;Ljava/lang/String;Lcom/yandex/div2/DivFontWeight;Ljava/lang/Integer;Ljava/lang/Integer;I)V", "getFontFamily", "()Ljava/lang/String;", "getFontSize", "()I", "getFontSizeUnit", "()Lcom/yandex/div2/DivSizeUnit;", "getFontSizeValue", "getFontWeight", "()Lcom/yandex/div2/DivFontWeight;", "getFontWeightValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLineHeight", "getText", "getTextColor", "textLength", "getTextLength", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;IILcom/yandex/div2/DivSizeUnit;Ljava/lang/String;Lcom/yandex/div2/DivFontWeight;Ljava/lang/Integer;Ljava/lang/Integer;I)Lcom/yandex/div/core/view2/spannable/TextData;", "equals", "", "other", "hashCode", "toString", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class TextData {
    private final String fontFamily;
    private final int fontSize;
    private final DivSizeUnit fontSizeUnit;
    private final int fontSizeValue;
    private final DivFontWeight fontWeight;
    private final Integer fontWeightValue;
    private final Integer lineHeight;
    private final String text;
    private final int textColor;
    private final int textLength;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFontSize() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFontSizeValue() {
        return this.fontSizeValue;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final DivSizeUnit getFontSizeUnit() {
        return this.fontSizeUnit;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFontFamily() {
        return this.fontFamily;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DivFontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getFontWeightValue() {
        return this.fontWeightValue;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getLineHeight() {
        return this.lineHeight;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    public final TextData copy(String text, int fontSize, int fontSizeValue, DivSizeUnit fontSizeUnit, String fontFamily, DivFontWeight fontWeight, Integer fontWeightValue, Integer lineHeight, int textColor) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
        return new TextData(text, fontSize, fontSizeValue, fontSizeUnit, fontFamily, fontWeight, fontWeightValue, lineHeight, textColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextData)) {
            return false;
        }
        TextData textData = (TextData) other;
        return Intrinsics.areEqual(this.text, textData.text) && this.fontSize == textData.fontSize && this.fontSizeValue == textData.fontSizeValue && this.fontSizeUnit == textData.fontSizeUnit && Intrinsics.areEqual(this.fontFamily, textData.fontFamily) && this.fontWeight == textData.fontWeight && Intrinsics.areEqual(this.fontWeightValue, textData.fontWeightValue) && Intrinsics.areEqual(this.lineHeight, textData.lineHeight) && this.textColor == textData.textColor;
    }

    public int hashCode() {
        int iHashCode = ((((((this.text.hashCode() * 31) + Integer.hashCode(this.fontSize)) * 31) + Integer.hashCode(this.fontSizeValue)) * 31) + this.fontSizeUnit.hashCode()) * 31;
        String str = this.fontFamily;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        DivFontWeight divFontWeight = this.fontWeight;
        int iHashCode3 = (iHashCode2 + (divFontWeight == null ? 0 : divFontWeight.hashCode())) * 31;
        Integer num = this.fontWeightValue;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.lineHeight;
        return ((iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31) + Integer.hashCode(this.textColor);
    }

    public String toString() {
        return "TextData(text=" + this.text + ", fontSize=" + this.fontSize + ", fontSizeValue=" + this.fontSizeValue + ", fontSizeUnit=" + this.fontSizeUnit + ", fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", fontWeightValue=" + this.fontWeightValue + ", lineHeight=" + this.lineHeight + ", textColor=" + this.textColor + ')';
    }

    public TextData(String text, int i, int i2, DivSizeUnit fontSizeUnit, String str, DivFontWeight divFontWeight, Integer num, Integer num2, int i3) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fontSizeUnit, "fontSizeUnit");
        this.text = text;
        this.fontSize = i;
        this.fontSizeValue = i2;
        this.fontSizeUnit = fontSizeUnit;
        this.fontFamily = str;
        this.fontWeight = divFontWeight;
        this.fontWeightValue = num;
        this.lineHeight = num2;
        this.textColor = i3;
        this.textLength = text.length();
    }

    public final String getText() {
        return this.text;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final int getFontSizeValue() {
        return this.fontSizeValue;
    }

    public final DivSizeUnit getFontSizeUnit() {
        return this.fontSizeUnit;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final DivFontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final Integer getFontWeightValue() {
        return this.fontWeightValue;
    }

    public final Integer getLineHeight() {
        return this.lineHeight;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextLength() {
        return this.textLength;
    }
}
