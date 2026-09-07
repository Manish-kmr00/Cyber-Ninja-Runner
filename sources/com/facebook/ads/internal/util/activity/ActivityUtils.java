package com.facebook.ads.internal.util.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.facebook.ads.internal.util.common.ANActivityLifecycleCallbacksListener;
import com.facebook.ads.redexgen.core.AbstractC14128a;
import com.facebook.ads.redexgen.core.AbstractC1490Bp;
import com.facebook.ads.redexgen.core.Br;
import com.facebook.ads.redexgen.core.Bs;
import com.facebook.ads.redexgen.core.C14138b;
import com.facebook.ads.redexgen.core.C14499m;
import com.facebook.ads.redexgen.core.C1493Bw;
import com.facebook.ads.redexgen.core.C2698k0;
import com.facebook.ads.redexgen.core.C2699k1;
import com.facebook.ads.redexgen.core.ExecutorC1520Cx;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ActivityUtils implements Application.ActivityLifecycleCallbacks {
    public static Context A01;
    public static C2698k0 A02;
    public static byte[] A03;
    public static String[] A04 = {"92eOfmmmV4HUmtBKNwX5jODUm9snbisL", "83A6RHTc3uHHgwZu0l", "xT8NDmJO40EcDZzCFYpPknxtJdrIGRIs", "yd9OYuKBF31VEKohInrUKVptjNnIlgtF", "ffDhLNnwXMIpP", "gJJ", "YtTChd0N7kYfN", "CHt0mr4gyt"};
    public static final C1493Bw A05;
    public static final List<Bs> A06;
    public static final List<Runnable> A07;
    public static final Map<Activity, Integer> A08;
    public final Class<? extends Activity> A00;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 121);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {Ascii.SO, 2, 35, 69, 86, 75, 88, 75, 86, 91, Ascii.FS, 2, -90, -102, -20, -33, -32, -76, -102, 6, 40, 57, 46, 59, 46, 57, 62, -27, 41, 46, 56, 40, 55, 42, 53, 38, 51, 40, 46, 42, 56, -13, 56, 103, 103, 58, 102, 101, 107, 92, 111, 107, Ascii.ETB, 96, 106, Ascii.ETB, 101, 102, 107, Ascii.ETB, 56, 103, 103, 99, 96, 90, 88, 107, 96, 102, 101, 37, -3, 41, 40, Ascii.GS, 47, 44, 44, Ascii.US, 40, 46, -38, 39, 41, Ascii.RS, 35, 32, 35, Ascii.GS, Ascii.ESC, 46, 35, 41, 40, -38, Ascii.US, 50, Ascii.GS, Ascii.US, 42, 46, 35, 41, 40, -38, 46, 34, 44, 41, 49, 40, Ascii.RS, 47, 44, 35, 40, 33, -38, 44, Ascii.US, 33, 35, 45, 46, Ascii.US, 44, -5, Ascii.GS, 46, 35, 48, 35, 46, 51, -3, Ascii.ESC, 38, 38, Ascii.FS, Ascii.ESC, Ascii.GS, 37, 45, 6, 35, 45, 46, Ascii.US, 40, Ascii.US, 44, 45, 74, 66, -2, 63, 65, 82, 71, 84, 71, 82, 87, -2, 81, 82, 63, 82, 67, Ascii.CAN, -2, Ascii.CAN, 41, Base64.padSymbol, 59, 45, 44, -24, 41, 43, 60, 49, 62, 49, 60, 65, -24, 49, 59, -24, 54, 55, 60, -24, 58, 45, 59, Base64.padSymbol, 53, 45, 44, -10, 44, 63, 77, Ascii.DC4, -6, Ascii.ETB, Ascii.EM, 42, Ascii.NAK, 43, 42, Ascii.US, 34, -35, -20, -27, 58, 57, Ascii.FF, 46, 63, 52, 65, 52, 63, 68, Ascii.SO, Base64.padSymbol, 48, 44, 63, 48, 47};
        if (A04[0].charAt(5) != 'm') {
            throw new RuntimeException();
        }
        A04[7] = "OT1BI2x3SK";
        A03 = bArr;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static synchronized void A04(C2698k0 c2698k0, Class<? extends Activity> cls) {
        A02 = c2698k0;
        A01 = c2698k0.getApplicationContext();
        if (A01 instanceof Application) {
            ANActivityLifecycleCallbacksListener aNActivityLifecycleCallbacksListener = ANActivityLifecycleCallbacksListener.getANActivityLifecycleCallbacksListener();
            if (aNActivityLifecycleCallbacksListener != null) {
                Map<Activity, Integer> activityStateMap = aNActivityLifecycleCallbacksListener.getActivityStateMap();
                synchronized (activityStateMap) {
                    try {
                        A08.putAll(activityStateMap);
                    } catch (ConcurrentModificationException unused) {
                        c2698k0.A08().AAu(A01(208, 8, 61), AbstractC14128a.A02, new C14138b(A01(72, 80, 65)));
                    }
                }
                ANActivityLifecycleCallbacksListener.unregisterActivityCallbacks(c2698k0);
            }
            ((Application) A01).registerActivityLifecycleCallbacks(new ActivityUtils(cls));
        } else {
            c2698k0.A08().AAu(A01(Sdk.SDKError.Reason.AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE, 3, 3), AbstractC14128a.A0d, new C14138b(A01(42, 30, 126)));
        }
    }

    static {
        A02();
        A08 = Collections.synchronizedMap(new WeakHashMap());
        A06 = Collections.synchronizedList(new ArrayList());
        A07 = new ArrayList();
        A05 = C1493Bw.A00();
    }

    public ActivityUtils(Class<? extends Activity> adsActivityClass) {
        this.A00 = adsActivityClass;
    }

    public static synchronized Activity A00() {
        Activity key = null;
        for (Map.Entry<Activity, Integer> entry : A08.entrySet()) {
            if (entry.getValue().intValue() == 3) {
                key = entry.getKey();
                break;
            }
        }
        Activity activityA00 = null;
        boolean z = key == null || Build.VERSION.SDK_INT < 28;
        if (z) {
            activityA00 = AbstractC1490Bp.A00();
        }
        if (A02 != null && z && key != activityA00) {
            C14138b c14138b = new C14138b(A01(19, 23, 76), A01(203, 5, 97) + key + A01(12, 7, 1) + activityA00);
            c14138b.A05(1);
            A02.A08().AAu(A01(208, 8, 61), AbstractC14128a.A03, c14138b);
        }
        return key != null ? key : activityA00;
    }

    public static void A03(C2699k1 c2699k1) {
        if (!C14499m.A1i(c2699k1) || Build.VERSION.SDK_INT >= 29) {
            return;
        }
        Br br = new Br(c2699k1);
        synchronized (A07) {
            A07.add(br);
        }
        ExecutorC1520Cx.A01.A01().postDelayed(br, 2000L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        A08.put(activity, 1);
        Iterator<Bs> it = A06.iterator();
        boolean zHasNext = it.hasNext();
        String[] strArr = A04;
        if (strArr[4].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[3] = "6ucg7ZQRC52PgbYLp0IlsO8L9UBIqtAr";
        strArr2[2] = "XfsAw5zLn3vJHYKMay1aCQiNLVOIwPXI";
        if (zHasNext) {
            it.next();
            throw new NullPointerException(A01(Sdk.SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, 17, 82));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        A08.put(activity, 6);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        ArrayList arrayList;
        Integer num = A08.get(activity);
        if (num == null || num.intValue() != 3) {
            C14138b c14138b = new C14138b(A01(172, 31, 79), A01(152, 20, 101) + num + A01(0, 12, 105) + activity);
            c14138b.A05(0);
            A02.A08().AAu(A01(208, 8, 61), AbstractC14128a.A03, c14138b);
        }
        A08.put(activity, 4);
        if (activity.getClass() != this.A00) {
            synchronized (A07) {
                arrayList = new ArrayList(A07);
                A07.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ExecutorC1520Cx.A01.A01().removeCallbacks((Runnable) it.next());
            }
        }
        A05.A01();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        A08.put(activity, 3);
        A05.A02();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        A08.put(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        A08.put(activity, 5);
    }
}
