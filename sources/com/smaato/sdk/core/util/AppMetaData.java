package com.smaato.sdk.core.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;

/* JADX INFO: loaded from: classes12.dex */
public final class AppMetaData {
    private final Context context;
    private final Logger logger;

    public AppMetaData(Context context, Logger logger) {
        this.context = (Context) Objects.requireNonNull(context, "Parameter context cannot be null for PermissionChecker::new");
        this.logger = logger;
    }

    public boolean isPermissionGranted(String str) {
        Objects.requireNonNull(str);
        try {
            return this.context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Exception e) {
            this.logger.error(LogDomain.CORE, "permission not granted", e);
            return false;
        }
    }

    public boolean isActivityRegistered(Class<? extends Activity> cls) {
        return Intents.canHandleIntent(this.context, new Intent(this.context, cls));
    }
}
