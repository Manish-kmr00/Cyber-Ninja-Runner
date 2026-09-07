package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.tg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4467tg implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4051cn f11782a;
    public final T b;
    public final C4407r6 c;
    public final C4074dl d;
    public final C4540we e;
    public final C4565xe f;

    public C4467tg() {
        this(new C4051cn(), new T(new Um()), new C4407r6(), new C4074dl(), new C4540we(), new C4565xe());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4184i6 fromModel(C4442sg c4442sg) {
        C4184i6 c4184i6 = new C4184i6();
        c4184i6.f = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(c4442sg.f11764a, c4184i6.f));
        C4325nn c4325nn = c4442sg.b;
        if (c4325nn != null) {
            C4076dn c4076dn = c4325nn.f11690a;
            if (c4076dn != null) {
                c4184i6.f11596a = this.f11782a.fromModel(c4076dn);
            }
            S s = c4325nn.b;
            if (s != null) {
                c4184i6.b = this.b.fromModel(s);
            }
            List<C4124fl> list = c4325nn.c;
            if (list != null) {
                c4184i6.e = this.d.fromModel(list);
            }
            c4184i6.c = (String) WrapUtils.getOrDefault(c4325nn.g, c4184i6.c);
            c4184i6.d = this.c.a(c4325nn.h);
            if (!TextUtils.isEmpty(c4325nn.d)) {
                c4184i6.i = this.e.fromModel(c4325nn.d);
            }
            if (!TextUtils.isEmpty(c4325nn.e)) {
                c4184i6.j = c4325nn.e.getBytes();
            }
            if (!In.a(c4325nn.f)) {
                c4184i6.k = this.f.fromModel(c4325nn.f);
            }
        }
        return c4184i6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C4467tg(C4051cn c4051cn, T t, C4407r6 c4407r6, C4074dl c4074dl, C4540we c4540we, C4565xe c4565xe) {
        this.f11782a = c4051cn;
        this.b = t;
        this.c = c4407r6;
        this.d = c4074dl;
        this.e = c4540we;
        this.f = c4565xe;
    }

    public final C4442sg a(C4184i6 c4184i6) {
        throw new UnsupportedOperationException();
    }
}
