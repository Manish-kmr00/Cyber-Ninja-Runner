package com.inmobi.media;

import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$MediationConfig;
import java.io.Serializable;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.lc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3460lc implements Serializable {
    private static final int APPLOVIN_AB_DEFAULT_AUDIO_LOAD_TIMEOUT = 9500;
    private static final int APPLOVIN_AB_DEFAULT_AUDIO_MAX_RETRIES = 3;
    private static final int APPLOVIN_AB_DEFAULT_AUDIO_RETRY_INTERVAL = 1000;
    private static final int APPLOVIN_AB_DEFAULT_BANNER_LOAD_TIMEOUT = 9500;
    private static final int APPLOVIN_AB_DEFAULT_BANNER_MAX_RETRIES = 3;
    private static final int APPLOVIN_AB_DEFAULT_BANNER_RETRY_INTERVAL = 1000;
    private static final int APPLOVIN_AB_DEFAULT_INTERSTITIAL_LOAD_TIMEOUT = 29500;
    private static final int APPLOVIN_AB_DEFAULT_INTERSTITIAL_MAX_RETRIES = 3;
    private static final int APPLOVIN_AB_DEFAULT_INTERSTITIAL_RETRY_INTERVAL = 1000;
    private static final int APPLOVIN_AB_DEFAULT_NATIVE_LOAD_TIMEOUT = 14500;
    private static final int APPLOVIN_AB_DEFAULT_NATIVE_MAX_RETRIES = 3;
    private static final int APPLOVIN_AB_DEFAULT_NATIVE_RETRY_INTERVAL = 1000;
    private static final int APPLOVIN_NONAB_DEFAULT_AUDIO_LOAD_TIMEOUT = 9500;
    private static final int APPLOVIN_NONAB_DEFAULT_AUDIO_MAX_RETRIES = 3;
    private static final int APPLOVIN_NONAB_DEFAULT_AUDIO_MUTT_TIMEOUT = 9500;
    private static final int APPLOVIN_NONAB_DEFAULT_AUDIO_RETRY_INTERVAL = 1000;
    private static final int APPLOVIN_NONAB_DEFAULT_BANNER_LOAD_TIMEOUT = 9500;
    private static final int APPLOVIN_NONAB_DEFAULT_BANNER_MAX_RETRIES = 3;
    private static final int APPLOVIN_NONAB_DEFAULT_BANNER_MUTT_TIMEOUT = 9500;
    private static final int APPLOVIN_NONAB_DEFAULT_BANNER_RETRY_INTERVAL = 1000;
    private static final int APPLOVIN_NONAB_DEFAULT_INTERSTITIAL_LOAD_TIMEOUT = 14500;
    private static final int APPLOVIN_NONAB_DEFAULT_INTERSTITIAL_MAX_RETRIES = 3;
    private static final int APPLOVIN_NONAB_DEFAULT_INTERSTITIAL_MUTT_TIMEOUT = 14500;
    private static final int APPLOVIN_NONAB_DEFAULT_INTERSTITIAL_RETRY_INTERVAL = 1000;
    private static final int APPLOVIN_NONAB_DEFAULT_NATIVE_LOAD_TIMEOUT = 14500;
    private static final int APPLOVIN_NONAB_DEFAULT_NATIVE_MAX_RETRIES = 3;
    private static final int APPLOVIN_NONAB_DEFAULT_NATIVE_MUTT_TIMEOUT = 14500;
    private static final int APPLOVIN_NONAB_DEFAULT_NATIVE_RETRY_INTERVAL = 1000;
    private static final int DEFAULT_AB_AUDIO_LOAD_TIMEOUT = 14500;
    private static final int DEFAULT_AB_BANNER_LOAD_TIMEOUT = 14500;
    private static final int DEFAULT_AB_INTERSTITIAL_LOAD_TIMEOUT = 29500;
    private static final int DEFAULT_AB_NATIVE_LOAD_TIMEOUT = 14500;
    private static final String DEFAULT_KEY = "default";
    private static final int DEFAULT_MAX_RETRIES = 3;
    private static final int DEFAULT_NONAB_AUDIO_LOAD_TIMEOUT = 29500;
    private static final int DEFAULT_NONAB_AUDIO_MUTT_TIMEOUT = 29500;
    private static final int DEFAULT_NONAB_BANNER_LOAD_TIMEOUT = 29500;
    private static final int DEFAULT_NONAB_BANNER_MUTT_TIMEOUT = 29500;
    private static final int DEFAULT_NONAB_INTERSTITIAL_LOAD_TIMEOUT = 29500;
    private static final int DEFAULT_NONAB_INTERSTITIAL_MUTT_TIMEOUT = 29500;
    private static final int DEFAULT_NONAB_NATIVE_LOAD_TIMEOUT = 29500;
    private static final int DEFAULT_NONAB_NATIVE_MUTT_TIMEOUT = 29500;
    private static final int DEFAULT_RETRY_INTERVAL = 1000;
    public static final int DEFAULT_TIMEOUT = 15000;
    public static final C3430jc Companion = new C3430jc();
    private static final String APPLOVIN_KEY = "c_applovin";
    private static final JSONObject defaultNonABBannerloadTimeout = AbstractC3402hc.a("default", 29500, APPLOVIN_KEY, 9500);
    private static final JSONObject defaultNonABBannerMuttTimeout = AbstractC3402hc.a("default", 29500, APPLOVIN_KEY, 9500);
    private static final JSONObject defaultNonABBannerMaxRetries = AbstractC3402hc.a("default", 3, APPLOVIN_KEY, 3);
    private static final JSONObject defaultNonABBannerRetryInterval = AbstractC3402hc.a("default", 1000, APPLOVIN_KEY, 1000);
    private static final JSONObject defaultNonABIntloadTimeout = AbstractC3402hc.a("default", 29500, APPLOVIN_KEY, 14500);
    private static final JSONObject defaultNonABIntMuttTimeout = AbstractC3402hc.a("default", 29500, APPLOVIN_KEY, 14500);
    private static final JSONObject defaultNonABIntMaxRetries = AbstractC3402hc.a("default", 3, APPLOVIN_KEY, 3);
    private static final JSONObject defaultNonABIntRetryInterval = AbstractC3402hc.a("default", 1000, APPLOVIN_KEY, 1000);
    private static final JSONObject defaultNonABNativeloadTimeout = AbstractC3402hc.a("default", 29500, APPLOVIN_KEY, 14500);
    private static final JSONObject defaultNonABNativeMuttTimeout = AbstractC3402hc.a("default", 29500, APPLOVIN_KEY, 14500);
    private static final JSONObject defaultNonABNativeMaxRetries = AbstractC3402hc.a("default", 3, APPLOVIN_KEY, 3);
    private static final JSONObject defaultNonABNativeRetryInterval = AbstractC3402hc.a("default", 1000, APPLOVIN_KEY, 1000);
    private static final JSONObject defaultNonABAudioloadTimeout = AbstractC3402hc.a("default", 29500, APPLOVIN_KEY, 9500);
    private static final JSONObject defaultNonABAudioMuttTimeout = AbstractC3402hc.a("default", 29500, APPLOVIN_KEY, 9500);
    private static final JSONObject defaultNonABAudioMaxRetries = AbstractC3402hc.a("default", 3, APPLOVIN_KEY, 3);
    private static final JSONObject defaultNonABAudioRetryInterval = AbstractC3402hc.a("default", 1000, APPLOVIN_KEY, 1000);
    private static final JSONObject defaultABBannerloadTimeout = AbstractC3402hc.a("default", 14500, APPLOVIN_KEY, 9500);
    private static final JSONObject defaultABBannerMaxRetries = AbstractC3402hc.a("default", 3, APPLOVIN_KEY, 3);
    private static final JSONObject defaultABBannerRetryInterval = AbstractC3402hc.a("default", 1000, APPLOVIN_KEY, 1000);
    private static final JSONObject defaultABIntloadTimeout = AbstractC3402hc.a("default", 29500, APPLOVIN_KEY, 29500);
    private static final JSONObject defaultABIntMaxRetries = AbstractC3402hc.a("default", 3, APPLOVIN_KEY, 3);
    private static final JSONObject defaultABIntRetryInterval = AbstractC3402hc.a("default", 1000, APPLOVIN_KEY, 1000);
    private static final JSONObject defaultABNativeloadTimeout = AbstractC3402hc.a("default", 14500, APPLOVIN_KEY, 14500);
    private static final JSONObject defaultABNativeMaxRetries = AbstractC3402hc.a("default", 3, APPLOVIN_KEY, 3);
    private static final JSONObject defaultABNativeRetryInterval = AbstractC3402hc.a("default", 1000, APPLOVIN_KEY, 1000);
    private static final JSONObject defaultABAudioloadTimeout = AbstractC3402hc.a("default", 14500, APPLOVIN_KEY, 9500);
    private static final JSONObject defaultABAudioMaxRetries = AbstractC3402hc.a("default", 3, APPLOVIN_KEY, 3);
    private static final JSONObject defaultABAudioRetryInterval = AbstractC3402hc.a("default", 1000, APPLOVIN_KEY, 1000);
    private static final JSONObject defaultPreloadBannerPreloadTimeout = AbstractC3388gc.a("default", 29500);
    private static final JSONObject defaultPreloadBannerMuttTimeout = AbstractC3388gc.a("default", 29500);
    private static final JSONObject defaultPreloadBannerLoadTimeout = AbstractC3388gc.a("default", 14500);
    private static final JSONObject defaultPreloadBannerMaxRetries = AbstractC3388gc.a("default", 3);
    private static final JSONObject defaultPreloadBannerRetryInterval = AbstractC3388gc.a("default", 1000);
    private static final JSONObject defaultPreloadIntPreloadTimeout = AbstractC3388gc.a("default", 29500);
    private static final JSONObject defaultPreloadIntMuttTimeout = AbstractC3388gc.a("default", 29500);
    private static final JSONObject defaultPreloadIntloadTimeout = AbstractC3388gc.a("default", 29500);
    private static final JSONObject defaultPreloadIntMaxRetries = AbstractC3388gc.a("default", 3);
    private static final JSONObject defaultPreloadIntRetryInterval = AbstractC3388gc.a("default", 1000);
    private static final JSONObject defaultPreloadNativePreloadTimeout = AbstractC3388gc.a("default", 29500);
    private static final JSONObject defaultPreloadNativeMuttTimeout = AbstractC3388gc.a("default", 29500);
    private static final JSONObject defaultPreloadNativeloadTimeout = AbstractC3388gc.a("default", 14500);
    private static final JSONObject defaultPreloadNativeMaxRetries = AbstractC3388gc.a("default", 3);
    private static final JSONObject defaultPreloadNativeRetryInterval = AbstractC3388gc.a("default", 1000);
    private static final JSONObject defaultPreloadAudioPreloadTimeout = AbstractC3388gc.a("default", 29500);
    private static final JSONObject defaultPreloadAudioMuttTimeout = AbstractC3388gc.a("default", 29500);
    private static final JSONObject defaultPreloadAudioloadTimeout = AbstractC3388gc.a("default", 14500);
    private static final JSONObject defaultPreloadAudioMaxRetries = AbstractC3388gc.a("default", 3);
    private static final JSONObject defaultPreloadAudioRetryInterval = AbstractC3388gc.a("default", 1000);
    private static final Function2<JSONObject, Integer, Boolean> validator = C3416ic.f3342a;
    private int step4s = 15000;
    private TimeoutConfigurations$MediationConfig mediationConfig = new TimeoutConfigurations$MediationConfig();

    public final TimeoutConfigurations$MediationConfig X() {
        return this.mediationConfig;
    }

    public final int Y() {
        return this.step4s;
    }

    public final boolean Z() {
        return Y() >= 0 && this.mediationConfig.isValid();
    }

    public final void a0() {
        int i = this.step4s;
        if (i <= 0) {
            i = 15000;
        }
        this.step4s = i;
    }
}
