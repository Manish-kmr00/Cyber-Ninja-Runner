package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.Player;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class y60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashSet f10705a = new LinkedHashSet();
    private Player b;

    public final void a(ol1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f10705a.add(listener);
    }

    public final Player a() {
        return this.b;
    }

    public final boolean b() {
        return this.b != null;
    }

    public final void a(Player player) {
        this.b = player;
        Iterator it = this.f10705a.iterator();
        while (it.hasNext()) {
            ((ti1) it.next()).a(player);
        }
    }
}
