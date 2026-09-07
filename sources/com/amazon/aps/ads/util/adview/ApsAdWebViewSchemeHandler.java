package com.amazon.aps.ads.util.adview;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.aps.ads.util.ApsAdExtensionsKt;
import com.amazon.aps.ads.util.ApsUtils;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ApsAdWebViewSchemeHandler.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0014J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/amazon/aps/ads/util/adview/ApsAdWebViewSchemeHandler;", "", "webviewClientListener", "Lcom/amazon/aps/ads/util/adview/ApsAdWebViewClientListener;", "(Lcom/amazon/aps/ads/util/adview/ApsAdWebViewClientListener;)V", "AMAZON_SCHEME", "", "MARKET_SCHEME", "MOBILE_SHOPPING_SCHEME", "MOBILE_SHOPPING_WEB_SCHEME", "MSHOP_PKG_NAME", "handleMarketAndAmazonScheme", "", "uri", "Landroid/net/Uri;", "handleMshopApp", "url", "handleMshopWeb", "launchIntent", "openUrl", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ApsAdWebViewSchemeHandler {
    private final String AMAZON_SCHEME;
    private final String MARKET_SCHEME;
    private final String MOBILE_SHOPPING_SCHEME;
    private final String MOBILE_SHOPPING_WEB_SCHEME;
    private final String MSHOP_PKG_NAME;
    private final ApsAdWebViewClientListener webviewClientListener;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.A);
        p0.startActivity(p1);
    }

    public ApsAdWebViewSchemeHandler(ApsAdWebViewClientListener webviewClientListener) {
        Intrinsics.checkNotNullParameter(webviewClientListener, "webviewClientListener");
        this.webviewClientListener = webviewClientListener;
        this.MSHOP_PKG_NAME = "com.amazon.mShop.android.shopping";
        this.MOBILE_SHOPPING_WEB_SCHEME = ApsAdWebViewSupportClient.MOBILE_SHOPPING_WEB_SCHEME;
        this.MOBILE_SHOPPING_SCHEME = ApsAdWebViewSupportClient.MOBILE_SHOPPING_SCHEME;
        this.MARKET_SCHEME = ApsAdWebViewSupportClient.MARKET_SCHEME;
        this.AMAZON_SCHEME = ApsAdWebViewSupportClient.AMAZON_SCHEME;
    }

    public final boolean openUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Uri uri = uri(url);
            if (uri != null && uri.getScheme() != null) {
                String scheme = uri.getScheme();
                if (Intrinsics.areEqual(scheme, this.MOBILE_SHOPPING_WEB_SCHEME)) {
                    return handleMshopWeb(url);
                }
                if (Intrinsics.areEqual(scheme, this.MOBILE_SHOPPING_SCHEME)) {
                    return handleMshopApp(url, uri);
                }
                return Intrinsics.areEqual(scheme, this.MARKET_SCHEME) ? true : Intrinsics.areEqual(scheme, this.AMAZON_SCHEME) ? handleMarketAndAmazonScheme(uri) : launchIntent(uri);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    protected Uri uri(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Uri uri = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(url)");
        return uri;
    }

    protected boolean handleMshopWeb(String url) {
        int i;
        Intrinsics.checkNotNullParameter(url, "url");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) url, "//", 0, false, 6, (Object) null);
        if (iIndexOf$default < 0 || (i = iIndexOf$default + 2) >= url.length()) {
            return false;
        }
        String strSubstring = url.substring(i);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.webviewClientListener.getAdViewContext(), new Intent("android.intent.action.VIEW", Uri.parse(Intrinsics.stringPlus("https://", strSubstring))));
        this.webviewClientListener.onAdLeftApplication();
        return true;
    }

    protected boolean handleMshopApp(String url, Uri uri) {
        int iIndexOf$default;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (this.webviewClientListener.getAdViewContext().getPackageManager().getLaunchIntentForPackage(this.MSHOP_PKG_NAME) == null && (iIndexOf$default = StringsKt.indexOf$default((CharSequence) url, "products/", 0, false, 6, (Object) null)) > 0) {
            String strSubstring = url.substring(iIndexOf$default + "products/".length());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            intent.setData(Uri.parse(Intrinsics.stringPlus("https://www.amazon.com/dp/", strSubstring)));
        }
        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.webviewClientListener.getAdViewContext(), intent);
        this.webviewClientListener.onAdLeftApplication();
        return true;
    }

    protected boolean handleMarketAndAmazonScheme(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.webviewClientListener.getAdViewContext(), intent);
                this.webviewClientListener.onAdLeftApplication();
                return true;
            } catch (ActivityNotFoundException unused) {
                ApsUtils.INSTANCE.directAppStoreLinkToBrowser(this.webviewClientListener.getAdViewContext(), uri);
                this.webviewClientListener.onAdLeftApplication();
                return true;
            }
        } catch (RuntimeException unused2) {
            ApsAdExtensionsKt.d(this, "App stores and browsers not found");
            return false;
        }
    }

    protected boolean launchIntent(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.webviewClientListener.getAdViewContext(), intent);
        this.webviewClientListener.onAdLeftApplication();
        return true;
    }
}
