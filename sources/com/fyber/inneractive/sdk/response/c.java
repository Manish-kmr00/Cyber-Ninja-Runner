package com.fyber.inneractive.sdk.response;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.AbstractC3081k;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends b {
    @Override // com.fyber.inneractive.sdk.response.b
    public final void a(String str, T t) {
        f fVar = (f) this.f2320a;
        if (str == null) {
            str = null;
        } else {
            com.fyber.inneractive.sdk.util.T t2 = com.fyber.inneractive.sdk.util.T.c;
            t2.getClass();
            int iIndexOf = str.indexOf(38);
            if (iIndexOf >= 0) {
                StringWriter stringWriter = new StringWriter((int) ((((double) str.length()) * 0.1d) + ((double) str.length())));
                try {
                    t2.a(stringWriter, str, iIndexOf);
                } catch (IOException unused) {
                }
                str = stringWriter.toString();
            }
        }
        int i = AbstractC3081k.f1710a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.assetResponse");
        if (!TextUtils.isEmpty(property)) {
            String strB = AbstractC3251o.b(property);
            if (!TextUtils.isEmpty(strB)) {
                str = strB;
            }
        }
        fVar.M = str;
    }

    @Override // com.fyber.inneractive.sdk.response.b
    public final e a() {
        f fVar = new f();
        this.f2320a = fVar;
        return fVar;
    }
}
