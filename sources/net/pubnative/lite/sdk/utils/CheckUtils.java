package net.pubnative.lite.sdk.utils;

/* JADX INFO: loaded from: classes6.dex */
public class CheckUtils {
    private static final String TAG = "CheckUtils";

    public static void checkArgument(boolean z, String str) {
        checkArgumentImpl(z, true, str);
    }

    public static class NoThrow {
        private static boolean sStrictMode;

        public static void setStrictMode(boolean z) {
            sStrictMode = z;
        }

        public static boolean checkArgument(boolean z, String str) {
            return CheckUtils.checkArgumentImpl(z, sStrictMode, str);
        }

        public static boolean checkNotNull(Object obj, String str) {
            return CheckUtils.checkNotNullImpl(obj, sStrictMode, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkArgumentImpl(boolean z, boolean z2, String str) {
        if (z) {
            return true;
        }
        if (z2) {
            throw new IllegalArgumentException(str);
        }
        Logger.e(TAG, str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkNotNullImpl(Object obj, boolean z, String str) {
        if (obj != null) {
            return true;
        }
        if (z) {
            throw new NullPointerException(str);
        }
        Logger.e(TAG, str);
        return false;
    }
}
