package com.fyber.inneractive.sdk.ignite;

import com.digitalturbine.ignite.authenticator.logger.ILogger;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes11.dex */
public final class k implements ILogger {
    @Override // com.digitalturbine.ignite.authenticator.logger.ILogger
    public final void d(String str, Object... objArr) {
        IAlog.a(str, objArr);
    }

    @Override // com.digitalturbine.ignite.authenticator.logger.ILogger
    public final void e(String str, Object... objArr) {
        IAlog.b(str, objArr);
    }

    @Override // com.digitalturbine.ignite.authenticator.logger.ILogger
    public final void i(String str, Object... objArr) {
        IAlog.c(str, objArr);
    }

    @Override // com.digitalturbine.ignite.authenticator.logger.ILogger
    public final void v(String str, Object... objArr) {
        IAlog.e(str, objArr);
    }

    @Override // com.digitalturbine.ignite.authenticator.logger.ILogger
    public final void w(String str, Object... objArr) {
        IAlog.f(str, objArr);
    }
}
