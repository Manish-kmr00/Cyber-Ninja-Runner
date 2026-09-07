package sg.bigo.ads.ad.interstitial.multi_img;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.p.g;
import sg.bigo.ads.common.p.h;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f12846a;
    public final d b;
    public final boolean c;
    public final c d;
    public final boolean e;
    List<a> f;
    public int g;
    final sg.bigo.ads.ad.b.c h;
    private final HashSet<String> i = new HashSet<>();

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12849a;
        public int b;

        private a(String str) {
            this.f12849a = str;
            this.b = 0;
        }

        /* synthetic */ a(String str, byte b) {
            this(str);
        }
    }

    private b(sg.bigo.ads.ad.b.c cVar, m mVar, d dVar, int i, c cVar2, boolean z, boolean z2, List<a> list) {
        this.h = cVar;
        this.f12846a = mVar;
        this.b = dVar;
        this.d = cVar2;
        this.c = z;
        this.e = z2;
        this.f = list;
        this.g = i;
    }

    public static b a(sg.bigo.ads.ad.b.c cVar, m mVar) {
        if (cVar == null || mVar == null) {
            return null;
        }
        switch (mVar.a("endpage.ad_component_layout")) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return a(cVar, mVar, mVar.a("endpage.multi_img_load"), d.a(mVar.a("endpage.multi_img")), c.a(mVar.a("endpage.multi_render_way")), true, true);
            default:
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000b A[PHI: r3
  0x000b: PHI (r3v12 java.util.ArrayList) = (r3v3 java.util.ArrayList), (r3v3 java.util.ArrayList), (r3v0 java.util.ArrayList) binds: [B:40:0x00ae, B:42:0x00b2, B:4:0x0008] A[DONT_GENERATE, DONT_INLINE]] */
    private static b a(sg.bigo.ads.ad.b.c cVar, m mVar, int i, d dVar, c cVar2, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        byte b = 0;
        if (dVar != d.NONE || z2) {
            sg.bigo.ads.api.core.c.d popPage = cVar.getPopPage();
            if (popPage != null) {
                String[] strArrE = popPage.e();
                if (!k.a(strArrE)) {
                    arrayList2 = new ArrayList();
                    for (String str : strArrE) {
                        arrayList2.add(new a(str, b));
                    }
                }
            }
            if (k.a((Collection) arrayList2) && (z || z2)) {
                arrayList2 = new ArrayList();
                o.a[] aVarArrAw = ((sg.bigo.ads.core.a.a) cVar.f()).aw();
                for (int i2 = 0; !k.a(aVarArrAw) && i2 < aVarArrAw.length; i2++) {
                    o.a aVar = aVarArrAw[i2];
                    if (aVar != null && !q.a((CharSequence) aVar.c())) {
                        arrayList2.add(new a(aVarArrAw[i2].c(), b));
                    }
                }
            }
            if (k.a((Collection) arrayList2) && ((z || z2) && ((sg.bigo.ads.core.a.a) cVar.f()).aQ())) {
                ArrayList arrayList3 = new ArrayList();
                String strAy = ((sg.bigo.ads.core.a.a) cVar.f()).ay();
                if (!q.a((CharSequence) strAy)) {
                    arrayList3.add(new a(strAy, b));
                }
                arrayList2 = arrayList3;
            }
            if (k.a((Collection) arrayList2) && (z || z2)) {
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            z3 = false;
        }
        d dVar2 = (!k.a((Collection) arrayList2) || z3) ? dVar : d.NONE;
        if (dVar == d.NONE && z2) {
            if (k.a((Collection) arrayList2)) {
                z4 = true;
            } else {
                arrayList = new ArrayList(arrayList2.subList(0, 1));
                z4 = z3;
            }
            return new b(cVar, mVar, dVar2, i, cVar2, z, z4, arrayList);
        }
        z4 = z3;
        arrayList = arrayList2;
        return new b(cVar, mVar, dVar2, i, cVar2, z, z4, arrayList);
    }

    public static b b(sg.bigo.ads.ad.b.c cVar, m mVar) {
        d dVar;
        c cVar2;
        int iA;
        if (cVar == null || mVar == null) {
            return null;
        }
        int iA2 = mVar.a("video_play_page.multi_img_load");
        switch (mVar.a("video_play_page.ad_component_layout")) {
            case 13:
            case 18:
                dVar = d.TILE;
                cVar2 = c.FILL_MATCH_SELF;
                iA = 1;
                break;
            case 14:
            case 15:
            case 16:
            case 17:
                d dVarA = d.a(mVar.a("video_play_page.multi_img"));
                c cVarA = c.a(mVar.a("video_play_page.multi_render_way"));
                iA = mVar.a("video_play_page.multi_method");
                dVar = dVarA;
                cVar2 = cVarA;
                break;
            default:
                return null;
        }
        return a(cVar, mVar, iA2, dVar, cVar2, iA == 1, false);
    }

    public static b c(sg.bigo.ads.ad.b.c cVar, m mVar) {
        return a(cVar, mVar, mVar.a("video_play_page.multi_img_load", 1), d.a(mVar.a("video_play_page.multi_img")), c.FILL_MATCH_SELF, true, false);
    }

    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        if (k.a((Collection) this.f)) {
            return arrayList;
        }
        Iterator<a> it = this.f.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f12849a);
        }
        return arrayList;
    }

    public final void a(final int i, final int i2) {
        String str = i + "_" + i2;
        if (this.i.contains(str)) {
            return;
        }
        this.i.add(str);
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.multi_img.b.1
            /* JADX WARN: Type inference failed for: r5v0, types: [sg.bigo.ads.api.core.c] */
            @Override // java.lang.Runnable
            public final void run() {
                int i3;
                int i4;
                int i5;
                String[] strArrE;
                int length = 0;
                if (k.a((Collection) b.this.f)) {
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                } else {
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    for (a aVar : b.this.f) {
                        String str2 = aVar.f12849a;
                        if (!sg.bigo.ads.common.p.e.a(b.this.h.b.e, str2)) {
                            if (!h.a.f13258a.a(str2)) {
                                int i9 = aVar.b;
                                if (i9 != 1) {
                                    if (i9 == 2) {
                                        i8++;
                                    }
                                }
                            }
                            i6++;
                        }
                        i7++;
                    }
                    i3 = i6;
                    i4 = i7;
                    i5 = i8;
                }
                ?? F = b.this.h.f();
                int i10 = i;
                int i11 = i2;
                sg.bigo.ads.api.core.c.d popPage = b.this.h.getPopPage();
                if (popPage != null && (strArrE = popPage.e()) != null) {
                    length = strArrE.length;
                }
                sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) F, i10, i11, length, i3, i4, i5);
            }
        });
    }

    public final void a(String str, int i) {
        if (k.a((Collection) this.f) || q.a((CharSequence) str)) {
            return;
        }
        for (a aVar : this.f) {
            if (str.equalsIgnoreCase(aVar.f12849a)) {
                aVar.b = i;
                return;
            }
        }
    }

    public final void b() {
        if (k.a((Collection) this.f)) {
            return;
        }
        for (final a aVar : this.f) {
            String str = aVar.f12849a;
            if (!sg.bigo.ads.common.p.e.a(this.h.b.e, str)) {
                if (h.a.f13258a.a(str)) {
                    return;
                } else {
                    sg.bigo.ads.common.p.e.a(this.h.b.e, str, ((sg.bigo.ads.core.a.a) this.h.f()).al(), new g() { // from class: sg.bigo.ads.ad.interstitial.multi_img.b.2
                        @Override // sg.bigo.ads.common.p.g
                        public final void a(int i, String str2, String str3) {
                            aVar.b = 2;
                        }

                        @Override // sg.bigo.ads.common.p.g
                        public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                            aVar.b = 1;
                        }
                    });
                }
            }
        }
    }
}
