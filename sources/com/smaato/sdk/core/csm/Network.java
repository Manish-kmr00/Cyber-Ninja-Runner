package com.smaato.sdk.core.csm;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Network {

    public static abstract class Builder {
        public abstract Network build();

        public abstract Builder setAdUnitId(String str);

        public abstract Builder setClassName(String str);

        public abstract Builder setClickUrl(String str);

        public abstract Builder setCustomData(String str);

        public abstract Builder setHeight(int i);

        public abstract Builder setImpression(String str);

        public abstract Builder setName(String str);

        public abstract Builder setPriority(int i);

        public abstract Builder setWidth(int i);
    }

    public abstract String getAdUnitId();

    public abstract String getClassName();

    public abstract String getClickUrl();

    public abstract String getCustomData();

    public abstract int getHeight();

    public abstract String getImpression();

    public abstract String getName();

    public abstract int getPriority();

    public abstract int getWidth();

    public boolean isCustomCsmNetwork() {
        return "Custom_CSM".equalsIgnoreCase(getName());
    }

    public static Builder builder() {
        return new AutoValue_Network.Builder();
    }
}
