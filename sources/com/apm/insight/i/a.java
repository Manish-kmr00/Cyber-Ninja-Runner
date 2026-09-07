package com.apm.insight.i;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.apm.insight.runtime.q;
import java.util.UUID;

/* JADX INFO: compiled from: DeviceUuidFactory.java */
/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile UUID f216a = null;
    private static String b = "";

    public static synchronized String a(Context context) {
        if (TextUtils.isEmpty(b)) {
            new a(context);
            UUID uuid = f216a;
            if (uuid != null) {
                b = uuid.toString();
            }
        }
        return b;
    }

    private a(Context context) {
        String string;
        if (f216a == null) {
            synchronized (a.class) {
                if (f216a == null) {
                    String strC = q.a().c();
                    if (strC != null) {
                        f216a = UUID.fromString(strC);
                    } else {
                        try {
                            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        } catch (Throwable unused) {
                            string = null;
                        }
                        try {
                            if (string != null) {
                                f216a = UUID.nameUUIDFromBytes(string.getBytes("utf8"));
                            } else {
                                f216a = UUID.randomUUID();
                            }
                        } catch (Throwable unused2) {
                        }
                        try {
                            q.a().b(f216a.toString());
                        } catch (Throwable unused3) {
                        }
                    }
                }
            }
        }
    }
}
