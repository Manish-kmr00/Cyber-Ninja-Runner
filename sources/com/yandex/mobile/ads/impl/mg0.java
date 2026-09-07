package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public abstract class mg0 extends bk<String> {
    private final ye1 w;
    private final pn1 x;

    @Override // com.yandex.mobile.ads.impl.bk
    protected final zj<String> a(String url, String query) {
        JSONObject jsonObject;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(query, "query");
        Context contextL = l();
        o3 o3VarF = f();
        lx1.f9575a.getClass();
        u3 u3Var = new u3(contextL, o3VarF, url, query, this, this, lx1.a.a(contextL), new ng0(), new d8());
        v7 v7VarA = f().a();
        String strOptString = null;
        String strG = v7VarA != null ? v7VarA.g() : null;
        this.w.getClass();
        if (strG != null && (jsonObject = rq0.a(strG)) != null) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            Intrinsics.checkNotNullParameter("response", "name");
            if (jsonObject.has("response")) {
                strOptString = jsonObject.optString("response");
            }
        }
        if (strOptString != null) {
            this.x.a(u3Var, strOptString);
        }
        return u3Var;
    }

    public /* synthetic */ mg0(Context context, o3 o3Var, g5 g5Var) {
        this(context, o3Var, g5Var, pu.a(), new ye1(), pn1.b.a());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected mg0(Context context, o3 adConfiguration, g5 adLoadingPhasesManager, CoroutineScope coroutineScope, ye1 openBiddingReadyResponseProvider, pn1 responseStorage) {
        super(context, adLoadingPhasesManager, adConfiguration, coroutineScope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(openBiddingReadyResponseProvider, "openBiddingReadyResponseProvider");
        Intrinsics.checkNotNullParameter(responseStorage, "responseStorage");
        this.w = openBiddingReadyResponseProvider;
        this.x = responseStorage;
    }
}
