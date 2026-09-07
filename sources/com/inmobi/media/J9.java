package com.inmobi.media;

import android.content.Context;
import com.android.billingclient.api.BillingClient;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class J9 extends Lambda implements Function1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J9() {
        super(1);
        String str = L9.f3126a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws JSONException {
        K5 k5A;
        M9 m9 = (M9) obj;
        String str = L9.f3126a;
        L9.d = 2;
        if (m9 == null) {
            C3330ca c3330ca = L9.b;
            if (c3330ca != null) {
                c3330ca.f3284a = null;
                BillingClient billingClient = c3330ca.b;
                if (billingClient != null) {
                    billingClient.endConnection();
                }
            }
            L9.b = null;
        } else {
            m9.toString();
            JSONObject jSONObject = new JSONObject();
            int i = m9.f3136a;
            if (i > 0) {
                jSONObject.put("p", i);
            }
            int i2 = m9.b;
            if (i2 > 0) {
                jSONObject.put("s", i2);
            }
            String nipMapJSON = jSONObject.length() == 0 ? null : jSONObject.toString();
            if (nipMapJSON != null) {
                L9.f3126a = nipMapJSON;
                Intrinsics.checkNotNullParameter(nipMapJSON, "nipMapJSON");
                Intrinsics.checkNotNullParameter(nipMapJSON, "nipMapJSON");
                Context contextD = C3517pb.d();
                if (contextD != null) {
                    ConcurrentHashMap concurrentHashMap = K5.b;
                    k5A = J5.a(contextD, "purchase_store");
                } else {
                    k5A = null;
                }
                if (k5A != null) {
                    k5A.a("purchase_pref", nipMapJSON);
                }
            }
            C3330ca c3330ca2 = L9.b;
            if (c3330ca2 != null) {
                c3330ca2.f3284a = null;
                BillingClient billingClient2 = c3330ca2.b;
                if (billingClient2 != null) {
                    billingClient2.endConnection();
                }
            }
            L9.b = null;
        }
        return Unit.INSTANCE;
    }
}
