package net.pubnative.lite.sdk.models;

import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public enum ContentInfoIconXPosition {
    LEFT("left"),
    RIGHT("right");

    public final String horizontalPosition;

    ContentInfoIconXPosition(String str) {
        this.horizontalPosition = str;
    }

    public static ContentInfoIconXPosition fromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        ContentInfoIconXPosition contentInfoIconXPosition = LEFT;
        if (lowerCase.equals(contentInfoIconXPosition.horizontalPosition)) {
            return contentInfoIconXPosition;
        }
        ContentInfoIconXPosition contentInfoIconXPosition2 = RIGHT;
        return lowerCase.equals(contentInfoIconXPosition2.horizontalPosition) ? contentInfoIconXPosition2 : contentInfoIconXPosition;
    }

    public static ContentInfoIconXPosition getDefaultXPosition() {
        return LEFT;
    }
}
