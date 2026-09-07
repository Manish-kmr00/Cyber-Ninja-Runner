package sg.bigo.ads.common.utils;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: classes10.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f13302a;

    public static void a(Context context, String str) {
        try {
            if (f13302a) {
                Toast.makeText(context, str, 1).show();
                sg.bigo.ads.common.t.a.a(0, 3, "toastDebug", str);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(String str) {
        if (f13302a) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(boolean z) {
        f13302a = z;
    }

    public static boolean a() {
        return false;
    }

    public static boolean b() {
        return f13302a;
    }
}
