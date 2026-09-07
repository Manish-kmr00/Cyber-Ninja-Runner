package com.bytedance.sdk.openadsdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Picture;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class Vgu {
    private static final Object BSW = new Object();
    private static float Bzk = -1.0f;
    private static WindowManager JG = null;
    private static float KZx = -1.0f;
    private static int ML = -1;
    private static int Og = -1;
    private static ViewConfiguration SD = null;
    private static Boolean SGo = null;
    private static boolean WV = true;
    private static int ZZv = -1;
    private static int omh = -1;
    private static float pA = -1.0f;

    private static boolean pA(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    private static boolean KZx() {
        return pA < 0.0f || Og < 0 || KZx < 0.0f || ZZv < 0 || ML < 0;
    }

    public static void pA(Context context) {
        pA(context, false);
    }

    public static void pA(Context context, boolean z) {
        Context contextPA = context == null ? com.bytedance.sdk.openadsdk.core.aBv.pA() : context;
        if (contextPA == null) {
            return;
        }
        JG = (WindowManager) contextPA.getSystemService("window");
        if (KZx() || z) {
            DisplayMetrics displayMetrics = contextPA.getResources().getDisplayMetrics();
            pA = displayMetrics.density;
            Og = displayMetrics.densityDpi;
            KZx = displayMetrics.scaledDensity;
            ZZv = displayMetrics.widthPixels;
            ML = displayMetrics.heightPixels;
        }
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int i = ZZv;
            int i2 = ML;
            if (i > i2) {
                ZZv = i2;
                ML = i;
                return;
            }
            return;
        }
        int i3 = ZZv;
        int i4 = ML;
        if (i3 < i4) {
            ZZv = i4;
            ML = i3;
        }
    }

    public static float pA(Context context, float f) {
        pA(context);
        return f * JG(context);
    }

    public static int Og(Context context, float f) {
        pA(context);
        float fJG = JG(context);
        if (fJG <= 0.0f) {
            fJG = 1.0f;
        }
        return (int) ((f / fJG) + 0.5f);
    }

    public static int KZx(Context context, float f) {
        return Float.valueOf(pA(context, f, true)).intValue();
    }

    public static float pA(Context context, float f, boolean z) {
        pA(context);
        return (f * ML(context)) + (z ? 0.5f : 0.0f);
    }

    public static int ZZv(Context context, float f) {
        pA(context, true);
        float fML = ML(context);
        if (fML <= 0.0f) {
            fML = 1.0f;
        }
        return (int) ((f / fML) + 0.5f);
    }

    public static int[] Og(Context context) {
        if (context == null) {
            return null;
        }
        if (JG == null) {
            JG = (WindowManager) com.bytedance.sdk.openadsdk.core.aBv.pA().getSystemService("window");
        }
        int[] iArr = new int[2];
        WindowManager windowManager = JG;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            try {
                Point point = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
                i = point.x;
                i2 = point.y;
            } catch (Exception unused) {
            }
            iArr[0] = i;
            iArr[1] = i2;
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int KZx(Context context) {
        pA(context);
        return ZZv;
    }

    public static int ZZv(Context context) {
        pA(context);
        return ML;
    }

    public static float ML(Context context) {
        pA(context, true);
        return pA;
    }

    public static float JG(Context context) {
        pA(context);
        return KZx;
    }

    public static int SD(Context context) {
        pA(context);
        return Og;
    }

    public static int[] pA(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] Og(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] KZx(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static void pA(View view, int i) {
        if (view == null || view.getVisibility() == i || !pA(i)) {
            return;
        }
        view.setVisibility(i);
    }

    public static boolean ZZv(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static void pA(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    public static void pA(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        pA(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
    }

    private static void pA(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i && marginLayoutParams.topMargin == i2 && marginLayoutParams.rightMargin == i3 && marginLayoutParams.bottomMargin == i4) {
            return;
        }
        if (i != -3) {
            marginLayoutParams.leftMargin = i;
        }
        if (i2 != -3) {
            marginLayoutParams.topMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.rightMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    private static Bitmap pA(WebView webView) {
        Bitmap bitmapCreateBitmap = null;
        try {
            Picture pictureCapturePicture = webView.capturePicture();
            bitmapCreateBitmap = Bitmap.createBitmap(pictureCapturePicture.getWidth(), pictureCapturePicture.getHeight(), Bitmap.Config.ARGB_8888);
            pictureCapturePicture.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("UIUtils", th.getMessage());
            return bitmapCreateBitmap;
        }
    }

    public static void ML(View view) {
        if (view == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(view);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.Vgu.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                View view2 = (View) weakReference.get();
                if (view2 != null) {
                    Vgu.pA(view2, 8);
                    view2.setAlpha(1.0f);
                }
            }
        });
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.start();
    }

    public static void JG(View view) {
        if (view == null) {
            return;
        }
        pA(view, 0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.Vgu.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    public static Pair<Integer, Integer> omh(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.aBv.pA();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return new Pair<>(Integer.valueOf(point.x), Integer.valueOf(point.y));
    }

    public static int Bzk(Context context) {
        return ((Integer) omh(context).second).intValue();
    }

    public static int SGo(Context context) {
        return ((Integer) omh(context).first).intValue();
    }

    public static float pA() {
        float f = Bzk;
        if (f > 0.0f) {
            return f;
        }
        Resources resources = com.bytedance.sdk.openadsdk.core.aBv.pA().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return 0.0f;
        }
        float dimensionPixelSize = resources.getDimensionPixelSize(identifier);
        Bzk = dimensionPixelSize;
        return dimensionPixelSize;
    }

    public static void pA(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(3846);
            activity.getWindow().addFlags(1792);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("UIUtils", e.getMessage());
        }
    }

    public static void Og(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(1792);
            activity.getWindow().clearFlags(1792);
        } catch (Exception unused) {
        }
    }

    public static boolean KZx(Activity activity) {
        if (SGo == null) {
            synchronized (BSW) {
                if (SGo == null) {
                    String strPA = com.bytedance.sdk.openadsdk.vZF.pA.pA("cutout_devices", "");
                    String str = Build.MODEL;
                    if (!TextUtils.isEmpty(strPA) && !TextUtils.isEmpty(str)) {
                        try {
                            JSONArray jSONArray = new JSONArray(strPA);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                if (str.equals(jSONArray.getString(i))) {
                                    SGo = Boolean.TRUE;
                                    return true;
                                }
                            }
                        } catch (Exception e) {
                            TX.Og("UIUtils", e.getMessage());
                        }
                    }
                    SGo = Boolean.valueOf(ZZv(activity) || pA("ro.miui.notch", activity) == 1 || BSW(activity) || DX(activity) || WV(activity) || Wx(activity) || Sn(activity));
                }
            }
        }
        return SGo.booleanValue();
    }

    public static boolean Og() {
        return WV && Build.VERSION.SDK_INT >= 28;
    }

    public static boolean ZZv(Activity activity) {
        DisplayCutout displayCutout;
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            if (rootWindowInsets != null) {
                displayCutout = rootWindowInsets.getDisplayCutout();
                WV = false;
            } else {
                displayCutout = null;
            }
            return displayCutout != null;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("UIUtils", e.getMessage());
            return false;
        }
    }

    public static int pA(String str, Activity activity) {
        if (!du.ML()) {
            return 0;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, new String(str), 0)).intValue();
        } catch (ClassNotFoundException e) {
            com.bytedance.sdk.component.utils.WV.pA("UIUtils", e.getMessage());
            return 0;
        } catch (IllegalAccessException e2) {
            com.bytedance.sdk.component.utils.WV.pA("UIUtils", e2.getMessage());
            return 0;
        } catch (IllegalArgumentException e3) {
            com.bytedance.sdk.component.utils.WV.pA("UIUtils", e3.getMessage());
            return 0;
        } catch (NoSuchMethodException e4) {
            com.bytedance.sdk.component.utils.WV.pA("UIUtils", e4.getMessage());
            return 0;
        } catch (InvocationTargetException e5) {
            com.bytedance.sdk.component.utils.WV.pA("UIUtils", e5.getMessage());
            return 0;
        }
    }

    public static boolean BSW(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static boolean WV(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static boolean Wx(Context context) {
        return Build.MODEL.equals("IN2010") || Build.MODEL.equals("IN2020") || Build.MODEL.equals("KB2000") || Build.MODEL.startsWith("ONEPLUS");
    }

    public static boolean Sn(Context context) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");
            String string = identifier > 0 ? resources.getString(identifier) : null;
            return (string == null || TextUtils.isEmpty(string)) ? false : true;
        } catch (Exception unused) {
        }
    }

    public static boolean DX(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static void pA(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.WV.pA("OnclickListener ", str + " is null , can not set OnClickListener !!!");
        } else {
            view.setOnClickListener(onClickListener);
        }
    }

    public static void pA(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.WV.pA("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
        } else {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public static void pA(View view, float f) {
        if (view == null) {
            return;
        }
        view.setAlpha(f);
    }

    public static void pA(TextView textView, com.bytedance.sdk.openadsdk.core.widget.oX oXVar, com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        pA(textView, oXVar, yfo, 14);
    }

    public static void pA(TextView textView, com.bytedance.sdk.openadsdk.core.widget.oX oXVar, com.bytedance.sdk.openadsdk.core.model.yFO yfo, int i) {
        pA(textView, oXVar, (yfo == null || yfo.Wo() == null) ? -1.0d : yfo.Wo().ZZv(), i);
    }

    public static void pA(TextView textView, com.bytedance.sdk.openadsdk.core.widget.oX oXVar, double d, int i) {
        if (d == -1.0d) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            oXVar.setVisibility(8);
        } else {
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%.1f", Double.valueOf(d)));
            }
            pA(oXVar, d, i);
        }
    }

    public static void pA(com.bytedance.sdk.openadsdk.core.widget.oX oXVar, double d, int i) {
        if (d < 0.0d) {
            oXVar.setVisibility(8);
        } else {
            oXVar.setVisibility(0);
            oXVar.pA(d, i);
        }
    }

    public static Bitmap pA(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        WebView webView = zZv.getWebView();
        int layerType = webView.getLayerType();
        webView.setLayerType(1, null);
        Bitmap bitmapOg = Og(zZv);
        if (bitmapOg == null) {
            bitmapOg = pA(webView);
        }
        webView.setLayerType(layerType, null);
        if (bitmapOg == null) {
            return null;
        }
        return com.bytedance.sdk.component.utils.ZZv.pA(bitmapOg, bitmapOg.getWidth() / 6, bitmapOg.getHeight() / 6);
    }

    public static void pA(final com.bytedance.sdk.openadsdk.core.model.yFO yfo, final String str, final String str2, final Bitmap bitmap, final String str3, final long j) {
        xy.Og(new com.bytedance.sdk.component.omh.omh("startCheckPlayableStatusPercentage") { // from class: com.bytedance.sdk.openadsdk.utils.Vgu.3
            @Override // java.lang.Runnable
            public void run() {
                Vgu.KZx(yfo, str, str2, bitmap, str3, j);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void KZx(final com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str, String str2, final Bitmap bitmap, final String str3, final long j) {
        if (bitmap != null) {
            try {
                if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && !bitmap.isRecycled()) {
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA(System.currentTimeMillis(), yfo, str, str2, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.utils.Vgu.4
                        @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
                        public JSONObject pA() {
                            try {
                                int iPA = Vgu.pA(bitmap);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str3);
                                long j2 = j;
                                if (j2 != -1) {
                                    jSONObject.put("page_id", j2);
                                }
                                jSONObject.put("render_type", "h5");
                                jSONObject.put("render_type_2", 0);
                                jSONObject.put("is_blank", iPA == 100 ? 1 : 0);
                                jSONObject.put("is_playable", com.bytedance.sdk.openadsdk.core.model.WQf.Og(yfo) ? 1 : 0);
                                jSONObject.put("usecache", com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(yfo) ? 1 : 0);
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                                    return jSONObject2;
                                } catch (JSONException unused) {
                                    return jSONObject2;
                                }
                            } catch (JSONException unused2) {
                                return null;
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("UIUtils", "(Developers can ignore this detection exception)checkWebViewIsTransparent->throwable ex>>>".concat(String.valueOf(th)));
            }
        }
    }

    private static Bitmap Og(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        if (zZv == null) {
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(zZv.getWidth(), zZv.getHeight(), Bitmap.Config.RGB_565);
            zZv.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int pA(Bitmap bitmap) {
        try {
            ArrayList<Integer> arrayListOg = Og(bitmap);
            if (arrayListOg == null) {
                return -1;
            }
            HashMap map = new HashMap();
            for (Integer num : arrayListOg) {
                if (map.containsKey(num)) {
                    Integer numValueOf = Integer.valueOf(((Integer) map.get(num)).intValue() + 1);
                    map.remove(num);
                    map.put(num, numValueOf);
                } else {
                    map.put(num, 1);
                }
            }
            int iIntValue = 0;
            int i = 0;
            for (Map.Entry entry : map.entrySet()) {
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (i < iIntValue2) {
                    iIntValue = ((Integer) entry.getKey()).intValue();
                    i = iIntValue2;
                }
            }
            if (iIntValue == 0) {
                return -1;
            }
            return (int) ((i / ((bitmap.getWidth() * bitmap.getHeight()) * 1.0f)) * 100.0f);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static ArrayList<Integer> Og(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i = width * height;
            int[] iArr = new int[i];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = iArr[i2];
                arrayList.add(Integer.valueOf(Color.rgb((16711680 & i3) >> 16, (65280 & i3) >> 8, i3 & 255)));
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void Og(View view, final float f) {
        if (view != null && f > 0.0f) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.utils.Vgu.5
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f);
                }
            });
            view.setClipToOutline(true);
        }
    }

    public static void SD(View view) {
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public static boolean pA(float f, float f2, Context context) {
        new Object[]{Float.valueOf(f), Float.valueOf(f2)};
        if (f != -1.0f && f2 != -1.0f) {
            if (SD == null) {
                SD = ViewConfiguration.get(context);
            }
            if (omh == -1) {
                omh = SD.getScaledTouchSlop();
            }
            if (f - f2 > omh) {
                return true;
            }
        }
        return false;
    }

    public static void pA(boolean z) {
        SGo = Boolean.valueOf(z);
    }
}
