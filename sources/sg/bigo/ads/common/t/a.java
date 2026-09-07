package sg.bigo.ads.common.t;

import android.util.Log;
import com.json.b9;
import sg.bigo.ads.common.utils.t;

/* JADX INFO: loaded from: classes8.dex */
public final class a {
    public static void a(int i, int i2, String str, String str2) {
        if (a(i)) {
            if (i == 0) {
                str2 = b9.i.d + str + "] " + str2;
            }
            Log.println(i2, "BigoAds", str2);
        }
    }

    public static void a(int i, String str, String str2) {
        a(i, 6, str, str2);
    }

    public static void a(String str, String str2) {
        a(0, 4, str, str2);
    }

    private static boolean a(int i) {
        t.a();
        if (t.b()) {
            return i == 2 || i == 1;
        }
        return i == 2;
    }

    public static void b(String str, String str2) {
        a(0, 5, str, str2);
    }
}
