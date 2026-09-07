package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public final class T implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Um f11355a;

    public T(Um um) {
        this.f11355a = um;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4034c6 fromModel(S s) {
        C4034c6 c4034c6 = new C4034c6();
        Tm tm = s.f11339a;
        if (tm != null) {
            c4034c6.f11491a = this.f11355a.fromModel(tm);
        }
        c4034c6.b = new C4258l6[s.b.size()];
        Iterator it = s.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            c4034c6.b[i] = this.f11355a.fromModel((Tm) it.next());
            i++;
        }
        String str = s.c;
        if (str != null) {
            c4034c6.c = str;
        }
        return c4034c6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final S a(C4034c6 c4034c6) {
        throw new UnsupportedOperationException();
    }
}
