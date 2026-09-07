package com.five_corp.ad.internal.base_url;

import com.five_corp.ad.internal.cache.x;
import com.five_corp.ad.internal.hub.c;
import com.five_corp.ad.internal.media_config.b;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1318a = "adchk.fivecdm.com";
    public String b = "bc2.fivecdm.com";
    public String c = "er.fivecdm.com";

    public a(com.five_corp.ad.internal.hub.a aVar) {
    }

    @Override // com.five_corp.ad.internal.hub.c
    public final void a(x xVar) {
        com.five_corp.ad.internal.media_config.a aVar = xVar.b;
        if (aVar != null) {
            b bVar = aVar.i;
            String str = bVar.f1424a;
            if (str == null) {
                str = "adchk.fivecdm.com";
            }
            this.f1318a = str;
            String str2 = bVar.b;
            if (str2 == null) {
                str2 = "bc2.fivecdm.com";
            }
            this.b = str2;
            String str3 = bVar.c;
            if (str3 == null) {
                str3 = "er.fivecdm.com";
            }
            this.c = str3;
        }
    }
}
