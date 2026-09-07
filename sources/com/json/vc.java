package com.json;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.json.mediationsdk.logger.IronLog;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes9.dex */
public class vc extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, po> f4521a;

    public vc(Looper looper) {
        super(looper);
        this.f4521a = new ConcurrentHashMap<>();
    }

    private boolean a(int i) {
        return i == 1016 || i == 1015;
    }

    void a(String str, po poVar) {
        if (str == null || poVar == null) {
            return;
        }
        this.f4521a.put(str, poVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            nh nhVar = (nh) message.obj;
            String path = nhVar.getPath();
            po poVar = this.f4521a.get(path);
            if (poVar == null) {
                return;
            }
            if (a(message.what)) {
                poVar.a(nhVar);
            } else {
                int i = message.what;
                poVar.a(nhVar, new fh(i, jv.a(i)));
            }
            this.f4521a.remove(path);
        } catch (Throwable th) {
            o9.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }
}
