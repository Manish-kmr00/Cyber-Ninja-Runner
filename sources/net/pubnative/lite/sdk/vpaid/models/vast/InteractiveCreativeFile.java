package net.pubnative.lite.sdk.vpaid.models.vast;

import android.text.TextUtils;
import net.pubnative.lite.sdk.vpaid.xml.Attribute;
import net.pubnative.lite.sdk.vpaid.xml.Text;

/* JADX INFO: loaded from: classes14.dex */
public class InteractiveCreativeFile {

    @Attribute
    private String apiFramework;

    @Text
    private String text;

    @Attribute
    private String type;

    @Attribute
    private boolean variableDuration;

    public String getType() {
        return this.type;
    }

    public String getApiFramework() {
        return this.apiFramework;
    }

    public boolean isVariableDuration() {
        return this.variableDuration;
    }

    public String getText() {
        return TextUtils.isEmpty(this.text) ? "" : this.text.trim();
    }
}
