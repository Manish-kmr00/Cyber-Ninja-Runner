package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import com.chartboost.sdk.privacy.model.CCPA;
import com.chartboost.sdk.privacy.model.COPPA;
import com.chartboost.sdk.privacy.model.Custom;
import com.chartboost.sdk.privacy.model.DataUseConsent;
import com.chartboost.sdk.privacy.model.GDPR;
import com.chartboost.sdk.privacy.model.LGPD;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class p8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, DataUseConsent> f1106a = new HashMap<>();
    public final SharedPreferences b;
    public final l4 c;

    /* JADX WARN: Code duplicated, block: B:29:0x0073  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e7  */
    public final void b() {
        byte b;
        DataUseConsent gdpr;
        SharedPreferences sharedPreferences = this.b;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("privacy_standards", "");
            if (string.isEmpty()) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string2 = jSONObject.getString("privacyStandard");
                    String string3 = jSONObject.getString("consent");
                    int iHashCode = string2.hashCode();
                    if (iHashCode != -1172350233) {
                        if (iHashCode != 3168159) {
                            if (iHashCode != 3319983) {
                                if (iHashCode == 94846581 && string2.equals("coppa")) {
                                    b = 2;
                                } else {
                                    b = -1;
                                }
                            } else if (string2.equals("lgpd")) {
                                b = 3;
                            } else {
                                b = -1;
                            }
                        } else if (string2.equals("gdpr")) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                    } else if (string2.equals("us_privacy")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    if (b == 0) {
                        GDPR.GDPR_CONSENT gdpr_consent = GDPR.GDPR_CONSENT.BEHAVIORAL;
                        if (gdpr_consent.getValue().equals(string3)) {
                            gdpr = new GDPR(gdpr_consent);
                        } else {
                            GDPR.GDPR_CONSENT gdpr_consent2 = GDPR.GDPR_CONSENT.NON_BEHAVIORAL;
                            if (gdpr_consent2.getValue().equals(string3)) {
                                gdpr = new GDPR(gdpr_consent2);
                            } else {
                                gdpr = null;
                            }
                        }
                    } else if (b == 1) {
                        CCPA.CCPA_CONSENT ccpa_consent = CCPA.CCPA_CONSENT.OPT_IN_SALE;
                        if (ccpa_consent.getValue().equals(string3)) {
                            gdpr = new CCPA(ccpa_consent);
                        } else {
                            CCPA.CCPA_CONSENT ccpa_consent2 = CCPA.CCPA_CONSENT.OPT_OUT_SALE;
                            if (ccpa_consent2.getValue().equals(string3)) {
                                gdpr = new CCPA(ccpa_consent2);
                            } else {
                                gdpr = null;
                            }
                        }
                    } else if (b != 2) {
                        gdpr = b != 3 ? new Custom(jSONObject.getString("privacyStandard"), jSONObject.getString("consent")) : new LGPD(jSONObject.getBoolean("consent"));
                    } else {
                        gdpr = new COPPA(jSONObject.getBoolean("consent"));
                    }
                    if (gdpr != null) {
                        this.f1106a.put(gdpr.getPrivacyStandard(), gdpr);
                    } else {
                        b(string2);
                        b7.a("Failed to load consent: " + string2, null);
                    }
                }
            } catch (JSONException e) {
                a(e);
                e.printStackTrace();
            }
        }
    }

    public p8(SharedPreferences sharedPreferences, l4 l4Var) {
        this.b = sharedPreferences;
        this.c = l4Var;
        b();
    }

    public HashMap<String, DataUseConsent> a() {
        return this.f1106a;
    }

    public final void c() {
        if (this.b != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<DataUseConsent> it = this.f1106a.values().iterator();
            while (it.hasNext()) {
                jSONArray.put(a(it.next()));
            }
            a(this.b, jSONArray);
        }
    }

    public void a(String str) {
        this.f1106a.remove(str);
        c();
    }

    public void b(DataUseConsent dataUseConsent) {
        b7.a("Added privacy standard: " + dataUseConsent.getPrivacyStandard() + " with consent: " + dataUseConsent.getConsent(), null);
        this.f1106a.put(dataUseConsent.getPrivacyStandard(), dataUseConsent);
        c();
    }

    public final void a(SharedPreferences sharedPreferences, JSONArray jSONArray) {
        if (sharedPreferences == null || jSONArray == null) {
            return;
        }
        sharedPreferences.edit().putString("privacy_standards", jSONArray.toString()).apply();
    }

    public final void b(String str) {
        this.c.mo4741track(r3.a(ma.d.PERSISTED_DATA_READING_ERROR, str, "", ""));
    }

    public final void a(JSONException jSONException) {
        this.c.mo4741track(r3.a(ma.d.DECODING_ERROR, jSONException.getMessage(), "", ""));
    }

    public final JSONObject a(DataUseConsent dataUseConsent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("privacyStandard", dataUseConsent.getPrivacyStandard());
            jSONObject.put("consent", dataUseConsent.getConsent());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
