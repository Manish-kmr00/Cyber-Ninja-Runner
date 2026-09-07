package com.five_corp.ad.internal.system;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1542a = new ArrayList();
    public int b;

    public c(String str) {
        for (int i = 0; i < 3; i++) {
            HandlerThread handlerThread = new HandlerThread("com.five-corp." + str + "-" + i);
            handlerThread.start();
            this.f1542a.add(handlerThread);
        }
        this.b = 0;
    }

    public final Looper a() {
        HandlerThread handlerThread;
        if (this.b < this.f1542a.size()) {
            handlerThread = (HandlerThread) this.f1542a.get(this.b);
            this.b++;
        } else {
            if (this.f1542a.isEmpty()) {
                return null;
            }
            handlerThread = (HandlerThread) this.f1542a.get(0);
            this.b = 1;
        }
        return handlerThread.getLooper();
    }
}
