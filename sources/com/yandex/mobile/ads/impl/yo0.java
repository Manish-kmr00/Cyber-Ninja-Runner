package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class yo0 extends pk<ox> {
    private final Context x;
    private final aq1<ox> y;
    private final Map<String, String> z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yo0(Context context, String url, aq1 requestPolicy, Map customHeaders, kl0 listener) {
        super(context, url, listener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(requestPolicy, "requestPolicy");
        Intrinsics.checkNotNullParameter(customHeaders, "customHeaders");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.x = context;
        this.y = requestPolicy;
        this.z = customHeaders;
    }

    @Override // com.yandex.mobile.ads.impl.np1
    protected final qq1<ox> a(tc1 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (200 != response.f10286a) {
            qq1<ox> qq1VarA = qq1.a(new r3(x3.e, response));
            Intrinsics.checkNotNull(qq1VarA);
            return qq1VarA;
        }
        ox oxVarA = this.y.a(response);
        qq1<ox> qq1VarA2 = oxVarA != null ? qq1.a(oxVarA, th0.a(response)) : qq1.a(new r3(x3.c, response));
        Intrinsics.checkNotNull(qq1VarA2);
        return qq1VarA2;
    }

    @Override // com.yandex.mobile.ads.impl.pk, com.yandex.mobile.ads.impl.np1
    protected final ki2 b(ki2 volleyError) {
        Intrinsics.checkNotNullParameter(volleyError, "volleyError");
        op0.c(new Object[0]);
        return super.b(volleyError);
    }

    @Override // com.yandex.mobile.ads.impl.np1
    public final Map<String, String> e() {
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
}
