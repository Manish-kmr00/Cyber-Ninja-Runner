package com.amazon.device.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import io.bidmachine.iab.vast.tags.VastAttributes;

/* JADX INFO: loaded from: classes13.dex */
public class DtbDeviceDataRetriever {
    public static final String ORIENTATION_LANDSCAPE = "landscape";
    public static final String ORIENTATION_PORTRAIT = "portrait";
    public static final String ORIENTATION_UNKNOWN = "unknown";
    private static final int SMALLEST_TABLET_SCREEN_WIDTH = 600;
    private static int[][] rotationArray = {new int[]{1, 0, 9, 8}, new int[]{0, 9, 8, 1}};

    public static String getScreenSize(DisplayMetrics displayMetrics, String str) {
        try {
            ((WindowManager) AdRegistration.getContext().getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            int iPixelsToDeviceIndependenPixels = DTBAdUtil.pixelsToDeviceIndependenPixels(i);
            int iPixelsToDeviceIndependenPixels2 = DTBAdUtil.pixelsToDeviceIndependenPixels(i2);
            if (str.equals("landscape")) {
                if (iPixelsToDeviceIndependenPixels < iPixelsToDeviceIndependenPixels2) {
                    iPixelsToDeviceIndependenPixels = iPixelsToDeviceIndependenPixels2;
                    iPixelsToDeviceIndependenPixels2 = iPixelsToDeviceIndependenPixels;
                }
            } else if (iPixelsToDeviceIndependenPixels > iPixelsToDeviceIndependenPixels2) {
                iPixelsToDeviceIndependenPixels = iPixelsToDeviceIndependenPixels2;
                iPixelsToDeviceIndependenPixels2 = iPixelsToDeviceIndependenPixels;
            }
            return String.valueOf(iPixelsToDeviceIndependenPixels) + VastAttributes.HORIZONTAL_POSITION + String.valueOf(iPixelsToDeviceIndependenPixels2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getOrientation(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 0 || rotation == 2) {
            return "portrait";
        }
        return "landscape";
    }

    public static String getCanonicalOrientation(Context context) {
        int iDetermineCanonicalScreenOrientation = determineCanonicalScreenOrientation(context);
        if (iDetermineCanonicalScreenOrientation != 0) {
            if (iDetermineCanonicalScreenOrientation != 1) {
                if (iDetermineCanonicalScreenOrientation != 8) {
                    if (iDetermineCanonicalScreenOrientation != 9) {
                        return "unknown";
                    }
                }
            }
            return "portrait";
        }
        return "landscape";
    }

    private static int determineCanonicalScreenOrientation(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        int i = context.getResources().getConfiguration().orientation;
        char c = 0;
        if (i != 1 ? i != 2 || rotation == 1 || rotation == 3 : rotation == 0 || rotation == 2) {
            c = 1;
        }
        return rotationArray[c ^ 1][rotation];
    }

    public static boolean isTablet() {
        return AdRegistration.getContext().getResources().getConfiguration().smallestScreenWidthDp >= 600;
    }
}
