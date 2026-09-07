package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class rn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ht1 f10126a;
    private final z2 b;

    public rn1(ht1 schedulePlaylistItemsProvider, z2 adBreakStatusController) {
        Intrinsics.checkNotNullParameter(schedulePlaylistItemsProvider, "schedulePlaylistItemsProvider");
        Intrinsics.checkNotNullParameter(adBreakStatusController, "adBreakStatusController");
        this.f10126a = schedulePlaylistItemsProvider;
        this.b = adBreakStatusController;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0040  */
    public final dt a(long j) {
        boolean z;
        ArrayList arrayListA = this.f10126a.a();
        int size = arrayListA.size();
        for (int i = 0; i < size; i++) {
            dt dtVarA = ((aj1) arrayListA.get(i)).a();
            if (i <= 0 ? j < 0 : j <= ((aj1) arrayListA.get(i - 1)).b()) {
                z = true;
            } else if (j > ((aj1) arrayListA.get(i)).b()) {
                z = true;
            } else {
                z = false;
            }
            y2 y2VarA = this.b.a(dtVarA);
            if (!z && y2.b == y2VarA) {
                return dtVarA;
            }
        }
        return null;
    }
}
