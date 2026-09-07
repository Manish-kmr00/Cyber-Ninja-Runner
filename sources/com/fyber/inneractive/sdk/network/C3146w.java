package com.fyber.inneractive.sdk.network;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.AbstractC3071a;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Track;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.IAlog;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.network.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3146w {
    public static final SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InneractiveAdRequest f1934a;
    public EnumC3143t b;
    public EnumC3144u c;
    public JSONArray d;
    public final com.fyber.inneractive.sdk.response.e e;
    public final JSONArray f;
    public boolean g;

    public C3146w(EnumC3143t enumC3143t) {
        this((com.fyber.inneractive.sdk.response.e) null);
        this.b = enumC3143t;
        this.f1934a = null;
        this.d = null;
    }

    public final C3146w a(Object... objArr) {
        if (objArr.length > 0) {
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < objArr.length - 1; i += 2) {
                String string = objArr[i].toString();
                Object obj = objArr[i + 1];
                try {
                    jSONObject.put(string, obj);
                } catch (Exception unused) {
                    IAlog.f("Got exception adding param to json object: %s, %s", string, obj);
                }
            }
            this.f.put(jSONObject);
        }
        return this;
    }

    public C3146w(EnumC3143t enumC3143t, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar) {
        this(eVar);
        this.b = enumC3143t;
        this.f1934a = inneractiveAdRequest;
        this.d = null;
    }

    public C3146w(EnumC3144u enumC3144u) {
        this((com.fyber.inneractive.sdk.response.e) null);
        this.c = enumC3144u;
        this.f1934a = null;
        this.d = null;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x014d  */
    /* JADX WARN: Code duplicated, block: B:104:0x0152  */
    /* JADX WARN: Code duplicated, block: B:107:0x015f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0161  */
    /* JADX WARN: Code duplicated, block: B:111:0x016c  */
    /* JADX WARN: Code duplicated, block: B:112:0x016f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0122  */
    /* JADX WARN: Code duplicated, block: B:94:0x0131  */
    /* JADX WARN: Code duplicated, block: B:95:0x0133  */
    public final void a(String str) {
        String str2;
        String str3;
        Long l;
        String str4;
        String str5;
        String campaignId;
        String str6;
        String spotId;
        StringBuilder sb;
        com.fyber.inneractive.sdk.response.e eVar;
        UnitDisplayType unitDisplayTypeA;
        String string;
        com.fyber.inneractive.sdk.response.e eVar2;
        Integer numValueOf;
        com.fyber.inneractive.sdk.response.e eVar3;
        String str7;
        InneractiveAdRequest inneractiveAdRequest;
        com.fyber.inneractive.sdk.response.e eVar4;
        boolean zIsDeprecated;
        UnitDisplayType unitDisplayType;
        UnitDisplayType unitDisplayType2;
        if (IAConfigManager.d() && !EnumC3144u.IA_IAB_GDPR_TCF_PURPOSE_1_DISABLED.equals(this.c)) {
            String strA = IAlog.a(this);
            Object obj = this.c;
            if (obj == null) {
                obj = this.b;
            }
            IAlog.a("%sSdk event dispatcher - aborting dispatch: %s", strA, obj);
            return;
        }
        com.fyber.inneractive.sdk.response.e eVar5 = this.e;
        if (eVar5 != null) {
            ImpressionData impressionData = eVar5.t;
            String impressionId = impressionData != null ? impressionData.getImpressionId() : null;
            ImpressionData impressionData2 = this.e.t;
            String demandSource = impressionData2 != null ? impressionData2.getDemandSource() : null;
            ImpressionData impressionData3 = this.e.t;
            Long demandId = impressionData3 != null ? impressionData3.getDemandId() : null;
            ImpressionData impressionData4 = this.e.t;
            String creativeId = impressionData4 != null ? impressionData4.getCreativeId() : null;
            ImpressionData impressionData5 = this.e.t;
            String advertiserDomain = impressionData5 != null ? impressionData5.getAdvertiserDomain() : null;
            ImpressionData impressionData6 = this.e.t;
            if (impressionData6 != null) {
                str2 = impressionId;
                str3 = demandSource;
                l = demandId;
                str4 = creativeId;
                str5 = advertiserDomain;
                campaignId = impressionData6.getCampaignId();
            } else {
                str2 = impressionId;
                campaignId = null;
                str3 = demandSource;
                l = demandId;
                str4 = creativeId;
                str5 = advertiserDomain;
            }
        } else {
            str2 = null;
            str3 = null;
            l = null;
            str4 = null;
            str5 = null;
            campaignId = null;
        }
        IAConfigManager iAConfigManager = IAConfigManager.O;
        C3148y c3148y = new C3148y(iAConfigManager.c, str2, str3, l, str4, str5, campaignId, str);
        InneractiveAdRequest inneractiveAdRequest2 = this.f1934a;
        com.fyber.inneractive.sdk.config.U selectedUnitConfig = inneractiveAdRequest2 == null ? null : inneractiveAdRequest2.getSelectedUnitConfig();
        if (selectedUnitConfig != null) {
            com.fyber.inneractive.sdk.config.T t = (com.fyber.inneractive.sdk.config.T) selectedUnitConfig;
            com.fyber.inneractive.sdk.config.P p = t.d;
            Track track = Track.ERRORS;
            Set set = p.f1678a;
            if (!(set == null ? false : set.contains(track))) {
                return;
            }
            com.fyber.inneractive.sdk.config.M m = t.c;
            if (m != null && (unitDisplayType2 = m.b) != null) {
                zIsDeprecated = unitDisplayType2.isDeprecated();
            } else {
                com.fyber.inneractive.sdk.config.V v = t.f;
                zIsDeprecated = (v == null || (unitDisplayType = v.j) == null) ? false : unitDisplayType.isDeprecated();
            }
            if (zIsDeprecated) {
                return;
            }
        }
        if (selectedUnitConfig == null && (eVar4 = this.e) != null) {
            AbstractC3071a.a(eVar4.o);
        }
        com.fyber.inneractive.sdk.response.e eVar6 = this.e;
        String str8 = eVar6 == null ? null : eVar6.d;
        String str9 = TextUtils.isEmpty(iAConfigManager.t) ? null : iAConfigManager.t;
        if (this.b == null && this.c == null) {
            IAlog.a("Sdk event dispatcher - error id or event id must be provided", new Object[0]);
            return;
        }
        InneractiveAdRequest inneractiveAdRequest3 = this.f1934a;
        if (inneractiveAdRequest3 == null) {
            com.fyber.inneractive.sdk.response.e eVar7 = this.e;
            if (eVar7 != null) {
                spotId = eVar7.C;
            } else {
                str6 = null;
            }
            sb = new StringBuilder();
            if (!TextUtils.isEmpty(iAConfigManager.l)) {
                sb.append(iAConfigManager.l).append("_");
            }
            eVar = this.e;
            if (eVar == null) {
                unitDisplayTypeA = null;
            } else {
                unitDisplayTypeA = eVar.p;
            }
            if (unitDisplayTypeA == null && (inneractiveAdRequest = this.f1934a) != null && inneractiveAdRequest.getSpotId() != null) {
                unitDisplayTypeA = com.fyber.inneractive.sdk.serverapi.b.a(this.f1934a.getSpotId());
            }
            if (unitDisplayTypeA != null) {
                string = unitDisplayTypeA.toString();
            } else {
                string = "unknown";
            }
            sb.append(string);
            String string2 = sb.toString();
            eVar2 = this.e;
            if (eVar2 == null) {
                numValueOf = null;
            } else {
                numValueOf = Integer.valueOf(eVar2.g);
            }
            eVar3 = this.e;
            if (eVar3 == null) {
                str7 = "";
            } else {
                str7 = eVar3.h;
            }
            com.fyber.inneractive.sdk.util.r.f2374a.execute(new RunnableC3145v(this, c3148y, str8, str9, string2, str6, numValueOf, str7));
        }
        spotId = inneractiveAdRequest3.getSpotId();
        str6 = spotId;
        sb = new StringBuilder();
        if (!TextUtils.isEmpty(iAConfigManager.l)) {
            sb.append(iAConfigManager.l).append("_");
        }
        eVar = this.e;
        if (eVar == null) {
            unitDisplayTypeA = null;
        } else {
            unitDisplayTypeA = eVar.p;
        }
        if (unitDisplayTypeA == null) {
            unitDisplayTypeA = com.fyber.inneractive.sdk.serverapi.b.a(this.f1934a.getSpotId());
        }
        if (unitDisplayTypeA != null) {
            string = unitDisplayTypeA.toString();
        } else {
            string = "unknown";
        }
        sb.append(string);
        String string3 = sb.toString();
        eVar2 = this.e;
        if (eVar2 == null) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(eVar2.g);
        }
        eVar3 = this.e;
        if (eVar3 == null) {
            str7 = "";
        } else {
            str7 = eVar3.h;
        }
        com.fyber.inneractive.sdk.util.r.f2374a.execute(new RunnableC3145v(this, c3148y, str8, str9, string3, str6, numValueOf, str7));
    }

    public C3146w(EnumC3144u enumC3144u, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar) {
        this(eVar);
        this.c = enumC3144u;
        this.f1934a = inneractiveAdRequest;
        this.d = null;
    }

    public C3146w(com.fyber.inneractive.sdk.response.e eVar) {
        this.g = false;
        this.e = eVar;
        this.f = new JSONArray();
    }
}
