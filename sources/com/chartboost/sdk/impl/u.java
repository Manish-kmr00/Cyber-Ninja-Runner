package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Networking.EndpointRepository;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0005\fB5\b\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\nR\u0017\u0010\u000e\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\nR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\f\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0013\u0010\u0011\u0082\u0001\u0003\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lcom/chartboost/sdk/impl/u;", "", "", "a", "Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Ljava/lang/String;", "name", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;", "()Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;", "getEndPoint", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "showEndPoint", "", "Z", "()Z", "shouldDisplayOnHostView", "e", "getCanBeClosed", "canBeClosed", InneractiveMediationDefs.GENDER_FEMALE, "isFullScreen", "<init>", "(Ljava/lang/String;Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;ZZ)V", "Lcom/chartboost/sdk/impl/u$a;", "Lcom/chartboost/sdk/impl/u$b;", "Lcom/chartboost/sdk/impl/u$c;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final EndpointRepository.EndPoint getEndPoint;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final EndpointRepository.EndPoint showEndPoint;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final boolean shouldDisplayOnHostView;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final boolean canBeClosed;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final boolean isFullScreen;

    public u(String str, EndpointRepository.EndPoint endPoint, EndpointRepository.EndPoint endPoint2, boolean z, boolean z2) {
        this.name = str;
        this.getEndPoint = endPoint;
        this.showEndPoint = endPoint2;
        this.shouldDisplayOnHostView = z;
        this.canBeClosed = z2;
        this.isFullScreen = !z;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final EndpointRepository.EndPoint getGetEndPoint() {
        return this.getEndPoint;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final EndpointRepository.EndPoint getShowEndPoint() {
        return this.showEndPoint;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final boolean getShouldDisplayOnHostView() {
        return this.shouldDisplayOnHostView;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final boolean getIsFullScreen() {
        return this.isFullScreen;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/chartboost/sdk/impl/u$b;", "Lcom/chartboost/sdk/impl/u;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final class b extends u {
        public static final b g = new b();

        public b() {
            super("Interstitial", EndpointRepository.EndPoint.INTERSTITIAL_GET, EndpointRepository.EndPoint.INTERSTITIAL_SHOW, false, false, 24, null);
        }
    }

    public /* synthetic */ u(String str, EndpointRepository.EndPoint endPoint, EndpointRepository.EndPoint endPoint2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, endPoint, endPoint2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? true : z2, null);
    }

    public /* synthetic */ u(String str, EndpointRepository.EndPoint endPoint, EndpointRepository.EndPoint endPoint2, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, endPoint, endPoint2, z, z2);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/chartboost/sdk/impl/u$c;", "Lcom/chartboost/sdk/impl/u;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final class c extends u {
        public static final c g = new c();

        public c() {
            super("Rewarded", EndpointRepository.EndPoint.REWARDED_GET, EndpointRepository.EndPoint.REWARDED_SHOW, false, false, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/chartboost/sdk/impl/u$a;", "Lcom/chartboost/sdk/impl/u;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final class a extends u {
        public static final a g = new a();

        public a() {
            super("Banner", EndpointRepository.EndPoint.BANNER_GET, EndpointRepository.EndPoint.BANNER_SHOW, true, false, 16, null);
        }
    }
}
