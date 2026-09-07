package com.yandex.mobile.ads.impl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: loaded from: classes4.dex */
public final class ig0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final if0[] f9214a;
    private static final Map<ByteString, Integer> b;
    public static final /* synthetic */ int c = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9215a;
        private final ArrayList b;
        private final BufferedSource c;
        public if0[] d;
        private int e;
        public int f;
        public int g;

        public /* synthetic */ a(kh0.b bVar) {
            this(bVar, 4096);
        }

        private final ByteString b(int i) throws IOException {
            if (i >= 0 && i <= ig0.b().length - 1) {
                return ig0.b()[i].f9210a;
            }
            int length = this.e + 1 + (i - ig0.b().length);
            if (length >= 0) {
                if0[] if0VarArr = this.d;
                if (length < if0VarArr.length) {
                    if0 if0Var = if0VarArr[length];
                    Intrinsics.checkNotNull(if0Var);
                    return if0Var.f9210a;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        public a(kh0.b source, int i) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.f9215a = i;
            this.b = new ArrayList();
            this.c = Okio.buffer(source);
            this.d = new if0[8];
            this.e = 7;
        }

        public final ByteString b() throws IOException {
            byte b = this.c.readByte();
            byte[] bArr = y82.f10712a;
            int i = b & 255;
            boolean z = (b & 128) == 128;
            long jA = a(i, 127);
            if (z) {
                Buffer buffer = new Buffer();
                int i2 = fi0.d;
                fi0.a(this.c, jA, buffer);
                return buffer.readByteString();
            }
            return this.c.readByteString(jA);
        }

        private final int a(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.d.length;
                while (true) {
                    length--;
                    i2 = this.e;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    if0 if0Var = this.d[length];
                    Intrinsics.checkNotNull(if0Var);
                    int i4 = if0Var.c;
                    i -= i4;
                    this.g -= i4;
                    this.f--;
                    i3++;
                }
                if0[] if0VarArr = this.d;
                int i5 = i2 + 1;
                System.arraycopy(if0VarArr, i5, if0VarArr, i5 + i3, this.f);
                this.e += i3;
            }
            return i3;
        }

        public final void c() throws IOException {
            while (!this.c.exhausted()) {
                int iA = y82.a(this.c.readByte());
                if (iA == 128) {
                    throw new IOException("index == 0");
                }
                if ((iA & 128) == 128) {
                    c(a(iA, 127) - 1);
                } else if (iA == 64) {
                    int i = ig0.c;
                    a(new if0(ig0.a(b()), b()));
                } else if ((iA & 64) == 64) {
                    a(new if0(b(a(iA, 63) - 1), b()));
                } else if ((iA & 32) == 32) {
                    int iA2 = a(iA, 31);
                    this.f9215a = iA2;
                    if (iA2 >= 0 && iA2 <= 4096) {
                        int i2 = this.g;
                        if (iA2 < i2) {
                            if (iA2 == 0) {
                                ArraysKt.fill$default(this.d, (Object) null, 0, 0, 6, (Object) null);
                                this.e = this.d.length - 1;
                                this.f = 0;
                                this.g = 0;
                            } else {
                                a(i2 - iA2);
                            }
                        }
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.f9215a);
                    }
                } else if (iA != 16 && iA != 0) {
                    this.b.add(new if0(b(a(iA, 15) - 1), b()));
                } else {
                    int i3 = ig0.c;
                    this.b.add(new if0(ig0.a(b()), b()));
                }
            }
        }

        private final void c(int i) throws IOException {
            if (i >= 0 && i <= ig0.b().length - 1) {
                this.b.add(ig0.b()[i]);
                return;
            }
            int length = this.e + 1 + (i - ig0.b().length);
            if (length >= 0) {
                if0[] if0VarArr = this.d;
                if (length < if0VarArr.length) {
                    ArrayList arrayList = this.b;
                    if0 if0Var = if0VarArr[length];
                    Intrinsics.checkNotNull(if0Var);
                    arrayList.add(if0Var);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        public final List<if0> a() {
            List<if0> list = CollectionsKt.toList(this.b);
            this.b.clear();
            return list;
        }

        private final void a(if0 if0Var) {
            this.b.add(if0Var);
            int i = if0Var.c;
            int i2 = this.f9215a;
            if (i > i2) {
                ArraysKt.fill$default(this.d, (Object) null, 0, 0, 6, (Object) null);
                this.e = this.d.length - 1;
                this.f = 0;
                this.g = 0;
                return;
            }
            a((this.g + i) - i2);
            int i3 = this.f + 1;
            if0[] if0VarArr = this.d;
            if (i3 > if0VarArr.length) {
                if0[] if0VarArr2 = new if0[if0VarArr.length * 2];
                System.arraycopy(if0VarArr, 0, if0VarArr2, if0VarArr.length, if0VarArr.length);
                this.e = this.d.length - 1;
                this.d = if0VarArr2;
            }
            int i4 = this.e;
            this.e = i4 - 1;
            this.d[i4] = if0Var;
            this.f++;
            this.g += i;
        }

        public final int a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                byte b = this.c.readByte();
                byte[] bArr = y82.f10712a;
                int i5 = b & 255;
                if ((b & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (b & 127) << i4;
                i4 += 7;
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f9216a;
        private final Buffer b;
        private int c;
        private boolean d;
        public int e;
        public if0[] f;
        private int g;
        public int h;
        public int i;

        public b(int i, boolean z, Buffer out) {
            Intrinsics.checkNotNullParameter(out, "out");
            this.f9216a = z;
            this.b = out;
            this.c = Integer.MAX_VALUE;
            this.e = i;
            this.f = new if0[8];
            this.g = 7;
        }

        private final void a(int i) {
            int i2;
            if (i > 0) {
                int length = this.f.length - 1;
                int i3 = 0;
                while (true) {
                    i2 = this.g;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    if0 if0Var = this.f[length];
                    Intrinsics.checkNotNull(if0Var);
                    i -= if0Var.c;
                    int i4 = this.i;
                    if0 if0Var2 = this.f[length];
                    Intrinsics.checkNotNull(if0Var2);
                    this.i = i4 - if0Var2.c;
                    this.h--;
                    i3++;
                    length--;
                }
                if0[] if0VarArr = this.f;
                int i5 = i2 + 1;
                System.arraycopy(if0VarArr, i5, if0VarArr, i5 + i3, this.h);
                if0[] if0VarArr2 = this.f;
                int i6 = this.g + 1;
                Arrays.fill(if0VarArr2, i6, i6 + i3, (Object) null);
                this.g += i3;
            }
        }

        public /* synthetic */ b(Buffer buffer) {
            this(4096, true, buffer);
        }

        private final void a(if0 if0Var) {
            int i = if0Var.c;
            int i2 = this.e;
            if (i > i2) {
                ArraysKt.fill$default(this.f, (Object) null, 0, 0, 6, (Object) null);
                this.g = this.f.length - 1;
                this.h = 0;
                this.i = 0;
                return;
            }
            a((this.i + i) - i2);
            int i3 = this.h + 1;
            if0[] if0VarArr = this.f;
            if (i3 > if0VarArr.length) {
                if0[] if0VarArr2 = new if0[if0VarArr.length * 2];
                System.arraycopy(if0VarArr, 0, if0VarArr2, if0VarArr.length, if0VarArr.length);
                this.g = this.f.length - 1;
                this.f = if0VarArr2;
            }
            int i4 = this.g;
            this.g = i4 - 1;
            this.f[i4] = if0Var;
            this.h++;
            this.i += i;
        }

        public final void a(ByteString data) throws IOException {
            Intrinsics.checkNotNullParameter(data, "data");
            if (this.f9216a && fi0.a(data) < data.size()) {
                Buffer buffer = new Buffer();
                fi0.a(data, buffer);
                ByteString byteString = buffer.readByteString();
                a(byteString.size(), 127, 128);
                this.b.write(byteString);
                return;
            }
            a(data.size(), 127, 0);
            this.b.write(data);
        }

        public final void b(int i) {
            int iMin = Math.min(i, 16384);
            int i2 = this.e;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.c = Math.min(this.c, iMin);
            }
            this.d = true;
            this.e = iMin;
            int i3 = this.i;
            if (iMin < i3) {
                if (iMin == 0) {
                    ArraysKt.fill$default(this.f, (Object) null, 0, 0, 6, (Object) null);
                    this.g = this.f.length - 1;
                    this.h = 0;
                    this.i = 0;
                    return;
                }
                a(i3 - iMin);
            }
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0076  */
        public final void a(ArrayList headerBlock) throws IOException {
            int length;
            int length2;
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            if (this.d) {
                int i = this.c;
                if (i < this.e) {
                    a(i, 31, 32);
                }
                this.d = false;
                this.c = Integer.MAX_VALUE;
                a(this.e, 31, 32);
            }
            int size = headerBlock.size();
            for (int i2 = 0; i2 < size; i2++) {
                if0 if0Var = (if0) headerBlock.get(i2);
                ByteString asciiLowercase = if0Var.f9210a.toAsciiLowercase();
                ByteString byteString = if0Var.b;
                Integer num = (Integer) ig0.a().get(asciiLowercase);
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (2 > length2 || length2 >= 8) {
                        length = length2;
                        length2 = -1;
                    } else if (Intrinsics.areEqual(ig0.b()[iIntValue].b, byteString)) {
                        length = length2;
                    } else if (Intrinsics.areEqual(ig0.b()[length2].b, byteString)) {
                        length2 = iIntValue + 2;
                        length = length2;
                    } else {
                        length = length2;
                        length2 = -1;
                    }
                } else {
                    length = -1;
                    length2 = -1;
                }
                if (length2 == -1) {
                    int length3 = this.f.length;
                    for (int i3 = this.g + 1; i3 < length3; i3++) {
                        if0 if0Var2 = this.f[i3];
                        Intrinsics.checkNotNull(if0Var2);
                        if (Intrinsics.areEqual(if0Var2.f9210a, asciiLowercase)) {
                            if0 if0Var3 = this.f[i3];
                            Intrinsics.checkNotNull(if0Var3);
                            if (Intrinsics.areEqual(if0Var3.b, byteString)) {
                                length2 = ig0.b().length + (i3 - this.g);
                                break;
                            } else if (length == -1) {
                                length = (i3 - this.g) + ig0.b().length;
                            }
                        }
                    }
                }
                if (length2 != -1) {
                    a(length2, 127, 128);
                } else if (length == -1) {
                    this.b.writeByte(64);
                    a(asciiLowercase);
                    a(byteString);
                    a(if0Var);
                } else if (asciiLowercase.startsWith(if0.d) && !Intrinsics.areEqual(if0.i, asciiLowercase)) {
                    a(length, 15, 0);
                    a(byteString);
                } else {
                    a(length, 63, 64);
                    a(byteString);
                    a(if0Var);
                }
            }
        }

        public final void a(int i, int i2, int i3) {
            if (i < i2) {
                this.b.writeByte(i | i3);
                return;
            }
            this.b.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.b.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.b.writeByte(i4);
        }
    }

    static {
        if0 if0Var = new if0(if0.i, "");
        ByteString name = if0.f;
        if0 if0Var2 = new if0(name, "GET");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter("POST", "value");
        ByteString.Companion companion = ByteString.INSTANCE;
        if0 if0Var3 = new if0(name, companion.encodeUtf8("POST"));
        ByteString name2 = if0.g;
        if0 if0Var4 = new if0(name2, RemoteSettings.FORWARD_SLASH_STRING);
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter("/index.html", "value");
        if0 if0Var5 = new if0(name2, companion.encodeUtf8("/index.html"));
        ByteString name3 = if0.h;
        if0 if0Var6 = new if0(name3, "http");
        Intrinsics.checkNotNullParameter(name3, "name");
        Intrinsics.checkNotNullParameter("https", "value");
        if0 if0Var7 = new if0(name3, companion.encodeUtf8("https"));
        ByteString name4 = if0.e;
        if0 if0Var8 = new if0(name4, "200");
        Intrinsics.checkNotNullParameter(name4, "name");
        Intrinsics.checkNotNullParameter("204", "value");
        if0 if0Var9 = new if0(name4, companion.encodeUtf8("204"));
        Intrinsics.checkNotNullParameter(name4, "name");
        Intrinsics.checkNotNullParameter("206", "value");
        if0 if0Var10 = new if0(name4, companion.encodeUtf8("206"));
        Intrinsics.checkNotNullParameter(name4, "name");
        Intrinsics.checkNotNullParameter("304", "value");
        if0 if0Var11 = new if0(name4, companion.encodeUtf8("304"));
        Intrinsics.checkNotNullParameter(name4, "name");
        Intrinsics.checkNotNullParameter("400", "value");
        if0 if0Var12 = new if0(name4, companion.encodeUtf8("400"));
        Intrinsics.checkNotNullParameter(name4, "name");
        Intrinsics.checkNotNullParameter("404", "value");
        if0 if0Var13 = new if0(name4, companion.encodeUtf8("404"));
        Intrinsics.checkNotNullParameter(name4, "name");
        Intrinsics.checkNotNullParameter("500", "value");
        if0 if0Var14 = new if0(name4, companion.encodeUtf8("500"));
        Intrinsics.checkNotNullParameter("accept-charset", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var15 = new if0(companion.encodeUtf8("accept-charset"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("accept-encoding", "name");
        Intrinsics.checkNotNullParameter("gzip, deflate", "value");
        if0 if0Var16 = new if0(companion.encodeUtf8("accept-encoding"), companion.encodeUtf8("gzip, deflate"));
        Intrinsics.checkNotNullParameter("accept-language", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var17 = new if0(companion.encodeUtf8("accept-language"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("accept-ranges", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var18 = new if0(companion.encodeUtf8("accept-ranges"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("accept", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var19 = new if0(companion.encodeUtf8("accept"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("access-control-allow-origin", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var20 = new if0(companion.encodeUtf8("access-control-allow-origin"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("age", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var21 = new if0(companion.encodeUtf8("age"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("allow", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var22 = new if0(companion.encodeUtf8("allow"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("authorization", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var23 = new if0(companion.encodeUtf8("authorization"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("cache-control", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var24 = new if0(companion.encodeUtf8("cache-control"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("content-disposition", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var25 = new if0(companion.encodeUtf8("content-disposition"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("content-encoding", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var26 = new if0(companion.encodeUtf8("content-encoding"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("content-language", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var27 = new if0(companion.encodeUtf8("content-language"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("content-length", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var28 = new if0(companion.encodeUtf8("content-length"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("content-location", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var29 = new if0(companion.encodeUtf8("content-location"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("content-range", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var30 = new if0(companion.encodeUtf8("content-range"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("content-type", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var31 = new if0(companion.encodeUtf8("content-type"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("cookie", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var32 = new if0(companion.encodeUtf8("cookie"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("date", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var33 = new if0(companion.encodeUtf8("date"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter(DownloadModel.ETAG, "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var34 = new if0(companion.encodeUtf8(DownloadModel.ETAG), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("expect", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var35 = new if0(companion.encodeUtf8("expect"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("expires", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var36 = new if0(companion.encodeUtf8("expires"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter(TypedValues.TransitionType.S_FROM, "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var37 = new if0(companion.encodeUtf8(TypedValues.TransitionType.S_FROM), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("host", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var38 = new if0(companion.encodeUtf8("host"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("if-match", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var39 = new if0(companion.encodeUtf8("if-match"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("if-modified-since", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var40 = new if0(companion.encodeUtf8("if-modified-since"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("if-none-match", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var41 = new if0(companion.encodeUtf8("if-none-match"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("if-range", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var42 = new if0(companion.encodeUtf8("if-range"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("if-unmodified-since", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var43 = new if0(companion.encodeUtf8("if-unmodified-since"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("last-modified", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var44 = new if0(companion.encodeUtf8("last-modified"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("link", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var45 = new if0(companion.encodeUtf8("link"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("location", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var46 = new if0(companion.encodeUtf8("location"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("max-forwards", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var47 = new if0(companion.encodeUtf8("max-forwards"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("proxy-authenticate", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var48 = new if0(companion.encodeUtf8("proxy-authenticate"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("proxy-authorization", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var49 = new if0(companion.encodeUtf8("proxy-authorization"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter(SessionDescription.ATTR_RANGE, "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var50 = new if0(companion.encodeUtf8(SessionDescription.ATTR_RANGE), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("referer", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var51 = new if0(companion.encodeUtf8("referer"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter(ToolBar.REFRESH, "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var52 = new if0(companion.encodeUtf8(ToolBar.REFRESH), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("retry-after", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var53 = new if0(companion.encodeUtf8("retry-after"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter(com.json.hm.f3752a, "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var54 = new if0(companion.encodeUtf8(com.json.hm.f3752a), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("set-cookie", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var55 = new if0(companion.encodeUtf8("set-cookie"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("strict-transport-security", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var56 = new if0(companion.encodeUtf8("strict-transport-security"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("transfer-encoding", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var57 = new if0(companion.encodeUtf8("transfer-encoding"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("user-agent", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var58 = new if0(companion.encodeUtf8("user-agent"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("vary", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var59 = new if0(companion.encodeUtf8("vary"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("via", "name");
        Intrinsics.checkNotNullParameter("", "value");
        if0 if0Var60 = new if0(companion.encodeUtf8("via"), companion.encodeUtf8(""));
        Intrinsics.checkNotNullParameter("www-authenticate", "name");
        Intrinsics.checkNotNullParameter("", "value");
        f9214a = new if0[]{if0Var, if0Var2, if0Var3, if0Var4, if0Var5, if0Var6, if0Var7, if0Var8, if0Var9, if0Var10, if0Var11, if0Var12, if0Var13, if0Var14, if0Var15, if0Var16, if0Var17, if0Var18, if0Var19, if0Var20, if0Var21, if0Var22, if0Var23, if0Var24, if0Var25, if0Var26, if0Var27, if0Var28, if0Var29, if0Var30, if0Var31, if0Var32, if0Var33, if0Var34, if0Var35, if0Var36, if0Var37, if0Var38, if0Var39, if0Var40, if0Var41, if0Var42, if0Var43, if0Var44, if0Var45, if0Var46, if0Var47, if0Var48, if0Var49, if0Var50, if0Var51, if0Var52, if0Var53, if0Var54, if0Var55, if0Var56, if0Var57, if0Var58, if0Var59, if0Var60, new if0(companion.encodeUtf8("www-authenticate"), companion.encodeUtf8(""))};
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int i = 0; i < 61; i++) {
            if0[] if0VarArr = f9214a;
            if (!linkedHashMap.containsKey(if0VarArr[i].f9210a)) {
                linkedHashMap.put(if0VarArr[i].f9210a, Integer.valueOf(i));
            }
        }
        Map<ByteString, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(...)");
        b = mapUnmodifiableMap;
    }

    public static ByteString a(ByteString name) throws IOException {
        Intrinsics.checkNotNullParameter(name, "name");
        int size = name.size();
        for (int i = 0; i < size; i++) {
            byte b2 = name.getByte(i);
            if (65 <= b2 && b2 < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.utf8());
            }
        }
        return name;
    }

    public static if0[] b() {
        return f9214a;
    }

    public static Map a() {
        return b;
    }
}
