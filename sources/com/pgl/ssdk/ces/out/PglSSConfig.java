package com.pgl.ssdk.ces.out;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class PglSSConfig {
    public static final int COLLECT_MODE_DEFAULT = 0;
    public static final int COLLECT_MODE_ML_MINIMIZE = 1;
    public static final String CUSTOMINFO_KEY_CHECKCLAZZ = "check_clz";
    public static final int OVREGION_TYPE_CN = 2;
    public static final int OVREGION_TYPE_SG = 0;
    public static final int OVREGION_TYPE_UNKNOWN = -1;
    public static final int OVREGION_TYPE_VA = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7509a;
    private final int b;
    private String c;
    private String d;
    private Map<String, Object> e;
    private String f;
    private String g;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7510a;
        private int b = -1;
        private int c = 0;
        private String d;

        public PglSSConfig build() {
            if (TextUtils.isEmpty(this.f7510a)) {
                return null;
            }
            int i = this.b;
            if (i != 2 && i != 1 && i != 0) {
                return null;
            }
            int i2 = this.c;
            if (i2 == 0 || i2 == 1) {
                return new PglSSConfig(this.f7510a, i, i2, this.d);
            }
            return null;
        }

        public Builder setAdsdkVersion(String str) {
            this.d = str;
            return this;
        }

        public Builder setAppId(String str) {
            this.f7510a = str;
            return this;
        }

        public Builder setCollectMode(int i) {
            this.c = i;
            return this;
        }

        public Builder setOVRegionType(int i) {
            this.b = i;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getAdSdkVersion() {
        return this.d;
    }

    public String getAppId() {
        return this.c;
    }

    public String getCnReportUrl() {
        return this.f;
    }

    public String getCnTokenUrl() {
        return this.g;
    }

    public int getCollectMode() {
        return this.b;
    }

    public Map<String, Object> getCustomInfo() {
        return this.e;
    }

    public int getOVRegionType() {
        return this.f7509a;
    }

    public void setCnReportUrl(String str) {
        this.f = str;
    }

    public void setCnTokenUrl(String str) {
        this.g = str;
    }

    public void setCustomInfo(Map<String, Object> map) {
        this.e = map;
    }

    private PglSSConfig(String str, int i, int i2, String str2) {
        this.c = str;
        this.f7509a = i;
        this.b = i2;
        this.d = str2;
    }
}
