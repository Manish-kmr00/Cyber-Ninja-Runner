package com.bytedance.sdk.component.ML.KZx.pA.pA;

import android.util.Log;
import coil.disk.DiskLruCache;
import com.json.b9;
import com.safedk.android.internal.partials.PangleFilesBridge;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public final class pA implements Closeable {
    private long Bzk;
    private final File JG;
    private final File ML;
    final ExecutorService Og;
    private final File SD;
    private final int SGo;
    private int Sn;
    private Writer WV;
    private final File ZZv;
    private final int omh;
    static final Pattern pA = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream KZx = new OutputStream() { // from class: com.bytedance.sdk.component.ML.KZx.pA.pA.pA.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    private long BSW = 0;
    private final LinkedHashMap<String, Og> Wx = new LinkedHashMap<>(0, 0.75f, true);
    private long DX = -1;
    private long oX = 0;
    private final Callable<Void> aBv = new Callable<Void>() { // from class: com.bytedance.sdk.component.ML.KZx.pA.pA.pA.1
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (pA.this) {
                if (pA.this.WV == null) {
                    return null;
                }
                pA.this.omh();
                if (pA.this.JG()) {
                    pA.this.ML();
                    pA.this.Sn = 0;
                }
                return null;
            }
        }
    };

    private pA(File file, int i, int i2, long j, ExecutorService executorService) {
        this.ZZv = file;
        this.omh = i;
        this.ML = new File(file, DiskLruCache.JOURNAL_FILE);
        this.JG = new File(file, DiskLruCache.JOURNAL_FILE_TMP);
        this.SD = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
        this.SGo = i2;
        this.Bzk = j;
        this.Og = executorService;
    }

    public static pA pA(File file, int i, int i2, long j, ExecutorService executorService) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
        if (file2.exists()) {
            File file3 = new File(file, DiskLruCache.JOURNAL_FILE);
            if (file3.exists()) {
                file2.delete();
            } else {
                pA(file2, file3, false);
            }
        }
        pA pAVar = new pA(file, i, i2, j, executorService);
        if (pAVar.ML.exists()) {
            try {
                pAVar.KZx();
                pAVar.ZZv();
                return pAVar;
            } catch (IOException e) {
                Log.w("DiskLruCache ", file + " is corrupt: " + e.getMessage() + ", removing");
                pAVar.Og();
            }
        }
        file.mkdirs();
        pA pAVar2 = new pA(file, i, i2, j, executorService);
        pAVar2.ML();
        return pAVar2;
    }

    private void KZx() throws IOException {
        com.bytedance.sdk.component.ML.KZx.pA.pA.KZx kZx = new com.bytedance.sdk.component.ML.KZx.pA.pA.KZx(new FileInputStream(this.ML), ZZv.pA);
        try {
            String strPA = kZx.pA();
            String strPA2 = kZx.pA();
            String strPA3 = kZx.pA();
            String strPA4 = kZx.pA();
            String strPA5 = kZx.pA();
            if (!DiskLruCache.MAGIC.equals(strPA) || !"1".equals(strPA2) || !Integer.toString(this.omh).equals(strPA3) || !Integer.toString(this.SGo).equals(strPA4) || !"".equals(strPA5)) {
                throw new IOException("unexpected journal header: [" + strPA + ", " + strPA2 + ", " + strPA4 + ", " + strPA5 + b9.i.e);
            }
            int i = 0;
            while (true) {
                try {
                    ZZv(kZx.pA());
                    i++;
                } catch (EOFException unused) {
                    this.Sn = i - this.Wx.size();
                    if (kZx.Og()) {
                        ML();
                    } else {
                        this.WV = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.ML, true), ZZv.pA));
                    }
                    com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(kZx);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(kZx);
            throw th;
        }
    }

    private void ZZv(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.Wx.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        Og og = this.Wx.get(strSubstring);
        if (og == null) {
            og = new Og(strSubstring);
            this.Wx.put(strSubstring, og);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            og.ZZv = true;
            og.ML = null;
            og.pA(strArrSplit);
            return;
        }
        if (iIndexOf2 != -1 || iIndexOf != 5 || !str.startsWith("DIRTY")) {
            if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
            }
            return;
        }
        og.ML = new C0190pA(og);
    }

    private void ZZv() throws IOException {
        pA(this.JG);
        Iterator<Og> it = this.Wx.values().iterator();
        while (it.hasNext()) {
            Og next = it.next();
            int i = 0;
            if (next.ML == null) {
                while (i < this.SGo) {
                    this.BSW += next.KZx[i];
                    i++;
                }
            } else {
                next.ML = null;
                while (i < this.SGo) {
                    pA(next.pA(i));
                    pA(next.Og(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ML() throws IOException {
        try {
            Writer writer = this.WV;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(PangleFilesBridge.fileOutputStreamCtor(this.JG), ZZv.pA));
            try {
                bufferedWriter.write(DiskLruCache.MAGIC);
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.omh));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.SGo));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (Og og : this.Wx.values()) {
                    if (og.ML != null) {
                        bufferedWriter.write("DIRTY " + og.Og + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + og.Og + og.pA() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.ML.exists()) {
                    pA(this.ML, this.SD, true);
                }
                pA(this.JG, this.ML, false);
                this.SD.delete();
                this.WV = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.ML, true), ZZv.pA));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static void pA(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void pA(File file, File file2, boolean z) throws IOException {
        if (z) {
            pA(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized KZx pA(String str) throws IOException {
        InputStream inputStream;
        SD();
        ML(str);
        Og og = this.Wx.get(str);
        if (og == null) {
            return null;
        }
        if (!og.ZZv) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.SGo];
        for (int i = 0; i < this.SGo; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(og.pA(i));
            } catch (FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.SGo && (inputStream = inputStreamArr[i2]) != null; i2++) {
                    com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStream);
                }
                return null;
            }
        }
        this.Sn++;
        this.WV.append((CharSequence) ("READ " + str + '\n'));
        if (JG()) {
            this.Og.submit(this.aBv);
        }
        return new KZx(str, og.JG, inputStreamArr, og.KZx);
    }

    public C0190pA Og(String str) throws IOException {
        return pA(str, -1L);
    }

    private synchronized C0190pA pA(String str, long j) throws IOException {
        SD();
        ML(str);
        Og og = this.Wx.get(str);
        if (j != -1 && (og == null || og.JG != j)) {
            return null;
        }
        if (og == null) {
            og = new Og(str);
            this.Wx.put(str, og);
        } else if (og.ML != null) {
            return null;
        }
        C0190pA c0190pA = new C0190pA(og);
        og.ML = c0190pA;
        this.WV.write("DIRTY " + str + '\n');
        this.WV.flush();
        return c0190pA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pA(C0190pA c0190pA, boolean z) throws IOException {
        Og og = c0190pA.Og;
        if (og.ML != c0190pA) {
            throw new IllegalStateException();
        }
        if (z && !og.ZZv) {
            for (int i = 0; i < this.SGo; i++) {
                if (!c0190pA.KZx[i]) {
                    c0190pA.Og();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                }
                if (!og.Og(i).exists()) {
                    c0190pA.Og();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.SGo; i2++) {
            File fileOg = og.Og(i2);
            if (z) {
                if (fileOg.exists()) {
                    File filePA = og.pA(i2);
                    fileOg.renameTo(filePA);
                    long j = og.KZx[i2];
                    long length = filePA.length();
                    og.KZx[i2] = length;
                    this.BSW = (this.BSW - j) + length;
                }
            } else {
                pA(fileOg);
            }
        }
        this.Sn++;
        og.ML = null;
        if (og.ZZv | z) {
            og.ZZv = true;
            this.WV.write("CLEAN " + og.Og + og.pA() + '\n');
            if (z) {
                long j2 = this.oX;
                this.oX = 1 + j2;
                og.JG = j2;
            }
        } else {
            this.Wx.remove(og.Og);
            this.WV.write("REMOVE " + og.Og + '\n');
        }
        this.WV.flush();
        if (this.BSW > this.Bzk || JG()) {
            this.Og.submit(this.aBv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JG() {
        int i = this.Sn;
        return i >= 2000 && i >= this.Wx.size();
    }

    public synchronized boolean KZx(String str) throws IOException {
        SD();
        ML(str);
        Og og = this.Wx.get(str);
        if (og != null && og.ML == null) {
            for (int i = 0; i < this.SGo; i++) {
                File filePA = og.pA(i);
                if (filePA.exists() && !filePA.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(filePA)));
                }
                this.BSW -= og.KZx[i];
                og.KZx[i] = 0;
            }
            this.Sn++;
            this.WV.append((CharSequence) ("REMOVE " + str + '\n'));
            this.Wx.remove(str);
            if (JG()) {
                this.Og.submit(this.aBv);
            }
            return true;
        }
        return false;
    }

    private void SD() {
        if (this.WV == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void pA() throws IOException {
        SD();
        omh();
        this.WV.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.WV == null) {
            return;
        }
        for (Og og : new ArrayList(this.Wx.values())) {
            if (og.ML != null) {
                og.ML.Og();
            }
        }
        omh();
        this.WV.close();
        this.WV = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void omh() throws IOException {
        long j = this.Bzk;
        long j2 = this.DX;
        if (j2 >= 0) {
            j = j2;
        }
        while (this.BSW > j) {
            KZx(this.Wx.entrySet().iterator().next().getKey());
        }
        this.DX = -1L;
    }

    public void Og() throws IOException {
        close();
        ZZv.pA(this.ZZv);
    }

    private void ML(String str) {
        if (!pA.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public final class KZx implements Closeable {
        private final long KZx;
        private final long[] ML;
        private final String Og;
        private final InputStream[] ZZv;

        private KZx(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.Og = str;
            this.KZx = j;
            this.ZZv = inputStreamArr;
            this.ML = jArr;
        }

        public InputStream pA(int i) {
            return this.ZZv[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.ZZv) {
                com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStream);
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.ML.KZx.pA.pA.pA$pA, reason: collision with other inner class name */
    public final class C0190pA {
        private final boolean[] KZx;
        private boolean ML;
        private final Og Og;
        private boolean ZZv;

        private C0190pA(Og og) {
            this.Og = og;
            this.KZx = og.ZZv ? null : new boolean[pA.this.SGo];
        }

        public OutputStream pA(int i) throws IOException {
            FileOutputStream fileOutputStreamFileOutputStreamCtor;
            C0191pA c0191pA;
            if (i < 0 || i >= pA.this.SGo) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + pA.this.SGo);
            }
            synchronized (pA.this) {
                if (this.Og.ML != this) {
                    throw new IllegalStateException();
                }
                if (!this.Og.ZZv) {
                    this.KZx[i] = true;
                }
                File fileOg = this.Og.Og(i);
                try {
                    fileOutputStreamFileOutputStreamCtor = PangleFilesBridge.fileOutputStreamCtor(fileOg);
                } catch (FileNotFoundException unused) {
                    pA.this.ZZv.mkdirs();
                    try {
                        fileOutputStreamFileOutputStreamCtor = PangleFilesBridge.fileOutputStreamCtor(fileOg);
                    } catch (FileNotFoundException unused2) {
                        return pA.KZx;
                    }
                }
                c0191pA = new C0191pA(fileOutputStreamFileOutputStreamCtor);
            }
            return c0191pA;
        }

        public void pA() throws IOException {
            if (this.ZZv) {
                pA.this.pA(this, false);
                pA.this.KZx(this.Og.Og);
            } else {
                pA.this.pA(this, true);
            }
            this.ML = true;
        }

        public void Og() throws IOException {
            pA.this.pA(this, false);
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.component.ML.KZx.pA.pA.pA$pA$pA, reason: collision with other inner class name */
        private class C0191pA extends FilterOutputStream {
            private C0191pA(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    C0190pA.this.ZZv = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0190pA.this.ZZv = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    C0190pA.this.ZZv = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    C0190pA.this.ZZv = true;
                }
            }
        }
    }

    private final class Og {
        private long JG;
        private final long[] KZx;
        private C0190pA ML;
        private final String Og;
        private boolean ZZv;

        private Og(String str) {
            this.Og = str;
            this.KZx = new long[pA.this.SGo];
        }

        public String pA() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.KZx) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pA(String[] strArr) throws IOException {
            if (strArr.length != pA.this.SGo) {
                throw Og(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.KZx[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw Og(strArr);
                }
            }
        }

        private IOException Og(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File pA(int i) {
            return new File(pA.this.ZZv, this.Og + "." + i);
        }

        public File Og(int i) {
            return new File(pA.this.ZZv, this.Og + "." + i + ".tmp");
        }
    }
}
