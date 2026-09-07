package com.yandex.mobile.ads.impl;

import android.content.Context;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Map;
import java.util.Random;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
final class ga2 extends Lambda implements Function1<bn1, bn1> {
    final /* synthetic */ ha2 b;
    final /* synthetic */ aa2 c;
    final /* synthetic */ o3 d;
    final /* synthetic */ Context e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ga2(ha2 ha2Var, aa2 aa2Var, o3 o3Var, Context context) {
        super(1);
        this.b = ha2Var;
        this.c = aa2Var;
        this.d = o3Var;
        this.e = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public final bn1 invoke(bn1 bn1Var) {
        bn1 queryParams = bn1Var;
        Intrinsics.checkNotNullParameter(queryParams, "queryParams");
        ha2 ha2Var = this.b;
        aa2 aa2Var = this.c;
        o3 o3Var = this.d;
        Context context = this.e;
        queryParams.a("charset", "UTF-8");
        ha2Var.f9078a.getClass();
        queryParams.a("rnd", String.valueOf(new Random().nextInt(89999999) + 10000000));
        Map<String, String> mapA = aa2Var.a();
        if (mapA != null) {
            for (Map.Entry<String, String> entry : mapA.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!StringsKt.isBlank(key)) {
                    queryParams.a(key, value);
                }
            }
        }
        l50 l50VarK = o3Var.k();
        ha2Var.c.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        if (!dx1.a(context)) {
            queryParams.a(CommonUrlParts.UUID, l50VarK.g());
            queryParams.a("mauid", l50VarK.e());
        }
        ha2Var.b.getClass();
        fq.a(context, queryParams);
        new n50(context, o3Var).a(context, queryParams);
        return queryParams;
    }
}
