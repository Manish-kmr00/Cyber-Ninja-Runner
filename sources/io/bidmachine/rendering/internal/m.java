package io.bidmachine.rendering.internal;

import android.text.TextUtils;
import android.util.Log;
import com.json.b9;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes11.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f12368a;

    public static boolean a() {
        return b();
    }

    public static boolean b() {
        return f12368a;
    }

    public static void a(String str, Object... objArr) {
        a(null, str, true, objArr);
    }

    public static void b(Object obj, String str, Object... objArr) {
        a(obj, str, false, objArr);
    }

    public static void a(Object obj, String str, Object... objArr) {
        a(obj, str, true, objArr);
    }

    public static void b(Throwable th) {
        a(th);
    }

    private static void a(Object obj, String str, boolean z, Object... objArr) {
        if (a()) {
            if (objArr != null && objArr.length != 0) {
                try {
                    str = String.format(str, objArr);
                } catch (Throwable unused) {
                }
            }
            if (obj != null) {
                String string = obj.toString();
                if (!TextUtils.isEmpty(string)) {
                    str = b9.i.d + string + "] " + str;
                }
            }
            if (z) {
                Log.e("AdaptiveRendering", str);
            } else {
                Log.d("AdaptiveRendering", str);
            }
        }
    }

    private static void a(Throwable th) {
        if (a()) {
            if (th instanceof UnknownHostException) {
                th.printStackTrace();
            } else {
                Log.w("AdaptiveRendering", th);
            }
        }
    }

    public static void a(boolean z) {
        f12368a = z;
    }
}
