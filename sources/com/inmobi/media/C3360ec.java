package com.inmobi.media;

import java.util.TimerTask;

/* JADX INFO: renamed from: com.inmobi.media.ec, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3360ec extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3374fc f3305a;
    public final /* synthetic */ byte b;

    public C3360ec(C3374fc c3374fc, byte b) {
        this.f3305a = c3374fc;
        this.b = b;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f3305a.a(this.b);
    }
}
