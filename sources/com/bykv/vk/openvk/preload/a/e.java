package com.bykv.vk.openvk.preload.a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GsonBuilder.java */
/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.a.b.c f889a = com.bykv.vk.openvk.preload.a.b.c.f864a;
    private p b = p.f894a;
    private c c = b.f814a;
    private final Map<Type, com.bykv.vk.openvk.preload.geckox.a.a.c<?>> d = new HashMap();
    private final List<r> e = new ArrayList();
    private final List<r> f = new ArrayList();
    private boolean g = false;
    private int h = 2;
    private int i = 2;
    private boolean j = false;
    private boolean k = false;
    private boolean l = true;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;

    public final e a(Type type, Object obj) {
        com.bykv.vk.openvk.preload.falconx.a.a.a(true);
        this.e.add(com.bykv.vk.openvk.preload.a.b.a.m.a(com.bykv.vk.openvk.preload.a.c.a.a(type), (q) obj));
        return this;
    }

    public final d a() {
        ArrayList arrayList = new ArrayList(this.e.size() + this.f.size() + 3);
        arrayList.addAll(this.e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        int i = this.h;
        int i2 = this.i;
        if (i != 2 && i2 != 2) {
            a aVar = new a(Date.class, i, i2);
            a aVar2 = new a(Timestamp.class, i, i2);
            a aVar3 = new a(java.sql.Date.class, i, i2);
            arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Date.class, aVar));
            arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Timestamp.class, aVar2));
            arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(java.sql.Date.class, aVar3));
        }
        return new d(this.f889a, this.c, this.d, this.l, this.b, this.h, this.i, this.e, this.f, arrayList);
    }
}
