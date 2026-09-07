package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;

/* JADX INFO: loaded from: classes8.dex */
public final class Zj implements Oc {
    @Override // io.appmetrica.analytics.impl.Oc
    public final void a(Context context) {
        AbstractC4473tm abstractC4473tmA = C4448sm.a(Ll.class);
        ProtobufStateStorage<Object> protobufStateStorageA = abstractC4473tmA.a(context, abstractC4473tmA.d(context));
        Ll ll = (Ll) protobufStateStorageA.read();
        Kl klA = ll.a(ll.m);
        klA.o = 0L;
        protobufStateStorageA.save(new Ll(klA));
    }
}
