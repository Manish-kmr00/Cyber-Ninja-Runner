package com.pubmatic.sdk.common.utility;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.URLUtil;
import com.pubmatic.sdk.common.log.POBLog;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes9.dex */
public class POBDeepLinkUtil {
    private static boolean a(Context context, Uri uri) {
        boolean z;
        if (triggerDeepLink(context, uri.toString(), false)) {
            POBLog.debug("PMDeepLinkUtil", "uri based deep link success!", "URL - " + uri);
            return true;
        }
        String[] strArrSplit = uri.toString().split(";");
        int length = strArrSplit.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            String strA = a(strArrSplit[i]);
            if (strA != null && triggerDeepLink(context, strA, false)) {
                POBLog.debug("PMDeepLinkUtil", "fallback based deep link success!", "Fallback URL - " + strA);
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            for (String str : strArrSplit) {
                String strB = b(str);
                if (strB != null && triggerDeepLink(context, strB, false)) {
                    POBLog.debug("PMDeepLinkUtil", "package based deep link success!", "Package URL - " + strB);
                    return true;
                }
            }
        }
        return z;
    }

    private static String b(String str) {
        try {
            if (str.contains("package")) {
                return "https://play.google.com/store/apps/details?id=" + str.split("=")[1];
            }
        } catch (Exception e) {
            POBLog.error("PMDeepLinkUtil", e.getLocalizedMessage(), new Object[0]);
        }
        return null;
    }

    public static void safedk_POBUtils_startActivity_77a045103a3f673fe5e6fdc8c1e6b82c(Context p0, Intent p1) throws Exception {
        Logger.d("SafeDK-Special|SafeDK: Call> Lcom/pubmatic/sdk/common/utility/POBUtils;->startActivity(Landroid/content/Context;Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.F);
        POBUtils.startActivity(p0, p1);
    }

    public static boolean triggerDeepLink(Context context, String str, boolean z) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            if (z) {
                intent.setPackage("com.android.vending");
            }
            intent.setData(Uri.parse(str));
            safedk_POBUtils_startActivity_77a045103a3f673fe5e6fdc8c1e6b82c(context, intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            POBLog.warn("PMDeepLinkUtil", "Activity not found for the uri: " + str, new Object[0]);
            return false;
        } catch (Exception e) {
            POBLog.warn("PMDeepLinkUtil", "Error while starting the activity for the uri: %s. Error: %s", str, e.getMessage());
            return false;
        }
    }

    public static boolean validateAndRedirect(Context context, String str) {
        if (str == null || context == null) {
            return false;
        }
        if (POBUtils.isValidPlayStoreUrl(str) || !URLUtil.isValidUrl(str)) {
            return a(context, Uri.parse(str));
        }
        return false;
    }

    private static String a(String str) {
        String str2 = null;
        try {
            if (!str.contains("browser_fallback_url")) {
                return null;
            }
            str2 = str.split("=")[1];
            POBLog.debug("PMDeepLinkUtil", "Fall back url :" + str2, new Object[0]);
            return str2;
        } catch (Exception e) {
            POBLog.error("PMDeepLinkUtil", e.getLocalizedMessage(), new Object[0]);
            return str2;
        }
    }
}
