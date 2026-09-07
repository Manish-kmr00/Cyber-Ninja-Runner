package com.yandex.mobile.ads.impl;

import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class pu1 implements ar1<cu1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f9951a;
    private final ar1<String> b;
    private final s32 c;
    private final j50 d;
    private final fl e;
    private final d60 f;
    private final u6 g;

    public pu1(lp1 reporter, ar1<String> stringResponseParser, s32 systemCurrentTimeProvider, j50 encryptionParametersParser, fl biddingSettingsDataParser, d60 exclusionRulesJsonConverter, u6 adQualityAdVerificationConfigurationJsonConverter) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(stringResponseParser, "stringResponseParser");
        Intrinsics.checkNotNullParameter(systemCurrentTimeProvider, "systemCurrentTimeProvider");
        Intrinsics.checkNotNullParameter(encryptionParametersParser, "encryptionParametersParser");
        Intrinsics.checkNotNullParameter(biddingSettingsDataParser, "biddingSettingsDataParser");
        Intrinsics.checkNotNullParameter(exclusionRulesJsonConverter, "exclusionRulesJsonConverter");
        Intrinsics.checkNotNullParameter(adQualityAdVerificationConfigurationJsonConverter, "adQualityAdVerificationConfigurationJsonConverter");
        this.f9951a = reporter;
        this.b = stringResponseParser;
        this.c = systemCurrentTimeProvider;
        this.d = encryptionParametersParser;
        this.e = biddingSettingsDataParser;
        this.f = exclusionRulesJsonConverter;
        this.g = adQualityAdVerificationConfigurationJsonConverter;
    }

    private static Long a(JSONObject jsonObject) {
        Long l;
        Object objOpt;
        Object objM7904constructorimpl;
        rq0 rq0Var = rq0.f10131a;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter("ad_blocker_status_validity_duration", "name");
        if (!jsonObject.has("ad_blocker_status_validity_duration") || (objOpt = jsonObject.opt("ad_blocker_status_validity_duration")) == null) {
            l = null;
        } else {
            rq0 rq0Var2 = rq0.f10131a;
            String strValueOf = String.valueOf(objOpt);
            rq0Var2.getClass();
            try {
                Result.Companion companion = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(Long.valueOf(Long.parseLong(strValueOf)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
                objM7904constructorimpl = null;
            }
            l = (Long) objM7904constructorimpl;
        }
        if (l != null) {
            return Long.valueOf(l.longValue() * 1000);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0287  */
    /* JADX WARN: Code duplicated, block: B:47:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:48:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:51:0x02c9 A[Catch: JSONException -> 0x057d, TryCatch #4 {JSONException -> 0x057d, blocks: (B:6:0x001c, B:8:0x006f, B:10:0x007a, B:12:0x00c6, B:14:0x00d1, B:16:0x0106, B:18:0x010e, B:20:0x0189, B:22:0x0192, B:24:0x01a1, B:26:0x01a9, B:29:0x01c4, B:32:0x01d1, B:37:0x0281, B:40:0x0288, B:45:0x02a7, B:49:0x02b3, B:51:0x02c9, B:53:0x02d5, B:58:0x030e, B:61:0x0315, B:66:0x0334, B:69:0x033b, B:71:0x0376, B:72:0x037a, B:65:0x032a, B:57:0x0304, B:44:0x029d, B:36:0x0277, B:54:0x02f2, B:33:0x0265, B:62:0x0318, B:41:0x028b), top: B:86:0x001c, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:60:0x0314  */
    /* JADX WARN: Code duplicated, block: B:68:0x033a  */
    /* JADX WARN: Code duplicated, block: B:71:0x0376 A[Catch: JSONException -> 0x057d, TryCatch #4 {JSONException -> 0x057d, blocks: (B:6:0x001c, B:8:0x006f, B:10:0x007a, B:12:0x00c6, B:14:0x00d1, B:16:0x0106, B:18:0x010e, B:20:0x0189, B:22:0x0192, B:24:0x01a1, B:26:0x01a9, B:29:0x01c4, B:32:0x01d1, B:37:0x0281, B:40:0x0288, B:45:0x02a7, B:49:0x02b3, B:51:0x02c9, B:53:0x02d5, B:58:0x030e, B:61:0x0315, B:66:0x0334, B:69:0x033b, B:71:0x0376, B:72:0x037a, B:65:0x032a, B:57:0x0304, B:44:0x029d, B:36:0x0277, B:54:0x02f2, B:33:0x0265, B:62:0x0318, B:41:0x028b), top: B:86:0x001c, inners: #0, #1, #2, #3 }] */
    @Override // com.yandex.mobile.ads.impl.ar1
    public final cu1 a(pq1 networkResponse) {
        el elVar;
        i50 i50Var;
        Object objM7904constructorimpl;
        Object objM7904constructorimpl2;
        JSONArray jSONArrayOptJSONArray;
        Set<b60> setA;
        Object objM7904constructorimpl3;
        Object objM7904constructorimpl4;
        List<String> listC;
        JSONObject jSONObjectOptJSONObject;
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        String strA = this.b.a(networkResponse);
        if (strA != null && strA.length() > 0) {
            try {
                JSONObject jsonObject = new JSONObject(strA);
                Long lA = a(jsonObject);
                boolean zOptBoolean = jsonObject.optBoolean("aab_disabled");
                boolean zOptBoolean2 = jsonObject.optBoolean("autograb_enabled");
                boolean zOptBoolean3 = jsonObject.optBoolean("custom_click_handling_enabled");
                boolean zOptBoolean4 = jsonObject.optBoolean("legacy_visibility_logic_enabled");
                boolean zOptBoolean5 = jsonObject.optBoolean("legacy_vast_tracking_enabled");
                boolean zOptBoolean6 = jsonObject.optBoolean("overlapping_view_tracking_enabled");
                boolean zOptBoolean7 = jsonObject.optBoolean("overlapping_window_tracking_enabled");
                boolean zOptBoolean8 = jsonObject.optBoolean("open_measurement_sdk_disabled");
                boolean zOptBoolean9 = jsonObject.optBoolean("multibanner_arrow_controls_disabled");
                rq0 rq0Var = rq0.f10131a;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                Intrinsics.checkNotNullParameter("visibility_error_indicator_enabled", "name");
                Boolean boolValueOf = jsonObject.has("visibility_error_indicator_enabled") ? Boolean.valueOf(jsonObject.optBoolean("visibility_error_indicator_enabled")) : null;
                String strOptString = jsonObject.optString("mraid_controller", null);
                String strOptString2 = jsonObject.optString("open_measurement_sdk_controller", null);
                String strOptString3 = jsonObject.optString("click_handler_type", null);
                String strOptString4 = jsonObject.optString("ad_host", null);
                String strOptString5 = jsonObject.optString("divkit_font", null);
                String strOptString6 = jsonObject.optString("instream_design", null);
                boolean zOptBoolean10 = jsonObject.optBoolean("sensitive_mode_disabled");
                boolean zOptBoolean11 = jsonObject.optBoolean("hard_sensitive_mode_enabled");
                boolean zOptBoolean12 = jsonObject.optBoolean("encrypted_requests_enabled");
                Boolean boolValueOf2 = jsonObject.has("mediation_sensitive_mode_disabled") ? Boolean.valueOf(jsonObject.optBoolean("mediation_sensitive_mode_disabled")) : null;
                boolean zOptBoolean13 = jsonObject.optBoolean("fused_location_provider_disabled");
                boolean zOptBoolean14 = jsonObject.optBoolean("lock_screen_enabled");
                boolean zOptBoolean15 = jsonObject.optBoolean("impression_validation_on_click_enabled");
                boolean zOptBoolean16 = jsonObject.optBoolean("legacy_slider_impression_enabled");
                long jOptLong = jsonObject.optLong("reload_timeout");
                this.c.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis() + (jOptLong > 0 ? jOptLong * 1000 : 86400000L);
                int iOptInt = jsonObject.optInt("ad_ids_storage_size");
                int iOptInt2 = jsonObject.optInt("native_web_view_pool_size");
                long jOptLong2 = jsonObject.optLong("max_disk_cache_size_bytes_for_video");
                long jOptLong3 = jsonObject.optLong("max_disk_cache_size_bytes_for_request_queue");
                Integer numB = rq0.b("ad_request_max_retries", jsonObject);
                Boolean bool = boolValueOf2;
                Integer numB2 = rq0.b("ping_request_max_retries", jsonObject);
                Boolean bool2 = boolValueOf;
                boolean zOptBoolean17 = jsonObject.optBoolean("show_version_validation_error_log", false);
                boolean zOptBoolean18 = jsonObject.optBoolean("show_version_validation_error_indicator", false);
                boolean zOptBoolean19 = jsonObject.optBoolean("fullscreen_back_button_enabled", false);
                boolean zOptBoolean20 = jsonObject.optBoolean("divkit_disabled", false);
                boolean zOptBoolean21 = jsonObject.optBoolean("use_okhttp_network_stack", false);
                boolean zOptBoolean22 = jsonObject.optBoolean("location_consent", false);
                boolean zOptBoolean23 = jsonObject.optBoolean("libssl_enabled", false);
                JSONObject jSONObjectOptJSONObject2 = jsonObject.optJSONObject("bidding_settings");
                el elVarB = jSONObjectOptJSONObject2 != null ? this.e.b(jSONObjectOptJSONObject2) : null;
                JSONObject jSONObjectOptJSONObject3 = jsonObject.optJSONObject("encryption");
                this.d.getClass();
                try {
                    try {
                        try {
                            try {
                                if (jSONObjectOptJSONObject3 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("rsa")) != null) {
                                    elVar = elVarB;
                                    String strOptString7 = jSONObjectOptJSONObject.optString("public_key", "");
                                    Integer numB3 = rq0.b("version", jSONObjectOptJSONObject);
                                    Intrinsics.checkNotNull(strOptString7);
                                    if (strOptString7.length() > 0 && numB3 != null) {
                                        i50Var = new i50(numB3.intValue(), strOptString7);
                                    }
                                    i50 i50Var2 = i50Var;
                                    boolean zOptBoolean24 = jsonObject.optBoolean("legacy_impression_callback_enabled", false);
                                    boolean zOptBoolean25 = jsonObject.optBoolean("close_fullscreen_with_adtune_disabled", false);
                                    boolean zOptBoolean26 = jsonObject.optBoolean("render_asset_validation_enabled", false);
                                    boolean zOptBoolean27 = jsonObject.optBoolean("automatic_sdk_initialization_delay_enabled", false);
                                    boolean zOptBoolean28 = jsonObject.optBoolean("native_banner_enabled", false);
                                    boolean zOptBoolean29 = jsonObject.optBoolean("use_divkit_close_action_instead_system_click", false);
                                    String strOptString8 = jsonObject.optString("banner_size_calculation_type", null);
                                    String strOptString9 = jsonObject.optString("startup_version", null);
                                    boolean zOptBoolean30 = jsonObject.optBoolean("app_open_ad_preloading_enabled", false);
                                    boolean zOptBoolean31 = jsonObject.optBoolean("interstitial_preloading_enabled", false);
                                    boolean zOptBoolean32 = jsonObject.optBoolean("rewarded_preloading_enabled", false);
                                    boolean zOptBoolean33 = jsonObject.optBoolean("new_false_click_tracking_enabled", false);
                                    boolean zOptBoolean34 = jsonObject.optBoolean("varioqub_enabled", false);
                                    boolean zOptBoolean35 = jsonObject.optBoolean("aab_http_check_disabled", false);
                                    Integer numB4 = rq0.b("aab_http_check_failed_requests_count", jsonObject);
                                    boolean zOptBoolean36 = jsonObject.optBoolean("crash_tracker_enabled", false);
                                    boolean zOptBoolean37 = jsonObject.optBoolean("error_tracker_enabled", false);
                                    boolean zOptBoolean38 = jsonObject.optBoolean("anr_tracker_enabled", false);
                                    Result.Companion companion = Result.INSTANCE;
                                    objM7904constructorimpl = Result.m7904constructorimpl(Long.valueOf(jsonObject.getLong("anr_tracker_interval")));
                                    if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
                                        objM7904constructorimpl = null;
                                    }
                                    Long l = (Long) objM7904constructorimpl;
                                    Result.Companion companion2 = Result.INSTANCE;
                                    objM7904constructorimpl2 = Result.m7904constructorimpl(Long.valueOf(jsonObject.getLong("anr_tracker_threshold")));
                                    if (Result.m7910isFailureimpl(objM7904constructorimpl2)) {
                                        objM7904constructorimpl2 = null;
                                    }
                                    Long l2 = (Long) objM7904constructorimpl2;
                                    boolean zOptBoolean39 = jsonObject.optBoolean("crash_ignore_enabled", false);
                                    jSONArrayOptJSONArray = jsonObject.optJSONArray("crash_stack_trace_exclusion_rules");
                                    if (jSONArrayOptJSONArray != null) {
                                        this.f.getClass();
                                        setA = d60.a(jSONArrayOptJSONArray);
                                    } else {
                                        setA = null;
                                    }
                                    Set<b60> set = setA;
                                    boolean zOptBoolean40 = jsonObject.optBoolean("time_stamping_tracking_urls_enabled", false);
                                    boolean zOptBoolean41 = jsonObject.optBoolean("app_ad_analytics_reporting_enabled", true);
                                    boolean zOptBoolean42 = jsonObject.optBoolean("app_metrica_easy_integration_auto_activation_disabled", false);
                                    Result.Companion companion3 = Result.INSTANCE;
                                    objM7904constructorimpl3 = Result.m7904constructorimpl(Integer.valueOf(jsonObject.getInt("network_thread_pool_size")));
                                    if (Result.m7910isFailureimpl(objM7904constructorimpl3)) {
                                        objM7904constructorimpl3 = null;
                                    }
                                    Integer num = (Integer) objM7904constructorimpl3;
                                    Result.Companion companion4 = Result.INSTANCE;
                                    objM7904constructorimpl4 = Result.m7904constructorimpl(Integer.valueOf(jsonObject.getInt("image_loading_thread_pool_size")));
                                    if (Result.m7910isFailureimpl(objM7904constructorimpl4)) {
                                        objM7904constructorimpl4 = null;
                                    }
                                    Integer num2 = (Integer) objM7904constructorimpl4;
                                    Integer numB5 = rq0.b("timeout_interval_for_request", jsonObject);
                                    Integer numB6 = rq0.b("timeout_interval_for_ping_request", jsonObject);
                                    u6 u6Var = this.g;
                                    JSONObject jSONObjectOptJSONObject4 = jsonObject.optJSONObject("verification_configuration");
                                    u6Var.getClass();
                                    b7 b7VarA = u6.a(jSONObjectOptJSONObject4);
                                    boolean zOptBoolean43 = jsonObject.optBoolean("sdk_tracking_reporter_enabled", false);
                                    rq0.f10131a.getClass();
                                    listC = rq0.c("fallback_hosts", jsonObject);
                                    if (listC == null) {
                                        listC = CollectionsKt.emptyList();
                                    }
                                    List<String> list = listC;
                                    boolean zOptBoolean44 = jsonObject.optBoolean("should_prefetch_dns", false);
                                    boolean zOptBoolean45 = jsonObject.optBoolean("should_use_ad_rendered_web_view_callback", false);
                                    boolean zOptBoolean46 = jsonObject.optBoolean("vpn_checking_enabled", false);
                                    boolean zOptBoolean47 = jsonObject.optBoolean("outstream_wrapper_video_supported", false);
                                    cu1.a aVarR = new cu1.a().b(numB).e(numB2).a(lA).c(zOptBoolean).g(zOptBoolean2).a(iOptInt).b(iOptInt2).c(jOptLong2).b(jOptLong3).a(jCurrentTimeMillis).f(strOptString).g(strOptString2).l(zOptBoolean3).b(strOptString8).d(bool2).h("7.12.1").A(zOptBoolean14).b(bool).L(zOptBoolean10).s(zOptBoolean11).r(zOptBoolean13);
                                    int i = iw1.l;
                                    return aVarR.c(iw1.a.a().j()).a(iw1.a.a().f()).x(zOptBoolean4).i(zOptBoolean25).w(zOptBoolean5).G(zOptBoolean6).H(zOptBoolean7).E(zOptBoolean8).B(zOptBoolean9).t(zOptBoolean15).v(zOptBoolean16).O(zOptBoolean17).N(zOptBoolean18).e(strOptString6).q(zOptBoolean19).a(elVar).a(i50Var2).n(zOptBoolean24).m(zOptBoolean20).S(zOptBoolean21).z(zOptBoolean22).y(zOptBoolean23).a(strOptString4).d(strOptString5).o(zOptBoolean12).I(zOptBoolean26).c(strOptString3).h(zOptBoolean27).C(zOptBoolean28).R(zOptBoolean29).i(strOptString9).f(zOptBoolean30).u(zOptBoolean31).J(zOptBoolean32).D(zOptBoolean33).T(zOptBoolean34).a(zOptBoolean35).a(numB4).k(zOptBoolean36).p(zOptBoolean37).b(zOptBoolean38).b(l).c(l2).j(zOptBoolean39).a(set).Q(zOptBoolean40).d(zOptBoolean41).e(zOptBoolean42).d(num).c(num2).g(numB5).f(numB6).a(b7VarA).K(zOptBoolean43).a(list).M(zOptBoolean44).P(zOptBoolean45).U(zOptBoolean46).F(zOptBoolean47).a();
                                }
                                elVar = elVarB;
                                Result.Companion companion5 = Result.INSTANCE;
                                objM7904constructorimpl3 = Result.m7904constructorimpl(Integer.valueOf(jsonObject.getInt("network_thread_pool_size")));
                            } catch (Throwable th) {
                                Result.Companion companion6 = Result.INSTANCE;
                                objM7904constructorimpl3 = Result.m7904constructorimpl(ResultKt.createFailure(th));
                            }
                            Result.Companion companion7 = Result.INSTANCE;
                            objM7904constructorimpl = Result.m7904constructorimpl(Long.valueOf(jsonObject.getLong("anr_tracker_interval")));
                        } catch (Throwable th2) {
                            Result.Companion companion8 = Result.INSTANCE;
                            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th2));
                        }
                        Result.Companion companion9 = Result.INSTANCE;
                        objM7904constructorimpl4 = Result.m7904constructorimpl(Integer.valueOf(jsonObject.getInt("image_loading_thread_pool_size")));
                    } catch (Throwable th3) {
                        Result.Companion companion10 = Result.INSTANCE;
                        objM7904constructorimpl4 = Result.m7904constructorimpl(ResultKt.createFailure(th3));
                    }
                    Result.Companion companion11 = Result.INSTANCE;
                    objM7904constructorimpl2 = Result.m7904constructorimpl(Long.valueOf(jsonObject.getLong("anr_tracker_threshold")));
                } catch (Throwable th4) {
                    Result.Companion companion12 = Result.INSTANCE;
                    objM7904constructorimpl2 = Result.m7904constructorimpl(ResultKt.createFailure(th4));
                }
                i50Var = null;
                i50 i50Var3 = i50Var;
                boolean zOptBoolean210 = jsonObject.optBoolean("legacy_impression_callback_enabled", false);
                boolean zOptBoolean211 = jsonObject.optBoolean("close_fullscreen_with_adtune_disabled", false);
                boolean zOptBoolean212 = jsonObject.optBoolean("render_asset_validation_enabled", false);
                boolean zOptBoolean213 = jsonObject.optBoolean("automatic_sdk_initialization_delay_enabled", false);
                boolean zOptBoolean214 = jsonObject.optBoolean("native_banner_enabled", false);
                boolean zOptBoolean215 = jsonObject.optBoolean("use_divkit_close_action_instead_system_click", false);
                String strOptString10 = jsonObject.optString("banner_size_calculation_type", null);
                String strOptString11 = jsonObject.optString("startup_version", null);
                boolean zOptBoolean310 = jsonObject.optBoolean("app_open_ad_preloading_enabled", false);
                boolean zOptBoolean311 = jsonObject.optBoolean("interstitial_preloading_enabled", false);
                boolean zOptBoolean312 = jsonObject.optBoolean("rewarded_preloading_enabled", false);
                boolean zOptBoolean313 = jsonObject.optBoolean("new_false_click_tracking_enabled", false);
                boolean zOptBoolean314 = jsonObject.optBoolean("varioqub_enabled", false);
                boolean zOptBoolean315 = jsonObject.optBoolean("aab_http_check_disabled", false);
                Integer numB7 = rq0.b("aab_http_check_failed_requests_count", jsonObject);
                boolean zOptBoolean316 = jsonObject.optBoolean("crash_tracker_enabled", false);
                boolean zOptBoolean317 = jsonObject.optBoolean("error_tracker_enabled", false);
                boolean zOptBoolean318 = jsonObject.optBoolean("anr_tracker_enabled", false);
                if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
                    objM7904constructorimpl = null;
                }
                Long l3 = (Long) objM7904constructorimpl;
                if (Result.m7910isFailureimpl(objM7904constructorimpl2)) {
                    objM7904constructorimpl2 = null;
                }
                Long l4 = (Long) objM7904constructorimpl2;
                boolean zOptBoolean319 = jsonObject.optBoolean("crash_ignore_enabled", false);
                jSONArrayOptJSONArray = jsonObject.optJSONArray("crash_stack_trace_exclusion_rules");
                if (jSONArrayOptJSONArray != null) {
                    this.f.getClass();
                    setA = d60.a(jSONArrayOptJSONArray);
                } else {
                    setA = null;
                }
                Set<b60> set2 = setA;
                boolean zOptBoolean48 = jsonObject.optBoolean("time_stamping_tracking_urls_enabled", false);
                boolean zOptBoolean49 = jsonObject.optBoolean("app_ad_analytics_reporting_enabled", true);
                boolean zOptBoolean410 = jsonObject.optBoolean("app_metrica_easy_integration_auto_activation_disabled", false);
                if (Result.m7910isFailureimpl(objM7904constructorimpl3)) {
                    objM7904constructorimpl3 = null;
                }
                Integer num3 = (Integer) objM7904constructorimpl3;
                if (Result.m7910isFailureimpl(objM7904constructorimpl4)) {
                    objM7904constructorimpl4 = null;
                }
                Integer num4 = (Integer) objM7904constructorimpl4;
                Integer numB8 = rq0.b("timeout_interval_for_request", jsonObject);
                Integer numB9 = rq0.b("timeout_interval_for_ping_request", jsonObject);
                u6 u6Var2 = this.g;
                JSONObject jSONObjectOptJSONObject5 = jsonObject.optJSONObject("verification_configuration");
                u6Var2.getClass();
                b7 b7VarA2 = u6.a(jSONObjectOptJSONObject5);
                boolean zOptBoolean411 = jsonObject.optBoolean("sdk_tracking_reporter_enabled", false);
                rq0.f10131a.getClass();
                listC = rq0.c("fallback_hosts", jsonObject);
                if (listC == null) {
                    listC = CollectionsKt.emptyList();
                }
                List<String> list2 = listC;
                boolean zOptBoolean412 = jsonObject.optBoolean("should_prefetch_dns", false);
                boolean zOptBoolean413 = jsonObject.optBoolean("should_use_ad_rendered_web_view_callback", false);
                boolean zOptBoolean414 = jsonObject.optBoolean("vpn_checking_enabled", false);
                boolean zOptBoolean415 = jsonObject.optBoolean("outstream_wrapper_video_supported", false);
                cu1.a aVarR2 = new cu1.a().b(numB).e(numB2).a(lA).c(zOptBoolean).g(zOptBoolean2).a(iOptInt).b(iOptInt2).c(jOptLong2).b(jOptLong3).a(jCurrentTimeMillis).f(strOptString).g(strOptString2).l(zOptBoolean3).b(strOptString10).d(bool2).h("7.12.1").A(zOptBoolean14).b(bool).L(zOptBoolean10).s(zOptBoolean11).r(zOptBoolean13);
                int i2 = iw1.l;
                return aVarR2.c(iw1.a.a().j()).a(iw1.a.a().f()).x(zOptBoolean4).i(zOptBoolean211).w(zOptBoolean5).G(zOptBoolean6).H(zOptBoolean7).E(zOptBoolean8).B(zOptBoolean9).t(zOptBoolean15).v(zOptBoolean16).O(zOptBoolean17).N(zOptBoolean18).e(strOptString6).q(zOptBoolean19).a(elVar).a(i50Var3).n(zOptBoolean210).m(zOptBoolean20).S(zOptBoolean21).z(zOptBoolean22).y(zOptBoolean23).a(strOptString4).d(strOptString5).o(zOptBoolean12).I(zOptBoolean212).c(strOptString3).h(zOptBoolean213).C(zOptBoolean214).R(zOptBoolean215).i(strOptString11).f(zOptBoolean310).u(zOptBoolean311).J(zOptBoolean312).D(zOptBoolean313).T(zOptBoolean314).a(zOptBoolean315).a(numB7).k(zOptBoolean316).p(zOptBoolean317).b(zOptBoolean318).b(l3).c(l4).j(zOptBoolean319).a(set2).Q(zOptBoolean48).d(zOptBoolean49).e(zOptBoolean410).d(num3).c(num4).g(numB8).f(numB9).a(b7VarA2).K(zOptBoolean411).a(list2).M(zOptBoolean412).P(zOptBoolean413).U(zOptBoolean414).F(zOptBoolean415).a();
            } catch (JSONException e) {
                op0.b(new Object[0]);
                this.f9951a.reportError("Can't parse sdk configuration response", e);
            }
        }
        return null;
    }
}
