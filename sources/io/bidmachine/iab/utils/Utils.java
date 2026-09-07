package io.bidmachine.iab.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.safedk.android.internal.partials.BidMachineNetworkBridge;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.bidmachine.rendering.Rendering;
import java.io.Closeable;
import java.io.Flushable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class Utils {
    public static final int HTTP_PERMANENT_REDIRECT = 308;
    public static final int HTTP_TEMPORARY_REDIRECT = 307;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f12249a = new Handler(Looper.getMainLooper());

    class a implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f12250a;

        a(int i) {
            this.f12250a = i;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            Insets insets = windowInsets.getInsets(this.f12250a);
            view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
            return windowInsets;
        }
    }

    private static float a(float f, float f2) {
        return f / f2;
    }

    private static float a(int i) {
        if (i == 1) {
            return 0.5f;
        }
        if (i != 3) {
            return i != 17 ? 1.0f : 0.5f;
        }
        return 0.0f;
    }

    private static void a(Window window, boolean z) {
        int i;
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController windowInsetsController = window.getDecorView().getWindowInsetsController();
            if (windowInsetsController == null) {
                return;
            }
            windowInsetsController.setSystemBarsBehavior(2);
            if (z) {
                windowInsetsController.hide(WindowInsets.Type.statusBars());
                return;
            }
            return;
        }
        if (z) {
            window.setFlags(1024, 1024);
            i = 4;
        } else {
            i = 0;
        }
        if (i > 0) {
            window.getDecorView().setSystemUiVisibility(i);
        }
    }

    public static void applyFullscreenActivityFlags(Activity activity) {
        applyFullscreenActivityFlags(activity, true);
    }

    public static void applyWindowInsets(Activity activity) {
        if (Build.VERSION.SDK_INT >= 34) {
            Window window = activity.getWindow();
            applyWindowInsets(window != null ? window.getDecorView() : activity.findViewById(R.id.content));
        }
    }

    private static float b(int i) {
        if (i == 16 || i == 17) {
            return 0.5f;
        }
        return i != 80 ? 0.0f : 1.0f;
    }

    public static void cancelOnUiThread(Runnable runnable) {
        f12249a.removeCallbacks(runnable);
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                CommonLog.e("Utils", th);
            }
        }
    }

    public static Float convertCssSizeToPx(String value) {
        return Float.valueOf(value.replace("px", ""));
    }

    public static int dpToPx(Context context, float size) {
        return (int) TypedValue.applyDimension(1, size, context.getResources().getDisplayMetrics());
    }

    public static void finishActivityWithoutAnimation(Activity activity) {
        activity.finish();
        setDefaultActivityTransition(activity);
    }

    public static void flush(Flushable flushable) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Throwable th) {
                CommonLog.e("Utils", th);
            }
        }
    }

    public static int generateViewId() {
        return View.generateViewId();
    }

    public static Point getClickPoint(int width, int height, int horizontalGravity, int verticalGravity) {
        Random random = new Random();
        return new Point((int) (((double) width) * a(random, 0.1f, a(horizontalGravity))), (int) (((double) height) * a(random, 0.1f, b(verticalGravity))));
    }

    public static Point getDefaultClickPoint(int width, int height) {
        return new Point(Math.round(width * 0.5f), Math.round(height * 0.7f));
    }

    public static int getScreenOrientation(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        int i = context.getResources().getConfiguration().orientation;
        if (i == 1) {
            return (rotation == 2 || rotation == 3) ? 9 : 1;
        }
        if (i == 2) {
            return (rotation == 2 || rotation == 3) ? 8 : 0;
        }
        return 9;
    }

    public static boolean isLandscapeOrientation(Context context) {
        int screenOrientation = getScreenOrientation(context);
        return screenOrientation == 0 || screenOrientation == 8 || screenOrientation == 6 || screenOrientation == 11;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        CommonLog.d("Utils", "Testing connectivity:", new Object[0]);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            CommonLog.d("Utils", "No Internet connection", new Object[0]);
            return false;
        }
        CommonLog.d("Utils", "Connected to Internet", new Object[0]);
        return true;
    }

    public static boolean isTablet(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        double d = displayMetrics.widthPixels / displayMetrics.xdpi;
        double d2 = displayMetrics.heightPixels / displayMetrics.ydpi;
        return Math.sqrt((d * d) + (d2 * d2)) >= 6.6d;
    }

    public static boolean isViewTransparent(View view) {
        return view.getAlpha() == 0.0f;
    }

    public static Float max(Float first, Float second) {
        if (first == null) {
            return second;
        }
        return second == null ? first : Float.valueOf(Math.max(first.floatValue(), second.floatValue()));
    }

    public static Float min(Float first, Float second) {
        if (first == null) {
            return second;
        }
        return second == null ? first : Float.valueOf(Math.min(first.floatValue(), second.floatValue()));
    }

    public static MotionEvent obtainMotionEvent(int action, int x, int y) {
        return MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), action, x, y, 0);
    }

    public static void onUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            f12249a.post(runnable);
        }
    }

    public static int orientationBySize(int width, int height) {
        return width > height ? 2 : 1;
    }

    public static String orientationToString(int orientation) {
        if (orientation == 0) {
            return "UNDEFINED";
        }
        if (orientation != 1) {
            return orientation != 2 ? "UNKNOWN" : "LANDSCAPE";
        }
        return "PORTRAIT";
    }

    public static int pixelsToIntDips(final float pixels, final float density) {
        return (int) (a(pixels, density) + 0.5f);
    }

    public static void postOnUiThread(Runnable runnable) {
        f12249a.post(runnable);
    }

    public static void removeFromParent(View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    public static void setDefaultActivityTransition(Activity activity) {
        if (Build.VERSION.SDK_INT < 34) {
            activity.overridePendingTransition(0, 0);
        } else {
            activity.overrideActivityTransition(0, 0, 0);
            activity.overrideActivityTransition(1, 0, 0);
        }
    }

    public static void setWindowBackgroundColor(Window window, int color) {
        if (window == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(color));
    }

    public static void simpleTrackUrl(final String url) {
        simpleTrackUrl(url, Executors.newSingleThreadExecutor());
    }

    public static String stringifyRect(Rect rect) {
        return rect.left + StringUtils.COMMA + rect.top + StringUtils.COMMA + rect.width() + StringUtils.COMMA + rect.height();
    }

    public static String stringifySize(Rect rect) {
        return rect.width() + StringUtils.COMMA + rect.height();
    }

    public static void applyFullscreenActivityFlags(Activity activity, boolean isNoStatusBar) {
        activity.requestWindowFeature(1);
        Window window = activity.getWindow();
        if (window != null) {
            window.addFlags(128);
            a(window, isNoStatusBar);
        }
        a(activity);
    }

    public static void applyWindowInsets(View view) {
        applyWindowInsets(view, WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout());
    }

    public static Point getClickPoint(Rect rect, int horizontalGravity, int verticalGravity) {
        return getClickPoint(rect.width(), rect.height(), horizontalGravity, verticalGravity);
    }

    public static Point getDefaultClickPoint(Rect rect) {
        return getDefaultClickPoint(rect.width(), rect.height());
    }

    public static void onUiThread(Runnable runnable, long delayMillis) {
        f12249a.postDelayed(runnable, delayMillis);
    }

    public static void simpleTrackUrl(final String url, final Executor executor) {
        if (TextUtils.isEmpty(url)) {
            CommonLog.d("Utils", "url is null or empty", new Object[0]);
            return;
        }
        try {
            executor.execute(new Runnable() { // from class: io.bidmachine.iab.utils.Utils$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    Utils.a(url);
                }
            });
        } catch (Exception e) {
            CommonLog.e("Utils", e);
        }
    }

    private static double a(Random random, float f, float f2) {
        double d;
        double dSqrt = Math.sqrt(Math.log(Math.abs(((random.nextLong() % 100000) + 1) / 100000.0d)) * (-2.0d)) * Math.sin(Math.abs(((random.nextLong() % 100000) + 1) / 100000.0d) * 6.283185307179586d);
        double d2 = f2;
        if (d2 < 0.4d || d2 > 0.6d) {
            d = d2 < 0.4d ? d2 + (((double) f) / (dSqrt * dSqrt)) : d2 - (((double) f) / (dSqrt * dSqrt));
        } else {
            d = (dSqrt * ((double) f)) + d2;
        }
        return Math.min(1.0d, Math.max(0.0d, d));
    }

    public static void applyWindowInsets(View view, int typeInsets) {
        view.setOnApplyWindowInsetsListener(new a(typeInsets));
        view.requestApplyInsets();
    }

    private static void a(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str) throws Throwable {
        HttpURLConnection httpURLConnection;
        Exception e;
        HttpURLConnection httpURLConnection2 = null;
        try {
            CommonLog.d("Utils", "Connection to URL: %s", str);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                try {
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setRequestProperty("Connection", "close");
                    httpURLConnection.setRequestMethod("GET");
                    String userAgent = Rendering.getUserAgent();
                    if (!TextUtils.isEmpty(userAgent)) {
                        httpURLConnection.setRequestProperty("User-Agent", userAgent);
                    }
                    CommonLog.d("Utils", "Response code: %d, for URL: %s", Integer.valueOf(BidMachineNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection)), str);
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection2 = httpURLConnection;
                    io.bidmachine.util.Utils.disconnectSafely(httpURLConnection2);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                CommonLog.e("Utils", "%s: %s: %s", str, e.getMessage(), e.toString());
            }
        } catch (Exception e3) {
            httpURLConnection = null;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            io.bidmachine.util.Utils.disconnectSafely(httpURLConnection2);
            throw th;
        }
        io.bidmachine.util.Utils.disconnectSafely(httpURLConnection);
    }
}
