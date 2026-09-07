package com.mbridge.msdk.foundation.tools;

import com.google.common.primitives.SignedBytes;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.UShort;

/* JADX INFO: loaded from: classes11.dex */
public class FastKV {
    static final int ASYNC_BLOCKING = 1;
    private static final String A_SUFFIX = ".kva";
    private static final int BASE_GC_BYTES_THRESHOLD = 4096;
    private static final int BASE_GC_KEYS_THRESHOLD = 80;
    private static final String BOTH_FILES_ERROR = "both files error";
    private static final String B_SUFFIX = ".kvb";
    private static final String C_SUFFIX = ".kvc";
    private static final int DATA_SIZE_LIMIT = 536870912;
    private static final int DATA_START = 12;
    private static final int DOUBLE_LIMIT;
    private static final byte[] EMPTY_ARRAY = new byte[0];
    static final String GC_FINISH = "gc finish";
    private static final int INTERNAL_LIMIT = 2048;
    private static final String MAP_FAILED = "map failed";
    static final int NON_BLOCKING = 0;
    private static final String OPEN_FILE_FAILED = "open file failed";
    private static final int PAGE_SIZE;
    private static final String PARSE_DATA_FAILED = "parse dara failed";
    static final int SYNC_BLOCKING = 2;
    private static final String TEMP_SUFFIX = ".tmp";
    static final String TRUNCATE_FINISH = "truncate finish";
    private static final int TRUNCATE_THRESHOLD;
    private static final int[] TYPE_SIZE;
    private MappedByteBuffer aBuffer;
    private FileChannel aChannel;
    private MappedByteBuffer bBuffer;
    private FileChannel bChannel;
    private long checksum;
    private int dataEnd;
    private final Map<String, b> encoderMap;
    private z fastBuffer;
    private int invalidBytes;
    private final String name;
    private final String path;
    private int removeStart;
    private boolean sizeChanged;
    private String tempExternalName;
    private int updateSize;
    private int updateStart;
    private int writingMode;
    private final Map<String, h> data = new HashMap();
    private final Executor executor = new c0();
    private final ArrayList<d> invalids = new ArrayList<>();
    private final c logger = a0.b;
    private boolean autoCommit = true;

    public static class Builder {
        private static final Map<String, FastKV> INSTANCE_MAP = new ConcurrentHashMap();
        private b[] encoders;
        private final String name;
        private final String path;
        private int writingMode = 0;

        public Builder(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("path is empty");
            }
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            this.path = str.endsWith(RemoteSettings.FORWARD_SLASH_STRING) ? str : str + '/';
            this.name = str2;
        }

        public Builder asyncBlocking() {
            this.writingMode = 1;
            return this;
        }

        public Builder blocking() {
            this.writingMode = 2;
            return this;
        }

        public FastKV build() {
            String str = this.path + this.name;
            Map<String, FastKV> map = INSTANCE_MAP;
            FastKV fastKV = map.get(str);
            if (fastKV == null) {
                synchronized (Builder.class) {
                    fastKV = map.get(str);
                    if (fastKV == null) {
                        fastKV = new FastKV(this.path, this.name, this.encoders, this.writingMode);
                        map.put(str, fastKV);
                    }
                }
            }
            return fastKV;
        }

        public Builder encoder(b[] bVarArr) {
            this.encoders = bVarArr;
            return this;
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FastKV.this.writeToCFile();
        }
    }

    public interface b<T> {
        T a(byte[] bArr, int i, int i2);

        String a();

        byte[] a(T t);
    }

    public interface c {
        void a(String str, Exception exc);

        void a(String str, String str2);

        void b(String str, Exception exc);
    }

    private static class d implements Comparable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5034a;
        int b;

        d(int i, int i2) {
            this.b = i;
            this.f5034a = i2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return this.b - dVar.b;
        }
    }

    static {
        int iA = a1.a();
        PAGE_SIZE = iA;
        int iMax = Math.max(iA << 1, 16384);
        DOUBLE_LIMIT = iMax;
        TRUNCATE_THRESHOLD = iMax << 1;
        TYPE_SIZE = new int[]{0, 1, 4, 4, 8, 8};
    }

    FastKV(String str, String str2, b[] bVarArr, int i) {
        this.path = str;
        this.name = str2;
        this.writingMode = i;
        HashMap map = new HashMap();
        x0 x0Var = x0.f5079a;
        map.put(x0Var.a(), x0Var);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String strA = bVar.a();
                if (map.containsKey(strA)) {
                    error("duplicate encoder tag:" + strA);
                } else {
                    map.put(strA, bVar);
                }
            }
        }
        this.encoderMap = map;
        loadData();
    }

    private void addObject(String str, Object obj, byte[] bArr, byte b2) {
        Object obj2;
        int length;
        h gVar;
        int iSaveArray = saveArray(str, bArr, b2);
        if (iSaveArray != 0) {
            String str2 = this.tempExternalName;
            boolean z = str2 != null;
            if (z) {
                this.tempExternalName = null;
                length = 32;
                obj2 = str2;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            if (b2 == 6) {
                gVar = new o(this.updateStart, iSaveArray, (String) obj2, length, z);
            } else {
                gVar = b2 == 7 ? new g(this.updateStart, iSaveArray, obj2, length, z) : new n(this.updateStart, iSaveArray, obj2, length, z);
            }
            this.data.put(str, gVar);
            updateChange();
        }
    }

    private void addOrUpdate(String str, Object obj, byte[] bArr, p pVar, byte b2) {
        if (pVar == null) {
            addObject(str, obj, bArr, b2);
        } else if (pVar.b || pVar.e != bArr.length) {
            updateObject(str, obj, bArr, pVar);
        } else {
            updateBytes(pVar.f5059a, bArr);
            pVar.d = obj;
        }
        checkIfCommit();
    }

    private int bytesThreshold() {
        int i = this.dataEnd;
        if (i <= 16384) {
            return 4096;
        }
        return i <= 65536 ? 8192 : 16384;
    }

    private void checkGC() {
        if (this.invalidBytes < (bytesThreshold() << 1)) {
            if (this.invalids.size() < (this.dataEnd < 16384 ? 80 : 160)) {
                return;
            }
        }
        gc(0);
    }

    private void checkIfCommit() {
        if (this.writingMode == 0 || !this.autoCommit) {
            return;
        }
        commitToCFile();
    }

    private void checkKey(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void checkKeySize(int i) {
        if (i > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void checkValueSize(int i, boolean z) {
        if (z) {
            if (i != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i < 0 || i >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void clearData() {
        this.dataEnd = 12;
        this.checksum = 0L;
        clearInvalid();
        this.data.clear();
        z zVar = this.fastBuffer;
        if (zVar == null || zVar.f5080a.length != PAGE_SIZE) {
            this.fastBuffer = new z(PAGE_SIZE);
        } else {
            zVar.b(0, 0);
            this.fastBuffer.a(4, 0L);
        }
    }

    private void clearInvalid() {
        this.invalidBytes = 0;
        this.invalids.clear();
    }

    private boolean commitToCFile() {
        int i = this.writingMode;
        if (i == 1) {
            this.executor.execute(new a());
        } else if (i == 2) {
            return writeToCFile();
        }
        return true;
    }

    private void copyBuffer(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.bBuffer ? this.bChannel : this.aChannel).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.bBuffer) {
                    this.bBuffer = map;
                } else {
                    this.aBuffer = map;
                }
                mappedByteBuffer2 = map;
            } catch (IOException e) {
                error(e);
                toBlockingMode();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private void countInvalid(int i, int i2) {
        this.invalidBytes += i2 - i;
        this.invalids.add(new d(i, i2));
    }

    private void deleteCFiles() {
        try {
            a1.a(new File(this.path, this.name + C_SUFFIX));
            a1.a(new File(this.path, this.name + TEMP_SUFFIX));
        } catch (Exception e) {
            error(e);
        }
    }

    private void ensureSize(int i) {
        int length = this.fastBuffer.f5080a.length;
        int i2 = this.dataEnd + i;
        if (i2 >= length) {
            int i3 = this.invalidBytes;
            if (i3 > i && i3 > bytesThreshold()) {
                gc(i);
                return;
            }
            int newCapacity = getNewCapacity(length, i2);
            byte[] bArr = new byte[newCapacity];
            System.arraycopy(this.fastBuffer.f5080a, 0, bArr, 0, this.dataEnd);
            this.fastBuffer.f5080a = bArr;
            if (this.writingMode == 0) {
                try {
                    long j = newCapacity;
                    MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.aBuffer = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.bBuffer = map2;
                    map2.order(byteOrder);
                } catch (IOException e) {
                    error(new Exception(MAP_FAILED, e));
                    this.fastBuffer.b(0, this.dataEnd - 12);
                    this.fastBuffer.a(4, this.checksum);
                    toBlockingMode();
                }
            }
        }
    }

    private void error(Exception exc) {
        c cVar = this.logger;
        if (cVar != null) {
            cVar.b(this.name, exc);
        }
    }

    private void fastPutString(String str, String str2, o oVar) {
        int iB = z.b(str2);
        if (oVar == null) {
            int iB2 = z.b(str);
            checkKeySize(iB2);
            int i = iB2 + 4;
            this.updateSize = i + iB;
            preparePutBytes();
            this.fastBuffer.a((byte) 6);
            putKey(str, iB2);
            putStringValue(str2, iB);
            Map<String, h> map = this.data;
            int i2 = this.updateStart;
            map.put(str, new o(i2, i2 + i, str2, iB, false));
            updateChange();
        } else {
            int i3 = oVar.f5059a;
            int i4 = i3 - oVar.c;
            int i5 = oVar.e;
            boolean z = false;
            String str3 = null;
            if (i5 == iB) {
                this.checksum ^= this.fastBuffer.a(i3, i5);
                if (iB == str2.length()) {
                    str2.getBytes(0, iB, this.fastBuffer.f5080a, oVar.f5059a);
                } else {
                    z zVar = this.fastBuffer;
                    zVar.b = oVar.f5059a;
                    zVar.c(str2);
                }
                this.updateStart = oVar.f5059a;
                this.updateSize = iB;
            } else {
                this.updateSize = i4 + iB;
                preparePutBytes();
                this.fastBuffer.a((byte) 6);
                int i6 = i4 - 3;
                z zVar2 = this.fastBuffer;
                byte[] bArr = zVar2.f5080a;
                System.arraycopy(bArr, oVar.c + 1, bArr, zVar2.b, i6);
                this.fastBuffer.b += i6;
                putStringValue(str2, iB);
                remove((byte) 6, oVar.c, oVar.f5059a + oVar.e);
                str3 = oVar.b ? (String) oVar.d : null;
                oVar.b = false;
                int i7 = this.updateStart;
                oVar.c = i7;
                oVar.f5059a = i7 + i4;
                oVar.e = iB;
                z = true;
            }
            oVar.d = str2;
            updateChange();
            if (z) {
                checkGC();
            }
            if (str3 != null) {
                a1.a(new File(this.path + this.name, str3));
            }
        }
        checkIfCommit();
    }

    private byte[] getArrayFromFile(g gVar) {
        try {
            byte[] bArrC = a1.c(new File(this.path + this.name, (String) gVar.d));
            return bArrC != null ? bArrC : EMPTY_ARRAY;
        } catch (Exception e) {
            error(e);
            return EMPTY_ARRAY;
        }
    }

    private int getNewCapacity(int i, int i2) {
        if (i2 > 536870912) {
            throw new IllegalStateException("data size out of limit");
        }
        int i3 = PAGE_SIZE;
        if (i2 <= i3) {
            return i3;
        }
        while (i < i2) {
            int i4 = DOUBLE_LIMIT;
            i = i <= i4 ? i << 1 : i + i4;
        }
        return i;
    }

    private Object getObjectFromFile(n nVar) {
        try {
            byte[] bArrC = a1.c(new File(this.path + this.name, (String) nVar.d));
            if (bArrC == null) {
                warning(new Exception("Read object data failed"));
                return null;
            }
            int i = bArrC[0] & 255;
            String str = new String(bArrC, 1, i, StandardCharsets.UTF_8);
            b bVar = this.encoderMap.get(str);
            if (bVar != null) {
                int i2 = i + 1;
                return bVar.a(bArrC, i2, bArrC.length - i2);
            }
            warning(new Exception("No encoder for tag:".concat(str)));
            return null;
        } catch (Exception e) {
            error(e);
            return null;
        }
    }

    private String getStringFromFile(o oVar) {
        try {
            byte[] bArrC = a1.c(new File(this.path + this.name, (String) oVar.d));
            if (bArrC != null && bArrC.length != 0) {
                return new String(bArrC, StandardCharsets.UTF_8);
            }
            return "";
        } catch (Exception e) {
            error(e);
        }
        return "";
    }

    private void info(String str) {
        c cVar = this.logger;
        if (cVar != null) {
            cVar.a(this.name, str);
        }
    }

    private boolean isABFileEqual() {
        z zVar = new z(this.dataEnd);
        this.bBuffer.rewind();
        this.bBuffer.get(zVar.f5080a, 0, this.dataEnd);
        byte[] bArr = this.fastBuffer.f5080a;
        byte[] bArr2 = zVar.f5080a;
        for (int i = 0; i < this.dataEnd; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private synchronized void loadData() {
        long jNanoTime = System.nanoTime();
        if (!loadFromCFile() && this.writingMode == 0) {
            loadFromABFile();
        }
        if (this.fastBuffer == null) {
            this.fastBuffer = new z(PAGE_SIZE);
        }
        if (this.logger != null) {
            info("loading finish, data len:" + this.dataEnd + ", get keys:" + this.data.size() + ", use time:" + ((System.nanoTime() - jNanoTime) / 1000000) + " ms");
        }
    }

    private void loadFromABFile() {
        File file = new File(this.path, this.name + A_SUFFIX);
        File file2 = new File(this.path, this.name + B_SUFFIX);
        try {
            if (a1.d(file) && a1.d(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long length = randomAccessFile.length();
                long length2 = randomAccessFile2.length();
                this.aChannel = randomAccessFile.getChannel();
                this.bChannel = randomAccessFile2.getChannel();
                try {
                    MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, length > 0 ? length : PAGE_SIZE);
                    this.aBuffer = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, length2 > 0 ? length2 : PAGE_SIZE);
                    this.bBuffer = map2;
                    map2.order(byteOrder);
                    this.fastBuffer = new z(this.aBuffer.capacity());
                    if (length == 0 && length2 == 0) {
                        this.dataEnd = 12;
                        return;
                    }
                    int i = this.aBuffer.getInt();
                    long j = this.aBuffer.getLong();
                    int i2 = this.bBuffer.getInt();
                    long j2 = this.bBuffer.getLong();
                    if (i >= 0 && i <= length - 12) {
                        this.dataEnd = i + 12;
                        this.aBuffer.rewind();
                        this.aBuffer.get(this.fastBuffer.f5080a, 0, this.dataEnd);
                        if (j == this.fastBuffer.a(12, i) && parseData() == 0) {
                            this.checksum = j;
                            if (length == length2 && isABFileEqual()) {
                                return;
                            }
                            warning(new Exception("B file error"));
                            copyBuffer(this.aBuffer, this.bBuffer, this.dataEnd);
                            return;
                        }
                    }
                    if (i2 >= 0 && i2 <= length2 - 12) {
                        this.data.clear();
                        clearInvalid();
                        this.dataEnd = i2 + 12;
                        if (this.fastBuffer.f5080a.length != this.bBuffer.capacity()) {
                            this.fastBuffer = new z(this.bBuffer.capacity());
                        }
                        this.bBuffer.rewind();
                        this.bBuffer.get(this.fastBuffer.f5080a, 0, this.dataEnd);
                        if (j2 == this.fastBuffer.a(12, i2) && parseData() == 0) {
                            warning(new Exception("A file error"));
                            copyBuffer(this.bBuffer, this.aBuffer, this.dataEnd);
                            this.checksum = j2;
                            return;
                        }
                    }
                    error(BOTH_FILES_ERROR);
                    resetData();
                    return;
                } catch (IOException e) {
                    error(e);
                    toBlockingMode();
                    tryBlockingIO(file, file2);
                    return;
                }
            }
            error(new Exception(OPEN_FILE_FAILED));
            toBlockingMode();
        } catch (Exception e2) {
            error(e2);
            clearData();
            toBlockingMode();
        }
    }

    private boolean loadFromCFile() {
        File file = new File(this.path, this.name + C_SUFFIX);
        File file2 = new File(this.path, this.name + TEMP_SUFFIX);
        boolean z = false;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file == null) {
                if (this.writingMode == 0) {
                    return false;
                }
                File file3 = new File(this.path, this.name + A_SUFFIX);
                File file4 = new File(this.path, this.name + B_SUFFIX);
                if (!file3.exists() || !file4.exists()) {
                    return false;
                }
                tryBlockingIO(file3, file4);
                return false;
            }
            if (!loadWithBlockingIO(file)) {
                clearData();
                deleteCFiles();
                return false;
            }
            if (this.writingMode != 0) {
                return false;
            }
            if (!writeToABFile(this.fastBuffer)) {
                this.writingMode = 1;
                return false;
            }
            info("recover from c file");
            try {
                deleteCFiles();
                return true;
            } catch (Exception e) {
                e = e;
                z = true;
                error(e);
                return z;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private boolean loadWithBlockingIO(File file) throws IOException {
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i = (int) length;
            int newCapacity = getNewCapacity(PAGE_SIZE, i);
            z zVar = this.fastBuffer;
            if (zVar == null || zVar.f5080a.length != newCapacity) {
                zVar = new z(new byte[newCapacity]);
                this.fastBuffer = zVar;
            } else {
                zVar.b = 0;
            }
            a1.a(file, zVar.f5080a, i);
            int iD = zVar.d();
            long jE = zVar.e();
            this.dataEnd = iD + 12;
            if (iD >= 0 && iD <= i - 12 && jE == zVar.a(12, iD) && parseData() == 0) {
                this.checksum = jE;
                return true;
            }
        }
        return false;
    }

    private void mergeInvalids() {
        int size = this.invalids.size() - 1;
        d dVar = this.invalids.get(size);
        while (size > 0) {
            int i = size - 1;
            d dVar2 = this.invalids.get(i);
            if (dVar.b == dVar2.f5034a) {
                dVar2.f5034a = dVar.f5034a;
                this.invalids.remove(size);
            }
            dVar = dVar2;
            size = i;
        }
    }

    private int parseData() {
        z zVar = this.fastBuffer;
        zVar.b = 12;
        while (true) {
            try {
                int i = zVar.b;
                int i2 = this.dataEnd;
                if (i >= i2) {
                    if (i == i2) {
                        return 0;
                    }
                    warning(new Exception(PARSE_DATA_FAILED));
                    return -1;
                }
                byte bA = zVar.a();
                byte b2 = (byte) (bA & 63);
                boolean z = true;
                if (b2 < 1 || b2 > 8) {
                    throw new Exception(PARSE_DATA_FAILED);
                }
                int iA = zVar.a() & 255;
                if (bA < 0) {
                    zVar.b += iA;
                    int iF = b2 <= 5 ? TYPE_SIZE[b2] : zVar.f() & UShort.MAX_VALUE;
                    z zVar2 = this.fastBuffer;
                    int i3 = zVar2.b + iF;
                    zVar2.b = i3;
                    countInvalid(i, i3);
                } else {
                    String strE = zVar.e(iA);
                    int i4 = zVar.b;
                    if (b2 > 5) {
                        int iF2 = 65535 & zVar.f();
                        if ((bA & SignedBytes.MAX_POWER_OF_TWO) == 0) {
                            z = false;
                        }
                        checkValueSize(iF2, z);
                        if (b2 == 6) {
                            this.data.put(strE, new o(i, i4 + 2, zVar.e(iF2), iF2, z));
                        } else if (b2 == 7) {
                            this.data.put(strE, new g(i, i4 + 2, z ? zVar.e(iF2) : zVar.b(iF2), iF2, z));
                        } else if (z) {
                            this.data.put(strE, new n(i, i4 + 2, zVar.e(iF2), iF2, true));
                        } else {
                            int iA2 = zVar.a() & 255;
                            String strE2 = zVar.e(iA2);
                            b bVar = this.encoderMap.get(strE2);
                            int i5 = iF2 - (iA2 + 1);
                            if (i5 < 0) {
                                throw new Exception(PARSE_DATA_FAILED);
                            }
                            if (bVar != null) {
                                try {
                                    Object objA = bVar.a(zVar.f5080a, zVar.b, i5);
                                    if (objA != null) {
                                        this.data.put(strE, new n(i, i4 + 2, objA, iF2, false));
                                    }
                                } catch (Exception e) {
                                    error(e);
                                }
                            } else {
                                error("object with tag: " + strE2 + " without encoder");
                            }
                            zVar.b += i5;
                        }
                    } else if (b2 == 1) {
                        this.data.put(strE, new i(i4, zVar.a() == 1));
                    } else if (b2 == 2) {
                        this.data.put(strE, new l(i4, zVar.d()));
                    } else if (b2 == 3) {
                        this.data.put(strE, new k(i4, zVar.c()));
                    } else if (b2 != 4) {
                        this.data.put(strE, new j(i4, zVar.b()));
                    } else {
                        this.data.put(strE, new m(i4, zVar.e()));
                    }
                }
            } catch (Exception e2) {
                warning(e2);
                return -1;
            }
        }
    }

    private void preparePutBytes() {
        ensureSize(this.updateSize);
        int i = this.dataEnd;
        this.updateStart = i;
        this.dataEnd = this.updateSize + i;
        this.fastBuffer.b = i;
        this.sizeChanged = true;
    }

    private void putKey(String str, int i) {
        this.fastBuffer.a((byte) i);
        if (i != str.length()) {
            this.fastBuffer.c(str);
            return;
        }
        z zVar = this.fastBuffer;
        str.getBytes(0, i, zVar.f5080a, zVar.b);
        this.fastBuffer.b += i;
    }

    private void putStringValue(String str, int i) {
        this.fastBuffer.a((short) i);
        if (i != str.length()) {
            this.fastBuffer.c(str);
        } else {
            z zVar = this.fastBuffer;
            str.getBytes(0, i, zVar.f5080a, zVar.b);
        }
    }

    private void resetBuffer(MappedByteBuffer mappedByteBuffer) throws IOException {
        int iCapacity = mappedByteBuffer.capacity();
        int i = PAGE_SIZE;
        if (iCapacity != i) {
            FileChannel fileChannel = mappedByteBuffer == this.aBuffer ? this.aChannel : this.bChannel;
            long j = i;
            fileChannel.truncate(j);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aBuffer) {
                this.aBuffer = map;
            } else {
                this.bBuffer = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void resetData() {
        if (this.writingMode == 0) {
            try {
                resetBuffer(this.aBuffer);
                resetBuffer(this.bBuffer);
            } catch (IOException unused) {
                toBlockingMode();
            }
        }
        clearData();
        a1.a(new File(this.path + this.name));
    }

    private int saveArray(String str, byte[] bArr, byte b2) {
        this.tempExternalName = null;
        if (bArr.length < 2048) {
            return wrapArray(str, bArr, b2);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String strB = a1.b();
        if (!a1.a(new File(this.path + this.name, strB), bArr)) {
            error("save large value failed");
            return 0;
        }
        this.tempExternalName = strB;
        byte[] bArr2 = new byte[32];
        strB.getBytes(0, 32, bArr2, 0);
        return wrapArray(str, bArr2, (byte) (b2 | SignedBytes.MAX_POWER_OF_TWO));
    }

    private long shiftCheckSum(long j, int i) {
        int i2 = (i & 7) << 3;
        return (j >>> (64 - i2)) | (j << i2);
    }

    private void syncABBuffer(MappedByteBuffer mappedByteBuffer) {
        if (this.sizeChanged && mappedByteBuffer != this.aBuffer) {
            mappedByteBuffer.putInt(0, this.dataEnd - 12);
        }
        mappedByteBuffer.putLong(4, this.checksum);
        int i = this.removeStart;
        if (i != 0) {
            mappedByteBuffer.put(i, this.fastBuffer.f5080a[i]);
        }
        if (this.updateSize != 0) {
            mappedByteBuffer.position(this.updateStart);
            mappedByteBuffer.put(this.fastBuffer.f5080a, this.updateStart, this.updateSize);
        }
    }

    private void toBlockingMode() {
        this.writingMode = 1;
        a1.a(this.aChannel);
        a1.a(this.bChannel);
        this.aChannel = null;
        this.bChannel = null;
        this.aBuffer = null;
        this.bBuffer = null;
    }

    private void truncate(int i) {
        int i2 = PAGE_SIZE;
        int newCapacity = getNewCapacity(i2, i + i2);
        byte[] bArr = this.fastBuffer.f5080a;
        if (newCapacity >= bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[newCapacity];
        System.arraycopy(bArr, 0, bArr2, 0, this.dataEnd);
        this.fastBuffer.f5080a = bArr2;
        if (this.writingMode == 0) {
            try {
                long j = newCapacity;
                this.aChannel.truncate(j);
                MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aBuffer = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.bChannel.truncate(j);
                MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.bBuffer = map2;
                map2.order(byteOrder);
            } catch (IOException e) {
                error(new Exception(MAP_FAILED, e));
                toBlockingMode();
            }
        }
        info(TRUNCATE_FINISH);
    }

    private void tryBlockingIO(File file, File file2) {
        try {
            if (loadWithBlockingIO(file)) {
                return;
            }
        } catch (IOException e) {
            warning(e);
        }
        clearData();
        try {
            if (loadWithBlockingIO(file2)) {
                return;
            }
        } catch (IOException e2) {
            warning(e2);
        }
        clearData();
    }

    private void updateBoolean(byte b2, int i) {
        long jShiftCheckSum = this.checksum ^ shiftCheckSum(1L, i);
        this.checksum = jShiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, jShiftCheckSum);
            this.aBuffer.put(i, b2);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.put(i, b2);
        } else {
            this.fastBuffer.a(4, jShiftCheckSum);
        }
        this.fastBuffer.f5080a[i] = b2;
    }

    private void updateBytes(int i, byte[] bArr) {
        int length = bArr.length;
        this.checksum ^= this.fastBuffer.a(i, length);
        z zVar = this.fastBuffer;
        zVar.b = i;
        zVar.a(bArr);
        long jA = this.checksum ^ this.fastBuffer.a(i, length);
        this.checksum = jA;
        if (this.writingMode != 0) {
            this.fastBuffer.a(4, jA);
            return;
        }
        this.aBuffer.putInt(0, -1);
        this.aBuffer.putLong(4, this.checksum);
        this.aBuffer.position(i);
        this.aBuffer.put(bArr);
        this.aBuffer.putInt(0, this.dataEnd - 12);
        this.bBuffer.putLong(4, this.checksum);
        this.bBuffer.position(i);
        this.bBuffer.put(bArr);
    }

    private void updateChange() {
        this.checksum ^= this.fastBuffer.a(this.updateStart, this.updateSize);
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            syncABBuffer(this.aBuffer);
            this.aBuffer.putInt(0, this.dataEnd - 12);
            syncABBuffer(this.bBuffer);
        } else {
            if (this.sizeChanged) {
                this.fastBuffer.b(0, this.dataEnd - 12);
            }
            this.fastBuffer.a(4, this.checksum);
        }
        this.sizeChanged = false;
        this.removeStart = 0;
        this.updateSize = 0;
    }

    private void updateInt32(int i, long j, int i2) {
        long jShiftCheckSum = shiftCheckSum(j, i2) ^ this.checksum;
        this.checksum = jShiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, jShiftCheckSum);
            this.aBuffer.putInt(i2, i);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putInt(i2, i);
        } else {
            this.fastBuffer.a(4, jShiftCheckSum);
        }
        this.fastBuffer.b(i2, i);
    }

    private void updateInt64(long j, long j2, int i) {
        long jShiftCheckSum = shiftCheckSum(j2, i) ^ this.checksum;
        this.checksum = jShiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, jShiftCheckSum);
            this.aBuffer.putLong(i, j);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putLong(i, j);
        } else {
            this.fastBuffer.a(4, jShiftCheckSum);
        }
        this.fastBuffer.a(i, j);
    }

    private void updateObject(String str, Object obj, byte[] bArr, p pVar) {
        int iSaveArray = saveArray(str, bArr, pVar.a());
        if (iSaveArray != 0) {
            String str2 = pVar.b ? (String) pVar.d : null;
            remove(pVar.a(), pVar.c, pVar.f5059a + pVar.e);
            String str3 = this.tempExternalName;
            boolean z = str3 != null;
            pVar.c = this.updateStart;
            pVar.f5059a = iSaveArray;
            pVar.b = z;
            if (z) {
                pVar.d = str3;
                pVar.e = 32;
                this.tempExternalName = null;
            } else {
                pVar.d = obj;
                pVar.e = bArr.length;
            }
            updateChange();
            checkGC();
            if (str2 != null) {
                a1.a(new File(this.path + this.name, str2));
            }
        }
    }

    private void updateOffset(int i, int[] iArr) {
        for (h hVar : this.data.values()) {
            int i2 = hVar.f5059a;
            if (i2 > i) {
                int i3 = iArr[(a1.a(iArr, i2) << 1) + 1];
                hVar.f5059a -= i3;
                if (hVar.a() >= 6) {
                    ((p) hVar).c -= i3;
                }
            }
        }
    }

    private void warning(Exception exc) {
        c cVar = this.logger;
        if (cVar != null) {
            cVar.a(this.name, exc);
        }
    }

    private int wrapArray(String str, byte[] bArr, byte b2) {
        wrapHeader(str, b2, bArr.length + 2);
        this.fastBuffer.a((short) bArr.length);
        z zVar = this.fastBuffer;
        int i = zVar.b;
        zVar.a(bArr);
        return i;
    }

    private void wrapHeader(String str, byte b2) {
        wrapHeader(str, b2, TYPE_SIZE[b2]);
    }

    private boolean writeToABFile(z zVar) {
        int length = zVar.f5080a.length;
        File file = new File(this.path, this.name + A_SUFFIX);
        File file2 = new File(this.path, this.name + B_SUFFIX);
        try {
            if (!a1.d(file) || !a1.d(file2)) {
                throw new Exception(OPEN_FILE_FAILED);
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j = length;
            randomAccessFile.setLength(j);
            randomAccessFile2.setLength(j);
            this.aChannel = randomAccessFile.getChannel();
            this.bChannel = randomAccessFile2.getChannel();
            MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.aBuffer = map;
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            map.order(byteOrder);
            MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.bBuffer = map2;
            map2.order(byteOrder);
            this.aBuffer.put(zVar.f5080a, 0, this.dataEnd);
            this.bBuffer.put(zVar.f5080a, 0, this.dataEnd);
            return true;
        } catch (Exception e) {
            error(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean writeToCFile() {
        try {
            File file = new File(this.path, this.name + TEMP_SUFFIX);
            if (a1.d(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(this.dataEnd);
                randomAccessFile.write(this.fastBuffer.f5080a, 0, this.dataEnd);
                randomAccessFile.close();
                File file2 = new File(this.path, this.name + C_SUFFIX);
                if (!file2.exists() || file2.delete()) {
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    warning(new Exception("rename failed"));
                }
            }
        } catch (Exception e) {
            error(e);
        }
        return false;
    }

    public synchronized void clear() {
        resetData();
        if (this.writingMode != 0) {
            deleteCFiles();
        }
    }

    public synchronized boolean commit() {
        this.autoCommit = true;
        return commitToCFile();
    }

    public synchronized boolean contains(String str) {
        return this.data.containsKey(str);
    }

    public synchronized void disableAutoCommit() {
        this.autoCommit = false;
    }

    public synchronized void force() {
        if (this.writingMode == 0) {
            this.aBuffer.force();
            this.bBuffer.force();
        }
    }

    void gc(int i) {
        Collections.sort(this.invalids);
        mergeInvalids();
        d dVar = this.invalids.get(0);
        int i2 = dVar.b;
        int i3 = this.dataEnd;
        int i4 = i3 - this.invalidBytes;
        int i5 = i4 - 12;
        int i6 = i4 - i2;
        int i7 = i3 - i2;
        boolean z = i5 < i7 + i6;
        if (!z) {
            this.checksum ^= this.fastBuffer.a(i2, i7);
        }
        int size = this.invalids.size();
        int i8 = size - 1;
        int i9 = this.dataEnd - this.invalids.get(i8).f5034a;
        int[] iArr = new int[(i9 > 0 ? size : i8) << 1];
        int i10 = dVar.b;
        int i11 = dVar.f5034a;
        for (int i12 = 1; i12 < size; i12++) {
            d dVar2 = this.invalids.get(i12);
            int i13 = dVar2.b - i11;
            byte[] bArr = this.fastBuffer.f5080a;
            System.arraycopy(bArr, i11, bArr, i10, i13);
            int i14 = (i12 - 1) << 1;
            iArr[i14] = i11;
            iArr[i14 + 1] = i11 - i10;
            i10 += i13;
            i11 = dVar2.f5034a;
        }
        if (i9 > 0) {
            byte[] bArr2 = this.fastBuffer.f5080a;
            System.arraycopy(bArr2, i11, bArr2, i10, i9);
            int i15 = i8 << 1;
            iArr[i15] = i11;
            iArr[i15 + 1] = i11 - i10;
        }
        clearInvalid();
        if (z) {
            this.checksum = this.fastBuffer.a(12, i5);
        } else {
            this.checksum ^= this.fastBuffer.a(i2, i6);
        }
        this.dataEnd = i4;
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            this.aBuffer.putLong(4, this.checksum);
            this.aBuffer.position(i2);
            this.aBuffer.put(this.fastBuffer.f5080a, i2, i6);
            this.aBuffer.putInt(0, i5);
            this.bBuffer.putInt(0, i5);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.position(i2);
            this.bBuffer.put(this.fastBuffer.f5080a, i2, i6);
        } else {
            this.fastBuffer.b(0, i5);
            this.fastBuffer.a(4, this.checksum);
        }
        updateOffset(i2, iArr);
        int i16 = i4 + i;
        if (this.fastBuffer.f5080a.length - i16 > TRUNCATE_THRESHOLD) {
            truncate(i16);
        }
        info(GC_FINISH);
    }

    public synchronized Map<String, Object> getAll() {
        Object objValueOf;
        int size = this.data.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap map = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, h> entry : this.data.entrySet()) {
            String key = entry.getKey();
            h value = entry.getValue();
            switch (value.a()) {
                case 1:
                    objValueOf = Boolean.valueOf(((i) value).b);
                    break;
                case 2:
                    objValueOf = Integer.valueOf(((l) value).b);
                    break;
                case 3:
                    objValueOf = Float.valueOf(((k) value).b);
                    break;
                case 4:
                    objValueOf = Long.valueOf(((m) value).b);
                    break;
                case 5:
                    objValueOf = Double.valueOf(((j) value).b);
                    break;
                case 6:
                    o oVar = (o) value;
                    objValueOf = oVar.b ? getStringFromFile(oVar) : oVar.d;
                    break;
                case 7:
                    g gVar = (g) value;
                    objValueOf = gVar.b ? getArrayFromFile(gVar) : gVar.d;
                    break;
                case 8:
                    n nVar = (n) value;
                    objValueOf = nVar.b ? getObjectFromFile(nVar) : nVar.d;
                    break;
                default:
                    objValueOf = null;
                    break;
            }
            map.put(key, objValueOf);
        }
        return map;
    }

    public byte[] getArray(String str) {
        return getArray(str, EMPTY_ARRAY);
    }

    public synchronized boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public synchronized long getLong(String str) {
        m mVar;
        mVar = (m) this.data.get(str);
        return mVar == null ? 0L : mVar.b;
    }

    public synchronized <T> T getObject(String str) {
        n nVar = (n) this.data.get(str);
        if (nVar != null) {
            return nVar.b ? (T) getObjectFromFile(nVar) : (T) nVar.d;
        }
        return null;
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public synchronized Set<String> getStringSet(String str) {
        return (Set) getObject(str);
    }

    public void putAll(Map<String, Object> map) {
        putAll(map, null);
    }

    public synchronized void putArray(String str, byte[] bArr) {
        checkKey(str);
        if (bArr == null) {
            remove(str);
        } else {
            addOrUpdate(str, bArr, bArr, (g) this.data.get(str), (byte) 7);
        }
    }

    public synchronized void putBoolean(String str, boolean z) {
        checkKey(str);
        i iVar = (i) this.data.get(str);
        if (iVar == null) {
            wrapHeader(str, (byte) 1);
            z zVar = this.fastBuffer;
            int i = zVar.b;
            zVar.a(z ? (byte) 1 : (byte) 0);
            updateChange();
            this.data.put(str, new i(i, z));
            checkIfCommit();
        } else if (iVar.b != z) {
            iVar.b = z;
            updateBoolean(z ? (byte) 1 : (byte) 0, iVar.f5059a);
            checkIfCommit();
        }
    }

    public synchronized void putDouble(String str, double d2) {
        checkKey(str);
        j jVar = (j) this.data.get(str);
        if (jVar == null) {
            wrapHeader(str, (byte) 5);
            z zVar = this.fastBuffer;
            int i = zVar.b;
            zVar.a(Double.doubleToRawLongBits(d2));
            updateChange();
            this.data.put(str, new j(i, d2));
            checkIfCommit();
        } else if (jVar.b != d2) {
            long jDoubleToRawLongBits = Double.doubleToRawLongBits(d2);
            long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(jVar.b) ^ jDoubleToRawLongBits;
            jVar.b = d2;
            updateInt64(jDoubleToRawLongBits, jDoubleToRawLongBits2, jVar.f5059a);
            checkIfCommit();
        }
    }

    public synchronized void putFloat(String str, float f) {
        checkKey(str);
        k kVar = (k) this.data.get(str);
        if (kVar == null) {
            wrapHeader(str, (byte) 3);
            z zVar = this.fastBuffer;
            int i = zVar.b;
            zVar.g(Float.floatToRawIntBits(f));
            updateChange();
            this.data.put(str, new k(i, f));
            checkIfCommit();
        } else if (kVar.b != f) {
            int iFloatToRawIntBits = Float.floatToRawIntBits(f);
            long jFloatToRawIntBits = ((long) (Float.floatToRawIntBits(kVar.b) ^ iFloatToRawIntBits)) & 4294967295L;
            kVar.b = f;
            updateInt32(iFloatToRawIntBits, jFloatToRawIntBits, kVar.f5059a);
            checkIfCommit();
        }
    }

    public synchronized void putInt(String str, int i) {
        checkKey(str);
        l lVar = (l) this.data.get(str);
        if (lVar == null) {
            wrapHeader(str, (byte) 2);
            z zVar = this.fastBuffer;
            int i2 = zVar.b;
            zVar.g(i);
            updateChange();
            this.data.put(str, new l(i2, i));
            checkIfCommit();
        } else {
            int i3 = lVar.b;
            if (i3 != i) {
                lVar.b = i;
                updateInt32(i, ((long) (i3 ^ i)) & 4294967295L, lVar.f5059a);
                checkIfCommit();
            }
        }
    }

    public synchronized void putLong(String str, long j) {
        checkKey(str);
        m mVar = (m) this.data.get(str);
        if (mVar == null) {
            wrapHeader(str, (byte) 4);
            z zVar = this.fastBuffer;
            int i = zVar.b;
            zVar.a(j);
            updateChange();
            this.data.put(str, new m(i, j));
            checkIfCommit();
        } else {
            long j2 = mVar.b;
            if (j2 != j) {
                mVar.b = j;
                updateInt64(j, j ^ j2, mVar.f5059a);
                checkIfCommit();
            }
        }
    }

    public synchronized <T> void putObject(String str, T t, b<T> bVar) {
        byte[] bArrA;
        checkKey(str);
        if (bVar == null) {
            throw new IllegalArgumentException("Encoder is null");
        }
        String strA = bVar.a();
        if (strA == null || strA.isEmpty() || strA.length() > 50) {
            throw new IllegalArgumentException("Invalid encoder tag:" + strA);
        }
        if (!this.encoderMap.containsKey(strA)) {
            throw new IllegalArgumentException("Encoder hasn't been registered");
        }
        if (t == null) {
            remove(str);
            return;
        }
        try {
            bArrA = bVar.a(t);
        } catch (Exception e) {
            error(e);
            bArrA = null;
        }
        if (bArrA == null) {
            remove(str);
            return;
        }
        int iB = z.b(strA);
        z zVar = new z(iB + 1 + bArrA.length);
        zVar.a((byte) iB);
        zVar.c(strA);
        zVar.a(bArrA);
        addOrUpdate(str, t, zVar.f5080a, (n) this.data.get(str), (byte) 8);
    }

    public synchronized void putString(String str, String str2) {
        checkKey(str);
        if (str2 == null) {
            remove(str);
        } else {
            o oVar = (o) this.data.get(str);
            if (str2.length() * 3 < 2048) {
                fastPutString(str, str2, oVar);
            } else {
                addOrUpdate(str, str2, str2.isEmpty() ? EMPTY_ARRAY : str2.getBytes(StandardCharsets.UTF_8), oVar, (byte) 6);
            }
        }
    }

    public synchronized void putStringSet(String str, Set<String> set) {
        try {
            if (set == null) {
                remove(str);
            } else {
                putObject(str, set, x0.f5079a);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void remove(String str) {
        h hVar = this.data.get(str);
        if (hVar != null) {
            this.data.remove(str);
            byte bA = hVar.a();
            String str2 = null;
            if (bA <= 5) {
                int iB = z.b(str);
                int i = hVar.f5059a;
                remove(bA, i - (iB + 2), i + TYPE_SIZE[bA]);
            } else {
                p pVar = (p) hVar;
                remove(bA, pVar.c, pVar.f5059a + pVar.e);
                if (pVar.b) {
                    str2 = (String) pVar.d;
                }
            }
            byte b2 = (byte) (bA | (-128));
            if (this.writingMode == 0) {
                this.aBuffer.putLong(4, this.checksum);
                this.aBuffer.put(this.removeStart, b2);
                this.bBuffer.putLong(4, this.checksum);
                this.bBuffer.put(this.removeStart, b2);
            } else {
                this.fastBuffer.a(4, this.checksum);
            }
            this.removeStart = 0;
            if (str2 != null) {
                a1.a(new File(this.path + this.name, str2));
            }
            checkGC();
            checkIfCommit();
        }
    }

    public synchronized String toString() {
        return "FastKV: path:" + this.path + " name:" + this.name;
    }

    private void wrapHeader(String str, byte b2, int i) {
        int iB = z.b(str);
        checkKeySize(iB);
        this.updateSize = iB + 2 + i;
        preparePutBytes();
        this.fastBuffer.a(b2);
        putKey(str, iB);
    }

    public synchronized byte[] getArray(String str, byte[] bArr) {
        g gVar = (g) this.data.get(str);
        if (gVar != null) {
            return gVar.b ? getArrayFromFile(gVar) : (byte[]) gVar.d;
        }
        return bArr;
    }

    public synchronized boolean getBoolean(String str, boolean z) {
        i iVar = (i) this.data.get(str);
        if (iVar != null) {
            z = iVar.b;
        }
        return z;
    }

    public synchronized double getDouble(String str, double d2) {
        j jVar = (j) this.data.get(str);
        if (jVar != null) {
            d2 = jVar.b;
        }
        return d2;
    }

    public synchronized float getFloat(String str, float f) {
        k kVar = (k) this.data.get(str);
        if (kVar != null) {
            f = kVar.b;
        }
        return f;
    }

    public synchronized int getInt(String str, int i) {
        l lVar = (l) this.data.get(str);
        if (lVar != null) {
            i = lVar.b;
        }
        return i;
    }

    public synchronized String getString(String str, String str2) {
        o oVar = (o) this.data.get(str);
        if (oVar != null) {
            return oVar.b ? getStringFromFile(oVar) : (String) oVar.d;
        }
        return str2;
    }

    public synchronized void putAll(Map<String, Object> map, Map<Class, b> map2) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && !key.isEmpty()) {
                if (value instanceof String) {
                    putString(key, (String) value);
                } else if (value instanceof Boolean) {
                    putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    putDouble(key, ((Double) value).doubleValue());
                } else if (value instanceof Set) {
                    Set<String> set = (Set) value;
                    if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                        putStringSet(key, set);
                    }
                } else if (value instanceof byte[]) {
                    putArray(key, (byte[]) value);
                } else if (map2 != null) {
                    b bVar = map2.get(value.getClass());
                    if (bVar != null) {
                        putObject(key, value, bVar);
                    } else {
                        warning(new Exception("missing encoder for type:" + value.getClass()));
                    }
                } else {
                    warning(new Exception("missing encoders"));
                }
            }
        }
    }

    private void error(String str) {
        c cVar = this.logger;
        if (cVar != null) {
            cVar.b(this.name, new Exception(str));
        }
    }

    public synchronized long getLong(String str, long j) {
        m mVar = (m) this.data.get(str);
        if (mVar != null) {
            j = mVar.b;
        }
        return j;
    }

    private void remove(byte b2, int i, int i2) {
        countInvalid(i, i2);
        byte b3 = (byte) (b2 | (-128));
        byte[] bArr = this.fastBuffer.f5080a;
        this.checksum = ((((long) (bArr[i] ^ b3)) & 255) << ((i & 7) << 3)) ^ this.checksum;
        bArr[i] = b3;
        this.removeStart = i;
    }
}
