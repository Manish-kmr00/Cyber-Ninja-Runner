package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.s4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4430s4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11758a;
    public final C4431s5 b;
    public final HashMap c;
    public final C4536wa d;
    public final Context e;
    public final C4605z4 f;

    public C4430s4(Context context, C4431s5 c4431s5) {
        this(context, c4431s5, new C4605z4());
    }

    public final InterfaceC4530w4 a(C4157h4 c4157h4, G4 g4) {
        InterfaceC4530w4 interfaceC4530w4A;
        synchronized (this.f11758a) {
            interfaceC4530w4A = (InterfaceC4530w4) this.c.get(c4157h4);
            if (interfaceC4530w4A == null) {
                this.f.getClass();
                interfaceC4530w4A = C4605z4.a(c4157h4).a(this.e, this.b, c4157h4, g4);
                this.c.put(c4157h4, interfaceC4530w4A);
                this.d.a(new C4405r4(c4157h4.b, c4157h4.c, c4157h4.d), c4157h4);
            }
        }
        return interfaceC4530w4A;
    }

    public C4430s4(Context context, C4431s5 c4431s5, C4605z4 c4605z4) {
        this.f11758a = new Object();
        this.c = new HashMap();
        this.d = new C4536wa();
        this.e = context.getApplicationContext();
        this.b = c4431s5;
        this.f = c4605z4;
    }

    public final void a(int i, String str, String str2) {
        Integer numValueOf = Integer.valueOf(i);
        synchronized (this.f11758a) {
            C4536wa c4536wa = this.d;
            Collection collection = (Collection) c4536wa.f11830a.remove(new C4405r4(str, numValueOf, str2));
            if (!In.a(collection)) {
                collection.size();
                ArrayList arrayList = new ArrayList(collection.size());
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    arrayList.add((InterfaceC4530w4) this.c.remove((C4157h4) it.next()));
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((InterfaceC4530w4) it2.next()).a();
                }
            }
        }
    }
}
