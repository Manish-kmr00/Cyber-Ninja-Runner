package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.impl.ny;
import com.yandex.mobile.ads.impl.oy;
import com.yandex.mobile.ads.impl.py;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes2.dex */
public abstract class iy1<I extends oy, O extends py, E extends ny> implements ly<I, O, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread f9269a;
    private final Object b = new Object();
    private final ArrayDeque<I> c = new ArrayDeque<>();
    private final ArrayDeque<O> d = new ArrayDeque<>();
    private final I[] e;
    private final O[] f;
    private int g;
    private int h;
    private I i;
    private i32 j;
    private boolean k;
    private boolean l;

    final class a extends Thread {
        final /* synthetic */ iy1 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ny1 ny1Var) {
            super("ExoPlayer:SimpleDecoder");
            this.b = ny1Var;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            iy1 iy1Var = this.b;
            iy1Var.getClass();
            do {
                try {
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            } while (iy1Var.e());
        }
    }

    protected abstract i32 a(oy oyVar, py pyVar, boolean z);

    protected abstract k32 c();

    protected abstract O d();

    @Override // com.yandex.mobile.ads.impl.ly
    public final Object a() throws ny {
        synchronized (this.b) {
            i32 i32Var = this.j;
            if (i32Var != null) {
                throw i32Var;
            }
            if (this.d.isEmpty()) {
                return null;
            }
            return this.d.removeFirst();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ly
    public final Object b() throws ny {
        I i;
        synchronized (this.b) {
            i32 i32Var = this.j;
            if (i32Var != null) {
                throw i32Var;
            }
            if (this.i != null) {
                throw new IllegalStateException();
            }
            int i2 = this.g;
            if (i2 == 0) {
                i = null;
            } else {
                I[] iArr = this.e;
                int i3 = i2 - 1;
                this.g = i3;
                i = iArr[i3];
            }
            this.i = i;
        }
        return i;
    }

    protected final void f() {
        int i = this.g;
        I[] iArr = this.e;
        if (i != iArr.length) {
            throw new IllegalStateException();
        }
        for (I i2 : iArr) {
            i2.e(1024);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ly
    public final void a(k32 k32Var) throws ny {
        synchronized (this.b) {
            i32 i32Var = this.j;
            if (i32Var == null) {
                if (k32Var == this.i) {
                    this.c.addLast(k32Var);
                    if (!this.c.isEmpty() && this.h > 0) {
                        this.b.notify();
                    }
                    this.i = null;
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                throw i32Var;
            }
        }
    }

    protected iy1(I[] iArr, O[] oArr) {
        this.e = iArr;
        this.g = iArr.length;
        for (int i = 0; i < this.g; i++) {
            this.e[i] = c();
        }
        this.f = oArr;
        this.h = oArr.length;
        for (int i2 = 0; i2 < this.h; i2++) {
            ((O[]) this.f)[i2] = d();
        }
        a aVar = new a((ny1) this);
        this.f9269a = aVar;
        aVar.start();
    }

    @Override // com.yandex.mobile.ads.impl.ly
    public final void flush() {
        synchronized (this.b) {
            this.k = true;
            I i = this.i;
            if (i != null) {
                i.b();
                I[] iArr = this.e;
                int i2 = this.g;
                this.g = i2 + 1;
                iArr[i2] = i;
                this.i = null;
            }
            while (!this.c.isEmpty()) {
                I iRemoveFirst = this.c.removeFirst();
                iRemoveFirst.b();
                I[] iArr2 = this.e;
                int i3 = this.g;
                this.g = i3 + 1;
                iArr2[i3] = iRemoveFirst;
            }
            while (!this.d.isEmpty()) {
                this.d.removeFirst().h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(O o) {
        synchronized (this.b) {
            o.b();
            O[] oArr = this.f;
            int i = this.h;
            this.h = i + 1;
            oArr[i] = o;
            if (!this.c.isEmpty() && this.h > 0) {
                this.b.notify();
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.ly
    public final void release() {
        synchronized (this.b) {
            this.l = true;
            this.b.notify();
        }
        try {
            this.f9269a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() throws InterruptedException {
        i32 i32Var;
        i32 i32VarA;
        synchronized (this.b) {
            while (!this.l && (this.c.isEmpty() || this.h <= 0)) {
                this.b.wait();
            }
            if (this.l) {
                return false;
            }
            I iRemoveFirst = this.c.removeFirst();
            O[] oArr = this.f;
            int i = this.h - 1;
            this.h = i;
            O o = oArr[i];
            boolean z = this.k;
            this.k = false;
            if (iRemoveFirst.c(4)) {
                o.b(4);
            } else {
                if (iRemoveFirst.c(Integer.MIN_VALUE)) {
                    o.b(Integer.MIN_VALUE);
                }
                if (iRemoveFirst.c(134217728)) {
                    o.b(134217728);
                }
                try {
                    i32VarA = a(iRemoveFirst, o, z);
                } catch (OutOfMemoryError e) {
                    i32Var = new i32("Unexpected decode error", e);
                    i32VarA = i32Var;
                } catch (RuntimeException e2) {
                    i32Var = new i32("Unexpected decode error", e2);
                    i32VarA = i32Var;
                }
                if (i32VarA != null) {
                    synchronized (this.b) {
                        this.j = i32VarA;
                    }
                    return false;
                }
            }
            synchronized (this.b) {
                if (this.k || o.c(Integer.MIN_VALUE)) {
                    o.h();
                } else {
                    this.d.addLast(o);
                }
                iRemoveFirst.b();
                I[] iArr = this.e;
                int i2 = this.g;
                this.g = i2 + 1;
                iArr[i2] = iRemoveFirst;
            }
            return true;
        }
    }
}
