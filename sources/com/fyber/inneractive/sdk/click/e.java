package com.fyber.inneractive.sdk.click;

import android.net.Uri;
import android.text.TextUtils;
import com.amazon.aps.ads.util.adview.ApsAdWebViewSupportClient;
import com.fyber.inneractive.sdk.config.G;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.E;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f1656a;
    public final /* synthetic */ Uri b;
    public final /* synthetic */ g c;

    public e(g gVar, List list, Uri uri) {
        this.c = gVar;
        this.f1656a = list;
        this.b = uri;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        c cVar = (c) obj;
        if (this.c.f) {
            return;
        }
        if (exc != null || cVar == null) {
            String string = this.b.toString();
            IAConfigManager iAConfigManager = IAConfigManager.O;
            com.fyber.inneractive.sdk.util.r.b.post(new G(string, null));
            Uri uri = this.b;
            this.c.getClass();
            b bVarA = r.a(uri.toString(), "IgniteGooglePlay", "failed getting redirects");
            List list = this.f1656a;
            if (list != null) {
                list.add(new j(this.b.toString(), false, q.INTERNAL_REDIRECT, "failed getting redirects. ignite click handler"));
                List list2 = this.f1656a;
                bVarA.f.clear();
                bVarA.f.addAll(list2);
            }
            g gVar = this.c;
            f fVar = gVar.c;
            if (fVar != null) {
                fVar.a(bVarA, gVar.d, gVar.e);
                return;
            }
            return;
        }
        if (cVar.f1654a.size() > 0) {
            ArrayList arrayList = cVar.f1654a;
            String str = (String) arrayList.get(arrayList.size() - 1);
            if (this.f1656a != null) {
                for (String str2 : cVar.f1654a) {
                    if (!TextUtils.equals(str2, str)) {
                        this.f1656a.add(new j(str2, true, q.INTERNAL_REDIRECT, null));
                    }
                }
                List list3 = this.f1656a;
                q qVar = q.OPEN_INTERNAL_STORE;
                list3.add(new j(str, true, qVar, null));
                this.c.getClass();
                b bVar = new b(str, qVar, "IgniteGooglePlay", null);
                List list4 = this.f1656a;
                bVar.f.clear();
                bVar.f.addAll(list4);
                g gVar2 = this.c;
                f fVar2 = gVar2.c;
                if (fVar2 != null) {
                    fVar2.a(bVar, gVar2.d, gVar2.e);
                }
            }
            if (str.startsWith(ApsAdWebViewSupportClient.MARKET_SCHEME)) {
                String strReplace = str.replace("market://details?id=", "https://play.google.com/store/apps/details?id=");
                IAConfigManager iAConfigManager2 = IAConfigManager.O;
                com.fyber.inneractive.sdk.util.r.b.post(new G(strReplace, null));
            } else {
                String str3 = cVar.b;
                IAConfigManager iAConfigManager3 = IAConfigManager.O;
                com.fyber.inneractive.sdk.util.r.b.post(new G(str, str3));
            }
        }
    }
}
