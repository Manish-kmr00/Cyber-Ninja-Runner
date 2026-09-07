package com.mbridge.msdk.videocommon.net;

import android.content.Context;
import android.os.Build;
import com.json.fe;
import com.mbridge.msdk.foundation.same.net.wrapper.e;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.out.MBConfiguration;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.bidmachine.iab.vast.tags.VastAttributes;
import net.pubnative.lite.sdk.models.AdExperience;

/* JADX INFO: compiled from: RewardSettingRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends com.mbridge.msdk.foundation.same.net.wrapper.c {
    public b(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.wrapper.c
    public void addExtraParams(String str, e eVar) {
        try {
            super.addExtraParams(str, eVar);
            eVar.a("platform", "1");
            eVar.a(CommonUrlParts.OS_VERSION, Build.VERSION.RELEASE);
            eVar.a("package_name", k0.t(this.mContext));
            eVar.a(CommonUrlParts.APP_VERSION, k0.B(this.mContext));
            eVar.a("app_version_code", k0.A(this.mContext) + "");
            eVar.a("orientation", k0.F(this.mContext) + "");
            eVar.a("model", k0.n());
            eVar.a(AdExperience.BRAND, k0.s());
            int iS = k0.s(this.mContext);
            eVar.a("network_type", iS + "");
            eVar.a("network_str", k0.a(this.mContext, iS) + "");
            eVar.a(POBConstants.KEY_LANGUAGE, k0.p(this.mContext));
            eVar.a("timezone", k0.w());
            eVar.a("useragent", k0.i());
            eVar.a("sdk_version", MBConfiguration.SDK_VERSION);
            eVar.a("screen_size", k0.n(this.mContext) + VastAttributes.HORIZONTAL_POSITION + k0.m(this.mContext));
            if (com.mbridge.msdk.util.b.a()) {
                eVar.a(fe.Q0, "");
                eVar.a("gp_version", t.d(this.mContext));
                eVar.a("is_clever", com.mbridge.msdk.foundation.same.a.C);
            } else {
                eVar.a(fe.Q0, f.d());
            }
            eVar.a("gaid2", f.c());
            com.mbridge.msdk.foundation.same.net.wrapper.f.h(eVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
