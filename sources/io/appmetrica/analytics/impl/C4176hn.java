package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreutils.internal.toggle.ConjunctiveCompositeThreadSafeToggle;
import kotlin.collections.CollectionsKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.hn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4176hn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Y3 f11590a;
    public final Zn b;
    public final ConjunctiveCompositeThreadSafeToggle c;

    public C4176hn(Toggle toggle) {
        Y3 y3 = new Y3(C4486ua.j().x());
        this.f11590a = y3;
        Zn zn = new Zn();
        this.b = zn;
        Toggle[] toggleArr = new Toggle[3];
        toggleArr[0] = y3;
        toggleArr[1] = zn;
        toggleArr[2] = toggle == null ? new Sn() : toggle;
        this.c = new ConjunctiveCompositeThreadSafeToggle(CollectionsKt.listOf((Object[]) toggleArr), "loc-def");
    }
}
