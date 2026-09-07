package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.network.C3142s;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3108m extends AbstractC3110o {
    public C3107l g;

    public C3108m(String str) {
        super(str);
    }

    public static void a(boolean z, com.fyber.inneractive.sdk.response.e eVar, InneractiveAdRequest inneractiveAdRequest) {
        String str;
        String spotId = inneractiveAdRequest.getSpotId();
        IAConfigManager iAConfigManager = IAConfigManager.O;
        String str2 = (String) iAConfigManager.x.c.get("KEY_MISSMATCH_STATS_SPOTS");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (str2.contains("-" + spotId + "-")) {
            return;
        }
        C3146w c3146w = new C3146w(EnumC3143t.MISSMATCH_SPOTID, inneractiveAdRequest, eVar);
        if (z) {
            str = "There is no " + spotId + " spot ID in current app config";
        } else {
            str = "spot ID " + spotId + " is not active in current app config";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reason", str);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "reason", str);
        }
        c3146w.f.put(jSONObject);
        c3146w.a((String) null);
        iAConfigManager.x.c.put("KEY_MISSMATCH_STATS_SPOTS", str2 + " -" + spotId + "-");
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public final void b() {
        IAlog.a("%s onRetry()", IAlog.a(this));
    }

    public final void c(InneractiveAdRequest inneractiveAdRequest) {
        AbstractC3110o abstractC3110o;
        com.fyber.inneractive.sdk.config.V v;
        UnitDisplayType unitDisplayType;
        InterfaceC3109n interfaceC3109n;
        if (!InneractiveAdManager.wasInitialized() && (interfaceC3109n = this.b) != null) {
            ((D) interfaceC3109n).a(inneractiveAdRequest, c(), new InneractiveInfrastructureError(InneractiveErrorCode.SDK_NOT_INITIALIZED, EnumC3104i.NO_APP_CONFIG_AVAILABLE));
        }
        String spotId = inneractiveAdRequest.getSpotId();
        IAConfigManager iAConfigManager = IAConfigManager.O;
        HashMap map = iAConfigManager.f1673a;
        com.fyber.inneractive.sdk.config.S s = (map == null || !map.containsKey(spotId)) ? null : (com.fyber.inneractive.sdk.config.S) iAConfigManager.f1673a.get(spotId);
        com.fyber.inneractive.sdk.response.e eVarC = c();
        if (s != null && !s.b) {
            a(false, eVarC, inneractiveAdRequest);
            ((D) this.b).a(inneractiveAdRequest, c(), new InneractiveInfrastructureError(InneractiveErrorCode.SPOT_DISABLED, EnumC3104i.NO_APP_CONFIG_AVAILABLE));
            return;
        }
        if (s == null || !s.f1680a.iterator().hasNext()) {
            if (s == null) {
                a(true, eVarC, inneractiveAdRequest);
                IAConfigManager.a();
            }
            IAlog.f("************************************************************************************************************************", new Object[0]);
            IAlog.f("*** Requested spot id '%s' doesn't exist within this application config - application Id: '%s'", inneractiveAdRequest.getSpotId(), iAConfigManager.c);
            IAlog.f("*** Are you sure that you are using the correct application and spot ids, as defined for this application in the Inneractive console?", new Object[0]);
            IAlog.f("************************************************************************************************************************", new Object[0]);
            ((D) this.b).a(inneractiveAdRequest, eVarC, new InneractiveInfrastructureError(InneractiveErrorCode.ERROR_CONFIGURATION_NO_SUCH_SPOT, EnumC3104i.NO_APP_CONFIG_AVAILABLE));
            return;
        }
        com.fyber.inneractive.sdk.config.T t = (com.fyber.inneractive.sdk.config.T) s.f1680a.get(0);
        if (t.c == null && ((v = t.f) == null || !((unitDisplayType = v.j) == UnitDisplayType.INTERSTITIAL || unitDisplayType == UnitDisplayType.REWARDED))) {
            ((D) this.b).a(inneractiveAdRequest, c(), new InneractiveInfrastructureError(InneractiveErrorCode.UNSUPPORTED_SPOT, EnumC3104i.NO_APP_CONFIG_AVAILABLE));
            return;
        }
        com.fyber.inneractive.sdk.config.global.r rVarA = com.fyber.inneractive.sdk.config.global.r.a();
        this.c = rVarA;
        rVarA.a(false, inneractiveAdRequest.getSpotId());
        C3142s c3142s = new C3142s(inneractiveAdRequest, inneractiveAdRequest.b, this.c, this);
        this.d = c3142s;
        c3142s.b = false;
        IAlog.a("IARemoteAdFetcher: requestAd called", new Object[0]);
        if (TextUtils.isEmpty(inneractiveAdRequest.getSpotId())) {
            IAlog.b("appID is null or empty. Please provide a valid appID and re-try.", new Object[0]);
        } else {
            if (AbstractC3251o.a("android.permission.INTERNET")) {
                if (!AbstractC3251o.a("android.permission.ACCESS_NETWORK_STATE")) {
                    IAlog.b("It is recommended to add ACCESS_NETWORK_STATE permission to the Manifest for better targetting", new Object[0]);
                }
                if (!AbstractC3251o.a("android.permission.READ_PHONE_STATE")) {
                    IAlog.f("It is recomended to add the READ_PHONE_STATE permission to the manifest for better targetting", new Object[0]);
                }
                iAConfigManager.s.b(c3142s.f);
                return;
            }
            IAlog.b("INTERNET permission is missing. Please add it to the Manifest and re-try, otherwise ads will not be requested and displayed! ", new Object[0]);
        }
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.INVALID_INPUT, EnumC3104i.VALIDATE_PARAMS_FAILED, new Exception("appID is null or empty or INTERNET permission is missing"));
        if (c3142s.b || (abstractC3110o = c3142s.f1926a) == null) {
            return;
        }
        abstractC3110o.a(inneractiveAdRequest, null, inneractiveInfrastructureError);
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3110o
    public final String d() {
        return IAlog.a(this);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public final void a() {
        IAlog.a("%s onTimeout()", IAlog.a(this));
    }
}
