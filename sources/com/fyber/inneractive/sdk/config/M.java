package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.c0;
import com.fyber.inneractive.sdk.util.d0;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class M implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f1676a = null;
    public UnitDisplayType b;
    public Boolean c;
    public Integer d;

    @Override // com.fyber.inneractive.sdk.util.c0
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        d0.a(jSONObject, ToolBar.REFRESH, this.f1676a);
        d0.a(jSONObject, "unitDisplayType", this.b);
        d0.a(jSONObject, "close", this.c);
        d0.a(jSONObject, "hideDelay", this.d);
        return jSONObject;
    }
}
