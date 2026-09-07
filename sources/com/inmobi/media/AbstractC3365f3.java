package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.f3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractC3365f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3379g3 f3309a;

    public AbstractC3365f3(C3379g3 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f3309a = listener;
    }

    public abstract void a();

    public abstract void b();
}
