package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class c2 {
    public static final c2 A;
    public static final c2 A0;
    public static final c2 B;
    public static final c2 B0;
    public static final c2 C;
    public static final c2 C0;
    public static final c2 D;
    public static final c2 D0;
    public static final c2 E;
    public static final c2 E0;
    public static final c2 F;
    public static final c2 F0;
    public static final c2 G;
    public static final c2 G0;
    public static final c2 H;
    public static final c2 H0;
    public static final c2 I;
    public static final c2 I0;
    public static final c2 J;
    public static final c2 J0;
    public static final c2 K;
    public static final c2 K0;
    public static final c2 L;
    public static final c2 L0;
    public static final c2 M;
    public static final c2 M0;
    public static final c2 N;
    public static final c2 N0;
    public static final c2 O;
    public static final c2 P;
    public static final c2 Q;
    public static final c2 R;
    public static final c2 S;
    public static final c2 T;
    public static final c2 U;
    public static final c2 V;
    public static final c2 W;
    public static final c2 X;
    public static final c2 Y;
    public static final c2 Z;
    public static final c2 a0;
    public static final c2 b0;
    private static JSONObject c;
    public static final c2 c0;
    public static final c2 d;
    public static final c2 d0;
    public static final c2 e;
    public static final c2 e0;
    public static final c2 f;
    public static final c2 f0;
    public static final c2 g;
    public static final c2 g0;
    public static final c2 h;
    public static final c2 h0;
    public static final c2 i;
    public static final c2 i0;
    public static final c2 j;
    public static final c2 j0;
    public static final c2 k;
    public static final c2 k0;
    public static final c2 l;
    public static final c2 l0;
    public static final c2 m;
    public static final c2 m0;
    public static final c2 n;
    public static final c2 n0;
    public static final c2 o;
    public static final c2 o0;
    public static final c2 p;
    public static final c2 p0;
    public static final c2 q;
    public static final c2 q0;
    public static final c2 r;
    public static final c2 r0;
    public static final c2 s;
    public static final c2 s0;
    public static final c2 t;
    public static final c2 t0;
    public static final c2 u;
    public static final c2 u0;
    public static final c2 v;
    public static final c2 v0;
    public static final c2 w;
    public static final c2 w0;
    public static final c2 x;
    public static final c2 x0;
    public static final c2 y;
    public static final c2 y0;
    public static final c2 z;
    public static final c2 z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f374a;
    private final b b;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f375a;

        static {
            int[] iArr = new int[b.values().length];
            f375a = iArr;
            try {
                iArr[b.AD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f375a[b.MEDIATED_AD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f375a[b.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f375a[b.USER_SESSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum b {
        AD,
        MEDIATED_AD,
        ERROR,
        USER_SESSION
    }

    static {
        b bVar = b.ERROR;
        d = new c2("generic", bVar);
        b bVar2 = b.USER_SESSION;
        e = new c2("sdk_init", bVar2);
        f = new c2("fetch_basic_settings_started", bVar2);
        g = new c2("fetch_basic_settings_success", bVar2);
        h = new c2("fetch_basic_settings_failure", bVar2);
        i = new c2("pub_init_callback", bVar2);
        j = new c2("sdk_extra_parameter_set", bVar2);
        b bVar3 = b.AD;
        k = new c2("ad_requested", bVar3);
        l = new c2("ad_request_success", bVar3);
        m = new c2("ad_request_failure", bVar3);
        n = new c2("ad_load_success", bVar3);
        o = new c2("ad_load_failure", bVar3);
        p = new c2("ad_display_attempted", bVar3);
        q = new c2("ad_displayed", bVar3);
        r = new c2("ad_reshown", bVar3);
        s = new c2("ad_display_failure", bVar3);
        t = new c2("ad_hidden", bVar3);
        u = new c2("reward_reporting_error", bVar3);
        v = new c2("reward_validation_error", bVar3);
        w = new c2("user_not_rewarded", bVar3);
        x = new c2("resource_load_started", bVar3);
        y = new c2("resource_retrieved_from_cache", bVar3);
        z = new c2("resource_load_success", bVar3);
        A = new c2("resource_load_failure", bVar3);
        B = new c2("resource_download_started", bVar3);
        C = new c2("resource_stream_loaded", bVar3);
        D = new c2("resource_download_success", bVar3);
        E = new c2("resource_download_failure", bVar3);
        F = new c2("ad_persist_request", bVar3);
        G = new c2("ad_persist_success", bVar3);
        H = new c2("ad_persist_failure", bVar3);
        I = new c2("persisted_ad_requested", bVar3);
        J = new c2("persisted_ad_load_success", bVar3);
        K = new c2("persisted_ad_load_failure", bVar3);
        L = new c2("persisted_ad_expired", bVar3);
        M = new c2("custom_intent_launch_success", bVar3);
        N = new c2("custom_intent_launch_failure", bVar3);
        b bVar4 = b.MEDIATED_AD;
        O = new c2("adapter_init_started", bVar4);
        P = new c2("adapter_init_success", bVar4);
        Q = new c2("adapter_init_failure", bVar4);
        R = new c2("signal_collection_success", bVar4);
        S = new c2("signal_collection_failure", bVar4);
        T = new c2("mediated_ad_requested", bVar4);
        U = new c2("mediated_ad_request_success", bVar4);
        V = new c2("mediated_ad_request_failure", bVar4);
        W = new c2("mediated_ad_load_started", bVar4);
        X = new c2("mediated_ad_load_success", bVar4);
        Y = new c2("mediated_ad_load_failure", bVar4);
        Z = new c2("waterfall_processing_complete", bVar4);
        a0 = new c2("mediated_ad_display_attempted", bVar4);
        b0 = new c2("mediated_ad_displayed", bVar4);
        c0 = new c2("mediated_ad_viewability_impression_called", bVar4);
        d0 = new c2("mediated_ad_display_failure", bVar4);
        e0 = new c2("mediated_ad_hidden", bVar4);
        f0 = new c2("mediated_ad_hidden_callback_not_called", bVar4);
        g0 = new c2("mediated_ad_reward_reporting_error", bVar4);
        h0 = new c2("mediated_ad_reward_validation_error", bVar4);
        i0 = new c2("user_not_rewarded_for_mediated_ad", bVar4);
        j0 = new c2("mediated_ad_extra_parameter_set", bVar4);
        k0 = new c2("mediated_ad_failover_missing_cached_ad", bVar4);
        l0 = new c2("mediated_ad_failover_attempted", bVar4);
        m0 = new c2("mediated_ad_failover_success", bVar4);
        n0 = new c2("mediated_ad_failover_failure", bVar4);
        o0 = new c2("activity_destroyed_by_app_relaunch", bVar);
        p0 = new c2("activity_missing", bVar);
        q0 = new c2("ad_context_violation", bVar);
        r0 = new c2("anr", bVar);
        s0 = new c2("app_exit_info_stack_trace", bVar);
        t0 = new c2("app_killed_during_ad", bVar);
        u0 = new c2("app_killed_during_mediated_ad", bVar);
        v0 = new c2("array_error", bVar);
        w0 = new c2("auto_redirect", bVar);
        x0 = new c2("black_view_detected", bVar);
        y0 = new c2("black_view", bVar);
        z0 = new c2("cache_error", bVar);
        A0 = new c2("caught_exception", bVar);
        B0 = new c2("consent_flow_error", bVar);
        C0 = new c2("crash", bVar);
        D0 = new c2("file_error", bVar);
        E0 = new c2("integration_error", bVar);
        F0 = new c2("media_error", bVar);
        G0 = new c2("memory_leak", bVar);
        H0 = new c2("native_error", bVar);
        I0 = new c2("network_error", bVar);
        J0 = new c2("task_exception", bVar);
        K0 = new c2("task_latency_alert", bVar);
        L0 = new c2("template_error", bVar);
        M0 = new c2("unexpected_state", bVar);
        N0 = new c2("web_view_error", bVar);
    }

    public c2(String str, b bVar) {
        this.f374a = str;
        this.b = bVar;
    }

    public b a() {
        return this.b;
    }

    public String b() {
        return this.f374a;
    }

    public double a(com.applovin.impl.sdk.k kVar) {
        if (k7.k(com.applovin.impl.sdk.k.o())) {
            return 100.0d;
        }
        double dA = a(this.f374a, kVar);
        if (dA >= 0.0d) {
            return dA;
        }
        double dA2 = a(this.b, kVar);
        return dA2 >= 0.0d ? dA2 : ((Float) kVar.a(v4.F)).floatValue();
    }

    private double a(String str, com.applovin.impl.sdk.k kVar) {
        if (c == null) {
            c = JsonUtils.deserialize((String) kVar.a(v4.B));
        }
        Double d2 = JsonUtils.getDouble(c, str, (Double) null);
        if (d2 != null) {
            return d2.doubleValue();
        }
        return -1.0d;
    }

    private double a(b bVar, com.applovin.impl.sdk.k kVar) {
        float fFloatValue;
        int i2 = a.f375a[bVar.ordinal()];
        if (i2 == 1 || i2 == 2) {
            fFloatValue = ((Float) kVar.a(v4.C)).floatValue();
        } else if (i2 == 3) {
            fFloatValue = ((Float) kVar.a(v4.D)).floatValue();
        } else {
            if (i2 != 4) {
                return -1.0d;
            }
            fFloatValue = ((Float) kVar.a(v4.E)).floatValue();
        }
        return fFloatValue;
    }
}
