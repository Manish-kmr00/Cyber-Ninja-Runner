package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f2175a;
    public final File b;

    public c(File file) {
        this.f2175a = file;
        this.b = new File(file.getPath() + ".bak");
    }

    public final FileInputStream a() {
        if (this.b.exists()) {
            this.f2175a.delete();
            this.b.renameTo(this.f2175a);
        }
        return new FileInputStream(this.f2175a);
    }

    public final b b() throws IOException {
        if (this.f2175a.exists()) {
            if (this.b.exists()) {
                this.f2175a.delete();
            } else if (!this.f2175a.renameTo(this.b)) {
                Log.w("AtomicFile", "Couldn't rename file " + this.f2175a + " to backup file " + this.b);
            }
        }
        try {
            return new b(this.f2175a);
        } catch (FileNotFoundException unused) {
            if (!this.f2175a.getParentFile().mkdirs()) {
                throw new IOException("Couldn't create directory " + this.f2175a);
            }
            try {
                return new b(this.f2175a);
            } catch (FileNotFoundException unused2) {
                throw new IOException("Couldn't create " + this.f2175a);
            }
        }
    }
}
