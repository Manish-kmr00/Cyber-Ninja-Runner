package com.five_corp.ad;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public abstract class FiveAd {

    @Deprecated
    public static class MediaUserAttribute {
        public MediaUserAttribute(String str, String str2) {
        }
    }

    public static String getSdkSemanticVersion() {
        return BuildConfig.SEMVER;
    }

    @Deprecated
    public static int getSdkVersion() {
        return BuildConfig.SEMVER_PATCH;
    }

    public static FiveAd getSingleton() {
        return k.a();
    }

    public static void initialize(Context context, FiveAdConfig fiveAdConfig) {
        if (context == null) {
            throw new IllegalArgumentException("Context must be a non-null value.");
        }
        if (fiveAdConfig == null) {
            throw new IllegalArgumentException("FiveAdConfig must be a non-null value.");
        }
        k.initialize(context, fiveAdConfig);
    }

    public static boolean isInitialized() {
        return k.isInitialized();
    }

    @Deprecated
    public abstract void enableSound(boolean z);

    @Deprecated
    public int getVersion() {
        return BuildConfig.SEMVER_PATCH;
    }

    public abstract boolean isSoundEnabled();

    @Deprecated
    public abstract void setMediaUserAttributes(List<MediaUserAttribute> list);
}
