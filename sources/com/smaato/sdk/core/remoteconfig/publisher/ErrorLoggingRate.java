package com.smaato.sdk.core.remoteconfig.publisher;

import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ErrorLoggingRate {
    private final int adResponse;
    private final int configurationApi;
    private final int configurationSdk;
    private final int creative;
    private final int requestTimeout;

    private ErrorLoggingRate(int i, int i2, int i3, int i4, int i5) {
        this.requestTimeout = i;
        this.adResponse = i2;
        this.configurationApi = i3;
        this.configurationSdk = i4;
        this.creative = i5;
    }

    public int getRequestTimeout() {
        return this.requestTimeout;
    }

    public int getAdResponse() {
        return this.adResponse;
    }

    public int getConfigurationApi() {
        return this.configurationApi;
    }

    public int getConfigurationSdk() {
        return this.configurationSdk;
    }

    public int getCreative() {
        return this.creative;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ErrorLoggingRate.class != obj.getClass()) {
            return false;
        }
        ErrorLoggingRate errorLoggingRate = (ErrorLoggingRate) obj;
        return this.requestTimeout == errorLoggingRate.requestTimeout && this.adResponse == errorLoggingRate.adResponse && this.configurationApi == errorLoggingRate.configurationApi && this.configurationSdk == errorLoggingRate.configurationSdk && this.creative == errorLoggingRate.creative;
    }

    public int hashCode() {
        return (((((((this.requestTimeout * 31) + this.adResponse) * 31) + this.configurationApi) * 31) + this.configurationSdk) * 31) + this.creative;
    }

    static final class Builder {
        private Integer adResponse;
        private Integer configurationApi;
        private Integer configurationSdk;
        private Integer creative;
        private Integer requestTimeout;

        Builder() {
        }

        Builder(JSONObject jSONObject) {
            if (jSONObject.optInt("requestTimeout", -1) != -1) {
                this.requestTimeout = Integer.valueOf(jSONObject.optInt("requestTimeout"));
            }
            if (jSONObject.optInt("adResponse", -1) != -1) {
                this.adResponse = Integer.valueOf(jSONObject.optInt("adResponse"));
            }
            if (jSONObject.optInt("configurationApi", -1) != -1) {
                this.configurationApi = Integer.valueOf(jSONObject.optInt("configurationApi"));
            }
            if (jSONObject.optInt("configurationSdk", -1) != -1) {
                this.configurationSdk = Integer.valueOf(jSONObject.optInt("configurationSdk"));
            }
            if (jSONObject.optInt(Reporting.Key.CREATIVE, -1) != -1) {
                this.creative = Integer.valueOf(jSONObject.optInt(Reporting.Key.CREATIVE));
            }
        }

        ErrorLoggingRate build() {
            Integer num = this.requestTimeout;
            if (num == null || num.intValue() < 0 || this.requestTimeout.intValue() > 100) {
                this.requestTimeout = 100;
            }
            Integer num2 = this.adResponse;
            if (num2 == null || num2.intValue() < 0 || this.adResponse.intValue() > 100) {
                this.adResponse = 100;
            }
            Integer num3 = this.configurationApi;
            if (num3 == null || num3.intValue() < 0 || this.configurationApi.intValue() > 100) {
                this.configurationApi = 100;
            }
            Integer num4 = this.configurationSdk;
            if (num4 == null || num4.intValue() < 0 || this.configurationSdk.intValue() > 100) {
                this.configurationSdk = 100;
            }
            Integer num5 = this.creative;
            if (num5 == null || num5.intValue() < 0 || this.creative.intValue() > 100) {
                this.creative = 100;
            }
            return new ErrorLoggingRate(this.requestTimeout.intValue(), this.adResponse.intValue(), this.configurationApi.intValue(), this.configurationSdk.intValue(), this.creative.intValue());
        }
    }
}
