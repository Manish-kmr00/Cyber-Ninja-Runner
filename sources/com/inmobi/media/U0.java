package com.inmobi.media;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class U0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final U0 f3208a = new U0();
    public static LinkedHashSet b;
    public static boolean c;

    public static final boolean a(U0 u0, Context context) {
        u0.getClass();
        try {
            Object systemService = context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                String packageName = context.getPackageName();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (packageName.equals(runningAppProcessInfo.processName)) {
                        if (runningAppProcessInfo.importance == 100) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("U0", "TAG");
        }
        return false;
    }

    public static final /* synthetic */ String b() {
        return "U0";
    }

    public final void c() {
        c = true;
    }

    public final void d() {
        c = false;
    }

    public static final void a(U0 u0, boolean z) {
        LinkedHashSet linkedHashSet;
        u0.getClass();
        if (C3517pb.d() == null || (linkedHashSet = b) == null) {
            return;
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            try {
                ((C3658zc) ((S0) it.next())).a(z);
            } catch (Exception unused) {
                Intrinsics.checkNotNullExpressionValue("U0", "TAG");
            }
        }
    }

    public final void a(Context context, S0 listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (b == null) {
            b = new LinkedHashSet();
            Context applicationContext = context.getApplicationContext();
            Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
            if (application != null) {
                try {
                    application.registerActivityLifecycleCallbacks(new T0(context));
                } catch (Throwable unused) {
                }
            }
        }
        LinkedHashSet linkedHashSet = b;
        if (linkedHashSet != null) {
            linkedHashSet.add(listener);
        }
    }
}
