package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.File;
import kotlin.Unit;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ja, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4212ja {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Boolean f11616a;

    public final void a(Context context) {
        if (this.f11616a == null) {
            synchronized (this) {
                if (this.f11616a == null) {
                    boolean z = false;
                    try {
                        File fileFromAppStorage = FileUtils.getFileFromAppStorage(context, "uuid.dat");
                        boolean zExists = fileFromAppStorage != null ? fileFromAppStorage.exists() : false;
                        File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(context, "uuid.dat");
                        boolean zExists2 = fileFromSdkStorage != null ? fileFromSdkStorage.exists() : false;
                        if (zExists || zExists2) {
                            z = true;
                        }
                    } catch (Throwable unused) {
                    }
                    this.f11616a = Boolean.valueOf(z);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
