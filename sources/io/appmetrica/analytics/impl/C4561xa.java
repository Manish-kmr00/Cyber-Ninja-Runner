package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.xa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public class C4561xa extends M2 {
    public final Aa b;

    public C4561xa(int i) {
        this(i, null);
    }

    public int b(Object obj) {
        return 0;
    }

    public C4561xa(int i, Aa aa) {
        super(i);
        this.b = aa;
    }

    @Override // io.appmetrica.analytics.impl.M2, io.appmetrica.analytics.impl.Aa
    public final C4225jn a(List<Object> list) {
        int iB;
        int i = 0;
        if (list == null || (list.size() <= this.f11252a && this.b == null)) {
            iB = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            iB = 0;
            int i2 = 0;
            for (Object obj : list) {
                if (i2 < this.f11252a) {
                    Aa aa = this.b;
                    if (aa != null) {
                        C4225jn c4225jnA = aa.a(obj);
                        Object obj2 = c4225jnA.f11624a;
                        iB += c4225jnA.b.getBytesTruncated();
                        In.a(obj, c4225jnA.f11624a);
                        obj = obj2;
                    }
                    arrayList.add(obj);
                } else {
                    i++;
                    iB += b(obj);
                }
                i2++;
            }
            list = arrayList;
        }
        return new C4225jn(list, new E4(i, iB));
    }

    public final Aa b() {
        return this.b;
    }
}
