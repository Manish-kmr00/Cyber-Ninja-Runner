package io.bidmachine.iab.utils;

import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes10.dex */
public class Logger {
    private static LogLevel c = LogLevel.error;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12245a;
    private final List b = new CopyOnWriteArrayList();

    public enum LogLevel {
        debug(1),
        info(2),
        warning(3),
        error(4),
        none(5);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12246a;

        LogLevel(int value) {
            this.f12246a = value;
        }

        public int getValue() {
            return this.f12246a;
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12247a;

        static {
            int[] iArr = new int[LogLevel.values().length];
            f12247a = iArr;
            try {
                iArr[LogLevel.debug.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12247a[LogLevel.error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12247a[LogLevel.warning.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Logger(String tag) {
        this.f12245a = tag;
    }

    private static String a(String str, String str2) {
        return String.format("[%s] %s", str, str2);
    }

    private boolean b(LogLevel logLevel) {
        LogLevel logLevel2 = c;
        return logLevel2 != null && logLevel2.getValue() <= logLevel.getValue();
    }

    public void addLogListener(LogListener logListener) {
        if (logListener != null) {
            this.b.add(logListener);
        }
    }

    public boolean canSendDLog() {
        return a(LogLevel.debug);
    }

    public boolean canSendELog() {
        return a(LogLevel.error);
    }

    public boolean canSendWLog() {
        return a(LogLevel.warning);
    }

    public void d(String subTag, String message, Object... args) {
        a(LogLevel.debug, subTag, message, args);
    }

    public void e(String subTag, String message, Object... args) {
        a(LogLevel.error, subTag, message, args);
    }

    public LogLevel getLoggingLevel() {
        return c;
    }

    public boolean removeLogListener(LogListener logListener) {
        return logListener != null && this.b.remove(logListener);
    }

    public void setLoggingLevel(LogLevel logLevel) {
        Log.d(this.f12245a, String.format("Changing logging level. From: %s, To: %s", c, logLevel));
        c = logLevel;
    }

    public void w(String subTag, String message, Object... args) {
        a(LogLevel.warning, subTag, message, args);
    }

    private boolean a(LogLevel logLevel) {
        return b(logLevel) || a();
    }

    private void b(LogLevel logLevel, String str) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((LogListener) it.next()).onLog(logLevel, this.f12245a, str);
        }
    }

    public void e(String subTag, Throwable throwable) {
        a(LogLevel.error, subTag, throwable.toString(), new Object[0]);
    }

    private static String a(String str, String str2, Object... objArr) {
        String strA = a(str, str2);
        if (objArr == null || objArr.length == 0) {
            return strA;
        }
        try {
            return String.format(strA, objArr);
        } catch (Throwable unused) {
            return strA;
        }
    }

    private void a(LogLevel logLevel, String str, String str2, Object... objArr) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        boolean zB = b(logLevel);
        boolean zA = a();
        if (zB || zA) {
            String strA = a(str, str2, objArr);
            if (zB) {
                a(logLevel, strA);
            }
            if (zA) {
                b(logLevel, strA);
            }
        }
    }

    private void a(LogLevel logLevel, String str) {
        int i = a.f12247a[logLevel.ordinal()];
        if (i == 1) {
            Log.d(this.f12245a, str);
        } else if (i == 2) {
            Log.e(this.f12245a, str);
        } else {
            if (i != 3) {
                return;
            }
            Log.w(this.f12245a, str);
        }
    }

    private boolean a() {
        return !this.b.isEmpty();
    }
}
