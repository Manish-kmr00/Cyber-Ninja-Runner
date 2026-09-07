package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0003B\u001b\b\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/chartboost/sdk/impl/e2;", "T", "", "a", "Ljava/lang/Object;", "value", "Lcom/chartboost/sdk/internal/Model/CBError;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/internal/Model/CBError;", "error", "<init>", "(Ljava/lang/Object;Lcom/chartboost/sdk/internal/Model/CBError;)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class e2<T> {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final T value;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final CBError error;

    /* JADX INFO: renamed from: com.chartboost.sdk.impl.e2$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0004\"\u0004\b\u0001\u0010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\t¨\u0006\f"}, d2 = {"Lcom/chartboost/sdk/impl/e2$a;", "", "T", "value", "Lcom/chartboost/sdk/impl/e2;", "a", "(Ljava/lang/Object;)Lcom/chartboost/sdk/impl/e2;", "Lcom/chartboost/sdk/internal/Model/CBError;", "error", "(Lcom/chartboost/sdk/internal/Model/CBError;)Lcom/chartboost/sdk/impl/e2;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        @JvmStatic
        public final <T> e2<T> a(T value) {
            return new e2<>(value, null, 0 == true ? 1 : 0);
        }

        @JvmStatic
        public final <T> e2<T> a(CBError error) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return new e2<>(defaultConstructorMarker, error, defaultConstructorMarker);
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    public static final <T> e2<T> a(CBError cBError) {
        return INSTANCE.a(cBError);
    }

    public e2(T t, CBError cBError) {
        this.value = t;
        this.error = cBError;
    }

    public /* synthetic */ e2(Object obj, CBError cBError, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, cBError);
    }
}
