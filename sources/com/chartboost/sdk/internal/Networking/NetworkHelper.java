package com.chartboost.sdk.internal.Networking;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.impl.b7;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.cc;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0003\u0010\bJ\u0015\u0010\u0003\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/chartboost/sdk/internal/Networking/NetworkHelper;", "", "", "a", "()Z", "", cc.r, "uri", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "urlString", "(Ljava/lang/String;)Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/net/URL;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Ljava/lang/String;)Ljava/net/URL;", "debugEndpoint", "Ljava/lang/String;", "isForceSDKToAcceptAllSSLCertsEnabled", "Z", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class NetworkHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NetworkHelper f1212a = new NetworkHelper();
    private static String debugEndpoint;
    private static boolean isForceSDKToAcceptAllSSLCertsEnabled;

    public final String a(String endpoint, String uri) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        String str = debugEndpoint;
        if (str != null && str.length() != 0) {
            b7.e("normalizedUrl: " + endpoint + " to: " + debugEndpoint, null);
            endpoint = debugEndpoint;
            Intrinsics.checkNotNull(endpoint);
        }
        if (uri == null || uri.length() == 0) {
            uri = "";
        } else if (!StringsKt.startsWith$default(uri, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null)) {
            uri = RemoteSettings.FORWARD_SLASH_STRING + uri;
        }
        return endpoint + uri;
    }

    public final String b(String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        URL urlC = c(urlString);
        String path = null;
        if (urlC != null) {
            try {
                path = urlC.getPath();
            } catch (Exception e) {
                b7.a("getPathFromUrl: " + urlString + " : " + e, null);
                path = "";
            }
        }
        return path == null ? "" : path;
    }

    public final URL c(String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        if (urlString.length() <= 0) {
            return null;
        }
        try {
            return new URL(urlString);
        } catch (Exception e) {
            b7.a("stringToURL: " + urlString + " : " + e, null);
            return null;
        }
    }

    public final String a(String urlString) {
        String str;
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        URL urlC = c(urlString);
        if (urlC == null) {
            return "";
        }
        try {
            str = urlC.getProtocol() + "://" + urlC.getHost();
        } catch (Exception e) {
            b7.a("getEndpointFromUrl: " + urlString + " : " + e, null);
            str = "";
        }
        return str == null ? "" : str;
    }

    @JvmStatic
    public static final boolean a() {
        return isForceSDKToAcceptAllSSLCertsEnabled;
    }
}
