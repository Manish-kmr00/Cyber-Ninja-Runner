package com.ogury.ad.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class w9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p3 f7433a;
    public final LinkedList b;
    public final x9 c;
    public final ArrayList d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public final Handler i;
    public o3 j;
    public c k;
    public Long l;
    public l7 m;
    public String n;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.ogury.ad.internal.w9$a[], still in use, count: 1, list:
  (r0v1 com.ogury.ad.internal.w9$a[]) from 0x002a: INVOKE (r0v1 com.ogury.ad.internal.w9$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
    public static final class a {
        HTML("html"),
        FORMAT("format"),
        MRAID("mraid");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7434a;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public a(String str) {
            super(str, i);
            this.f7434a = str;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) e.clone();
        }
    }

    public w9() {
        p3 loadStrategyFactory = new p3();
        Intrinsics.checkNotNullParameter(loadStrategyFactory, "loadStrategyFactory");
        this.f7433a = loadStrategyFactory;
        this.b = new LinkedList();
        this.c = new x9(this);
        this.d = new ArrayList();
        this.i = new Handler(Looper.getMainLooper());
        this.n = "";
    }

    public final String a() {
        return this.n;
    }

    public final l7 b() {
        return this.m;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.n = str;
    }

    public static final void a(w9 w9Var) {
        w9Var.i.removeCallbacksAndMessages(null);
    }

    public final void a(c cVar, l7.b bVar, String str) {
        this.i.removeCallbacksAndMessages(null);
        this.h = true;
        l7 l7Var = this.m;
        if (l7Var != null) {
            l7.a.a(l7Var, cVar, bVar, str, 28);
        }
    }

    public final void a(final long j) {
        String str = "load timeout " + j;
        u3.f7411a.getClass();
        this.i.postDelayed(new Runnable() { // from class: com.ogury.ad.internal.w9$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                w9.a(this.f$0, j);
            }
        }, j);
    }

    public static final void a(w9 w9Var, long j) {
        l7 l7Var;
        u3.f7411a.getClass();
        for (v9 v9Var : w9Var.b) {
            if (!v9Var.b() && !(v9Var instanceof n3)) {
                Iterator it = w9Var.b.iterator();
                while (it.hasNext()) {
                    ((v9) it.next()).a();
                }
                c cVar = w9Var.k;
                if (cVar == null || (l7Var = w9Var.m) == null) {
                    return;
                }
                l7.b bVar = l7.b.TIMEOUT;
                ArrayList arrayList = w9Var.d;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                Long lValueOf = Long.valueOf(timeUnit.toSeconds(j));
                long jCurrentTimeMillis = System.currentTimeMillis();
                Long l = w9Var.l;
                Intrinsics.checkNotNull(l);
                l7Var.a(cVar, bVar, arrayList, lValueOf, Long.valueOf(timeUnit.toSeconds(jCurrentTimeMillis - l.longValue())), w9Var.n);
                return;
            }
        }
        for (v9 v9Var2 : w9Var.b) {
            if (v9Var2 instanceof n3) {
                ((n3) v9Var2).a();
            }
        }
        c cVar2 = w9Var.k;
        w9Var.b.clear();
        w9Var.i.removeCallbacksAndMessages(null);
        l7 l7Var2 = w9Var.m;
        if (l7Var2 != null) {
            l7Var2.b(cVar2);
        }
    }
}
