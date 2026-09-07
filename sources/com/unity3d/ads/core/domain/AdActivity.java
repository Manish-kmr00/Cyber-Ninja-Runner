package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.FullScreenWebViewDisplay;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'UNITY_ADS_FULLSCREEN_ACTIVITY' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: AndroidGetIsAdActivity.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/unity3d/ads/core/domain/AdActivity;", "", "activityName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getActivityName", "()Ljava/lang/String;", "GOOGLE_ADS_ACTIVITY", "FACEBOOK_ADS_ACTIVITY", "APPLOVIN_ADS_ACTIVITY", "APPLOVIN_INTERSTITIAL_ACTIVITY", "APPLOVIN_INTERSTITIAL_ORIENTATION_AWARE_ACTIVITY", "IRONSOURCE_ADS_ACTIVITY", "IRONSOURCE_INTERSTITIAL_ACTIVITY", "UNITY_ADS_FULLSCREEN_ACTIVITY", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AdActivity {
    private static final /* synthetic */ AdActivity[] $VALUES;
    public static final AdActivity UNITY_ADS_FULLSCREEN_ACTIVITY;
    private final String activityName;
    public static final AdActivity GOOGLE_ADS_ACTIVITY = new AdActivity("GOOGLE_ADS_ACTIVITY", 0, com.google.android.gms.ads.AdActivity.CLASS_NAME);
    public static final AdActivity FACEBOOK_ADS_ACTIVITY = new AdActivity("FACEBOOK_ADS_ACTIVITY", 1, "com.facebook.ads.AudienceNetworkActivity");
    public static final AdActivity APPLOVIN_ADS_ACTIVITY = new AdActivity("APPLOVIN_ADS_ACTIVITY", 2, "com.applovin.adview.AppLovinFullscreenThemedActivity");
    public static final AdActivity APPLOVIN_INTERSTITIAL_ACTIVITY = new AdActivity("APPLOVIN_INTERSTITIAL_ACTIVITY", 3, "com.applovin.adview.AppLovinFullscreenActivity");
    public static final AdActivity APPLOVIN_INTERSTITIAL_ORIENTATION_AWARE_ACTIVITY = new AdActivity("APPLOVIN_INTERSTITIAL_ORIENTATION_AWARE_ACTIVITY", 4, "com.applovin.impl.adview.AppLovinOrientationAwareInterstitialActivity");
    public static final AdActivity IRONSOURCE_ADS_ACTIVITY = new AdActivity("IRONSOURCE_ADS_ACTIVITY", 5, "com.ironsource.sdk.controller.ControllerActivity");
    public static final AdActivity IRONSOURCE_INTERSTITIAL_ACTIVITY = new AdActivity("IRONSOURCE_INTERSTITIAL_ACTIVITY", 6, "com.ironsource.sdk.controller.InterstitialActivity");

    private static final /* synthetic */ AdActivity[] $values() {
        return new AdActivity[]{GOOGLE_ADS_ACTIVITY, FACEBOOK_ADS_ACTIVITY, APPLOVIN_ADS_ACTIVITY, APPLOVIN_INTERSTITIAL_ACTIVITY, APPLOVIN_INTERSTITIAL_ORIENTATION_AWARE_ACTIVITY, IRONSOURCE_ADS_ACTIVITY, IRONSOURCE_INTERSTITIAL_ACTIVITY, UNITY_ADS_FULLSCREEN_ACTIVITY};
    }

    public static AdActivity valueOf(String str) {
        return (AdActivity) Enum.valueOf(AdActivity.class, str);
    }

    public static AdActivity[] values() {
        return (AdActivity[]) $VALUES.clone();
    }

    private AdActivity(String str, int i, String str2) {
        super(str, i);
        this.activityName = str2;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    static {
        String qualifiedName = Reflection.getOrCreateKotlinClass(FullScreenWebViewDisplay.class).getQualifiedName();
        UNITY_ADS_FULLSCREEN_ACTIVITY = new AdActivity("UNITY_ADS_FULLSCREEN_ACTIVITY", 7, qualifiedName == null ? "FullScreenWebViewDisplay" : qualifiedName);
        $VALUES = $values();
    }
}
