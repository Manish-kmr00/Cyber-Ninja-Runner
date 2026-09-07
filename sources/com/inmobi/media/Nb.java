package com.inmobi.media;

import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class Nb extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Nb f3150a = new Nb();

    public Nb() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N1 it = (N1) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        int i = it.f3141a;
        if (i == 1 || i == 2) {
            Ob.d.set(false);
            M3 m3 = Ob.f;
            if (m3 != null) {
                ScheduledExecutorService scheduledExecutorService = m3.h;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
                m3.h = null;
                m3.e.set(false);
                m3.f.set(true);
                m3.g.clear();
                m3.i = null;
            }
            Ob.f = null;
            Ob.i = null;
            C3517pb.f().a(Ob.h);
        } else {
            Ob ob = Ob.f3160a;
        }
        return Unit.INSTANCE;
    }
}
