package com.ogury.ad.internal;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q3 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r3 f7388a;

    public q3() {
        this(0);
    }

    public final r3 a() {
        return this.f7388a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q3) && this.f7388a == ((q3) obj).f7388a;
    }

    public final int hashCode() {
        return this.f7388a.hashCode();
    }

    public final String toString() {
        return "LoadedSettings(loadedSource=" + this.f7388a + ")";
    }

    public q3(r3 loadedSource) {
        Intrinsics.checkNotNullParameter(loadedSource, "loadedSource");
        this.f7388a = loadedSource;
    }

    public q3(int i) {
        r3 loadedSource = r3.LOADED_SOURCE_FORMAT;
        Intrinsics.checkNotNullParameter(loadedSource, "loadedSource");
        this.f7388a = loadedSource;
    }
}
