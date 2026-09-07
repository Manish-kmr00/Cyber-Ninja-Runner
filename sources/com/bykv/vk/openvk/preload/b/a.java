package com.bykv.vk.openvk.preload.b;

import java.util.List;

/* JADX INFO: compiled from: BranchInterceptor.java */
/* JADX INFO: loaded from: classes13.dex */
public abstract class a<IN, OUT> extends l<IN, OUT> {
    protected abstract String a(IN in);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bykv.vk.openvk.preload.b.d
    public final Object a(b<OUT> bVar, IN in) throws Exception {
        new c(bVar);
        String strA = a(in);
        l.a aVar = a().get(strA);
        if (aVar == null) {
            throw new IllegalArgumentException("can not found branch, branch name is：".concat(String.valueOf(strA)));
        }
        List<h> list = aVar.f904a;
        Object objA = c.a(list, ((i) bVar).f903a, this).a(in);
        return !a(list) ? objA : bVar.a(objA);
    }
}
