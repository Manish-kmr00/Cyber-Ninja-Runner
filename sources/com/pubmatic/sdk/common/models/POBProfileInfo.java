package com.pubmatic.sdk.common.models;

import com.json.b9;
import com.pubmatic.sdk.common.utility.POBUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class POBProfileInfo {
    public static final String COUNTRY_FILTERING_ALLOW_MODE = "include";
    public static final String COUNTRY_FILTERING_BLOCK_MODE = "exclude";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7586a;
    private int b;
    private String e;
    private Set f;
    private String g;
    private boolean d = true;
    private final long c = System.currentTimeMillis();

    @Retention(RetentionPolicy.SOURCE)
    public @interface CountryFilterMode {
    }

    public static POBProfileInfo build(JSONObject jSONObject) throws JSONException {
        POBProfileInfo pOBProfileInfo = new POBProfileInfo();
        pOBProfileInfo.f7586a = jSONObject.optInt("pid");
        pOBProfileInfo.b = jSONObject.optInt("pubid");
        pOBProfileInfo.e = jSONObject.optString("adserver");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ctFiltering");
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
            pOBProfileInfo.g = jSONObjectOptJSONObject.optString(b9.a.t);
            pOBProfileInfo.f = POBUtils.parseJsonArrayToSet(jSONObjectOptJSONObject.optJSONArray("codes"));
        }
        pOBProfileInfo.d = jSONObject.optInt("enableCrashAnalyticAndroid", 1) != 0;
        return pOBProfileInfo;
    }

    public String getAdServerName() {
        return this.e;
    }

    public String getCountryFilteringMode() {
        return this.g;
    }

    public long getCreatedDateTime() {
        return this.c;
    }

    public Set<String> getFilteringCountries() {
        return this.f;
    }

    public int getProfileId() {
        return this.f7586a;
    }

    public int getPublisherId() {
        return this.b;
    }

    public boolean isCrashAnalyticsEnabled() {
        return this.d;
    }

    public boolean isProfileInfoExpired() {
        return System.currentTimeMillis() - this.c > 86400000;
    }
}
