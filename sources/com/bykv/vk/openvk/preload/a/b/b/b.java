package com.bykv.vk.openvk.preload.a.b.b;

import com.bykv.vk.openvk.preload.a.b.d;
import java.lang.reflect.AccessibleObject;

/* JADX INFO: compiled from: ReflectionAccessor.java */
/* JADX INFO: loaded from: classes11.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f862a;

    public abstract void a(AccessibleObject accessibleObject);

    static {
        f862a = d.a() < 9 ? new a() : new c();
    }

    public static b a() {
        return f862a;
    }
}
