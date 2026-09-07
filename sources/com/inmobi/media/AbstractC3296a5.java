package com.inmobi.media;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.a5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractC3296a5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f3265a = new Object();
    public static final Object b = new Object();
    public static boolean c;
    public static boolean d;
    public static JSONObject e;
    public static JSONObject f;

    public static final void a(JSONObject jSONObject) {
        synchronized (b) {
            Objects.toString(f);
            Objects.toString(jSONObject);
            f = jSONObject;
            d = true;
            Context contextD = C3517pb.d();
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                K5 k5A = J5.a(contextD, "unified_id_info_store");
                JSONObject jSONObject2 = f;
                if (jSONObject2 == null) {
                    k5A.a("publisher_provided_unified_id");
                } else {
                    k5A.a("publisher_provided_unified_id", String.valueOf(jSONObject2));
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    public static final JSONObject b() {
        synchronized (f3265a) {
            if (c) {
                return e;
            }
            c = true;
            Context contextD = C3517pb.d();
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                K5 k5A = J5.a(contextD, "unified_id_info_store");
                Intrinsics.checkNotNullParameter("ufids", "key");
                String string = k5A.f3112a.getString("ufids", null);
                if (string != null) {
                    try {
                        e = new JSONObject(string);
                    } catch (JSONException unused) {
                    }
                    return e;
                }
            }
            return null;
        }
    }

    public static final JSONObject a() {
        synchronized (b) {
            if (d) {
                Objects.toString(f);
                return f;
            }
            d = true;
            Context contextD = C3517pb.d();
            String string = null;
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                K5 k5A = J5.a(contextD, "unified_id_info_store");
                Intrinsics.checkNotNullParameter("publisher_provided_unified_id", "key");
                string = k5A.f3112a.getString("publisher_provided_unified_id", null);
            }
            try {
                f = new JSONObject(string);
            } catch (NullPointerException | JSONException unused) {
            }
            Objects.toString(f);
            return f;
        }
    }

    public static final void b(JSONObject jSONObject) {
        synchronized (f3265a) {
            e = jSONObject;
            c = true;
            Context contextD = C3517pb.d();
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                K5 k5A = J5.a(contextD, "unified_id_info_store");
                JSONObject jSONObject2 = e;
                if (jSONObject2 == null) {
                    k5A.a("ufids");
                } else {
                    String strValueOf = String.valueOf(jSONObject2);
                    Intrinsics.checkNotNullParameter("ufids", "key");
                    SharedPreferences.Editor editorEdit = k5A.f3112a.edit();
                    editorEdit.putString("ufids", strValueOf);
                    editorEdit.apply();
                }
                SharedPreferences.Editor editorEdit2 = PreferenceManager.getDefaultSharedPreferences(contextD).edit();
                JSONObject jSONObject3 = e;
                if (jSONObject3 == null) {
                    editorEdit2.remove("InMobi_unifiedId");
                } else {
                    editorEdit2.putString("InMobi_unifiedId", String.valueOf(jSONObject3));
                }
                editorEdit2.apply();
            }
        }
    }
}
