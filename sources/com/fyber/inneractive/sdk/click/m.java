package com.fyber.inneractive.sdk.click;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.network.E;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1662a;
    public final /* synthetic */ String b;
    public final /* synthetic */ r c;

    public m(r rVar, String str, String str2) {
        this.c = rVar;
        this.f1662a = str;
        this.b = str2;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        c cVar = (c) obj;
        if (this.c.e) {
            return;
        }
        if (exc != null) {
            r.a(this.c, null, this.f1662a, this.b, exc);
            return;
        }
        if (cVar != null) {
            String str = this.f1662a;
            if (cVar.f1654a.size() > 1) {
                ArrayList arrayList = cVar.f1654a;
                str = (String) arrayList.get(arrayList.size() - 1);
            }
            b bVarA = this.c.a(str);
            if ((bVarA == null || bVarA.f1653a == q.FAILED) && !TextUtils.isEmpty(cVar.b)) {
                r rVar = this.c;
                rVar.getClass();
                for (String str2 : cVar.f1654a) {
                    if (!TextUtils.equals(str2, str)) {
                        rVar.f.add(new j(str2, true, q.INTERNAL_REDIRECT, null));
                    }
                }
                r.a(this.c, cVar.b, str, this.b, null);
                return;
            }
            r rVar2 = this.c;
            rVar2.getClass();
            for (String str3 : cVar.f1654a) {
                if (!TextUtils.equals(str3, str)) {
                    rVar2.f.add(new j(str3, false, q.INTERNAL_REDIRECT, null));
                }
            }
            if (this.c.f.size() == 0) {
                this.c.f.add(new j(str, false, q.INTERNAL_REDIRECT, null));
            }
            this.c.a(r.a(str, "followRedirects", "Invalid response"));
        }
    }
}
