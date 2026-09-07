package com.fyber.inneractive.sdk.bidder.adm;

import android.text.TextUtils;
import android.util.Base64;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.flow.B;
import com.fyber.inneractive.sdk.network.f0;
import com.fyber.inneractive.sdk.util.AbstractC3247k;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Locale;

/* JADX INFO: loaded from: classes12.dex */
public final class y implements com.fyber.inneractive.sdk.response.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdmParametersOuterClass$AdmParameters f1627a;
    public final String b;
    public String c;
    public final String d;

    public y(String str, String str2) {
        this.b = str;
        this.d = str2;
    }

    public final void a(B b, com.fyber.inneractive.sdk.config.global.r rVar) {
        try {
            AdmParametersOuterClass$AdmParameters from = AdmParametersOuterClass$AdmParameters.parseFrom(Base64.decode(this.b, 0));
            this.f1627a = from;
            if (from != null) {
                b.a();
            }
            b(b, rVar);
        } catch (Exception e) {
            IAlog.f("failed to parse ad markup payload %s", e.getMessage());
            com.fyber.inneractive.sdk.util.r.b.post(new u(b, e));
        }
    }

    public final void b(B b, com.fyber.inneractive.sdk.config.global.r rVar) {
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = this.f1627a;
        com.fyber.inneractive.sdk.response.e eVar = null;
        String markupUrl = (admParametersOuterClass$AdmParameters == null || !admParametersOuterClass$AdmParameters.hasMarkupUrl()) ? null : this.f1627a.getMarkupUrl();
        if (TextUtils.isEmpty(markupUrl)) {
            com.fyber.inneractive.sdk.util.r.b.post(new x(b));
            return;
        }
        try {
            AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters2 = this.f1627a;
            int iA = admParametersOuterClass$AdmParameters2 != null ? admParametersOuterClass$AdmParameters2.getAdType().a() : c.OTHER.a();
            com.fyber.inneractive.sdk.response.a aVarA = com.fyber.inneractive.sdk.response.a.a(iA);
            if (aVarA == null) {
                aVarA = com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_MRAID;
            }
            com.fyber.inneractive.sdk.factories.e eVar2 = (com.fyber.inneractive.sdk.factories.e) com.fyber.inneractive.sdk.factories.d.f1768a.f1769a.get(aVarA);
            com.fyber.inneractive.sdk.response.b bVarB = eVar2 != null ? eVar2.b() : null;
            if (bVarB != null) {
                bVarB.f2320a = bVarB.a();
                a(bVarB);
                eVar = bVarB.f2320a;
            } else {
                IAlog.a("failed parse adm network request with no input stream - received ad type %s does not have an appropriate parser", Integer.valueOf(iA));
            }
        } catch (Exception e) {
            IAlog.a("failed parse adm network request with no input stream", e, new Object[0]);
        }
        com.fyber.inneractive.sdk.response.e eVar3 = eVar;
        f0 f0Var = new f0(new v(this, b, eVar3), markupUrl, this, rVar, eVar3);
        f0Var.d = new w(this);
        IAConfigManager.O.s.b(f0Var);
    }

    /* JADX WARN: Code duplicated, block: B:166:0x035d  */
    @Override // com.fyber.inneractive.sdk.response.j
    public final void a(com.fyber.inneractive.sdk.response.b bVar) {
        int i;
        com.fyber.inneractive.sdk.ignite.m mVar;
        bVar.f2320a.D = true;
        IAConfigManager.O.x.e = true;
        ImpressionData impressionData = new ImpressionData();
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = this.f1627a;
        if (admParametersOuterClass$AdmParameters == null) {
            return;
        }
        int iA = admParametersOuterClass$AdmParameters.getAdType().a();
        if (this.f1627a.hasErrorMessage()) {
            this.f1627a.getErrorMessage();
        }
        String sessionId = this.f1627a.hasSessionId() ? this.f1627a.getSessionId() : null;
        Long lValueOf = this.f1627a.hasContentId() ? Long.valueOf(this.f1627a.getContentId()) : null;
        if (this.f1627a.hasPublisherId()) {
            this.f1627a.getPublisherId();
        }
        Integer numValueOf = this.f1627a.hasAdWidth() ? Integer.valueOf(this.f1627a.getAdWidth()) : null;
        Integer numValueOf2 = this.f1627a.hasAdHeight() ? Integer.valueOf(this.f1627a.getAdHeight()) : null;
        String sdkImpressionUrl = this.f1627a.hasSdkImpressionUrl() ? this.f1627a.getSdkImpressionUrl() : null;
        String sdkClickUrl = this.f1627a.hasSdkClickUrl() ? this.f1627a.getSdkClickUrl() : null;
        Integer numValueOf3 = this.f1627a.hasAdExpirationInterval() ? Integer.valueOf(this.f1627a.getAdExpirationInterval()) : null;
        String adCompletionUrl = this.f1627a.hasAdCompletionUrl() ? this.f1627a.getAdCompletionUrl() : null;
        String attributionImpressionUrl = this.f1627a.hasAttributionImpressionUrl() ? this.f1627a.getAttributionImpressionUrl() : null;
        String attributionClickUrl = this.f1627a.hasAttributionClickUrl() ? this.f1627a.getAttributionClickUrl() : null;
        bVar.b = this.f1627a.hasAdUnitId() ? this.f1627a.getAdUnitId() : null;
        this.f1627a.getAdUnitType().name().toLowerCase();
        String lowerCase = this.f1627a.hasAdUnitId() ? this.f1627a.getAdUnitDisplayType().name().toLowerCase(Locale.US) : null;
        String adNetworkName = this.f1627a.hasAdNetworkName() ? this.f1627a.getAdNetworkName() : null;
        Long lValueOf2 = this.f1627a.hasAdNetworkId() ? Long.valueOf(this.f1627a.getAdNetworkId()) : null;
        String creativeId = this.f1627a.hasCreativeId() ? this.f1627a.getCreativeId() : null;
        String adDomain = this.f1627a.hasAdDomain() ? this.f1627a.getAdDomain() : null;
        String appBundleId = this.f1627a.hasAppBundleId() ? this.f1627a.getAppBundleId() : null;
        String campaignId = this.f1627a.hasCampaignId() ? this.f1627a.getCampaignId() : null;
        String string = this.f1627a.hasPricingValue() ? Double.toString(this.f1627a.getPricingValue()) : null;
        String strValueOf = this.f1627a.hasSpotId() ? String.valueOf(this.f1627a.getSpotId()) : null;
        impressionData.setCpmValue(string);
        impressionData.setCurrency("USD");
        if (this.f1627a.hasMrcData()) {
            int pixelPercent = this.f1627a.getMrcData().hasPixelPercent() ? this.f1627a.getMrcData().getPixelPercent() : 0;
            int pixelDuration = this.f1627a.getMrcData().hasPixelDuration() ? this.f1627a.getMrcData().getPixelDuration() : -1;
            String pixelImpressionUrl = this.f1627a.getMrcData().hasPixelImpressionUrl() ? this.f1627a.getMrcData().getPixelImpressionUrl() : null;
            com.fyber.inneractive.sdk.response.e eVar = bVar.f2320a;
            eVar.v = pixelPercent;
            eVar.w = pixelDuration;
            eVar.x = pixelImpressionUrl;
        } else {
            numValueOf2 = numValueOf2;
            sdkImpressionUrl = sdkImpressionUrl;
            sdkClickUrl = sdkClickUrl;
        }
        Boolean boolValueOf = this.f1627a.hasSkipMode() ? Boolean.valueOf(this.f1627a.getSkipMode()) : null;
        bVar.f2320a.s = this.f1627a.toString();
        bVar.f2320a.a(numValueOf3 != null ? numValueOf3.toString() : "");
        impressionData.setImpressionId(sessionId);
        impressionData.setDemandSource(adNetworkName);
        bVar.f2320a.d = lValueOf != null ? lValueOf.toString() : "";
        bVar.f2320a.getClass();
        bVar.f2320a.getClass();
        com.fyber.inneractive.sdk.response.e eVar2 = bVar.f2320a;
        eVar2.A = appBundleId;
        eVar2.B = this.d;
        eVar2.C = strValueOf;
        if (lValueOf2 != null) {
            impressionData.setDemandId(lValueOf2);
        }
        com.fyber.inneractive.sdk.response.e eVar3 = bVar.f2320a;
        eVar3.g = iA;
        if (numValueOf != null) {
            eVar3.e = numValueOf.intValue();
        }
        if (numValueOf2 != null) {
            bVar.f2320a.f = numValueOf2.intValue();
        }
        com.fyber.inneractive.sdk.response.e eVar4 = bVar.f2320a;
        eVar4.k = sdkImpressionUrl;
        eVar4.l = sdkClickUrl;
        eVar4.q = adCompletionUrl;
        eVar4.m = attributionImpressionUrl;
        eVar4.n = attributionClickUrl;
        eVar4.o = bVar.b;
        try {
            eVar4.p = UnitDisplayType.fromValue(lowerCase);
        } catch (IllegalArgumentException unused) {
            bVar.f2320a.p = UnitDisplayType.INTERSTITIAL;
        }
        if (!TextUtils.isEmpty(creativeId)) {
            impressionData.setCreativeId(creativeId);
        }
        if (!TextUtils.isEmpty(adDomain)) {
            impressionData.setAdvertiserDomain(adDomain);
        }
        if (!TextUtils.isEmpty(campaignId)) {
            impressionData.setCampaignId(campaignId);
        }
        impressionData.setCountry(AbstractC3247k.j());
        bVar.f2320a.t = impressionData;
        if (boolValueOf == null) {
            i = -1;
        } else {
            i = boolValueOf.booleanValue() ? 1 : 0;
        }
        bVar.f2320a.y = i;
        String igniteInstallUrl = this.f1627a.hasIgniteInstallUrl() ? this.f1627a.getIgniteInstallUrl() : null;
        if (!TextUtils.isEmpty(igniteInstallUrl)) {
            bVar.f2320a.G = igniteInstallUrl;
        }
        com.fyber.inneractive.sdk.response.e eVar5 = bVar.f2320a;
        com.fyber.inneractive.sdk.ignite.m mVar2 = com.fyber.inneractive.sdk.ignite.m.NONE;
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters2 = this.f1627a;
        if (admParametersOuterClass$AdmParameters2 == null) {
            mVar = mVar2;
        } else {
            n igniteMode = admParametersOuterClass$AdmParameters2.hasIgniteMode() ? this.f1627a.getIgniteMode() : null;
            if (igniteMode == null || igniteMode.equals(n.NONE)) {
                mVar = mVar2;
            } else {
                mVar = igniteMode.equals(n.SINGLETAP) ? com.fyber.inneractive.sdk.ignite.m.SINGLE_TAP : com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP;
            }
        }
        if (mVar != null) {
            mVar2 = mVar;
        } else {
            eVar5.getClass();
        }
        eVar5.H = mVar2;
        String igniteLauncherActivity = this.f1627a.hasIgniteLauncherActivity() ? this.f1627a.getIgniteLauncherActivity() : null;
        if (!TextUtils.isEmpty(igniteLauncherActivity)) {
            bVar.f2320a.I = igniteLauncherActivity;
        }
        Boolean boolValueOf2 = this.f1627a.hasBrandBidderDontShowEndcard() ? Boolean.valueOf(this.f1627a.getBrandBidderDontShowEndcard()) : null;
        if (boolValueOf2 != null) {
            bVar.f2320a.E = boolValueOf2.booleanValue() ? "1" : "0";
        }
        String brandBidderCtaText = this.f1627a.getBrandBidderCtaText();
        if (!TextUtils.isEmpty(brandBidderCtaText)) {
            bVar.f2320a.F = brandBidderCtaText;
        }
        Boolean boolValueOf3 = this.f1627a.hasMraidVideoOMSignal() ? Boolean.valueOf(this.f1627a.getMraidVideoOMSignal()) : null;
        if (boolValueOf3 != null) {
            bVar.f2320a.J = boolValueOf3.booleanValue();
        }
    }

    @Override // com.fyber.inneractive.sdk.response.j
    public final String a() {
        return this.c;
    }
}
