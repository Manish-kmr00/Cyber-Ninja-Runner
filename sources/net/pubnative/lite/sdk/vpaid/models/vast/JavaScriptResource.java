package net.pubnative.lite.sdk.vpaid.models.vast;

import android.text.TextUtils;
import net.pubnative.lite.sdk.vpaid.xml.Attribute;
import net.pubnative.lite.sdk.vpaid.xml.Text;

/* JADX INFO: loaded from: classes7.dex */
public class JavaScriptResource {

    @Attribute
    private String apiFramework;

    @Attribute
    private String browserOptional;

    @Text
    private String text;

    public String getApiFramework() {
        return this.apiFramework;
    }

    public String isBrowserOptional() {
        return this.browserOptional;
    }

    public String getText() {
        return TextUtils.isEmpty(this.text) ? "" : this.text.trim();
    }
}
