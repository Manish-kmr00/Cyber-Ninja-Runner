package com.chartboost.sdk.impl;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JÉ\u0001\u0010\r\u001a>\u00124\u00122\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000426\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\t0\u000626\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/chartboost/sdk/impl/c0;", "", "Lcom/chartboost/sdk/impl/y0;", "appRequest", "Lcom/chartboost/sdk/impl/z6;", "params", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "loadOpenRTBAd", "loadAdGet", "Lkotlin/Pair;", "a", "(Lcom/chartboost/sdk/impl/y0;Lcom/chartboost/sdk/impl/z6;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lkotlin/Pair;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f982a = new c0();

    public final Pair<Function2<y0, z6, Unit>, z6> a(y0 appRequest, z6 params, Function2<? super y0, ? super z6, Unit> loadOpenRTBAd, Function2<? super y0, ? super z6, Unit> loadAdGet) {
        Intrinsics.checkNotNullParameter(appRequest, "appRequest");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(loadOpenRTBAd, "loadOpenRTBAd");
        Intrinsics.checkNotNullParameter(loadAdGet, "loadAdGet");
        return appRequest.getBidResponse() != null ? new Pair<>(loadOpenRTBAd, params) : new Pair<>(loadAdGet, params);
    }
}
