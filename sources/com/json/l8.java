package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u001f\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/ironsource/l8;", "", "", "e", "toString", "", "a", "Lcom/ironsource/n8;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "isCapped", "type", "", "hashCode", "other", "equals", "Z", "d", "()Z", "Lcom/ironsource/n8;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/ironsource/n8;", "<init>", "(ZLcom/ironsource/n8;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class l8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isCapped;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final n8 type;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3852a;

        static {
            int[] iArr = new int[n8.values().length];
            try {
                iArr[n8.Delivery.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[n8.Pacing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[n8.ShowCount.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3852a = iArr;
        }
    }

    public l8(boolean z, n8 n8Var) {
        this.isCapped = z;
        this.type = n8Var;
    }

    public /* synthetic */ l8(boolean z, n8 n8Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : n8Var);
    }

    public static /* synthetic */ l8 a(l8 l8Var, boolean z, n8 n8Var, int i, Object obj) {
        if ((i & 1) != 0) {
            z = l8Var.isCapped;
        }
        if ((i & 2) != 0) {
            n8Var = l8Var.type;
        }
        return l8Var.a(z, n8Var);
    }

    public final l8 a(boolean isCapped, n8 type) {
        return new l8(isCapped, type);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getIsCapped() {
        return this.isCapped;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final n8 getType() {
        return this.type;
    }

    public final n8 c() {
        return this.type;
    }

    public final boolean d() {
        return this.isCapped;
    }

    public final String e() {
        n8 n8Var = this.type;
        int i = n8Var == null ? -1 : a.f3852a[n8Var.ordinal()];
        if (i == 1) {
            return "Placement delivery is false";
        }
        if (i == 2) {
            return "In pacing mode";
        }
        if (i != 3) {
            return null;
        }
        return "Max ad cap reached";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof l8)) {
            return false;
        }
        l8 l8Var = (l8) other;
        return this.isCapped == l8Var.isCapped && this.type == l8Var.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.isCapped;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        n8 n8Var = this.type;
        return i + (n8Var == null ? 0 : n8Var.hashCode());
    }

    public String toString() {
        return "CappingStatus(isCapped=" + this.isCapped + " reason=" + this.type + ')';
    }
}
