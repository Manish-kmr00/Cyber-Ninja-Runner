package net.pubnative.lite.sdk.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.amazon.aps.ads.util.adview.ApsAdWebViewSupportClient;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.events.RedirectEvent;
import java.util.Locale;

/* JADX INFO: loaded from: classes11.dex */
public class UrlHandler {
    private static final String TAG = "UrlHandler";
    private final IntentHandler mIntentHandler;

    public UrlHandler(Context context) {
        this.mIntentHandler = new IntentHandler(context);
    }

    public void handleUrl(String str, String str2) {
        if (str == null) {
            return;
        }
        Logger.d(TAG, "Handling url: " + str);
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String host = uri.getHost();
        String lowerCase = uri.toString().toLowerCase(Locale.ROOT);
        if (POBCommonConstants.PLAY_STORE_DOMAIN.equalsIgnoreCase(host) || "market.android.com".equalsIgnoreCase(host) || ApsAdWebViewSupportClient.MARKET_SCHEME.equalsIgnoreCase(scheme) || lowerCase.startsWith(POBCommonConstants.PLAY_STORE_DOMAIN) || lowerCase.startsWith("market.android.com/")) {
            this.mIntentHandler.handleDeepLink(uri);
            return;
        }
        if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
            if (str2 != null && str2.equalsIgnoreCase(RedirectEvent.i)) {
                this.mIntentHandler.handleBrowserLinkBrowserActivity(uri);
                return;
            } else {
                this.mIntentHandler.handleBrowserLink(uri);
                return;
            }
        }
        if (TextUtils.isEmpty(scheme)) {
            return;
        }
        this.mIntentHandler.handleDeepLink(uri);
    }
}
