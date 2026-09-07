package io.bidmachine.analytics.internal;

import android.content.Context;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractC4634j {
    public static final a c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f12098a = new Object();
    private b b = b.EMPTY;

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.j$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.j$b */
    public enum b {
        EMPTY,
        CREATED,
        ENABLED,
        DISABLED,
        DESTROYED
    }

    public abstract String a();

    public final void a(Object obj) {
        synchronized (this.f12098a) {
            b bVar = this.b;
            if (bVar == b.CREATED || bVar == b.DISABLED) {
                b(obj);
                this.b = b.DISABLED;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void b(Context context) {
        synchronized (this.f12098a) {
            if (this.b != b.ENABLED) {
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                e(context);
                Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            this.b = b.DISABLED;
            Unit unit = Unit.INSTANCE;
        }
    }

    public abstract void b(Object obj);

    public final void c(Context context) {
        synchronized (this.f12098a) {
            if (this.b != b.DISABLED) {
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                f(context);
                Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            this.b = b.ENABLED;
            Unit unit = Unit.INSTANCE;
        }
    }

    public abstract void d(Context context);

    public abstract void e(Context context);

    public abstract void f(Context context);

    public final void a(Context context) {
        synchronized (this.f12098a) {
            if (this.b != b.EMPTY) {
                return;
            }
            d(context);
            this.b = b.CREATED;
            Unit unit = Unit.INSTANCE;
        }
    }
}
