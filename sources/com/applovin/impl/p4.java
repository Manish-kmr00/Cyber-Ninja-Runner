package com.applovin.impl;

import android.content.Context;
import android.text.SpannedString;

/* JADX INFO: loaded from: classes.dex */
public class p4 extends o2 {
    private final p0.a n;
    private final Context o;
    private final boolean p;

    public p4(p0.a aVar, boolean z, Context context) {
        super(o2.c.RIGHT_DETAIL);
        this.n = aVar;
        this.o = context;
        this.c = new SpannedString(aVar.a());
        this.p = z;
    }

    @Override // com.applovin.impl.o2
    public SpannedString f() {
        return new SpannedString(this.n.a(this.o));
    }

    @Override // com.applovin.impl.o2
    public boolean o() {
        return false;
    }

    @Override // com.applovin.impl.o2
    public boolean p() {
        Boolean boolB = this.n.b(this.o);
        if (boolB != null) {
            return boolB.equals(Boolean.valueOf(this.p));
        }
        return false;
    }
}
