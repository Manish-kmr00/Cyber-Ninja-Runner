package com.pgl.ssdk;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes11.dex */
public abstract class c {

    public static class a extends r {
        public a(long j, long j2, int i, long j3, ByteBuffer byteBuffer) {
            super(j, j2, i, j3, byteBuffer);
        }
    }

    public static a a(o oVar) throws q, IOException {
        r rVarA = d.a(oVar);
        return new a(rVarA.a(), rVarA.c(), rVarA.b(), rVarA.e(), rVarA.d());
    }
}
