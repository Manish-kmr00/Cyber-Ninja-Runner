package com.json;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.json.mediationsdk.logger.IronLog;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ik {
    private static final String b = "ik";
    private static final String c = "supersonic_shared_preferen";
    private static final String d = "version";
    private static final String e = "back_button_state";
    private static final String f = "search_keys";
    private static final String g = "^\\d+_\\d+$";
    private static ik h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f3781a;

    private ik(Context context) {
        this.f3781a = context.getSharedPreferences("supersonic_shared_preferen", 0);
    }

    public static synchronized ik a(Context context) {
        if (h == null) {
            h = new ik(context);
        }
        return h;
    }

    private boolean b(String str) {
        return str.matches(g);
    }

    public static synchronized ik e() {
        return h;
    }

    public String a(String str) {
        String string = this.f3781a.getString(str, null);
        return string != null ? string : JsonUtils.EMPTY_JSON;
    }

    public ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strArr = (String[]) this.f3781a.getAll().keySet().toArray(new String[0]);
        SharedPreferences.Editor editorEdit = this.f3781a.edit();
        for (String str : strArr) {
            if (b(str)) {
                arrayList.add(str);
                editorEdit.remove(str);
            }
        }
        editorEdit.apply();
        return arrayList;
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.f3781a.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public boolean a(String str, String str2, String str3) {
        String string = this.f3781a.getString("ssaUserData", null);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(string);
            if (jSONObjectJsonObjectInit.isNull(str2)) {
                return false;
            }
            JSONObject jSONObject = jSONObjectJsonObjectInit.getJSONObject(str2);
            if (jSONObject.isNull(str3)) {
                return false;
            }
            jSONObject.getJSONObject(str3).put("timestamp", str);
            SharedPreferences.Editor editorEdit = this.f3781a.edit();
            editorEdit.putString("ssaUserData", jSONObjectJsonObjectInit.toString());
            editorEdit.apply();
            return true;
        } catch (JSONException e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            return false;
        }
    }

    public eh.a b() {
        int i = Integer.parseInt(this.f3781a.getString(e, "2"));
        if (i == 0) {
            return eh.a.None;
        }
        if (i == 1) {
            return eh.a.Device;
        }
        return i == 2 ? eh.a.Controller : eh.a.Controller;
    }

    public String c() {
        return this.f3781a.getString("version", "-1");
    }

    public void c(String str) {
        SharedPreferences.Editor editorEdit = this.f3781a.edit();
        editorEdit.putString(e, str);
        editorEdit.apply();
    }

    public List<String> d() {
        String string = this.f3781a.getString(f, null);
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            fr frVar = new fr(string);
            if (frVar.a(b9.h.R)) {
                try {
                    arrayList.addAll(frVar.a((JSONArray) frVar.b(b9.h.R)));
                } catch (JSONException e2) {
                    o9.d().a(e2);
                    IronLog.INTERNAL.error(e2.toString());
                }
            }
        }
        return arrayList;
    }

    public void d(String str) {
        if (c().equalsIgnoreCase(str)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f3781a.edit();
        editorEdit.putString("version", str);
        editorEdit.apply();
    }

    public void e(String str) {
        SharedPreferences.Editor editorEdit = this.f3781a.edit();
        editorEdit.putString(f, str);
        editorEdit.apply();
    }
}
