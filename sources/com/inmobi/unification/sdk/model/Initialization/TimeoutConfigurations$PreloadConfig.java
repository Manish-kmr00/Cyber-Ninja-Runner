package com.inmobi.unification.sdk.model.Initialization;

import com.inmobi.media.C3430jc;
import com.inmobi.media.C3460lc;
import com.safedk.android.analytics.brandsafety.l;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"com/inmobi/unification/sdk/model/Initialization/TimeoutConfigurations$PreloadConfig", "", "<init>", "()V", "Lcom/inmobi/unification/sdk/model/Initialization/TimeoutConfigurations$AdPreloadConfig;", "getBanner", "()Lcom/inmobi/unification/sdk/model/Initialization/TimeoutConfigurations$AdPreloadConfig;", "getInterstitial", "getNative", "getAudio", "", "isValid", "()Z", "banner", "Lcom/inmobi/unification/sdk/model/Initialization/TimeoutConfigurations$AdPreloadConfig;", l.w, "native", "audio", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TimeoutConfigurations$PreloadConfig {
    private TimeoutConfigurations$AdPreloadConfig audio;
    private TimeoutConfigurations$AdPreloadConfig banner;
    private TimeoutConfigurations$AdPreloadConfig int;
    private TimeoutConfigurations$AdPreloadConfig native;

    public TimeoutConfigurations$PreloadConfig() {
        C3430jc c3430jc = C3460lc.Companion;
        c3430jc.getClass();
        JSONObject jSONObject = C3460lc.defaultPreloadBannerPreloadTimeout;
        c3430jc.getClass();
        JSONObject jSONObject2 = C3460lc.defaultPreloadBannerMuttTimeout;
        c3430jc.getClass();
        JSONObject jSONObject3 = C3460lc.defaultPreloadBannerLoadTimeout;
        c3430jc.getClass();
        JSONObject jSONObject4 = C3460lc.defaultPreloadBannerRetryInterval;
        c3430jc.getClass();
        this.banner = new TimeoutConfigurations$AdPreloadConfig(jSONObject, jSONObject2, jSONObject3, jSONObject4, C3460lc.defaultPreloadBannerMaxRetries);
        c3430jc.getClass();
        JSONObject jSONObject5 = C3460lc.defaultPreloadIntPreloadTimeout;
        c3430jc.getClass();
        JSONObject jSONObject6 = C3460lc.defaultPreloadIntMuttTimeout;
        c3430jc.getClass();
        JSONObject jSONObject7 = C3460lc.defaultPreloadIntloadTimeout;
        c3430jc.getClass();
        JSONObject jSONObject8 = C3460lc.defaultPreloadIntRetryInterval;
        c3430jc.getClass();
        this.int = new TimeoutConfigurations$AdPreloadConfig(jSONObject5, jSONObject6, jSONObject7, jSONObject8, C3460lc.defaultPreloadIntMaxRetries);
        c3430jc.getClass();
        JSONObject jSONObject9 = C3460lc.defaultPreloadNativePreloadTimeout;
        c3430jc.getClass();
        JSONObject jSONObject10 = C3460lc.defaultPreloadNativeMuttTimeout;
        c3430jc.getClass();
        JSONObject jSONObject11 = C3460lc.defaultPreloadNativeloadTimeout;
        c3430jc.getClass();
        JSONObject jSONObject12 = C3460lc.defaultPreloadNativeRetryInterval;
        c3430jc.getClass();
        this.native = new TimeoutConfigurations$AdPreloadConfig(jSONObject9, jSONObject10, jSONObject11, jSONObject12, C3460lc.defaultPreloadNativeMaxRetries);
        c3430jc.getClass();
        JSONObject jSONObject13 = C3460lc.defaultPreloadAudioPreloadTimeout;
        c3430jc.getClass();
        JSONObject jSONObject14 = C3460lc.defaultPreloadAudioMuttTimeout;
        c3430jc.getClass();
        JSONObject jSONObject15 = C3460lc.defaultPreloadAudioloadTimeout;
        c3430jc.getClass();
        JSONObject jSONObject16 = C3460lc.defaultPreloadAudioRetryInterval;
        c3430jc.getClass();
        this.audio = new TimeoutConfigurations$AdPreloadConfig(jSONObject13, jSONObject14, jSONObject15, jSONObject16, C3460lc.defaultPreloadAudioMaxRetries);
    }

    public final TimeoutConfigurations$AdPreloadConfig getAudio() {
        return this.audio;
    }

    public final TimeoutConfigurations$AdPreloadConfig getBanner() {
        return this.banner;
    }

    /* JADX INFO: renamed from: getInterstitial, reason: from getter */
    public final TimeoutConfigurations$AdPreloadConfig getInt() {
        return this.int;
    }

    public final TimeoutConfigurations$AdPreloadConfig getNative() {
        return this.native;
    }

    public final boolean isValid() {
        return this.banner.isValid() && this.int.isValid() && this.native.isValid() && this.audio.isValid();
    }
}
