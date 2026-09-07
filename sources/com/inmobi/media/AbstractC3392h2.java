package com.inmobi.media;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.amazon.aps.ads.util.adview.ApsAdWebViewSupportClient;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.h2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractC3392h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3329a = 0;

    public static boolean a(Context context, String str) {
        if (str != null) {
            if (context == null) {
                Uri uri = Uri.parse(str);
                Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                return a(uri);
            }
            try {
                if (new Intent("android.intent.action.VIEW", Uri.parse(str)).resolveActivity(context.getPackageManager()) != null) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static final String b(Context context, Z6 z6, String str, String str2) {
        String stringExtra;
        if (AbstractC3420j2.a(str)) {
            Intrinsics.checkNotNull(str);
            return a(context, z6, str, (String) null);
        }
        try {
            Uri uri = Uri.parse(str2);
            try {
                stringExtra = Intent.parseUri(str2, 1).getStringExtra("browser_fallback_url");
            } catch (URISyntaxException unused) {
                Intrinsics.checkNotNullExpressionValue("h2", "TAG");
                stringExtra = null;
            }
            if (Intrinsics.areEqual(SDKConstants.PARAM_INTENT, uri.getScheme()) && AbstractC3420j2.a(stringExtra)) {
                String strDecode = URLDecoder.decode(stringExtra, "UTF-8");
                Intrinsics.checkNotNullExpressionValue(strDecode, "decode(...)");
                return a(context, z6, strDecode, (String) null);
            }
        } catch (Exception unused2) {
            Intrinsics.checkNotNullExpressionValue("h2", "TAG");
        }
        return null;
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.i);
        p0.startActivity(p1);
    }

    public static int a(Context context, String url, ResolveInfo resolveInfo, InterfaceC3386ga redirectionValidator, String api) throws URISyntaxException {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(redirectionValidator, "redirectionValidator");
        Intrinsics.checkNotNullParameter(api, "api");
        if (context == null) {
            return 7;
        }
        if (!redirectionValidator.d()) {
            redirectionValidator.a("EX_" + api);
            return 8;
        }
        Intent uri = Intent.parseUri(url, 3);
        Intrinsics.checkNotNullExpressionValue(uri, "parseUri(...)");
        if ((resolveInfo != null ? resolveInfo.activityInfo : null) != null) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if ((activityInfo != null ? activityInfo.packageName : null) != null) {
                if ((activityInfo != null ? activityInfo.name : null) != null) {
                    uri.setClassName(activityInfo.packageName, activityInfo.name);
                }
            }
        }
        uri.setFlags(268435456);
        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, uri);
        return 0;
    }

    public static ArrayList b(Context context, String url) throws URISyntaxException {
        Intrinsics.checkNotNullParameter(url, "url");
        ArrayList arrayList = new ArrayList();
        if (url.length() == 0 || context == null) {
            return arrayList;
        }
        Intent uri = Intent.parseUri(url, 3);
        Intrinsics.checkNotNullExpressionValue(uri, "parseUri(...)");
        List<ResolveInfo> listQueryIntentActivityOptions = context.getPackageManager().queryIntentActivityOptions((ComponentName) null, (Intent[]) null, uri, 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivityOptions, "queryIntentActivityOptions(...)");
        for (ResolveInfo resolveInfo : listQueryIntentActivityOptions) {
            if (resolveInfo.activityInfo.exported) {
                Intrinsics.checkNotNull(resolveInfo);
                arrayList.add(resolveInfo);
            }
        }
        return arrayList;
    }

    public static int a(Context context, String url, InterfaceC3386ga redirectionValidator, String api) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(redirectionValidator, "redirectionValidator");
        Intrinsics.checkNotNullParameter(api, "api");
        if (context == null) {
            return 7;
        }
        if (!redirectionValidator.d()) {
            redirectionValidator.a("EX_" + api);
            return 8;
        }
        String stringExtra = null;
        try {
            Intent uri = Intent.parseUri(url, 0);
            uri.setFlags(268435456);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, uri);
            return 0;
        } catch (ActivityNotFoundException e) {
            Uri uri2 = Uri.parse(url);
            try {
                stringExtra = Intent.parseUri(url, 1).getStringExtra("browser_fallback_url");
            } catch (URISyntaxException unused) {
                Intrinsics.checkNotNullExpressionValue("h2", "TAG");
            }
            if (Intrinsics.areEqual(SDKConstants.PARAM_INTENT, uri2.getScheme()) && stringExtra != null && stringExtra.length() != 0) {
                return a(context, stringExtra, redirectionValidator, api);
            }
            throw e;
        } catch (NullPointerException e2) {
            Uri uri3 = Uri.parse(url);
            try {
                stringExtra = Intent.parseUri(url, 1).getStringExtra("browser_fallback_url");
            } catch (URISyntaxException unused2) {
                Intrinsics.checkNotNullExpressionValue("h2", "TAG");
            }
            if (Intrinsics.areEqual(SDKConstants.PARAM_INTENT, uri3.getScheme()) && stringExtra != null && stringExtra.length() != 0) {
                return a(context, stringExtra, redirectionValidator, api);
            }
            throw e2;
        }
    }

    public static String a(Context context, Z6 redirectionValidator, String url, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(redirectionValidator, "redirectionValidator");
        Intrinsics.checkNotNullParameter("NATIVE", "api");
        if (context == null) {
            return null;
        }
        redirectionValidator.getClass();
        try {
            Intent uri = Intent.parseUri(url, 0);
            if (uri.resolveActivity(context.getPackageManager()) != null) {
                uri.setFlags(268435456);
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, uri);
            } else {
                Intrinsics.checkNotNullExpressionValue("h2", "TAG");
                url = b(context, redirectionValidator, str, url);
            }
            return url;
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("h2", "TAG");
            return b(context, redirectionValidator, str, url);
        }
    }

    public static boolean a(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("http", uri.getScheme()) || Intrinsics.areEqual("https", uri.getScheme());
    }

    public static boolean a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Uri uri = Uri.parse(url);
        Intrinsics.checkNotNull(uri);
        return (!a(uri) || Intrinsics.areEqual(POBCommonConstants.PLAY_STORE_DOMAIN, uri.getHost()) || Intrinsics.areEqual("market.android.com", uri.getHost()) || Intrinsics.areEqual(ApsAdWebViewSupportClient.MARKET_SCHEME, uri.getScheme())) ? false : true;
    }
}
