package sg.bigo.ads.common.x;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f13361a;

    public static SharedPreferences a(String str) {
        Context context = f13361a;
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        sg.bigo.ads.common.t.a.a(0, "SharedPreferenceManager", "sContext is null");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(SharedPreferences.Editor editor, String str, T t, int i) {
        if (editor != null) {
            if (i == 0) {
                if (!(t instanceof Number)) {
                    throw new NumberFormatException();
                }
                editor.putInt(str, ((Number) t).intValue());
                return;
            }
            if (i == 1) {
                if (!(t instanceof Number)) {
                    throw new NumberFormatException();
                }
                editor.putLong(str, ((Number) t).longValue());
                return;
            }
            if (i == 2) {
                if (!(t instanceof Number)) {
                    throw new NumberFormatException();
                }
                editor.putFloat(str, ((Number) t).floatValue());
                return;
            }
            if (i == 3) {
                if (t != 0 && !(t instanceof String)) {
                    throw new ClassCastException();
                }
                editor.putString(str, (String) t);
                return;
            }
            if (i == 4) {
                if (!(t instanceof Boolean)) {
                    throw new ClassCastException();
                }
                editor.putBoolean(str, ((Boolean) t).booleanValue());
            } else {
                if (i != 5) {
                    return;
                }
                if (t != 0 && !(t instanceof Set)) {
                    throw new ClassCastException();
                }
                editor.putStringSet(str, (Set) t);
            }
        }
    }

    public static <T> void a(String str, T t, int i) {
        a("sp_ads", str, t, i);
    }

    static <T> void a(String str, String str2, T t, int i) {
        try {
            SharedPreferences.Editor editorB = b(str);
            a(editorB, str2, t, i);
            c.a.a();
            c.a.C0882a.a(editorB);
        } catch (Exception e) {
            sg.bigo.ads.common.t.a.a(0, "SharedPreferenceManager", Log.getStackTraceString(e));
        }
    }

    public static boolean a() {
        return f13361a != null;
    }

    public static SharedPreferences.Editor b(String str) {
        try {
            return a(str).edit();
        } catch (Exception e) {
            sg.bigo.ads.common.t.a.a(0, "SharedPreferenceManager", Log.getStackTraceString(e));
            return null;
        }
    }

    public static <T> Object b(String str, T t, int i) {
        return b("sp_ads", str, t, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T> Object b(String str, String str2, T t, int i) {
        SharedPreferences sharedPreferencesA = a(str);
        if (sharedPreferencesA != null) {
            if (i == 0) {
                if (!(t instanceof Number)) {
                    throw new NumberFormatException();
                }
                int iIntValue = ((Number) t).intValue();
                Object obj = sharedPreferencesA.getAll().get(str2);
                if (obj instanceof Integer) {
                    iIntValue = ((Integer) obj).intValue();
                } else if (obj instanceof String) {
                    try {
                        iIntValue = Integer.parseInt((String) obj);
                    } catch (Exception unused) {
                    }
                }
                return Integer.valueOf(iIntValue);
            }
            if (i == 1) {
                if (!(t instanceof Number)) {
                    throw new NumberFormatException();
                }
                long jLongValue = ((Number) t).longValue();
                Object obj2 = sharedPreferencesA.getAll().get(str2);
                if (obj2 instanceof Long) {
                    jLongValue = ((Long) obj2).longValue();
                } else if (obj2 instanceof String) {
                    try {
                        jLongValue = Long.parseLong((String) obj2);
                    } catch (Exception unused2) {
                    }
                }
                return Long.valueOf(jLongValue);
            }
            if (i == 2) {
                if (!(t instanceof Number)) {
                    throw new NumberFormatException();
                }
                float fFloatValue = ((Number) t).floatValue();
                Object obj3 = sharedPreferencesA.getAll().get(str2);
                if (obj3 instanceof Float) {
                    fFloatValue = ((Float) obj3).floatValue();
                } else if (obj3 instanceof String) {
                    try {
                        fFloatValue = Float.parseFloat((String) obj3);
                    } catch (Exception unused3) {
                    }
                }
                return Float.valueOf(fFloatValue);
            }
            if (i == 3) {
                if (t != 0 && !(t instanceof String)) {
                    throw new ClassCastException();
                }
                try {
                    return sharedPreferencesA.getString(str2, (String) t);
                } catch (ClassCastException unused4) {
                    return null;
                }
            }
            if (i == 4) {
                if (!(t instanceof Boolean)) {
                    throw new ClassCastException();
                }
                boolean zBooleanValue = ((Boolean) t).booleanValue();
                Object obj4 = sharedPreferencesA.getAll().get(str2);
                if (obj4 instanceof Boolean) {
                    zBooleanValue = ((Boolean) obj4).booleanValue();
                } else if (obj4 instanceof String) {
                    try {
                        zBooleanValue = Boolean.parseBoolean((String) obj4);
                    } catch (Exception unused5) {
                    }
                }
                return Boolean.valueOf(zBooleanValue);
            }
            if (i == 5) {
                if (t == 0 || (t instanceof Set)) {
                    return sharedPreferencesA.getStringSet(str2, (Set) t);
                }
                throw new ClassCastException();
            }
        }
        return null;
    }
}
