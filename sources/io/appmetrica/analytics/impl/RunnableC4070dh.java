package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.dh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class RunnableC4070dh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11516a;
    public final C3984a6 b;
    public final Bundle c;
    public final C4430s4 d;

    public RunnableC4070dh(Context context, C3984a6 c3984a6, Bundle bundle, C4430s4 c4430s4) {
        this.f11516a = context;
        this.b = c3984a6;
        this.c = bundle;
        this.d = c4430s4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            C4007b4 c4007b4A = C4007b4.a(this.f11516a, this.c);
            if (c4007b4A == null) {
                return;
            }
            C4157h4 c4157h4A = C4157h4.a(c4007b4A);
            Ui uiU = C4486ua.E.u();
            uiU.a(c4007b4A.b.getAppVersion(), c4007b4A.b.getAppBuildNumber());
            uiU.a(c4007b4A.b.getDeviceType());
            G4 g4 = new G4(c4007b4A);
            this.d.a(c4157h4A, g4).a(this.b, g4);
        } catch (Throwable th) {
            Fj fj = AbstractC4097ej.f11536a;
            String str = "Exception during processing event with type: " + this.b.d + " (" + this.b.e + "): " + th.getMessage();
            fj.getClass();
            fj.a(new C4122fj(str, th));
        }
    }
}
