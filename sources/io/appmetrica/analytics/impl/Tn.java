package io.appmetrica.analytics.impl;

import android.util.Base64;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class Tn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Vn f11370a;

    public Tn(Oe oe, C4188ia c4188ia) {
        this.f11370a = new Vn(oe, c4188ia, new Wn() { // from class: io.appmetrica.analytics.impl.Tn$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.Wn
            public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
                return Tn.a(jSONObject, jSONObject2);
            }
        });
    }

    public static final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("device_id", JsonUtils.optStringOrNullable(jSONObject2, "device_id", JsonUtils.optStringOrNull(jSONObject, "device_id")));
        jSONObject3.put("device_id_hash", JsonUtils.optStringOrNullable(jSONObject2, "device_id_hash", JsonUtils.optStringOrNull(jSONObject, "device_id_hash")));
        jSONObject3.put(Constants.REFERRER, JsonUtils.optStringOrNullable(jSONObject2, Constants.REFERRER, JsonUtils.optStringOrNull(jSONObject, Constants.REFERRER)));
        jSONObject3.put("referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject2, "referrer_checked", JsonUtils.optBooleanOrNullable(jSONObject, "referrer_checked", Boolean.FALSE)));
        jSONObject3.put("last_migration_api_level", AbstractC4288mb.a(jSONObject2, "last_migration_api_level", AbstractC4288mb.a(jSONObject, "last_migration_api_level", -1)));
        return jSONObject3;
    }

    public final synchronized void b(String str) {
        Vn vn = this.f11370a;
        vn.a(vn.a().put("device_id_hash", str));
    }

    public final synchronized boolean c() {
        return this.f11370a.a().optBoolean("referrer_checked", false);
    }

    public final synchronized void d() {
        Vn vn = this.f11370a;
        vn.a(vn.a().put("referrer_checked", true));
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0026  */
    public final synchronized C4044cg b() {
        C4044cg c4044cg;
        String strOptStringOrNull = JsonUtils.optStringOrNull(this.f11370a.a(), Constants.REFERRER);
        if (strOptStringOrNull != null) {
            try {
                byte[] bArrDecode = Base64.decode(strOptStringOrNull.getBytes(Charsets.UTF_8), 0);
                if (bArrDecode == null || bArrDecode.length == 0) {
                    c4044cg = null;
                } else {
                    c4044cg = new C4044cg(bArrDecode);
                }
            } catch (Throwable unused) {
            }
        } else {
            c4044cg = null;
        }
        return c4044cg;
    }

    public final synchronized void a(String str) {
        Vn vn = this.f11370a;
        vn.a(vn.a().put("device_id", str));
    }

    public final synchronized String a() {
        return JsonUtils.optStringOrNull(this.f11370a.a(), "device_id_hash");
    }

    public final synchronized void a(C4044cg c4044cg) {
        Vn vn = this.f11370a;
        vn.a(vn.a().put(Constants.REFERRER, c4044cg != null ? new String(Base64.encode(c4044cg.a(), 0), Charsets.UTF_8) : null));
    }
}
