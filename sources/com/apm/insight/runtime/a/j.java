package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;

/* JADX INFO: compiled from: JavaCrashAssembly.java */
/* JADX INFO: loaded from: classes6.dex */
final class j extends c {
    j(Context context, b bVar, d dVar) {
        super(CrashType.JAVA, context, bVar, dVar);
    }

    @Override // com.apm.insight.runtime.a.c
    public final com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar) {
        com.apm.insight.entity.a aVarA = super.a(i, aVar);
        if (i == 0) {
            aVarA.a("app_count", (Object) 1);
            aVarA.a("magic_tag", "ss_app_log");
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
        } else if (i == 5) {
            Header.b(aVarA.d());
        }
        return aVarA;
    }
}
