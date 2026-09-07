package com.inmobi.media;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.y6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3638y6 implements InterfaceC3624x6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC3624x6 f3485a;
    public final AtomicBoolean b;

    public C3638y6(InterfaceC3624x6 mediaChangeReceiver) {
        Intrinsics.checkNotNullParameter(mediaChangeReceiver, "mediaChangeReceiver");
        this.f3485a = mediaChangeReceiver;
        this.b = new AtomicBoolean(false);
    }

    @Override // com.inmobi.media.InterfaceC3624x6
    public final void a() {
        if (this.b.getAndSet(false)) {
            this.f3485a.a();
        }
    }

    @Override // com.inmobi.media.InterfaceC3624x6
    public final void b() {
        if (this.b.getAndSet(true)) {
            return;
        }
        this.f3485a.b();
    }
}
