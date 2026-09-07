package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class Jl implements Ml {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Hl f11214a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.Ml
    public final void a(Hl hl) {
        this.f11214a = hl;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((Ml) it.next()).a(hl);
        }
    }

    public final Hl b() {
        Hl hl = this.f11214a;
        if (hl != null) {
            return hl;
        }
        Intrinsics.throwUninitializedPropertyAccessException("startupState");
        return null;
    }

    public final void b(Ml ml) {
        this.b.remove(ml);
    }

    public final void a(Ml ml) {
        this.b.add(ml);
        if (this.f11214a != null) {
            Hl hl = this.f11214a;
            if (hl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startupState");
                hl = null;
            }
            ml.a(hl);
        }
    }

    public final void a(Context context) {
        String strOptStringOrNull;
        ProtobufStateStorage<Object> protobufStateStorageA = C4448sm.a(Ll.class).a(context);
        Tn tnA = C4486ua.j().B().a();
        synchronized (tnA) {
            strOptStringOrNull = JsonUtils.optStringOrNull(tnA.f11370a.a(), "device_id");
        }
        a(new Hl(strOptStringOrNull, tnA.a(), (Ll) protobufStateStorageA.read()));
    }
}
