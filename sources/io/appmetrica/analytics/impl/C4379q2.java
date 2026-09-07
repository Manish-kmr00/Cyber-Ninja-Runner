package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.q2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4379q2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Pl fromModel(C4354p2 c4354p2) {
        Nl nl;
        Pl pl = new Pl();
        pl.f11300a = new Ol[c4354p2.f11711a.size()];
        for (int i = 0; i < c4354p2.f11711a.size(); i++) {
            Ol ol = new Ol();
            Pair pair = (Pair) c4354p2.f11711a.get(i);
            ol.f11286a = (String) pair.first;
            if (pair.second != null) {
                ol.b = new Nl();
                C4329o2 c4329o2 = (C4329o2) pair.second;
                if (c4329o2 == null) {
                    nl = null;
                } else {
                    Nl nl2 = new Nl();
                    nl2.f11272a = c4329o2.f11694a;
                    nl = nl2;
                }
                ol.b = nl;
            }
            pl.f11300a[i] = ol;
        }
        return pl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4354p2 toModel(Pl pl) {
        ArrayList arrayList = new ArrayList();
        for (Ol ol : pl.f11300a) {
            String str = ol.f11286a;
            Nl nl = ol.b;
            arrayList.add(new Pair(str, nl == null ? null : new C4329o2(nl.f11272a)));
        }
        return new C4354p2(arrayList);
    }
}
