package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes7.dex */
public final class ln1 extends ik {
    private final Resources e;
    private final String f;
    private Uri g;
    private AssetFileDescriptor h;
    private FileInputStream i;
    private long j;
    private boolean k;

    public static class a extends rv {
        public a(int i, String str, Exception exc) {
            super(i, str, exc);
        }
    }

    public static Uri buildRawResourceUri(int i) {
        return Uri.parse("rawresource:///" + i);
    }

    public ln1(Context context) {
        super(false);
        this.e = context.getResources();
        this.f = context.getPackageName();
    }

    /* JADX WARN: Code duplicated, block: B:82:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.yandex.mobile.ads.impl.qv
    public final long a(uv uvVar) throws a {
        int identifier;
        Uri uri = uvVar.f10424a;
        this.g = uri;
        if (!TextUtils.equals("rawresource", uri.getScheme())) {
            if (TextUtils.equals("android.resource", uri.getScheme()) && uri.getPathSegments().size() == 1) {
                String lastPathSegment = uri.getLastPathSegment();
                lastPathSegment.getClass();
                if (lastPathSegment.matches("\\d+")) {
                    String lastPathSegment2 = uri.getLastPathSegment();
                    lastPathSegment2.getClass();
                    identifier = Integer.parseInt(lastPathSegment2);
                }
            }
            if (TextUtils.equals("android.resource", uri.getScheme())) {
                String path = uri.getPath();
                path.getClass();
                if (path.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                    path = path.substring(1);
                }
                String host = uri.getHost();
                identifier = this.e.getIdentifier((TextUtils.isEmpty(host) ? "" : host + ":") + path, "raw", this.f);
                if (identifier == 0) {
                    throw new a(2005, "Resource not found.", null);
                }
            } else {
                throw new a(1004, "URI must either use scheme rawresource or android.resource", null);
            }
        } else {
            try {
                String lastPathSegment3 = uri.getLastPathSegment();
                lastPathSegment3.getClass();
                identifier = Integer.parseInt(lastPathSegment3);
            } catch (NumberFormatException unused) {
                throw new a(1004, "Resource identifier must be an integer.", null);
            }
        }
        b(uvVar);
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.e.openRawResourceFd(identifier);
            this.h = assetFileDescriptorOpenRawResourceFd;
            if (assetFileDescriptorOpenRawResourceFd != null) {
                long length = assetFileDescriptorOpenRawResourceFd.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenRawResourceFd.getFileDescriptor());
                this.i = fileInputStream;
                if (length != -1) {
                    try {
                        if (uvVar.f > length) {
                            throw new a(2008, null, null);
                        }
                    } catch (a e) {
                        throw e;
                    } catch (IOException e2) {
                        throw new a(2000, null, e2);
                    }
                }
                long startOffset = assetFileDescriptorOpenRawResourceFd.getStartOffset();
                long jSkip = fileInputStream.skip(uvVar.f + startOffset) - startOffset;
                if (jSkip == uvVar.f) {
                    if (length == -1) {
                        FileChannel channel = fileInputStream.getChannel();
                        if (channel.size() == 0) {
                            this.j = -1L;
                        } else {
                            long size = channel.size() - channel.position();
                            this.j = size;
                            if (size < 0) {
                                throw new a(2008, null, null);
                            }
                        }
                    } else {
                        long j = length - jSkip;
                        this.j = j;
                        if (j < 0) {
                            throw new rv(2008);
                        }
                    }
                    long jMin = uvVar.g;
                    if (jMin != -1) {
                        long j2 = this.j;
                        if (j2 != -1) {
                            jMin = Math.min(j2, jMin);
                        }
                        this.j = jMin;
                    }
                    this.k = true;
                    c(uvVar);
                    long j3 = uvVar.g;
                    return j3 != -1 ? j3 : this.j;
                }
                throw new a(2008, null, null);
            }
            throw new a(2000, "Resource is compressed: " + uri, null);
        } catch (Resources.NotFoundException e3) {
            throw new a(2005, null, e3);
        }
    }

    @Override // com.yandex.mobile.ads.impl.nv
    public final int read(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.j;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new a(2000, null, e);
            }
        }
        FileInputStream fileInputStream = this.i;
        int i3 = x82.f10629a;
        int i4 = fileInputStream.read(bArr, i, i2);
        if (i4 == -1) {
            if (this.j == -1) {
                return -1;
            }
            throw new a(2000, "End of stream reached having not read sufficient data.", new EOFException());
        }
        long j2 = this.j;
        if (j2 != -1) {
            this.j = j2 - ((long) i4);
        }
        c(i4);
        return i4;
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Uri getUri() {
        return this.g;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0037 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0055 */
    @Override // com.yandex.mobile.ads.impl.qv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() throws com.yandex.mobile.ads.impl.ln1.a {
        /*
            r5 = this;
            r0 = 0
            r5.g = r0
            r1 = 2000(0x7d0, float:2.803E-42)
            r2 = 0
            java.io.FileInputStream r3 = r5.i     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L39
            if (r3 == 0) goto Ld
            r3.close()     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L39
        Ld:
            r5.i = r0
            android.content.res.AssetFileDescriptor r3 = r5.h     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L24
            if (r3 == 0) goto L16
            r3.close()     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L24
        L16:
            r5.h = r0
            boolean r0 = r5.k
            if (r0 == 0) goto L21
            r5.k = r2
            r5.e()
        L21:
            return
        L22:
            r1 = move-exception
            goto L2b
        L24:
            r3 = move-exception
            com.yandex.mobile.ads.impl.ln1$a r4 = new com.yandex.mobile.ads.impl.ln1$a     // Catch: java.lang.Throwable -> L22
            r4.<init>(r1, r0, r3)     // Catch: java.lang.Throwable -> L22
            throw r4     // Catch: java.lang.Throwable -> L22
        L2b:
            r5.h = r0
            boolean r0 = r5.k
            if (r0 == 0) goto L36
            r5.k = r2
            r5.e()
        L36:
            throw r1
        L37:
            r3 = move-exception
            goto L40
        L39:
            r3 = move-exception
            com.yandex.mobile.ads.impl.ln1$a r4 = new com.yandex.mobile.ads.impl.ln1$a     // Catch: java.lang.Throwable -> L37
            r4.<init>(r1, r0, r3)     // Catch: java.lang.Throwable -> L37
            throw r4     // Catch: java.lang.Throwable -> L37
        L40:
            r5.i = r0
            android.content.res.AssetFileDescriptor r4 = r5.h     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            if (r4 == 0) goto L49
            r4.close()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
        L49:
            r5.h = r0
            boolean r0 = r5.k
            if (r0 == 0) goto L54
            r5.k = r2
            r5.e()
        L54:
            throw r3
        L55:
            r1 = move-exception
            goto L5e
        L57:
            r3 = move-exception
            com.yandex.mobile.ads.impl.ln1$a r4 = new com.yandex.mobile.ads.impl.ln1$a     // Catch: java.lang.Throwable -> L55
            r4.<init>(r1, r0, r3)     // Catch: java.lang.Throwable -> L55
            throw r4     // Catch: java.lang.Throwable -> L55
        L5e:
            r5.h = r0
            boolean r0 = r5.k
            if (r0 == 0) goto L69
            r5.k = r2
            r5.e()
        L69:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.ln1.close():void");
    }
}
