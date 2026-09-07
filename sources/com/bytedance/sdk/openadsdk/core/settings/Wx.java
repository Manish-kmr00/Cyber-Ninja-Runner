package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.roi;
import com.bytedance.sdk.openadsdk.utils.TV;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.playon.bridge.Ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Wx extends DX {
    static final ArrayList<String> ZZv = new ArrayList<>(Arrays.asList("ja", "en", "ko", "zh", "th", "vi", "id", "ru", "ar", "fr", DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR, "it", "es", "hi", "pt", "zh-Hant", "ms", "pl", "tr"));
    public boolean KZx;
    private Set<String> ML;

    public Wx(DX.pA pAVar) {
        super("tt_sdk_settings.prop", pAVar);
        this.ML = Collections.synchronizedSet(new HashSet());
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.ML
    public void pA(JSONObject jSONObject) {
        int iOptInt;
        ML.pA pAVarPA = pA();
        JSONObject jSONObjectML = oX.vkV().ML();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("digest");
        this.KZx = (jSONObjectOptJSONObject == null || jSONObjectML == null || !jSONObjectOptJSONObject.toString().equals(jSONObjectML.toString())) ? false : true;
        if (jSONObjectOptJSONObject != null) {
            pAVarPA.pA("digest", jSONObjectOptJSONObject.toString());
        } else {
            pAVarPA.pA("digest");
        }
        pAVarPA.pA("data_time", jSONObject.optLong("data_time"));
        if (jSONObject.has("req_inter_min")) {
            long jOptLong = jSONObject.optLong("req_inter_min", 10L) * 60000;
            if (jOptLong < 0 || jOptLong > 86400000) {
                jOptLong = 600000;
            }
            pAVarPA.pA("req_inter_min", jOptLong);
        }
        if (jSONObject.has("lp_new_style")) {
            pAVarPA.pA("landingpage_new_style", jSONObject.optInt("lp_new_style", Integer.MAX_VALUE));
        }
        if (jSONObject.has("blank_detect_rate")) {
            int iOptInt2 = jSONObject.optInt("blank_detect_rate", 30);
            if (iOptInt2 < 0 || iOptInt2 > 100) {
                iOptInt2 = 30;
            }
            pAVarPA.pA("blank_detect_rate", iOptInt2);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("feq_policy");
        if (jSONObjectOptJSONObject2 != null) {
            if (jSONObjectOptJSONObject2.has("duration")) {
                pAVarPA.pA("duration", jSONObjectOptJSONObject2.optLong("duration") * 1000);
            }
            if (jSONObjectOptJSONObject2.has("max")) {
                pAVarPA.pA("max", jSONObjectOptJSONObject2.optInt("max"));
            }
        }
        if (jSONObject.has("vbtt")) {
            pAVarPA.pA("vbtt", jSONObject.optInt("vbtt", 5));
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("abtest");
        if (jSONObjectOptJSONObject3 != null) {
            if (jSONObjectOptJSONObject3.has("version")) {
                pAVarPA.pA("ab_test_version", jSONObjectOptJSONObject3.optString("version"));
            }
            if (jSONObjectOptJSONObject3.has(Ad.VERIFICATIONPARAM)) {
                pAVarPA.pA("ab_test_param", jSONObjectOptJSONObject3.optString(Ad.VERIFICATIONPARAM));
            }
        } else {
            oX.vkV().SD();
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("log_rate_conf");
        if (jSONObjectOptJSONObject4 != null && jSONObjectOptJSONObject4.has("global_rate")) {
            pAVarPA.pA("global_rate", (float) jSONObjectOptJSONObject4.optDouble("global_rate", 1.0d));
        }
        if (jSONObject.has("pyload_h5")) {
            pAVarPA.pA("pyload_h5", jSONObject.optString("pyload_h5"));
        }
        if (jSONObject.has("pure_pyload_h5")) {
            pAVarPA.pA("playableLoadH5Url", jSONObject.optString("pure_pyload_h5"));
        }
        if (jSONObject.has("ads_url")) {
            pAVarPA.pA("ads_url", jSONObject.optString("ads_url"));
        }
        if (jSONObject.has("app_log_url")) {
            pAVarPA.pA("app_log_url", jSONObject.optString("app_log_url"));
        }
        if (jSONObject.has("coppa")) {
            int iOptInt3 = jSONObject.optInt("coppa", -99);
            com.bytedance.sdk.openadsdk.core.Bzk.Og().ZZv(iOptInt3);
            pAVarPA.pA("coppa", iOptInt3);
        }
        if (jSONObject.has(CampaignEx.JSON_KEY_PRIVACY_URL)) {
            pAVarPA.pA("policy_url", jSONObject.optString(CampaignEx.JSON_KEY_PRIVACY_URL));
        }
        if (jSONObject.has("consent_url")) {
            pAVarPA.pA("consent_url", jSONObject.optString("consent_url"));
        }
        if (jSONObject.has("ivrv_downward")) {
            pAVarPA.pA("ivrv_downward", jSONObject.optInt("ivrv_downward", 0));
        }
        if (jSONObject.has("dc")) {
            pAVarPA.pA("dc", jSONObject.optString("dc"));
        }
        oX.vkV().pA(jSONObject, pAVarPA);
        oX.vkV().Og(jSONObject, pAVarPA);
        if (jSONObject.has("if_both_open")) {
            pAVarPA.pA("if_both_open", jSONObject.optInt("if_both_open", 0));
        }
        if (jSONObject.has("support_tnc")) {
            pAVarPA.pA("support_tnc", jSONObject.optInt("support_tnc", 1));
        }
        if (jSONObject.has("insert_js_config")) {
            pAVarPA.pA("insert_js_config", jSONObject.optString("insert_js_config", ""));
        }
        if (jSONObject.has("max_tpl_cnts")) {
            pAVarPA.pA("max_tpl_cnts", jSONObject.optInt("max_tpl_cnts", 100));
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject5 != null) {
            if (jSONObjectOptJSONObject5.has("force_language")) {
                String strOptString = jSONObjectOptJSONObject5.optString("force_language");
                if (!TextUtils.isEmpty(strOptString) && ZZv.contains(strOptString)) {
                    pAVarPA.pA("force_language", strOptString);
                }
            }
            if (jSONObjectOptJSONObject5.has("fetch_tpl_timeout_ctrl")) {
                pAVarPA.pA("fetch_tpl_timeout_ctrl", jSONObjectOptJSONObject5.optInt("fetch_tpl_timeout_ctrl", 3000));
            }
            if (jSONObjectOptJSONObject5.has("fetch_tpl_second")) {
                pAVarPA.pA("fetch_tpl_second", jSONObjectOptJSONObject5.optInt("fetch_tpl_second", 0));
            }
            if (jSONObjectOptJSONObject5.has("support_gzip")) {
                pAVarPA.pA("support_gzip", jSONObjectOptJSONObject5.optBoolean("support_gzip", false));
            }
            if (jSONObjectOptJSONObject5.has("aes_key")) {
                pAVarPA.pA("aes_key", jSONObjectOptJSONObject5.optString("aes_key"));
            }
            if (jSONObjectOptJSONObject5.has("support_rtl")) {
                pAVarPA.pA("support_rtl", jSONObjectOptJSONObject5.optBoolean("support_rtl", false));
            }
            if (jSONObjectOptJSONObject5.has("ad_revenue_enable")) {
                pAVarPA.pA("ad_revenue_enable", jSONObjectOptJSONObject5.optBoolean("ad_revenue_enable", true));
            }
            if (jSONObjectOptJSONObject5.has("gecko_hosts")) {
                try {
                    this.ML.clear();
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject5.optJSONArray("gecko_hosts");
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            this.ML.add(jSONArrayOptJSONArray.getString(i));
                        }
                    }
                    this.ML = pA(this.ML);
                    pAVarPA.pA("gecko_hosts", jSONArrayOptJSONArray.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.Og("GeckoLog: settings json error ".concat(String.valueOf(th)));
                }
            }
        }
        if (jSONObject.has("read_video_from_cache")) {
            pAVarPA.pA("read_video_from_cache", jSONObject.optInt("read_video_from_cache", 1));
        }
        KZx.pA(jSONObject.optJSONArray("ad_slot_conf_list"));
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("privacy");
        if (jSONObjectOptJSONObject6 != null) {
            if (jSONObjectOptJSONObject6.has("ad_enable")) {
                pAVarPA.pA("privacy_ad_enable", jSONObjectOptJSONObject6.optInt("ad_enable", Integer.MAX_VALUE));
            }
            if (jSONObjectOptJSONObject6.has("personalized_ad")) {
                pAVarPA.pA("privacy_personalized_ad", jSONObjectOptJSONObject6.optInt("personalized_ad", Integer.MAX_VALUE));
            }
            if (jSONObjectOptJSONObject6.has("sladar_enable")) {
                pAVarPA.pA("privacy_sladar_enable", jSONObjectOptJSONObject6.optInt("sladar_enable", Integer.MAX_VALUE));
            }
            if (jSONObjectOptJSONObject6.has("app_log_enable")) {
                pAVarPA.pA("privacy_app_log_enable", jSONObjectOptJSONObject6.optInt("app_log_enable", Integer.MAX_VALUE));
            }
            if (jSONObjectOptJSONObject6.has("debug_unlock")) {
                pAVarPA.pA("privacy_debug_unlock", jSONObjectOptJSONObject6.optInt("debug_unlock", Integer.MAX_VALUE));
            }
            if (jSONObjectOptJSONObject6.has("fields_allowed")) {
                String strOptString2 = jSONObjectOptJSONObject6.optString("fields_allowed", "");
                if (!TextUtils.isEmpty(strOptString2)) {
                    pAVarPA.pA("privacy_fields_allowed", strOptString2);
                } else {
                    pAVarPA.pA("privacy_fields_allowed");
                }
            }
            if (jSONObjectOptJSONObject6.has("app_reg")) {
                int iOptInt4 = jSONObjectOptJSONObject6.optInt("app_reg", 1);
                if (iOptInt4 == 0 && roi.pA().SD() == 1) {
                    xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.Wx.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(aBv.pA(), "Appid is not registered on pangle media platform", 1).show();
                        }
                    });
                }
                pAVarPA.pA("privacy_app_reg", iOptInt4 != 0);
            }
        }
        if (jSONObject.has("video_cache_config")) {
            pAVarPA.pA("video_cache_config", jSONObject.optString("video_cache_config"));
        }
        if (jSONObject.has("loaded_recall_time")) {
            int iOptInt5 = jSONObject.optInt("loaded_recall_time", 0);
            if (iOptInt5 != 0 && iOptInt5 != 1) {
                iOptInt5 = 0;
            }
            pAVarPA.pA("loadedCallbackOpportunity", iOptInt5);
        }
        if (jSONObject.has("load_strategy")) {
            int iOptInt6 = jSONObject.optInt("load_strategy", 0);
            if (iOptInt6 != 0 && iOptInt6 != 1) {
                iOptInt6 = 0;
            }
            pAVarPA.pA("load_callback_strategy", iOptInt6);
        }
        if (jSONObject.has("splash_video_load_strategy")) {
            int iOptInt7 = jSONObject.optInt("splash_video_load_strategy", 0);
            if (iOptInt7 < 0 || iOptInt7 > 3) {
                iOptInt7 = 0;
            }
            pAVarPA.pA("splash_video_load_strategy", iOptInt7);
        }
        if (jSONObject.has("allow_blind_mode_request_ad")) {
            pAVarPA.pA("allow_blind_mode_request_ad", jSONObject.optBoolean("allow_blind_mode_request_ad", false));
        }
        JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("bus_con");
        if (jSONObjectOptJSONObject7 != null) {
            if (jSONObjectOptJSONObject7.has("bus_con_send_log_type")) {
                pAVarPA.pA("bus_con_send_log_type", jSONObjectOptJSONObject7.optInt("bus_con_send_log_type", 1));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_sec_type")) {
                pAVarPA.pA("bus_con_sec_type", jSONObjectOptJSONObject7.optInt("bus_con_sec_type", Integer.MAX_VALUE));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_dislike_report_raw")) {
                pAVarPA.pA("bus_con_dislike_report_raw", jSONObjectOptJSONObject7.optBoolean("bus_con_dislike_report_raw", false));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_adshow_check_enable")) {
                pAVarPA.pA("bus_con_adshow_check_enable", jSONObjectOptJSONObject7.optBoolean("bus_con_adshow_check_enable", true));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_tnc_interval")) {
                pAVarPA.pA("bus_con_tnc_interval", jSONObjectOptJSONObject7.optLong("bus_con_tnc_interval", 600000L));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_token_thread_count")) {
                pAVarPA.pA("bus_con_token_thread_count", jSONObjectOptJSONObject7.optInt("bus_con_token_thread_count", 4));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_video_keep_screen_on")) {
                pAVarPA.pA("bus_con_video_keep_screen_on", jSONObjectOptJSONObject7.optInt("bus_con_video_keep_screen_on", 1));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_auto_click_delay")) {
                pAVarPA.pA("bus_con_auto_click_delay", jSONObjectOptJSONObject7.optInt("bus_con_auto_click_delay", 3000));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_express_host")) {
                pAVarPA.pA("bus_con_express_host", jSONObjectOptJSONObject7.optString("bus_con_express_host", "https://sf16-static.i18n-pglstatp.com/obj/ad-pattern-sg/"));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_rewardedfull_link")) {
                pAVarPA.pA("bus_con_rewardedfull_link", jSONObjectOptJSONObject7.optInt("bus_con_rewardedfull_link", 0));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_check_clz")) {
                pAVarPA.pA("bus_con_check_clz", jSONObjectOptJSONObject7.optString("bus_con_check_clz", ""));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_url_check")) {
                pAVarPA.pA("bus_con_url_check", jSONObjectOptJSONObject7.optInt("bus_con_url_check", 1));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_behavior_count")) {
                pAVarPA.pA("bus_con_behavior_count", jSONObjectOptJSONObject7.optInt("bus_con_behavior_count", 300));
            }
            if (jSONObjectOptJSONObject7.has(oX.pA)) {
                pAVarPA.pA(oX.pA, jSONObjectOptJSONObject7.optBoolean(oX.pA, false));
            }
            if (jSONObjectOptJSONObject7.has(oX.Og)) {
                pAVarPA.pA(oX.Og, jSONObjectOptJSONObject7.optInt(oX.Og, 10000));
            }
            if (jSONObjectOptJSONObject7.has(oX.KZx)) {
                pAVarPA.pA(oX.KZx, (float) jSONObjectOptJSONObject7.optDouble(oX.KZx, 1.0d));
            }
        }
        if (jSONObject.has("perf_con")) {
            try {
                JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("perf_con");
                if (jSONObjectOptJSONObject8 != null) {
                    if (jSONObjectOptJSONObject8.has("perf_con_stats_rate")) {
                        String strOptString3 = jSONObjectOptJSONObject8.optString("perf_con_stats_rate");
                        if (!TextUtils.isEmpty(strOptString3)) {
                            pAVarPA.pA("perf_con_stats_rate", strOptString3);
                        }
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_applog_send")) {
                        String strOptString4 = jSONObjectOptJSONObject8.optString("perf_con_applog_send");
                        if (!TextUtils.isEmpty(strOptString4)) {
                            pAVarPA.pA("perf_con_applog_send", strOptString4);
                        }
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_apm_native")) {
                        pAVarPA.pA("perf_con_apm_native", jSONObjectOptJSONObject8.optInt("perf_con_apm_native"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_webview_preload_cache")) {
                        pAVarPA.pA("perf_con_webview_preload_cache", jSONObjectOptJSONObject8.optInt("perf_con_webview_preload_cache"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_webview_preload_cache_v3")) {
                        pAVarPA.pA("perf_con_webview_preload_cache_v3", jSONObjectOptJSONObject8.optInt("perf_con_webview_preload_cache_v3"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_webview_cache_count")) {
                        pAVarPA.pA("perf_con_webview_cache_count", jSONObjectOptJSONObject8.optInt("perf_con_webview_cache_count", 0));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_webview_cache_count_v3")) {
                        pAVarPA.pA("perf_con_webview_cache_count_v3", jSONObjectOptJSONObject8.optInt("perf_con_webview_cache_count_v3", 0));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_thread_stack_size") && (iOptInt = jSONObjectOptJSONObject8.optInt("perf_con_thread_stack_size")) >= -524288 && iOptInt <= 0) {
                        pAVarPA.pA("perf_con_thread_stack_size", iOptInt);
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_use_new_thread_pool")) {
                        pAVarPA.pA("perf_con_use_new_thread_pool", jSONObjectOptJSONObject8.optInt("perf_con_use_new_thread_pool", 0));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_thread_pool_config")) {
                        String strOptString5 = jSONObjectOptJSONObject8.optString("perf_con_thread_pool_config");
                        if (!TextUtils.isEmpty(strOptString5)) {
                            pAVarPA.pA("perf_con_thread_pool_config", strOptString5);
                        }
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_is_new_net_thread")) {
                        pAVarPA.pA("perf_con_is_new_net_thread", jSONObjectOptJSONObject8.optInt("perf_con_is_new_net_thread", 0));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_use_prop")) {
                        TV.pA(jSONObjectOptJSONObject8.optInt("perf_con_use_prop", 1));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_adlog_expire_time")) {
                        pAVarPA.pA("perf_con_adlog_expire_time", jSONObjectOptJSONObject8.optLong("perf_con_adlog_expire_time"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_adlog_turn_off_retry_ad")) {
                        pAVarPA.pA("perf_con_adlog_turn_off_retry_ad", jSONObjectOptJSONObject8.optLong("perf_con_adlog_turn_off_retry_ad"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_adlog_turn_off_retry_stats")) {
                        pAVarPA.pA("perf_con_adlog_turn_off_retry_stats", jSONObjectOptJSONObject8.optLong("perf_con_adlog_turn_off_retry_stats"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_applog_rate")) {
                        pAVarPA.pA("perf_con_applog_rate", jSONObjectOptJSONObject8.optString("perf_con_applog_rate"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_track_url_strategy")) {
                        pAVarPA.pA("perf_con_track_url_strategy", jSONObjectOptJSONObject8.optString("perf_con_track_url_strategy"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_drawable_code")) {
                        pAVarPA.pA("perf_con_drawable_code", jSONObjectOptJSONObject8.optInt("perf_con_drawable_code", 0));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_close_button_delay_check_time")) {
                        pAVarPA.pA("perf_con_close_button_delay_check_time", jSONObjectOptJSONObject8.optInt("perf_con_close_button_delay_check_time", -1));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_drop2rt_skip_label_list")) {
                        pAVarPA.pA("perf_con_drop2rt_skip_label_list", jSONObjectOptJSONObject8.optString("perf_con_drop2rt_skip_label_list"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_crypt_V4_get_ad")) {
                        pAVarPA.pA("perf_con_crypt_V4_get_ad", jSONObjectOptJSONObject8.optBoolean("perf_con_crypt_V4_get_ad", false));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_crypt_V4_applog")) {
                        pAVarPA.pA("perf_con_crypt_V4_applog", jSONObjectOptJSONObject8.optBoolean("perf_con_crypt_V4_applog", false));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_crypt_V4")) {
                        pAVarPA.pA("perf_con_crypt_V4", jSONObjectOptJSONObject8.optBoolean("perf_con_crypt_V4", false));
                    }
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.WV.pA("SettingsDefaultRepository", th2.getMessage());
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("app_common_config", jSONObjectOptJSONObject5);
            jSONObject2.put("perf_con", jSONObject.optJSONObject("perf_con"));
            jSONObject2.put("bus_con", jSONObject.optJSONObject("bus_con"));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("SettingsDefaultRepository", "coreSettingJson", e.getMessage());
        }
        pAVarPA.pA("core_settings", jSONObject2.toString());
        if (jSONObject.has("dual_event_url")) {
            pAVarPA.pA("dual_event_url", jSONObject.optString("dual_event_url"));
        }
        pAVarPA.pA();
        oX.vkV().Mc();
        ZZv();
    }

    public static Set<String> pA(Set<String> set) {
        try {
            if (set == null) {
                return new HashSet();
            }
            HashSet hashSet = new HashSet();
            for (String str : set) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            return hashSet;
        } catch (Throwable unused) {
            return new HashSet();
        }
    }
}
