package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;

/* JADX INFO: loaded from: classes5.dex */
public final class Kn implements Ra {
    @Override // io.appmetrica.analytics.impl.Ra
    public final String a(Context context) {
        ProtobufStateStorage<Object> protobufStateStorageA;
        Ll ll;
        try {
            AbstractC4473tm abstractC4473tmA = C4448sm.a(Ll.class);
            if (abstractC4473tmA != null && (protobufStateStorageA = abstractC4473tmA.a(context, abstractC4473tmA.c(context))) != null && (ll = (Ll) protobufStateStorageA.read()) != null) {
                return ll.f11248a;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
