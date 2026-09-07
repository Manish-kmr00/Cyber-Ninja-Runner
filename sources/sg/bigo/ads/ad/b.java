package sg.bigo.ads.ad;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.a.l;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, List<Ad>> f12485a;
    private final List<Map<String, List<Ad>>> b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static b f12488a = new b(0);
    }

    /* JADX INFO: renamed from: sg.bigo.ads.ad.b$b, reason: collision with other inner class name */
    interface InterfaceC0809b {
        boolean a(Ad ad);
    }

    private b() {
        this.f12485a = new ConcurrentHashMap();
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(this.f12485a);
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private int a(String str, Map<String, List<Ad>> map) {
        return a(str, map, new InterfaceC0809b() { // from class: sg.bigo.ads.ad.b.1
            @Override // sg.bigo.ads.ad.b.InterfaceC0809b
            public final boolean a(Ad ad) {
                return ad != null && ad.isExpired();
            }
        });
    }

    private int a(String str, Map<String, List<Ad>> map, InterfaceC0809b interfaceC0809b) {
        List<Ad> list = map.get(str);
        int i = 0;
        if (list != null && !list.isEmpty()) {
            for (Ad ad : list) {
                if (interfaceC0809b.a(ad)) {
                    a(ad);
                    list.remove(ad);
                    i++;
                }
            }
        }
        return i;
    }

    private void a(final Ad ad) {
        if (ad == null) {
            return;
        }
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.b.2
            @Override // java.lang.Runnable
            public final void run() {
                ad.destroy();
            }
        });
    }

    private static String b(Ad ad) {
        return ad == null ? "null" : ad.toString();
    }

    private static String b(l lVar) {
        if (lVar == null) {
            return null;
        }
        String strL = lVar.l();
        if (TextUtils.isEmpty(strL)) {
            return null;
        }
        return strL + "_" + lVar.v() + "_" + lVar.b();
    }

    public final Ad a(l lVar) {
        String strB = b(lVar);
        sg.bigo.ads.common.t.a.a(0, 3, "AdCacheManager", "AdCacheManager:key = ".concat(String.valueOf(strB)));
        Ad ad = null;
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        sg.bigo.ads.common.t.a.a(0, 3, "AdCacheManager", "AdCacheManager:getAd expiredNum is ".concat(String.valueOf(a(strB, this.f12485a))));
        List<Ad> list = this.f12485a.get(strB);
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (i < list.size()) {
                try {
                    Ad ad2 = list.get(i);
                    i++;
                    ad = ad2;
                } catch (Exception e) {
                    sg.bigo.ads.common.t.a.a(0, "AdCacheManager", "AdCacheManager:getAd end error= " + e.getMessage());
                }
            }
            if (ad != null) {
                list.remove(ad);
            }
            sg.bigo.ads.common.t.a.a(0, 3, "AdCacheManager", "AdCacheManager:getAd end cacheNum= " + list.size() + "ad = " + b(ad));
        }
        return ad;
    }

    public final void a(l lVar, Ad ad) {
        if (lVar == null) {
            return;
        }
        String strL = lVar.l();
        String strB = b(lVar);
        if (TextUtils.isEmpty(strB) || i.f13093a == null) {
            return;
        }
        int iH = i.f13093a.q().h(strL);
        Map<String, List<Ad>> map = this.f12485a;
        int iA = a(strB, map);
        List copyOnWriteArrayList = map.get(strB);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.add(ad);
            map.put(strB, (List<Ad>) copyOnWriteArrayList);
        } else {
            int iIndexOf = copyOnWriteArrayList.indexOf(ad);
            if (iIndexOf >= 0) {
                copyOnWriteArrayList.set(iIndexOf, ad);
            } else {
                copyOnWriteArrayList.add(ad);
            }
        }
        sg.bigo.ads.api.core.c[] cVarArrA = sg.bigo.ads.controller.loader.a.a(ad);
        for (int i = 0; cVarArrA != null && i < cVarArrA.length; i++) {
            sg.bigo.ads.api.core.c cVar = cVarArrA[i];
            cVar.T();
            cVar.S();
        }
        Object[] array = copyOnWriteArrayList.toArray();
        if (array != null) {
            List listAsList = Arrays.asList(array);
            Collections.sort(listAsList, Collections.reverseOrder());
            copyOnWriteArrayList.clear();
            copyOnWriteArrayList.addAll(listAsList);
        }
        int size = copyOnWriteArrayList.size();
        if (iH > 0 && size > iH) {
            try {
                Ad ad2 = (Ad) copyOnWriteArrayList.remove(iH);
                sg.bigo.ads.common.t.a.a(0, 3, "AdCacheManager", "AdCacheManager:removeAd due to limit:" + b(ad2));
                a(ad2);
            } catch (Exception e) {
                sg.bigo.ads.common.t.a.a(0, "AdCacheManager", "AdCacheManager:doAdPut, error = " + e.getMessage());
            }
        }
        sg.bigo.ads.common.t.a.a(0, 3, "AdCacheManager", "AdCacheManager:putAdInCache:" + b(ad));
        sg.bigo.ads.common.t.a.a(0, 3, "AdCacheManager", "AdCacheManager:doAdPut, size = " + copyOnWriteArrayList.size() + ", expired num = " + iA);
    }
}
