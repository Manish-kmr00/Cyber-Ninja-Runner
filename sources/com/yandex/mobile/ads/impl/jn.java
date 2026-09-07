package com.yandex.mobile.ads.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
final class jn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<String, in> f9335a = new HashMap<>();
    private final SparseArray<String> b = new SparseArray<>();
    private final SparseBooleanArray c = new SparseBooleanArray();
    private final SparseBooleanArray d = new SparseBooleanArray();
    private c e;
    private c f;

    private static final class a implements c {
        private static final String[] e = {"id", "key", "metadata"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final wv f9336a;
        private final SparseArray<in> b = new SparseArray<>();
        private String c;
        private String d;

        @Override // com.yandex.mobile.ads.impl.jn.c
        public final void b() throws Throwable {
            wv wvVar = this.f9336a;
            String str = this.c;
            str.getClass();
            try {
                String strConcat = "ExoPlayerCacheIndex".concat(str);
                SQLiteDatabase writableDatabase = wvVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    int i = bb2.f8491a;
                    try {
                        if (x82.a(writableDatabase, "ExoPlayerVersions")) {
                            writableDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", new String[]{Integer.toString(1), str});
                        }
                        writableDatabase.execSQL("DROP TABLE IF EXISTS " + strConcat);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (SQLException e2) {
                        throw new vv(e2);
                    }
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (SQLException e3) {
                throw new vv(e3);
            }
        }

        public a(h60 h60Var) {
            this.f9336a = h60Var;
        }

        @Override // com.yandex.mobile.ads.impl.jn.c
        public final boolean a() throws Throwable {
            SQLiteDatabase readableDatabase = this.f9336a.getReadableDatabase();
            String str = this.c;
            str.getClass();
            return bb2.a(readableDatabase, 1, str) != -1;
        }

        @Override // com.yandex.mobile.ads.impl.jn.c
        public final void a(long j) {
            String hexString = Long.toHexString(j);
            this.c = hexString;
            this.d = "ExoPlayerCacheIndex" + hexString;
        }

        @Override // com.yandex.mobile.ads.impl.jn.c
        public final void b(HashMap<String, in> map) throws Throwable {
            try {
                SQLiteDatabase writableDatabase = this.f9336a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    String str = this.c;
                    str.getClass();
                    bb2.a(writableDatabase, 1, str, 1);
                    String str2 = this.d;
                    str2.getClass();
                    writableDatabase.execSQL("DROP TABLE IF EXISTS ".concat(str2));
                    writableDatabase.execSQL("CREATE TABLE " + this.d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
                    for (in inVar : map.values()) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        kz kzVarA = inVar.a();
                        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                        Set<Map.Entry<String, byte[]>> setA = kzVarA.a();
                        dataOutputStream.writeInt(setA.size());
                        for (Map.Entry<String, byte[]> entry : setA) {
                            dataOutputStream.writeUTF(entry.getKey());
                            byte[] value = entry.getValue();
                            dataOutputStream.writeInt(value.length);
                            dataOutputStream.write(value);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("id", Integer.valueOf(inVar.f9245a));
                        contentValues.put("key", inVar.b);
                        contentValues.put("metadata", byteArray);
                        String str3 = this.d;
                        str3.getClass();
                        writableDatabase.replaceOrThrow(str3, null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.b.clear();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                throw new vv(e2);
            }
        }

        @Override // com.yandex.mobile.ads.impl.jn.c
        public final void a(HashMap<String, in> map, SparseArray<String> sparseArray) throws Throwable {
            if (this.b.size() == 0) {
                try {
                    SQLiteDatabase readableDatabase = this.f9336a.getReadableDatabase();
                    String str = this.c;
                    str.getClass();
                    if (bb2.a(readableDatabase, 1, str) != 1) {
                        SQLiteDatabase writableDatabase = this.f9336a.getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            String str2 = this.c;
                            str2.getClass();
                            bb2.a(writableDatabase, 1, str2, 1);
                            String str3 = this.d;
                            str3.getClass();
                            writableDatabase.execSQL("DROP TABLE IF EXISTS ".concat(str3));
                            writableDatabase.execSQL("CREATE TABLE " + this.d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    }
                    SQLiteDatabase readableDatabase2 = this.f9336a.getReadableDatabase();
                    String str4 = this.d;
                    str4.getClass();
                    Cursor cursorQuery = readableDatabase2.query(str4, e, null, null, null, null, null);
                    while (cursorQuery.moveToNext()) {
                        try {
                            int i = cursorQuery.getInt(0);
                            String string = cursorQuery.getString(1);
                            string.getClass();
                            map.put(string, new in(i, string, jn.a(new DataInputStream(new ByteArrayInputStream(cursorQuery.getBlob(2))))));
                            sparseArray.put(i, string);
                        } catch (Throwable th2) {
                            if (cursorQuery != null) {
                                try {
                                    cursorQuery.close();
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                    cursorQuery.close();
                    return;
                } catch (SQLiteException e2) {
                    map.clear();
                    sparseArray.clear();
                    throw new vv(e2);
                }
            }
            throw new IllegalStateException();
        }

        @Override // com.yandex.mobile.ads.impl.jn.c
        public final void a(in inVar, boolean z) {
            if (z) {
                this.b.delete(inVar.f9245a);
            } else {
                this.b.put(inVar.f9245a, null);
            }
        }

        @Override // com.yandex.mobile.ads.impl.jn.c
        public final void a(in inVar) {
            this.b.put(inVar.f9245a, inVar);
        }

        @Override // com.yandex.mobile.ads.impl.jn.c
        public final void a(HashMap<String, in> map) throws Throwable {
            if (this.b.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f9336a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i = 0; i < this.b.size(); i++) {
                    try {
                        in inVarValueAt = this.b.valueAt(i);
                        if (inVarValueAt == null) {
                            int iKeyAt = this.b.keyAt(i);
                            String str = this.d;
                            str.getClass();
                            writableDatabase.delete(str, "id = ?", new String[]{Integer.toString(iKeyAt)});
                        } else {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            kz kzVarA = inVarValueAt.a();
                            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                            Set<Map.Entry<String, byte[]>> setA = kzVarA.a();
                            dataOutputStream.writeInt(setA.size());
                            for (Map.Entry<String, byte[]> entry : setA) {
                                dataOutputStream.writeUTF(entry.getKey());
                                byte[] value = entry.getValue();
                                dataOutputStream.writeInt(value.length);
                                dataOutputStream.write(value);
                            }
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("id", Integer.valueOf(inVarValueAt.f9245a));
                            contentValues.put("key", inVarValueAt.b);
                            contentValues.put("metadata", byteArray);
                            String str2 = this.d;
                            str2.getClass();
                            writableDatabase.replaceOrThrow(str2, null, contentValues);
                        }
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.b.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e2) {
                throw new vv(e2);
            }
        }
    }

    private static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f9337a = false;
        private final Cipher b = null;
        private final SecretKeySpec c = null;
        private final SecureRandom d = null;
        private final lh e;
        private boolean f;
        private hr1 g;

        @Override // com.yandex.mobile.ads.impl.jn.c
        public final void a(long j) {
        }

        public b(File file) {
            this.e = new lh(file);
        }

        @Override // com.yandex.mobile.ads.impl.jn.c
        public final boolean a() {
            return this.e.b();
        }

        private static int a(in inVar, int i) {
            int iHashCode = inVar.b.hashCode() + (inVar.f9245a * 31);
            if (i < 2) {
                long jB = inVar.a().b();
                return (iHashCode * 31) + ((int) (jB ^ (jB >>> 32)));
            }
            return (iHashCode * 31) + inVar.a().hashCode();
        }

        @Override // com.yandex.mobile.ads.impl.jn.c
        public final void b() {
            this.e.a();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.yandex.mobile.ads.impl.jn.c
        public final void b(HashMap<String, in> map) throws Throwable {
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream outputStreamD = this.e.d();
                hr1 hr1Var = this.g;
                if (hr1Var == null) {
                    this.g = new hr1(outputStreamD);
                } else {
                    hr1Var.a(outputStreamD);
                }
                hr1 hr1Var2 = this.g;
                DataOutputStream dataOutputStream2 = new DataOutputStream(hr1Var2);
                try {
                    dataOutputStream2.writeInt(2);
                    dataOutputStream2.writeInt(this.f9337a ? 1 : 0);
                    if (this.f9337a) {
                        byte[] bArr = new byte[16];
                        SecureRandom secureRandom = this.d;
                        int i = x82.f10629a;
                        secureRandom.nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            this.b.init(1, this.c, new IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream2 = new DataOutputStream(new CipherOutputStream(hr1Var2, this.b));
                        } catch (InvalidAlgorithmParameterException e) {
                            e = e;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e2) {
                            e = e2;
                            throw new IllegalStateException(e);
                        }
                    }
                    try {
                        dataOutputStream2.writeInt(map.size());
                        int iA = 0;
                        for (in inVar : map.values()) {
                            dataOutputStream2.writeInt(inVar.f9245a);
                            dataOutputStream2.writeUTF(inVar.b);
                            Set<Map.Entry<String, byte[]>> setA = inVar.a().a();
                            dataOutputStream2.writeInt(setA.size());
                            for (Map.Entry<String, byte[]> entry : setA) {
                                dataOutputStream2.writeUTF(entry.getKey());
                                byte[] value = entry.getValue();
                                dataOutputStream2.writeInt(value.length);
                                dataOutputStream2.write(value);
                            }
                            iA += a(inVar, 2);
                        }
                        dataOutputStream2.writeInt(iA);
                        this.e.a(dataOutputStream2);
                        int i2 = x82.f10629a;
                        this.f = false;
                    } catch (Throwable th) {
                        th = th;
                        dataOutputStream = dataOutputStream2;
                        dataOutputStream2 = dataOutputStream;
                        x82.a((Closeable) dataOutputStream2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    x82.a((Closeable) dataOutputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        @Override // com.yandex.mobile.ads.impl.jn.c
        public final void a(HashMap<String, in> map, SparseArray<String> sparseArray) throws Throwable {
            if (!this.f) {
                if (this.e.b()) {
                    DataInputStream dataInputStream = null;
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(this.e.c());
                        DataInputStream dataInputStream2 = new DataInputStream(bufferedInputStream);
                        try {
                            int i = dataInputStream2.readInt();
                            if (i >= 0 && i <= 2) {
                                if ((dataInputStream2.readInt() & 1) != 0) {
                                    if (this.b == null) {
                                        x82.a((Closeable) dataInputStream2);
                                    } else {
                                        byte[] bArr = new byte[16];
                                        dataInputStream2.readFully(bArr);
                                        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                                        try {
                                            Cipher cipher = this.b;
                                            SecretKeySpec secretKeySpec = this.c;
                                            int i2 = x82.f10629a;
                                            cipher.init(2, secretKeySpec, ivParameterSpec);
                                            dataInputStream2 = new DataInputStream(new CipherInputStream(bufferedInputStream, this.b));
                                        } catch (InvalidAlgorithmParameterException e) {
                                            e = e;
                                            throw new IllegalStateException(e);
                                        } catch (InvalidKeyException e2) {
                                            e = e2;
                                            throw new IllegalStateException(e);
                                        }
                                    }
                                } else if (this.f9337a) {
                                    this.f = true;
                                }
                                int i3 = dataInputStream2.readInt();
                                int iA = 0;
                                for (int i4 = 0; i4 < i3; i4++) {
                                    in inVarA = a(i, dataInputStream2);
                                    map.put(inVarA.b, inVarA);
                                    sparseArray.put(inVarA.f9245a, inVarA.b);
                                    iA += a(inVarA, i);
                                }
                                int i5 = dataInputStream2.readInt();
                                boolean z = dataInputStream2.read() == -1;
                                if (i5 == iA && z) {
                                    x82.a((Closeable) dataInputStream2);
                                    return;
                                }
                                x82.a((Closeable) dataInputStream2);
                            } else {
                                x82.a((Closeable) dataInputStream2);
                            }
                        } catch (IOException unused) {
                            dataInputStream = dataInputStream2;
                            if (dataInputStream != null) {
                                x82.a((Closeable) dataInputStream);
                            }
                        } catch (Throwable th) {
                            th = th;
                            dataInputStream = dataInputStream2;
                            if (dataInputStream != null) {
                                x82.a((Closeable) dataInputStream);
                            }
                            throw th;
                        }
                    } catch (IOException unused2) {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    map.clear();
                    sparseArray.clear();
                    this.e.a();
                    return;
                }
                return;
            }
            throw new IllegalStateException();
        }

        @Override // com.yandex.mobile.ads.impl.jn.c
        public final void a(in inVar, boolean z) {
            this.f = true;
        }

        @Override // com.yandex.mobile.ads.impl.jn.c
        public final void a(in inVar) {
            this.f = true;
        }

        private static in a(int i, DataInputStream dataInputStream) throws IOException {
            kz kzVarA;
            int i2 = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            if (i < 2) {
                long j = dataInputStream.readLong();
                bs bsVar = new bs();
                bs.a(bsVar, j);
                kzVarA = kz.c.a(bsVar);
            } else {
                kzVarA = jn.a(dataInputStream);
            }
            return new in(i2, utf, kzVarA);
        }

        @Override // com.yandex.mobile.ads.impl.jn.c
        public final void a(HashMap<String, in> map) throws Throwable {
            if (this.f) {
                b(map);
            }
        }
    }

    private interface c {
        void a(long j);

        void a(in inVar);

        void a(in inVar, boolean z);

        void a(HashMap<String, in> map) throws Throwable;

        void a(HashMap<String, in> map, SparseArray<String> sparseArray) throws Throwable;

        boolean a() throws Throwable;

        void b() throws Throwable;

        void b(HashMap<String, in> map) throws Throwable;
    }

    public jn(h60 h60Var, File file) {
        a aVar = new a(h60Var);
        b bVar = new b(new File(file, "monetization_cached_content_index.exi"));
        this.e = aVar;
        this.f = bVar;
    }

    public final kz b(String str) {
        in inVar = this.f9335a.get(str);
        return inVar != null ? inVar.a() : kz.c;
    }

    public final in c(String str) {
        in inVar = this.f9335a.get(str);
        if (inVar != null) {
            return inVar;
        }
        SparseArray<String> sparseArray = this.b;
        int size = sparseArray.size();
        int i = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            iKeyAt = i;
        }
        in inVar2 = new in(iKeyAt, str, kz.c);
        this.f9335a.put(str, inVar2);
        this.b.put(iKeyAt, str);
        this.d.put(iKeyAt, true);
        this.e.a(inVar2);
        return inVar2;
    }

    public final void d(String str) {
        in inVar = this.f9335a.get(str);
        if (inVar != null && inVar.c() && inVar.d()) {
            this.f9335a.remove(str);
            int i = inVar.f9245a;
            boolean z = this.d.get(i);
            this.e.a(inVar, z);
            if (z) {
                this.b.remove(i);
                this.d.delete(i);
            } else {
                this.b.put(i, null);
                this.c.put(i, true);
            }
        }
    }

    public final void b() {
        Iterator it = jk0.a(this.f9335a.keySet()).iterator();
        while (it.hasNext()) {
            d((String) it.next());
        }
    }

    public final void a(String str, bs bsVar) {
        in inVarC = c(str);
        if (inVarC.a(bsVar)) {
            this.e.a(inVarC);
        }
    }

    public final void c() throws Throwable {
        this.e.a(this.f9335a);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.b.remove(this.c.keyAt(i));
        }
        this.c.clear();
        this.d.clear();
    }

    public final in a(String str) {
        return this.f9335a.get(str);
    }

    public final Collection<in> a() {
        return Collections.unmodifiableCollection(this.f9335a.values());
    }

    public final String a(int i) {
        return this.b.get(i);
    }

    public final void a(long j) throws Throwable {
        c cVar;
        this.e.a(j);
        c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.a(j);
        }
        if (!this.e.a() && (cVar = this.f) != null && cVar.a()) {
            this.f.a(this.f9335a, this.b);
            this.e.b(this.f9335a);
        } else {
            this.e.a(this.f9335a, this.b);
        }
        c cVar3 = this.f;
        if (cVar3 != null) {
            cVar3.b();
            this.f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static kz a(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            String utf = dataInputStream.readUTF();
            int i3 = dataInputStream.readInt();
            if (i3 >= 0) {
                int iMin = Math.min(i3, 10485760);
                byte[] bArrCopyOf = x82.f;
                int i4 = 0;
                while (i4 != i3) {
                    int i5 = i4 + iMin;
                    bArrCopyOf = Arrays.copyOf(bArrCopyOf, i5);
                    dataInputStream.readFully(bArrCopyOf, i4, iMin);
                    iMin = Math.min(i3 - i5, 10485760);
                    i4 = i5;
                }
                map.put(utf, bArrCopyOf);
            } else {
                throw new IOException(oe.a("Invalid value size: ", i3));
            }
        }
        return new kz(map);
    }
}
