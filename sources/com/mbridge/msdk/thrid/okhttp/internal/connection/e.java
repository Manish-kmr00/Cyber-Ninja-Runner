package com.mbridge.msdk.thrid.okhttp.internal.connection;

import java.io.IOException;

/* JADX INFO: compiled from: RouteException.java */
/* JADX INFO: loaded from: classes12.dex */
public final class e extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IOException f5519a;
    private IOException b;

    public e(IOException iOException) {
        super(iOException);
        this.f5519a = iOException;
        this.b = iOException;
    }

    public IOException a() {
        return this.f5519a;
    }

    public IOException b() {
        return this.b;
    }

    public void a(IOException iOException) {
        com.mbridge.msdk.thrid.okhttp.internal.c.a((Throwable) this.f5519a, (Throwable) iOException);
        this.b = iOException;
    }
}
