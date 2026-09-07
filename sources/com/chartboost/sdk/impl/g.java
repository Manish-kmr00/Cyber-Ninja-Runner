package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Model.CBError;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJN\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\t\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/chartboost/sdk/impl/g;", "", "", "bidResponse", "Lcom/chartboost/sdk/impl/n1;", "base64Wrapper", "Lkotlin/Function2;", "Lcom/chartboost/sdk/internal/Model/CBError$d;", "", "onLoadFailure", "Lkotlin/Result;", "a", "(Ljava/lang/String;Lcom/chartboost/sdk/impl/n1;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f1021a = new g();

    public Object a(String bidResponse, n1 base64Wrapper, Function2<? super String, ? super CBError.d, Unit> onLoadFailure) {
        Intrinsics.checkNotNullParameter(base64Wrapper, "base64Wrapper");
        Intrinsics.checkNotNullParameter(onLoadFailure, "onLoadFailure");
        String str = null;
        if (bidResponse != null) {
            String strB = base64Wrapper.b(bidResponse);
            if (strB.length() == 0) {
                b7.b("Cannot decode provided bidResponse.", null, 2, null);
                onLoadFailure.invoke("", CBError.b.INVALID_RESPONSE);
                Result.Companion companion = Result.INSTANCE;
                return Result.m7904constructorimpl(ResultKt.createFailure(f.a.b));
            }
            str = strB;
        }
        Result.Companion companion2 = Result.INSTANCE;
        return Result.m7904constructorimpl(str);
    }
}
