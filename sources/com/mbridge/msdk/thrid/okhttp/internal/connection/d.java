package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.mbridge.msdk.thrid.okhttp.a0;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: RouteDatabase.java */
/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<a0> f5518a = new LinkedHashSet();

    public synchronized void a(a0 a0Var) {
        this.f5518a.remove(a0Var);
    }

    public synchronized void b(a0 a0Var) {
        this.f5518a.add(a0Var);
    }

    public synchronized boolean c(a0 a0Var) {
        return this.f5518a.contains(a0Var);
    }
}
