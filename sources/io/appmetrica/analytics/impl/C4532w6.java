package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.w6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4532w6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4163ha f11827a;
    public final C4383q6 b;
    public final Context c;
    public final C4138ga d;

    public C4532w6(Context context) {
        this(context, new C4163ha(), new C4383q6(), C4138ga.a(context));
    }

    public final void a(C4319nh c4319nh) {
        boolean zMkdir;
        D9 d9A;
        PrintWriter printWriter;
        File crashesDirectory = FileUtils.getCrashesDirectory(this.c);
        this.b.getClass();
        if (crashesDirectory == null) {
            return;
        }
        try {
            try {
                if (crashesDirectory.exists()) {
                    if (!crashesDirectory.isDirectory()) {
                        if (!crashesDirectory.delete()) {
                            return;
                        } else {
                            zMkdir = crashesDirectory.mkdir();
                        }
                    }
                    C4367pf c4367pf = c4319nh.e.f11474a;
                    String str = c4367pf.f11723a.getAsInteger("PROCESS_CFG_PROCESS_ID") + "-" + c4367pf.f11723a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
                    d9A = this.d.a(str);
                    d9A.f11102a.lock();
                    d9A.b.a();
                    this.f11827a.getClass();
                    printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
                    printWriter.write(new C4363pb(c4319nh.f11686a, c4319nh.e, c4319nh.d).k());
                    In.a((Closeable) printWriter);
                    d9A.c();
                    return;
                }
                zMkdir = crashesDirectory.mkdir();
                printWriter.write(new C4363pb(c4319nh.f11686a, c4319nh.e, c4319nh.d).k());
                In.a((Closeable) printWriter);
                d9A.c();
                return;
            } catch (Throwable unused) {
                In.a((Closeable) printWriter);
                d9A.c();
                return;
            }
            d9A.f11102a.lock();
            d9A.b.a();
            this.f11827a.getClass();
            printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
        } catch (Throwable unused2) {
            printWriter = null;
        }
        if (!zMkdir) {
            return;
        }
        C4367pf c4367pf2 = c4319nh.e.f11474a;
        String str2 = c4367pf2.f11723a.getAsInteger("PROCESS_CFG_PROCESS_ID") + "-" + c4367pf2.f11723a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
        d9A = this.d.a(str2);
    }

    public C4532w6(Context context, C4163ha c4163ha, C4383q6 c4383q6, C4138ga c4138ga) {
        this.c = context;
        this.f11827a = c4163ha;
        this.b = c4383q6;
        this.d = c4138ga;
    }
}
