package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class mu1 extends pk<cu1> {
    private final fq1 A;
    private final Context x;
    private final aq1<cu1> y;
    private final Map<String, String> z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mu1(Context context, String url, nu1 requestPolicy, Map customHeaders, ou1 requestListener, ou1 listener) {
        super(context, 0, url, listener, requestListener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(requestPolicy, "requestPolicy");
        Intrinsics.checkNotNullParameter(customHeaders, "customHeaders");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.x = context;
        this.y = requestPolicy;
        this.z = customHeaders;
        r();
        s();
        this.A = fq1.c;
    }

    @Override // com.yandex.mobile.ads.impl.np1
    public final qq1<cu1> a(tc1 response) {
        x3 x3Var;
        Intrinsics.checkNotNullParameter(response, "response");
        a(Integer.valueOf(response.f10286a));
        if (200 == response.f10286a) {
            cu1 cu1VarA = this.y.a(response);
            if (cu1VarA != null) {
                Map<String, String> mapEmptyMap = response.c;
                if (mapEmptyMap == null) {
                    mapEmptyMap = MapsKt.emptyMap();
                }
                a(mapEmptyMap);
                qq1<cu1> qq1VarA = qq1.a(cu1VarA, th0.a(response));
                Intrinsics.checkNotNullExpressionValue(qq1VarA, "success(...)");
                return qq1VarA;
            }
            x3Var = x3.c;
        } else {
            x3Var = x3.e;
        }
        qq1<cu1> qq1VarA2 = qq1.a(new r3(x3Var, response));
        Intrinsics.checkNotNullExpressionValue(qq1VarA2, "error(...)");
        return qq1VarA2;
    }

    @Override // com.yandex.mobile.ads.impl.pk, com.yandex.mobile.ads.impl.np1
    public final ki2 b(ki2 volleyError) {
        Intrinsics.checkNotNullParameter(volleyError, "volleyError");
        op0.c(new Object[0]);
        int i = r3.d;
        return super.b((ki2) r3.a.a(volleyError));
    }

    @Override // com.yandex.mobile.ads.impl.np1
    public final Map<String, String> e() throws zh {
        HashMap headers = new HashMap();
        Context context = this.x;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(headers, "headers");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        if (cu1VarA != null && cu1VarA.b0()) {
            headers.put(sh0.V.a(), "1");
        }
        headers.putAll(this.z);
        return headers;
    }

    @Override // com.yandex.mobile.ads.impl.pk
    protected final fq1 w() {
        return this.A;
    }
}
