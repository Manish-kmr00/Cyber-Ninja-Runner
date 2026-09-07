package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/* JADX INFO: loaded from: classes4.dex */
public final class I6 extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H6 f11189a;

    public I6(Handler handler, H6 h6) {
        super(handler);
        this.f11189a = h6;
    }

    public static void a(ResultReceiver resultReceiver, C4231k4 c4231k4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            c4231k4.b(bundle);
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f11189a.a(i, bundle);
    }

    public static void a(ResultReceiver resultReceiver, EnumC4273ll enumC4273ll, C4231k4 c4231k4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("startup_error_key_code", enumC4273ll.f11658a);
            c4231k4.b(bundle);
            resultReceiver.send(2, bundle);
        }
    }
}
