package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.base.a;
import java.util.Arrays;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes12.dex */
public final class yx0<T extends com.monetization.ads.mediation.base.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cy0 f10778a;
    private final e01 b;

    public final T a(Context context, hz0 mediationNetwork, Class<T> clazz) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        T t = null;
        try {
            String strE = mediationNetwork.e();
            this.b.getClass();
            if (!e01.a(context, strE)) {
                return null;
            }
            Object objA = co1.a.a(strE, new Object[0]);
            T tCast = clazz.cast(objA);
            if (tCast == null) {
                try {
                    if (objA == null) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        str = String.format("Instantiation failed for %s", Arrays.copyOf(new Object[]{strE}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    } else {
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        str = String.format("Cast from %s to %s is failed", Arrays.copyOf(new Object[]{objA.getClass().getName(), clazz.getName()}, 2));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    }
                    a(context, mediationNetwork, str);
                } catch (ClassCastException e) {
                    e = e;
                    t = tCast;
                } catch (Throwable th) {
                    th = th;
                    t = tCast;
                    a(context, mediationNetwork, "could_not_create_adapter", th);
                    return t;
                }
            }
            return tCast;
        } catch (ClassCastException e2) {
            e = e2;
        } catch (Throwable th2) {
            th = th2;
        }
        a(context, mediationNetwork, "does_not_conform_to_protocol", e);
        return t;
    }

    public /* synthetic */ yx0(cy0 cy0Var) {
        this(cy0Var, new e01());
    }

    public yx0(cy0 mediatedAdapterReporter, e01 mediationSupportedChecker) {
        Intrinsics.checkNotNullParameter(mediatedAdapterReporter, "mediatedAdapterReporter");
        Intrinsics.checkNotNullParameter(mediationSupportedChecker, "mediationSupportedChecker");
        this.f10778a = mediatedAdapterReporter;
        this.b = mediationSupportedChecker;
    }

    private final void a(Context context, hz0 hz0Var, String str) {
        this.f10778a.a(context, hz0Var, MapsKt.mapOf(TuplesKt.to("reason", "could_not_create_adapter"), TuplesKt.to("description", str)), (String) null);
    }

    private final void a(Context context, hz0 hz0Var, String str, Throwable th) {
        Map<String, ? extends Object> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("reason", str));
        String message = th.getMessage();
        if (message == null) {
            message = "Unknown error message";
        }
        op0.c(new Object[0]);
        mapMutableMapOf.put("description", th.getClass().getName() + " " + message);
        this.f10778a.a(context, hz0Var, mapMutableMapOf, (String) null);
    }
}
