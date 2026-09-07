package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2071a;
    public final List b;
    public final byte[] c;

    public D(int i, String str, ArrayList arrayList, byte[] bArr) {
        this.f2071a = str;
        this.b = arrayList == null ? Collections.emptyList() : Collections.unmodifiableList(arrayList);
        this.c = bArr;
    }
}
