package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes10.dex */
public final class eb0 extends ik {
    private RandomAccessFile e;
    private Uri f;
    private long g;
    private boolean h;

    public static final class b implements qv.a {
        @Override // com.yandex.mobile.ads.impl.qv.a
        public final qv a() {
            return new eb0();
        }
    }

    public static class c extends rv {
        public c(int i, String str, FileNotFoundException fileNotFoundException) {
            super(i, str, fileNotFoundException);
        }

        public c(Exception exc, int i) {
            super(exc, i);
        }
    }

    public eb0() {
        super(false);
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final long a(uv uvVar) throws c {
        Uri uri = uvVar.f10424a;
        this.f = uri;
        b(uvVar);
        try {
            String path = uri.getPath();
            path.getClass();
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.e = randomAccessFile;
            try {
                randomAccessFile.seek(uvVar.f);
                long length = uvVar.g;
                if (length == -1) {
                    length = this.e.length() - uvVar.f;
                }
                this.g = length;
                if (length >= 0) {
                    this.h = true;
                    c(uvVar);
                    return this.g;
                }
                throw new c(2008, null, null);
            } catch (IOException e) {
                throw new c(e, 2000);
            }
        } catch (FileNotFoundException e2) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new c(e2, (x82.f10629a < 21 || !a.a(e2.getCause())) ? 2005 : 2006);
            }
            throw new c(1004, "uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=" + uri.getPath() + ",query=" + uri.getQuery() + ",fragment=" + uri.getFragment(), e2);
        } catch (SecurityException e3) {
            throw new c(e3, 2006);
        } catch (RuntimeException e4) {
            throw new c(e4, 2000);
        }
    }

    @Override // com.yandex.mobile.ads.impl.nv
    public final int read(byte[] bArr, int i, int i2) throws c {
        if (i2 == 0) {
            return 0;
        }
        long j = this.g;
        if (j == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.e;
            int i3 = x82.f10629a;
            int i4 = randomAccessFile.read(bArr, i, (int) Math.min(j, i2));
            if (i4 > 0) {
                this.g -= (long) i4;
                c(i4);
            }
            return i4;
        } catch (IOException e) {
            throw new c(e, 2000);
        }
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Uri getUri() {
        return this.f;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0017 */
    @Override // com.yandex.mobile.ads.impl.qv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() throws com.yandex.mobile.ads.impl.eb0.c {
        /*
            r5 = this;
            r0 = 0
            r5.f = r0
            r1 = 0
            java.io.RandomAccessFile r2 = r5.e     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L19
            if (r2 == 0) goto Lb
            r2.close()     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L19
        Lb:
            r5.e = r0
            boolean r0 = r5.h
            if (r0 == 0) goto L16
            r5.h = r1
            r5.e()
        L16:
            return
        L17:
            r2 = move-exception
            goto L22
        L19:
            r2 = move-exception
            com.yandex.mobile.ads.impl.eb0$c r3 = new com.yandex.mobile.ads.impl.eb0$c     // Catch: java.lang.Throwable -> L17
            r4 = 2000(0x7d0, float:2.803E-42)
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L17
            throw r3     // Catch: java.lang.Throwable -> L17
        L22:
            r5.e = r0
            boolean r0 = r5.h
            if (r0 == 0) goto L2d
            r5.h = r1
            r5.e()
        L2d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.eb0.close():void");
    }

    private static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static boolean a(Throwable th) {
            return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
        }
    }
}
