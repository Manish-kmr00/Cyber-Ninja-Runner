package com.json;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.json.mediationsdk.logger.IronLog;
import com.json.sdk.utils.Logger;

/* JADX INFO: loaded from: classes10.dex */
public class fb extends Handler {
    private static final String b = "DownloadHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    po f3693a;

    public fb(Looper looper) {
        super(looper);
    }

    public void a() {
        this.f3693a = null;
    }

    public void a(po poVar) {
        if (poVar == null) {
            throw new IllegalArgumentException();
        }
        this.f3693a = poVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        po poVar = this.f3693a;
        if (poVar == null) {
            Logger.i(b, "OnPreCacheCompletion listener is null, msg: " + message.toString());
            return;
        }
        try {
            int i = message.what;
            if (i == 1016) {
                poVar.a((nh) message.obj);
            } else {
                this.f3693a.a((nh) message.obj, new fh(i, jv.a(i)));
            }
        } catch (Throwable th) {
            o9.d().a(th);
            Logger.i(b, "handleMessage | Got exception: " + th.getMessage());
            IronLog.INTERNAL.error(th.toString());
        }
    }
}
