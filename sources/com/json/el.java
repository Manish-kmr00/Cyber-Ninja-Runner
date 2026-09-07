package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.model.InterstitialPlacement;
import com.json.mediationsdk.model.Placement;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\tJ\u0006\u0010\u0012\u001a\u00020\u0011J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0015\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0015\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006 "}, d2 = {"Lcom/ironsource/el;", "Lcom/ironsource/kr;", "Lcom/unity3d/mediation/LevelPlay$AdFormat;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "", "adUnitId", "", "d", CampaignEx.JSON_KEY_AD_K, "", "Lcom/ironsource/zn;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "a", "Lcom/ironsource/i7$b;", "Lcom/ironsource/td$a;", "Lcom/unity3d/mediation/LevelPlayAdSize;", "h", "", "i", "placementName", "Lcom/ironsource/mediationsdk/model/Placement;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/vl;", "tools", "Lcom/ironsource/iq;", "j", "Lcom/ironsource/u1;", "Lcom/ironsource/np;", "", "sdkConfig", "<init>", "(Lcom/ironsource/kr;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class el extends kr {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3658a;

        static {
            int[] iArr = new int[LevelPlay.AdFormat.values().length];
            try {
                iArr[LevelPlay.AdFormat.REWARDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LevelPlay.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LevelPlay.AdFormat.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LevelPlay.AdFormat.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f3658a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public el(kr sdkConfig) {
        super(sdkConfig);
        Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
    }

    private final boolean d(LevelPlay.AdFormat adFormat, String adUnitId) {
        Boolean enabled;
        t.d dVarB;
        Map<String, t.d> mapA;
        t.d dVar;
        boolean z = adFormat == LevelPlay.AdFormat.REWARDED;
        t tVar = getSdkInitResponse().getConfigurations().a().get(adFormat);
        wp wpVarG = null;
        wp wpVarG2 = (tVar == null || (mapA = tVar.a()) == null || (dVar = mapA.get(adUnitId)) == null) ? null : dVar.getProgressiveLoadingConfig();
        if (wpVarG2 != null) {
            enabled = wpVarG2.getEnabled();
            if (enabled == null) {
                return z;
            }
        } else {
            if (tVar != null && (dVarB = tVar.getFeatures()) != null) {
                wpVarG = dVarB.getProgressiveLoadingConfig();
            }
            if (wpVarG == null || (enabled = wpVarG.getEnabled()) == null) {
                return z;
            }
        }
        return enabled.booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007a A[PHI: r8
  0x007a: PHI (r8v18 java.lang.Boolean) = (r8v4 java.lang.Boolean), (r8v13 java.lang.Boolean), (r8v19 java.lang.Boolean) binds: [B:28:0x0078, B:34:0x00a3, B:25:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    public final i7.b a(String adUnitId) {
        Integer numB;
        Boolean boolD;
        boolean zBooleanValue;
        boolean zBooleanValue2;
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        t6 bannerConfigurations = getSdkInitResponse().getConfigurations().getBannerConfigurations();
        t6.b bVar = bannerConfigurations.a().get(adUnitId);
        int iIntValue = ((bVar == null || (numB = bVar.getBannerInterval()) == null) && (numB = bannerConfigurations.getFeatures().getBannerInterval()) == null) ? 60 : numB.intValue();
        t6.b bVar2 = bannerConfigurations.a().get(adUnitId);
        if ((bVar2 == null || (boolD = bVar2.getIsAutoRefresh()) == null) && (boolD = bannerConfigurations.getFeatures().getIsAutoRefresh()) == null) {
            zBooleanValue = iIntValue > 0;
        } else {
            zBooleanValue = boolD.booleanValue();
        }
        t6.b bVar3 = bannerConfigurations.a().get(adUnitId);
        if ((bVar3 == null || (boolE = bVar3.getIsLoadWhileShow()) == null) && (boolE = bannerConfigurations.getFeatures().getIsLoadWhileShow()) == null) {
            q qVar = getSdkInitResponse().getConfigurations().getApplicationConfigurations().getAuctionSettings().a().get(LevelPlay.AdFormat.BANNER);
            Boolean boolE = qVar != null ? qVar.getIsLoadWhileShow() : null;
            zBooleanValue2 = boolE != null ? boolE.booleanValue() : false;
        }
        return new i7.b(zBooleanValue2 ? i7.c.TIMED_SHOW : i7.c.TIMED_LOAD, ((long) iIntValue) * 1000, zBooleanValue);
    }

    public final td.a a(LevelPlay.AdFormat adFormat, String adUnitId) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        return new td.a(d(adFormat, adUnitId) ? td.c.PROGRESSIVE_ON_SHOW : td.c.MANUAL);
    }

    public final u1 a(vl tools) {
        Intrinsics.checkNotNullParameter(tools, "tools");
        return new u1(tools, getSdkInitResponse().getConfigurations().a());
    }

    public final List<String> a(LevelPlay.AdFormat adFormat) {
        Map<String, zp.b> mapA;
        Set<String> setKeySet;
        List<String> list;
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        zp.a aVar = getSdkInitResponse().getProviderOrder().a().get(adFormat);
        return (aVar == null || (mapA = aVar.a()) == null || (setKeySet = mapA.keySet()) == null || (list = CollectionsKt.toList(setKeySet)) == null) ? CollectionsKt.emptyList() : list;
    }

    public final boolean a(String adUnitId, LevelPlay.AdFormat adFormat) {
        Map<String, zp.b> mapA;
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        zp.a aVar = getSdkInitResponse().getProviderOrder().a().get(adFormat);
        return (aVar == null || (mapA = aVar.a()) == null || !mapA.containsKey(adUnitId)) ? false : true;
    }

    public final long b(LevelPlay.AdFormat adFormat) {
        t.d dVarB;
        Long lD;
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        t tVar = getSdkInitResponse().getConfigurations().a().get(adFormat);
        long jLongValue = (tVar == null || (dVarB = tVar.getFeatures()) == null || (lD = dVarB.getExpiredDurationInMinutes()) == null) ? 60L : lD.longValue();
        return jLongValue > 0 ? TimeUnit.MINUTES.toMillis(jLongValue) : jLongValue;
    }

    public final Placement b(LevelPlay.AdFormat adFormat, String placementName) {
        Placement placementA;
        InterstitialPlacement interstitialPlacementA;
        String str;
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        int i = a.f3658a[adFormat.ordinal()];
        if (i == 1) {
            yq yqVarF = d().c().getRewardedVideoConfigurations();
            if (yqVarF == null || (placementA = yqVarF.a(placementName)) == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(placementA, "getRewardedVideoPlacement(placementName)");
            return new Placement(placementA.getPlacementId(), placementA.getPlacementName(), placementA.getIsDefault(), placementA.getCom.ironsource.mediationsdk.utils.IronSourceConstants.EVENTS_REWARD_NAME java.lang.String(), placementA.getRewardAmount(), placementA.getPlacementAvailabilitySettings());
        }
        if (i == 2) {
            mj mjVarD = d().c().getInterstitialConfigurations();
            if (mjVarD == null || (interstitialPlacementA = mjVarD.a(placementName)) == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(interstitialPlacementA, "getInterstitialPlacement(placementName)");
            return new Placement(interstitialPlacementA);
        }
        if (i == 3) {
            u6 u6VarC = d().c().getBannerConfigurations();
            if (u6VarC == null) {
                throw new IllegalStateException("Error getting " + adFormat + " configurations");
            }
            h7 h7VarA = u6VarC.a(placementName);
            if (h7VarA == null) {
                h7VarA = u6VarC.i();
                str = "config.defaultBannerPlacement";
            } else {
                str = "config.getBannerPlacemen…ig.defaultBannerPlacement";
            }
            Intrinsics.checkNotNullExpressionValue(h7VarA, str);
            return new Placement(h7VarA);
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        rm rmVarE = d().c().getNativeAdConfigurations();
        if (rmVarE != null && placementName != null) {
            cn cnVarA = rmVarE.a(placementName);
            if (cnVarA == null) {
                cnVarA = rmVarE.e();
            }
            if (cnVarA != null) {
                return new Placement(cnVarA);
            }
        }
        throw new IllegalStateException("Error getting " + adFormat + " configurations");
    }

    public final np b(vl tools) {
        Intrinsics.checkNotNullParameter(tools, "tools");
        return new np(tools, getSdkInitResponse().getConfigurations().a());
    }

    public final iq c(vl tools) {
        Intrinsics.checkNotNullParameter(tools, "tools");
        t tVar = getSdkInitResponse().getConfigurations().a().get(LevelPlay.AdFormat.REWARDED);
        return new iq(tools, tVar != null ? tVar.a() : null, tVar != null ? tVar.c() : null);
    }

    public final List<zn> c(LevelPlay.AdFormat adFormat) {
        Map<String, zp.b> mapA;
        Set<String> setKeySet;
        List<zn> listDistinct;
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        zp.a aVar = getSdkInitResponse().getProviderOrder().a().get(adFormat);
        if (aVar != null && (mapA = aVar.a()) != null && (setKeySet = mapA.keySet()) != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(c(adFormat, (String) it.next()));
            }
            List listFlatten = CollectionsKt.flatten(arrayList);
            if (listFlatten != null && (listDistinct = CollectionsKt.distinct(listFlatten)) != null) {
                return listDistinct;
            }
        }
        return CollectionsKt.emptyList();
    }

    public final List<zn> c(LevelPlay.AdFormat adFormat, String adUnitId) {
        Map<String, zp.b> mapA;
        zp.b bVar;
        List<String> listA;
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        zp.a aVar = getSdkInitResponse().getProviderOrder().a().get(adFormat);
        if (aVar == null || (mapA = aVar.a()) == null || (bVar = mapA.get(adUnitId)) == null || (listA = bVar.a()) == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            zn znVar = getSdkInitResponse().getProviderSettings().a().get((String) it.next());
            if (znVar != null) {
                arrayList.add(znVar);
            }
        }
        return arrayList;
    }

    public final List<LevelPlayAdSize> h() {
        List<String> listA = getSdkInitResponse().getConfigurations().getBannerConfigurations().getFeatures().a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(LevelPlayAdSize.INSTANCE.createAdSize$mediationsdk_release((String) it.next()));
        }
        return arrayList;
    }

    public final float i() {
        return getSdkInitResponse().getConfigurations().getBannerConfigurations().getFeatures().getMaxScreenHeightPercentage();
    }

    public final boolean j() {
        g1 g1VarA = d().c().getAdQualityConfigurations();
        return g1VarA != null && g1VarA.a();
    }

    public final boolean k() {
        return getSdkInitResponse().getConfigurations().getApplicationConfigurations().getIntegration();
    }
}
