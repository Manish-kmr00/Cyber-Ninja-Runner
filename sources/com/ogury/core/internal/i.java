package com.ogury.core.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReflectionUtil.kt */
/* JADX INFO: loaded from: classes12.dex */
public final class i {
    public static boolean a(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        try {
            Class.forName(className);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
