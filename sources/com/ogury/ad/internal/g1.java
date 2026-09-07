package com.ogury.ad.internal;

import android.content.Context;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f7302a;
    public final b0 b;
    public final d8 c;

    public g1(Context context) {
        z androidDevice = new z(context);
        b0 app = new b0(context);
        d8 permissionsHandler = new d8(context, i7.TRACKERS);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(androidDevice, "androidDevice");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(permissionsHandler, "permissionsHandler");
        this.f7302a = androidDevice;
        this.b = app;
        this.c = permissionsHandler;
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("connectivity", this.c.c());
        e9 e9Var = this.f7302a.b;
        e9Var.getClass();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(e9Var.f7293a);
        String str = simpleDateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        jSONObject.put(POBConstants.KEY_AT, str);
        jSONObject.put("build", 404010);
        jSONObject.put("version", "5.0.1");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.b.b.b());
        jSONObject.put("apps_publishers", jSONArray);
        return jSONObject;
    }
}
