package io.bidmachine.util;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import com.json.b9;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bH\u0007J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0007J\b\u0010\u001d\u001a\u00020\u0004H\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010 \u001a\u00020\u0004H\u0007J\u0012\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0017\u0010#\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010$J\u0017\u0010%\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0010J\u0010\u0010&\u001a\u00020'2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010)\u001a\u00020*2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0017\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010,J\u0017\u0010-\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010,J\u0017\u0010.\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010,J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0017\u00100\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010,J\u0010\u00101\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u00102\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0017\u00103\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010,R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u00064"}, d2 = {"Lio/bidmachine/util/DeviceUtils;", "", "()V", POBConstants.KEY_HWV, "", "isDeviceRooted", "", "Ljava/lang/Boolean;", "getActiveNetworkCapabilities", "Landroid/net/NetworkCapabilities;", "context", "Landroid/content/Context;", "getActiveNetworkInfo", "Landroid/net/NetworkInfo;", "getBatteryLevel", "", "(Landroid/content/Context;)Ljava/lang/Double;", "getBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBuildId", "getConfiguration", "Landroid/content/res/Configuration;", "getDeviceName", "getDisplayMetrics", "Landroid/util/DisplayMetrics;", "getHWV", "getKernelVersionThroughProcVersion", "getKernelVersionThroughUName", "getManufacturer", "getModel", "getOrientation", "", "getOsVersion", "getPhoneMCCMNC", "getPhoneOperatorName", "getScreenBrightness", "(Landroid/content/Context;)Ljava/lang/Integer;", "getScreenBrightnessRatio", "getScreenDensity", "", "getScreenOrientation", "getScreenSize", "Landroid/graphics/Point;", "isAirplaneModeOn", "(Landroid/content/Context;)Ljava/lang/Boolean;", "isBatterySaverEnabled", b9.i.k0, "isDarkModeEnabled", "isDoNotDisturbOn", "isLandscapeOrientation", "isNetworkAvailable", "isRingMuted", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DeviceUtils {
    public static final DeviceUtils INSTANCE = new DeviceUtils();
    private static String hwv;
    private static Boolean isDeviceRooted;

    private DeviceUtils() {
    }

    @JvmStatic
    public static final String getOsVersion() {
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        return RELEASE;
    }

    @JvmStatic
    public static final String getBuildId() {
        String ID = Build.ID;
        Intrinsics.checkNotNullExpressionValue(ID, "ID");
        return ID;
    }

    @JvmStatic
    public static final String getModel() {
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        return MODEL;
    }

    @JvmStatic
    public static final String getManufacturer() {
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        return MANUFACTURER;
    }

    @JvmStatic
    public static final DisplayMetrics getDisplayMetrics(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getDisplayMetrics(context);
    }

    @JvmStatic
    public static final Configuration getConfiguration(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getConfiguration(context);
    }

    @JvmStatic
    public static final boolean isNetworkAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isNetworkAvailable(context);
    }

    @Deprecated(message = "Use getActiveNetworkCapabilities instead", replaceWith = @ReplaceWith(expression = "DeviceUtils.getActiveNetworkCapabilities(context)", imports = {}))
    @JvmStatic
    public static final NetworkInfo getActiveNetworkInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getActiveNetworkInfo(context);
    }

    @JvmStatic
    public static final NetworkCapabilities getActiveNetworkCapabilities(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getActiveNetworkCapabilities(context);
    }

    @JvmStatic
    public static final int getOrientation(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getOrientation(context);
    }

    @JvmStatic
    public static final boolean isLandscapeOrientation(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isLandscapeOrientation(context);
    }

    @JvmStatic
    public static final int getScreenOrientation(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getScreenOrientation(context);
    }

    @JvmStatic
    public static final float getScreenDensity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getScreenDensity(context);
    }

    @JvmStatic
    public static final Point getScreenSize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getScreenSize(context);
    }

    @JvmStatic
    public static final Boolean isRingMuted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isRingMuted(context);
    }

    @JvmStatic
    public static final Boolean isCharging(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isCharging(context);
    }

    @JvmStatic
    public static final Double getBatteryLevel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getBatteryLevel(context);
    }

    @JvmStatic
    public static final Boolean isBatterySaverEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isBatterySaverEnabled(context);
    }

    @JvmStatic
    public static final boolean isDarkModeEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isDarkModeEnabled(context);
    }

    @JvmStatic
    public static final Boolean isAirplaneModeOn(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isAirplaneModeOn(context);
    }

    @JvmStatic
    public static final Boolean isDoNotDisturbOn(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isDoNotDisturbOn(context);
    }

    @JvmStatic
    public static final String getDeviceName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getDeviceName(context);
    }

    @JvmStatic
    public static final BluetoothAdapter getBluetoothAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getBluetoothAdapter(context);
    }

    @JvmStatic
    public static final Integer getScreenBrightness(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getScreenBrightness(context);
    }

    @JvmStatic
    public static final Double getScreenBrightnessRatio(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getScreenBrightnessRatio(context);
    }

    @JvmStatic
    public static final String getPhoneMCCMNC(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getPhoneMCCMNC(context);
    }

    @JvmStatic
    public static final String getPhoneOperatorName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getPhoneOperatorName(context);
    }

    @JvmStatic
    public static final boolean isDeviceRooted() {
        Boolean bool = isDeviceRooted;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = true;
        try {
            String[] strArr = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
            for (int i = 0; i < 8; i++) {
                if (new File(strArr[i]).exists()) {
                    isDeviceRooted = true;
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            if (new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine() == null) {
                z = false;
            }
            isDeviceRooted = Boolean.valueOf(z);
            if (processExec != null) {
                processExec.destroy();
            }
            return z;
        } catch (Exception unused2) {
            if (processExec != null) {
                processExec.destroy();
            }
            isDeviceRooted = false;
            return false;
        } catch (Throwable th) {
            if (processExec != null) {
                processExec.destroy();
            }
            throw th;
        }
    }

    @JvmStatic
    public static final String getHWV() throws Throwable {
        String str = hwv;
        if (str != null) {
            return str;
        }
        DeviceUtils deviceUtils = INSTANCE;
        String kernelVersionThroughProcVersion = deviceUtils.getKernelVersionThroughProcVersion();
        if (kernelVersionThroughProcVersion == null || kernelVersionThroughProcVersion.length() <= 0) {
            kernelVersionThroughProcVersion = deviceUtils.getKernelVersionThroughUName();
        }
        hwv = kernelVersionThroughProcVersion;
        return kernelVersionThroughProcVersion;
    }

    private final String getKernelVersionThroughProcVersion() throws Throwable {
        RandomAccessFile randomAccessFile;
        Throwable th;
        String line = null;
        try {
            randomAccessFile = new RandomAccessFile("/proc/version", "r");
            try {
                line = randomAccessFile.readLine();
            } catch (Exception unused) {
            } catch (Throwable th2) {
                th = th2;
                UtilsKt.closeSafely(randomAccessFile);
                throw th;
            }
        } catch (Exception unused2) {
            randomAccessFile = null;
        } catch (Throwable th3) {
            randomAccessFile = null;
            th = th3;
        }
        UtilsKt.closeSafely(randomAccessFile);
        return line;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0064  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private final String getKernelVersionThroughUName() throws Throwable {
        InputStreamReader inputStreamReader;
        ?? bufferedReader;
        Throwable th;
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec("uname -a");
            try {
                inputStreamReader = new InputStreamReader(processExec.getInputStream());
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        String line = bufferedReader.readLine();
                        UtilsKt.closeSafely((Closeable) bufferedReader);
                        UtilsKt.closeSafely(inputStreamReader);
                        if (processExec != null) {
                            processExec.destroy();
                        }
                        return line;
                    } catch (Exception unused) {
                        UtilsKt.closeSafely((Closeable) bufferedReader);
                        UtilsKt.closeSafely(inputStreamReader);
                        if (processExec != null) {
                            processExec.destroy();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        UtilsKt.closeSafely((Closeable) bufferedReader);
                        UtilsKt.closeSafely(inputStreamReader);
                        if (processExec != null) {
                            processExec.destroy();
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                    bufferedReader = 0;
                } catch (Throwable th3) {
                    bufferedReader = 0;
                    th = th3;
                }
            } catch (Exception unused3) {
                inputStreamReader = null;
                bufferedReader = inputStreamReader;
                UtilsKt.closeSafely((Closeable) bufferedReader);
                UtilsKt.closeSafely(inputStreamReader);
                if (processExec != null) {
                    processExec.destroy();
                }
                return null;
            } catch (Throwable th4) {
                bufferedReader = 0;
                th = th4;
                inputStreamReader = null;
            }
        } catch (Exception unused4) {
            processExec = null;
            inputStreamReader = null;
        } catch (Throwable th5) {
            inputStreamReader = null;
            bufferedReader = 0;
            th = th5;
            processExec = null;
        }
    }
}
