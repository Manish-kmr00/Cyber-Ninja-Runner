package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Model.CBError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\b\u001a\u00020\u0002*\u00020\u00002\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u00032\u001d\u0010\u0007\u001a\u0019\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\b\u0003H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/chartboost/sdk/impl/a7;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "isSuccess", "Lkotlin/Function2;", "Lcom/chartboost/sdk/internal/Model/CBError;", "isError", "a", "(Lcom/chartboost/sdk/impl/a7;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class n {
    public static final void a(a7 a7Var, Function1<? super a7, Unit> isSuccess, Function2<? super a7, ? super CBError, Unit> isError) {
        Intrinsics.checkNotNullParameter(a7Var, "<this>");
        Intrinsics.checkNotNullParameter(isSuccess, "isSuccess");
        Intrinsics.checkNotNullParameter(isError, "isError");
        if (a7Var.getError() == null) {
            isSuccess.invoke(a7Var);
        } else {
            isError.invoke(a7Var, a7Var.getError());
        }
    }
}
