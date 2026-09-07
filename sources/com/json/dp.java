package com.json;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class dp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3615a = "com.google.market";
    public static final String b = "com.android.vending";
    public static final String c = "isInstalled";
    private static final String d = "dp";
    private static final ArrayList<String> e = new a();

    class a extends ArrayList<String> {
        a() {
            add(dp.f3615a);
            add("com.android.vending");
        }
    }

    class b extends JSONObject {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3616a;

        b(boolean z) throws JSONException {
            this.f3616a = z;
            put("isInstalled", z);
        }
    }

    private enum c {
        GOOGLE_PLAY(2, new String[]{"com.android.vending"}),
        GOOGLE_MARKET(4, new String[]{dp.f3615a}),
        SAMSUNG(5, new String[]{"com.sec.android.app.samsungapps"}),
        AMAZON(6, new String[]{"com.amazon.venezia"}),
        HUAWEI(7, new String[]{"com.huawei.appmarket"});

        private static final Map<String, c> h = new HashMap();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f3617a;
        private final String[] b;

        static {
            for (c cVar : values()) {
                for (String str : cVar.d()) {
                    h.put(str, cVar);
                }
            }
        }

        c(int i2, String[] strArr) {
            this.f3617a = i2;
            this.b = strArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArrayList<String> b() {
            return new ArrayList<>(h.keySet());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int c() {
            return this.f3617a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String[] d() {
            return this.b;
        }
    }

    private static JSONObject a(Context context) {
        return a(context, e);
    }

    private static JSONObject a(Context context, ArrayList<String> arrayList) {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        try {
            ArrayList<String> arrayListB = b(context);
            for (String str : arrayList) {
                jSONObjectJsonObjectInit.put(str, a(arrayListB.contains(str.trim().toLowerCase(Locale.getDefault()))));
            }
        } catch (Exception e2) {
            o9.d().a(e2);
            Log.d(d, "Error while extracting packages installation data");
        }
        return jSONObjectJsonObjectInit;
    }

    private static JSONObject a(boolean z) throws JSONException {
        return SafeIronSourceronsourceBridge.com_ironsource_dp$b_jsonObjectInit(z);
    }

    private static ArrayList<String> b(Context context) {
        List<ApplicationInfo> listO = mm.S().f().o(context);
        ArrayList<String> arrayList = new ArrayList<>();
        for (ApplicationInfo applicationInfo : listO) {
            if (applicationInfo != null) {
                arrayList.add(applicationInfo.packageName.toLowerCase(Locale.getDefault()));
            }
        }
        return arrayList;
    }

    public static Integer c(Context context) {
        JSONObject jSONObjectA = a(context, c.b());
        int iPow = 0;
        for (c cVar : c.values()) {
            for (String str : cVar.d()) {
                JSONObject jSONObjectOptJSONObject = jSONObjectA.optJSONObject(str);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean("isInstalled")) {
                    iPow = (int) (((double) iPow) + Math.pow(2.0d, cVar.c() - 1));
                    break;
                }
            }
        }
        return Integer.valueOf(iPow);
    }

    public static boolean d(Context context) {
        JSONObject jSONObjectA = a(context);
        Iterator<String> itKeys = jSONObjectA.keys();
        while (itKeys.hasNext()) {
            JSONObject jSONObjectOptJSONObject = jSONObjectA.optJSONObject(itKeys.next());
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean("isInstalled")) {
                return true;
            }
        }
        return false;
    }
}
