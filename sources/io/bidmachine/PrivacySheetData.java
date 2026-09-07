package io.bidmachine;

import io.bidmachine.rendering.model.PrivacySheetParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrivacySheetData.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lio/bidmachine/PrivacySheetData;", "", "labelData", "Lio/bidmachine/LabelData;", "privacySheetParams", "Lio/bidmachine/rendering/model/PrivacySheetParams;", "(Lio/bidmachine/LabelData;Lio/bidmachine/rendering/model/PrivacySheetParams;)V", "getLabelData", "()Lio/bidmachine/LabelData;", "getPrivacySheetParams", "()Lio/bidmachine/rendering/model/PrivacySheetParams;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bidmachine-android-sdk_d_3_2_1"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final /* data */ class PrivacySheetData {
    private final LabelData labelData;
    private final PrivacySheetParams privacySheetParams;

    public static /* synthetic */ PrivacySheetData copy$default(PrivacySheetData privacySheetData, LabelData labelData, PrivacySheetParams privacySheetParams, int i, Object obj) {
        if ((i & 1) != 0) {
            labelData = privacySheetData.labelData;
        }
        if ((i & 2) != 0) {
            privacySheetParams = privacySheetData.privacySheetParams;
        }
        return privacySheetData.copy(labelData, privacySheetParams);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LabelData getLabelData() {
        return this.labelData;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PrivacySheetParams getPrivacySheetParams() {
        return this.privacySheetParams;
    }

    public final PrivacySheetData copy(LabelData labelData, PrivacySheetParams privacySheetParams) {
        Intrinsics.checkNotNullParameter(labelData, "labelData");
        Intrinsics.checkNotNullParameter(privacySheetParams, "privacySheetParams");
        return new PrivacySheetData(labelData, privacySheetParams);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrivacySheetData)) {
            return false;
        }
        PrivacySheetData privacySheetData = (PrivacySheetData) other;
        return Intrinsics.areEqual(this.labelData, privacySheetData.labelData) && Intrinsics.areEqual(this.privacySheetParams, privacySheetData.privacySheetParams);
    }

    public int hashCode() {
        return (this.labelData.hashCode() * 31) + this.privacySheetParams.hashCode();
    }

    public String toString() {
        return "PrivacySheetData(labelData=" + this.labelData + ", privacySheetParams=" + this.privacySheetParams + ')';
    }

    public PrivacySheetData(LabelData labelData, PrivacySheetParams privacySheetParams) {
        Intrinsics.checkNotNullParameter(labelData, "labelData");
        Intrinsics.checkNotNullParameter(privacySheetParams, "privacySheetParams");
        this.labelData = labelData;
        this.privacySheetParams = privacySheetParams;
    }

    public final LabelData getLabelData() {
        return this.labelData;
    }

    public final PrivacySheetParams getPrivacySheetParams() {
        return this.privacySheetParams;
    }
}
