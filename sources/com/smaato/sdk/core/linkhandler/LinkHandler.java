package com.smaato.sdk.core.linkhandler;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.amazon.aps.ads.util.adview.ApsAdWebViewSupportClient;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity;
import com.smaato.sdk.core.network.HttpClient;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.Either;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes13.dex */
public class LinkHandler {
    public static final int MAX_REDIRECTS = 16;
    public static final String SMAATO_FORCE_BROWSER_PARAM = "SMAATO_OPEN_BROWSER";
    private final ActivityQueries activityQueries;
    private final Application application;
    private final HttpClient httpClient;
    private final IntentLauncher intentLauncher;
    private final SimpleHttpClient simpleHttpClient;

    public LinkHandler(Application application, HttpClient httpClient, SimpleHttpClient simpleHttpClient, IntentLauncher intentLauncher, ActivityQueries activityQueries) {
        this.application = application;
        this.intentLauncher = intentLauncher;
        HttpClient.Builder builderBuildUpon = httpClient.buildUpon();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.httpClient = builderBuildUpon.connectTimeout(5000L, timeUnit).readTimeout(5000L, timeUnit).build();
        this.simpleHttpClient = simpleHttpClient;
        this.activityQueries = activityQueries;
    }

    public boolean launchAsUncheckedIntent(String str) {
        try {
            return this.intentLauncher.launch(createUncheckedIntentForUrl(str));
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: handleUrlOnBackGround, reason: merged with bridge method [inline-methods] */
    public void m5551x29a88085(final String str, final Runnable runnable, final Runnable runnable2) {
        if (!Threads.isMainThread()) {
            if (!TextUtils.isEmpty(str) && handleUrl(str)) {
                Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.core.linkhandler.LinkHandler$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Objects.onNotNull(runnable, new LinkHandler$$ExternalSyntheticLambda4());
                    }
                });
                return;
            } else {
                Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.core.linkhandler.LinkHandler$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Objects.onNotNull(runnable2, new LinkHandler$$ExternalSyntheticLambda4());
                    }
                });
                return;
            }
        }
        Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.core.linkhandler.LinkHandler$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5551x29a88085(str, runnable, runnable2);
            }
        });
    }

    private boolean handleUrl(String str) {
        if (str.startsWith(SmaDeepLink.SMAATO_DEEPLINK_SCHEME)) {
            try {
                SmaDeepLink smaDeepLink = new SmaDeepLink(str);
                if (launchUrl(smaDeepLink.primaryUrl)) {
                    return fireTrackingUrls(smaDeepLink.primaryTrackerUrls);
                }
                if (launchUrl(smaDeepLink.fallbackUrl)) {
                    return fireTrackingUrls(smaDeepLink.fallbackTrackerUrls);
                }
                return false;
            } catch (Exception unused) {
            }
        } else {
            return launchUrl(str);
        }
    }

    private boolean launchUrl(String str) {
        if ((URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) && isForceNativeBrowserEnabled(str)) {
            return startInBrowser(str);
        }
        if (isApiLevel30Plus()) {
            boolean zTryToStartAsAppLink = tryToStartAsAppLink(str, true);
            return !zTryToStartAsAppLink ? handleFailedUrl(str) : zTryToStartAsAppLink;
        }
        try {
            if (this.intentLauncher.launch(resolveExternalAppUrl(str))) {
                return true;
            }
        } catch (Exception unused) {
        }
        if (!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) {
            return false;
        }
        try {
            return this.intentLauncher.launch(resolveRedirectUrlAndCreateIntent(str));
        } catch (Exception e) {
            Log.e("LinkHandler", "intent launcher resolver exception", e);
        }
    }

    private boolean tryToStartAsAppLink(String str, boolean z) {
        Intent intentCreateUncheckedIntentForUrl = createUncheckedIntentForUrl(str);
        if (z) {
            intentCreateUncheckedIntentForUrl.addFlags(1024);
        }
        return this.intentLauncher.launch(intentCreateUncheckedIntentForUrl);
    }

    private boolean handleFailedUrl(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            return resolveRedirectAndStartAsAppLink(str);
        }
        if (isIntentUrl(str)) {
            return this.intentLauncher.launch(createIntentForFallback(str));
        }
        return false;
    }

    private boolean resolveRedirectAndStartAsAppLink(String str) {
        try {
            ResolvedRedirection resolvedRedirection = new ResolvedRedirection(str);
            if (!URLUtil.isHttpUrl(resolvedRedirection.url) && !URLUtil.isHttpsUrl(resolvedRedirection.url)) {
                return tryToStartAsAppLink(resolvedRedirection.url, false);
            }
            return startInBrowser(resolvedRedirection.url);
        } catch (Exception unused) {
            return false;
        }
    }

    private Intent resolveRedirectUrlAndCreateIntent(String str) {
        ResolvedRedirection resolvedRedirection = new ResolvedRedirection(str);
        if (URLUtil.isHttpUrl(resolvedRedirection.url) || URLUtil.isHttpsUrl(resolvedRedirection.url)) {
            return createBrowserIntent(resolvedRedirection.url);
        }
        try {
            return resolveExternalAppUrl(resolvedRedirection.url);
        } catch (Exception unused) {
            return createBrowserIntent(resolvedRedirection.url);
        }
    }

    private Intent resolveExternalAppUrl(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            return createCheckedAppLinkIntent(str);
        }
        if (str.length() >= 6 && SDKConstants.PARAM_INTENT.equalsIgnoreCase(str.substring(0, 6))) {
            return createExternalAppIntent(str);
        }
        return createViewIntent(str);
    }

    private Intent createUncheckedIntentForUrl(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            return new Intent("android.intent.action.VIEW", Uri.parse(str)).addCategory("android.intent.category.BROWSABLE").addCategory("android.intent.category.DEFAULT");
        }
        if (isIntentUrl(str)) {
            return createUncheckedExternalAppIntent(str);
        }
        return createViewIntent(str);
    }

    public Either<Intent, String> findExternalAppForUrl(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            return Either.right(str);
        }
        if (isIntentUrl(str)) {
            try {
                return Either.left(createUncheckedExternalAppIntent(str));
            } catch (Exception unused) {
                return Either.right(str);
            }
        }
        return Either.left(createViewIntent(str));
    }

    private Intent createCheckedAppLinkIntent(String str) {
        Set<String> setQueryTargetActivityNames = this.activityQueries.queryTargetActivityNames("https://");
        Set<String> setQueryTargetActivityNames2 = this.activityQueries.queryTargetActivityNames(str);
        setQueryTargetActivityNames2.removeAll(setQueryTargetActivityNames);
        if (setQueryTargetActivityNames2.isEmpty()) {
            throw new IllegalArgumentException("No app supports " + str);
        }
        return new Intent("android.intent.action.VIEW", Uri.parse(str)).addCategory("android.intent.category.BROWSABLE").addCategory("android.intent.category.DEFAULT").addFlags(268435456);
    }

    private Intent createExternalAppIntent(String str) {
        return createExternalAppIntent(str, false);
    }

    private Intent createUncheckedExternalAppIntent(String str) {
        return createExternalAppIntent(str, true);
    }

    private Intent createExternalAppIntent(String str, boolean z) {
        try {
            Intent uri = Intent.parseUri(str, 1);
            if (!z && !this.activityQueries.canBeLaunched(uri)) {
                return createIntentForFallback(str);
            }
            return uri;
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Intent createIntentForFallback(String str) {
        try {
            Intent uri = Intent.parseUri(str, 1);
            String stringExtra = uri.getStringExtra("browser_fallback_url");
            if (!TextUtils.isEmpty(stringExtra)) {
                return createBrowserIntent(stringExtra);
            }
            String stringExtra2 = uri.getStringExtra("package");
            if (!TextUtils.isEmpty(stringExtra2)) {
                return createMarketIntent(stringExtra2);
            }
            throw new IllegalArgumentException("No such app supports " + str);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Intent createMarketIntent(String str) {
        return new Intent("android.intent.action.VIEW", new Uri.Builder().scheme(ApsAdWebViewSupportClient.MARKET_SCHEME).authority("details").appendQueryParameter("id", str).build());
    }

    private boolean startInBrowser(String str) {
        return this.intentLauncher.launch(createBrowserIntent(str));
    }

    private Intent createBrowserIntent(String str) {
        Intent intentCreateExternalBrowserIntent = createExternalBrowserIntent(str);
        return intentCreateExternalBrowserIntent != null ? intentCreateExternalBrowserIntent : createInternalBrowserIntent(str);
    }

    private Intent createInternalBrowserIntent(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            return SmaatoSdkBrowserActivity.createIntent(this.application, str);
        }
        throw new IllegalArgumentException("Not browsable url " + str);
    }

    private Intent createExternalBrowserIntent(String str) {
        Intent intentAddCategory = new Intent("android.intent.action.VIEW", Uri.parse(str)).addCategory("android.intent.category.BROWSABLE");
        Intent intent = new Intent(intentAddCategory);
        intent.setPackage("com.android.chrome");
        if (this.activityQueries.canBeLaunched(intent)) {
            return intent;
        }
        if (this.activityQueries.canBeLaunched(intentAddCategory)) {
            return intentAddCategory;
        }
        return null;
    }

    private Intent createViewIntent(String str) {
        return new Intent("android.intent.action.VIEW", Uri.parse(str));
    }

    private boolean isIntentUrl(String str) {
        return str.length() >= 6 && SDKConstants.PARAM_INTENT.equalsIgnoreCase(str.substring(0, 6));
    }

    private boolean fireTrackingUrls(final List list) {
        try {
            Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.core.linkhandler.LinkHandler$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5550xd6c5c5d(list);
                }
            });
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: lambda$fireTrackingUrls$3$com-smaato-sdk-core-linkhandler-LinkHandler, reason: not valid java name */
    /* synthetic */ void m5550xd6c5c5d(List list) {
        this.simpleHttpClient.fireAndForget(list);
    }

    public static boolean isApiLevel30Plus() {
        return Build.VERSION.SDK_INT >= 30;
    }

    private boolean isForceNativeBrowserEnabled(String str) {
        return str.contains(SMAATO_FORCE_BROWSER_PARAM);
    }
}
