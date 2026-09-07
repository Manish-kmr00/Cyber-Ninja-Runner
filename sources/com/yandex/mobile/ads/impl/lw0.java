package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface lw0 extends fx1 {

    public interface a extends fx1.a<lw0> {
        void a(lw0 lw0Var);
    }

    long a(long j, yw1 yw1Var);

    long a(e70[] e70VarArr, boolean[] zArr, et1[] et1VarArr, boolean[] zArr2, long j);

    void a(a aVar, long j);

    void discardBuffer(long j, boolean z);

    s52 getTrackGroups();

    void maybeThrowPrepareError() throws IOException;

    long readDiscontinuity();

    long seekToUs(long j);
}
