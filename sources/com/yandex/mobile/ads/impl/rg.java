package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class rg extends ik {
    private final AssetManager e;
    private Uri f;
    private InputStream g;
    private long h;
    private boolean i;

    public static final class a extends rv {
        public a(IOException iOException, int i) {
            super(iOException, i);
        }
    }

    public rg(Context context) {
        super(false);
        this.e = context.getAssets();
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final long a(uv uvVar) throws a {
        try {
            Uri uri = uvVar.f10424a;
            this.f = uri;
            String path = uri.getPath();
            path.getClass();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                path = path.substring(1);
            }
            b(uvVar);
            InputStream inputStreamOpen = this.e.open(path, 1);
            this.g = inputStreamOpen;
            if (inputStreamOpen.skip(uvVar.f) >= uvVar.f) {
                long j = uvVar.g;
                if (j != -1) {
                    this.h = j;
                } else {
                    long jAvailable = this.g.available();
                    this.h = jAvailable;
                    if (jAvailable == 2147483647L) {
                        this.h = -1L;
                    }
                }
                this.i = true;
                c(uvVar);
                return this.h;
            }
            throw new a(null, 2008);
        } catch (a e) {
            throw e;
        } catch (IOException e2) {
            throw new a(e2, e2 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // com.yandex.mobile.ads.impl.nv
    public final int read(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.h;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new a(e, 2000);
            }
        }
        InputStream inputStream = this.g;
        int i3 = x82.f10629a;
        int i4 = inputStream.read(bArr, i, i2);
        if (i4 == -1) {
            return -1;
        }
        long j2 = this.h;
        if (j2 != -1) {
            this.h = j2 - ((long) i4);
        }
        c(i4);
        return i4;
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
    public final void close() throws com.yandex.mobile.ads.impl.rg.a {
        /*
            r5 = this;
            r0 = 0
            r5.f = r0
            r1 = 0
            java.io.InputStream r2 = r5.g     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L19
            if (r2 == 0) goto Lb
            r2.close()     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L19
        Lb:
            r5.g = r0
            boolean r0 = r5.i
            if (r0 == 0) goto L16
            r5.i = r1
            r5.e()
        L16:
            return
        L17:
            r2 = move-exception
            goto L22
        L19:
            r2 = move-exception
            com.yandex.mobile.ads.impl.rg$a r3 = new com.yandex.mobile.ads.impl.rg$a     // Catch: java.lang.Throwable -> L17
            r4 = 2000(0x7d0, float:2.803E-42)
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L17
            throw r3     // Catch: java.lang.Throwable -> L17
        L22:
            r5.g = r0
            boolean r0 = r5.i
            if (r0 == 0) goto L2d
            r5.i = r1
            r5.e()
        L2d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.rg.close():void");
    }
}
