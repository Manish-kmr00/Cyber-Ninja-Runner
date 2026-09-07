package com.five_corp.ad.internal.http.auxcache;

import com.five_corp.ad.internal.ad.s;
import com.five_corp.ad.internal.o;
import com.json.b9;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f1386a;
    public final /* synthetic */ o b;
    public final /* synthetic */ i c;

    public g(i iVar, j jVar, o oVar) {
        this.c = iVar;
        this.f1386a = jVar;
        this.b = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar;
        for (k kVar : this.f1386a.c) {
            s sVar = this.f1386a.f1389a;
            o oVar = this.b;
            kVar.g.remove(sVar);
            kVar.f.add(sVar);
            if (!kVar.j) {
                if (kVar.h == null) {
                    kVar.h = new HashMap();
                }
                if (!kVar.h.containsKey(sVar)) {
                    kVar.h.put(sVar, new ArrayList());
                }
                List list = (List) kVar.h.get(sVar);
                list.add("[Download " + sVar.f1310a + " failed with DetailedError: " + oVar.toString() + b9.i.e);
                if (list.size() >= 10) {
                    Locale locale = Locale.US;
                    int i = kVar.i;
                    String str = kVar.b;
                    StringBuilder sb = new StringBuilder(b9.i.d);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        sb.append((String) it.next());
                        sb.append(StringUtils.COMMA);
                    }
                    sb.append(b9.i.e);
                    kVar.c.a("auxiliary resource cache download error is occurred " + i + " times for ad ots: " + str + ". errors: " + sb.toString(), 4);
                    kVar.j = true;
                    kVar.h = null;
                }
            }
            i iVar = this.c;
            int i2 = kVar.f1390a.c;
            iVar.getClass();
            int iA = com.five_corp.ad.e.a(i2);
            if (iA == 0) {
                lVar = iVar.i;
            } else if (iA == 1) {
                lVar = iVar.j;
            } else {
                if (iA != 2) {
                    throw new RuntimeException("Unknown DownloadRequesterPriority: ".concat(com.five_corp.ad.internal.http.b.b(i2)));
                }
                lVar = iVar.k;
            }
            lVar.c.add(kVar);
        }
        this.c.a(this.f1386a);
    }
}
