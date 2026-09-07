package com.apm.insight.runtime;

import com.apm.insight.entity.Header;

/* JADX INFO: compiled from: ConfigPropGetter.java */
/* JADX INFO: loaded from: classes13.dex */
public class e {
    private static final e b = new e() { // from class: com.apm.insight.runtime.e.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Header f285a = null;

        @Override // com.apm.insight.runtime.e
        public final Object b(String str) {
            if (this.f285a == null) {
                this.f285a = Header.b(com.apm.insight.e.g());
            }
            return this.f285a.f().opt(str);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f284a;

    e() {
        this(b);
    }

    private e(e eVar) {
        this.f284a = eVar;
    }

    public Object b(String str) {
        e eVar = this.f284a;
        if (eVar != null) {
            return eVar.b(str);
        }
        return null;
    }

    public Object a(String str) {
        e eVar = this.f284a;
        if (eVar != null) {
            return eVar.a(str);
        }
        return null;
    }
}
