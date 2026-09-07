package com.inmobi.media;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class K5 {
    public static final ConcurrentHashMap b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f3112a;

    public K5(Context context, String str) {
        this.f3112a = context.getSharedPreferences(str, 0);
    }

    @JvmStatic
    public static final K5 a(Context context, String str) {
        return J5.a(context, str);
    }

    public final void b() {
        SharedPreferences.Editor editorEdit = this.f3112a.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    public final boolean a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!this.f3112a.contains(key)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = this.f3112a.edit();
        editorEdit.remove(key);
        editorEdit.apply();
        return true;
    }

    public final void a(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorEdit = this.f3112a.edit();
        editorEdit.putString(key, str);
        editorEdit.apply();
    }

    public final void a(String key, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorEdit = this.f3112a.edit();
        editorEdit.putInt(key, i);
        editorEdit.apply();
    }

    public final void a(String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorEdit = this.f3112a.edit();
        editorEdit.putLong(key, j);
        editorEdit.apply();
    }

    public final void a(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorEdit = this.f3112a.edit();
        editorEdit.putBoolean(key, z);
        editorEdit.apply();
    }
}
