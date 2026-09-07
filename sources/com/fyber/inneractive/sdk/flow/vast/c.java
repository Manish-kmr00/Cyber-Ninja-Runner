package com.fyber.inneractive.sdk.flow.vast;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.model.vast.A;
import com.fyber.inneractive.sdk.model.vast.k;
import com.fyber.inneractive.sdk.model.vast.l;
import com.fyber.inneractive.sdk.model.vast.m;
import com.fyber.inneractive.sdk.model.vast.o;
import com.fyber.inneractive.sdk.model.vast.q;
import com.fyber.inneractive.sdk.model.vast.r;
import com.fyber.inneractive.sdk.model.vast.s;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.model.vast.v;
import com.fyber.inneractive.sdk.model.vast.w;
import com.fyber.inneractive.sdk.model.vast.x;
import com.fyber.inneractive.sdk.player.n;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.H;
import com.fyber.inneractive.sdk.util.IAlog;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1836a = -1;
    public int b = -1;
    public int c = -1;
    public boolean d = false;
    public boolean e = false;
    public final LinkedHashMap f = new LinkedHashMap();
    public final ArrayList g = new ArrayList();
    public final ArrayList h = new ArrayList();
    public final ArrayList i = new ArrayList();
    public final ArrayList j = new ArrayList();

    public final void a(com.fyber.inneractive.sdk.model.vast.b bVar, com.fyber.inneractive.sdk.model.vast.h hVar, int i) throws b {
        List list;
        ArrayList arrayList = hVar.h;
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!H.e((String) it.next())) {
                    throw new b("Found non-secure click tracking url for companion: " + hVar, 0);
                }
            }
            if (i > 0) {
                this.h.add(hVar);
            }
        }
        String str = hVar.g;
        if (!H.e(str)) {
            throw new b("Found non-secure click through url: " + str, 0);
        }
        if (!hVar.a()) {
            if (this.i.contains(hVar)) {
                return;
            }
            this.i.add(hVar);
            return;
        }
        Integer num = hVar.f1879a;
        Integer num2 = hVar.b;
        if (num == null || num2 == null || num.intValue() < 100 || num2.intValue() < 100) {
            throw new b("Incompatible size: " + num + StringUtils.COMMA + num2, 16);
        }
        ArrayList<w> arrayList2 = hVar.j;
        for (w wVar : arrayList2) {
            if (!H.e(wVar.b)) {
                throw new b("Found non-secure tracking event: " + wVar, 0);
            }
        }
        String str2 = hVar.c;
        l lVar = hVar.d;
        if (lVar != null) {
            k kVarA = k.a(lVar.f1881a);
            if (kVarA == null) {
                throw new b("Found invalid creative type:" + lVar.f1881a, 0);
            }
            list = arrayList2;
            a(bVar, com.fyber.inneractive.sdk.model.vast.i.Static, i, num.intValue(), num2.intValue(), str2, str, arrayList, list, lVar.b, kVarA);
        } else {
            list = arrayList2;
        }
        String str3 = hVar.e;
        if (!TextUtils.isEmpty(str3)) {
            if (!H.e(str3)) {
                throw new b("Found non-secure iframe url:" + str3, 0);
            }
            a(bVar, com.fyber.inneractive.sdk.model.vast.i.Iframe, i, num.intValue(), num2.intValue(), str2, str, arrayList, list, str3, null);
        }
        String str4 = hVar.f;
        if (!TextUtils.isEmpty(str4)) {
            a(bVar, com.fyber.inneractive.sdk.model.vast.i.Html, i, num.intValue(), num2.intValue(), str2, str, arrayList, list, str4, null);
        }
        bVar.g.size();
    }

    public final com.fyber.inneractive.sdk.model.vast.b a(com.fyber.inneractive.sdk.model.vast.f fVar, List list, String str) {
        List list2;
        ArrayList arrayList;
        int iF = AbstractC3251o.f();
        int iE = AbstractC3251o.e();
        IAlog.a("%sprocess started", "VastProcessor: ");
        if (fVar != null && fVar.c != null) {
            com.fyber.inneractive.sdk.model.vast.b bVar = new com.fyber.inneractive.sdk.model.vast.b(new g(this.c, iF, iE), new d(iF, iE));
            bVar.f1874a = str;
            ArrayList arrayList2 = fVar.c.c;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                if (list == null) {
                    list2 = list;
                    if (fVar.b != null) {
                        arrayList = new ArrayList();
                        arrayList.add(fVar);
                    }
                }
                if (list2 != null) {
                    list2 = arrayList;
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        A a2 = ((com.fyber.inneractive.sdk.model.vast.f) it.next()).b;
                        if (a2 != null) {
                            a(bVar, a2);
                        }
                    }
                }
                list2 = arrayList;
                a(bVar, fVar.c);
                if (bVar.d.size() == 0) {
                    if (this.f.isEmpty()) {
                        throw new h("ErrorNoMediaFiles", "No media files exist after merge");
                    }
                    throw new h("ErrorNoCompatibleMediaFile", "No compatible media files after filtering");
                }
                ArrayList<com.fyber.inneractive.sdk.model.vast.c> arrayList3 = new ArrayList(bVar.g);
                Collections.sort(arrayList3, bVar.h);
                if (!arrayList3.isEmpty()) {
                    for (com.fyber.inneractive.sdk.model.vast.h hVar : this.i) {
                        if (!hVar.a()) {
                            for (com.fyber.inneractive.sdk.model.vast.c cVar : arrayList3) {
                                ArrayList arrayList4 = hVar.h;
                                if (arrayList4 != null) {
                                    Iterator it2 = arrayList4.iterator();
                                    while (it2.hasNext()) {
                                        cVar.a(x.EVENT_CLICK, (String) it2.next());
                                    }
                                }
                                String str2 = hVar.g;
                                if (TextUtils.isEmpty(cVar.g)) {
                                    cVar.g = str2;
                                }
                                ArrayList<w> arrayList5 = hVar.j;
                                if (arrayList5 != null) {
                                    for (w wVar : arrayList5) {
                                        x xVarA = x.a(wVar.f1889a);
                                        String str3 = wVar.b;
                                        if (xVarA != null && str3 != null) {
                                            cVar.a(xVarA, str3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                int i = 0;
                if (IAlog.f2345a == 2) {
                    IAlog.e("%sLogging merged model media files: ", "VastProcessor: ");
                    Iterator it3 = new ArrayList(bVar.d).iterator();
                    int i2 = 0;
                    while (it3.hasNext()) {
                        IAlog.e("%s(%d) %s", "VastProcessor: ", Integer.valueOf(i2), (r) it3.next());
                        i2++;
                    }
                }
                if (IAlog.f2345a == 2) {
                    IAlog.e("%sLogging merged model companion ads: ", "VastProcessor: ");
                    ArrayList arrayList6 = new ArrayList(bVar.g);
                    Collections.sort(arrayList6, bVar.h);
                    if (arrayList6.size() > 0) {
                        Iterator it4 = arrayList6.iterator();
                        while (it4.hasNext()) {
                            IAlog.e("%s(%d) %s", "VastProcessor: ", Integer.valueOf(i), ((com.fyber.inneractive.sdk.model.vast.c) it4.next()).a());
                            i++;
                        }
                    } else {
                        IAlog.e("%sNo companion ads found!", "VastProcessor: ");
                    }
                }
                return bVar;
            }
            list2 = list;
            throw new h("ErrorNoMediaFiles", "Empty inline with no creatives");
        }
        IAlog.a("%sno inline found", "VastProcessor: ");
        throw new h("ErrorNoMediaFiles", "Empty inline ad found");
    }

    /* JADX WARN: Code duplicated, block: B:67:0x0156  */
    /* JADX WARN: Code duplicated, block: B:69:0x0160  */
    /* JADX WARN: Code duplicated, block: B:74:0x017a  */
    /* JADX WARN: Code duplicated, block: B:76:0x017e  */
    /* JADX WARN: Code duplicated, block: B:81:0x0192  */
    /* JADX WARN: Code duplicated, block: B:83:0x019a  */
    /* JADX WARN: Code duplicated, block: B:84:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:86:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:87:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:88:0x01b4  */
    public final void a(com.fyber.inneractive.sdk.model.vast.b bVar, com.fyber.inneractive.sdk.model.vast.g gVar) {
        String[] strArrSplit;
        f fVar;
        String str;
        Integer num;
        HashMap map;
        List list;
        IAlog.a("%sprocessing ad element: %s", "VastProcessor: ", gVar);
        ArrayList<String> arrayList = gVar.b;
        if (arrayList != null) {
            for (String str2 : arrayList) {
                IAlog.a("%sadding impression url: %s", "VastProcessor: ", str2);
                x xVar = x.EVENT_IMPRESSION;
                if (H.e(str2)) {
                    bVar.a(xVar, str2);
                } else {
                    throw new h("VastErrorUnsecure", "found unsecure tracking event: " + xVar.a());
                }
            }
        }
        String str3 = gVar.f1878a;
        if (!TextUtils.isEmpty(str3)) {
            IAlog.a("%sadding error url: %s", "VastProcessor: ", str3);
            bVar.a(x.EVENT_ERROR, str3);
        }
        if (IAConfigManager.O.K != null) {
            for (com.fyber.inneractive.sdk.measurement.i iVar : gVar.d) {
                if (iVar.b()) {
                    bVar.e.add(iVar);
                } else {
                    x xVar2 = x.EVENT_VERIFICATION_NOT_EXECUTED;
                    if (((xVar2 == null || (map = iVar.c) == null || (list = (List) map.get(xVar2)) == null) ? 0 : list.size()) > 0) {
                        n.a(new com.fyber.inneractive.sdk.measurement.h(iVar.a(xVar2), com.fyber.inneractive.sdk.measurement.j.VERIFICATION_NOT_SUPPORTED), xVar2);
                    }
                    this.j.add(iVar);
                }
            }
        }
        o oVar = gVar.e;
        if (oVar != null) {
            bVar.f = oVar;
        }
        v vVar = gVar.g;
        if (vVar != null) {
            bVar.p = vVar;
        }
        for (m mVar : gVar.c) {
            q qVar = mVar.f1882a;
            if (qVar != null) {
                ArrayList<r> arrayList2 = qVar.f1885a;
                if (arrayList2 != null) {
                    bVar.j = arrayList2.size();
                    for (r rVar : arrayList2) {
                        String str4 = rVar.f1886a;
                        s sVar = s.progressive;
                        if (!str4.equals(sVar.a())) {
                            fVar = new f(e.UNSUPPORTED_DELIVERY, sVar.a());
                        } else if (this.b > -1 && (num = rVar.e) != null && num.intValue() != 0) {
                            int iIntValue = rVar.e.intValue();
                            int i = this.f1836a;
                            if (iIntValue < i) {
                                fVar = new f(e.BITRATE_NOT_IN_RANGE, Integer.valueOf(i));
                            } else {
                                int iIntValue2 = rVar.e.intValue();
                                int i2 = this.b;
                                if (iIntValue2 > i2) {
                                    fVar = new f(e.BITRATE_NOT_IN_RANGE, Integer.valueOf(i2));
                                } else if (t.a(rVar.d) != t.UNKNOWN) {
                                    if (!this.d) {
                                        str = rVar.f;
                                        if (str == null) {
                                            if (TextUtils.isEmpty(rVar.g)) {
                                                fVar = new f(e.NO_CONTENT);
                                            } else if (H.e(rVar.g)) {
                                                fVar = null;
                                            } else {
                                                fVar = new f(e.UNSECURED_VIDEO_URL);
                                            }
                                        } else if (TextUtils.isEmpty(rVar.g)) {
                                            fVar = new f(e.NO_CONTENT);
                                        } else if (H.e(rVar.g)) {
                                            fVar = new f(e.UNSECURED_VIDEO_URL);
                                        } else {
                                            fVar = null;
                                        }
                                    } else {
                                        str = rVar.f;
                                        if (str == null) {
                                            if (TextUtils.isEmpty(rVar.g)) {
                                                fVar = new f(e.NO_CONTENT);
                                            } else if (H.e(rVar.g)) {
                                                fVar = new f(e.UNSECURED_VIDEO_URL);
                                            } else {
                                                fVar = null;
                                            }
                                        } else if (TextUtils.isEmpty(rVar.g)) {
                                            fVar = new f(e.NO_CONTENT);
                                        } else if (H.e(rVar.g)) {
                                            fVar = new f(e.UNSECURED_VIDEO_URL);
                                        } else {
                                            fVar = null;
                                        }
                                    }
                                } else {
                                    fVar = new f(e.UNSUPPORTED_MIME_TYPE);
                                }
                            }
                        } else if (t.a(rVar.d) != t.UNKNOWN) {
                            if (!this.d && rVar.b.intValue() >= rVar.c.intValue()) {
                                fVar = new f(e.VERTICAL_VIDEO_EXPECTED);
                            } else {
                                str = rVar.f;
                                if (str == null && this.e && str.equalsIgnoreCase("VPAID")) {
                                    fVar = new f(e.FILTERED_BY_APP_OR_UNIT);
                                } else if (TextUtils.isEmpty(rVar.g)) {
                                    fVar = new f(e.NO_CONTENT);
                                } else if (H.e(rVar.g)) {
                                    fVar = new f(e.UNSECURED_VIDEO_URL);
                                } else {
                                    fVar = null;
                                }
                            }
                        } else {
                            fVar = new f(e.UNSUPPORTED_MIME_TYPE);
                        }
                        if (fVar != null) {
                            IAlog.a("%smedia file filtered!: %s", "VastProcessor: ", rVar);
                            IAlog.a("%s-- %s", "VastProcessor: ", rVar);
                            IAlog.a("%s-- %s", "VastProcessor: ", fVar);
                            this.f.put(rVar, fVar);
                        } else {
                            IAlog.a("%sadding media file: %s", "VastProcessor: ", rVar);
                            bVar.d.add(rVar);
                            bVar.k.add(rVar);
                            bVar.i++;
                        }
                    }
                }
                ArrayList<String> arrayList3 = qVar.d;
                if (arrayList3 != null) {
                    for (String str5 : arrayList3) {
                        x xVar3 = x.EVENT_CLICK;
                        if (H.e(str5)) {
                            bVar.a(xVar3, str5);
                        } else {
                            throw new h("VastErrorUnsecure", "found unsecure tracking event: " + xVar3.a());
                        }
                    }
                }
                ArrayList<w> arrayList4 = qVar.b;
                if (arrayList4 != null) {
                    for (w wVar : arrayList4) {
                        x xVarA = x.a(wVar.f1889a);
                        if (xVarA != x.UNKNOWN) {
                            bVar.a(xVarA, wVar.b);
                        }
                        if (xVarA == x.EVENT_PROGRESS) {
                            String str6 = wVar.b;
                            String str7 = wVar.c;
                            com.fyber.inneractive.sdk.model.vast.e eVar = new com.fyber.inneractive.sdk.model.vast.e(str6, str7);
                            if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7) && eVar.d != 0) {
                                bVar.m.add(eVar);
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(qVar.c)) {
                    bVar.b = qVar.c;
                }
                String str8 = qVar.e;
                if (!TextUtils.isEmpty(str8) && (strArrSplit = str8.split(":")) != null && strArrSplit.length <= 3) {
                    if (strArrSplit.length == 1) {
                        try {
                            Integer.parseInt(str8);
                        } catch (NumberFormatException unused) {
                        }
                    } else if (strArrSplit.length == 2) {
                        Integer.parseInt(strArrSplit[1]);
                        Integer.parseInt(strArrSplit[0]);
                    } else {
                        Integer.parseInt(strArrSplit[2]);
                        Integer.parseInt(strArrSplit[1]);
                        Integer.parseInt(strArrSplit[0]);
                    }
                }
            }
            com.fyber.inneractive.sdk.model.vast.j jVar = mVar.b;
            ArrayList<com.fyber.inneractive.sdk.model.vast.h> arrayList5 = jVar == null ? null : jVar.f1880a;
            if (arrayList5 != null) {
                for (com.fyber.inneractive.sdk.model.vast.h hVar : arrayList5) {
                    try {
                        a(bVar, hVar, gVar.f);
                    } catch (b e) {
                        IAlog.a("Failed processing companion ad: %s error = %s", hVar, e.getMessage());
                        hVar.i = e;
                        this.g.add(hVar);
                    }
                }
            }
        }
        ArrayList arrayList6 = gVar.h;
        String str9 = !arrayList6.isEmpty() ? ((com.fyber.inneractive.sdk.model.vast.n) arrayList6.get(0)).f1883a : null;
        if (TextUtils.isEmpty(str9)) {
            return;
        }
        bVar.n = str9;
    }

    public final void a(com.fyber.inneractive.sdk.model.vast.b bVar, com.fyber.inneractive.sdk.model.vast.i iVar, int i, int i2, int i3, String str, String str2, List list, List list2, String str3, k kVar) {
        com.fyber.inneractive.sdk.model.vast.h hVar;
        Integer num;
        Integer num2;
        com.fyber.inneractive.sdk.model.vast.c cVar = new com.fyber.inneractive.sdk.model.vast.c(iVar, i2, i3, str, i);
        cVar.g = str2;
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                cVar.a(x.a(wVar.f1889a), wVar.b);
            }
        }
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                cVar.a(x.EVENT_CLICK, (String) it2.next());
            }
        }
        if (!this.h.isEmpty()) {
            if (cVar.h > 0) {
                ArrayList arrayList = this.h;
                hVar = (com.fyber.inneractive.sdk.model.vast.h) arrayList.remove(arrayList.size() - 1);
            } else {
                hVar = null;
            }
            String str4 = cVar.e;
            for (com.fyber.inneractive.sdk.model.vast.h hVar2 : this.h) {
                String str5 = hVar2.c;
                if ((str4 != null && str4.equals(str5)) || ((str5 == null && (num = hVar2.f1879a) != null && cVar.c == num.intValue() && (num2 = hVar2.b) != null && cVar.d == num2.intValue()) || !hVar2.a())) {
                    ArrayList<String> arrayList2 = hVar2.h;
                    if (arrayList2.size() > 0) {
                        for (String str6 : arrayList2) {
                            if (H.e(str6)) {
                                cVar.a(x.EVENT_CLICK, str6);
                            }
                        }
                    }
                }
            }
            if (hVar != null) {
                this.h.add(hVar);
            }
        }
        cVar.f = str3;
        cVar.b = kVar;
        bVar.g.add(cVar);
        bVar.l.add(cVar);
    }
}
