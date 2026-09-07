package io.appmetrica.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.webkit.WebView;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.impl.AbstractC4303n1;
import io.appmetrica.analytics.impl.C0;
import io.appmetrica.analytics.impl.C4278m1;
import io.appmetrica.analytics.plugins.AppMetricaPlugins;
import io.appmetrica.analytics.profile.UserProfile;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class AppMetrica {
    public static void activate(Context context, AppMetricaConfig appMetricaConfig) {
        AbstractC4303n1.f11678a.a(context, appMetricaConfig);
    }

    public static void activateReporter(Context context, ReporterConfig reporterConfig) {
        AbstractC4303n1.f11678a.a(context, reporterConfig);
    }

    public static void clearAppEnvironment() {
        AbstractC4303n1.f11678a.a();
    }

    public static void enableActivityAutoTracking(Application application) {
        AbstractC4303n1.f11678a.a(application);
    }

    public static String getDeviceId(Context context) {
        return AbstractC4303n1.f11678a.b();
    }

    public static int getLibraryApiLevel() {
        return 115;
    }

    public static String getLibraryVersion() {
        return "7.7.2";
    }

    public static AppMetricaPlugins getPluginExtension() {
        return C0.f11079a;
    }

    public static IReporter getReporter(Context context, String str) {
        return AbstractC4303n1.f11678a.a(context, str);
    }

    public static String getUuid(Context context) {
        return AbstractC4303n1.f11678a.a(context).id;
    }

    public static void initWebViewReporting(WebView webView) {
        AbstractC4303n1.f11678a.a(webView);
    }

    public static void pauseSession(Activity activity) {
        AbstractC4303n1.f11678a.a(activity);
    }

    public static void putAppEnvironmentValue(String str, String str2) {
        AbstractC4303n1.f11678a.a(str, str2);
    }

    public static void putErrorEnvironmentValue(String str, String str2) {
        AbstractC4303n1.f11678a.b(str, str2);
    }

    public static void registerAnrListener(AnrListener anrListener) {
        AbstractC4303n1.f11678a.a(anrListener);
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        AbstractC4303n1.f11678a.a(adRevenue);
    }

    public static void reportAnr(Map<Thread, StackTraceElement[]> map) {
        AbstractC4303n1.f11678a.a(map);
    }

    public static void reportAppOpen(Activity activity) {
        AbstractC4303n1.f11678a.b(activity);
    }

    public static void reportECommerce(ECommerceEvent eCommerceEvent) {
        AbstractC4303n1.f11678a.a(eCommerceEvent);
    }

    public static void reportError(String str, String str2) {
        AbstractC4303n1.f11678a.a(str, str2, (Throwable) null);
    }

    public static void reportEvent(String str) {
        AbstractC4303n1.f11678a.b(str);
    }

    public static void reportExternalAdRevenue(Object... objArr) {
        AbstractC4303n1.f11678a.b(objArr);
    }

    public static void reportExternalAttribution(ExternalAttribution externalAttribution) {
        AbstractC4303n1.f11678a.a(externalAttribution);
    }

    public static void reportReferralUrl(String str) {
        AbstractC4303n1.f11678a.d(str);
    }

    public static void reportRevenue(Revenue revenue) {
        AbstractC4303n1.f11678a.a(revenue);
    }

    public static void reportUnhandledException(Throwable th) {
        AbstractC4303n1.f11678a.a(th);
    }

    public static void reportUserProfile(UserProfile userProfile) {
        AbstractC4303n1.f11678a.a(userProfile);
    }

    public static void requestDeferredDeeplink(DeferredDeeplinkListener deferredDeeplinkListener) {
        AbstractC4303n1.f11678a.a(deferredDeeplinkListener);
    }

    public static void requestDeferredDeeplinkParameters(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        AbstractC4303n1.f11678a.a(deferredDeeplinkParametersListener);
    }

    public static void requestStartupParams(Context context, StartupParamsCallback startupParamsCallback, List<String> list) {
        C4278m1 c4278m1 = AbstractC4303n1.f11678a;
        if (list.isEmpty()) {
            list = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH);
        }
        c4278m1.a(context, startupParamsCallback, list);
    }

    public static void resumeSession(Activity activity) {
        AbstractC4303n1.f11678a.c(activity);
    }

    public static void sendEventsBuffer() {
        AbstractC4303n1.f11678a.f();
    }

    public static void setAdvIdentifiersTracking(boolean z) {
        AbstractC4303n1.f11678a.a(z);
    }

    public static void setDataSendingEnabled(boolean z) {
        AbstractC4303n1.f11678a.b(z);
    }

    public static void setLocation(Location location) {
        AbstractC4303n1.f11678a.a(location);
    }

    public static void setLocationTracking(boolean z) {
        AbstractC4303n1.f11678a.c(z);
    }

    public static void setUserProfileID(String str) {
        AbstractC4303n1.f11678a.e(str);
    }

    public static void reportAppOpen(Intent intent) {
        AbstractC4303n1.f11678a.a(intent);
    }

    public static void reportError(String str, String str2, Throwable th) {
        AbstractC4303n1.f11678a.a(str, str2, th);
    }

    public static void reportEvent(String str, String str2) {
        AbstractC4303n1.f11678a.c(str, str2);
    }

    public static void reportAppOpen(String str) {
        AbstractC4303n1.f11678a.a(str);
    }

    public static void reportError(String str, Throwable th) {
        AbstractC4303n1.f11678a.a(str, th);
    }

    public static void reportEvent(String str, Map<String, Object> map) {
        AbstractC4303n1.f11678a.a(str, map);
    }
}
