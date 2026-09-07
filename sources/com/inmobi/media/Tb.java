package com.inmobi.media;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final K5 f3205a;
    public static int b;
    public static Integer c;

    static {
        K5 k5A;
        Context contextD = C3517pb.d();
        if (contextD != null) {
            ConcurrentHashMap concurrentHashMap = K5.b;
            k5A = J5.a(contextD, "imtelemetrydboverflow");
        } else {
            k5A = null;
        }
        f3205a = k5A;
        b = -1;
    }

    public static int a() {
        if (b == -1) {
            K5 k5 = f3205a;
            int i = 0;
            if (k5 != null) {
                Intrinsics.checkNotNullParameter("count", "key");
                i = k5.f3112a.getInt("count", 0);
            }
            b = i;
        }
        return b;
    }
}
