package net.pubnative.lite.sdk.vpaid.models.vast;

import android.text.TextUtils;
import net.pubnative.lite.sdk.vpaid.xml.Attribute;
import net.pubnative.lite.sdk.vpaid.xml.Text;

/* JADX INFO: loaded from: classes10.dex */
public class ClosedCaptionFile {

    @Attribute
    private String language;

    @Text
    private String text;

    @Attribute
    private String type;

    public String isType() {
        return this.type;
    }

    public String isLanguage() {
        return this.language;
    }

    public String getText() {
        return TextUtils.isEmpty(this.text) ? "" : this.text.trim();
    }
}
