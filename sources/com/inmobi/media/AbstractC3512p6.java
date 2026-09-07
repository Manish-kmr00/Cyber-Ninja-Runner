package com.inmobi.media;

import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.p6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractC3512p6 {
    public static void a(C3414ia c3414ia) {
        CopyOnWriteArrayList copyOnWriteArrayList = AbstractC3526q6.f3406a;
        Objects.toString(c3414ia);
        if (c3414ia == null) {
            return;
        }
        try {
            for (WeakReference weakReference : AbstractC3526q6.f3406a) {
                if (weakReference.get() == null || Intrinsics.areEqual(weakReference.get(), c3414ia)) {
                    AbstractC3526q6.f3406a.remove(weakReference);
                }
            }
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }
}
