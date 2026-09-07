package com.inmobi.media;

import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class T2 {
    /* JADX WARN: Code duplicated, block: B:19:0x0065  */
    /* JADX WARN: Code duplicated, block: B:27:0x007d  */
    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    public static void a(Context context, CustomTabsIntent customTabsIntent, Uri uri, O1 o1, Z5 z5, InterfaceC3386ga redirectionValidator, String api) {
        int iA;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customTabsIntent, "customTabsIntent");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(redirectionValidator, "redirectionValidator");
        Intrinsics.checkNotNullParameter(api, "api");
        String strA = Y2.a(context);
        try {
            try {
                if (strA == null) {
                    Intrinsics.checkNotNullExpressionValue("W2", "access$getLOG_TAG$cp(...)");
                    if (o1 != null) {
                        String string = uri.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        o1.a(string, api, z5);
                        return;
                    }
                    return;
                }
                customTabsIntent.intent.setFlags(268435456);
                customTabsIntent.intent.setPackage(strA);
                safedk_CustomTabsIntent_launchUrl_46a735ad316dd66561bc1347435a4f91(customTabsIntent, context, uri);
                if (z5 != null) {
                    z5.g = "IN_NATIVE";
                }
                if (o1 != null) {
                    o1.a(N5.LPStartSuccess, z5, (Integer) null);
                }
            } catch (Exception unused) {
                String string2 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                iA = AbstractC3392h2.a(context, string2, redirectionValidator, api);
                if (z5 != null) {
                    z5.g = "EX_NATIVE";
                }
                if (iA != 0) {
                }
                if (o1 != null) {
                    o1.a(N5.LPStartSuccess, z5, (Integer) null);
                }
            }
        } catch (Exception unused2) {
            iA = 9;
            if (z5 != null) {
                z5.g = "EX_NATIVE";
            }
            if (iA != 0 || iA == 1) {
                if (o1 != null) {
                    o1.a(N5.LPStartSuccess, z5, (Integer) null);
                }
            } else if (o1 != null) {
                o1.a(N5.LPBrowserOpenFailed, z5, Integer.valueOf(iA));
            }
        }
    }

    public static void safedk_CustomTabsIntent_launchUrl_46a735ad316dd66561bc1347435a4f91(CustomTabsIntent p0, Context p1, Uri p2) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroidx/browser/customtabs/CustomTabsIntent;->launchUrl(Landroid/content/Context;Landroid/net/Uri;)V");
        if (p2 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p2, com.safedk.android.utils.h.i);
        p0.launchUrl(p1, p2);
    }
}
