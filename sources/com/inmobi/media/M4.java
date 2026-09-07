package com.inmobi.media;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class M4 implements L4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C3414ia f3133a;
    public final Jb b;

    public M4(Context context, double d, EnumC3396h6 logLevel, boolean z, boolean z2, int i, long j, boolean z3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        if (!z2) {
            this.b = new Jb();
        }
        if (z) {
            return;
        }
        C3414ia logger = new C3414ia(context, d, logLevel, j, i, z3);
        this.f3133a = logger;
        CopyOnWriteArrayList copyOnWriteArrayList = AbstractC3526q6.f3406a;
        Intrinsics.checkNotNull(logger);
        Intrinsics.checkNotNullParameter(logger, "logger");
        Objects.toString(logger);
        AbstractC3526q6.f3406a.add(new WeakReference(logger));
    }

    public final void a(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        C3414ia c3414ia = this.f3133a;
        if (c3414ia != null) {
            c3414ia.a(EnumC3396h6.DEBUG, tag, message);
        }
        if (this.b != null) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    public final void b(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        C3414ia c3414ia = this.f3133a;
        if (c3414ia != null) {
            c3414ia.a(EnumC3396h6.ERROR, tag, message);
        }
        if (this.b != null) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    public final void c(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        C3414ia c3414ia = this.f3133a;
        if (c3414ia != null) {
            c3414ia.a(EnumC3396h6.INFO, tag, message);
        }
        if (this.b != null) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    public final void d(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        C3414ia c3414ia = this.f3133a;
        if (c3414ia != null) {
            c3414ia.a(EnumC3396h6.STATE, tag, message);
        }
        if (this.b != null) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter("STATE_CHANGE: " + message, "message");
        }
    }

    public final void e(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        C3414ia c3414ia = this.f3133a;
        if (c3414ia != null) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            Objects.toString(c3414ia.i);
            if (c3414ia.i.get()) {
                return;
            }
            c3414ia.h.put(key, value);
        }
    }

    public final void a(String tag, String message, Exception error) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(error, "error");
        C3414ia c3414ia = this.f3133a;
        if (c3414ia != null) {
            c3414ia.a(EnumC3396h6.ERROR, tag, message + "\nError: " + ExceptionsKt.stackTraceToString(error));
        }
        if (this.b != null) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(error, "error");
        }
    }

    public final void b() {
        C3414ia c3414ia = this.f3133a;
        if (c3414ia != null) {
            c3414ia.a();
        }
    }

    public final void a(boolean z) {
        C3414ia c3414ia = this.f3133a;
        if (c3414ia != null) {
            Objects.toString(c3414ia.i);
            if (!c3414ia.i.get()) {
                c3414ia.d = z;
            }
        }
        if (z) {
            return;
        }
        C3414ia c3414ia2 = this.f3133a;
        if (c3414ia2 == null || !c3414ia2.f.a()) {
            CopyOnWriteArrayList copyOnWriteArrayList = AbstractC3526q6.f3406a;
            AbstractC3512p6.a(this.f3133a);
            this.f3133a = null;
        }
    }

    public final void a() {
        C3414ia c3414ia = this.f3133a;
        if (c3414ia != null) {
            c3414ia.b();
        }
        CopyOnWriteArrayList copyOnWriteArrayList = AbstractC3526q6.f3406a;
        AbstractC3512p6.a(this.f3133a);
    }
}
