package com.bykv.vk.openvk.preload.b;

import java.util.List;

/* JADX INFO: compiled from: RetryBranchInterceptor.java */
/* JADX INFO: loaded from: classes13.dex */
public abstract class j<IN, OUT> extends l<IN, OUT> {
    private String d;

    protected abstract String a(IN in);

    protected abstract String a(IN in, Throwable th, String str);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bykv.vk.openvk.preload.b.d
    public final Object a(b<OUT> bVar, IN in) throws Throwable {
        new c(bVar);
        this.d = a(in);
        l.a aVar = a().get(this.d);
        while (aVar != null) {
            List<h> list = aVar.f904a;
            try {
                Object objA = c.a(list, bVar.f903a, this).a(in);
                return !a(list) ? objA : bVar.a(objA);
            } catch (i.a e) {
                Throwable cause = e.getCause();
                new c(bVar);
                this.d = a(in, cause, this.d);
                aVar = a().get(this.d);
            } catch (Throwable th) {
                new c(bVar);
                this.d = a(in, th, this.d);
                aVar = a().get(this.d);
            }
        }
        throw new IllegalArgumentException("can not found branch，branch name is：" + this.d);
    }
}
