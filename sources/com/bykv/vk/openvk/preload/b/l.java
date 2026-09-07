package com.bykv.vk.openvk.preload.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: SubBranchInterceptor.java */
/* JADX INFO: loaded from: classes12.dex */
public abstract class l<IN, OUT> extends d<IN, OUT> {
    private Map<String, a> d;

    l() {
    }

    final Map<String, a> a() {
        return this.d;
    }

    static boolean a(List<h> list) {
        return !list.isEmpty() && list.get(list.size() - 1).f901a == f.class;
    }

    @Override // com.bykv.vk.openvk.preload.b.d
    protected final void a(Object... objArr) {
        Object obj;
        super.a(objArr);
        if (objArr == null || objArr.length != 1 || (obj = objArr[0]) == null) {
            throw new IllegalStateException("args error");
        }
        try {
            this.d = (Map) obj;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX INFO: compiled from: SubBranchInterceptor.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, a> f905a = new HashMap();

        public final a a(String str) {
            if (this.f905a.containsKey(str)) {
                throw new IllegalArgumentException("duplicated branch name");
            }
            a aVar = new a();
            this.f905a.put(str, aVar);
            return aVar;
        }

        public final h a(Class<? extends l> cls) {
            return h.a.a().a(cls).a(this.f905a).a((com.bykv.vk.openvk.preload.b.b.a) null).b();
        }
    }

    /* JADX INFO: compiled from: SubBranchInterceptor.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<h> f904a = new ArrayList();

        public final a a(h hVar) {
            this.f904a.add(hVar);
            return this;
        }

        public final a a(List<h> list) {
            this.f904a.addAll(list);
            return this;
        }
    }
}
