package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public interface ro1 extends ji1.b {

    public interface a {
        void a();

        void b();
    }

    default void a(float f, float f2) throws j60 {
    }

    void a(int i, ii1 ii1Var);

    void a(long j) throws j60;

    void a(long j, long j2) throws j60;

    void a(to1 to1Var, gc0[] gc0VarArr, et1 et1Var, long j, boolean z, boolean z2, long j2, long j3) throws j60;

    void a(gc0[] gc0VarArr, et1 et1Var, long j, long j2) throws j60;

    boolean a();

    void b();

    void c();

    boolean d();

    boolean e();

    et1 g();

    String getName();

    int getState();

    void h();

    void i() throws IOException;

    long j();

    boolean k();

    bv0 l();

    int m();

    rk n();

    void start() throws j60;

    void stop();
}
