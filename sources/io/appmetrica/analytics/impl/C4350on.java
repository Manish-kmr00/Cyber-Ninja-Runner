package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.List;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.on, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4350on implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4051cn f11707a;
    public final T b;
    public final C4407r6 c;
    public final C4074dl d;
    public final C4540we e;
    public final C4565xe f;

    public C4350on() {
        this(new C4051cn(), new T(new Um()), new C4407r6(), new C4074dl(), new C4540we(), new C4565xe());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4134g6 fromModel(C4325nn c4325nn) {
        C4134g6 c4134g6 = new C4134g6();
        C4076dn c4076dn = c4325nn.f11690a;
        if (c4076dn != null) {
            c4134g6.f11563a = this.f11707a.fromModel(c4076dn);
        }
        S s = c4325nn.b;
        if (s != null) {
            c4134g6.b = this.b.fromModel(s);
        }
        List<C4124fl> list = c4325nn.c;
        if (list != null) {
            c4134g6.e = this.d.fromModel(list);
        }
        String str = c4325nn.g;
        if (str != null) {
            c4134g6.c = str;
        }
        c4134g6.d = this.c.a(c4325nn.h);
        if (!TextUtils.isEmpty(c4325nn.d)) {
            c4134g6.h = this.e.fromModel(c4325nn.d);
        }
        if (!TextUtils.isEmpty(c4325nn.e)) {
            c4134g6.i = c4325nn.e.getBytes();
        }
        if (!In.a(c4325nn.f)) {
            c4134g6.j = this.f.fromModel(c4325nn.f);
        }
        return c4134g6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C4350on(C4051cn c4051cn, T t, C4407r6 c4407r6, C4074dl c4074dl, C4540we c4540we, C4565xe c4565xe) {
        this.b = t;
        this.f11707a = c4051cn;
        this.c = c4407r6;
        this.d = c4074dl;
        this.e = c4540we;
        this.f = c4565xe;
    }

    public final C4325nn a(C4134g6 c4134g6) {
        throw new UnsupportedOperationException();
    }
}
