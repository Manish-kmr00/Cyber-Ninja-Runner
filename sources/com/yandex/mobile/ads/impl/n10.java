package com.yandex.mobile.ads.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class n10 implements sm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f9686a = new LinkedHashMap(16, 0.75f, true);
    private long b = 0;
    private final d c;
    private final int d;

    final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f9687a;

        a(File file) {
            this.f9687a = file;
        }
    }

    static class c extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9689a;
        private long b;

        c(BufferedInputStream bufferedInputStream, long j) {
            super(bufferedInputStream);
            this.f9689a = j;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read() throws IOException {
            int i = super.read();
            if (i != -1) {
                this.b++;
            }
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = super.read(bArr, i, i2);
            if (i3 != -1) {
                this.b += (long) i3;
            }
            return i3;
        }
    }

    public interface d {
    }

    public n10(File file, int i) {
        this.c = new a(file);
        this.d = i;
    }

    @Override // com.yandex.mobile.ads.impl.sm
    public final synchronized sm.a get(String str) {
        b bVar = (b) this.f9686a.get(str);
        if (bVar == null) {
            return null;
        }
        File file = ((a) this.c).f9687a;
        int length = str.length() / 2;
        File file2 = new File(file, String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode()));
        try {
            c cVar = new c(new BufferedInputStream(new FileInputStream(file2)), file2.length());
            try {
                b bVarA = b.a(cVar);
                if (!TextUtils.equals(str, bVarA.b)) {
                    Object[] objArr = {file2.getAbsolutePath(), str, bVarA.b};
                    boolean z = li2.f9524a;
                    op0.a(objArr);
                    b bVar2 = (b) this.f9686a.remove(str);
                    if (bVar2 != null) {
                        this.b -= bVar2.f9688a;
                    }
                    cVar.close();
                    return null;
                }
                sm.a aVarA = bVar.a(a(cVar, cVar.f9689a - cVar.b));
                cVar.close();
                return aVarA;
            } catch (Throwable th) {
                cVar.close();
                throw th;
            }
        } catch (IOException e) {
            Object[] objArr2 = {file2.getAbsolutePath(), e.toString()};
            boolean z2 = li2.f9524a;
            op0.a(objArr2);
            b(str);
            return null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.sm
    public final synchronized void a() {
        File file = ((a) this.c).f9687a;
        if (!file.exists()) {
            if (!file.mkdirs()) {
                Object[] objArr = {file.getAbsolutePath()};
                boolean z = li2.f9524a;
                op0.b(objArr);
            }
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            try {
                long length = file2.length();
                c cVar = new c(new BufferedInputStream(new FileInputStream(file2)), length);
                try {
                    b bVarA = b.a(cVar);
                    bVarA.f9688a = length;
                    String str = bVarA.b;
                    if (this.f9686a.containsKey(str)) {
                        this.b = (bVarA.f9688a - ((b) this.f9686a.get(str)).f9688a) + this.b;
                    } else {
                        this.b += bVarA.f9688a;
                    }
                    this.f9686a.put(str, bVarA);
                    cVar.close();
                } catch (Throwable th) {
                    cVar.close();
                    throw th;
                }
            } catch (IOException unused) {
                file2.delete();
            } catch (Throwable unused2) {
                Intrinsics.checkNotNullParameter(file2, "<this>");
                try {
                    file2.delete();
                } catch (Throwable unused3) {
                }
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.sm
    public final synchronized void a(String str) {
        sm.a aVar = get(str);
        if (aVar != null) {
            aVar.f = 0L;
            aVar.e = 0L;
            a(str, aVar);
        }
    }

    private void b() {
        if (this.b < this.d) {
            return;
        }
        if (li2.f9524a) {
            op0.e(new Object[0]);
        }
        long j = this.b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator it = this.f9686a.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            b bVar = (b) ((Map.Entry) it.next()).getValue();
            String str = bVar.b;
            File file = ((a) this.c).f9687a;
            int length = str.length() / 2;
            if (new File(file, String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode())).delete()) {
                this.b -= bVar.f9688a;
            } else {
                String str2 = bVar.b;
                int length2 = str2.length() / 2;
                op0.a(str2, String.valueOf(str2.substring(0, length2).hashCode()) + String.valueOf(str2.substring(length2).hashCode()));
            }
            it.remove();
            i++;
            if (this.b < this.d * 0.9f) {
                break;
            }
        }
        if (li2.f9524a) {
            op0.e(Integer.valueOf(i), Long.valueOf(this.b - j), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    static long b(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            long j = ((long) i) & 255;
            int i2 = inputStream.read();
            if (i2 != -1) {
                long j2 = j | ((((long) i2) & 255) << 8);
                int i3 = inputStream.read();
                if (i3 != -1) {
                    long j3 = j2 | ((((long) i3) & 255) << 16);
                    int i4 = inputStream.read();
                    if (i4 != -1) {
                        long j4 = j3 | ((((long) i4) & 255) << 24);
                        int i5 = inputStream.read();
                        if (i5 != -1) {
                            long j5 = j4 | ((((long) i5) & 255) << 32);
                            int i6 = inputStream.read();
                            if (i6 != -1) {
                                long j6 = j5 | ((((long) i6) & 255) << 40);
                                int i7 = inputStream.read();
                                if (i7 != -1) {
                                    long j7 = j6 | ((((long) i7) & 255) << 48);
                                    int i8 = inputStream.read();
                                    if (i8 != -1) {
                                        return ((((long) i8) & 255) << 56) | j7;
                                    }
                                    throw new EOFException();
                                }
                                throw new EOFException();
                            }
                            throw new EOFException();
                        }
                        throw new EOFException();
                    }
                    throw new EOFException();
                }
                throw new EOFException();
            }
            throw new EOFException();
        }
        throw new EOFException();
    }

    public final synchronized void b(String str) {
        File file = ((a) this.c).f9687a;
        int length = str.length() / 2;
        boolean zDelete = new File(file, String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode())).delete();
        b bVar = (b) this.f9686a.remove(str);
        if (bVar != null) {
            this.b -= bVar.f9688a;
        }
        if (!zDelete) {
            int length2 = str.length() / 2;
            Object[] objArr = {str, String.valueOf(str.substring(0, length2).hashCode()) + String.valueOf(str.substring(length2).hashCode())};
            boolean z = li2.f9524a;
            op0.a(objArr);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f9688a;
        final String b;
        final String c;
        final long d;
        final long e;
        final long f;
        final long g;
        final List<hf0> h;

        private b(String str, String str2, long j, long j2, long j3, long j4, List<hf0> list) {
            this.b = str;
            this.c = "".equals(str2) ? null : str2;
            this.d = j;
            this.e = j2;
            this.f = j3;
            this.g = j4;
            this.h = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static List<hf0> a(sm.a aVar) {
            List<hf0> list = aVar.h;
            if (list != null) {
                return list;
            }
            Map<String, String> map = aVar.g;
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new hf0(entry.getKey(), entry.getValue()));
            }
            return arrayList;
        }

        static b a(c cVar) throws IOException {
            if (n10.a(cVar) == 538247942) {
                String str = new String(n10.a(cVar, n10.b(cVar)), "UTF-8");
                String str2 = new String(n10.a(cVar, n10.b(cVar)), "UTF-8");
                long jB = n10.b(cVar);
                long jB2 = n10.b(cVar);
                long jB3 = n10.b(cVar);
                long jB4 = n10.b(cVar);
                int iA = n10.a(cVar);
                if (iA >= 0) {
                    List listEmptyList = iA == 0 ? Collections.emptyList() : new ArrayList();
                    int i = 0;
                    while (i < iA) {
                        listEmptyList.add(new hf0(new String(n10.a(cVar, n10.b(cVar)), "UTF-8").intern(), new String(n10.a(cVar, n10.b(cVar)), "UTF-8").intern()));
                        i++;
                        jB4 = jB4;
                        jB3 = jB3;
                    }
                    return new b(str, str2, jB, jB2, jB3, jB4, listEmptyList);
                }
                throw new IOException(oe.a("readHeaderList size=", iA));
            }
            throw new IOException();
        }

        final sm.a a(byte[] bArr) {
            sm.a aVar = new sm.a();
            aVar.f10218a = bArr;
            aVar.b = this.c;
            aVar.c = this.d;
            aVar.d = this.e;
            aVar.e = this.f;
            aVar.f = this.g;
            List<hf0> list = this.h;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (hf0 hf0Var : list) {
                treeMap.put(hf0Var.a(), hf0Var.b());
            }
            aVar.g = treeMap;
            aVar.h = Collections.unmodifiableList(this.h);
            return aVar;
        }

        final boolean a(BufferedOutputStream bufferedOutputStream) {
            try {
                n10.a(bufferedOutputStream, 538247942);
                byte[] bytes = this.b.getBytes("UTF-8");
                n10.a(bufferedOutputStream, bytes.length);
                bufferedOutputStream.write(bytes, 0, bytes.length);
                String str = this.c;
                if (str == null) {
                    str = "";
                }
                byte[] bytes2 = str.getBytes("UTF-8");
                n10.a(bufferedOutputStream, bytes2.length);
                bufferedOutputStream.write(bytes2, 0, bytes2.length);
                n10.a(bufferedOutputStream, this.d);
                n10.a(bufferedOutputStream, this.e);
                n10.a(bufferedOutputStream, this.f);
                n10.a(bufferedOutputStream, this.g);
                List<hf0> list = this.h;
                if (list != null) {
                    n10.a(bufferedOutputStream, list.size());
                    for (hf0 hf0Var : list) {
                        byte[] bytes3 = hf0Var.a().getBytes("UTF-8");
                        n10.a(bufferedOutputStream, bytes3.length);
                        bufferedOutputStream.write(bytes3, 0, bytes3.length);
                        byte[] bytes4 = hf0Var.b().getBytes("UTF-8");
                        n10.a(bufferedOutputStream, bytes4.length);
                        bufferedOutputStream.write(bytes4, 0, bytes4.length);
                    }
                } else {
                    n10.a(bufferedOutputStream, 0);
                }
                bufferedOutputStream.flush();
                return true;
            } catch (IOException e) {
                Object[] objArr = {e.toString()};
                boolean z = li2.f9524a;
                op0.a(objArr);
                return false;
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.sm
    public final synchronized void a(String str, sm.a aVar) {
        File file;
        long j = this.b;
        byte[] bArr = aVar.f10218a;
        long length = j + ((long) bArr.length);
        int i = this.d;
        if (length > i && bArr.length > i * 0.9f) {
            return;
        }
        File file2 = ((a) this.c).f9687a;
        int length2 = str.length() / 2;
        File file3 = new File(file2, String.valueOf(str.substring(0, length2).hashCode()) + String.valueOf(str.substring(length2).hashCode()));
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
            file = file3;
            try {
                b bVar = new b(str, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, b.a(aVar));
                if (bVar.a(bufferedOutputStream)) {
                    bufferedOutputStream.write(aVar.f10218a);
                    bufferedOutputStream.close();
                    bVar.f9688a = file.length();
                    if (!this.f9686a.containsKey(str)) {
                        this.b += bVar.f9688a;
                    } else {
                        this.b = (bVar.f9688a - ((b) this.f9686a.get(str)).f9688a) + this.b;
                    }
                    this.f9686a.put(str, bVar);
                    b();
                    return;
                }
                bufferedOutputStream.close();
                Object[] objArr = {file.getAbsolutePath()};
                boolean z = li2.f9524a;
                op0.a(objArr);
                throw new IOException();
            } catch (IOException unused) {
                if (!file.delete()) {
                    Object[] objArr2 = {file.getAbsolutePath()};
                    boolean z2 = li2.f9524a;
                    op0.a(objArr2);
                }
                if (!((a) this.c).f9687a.exists()) {
                    boolean z3 = li2.f9524a;
                    op0.a(new Object[0]);
                    this.f9686a.clear();
                    this.b = 0L;
                    a();
                }
            }
        } catch (IOException unused2) {
            file = file3;
        }
    }

    static int a(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            int i2 = inputStream.read();
            if (i2 != -1) {
                int i3 = i | (i2 << 8);
                int i4 = inputStream.read();
                if (i4 != -1) {
                    int i5 = i3 | (i4 << 16);
                    int i6 = inputStream.read();
                    if (i6 != -1) {
                        return (i6 << 24) | i5;
                    }
                    throw new EOFException();
                }
                throw new EOFException();
            }
            throw new EOFException();
        }
        throw new EOFException();
    }

    static byte[] a(c cVar, long j) throws IOException {
        long j2 = cVar.f9689a - cVar.b;
        if (j >= 0 && j <= j2) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(cVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + j2);
    }

    static void a(BufferedOutputStream bufferedOutputStream, int i) throws IOException {
        bufferedOutputStream.write(i & 255);
        bufferedOutputStream.write((i >> 8) & 255);
        bufferedOutputStream.write((i >> 16) & 255);
        bufferedOutputStream.write((i >> 24) & 255);
    }

    static void a(BufferedOutputStream bufferedOutputStream, long j) throws IOException {
        bufferedOutputStream.write((byte) j);
        bufferedOutputStream.write((byte) (j >>> 8));
        bufferedOutputStream.write((byte) (j >>> 16));
        bufferedOutputStream.write((byte) (j >>> 24));
        bufferedOutputStream.write((byte) (j >>> 32));
        bufferedOutputStream.write((byte) (j >>> 40));
        bufferedOutputStream.write((byte) (j >>> 48));
        bufferedOutputStream.write((byte) (j >>> 56));
    }
}
