package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes12.dex */
public abstract class ly1 implements h01 {
    protected abstract g01 a(j01 j01Var, ByteBuffer byteBuffer);

    @Override // com.yandex.mobile.ads.impl.h01
    public final g01 a(j01 j01Var) {
        ByteBuffer byteBuffer = j01Var.d;
        byteBuffer.getClass();
        if (byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            if (j01Var.e()) {
                return null;
            }
            return a(j01Var, byteBuffer);
        }
        throw new IllegalArgumentException();
    }
}
