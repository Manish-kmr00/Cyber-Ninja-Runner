package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.adjust.sdk.Constants;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ig, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class ResultReceiverC4193ig extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sf f11604a;

    public ResultReceiverC4193ig(Handler handler, Sf sf) {
        super(handler);
        this.f11604a = sf;
    }

    public static void a(ResultReceiver resultReceiver, C4044cg c4044cg) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(Constants.REFERRER, c4044cg == null ? null : c4044cg.a());
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            C4044cg c4044cg = null;
            try {
                byte[] byteArray = bundle.getByteArray(Constants.REFERRER);
                if (byteArray != null && byteArray.length != 0) {
                    c4044cg = new C4044cg(byteArray);
                }
            } catch (Throwable unused) {
            }
            this.f11604a.a(c4044cg);
        }
    }
}
