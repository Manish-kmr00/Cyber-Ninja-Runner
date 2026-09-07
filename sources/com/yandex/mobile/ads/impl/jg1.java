package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.SystemClock;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
final class jg1 implements ig1 {
    private final boolean b;
    private final Handler c;
    private b d;
    private kg1 e;
    private f52 f;
    private long g;
    private long h;
    private long i;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.jg1$b[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.jg1$b[]) from 0x0024: INVOKE (r0v1 com.yandex.mobile.ads.impl.jg1$b[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    private static final class b {
        b,
        c,
        d;

        static {
            EnumEntriesKt.enumEntries(bVarArr);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) e.clone();
        }

        private b() {
            super(str, i);
        }
    }

    public jg1(boolean z, Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.b = z;
        this.c = handler;
        this.d = b.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(jg1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
    }

    @Override // com.yandex.mobile.ads.impl.ig1
    public final void invalidate() {
        b bVar = b.b;
        if (bVar == this.d) {
            return;
        }
        this.d = bVar;
        this.e = null;
        this.c.removeCallbacksAndMessages(null);
    }

    @Override // com.yandex.mobile.ads.impl.ig1
    public final void pause() {
        if (b.c == this.d) {
            this.d = b.d;
            this.c.removeCallbacksAndMessages(null);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.i;
            this.i = jElapsedRealtime;
            long j2 = this.g - j;
            this.g = j2;
            long jMax = (long) Math.max(0.0d, j2);
            f52 f52Var = this.f;
            if (f52Var != null) {
                f52Var.a(jMax, this.h - jMax);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.ig1
    public final void resume() {
        if (b.d == this.d) {
            a();
        }
    }

    public static final void b(jg1 jg1Var) {
        jg1Var.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - jg1Var.i;
        jg1Var.i = jElapsedRealtime;
        long j2 = jg1Var.g - j;
        jg1Var.g = j2;
        long jMax = (long) Math.max(0.0d, j2);
        f52 f52Var = jg1Var.f;
        if (f52Var != null) {
            f52Var.a(jMax, jg1Var.h - jMax);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ig1
    public final void stop() {
        invalidate();
    }

    private final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            jg1.b(jg1.this);
            jg1.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        this.d = b.c;
        this.i = SystemClock.elapsedRealtime();
        long jMin = (long) Math.min(200.0d, this.g);
        if (jMin > 0) {
            this.c.postDelayed(new a(), jMin);
            return;
        }
        kg1 kg1Var = this.e;
        if (kg1Var != null) {
            kg1Var.a();
        }
        invalidate();
    }

    @Override // com.yandex.mobile.ads.impl.ig1
    public final void a(f52 f52Var) {
        this.f = f52Var;
    }

    @Override // com.yandex.mobile.ads.impl.ig1
    public final void a(long j, kg1 kg1Var) {
        invalidate();
        this.e = kg1Var;
        this.g = j;
        this.h = j;
        if (this.b) {
            this.c.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.jg1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    jg1.c(this.f$0);
                }
            });
        } else {
            a();
        }
    }
}
