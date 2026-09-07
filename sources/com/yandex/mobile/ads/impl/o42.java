package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class o42 extends rk implements Handler.Callback {
    private int A;
    private long B;
    private final Handler n;
    private final n42 o;
    private final j32 p;
    private final hc0 q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private gc0 v;
    private h32 w;
    private k32 x;
    private l32 y;
    private l32 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o42(n42 n42Var, Looper looper) {
        super(3);
        j32 j32Var = j32.f9285a;
        this.o = (n42) hg.a(n42Var);
        this.n = looper == null ? null : x82.a(looper, (Handler.Callback) this);
        this.p = j32Var;
        this.q = new hc0();
        this.B = -9223372036854775807L;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final boolean d() {
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.ro1, com.yandex.mobile.ads.impl.so1
    public final String getName() {
        return "TextRenderer";
    }

    public final void c(long j) {
        if (k()) {
            this.B = j;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected final void u() {
        this.v = null;
        this.B = -9223372036854775807L;
        List<ev> listEmptyList = Collections.emptyList();
        Handler handler = this.n;
        if (handler != null) {
            handler.obtainMessage(0, listEmptyList).sendToTarget();
        } else {
            this.o.onCues(listEmptyList);
            this.o.a(new gv(listEmptyList));
        }
        B();
    }

    @Override // com.yandex.mobile.ads.impl.rk, com.yandex.mobile.ads.impl.ro1
    public final boolean a() {
        return this.s;
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected final void a(long j, boolean z) {
        List<ev> listEmptyList = Collections.emptyList();
        Handler handler = this.n;
        if (handler != null) {
            handler.obtainMessage(0, listEmptyList).sendToTarget();
        } else {
            this.o.onCues(listEmptyList);
            this.o.a(new gv(listEmptyList));
        }
        this.r = false;
        this.s = false;
        this.B = -9223372036854775807L;
        if (this.u != 0) {
            B();
            z();
        } else {
            A();
            h32 h32Var = this.w;
            h32Var.getClass();
            h32Var.flush();
        }
    }

    private void A() {
        this.x = null;
        this.A = -1;
        l32 l32Var = this.y;
        if (l32Var != null) {
            l32Var.h();
            this.y = null;
        }
        l32 l32Var2 = this.z;
        if (l32Var2 != null) {
            l32Var2.h();
            this.z = null;
        }
    }

    private void B() {
        A();
        h32 h32Var = this.w;
        h32Var.getClass();
        h32Var.release();
        this.w = null;
        this.u = 0;
    }

    private void z() {
        this.t = true;
        j32 j32Var = this.p;
        gc0 gc0Var = this.v;
        gc0Var.getClass();
        this.w = ((j32.a) j32Var).a(gc0Var);
    }

    private long y() {
        if (this.A == -1) {
            return Long.MAX_VALUE;
        }
        this.y.getClass();
        if (this.A >= this.y.a()) {
            return Long.MAX_VALUE;
        }
        return this.y.a(this.A);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            List<ev> list = (List) message.obj;
            this.o.onCues(list);
            this.o.a(new gv(list));
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected final void a(gc0[] gc0VarArr, long j, long j2) {
        this.v = gc0VarArr[0];
        if (this.w != null) {
            this.u = 1;
        } else {
            z();
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00de  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f5  */
    @Override // com.yandex.mobile.ads.impl.ro1
    public final void a(long j, long j2) throws ny {
        boolean z;
        List<ev> listB;
        Handler handler;
        if (k()) {
            long j3 = this.B;
            if (j3 != -9223372036854775807L && j >= j3) {
                A();
                this.s = true;
            }
        }
        if (this.s) {
            return;
        }
        if (this.z == null) {
            h32 h32Var = this.w;
            h32Var.getClass();
            h32Var.a(j);
            try {
                h32 h32Var2 = this.w;
                h32Var2.getClass();
                this.z = h32Var2.a();
            } catch (i32 e) {
                at0.a("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.v, e);
                List<ev> listEmptyList = Collections.emptyList();
                Handler handler2 = this.n;
                if (handler2 != null) {
                    handler2.obtainMessage(0, listEmptyList).sendToTarget();
                } else {
                    this.o.onCues(listEmptyList);
                    this.o.a(new gv(listEmptyList));
                }
                B();
                z();
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.y != null) {
            long jY = y();
            z = false;
            while (jY <= j) {
                this.A++;
                jY = y();
                z = true;
            }
        } else {
            z = false;
        }
        l32 l32Var = this.z;
        if (l32Var != null) {
            if (!l32Var.f()) {
                if (l32Var.c <= j) {
                    l32 l32Var2 = this.y;
                    if (l32Var2 != null) {
                        l32Var2.h();
                    }
                    this.A = l32Var.a(j);
                    this.y = l32Var;
                    this.z = null;
                }
                this.y.getClass();
                listB = this.y.b(j);
                handler = this.n;
                if (handler != null) {
                    handler.obtainMessage(0, listB).sendToTarget();
                } else {
                    this.o.onCues(listB);
                    this.o.a(new gv(listB));
                }
            } else if (!z && y() == Long.MAX_VALUE) {
                if (this.u == 2) {
                    B();
                    z();
                } else {
                    A();
                    this.s = true;
                }
            }
            if (z) {
                this.y.getClass();
                listB = this.y.b(j);
                handler = this.n;
                if (handler != null) {
                    handler.obtainMessage(0, listB).sendToTarget();
                } else {
                    this.o.onCues(listB);
                    this.o.a(new gv(listB));
                }
            }
        } else if (z) {
            this.y.getClass();
            listB = this.y.b(j);
            handler = this.n;
            if (handler != null) {
                handler.obtainMessage(0, listB).sendToTarget();
            } else {
                this.o.onCues(listB);
                this.o.a(new gv(listB));
            }
        }
        if (this.u == 2) {
            return;
        }
        while (!this.r) {
            try {
                k32 k32VarB = this.x;
                if (k32VarB == null) {
                    h32 h32Var3 = this.w;
                    h32Var3.getClass();
                    k32VarB = h32Var3.b();
                    if (k32VarB == null) {
                        return;
                    } else {
                        this.x = k32VarB;
                    }
                }
                if (this.u == 1) {
                    k32VarB.d(4);
                    h32 h32Var4 = this.w;
                    h32Var4.getClass();
                    h32Var4.a(k32VarB);
                    this.x = null;
                    this.u = 2;
                    return;
                }
                int iA = a(this.q, k32VarB, 0);
                if (iA == -4) {
                    if (k32VarB.f()) {
                        this.r = true;
                        this.t = false;
                    } else {
                        gc0 gc0Var = this.q.b;
                        if (gc0Var == null) {
                            return;
                        }
                        k32VarB.j = gc0Var.q;
                        k32VarB.h();
                        this.t &= !k32VarB.g();
                    }
                    if (!this.t) {
                        h32 h32Var5 = this.w;
                        h32Var5.getClass();
                        h32Var5.a(k32VarB);
                        this.x = null;
                    }
                } else if (iA == -3) {
                    return;
                }
            } catch (i32 e2) {
                at0.a("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.v, e2);
                List<ev> listEmptyList2 = Collections.emptyList();
                Handler handler3 = this.n;
                if (handler3 != null) {
                    handler3.obtainMessage(0, listEmptyList2).sendToTarget();
                } else {
                    this.o.onCues(listEmptyList2);
                    this.o.a(new gv(listEmptyList2));
                }
                B();
                z();
                return;
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.so1
    public final int a(gc0 gc0Var) {
        if (((j32.a) this.p).b(gc0Var)) {
            return so1.a(gc0Var.F == 0 ? 4 : 2, 0, 0);
        }
        if (s01.e(gc0Var.m)) {
            return so1.a(1, 0, 0);
        }
        return so1.a(0, 0, 0);
    }
}
