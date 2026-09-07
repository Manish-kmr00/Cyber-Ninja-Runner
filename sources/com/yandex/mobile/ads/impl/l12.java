package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes7.dex */
public final class l12 extends ly1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wf1 f9469a = new wf1();
    private final vf1 b = new vf1();
    private i52 c;

    @Override // com.yandex.mobile.ads.impl.ly1
    protected final g01 a(j01 j01Var, ByteBuffer byteBuffer) {
        g01.b n12Var;
        i52 i52Var = this.c;
        if (i52Var == null || j01Var.j != i52Var.c()) {
            i52 i52Var2 = new i52(j01Var.f);
            this.c = i52Var2;
            i52Var2.a(j01Var.f - j01Var.j);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.f9469a.a(iLimit, bArrArray);
        this.b.a(iLimit, bArrArray);
        this.b.d(39);
        long jB = (((long) this.b.b(1)) << 32) | ((long) this.b.b(32));
        this.b.d(20);
        int iB = this.b.b(12);
        int iB2 = this.b.b(8);
        this.f9469a.f(14);
        if (iB2 == 0) {
            n12Var = new n12();
        } else if (iB2 == 255) {
            n12Var = cl1.a(this.f9469a, iB, jB);
        } else if (iB2 == 4) {
            n12Var = o12.a(this.f9469a);
        } else if (iB2 != 5) {
            n12Var = iB2 != 6 ? null : z42.a(this.f9469a, jB, this.c);
        } else {
            n12Var = m12.a(this.f9469a, jB, this.c);
        }
        return n12Var == null ? new g01(new g01.b[0]) : new g01(n12Var);
    }
}
