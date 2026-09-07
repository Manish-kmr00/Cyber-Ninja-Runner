package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;

/* JADX INFO: loaded from: classes5.dex */
public final class Lm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Nm f11249a;
    public final Nm b;

    public Lm(Context context) {
        if (new SafePackageManager().hasSystemFeature(context, "android.hardware.telephony")) {
            this.f11249a = new W2(new Pk(context));
            this.b = new W2(new Rc(context));
        } else {
            this.f11249a = new C4086e8();
            this.b = new C4086e8();
        }
    }
}
