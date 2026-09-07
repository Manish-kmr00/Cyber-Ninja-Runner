package com.yandex.mobile.ads.impl;

import androidx.media3.common.Player;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class x60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashSet f10625a = new LinkedHashSet();
    private Player b;

    public final void a(nl1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f10625a.add(listener);
    }

    public final Player a() {
        return this.b;
    }

    public final boolean b() {
        return this.b != null;
    }

    public final void a(Player player) {
        this.b = player;
        Iterator it = this.f10625a.iterator();
        while (it.hasNext()) {
            ((si1) it.next()).a(player);
        }
    }
}
