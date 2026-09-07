package com.yandex.mobile.ads.impl;

import com.vungle.ads.BuildConfig;
import com.vungle.ads.internal.Constants;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class iz0 {
    private static final String c = "com.yandex.mobile.ads.mediation";
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9272a;
    private final List<b> b;

    public iz0(String name, List<b> adapters) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(adapters, "adapters");
        this.f9272a = name;
        this.b = adapters;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof iz0)) {
            return false;
        }
        iz0 iz0Var = (iz0) obj;
        return Intrinsics.areEqual(this.f9272a, iz0Var.f9272a) && Intrinsics.areEqual(this.b, iz0Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f9272a.hashCode() * 31);
    }

    public final String toString() {
        return "MediationNetwork(name=" + this.f9272a + ", adapters=" + this.b + ")";
    }

    public final String c() {
        return this.f9272a;
    }

    public final List<b> b() {
        return this.b;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9273a;
        private final String b;

        public b(String format, String className) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(className, "className");
            this.f9273a = format;
            this.b = className;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.f9273a, bVar.f9273a) && Intrinsics.areEqual(this.b, bVar.b);
        }

        public final int hashCode() {
            return this.b.hashCode() + (this.f9273a.hashCode() * 31);
        }

        public final String toString() {
            return "MediationAdapterSignature(format=" + this.f9273a + ", className=" + this.b + ")";
        }

        public final String b() {
            return this.f9273a;
        }

        public final String a() {
            return this.b;
        }
    }

    public static final class a {
        public static List a() {
            return CollectionsKt.listOf((Object[]) new iz0[]{new iz0("AdColony", CollectionsKt.listOf((Object[]) new b[]{new b("Banner", a("banner", "AdColonyBannerAdapter")), new b("Interstitial", a("interstitial", "AdColonyInterstitialAdapter")), new b("Rewarded", a("rewarded", "AdColonyRewardedAdapter"))})), new iz0("AppLovin", CollectionsKt.listOf((Object[]) new b[]{new b("Banner", a("banner", "AppLovinBannerAdapter")), new b("Interstitial", a("interstitial", "AppLovinInterstitialAdapter")), new b("Rewarded", a("rewarded", "AppLovinRewardedAdapter"))})), new iz0("Appnext", CollectionsKt.listOf((Object[]) new b[]{new b("Banner", a("banner", "AppNextBannerAdapter")), new b("Interstitial", a("interstitial", "AppNextInterstitialAdapter")), new b("Native", a("nativeads", "AppNextNativeAdapter")), new b("Rewarded", a("rewarded", "AppNextRewardedAdapter"))})), new iz0("BigoAds", CollectionsKt.listOf((Object[]) new b[]{new b("Banner", a("banner", "BigoAdsBannerAdapter")), new b("Interstitial", a("interstitial", "BigoAdsInterstitialAdapter")), new b("Native", a("nativeads", "BigoAdsNativeAdapter")), new b("Rewarded", a("rewarded", "BigoAdsRewardedAdapter"))})), new iz0("Chartboost", CollectionsKt.listOf((Object[]) new b[]{new b("Banner", a("banner", "ChartboostBannerAdapter")), new b("Interstitial", a("interstitial", "ChartboostInterstitialAdapter")), new b("Rewarded", a("rewarded", "ChartboostRewardedAdapter"))})), new iz0("AdMob", CollectionsKt.listOf((Object[]) new b[]{new b("AppOpen", a(Constants.PLACEMENT_TYPE_APP_OPEN, "AdMobAppOpenAdAdapter")), new b("Banner", a("banner", "AdMobBannerAdapter")), new b("Interstitial", a("interstitial", "AdMobInterstitialAdapter")), new b("Native", a("nativeads", "AdMobNativeAdapter")), new b("Rewarded", a("rewarded", "AdMobRewardedAdapter"))})), new iz0("AdManager", CollectionsKt.listOf((Object[]) new b[]{new b("Banner", a("banner", "AdManagerBannerAdapter")), new b("Interstitial", a("interstitial", "AdManagerInterstitialAdapter")), new b("Native", a("nativeads", "AdManagerNativeAdapter")), new b("Rewarded", a("rewarded", "AdManagerRewardedAdapter"))})), new iz0("InMobi", CollectionsKt.listOf((Object[]) new b[]{new b("Banner", a("banner", "InMobiBannerAdapter")), new b("Interstitial", a("interstitial", "InMobiInterstitialAdapter")), new b("Rewarded", a("rewarded", "InMobiRewardedAdapter"))})), new iz0("IronSource", CollectionsKt.listOf((Object[]) new b[]{new b("Banner", a("banner", "IronSourceBannerAdapter")), new b("Interstitial", a("interstitial", "IronSourceInterstitialAdapter")), new b("Rewarded", a("rewarded", "IronSourceRewardedAdapter"))})), new iz0("Mintegral", CollectionsKt.listOf((Object[]) new b[]{new b("Banner", a("banner", "MintegralBannerAdapter")), new b("Interstitial", a("interstitial", "MintegralInterstitialAdapter")), new b("Native", a("nativeads", "MintegralNativeAdapter")), new b("Rewarded", a("rewarded", "MintegralRewardedAdapter"))})), new iz0("MyTarget", CollectionsKt.listOf((Object[]) new b[]{new b("Banner", a("banner", "MyTargetBannerAdapter")), new b("Interstitial", a("interstitial", "MyTargetInterstitialAdapter")), new b("Native", a("nativeads", "MyTargetNativeAdapter")), new b("Rewarded", a("rewarded", "MyTargetRewardedAdapter"))})), new iz0("Pangle", CollectionsKt.listOf((Object[]) new b[]{new b("Interstitial", a("interstitial", "PangleInterstitialAdapter")), new b("Rewarded", a("rewarded", "PangleRewardedAdapter"))})), new iz0("StartApp", CollectionsKt.listOf((Object[]) new b[]{new b("Banner", a("banner", "StartAppBannerAdapter")), new b("Interstitial", a("interstitial", "StartAppInterstitialAdapter")), new b("Native", a("nativeads", "StartAppNativeAdapter")), new b("Rewarded", a("rewarded", "StartAppRewardedAdapter"))})), new iz0("TapJoy", CollectionsKt.listOf((Object[]) new b[]{new b("Interstitial", a("interstitial", "TapJoyInterstitialAdapter")), new b("Rewarded", a("rewarded", "TapJoyRewardedAdapter"))})), new iz0("UnityAds", CollectionsKt.listOf((Object[]) new b[]{new b("Banner", a("banner", "UnityAdsBannerAdapter")), new b("Interstitial", a("interstitial", "UnityAdsInterstitialAdapter")), new b("Rewarded", a("rewarded", "UnityAdsRewardedAdapter"))})), new iz0(BuildConfig.OMSDK_PARTNER_NAME, CollectionsKt.listOf((Object[]) new b[]{new b("Banner", a("banner", "VungleBannerAdapter")), new b("Interstitial", a("interstitial", "VungleInterstitialAdapter")), new b("Rewarded", a("rewarded", "VungleRewardedAdapter"))}))});
        }

        private static String a(String str, String str2) {
            return iz0.c + "." + str + "." + str2;
        }
    }
}
