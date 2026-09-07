package com.bytedance.sdk.openadsdk.p002Sd;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class ZZv {
    private final String KZx;
    private final Context Og;
    private SharedPreferences pA;

    public ZZv(Context context, String str) {
        this.Og = context;
        this.KZx = str;
    }

    private SharedPreferences Og() {
        Context context;
        SharedPreferences sharedPreferences = this.pA;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        if (TextUtils.isEmpty(this.KZx) || (context = this.Og) == null) {
            return null;
        }
        try {
            this.pA = context.getSharedPreferences(this.KZx, 0);
        } catch (Throwable th) {
            Log.e("SPUnit", th.getMessage());
        }
        return this.pA;
    }

    public void pA(JSONObject jSONObject) {
        try {
            SharedPreferences sharedPreferencesOg = Og();
            if (sharedPreferencesOg != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesOg.edit();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        if (!TextUtils.isEmpty(next)) {
                            Object obj = jSONObject.get(next);
                            if (obj instanceof Integer) {
                                editorEdit.putInt(next, ((Integer) obj).intValue());
                            } else if (obj instanceof Long) {
                                editorEdit.putLong(next, ((Long) obj).longValue());
                            } else if (obj instanceof String) {
                                editorEdit.putString(next, (String) obj);
                            } else if (obj instanceof Boolean) {
                                editorEdit.putBoolean(next, ((Boolean) obj).booleanValue());
                            } else if (obj instanceof Float) {
                                editorEdit.putFloat(next, ((Float) obj).floatValue());
                            } else if (obj instanceof Double) {
                                editorEdit.putFloat(next, Double.valueOf(((Double) obj).doubleValue()).floatValue());
                            }
                        }
                    } catch (Throwable th) {
                        Log.e("SPUnit", th.getMessage());
                    }
                }
                editorEdit.apply();
            }
        } catch (Throwable th2) {
            Log.e("SPUnit", th2.getMessage());
        }
    }

    public void pA(String str, long j) {
        try {
            SharedPreferences sharedPreferencesOg = Og();
            if (sharedPreferencesOg != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesOg.edit();
                editorEdit.putLong(str, j);
                editorEdit.apply();
            }
        } catch (Throwable th) {
            Log.e("SPUnit", th.getMessage());
        }
    }

    public int pA(String str, int i) {
        try {
            SharedPreferences sharedPreferencesOg = Og();
            if (sharedPreferencesOg != null && sharedPreferencesOg.contains(str)) {
                return sharedPreferencesOg.getInt(str, i);
            }
            return i;
        } catch (Throwable th) {
            Log.i("SPUnit", this.KZx + th.getMessage());
            return i;
        }
    }

    public long Og(String str, long j) {
        try {
            SharedPreferences sharedPreferencesOg = Og();
            if (sharedPreferencesOg != null && sharedPreferencesOg.contains(str)) {
                return sharedPreferencesOg.getLong(str, j);
            }
            return j;
        } catch (Throwable th) {
            Log.i("SPUnit", this.KZx + th.getMessage());
            return j;
        }
    }

    public String pA(String str, String str2) {
        try {
            SharedPreferences sharedPreferencesOg = Og();
            if (sharedPreferencesOg != null && sharedPreferencesOg.contains(str)) {
                return sharedPreferencesOg.getString(str, str2);
            }
            return str2;
        } catch (Throwable th) {
            Log.i("SPUnit", this.KZx + th.getMessage());
            return str2;
        }
    }

    public boolean pA(String str, boolean z) {
        try {
            SharedPreferences sharedPreferencesOg = Og();
            if (sharedPreferencesOg != null && sharedPreferencesOg.contains(str)) {
                return sharedPreferencesOg.getBoolean(str, z);
            }
            return z;
        } catch (Throwable th) {
            Log.i("SPUnit", this.KZx + th.getMessage());
            return z;
        }
    }

    public void pA() {
        SharedPreferences sharedPreferencesOg = Og();
        if (sharedPreferencesOg != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesOg.edit();
            editorEdit.clear();
            editorEdit.commit();
        }
    }
}
