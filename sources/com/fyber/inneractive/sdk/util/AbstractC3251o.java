package com.fyber.inneractive.sdk.util;

import android.app.Application;
import android.content.Context;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.amazon.device.ads.DtbConstants;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public abstract class AbstractC3251o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f2370a;

    public static void a() {
    }

    public static boolean a(String str) {
        try {
            return f2370a.checkCallingOrSelfPermission(str) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int b(int i) {
        try {
            return (int) ((i / b()) + 0.5f);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int d() {
        Application application = f2370a;
        int i = (application == null || application.getResources() == null || application.getResources().getConfiguration() == null) ? 1 : application.getResources().getConfiguration().orientation;
        try {
            if (Settings.System.getInt(application.getContentResolver(), "accelerometer_rotation", 0) != 1) {
                i = 1;
            }
        } catch (Throwable th) {
            IAlog.a("failed getOrientation. returning portrait orientation", th, new Object[0]);
        }
        IAlog.a("The device orientation: %s", i == 1 ? "portrait" : "landscape");
        return i;
    }

    public static int e() {
        int i;
        WindowManager windowManager;
        Display defaultDisplay;
        if (f2370a == null || (windowManager = (WindowManager) IAConfigManager.O.v.a().getSystemService("window")) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            i = -1;
        } else {
            Point point = new Point();
            defaultDisplay.getSize(point);
            i = point.y;
        }
        if (i != -1) {
            return i;
        }
        try {
            DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
            if (displayMetrics != null) {
                i = displayMetrics.heightPixels;
            }
        } catch (Throwable unused) {
        }
        return i == -1 ? DtbConstants.DEFAULT_PLAYER_HEIGHT : i;
    }

    public static int f() {
        int i;
        WindowManager windowManager;
        Display defaultDisplay;
        try {
            if (f2370a == null || (windowManager = (WindowManager) IAConfigManager.O.v.a().getSystemService("window")) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
                i = -1;
            } else {
                Point point = new Point();
                defaultDisplay.getSize(point);
                i = point.x;
            }
        } catch (Throwable unused) {
        }
        if (i != -1) {
            return i;
        }
        try {
            DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
            if (displayMetrics != null) {
                i = displayMetrics.widthPixels;
            }
        } catch (Throwable unused2) {
        }
        if (i == -1) {
            return 320;
        }
        return i;
    }

    public static void g() {
    }

    public static void h() {
    }

    public static String i() {
        IAConfigManager iAConfigManager;
        int i = 0;
        while (true) {
            iAConfigManager = IAConfigManager.O;
            if (!iAConfigManager.y.f2378a.get() || iAConfigManager.y.d.compareAndSet(true, true) || i >= 25) {
                break;
            }
            IAlog.a("UserAgentProvider | waiting on user agent", new Object[0]);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
            }
            i++;
        }
        return iAConfigManager.y.a();
    }

    public static float b() {
        return IAConfigManager.O.v.a().getResources().getConfiguration().densityDpi / 160.0f;
    }

    public static Drawable c(int i) {
        return IAConfigManager.O.v.a().getDrawable(i);
    }

    public static int a(int i) {
        return (int) ((b() * i) + 0.5f);
    }

    public static void a(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static int c() {
        return ((WindowManager) IAConfigManager.O.v.a().getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public static int a(float f) {
        return (int) (TypedValue.applyDimension(1, f, IAConfigManager.O.v.a().getResources().getDisplayMetrics()) + 0.5f);
    }

    public static String a(ArrayList arrayList) {
        if (Build.VERSION.SDK_INT >= 26) {
            return UByte$$ExternalSyntheticBackport0.m(StringUtils.COMMA, arrayList);
        }
        return TextUtils.join(StringUtils.COMMA, arrayList);
    }

    public static void a(Context context, byte[] bArr) {
        FileOutputStream fileOutputStreamOpenFileOutput;
        try {
            fileOutputStreamOpenFileOutput = context.openFileOutput("session_details.json", 0);
            try {
                fileOutputStreamOpenFileOutput.write(bArr);
                fileOutputStreamOpenFileOutput.flush();
            } catch (Throwable unused) {
                try {
                    IAlog.a("writeFileWithContext failed writing %s", "session_details.json");
                } finally {
                    AbstractC3256u.a(fileOutputStreamOpenFileOutput);
                }
            }
        } catch (Throwable unused2) {
            fileOutputStreamOpenFileOutput = null;
        }
    }

    public static String b(String str) {
        String string = (String) AbstractC3250n.f2369a.get(str);
        if (TextUtils.isEmpty(string)) {
            IAlog.a("Assets cache: reading file: %s", str);
            try {
                InputStream inputStreamOpen = f2370a.getAssets().open(str, 3);
                StringBuffer stringBuffer = new StringBuffer();
                byte[] bArr = new byte[4096];
                for (int i = 0; i != -1; i = inputStreamOpen.read(bArr)) {
                    stringBuffer.append(new String(bArr, 0, i));
                }
                inputStreamOpen.close();
                string = stringBuffer.toString();
                IAlog.a("Assets cache: success - %s", str);
            } catch (IOException e) {
                IAlog.a("Assets cache: Could not read response from file", new Object[0]);
                IAlog.e(AbstractC3256u.a(e), new Object[0]);
            }
            if (!TextUtils.isEmpty(string)) {
                AbstractC3250n.f2369a.put(str, string);
            }
        } else {
            IAlog.a("Assets cache: returning cached assets for %s", str);
        }
        return string;
    }

    public static String a(Context context) {
        if (context != null) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
                if (signatureArr.length > 0) {
                    Signature signature = signatureArr[0];
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.update(signature.toByteArray());
                    byte[] bArrDigest = messageDigest.digest();
                    StringBuilder sb = new StringBuilder();
                    for (byte b : bArrDigest) {
                        String hexString = Integer.toHexString(b & 255);
                        if (hexString.length() == 1) {
                            sb.append("0");
                        }
                        sb.append(hexString);
                    }
                    return sb.toString();
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return "";
    }

    public static void a(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).gravity = i;
        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (i == 17) {
                layoutParams2.addRule(13);
            } else {
                int i2 = i & 7;
                if (i2 == 1) {
                    layoutParams2.addRule(14);
                } else if (i2 == 3) {
                    layoutParams2.addRule(9);
                } else if (i2 == 5) {
                    layoutParams2.addRule(11);
                }
                int i3 = i & 112;
                if (i3 == 16) {
                    layoutParams2.addRule(15);
                } else if (i3 == 48) {
                    layoutParams2.addRule(10);
                } else if (i3 == 80) {
                    layoutParams2.addRule(12);
                }
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public static Context a(View view) {
        if (view != null) {
            return view.getContext();
        }
        return f2370a;
    }
}
