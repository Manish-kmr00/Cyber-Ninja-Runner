package com.fyber.inneractive.sdk.protobuf;

import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
public final class Y0 extends C3182e1 {
    public final /* synthetic */ AbstractC3185f1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y0(AbstractC3185f1 abstractC3185f1) {
        super(abstractC3185f1);
        this.b = abstractC3185f1;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.C3182e1, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new X0(this.b);
    }
}
