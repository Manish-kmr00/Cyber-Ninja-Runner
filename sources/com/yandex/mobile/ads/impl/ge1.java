package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ge1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m82 f8996a;

    public final op1 a(np1<?> request, Map<String, String> additionalHeaders) throws zh, IOException {
        n01 n01Var;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(additionalHeaders, "additionalHeaders");
        URL urlA = cd1.a(request, this.f8996a);
        Map<String, String> mapE = request.e();
        Intrinsics.checkNotNullExpressionValue(mapE, "getHeaders(...)");
        Map mutableMap = MapsKt.toMutableMap(MapsKt.plus(additionalHeaders, mapE));
        if (!mutableMap.containsKey("Content-Type")) {
            mutableMap.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        }
        nf0 nf0VarA = nf0.b.a(mutableMap);
        n01.c.getClass();
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.f() == -1) {
            n01Var = n01.d;
        } else {
            switch (request.f()) {
                case 0:
                    n01Var = n01.d;
                    break;
                case 1:
                    n01Var = n01.e;
                    break;
                case 2:
                    n01Var = n01.f;
                    break;
                case 3:
                    n01Var = n01.g;
                    break;
                case 4:
                    n01Var = n01.h;
                    break;
                case 5:
                    n01Var = n01.i;
                    break;
                case 6:
                    n01Var = n01.j;
                    break;
                case 7:
                    n01Var = n01.k;
                    break;
                default:
                    throw new IllegalStateException("Unknown method type.".toString());
            }
        }
        byte[] bArrB = request.b();
        return new op1.a().a(urlA).a(nf0VarA).a(n01Var.a(), bArrB != null ? rp1.a.a(bArrB) : null).a();
    }

    public ge1(m82 m82Var) {
        this.f8996a = m82Var;
    }
}
