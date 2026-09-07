package com.chartboost.sdk.internal.Networking;

import com.chartboost.sdk.impl.o9;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.net.URL;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0013R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\n*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/chartboost/sdk/internal/Networking/a;", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;", "endPoint", "", "host", "path", "", "setEndpoint", "(Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/net/URL;", "getEndPointUrl", "(Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;)Ljava/net/URL;", "restoreDefaults", "()V", "configEndpoint", "a", "(Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;Ljava/lang/String;)Ljava/net/URL;", "Lcom/chartboost/sdk/impl/o9;", "Lcom/chartboost/sdk/impl/o9;", "sdkConfiguration", "configUrl", "<init>", "(Lcom/chartboost/sdk/impl/o9;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public class a implements EndpointRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final o9 sdkConfiguration;

    /* JADX INFO: renamed from: com.chartboost.sdk.internal.Networking.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class C0267a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1214a;

        static {
            int[] iArr = new int[EndpointRepository.EndPoint.values().length];
            try {
                iArr[EndpointRepository.EndPoint.INTERSTITIAL_GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EndpointRepository.EndPoint.REWARDED_GET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EndpointRepository.EndPoint.PREFETCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f1214a = iArr;
        }
    }

    public a(o9 sdkConfiguration) {
        Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
        this.sdkConfiguration = sdkConfiguration;
    }

    public final URL a(EndpointRepository.EndPoint endPoint) {
        int i = C0267a.f1214a[endPoint.ordinal()];
        if (i == 1) {
            String str = String.format("webview/%s/interstitial/get", Arrays.copyOf(new Object[]{this.sdkConfiguration.x}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
            return a(endPoint, str);
        }
        if (i == 2) {
            String str2 = String.format("webview/%s/reward/get", Arrays.copyOf(new Object[]{this.sdkConfiguration.x}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(this, *args)");
            return a(endPoint, str2);
        }
        if (i != 3) {
            return null;
        }
        String str3 = this.sdkConfiguration.y;
        Intrinsics.checkNotNullExpressionValue(str3, "sdkConfiguration.webviewPrefetchEndpoint");
        return a(endPoint, str3);
    }

    @Override // com.chartboost.sdk.internal.Networking.EndpointRepository
    public URL getEndPointUrl(EndpointRepository.EndPoint endPoint) {
        Intrinsics.checkNotNullParameter(endPoint, "endPoint");
        URL urlA = a(endPoint);
        return urlA == null ? b.b(endPoint) : urlA;
    }

    @Override // com.chartboost.sdk.internal.Networking.EndpointRepository
    public void restoreDefaults() {
    }

    @Override // com.chartboost.sdk.internal.Networking.EndpointRepository
    public void setEndpoint(EndpointRepository.EndPoint endPoint, String host, String path) {
        Intrinsics.checkNotNullParameter(endPoint, "endPoint");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IllegalStateException("Cannot set endpoint".toString());
    }

    public final URL a(EndpointRepository.EndPoint endPoint, String str) {
        return new URL("https", b.a(endPoint), RemoteSettings.FORWARD_SLASH_STRING + str);
    }
}
