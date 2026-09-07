package com.moloco.sdk.common_adapter_internal;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0005HÆ\u0003J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\t\u0010\t\u001a\u00020\u0005HÆ\u0003JE\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\r\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001aR\u0017\u0010\u000f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010 ¨\u0006)"}, d2 = {"Lcom/moloco/sdk/common_adapter_internal/ScreenData;", "", "", "component1", "component2", "", "component3", "component4", "component5", "component6", "widthPx", "heightPx", "widthDp", "heightDp", "dpi", "pxRatio", "copy", "", "toString", "hashCode", "other", "", "equals", "a", "I", "getWidthPx", "()I", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getHeightPx", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "F", "getWidthDp", "()F", "d", "getHeightDp", "e", "getDpi", InneractiveMediationDefs.GENDER_FEMALE, "getPxRatio", "<init>", "(IIFFIF)V", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class ScreenData {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int widthPx;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int heightPx;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final float widthDp;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final float heightDp;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final int dpi;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final float pxRatio;

    public ScreenData(int i, int i2, float f, float f2, int i3, float f3) {
        this.widthPx = i;
        this.heightPx = i2;
        this.widthDp = f;
        this.heightDp = f2;
        this.dpi = i3;
        this.pxRatio = f3;
    }

    public static /* synthetic */ ScreenData copy$default(ScreenData screenData, int i, int i2, float f, float f2, int i3, float f3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = screenData.widthPx;
        }
        if ((i4 & 2) != 0) {
            i2 = screenData.heightPx;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            f = screenData.widthDp;
        }
        float f4 = f;
        if ((i4 & 8) != 0) {
            f2 = screenData.heightDp;
        }
        float f5 = f2;
        if ((i4 & 16) != 0) {
            i3 = screenData.dpi;
        }
        int i6 = i3;
        if ((i4 & 32) != 0) {
            f3 = screenData.pxRatio;
        }
        return screenData.copy(i, i5, f4, f5, i6, f3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getWidthPx() {
        return this.widthPx;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHeightPx() {
        return this.heightPx;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getWidthDp() {
        return this.widthDp;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getHeightDp() {
        return this.heightDp;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getDpi() {
        return this.dpi;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getPxRatio() {
        return this.pxRatio;
    }

    public final ScreenData copy(int widthPx, int heightPx, float widthDp, float heightDp, int dpi, float pxRatio) {
        return new ScreenData(widthPx, heightPx, widthDp, heightDp, dpi, pxRatio);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScreenData)) {
            return false;
        }
        ScreenData screenData = (ScreenData) other;
        return this.widthPx == screenData.widthPx && this.heightPx == screenData.heightPx && Float.compare(this.widthDp, screenData.widthDp) == 0 && Float.compare(this.heightDp, screenData.heightDp) == 0 && this.dpi == screenData.dpi && Float.compare(this.pxRatio, screenData.pxRatio) == 0;
    }

    public final int getDpi() {
        return this.dpi;
    }

    public final float getHeightDp() {
        return this.heightDp;
    }

    public final int getHeightPx() {
        return this.heightPx;
    }

    public final float getPxRatio() {
        return this.pxRatio;
    }

    public final float getWidthDp() {
        return this.widthDp;
    }

    public final int getWidthPx() {
        return this.widthPx;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.widthPx) * 31) + Integer.hashCode(this.heightPx)) * 31) + Float.hashCode(this.widthDp)) * 31) + Float.hashCode(this.heightDp)) * 31) + Integer.hashCode(this.dpi)) * 31) + Float.hashCode(this.pxRatio);
    }

    public String toString() {
        return "ScreenData(widthPx=" + this.widthPx + ", heightPx=" + this.heightPx + ", widthDp=" + this.widthDp + ", heightDp=" + this.heightDp + ", dpi=" + this.dpi + ", pxRatio=" + this.pxRatio + ')';
    }
}
