package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class Fm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4377q0 f11147a;
    public final Cdo b;
    public final C4351p c;
    public final Ak d;
    public final P5 e;
    public final C4212ja f;

    public Fm(C4377q0 c4377q0, Cdo cdo, C4351p c4351p, Ak ak, P5 p5, C4212ja c4212ja) {
        this.f11147a = c4377q0;
        this.b = cdo;
        this.c = c4351p;
        this.d = ak;
        this.e = p5;
        this.f = c4212ja;
    }

    public static Intent a(Activity activity) {
        return (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.Fm$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return Fm.b((Activity) obj);
            }
        });
    }

    public static final Intent b(Activity activity) {
        return activity.getIntent();
    }

    public Fm(C4377q0 c4377q0, Cdo cdo) {
        this(c4377q0, cdo, C4455t4.i().a(), C4455t4.i().m(), C4455t4.i().f(), C4455t4.i().h());
    }
}
