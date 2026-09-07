package com.yandex.mobile.ads.impl;

import java.util.logging.Logger;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes10.dex */
public final class b42 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(a42 a42Var, d42 d42Var, String str) {
        e42 e42Var = e42.h;
        Logger loggerA = e42.b.a();
        String strF = d42Var.f();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        loggerA.fine(strF + " " + z0.a(new Object[]{str}, 1, "%-22s", "format(...)") + ": " + a42Var.b());
    }

    public static final String a(long j) {
        String str;
        if (j <= -999500000) {
            str = ((j - ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else if (j <= -999500) {
            str = ((j - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j <= 0) {
            str = ((j - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j < 999500) {
            str = ((j + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j >= 999500000) {
            str = ((j + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else {
            str = ((j + ((long) 500000)) / ((long) 1000000)) + " ms";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return z0.a(new Object[]{str}, 1, "%6s", "format(...)");
    }
}
