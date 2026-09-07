package com.chartboost.sdk.impl;

import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class g5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f1027a;
    public final File b;
    public final File c;
    public final File d;
    public final File e;
    public final File f;
    public final File g;
    public final File h;
    public final File i;

    public g5(File file) {
        File file2 = new File(file, ".chartboost");
        this.f1027a = file2;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        this.b = a(file2, "css");
        this.c = a(file2, "html");
        this.d = a(file2, "images");
        this.e = a(file2, POBConstants.KEY_JS);
        this.f = a(file2, "templates");
        this.g = a(file2, "videos");
        this.h = a(file2, "precache");
        this.i = a(file2, "precache_queue");
    }

    public File a() {
        return this.f1027a;
    }

    public static File a(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2;
    }
}
