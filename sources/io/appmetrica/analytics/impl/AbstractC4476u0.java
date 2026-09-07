package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractC4476u0 {
    public static I6 a(Handler handler, C4451t0 c4451t0) {
        return new I6(handler, c4451t0);
    }

    public static C4367pf a(Context context, I6 i6) {
        return new C4367pf(context, i6);
    }

    public static C4320ni a(C4367pf c4367pf, Context context, ICommonExecutor iCommonExecutor) {
        C4178i0 c4178i0 = new C4178i0(context, iCommonExecutor, C4455t4.i().d());
        return new C4320ni(c4178i0, new C4375pn(new C4412rb()), new W4(c4367pf), new Lj(context, c4178i0));
    }

    public static C4398ql a(Context context, C4320ni c4320ni, Ke ke, Handler handler) {
        return new C4398ql(c4320ni, new C4597yl(context, ke), handler);
    }

    public static Yf a(C4320ni c4320ni, Ke ke, Handler handler) {
        return new Yf(c4320ni, ke, handler, ke.s());
    }

    public static C4021bi a(Context context, C4367pf c4367pf, C4320ni c4320ni, Handler handler, C4398ql c4398ql) {
        return new C4021bi(context, c4367pf, c4320ni, handler, c4398ql);
    }
}
