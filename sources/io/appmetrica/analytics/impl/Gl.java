package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;

/* JADX INFO: loaded from: classes4.dex */
public final class Gl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProtobufStateStorage f11167a;
    public final Tn b;

    public Gl(ProtobufStateStorage protobufStateStorage, Tn tn) {
        this.f11167a = protobufStateStorage;
        this.b = tn;
    }

    public Gl(Context context) {
        this(C4448sm.a(Ll.class).a(context), C4486ua.j().B().a());
    }
}
