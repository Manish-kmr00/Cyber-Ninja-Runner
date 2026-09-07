package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Rf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3994ag f11331a;
    public final Ga b;
    public final C4268lg c;
    public final Lazy d = LazyKt.lazy(new Of(this));
    public final Lazy e = LazyKt.lazy(new Mf(this));
    public final Lazy f = LazyKt.lazy(new Qf(this));
    public final ArrayList g = new ArrayList();

    public Rf(C3994ag c3994ag, C4243kg c4243kg, Ga ga, C4268lg c4268lg) {
        this.f11331a = c3994ag;
        this.b = ga;
        this.c = c4268lg;
    }

    public static final Jf a(Rf rf) {
        return (Jf) rf.d.getValue();
    }

    public static final void a(Rf rf, C4044cg c4044cg, Jf jf) {
        boolean zAreEqual;
        rf.g.add(c4044cg);
        C4268lg c4268lg = rf.c;
        if (c4044cg == null) {
            c4268lg.getClass();
        } else {
            SafePackageManager safePackageManager = c4268lg.b;
            Context context = c4268lg.f11653a;
            String installerPackageName = safePackageManager.getInstallerPackageName(context, context.getPackageName());
            int iOrdinal = c4044cg.d.ordinal();
            if (iOrdinal == 1) {
                zAreEqual = Intrinsics.areEqual(c4268lg.f, installerPackageName);
            } else if (iOrdinal == 2) {
                zAreEqual = Intrinsics.areEqual(c4268lg.g, installerPackageName);
            }
            if (zAreEqual) {
                rf.a(c4044cg);
                return;
            }
        }
        jf.a();
    }

    public final void a(C4044cg c4044cg) {
        C3994ag c3994ag = this.f11331a;
        synchronized (c3994ag) {
            c3994ag.b = c4044cg;
            c3994ag.c = true;
            c3994ag.d.a(c4044cg);
            c3994ag.d.d();
            c3994ag.a(c3994ag.b);
        }
    }
}
