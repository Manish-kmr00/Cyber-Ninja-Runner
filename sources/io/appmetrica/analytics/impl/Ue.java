package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class Ue implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4143gf f11376a;
    public final Pe b;

    public Ue() {
        this(new C4143gf(), new Pe());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4043cf fromModel(Se se) {
        C4043cf c4043cf = new C4043cf();
        c4043cf.f11495a = this.f11376a.fromModel(se.f11348a);
        c4043cf.b = new C4018bf[se.b.size()];
        Iterator<Re> it = se.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            c4043cf.b[i] = this.b.fromModel(it.next());
            i++;
        }
        return c4043cf;
    }

    public Ue(C4143gf c4143gf, Pe pe) {
        this.f11376a = c4143gf;
        this.b = pe;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Se toModel(C4043cf c4043cf) {
        C4118ff model;
        ArrayList arrayList = new ArrayList(c4043cf.b.length);
        for (C4018bf c4018bf : c4043cf.b) {
            arrayList.add(this.b.toModel(c4018bf));
        }
        C3993af c3993af = c4043cf.f11495a;
        if (c3993af == null) {
            model = this.f11376a.toModel(new C3993af());
        } else {
            model = this.f11376a.toModel(c3993af);
        }
        return new Se(model, arrayList);
    }
}
