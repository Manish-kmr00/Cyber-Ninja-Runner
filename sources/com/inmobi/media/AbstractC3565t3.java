package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Insets;
import android.hardware.display.DisplayManager;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.WindowInsetsCompat;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.t3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC3565t3 {
    public static String c;
    public static JSONObject f;
    public static Integer g;
    public static Float h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3579u3 f3431a = new C3579u3(0, 2.0f, 0);
    public static final C3551s3 b = new C3551s3(0, 0);
    public static float d = -1.0f;
    public static boolean e = true;
    public static final boolean i = C3435k3.f3355a.F();

    public static String a() {
        Display displayA;
        Context contextD = C3517pb.d();
        if (contextD == null || (displayA = a(contextD)) == null) {
            return "0x0";
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayA.getMetrics(displayMetrics);
        return new StringBuilder().append(displayMetrics.widthPixels).append('x').append(displayMetrics.heightPixels).toString();
    }

    public static float b() {
        Display displayA;
        if (d == -1.0f) {
            Context contextD = C3517pb.d();
            if (contextD == null || (displayA = a(contextD)) == null) {
                return 2.0f;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayA.getMetrics(displayMetrics);
            float f2 = displayMetrics.density;
            if (f2 == 0.0f) {
                return 2.0f;
            }
            d = f2;
        }
        return d;
    }

    public static HashMap c() {
        HashMap map = new HashMap();
        try {
            map.put("d-device-screen-density", String.valueOf(b()));
            C3579u3 c3579u3D = d();
            map.put("d-device-screen-size", new StringBuilder().append(c3579u3D.f3441a).append('X').append(c3579u3D.b).toString());
            map.put("d-density-dependent-screen-size", a());
            map.put("d-orientation", String.valueOf((int) g()));
            Float f2 = h;
            map.put("d-textsize", String.valueOf(f2 != null ? f2.floatValue() : 37.0f));
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("t3", "TAG");
        }
        return map;
    }

    public static C3579u3 d() {
        Display displayA;
        Context contextD = C3517pb.d();
        if (contextD != null && (displayA = a(contextD)) != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayA.getMetrics(displayMetrics);
            float f2 = displayMetrics.density;
            return new C3579u3((int) (displayMetrics.widthPixels / f2), f2, (int) (displayMetrics.heightPixels / f2));
        }
        return f3431a;
    }

    public static String e() {
        String string = null;
        if (e) {
            return null;
        }
        String str = c;
        if (str != null) {
            return str;
        }
        Context contextD = C3517pb.d();
        if (contextD != null) {
            ConcurrentHashMap concurrentHashMap = K5.b;
            K5 k5A = J5.a(contextD, "display_info_store");
            Intrinsics.checkNotNullParameter("gesture_margin", "key");
            string = k5A.f3112a.getString("gesture_margin", null);
        }
        c = string;
        return string;
    }

    public static Integer f() {
        Context contextD = C3517pb.d();
        if (contextD == null) {
            return null;
        }
        int i2 = Settings.Secure.getInt(contextD.getContentResolver(), "navigation_mode", -1);
        if (i2 == 0 || i2 == 1) {
            return 0;
        }
        return i2 != 2 ? null : 1;
    }

    public static byte g() {
        Display displayA;
        int rotation;
        Context contextD = C3517pb.d();
        if (contextD == null || (displayA = a(contextD)) == null || (rotation = displayA.getRotation()) == 0) {
            return (byte) 1;
        }
        if (rotation == 1) {
            return (byte) 3;
        }
        if (rotation == 2) {
            return (byte) 2;
        }
        if (rotation == 3) {
            return (byte) 4;
        }
        Intrinsics.checkNotNullExpressionValue("t3", "TAG");
        return (byte) 1;
    }

    public static C3579u3 h() {
        Display displayA;
        Context contextD = C3517pb.d();
        if (contextD != null && (displayA = a(contextD)) != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayA.getRealMetrics(displayMetrics);
            float f2 = displayMetrics.density;
            return new C3579u3((int) (displayMetrics.widthPixels / f2), f2, (int) (displayMetrics.heightPixels / f2));
        }
        return f3431a;
    }

    public static final int a(int i2) {
        try {
            return MathKt.roundToInt(i2 / b());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void a(final WindowInsets insets, final Context context) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (e) {
            return;
        }
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.t3$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3565t3.b(insets, context);
            }
        });
    }

    public static final void b(Context context) {
        Window window;
        WindowInsets rootWindowInsets;
        if (e || !(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || (rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null) {
            return;
        }
        a(rootWindowInsets, context);
    }

    public static Display a(Context context) {
        if (C3435k3.f3355a.E()) {
            Object systemService = context.getSystemService("display");
            DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
            if (displayManager != null) {
                return displayManager.getDisplay(0);
            }
            return null;
        }
        Object systemService2 = context.getSystemService("window");
        WindowManager windowManager = systemService2 instanceof WindowManager ? (WindowManager) systemService2 : null;
        if (windowManager != null) {
            return windowManager.getDefaultDisplay();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    public static int a(WindowInsets insets) {
        int i2;
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (C3435k3.f3355a.z()) {
            EnumC3501o9 enumC3501o9A = AbstractC3515p9.a(g());
            Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemGestures());
            Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
            int iOrdinal = enumC3501o9A.ordinal();
            i2 = 1;
            if (iOrdinal == 0) {
                if (insets2.left == 0 && insets2.right == 0) {
                    i2 = 0;
                }
            } else if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (insets2.right == 0 && insets2.bottom == 0) {
                        i2 = 0;
                    }
                } else if (insets2.left == 0) {
                    i2 = 0;
                }
            } else if (insets2.left == 0 && insets2.bottom == 0) {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        Intrinsics.checkNotNullExpressionValue("t3", "TAG");
        return i2;
    }

    public static final void b(WindowInsets insets, Context context) {
        Intrinsics.checkNotNullParameter(insets, "$insets");
        try {
            String string = insets.getSystemGestureInsets().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String[] strArr = (String[]) new Regex("Insets").split(string, 0).toArray(new String[0]);
            StringBuffer stringBuffer = new StringBuffer();
            if (strArr.length > 1) {
                String[] strArr2 = (String[]) new Regex(StringUtils.COMMA).split(new Regex("[^0-9,=a-zA-Z]*").replace(strArr[1], ""), 0).toArray(new String[0]);
                stringBuffer.append("{");
                int length = strArr2.length;
                for (int i2 = 0; i2 < length; i2++) {
                    String[] strArr3 = (String[]) new Regex("=").split(strArr2[i2], 0).toArray(new String[0]);
                    if (strArr3.length == 2) {
                        stringBuffer.append('\"' + strArr3[0] + '\"');
                        stringBuffer.append(":");
                        stringBuffer.append(a(Integer.parseInt(strArr3[1])));
                        if (i2 < strArr2.length - 1) {
                            stringBuffer.append(", ");
                        }
                    }
                }
                stringBuffer.append("}");
            }
            if (stringBuffer.length() > 0) {
                c = stringBuffer.toString();
                ConcurrentHashMap concurrentHashMap = K5.b;
                Intrinsics.checkNotNull(context);
                K5 k5A = J5.a(context, "display_info_store");
                String string2 = stringBuffer.toString();
                Intrinsics.checkNotNullParameter("gesture_margin", "key");
                SharedPreferences.Editor editorEdit = k5A.f3112a.edit();
                editorEdit.putString("gesture_margin", string2);
                editorEdit.apply();
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("t3", "TAG");
        }
    }

    public static void a(final LinkedHashMap value) {
        Intrinsics.checkNotNullParameter(value, "value");
        final Context contextD = C3517pb.d();
        if (contextD == null) {
            return;
        }
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.t3$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                AbstractC3565t3.a(value, contextD);
            }
        });
    }

    public static final void a(Map value, Context context) throws JSONException {
        Intrinsics.checkNotNullParameter(value, "$value");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullExpressionValue("t3", "TAG");
        Objects.toString(value);
        if (f == null) {
            f = new JSONObject();
        }
        Iterator it = value.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            JSONObject jSONObject = f;
            if (jSONObject != null) {
                jSONObject.put(String.valueOf(iIntValue), value.get(Integer.valueOf(iIntValue)));
            }
        }
        ConcurrentHashMap concurrentHashMap = K5.b;
        K5 k5A = J5.a(context, "display_info_store");
        JSONObject jSONObject2 = f;
        k5A.a("safe_area", jSONObject2 != null ? jSONObject2.toString() : null);
    }

    public static void a(final Integer num) {
        final Context contextD = C3517pb.d();
        if (contextD == null) {
            return;
        }
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.t3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3565t3.a(num, contextD);
            }
        });
    }

    public static final void a(Integer num, Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullExpressionValue("t3", "TAG");
        g = num;
        ConcurrentHashMap concurrentHashMap = K5.b;
        J5.a(context, "display_info_store").a("nav_bar_type", num != null ? num.intValue() : -1);
    }
}
