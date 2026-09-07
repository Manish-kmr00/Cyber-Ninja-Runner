package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class r51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10074a;
    private final xp1 b;
    private final pk.a<o8<u61>> c;
    private final pn1 d;
    private final ye1 e;

    /* JADX WARN: Code duplicated, block: B:10:0x0061  */
    public final q51 a(aq1<u61> requestPolicy, o3 adConfiguration, v7 adRequestData, String url, String query) {
        String strOptString;
        JSONObject jsonObject;
        Intrinsics.checkNotNullParameter(requestPolicy, "requestPolicy");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(query, "query");
        q51 q51Var = new q51(this.f10074a, requestPolicy, adConfiguration, url, query, this.b, this.c, new k61(requestPolicy), new t61());
        String strG = adRequestData.g();
        this.e.getClass();
        if (strG == null || (jsonObject = rq0.a(strG)) == null) {
            strOptString = null;
        } else {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            Intrinsics.checkNotNullParameter("response", "name");
            if (jsonObject.has("response")) {
                strOptString = jsonObject.optString("response");
            } else {
                strOptString = null;
            }
        }
        if (strOptString != null) {
            this.d.a(q51Var, strOptString);
        }
        return q51Var;
    }

    public /* synthetic */ r51(Context context, xp1 xp1Var, pk.a aVar) {
        this(context, xp1Var, aVar, pn1.b.a(), new ye1());
    }

    public r51(Context context, xp1 requestListener, pk.a<o8<u61>> responseListener, pn1 responseStorage, ye1 openBiddingReadyResponseProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        Intrinsics.checkNotNullParameter(responseListener, "responseListener");
        Intrinsics.checkNotNullParameter(responseStorage, "responseStorage");
        Intrinsics.checkNotNullParameter(openBiddingReadyResponseProvider, "openBiddingReadyResponseProvider");
        this.f10074a = context;
        this.b = requestListener;
        this.c = responseListener;
        this.d = responseStorage;
        this.e = openBiddingReadyResponseProvider;
    }
}
