package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import com.json.mediationsdk.utils.IronSourceConstants;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class Ke extends AbstractC4564xd {
    public static final Ne d = new Ne("UUID_RESULT", null);
    public static final Ne e = new Ne("DEVICE_ID_RESULT", null);
    public static final Ne f = new Ne("DEVICE_ID_HASH_RESULT", null);
    public static final Ne g = new Ne("AD_URL_GET_RESULT", null);
    public static final Ne h = new Ne("AD_URL_REPORT_RESULT", null);
    public static final Ne i = new Ne("CUSTOM_HOSTS", null);
    public static final Ne j = new Ne("SERVER_TIME_OFFSET", null);
    public static final Ne k = new Ne("RESPONSE_CLIDS_RESULT", null);
    public static final Ne l = new Ne("CUSTOM_SDK_HOSTS", null);
    public static final Ne m = new Ne("CLIENT_CLIDS", null);
    public static final Ne n = new Ne("DEFERRED_DEEP_LINK_WAS_CHECKED", null);
    public static final Ne o = new Ne("API_LEVEL", null);
    public static final Ne p = new Ne("NEXT_STARTUP_TIME", null);
    public static final Ne q = new Ne(IronSourceConstants.TYPE_GAID, null);
    public static final Ne r = new Ne("HOAID", null);
    public static final Ne s = new Ne("YANDEX_ADV_ID", null);
    public static final Ne t = new Ne("CLIENT_CLIDS_CHANGED_AFTER_LAST_IDENTIFIERS_UPDATE", null);
    public static final Ne u = new Ne("SCREEN_INFO", null);
    public static final Ne v = new Ne("SCREEN_SIZE_CHECKED_BY_DEPRECATED", null);
    public static final Ne w = new Ne("FEATURES", null);
    public static final Ne x = new Ne("APPMETRICA_CLIENT_CONFIG", null);

    public Ke(Oa oa) {
        super(oa);
    }

    public final boolean a(boolean z) {
        return this.f11258a.getBoolean(t.b, z);
    }

    public final long b(long j2) {
        return this.f11258a.getLong(j.f11268a, j2);
    }

    public final Ke c(IdentifiersResult identifiersResult) {
        return a(l.b, identifiersResult);
    }

    public final IdentifiersResult d() {
        return h(g.b);
    }

    public final IdentifiersResult e() {
        return h(h.b);
    }

    public final Ke f(IdentifiersResult identifiersResult) {
        return a(q.b, identifiersResult);
    }

    public final IdentifiersResult h() {
        return h(l.b);
    }

    public final IdentifiersResult i() {
        return h(f.b);
    }

    public final IdentifiersResult j() {
        return h(e.b);
    }

    public final C4038ca k() {
        String string = this.f11258a.getString(w.b, null);
        try {
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                return new C4038ca(JsonUtils.optBooleanOrNull(jSONObject, "libSslEnabled"), IdentifierStatus.from(JsonUtils.optStringOrNull(jSONObject, "STATUS")), JsonUtils.optStringOrNull(jSONObject, "ERROR_EXPLANATION"));
            }
        } catch (Throwable unused) {
        }
        return new C4038ca(null, IdentifierStatus.UNKNOWN, null);
    }

    public final IdentifiersResult l() {
        return h(q.b);
    }

    public final IdentifiersResult m() {
        return h(r.b);
    }

    public final long n() {
        return this.f11258a.getLong(p.b, 0L);
    }

    public final IdentifiersResult o() {
        return h(k.b);
    }

    public final ScreenInfo p() {
        return AbstractC4288mb.e(this.f11258a.getString(u.b, null));
    }

    public final IdentifiersResult q() {
        return h(d.b);
    }

    public final IdentifiersResult r() {
        return h(s.b);
    }

    public final boolean s() {
        return this.f11258a.getBoolean(n.b, false);
    }

    public final boolean t() {
        return this.f11258a.getBoolean(v.b, false);
    }

    public final Ke u() {
        return (Ke) b(n.b, true);
    }

    public final void v() {
        b(v.b, true);
    }

    public final List<String> g() {
        String string = this.f11258a.getString(i.b, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return AbstractC4288mb.b(string);
    }

    public final long a(long j2) {
        return this.f11258a.getLong(o.b, j2);
    }

    public final Ke b(IdentifiersResult identifiersResult) {
        return a(h.b, identifiersResult);
    }

    public final Ke c(long j2) {
        return (Ke) b(o.b, j2);
    }

    public final Ke d(IdentifiersResult identifiersResult) {
        return a(f.b, identifiersResult);
    }

    public final Ke e(IdentifiersResult identifiersResult) {
        return a(e.b, identifiersResult);
    }

    public final AppMetricaConfig f() {
        String string = this.f11258a.getString(x.b, null);
        if (string == null) {
            return null;
        }
        return AppMetricaConfig.fromJson(string);
    }

    public final IdentifiersResult h(String str) {
        IdentifiersResult identifiersResult;
        try {
            String string = this.f11258a.getString(str, null);
            if (string != null) {
                JSONObject jSONObject = new JSONObject(string);
                identifiersResult = new IdentifiersResult(JsonUtils.optStringOrNull(jSONObject, "ID"), IdentifierStatus.from(JsonUtils.optStringOrNull(jSONObject, "STATUS")), JsonUtils.optStringOrNull(jSONObject, "ERROR_EXPLANATION"));
            } else {
                identifiersResult = null;
            }
        } catch (Throwable unused) {
        }
        return identifiersResult == null ? new IdentifiersResult(null, IdentifierStatus.UNKNOWN, "no identifier in preferences") : identifiersResult;
    }

    public final Ke i(IdentifiersResult identifiersResult) {
        return a(d.b, identifiersResult);
    }

    public final Ke j(IdentifiersResult identifiersResult) {
        return a(s.b, identifiersResult);
    }

    public final Ke g(IdentifiersResult identifiersResult) {
        return a(r.b, identifiersResult);
    }

    public final Ke a(IdentifiersResult identifiersResult) {
        return a(g.b, identifiersResult);
    }

    public final Ke b(boolean z) {
        return (Ke) b(t.b, z);
    }

    public final Ke d(long j2) {
        return (Ke) b(p.b, j2);
    }

    public final Ke e(long j2) {
        return (Ke) b(j.b, j2);
    }

    public final String i(String str) {
        return this.f11258a.getString(m.b, str);
    }

    public final Ke j(String str) {
        return (Ke) b(m.b, str);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4564xd
    public final String f(String str) {
        return new Ne(str, null).b;
    }

    public final Ke a(List<String> list) {
        return (Ke) b(i.b, In.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
    }

    public final Ke h(IdentifiersResult identifiersResult) {
        return a(k.b, identifiersResult);
    }

    public final Ke a(C4038ca c4038ca) {
        String str = w.b;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("libSslEnabled", c4038ca.f11492a).put("STATUS", c4038ca.b.getValue()).putOpt("ERROR_EXPLANATION", c4038ca.c);
        } catch (Throwable unused) {
        }
        return (Ke) b(str, jSONObject.toString());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4564xd
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final Ke g(String str) {
        return (Ke) d(new Ne(str, null).b);
    }

    public final void a(ScreenInfo screenInfo) {
        b(u.b, AbstractC4288mb.a(screenInfo));
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        b(x.b, appMetricaConfig.toJson());
    }

    public final Ke a(String str, IdentifiersResult identifiersResult) {
        String string;
        if (identifiersResult != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ID", identifiersResult.id).put("STATUS", identifiersResult.status.getValue()).put("ERROR_EXPLANATION", identifiersResult.errorExplanation);
                } catch (Throwable unused) {
                }
                string = jSONObject.toString();
            } catch (Throwable unused2) {
                string = null;
            }
        } else {
            string = null;
        }
        if (string != null) {
            b(str, string);
        }
        return this;
    }
}
