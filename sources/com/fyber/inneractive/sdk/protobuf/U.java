package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public abstract class U implements D0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC3169a0 f2270a;
    public AbstractC3169a0 b;
    public boolean c = false;

    public U(AbstractC3169a0 abstractC3169a0) {
        this.f2270a = abstractC3169a0;
        this.b = (AbstractC3169a0) abstractC3169a0.dynamicMethod(Z.NEW_MUTABLE_INSTANCE);
    }

    public static void a(AbstractC3169a0 abstractC3169a0, AbstractC3169a0 abstractC3169a1) {
        Q0 q0 = Q0.c;
        q0.getClass();
        q0.a(abstractC3169a0.getClass()).a(abstractC3169a0, abstractC3169a1);
    }

    public final AbstractC3169a0 b() {
        if (this.c) {
            return this.b;
        }
        this.b.makeImmutable();
        this.c = true;
        return this.b;
    }

    public final void c() {
        if (this.c) {
            AbstractC3169a0 abstractC3169a0 = (AbstractC3169a0) this.b.dynamicMethod(Z.NEW_MUTABLE_INSTANCE);
            a(abstractC3169a0, this.b);
            this.b = abstractC3169a0;
            this.c = false;
        }
    }

    public final Object clone() {
        U uNewBuilderForType = this.f2270a.newBuilderForType();
        AbstractC3169a0 abstractC3169a0B = b();
        uNewBuilderForType.c();
        a(uNewBuilderForType.b, abstractC3169a0B);
        return uNewBuilderForType;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.F0
    public final E0 getDefaultInstanceForType() {
        return this.f2270a;
    }

    public static void a(Iterable iterable, List list) {
        Charset charset = AbstractC3205m0.f2291a;
        iterable.getClass();
        if (iterable instanceof InterfaceC3219r0) {
            List listB = ((InterfaceC3219r0) iterable).b();
            InterfaceC3219r0 interfaceC3219r0 = (InterfaceC3219r0) list;
            int size = list.size();
            for (Object obj : listB) {
                if (obj == null) {
                    String str = "Element at index " + (interfaceC3219r0.size() - size) + " is null.";
                    for (int size2 = interfaceC3219r0.size() - 1; size2 >= size; size2--) {
                        interfaceC3219r0.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof AbstractC3221s) {
                    interfaceC3219r0.a((AbstractC3221s) obj);
                } else {
                    interfaceC3219r0.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof O0) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
        }
        int size3 = list.size();
        for (Object obj2 : iterable) {
            if (obj2 == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                    list.remove(size4);
                }
                throw new NullPointerException(str2);
            }
            list.add(obj2);
        }
    }

    public final AbstractC3169a0 a() {
        AbstractC3169a0 abstractC3169a0B = b();
        if (abstractC3169a0B.isInitialized()) {
            return abstractC3169a0B;
        }
        throw new C3209n1();
    }

    public final U a(AbstractC3229w abstractC3229w, H h) throws IOException {
        c();
        try {
            Q0 q0 = Q0.c;
            AbstractC3169a0 abstractC3169a0 = this.b;
            q0.getClass();
            U0 u0A = q0.a(abstractC3169a0.getClass());
            AbstractC3169a0 abstractC3169a1 = this.b;
            C3231x c3231x = abstractC3229w.d;
            if (c3231x == null) {
                c3231x = new C3231x(abstractC3229w);
            }
            u0A.a(abstractC3169a1, c3231x, h);
            return this;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }
}
