package com.inmobi.media;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class S4 extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final S4 f3189a = new S4();

    public S4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Context contextD = C3517pb.d();
        if (contextD == null) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = K5.b;
        return J5.a(contextD, "inmobi_store");
    }
}
