package com.chartboost.sdk.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J0\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/chartboost/sdk/impl/l;", "", "Lcom/chartboost/sdk/impl/z6;", "params", "Lkotlin/Function1;", "Lcom/chartboost/sdk/impl/a7;", "", "Lkotlin/ExtensionFunctionType;", "callback", "a", "(Lcom/chartboost/sdk/impl/z6;Lkotlin/jvm/functions/Function1;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public interface l {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a {
        public static String a(l lVar, JSONObject receiver, String error, String response) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(response, "response");
            try {
                receiver.put("error", error);
                receiver.put("response", response);
            } catch (Exception e) {
                b7.b("Cannot create error json for the event", e);
            }
            String string = receiver.toString();
            Intrinsics.checkNotNullExpressionValue(string, "apply {\n            try …   }\n        }.toString()");
            return string;
        }
    }

    void a(z6 params, Function1<? super a7, Unit> callback);
}
