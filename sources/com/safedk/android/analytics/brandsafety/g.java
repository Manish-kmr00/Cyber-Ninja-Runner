package com.safedk.android.analytics.brandsafety;

import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.AppLovinBridge;
import com.safedk.android.analytics.reporters.CrashReporter;
import com.safedk.android.utils.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes6.dex */
public class g implements AppLovinCommunicatorPublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8096a = "BrandSafetyReporter";
    private static final ExecutorService b = Executors.newSingleThreadExecutor();
    private static g c = null;

    private g() {
        d();
    }

    public static g a() {
        if (c == null) {
            c = new g();
        }
        return c;
    }

    private void d() {
        com.safedk.android.analytics.b bVar = new com.safedk.android.analytics.b() { // from class: com.safedk.android.analytics.brandsafety.g.1
            @Override // com.safedk.android.analytics.b
            public void a(String str, Bundle bundle) {
                Logger.d(g.f8096a, "Response received, response=" + bundle.toString());
            }
        };
        AppLovinBridge.registerListener(AppLovinBridge.c, bVar);
        AppLovinBridge.registerListener(AppLovinBridge.d, bVar);
    }

    public static void a(final Bundle bundle) {
        Logger.d(f8096a, "report image uploaded to server started");
        try {
            b.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.g.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (bundle != null) {
                            if (bundle.size() > 0) {
                                Logger.d(g.f8096a, "Starting image upload report event.");
                                AppLovinBridge.reportImageUploadEvent(bundle, g.c);
                                String string = bundle.getString("image_id");
                                c cVarJ = b.j(string);
                                if (cVarJ != null) {
                                    for (k kVar : cVarJ.g()) {
                                        if (string.contains(kVar.f8110a)) {
                                            g.b(kVar, cVarJ.p);
                                        }
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        Logger.d(g.f8096a, "Data argument is null, which means that the upload failed or that the validation check has failed. Nothing to report to the server.");
                    } catch (Throwable th) {
                        Logger.e(g.f8096a, "Caught exception while creating json data", th);
                        new CrashReporter().caughtException(th);
                    }
                }
            });
        } catch (Throwable th) {
            Logger.e(f8096a, "failed during reportImageUploadedToServer. data: " + bundle.toString(), th);
            new CrashReporter().caughtException(th);
        }
    }

    public static void b(final Bundle bundle) {
        Logger.d(f8096a, "report file uploaded to server started");
        try {
            b.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.g.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (bundle != null && bundle.size() > 0) {
                            Logger.d(g.f8096a, "Starting file upload report event.");
                            AppLovinBridge.reportFileUploadEvent(bundle, g.c);
                        } else {
                            Logger.d(g.f8096a, "Data argument is null, which means that the upload failed or that the validation check has failed. Nothing to report to the server.");
                        }
                    } catch (Throwable th) {
                        Logger.e(g.f8096a, "Caught exception while creating json data", th);
                        new CrashReporter().caughtException(th);
                    }
                }
            });
        } catch (Throwable th) {
            Logger.e(f8096a, "failed during reportFileUploadedToServer. data: " + bundle, th);
            new CrashReporter().caughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(k kVar, BrandSafetyUtils.AdType adType) {
        if (kVar != null) {
            a aVarA = SafeDK.getInstance().a(adType);
            if (aVarA != null) {
                Logger.d(f8096a, "Executing image cleanup request");
                aVarA.b(kVar);
            } else {
                Logger.d(f8096a, "Upload: finder not found for image cleanup request");
            }
        }
    }

    public static void c(final Bundle bundle) {
        try {
            b.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.g.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (bundle != null) {
                            if (bundle.size() > 0) {
                                Logger.d(g.f8096a, "Starting url resolution report event.");
                                AppLovinBridge.reportClickUrlResolvedEvent(bundle, g.c);
                            }
                        } else {
                            Logger.d(g.f8096a, "Data argument is null, which means reporting a resolved click url is not possible. ");
                        }
                    } catch (Throwable th) {
                        Logger.e(g.f8096a, "Caught exception while creating json data", th);
                        new CrashReporter().caughtException(th);
                    }
                }
            });
        } catch (Throwable th) {
            Logger.e(f8096a, "failed during reportImageUploadedToServer. data: " + bundle.toString(), th);
            new CrashReporter().caughtException(th);
        }
    }

    public String b() {
        return AppLovinBridge.f7952a;
    }
}
