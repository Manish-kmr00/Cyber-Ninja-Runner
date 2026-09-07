package com.chartboost.sdk.internal.Networking;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\b\u001a\u00020\u0005*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0018\u0010\n\u001a\u00020\u0005*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;", "Ljava/net/URL;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;)Ljava/net/URL;", "defaultUrl", "", "a", "(Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;)Ljava/lang/String;", "defaultHost", "(Ljava/net/URL;)Ljava/lang/String;", "cbRequestHost", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class b {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1215a;

        static {
            int[] iArr = new int[EndpointRepository.EndPoint.values().length];
            try {
                iArr[EndpointRepository.EndPoint.BANNER_GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f1215a = iArr;
        }
    }

    public static final String a(EndpointRepository.EndPoint endPoint) {
        Intrinsics.checkNotNullParameter(endPoint, "<this>");
        return a.f1215a[endPoint.ordinal()] == 1 ? EndpointRepository.a.DA.getDefaultValue() : EndpointRepository.a.AD_GET.getDefaultValue();
    }

    public static final URL b(EndpointRepository.EndPoint endPoint) {
        Intrinsics.checkNotNullParameter(endPoint, "<this>");
        return new URL("https", a(endPoint), endPoint.getDefaultValue());
    }

    public static final String a(URL url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        return url.getProtocol() + "://" + url.getHost();
    }
}
