package net.pubnative.lite.sdk.vpaid.models.vast;

import android.text.TextUtils;
import net.pubnative.lite.sdk.vpaid.xml.Attribute;
import net.pubnative.lite.sdk.vpaid.xml.Text;

/* JADX INFO: loaded from: classes7.dex */
public class Pricing {

    @Attribute
    private String currency;

    @Attribute
    private String model;

    @Text
    private String text;

    public String getModel() {
        return this.model;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getText() {
        return TextUtils.isEmpty(this.text) ? "" : this.text.trim();
    }
}
