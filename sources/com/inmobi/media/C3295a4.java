package com.inmobi.media;

import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.a4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3295a4 implements Z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Movie f3264a;
    public int b;
    public long c;
    public volatile boolean d;
    public C3310b4 e;

    public C3295a4(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        File file = new File(filePath);
        byte[] bArr = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            int i = fileInputStream.read(bArr);
            W8.a((Closeable) fileInputStream);
            Movie movieDecodeByteArray = Movie.decodeByteArray(bArr, 0, i);
            this.f3264a = movieDecodeByteArray;
            if (movieDecodeByteArray == null) {
                throw new IllegalStateException("Cannot decode gif byte array");
            }
        } catch (Throwable th) {
            W8.a((Closeable) fileInputStream);
            throw th;
        }
    }

    @Override // com.inmobi.media.Z3
    public final void a(boolean z) {
        this.d = z;
        if (!this.d) {
            this.c = SystemClock.uptimeMillis() - ((long) this.b);
        }
        C3310b4 c3310b4 = this.e;
        if (c3310b4 != null) {
            Intrinsics.checkNotNull(c3310b4);
            c3310b4.invalidate();
        }
    }

    @Override // com.inmobi.media.Z3
    public final void b() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.c == 0) {
            this.c = jUptimeMillis;
        }
        Movie movie = this.f3264a;
        int iDuration = movie != null ? movie.duration() : 0;
        if (iDuration == 0) {
            iDuration = 1000;
        }
        int i = (int) ((jUptimeMillis - this.c) % ((long) iDuration));
        this.b = i;
        Movie movie2 = this.f3264a;
        if (movie2 != null) {
            movie2.setTime(i);
        }
    }

    @Override // com.inmobi.media.Z3
    public final boolean c() {
        return !this.d;
    }

    @Override // com.inmobi.media.Z3
    public final int d() {
        Movie movie = this.f3264a;
        if (movie != null) {
            return movie.width();
        }
        return 0;
    }

    public final void e() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.a4$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3295a4.a(this.f$0);
            }
        });
    }

    @Override // com.inmobi.media.Z3
    public final void start() {
    }

    @Override // com.inmobi.media.Z3
    public final int a() {
        Movie movie = this.f3264a;
        if (movie != null) {
            return movie.height();
        }
        return 0;
    }

    @Override // com.inmobi.media.Z3
    public final void a(Canvas canvas, float f, float f2) {
        Movie movie = this.f3264a;
        if (movie != null) {
            movie.draw(canvas, f, f2);
        }
        Movie movie2 = this.f3264a;
        if (this.b + 20 >= (movie2 != null ? movie2.duration() : 0)) {
            e();
        }
    }

    public static final void a(C3295a4 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b = 0;
        this$0.a(false);
    }

    @Override // com.inmobi.media.Z3
    public final void a(C3310b4 c3310b4) {
        this.e = c3310b4;
    }
}
