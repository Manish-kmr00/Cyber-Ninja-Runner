package com.smaato.sdk.core.remoteconfig.global;

import com.smaato.sdk.core.BuildConfig;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ConfigUrls {
    private static final Pattern URL_PATTERN = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$");
    private final String adViolationUrl;
    private final String configLogUrl;
    private final String configurationUrl;
    private final String eventLogUrl;
    private final String somaUbUrl;
    private final String somaUrl;

    private ConfigUrls(String str, String str2, String str3, String str4, String str5, String str6) {
        this.somaUrl = str;
        this.adViolationUrl = str2;
        this.somaUbUrl = str3;
        this.configurationUrl = str4;
        this.configLogUrl = str5;
        this.eventLogUrl = str6;
    }

    public String getSomaUrl() {
        return this.somaUrl;
    }

    public String getAdViolationUrl() {
        return this.adViolationUrl;
    }

    public String getSomaUbUrl() {
        return this.somaUbUrl;
    }

    public String getConfigurationUrl() {
        return this.configurationUrl;
    }

    public String getConfigLogUrl() {
        return this.configLogUrl;
    }

    public String getEventLogUrl() {
        return this.eventLogUrl;
    }

    static final class Builder {
        private String adViolationUrl;
        private String configLogUrl;
        private String configurationUrl;
        private String eventLogUrl;
        private String somaUbUrl;
        private String somaUrl;

        Builder() {
        }

        Builder(JSONObject jSONObject) {
            parseUrls(jSONObject);
        }

        ConfigUrls build() {
            String str = this.somaUrl;
            if (str == null) {
                str = BuildConfig.SOMA_API_URL;
            }
            this.somaUrl = str;
            String str2 = this.adViolationUrl;
            if (str2 == null) {
                str2 = BuildConfig.SOMA_VIOLATIONS_AGGREGATOR_URL;
            }
            this.adViolationUrl = str2;
            String soma_ub_url = this.somaUbUrl;
            if (soma_ub_url == null) {
                soma_ub_url = BuildConfigProvider.getSOMA_UB_URL();
            }
            this.somaUbUrl = soma_ub_url;
            String publisherConfigUrl = this.configurationUrl;
            if (publisherConfigUrl == null) {
                publisherConfigUrl = BuildConfigProvider.getPublisherConfigUrl();
            }
            this.configurationUrl = publisherConfigUrl;
            String publisherLogUrl = this.configLogUrl;
            if (publisherLogUrl == null) {
                publisherLogUrl = BuildConfigProvider.getPublisherLogUrl();
            }
            this.configLogUrl = publisherLogUrl;
            String event_log_url = this.eventLogUrl;
            if (event_log_url == null) {
                event_log_url = BuildConfigProvider.getEVENT_LOG_URL();
            }
            this.eventLogUrl = event_log_url;
            return new ConfigUrls(this.somaUrl, this.adViolationUrl, this.somaUbUrl, this.configurationUrl, this.configLogUrl, this.eventLogUrl);
        }

        private void parseUrls(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.somaUrl = jSONObject.has("somaurl") ? returnIfValidUrl(jSONObject.optString("somaurl")) : null;
            this.adViolationUrl = jSONObject.has("adviolationurl") ? returnIfValidUrl(jSONObject.optString("adviolationurl")) : null;
            this.somaUbUrl = jSONObject.has("somauburl") ? returnIfValidUrl(jSONObject.optString("somauburl")) : null;
            this.configurationUrl = jSONObject.has("configurationurl") ? returnIfValidUrl(jSONObject.optString("configurationurl")) : null;
            this.configLogUrl = jSONObject.has("configlogurl") ? returnIfValidUrl(jSONObject.optString("configlogurl")) : null;
            this.eventLogUrl = jSONObject.has("eventlogurl") ? returnIfValidUrl(jSONObject.optString("eventlogurl")) : null;
        }

        private String returnIfValidUrl(String str) {
            if (str == null || str.isEmpty() || !ConfigUrls.URL_PATTERN.matcher(str).matches()) {
                return null;
            }
            return str;
        }
    }
}
