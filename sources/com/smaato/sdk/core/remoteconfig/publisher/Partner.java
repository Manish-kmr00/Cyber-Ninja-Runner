package com.smaato.sdk.core.remoteconfig.publisher;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.TextUtils;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class Partner {
    public static final String SMAATO_PARTNER_NAME = "SMAATO";
    private final double bidAdjustment;
    private final String name;

    private Partner(String str, double d) {
        this.name = (String) Objects.requireNonNull(str);
        this.bidAdjustment = d;
    }

    public double getBidAdjustment() {
        return this.bidAdjustment;
    }

    public String getName() {
        return this.name;
    }

    public boolean isSmaato() {
        return SMAATO_PARTNER_NAME.equalsIgnoreCase(this.name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Partner.class != obj.getClass()) {
            return false;
        }
        Partner partner = (Partner) obj;
        if (Double.compare(partner.bidAdjustment, this.bidAdjustment) != 0) {
            return false;
        }
        return this.name.equals(partner.name);
    }

    public int hashCode() {
        return Objects.hash(this.name, Double.valueOf(this.bidAdjustment));
    }

    static Set<Partner> getPartners(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        HashSet hashSet = new HashSet(length);
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                hashSet.add(new Builder(jSONObjectOptJSONObject).build());
            }
        }
        return hashSet;
    }

    static class Builder {
        private Double bidAdjustment;
        private String name;

        Builder() {
            this.name = Partner.SMAATO_PARTNER_NAME;
            this.bidAdjustment = Double.valueOf(100.0d);
        }

        Builder(JSONObject jSONObject) {
            this.name = jSONObject.optString("name", null);
            if (jSONObject.optDouble("bidAdjustment", -1.0d) != -1.0d) {
                this.bidAdjustment = Double.valueOf(jSONObject.optDouble("bidAdjustment"));
            }
        }

        Partner build() {
            if (TextUtils.isEmpty(this.name)) {
                this.name = Partner.SMAATO_PARTNER_NAME;
            }
            Double d = this.bidAdjustment;
            if (d == null) {
                this.bidAdjustment = Double.valueOf(100.0d);
            } else if (d.doubleValue() > 200.0d) {
                this.bidAdjustment = Double.valueOf(200.0d);
            } else if (this.bidAdjustment.doubleValue() < 0.0d) {
                this.bidAdjustment = Double.valueOf(100.0d);
            }
            return new Partner(this.name, this.bidAdjustment.doubleValue());
        }
    }
}
