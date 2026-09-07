package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.unified.UnifiedMediationParams;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\f\u000eBC\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0017¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\f\u0010\u0004R\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0012\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001b\u0010\u0019¨\u0006\""}, d2 = {"Lcom/chartboost/sdk/impl/s6;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, UnifiedMediationParams.KEY_IMAGE_URL, "clickthroughUrl", "Lcom/chartboost/sdk/impl/s6$b;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/s6$b;", "d", "()Lcom/chartboost/sdk/impl/s6$b;", com.ironsource.b9.h.L, "Lcom/chartboost/sdk/impl/s6$a;", "Lcom/chartboost/sdk/impl/s6$a;", "()Lcom/chartboost/sdk/impl/s6$a;", VastAttributes.MARGIN, "e", "getPadding", VastAttributes.PADDING, InneractiveMediationDefs.GENDER_FEMALE, ContentDisposition.Parameters.Size, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/impl/s6$b;Lcom/chartboost/sdk/impl/s6$a;Lcom/chartboost/sdk/impl/s6$a;Lcom/chartboost/sdk/impl/s6$a;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class s6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String imageUrl;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String clickthroughUrl;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final b position;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final a margin;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final a padding;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final a size;

    public s6() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof s6)) {
            return false;
        }
        s6 s6Var = (s6) other;
        return Intrinsics.areEqual(this.imageUrl, s6Var.imageUrl) && Intrinsics.areEqual(this.clickthroughUrl, s6Var.clickthroughUrl) && this.position == s6Var.position && Intrinsics.areEqual(this.margin, s6Var.margin) && Intrinsics.areEqual(this.padding, s6Var.padding) && Intrinsics.areEqual(this.size, s6Var.size);
    }

    public int hashCode() {
        return (((((((((this.imageUrl.hashCode() * 31) + this.clickthroughUrl.hashCode()) * 31) + this.position.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.size.hashCode();
    }

    public String toString() {
        return "InfoIcon(imageUrl=" + this.imageUrl + ", clickthroughUrl=" + this.clickthroughUrl + ", position=" + this.position + ", margin=" + this.margin + ", padding=" + this.padding + ", size=" + this.size + ')';
    }

    public s6(String imageUrl, String clickthroughUrl, b position, a margin, a padding, a size) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(clickthroughUrl, "clickthroughUrl");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(size, "size");
        this.imageUrl = imageUrl;
        this.clickthroughUrl = clickthroughUrl;
        this.position = position;
        this.margin = margin;
        this.padding = padding;
        this.size = size;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getClickthroughUrl() {
        return this.clickthroughUrl;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final b getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final a getMargin() {
        return this.margin;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final a getSize() {
        return this.size;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/chartboost/sdk/impl/s6$b;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "I", "()I", "intValue", "<init>", "(Ljava/lang/String;II)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "a", "d", "e", InneractiveMediationDefs.GENDER_FEMALE, "g", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public enum b {
        TOP_LEFT(0),
        TOP_RIGHT(1),
        BOTTOM_LEFT(2),
        BOTTOM_RIGHT(3);


        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final int intValue;

        b(int i) {
            this.intValue = i;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getIntValue() {
            return this.intValue;
        }

        /* JADX INFO: renamed from: com.chartboost.sdk.impl.s6$b$a, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/chartboost/sdk/impl/s6$b$a;", "", "", "infoIconPosition", "Lcom/chartboost/sdk/impl/s6$b;", "a", "(I)Lcom/chartboost/sdk/impl/s6$b;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            /* JADX WARN: Code duplicated, block: B:10:0x0017  */
            /* JADX WARN: Code duplicated, block: B:14:? A[RETURN, SYNTHETIC] */
            public final b a(int infoIconPosition) {
                for (b bVar : b.values()) {
                    if (bVar.getIntValue() == infoIconPosition) {
                        if (bVar == null) {
                            return b.TOP_LEFT;
                        }
                        return bVar;
                    }
                }
                bVar = null;
                if (bVar == null) {
                    return b.TOP_LEFT;
                }
                return bVar;
            }

            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    public /* synthetic */ s6(String str, String str2, b bVar, a aVar, a aVar2, a aVar3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) == 0 ? str2 : "", (i & 4) != 0 ? b.TOP_LEFT : bVar, (i & 8) != 0 ? new a(0.0d, 0.0d, 3, null) : aVar, (i & 16) != 0 ? new a(0.0d, 0.0d, 3, null) : aVar2, (i & 32) != 0 ? new a(0.0d, 0.0d, 3, null) : aVar3);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\b\u0002\u0010\u0012\u001a\u00060\fj\u0002`\r\u0012\f\b\u0002\u0010\u0013\u001a\u00060\fj\u0002`\r¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\u0012\u001a\u00060\fj\u0002`\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00060\fj\u0002`\r8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/chartboost/sdk/impl/s6$a;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/chartboost/sdk/internal/AdUnitManager/data/SizeDp;", "a", "D", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()D", "width", "height", "<init>", "(DD)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final double width;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final double height;

        public a() {
            this(0.0d, 0.0d, 3, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return Double.compare(this.width, aVar.width) == 0 && Double.compare(this.height, aVar.height) == 0;
        }

        public int hashCode() {
            return (Double.hashCode(this.width) * 31) + Double.hashCode(this.height);
        }

        public String toString() {
            return "DoubleSize(width=" + this.width + ", height=" + this.height + ')';
        }

        public a(double d, double d2) {
            this.width = d;
            this.height = d2;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final double getWidth() {
            return this.width;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final double getHeight() {
            return this.height;
        }

        public /* synthetic */ a(double d, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2);
        }
    }
}
