package com.fyber.inneractive.sdk.response;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.ignite.m;
import com.fyber.inneractive.sdk.network.EnumC3138n;
import com.fyber.inneractive.sdk.network.InterfaceC3139o;
import com.fyber.inneractive.sdk.util.AbstractC3247k;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC3139o f2323a;

    public k(InterfaceC3139o interfaceC3139o) {
        this.f2323a = interfaceC3139o;
    }

    @Override // com.fyber.inneractive.sdk.response.j
    public final void a(b bVar) {
        float f;
        Long lValueOf;
        bVar.f2320a.D = false;
        IAConfigManager.O.x.e = false;
        ImpressionData impressionData = new ImpressionData();
        Map mapB = this.f2323a.b();
        String strA = a(mapB, EnumC3138n.RETURNED_AD_TYPE);
        a(mapB, EnumC3138n.ERROR_CODE);
        String strA2 = a(mapB, EnumC3138n.SESSION_ID);
        String strA3 = a(mapB, EnumC3138n.CONTENT_ID);
        a(mapB, EnumC3138n.PUBLISHER_ID);
        String strA4 = a(mapB, EnumC3138n.WIDTH);
        String strA5 = a(mapB, EnumC3138n.HEIGHT);
        String strA6 = a(mapB, EnumC3138n.SDK_IMPRESSION_URL);
        String strA7 = a(mapB, EnumC3138n.SDK_CLICK_URL);
        String strA8 = a(mapB, EnumC3138n.ATTRIBUTION_IMPRESSION_URL);
        String strA9 = a(mapB, EnumC3138n.ATTRIBUTION_CLICK_URL);
        String strA10 = a(mapB, EnumC3138n.AD_TIMEOUT);
        String strA11 = a(mapB, EnumC3138n.AD_COMPLETION_URL);
        bVar.b = a(mapB, EnumC3138n.AD_UNIT_ID);
        a(mapB, EnumC3138n.AD_UNIT_TYPE);
        String strA12 = a(mapB, EnumC3138n.AD_UNIT_DISPLAY_TYPE);
        String strA13 = a(mapB, EnumC3138n.AD_NETWORK);
        String strA14 = a(mapB, EnumC3138n.AD_NETWORK_ID);
        String strA15 = a(mapB, EnumC3138n.CREATIVE_ID);
        String strA16 = a(mapB, EnumC3138n.AD_DOMAIN);
        String strA17 = a(mapB, EnumC3138n.APP_BUNDLE);
        String strA18 = a(mapB, EnumC3138n.CAMPAIGN_ID);
        String strA19 = a(mapB, EnumC3138n.CPM_VALUE);
        String strA20 = a(mapB, EnumC3138n.CPM_CURRENCY);
        impressionData.setCpmValue(strA19);
        impressionData.setCurrency(strA20);
        String strA21 = a(mapB, EnumC3138n.BANNER_MRC_PERCENT);
        String strA22 = a(mapB, EnumC3138n.BANNER_MRC_DURATION);
        String strA23 = a(mapB, EnumC3138n.BANNER_MRC_IMPRESSION_URL);
        String strA24 = a(mapB, EnumC3138n.INTERSTITIAL_SKIP_MODE);
        String strA25 = a(mapB, EnumC3138n.IGNITE_INSTALL_URL);
        String strA26 = a(mapB, EnumC3138n.IGNITE_MODE);
        String strA27 = a(mapB, EnumC3138n.APP_BUNDLE_LAUNCHER);
        String strA28 = a(mapB, EnumC3138n.BRAND_BIDDER_SHOW_ENDCARD);
        String strA29 = a(mapB, EnumC3138n.BRAND_BIDDER_CTA_TEXT);
        String strA30 = a(mapB, EnumC3138n.MRAID_VIDEO_SIGNAL);
        e eVar = bVar.f2320a;
        eVar.r = mapB;
        eVar.a(strA10);
        impressionData.setImpressionId(strA2);
        impressionData.setDemandSource(strA13);
        e eVar2 = bVar.f2320a;
        eVar2.d = strA3;
        eVar2.getClass();
        bVar.f2320a.A = strA17;
        if (!TextUtils.isEmpty(strA14)) {
            if (TextUtils.isEmpty(strA14)) {
                lValueOf = null;
            } else {
                try {
                    lValueOf = Long.valueOf(strA14);
                } catch (NumberFormatException unused) {
                    lValueOf = null;
                }
            }
            impressionData.setDemandId(lValueOf);
        }
        if (!TextUtils.isEmpty(strA)) {
            bVar.f2320a.g = Integer.valueOf(strA).intValue();
        }
        if (!TextUtils.isEmpty(strA4)) {
            bVar.f2320a.e = Integer.valueOf(strA4).intValue();
        }
        if (!TextUtils.isEmpty(strA5)) {
            bVar.f2320a.f = Integer.valueOf(strA5).intValue();
        }
        e eVar3 = bVar.f2320a;
        eVar3.k = strA6;
        eVar3.l = strA7;
        eVar3.m = strA8;
        eVar3.n = strA9;
        eVar3.q = strA11;
        eVar3.o = bVar.b;
        try {
            eVar3.p = UnitDisplayType.fromValue(strA12);
        } catch (IllegalArgumentException unused2) {
            bVar.f2320a.p = UnitDisplayType.INTERSTITIAL;
        }
        if (!TextUtils.isEmpty(strA15)) {
            impressionData.setCreativeId(strA15);
        }
        if (!TextUtils.isEmpty(strA16)) {
            impressionData.setAdvertiserDomain(strA16);
        }
        if (!TextUtils.isEmpty(strA18)) {
            impressionData.setCampaignId(strA18);
        }
        impressionData.setCountry(AbstractC3247k.j());
        e eVar4 = bVar.f2320a;
        eVar4.t = impressionData;
        eVar4.v = AbstractC3256u.a(strA21, 0);
        e eVar5 = bVar.f2320a;
        if (TextUtils.isEmpty(strA22)) {
            f = -1.0f;
        } else {
            try {
                f = Float.parseFloat(strA22);
            } catch (NumberFormatException unused3) {
                f = -1.0f;
            }
        }
        eVar5.w = f;
        e eVar6 = bVar.f2320a;
        eVar6.x = strA23;
        eVar6.y = AbstractC3256u.a(strA24, -1);
        if (!TextUtils.isEmpty(strA25)) {
            bVar.f2320a.G = strA25;
        }
        if (!TextUtils.isEmpty(strA26)) {
            e eVar7 = bVar.f2320a;
            m mVarA = m.a(strA26);
            if (mVarA == null) {
                eVar7.getClass();
                mVarA = m.NONE;
            }
            eVar7.H = mVarA;
        }
        if (!TextUtils.isEmpty(strA27)) {
            bVar.f2320a.I = strA27;
        }
        if (!TextUtils.isEmpty(strA28)) {
            bVar.f2320a.E = strA28;
        }
        if (!TextUtils.isEmpty(strA29)) {
            bVar.f2320a.F = strA29;
        }
        bVar.f2320a.J = "1".equals(strA30) || Boolean.parseBoolean(strA30);
    }

    @Override // com.fyber.inneractive.sdk.response.j
    public final String a() {
        return this.f2323a.a().toString();
    }

    public final String a(Map map, EnumC3138n enumC3138n) {
        String lowerCase = enumC3138n.a().toLowerCase(Locale.US);
        String str = (String) map.get(lowerCase);
        IAlog.e("%s%s extracted from response header: %s", IAlog.a(this), lowerCase, str);
        IAlog.d("%s %s : %s", "RESPONSE_HEADER", lowerCase, str);
        return str;
    }
}
