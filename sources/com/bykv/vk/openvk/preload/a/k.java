package com.bykv.vk.openvk.preload.a;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: JsonObject.java */
/* JADX INFO: loaded from: classes12.dex */
public final class k extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.g<String, h> f892a = new com.bykv.vk.openvk.preload.a.b.g<>();

    public final void a(String str, h hVar) {
        com.bykv.vk.openvk.preload.a.b.g<String, h> gVar = this.f892a;
        if (hVar == null) {
            hVar = j.f891a;
        }
        gVar.put(str, hVar);
    }

    public final Set<Map.Entry<String, h>> g() {
        return this.f892a.entrySet();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof k) && ((k) obj).f892a.equals(this.f892a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f892a.hashCode();
    }
}
