package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Um implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4074dl f11383a;

    public Um() {
        this(new C4074dl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4258l6 fromModel(Tm tm) {
        C4258l6 c4258l6 = new C4258l6();
        Integer num = tm.e;
        c4258l6.e = num == null ? -1 : num.intValue();
        c4258l6.d = tm.d;
        c4258l6.b = tm.b;
        c4258l6.f11645a = tm.f11369a;
        c4258l6.c = tm.c;
        C4074dl c4074dl = this.f11383a;
        List list = tm.f;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new C4124fl((StackTraceElement) it.next()));
        }
        c4258l6.f = c4074dl.fromModel(arrayList);
        return c4258l6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Um(C4074dl c4074dl) {
        this.f11383a = c4074dl;
    }

    public final Tm a(C4258l6 c4258l6) {
        throw new UnsupportedOperationException();
    }
}
