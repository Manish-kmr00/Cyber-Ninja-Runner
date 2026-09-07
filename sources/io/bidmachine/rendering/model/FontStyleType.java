package io.bidmachine.rendering.model;

import com.adjust.sdk.Constants;
import io.bidmachine.rendering.utils.KeyHolder;
import io.bidmachine.rendering.utils.Utils;

/* JADX INFO: loaded from: classes6.dex */
public enum FontStyleType implements KeyHolder {
    Normal(Constants.NORMAL, 0),
    Bold("bold", 1),
    Italic("italic", 2),
    BoldItalic("bold_italic", 3);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12414a;
    private final int b;

    FontStyleType(String key, int typeface) {
        this.f12414a = key;
        this.b = typeface;
    }

    public static FontStyleType fromKey(String key) {
        return (FontStyleType) Utils.fromKey(key, values());
    }

    @Override // io.bidmachine.rendering.utils.KeyHolder
    public String getKey() {
        return this.f12414a;
    }

    public int getTypeface() {
        return this.b;
    }
}
