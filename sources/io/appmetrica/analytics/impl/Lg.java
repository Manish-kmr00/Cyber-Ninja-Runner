package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public final class Lg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11245a;
    public final ICommonExecutor b;
    public final C4430s4 c;
    public final C4163ha d;

    public Lg(Context context, C4430s4 c4430s4, IHandlerExecutor iHandlerExecutor, C4163ha c4163ha) {
        this.f11245a = context;
        this.b = iHandlerExecutor;
        this.c = c4430s4;
        this.d = c4163ha;
    }

    public final void a(C4576y0 c4576y0, Consumer consumer, Function function) {
        ICommonExecutor iCommonExecutor = this.b;
        C4163ha c4163ha = this.d;
        String str = c4576y0.d;
        c4163ha.getClass();
        iCommonExecutor.execute(new Gf(new File(str), new Dd(new Ed(c4576y0.f11849a, c4576y0.b), new Cd()), consumer, new Kg(this, c4576y0.f, function)));
    }
}
