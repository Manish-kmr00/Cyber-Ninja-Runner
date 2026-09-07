package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.o;
import com.bykv.vk.openvk.preload.a.q;
import com.bykv.vk.openvk.preload.a.r;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
/* JADX INFO: loaded from: classes12.dex */
public final class h implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f829a;
    private final com.bykv.vk.openvk.preload.a.c b;
    private final com.bykv.vk.openvk.preload.a.b.c c;
    private final d d;
    private final com.bykv.vk.openvk.preload.a.b.b.b e = com.bykv.vk.openvk.preload.a.b.b.b.a();

    public h(com.bykv.vk.openvk.preload.a.b.b bVar, com.bykv.vk.openvk.preload.a.c cVar, com.bykv.vk.openvk.preload.a.b.c cVar2, d dVar) {
        this.f829a = bVar;
        this.b = cVar;
        this.c = cVar2;
        this.d = dVar;
    }

    private boolean a(Field field, boolean z) {
        com.bykv.vk.openvk.preload.a.b.c cVar = this.c;
        return (cVar.a(field.getType(), z) || cVar.a(field, z)) ? false : true;
    }

    private List<String> a(Field field) {
        com.bykv.vk.openvk.preload.a.a.b bVar = (com.bykv.vk.openvk.preload.a.a.b) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.b.class);
        if (bVar == null) {
            return Collections.singletonList(this.b.a(field));
        }
        String strA = bVar.a();
        String[] strArrB = bVar.b();
        if (strArrB.length == 0) {
            return Collections.singletonList(strA);
        }
        ArrayList arrayList = new ArrayList(strArrB.length + 1);
        arrayList.add(strA);
        for (String str : strArrB) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final <T> q<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        Class<? super T> clsA = aVar.a();
        if (Object.class.isAssignableFrom(clsA)) {
            return new a(this.f829a.a(aVar), a(dVar, aVar, clsA));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r25v0 */
    private Map<String, b> a(final com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<?> aVar, Class<?> cls) {
        int i;
        boolean z;
        int i2;
        Field[] fieldArr;
        Class<?> cls2;
        Type type;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type typeB = aVar.b();
        com.bykv.vk.openvk.preload.a.c.a<?> aVarA = aVar;
        Class<?> clsA = cls;
        while (clsA != Object.class) {
            Field[] declaredFields = clsA.getDeclaredFields();
            int length = declaredFields.length;
            boolean z2 = false;
            int i3 = 0;
            while (i3 < length) {
                final Field field = declaredFields[i3];
                boolean zA = this.a(field, true);
                boolean zA2 = this.a(field, z2);
                if (zA || zA2) {
                    this.e.a(field);
                    Type typeA = com.bykv.vk.openvk.preload.a.b.a.a(aVarA.b(), clsA, field.getGenericType());
                    List<String> listA = this.a(field);
                    int size = listA.size();
                    ?? r1 = z2;
                    b bVar = null;
                    while (r1 < size) {
                        Type type2 = typeB;
                        String str = listA.get(r1);
                        boolean z3 = r1 != 0 ? z2 : zA;
                        final com.bykv.vk.openvk.preload.a.c.a<?> aVarA2 = com.bykv.vk.openvk.preload.a.c.a.a(typeA);
                        Class<? super Object> clsA2 = aVarA2.a();
                        boolean z4 = (clsA2 instanceof Class) && clsA2.isPrimitive();
                        com.bykv.vk.openvk.preload.a.a.a aVar2 = (com.bykv.vk.openvk.preload.a.a.a) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.a.class);
                        q<?> qVarA = aVar2 != null ? d.a(this.f829a, dVar, aVarA2, aVar2) : null;
                        boolean z5 = qVarA != null;
                        if (qVarA == null) {
                            qVarA = dVar.a((com.bykv.vk.openvk.preload.a.c.a) aVarA2);
                        }
                        final q<?> qVar = qVarA;
                        ?? r25 = r1;
                        int i4 = size;
                        List<String> list = listA;
                        Field field2 = field;
                        int i5 = i3;
                        final boolean z6 = z5;
                        int i6 = length;
                        Field[] fieldArr2 = declaredFields;
                        Class<?> cls3 = clsA;
                        final boolean z7 = z4;
                        b bVar2 = (b) linkedHashMap.put(str, new b(str, z3, zA2) { // from class: com.bykv.vk.openvk.preload.a.b.a.h.1
                            @Override // com.bykv.vk.openvk.preload.a.b.a.h.b
                            final void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IllegalAccessException, IOException {
                                (z6 ? qVar : new l(dVar, qVar, aVarA2.b())).a(cVar, field.get(obj));
                            }

                            @Override // com.bykv.vk.openvk.preload.a.b.a.h.b
                            final void a(com.bykv.vk.openvk.preload.a.d.a aVar3, Object obj) throws IllegalAccessException, IOException {
                                Object objA = qVar.a(aVar3);
                                if (objA == null && z7) {
                                    return;
                                }
                                field.set(obj, objA);
                            }

                            @Override // com.bykv.vk.openvk.preload.a.b.a.h.b
                            public final boolean a(Object obj) throws IllegalAccessException, IOException {
                                return this.b && field.get(obj) != obj;
                            }
                        });
                        if (bVar == null) {
                            bVar = bVar2;
                        }
                        this = this;
                        clsA = cls3;
                        zA = z3;
                        typeB = type2;
                        z2 = false;
                        length = i6;
                        size = i4;
                        listA = list;
                        field = field2;
                        i3 = i5;
                        declaredFields = fieldArr2;
                        r1 = (r25 == true ? 1 : 0) + 1;
                    }
                    i = i3;
                    z = z2;
                    i2 = length;
                    fieldArr = declaredFields;
                    cls2 = clsA;
                    type = typeB;
                    if (bVar != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + bVar.f831a);
                    }
                } else {
                    i = i3;
                    z = z2;
                    i2 = length;
                    fieldArr = declaredFields;
                    cls2 = clsA;
                    type = typeB;
                }
                i3 = i + 1;
                this = this;
                aVarA = aVarA;
                clsA = cls2;
                typeB = type;
                z2 = z;
                length = i2;
                declaredFields = fieldArr;
            }
            Class<?> cls4 = clsA;
            aVarA = com.bykv.vk.openvk.preload.a.c.a.a(com.bykv.vk.openvk.preload.a.b.a.a(aVarA.b(), cls4, cls4.getGenericSuperclass()));
            clsA = aVarA.a();
        }
        return linkedHashMap;
    }

    /* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
    static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f831a;
        final boolean b;
        final boolean c;

        abstract void a(com.bykv.vk.openvk.preload.a.d.a aVar, Object obj) throws IllegalAccessException, IOException;

        abstract void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IllegalAccessException, IOException;

        abstract boolean a(Object obj) throws IllegalAccessException, IOException;

        protected b(String str, boolean z, boolean z2) {
            this.f831a = str;
            this.b = z;
            this.c = z2;
        }
    }

    /* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
    public static final class a<T> extends q<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bykv.vk.openvk.preload.a.b.h<T> f830a;
        private final Map<String, b> b;

        a(com.bykv.vk.openvk.preload.a.b.h<T> hVar, Map<String, b> map) {
            this.f830a = hVar;
            this.b = map;
        }

        @Override // com.bykv.vk.openvk.preload.a.q
        public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            T tA = this.f830a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = this.b.get(aVar.g());
                    if (bVar == null || !bVar.c) {
                        aVar.n();
                    } else {
                        bVar.a(aVar, tA);
                    }
                }
                aVar.d();
                return tA;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new o(e2);
            }
        }

        @Override // com.bykv.vk.openvk.preload.a.q
        public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.h();
                return;
            }
            cVar.f();
            try {
                for (b bVar : this.b.values()) {
                    if (bVar.a(t)) {
                        cVar.a(bVar.f831a);
                        bVar.a(cVar, t);
                    }
                }
                cVar.g();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }
}
