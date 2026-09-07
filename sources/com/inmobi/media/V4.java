package com.inmobi.media;

import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class V4 implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3217a;
    public final String b;

    public V4(String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f3217a = z;
        this.b = S.a("TIM-", name);
    }

    public final boolean a() {
        return this.f3217a;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r) {
        Intrinsics.checkNotNullParameter(r, "r");
        try {
            Thread thread = new Thread(r, this.b);
            thread.setDaemon(this.f3217a);
            return thread;
        } catch (InternalError e) {
            e.toString();
            return null;
        }
    }

    public /* synthetic */ V4(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public V4(String name) {
        this(name, false);
        Intrinsics.checkNotNullParameter(name, "name");
    }
}
