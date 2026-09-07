package com.smaato.sdk.richmedia.mraid.dataprovider;

import com.smaato.sdk.core.util.Joiner;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.richmedia.mraid.MraidUtils;
import com.smaato.sdk.richmedia.mraid.exception.MraidException;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class MraidExpandProperties {
    public final int heightDp;
    public final boolean isModal;
    public final int widthDp;

    private MraidExpandProperties(int i, int i2) {
        this.isModal = true;
        this.widthDp = i;
        this.heightDp = i2;
    }

    public static class Builder {
        private Integer heightDp;
        private Integer widthDp;

        public Builder(Map<String, String> map) {
            String str = map.get("width");
            if (!TextUtils.isEmpty(str)) {
                Float optFloat = MraidUtils.parseOptFloat(str);
                this.widthDp = optFloat == null ? null : Integer.valueOf(optFloat.intValue());
            }
            String str2 = map.get("height");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Float optFloat2 = MraidUtils.parseOptFloat(str2);
            this.heightDp = optFloat2 != null ? Integer.valueOf(optFloat2.intValue()) : null;
        }

        public MraidExpandProperties build() throws MraidException {
            ArrayList arrayList = new ArrayList();
            if (this.widthDp == null) {
                arrayList.add("width");
            }
            if (this.heightDp == null) {
                arrayList.add("height");
            }
            if (!arrayList.isEmpty()) {
                throw new MraidException("Missing required parameter(s): " + Joiner.join(", ", arrayList));
            }
            if (this.widthDp.intValue() <= 0) {
                arrayList.add("width");
            }
            if (this.heightDp.intValue() <= 0) {
                arrayList.add("height");
            }
            if (!arrayList.isEmpty()) {
                throw new MraidException("Invalid parameter(s): " + Joiner.join(", ", arrayList));
            }
            return new MraidExpandProperties(this.widthDp.intValue(), this.heightDp.intValue());
        }
    }
}
