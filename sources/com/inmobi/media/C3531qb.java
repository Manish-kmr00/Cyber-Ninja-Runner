package com.inmobi.media;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.qb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3531qb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3531qb f3411a = new C3531qb();
    public static String b = null;
    public static String c = "dir";

    public static final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c = str;
    }

    @JvmStatic
    public static /* synthetic */ void b() {
    }

    @JvmStatic
    public static final String c() {
        return "10.8.2";
    }

    public static final String d() {
        return c;
    }

    @JvmStatic
    public static /* synthetic */ void e() {
    }

    public static final String f() {
        return b;
    }

    @JvmStatic
    public static /* synthetic */ void g() {
    }

    public static final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b = str;
    }

    public final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConcurrentHashMap concurrentHashMap = K5.b;
        K5 k5A = J5.a(context, "sdk_version_store");
        Intrinsics.checkNotNullParameter("db_deletion_failed", "key");
        return k5A.f3112a.getBoolean("db_deletion_failed", false);
    }

    public static final String a() {
        if (TextUtils.isEmpty("")) {
            return "pr-SAND-10.8.2-20250228";
        }
        return "pr-SAND-10.8.2-20250228-";
    }

    public final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConcurrentHashMap concurrentHashMap = K5.b;
        K5 k5A = J5.a(context, "sdk_version_store");
        Intrinsics.checkNotNullParameter("sdk_version", "key");
        return k5A.f3112a.getString("sdk_version", null);
    }

    public final void a(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConcurrentHashMap concurrentHashMap = K5.b;
        J5.a(context, "sdk_version_store").a("sdk_version", str);
    }

    public final void a(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConcurrentHashMap concurrentHashMap = K5.b;
        J5.a(context, "sdk_version_store").a("db_deletion_failed", z);
    }
}
