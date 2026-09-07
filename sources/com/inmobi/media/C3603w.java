package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C3603w extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InMobiAdRequestStatus f3462a;
    public final short b;

    public C3603w(InMobiAdRequestStatus status, short s) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.f3462a = status;
        this.b = s;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f3462a.getMessage();
    }
}
