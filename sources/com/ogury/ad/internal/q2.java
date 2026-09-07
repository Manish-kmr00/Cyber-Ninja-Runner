package com.ogury.ad.internal;

import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q2 implements o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l3 f7387a;

    public q2(x9 loadCallback) {
        Intrinsics.checkNotNullParameter(loadCallback, "loadCallback");
        this.f7387a = loadCallback;
    }

    @Override // com.ogury.ad.internal.o3
    public final void a() {
    }

    @Override // com.ogury.ad.internal.o3
    public final void a(LinkedList loadCommands, int i) {
        Intrinsics.checkNotNullParameter(loadCommands, "loadCommands");
        Iterator it = loadCommands.iterator();
        while (it.hasNext()) {
            ((v9) it.next()).a(this.f7387a, i);
        }
    }
}
