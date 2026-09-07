package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\b\u001a\u00020\u0004HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/ironsource/am;", "", "", "a", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "revenue", "precision", "toString", "", "hashCode", "other", "", "equals", "D", "d", "()D", "Ljava/lang/String;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Ljava/lang/String;", "<init>", "(DLjava/lang/String;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class am {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String d = "revenue";
    public static final String e = "precision";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final double revenue;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String precision;

    /* JADX INFO: renamed from: com.ironsource.am$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/ironsource/am$a;", "", "Lorg/json/JSONObject;", "json", "Lcom/ironsource/am;", "a", "", "LOAD_ARM_DATA_KEY_PRECISION", "Ljava/lang/String;", "LOAD_ARM_DATA_KEY_REVENUE", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final am a(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                double d = json.getDouble("revenue");
                String precision = json.getString("precision");
                Intrinsics.checkNotNullExpressionValue(precision, "precision");
                return new am(d, precision);
            } catch (Exception e) {
                o9.d().a(e);
                vt.a(e);
                return null;
            }
        }
    }

    public am(double d2, String precision) {
        Intrinsics.checkNotNullParameter(precision, "precision");
        this.revenue = d2;
        this.precision = precision;
    }

    public static /* synthetic */ am a(am amVar, double d2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            d2 = amVar.revenue;
        }
        if ((i & 2) != 0) {
            str = amVar.precision;
        }
        return amVar.a(d2, str);
    }

    @JvmStatic
    public static final am a(JSONObject jSONObject) {
        return INSTANCE.a(jSONObject);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final double getRevenue() {
        return this.revenue;
    }

    public final am a(double revenue, String precision) {
        Intrinsics.checkNotNullParameter(precision, "precision");
        return new am(revenue, precision);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getPrecision() {
        return this.precision;
    }

    public final String c() {
        return this.precision;
    }

    public final double d() {
        return this.revenue;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof am)) {
            return false;
        }
        am amVar = (am) other;
        return Double.compare(this.revenue, amVar.revenue) == 0 && Intrinsics.areEqual(this.precision, amVar.precision);
    }

    public int hashCode() {
        return (Double.hashCode(this.revenue) * 31) + this.precision.hashCode();
    }

    public String toString() {
        return "LoadArmData(revenue=" + this.revenue + ", precision=" + this.precision + ')';
    }
}
