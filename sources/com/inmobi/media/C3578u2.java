package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.u2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3578u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f3440a = new LinkedHashMap();
    public static final Lazy b = LazyKt.lazy(C3535r2.f3413a);
    public static final AtomicBoolean c = new AtomicBoolean(false);
    public static final AtomicBoolean d = new AtomicBoolean(true);
    public static final ConcurrentHashMap e = new ConcurrentHashMap();
    public static final Lazy f = LazyKt.lazy(C3522q2.f3402a);

    static {
        C3517pb.f().a(new int[]{2, 1}, C3480n2.f3379a);
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.u2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3578u2.a();
            }
        });
    }

    @JvmStatic
    public static final Config a(String str, String str2, InterfaceC3564t2 interfaceC3564t2) {
        return C3549s2.a(str, str2, interfaceC3564t2);
    }

    public static final /* synthetic */ String b() {
        return "ConfigBootstrapHandler";
    }

    public static final /* synthetic */ String f() {
        return "u2";
    }

    @JvmStatic
    public static final void g() {
        C3549s2.a();
    }

    @JvmStatic
    public static final void h() {
        if (c.getAndSet(false)) {
            Intrinsics.checkNotNullExpressionValue(f(), "access$getTAG$cp(...)");
            ((HandlerC3494o2) b.getValue()).sendEmptyMessage(5);
        }
    }

    public static final void a() {
        C3549s2.a();
    }
}
