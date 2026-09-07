package com.yandex.mobile.ads.nativeads.template.appearance;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.yandex.mobile.ads.impl.ia1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u000b\u0010\nJ \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u001a\u0010\u001b\u001a\u00020\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\nR\u001c\u0010$\u001a\u0004\u0018\u00010\u001f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/yandex/mobile/ads/nativeads/template/appearance/TextAppearance;", "Landroid/os/Parcelable;", "Lcom/yandex/mobile/ads/impl/ia1;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "I", "getTextColor", "textColor", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "F", "getTextSize", "()F", "textSize", "d", "getFontStyle", "fontStyle", "", "e", "Ljava/lang/String;", "getFontFamilyName", "()Ljava/lang/String;", "fontFamilyName", "Builder", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class TextAppearance implements Parcelable, ia1 {
    public static final Parcelable.Creator<TextAppearance> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int textColor;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final float textSize;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final int fontStyle;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final String fontFamilyName;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/yandex/mobile/ads/nativeads/template/appearance/TextAppearance$Builder;", "", "Lcom/yandex/mobile/ads/nativeads/template/appearance/TextAppearance;", "build", "()Lcom/yandex/mobile/ads/nativeads/template/appearance/TextAppearance;", "", "textColor", "setTextColor", "(I)Lcom/yandex/mobile/ads/nativeads/template/appearance/TextAppearance$Builder;", "", "textSize", "setTextSize", "(F)Lcom/yandex/mobile/ads/nativeads/template/appearance/TextAppearance$Builder;", "", "fontFamilyName", "setFontFamilyName", "(Ljava/lang/String;)Lcom/yandex/mobile/ads/nativeads/template/appearance/TextAppearance$Builder;", "fontStyle", "setFontStyle", "<init>", "()V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f10897a;
        private float b;
        private int c;
        private String d;

        public final TextAppearance build() {
            return new TextAppearance(this.f10897a, this.b, this.c, this.d, null);
        }

        public final Builder setFontFamilyName(String fontFamilyName) {
            this.d = fontFamilyName;
            return this;
        }

        public final Builder setFontStyle(int fontStyle) {
            this.c = fontStyle;
            return this;
        }

        public final Builder setTextColor(int textColor) {
            this.f10897a = textColor;
            return this;
        }

        public final Builder setTextSize(float textSize) {
            this.b = textSize;
            return this;
        }
    }

    public static final class a implements Parcelable.Creator<TextAppearance> {
        @Override // android.os.Parcelable.Creator
        public final TextAppearance createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TextAppearance(parcel.readInt(), parcel.readFloat(), parcel.readInt(), parcel.readString(), null);
        }

        @Override // android.os.Parcelable.Creator
        public final TextAppearance[] newArray(int i) {
            return new TextAppearance[i];
        }
    }

    public /* synthetic */ TextAppearance(int i, float f, int i2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, f, i2, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(TextAppearance.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.yandex.mobile.ads.nativeads.template.appearance.TextAppearance");
        TextAppearance textAppearance = (TextAppearance) other;
        if (getTextColor() == textAppearance.getTextColor() && getTextSize() == textAppearance.getTextSize() && getFontStyle() == textAppearance.getFontStyle()) {
            return Intrinsics.areEqual(getFontFamilyName(), textAppearance.getFontFamilyName());
        }
        return false;
    }

    @Override // com.yandex.mobile.ads.impl.ia1
    public String getFontFamilyName() {
        return this.fontFamilyName;
    }

    @Override // com.yandex.mobile.ads.impl.ia1
    public int getFontStyle() {
        return this.fontStyle;
    }

    @Override // com.yandex.mobile.ads.impl.ia1
    public int getTextColor() {
        return this.textColor;
    }

    @Override // com.yandex.mobile.ads.impl.ia1
    public float getTextSize() {
        return this.textSize;
    }

    public int hashCode() {
        int fontStyle = (getFontStyle() + ((Float.hashCode(getTextSize()) + (getTextColor() * 31)) * 31)) * 31;
        String fontFamilyName = getFontFamilyName();
        return fontStyle + (fontFamilyName != null ? fontFamilyName.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.textColor);
        parcel.writeFloat(this.textSize);
        parcel.writeInt(this.fontStyle);
        parcel.writeString(this.fontFamilyName);
    }

    private TextAppearance(int i, float f, int i2, String str) {
        this.textColor = i;
        this.textSize = f;
        this.fontStyle = i2;
        this.fontFamilyName = str;
    }
}
