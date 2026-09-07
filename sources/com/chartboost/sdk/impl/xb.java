package com.chartboost.sdk.impl;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0007\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\n¨\u0006\r"}, d2 = {"Lcom/chartboost/sdk/impl/xb;", "", "", "webviewMessage", "Lcom/chartboost/sdk/impl/xb$a;", "callback", "", "a", "(Ljava/lang/String;Lcom/chartboost/sdk/impl/xb$a;)V", "", "(Ljava/lang/String;)Z", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class xb {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/chartboost/sdk/impl/xb$a;", "", "Lorg/json/JSONObject;", "data", "", "a", "(Lorg/json/JSONObject;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public interface a {
        void a(JSONObject data);
    }

    public final void a(String webviewMessage, a callback) {
        if (a(webviewMessage)) {
            b7.b("CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource", null, 2, null);
            if (callback != null) {
                callback.a(new JSONObject().put("message", "CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource"));
            }
        }
    }

    public final boolean a(String webviewMessage) {
        return (webviewMessage == null || !StringsKt.contains$default((CharSequence) webviewMessage, (CharSequence) HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, false, 2, (Object) null) || !StringsKt.contains$default((CharSequence) webviewMessage, (CharSequence) "'null'", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) webviewMessage, (CharSequence) com.safedk.android.analytics.brandsafety.creatives.discoveries.d.v, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) webviewMessage, (CharSequence) "https://", false, 2, (Object) null)) ? false : true;
    }
}
