package io.bidmachine.ads.networks.gam.versions.v22_0_0;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.VersionInfo;
import io.bidmachine.AdsFormat;
import io.bidmachine.ads.networks.gam.GAMLoader;
import io.bidmachine.ads.networks.gam.GAMUnitData;
import io.bidmachine.ads.networks.gam.InternalGAMAd;
import io.bidmachine.ads.networks.gam.versions.BaseVersionWrapper;
import io.bidmachine.utils.version.Version;

/* JADX INFO: loaded from: classes12.dex */
public class VersionWrapperImpl extends BaseVersionWrapper {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11986a;

        static {
            int[] iArr = new int[AdsFormat.values().length];
            f11986a = iArr;
            try {
                iArr[AdsFormat.Banner.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11986a[AdsFormat.Banner_320x50.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11986a[AdsFormat.Banner_728x90.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11986a[AdsFormat.Banner_300x250.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11986a[AdsFormat.Interstitial.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11986a[AdsFormat.InterstitialStatic.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11986a[AdsFormat.InterstitialVideo.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11986a[AdsFormat.Rewarded.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11986a[AdsFormat.RewardedStatic.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11986a[AdsFormat.RewardedVideo.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public VersionWrapperImpl() {
        super(19, new Version(22, 0, 0));
    }

    private boolean a() {
        try {
            Class.forName("com.google.android.gms.ads.MobileAds");
            Class.forName("com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder");
            Class.forName("com.google.android.gms.ads.admanager.AdManagerAdView");
            Class.forName("com.google.android.gms.ads.admanager.AdManagerInterstitialAd");
            Class.forName("com.google.android.gms.ads.rewarded.RewardedAd");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // io.bidmachine.ads.networks.gam.versions.VersionWrapper
    public InternalGAMAd createAd(GAMLoader gAMLoader, AdsFormat adsFormat, GAMUnitData gAMUnitData) {
        switch (a.f11986a[adsFormat.ordinal()]) {
            case 1:
            case 2:
                return new c(gAMLoader, adsFormat, gAMUnitData, AdSize.BANNER);
            case 3:
                return new c(gAMLoader, adsFormat, gAMUnitData, AdSize.LEADERBOARD);
            case 4:
                return new c(gAMLoader, adsFormat, gAMUnitData, AdSize.MEDIUM_RECTANGLE);
            case 5:
            case 6:
            case 7:
                return new d(gAMLoader, adsFormat, gAMUnitData);
            case 8:
            case 9:
            case 10:
                return new e(gAMLoader, adsFormat, gAMUnitData);
            default:
                return null;
        }
    }

    @Override // io.bidmachine.ads.networks.gam.versions.VersionWrapper
    public Version getVersion() {
        VersionInfo version = MobileAds.getVersion();
        return new Version(version.getMajorVersion(), version.getMinorVersion(), version.getMicroVersion());
    }

    @Override // io.bidmachine.ads.networks.gam.versions.VersionWrapper
    public void initialize(Context context) {
        MobileAds.initialize(context);
    }

    @Override // io.bidmachine.ads.networks.gam.versions.VersionWrapper
    public boolean isGAMPresent(Context context) {
        return a(context) && a();
    }

    private boolean a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return false;
            }
            return !TextUtils.isEmpty(bundle.getString("com.google.android.gms.ads.APPLICATION_ID"));
        } catch (Exception unused) {
            return false;
        }
    }
}
