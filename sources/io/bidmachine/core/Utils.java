package io.bidmachine.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import com.google.common.base.Ascii;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.d;
import com.safedk.android.internal.partials.BidMachineFilesBridge;
import com.safedk.android.internal.partials.BidMachineNetworkBridge;
import io.appmetrica.analytics.gpllibrary.internal.GplLibraryWrapper;
import io.bidmachine.Executable;
import io.bidmachine.Function;
import io.bidmachine.SimpleContextProvider;
import io.bidmachine.UserAgentManager;
import io.bidmachine.util.ViewUtils;
import io.bidmachine.utils.DeviceUtils;
import io.bidmachine.utils.ThrowableRunnable;
import io.bidmachine.utils.lazy.LazyCachedValue;
import io.bidmachine.utils.lazy.LazyValue;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class Utils {
    private static final Handler BACKGROUND_HANDLER;
    private static final LazyCachedValue<Integer> CURRENT_YEAR;
    private static String appName;
    private static String appVersion;
    private static final Handler UI_HANDLER = new Handler(Looper.getMainLooper());
    private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();
    private static final char[] UPPER_HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static float getOrDefault(float f, float f2, float f3) {
        return f == f2 ? f3 : f;
    }

    public static long getOrDefault(long j, long j2, long j3) {
        return j == j2 ? j3 : j;
    }

    public static <T> T oneOf(T t, T t2, T t3) {
        if (t != null) {
            return t;
        }
        return t2 != null ? t2 : t3;
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        com.safedk.android.utils.Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, "io.bidmachine");
        p0.startActivity(p1);
    }

    static {
        HandlerThread handlerThread = new HandlerThread("BackgroundHandlerThread");
        handlerThread.start();
        BACKGROUND_HANDLER = new Handler(handlerThread.getLooper());
        CURRENT_YEAR = new LazyCachedValue<>(new LazyValue() { // from class: io.bidmachine.core.Utils$$ExternalSyntheticLambda3
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return Integer.valueOf(Utils.safeCalendarGetInstance().get(1));
            }
        });
    }

    public static boolean isUiThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void onUiThread(Runnable runnable) {
        if (isUiThread()) {
            runnable.run();
        } else {
            UI_HANDLER.post(runnable);
        }
    }

    public static void onUiThread(Runnable runnable, long j) {
        UI_HANDLER.postDelayed(runnable, j);
    }

    public static void cancelUiThreadTask(Runnable runnable) {
        UI_HANDLER.removeCallbacks(runnable);
    }

    public static void onBackgroundThread(Runnable runnable) {
        Looper looperMyLooper = Looper.myLooper();
        Handler handler = BACKGROUND_HANDLER;
        if (looperMyLooper == handler.getLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public static void onBackgroundThread(Runnable runnable, long j) {
        BACKGROUND_HANDLER.postDelayed(runnable, j);
    }

    public static void cancelBackgroundThreadTask(Runnable runnable) {
        BACKGROUND_HANDLER.removeCallbacks(runnable);
    }

    public static Handler createHandlerWithMyOrMainLooper() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        return new Handler(looperMyLooper);
    }

    public static String readFile(File file) {
        try {
            return streamToString(new FileInputStream(file));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String streamToString(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        String string = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
                string = byteArrayOutputStream.toString("UTF-8");
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            byteArrayOutputStream = null;
        }
        flush(byteArrayOutputStream);
        close(byteArrayOutputStream);
        close(inputStream);
        return string;
    }

    public static ConnectivityManager getConnectivityManager(Context context) {
        if (!isPermissionGranted(context, "android.permission.ACCESS_NETWORK_STATE")) {
            Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.core.Utils$$ExternalSyntheticLambda2
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("Manifest permission not found: %s. Check the integration.", "android.permission.ACCESS_NETWORK_STATE");
                }
            });
            return null;
        }
        try {
            return (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Throwable th) {
            Logger.w(th);
            return null;
        }
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        try {
            ConnectivityManager connectivityManager = getConnectivityManager(context);
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable th) {
            Logger.w(th);
            return null;
        }
    }

    public static NetworkCapabilities getActiveNetworkCapabilities(Context context) {
        ConnectivityManager connectivityManager = getConnectivityManager(context);
        if (connectivityManager == null) {
            return null;
        }
        try {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null) {
                return null;
            }
            return connectivityManager.getNetworkCapabilities(activeNetwork);
        } catch (Throwable th) {
            Logger.w(th);
            return null;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static Location getBestLocation(Context context, Location location, Location location2) {
        Location location3 = (Location) oneOf(location, location2);
        Location location4 = getLocation(context);
        if (location4 != null) {
            return (location3 == null || location4.getTime() >= location3.getTime()) ? location4 : location3;
        }
        return location3;
    }

    public static Location getLocation(Context context) {
        String bestProvider;
        Location lastKnownLocation;
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 34) {
                bestProvider = GplLibraryWrapper.FUSED_PROVIDER;
            } else {
                bestProvider = locationManager.getBestProvider(new Criteria(), false);
            }
            if (bestProvider == null) {
                return null;
            }
            Location lastKnownLocation2 = locationManager.getLastKnownLocation(bestProvider);
            if (lastKnownLocation2 != null) {
                return lastKnownLocation2;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders != null && allProviders.size() > 1) {
                for (String str : allProviders) {
                    if (str != null && !str.equals(bestProvider) && (lastKnownLocation = locationManager.getLastKnownLocation(str)) != null) {
                        return lastKnownLocation;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            Logger.w(e);
        }
        return null;
    }

    public static int getUtcOffsetMinutes() {
        return (int) TimeUnit.MILLISECONDS.toMinutes(TimeZone.getDefault().getOffset(System.currentTimeMillis()));
    }

    public static Point getScreenSize(Context context) {
        DisplayMetrics displayMetrics = DeviceUtils.getDisplayMetrics(context);
        return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static float getScreenDensity(Context context) {
        return DeviceUtils.getDisplayMetrics(context).density;
    }

    public static boolean canUseExternalFilesDir() {
        return isExternalMemoryAvailable();
    }

    public static boolean isPermissionGranted(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    static boolean writePermissionGranted(Context context) {
        return isPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static boolean isExternalMemoryAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static byte[] getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            Logger.w(e);
            return null;
        }
    }

    public static File getCacheDir(Context context, String str) {
        File externalFilesDir = getExternalFilesDir(context);
        if (externalFilesDir == null) {
            return null;
        }
        File file = new File(externalFilesDir.getPath() + RemoteSettings.FORWARD_SLASH_STRING + str + RemoteSettings.FORWARD_SLASH_STRING);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static File getExternalFilesDir(Context context) {
        return context.getExternalFilesDir(null);
    }

    public static File getExternalFilesDirDirty(Context context) {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                return null;
            }
            return new File(externalStorageDirectory, "/Android/data/" + context.getPackageName() + "/files");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isUrlValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            new URL(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isHttpUrl(String str) {
        return str.startsWith(d.v) || str.startsWith("https://");
    }

    public static String generateFileName(String str) {
        return new BigInteger(getMD5(str.getBytes())).abs().toString(36);
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                Logger.w(e);
            }
        }
    }

    public static void flush(Flushable flushable) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Exception e) {
                Logger.w(e);
            }
        }
    }

    public static Rect getViewRectangle(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Rect(iArr[0], iArr[1], view.getWidth() + iArr[0], view.getHeight() + iArr[1]);
    }

    public static boolean isViewTransparent(View view) {
        return view.getAlpha() == 0.0f;
    }

    public static void simpleTrackUrl(final String str, Executor executor) {
        if (TextUtils.isEmpty(str) || executor == null) {
            return;
        }
        try {
            executor.execute(new Runnable() { // from class: io.bidmachine.core.Utils$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    Utils.lambda$simpleTrackUrl$2(str);
                }
            });
        } catch (Exception e) {
            Logger.w(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static /* synthetic */ void lambda$simpleTrackUrl$2(String str) throws Throwable {
        Throwable th;
        HttpURLConnection httpURLConnection;
        Exception e;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                try {
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setRequestProperty("Connection", "close");
                    httpURLConnection.setRequestMethod("GET");
                    String userAgent = UserAgentManager.getUserAgent();
                    if (!TextUtils.isEmpty(userAgent)) {
                        httpURLConnection.setRequestProperty("User-Agent", userAgent);
                    }
                    BidMachineNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
                    if (httpURLConnection != null) {
                        try {
                            close(BidMachineNetworkBridge.urlConnectionGetInputStream(httpURLConnection));
                        } catch (Exception e2) {
                            e = e2;
                            Logger.w(e);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection != null) {
                        try {
                            close(BidMachineNetworkBridge.urlConnectionGetInputStream(httpURLConnection));
                        } catch (Exception e3) {
                            Logger.w(e3);
                        }
                    }
                    io.bidmachine.util.Utils.disconnectSafely(httpURLConnection);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                Logger.w(e);
                if (httpURLConnection != null) {
                    try {
                        close(BidMachineNetworkBridge.urlConnectionGetInputStream(httpURLConnection));
                    } catch (Exception e5) {
                        e = e5;
                        Logger.w(e);
                    }
                }
            }
        } catch (Exception e6) {
            e = e6;
            httpURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                close(BidMachineNetworkBridge.urlConnectionGetInputStream(httpURLConnection));
            }
            io.bidmachine.util.Utils.disconnectSafely(httpURLConnection);
            throw th;
        }
        io.bidmachine.util.Utils.disconnectSafely(httpURLConnection);
    }

    public static boolean canAddWindowToActivity(Activity activity) {
        return (activity == null || activity.getWindow() == null || !activity.getWindow().isActive() || activity.getWindow().getDecorView().getWindowToken() == null) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable, java.io.Flushable] */
    public static String retrieveAndSaveFrame(Context context, Uri uri, String str) throws Throwable {
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(context, uri);
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(Long.parseLong(mediaMetadataRetriever.extractMetadata(9)), 2);
        ?? r1 = 0;
        try {
            if (frameAtTime != null) {
                try {
                    File file = new File(getCacheDir(context, str), generateFileName(uri.toString()));
                    fileOutputStreamFileOutputStreamCtor = BidMachineFilesBridge.fileOutputStreamCtor(file);
                    try {
                        frameAtTime.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStreamFileOutputStreamCtor);
                        String absolutePath = file.getAbsolutePath();
                        flush(fileOutputStreamFileOutputStreamCtor);
                        close(fileOutputStreamFileOutputStreamCtor);
                        return absolutePath;
                    } catch (Exception e) {
                        e = e;
                        Logger.w(e);
                        flush(fileOutputStreamFileOutputStreamCtor);
                        close(fileOutputStreamFileOutputStreamCtor);
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStreamFileOutputStreamCtor = null;
                } catch (Throwable th) {
                    th = th;
                    flush(r1);
                    close(r1);
                    throw th;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            r1 = context;
        }
    }

    public static boolean isYearValid(int i) {
        return i >= 1900 && i <= CURRENT_YEAR.get().intValue();
    }

    @SafeVarargs
    public static Object invokeMethodByName(Object obj, String str, Pair<Class<?>, Object>... pairArr) throws Exception {
        return invokeMethodByName(obj, obj.getClass(), str, pairArr);
    }

    @SafeVarargs
    public static Object invokeMethodByName(Object obj, Class<?> cls, String str, Pair<Class<?>, Object>... pairArr) throws Exception {
        Class<?>[] clsArr;
        Object[] objArr;
        if (pairArr != null) {
            clsArr = new Class[pairArr.length];
            objArr = new Object[pairArr.length];
            for (int i = 0; i < pairArr.length; i++) {
                clsArr[i] = (Class) pairArr[i].first;
                objArr[i] = pairArr[i].second;
            }
        } else {
            clsArr = null;
            objArr = null;
        }
        for (int i2 = 10; i2 > 0 && cls != null; i2--) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(obj, objArr);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            } catch (NoSuchMethodException unused2) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static <T> T oneOf(T t, T t2) {
        return (T) oneOf(t, t2, null);
    }

    public static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static String getAppName(Context context) {
        if (appName == null) {
            appName = (String) context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
        }
        return appName;
    }

    public static String getAppVersion(Context context) {
        if (appVersion == null) {
            try {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                if (str != null) {
                    appVersion = str;
                }
            } catch (Exception e) {
                Logger.w(e);
            }
        }
        return appVersion;
    }

    public static boolean canUseCleartextTraffic() {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    public static Map<String, String> toMap(JSONObject jSONObject) throws Exception {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (objOpt != null) {
                map.put(next, objOpt.toString());
            }
        }
        return map;
    }

    public static void startActivity(Context context, Intent intent) {
        try {
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    public static String generateTag(String str, Object obj) {
        return str + " @" + Integer.toHexString(obj.hashCode());
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }

    public static String toSignatureHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        char[] cArr = new char[(bArr.length * 3) - 1];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b = bArr[i2];
            char[] cArr2 = UPPER_HEX_ARRAY;
            cArr[i] = cArr2[(b & 255) >>> 4];
            int i3 = i + 2;
            cArr[i + 1] = cArr2[b & Ascii.SI];
            if (i2 < bArr.length - 1) {
                i += 3;
                cArr[i3] = AbstractJsonLexerKt.COLON;
            } else {
                i = i3;
            }
        }
        return new String(cArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void sort(CopyOnWriteArrayList<T> copyOnWriteArrayList, Comparator<? super T> comparator) {
        Object[] array = copyOnWriteArrayList.toArray();
        Arrays.sort(array, comparator);
        for (int i = 0; i < array.length; i++) {
            copyOnWriteArrayList.set(i, array[i]);
        }
    }

    public static String checkIfEmpty(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }

    public static int parseIntOrDefault(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Throwable unused) {
            }
        }
        return i;
    }

    public static Integer parseIntOrDefault(String str, Integer num) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Integer.parseInt(str));
            } catch (Throwable unused) {
            }
        }
        return num;
    }

    public static Float parseFloatOrDefault(String str, Float f) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Float.valueOf(Float.parseFloat(str));
            } catch (Throwable unused) {
            }
        }
        return f;
    }

    public static Integer convertToIntOrDefault(Object obj, Integer num) {
        if (obj == null) {
            return num;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        return parseIntOrDefault(obj.toString(), num);
    }

    public static Float convertToFloatOrDefault(Object obj, Float f) {
        if (obj == null) {
            return f;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        return parseFloatOrDefault(obj.toString(), f);
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static <T> String join(List<T> list) {
        return join(list, ", ");
    }

    public static <T> String join(List<T> list, CharSequence charSequence) {
        return join(list, charSequence, new Function() { // from class: io.bidmachine.core.Utils$$ExternalSyntheticLambda1
            @Override // io.bidmachine.Function
            public final Object apply(Object obj) {
                return obj.toString();
            }
        });
    }

    public static <T> String join(List<T> list, CharSequence charSequence, Function<T, String> function) {
        String strApply;
        if (isEmpty(list)) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(list.size());
            for (T t : list) {
                if (t != null && (strApply = function.apply(t)) != null) {
                    if (sb.length() > 0) {
                        sb.append(charSequence);
                    }
                    sb.append(strApply);
                }
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Integer safeParseColor(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Integer parseHorizontalPosition(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "center":
                return 1;
            case "left":
                return 3;
            case "right":
                return 5;
            default:
                return null;
        }
    }

    public static Integer parseVerticalPosition(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "bottom":
                return 80;
            case "center":
                return 16;
            case "top":
                return 48;
            default:
                return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void putAll(Map<K, V> map, Map<K, V> map2) {
        if (map == null || map2 == 0) {
            return;
        }
        map.putAll(map2);
    }

    public static <T> void ifNotNull(T t, Executable<T> executable) {
        if (t != null) {
            executable.execute(t);
        }
    }

    public static void ifNotEmpty(String str, Executable<String> executable) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        executable.execute(str);
    }

    public static void runCatching(ThrowableRunnable throwableRunnable) {
        try {
            throwableRunnable.run();
        } catch (Throwable unused) {
        }
    }

    private static Calendar safeCalendarGetInstance() {
        try {
            try {
                return Calendar.getInstance();
            } catch (Throwable unused) {
                return Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.US);
            }
        } catch (Throwable unused2) {
            return Calendar.getInstance(Locale.US);
        }
    }

    public static Context findDialogContext(Context context) {
        return findDialogContext(context, null);
    }

    public static Context findDialogContext(Context context, View view) {
        Activity activity = new SimpleContextProvider(context).getActivity();
        if (activity != null) {
            return activity;
        }
        if (view == null) {
            return context;
        }
        View viewFindContentOrRootView = ViewUtils.findContentOrRootView(view);
        if (viewFindContentOrRootView != null) {
            return viewFindContentOrRootView.getContext();
        }
        return view.getContext();
    }
}
