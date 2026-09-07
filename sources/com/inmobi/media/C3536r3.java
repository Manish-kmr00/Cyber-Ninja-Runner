package com.inmobi.media;

import coil.disk.DiskLruCache;
import com.safedk.android.internal.partials.InMobiFilesBridge;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.r3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3536r3 implements Closeable {
    public static final Pattern p = Pattern.compile("[a-z0-9_-]{1,64}");
    public static final C3465m3 q = new C3465m3();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f3414a;
    public final File b;
    public final File c;
    public final File d;
    public final long f;
    public final id g;
    public BufferedWriter j;
    public int l;
    public long i = 0;
    public final LinkedHashMap k = new LinkedHashMap(0, 0.75f, true);
    public long m = 0;
    public final ThreadPoolExecutor n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final CallableC3451l3 o = new CallableC3451l3(this);
    public final int e = 1;
    public final int h = 2;

    public C3536r3(File file, long j, id idVar) {
        this.f3414a = file;
        this.b = new File(file, DiskLruCache.JOURNAL_FILE);
        this.c = new File(file, DiskLruCache.JOURNAL_FILE_TMP);
        this.d = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
        this.f = j;
        this.g = idVar;
    }

    public static void a(C3536r3 c3536r3, C3495o3 c3495o3, boolean z) {
        synchronized (c3536r3) {
            C3509p3 c3509p3 = c3495o3.f3385a;
            if (c3509p3.d != c3495o3) {
                throw new IllegalStateException("CurrentEditor of Entry didn't match with CurrentEditor instance.");
            }
            if (z && !c3509p3.c) {
                for (int i = 0; i < c3536r3.h; i++) {
                    if (!c3495o3.b[i]) {
                        a(c3495o3.d, c3495o3, false);
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!c3509p3.b(i).exists()) {
                        a(c3495o3.d, c3495o3, false);
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < c3536r3.h; i2++) {
                File fileB = c3509p3.b(i2);
                if (z) {
                    if (fileB.exists()) {
                        File fileA = c3509p3.a(i2);
                        fileB.renameTo(fileA);
                        long j = c3509p3.b[i2];
                        long length = fileA.length();
                        c3509p3.b[i2] = length;
                        c3536r3.i = (c3536r3.i - j) + length;
                    }
                } else if (fileB.exists() && !fileB.delete()) {
                    throw new IOException();
                }
            }
            c3536r3.l++;
            c3509p3.d = null;
            if (c3509p3.c || z) {
                c3509p3.c = true;
                BufferedWriter bufferedWriter = c3536r3.j;
                StringBuilder sbAppend = new StringBuilder("CLEAN ").append(c3509p3.f3397a);
                StringBuilder sb = new StringBuilder();
                for (long j2 : c3509p3.b) {
                    sb.append(' ').append(j2);
                }
                bufferedWriter.write(sbAppend.append(sb.toString()).append('\n').toString());
                if (z) {
                    c3536r3.m++;
                }
            } else {
                c3536r3.k.remove(c3509p3.f3397a);
                c3536r3.j.write("REMOVE " + c3509p3.f3397a + '\n');
            }
            c3536r3.j.flush();
            if (c3536r3.i > c3536r3.f || c3536r3.a()) {
                c3536r3.n.submit(c3536r3.o);
            }
        }
    }

    public final void b() throws IOException {
        File file = this.c;
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
        Iterator it = this.k.values().iterator();
        while (it.hasNext()) {
            C3509p3 c3509p3 = (C3509p3) it.next();
            int i = 0;
            if (c3509p3.d == null) {
                while (i < this.h) {
                    this.i += c3509p3.b[i];
                    i++;
                }
            } else {
                c3509p3.d = null;
                while (i < this.h) {
                    File fileA = c3509p3.a(i);
                    if (fileA.exists() && !fileA.delete()) {
                        throw new IOException();
                    }
                    File fileB = c3509p3.b(i);
                    if (fileB.exists() && !fileB.delete()) {
                        throw new IOException();
                    }
                    i++;
                }
                it.remove();
            }
        }
    }

    public final void c() {
        Db db = new Db(new FileInputStream(this.b), Dc.f3051a);
        try {
            String strA = db.a();
            String strA2 = db.a();
            String strA3 = db.a();
            String strA4 = db.a();
            String strA5 = db.a();
            if (!DiskLruCache.MAGIC.equals(strA) || !"1".equals(strA2) || !Integer.toString(this.e).equals(strA3) || !Integer.toString(this.h).equals(strA4) || !"".equals(strA5)) {
                throw new IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + com.ironsource.b9.i.e);
            }
            int i = 0;
            while (true) {
                try {
                    c(db.a());
                    i++;
                } catch (EOFException unused) {
                    this.l = i - this.k.size();
                    Dc.a(db);
                    return;
                }
            }
        } catch (Throwable th) {
            Dc.a(db);
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.j == null) {
            return;
        }
        Iterator it = new ArrayList(this.k.values()).iterator();
        while (it.hasNext()) {
            C3495o3 c3495o3 = ((C3509p3) it.next()).d;
            if (c3495o3 != null) {
                a(c3495o3.d, c3495o3, false);
            }
        }
        while (this.i > this.f) {
            d((String) ((Map.Entry) this.k.entrySet().iterator().next()).getKey());
        }
        this.j.close();
        this.j = null;
    }

    public final synchronized void d() {
        BufferedWriter bufferedWriter = this.j;
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(InMobiFilesBridge.fileOutputStreamCtor(this.c), Dc.f3051a));
        try {
            bufferedWriter2.write(DiskLruCache.MAGIC);
            bufferedWriter2.write("\n");
            bufferedWriter2.write("1");
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.e));
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.h));
            bufferedWriter2.write("\n");
            bufferedWriter2.write("\n");
            for (C3509p3 c3509p3 : this.k.values()) {
                if (c3509p3.d != null) {
                    bufferedWriter2.write("DIRTY " + c3509p3.f3397a + '\n');
                } else {
                    StringBuilder sbAppend = new StringBuilder().append("CLEAN ").append(c3509p3.f3397a);
                    StringBuilder sb = new StringBuilder();
                    for (long j : c3509p3.b) {
                        sb.append(' ').append(j);
                    }
                    bufferedWriter2.write(sbAppend.append(sb.toString()).append('\n').toString());
                }
            }
            bufferedWriter2.close();
            if (this.b.exists()) {
                File file = this.b;
                File file2 = this.d;
                if (file2.exists() && !file2.delete()) {
                    throw new IOException();
                }
                if (!file.renameTo(file2)) {
                    throw new IOException();
                }
            }
            if (!this.c.renameTo(this.b)) {
                throw new IOException();
            }
            this.d.delete();
            this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), Dc.f3051a));
        } catch (Throwable th) {
            bufferedWriter2.close();
            throw th;
        }
    }

    public final synchronized C3523q3 b(String key) {
        InputStream inputStream;
        if (this.j != null) {
            if (p.matcher(key).matches()) {
                C3509p3 c3509p3 = (C3509p3) this.k.get(key);
                if (c3509p3 == null) {
                    return null;
                }
                if (!c3509p3.c) {
                    return null;
                }
                InputStream[] inputStreamArr = new InputStream[this.h];
                for (int i = 0; i < this.h; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(c3509p3.a(i));
                    } catch (FileNotFoundException unused) {
                        if (this.g != null) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("urlKey", key));
                            Ob ob = Ob.f3160a;
                            Ob.b("ResourceDiskCacheFileMissing", mapMutableMapOf, Sb.SDK);
                        }
                        for (int i2 = 0; i2 < this.h && (inputStream = inputStreamArr[i2]) != null; i2++) {
                            Dc.a(inputStream);
                        }
                        return null;
                    }
                }
                this.l++;
                this.j.append((CharSequence) ("READ " + key + '\n'));
                if (a()) {
                    this.n.submit(this.o);
                }
                return new C3523q3(inputStreamArr);
            }
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + key + "\"");
        }
        throw new IllegalStateException("cache is closed");
    }

    public final void c(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf != -1) {
            int i = iIndexOf + 1;
            int iIndexOf2 = str.indexOf(32, i);
            if (iIndexOf2 == -1) {
                strSubstring = str.substring(i);
                if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                    this.k.remove(strSubstring);
                    return;
                }
            } else {
                strSubstring = str.substring(i, iIndexOf2);
            }
            C3509p3 c3509p3 = (C3509p3) this.k.get(strSubstring);
            if (c3509p3 == null) {
                c3509p3 = new C3509p3(this, strSubstring);
                this.k.put(strSubstring, c3509p3);
            }
            if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
                String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
                c3509p3.c = true;
                c3509p3.d = null;
                if (strArrSplit.length == c3509p3.e.h) {
                    for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                        try {
                            c3509p3.b[i2] = Long.parseLong(strArrSplit[i2]);
                        } catch (NumberFormatException unused) {
                            throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
                        }
                    }
                    return;
                }
                throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
            }
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                c3509p3.d = new C3495o3(this, c3509p3);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        throw new IOException("unexpected journal line: ".concat(str));
    }

    public final synchronized void d(String str) {
        if (this.j != null) {
            if (p.matcher(str).matches()) {
                C3509p3 c3509p3 = (C3509p3) this.k.get(str);
                if (c3509p3 != null && c3509p3.d == null) {
                    for (int i = 0; i < this.h; i++) {
                        File file = c3509p3.a(i);
                        if (this.g != null) {
                            Intrinsics.checkNotNullParameter(file, "file");
                            if (str != null && i == 0) {
                                String str2 = "";
                                try {
                                    String strA = Dc.a(new InputStreamReader(new FileInputStream(file), Dc.b));
                                    Intrinsics.checkNotNullExpressionValue(strA, "readFully(...)");
                                    str2 = strA;
                                } catch (Exception unused) {
                                }
                                Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("urlKey", str), TuplesKt.to("url", str2));
                                Ob ob = Ob.f3160a;
                                Ob.b("ResourceDiskCacheFileEvicted", mapMutableMapOf, Sb.SDK);
                            }
                        }
                        if (file.exists() && !file.delete()) {
                            throw new IOException("failed to delete " + file);
                        }
                        long j = this.i;
                        long[] jArr = c3509p3.b;
                        this.i = j - jArr[i];
                        jArr[i] = 0;
                    }
                    this.l++;
                    this.j.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.k.remove(str);
                    if (a()) {
                        this.n.submit(this.o);
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
        }
        throw new IllegalStateException("cache is closed");
    }

    public final C3495o3 a(String str) {
        synchronized (this) {
            if (this.j != null) {
                if (p.matcher(str).matches()) {
                    C3509p3 c3509p3 = (C3509p3) this.k.get(str);
                    if (c3509p3 == null) {
                        c3509p3 = new C3509p3(this, str);
                        this.k.put(str, c3509p3);
                    } else if (c3509p3.d != null) {
                        return null;
                    }
                    C3495o3 c3495o3 = new C3495o3(this, c3509p3);
                    c3509p3.d = c3495o3;
                    this.j.write("DIRTY " + str + '\n');
                    this.j.flush();
                    return c3495o3;
                }
                throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
            }
            throw new IllegalStateException("cache is closed");
        }
    }

    public final boolean a() {
        int i = this.l;
        return i >= 2000 && i >= this.k.size();
    }
}
