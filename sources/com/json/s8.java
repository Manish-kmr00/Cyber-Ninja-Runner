package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0005BO\b\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010&\u001a\u0004\u0018\u00010#¢\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u000b\u0010\u001cR\u0019\u0010\"\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010&\u001a\u0004\u0018\u00010#8\u0006¢\u0006\f\n\u0004\b \u0010$\u001a\u0004\b\u0005\u0010%¨\u0006)"}, d2 = {"Lcom/ironsource/s8;", "", "", "toString", "Lcom/ironsource/yq;", "a", "Lcom/ironsource/yq;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/ironsource/yq;", "rewardedVideoConfigurations", "Lcom/ironsource/mj;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/mj;", "d", "()Lcom/ironsource/mj;", "interstitialConfigurations", "Lcom/ironsource/u6;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/u6;", "()Lcom/ironsource/u6;", "bannerConfigurations", "Lcom/ironsource/rm;", "Lcom/ironsource/rm;", "e", "()Lcom/ironsource/rm;", "nativeAdConfigurations", "Lcom/ironsource/a4;", "Lcom/ironsource/a4;", "()Lcom/ironsource/a4;", "applicationConfigurations", "Lcom/ironsource/pu;", "Lcom/ironsource/pu;", "g", "()Lcom/ironsource/pu;", "testSuiteSettings", "Lcom/ironsource/g1;", "Lcom/ironsource/g1;", "()Lcom/ironsource/g1;", "adQualityConfigurations", "<init>", "(Lcom/ironsource/yq;Lcom/ironsource/mj;Lcom/ironsource/u6;Lcom/ironsource/rm;Lcom/ironsource/a4;Lcom/ironsource/pu;Lcom/ironsource/g1;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class s8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final yq rewardedVideoConfigurations;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final mj interstitialConfigurations;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final u6 bannerConfigurations;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final rm nativeAdConfigurations;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final a4 applicationConfigurations;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final pu testSuiteSettings;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final g1 adQualityConfigurations;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0004\u001a\u00020\u0012J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0010HÆ\u0003J]\u0010\u0004\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\t\u0010\u001a\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b\u000f\u0010#R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010&\"\u0004\b\u000f\u0010'R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010*\"\u0004\b\u000f\u0010+R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010,\u001a\u0004\b-\u0010.\"\u0004\b\u000f\u0010/R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u00100\u001a\u0004\b1\u00102\"\u0004\b\u000f\u00103R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u00104\u001a\u0004\b5\u00106\"\u0004\b\u0004\u00107R$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u00108\u001a\u0004\b9\u0010:\"\u0004\b\u000f\u0010;¨\u0006>"}, d2 = {"Lcom/ironsource/s8$a;", "", "Lcom/ironsource/yq;", "rewardedVideoConfigurations", "a", "Lcom/ironsource/mj;", "interstitialConfigurations", "Lcom/ironsource/u6;", "bannerConfigurations", "Lcom/ironsource/rm;", "nativeAdConfigurations", "Lcom/ironsource/a4;", "applicationConfigurations", "Lcom/ironsource/pu;", "testSuiteSettings", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/g1;", "adQualityConfigurations", "Lcom/ironsource/s8;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "e", InneractiveMediationDefs.GENDER_FEMALE, "g", "h", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/ironsource/yq;", "n", "()Lcom/ironsource/yq;", "(Lcom/ironsource/yq;)V", "Lcom/ironsource/mj;", "l", "()Lcom/ironsource/mj;", "(Lcom/ironsource/mj;)V", "Lcom/ironsource/u6;", CampaignEx.JSON_KEY_AD_K, "()Lcom/ironsource/u6;", "(Lcom/ironsource/u6;)V", "Lcom/ironsource/rm;", "m", "()Lcom/ironsource/rm;", "(Lcom/ironsource/rm;)V", "Lcom/ironsource/a4;", "j", "()Lcom/ironsource/a4;", "(Lcom/ironsource/a4;)V", "Lcom/ironsource/pu;", "o", "()Lcom/ironsource/pu;", "(Lcom/ironsource/pu;)V", "Lcom/ironsource/g1;", "i", "()Lcom/ironsource/g1;", "(Lcom/ironsource/g1;)V", "<init>", "(Lcom/ironsource/yq;Lcom/ironsource/mj;Lcom/ironsource/u6;Lcom/ironsource/rm;Lcom/ironsource/a4;Lcom/ironsource/pu;Lcom/ironsource/g1;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private yq rewardedVideoConfigurations;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private mj interstitialConfigurations;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private u6 bannerConfigurations;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private rm nativeAdConfigurations;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private a4 applicationConfigurations;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private pu testSuiteSettings;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        private g1 adQualityConfigurations;

        public a() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public a(yq yqVar, mj mjVar, u6 u6Var, rm rmVar, a4 a4Var, pu puVar, g1 g1Var) {
            this.rewardedVideoConfigurations = yqVar;
            this.interstitialConfigurations = mjVar;
            this.bannerConfigurations = u6Var;
            this.nativeAdConfigurations = rmVar;
            this.applicationConfigurations = a4Var;
            this.testSuiteSettings = puVar;
            this.adQualityConfigurations = g1Var;
        }

        public /* synthetic */ a(yq yqVar, mj mjVar, u6 u6Var, rm rmVar, a4 a4Var, pu puVar, g1 g1Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : yqVar, (i & 2) != 0 ? null : mjVar, (i & 4) != 0 ? null : u6Var, (i & 8) != 0 ? null : rmVar, (i & 16) != 0 ? null : a4Var, (i & 32) != 0 ? null : puVar, (i & 64) != 0 ? null : g1Var);
        }

        public static /* synthetic */ a a(a aVar, yq yqVar, mj mjVar, u6 u6Var, rm rmVar, a4 a4Var, pu puVar, g1 g1Var, int i, Object obj) {
            if ((i & 1) != 0) {
                yqVar = aVar.rewardedVideoConfigurations;
            }
            if ((i & 2) != 0) {
                mjVar = aVar.interstitialConfigurations;
            }
            mj mjVar2 = mjVar;
            if ((i & 4) != 0) {
                u6Var = aVar.bannerConfigurations;
            }
            u6 u6Var2 = u6Var;
            if ((i & 8) != 0) {
                rmVar = aVar.nativeAdConfigurations;
            }
            rm rmVar2 = rmVar;
            if ((i & 16) != 0) {
                a4Var = aVar.applicationConfigurations;
            }
            a4 a4Var2 = a4Var;
            if ((i & 32) != 0) {
                puVar = aVar.testSuiteSettings;
            }
            pu puVar2 = puVar;
            if ((i & 64) != 0) {
                g1Var = aVar.adQualityConfigurations;
            }
            return aVar.a(yqVar, mjVar2, u6Var2, rmVar2, a4Var2, puVar2, g1Var);
        }

        public final a a(a4 applicationConfigurations) {
            this.applicationConfigurations = applicationConfigurations;
            return this;
        }

        public final a a(g1 adQualityConfigurations) {
            this.adQualityConfigurations = adQualityConfigurations;
            return this;
        }

        public final a a(mj interstitialConfigurations) {
            this.interstitialConfigurations = interstitialConfigurations;
            return this;
        }

        public final a a(rm nativeAdConfigurations) {
            this.nativeAdConfigurations = nativeAdConfigurations;
            return this;
        }

        public final a a(u6 bannerConfigurations) {
            this.bannerConfigurations = bannerConfigurations;
            return this;
        }

        public final a a(yq rewardedVideoConfigurations) {
            this.rewardedVideoConfigurations = rewardedVideoConfigurations;
            return this;
        }

        public final a a(yq rewardedVideoConfigurations, mj interstitialConfigurations, u6 bannerConfigurations, rm nativeAdConfigurations, a4 applicationConfigurations, pu testSuiteSettings, g1 adQualityConfigurations) {
            return new a(rewardedVideoConfigurations, interstitialConfigurations, bannerConfigurations, nativeAdConfigurations, applicationConfigurations, testSuiteSettings, adQualityConfigurations);
        }

        public final s8 a() {
            return new s8(this.rewardedVideoConfigurations, this.interstitialConfigurations, this.bannerConfigurations, this.nativeAdConfigurations, this.applicationConfigurations, this.testSuiteSettings, this.adQualityConfigurations, null);
        }

        public final void a(pu puVar) {
            this.testSuiteSettings = puVar;
        }

        public final a b(pu testSuiteSettings) {
            this.testSuiteSettings = testSuiteSettings;
            return this;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final yq getRewardedVideoConfigurations() {
            return this.rewardedVideoConfigurations;
        }

        public final void b(a4 a4Var) {
            this.applicationConfigurations = a4Var;
        }

        public final void b(g1 g1Var) {
            this.adQualityConfigurations = g1Var;
        }

        public final void b(mj mjVar) {
            this.interstitialConfigurations = mjVar;
        }

        public final void b(rm rmVar) {
            this.nativeAdConfigurations = rmVar;
        }

        public final void b(u6 u6Var) {
            this.bannerConfigurations = u6Var;
        }

        public final void b(yq yqVar) {
            this.rewardedVideoConfigurations = yqVar;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final mj getInterstitialConfigurations() {
            return this.interstitialConfigurations;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final u6 getBannerConfigurations() {
            return this.bannerConfigurations;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final rm getNativeAdConfigurations() {
            return this.nativeAdConfigurations;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return Intrinsics.areEqual(this.rewardedVideoConfigurations, aVar.rewardedVideoConfigurations) && Intrinsics.areEqual(this.interstitialConfigurations, aVar.interstitialConfigurations) && Intrinsics.areEqual(this.bannerConfigurations, aVar.bannerConfigurations) && Intrinsics.areEqual(this.nativeAdConfigurations, aVar.nativeAdConfigurations) && Intrinsics.areEqual(this.applicationConfigurations, aVar.applicationConfigurations) && Intrinsics.areEqual(this.testSuiteSettings, aVar.testSuiteSettings) && Intrinsics.areEqual(this.adQualityConfigurations, aVar.adQualityConfigurations);
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final a4 getApplicationConfigurations() {
            return this.applicationConfigurations;
        }

        /* JADX INFO: renamed from: g, reason: from getter */
        public final pu getTestSuiteSettings() {
            return this.testSuiteSettings;
        }

        /* JADX INFO: renamed from: h, reason: from getter */
        public final g1 getAdQualityConfigurations() {
            return this.adQualityConfigurations;
        }

        public int hashCode() {
            yq yqVar = this.rewardedVideoConfigurations;
            int iHashCode = (yqVar == null ? 0 : yqVar.hashCode()) * 31;
            mj mjVar = this.interstitialConfigurations;
            int iHashCode2 = (iHashCode + (mjVar == null ? 0 : mjVar.hashCode())) * 31;
            u6 u6Var = this.bannerConfigurations;
            int iHashCode3 = (iHashCode2 + (u6Var == null ? 0 : u6Var.hashCode())) * 31;
            rm rmVar = this.nativeAdConfigurations;
            int iHashCode4 = (iHashCode3 + (rmVar == null ? 0 : rmVar.hashCode())) * 31;
            a4 a4Var = this.applicationConfigurations;
            int iHashCode5 = (iHashCode4 + (a4Var == null ? 0 : a4Var.hashCode())) * 31;
            pu puVar = this.testSuiteSettings;
            int iHashCode6 = (iHashCode5 + (puVar == null ? 0 : puVar.hashCode())) * 31;
            g1 g1Var = this.adQualityConfigurations;
            return iHashCode6 + (g1Var != null ? g1Var.hashCode() : 0);
        }

        public final g1 i() {
            return this.adQualityConfigurations;
        }

        public final a4 j() {
            return this.applicationConfigurations;
        }

        public final u6 k() {
            return this.bannerConfigurations;
        }

        public final mj l() {
            return this.interstitialConfigurations;
        }

        public final rm m() {
            return this.nativeAdConfigurations;
        }

        public final yq n() {
            return this.rewardedVideoConfigurations;
        }

        public final pu o() {
            return this.testSuiteSettings;
        }

        public String toString() {
            return "Builder(rewardedVideoConfigurations=" + this.rewardedVideoConfigurations + ", interstitialConfigurations=" + this.interstitialConfigurations + ", bannerConfigurations=" + this.bannerConfigurations + ", nativeAdConfigurations=" + this.nativeAdConfigurations + ", applicationConfigurations=" + this.applicationConfigurations + ", testSuiteSettings=" + this.testSuiteSettings + ", adQualityConfigurations=" + this.adQualityConfigurations + ')';
        }
    }

    private s8(yq yqVar, mj mjVar, u6 u6Var, rm rmVar, a4 a4Var, pu puVar, g1 g1Var) {
        this.rewardedVideoConfigurations = yqVar;
        this.interstitialConfigurations = mjVar;
        this.bannerConfigurations = u6Var;
        this.nativeAdConfigurations = rmVar;
        this.applicationConfigurations = a4Var;
        this.testSuiteSettings = puVar;
        this.adQualityConfigurations = g1Var;
    }

    public /* synthetic */ s8(yq yqVar, mj mjVar, u6 u6Var, rm rmVar, a4 a4Var, pu puVar, g1 g1Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(yqVar, mjVar, u6Var, rmVar, a4Var, puVar, g1Var);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final g1 getAdQualityConfigurations() {
        return this.adQualityConfigurations;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final a4 getApplicationConfigurations() {
        return this.applicationConfigurations;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final u6 getBannerConfigurations() {
        return this.bannerConfigurations;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final mj getInterstitialConfigurations() {
        return this.interstitialConfigurations;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final rm getNativeAdConfigurations() {
        return this.nativeAdConfigurations;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final yq getRewardedVideoConfigurations() {
        return this.rewardedVideoConfigurations;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final pu getTestSuiteSettings() {
        return this.testSuiteSettings;
    }

    public String toString() {
        return "configurations(\n" + this.rewardedVideoConfigurations + '\n' + this.interstitialConfigurations + '\n' + this.bannerConfigurations + '\n' + this.nativeAdConfigurations + ')';
    }
}
