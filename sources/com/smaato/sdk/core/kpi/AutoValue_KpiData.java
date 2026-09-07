package com.smaato.sdk.core.kpi;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_KpiData extends KpiData {
    private final String rollingFillRatePerAdSpace;
    private final String sessionDepthPerAdSpace;
    private final String totalAdRequests;
    private final String totalFillRate;

    private AutoValue_KpiData(String str, String str2, String str3, String str4) {
        this.rollingFillRatePerAdSpace = str;
        this.sessionDepthPerAdSpace = str2;
        this.totalAdRequests = str3;
        this.totalFillRate = str4;
    }

    @Override // com.smaato.sdk.core.kpi.KpiData
    public String getRollingFillRatePerAdSpace() {
        return this.rollingFillRatePerAdSpace;
    }

    @Override // com.smaato.sdk.core.kpi.KpiData
    public String getSessionDepthPerAdSpace() {
        return this.sessionDepthPerAdSpace;
    }

    @Override // com.smaato.sdk.core.kpi.KpiData
    public String getTotalAdRequests() {
        return this.totalAdRequests;
    }

    @Override // com.smaato.sdk.core.kpi.KpiData
    public String getTotalFillRate() {
        return this.totalFillRate;
    }

    public String toString() {
        return "KpiData{rollingFillRatePerAdSpace=" + this.rollingFillRatePerAdSpace + ", sessionDepthPerAdSpace=" + this.sessionDepthPerAdSpace + ", totalAdRequests=" + this.totalAdRequests + ", totalFillRate=" + this.totalFillRate + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KpiData)) {
            return false;
        }
        KpiData kpiData = (KpiData) obj;
        return this.rollingFillRatePerAdSpace.equals(kpiData.getRollingFillRatePerAdSpace()) && this.sessionDepthPerAdSpace.equals(kpiData.getSessionDepthPerAdSpace()) && this.totalAdRequests.equals(kpiData.getTotalAdRequests()) && this.totalFillRate.equals(kpiData.getTotalFillRate());
    }

    public int hashCode() {
        return ((((((this.rollingFillRatePerAdSpace.hashCode() ^ 1000003) * 1000003) ^ this.sessionDepthPerAdSpace.hashCode()) * 1000003) ^ this.totalAdRequests.hashCode()) * 1000003) ^ this.totalFillRate.hashCode();
    }

    static final class Builder extends KpiData.Builder {
        private String rollingFillRatePerAdSpace;
        private String sessionDepthPerAdSpace;
        private String totalAdRequests;
        private String totalFillRate;

        Builder() {
        }

        @Override // com.smaato.sdk.core.kpi.KpiData.Builder
        public KpiData.Builder setRollingFillRatePerAdSpace(String str) {
            if (str == null) {
                throw new NullPointerException("Null rollingFillRatePerAdSpace");
            }
            this.rollingFillRatePerAdSpace = str;
            return this;
        }

        @Override // com.smaato.sdk.core.kpi.KpiData.Builder
        public KpiData.Builder setSessionDepthPerAdSpace(String str) {
            if (str == null) {
                throw new NullPointerException("Null sessionDepthPerAdSpace");
            }
            this.sessionDepthPerAdSpace = str;
            return this;
        }

        @Override // com.smaato.sdk.core.kpi.KpiData.Builder
        public KpiData.Builder setTotalAdRequests(String str) {
            if (str == null) {
                throw new NullPointerException("Null totalAdRequests");
            }
            this.totalAdRequests = str;
            return this;
        }

        @Override // com.smaato.sdk.core.kpi.KpiData.Builder
        public KpiData.Builder setTotalFillRate(String str) {
            if (str == null) {
                throw new NullPointerException("Null totalFillRate");
            }
            this.totalFillRate = str;
            return this;
        }

        @Override // com.smaato.sdk.core.kpi.KpiData.Builder
        public KpiData build() {
            String str;
            if (this.rollingFillRatePerAdSpace != null) {
                str = "";
            } else {
                str = " rollingFillRatePerAdSpace";
            }
            if (this.sessionDepthPerAdSpace == null) {
                str = str + " sessionDepthPerAdSpace";
            }
            if (this.totalAdRequests == null) {
                str = str + " totalAdRequests";
            }
            if (this.totalFillRate == null) {
                str = str + " totalFillRate";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_KpiData(this.rollingFillRatePerAdSpace, this.sessionDepthPerAdSpace, this.totalAdRequests, this.totalFillRate);
        }
    }
}
