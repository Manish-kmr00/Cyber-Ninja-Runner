package com.mbridge.msdk.video.dynview.request;

import android.content.Context;
import android.os.Build;
import com.json.fe;
import com.mbridge.msdk.foundation.same.net.wrapper.c;
import com.mbridge.msdk.foundation.same.net.wrapper.e;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.out.MBConfiguration;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import net.pubnative.lite.sdk.models.AdExperience;

/* JADX INFO: compiled from: MoreOfferLoadRequest.java */
/* JADX INFO: loaded from: classes11.dex */
public class b extends c {
    public b(Context context) {
        super(context);
    }

    private void a(e eVar) {
        eVar.a("platform", "1");
        eVar.a(CommonUrlParts.OS_VERSION, Build.VERSION.RELEASE);
        eVar.a("package_name", k0.t(this.mContext));
        eVar.a(CommonUrlParts.APP_VERSION, k0.B(this.mContext));
        eVar.a("app_version_code", k0.A(this.mContext) + "");
        eVar.a("orientation", k0.F(this.mContext) + "");
        eVar.a("model", k0.n());
        eVar.a(AdExperience.BRAND, k0.s());
        eVar.a(fe.Q0, "");
        eVar.a("gaid2", f.c());
        int iS = k0.s(this.mContext);
        eVar.a("network_type", iS + "");
        eVar.a("network_str", k0.a(this.mContext, iS) + "");
        eVar.a(POBConstants.KEY_LANGUAGE, k0.p(this.mContext));
        eVar.a("timezone", k0.w());
        eVar.a("useragent", k0.i());
        eVar.a("sdk_version", MBConfiguration.SDK_VERSION);
        com.mbridge.msdk.foundation.same.net.wrapper.f.a(eVar, this.mContext);
        com.mbridge.msdk.foundation.same.net.wrapper.f.b(eVar);
        com.mbridge.msdk.foundation.same.net.wrapper.f.j(eVar);
    }

    @Override // com.mbridge.msdk.foundation.same.net.wrapper.c
    public void addExtraParams(String str, e eVar) {
        super.addExtraParams(str, eVar);
        a(eVar);
    }
}
