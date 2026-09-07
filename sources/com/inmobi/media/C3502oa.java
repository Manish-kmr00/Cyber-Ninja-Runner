package com.inmobi.media;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.oa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3502oa extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3502oa f3391a = new C3502oa();

    public C3502oa() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ConcurrentHashMap concurrentHashMap = K5.b;
        Context contextD = C3517pb.d();
        Intrinsics.checkNotNull(contextD);
        K5 k5A = J5.a(contextD, "default");
        Intrinsics.checkNotNullParameter("enableImraidLogs", "key");
        return Boolean.valueOf(k5A.f3112a.getBoolean("enableImraidLogs", false));
    }
}
