package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.apm.insight.nativecrash.NativeCrashCollector;

/* JADX INFO: compiled from: NativeCrashAssembly.java */
/* JADX INFO: loaded from: classes6.dex */
final class l extends c {
    @Override // com.apm.insight.runtime.a.c
    protected final boolean c() {
        return false;
    }

    l(Context context, b bVar, d dVar) {
        super(CrashType.NATIVE, context, bVar, dVar);
    }

    @Override // com.apm.insight.runtime.a.c
    public final com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar) {
        com.apm.insight.entity.a aVarA = super.a(i, aVar);
        if (i == 0) {
            Header headerA = Header.a(this.b);
            headerA.c();
            aVarA.a(headerA);
            com.apm.insight.a.a(aVarA, headerA, this.f274a);
        } else if (i == 1) {
            Header headerD = aVarA.d();
            headerD.d();
            headerD.e();
        } else if (i == 2) {
            Header.a(aVarA.d());
        }
        return aVarA;
    }

    @Override // com.apm.insight.runtime.a.c
    public final int a() {
        return NativeCrashCollector.a();
    }
}
