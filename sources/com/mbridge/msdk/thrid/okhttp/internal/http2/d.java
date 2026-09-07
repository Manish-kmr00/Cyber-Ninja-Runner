package com.mbridge.msdk.thrid.okhttp.internal.http2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.hm;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.mbridge.msdk.thrid.okio.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Hpack.java */
/* JADX INFO: loaded from: classes7.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final c[] f5538a;
    static final Map<com.mbridge.msdk.thrid.okio.f, Integer> b;

    /* JADX INFO: compiled from: Hpack.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<c> f5539a;
        private final com.mbridge.msdk.thrid.okio.e b;
        private final int c;
        private int d;
        c[] e;
        int f;
        int g;
        int h;

        a(int i, s sVar) {
            this(i, i, sVar);
        }

        private void a() {
            int i = this.d;
            int i2 = this.h;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    b(i2 - i);
                }
            }
        }

        private void b() {
            Arrays.fill(this.e, (Object) null);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
        }

        private boolean d(int i) {
            return i >= 0 && i <= d.f5538a.length - 1;
        }

        private void e(int i) throws IOException {
            if (d(i)) {
                this.f5539a.add(d.f5538a[i]);
                return;
            }
            int iA = a(i - d.f5538a.length);
            if (iA >= 0) {
                c[] cVarArr = this.e;
                if (iA < cVarArr.length) {
                    this.f5539a.add(cVarArr[iA]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void g(int i) throws IOException {
            this.f5539a.add(new c(c(i), e()));
        }

        private void h() throws IOException {
            this.f5539a.add(new c(d.a(e()), e()));
        }

        public List<c> c() {
            ArrayList arrayList = new ArrayList(this.f5539a);
            this.f5539a.clear();
            return arrayList;
        }

        void f() throws IOException {
            while (!this.b.f()) {
                byte b = this.b.readByte();
                int i = b & 255;
                if (i == 128) {
                    throw new IOException("index == 0");
                }
                if ((b & 128) == 128) {
                    e(a(i, 127) - 1);
                } else if (i == 64) {
                    g();
                } else if ((b & SignedBytes.MAX_POWER_OF_TWO) == 64) {
                    f(a(i, 63) - 1);
                } else if ((b & 32) == 32) {
                    int iA = a(i, 31);
                    this.d = iA;
                    if (iA < 0 || iA > this.c) {
                        throw new IOException("Invalid dynamic table size update " + this.d);
                    }
                    a();
                } else if (i == 16 || i == 0) {
                    h();
                } else {
                    g(a(i, 15) - 1);
                }
            }
        }

        a(int i, int i2, s sVar) {
            this.f5539a = new ArrayList();
            this.e = new c[8];
            this.f = 7;
            this.g = 0;
            this.h = 0;
            this.c = i;
            this.d = i2;
            this.b = com.mbridge.msdk.thrid.okio.l.a(sVar);
        }

        private int d() throws IOException {
            return this.b.readByte() & 255;
        }

        private com.mbridge.msdk.thrid.okio.f c(int i) throws IOException {
            if (d(i)) {
                return d.f5538a[i].f5537a;
            }
            int iA = a(i - d.f5538a.length);
            if (iA >= 0) {
                c[] cVarArr = this.e;
                if (iA < cVarArr.length) {
                    return cVarArr[iA].f5537a;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void g() throws IOException {
            a(-1, new c(d.a(e()), e()));
        }

        private int b(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.e.length;
                while (true) {
                    length--;
                    i2 = this.f;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.e[length].c;
                    i -= i4;
                    this.h -= i4;
                    this.g--;
                    i3++;
                }
                c[] cVarArr = this.e;
                int i5 = i2 + 1;
                System.arraycopy(cVarArr, i5, cVarArr, i5 + i3, this.g);
                this.f += i3;
            }
            return i3;
        }

        private int a(int i) {
            return this.f + 1 + i;
        }

        private void a(int i, c cVar) {
            this.f5539a.add(cVar);
            int i2 = cVar.c;
            if (i != -1) {
                i2 -= this.e[a(i)].c;
            }
            int i3 = this.d;
            if (i2 > i3) {
                b();
                return;
            }
            int iB = b((this.h + i2) - i3);
            if (i == -1) {
                int i4 = this.g + 1;
                c[] cVarArr = this.e;
                if (i4 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f = this.e.length - 1;
                    this.e = cVarArr2;
                }
                int i5 = this.f;
                this.f = i5 - 1;
                this.e[i5] = cVar;
                this.g++;
            } else {
                this.e[i + a(i) + iB] = cVar;
            }
            this.h += i2;
        }

        com.mbridge.msdk.thrid.okio.f e() throws IOException {
            int iD = d();
            boolean z = (iD & 128) == 128;
            int iA = a(iD, 127);
            if (z) {
                return com.mbridge.msdk.thrid.okio.f.a(k.b().a(this.b.c(iA)));
            }
            return this.b.b(iA);
        }

        private void f(int i) throws IOException {
            a(-1, new c(c(i), e()));
        }

        int a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iD = d();
                if ((iD & 128) == 0) {
                    return i2 + (iD << i4);
                }
                i2 += (iD & 127) << i4;
                i4 += 7;
            }
        }
    }

    /* JADX INFO: compiled from: Hpack.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.thrid.okio.c f5540a;
        private final boolean b;
        private int c;
        private boolean d;
        int e;
        int f;
        c[] g;
        int h;
        int i;
        int j;

        b(com.mbridge.msdk.thrid.okio.c cVar) {
            this(4096, true, cVar);
        }

        private int a(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.g.length;
                while (true) {
                    length--;
                    i2 = this.h;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.g[length].c;
                    i -= i4;
                    this.j -= i4;
                    this.i--;
                    i3++;
                }
                c[] cVarArr = this.g;
                int i5 = i2 + 1;
                System.arraycopy(cVarArr, i5, cVarArr, i5 + i3, this.i);
                c[] cVarArr2 = this.g;
                int i6 = this.h + 1;
                Arrays.fill(cVarArr2, i6, i6 + i3, (Object) null);
                this.h += i3;
            }
            return i3;
        }

        private void b() {
            Arrays.fill(this.g, (Object) null);
            this.h = this.g.length - 1;
            this.i = 0;
            this.j = 0;
        }

        b(int i, boolean z, com.mbridge.msdk.thrid.okio.c cVar) {
            this.c = Integer.MAX_VALUE;
            this.g = new c[8];
            this.h = 7;
            this.i = 0;
            this.j = 0;
            this.e = i;
            this.f = i;
            this.b = z;
            this.f5540a = cVar;
        }

        void b(int i) {
            this.e = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.f;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.c = Math.min(this.c, iMin);
            }
            this.d = true;
            this.f = iMin;
            a();
        }

        private void a(c cVar) {
            int i = cVar.c;
            int i2 = this.f;
            if (i > i2) {
                b();
                return;
            }
            a((this.j + i) - i2);
            int i3 = this.i + 1;
            c[] cVarArr = this.g;
            if (i3 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.h = this.g.length - 1;
                this.g = cVarArr2;
            }
            int i4 = this.h;
            this.h = i4 - 1;
            this.g[i4] = cVar;
            this.i++;
            this.j += i;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0069  */
        void a(List<c> list) throws IOException {
            int length;
            int length2;
            if (this.d) {
                int i = this.c;
                if (i < this.f) {
                    a(i, 31, 32);
                }
                this.d = false;
                this.c = Integer.MAX_VALUE;
                a(this.f, 31, 32);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = list.get(i2);
                com.mbridge.msdk.thrid.okio.f fVarF = cVar.f5537a.f();
                com.mbridge.msdk.thrid.okio.f fVar = cVar.b;
                Integer num = d.b.get(fVarF);
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (length2 <= 1 || length2 >= 8) {
                        length = length2;
                        length2 = -1;
                    } else {
                        c[] cVarArr = d.f5538a;
                        if (com.mbridge.msdk.thrid.okhttp.internal.c.a(cVarArr[iIntValue].b, fVar)) {
                            length = length2;
                        } else if (com.mbridge.msdk.thrid.okhttp.internal.c.a(cVarArr[length2].b, fVar)) {
                            length2 = iIntValue + 2;
                            length = length2;
                        } else {
                            length = length2;
                            length2 = -1;
                        }
                    }
                } else {
                    length = -1;
                    length2 = -1;
                }
                if (length2 == -1) {
                    int length3 = this.g.length;
                    for (int i3 = this.h + 1; i3 < length3; i3++) {
                        if (com.mbridge.msdk.thrid.okhttp.internal.c.a(this.g[i3].f5537a, fVarF)) {
                            if (com.mbridge.msdk.thrid.okhttp.internal.c.a(this.g[i3].b, fVar)) {
                                length2 = (i3 - this.h) + d.f5538a.length;
                                break;
                            } else if (length == -1) {
                                length = (i3 - this.h) + d.f5538a.length;
                            }
                        }
                    }
                }
                if (length2 != -1) {
                    a(length2, 127, 128);
                } else if (length == -1) {
                    this.f5540a.writeByte(64);
                    a(fVarF);
                    a(fVar);
                    a(cVar);
                } else if (fVarF.b(c.d) && !c.i.equals(fVarF)) {
                    a(length, 15, 0);
                    a(fVar);
                } else {
                    a(length, 63, 64);
                    a(fVar);
                    a(cVar);
                }
            }
        }

        void a(int i, int i2, int i3) {
            if (i < i2) {
                this.f5540a.writeByte(i | i3);
                return;
            }
            this.f5540a.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f5540a.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f5540a.writeByte(i4);
        }

        void a(com.mbridge.msdk.thrid.okio.f fVar) throws IOException {
            if (this.b && k.b().a(fVar) < fVar.e()) {
                com.mbridge.msdk.thrid.okio.c cVar = new com.mbridge.msdk.thrid.okio.c();
                k.b().a(fVar, cVar);
                com.mbridge.msdk.thrid.okio.f fVarO = cVar.o();
                a(fVarO.e(), 127, 128);
                this.f5540a.a(fVarO);
                return;
            }
            a(fVar.e(), 127, 0);
            this.f5540a.a(fVar);
        }

        private void a() {
            int i = this.f;
            int i2 = this.j;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    a(i2 - i);
                }
            }
        }
    }

    static {
        com.mbridge.msdk.thrid.okio.f fVar = c.f;
        com.mbridge.msdk.thrid.okio.f fVar2 = c.g;
        com.mbridge.msdk.thrid.okio.f fVar3 = c.h;
        com.mbridge.msdk.thrid.okio.f fVar4 = c.e;
        f5538a = new c[]{new c(c.i, ""), new c(fVar, "GET"), new c(fVar, "POST"), new c(fVar2, RemoteSettings.FORWARD_SLASH_STRING), new c(fVar2, "/index.html"), new c(fVar3, "http"), new c(fVar3, "https"), new c(fVar4, "200"), new c(fVar4, "204"), new c(fVar4, "206"), new c(fVar4, "304"), new c(fVar4, "400"), new c(fVar4, "404"), new c(fVar4, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c(DownloadModel.ETAG, ""), new c("expect", ""), new c("expires", ""), new c(TypedValues.TransitionType.S_FROM, ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c(SessionDescription.ATTR_RANGE, ""), new c("referer", ""), new c(ToolBar.REFRESH, ""), new c("retry-after", ""), new c(hm.f3752a, ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        b = a();
    }

    private static Map<com.mbridge.msdk.thrid.okio.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f5538a.length);
        int i = 0;
        while (true) {
            c[] cVarArr = f5538a;
            if (i >= cVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cVarArr[i].f5537a)) {
                linkedHashMap.put(cVarArr[i].f5537a, Integer.valueOf(i));
            }
            i++;
        }
    }

    static com.mbridge.msdk.thrid.okio.f a(com.mbridge.msdk.thrid.okio.f fVar) throws IOException {
        int iE = fVar.e();
        for (int i = 0; i < iE; i++) {
            byte bA = fVar.a(i);
            if (bA >= 65 && bA <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.h());
            }
        }
        return fVar;
    }
}
