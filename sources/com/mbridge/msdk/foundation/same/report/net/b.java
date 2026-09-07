package com.mbridge.msdk.foundation.same.report.net;

import com.mbridge.msdk.foundation.same.net.c;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.tools.o0;

/* JADX INFO: compiled from: ReportResponseHandler.java */
/* JADX INFO: loaded from: classes10.dex */
public abstract class b extends c<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5026a = "b";

    public abstract void a(String str);

    public abstract void b(String str);

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.exception.a aVar) {
        o0.b(f5026a, "errorCode = " + aVar.f4982a);
        a(com.mbridge.msdk.foundation.same.net.utils.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(e<String> eVar) {
        if (eVar != null) {
            b(eVar.c);
        }
    }
}
