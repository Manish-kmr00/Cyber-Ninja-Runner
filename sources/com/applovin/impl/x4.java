package com.applovin.impl;

import com.smaato.sdk.core.gdpr.CmpApiConstants;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f743a;
    private final Class b;
    public static final x4 c = new x4("com.applovin.sdk.impl.isFirstRun", String.class);
    public static final x4 d = new x4("com.applovin.sdk.launched_before", Boolean.class);
    public static final x4 e = new x4("com.applovin.sdk.launch_count", Long.class);
    public static final x4 f = new x4("com.applovin.sdk.last_launch_timestamp", Long.class);
    public static final x4 g = new x4("com.applovin.sdk.latest_installed_version", String.class);
    public static final x4 h = new x4("com.applovin.sdk.install_date", Long.class);
    public static final x4 i = new x4("com.applovin.sdk.save_settings_with_sdk_key_agnostic_name", Boolean.class);
    public static final x4 j = new x4("com.applovin.sdk.user_id", String.class);
    public static final x4 k = new x4("com.applovin.sdk.compass_random_token", String.class);
    public static final x4 l = new x4("com.applovin.sdk.applovin_random_token", String.class);
    public static final x4 m = new x4("com.applovin.sdk.alart", String.class);
    public static final x4 n = new x4("com.applovin.sdk.aleid", String.class);
    public static final x4 o = new x4("com.applovin.sdk.device_test_group", String.class);
    public static final x4 p = new x4("com.applovin.sdk.compliance.has_user_consent", Boolean.class);
    public static final x4 q = new x4("com.applovin.sdk.compliance.is_age_restricted_user", Boolean.class);
    public static final x4 r = new x4("com.applovin.sdk.compliance.is_do_not_sell", Boolean.class);
    public static final x4 s = new x4("com.applovin.sdk.has_seen_but_not_accepted_privacy_policy", Boolean.class);
    public static final x4 t = new x4(CmpApiConstants.IABTCF_CMP_SDK_ID, Object.class);
    public static final x4 u = new x4(CmpApiConstants.IABTCF_CMP_SDK_VERSION, Object.class);
    public static final x4 v = new x4("IABTCF_gdprApplies", Object.class);
    public static final x4 w = new x4("IABTCF_TCString", String.class);
    public static final x4 x = new x4("IABTCF_AddtlConsent", String.class);
    public static final x4 y = new x4(CmpApiConstants.IABTCF_VENDOR_CONSENT, String.class);
    public static final x4 z = new x4(CmpApiConstants.IABTCF_VENDOR_LEGITIMATE_INTERESTS, String.class);
    public static final x4 A = new x4(CmpApiConstants.IABTCF_PURPOSE_CONSENTS, String.class);
    public static final x4 B = new x4(CmpApiConstants.IABTCF_PURPOSE_LEGITIMATE_INTERESTS, String.class);
    public static final x4 C = new x4(CmpApiConstants.IABTCF_SPECIAL_FEATURES_OPT_INS, String.class);
    public static final x4 D = new x4("com.applovin.sdk.impl.ad.persistence.queue", String.class);
    public static final x4 E = new x4("com.applovin.sdk.mediation.signal_providers", String.class);
    public static final x4 F = new x4("com.applovin.sdk.mediation.auto_init_adapters", String.class);
    public static final x4 G = new x4("com.applovin.sdk.persisted_data", String.class);
    public static final x4 H = new x4("com.applovin.sdk.mediation.test_mode_enabled", Boolean.class);
    public static final x4 I = new x4("com.applovin.sdk.mediation.should_use_applovin_adaptive_sizing_formula", Boolean.class);
    public static final x4 J = new x4("com.applovin.sdk.mediation.stats_per_ad_unit_since_install", String.class);
    public static final x4 K = new x4("com.applovin.sdk.mediation.stats_per_ad_format_since_install", String.class);
    public static final x4 L = new x4("com.applovin.sdk.user_agent", String.class);
    public static final x4 M = new x4("com.applovin.sdk.last_fullscreen_ad_timestamp_ms", Long.class);
    public static final x4 N = new x4("com.applovin.sdk.last_fullscreen_ad_duration_ms", Long.class);
    public static final x4 O = new x4("com.applovin.sdk.app_killed_urls_from_last_ad", String.class);
    public static final x4 P = new x4("com.applovin.sdk.app_killed_last_ad_data", String.class);
    public static final x4 Q = new x4("com.applovin.sdk.app_killed_last_mediated_ad_tracking_info", String.class);
    public static final x4 R = new x4("com.applovin.sdk.last_mediated_fullscreen_ad_duration_ms", Long.class);
    public static final x4 S = new x4("com.applovin.sdk.template_browser_package_name", String.class);

    public x4(String str, Class cls) {
        this.f743a = str;
        this.b = cls;
    }

    public String a() {
        return this.f743a;
    }

    public Class b() {
        return this.b;
    }

    public String toString() {
        return "Key{name='" + this.f743a + "', type=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
