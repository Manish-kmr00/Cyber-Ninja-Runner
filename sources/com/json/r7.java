package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.model.NetworkSettings;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\u0010\u0011\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0011\u001a\u00060\rj\u0002`\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/ironsource/r7;", "Lcom/ironsource/e3;", "Lcom/ironsource/yp;", "providerName", "Lcom/ironsource/ui;", "a", "Lcom/ironsource/s8;", "Lcom/ironsource/s8;", "adFormatConfigurations", "Lcom/ironsource/cq;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/cq;", "providerSettingsHolder", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "Lcom/unity3d/ironsourceads/internal/AdFormat;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "<init>", "(Lcom/ironsource/s8;Lcom/ironsource/cq;Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class r7 implements e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final s8 adFormatConfigurations;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final cq providerSettingsHolder;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final IronSource.AD_UNIT adFormat;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4216a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            try {
                iArr[IronSource.AD_UNIT.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f4216a = iArr;
        }
    }

    public r7(s8 adFormatConfigurations, cq cqVar, IronSource.AD_UNIT adFormat) {
        Intrinsics.checkNotNullParameter(adFormatConfigurations, "adFormatConfigurations");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        this.adFormatConfigurations = adFormatConfigurations;
        this.providerSettingsHolder = cqVar;
        this.adFormat = adFormat;
    }

    @Override // com.json.e3
    public ui a(yp providerName) {
        NetworkSettings networkSettingsB;
        yq rewardedVideoConfigurations;
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        cq cqVar = this.providerSettingsHolder;
        if (cqVar == null || (networkSettingsB = cqVar.b(providerName.value())) == null) {
            return null;
        }
        int i = a.f4216a[this.adFormat.ordinal()];
        if (i == 1) {
            u6 bannerConfigurations = this.adFormatConfigurations.getBannerConfigurations();
            if (bannerConfigurations != null) {
                return new z6(new c3(networkSettingsB, networkSettingsB.getBannerSettings(), this.adFormat), bannerConfigurations);
            }
            return null;
        }
        if (i != 2) {
            if (i == 3 && (rewardedVideoConfigurations = this.adFormatConfigurations.getRewardedVideoConfigurations()) != null) {
                return new lq(new c3(networkSettingsB, networkSettingsB.getRewardedVideoSettings(), this.adFormat), rewardedVideoConfigurations);
            }
            return null;
        }
        mj interstitialConfigurations = this.adFormatConfigurations.getInterstitialConfigurations();
        if (interstitialConfigurations != null) {
            return new pj(new c3(networkSettingsB, networkSettingsB.getInterstitialSettings(), this.adFormat), interstitialConfigurations);
        }
        return null;
    }
}
