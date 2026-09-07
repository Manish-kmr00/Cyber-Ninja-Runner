package com.smaato.sdk.richmedia.mraid.dataprovider;

import android.graphics.Rect;
import com.smaato.sdk.core.util.Joiner;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.richmedia.mraid.MraidUtils;
import com.smaato.sdk.richmedia.mraid.exception.MraidException;
import com.smaato.sdk.richmedia.util.RectUtils;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class MraidResizeProperties {
    final boolean allowOffscreen;
    final int heightDp;
    final int offsetXDp;
    final int offsetYDp;
    final int widthDp;

    private MraidResizeProperties(int i, int i2, int i3, int i4, boolean z) {
        this.widthDp = i;
        this.heightDp = i2;
        this.offsetXDp = i3;
        this.offsetYDp = i4;
        this.allowOffscreen = z;
    }

    public Rect getRectRelativeToMaxSize(Rect rect, Rect rect2) {
        int i = this.offsetXDp;
        int i2 = this.offsetYDp;
        if (!rect.isEmpty()) {
            i += rect.left;
            i2 += rect.top;
        }
        Rect rect3 = new Rect(i, i2, this.widthDp + i, this.heightDp + i2);
        return this.allowOffscreen ? rect3 : RectUtils.adjust(rect3, rect2);
    }

    public static class Builder {
        private Boolean allowOffscreen;
        private Integer heightDp;
        private Integer offsetXDp;
        private Integer offsetYDp;
        private Integer widthDp;

        public Builder(Map<String, String> map) {
            this.allowOffscreen = Boolean.FALSE;
            String str = map.get("width");
            if (!TextUtils.isEmpty(str)) {
                Float optFloat = MraidUtils.parseOptFloat(str);
                this.widthDp = optFloat == null ? null : Integer.valueOf(optFloat.intValue());
            }
            String str2 = map.get("height");
            if (!TextUtils.isEmpty(str2)) {
                Float optFloat2 = MraidUtils.parseOptFloat(str2);
                this.heightDp = optFloat2 == null ? null : Integer.valueOf(optFloat2.intValue());
            }
            String str3 = map.get("offsetX");
            if (!TextUtils.isEmpty(str3)) {
                Float optFloat3 = MraidUtils.parseOptFloat(str3);
                this.offsetXDp = optFloat3 == null ? null : Integer.valueOf(optFloat3.intValue());
            }
            String str4 = map.get("offsetY");
            if (!TextUtils.isEmpty(str4)) {
                Float optFloat4 = MraidUtils.parseOptFloat(str4);
                this.offsetYDp = optFloat4 != null ? Integer.valueOf(optFloat4.intValue()) : null;
            }
            String str5 = map.get("allowOffscreen");
            if (TextUtils.isEmpty(str5)) {
                return;
            }
            this.allowOffscreen = Boolean.valueOf(Boolean.parseBoolean(str5));
        }

        public MraidResizeProperties build() throws MraidException {
            ArrayList arrayList = new ArrayList();
            if (this.widthDp == null) {
                arrayList.add("width");
            }
            if (this.heightDp == null) {
                arrayList.add("height");
            }
            if (this.offsetXDp == null) {
                arrayList.add("offsetX");
            }
            if (this.offsetYDp == null) {
                arrayList.add("offsetY");
            }
            if (!arrayList.isEmpty()) {
                throw new MraidException("Missing required parameter(s): " + Joiner.join(", ", arrayList));
            }
            if (this.widthDp.intValue() < 50 || this.heightDp.intValue() < 50) {
                throw new MraidException("Expected resize dimension should be >= 50 dp");
            }
            return new MraidResizeProperties(this.widthDp.intValue(), this.heightDp.intValue(), this.offsetXDp.intValue(), this.offsetYDp.intValue(), this.allowOffscreen.booleanValue());
        }
    }
}
