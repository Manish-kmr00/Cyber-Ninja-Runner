package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.w0;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3074d implements w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3075e f1691a;

    public C3074d(C3075e c3075e) {
        this.f1691a = c3075e;
    }

    @Override // com.fyber.inneractive.sdk.util.w0
    public final void a() {
        IAlog.a("onVisibleTimeReached: %s", Long.valueOf(System.currentTimeMillis()));
        this.f1691a.b = true;
    }
}
