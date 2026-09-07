package com.playon.bridge.common.util;

import android.os.Looper;
import com.playon.bridge.common.Log;
import java.util.IllegalFormatException;

/* JADX INFO: loaded from: classes6.dex */
public final class Preconditions {
    public static final String EMPTY_ARGUMENTS = "";
    private static final String TAG = Log.makeTag("Precondition");

    private Preconditions() {
    }

    public static void checkArgument(boolean z) {
        checkArgumentInternal(z, true, "Illegal argument.", "");
    }

    public static void checkArgument(boolean z, String str) {
        checkArgumentInternal(z, true, str, "");
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        checkArgumentInternal(z, true, str, objArr);
    }

    public static void checkState(boolean z) {
        checkStateInternal(z, true, "Illegal state.", "");
    }

    public static void checkState(boolean z, String str) {
        checkStateInternal(z, true, str, "");
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        checkStateInternal(z, true, str, objArr);
    }

    public static void checkNotNull(Object obj) {
        checkNotNullInternal(obj, true, "Object can not be null.", "");
    }

    public static void checkNotNull(Object obj, String str) {
        checkNotNullInternal(obj, true, str, "");
    }

    public static void checkNotNull(Object obj, String str, Object... objArr) {
        checkNotNullInternal(obj, true, str, objArr);
    }

    public static void checkUiThread() {
        checkUiThreadInternal(true, "This method must be called from the UI thread.", "");
    }

    public static void checkUiThread(String str) {
        checkUiThreadInternal(true, str, "");
    }

    public static void checkUiThread(String str, Object... objArr) {
        checkUiThreadInternal(true, str, objArr);
    }

    public static final class NoThrow {
        private static volatile boolean sStrictMode;

        public static void setStrictMode(boolean z) {
            sStrictMode = z;
        }

        public static boolean checkArgument(boolean z) {
            return Preconditions.checkArgumentInternal(z, sStrictMode, "Illegal argument", "");
        }

        public static boolean checkArgument(boolean z, String str) {
            return Preconditions.checkArgumentInternal(z, sStrictMode, str, "");
        }

        public static boolean checkArgument(boolean z, String str, Object... objArr) {
            return Preconditions.checkArgumentInternal(z, sStrictMode, str, objArr);
        }

        public static boolean checkState(boolean z) {
            return Preconditions.checkStateInternal(z, sStrictMode, "Illegal state.", "");
        }

        public static boolean checkState(boolean z, String str) {
            return Preconditions.checkStateInternal(z, sStrictMode, str, "");
        }

        public static boolean checkState(boolean z, String str, Object... objArr) {
            return Preconditions.checkStateInternal(z, sStrictMode, str, objArr);
        }

        public static boolean checkNotNull(Object obj) {
            return Preconditions.checkNotNullInternal(obj, sStrictMode, "Object can not be null.", "");
        }

        public static boolean checkNotNull(Object obj, String str) {
            return Preconditions.checkNotNullInternal(obj, sStrictMode, str, "");
        }

        public static boolean checkNotNull(Object obj, String str, Object... objArr) {
            return Preconditions.checkNotNullInternal(obj, sStrictMode, str, objArr);
        }

        public static boolean checkUiThread() {
            return Preconditions.checkUiThreadInternal(sStrictMode, "This method must be called from the UI thread.", "");
        }

        public static boolean checkUiThread(String str) {
            return Preconditions.checkUiThreadInternal(sStrictMode, str, "");
        }

        public static boolean checkUiThread(String str, Object... objArr) {
            return Preconditions.checkUiThreadInternal(false, str, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkArgumentInternal(boolean z, boolean z2, String str, Object... objArr) {
        if (z) {
            return true;
        }
        String str2 = format(str, objArr);
        if (z2) {
            throw new IllegalArgumentException(str2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkStateInternal(boolean z, boolean z2, String str, Object... objArr) {
        if (z) {
            return true;
        }
        String str2 = format(str, objArr);
        if (z2) {
            throw new IllegalStateException(str2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkNotNullInternal(Object obj, boolean z, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String str2 = format(str, objArr);
        if (z) {
            throw new NullPointerException(str2);
        }
        Log.i(TAG, str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkUiThreadInternal(boolean z, String str, Object... objArr) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            return true;
        }
        String str2 = format(str, objArr);
        if (z) {
            throw new IllegalStateException(str2);
        }
        return false;
    }

    private static String format(String str, Object... objArr) {
        String strValueOf = String.valueOf(str);
        try {
            return String.format(strValueOf, objArr);
        } catch (IllegalFormatException unused) {
            return strValueOf;
        }
    }
}
