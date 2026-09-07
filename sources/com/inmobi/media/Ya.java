package com.inmobi.media;

import com.inmobi.commons.utils.json.Constructor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class Ya {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Constructor f3247a;

    public Ya(Constructor constructor) {
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        this.f3247a = constructor;
    }

    public final Constructor<Object> a() {
        return this.f3247a;
    }

    public final void a(Constructor<Object> constructor) {
        Intrinsics.checkNotNullParameter(constructor, "<set-?>");
        this.f3247a = constructor;
    }
}
