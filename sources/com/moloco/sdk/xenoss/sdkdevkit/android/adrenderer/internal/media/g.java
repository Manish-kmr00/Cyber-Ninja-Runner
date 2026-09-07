package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import android.content.Context;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6592a;
    public final String b;
    public final String c;

    public g(Context appContext, String cacheDir) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        this.f6592a = appContext;
        this.b = cacheDir;
        this.c = "MediaCacheLocationProviderImpl";
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f
    public v<File, com.moloco.sdk.internal.m> a() {
        try {
            File externalCacheDir = this.f6592a.getExternalCacheDir();
            if (externalCacheDir != null) {
                File file = new File(externalCacheDir, this.b);
                file.mkdir();
                if (file.exists()) {
                    return new v.b(file);
                }
            }
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, this.c, "Failed to create cache directory in external storage", null, false, 12, null);
            return new v.a(new com.moloco.sdk.internal.m("Failed to create cache directory in external storage", 102));
        } catch (IOException e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.c, "Failed to create cache directory in external storage", e, false, 8, null);
            return new v.a(new com.moloco.sdk.internal.m("Failed to create cache directory in external storage", 101));
        } catch (SecurityException e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.c, "Failed to create cache directory in external storage", e2, false, 8, null);
            return new v.a(new com.moloco.sdk.internal.m("Failed to create cache directory in external storage", 100));
        } catch (Exception e3) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.c, "Failed to create cache directory in external storage", e3, false, 8, null);
            return new v.a(new com.moloco.sdk.internal.m("Failed to create cache directory in external storage", 200));
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f
    public v<File, com.moloco.sdk.internal.m> b() {
        try {
            if (this.f6592a.getCacheDir() != null) {
                File file = new File(this.f6592a.getCacheDir(), this.b);
                file.mkdir();
                if (file.exists()) {
                    MolocoLogger.debug$default(MolocoLogger.INSTANCE, this.c, "Able to write to internal storage cache directory", false, 4, null);
                    return new v.b(file);
                }
            }
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.c, "Failed to create cache directory in internal storage", null, false, 12, null);
            return new v.a(new com.moloco.sdk.internal.m("Failed to create cache directory in internal storage", 102));
        } catch (IOException e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.c, "Failed to create cache directory in external storage", e, false, 8, null);
            return new v.a(new com.moloco.sdk.internal.m("Failed to create cache directory in internal storage", 101));
        } catch (SecurityException e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.c, "Failed to create cache directory in external storage", e2, false, 8, null);
            return new v.a(new com.moloco.sdk.internal.m("Failed to create cache directory in internal storage", 100));
        } catch (Exception e3) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.c, "Failed to create cache directory in external storage", e3, false, 8, null);
            return new v.a(new com.moloco.sdk.internal.m("Failed to create cache directory in internal storage", 200));
        }
    }

    public final Context c() {
        return this.f6592a;
    }

    public final String d() {
        return this.b;
    }
}
