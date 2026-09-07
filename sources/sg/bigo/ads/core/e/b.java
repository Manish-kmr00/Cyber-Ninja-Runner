package sg.bigo.ads.core.e;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.facebook.login.LoginLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.common.u.a.e;
import sg.bigo.ads.common.u.c.c;
import sg.bigo.ads.common.u.g;
import sg.bigo.ads.common.u.h;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    public interface a {
        void a();

        boolean a(int i);

        void b();
    }

    public static void a(Context context, String str, sg.bigo.ads.common.u.a aVar, String str2, int i, Map<String, String> map, a aVar2) {
        a(context, str, aVar, str2, i, false, 0, map, aVar2);
    }

    public static void a(Context context, final String str, final sg.bigo.ads.common.u.a aVar, final String str2, final int i, final boolean z, final int i2, final Map<String, String> map, final a aVar2) {
        if (sg.bigo.ads.common.x.a.p()) {
            return;
        }
        sg.bigo.ads.common.t.a.a(0, 3, "TrackerRequestHelper", "track url = " + aVar.a());
        if (i.f13093a.n().a(9) && URLUtil.isHttpUrl(aVar.a())) {
            b(str, LoginLogger.EVENT_EXTRAS_FAILURE, aVar, str2, z, i2, i, map, 901, "Invalid http url");
            return;
        }
        a(str, aVar, str2, z, i2, i, map);
        sg.bigo.ads.common.u.b.a aVar3 = new sg.bigo.ads.common.u.b.a(aVar, context);
        aVar3.k = e.g();
        g.a(aVar3, new sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.a, sg.bigo.ads.common.u.c.a>() { // from class: sg.bigo.ads.core.e.b.1
            private final List<Integer> j = new ArrayList();
            private int k = -1;
            private boolean l = false;

            private boolean a(sg.bigo.ads.common.u.b.a aVar4) {
                Iterator<Integer> it = this.j.iterator();
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    a aVar5 = aVar2;
                    if ((aVar5 != null && aVar5.a(iIntValue)) || super.a(aVar4, iIntValue)) {
                        this.k = iIntValue;
                        this.l = true;
                        return true;
                    }
                }
                return false;
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* bridge */ /* synthetic */ c a(sg.bigo.ads.common.u.c.a aVar4) {
                return aVar4;
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ void a(sg.bigo.ads.common.u.b.c cVar, String str3, int i3) {
                super.a((sg.bigo.ads.common.u.b.a) cVar, str3, i3);
                this.j.add(Integer.valueOf(i3));
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ void a(sg.bigo.ads.common.u.b.c cVar, c cVar2) {
                sg.bigo.ads.common.u.c.a aVar4 = (sg.bigo.ads.common.u.c.a) cVar2;
                a aVar5 = aVar2;
                if (aVar5 != null) {
                    aVar5.b();
                }
                b.b(str, "success", aVar, str2, z, i2, i, map, aVar4.f13275a, "success");
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ void a(sg.bigo.ads.common.u.b.c cVar, h hVar) {
                String str3;
                sg.bigo.ads.common.u.a aVar4;
                String str4;
                boolean z2;
                int i3;
                int i4;
                Map map2;
                int i5;
                String message;
                String str5;
                sg.bigo.ads.common.u.b.a aVar5 = (sg.bigo.ads.common.u.b.a) cVar;
                if (this.l || a(aVar5)) {
                    a aVar6 = aVar2;
                    if (aVar6 != null) {
                        aVar6.b();
                    }
                    str3 = str;
                    aVar4 = aVar;
                    str4 = str2;
                    z2 = z;
                    i3 = i2;
                    i4 = i;
                    map2 = map;
                    i5 = this.k;
                    message = "Something wrong occurs when handling the request, but it is still successful";
                    str5 = "success";
                } else {
                    sg.bigo.ads.common.t.a.a(0, 3, "TrackerRequestHelper", "track onError e=" + hVar.getMessage());
                    a aVar7 = aVar2;
                    if (aVar7 != null) {
                        aVar7.a();
                    }
                    str3 = str;
                    aVar4 = aVar;
                    str4 = str2;
                    z2 = z;
                    i3 = i2;
                    i4 = i;
                    map2 = map;
                    i5 = hVar.f13280a;
                    message = hVar.getMessage();
                    str5 = LoginLogger.EVENT_EXTRAS_FAILURE;
                }
                b.b(str3, str5, aVar4, str4, z2, i3, i4, map2, i5, message);
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ boolean a(sg.bigo.ads.common.u.b.c cVar, int i3) {
                this.j.add(Integer.valueOf(i3));
                return a((sg.bigo.ads.common.u.b.a) cVar);
            }
        });
    }

    private static void a(String str, sg.bigo.ads.common.u.a aVar, String str2, boolean z, int i, int i2, Map<String, String> map) {
        b(str, "start", aVar, str2, z, i, i2, map, 0, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2, sg.bigo.ads.common.u.a aVar, String str3, boolean z, int i, int i2, Map<String, String> map, int i3, String str4) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        HashMap map2 = new HashMap(map);
        map2.put("action", str);
        map2.put("track_url", aVar.a());
        map2.put("domain_front", aVar.e() ? aVar.d() : "");
        map2.put("track_name", str3);
        map2.put("states", str2);
        map2.put("src", z ? "1" : "0");
        map2.put("res_code", String.valueOf(i3));
        if (str4 == null) {
            str4 = "";
        }
        map2.put("res_msg", str4);
        map2.put("retry", String.valueOf(i));
        map2.put("out_ad", String.valueOf(i2));
        str.hashCode();
        switch (str) {
            case "va_cpn_cli":
            case "va_cli":
            case "click_track":
                sg.bigo.ads.core.d.b.b(map2);
                break;
            case "va_cpn_imp":
            case "impl_track":
            case "va_show":
                sg.bigo.ads.core.d.b.a(map2);
                break;
            default:
                sg.bigo.ads.common.t.a.a(0, 3, "TrackerRequestHelper", "reportTrack dont report action =".concat(String.valueOf(str)));
                break;
        }
    }
}
