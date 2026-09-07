package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Model.CBError;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/chartboost/sdk/impl/y7;", "Lcom/chartboost/sdk/impl/i2;", "", InneractiveMediationDefs.GENDER_FEMALE, "()V", "Lcom/chartboost/sdk/impl/f2;", "serverResponse", "Lcom/chartboost/sdk/impl/e2;", "Lorg/json/JSONObject;", "a", "(Lcom/chartboost/sdk/impl/f2;)Lcom/chartboost/sdk/impl/e2;", "Lcom/chartboost/sdk/impl/k7;", "networkParameters", "Lcom/chartboost/sdk/impl/o;", "adParameters", "Lcom/chartboost/sdk/impl/t7;", "omManager", "Lcom/chartboost/sdk/impl/l4;", "eventTracker", "<init>", "(Lcom/chartboost/sdk/impl/k7;Lcom/chartboost/sdk/impl/o;Lcom/chartboost/sdk/impl/t7;Lcom/chartboost/sdk/impl/l4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class y7 extends i2 {
    /* JADX WARN: Illegal instructions before constructor call */
    public y7(k7 networkParameters, o oVar, t7 t7Var, l4 l4Var) {
        Intrinsics.checkNotNullParameter(networkParameters, "networkParameters");
        c2.c cVar = networkParameters.f1060a;
        Intrinsics.checkNotNullExpressionValue(cVar, "networkParameters.method");
        String str = networkParameters.b;
        Intrinsics.checkNotNullExpressionValue(str, "networkParameters.endpoint");
        String str2 = networkParameters.c;
        Intrinsics.checkNotNullExpressionValue(str2, "networkParameters.path");
        f9 f9Var = networkParameters.d;
        k8 k8Var = networkParameters.e;
        Intrinsics.checkNotNullExpressionValue(k8Var, "networkParameters.priority");
        i2.a aVar = networkParameters.f;
        Intrinsics.checkNotNull(l4Var);
        super(cVar, str, str2, f9Var, k8Var, null, aVar, l4Var);
        JSONObject jSONObjectH = new z7(networkParameters.d, oVar, t7Var).h();
        Intrinsics.checkNotNullExpressionValue(jSONObjectH, "OpenRTBRequestModel(\n   …     ).jsonRepresentation");
        a(jSONObjectH);
    }

    @Override // com.chartboost.sdk.impl.i2
    public void f() {
    }

    @Override // com.chartboost.sdk.impl.i2, com.chartboost.sdk.impl.c2
    public e2<JSONObject> a(f2 serverResponse) {
        byte[] data;
        try {
            if (serverResponse == null || (data = serverResponse.getData()) == null) {
                data = new byte[0];
            }
            return e2.INSTANCE.a(new JSONObject(new String(data, Charsets.UTF_8)));
        } catch (JSONException e) {
            b7.b("parseServerResponse", e);
            return e2.INSTANCE.a(new CBError(CBError.c.HTTP_NOT_FOUND, "No Bid"));
        }
    }
}
