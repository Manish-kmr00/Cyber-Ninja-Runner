package net.pubnative.lite.sdk.vpaid.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.models.ContentInfo;
import net.pubnative.lite.sdk.models.PositionX;
import net.pubnative.lite.sdk.models.PositionY;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.vpaid.models.vast.Icon;
import net.pubnative.lite.sdk.vpaid.models.vast.IconClickTracking;
import net.pubnative.lite.sdk.vpaid.models.vast.IconViewTracking;

/* JADX INFO: loaded from: classes6.dex */
public class Utils {
    private static final String TAG = "Utils";
    private static boolean debugMode = true;

    public enum StretchOption {
        NONE,
        STRETCH,
        NO_STRETCH
    }

    public static void setDebugMode(boolean z) {
        debugMode = z;
    }

    public static boolean isDebug() {
        return debugMode;
    }

    public static boolean isOnline(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable();
        } catch (Exception e) {
            HyBid.reportException(e);
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isEmulator() {
        return Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK") || Build.MANUFACTURER.contains("Genymotion");
    }

    public static float getSystemVolume(Context context) {
        AudioManager audioManager;
        if (context == null || (audioManager = (AudioManager) context.getSystemService("audio")) == null) {
            return 1.0f;
        }
        return Math.round((audioManager.getStreamVolume(3) * 100.0f) / audioManager.getStreamMaxVolume(3)) / 100.0f;
    }

    public static boolean isPhoneMuted(Context context) {
        AudioManager audioManager;
        return (context == null || (audioManager = (AudioManager) context.getSystemService("audio")) == null || audioManager.getRingerMode() != 0) ? false : true;
    }

    public static FrameLayout.LayoutParams calculateNewLayoutParams(FrameLayout.LayoutParams layoutParams, int i, int i2, int i3, int i4, StretchOption stretchOption) {
        float f;
        int i5;
        layoutParams.gravity = 17;
        float f2 = 0.0f;
        if (i == i2) {
            if (i3 == i4) {
                layoutParams.width = i3;
                layoutParams.height = i4;
            } else if (i3 > i4) {
                layoutParams.height = i4;
                layoutParams.width = (int) ((i / i2) * i4);
                int i6 = i3 - layoutParams.width;
                if (layoutParams.width != 0) {
                    f = i6 * 100.0f;
                    i5 = layoutParams.width;
                    f2 = f / i5;
                }
            } else {
                layoutParams.width = i3;
                layoutParams.height = (int) ((i2 / i) * i3);
                int i7 = i4 - layoutParams.height;
                if (layoutParams.height != 0) {
                    f = i7 * 100.0f;
                    i5 = layoutParams.height;
                    f2 = f / i5;
                }
            }
        } else if (i > i2) {
            layoutParams.width = i3;
            layoutParams.height = (int) ((i2 / i) * i3);
            if (layoutParams.height > i4) {
                float f3 = i4 / layoutParams.height;
                layoutParams.height = i4;
                layoutParams.width = (int) (layoutParams.width * f3);
            }
            int i8 = i4 - layoutParams.height;
            if (layoutParams.height != 0) {
                f = i8 * 100.0f;
                i5 = layoutParams.height;
                f2 = f / i5;
            }
        } else {
            layoutParams.height = i4;
            layoutParams.width = (int) ((i / i2) * i4);
            if (layoutParams.width > i3) {
                float f4 = i3 / layoutParams.width;
                layoutParams.width = i3;
                layoutParams.height = (int) (layoutParams.height * f4);
            }
            int i9 = i3 - layoutParams.width;
            if (layoutParams.width != 0) {
                f = i9 * 100.0f;
                i5 = layoutParams.width;
                f2 = f / i5;
            }
        }
        int i10 = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$vpaid$utils$Utils$StretchOption[stretchOption.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                layoutParams.width = i3;
                layoutParams.height = i4;
            }
        } else if (f2 < 11.0f) {
            layoutParams.width = i3;
            layoutParams.height = i4;
        }
        return layoutParams;
    }

    /* JADX INFO: renamed from: net.pubnative.lite.sdk.vpaid.utils.Utils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$vpaid$utils$Utils$StretchOption;

        static {
            int[] iArr = new int[StretchOption.values().length];
            $SwitchMap$net$pubnative$lite$sdk$vpaid$utils$Utils$StretchOption = iArr;
            try {
                iArr[StretchOption.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$vpaid$utils$Utils$StretchOption[StretchOption.STRETCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$vpaid$utils$Utils$StretchOption[StretchOption.NO_STRETCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static String readAssets(AssetManager assetManager, String str) throws IOException {
        return getStringFromStream(assetManager.open(str));
    }

    public static String getStringFromStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toString("UTF-8");
            }
        }
    }

    public static Integer parseDuration(String str) {
        try {
            String[] strArrSplit = str.split(":");
            int i = Integer.parseInt(strArrSplit[0]);
            return Integer.valueOf(Double.valueOf(strArrSplit[2]).intValue() + (Integer.parseInt(strArrSplit[1]) * 60) + (i * 3600));
        } catch (RuntimeException e) {
            HyBid.reportException((Exception) e);
            Logger.e(TAG, "Error while parsing ad duration");
            return null;
        }
    }

    public static int parsePercent(String str) {
        return Integer.parseInt(str.replace("%", "").trim());
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0168  */
    public static ContentInfo parseContentInfo(Icon icon) {
        int i;
        int i2;
        int i3;
        int i4;
        if (icon == null) {
            return null;
        }
        String text = "";
        String text2 = (icon.getStaticResources() == null || icon.getStaticResources().isEmpty() || TextUtils.isEmpty(icon.getStaticResources().get(0).getText())) ? "" : icon.getStaticResources().get(0).getText();
        if (icon.getIconClicks() != null && icon.getIconClicks().getIconClickThrough() != null && !TextUtils.isEmpty(icon.getIconClicks().getIconClickThrough().getText())) {
            text = icon.getIconClicks().getIconClickThrough().getText();
        }
        String str = text;
        ArrayList arrayList = new ArrayList();
        if (icon.getIconClicks() != null && icon.getIconClicks().getIconClickTrackingList() != null && !icon.getIconClicks().getIconClickTrackingList().isEmpty()) {
            for (IconClickTracking iconClickTracking : icon.getIconClicks().getIconClickTrackingList()) {
                if (!TextUtils.isEmpty(iconClickTracking.getText())) {
                    arrayList.add(iconClickTracking.getText());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (icon.getIconViewTrackingList() != null && !icon.getIconViewTrackingList().isEmpty()) {
            for (IconViewTracking iconViewTracking : icon.getIconViewTrackingList()) {
                if (!TextUtils.isEmpty(iconViewTracking.getText())) {
                    arrayList2.add(iconViewTracking.getText());
                }
            }
        }
        PositionX positionX = PositionX.LEFT;
        PositionY positionY = PositionY.TOP;
        if (!TextUtils.isEmpty(icon.getXPosition()) && icon.getXPosition().equals(PositionX.RIGHT.getValue())) {
            positionX = PositionX.RIGHT;
        }
        PositionX positionX2 = positionX;
        PositionY positionY2 = (TextUtils.isEmpty(icon.getYPosition()) || !icon.getYPosition().equals(PositionY.BOTTOM.getValue())) ? positionY : PositionY.BOTTOM;
        if (TextUtils.isEmpty(icon.getWidth()) || TextUtils.isEmpty(icon.getHeight())) {
            i = -1;
            i2 = -1;
        } else {
            try {
                i3 = Integer.parseInt(icon.getWidth());
                try {
                    i4 = Integer.parseInt(icon.getHeight());
                } catch (RuntimeException e) {
                    e = e;
                    HyBid.reportException((Exception) e);
                    i4 = -1;
                }
            } catch (RuntimeException e2) {
                e = e2;
                i3 = -1;
            }
            if (i3 == -1 || i4 == -1) {
                i = -1;
                i2 = -1;
            } else {
                i2 = i4;
                i = i3;
            }
        }
        if (TextUtils.isEmpty(text2)) {
            return null;
        }
        return new ContentInfo(text2, str, "", i, i2, positionX2, positionY2, arrayList2, arrayList);
    }
}
