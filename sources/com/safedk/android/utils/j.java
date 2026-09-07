package com.safedk.android.utils;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8162a = "sdk_key";
    public static final String b = "userUUID";
    public static final String c = "configuration";
    public static final String d = "last_reported_device_at";
    public static final String e = "last_reported_version";
    public static final String f = "configETag";
    public static final String g = "sdk_version";
    public static final String h = "versionCode";
    public static final String i = "randomToken";
    public static final int j = -1;
    public static final String k = "";
    private static final String l = "SharedPreferencesUtils";
    private static final String m = "offlineMode";
    private static final String n = "age";
    private static final String o = "region";
    private static final String p = "last_foreground_time";
    private static final String q = "last_foreground_report";
    private static final String r = "sdk_versions";
    private static final String s = "is_reported";
    private static final String w = "safedk_stored_version";
    private static final String x = "§§";
    private final SharedPreferences t;
    private boolean u;
    private JSONObject v;

    public j(SharedPreferences sharedPreferences, boolean z) {
        this.t = sharedPreferences;
        this.u = z;
    }

    private void a(Map<String, String> map) {
        try {
            this.v = new JSONObject(this.t.getString(r, JsonUtils.EMPTY_JSON));
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                String sdkUUIDByPackage = SdksMapping.getSdkUUIDByPackage(key);
                Logger.d(l, "addDiscoveredVersionsToVersionsJson sdkPackage=" + key + ", version=" + value + ", uuid=" + sdkUUIDByPackage);
                if (sdkUUIDByPackage != null) {
                    try {
                        if (sdkUUIDByPackage.length() > 0 && value != null && value.length() > 0) {
                            this.v.put(sdkUUIDByPackage, value);
                        }
                    } catch (JSONException e2) {
                        Logger.d(l, "error in addDiscoveredVersionsToVersionsJson", e2);
                    }
                }
                Logger.d(l, "UUID for sdkPackage " + key + "is empty and will not be added to sdkVersionsJson");
            }
            a(this.v);
        } catch (Throwable th) {
            Logger.e(l, "Exception in addDiscoveredVersionsToVersionsJson", th);
        }
    }

    private void a(JSONObject jSONObject) {
        SharedPreferences.Editor editorEdit = this.t.edit();
        editorEdit.putString(r, jSONObject.toString());
        Logger.d(l, "saveSdkVersions saved (" + jSONObject.length() + " items) : " + jSONObject.toString());
        editorEdit.apply();
    }

    public String a() {
        return this.t.getString(b, null);
    }

    public boolean b() {
        return this.t.getBoolean(m, this.u);
    }

    public Integer c() {
        int i2 = this.t.getInt("age", -1);
        if (i2 < 0) {
            return null;
        }
        return new Integer(i2);
    }

    public String d() {
        return this.t.getString("region", null);
    }

    public Bundle e() {
        Logger.d(l, "getConfiguration started");
        return a(this.t, c);
    }

    public long f() {
        return this.t.getLong(d, 0L);
    }

    public int g() {
        return this.t.getInt(e, 0);
    }

    public long h() {
        return this.t.getLong(p, 0L);
    }

    public long i() {
        return this.t.getLong(q, 0L);
    }

    public JSONObject j() {
        return this.v;
    }

    public void a(long j2) {
        SharedPreferences.Editor editorEdit = this.t.edit();
        editorEdit.putLong(p, j2);
        editorEdit.apply();
    }

    public String k() {
        return this.t.getString(f, null);
    }

    public void a(String str) {
        SharedPreferences.Editor editorEdit = this.t.edit();
        editorEdit.putString(b, str);
        editorEdit.apply();
    }

    public boolean l() {
        return this.t.contains(c);
    }

    public void a(Bundle bundle) {
        try {
            SharedPreferences.Editor editorEdit = this.t.edit();
            String strP = p();
            String strA = a();
            editorEdit.clear();
            a(editorEdit, c, bundle);
            if (strP != null) {
                editorEdit.putString(w, strP);
            }
            if (strA != null) {
                editorEdit.putString(b, strA);
            }
            editorEdit.apply();
        } catch (Throwable th) {
            Logger.e(l, "Caught exception : " + th.getMessage(), th);
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, Bundle bundle) {
        String str2 = str + x;
        for (String str3 : bundle.keySet()) {
            Object obj = bundle.get(str3);
            if (obj == null) {
                editor.remove(str2 + str3);
            } else if (obj instanceof Integer) {
                editor.putInt(str2 + str3, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                editor.putLong(str2 + str3, ((Long) obj).longValue());
            } else if (obj instanceof Boolean) {
                editor.putBoolean(str2 + str3, ((Boolean) obj).booleanValue());
            } else if (obj instanceof CharSequence) {
                editor.putString(str2 + str3, ((CharSequence) obj).toString());
            } else if ((obj instanceof ArrayList) && ((ArrayList) obj).size() > 0 && (((ArrayList) obj).get(0) instanceof String)) {
                editor.putStringSet(str2 + str3, new HashSet((ArrayList) obj));
            } else if (obj instanceof Bundle) {
                a(editor, str2 + str3, (Bundle) obj);
            }
        }
    }

    public static Bundle a(SharedPreferences sharedPreferences, String str) {
        Logger.d(l, "loadPreferencesBundle started, key=" + str);
        Bundle bundle = new Bundle();
        Map<String, ?> all = sharedPreferences.getAll();
        String str2 = str + x;
        HashSet<String> hashSet = new HashSet();
        for (String str3 : all.keySet()) {
            if (str3.startsWith(str2)) {
                String strB = b(str3, str2);
                if (!strB.contains(x)) {
                    Object obj = all.get(str3);
                    if (obj != null) {
                        if (obj instanceof Integer) {
                            bundle.putInt(strB, ((Integer) obj).intValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(strB, ((Long) obj).longValue());
                        } else if (obj instanceof Boolean) {
                            bundle.putBoolean(strB, ((Boolean) obj).booleanValue());
                        } else if (obj instanceof CharSequence) {
                            bundle.putString(strB, ((CharSequence) obj).toString());
                        } else if (obj instanceof HashSet) {
                            bundle.putStringArrayList(strB, new ArrayList<>((HashSet) obj));
                        }
                    }
                } else {
                    hashSet.add(a(strB, x));
                }
            }
        }
        for (String str4 : hashSet) {
            bundle.putBundle(str4, a(sharedPreferences, str2 + str4));
        }
        return bundle;
    }

    public static String a(String str, String str2) {
        if (!b(str) && str2 != null) {
            if (str2.length() == 0) {
                return "";
            }
            int iIndexOf = str.indexOf(str2);
            return iIndexOf != -1 ? str.substring(0, iIndexOf) : str;
        }
        return str;
    }

    public static boolean b(String str) {
        return str == null || str.length() == 0;
    }

    public static String b(String str, String str2) {
        if (!b(str) && !b(str2) && str.startsWith(str2)) {
            return str.substring(str2.length());
        }
        return str;
    }

    public void a(int i2, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = this.t.edit();
            editorEdit.putInt(h, i2);
            editorEdit.putString(i, str);
            editorEdit.putString("sdk_key", str2);
            Logger.d(l, "save sdk key " + str2 + ", token " + str + ", version code " + i2);
            editorEdit.apply();
        } catch (Throwable th) {
            Logger.d(l, "Caught exception", th);
        }
    }

    public String m() {
        String string = this.t.getString("sdk_key", null);
        Logger.d(l, "read sdk key " + string);
        return string;
    }

    public int n() {
        int i2 = this.t.getInt(h, 0);
        Logger.d(l, "read version code " + i2);
        return i2;
    }

    public String o() {
        String string = this.t.getString(i, null);
        Logger.d(l, "read token " + string);
        return string;
    }

    public void c(String str) {
        SharedPreferences.Editor editorEdit = this.t.edit();
        editorEdit.putString(w, str);
        editorEdit.apply();
    }

    public String p() {
        return this.t.getString(w, null);
    }
}
