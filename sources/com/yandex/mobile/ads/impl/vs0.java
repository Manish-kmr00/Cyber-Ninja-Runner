package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class vs0 {
    public static ArrayList a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zq0(context, new ws0()));
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        if (cu1VarA != null && !cu1VarA.d0()) {
            arrayList.add(ve0.a(context));
            arrayList.add(sf0.a(context));
        }
        return arrayList;
    }
}
