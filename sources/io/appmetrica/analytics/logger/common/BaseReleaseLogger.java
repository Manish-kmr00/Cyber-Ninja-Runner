package io.appmetrica.analytics.logger.common;

import android.content.Context;
import android.util.Log;
import com.json.b9;
import io.appmetrica.analytics.logger.common.impl.a;
import io.appmetrica.analytics.logger.common.impl.b;
import io.appmetrica.analytics.logger.common.impl.c;
import io.appmetrica.analytics.logger.common.impl.d;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseReleaseLogger {
    private static volatile String d = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11913a;
    private volatile boolean b = false;
    private final c c;

    public BaseReleaseLogger(String str, String str2) {
        this.c = new c(new d(str), new a(), new b());
        this.f11913a = str2;
    }

    public static void init(Context context) {
        d = b9.i.d + context.getPackageName() + "] : ";
    }

    public void error(String str, Object... objArr) {
        if (this.b) {
            c cVar = this.c;
            String prefix = getPrefix();
            cVar.b.getClass();
            for (String str2 : cVar.c.a(a.a(prefix, str, objArr))) {
                String str3 = cVar.f11915a.f11916a;
                if (str2 == null) {
                    str2 = "";
                }
                Log.println(6, str3, str2);
            }
        }
    }

    public String getPrefix() {
        return d + this.f11913a;
    }

    public void info(String str, Object... objArr) {
        if (this.b) {
            c cVar = this.c;
            String prefix = getPrefix();
            cVar.b.getClass();
            for (String str2 : cVar.c.a(a.a(prefix, str, objArr))) {
                String str3 = cVar.f11915a.f11916a;
                if (str2 == null) {
                    str2 = "";
                }
                Log.println(4, str3, str2);
            }
        }
    }

    public void setEnabled(boolean z) {
        this.b = z;
    }

    public void warning(String str, Object... objArr) {
        if (this.b) {
            c cVar = this.c;
            String prefix = getPrefix();
            cVar.b.getClass();
            for (String str2 : cVar.c.a(a.a(prefix, str, objArr))) {
                String str3 = cVar.f11915a.f11916a;
                if (str2 == null) {
                    str2 = "";
                }
                Log.println(5, str3, str2);
            }
        }
    }

    public void error(Throwable th, String str, Object... objArr) {
        if (this.b) {
            c cVar = this.c;
            String prefix = getPrefix();
            cVar.b.getClass();
            StringBuilder sb = new StringBuilder();
            if (str == null) {
                str = "";
            }
            for (String str2 : cVar.c.a(a.a(prefix, sb.append(str).append("\n").append(Log.getStackTraceString(th)).toString(), objArr))) {
                String str3 = cVar.f11915a.f11916a;
                if (str2 == null) {
                    str2 = "";
                }
                Log.println(6, str3, str2);
            }
        }
    }
}
