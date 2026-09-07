package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.cn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4051cn implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4074dl f11501a;

    public C4051cn() {
        this(new C4074dl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4283m6 fromModel(C4076dn c4076dn) {
        C4283m6 c4283m6 = new C4283m6();
        c4283m6.f11665a = (String) WrapUtils.getOrDefault(c4076dn.f11522a, "");
        c4283m6.b = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(c4076dn.b, ""));
        List<C4124fl> list = c4076dn.c;
        if (list != null) {
            c4283m6.c = this.f11501a.fromModel(list);
        }
        C4076dn c4076dn2 = c4076dn.d;
        if (c4076dn2 != null) {
            c4283m6.d = fromModel(c4076dn2);
        }
        List list2 = c4076dn.e;
        int i = 0;
        if (list2 == null) {
            c4283m6.e = new C4283m6[0];
        } else {
            c4283m6.e = new C4283m6[list2.size()];
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                c4283m6.e[i] = fromModel((C4076dn) it.next());
                i++;
            }
        }
        return c4283m6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C4051cn(C4074dl c4074dl) {
        this.f11501a = c4074dl;
    }

    public final C4076dn a(C4283m6 c4283m6) {
        throw new UnsupportedOperationException();
    }
}
