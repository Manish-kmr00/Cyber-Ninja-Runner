package net.pubnative.lite.sdk.mraid.properties;

import com.json.b9;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public final class MRAIDResizeProperties {
    public static final int CUSTOM_CLOSE_POSITION_BOTTOM_CENTER = 5;
    public static final int CUSTOM_CLOSE_POSITION_BOTTOM_LEFT = 4;
    public static final int CUSTOM_CLOSE_POSITION_BOTTOM_RIGHT = 6;
    public static final int CUSTOM_CLOSE_POSITION_CENTER = 3;
    public static final int CUSTOM_CLOSE_POSITION_TOP_CENTER = 1;
    public static final int CUSTOM_CLOSE_POSITION_TOP_LEFT = 0;
    public static final int CUSTOM_CLOSE_POSITION_TOP_RIGHT = 2;
    public boolean allowOffscreen;
    public int customClosePosition;
    public int height;
    public int offsetX;
    public int offsetY;
    public int width;

    public MRAIDResizeProperties() {
        this(0, 0, 0, 0, 2, true);
    }

    public MRAIDResizeProperties(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.width = i;
        this.height = i2;
        this.offsetX = i3;
        this.offsetY = i4;
        this.customClosePosition = i5;
        this.allowOffscreen = z;
    }

    public static int customClosePositionFromString(String str) {
        int iIndexOf = Arrays.asList(b9.e.c, "top-center", "top-right", "center", b9.e.e, "bottom-center", b9.e.d).indexOf(str);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        return 2;
    }
}
