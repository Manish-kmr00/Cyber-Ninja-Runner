package io.appmetrica.analytics.coreutils.internal.services;

import com.unity3d.services.core.properties.MadeWithUnityDetector;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.plugins.PluginErrorDetails;

/* JADX INFO: loaded from: classes12.dex */
public class FrameworkDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f11003a = new FrameworkDetector().detectFramework();

    public static String framework() {
        return f11003a;
    }

    public static boolean isNative() {
        return "native".equals(f11003a);
    }

    public String detectFramework() {
        if (ReflectionUtils.detectClassExists(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME)) {
            return "unity";
        }
        if (ReflectionUtils.detectClassExists("mono.MonoPackageManager")) {
            return PluginErrorDetails.Platform.XAMARIN;
        }
        if (ReflectionUtils.detectClassExists("org.apache.cordova.CordovaPlugin")) {
            return PluginErrorDetails.Platform.CORDOVA;
        }
        if (ReflectionUtils.detectClassExists("com.facebook.react.ReactRootView")) {
            return "react";
        }
        if (!ReflectionUtils.detectClassExists("io.flutter.embedding.engine.FlutterEngine")) {
            return "native";
        }
        return PluginErrorDetails.Platform.FLUTTER;
    }
}
