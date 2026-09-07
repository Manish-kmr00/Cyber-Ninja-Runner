package com.yandex.mobile.ads.impl;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes9.dex */
abstract class ao implements h32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayDeque<a> f8428a = new ArrayDeque<>();
    private final ArrayDeque<l32> b;
    private final PriorityQueue<a> c;
    private a d;
    private long e;
    private long f;

    protected abstract void b(k32 k32Var);

    protected abstract g32 c();

    protected abstract boolean h();

    @Override // com.yandex.mobile.ads.impl.ly
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(k32 k32Var) throws i32 {
        if (k32Var != this.d) {
            throw new IllegalArgumentException();
        }
        a aVar = (a) k32Var;
        if (aVar.e()) {
            aVar.b();
            this.f8428a.add(aVar);
        } else {
            long j = this.f;
            this.f = 1 + j;
            aVar.k = j;
            this.c.add(aVar);
        }
        this.d = null;
    }

    public ao() {
        for (int i = 0; i < 10; i++) {
            this.f8428a.add(new a());
        }
        this.b = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.b.add(new b(new py.a() { // from class: com.yandex.mobile.ads.impl.ao$$ExternalSyntheticLambda0
                @Override // com.yandex.mobile.ads.impl.py.a
                public final void a(py pyVar) {
                    this.f$0.a((ao.b) pyVar);
                }
            }));
        }
        this.c = new PriorityQueue<>();
    }

    @Override // com.yandex.mobile.ads.impl.ly
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public k32 b() throws i32 {
        if (this.d == null) {
            if (this.f8428a.isEmpty()) {
                return null;
            }
            a aVarPollFirst = this.f8428a.pollFirst();
            this.d = aVarPollFirst;
            return aVarPollFirst;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.ly
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public l32 a() throws i32 {
        if (this.b.isEmpty()) {
            return null;
        }
        while (!this.c.isEmpty()) {
            a aVarPeek = this.c.peek();
            int i = x82.f10629a;
            if (aVarPeek.f > this.e) {
                break;
            }
            a aVarPoll = this.c.poll();
            if (aVarPoll.f()) {
                l32 l32VarPollFirst = this.b.pollFirst();
                l32VarPollFirst.b(4);
                aVarPoll.b();
                this.f8428a.add(aVarPoll);
                return l32VarPollFirst;
            }
            b(aVarPoll);
            if (h()) {
                g32 g32VarC = c();
                l32 l32VarPollFirst2 = this.b.pollFirst();
                l32VarPollFirst2.a(aVarPoll.f, g32VarC, Long.MAX_VALUE);
                aVarPoll.b();
                this.f8428a.add(aVarPoll);
                return l32VarPollFirst2;
            }
            aVarPoll.b();
            this.f8428a.add(aVarPoll);
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.ly
    public void flush() {
        this.f = 0L;
        this.e = 0L;
        while (!this.c.isEmpty()) {
            a aVarPoll = this.c.poll();
            int i = x82.f10629a;
            aVarPoll.b();
            this.f8428a.add(aVarPoll);
        }
        a aVar = this.d;
        if (aVar != null) {
            aVar.b();
            this.f8428a.add(aVar);
            this.d = null;
        }
    }

    protected final l32 f() {
        return this.b.pollFirst();
    }

    protected final void a(l32 l32Var) {
        l32Var.b();
        this.b.add(l32Var);
    }

    protected final long g() {
        return this.e;
    }

    private static final class a extends k32 implements Comparable<a> {
        private long k;

        private a() {
        }

        /* JADX WARN: Code duplicated, block: B:14:0x002d A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:15:0x002f A[ORIG_RETURN, RETURN] */
        @Override // java.lang.Comparable
        public final int compareTo(a aVar) {
            a aVar2 = aVar;
            if (f() != aVar2.f()) {
                if (f()) {
                    return 1;
                }
                return -1;
            }
            long j = this.f - aVar2.f;
            if (j == 0) {
                j = this.k - aVar2.k;
                if (j == 0) {
                    return 0;
                }
            }
            if (j > 0) {
                return 1;
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class b extends l32 {
        private py.a<b> f;

        public b(py.a<b> aVar) {
            this.f = aVar;
        }

        @Override // com.yandex.mobile.ads.impl.py
        public final void h() {
            this.f.a(this);
        }
    }

    @Override // com.yandex.mobile.ads.impl.h32
    public void a(long j) {
        this.e = j;
    }
}
