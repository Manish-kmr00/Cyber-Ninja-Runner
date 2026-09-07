package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vn1 f8373a;
    private final ab b;
    private final sn1 c;
    private final t50 d;
    private rs1.b e;
    private rs1 f;
    private int g;
    private int h;
    private int i;
    private os1 j;

    public a60(vn1 connectionPool, ab address, sn1 call, t50 eventListener) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.f8373a = connectionPool;
        this.b = address;
        this.c = call;
        this.d = eventListener;
    }

    public final z50 a(be1 client, wn1 chain) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        try {
            int iC = chain.c();
            int iE = chain.e();
            int iG = chain.g();
            client.getClass();
            return a(iC, iE, iG, client.v(), !Intrinsics.areEqual(chain.f().f(), "GET")).a(client, chain);
        } catch (qs1 e) {
            a(e.b());
            throw e;
        } catch (IOException e2) {
            a(e2);
            throw new qs1(e2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007b  */
    /* JADX WARN: Code duplicated, block: B:33:0x0099  */
    /* JADX WARN: Code duplicated, block: B:35:0x009d  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:44:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:50:0x010f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0150  */
    /* JADX WARN: Code duplicated, block: B:56:0x0176  */
    /* JADX WARN: Code duplicated, block: B:86:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x01ce A[SYNTHETIC] */
    private final tn1 a(int i, int i2, int i3, boolean z, boolean z2) throws IOException {
        os1 os1VarC;
        rs1.b bVar;
        rs1 rs1Var;
        rs1.b bVarB;
        List<os1> listA;
        tn1 connection;
        rs1.b bVar2;
        rs1 rs1Var2;
        Socket socketL;
        while (!this.c.j()) {
            tn1 connection2 = this.c.d();
            if (connection2 != null) {
                synchronized (connection2) {
                    socketL = (connection2.d() || !a(connection2.k().a().k())) ? this.c.l() : null;
                    Unit unit = Unit.INSTANCE;
                }
                if (this.c.d() == null) {
                    if (socketL != null) {
                        y82.a(socketL);
                    }
                    t50 t50Var = this.d;
                    sn1 call = this.c;
                    t50Var.getClass();
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(connection2, "connection");
                    this.g = 0;
                    this.h = 0;
                    this.i = 0;
                    if (this.f8373a.a(this.b, this.c, null, false)) {
                        connection2 = this.c.d();
                        Intrinsics.checkNotNull(connection2);
                        t50 t50Var2 = this.d;
                        sn1 call2 = this.c;
                        t50Var2.getClass();
                        Intrinsics.checkNotNullParameter(call2, "call");
                        Intrinsics.checkNotNullParameter(connection2, "connection");
                    } else {
                        os1VarC = this.j;
                        try {
                            if (os1VarC != null) {
                                Intrinsics.checkNotNull(os1VarC);
                                this.j = null;
                            } else {
                                bVar = this.e;
                                if (bVar != null) {
                                    Intrinsics.checkNotNull(bVar);
                                    if (bVar.b()) {
                                        rs1.b bVar3 = this.e;
                                        Intrinsics.checkNotNull(bVar3);
                                        os1VarC = bVar3.c();
                                    }
                                }
                                rs1Var = this.f;
                                if (rs1Var == null) {
                                    rs1Var = new rs1(this.b, this.c.c().n(), this.c, this.d);
                                    this.f = rs1Var;
                                }
                                bVarB = rs1Var.b();
                                this.e = bVarB;
                                listA = bVarB.a();
                                if (!this.c.j()) {
                                    if (this.f8373a.a(this.b, this.c, listA, false)) {
                                        connection2 = this.c.d();
                                        Intrinsics.checkNotNull(connection2);
                                        t50 t50Var3 = this.d;
                                        sn1 call3 = this.c;
                                        t50Var3.getClass();
                                        Intrinsics.checkNotNullParameter(call3, "call");
                                        Intrinsics.checkNotNullParameter(connection2, "connection");
                                    } else {
                                        os1VarC = bVarB.c();
                                        connection = new tn1(this.f8373a, os1VarC);
                                        this.c.b(connection);
                                        connection.a(i, i2, i3, z, this.c, this.d);
                                        this.c.b((tn1) null);
                                        this.c.c().n().a(connection.k());
                                        if (this.f8373a.a(this.b, this.c, listA, true)) {
                                            tn1 connection3 = this.c.d();
                                            Intrinsics.checkNotNull(connection3);
                                            this.j = os1VarC;
                                            y82.a(connection.m());
                                            t50 t50Var4 = this.d;
                                            sn1 call4 = this.c;
                                            t50Var4.getClass();
                                            Intrinsics.checkNotNullParameter(call4, "call");
                                            Intrinsics.checkNotNullParameter(connection3, "connection");
                                            connection2 = connection3;
                                        } else {
                                            synchronized (connection) {
                                                this.f8373a.b(connection);
                                                this.c.a(connection);
                                                Unit unit2 = Unit.INSTANCE;
                                            }
                                            t50 t50Var5 = this.d;
                                            sn1 call5 = this.c;
                                            t50Var5.getClass();
                                            Intrinsics.checkNotNullParameter(call5, "call");
                                            Intrinsics.checkNotNullParameter(connection, "connection");
                                            connection2 = connection;
                                        }
                                    }
                                } else {
                                    throw new IOException("Canceled");
                                }
                            }
                            connection.a(i, i2, i3, z, this.c, this.d);
                            this.c.b((tn1) null);
                            this.c.c().n().a(connection.k());
                            if (this.f8373a.a(this.b, this.c, listA, true)) {
                                tn1 connection4 = this.c.d();
                                Intrinsics.checkNotNull(connection4);
                                this.j = os1VarC;
                                y82.a(connection.m());
                                t50 t50Var6 = this.d;
                                sn1 call6 = this.c;
                                t50Var6.getClass();
                                Intrinsics.checkNotNullParameter(call6, "call");
                                Intrinsics.checkNotNullParameter(connection4, "connection");
                                connection2 = connection4;
                            } else {
                                synchronized (connection) {
                                    this.f8373a.b(connection);
                                    this.c.a(connection);
                                    Unit unit3 = Unit.INSTANCE;
                                    t50 t50Var7 = this.d;
                                    sn1 call7 = this.c;
                                    t50Var7.getClass();
                                    Intrinsics.checkNotNullParameter(call7, "call");
                                    Intrinsics.checkNotNullParameter(connection, "connection");
                                    connection2 = connection;
                                }
                            }
                        } catch (Throwable th) {
                            this.c.b((tn1) null);
                            throw th;
                        }
                        listA = null;
                        connection = new tn1(this.f8373a, os1VarC);
                        this.c.b(connection);
                    }
                } else if (socketL != null) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                this.g = 0;
                this.h = 0;
                this.i = 0;
                if (this.f8373a.a(this.b, this.c, null, false)) {
                    connection2 = this.c.d();
                    Intrinsics.checkNotNull(connection2);
                    t50 t50Var8 = this.d;
                    sn1 call8 = this.c;
                    t50Var8.getClass();
                    Intrinsics.checkNotNullParameter(call8, "call");
                    Intrinsics.checkNotNullParameter(connection2, "connection");
                } else {
                    os1VarC = this.j;
                    if (os1VarC != null) {
                        Intrinsics.checkNotNull(os1VarC);
                        this.j = null;
                    } else {
                        bVar = this.e;
                        if (bVar != null) {
                            Intrinsics.checkNotNull(bVar);
                            if (bVar.b()) {
                                rs1.b bVar4 = this.e;
                                Intrinsics.checkNotNull(bVar4);
                                os1VarC = bVar4.c();
                            }
                        }
                        rs1Var = this.f;
                        if (rs1Var == null) {
                            rs1Var = new rs1(this.b, this.c.c().n(), this.c, this.d);
                            this.f = rs1Var;
                        }
                        bVarB = rs1Var.b();
                        this.e = bVarB;
                        listA = bVarB.a();
                        if (!this.c.j()) {
                            if (this.f8373a.a(this.b, this.c, listA, false)) {
                                connection2 = this.c.d();
                                Intrinsics.checkNotNull(connection2);
                                t50 t50Var9 = this.d;
                                sn1 call9 = this.c;
                                t50Var9.getClass();
                                Intrinsics.checkNotNullParameter(call9, "call");
                                Intrinsics.checkNotNullParameter(connection2, "connection");
                            } else {
                                os1VarC = bVarB.c();
                                connection = new tn1(this.f8373a, os1VarC);
                                this.c.b(connection);
                                connection.a(i, i2, i3, z, this.c, this.d);
                                this.c.b((tn1) null);
                                this.c.c().n().a(connection.k());
                                if (this.f8373a.a(this.b, this.c, listA, true)) {
                                    tn1 connection5 = this.c.d();
                                    Intrinsics.checkNotNull(connection5);
                                    this.j = os1VarC;
                                    y82.a(connection.m());
                                    t50 t50Var10 = this.d;
                                    sn1 call10 = this.c;
                                    t50Var10.getClass();
                                    Intrinsics.checkNotNullParameter(call10, "call");
                                    Intrinsics.checkNotNullParameter(connection5, "connection");
                                    connection2 = connection5;
                                } else {
                                    synchronized (connection) {
                                        this.f8373a.b(connection);
                                        this.c.a(connection);
                                        Unit unit4 = Unit.INSTANCE;
                                        t50 t50Var11 = this.d;
                                        sn1 call11 = this.c;
                                        t50Var11.getClass();
                                        Intrinsics.checkNotNullParameter(call11, "call");
                                        Intrinsics.checkNotNullParameter(connection, "connection");
                                        connection2 = connection;
                                    }
                                }
                            }
                        } else {
                            throw new IOException("Canceled");
                        }
                    }
                    listA = null;
                    connection = new tn1(this.f8373a, os1VarC);
                    this.c.b(connection);
                    connection.a(i, i2, i3, z, this.c, this.d);
                    this.c.b((tn1) null);
                    this.c.c().n().a(connection.k());
                    if (this.f8373a.a(this.b, this.c, listA, true)) {
                        tn1 connection6 = this.c.d();
                        Intrinsics.checkNotNull(connection6);
                        this.j = os1VarC;
                        y82.a(connection.m());
                        t50 t50Var12 = this.d;
                        sn1 call12 = this.c;
                        t50Var12.getClass();
                        Intrinsics.checkNotNullParameter(call12, "call");
                        Intrinsics.checkNotNullParameter(connection6, "connection");
                        connection2 = connection6;
                    } else {
                        synchronized (connection) {
                            this.f8373a.b(connection);
                            this.c.a(connection);
                            Unit unit5 = Unit.INSTANCE;
                            t50 t50Var13 = this.d;
                            sn1 call13 = this.c;
                            t50Var13.getClass();
                            Intrinsics.checkNotNullParameter(call13, "call");
                            Intrinsics.checkNotNullParameter(connection, "connection");
                            connection2 = connection;
                        }
                    }
                }
            }
            if (connection2.a(z2)) {
                return connection2;
            }
            connection2.j();
            if (this.j == null && (bVar2 = this.e) != null && !bVar2.b() && (rs1Var2 = this.f) != null && !rs1Var2.a()) {
                throw new IOException("exhausted all routes");
            }
        }
        throw new IOException("Canceled");
    }

    public final boolean b() {
        rs1 rs1Var;
        tn1 tn1VarD;
        int i = this.g;
        if (i == 0 && this.h == 0 && this.i == 0) {
            return false;
        }
        if (this.j != null) {
            return true;
        }
        os1 os1VarK = null;
        if (i <= 1 && this.h <= 1 && this.i <= 0 && (tn1VarD = this.c.d()) != null) {
            synchronized (tn1VarD) {
                if (tn1VarD.e() == 0) {
                    di0 di0VarK = tn1VarD.k().a().k();
                    di0 other = this.b.k();
                    byte[] bArr = y82.f10712a;
                    Intrinsics.checkNotNullParameter(di0VarK, "<this>");
                    Intrinsics.checkNotNullParameter(other, "other");
                    if (Intrinsics.areEqual(di0VarK.g(), other.g()) && di0VarK.i() == other.i() && Intrinsics.areEqual(di0VarK.k(), other.k())) {
                        os1VarK = tn1VarD.k();
                    }
                }
            }
        }
        if (os1VarK != null) {
            this.j = os1VarK;
            return true;
        }
        rs1.b bVar = this.e;
        if ((bVar == null || !bVar.b()) && (rs1Var = this.f) != null) {
            return rs1Var.a();
        }
        return true;
    }

    public final ab a() {
        return this.b;
    }

    public final boolean a(di0 url) {
        Intrinsics.checkNotNullParameter(url, "url");
        di0 di0VarK = this.b.k();
        return url.i() == di0VarK.i() && Intrinsics.areEqual(url.g(), di0VarK.g());
    }

    public final void a(IOException e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.j = null;
        if ((e instanceof s22) && ((s22) e).b == q50.h) {
            this.g++;
        } else if (e instanceof nr) {
            this.h++;
        } else {
            this.i++;
        }
    }
}
