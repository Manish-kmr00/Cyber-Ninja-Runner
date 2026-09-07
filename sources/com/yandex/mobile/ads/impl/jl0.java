package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
public final class jl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9329a;
    private final gl0 b;

    public jl0(Context context, gl0 fileProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileProvider, "fileProvider");
        this.f9329a = context;
        this.b = fileProvider;
    }

    public final il0 a(String reportText) {
        Intrinsics.checkNotNullParameter(reportText, "reportText");
        try {
            File fileA = this.b.a();
            File parentFile = fileA.getParentFile();
            long freeSpace = parentFile != null ? parentFile.getFreeSpace() : 0L;
            byte[] bytes = reportText.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            if (bytes.length >= freeSpace) {
                return new il0.a("Not enough space error");
            }
            FilesKt.writeBytes(fileA, bytes);
            Uri uriForFile = FileProvider.getUriForFile(this.f9329a, this.f9329a.getPackageName() + ".monetization.ads.inspector.fileprovider", fileA);
            Intrinsics.checkNotNull(uriForFile);
            return new il0.c(uriForFile);
        } catch (Exception unused) {
            op0.c(new Object[0]);
            return new il0.a("Failed to save report");
        }
    }
}
