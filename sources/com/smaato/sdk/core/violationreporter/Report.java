package com.smaato.sdk.core.violationreporter;

import com.json.cc;
import java.util.Collection;
import java.util.List;
import net.pubnative.lite.sdk.models.APIMeta;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
abstract class Report {

    public static abstract class Builder {
        public abstract Report build();

        public abstract Builder setAdMarkup(String str);

        public abstract Builder setAdSpace(String str);

        public abstract Builder setApiKey(String str);

        public abstract Builder setApiVersion(String str);

        public abstract Builder setAsnId(String str);

        public abstract Builder setBundleId(String str);

        public abstract Builder setClickUrl(String str);

        public abstract Builder setCreativeId(String str);

        public abstract Builder setError(String str);

        public abstract Builder setOriginalUrl(String str);

        public abstract Builder setPlatform(String str);

        public abstract Builder setPublisher(String str);

        public abstract Builder setRedirectUrl(String str);

        public abstract Builder setSci(String str);

        public abstract Builder setSdkVersion(String str);

        public abstract Builder setSessionId(String str);

        public abstract Builder setTimestamp(String str);

        public abstract Builder setTraceUrls(List<String> list);

        public abstract Builder setType(String str);

        public abstract Builder setViolatedUrl(String str);
    }

    public abstract String getAdMarkup();

    public abstract String getAdSpace();

    public abstract String getApiKey();

    public abstract String getApiVersion();

    public abstract String getAsnId();

    public abstract String getBundleId();

    public abstract String getClickUrl();

    public abstract String getCreativeId();

    public abstract String getError();

    public abstract String getOriginalUrl();

    public abstract String getPlatform();

    public abstract String getPublisher();

    public abstract String getRedirectUrl();

    public abstract String getSci();

    public abstract String getSdkVersion();

    public abstract String getSessionId();

    public abstract String getTimestamp();

    public abstract List<String> getTraceUrls();

    public abstract String getType();

    public abstract String getViolatedUrl();

    Report() {
    }

    public static Builder builder() {
        return new AutoValue_Report.Builder();
    }

    public JSONObject toJson() throws JSONException {
        return new JSONObject().put("sci", getSci()).put("timestamp", getTimestamp()).put("error", getError()).put(cc.b, getSdkVersion()).put("bundleid", getBundleId()).put("type", getType()).put("violatedurl", getViolatedUrl()).put("publisher", getPublisher()).put("platform", getPlatform()).put("adspace", getAdSpace()).put("sessionid", getSessionId()).put("apikey", getApiKey()).put("apiversion", getApiVersion()).put("originalurl", getOriginalUrl()).put(APIMeta.CREATIVE_ID, getCreativeId()).put("asnid", getAsnId()).put("redirecturl", getRedirectUrl()).put("clickurl", getClickUrl()).put("admarkup", getAdMarkup()).put("traceurls", new JSONArray((Collection) getTraceUrls()));
    }
}
