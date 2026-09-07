package com.inmobi.media;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.amazon.aps.ads.util.adview.ApsAdWebViewSupportClient;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class V0 {
    public static boolean a(Context context, String url, InterfaceC3386ga redirectionValidator, String api, L4 l4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(redirectionValidator, "redirectionValidator");
        Intrinsics.checkNotNullParameter(api, "api");
        if (l4 != null) {
            ((M4) l4).c("AppstoreLinkHandler", "In appStoreLinkHandled");
        }
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() != 0) {
            Uri uri = Uri.parse(url);
            if (Intrinsics.areEqual(ApsAdWebViewSupportClient.MARKET_SCHEME, uri.getScheme()) || Intrinsics.areEqual(POBCommonConstants.PLAY_STORE_DOMAIN, uri.getHost()) || Intrinsics.areEqual("market.android.com", uri.getHost())) {
                Uri uri2 = Uri.parse(url);
                if (context != null) {
                    try {
                        context.getPackageManager().getPackageInfo("com.android.vending", 0);
                        if (!redirectionValidator.d()) {
                            redirectionValidator.a("EX_" + api);
                            return false;
                        }
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW", uri2);
                            intent.setPackage("com.android.vending");
                            intent.addFlags(268435456);
                            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
                            if (l4 != null) {
                                ((M4) l4).c("AppstoreLinkHandler", "Playstore link handled successfully");
                            }
                            return true;
                        } catch (Exception e) {
                            if (l4 == null) {
                                return false;
                            }
                            ((M4) l4).c("AppstoreLinkHandler", ld.a(e, new StringBuilder("Error message in processing appStoreLinkHandling: ")));
                            return false;
                        }
                    } catch (PackageManager.NameNotFoundException e2) {
                        e2.printStackTrace();
                    }
                }
                int iA = AbstractC3337d3.a(context, url, redirectionValidator, api, l4);
                if (iA != 0 && iA != 1) {
                    return false;
                }
                if (l4 != null) {
                    ((M4) l4).c("AppstoreLinkHandler", "Playstore link handled successfully");
                }
                return true;
            }
        }
        return false;
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.i);
        p0.startActivity(p1);
    }
}
