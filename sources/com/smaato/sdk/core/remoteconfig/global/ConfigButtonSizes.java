package com.smaato.sdk.core.remoteconfig.global;

import com.adjust.sdk.Constants;
import com.smaato.sdk.core.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class ConfigButtonSizes {
    private final int midInDp;
    private final int smallInDp;

    private ConfigButtonSizes(int i, int i2) {
        this.smallInDp = i;
        this.midInDp = i2;
    }

    public int getSmallInDp() {
        return this.smallInDp;
    }

    public int getMidInDp() {
        return this.midInDp;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConfigButtonSizes configButtonSizes = (ConfigButtonSizes) obj;
        return this.smallInDp == configButtonSizes.getSmallInDp() && this.midInDp == configButtonSizes.getMidInDp();
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.smallInDp), Integer.valueOf(this.midInDp));
    }

    static final class Builder {
        private Integer midSize;
        private Integer smallSize;

        Builder() {
        }

        Builder(JSONObject jSONObject) {
            if (jSONObject.optInt(Constants.SMALL, -1) != -1) {
                this.smallSize = Integer.valueOf(jSONObject.optInt(Constants.SMALL));
            }
            if (jSONObject.optInt("mid", -1) != -1) {
                this.midSize = Integer.valueOf(jSONObject.optInt("mid"));
            }
        }

        ConfigButtonSizes build() {
            Integer num = this.smallSize;
            if (num == null || num.intValue() < 0) {
                this.smallSize = 20;
            }
            Integer num2 = this.midSize;
            if (num2 == null || num2.intValue() < 0) {
                this.midSize = 30;
            }
            return new ConfigButtonSizes(this.smallSize.intValue(), this.midSize.intValue());
        }
    }
}
