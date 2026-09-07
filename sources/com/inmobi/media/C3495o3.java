package com.inmobi.media;

import com.safedk.android.internal.partials.InMobiFilesBridge;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* JADX INFO: renamed from: com.inmobi.media.o3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3495o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3509p3 f3385a;
    public final boolean[] b;
    public boolean c;
    public final /* synthetic */ C3536r3 d;

    public C3495o3(C3536r3 c3536r3, C3509p3 c3509p3) {
        this.d = c3536r3;
        this.f3385a = c3509p3;
        this.b = c3509p3.c ? null : new boolean[c3536r3.h];
    }

    public final OutputStream a(int i) {
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        C3481n3 c3481n3;
        synchronized (this.d) {
            C3509p3 c3509p3 = this.f3385a;
            if (c3509p3.d != this) {
                throw new IllegalStateException();
            }
            if (!c3509p3.c) {
                this.b[i] = true;
            }
            File fileB = c3509p3.b(i);
            try {
                fileOutputStreamFileOutputStreamCtor = InMobiFilesBridge.fileOutputStreamCtor(fileB);
            } catch (FileNotFoundException unused) {
                this.d.f3414a.mkdirs();
                try {
                    fileOutputStreamFileOutputStreamCtor = InMobiFilesBridge.fileOutputStreamCtor(fileB);
                } catch (FileNotFoundException unused2) {
                    return C3536r3.q;
                }
            }
            c3481n3 = new C3481n3(this, fileOutputStreamFileOutputStreamCtor);
        }
        return c3481n3;
    }

    public final void a(String str, int i) throws Throwable {
        OutputStreamWriter outputStreamWriter = null;
        try {
            OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(a(i), Dc.b);
            try {
                outputStreamWriter2.write(str);
                Dc.a(outputStreamWriter2);
            } catch (Throwable th) {
                th = th;
                outputStreamWriter = outputStreamWriter2;
                Dc.a(outputStreamWriter);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
