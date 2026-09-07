package com.fyber.inneractive.sdk.logger;

import android.content.Context;

/* JADX INFO: loaded from: classes12.dex */
public abstract class FMPLogger {
    public abstract void debug(String str, Object... objArr);

    public abstract void error(String str, Throwable th, Object... objArr);

    public abstract void info(String str, Object... objArr);

    public abstract void initialize(Context context);

    public abstract void log(int i, Exception exc, String str, Object... objArr);

    public abstract void verbose(String str, Throwable th, Object... objArr);

    public abstract void verbose(String str, Object... objArr);

    public abstract void warning(String str, Object... objArr);
}
