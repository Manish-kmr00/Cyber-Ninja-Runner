package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ht1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f9134a;

    public ht1(lm0 instreamAdPlaylist) {
        Intrinsics.checkNotNullParameter(instreamAdPlaylist, "instreamAdPlaylist");
        this.f9134a = a(instreamAdPlaylist);
    }

    private static ArrayList a(lm0 lm0Var) {
        ArrayList arrayList = new ArrayList();
        dt dtVarC = lm0Var.c();
        if (dtVarC != null) {
            arrayList.add(new aj1(dtVarC, 0L));
        }
        arrayList.addAll(lm0Var.a());
        return arrayList;
    }

    public final ArrayList a() {
        return this.f9134a;
    }
}
