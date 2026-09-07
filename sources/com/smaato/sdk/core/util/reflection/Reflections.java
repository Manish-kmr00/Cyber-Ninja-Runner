package com.smaato.sdk.core.util.reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class Reflections {
    public static boolean isClassInClasspath(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
