package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class ku1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h50 f9450a = new h50();

    public final String a(Context context, dx1 sensitiveModeChecker, jc advertisingConfiguration, l50 environmentConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(environmentConfiguration, "environmentConfiguration");
        Intrinsics.checkNotNullParameter(advertisingConfiguration, "advertisingConfiguration");
        Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
        String[] strArr = {new cb0(new cb0.a(sensitiveModeChecker.b(context)).j(environmentConfiguration.g()).e(environmentConfiguration.e()).a(advertisingConfiguration.a(), advertisingConfiguration.b()).a(advertisingConfiguration.c()).I0().l(context).k(context).H0().a(dx1.a(context)).a(context, environmentConfiguration.b()).b(context).L0().M0(), 0).toString(), CollectionsKt.joinToString$default(environmentConfiguration.f(), com.ironsource.b9.i.c, null, null, 0, null, ju1.b, 30, null)};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            String str = strArr[i];
            if (!StringsKt.isBlank(str)) {
                arrayList.add(str);
            }
        }
        return this.f9450a.a(context, CollectionsKt.joinToString$default(arrayList, com.ironsource.b9.i.c, null, null, 0, null, null, 62, null));
    }
}
