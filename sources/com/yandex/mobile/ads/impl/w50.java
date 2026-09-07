package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes12.dex */
public final class w50 extends ly1 {
    @Override // com.yandex.mobile.ads.impl.ly1
    protected final g01 a(j01 j01Var, ByteBuffer byteBuffer) {
        wf1 wf1Var = new wf1(byteBuffer.limit(), byteBuffer.array());
        String strQ = wf1Var.q();
        strQ.getClass();
        String strQ2 = wf1Var.q();
        strQ2.getClass();
        return new g01(new v50(strQ, strQ2, wf1Var.p(), wf1Var.p(), Arrays.copyOfRange(wf1Var.c(), wf1Var.d(), wf1Var.e())));
    }
}
