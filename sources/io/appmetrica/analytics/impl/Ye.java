package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class Ye implements Ki {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11436a;
    public final String b = "content://" + a() + "/preload_info";
    public final String c = "tracking_id";
    public final String d = "additional_parameters";

    public Ye(Context context) {
        this.f11436a = context;
    }

    public final String a() {
        return "com.yandex.preinstallsatellite.appmetrica.provider";
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C4118ff invoke() {
        Cursor cursorQuery;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (!PackageManagerUtils.hasContentProvider(this.f11436a, "com.yandex.preinstallsatellite.appmetrica.provider")) {
            Vi.a("Satellite content provider with preload info was not found.", new Object[0]);
            return null;
        }
        try {
            cursorQuery = this.f11436a.getContentResolver().query(Uri.parse(this.b), null, null, null, null);
            try {
                if (cursorQuery == null) {
                    Vi.a("No Satellite content provider found", new Object[0]);
                } else {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(this.c));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(this.d));
                        if (string2 != null) {
                            try {
                                if (string2.length() == 0) {
                                    jSONObject = new JSONObject();
                                    jSONObject2 = jSONObject;
                                } else {
                                    jSONObject2 = new JSONObject(string2);
                                }
                            } catch (Throwable unused) {
                                jSONObject = new JSONObject();
                            }
                        } else {
                            jSONObject = new JSONObject();
                            jSONObject2 = jSONObject;
                        }
                        if (!TextUtils.isEmpty(string) && ParseUtils.parseLong(string) == null) {
                            Vi.a("Tracking id from Satellite is not a number.", new Object[0]);
                        }
                        Vi.a("Preload info from Satellite: {tracking id = %s, additional parameters = %s}", string, jSONObject2);
                        C4118ff c4118ff = new C4118ff(string, jSONObject2, !TextUtils.isEmpty(string), false, X7.d);
                        In.a(cursorQuery);
                        return c4118ff;
                    }
                    Vi.a("No Preload Info data in Satellite content provider", new Object[0]);
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            cursorQuery = null;
        }
        In.a(cursorQuery);
        return null;
    }
}
