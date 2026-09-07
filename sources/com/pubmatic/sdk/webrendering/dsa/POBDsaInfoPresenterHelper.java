package com.pubmatic.sdk.webrendering.dsa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebSettings;
import com.json.m5;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.cache.POBAdViewCacheService;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.models.POBDSATransparencyInfo;
import com.pubmatic.sdk.common.ui.POBFullScreenActivityListener;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.common.view.POBWebView;
import com.pubmatic.sdk.webrendering.ui.POBFullScreenActivity;
import com.pubmatic.sdk.webrendering.ui.POBMraidViewContainer;
import com.pubmatic.sdk.webrendering.ui.POBMraidViewContainerListener;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.internal.partials.PubMaticNetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/pubmatic/sdk/webrendering/dsa/POBDsaInfoPresenterHelper;", "", "<init>", "()V", "Landroid/content/Context;", "mContext", "Lcom/pubmatic/sdk/common/base/POBAdDescriptor;", "mDescriptor", "", "webPageData", "", m5.v, "(Landroid/content/Context;Lcom/pubmatic/sdk/common/base/POBAdDescriptor;Ljava/lang/String;)V", "context", "url", "data", "Lcom/pubmatic/sdk/common/view/POBWebView;", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/pubmatic/sdk/common/view/POBWebView;", "webrendering_release"}, k = 1, mv = {1, 7, 1})
public final class POBDsaInfoPresenterHelper {
    public static final POBDsaInfoPresenterHelper INSTANCE = new POBDsaInfoPresenterHelper();

    private POBDsaInfoPresenterHelper() {
    }

    private final POBWebView a(Context context, String url, String data) {
        POBWebView pOBWebViewCreateInstance = POBWebView.createInstance(POBUtils.resolveWebViewContext(context));
        if (pOBWebViewCreateInstance != null) {
            WebSettings settings = pOBWebViewCreateInstance.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
            settings.setJavaScriptEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setDomStorageEnabled(true);
            PubMaticNetworkBridge.webviewLoadDataWithBaseURL(pOBWebViewCreateInstance, url, data, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
        }
        return pOBWebViewCreateInstance;
    }

    public static void safedk_POBFullScreenActivity_startActivity_9b43eeb3a2c956a47043e4be8e9dab59(Context p0, Intent p1) throws Exception {
        Logger.d("SafeDK-Special|SafeDK: Call> Lcom/pubmatic/sdk/webrendering/ui/POBFullScreenActivity;->startActivity(Landroid/content/Context;Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.F);
        POBFullScreenActivity.startActivity(p0, p1);
    }

    @JvmStatic
    public static final void show(final Context mContext, POBAdDescriptor mDescriptor, String webPageData) throws UnsupportedEncodingException {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(webPageData, "webPageData");
        if (mDescriptor != null) {
            String strEncode = URLEncoder.encode(mDescriptor.getDisplayedOnBehalfOf(), "UTF-8");
            String strEncode2 = URLEncoder.encode(mDescriptor.getPaidBy(), "UTF-8");
            List<POBDSATransparencyInfo> transparencyData = mDescriptor.getTransparencyData();
            POBLog.debug("POBDsaInfoUtil", "DSA Icon clicked: Advertiser: %s Paid By: %s Transparency: %s", strEncode, strEncode2, transparencyData);
            String strEncode3 = transparencyData != null ? URLEncoder.encode(POBDSATransparencyInfo.INSTANCE.getCombinedListOfParams(transparencyData), "UTF-8") : "";
            POBLog.debug("POBDsaInfoUtil", "Combined Params: %s", strEncode3);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(POBCommonConstants.DSA_INFO_BASE_URL, Arrays.copyOf(new Object[]{strEncode, strEncode2, strEncode3}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            final POBWebView pOBWebViewA = INSTANCE.a(mContext, str, webPageData);
            final int iHashCode = pOBWebViewA != null ? pOBWebViewA.hashCode() : 0;
            if (pOBWebViewA != null) {
                POBMraidViewContainer pOBMraidViewContainer = new POBMraidViewContainer(mContext, pOBWebViewA, false, true);
                pOBMraidViewContainer.setMraidViewContainerListener(new POBMraidViewContainerListener() { // from class: com.pubmatic.sdk.webrendering.dsa.POBDsaInfoPresenterHelper.show.1
                    @Override // com.pubmatic.sdk.webrendering.ui.POBMraidViewContainerListener
                    public void onClose() {
                        POBFullScreenActivity.closeActivity(mContext, iHashCode);
                    }

                    @Override // com.pubmatic.sdk.webrendering.ui.POBMraidViewContainerListener
                    public void onForward() {
                    }
                });
                POBInstanceProvider.getAdViewCacheService().storeAdView(Integer.valueOf(iHashCode), new POBAdViewCacheService.AdViewConfig(pOBMraidViewContainer, new POBFullScreenActivityListener() { // from class: com.pubmatic.sdk.webrendering.dsa.POBDsaInfoPresenterHelper.show.2
                    @Override // com.pubmatic.sdk.common.ui.POBFullScreenActivityListener
                    public void onCreate(Activity context) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        pOBWebViewA.setBaseContext(context);
                    }

                    @Override // com.pubmatic.sdk.common.ui.POBFullScreenActivityListener
                    public void onDestroy() {
                        pOBWebViewA.setBaseContext(mContext);
                    }
                }));
                Intent intent = new Intent();
                intent.putExtra(POBFullScreenActivity.RENDERER_IDENTIFIER, iHashCode);
                try {
                    safedk_POBFullScreenActivity_startActivity_9b43eeb3a2c956a47043e4be8e9dab59(mContext, intent);
                } catch (Exception e) {
                    POBLog.error("POBDsaInfoUtil", "Error while starting full screen activity for DSA detail screen. Error: %s", e.getMessage());
                }
            }
        }
    }
}
