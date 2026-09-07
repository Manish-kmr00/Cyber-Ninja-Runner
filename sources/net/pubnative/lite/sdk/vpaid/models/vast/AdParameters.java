package net.pubnative.lite.sdk.vpaid.models.vast;

import android.text.TextUtils;
import net.pubnative.lite.sdk.vpaid.xml.Attribute;
import net.pubnative.lite.sdk.vpaid.xml.Text;

/* JADX INFO: loaded from: classes13.dex */
public class AdParameters {

    @Text
    private String text;

    @Attribute
    private String xmlEncoded;

    public String getXmlEncoded() {
        return this.xmlEncoded;
    }

    public String getText() {
        return TextUtils.isEmpty(this.text) ? "" : this.text.trim();
    }
}
