package com.bykv.vk.openvk.preload.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: Gson.java */
/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bykv.vk.openvk.preload.a.c.a<?> f880a = com.bykv.vk.openvk.preload.a.c.a.a(Object.class);
    private final ThreadLocal<Map<com.bykv.vk.openvk.preload.a.c.a<?>, a<?>>> b;
    private final Map<com.bykv.vk.openvk.preload.a.c.a<?>, q<?>> c;
    private final com.bykv.vk.openvk.preload.a.b.b d;
    private final com.bykv.vk.openvk.preload.a.b.a.d e;
    private List<r> f;
    private com.bykv.vk.openvk.preload.a.b.c g;
    private c h;
    private Map<Type, com.bykv.vk.openvk.preload.geckox.a.a.c<?>> i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private String q;
    private int r;
    private int s;
    private p t;
    private List<r> u;
    private List<r> v;

    public d() {
        this(com.bykv.vk.openvk.preload.a.b.c.f864a, b.f814a, Collections.emptyMap(), true, p.f894a, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    d(com.bykv.vk.openvk.preload.a.b.c cVar, c cVar2, Map<Type, com.bykv.vk.openvk.preload.geckox.a.a.c<?>> map, boolean z, p pVar, int i, int i2, List<r> list, List<r> list2, List<r> list3) {
        final q<Number> qVar;
        this.b = new ThreadLocal<>();
        this.c = new ConcurrentHashMap();
        this.g = cVar;
        this.h = cVar2;
        this.i = map;
        com.bykv.vk.openvk.preload.a.b.b bVar = new com.bykv.vk.openvk.preload.a.b.b(map);
        this.d = bVar;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = z;
        this.n = false;
        this.o = false;
        this.p = false;
        this.t = pVar;
        this.q = null;
        this.r = i;
        this.s = i2;
        this.u = list;
        this.v = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.B);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.g.f827a);
        arrayList.add(cVar);
        arrayList.addAll(list3);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.p);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.g);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.d);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.e);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f);
        if (pVar == p.f894a) {
            qVar = com.bykv.vk.openvk.preload.a.b.a.m.k;
        } else {
            qVar = new q<Number>() { // from class: com.bykv.vk.openvk.preload.a.d.3
                @Override // com.bykv.vk.openvk.preload.a.q
                public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, Number number) throws IOException {
                    Number number2 = number;
                    if (number2 == null) {
                        cVar3.h();
                    } else {
                        cVar3.b(number2.toString());
                    }
                }

                @Override // com.bykv.vk.openvk.preload.a.q
                public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                    if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                        aVar.j();
                        return null;
                    }
                    return Long.valueOf(aVar.l());
                }
            };
        }
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Long.TYPE, Long.class, qVar));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Double.TYPE, Double.class, new q<Number>() { // from class: com.bykv.vk.openvk.preload.a.d.1
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, Number number) throws IOException {
                Number number2 = number;
                if (number2 == null) {
                    cVar3.h();
                } else {
                    d.a(number2.doubleValue());
                    cVar3.a(number2);
                }
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Double.valueOf(aVar.k());
            }
        }));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Float.TYPE, Float.class, new q<Number>() { // from class: com.bykv.vk.openvk.preload.a.d.2
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, Number number) throws IOException {
                Number number2 = number;
                if (number2 == null) {
                    cVar3.h();
                } else {
                    d.a(number2.floatValue());
                    cVar3.a(number2);
                }
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ Number a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Float.valueOf((float) aVar.k());
            }
        }));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.l);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.h);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.i);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(AtomicLong.class, new q<AtomicLong>() { // from class: com.bykv.vk.openvk.preload.a.d.4
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, AtomicLong atomicLong) throws IOException {
                qVar.a(cVar3, Long.valueOf(atomicLong.get()));
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ AtomicLong a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return new AtomicLong(((Number) qVar.a(aVar)).longValue());
            }
        }.a()));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(AtomicLongArray.class, new q<AtomicLongArray>() { // from class: com.bykv.vk.openvk.preload.a.d.5
            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar3, AtomicLongArray atomicLongArray) throws IOException {
                AtomicLongArray atomicLongArray2 = atomicLongArray;
                cVar3.d();
                int length = atomicLongArray2.length();
                for (int i3 = 0; i3 < length; i3++) {
                    qVar.a(cVar3, Long.valueOf(atomicLongArray2.get(i3)));
                }
                cVar3.e();
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final /* synthetic */ AtomicLongArray a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                ArrayList arrayList2 = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList2.add(Long.valueOf(((Number) qVar.a(aVar)).longValue()));
                }
                aVar.b();
                int size = arrayList2.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i3 = 0; i3 < size; i3++) {
                    atomicLongArray.set(i3, ((Long) arrayList2.get(i3)).longValue());
                }
                return atomicLongArray;
            }
        }.a()));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.j);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.m);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.q);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.r);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(BigDecimal.class, com.bykv.vk.openvk.preload.a.b.a.m.n));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(BigInteger.class, com.bykv.vk.openvk.preload.a.b.a.m.o));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.s);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.t);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.v);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.w);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.z);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.u);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.b);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.c.f823a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.y);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.j.f833a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.i.f832a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.x);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.a.f819a);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.f837a);
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.b(bVar));
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.f(bVar));
        com.bykv.vk.openvk.preload.a.b.a.d dVar = new com.bykv.vk.openvk.preload.a.b.a.d(bVar);
        this.e = dVar;
        arrayList.add(dVar);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.C);
        arrayList.add(new com.bykv.vk.openvk.preload.a.b.a.h(bVar, cVar2, cVar, dVar));
        this.f = Collections.unmodifiableList(arrayList);
    }

    static void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final <T> q<T> a(com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        boolean z;
        q<T> qVar = (q) this.c.get(aVar == null ? f880a : aVar);
        if (qVar != null) {
            return qVar;
        }
        Map<com.bykv.vk.openvk.preload.a.c.a<?>, a<?>> map = this.b.get();
        if (map == null) {
            map = new HashMap<>();
            this.b.set(map);
            z = true;
        } else {
            z = false;
        }
        a<?> aVar2 = map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            a<?> aVar3 = new a<>();
            map.put(aVar, aVar3);
            Iterator<r> it = this.f.iterator();
            while (it.hasNext()) {
                q<T> qVarA = it.next().a(this, aVar);
                if (qVarA != null) {
                    aVar3.a((q<?>) qVarA);
                    this.c.put(aVar, qVarA);
                    map.remove(aVar);
                    if (z) {
                        this.b.remove();
                    }
                    return qVarA;
                }
            }
            throw new IllegalArgumentException("GSON (pangle-v3200) cannot handle ".concat(String.valueOf(aVar)));
        } catch (Throwable th) {
            map.remove(aVar);
            if (z) {
                this.b.remove();
            }
            throw th;
        }
    }

    public final <T> q<T> a(r rVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        if (!this.f.contains(rVar)) {
            rVar = this.e;
        }
        boolean z = false;
        for (r rVar2 : this.f) {
            if (z) {
                q<T> qVarA = rVar2.a(this, aVar);
                if (qVarA != null) {
                    return qVarA;
                }
            } else if (rVar2 == rVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(aVar)));
    }

    public final <T> q<T> a(Class<T> cls) {
        return a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a((Class) cls));
    }

    public final String a(Object obj) {
        if (obj == null) {
            j jVar = j.f891a;
            StringWriter stringWriter = new StringWriter();
            try {
                com.bykv.vk.openvk.preload.a.d.c cVarA = a((Writer) stringWriter);
                boolean zA = cVarA.a();
                cVarA.a(true);
                boolean zB = cVarA.b();
                cVarA.b(this.m);
                boolean zC = cVarA.c();
                cVarA.c(false);
                try {
                    try {
                        com.bykv.vk.openvk.preload.falconx.a.a.a(jVar, cVarA);
                        cVarA.a(zA);
                        cVarA.b(zB);
                        cVarA.c(zC);
                        return stringWriter.toString();
                    } catch (IOException e) {
                        throw new i(e);
                    } catch (AssertionError e2) {
                        AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e2.getMessage());
                        assertionError.initCause(e2);
                        throw assertionError;
                    }
                } catch (Throwable th) {
                    cVarA.a(zA);
                    cVarA.b(zB);
                    cVarA.c(zC);
                    throw th;
                }
            } catch (IOException e3) {
                throw new i(e3);
            }
        }
        Class<?> cls = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            com.bykv.vk.openvk.preload.a.d.c cVarA2 = a((Writer) stringWriter2);
            q qVarA = a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a((Type) cls));
            boolean zA2 = cVarA2.a();
            cVarA2.a(true);
            boolean zB2 = cVarA2.b();
            cVarA2.b(this.m);
            boolean zC2 = cVarA2.c();
            cVarA2.c(false);
            try {
                try {
                    try {
                        qVarA.a(cVarA2, obj);
                        cVarA2.a(zA2);
                        cVarA2.b(zB2);
                        cVarA2.c(zC2);
                        return stringWriter2.toString();
                    } catch (IOException e4) {
                        throw new i(e4);
                    }
                } catch (AssertionError e5) {
                    AssertionError assertionError2 = new AssertionError("AssertionError (GSON pangle-v3200): " + e5.getMessage());
                    assertionError2.initCause(e5);
                    throw assertionError2;
                }
            } catch (Throwable th2) {
                cVarA2.a(zA2);
                cVarA2.b(zB2);
                cVarA2.c(zC2);
                throw th2;
            }
        } catch (IOException e6) {
            throw new i(e6);
        }
    }

    private static com.bykv.vk.openvk.preload.a.d.c a(Writer writer) throws IOException {
        com.bykv.vk.openvk.preload.a.d.c cVar = new com.bykv.vk.openvk.preload.a.d.c(writer);
        cVar.c(false);
        return cVar;
    }

    private <T> T a(com.bykv.vk.openvk.preload.a.d.a aVar, Type type) throws i, o {
        boolean zQ = aVar.q();
        boolean z = true;
        aVar.a(true);
        try {
            try {
                try {
                    aVar.f();
                    z = false;
                    T tA = a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(type)).a(aVar);
                    aVar.a(zQ);
                    return tA;
                } catch (EOFException e) {
                    if (!z) {
                        throw new o(e);
                    }
                    aVar.a(zQ);
                    return null;
                } catch (IOException e2) {
                    throw new o(e2);
                }
            } catch (AssertionError e3) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e3.getMessage());
                assertionError.initCause(e3);
                throw assertionError;
            } catch (IllegalStateException e4) {
                throw new o(e4);
            }
        } catch (Throwable th) {
            aVar.a(zQ);
            throw th;
        }
    }

    /* JADX INFO: compiled from: Gson.java */
    static class a<T> extends q<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private q<T> f885a;

        a() {
        }

        public final void a(q<T> qVar) {
            if (this.f885a != null) {
                throw new AssertionError();
            }
            this.f885a = qVar;
        }

        @Override // com.bykv.vk.openvk.preload.a.q
        public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            q<T> qVar = this.f885a;
            if (qVar == null) {
                throw new IllegalStateException();
            }
            return qVar.a(aVar);
        }

        @Override // com.bykv.vk.openvk.preload.a.q
        public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t) throws IOException {
            q<T> qVar = this.f885a;
            if (qVar == null) {
                throw new IllegalStateException();
            }
            qVar.a(cVar, t);
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.f + ",instanceCreators:" + this.d + "}";
    }

    public final <T> T a(Reader reader, Type type) throws i, o {
        com.bykv.vk.openvk.preload.a.d.a aVar = new com.bykv.vk.openvk.preload.a.d.a(reader);
        aVar.a(false);
        T t = (T) a(aVar, type);
        if (t != null) {
            try {
                if (aVar.f() != com.bykv.vk.openvk.preload.a.d.b.END_DOCUMENT) {
                    throw new i("JSON document was not fully consumed.");
                }
            } catch (com.bykv.vk.openvk.preload.a.d.d e) {
                throw new o(e);
            } catch (IOException e2) {
                throw new i(e2);
            }
        }
        return t;
    }
}
