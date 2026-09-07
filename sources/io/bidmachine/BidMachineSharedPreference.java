package io.bidmachine;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import io.bidmachine.core.Utils;
import io.bidmachine.protobuf.Extras;
import io.bidmachine.protobuf.InitResponse;
import io.bidmachine.utils.DeviceUtils;
import io.bidmachine.utils.SharedPreferenceUtils;
import io.bidmachine.utils.ThrowableRunnable;
import java.util.UUID;

/* JADX INFO: loaded from: classes12.dex */
class BidMachineSharedPreference {
    private static final String KEY_BM_IFV = "bid_machine_ifv";
    private static final String KEY_FIRST_LAUNCH_TIME = "first_app_launch_ms";
    private static final String KEY_HW_INFO = "hw_info_";
    private static final String KEY_INIT_DATA = "initData";
    private static final String KEY_INIT_DATA_SESSION_ID = "init_data_session_id";
    private static final String KEY_INIT_EXTRAS = "init_extras";
    private static final String KEY_SESSION_COUNT = "session_count";
    private static final String KEY_USER_AGENT = "ua";
    private static final String KEY_USER_AGENT_DEVICE_OS = "ua_device_os";
    private static final String KEY_USER_AGENT_EXPIRATION = "ua_exp";
    private static final String NAME = "BidMachinePref";
    private static SharedPreferences sharedPreferences;

    BidMachineSharedPreference() {
    }

    static String obtainBMIFV(Context context) {
        SharedPreferences sharedPreferences2 = getSharedPreferences(context);
        String string = null;
        try {
            string = sharedPreferences2.getString(KEY_BM_IFV, null);
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        sharedPreferences2.edit().putString(KEY_BM_IFV, string2).apply();
        return string2;
    }

    static long obtainFirstLaunchTimeMs(Context context) {
        long j;
        SharedPreferences sharedPreferences2 = getSharedPreferences(context);
        try {
            j = sharedPreferences2.getLong(KEY_FIRST_LAUNCH_TIME, 0L);
        } catch (Exception unused) {
            j = 0;
        }
        if (j != 0) {
            return j;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        sharedPreferences2.edit().putLong(KEY_FIRST_LAUNCH_TIME, jCurrentTimeMillis).apply();
        return jCurrentTimeMillis;
    }

    static void incrementSessionCount(final Context context) {
        Utils.runCatching(new ThrowableRunnable() { // from class: io.bidmachine.BidMachineSharedPreference$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.ThrowableRunnable
            public final void run() {
                Context context2 = context;
                BidMachineSharedPreference.storeSessionCount(context2, BidMachineSharedPreference.getSessionCount(context2) + 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void storeSessionCount(final Context context, final int i) {
        Utils.runCatching(new ThrowableRunnable() { // from class: io.bidmachine.BidMachineSharedPreference$$ExternalSyntheticLambda1
            @Override // io.bidmachine.utils.ThrowableRunnable
            public final void run() {
                BidMachineSharedPreference.getSharedPreferences(context).edit().putInt(BidMachineSharedPreference.KEY_SESSION_COUNT, i).apply();
            }
        });
    }

    static int getSessionCount(Context context) {
        return SharedPreferenceUtils.optInt(getSharedPreferences(context), KEY_SESSION_COUNT, 0);
    }

    static void storeInitResponse(Context context, InitResponse initResponse, String str) {
        try {
            SharedPreferenceUtils.putString(getSharedPreferences(context), KEY_INIT_DATA, Base64.encodeToString(initResponse.toByteArray(), 0));
            SharedPreferenceUtils.putString(getSharedPreferences(context), KEY_INIT_DATA_SESSION_ID, str);
        } catch (Exception unused) {
        }
    }

    static InitResponse getInitResponse(Context context) {
        SharedPreferences sharedPreferences2 = getSharedPreferences(context);
        try {
            return InitResponse.parseFrom(Base64.decode(sharedPreferences2.getString(KEY_INIT_DATA, null), 0));
        } catch (Exception unused) {
            SharedPreferenceUtils.remove(sharedPreferences2, KEY_INIT_DATA);
            return null;
        }
    }

    static String getInitResponseSessionId(Context context) {
        String strOptString = SharedPreferenceUtils.optString(getSharedPreferences(context), KEY_INIT_DATA_SESSION_ID, null);
        return strOptString != null ? strOptString : "";
    }

    static void storeInitExtras(Context context, Extras extras) {
        try {
            SharedPreferenceUtils.putString(getSharedPreferences(context), KEY_INIT_EXTRAS, Base64.encodeToString(extras.toByteArray(), 0));
        } catch (Exception unused) {
        }
    }

    static Extras getInitExtras(Context context) {
        SharedPreferences sharedPreferences2 = getSharedPreferences(context);
        try {
            return Extras.parseFrom(Base64.decode(SharedPreferenceUtils.optString(sharedPreferences2, KEY_INIT_EXTRAS, null), 0));
        } catch (Exception unused) {
            SharedPreferenceUtils.remove(sharedPreferences2, KEY_INIT_EXTRAS);
            return null;
        }
    }

    static void clearInitExtras(Context context) {
        SharedPreferenceUtils.remove(getSharedPreferences(context), KEY_INIT_EXTRAS);
    }

    static String getValidUserAgent(Context context) {
        String userAgent = getUserAgent(context);
        if (TextUtils.isEmpty(userAgent) || !DeviceUtils.getOsVersion().equals(getUserAgentDeviceOs(context)) || getUserAgentExpirationMs(context) <= System.currentTimeMillis()) {
            return null;
        }
        return userAgent;
    }

    static void setValidUserAgent(Context context, String str, long j) {
        setUserAgent(context, str);
        setUserAgentDeviceOs(context, DeviceUtils.getOsVersion());
        setUserAgentExpirationMs(context, j);
    }

    static String getUserAgent(Context context) {
        return SharedPreferenceUtils.optString(getSharedPreferences(context), "ua", null);
    }

    static void setUserAgent(Context context, String str) {
        SharedPreferenceUtils.putString(getSharedPreferences(context), "ua", str);
    }

    static String getUserAgentDeviceOs(Context context) {
        return SharedPreferenceUtils.optString(getSharedPreferences(context), KEY_USER_AGENT_DEVICE_OS, null);
    }

    static void setUserAgentDeviceOs(Context context, String str) {
        SharedPreferenceUtils.putString(getSharedPreferences(context), KEY_USER_AGENT_DEVICE_OS, str);
    }

    static long getUserAgentExpirationMs(Context context) {
        return SharedPreferenceUtils.optLong(getSharedPreferences(context), KEY_USER_AGENT_EXPIRATION, -1L);
    }

    static void setUserAgentExpirationMs(Context context, long j) {
        SharedPreferenceUtils.putLong(getSharedPreferences(context), KEY_USER_AGENT_EXPIRATION, Long.valueOf(j));
    }

    static String getHwInfo(Context context, String str) {
        return SharedPreferenceUtils.optString(getSharedPreferences(context), KEY_HW_INFO + str, null);
    }

    static void setHwInfo(Context context, String str, String str2) {
        SharedPreferenceUtils.putString(getSharedPreferences(context), KEY_HW_INFO + str, str2);
    }

    static SharedPreferences getSharedPreferences(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(NAME, 0);
        }
        return sharedPreferences;
    }

    static void clear(Context context) {
        SharedPreferenceUtils.clear(getSharedPreferences(context));
    }
}
