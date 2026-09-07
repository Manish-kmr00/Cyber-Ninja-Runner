package com.inmobi.media;

import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.oc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3504oc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f3393a;
    public HashMap b = new LinkedHashMap();

    public C3504oc(byte b) {
        this.f3393a = b;
    }

    public final Object a(String key, Class classType) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(classType, "classType");
        Object obj = this.b.get(key);
        if (classType.isInstance(obj)) {
            return classType.cast(obj);
        }
        return null;
    }
}
