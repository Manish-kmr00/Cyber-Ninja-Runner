package com.fyber.inneractive.sdk.flow.storepromo.loader;

import com.fyber.inneractive.sdk.util.r;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1815a;
    public final /* synthetic */ f b;

    public e(f fVar, d dVar) {
        this.b = fVar;
        this.f1815a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.fyber.inneractive.sdk.flow.storepromo.model.c cVar;
        f fVar = this.b;
        if (fVar.f == null || (cVar = fVar.b) == null) {
            return;
        }
        d dVar = this.f1815a;
        StringBuilder sb = new StringBuilder("\n<script>\n");
        ArrayList<com.fyber.inneractive.sdk.flow.storepromo.model.a> arrayList = cVar.f1826a;
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        int i = 0;
        int i2 = 0;
        for (com.fyber.inneractive.sdk.flow.storepromo.model.a aVar : arrayList) {
            int i3 = h.f1818a[aVar.f1825a.ordinal()];
            if (i3 == 1) {
                i++;
                String str = i.f1819a;
                String str2 = String.format("app_screen_%d", Integer.valueOf(i));
                sb2.append("var " + str2 + "_el = document.createElement('img');\n" + str2 + "_el.id = '" + str2 + "';\ndocument.getElementById('carousel').appendChild(" + str2 + "_el);\n");
                sb2.append(String.format(i.f1819a, Integer.valueOf(i), aVar.b));
                sb2.append(String.format(i.b, Integer.valueOf(i), Integer.valueOf(i)));
            } else if (i3 == 2) {
                i2++;
                String str3 = i.f1819a;
                String str4 = String.format("app_video_url_%d", Integer.valueOf(i2));
                sb2.append("var " + str4 + "_el = document.createElement('video');\n" + str4 + "_el.id = '" + str4 + "';\ndocument.getElementById('carousel').appendChild(" + str4 + "_el);\n");
                sb2.append(String.format(i.c, Integer.valueOf(i2), aVar.b));
                sb2.append(String.format(i.d, Integer.valueOf(i2), Integer.valueOf(i2)));
            } else if (i3 == 3) {
                sb2.append(String.format(i.e, aVar.b));
                sb2.append(i.f);
            } else if (i3 == 4) {
                sb2.append(String.format(i.q, aVar.b));
                sb2.append(i.r);
            }
        }
        StringBuilder sbAppend = sb.append(sb2.toString()).append(String.format(i.g, cVar.b.replace("`", "\\`")) + i.h + String.format(i.i, cVar.f.replace("`", "\\`")) + i.j + String.format(i.k, cVar.g.b.replace("`", "\\`")) + i.l + String.format(i.o, cVar.g.f1827a.replace("`", "\\`")) + i.p + String.format(i.m, cVar.g.c.replace("`", "\\`")) + i.n);
        StringBuilder sb3 = new StringBuilder();
        boolean z2 = Boolean.parseBoolean(cVar.d);
        boolean z3 = Boolean.parseBoolean(cVar.e);
        sb3.append(i.a(z2, "in_app_purchases"));
        sb3.append(i.a(z3, "app_contains_ads"));
        if (z3 && z2) {
            z = true;
        }
        sb3.append(i.a(z, "app_subtitle_separator"));
        String str5 = cVar.c + sbAppend.append(sb3.toString()).append("</script>").toString();
        dVar.getClass();
        r.b.post(new c(dVar, str5));
    }
}
