package net.pubnative.lite.sdk.mraid.internal;

import android.util.Log;
import com.json.b9;

/* JADX INFO: loaded from: classes5.dex */
public class MRAIDLog {
    private static LOG_LEVEL LEVEL = LOG_LEVEL.warning;
    private static final String TAG = "HyBid-MRAID";

    public enum LOG_LEVEL {
        verbose(1),
        debug(2),
        info(3),
        warning(4),
        error(5),
        none(6);

        private final int value;

        LOG_LEVEL(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static void d(String str) {
        if (LEVEL.getValue() <= LOG_LEVEL.debug.getValue()) {
            Log.d(TAG, str);
        }
    }

    public static void e(String str) {
        if (LEVEL.getValue() <= LOG_LEVEL.error.getValue()) {
            Log.e(TAG, str);
        }
    }

    public static void i(String str) {
        if (LEVEL.getValue() <= LOG_LEVEL.info.getValue()) {
            Log.i(TAG, str);
        }
    }

    public static void v(String str) {
        if (LEVEL.getValue() <= LOG_LEVEL.verbose.getValue()) {
            Log.v(TAG, str);
        }
    }

    public static void w(String str) {
        if (LEVEL.getValue() <= LOG_LEVEL.warning.getValue()) {
            Log.w(TAG, str);
        }
    }

    public static void d(String str, String str2) {
        if (LEVEL.getValue() <= LOG_LEVEL.debug.getValue()) {
            Log.d(TAG, b9.i.d + str + "] " + str2);
        }
    }

    public static void e(String str, String str2) {
        if (LEVEL.getValue() <= LOG_LEVEL.error.getValue()) {
            Log.e(TAG, b9.i.d + str + "] " + str2);
        }
    }

    public static void i(String str, String str2) {
        if (LEVEL.getValue() <= LOG_LEVEL.info.getValue()) {
            Log.i(TAG, b9.i.d + str + "] " + str2);
        }
    }

    public static void v(String str, String str2) {
        if (LEVEL.getValue() <= LOG_LEVEL.verbose.getValue()) {
            Log.v(TAG, b9.i.d + str + "] " + str2);
        }
    }

    public static void w(String str, String str2) {
        if (LEVEL.getValue() <= LOG_LEVEL.warning.getValue()) {
            Log.w(TAG, b9.i.d + str + "] " + str2);
        }
    }

    public static void setLoggingLevel(LOG_LEVEL log_level) {
        Log.i(TAG, "Changing logging level from :" + LEVEL + ". To:" + log_level);
        LEVEL = log_level;
    }

    public static LOG_LEVEL getLoggingLevel() {
        return LEVEL;
    }
}
