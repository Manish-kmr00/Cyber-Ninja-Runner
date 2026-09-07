package sg.bigo.ads.controller.landing;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.safedk.android.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONArray;
import sg.bigo.ads.api.AdActivity;
import sg.bigo.ads.api.core.e;
import sg.bigo.ads.controller.form.AdFormActivity;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final WeakHashMap<sg.bigo.ads.ad.c<?, ?>, Integer> f13486a = new WeakHashMap<>();

    public static int a(int i) {
        if (i == 0) {
            return 2;
        }
        if (i != 1) {
            return i != 2 ? 5 : 4;
        }
        return 3;
    }

    public static e a(Context context, String str, String str2, String str3, boolean z, int i, JSONArray jSONArray, sg.bigo.ads.ad.c<?, ?> cVar, boolean z2) {
        ArrayList arrayList;
        if (str != null) {
            arrayList = new ArrayList();
            arrayList.add(str);
        } else {
            arrayList = null;
        }
        return a(context, arrayList, str2, str3, z, i, jSONArray, cVar, z2);
    }

    public static e a(Context context, List<String> list, String str, String str2, boolean z, int i, JSONArray jSONArray, sg.bigo.ads.ad.c<?, ?> cVar, boolean z2) {
        a aVar;
        e eVar = new e();
        boolean zA = false;
        eVar.f13102a = 0;
        if (cVar != null && (aVar = cVar.l) != null && !aVar.b()) {
            aVar.a();
        }
        if (list != null) {
            boolean zA2 = false;
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str3 = list.get(i2);
                if (!TextUtils.isEmpty(str3) && (zA2 = sg.bigo.ads.core.landing.a.a(Uri.parse(str3), context, eVar, str2))) {
                    eVar.f13102a = 1;
                    break;
                }
            }
            zA = zA2;
        }
        if (!zA && z && !TextUtils.isEmpty(str2) && (zA = sg.bigo.ads.core.landing.a.a(context, str2))) {
            eVar.f13102a = 4;
        }
        if (!zA && !TextUtils.isEmpty(str)) {
            Uri uri = Uri.parse(str);
            if (sg.bigo.ads.core.landing.a.a(str)) {
                eVar.f13102a = 2;
                zA = sg.bigo.ads.core.landing.a.a(uri, context, eVar);
            } else {
                eVar.f13102a = 3;
                zA = i == 1 ? sg.bigo.ads.core.landing.a.a(context, str, jSONArray) : i == 2 ? a(context, str, cVar, eVar, z2) : a(context, str, cVar, eVar, 0, z2);
            }
        }
        eVar.h = zA;
        if (zA && cVar != null) {
            sg.bigo.ads.api.core.c cVarF = cVar.f();
            if (cVar.s != cVarF.y()) {
                cVar.q = -1;
                cVar.s = cVarF.y();
            }
            cVar.r = System.currentTimeMillis();
            cVar.q++;
        }
        return eVar;
    }

    public static void a() {
    }

    private static void a(int i, sg.bigo.ads.ad.c<?, ?> cVar) {
        WeakHashMap<sg.bigo.ads.ad.c<?, ?>, Integer> weakHashMap = f13486a;
        synchronized (weakHashMap) {
            weakHashMap.put(cVar, Integer.valueOf(i));
        }
    }

    public static void a(Context context, String str, sg.bigo.ads.ad.c<?, ?> cVar) {
        JSONArray jSONArrayD;
        int iC;
        e eVar = new e();
        eVar.f13102a = 0;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Uri uri = Uri.parse(str);
        if (sg.bigo.ads.core.landing.a.a(str)) {
            eVar.f13102a = 2;
            sg.bigo.ads.core.landing.a.a(uri, context, eVar);
            return;
        }
        eVar.f13102a = 3;
        if (cVar != null) {
            iC = cVar.f().N().c();
            jSONArrayD = cVar.f().N().d();
        } else {
            jSONArrayD = null;
            iC = 0;
        }
        if (iC == 1) {
            sg.bigo.ads.core.landing.a.a(context, str, jSONArrayD);
        } else if (iC == 2) {
            a(context, str, cVar, eVar, false);
        } else {
            a(context, str, cVar, eVar, 0, false);
        }
    }

    public static boolean a(Context context, Class<? extends sg.bigo.ads.controller.e.b<?>> cls, sg.bigo.ads.ad.c<?, ?> cVar) {
        if (Build.VERSION.SDK_INT == 26) {
            sg.bigo.ads.core.d.b.a(cVar.f(), 3000, 10116, "android 8.0 cannot show popup");
            return false;
        }
        try {
            Intent intentB = AdActivity.b(context, cls);
            int iHashCode = cVar.hashCode();
            a(iHashCode, cVar);
            intentB.putExtra("ad_identifier", iHashCode);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intentB);
            return true;
        } catch (Exception e) {
            sg.bigo.ads.core.d.b.a(cVar.f(), 3000, 10116, Log.getStackTraceString(e));
            return false;
        }
    }

    public static boolean a(Context context, Class<? extends sg.bigo.ads.controller.e.b<?>> cls, sg.bigo.ads.ad.c<?, ?> cVar, boolean z) {
        try {
            Intent intentE = z ? AdActivity.e(context, cls) : AdActivity.d(context, cls);
            int iHashCode = cVar.hashCode();
            a(iHashCode, cVar);
            intentE.putExtra("ad_identifier", iHashCode);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intentE);
            return true;
        } catch (Exception e) {
            sg.bigo.ads.core.d.b.a(cVar.f(), 3000, 10116, Log.getStackTraceString(e));
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001f  */
    public static boolean a(Context context, String str, sg.bigo.ads.ad.c<?, ?> cVar, e eVar, int i, boolean z) {
        LandingPageStyleConfig landingPageStyleConfigA;
        Intent intentC;
        int i2;
        if (cVar != null) {
            try {
                if (cVar.t == null || cVar.t.get() == null) {
                    landingPageStyleConfigA = null;
                } else {
                    landingPageStyleConfigA = cVar.t.get().a(context, str, i, z);
                }
            } catch (Exception e) {
                sg.bigo.ads.core.d.b.a(cVar != null ? cVar.f() : null, 3000, 10116, Log.getStackTraceString(e));
                return false;
            }
        } else {
            landingPageStyleConfigA = null;
        }
        if (landingPageStyleConfigA == null || !landingPageStyleConfigA.a() || landingPageStyleConfigA.b()) {
            intentC = z ? AdActivity.c(context, c.class) : AdActivity.a(context, c.class);
            i2 = 0;
        } else {
            i2 = landingPageStyleConfigA.f13473a;
            intentC = AdActivity.f(context, landingPageStyleConfigA.g);
            intentC.putExtra("layout_style", landingPageStyleConfigA);
        }
        intentC.putExtra("webview_force_time", landingPageStyleConfigA != null ? landingPageStyleConfigA.b : 1);
        intentC.putExtra("url", str);
        if (cVar != null) {
            int iHashCode = cVar.hashCode();
            a(iHashCode, cVar);
            intentC.putExtra("ad_identifier", iHashCode);
            intentC.putExtra("land_way", i);
        }
        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intentC);
        if (eVar != null) {
            eVar.d = i2;
        }
        return true;
    }

    private static boolean a(Context context, final String str, final sg.bigo.ads.ad.c<?, ?> cVar, final e eVar, final boolean z) {
        final b bVar = new b(str, cVar == null ? null : cVar.f(), cVar, cVar != null ? cVar.l : null);
        sg.bigo.ads.a.a.C0805a c0805a = new sg.bigo.ads.a.a.C0805a();
        c0805a.f12464a = str;
        c0805a.b = bVar;
        c0805a.c = new sg.bigo.ads.a.a.b() { // from class: sg.bigo.ads.controller.landing.d.1
            @Override // sg.bigo.ads.a.a.b
            public final void a(Context context2, String str2, int i, String str3) {
                sg.bigo.ads.common.t.a.a(0, 3, "WebViewStatHelper", "Open landing page by chrome tabs failed, using webView.");
                d.a(context2, str, cVar, eVar, d.a(i), z);
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                sg.bigo.ads.ad.c cVar2 = cVar;
                sg.bigo.ads.core.d.b.a(cVar2 == null ? null : cVar2.f(), 3002, 10114, str3);
            }

            @Override // sg.bigo.ads.a.a.b
            public final void a(String str2, String str3, String str4) {
                b bVar2 = bVar;
                bVar2.f13480a = str2;
                bVar2.b = str3;
                bVar2.c = str4;
            }
        };
        c0805a.a().a(context);
        return true;
    }

    public static boolean a(Context context, sg.bigo.ads.ad.c<?, ?> cVar) {
        if (cVar == null) {
            sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) null, 3000, 10221, "ad == null, launchFormActivity failed");
            return false;
        }
        try {
            Intent intentA = AdFormActivity.a(context);
            int iHashCode = cVar.hashCode();
            int iB_ = cVar.b_();
            a(iHashCode, cVar);
            intentA.putExtra("ad_identifier", iHashCode);
            intentA.putExtra("open_form_time", iB_);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intentA);
            return true;
        } catch (Exception e) {
            sg.bigo.ads.core.d.b.a(cVar.f(), 3000, 10221, Log.getStackTraceString(e));
            return false;
        }
    }

    public static sg.bigo.ads.ad.c<?, ?> b(int i) {
        sg.bigo.ads.ad.c<?, ?> key;
        WeakHashMap<sg.bigo.ads.ad.c<?, ?>, Integer> weakHashMap = f13486a;
        synchronized (weakHashMap) {
            for (Map.Entry<sg.bigo.ads.ad.c<?, ?>, Integer> entry : weakHashMap.entrySet()) {
                if (entry.getValue().intValue() == i) {
                    key = entry.getKey();
                }
            }
            key = null;
        }
        return key;
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        p0.startActivity(p1);
    }
}
