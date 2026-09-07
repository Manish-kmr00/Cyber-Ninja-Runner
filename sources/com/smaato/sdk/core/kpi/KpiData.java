package com.smaato.sdk.core.kpi;

/* JADX INFO: loaded from: classes.dex */
public abstract class KpiData {

    public static abstract class Builder {
        public abstract KpiData build();

        public abstract Builder setRollingFillRatePerAdSpace(String str);

        public abstract Builder setSessionDepthPerAdSpace(String str);

        public abstract Builder setTotalAdRequests(String str);

        public abstract Builder setTotalFillRate(String str);
    }

    public abstract String getRollingFillRatePerAdSpace();

    public abstract String getSessionDepthPerAdSpace();

    public abstract String getTotalAdRequests();

    public abstract String getTotalFillRate();

    public static Builder builder() {
        return new AutoValue_KpiData.Builder();
    }
}
