package com.amazon.aps.ads.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.amazon.aps.ads.Aps;
import com.amazon.aps.ads.ApsLog;
import com.amazon.aps.ads.util.adview.ApsAdWebViewSupportClient;
import com.amazon.aps.shared.ApsMetrics;
import com.amazon.aps.shared.metrics.model.ApsMetricsDeviceInfo;
import com.amazon.aps.shared.metrics.model.ApsMetricsSdkInfo;
import com.amazon.device.ads.DtbCommonUtils;
import com.amazon.device.ads.DtbDeviceData;
import com.amazon.device.ads.DtbDeviceDataRetriever;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ApsUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/amazon/aps/ads/util/ApsUtils;", "", "()V", "Companion", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ApsUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ApsUtils";
    private static final String AMAZON_SCHEME = ApsAdWebViewSupportClient.AMAZON_SCHEME;
    private static final String AMAZON_APP_STORE_LINK = ApsAdWebViewSupportClient.AMAZON_APP_STORE_LINK;
    private static final String GOOGLE_PLAY_STORE_LINK = ApsAdWebViewSupportClient.GOOGLE_PLAY_STORE_LINK;

    /* JADX INFO: compiled from: ApsUtils.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0016\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/amazon/aps/ads/util/ApsUtils$Companion;", "", "()V", "AMAZON_APP_STORE_LINK", "", "getAMAZON_APP_STORE_LINK", "()Ljava/lang/String;", "AMAZON_SCHEME", "getAMAZON_SCHEME", "GOOGLE_PLAY_STORE_LINK", "getGOOGLE_PLAY_STORE_LINK", "TAG", "getTAG", "directAppStoreLinkToBrowser", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "isNullOrEmpty", "", "s", "setupMetrics", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
            Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
            if (p1 == null) {
                return;
            }
            BrandSafetyUtils.detectAdClick(p1, h.A);
            p0.startActivity(p1);
        }

        private Companion() {
        }

        public final String getTAG() {
            return ApsUtils.TAG;
        }

        public final String getAMAZON_SCHEME() {
            return ApsUtils.AMAZON_SCHEME;
        }

        public final String getAMAZON_APP_STORE_LINK() {
            return ApsUtils.AMAZON_APP_STORE_LINK;
        }

        public final String getGOOGLE_PLAY_STORE_LINK() {
            return ApsUtils.GOOGLE_PLAY_STORE_LINK;
        }

        public final void setupMetrics(Context context) {
            if (context == null) {
                return;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ApsMetrics.INSTANCE.init(context, new ApsMetricsDeviceInfo(DtbCommonUtils.getSDKFramework(), DtbDeviceDataRetriever.getScreenSize(displayMetrics, "portrait"), DtbDeviceDataRetriever.isTablet() ? "tablet" : "phone", DtbDeviceData.getConnectionType(), null, 16, null), new ApsMetricsSdkInfo(Aps.getSdkVersion()));
        }

        public final void directAppStoreLinkToBrowser(Context context, Uri uri) throws ActivityNotFoundException, NullPointerException {
            String strStringPlus;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            if (Intrinsics.areEqual(getAMAZON_SCHEME(), uri.getScheme())) {
                ApsLog.d(getTAG(), "Amazon app store unavailable in the device");
                strStringPlus = Intrinsics.stringPlus(getAMAZON_APP_STORE_LINK(), uri.getQuery());
            } else {
                ApsLog.d(getTAG(), "App store unavailable in the device");
                strStringPlus = getGOOGLE_PLAY_STORE_LINK() + ((Object) uri.getHost()) + '?' + ((Object) uri.getQuery());
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(strStringPlus));
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
        }

        public final boolean isNullOrEmpty(String s) {
            return StringsKt.equals$default(s, null, false, 2, null) || StringsKt.equals$default(s, "", false, 2, null);
        }
    }

    private ApsUtils() {
    }
}
