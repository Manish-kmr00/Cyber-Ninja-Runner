package io.appmetrica.analytics.impl;

import android.os.FileObserver;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.p6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class FileObserverC4358p6 extends FileObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Consumer f11714a;
    public final File b;
    public final C4163ha c;

    public FileObserverC4358p6(File file, G1 g1, C4163ha c4163ha) {
        super(file.getAbsolutePath(), 4095);
        this.f11714a = g1;
        this.b = file;
        this.c = c4163ha;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        Consumer consumer = this.f11714a;
        C4163ha c4163ha = this.c;
        File file = this.b;
        c4163ha.getClass();
        consumer.consume(new File(file, str));
    }
}
