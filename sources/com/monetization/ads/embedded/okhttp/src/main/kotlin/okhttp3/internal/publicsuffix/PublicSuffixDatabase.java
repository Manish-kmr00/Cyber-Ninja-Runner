package com.monetization.ads.embedded.okhttp.src.main.kotlin.okhttp3.internal.publicsuffix;

import com.yandex.mobile.ads.impl.nh1;
import com.yandex.mobile.ads.impl.y82;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/monetization/ads/embedded/okhttp/src/main/kotlin/okhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "<init>", "()V", "a", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class PublicSuffixDatabase {
    private static final byte[] e = {42};
    private static final List<String> f = CollectionsKt.listOf("*");
    private static final PublicSuffixDatabase g = new PublicSuffixDatabase();
    public static final /* synthetic */ int h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f7209a = new AtomicBoolean(false);
    private final CountDownLatch b = new CountDownLatch(1);
    private byte[] c;
    private byte[] d;

    public static final class a {
        public /* synthetic */ a(int i) {
            this();
        }

        public static final String a(byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            boolean z;
            int i3;
            int i4;
            int i5 = PublicSuffixDatabase.h;
            int length = bArr.length;
            int i6 = 0;
            while (i6 < length) {
                int i7 = (i6 + length) / 2;
                while (i7 > -1 && bArr[i7] != 10) {
                    i7--;
                }
                int i8 = i7 + 1;
                int i9 = 1;
                while (true) {
                    i2 = i8 + i9;
                    if (bArr[i2] == 10) {
                        break;
                    }
                    i9++;
                }
                int i10 = i2 - i8;
                int i11 = i;
                boolean z2 = false;
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    if (z2) {
                        i3 = 46;
                        z = false;
                    } else {
                        byte b = bArr2[i11][i12];
                        byte[] bArr3 = y82.f10712a;
                        int i14 = b & 255;
                        z = z2;
                        i3 = i14;
                    }
                    byte b2 = bArr[i8 + i13];
                    byte[] bArr4 = y82.f10712a;
                    i4 = i3 - (b2 & 255);
                    if (i4 != 0) {
                        break;
                    }
                    i13++;
                    i12++;
                    if (i13 == i10) {
                        break;
                    }
                    if (bArr2[i11].length != i12) {
                        z2 = z;
                    } else {
                        if (i11 == bArr2.length - 1) {
                            break;
                        }
                        i11++;
                        i12 = -1;
                        z2 = true;
                    }
                }
                if (i4 >= 0) {
                    if (i4 <= 0) {
                        int i15 = i10 - i13;
                        int length2 = bArr2[i11].length - i12;
                        int length3 = bArr2.length;
                        for (int i16 = i11 + 1; i16 < length3; i16++) {
                            length2 += bArr2[i16].length;
                        }
                        if (length2 >= i15) {
                            if (length2 <= i15) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                                return new String(bArr, i8, i10, UTF_8);
                            }
                        }
                    }
                    i6 = i2 + 1;
                }
                length = i7;
            }
            return null;
        }

        private a() {
        }
    }

    private final void b() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource bufferedSourceBuffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
        try {
            byte[] byteArray = bufferedSourceBuffer.readByteArray(bufferedSourceBuffer.readInt());
            byte[] byteArray2 = bufferedSourceBuffer.readByteArray(bufferedSourceBuffer.readInt());
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedSourceBuffer, null);
            synchronized (this) {
                Intrinsics.checkNotNull(byteArray);
                this.c = byteArray;
                Intrinsics.checkNotNull(byteArray2);
                this.d = byteArray2;
            }
            this.b.countDown();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedSourceBuffer, th);
                throw th2;
            }
        }
    }

    public final String a(String domain) {
        int size;
        int size2;
        Intrinsics.checkNotNullParameter(domain, "domain");
        String unicode = IDN.toUnicode(domain);
        Intrinsics.checkNotNull(unicode);
        List<String> listSplit$default = StringsKt.split$default((CharSequence) unicode, new char[]{'.'}, false, 0, 6, (Object) null);
        if (Intrinsics.areEqual(CollectionsKt.last((List) listSplit$default), "")) {
            listSplit$default = CollectionsKt.dropLast(listSplit$default, 1);
        }
        List<String> listA = a(listSplit$default);
        if (listSplit$default.size() == listA.size() && listA.get(0).charAt(0) != '!') {
            return null;
        }
        if (listA.get(0).charAt(0) == '!') {
            size = listSplit$default.size();
            size2 = listA.size();
        } else {
            size = listSplit$default.size();
            size2 = listA.size() + 1;
        }
        int i = size - size2;
        List listSplit$default2 = StringsKt.split$default((CharSequence) domain, new char[]{'.'}, false, 0, 6, (Object) null);
        if (Intrinsics.areEqual(CollectionsKt.last(listSplit$default2), "")) {
            listSplit$default2 = CollectionsKt.dropLast(listSplit$default2, 1);
        }
        return SequencesKt.joinToString$default(SequencesKt.drop(CollectionsKt.asSequence(listSplit$default2), i), ".", null, null, 0, null, null, 62, null);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0030  */
    private final List<String> a(List<String> list) {
        String str;
        String strA;
        String str2;
        List<String> listEmptyList;
        List<String> listEmptyList2;
        if (this.f7209a.get() || !this.f7209a.compareAndSet(false, true)) {
            try {
                this.b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z = false;
            while (true) {
                try {
                    try {
                        b();
                        break;
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z = true;
                    } catch (IOException e2) {
                        int i = nh1.c;
                        nh1.f9731a.getClass();
                        nh1.a(5, "Failed to read public suffix list", e2);
                        if (z) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.c != null) {
            int size = list.size();
            byte[][] bArr = new byte[size][];
            for (int i2 = 0; i2 < size; i2++) {
                String str3 = list.get(i2);
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                byte[] bytes = str3.getBytes(UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                bArr[i2] = bytes;
            }
            int i3 = 0;
            while (true) {
                str = null;
                if (i3 >= size) {
                    strA = null;
                    break;
                }
                byte[] bArr2 = this.c;
                if (bArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                    bArr2 = null;
                }
                strA = a.a(bArr2, bArr, i3);
                if (strA != null) {
                    break;
                }
                i3++;
            }
            if (size <= 1) {
                str2 = null;
                break;
            }
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    str2 = null;
                    break;
                }
                bArr3[i4] = e;
                byte[] bArr4 = this.c;
                if (bArr4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                    bArr4 = null;
                }
                String strA2 = a.a(bArr4, bArr3, i4);
                if (strA2 != null) {
                    str2 = strA2;
                    break;
                }
                i4++;
            }
            if (str2 != null) {
                int i5 = size - 1;
                for (int i6 = 0; i6 < i5; i6++) {
                    byte[] bArr5 = this.d;
                    if (bArr5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
                        bArr5 = null;
                    }
                    String strA3 = a.a(bArr5, bArr, i6);
                    if (strA3 != null) {
                        str = strA3;
                        break;
                    }
                }
            }
            if (str != null) {
                return StringsKt.split$default((CharSequence) ("!" + str), new char[]{'.'}, false, 0, 6, (Object) null);
            }
            if (strA == null && str2 == null) {
                return f;
            }
            if (strA == null || (listEmptyList = StringsKt.split$default((CharSequence) strA, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (str2 == null || (listEmptyList2 = StringsKt.split$default((CharSequence) str2, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            return listEmptyList.size() > listEmptyList2.size() ? listEmptyList : listEmptyList2;
        }
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
    }
}
