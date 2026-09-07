package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.File;
import kotlin.io.FilesKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ia, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4188ia implements Yn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11600a;
    public final String b;

    public C4188ia(Context context, String str) {
        this.f11600a = context;
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.Yn
    public final String a() {
        try {
            File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.f11600a, this.b);
            if (fileFromSdkStorage == null) {
                return null;
            }
            fileFromSdkStorage.exists();
            File fileFromAppStorage = FileUtils.getFileFromAppStorage(this.f11600a, this.b);
            if (fileFromAppStorage != null) {
                FileUtils.copyToNullable(fileFromAppStorage, fileFromSdkStorage);
            }
            return FilesKt.readText$default(fileFromSdkStorage, null, 1, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // io.appmetrica.analytics.impl.Yn
    public final void a(String str) {
        try {
            File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.f11600a, this.b);
            if (fileFromSdkStorage != null) {
                FilesKt.writeText$default(fileFromSdkStorage, str, null, 2, null);
            }
        } catch (Throwable unused) {
        }
    }
}
