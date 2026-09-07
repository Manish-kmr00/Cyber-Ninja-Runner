package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.CrashConfig;
import com.inmobi.commons.core.configs.RootConfig;
import com.inmobi.commons.core.configs.SignalsConfig;
import com.inmobi.commons.core.configs.TelemetryConfig;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.m2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3464m2 {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Config a(String configType, String str) {
        Intrinsics.checkNotNullParameter(configType, "configType");
        switch (configType.hashCode()) {
            case -60641721:
                if (configType.equals("crashReporting")) {
                    return new CrashConfig(str);
                }
                break;
            case 96432:
                if (configType.equals("ads")) {
                    return new AdConfig(str);
                }
                break;
            case 3506402:
                if (configType.equals("root")) {
                    return new RootConfig(str);
                }
                break;
            case 780346297:
                if (configType.equals("telemetry")) {
                    return new TelemetryConfig(str);
                }
                break;
            case 2088265419:
                if (configType.equals("signals")) {
                    return new SignalsConfig(str);
                }
                break;
        }
        return new AdConfig(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:25:0x00ed  */
    public static Config a(String configType, JSONObject jsonObject, String str, long j) {
        Config config;
        Intrinsics.checkNotNullParameter(configType, "configType");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        switch (configType) {
            case "crashReporting":
                CrashConfig.Companion.getClass();
                config = (Config) new A5().a(jsonObject, CrashConfig.class);
                break;
            case "ads":
                AdConfig.Companion.getClass();
                config = (Config) com.inmobi.commons.core.configs.b.a().a(jsonObject, AdConfig.class);
                break;
            case "root":
                RootConfig.Companion.getClass();
                config = (Config) new A5().a(new Za("components", RootConfig.class), (Ya) new C3312b6(new com.inmobi.commons.core.configs.d(), RootConfig.ComponentConfig.class)).a(new Za(RootConfig.IP_ADDRESS_TP_SUPPORT_KEY, RootConfig.class), (Ya) new C3312b6(new Xa(), String.class)).a(jsonObject, RootConfig.class);
                break;
            case "telemetry":
                TelemetryConfig.Companion.getClass();
                config = (Config) new A5().a(new Za("priorityEvents", TelemetryConfig.class), (Ya) new C3312b6(new Pb(), String.class)).a(jsonObject, TelemetryConfig.class);
                break;
            case "signals":
                SignalsConfig.Companion.getClass();
                config = (Config) com.inmobi.commons.core.configs.f.a().a(jsonObject, SignalsConfig.class);
                break;
            default:
                AdConfig.Companion.getClass();
                config = (Config) com.inmobi.commons.core.configs.b.a().a(jsonObject, AdConfig.class);
                break;
        }
        if (config != null) {
            config.setAccountId$media_release(str);
            config.setLastUpdateTimeStamp(j);
        }
        return config;
    }
}
