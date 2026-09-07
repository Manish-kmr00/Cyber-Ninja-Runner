package net.pubnative.lite.sdk.vpaid.models.vast;

import android.text.TextUtils;
import net.pubnative.lite.sdk.vpaid.xml.Text;

/* JADX INFO: loaded from: classes8.dex */
public class Duration {

    @Text
    private String text;

    public String getText() {
        if (!TextUtils.isEmpty(this.text)) {
            return this.text.trim();
        }
        return "00:00:10";
    }
}
