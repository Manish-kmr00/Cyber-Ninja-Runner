package com.moloco.sdk.acm.services;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6049a = new a();

    public final boolean a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return Boolean.parseBoolean(b(key));
    }

    public final String b(String str) {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
            String str2 = (String) objInvoke;
            try {
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
            } catch (Exception unused) {
            }
            return str2;
        } catch (Exception unused2) {
            return null;
        }
    }
}
