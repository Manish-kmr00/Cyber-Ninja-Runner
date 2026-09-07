package com.five_corp.ad.internal.http;

import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import com.five_corp.ad.internal.util.f;
import com.five_corp.ad.internal.util.g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.http.connection.b f1396a;

    public d(com.five_corp.ad.internal.http.connection.b bVar) {
        this.f1396a = bVar;
    }

    public final f a(String str, String str2, String str3, String str4) {
        f fVar;
        String headerField;
        f fVar2;
        if (str3 != null) {
            " with body ".concat(str3);
        }
        f fVarA = this.f1396a.a(str, str2, str3, null, "gzip, deflate", str4, 10000, 10000);
        if (!fVarA.f1560a) {
            return new f(false, fVarA.b, null);
        }
        com.five_corp.ad.internal.http.connection.a aVar = (com.five_corp.ad.internal.http.connection.a) fVarA.c;
        g gVarA = aVar.a();
        if (!gVarA.f1560a) {
            return new f(false, gVarA.b, null);
        }
        f fVarB = aVar.b();
        if (fVarB.f1560a) {
            int iIntValue = ((Integer) fVarB.c).intValue();
            if (200 <= iIntValue && iIntValue < 300) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[16384];
                while (true) {
                    f fVarA2 = aVar.a(bArr);
                    if (!fVarA2.f1560a) {
                        fVar = new f(false, fVarA2.b, null);
                        break;
                    }
                    int iIntValue2 = ((Integer) fVarA2.c).intValue();
                    if (iIntValue2 > 0) {
                        byteArrayOutputStream.write(bArr, 0, iIntValue2);
                    } else {
                        try {
                            byteArrayOutputStream.flush();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            String contentType = aVar.f1395a.getContentType();
                            if (contentType != null && (contentType.contains("text/") || contentType.contains("javascript") || contentType.contains("ecmascript") || contentType.contains("application/json"))) {
                                fVar = new f(true, null, new c(new String(byteArray, StandardCharsets.UTF_8), iIntValue));
                                break;
                            }
                            fVar2 = new f(true, null, new c(iIntValue, byteArray));
                            fVar = fVar2;
                            break;
                        } catch (IOException e) {
                            fVar2 = new f(false, new o(p.s5, null, e, null), null);
                        }
                    }
                }
            } else if (300 <= iIntValue && iIntValue < 400 && (headerField = aVar.f1395a.getHeaderField("Location")) != null) {
                try {
                    fVar = a(new URL(new URL(str), headerField).toString(), "GET", null, null);
                } catch (MalformedURLException e2) {
                    fVar2 = new f(false, new o(p.t5, null, e2, null), null);
                    fVar = fVar2;
                    break;
                }
            } else {
                fVar = new f(true, null, new c(iIntValue));
            }
        } else {
            o oVar = fVarB.b;
            int i = oVar.f1517a.f1518a;
            fVar = new f(false, oVar, null);
        }
        InputStream inputStream = aVar.b;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
            aVar.b = null;
        }
        InputStream errorStream = aVar.f1395a.getErrorStream();
        if (errorStream != null) {
            try {
                errorStream.close();
            } catch (Exception unused2) {
            }
        }
        aVar.f1395a = null;
        return fVar;
    }
}
