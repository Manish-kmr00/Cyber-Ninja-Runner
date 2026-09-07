package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedContentIndex;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes12.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f2158a;
    public final j b;
    public final i d;
    public a f;
    public final HashMap c = new HashMap();
    public final HashMap e = new HashMap();

    public l(File file, j jVar) {
        this.f2158a = file;
        this.b = jVar;
        this.d = new i(file);
        ConditionVariable conditionVariable = new ConditionVariable();
        new k(this, conditionVariable).start();
        conditionVariable.block();
    }

    public final synchronized m a(String str, long j) {
        m mVarA;
        m mVar;
        a aVar = this.f;
        if (aVar != null) {
            throw aVar;
        }
        h hVar = (h) this.d.f2155a.get(str);
        if (hVar == null) {
            mVar = new m(str, j, -1L, -9223372036854775807L, null);
        } else {
            while (true) {
                mVarA = hVar.a(j);
                if (!mVarA.d || mVarA.e.length() == mVarA.c) {
                    break;
                }
                a();
            }
            mVar = mVarA;
        }
        if (!mVar.d) {
            if (this.c.containsKey(str)) {
                return null;
            }
            this.c.put(str, mVar);
            return mVar;
        }
        h hVar2 = (h) this.d.f2155a.get(str);
        if (!hVar2.c.remove(mVar)) {
            throw new IllegalStateException();
        }
        int i = hVar2.f2154a;
        if (!mVar.d) {
            throw new IllegalStateException();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        File parentFile = mVar.e.getParentFile();
        long j2 = mVar.b;
        Pattern pattern = m.g;
        File file = new File(parentFile, i + "." + j2 + "." + jCurrentTimeMillis + ".v3.exo");
        m mVar2 = new m(mVar.f2153a, mVar.b, mVar.c, jCurrentTimeMillis, file);
        if (!mVar.e.renameTo(file)) {
            throw new a("Renaming of " + mVar.e + " to " + file + " failed.");
        }
        hVar2.c.add(mVar2);
        ArrayList arrayList = (ArrayList) this.e.get(mVar.f2153a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                j jVar = (j) arrayList.get(size);
                jVar.f2156a.remove(mVar);
                jVar.b -= mVar.c;
                jVar.f2156a.add(mVar2);
                jVar.b += mVar2.c;
                jVar.a(this, 0L);
            }
        }
        j jVar2 = this.b;
        jVar2.f2156a.remove(mVar);
        jVar2.b -= mVar.c;
        jVar2.f2156a.add(mVar2);
        jVar2.b += mVar2.c;
        jVar2.a(this, 0L);
        return mVar2;
    }

    public final synchronized void b(m mVar) {
        if (mVar != this.c.remove(mVar.f2153a)) {
            throw new IllegalStateException();
        }
        notifyAll();
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d6 A[PHI: r4
  0x00d6: PHI (r4v6 java.io.DataInputStream) = (r4v3 java.io.DataInputStream), (r4v12 java.io.DataInputStream) binds: [B:53:0x00d4, B:35:0x00af] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:59:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:64:0x010a  */
    /* JADX WARN: Code duplicated, block: B:66:0x0114  */
    /* JADX WARN: Code duplicated, block: B:67:0x011b  */
    /* JADX WARN: Code duplicated, block: B:69:0x011e  */
    /* JADX WARN: Code duplicated, block: B:70:0x0122  */
    /* JADX WARN: Code duplicated, block: B:87:0x0125 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:59:0x00f8, please report this as an issue */
    public static void a(l lVar) throws Throwable {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2;
        File[] fileArrListFiles;
        m mVarA;
        if (!lVar.f2158a.exists()) {
            lVar.f2158a.mkdirs();
            return;
        }
        i iVar = lVar.d;
        if (!iVar.f) {
            DataInputStream dataInputStream3 = null;
            try {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(iVar.c.a());
                    dataInputStream = new DataInputStream(bufferedInputStream);
                    try {
                        if (dataInputStream.readInt() == 1) {
                            try {
                                if ((dataInputStream.readInt() & 1) != 0) {
                                    if (iVar.d != null) {
                                        byte[] bArr = new byte[16];
                                        dataInputStream.readFully(bArr);
                                        try {
                                            iVar.d.init(2, iVar.e, new IvParameterSpec(bArr));
                                            dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, iVar.d));
                                        } catch (InvalidAlgorithmParameterException e) {
                                            e = e;
                                            throw new IllegalStateException(e);
                                        } catch (InvalidKeyException e2) {
                                            e = e2;
                                            throw new IllegalStateException(e);
                                        }
                                    }
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.c cVar = iVar.c;
                                    cVar.f2175a.delete();
                                    cVar.b.delete();
                                    iVar.f2155a.clear();
                                    iVar.b.clear();
                                    fileArrListFiles = lVar.f2158a.listFiles();
                                    if (fileArrListFiles == null) {
                                        return;
                                    }
                                    for (File file : fileArrListFiles) {
                                        if (!file.getName().equals(CachedContentIndex.FILE_NAME)) {
                                            if (file.length() > 0) {
                                                mVarA = m.a(file, lVar.d);
                                            } else {
                                                mVarA = null;
                                            }
                                            if (mVarA != null) {
                                                lVar.a(mVarA);
                                            } else {
                                                file.delete();
                                            }
                                        }
                                    }
                                    lVar.d.a();
                                    lVar.d.b();
                                    return;
                                }
                                if (iVar.d != null) {
                                    iVar.f = true;
                                }
                                int i = dataInputStream.readInt();
                                int i2 = 0;
                                for (int i3 = 0; i3 < i; i3++) {
                                    int i4 = dataInputStream.readInt();
                                    String utf = dataInputStream.readUTF();
                                    h hVar = new h(i4, utf, dataInputStream.readLong());
                                    iVar.f2155a.put(utf, hVar);
                                    iVar.b.put(i4, utf);
                                    int iHashCode = utf.hashCode();
                                    long j = hVar.d;
                                    i2 += ((iHashCode + (i4 * 31)) * 31) + ((int) (j ^ (j >>> 32)));
                                }
                                if (dataInputStream.readInt() != i2) {
                                    z.a(dataInputStream);
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.c cVar2 = iVar.c;
                                    cVar2.f2175a.delete();
                                    cVar2.b.delete();
                                    iVar.f2155a.clear();
                                    iVar.b.clear();
                                } else {
                                    z.a(dataInputStream);
                                }
                                fileArrListFiles = lVar.f2158a.listFiles();
                                if (fileArrListFiles == null) {
                                    return;
                                }
                                while (i < r3) {
                                    if (!file.getName().equals(CachedContentIndex.FILE_NAME)) {
                                        if (file.length() > 0) {
                                            mVarA = m.a(file, lVar.d);
                                        } else {
                                            mVarA = null;
                                        }
                                        if (mVarA != null) {
                                            lVar.a(mVarA);
                                        } else {
                                            file.delete();
                                        }
                                    }
                                }
                                lVar.d.a();
                                lVar.d.b();
                                return;
                            } catch (Throwable th) {
                                th = th;
                                dataInputStream3 = dataInputStream;
                                dataInputStream2 = dataInputStream3;
                                if (dataInputStream2 != null) {
                                    z.a(dataInputStream2);
                                }
                                throw th;
                            }
                        }
                        z.a(dataInputStream);
                    } catch (FileNotFoundException unused) {
                        if (dataInputStream != null) {
                            z.a(dataInputStream);
                        }
                    } catch (IOException e3) {
                        e = e3;
                        Log.e("CachedContentIndex", "Error reading cache content index file.", e);
                        if (dataInputStream != null) {
                            z.a(dataInputStream);
                        }
                    }
                } catch (FileNotFoundException unused2) {
                    dataInputStream = null;
                } catch (IOException e4) {
                    e = e4;
                    dataInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.util.c cVar3 = iVar.c;
                cVar3.f2175a.delete();
                cVar3.b.delete();
                iVar.f2155a.clear();
                iVar.b.clear();
                fileArrListFiles = lVar.f2158a.listFiles();
                if (fileArrListFiles == null) {
                    return;
                }
                while (i < r3) {
                    if (!file.getName().equals(CachedContentIndex.FILE_NAME)) {
                        if (file.length() > 0) {
                            mVarA = m.a(file, lVar.d);
                        } else {
                            mVarA = null;
                        }
                        if (mVarA != null) {
                            lVar.a(mVarA);
                        } else {
                            file.delete();
                        }
                    }
                }
                lVar.d.a();
                lVar.d.b();
                return;
            } catch (Throwable th3) {
                th = th3;
                if (dataInputStream2 != null) {
                    z.a(dataInputStream2);
                }
                throw th;
            }
        }
        throw new IllegalStateException();
    }

    public final void a(m mVar) {
        i iVar = this.d;
        String str = mVar.f2153a;
        h hVarA = (h) iVar.f2155a.get(str);
        if (hVarA == null) {
            hVarA = iVar.a(str, -1L);
        }
        hVarA.c.add(mVar);
        ArrayList arrayList = (ArrayList) this.e.get(mVar.f2153a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                j jVar = (j) arrayList.get(size);
                jVar.f2156a.add(mVar);
                jVar.b += mVar.c;
                jVar.a(this, 0L);
            }
        }
        j jVar2 = this.b;
        jVar2.f2156a.add(mVar);
        jVar2.b += mVar.c;
        jVar2.a(this, 0L);
    }

    public final void a(g gVar, boolean z) throws Throwable {
        h hVar = (h) this.d.f2155a.get(gVar.f2153a);
        if (hVar == null || !hVar.c.remove(gVar)) {
            return;
        }
        gVar.e.delete();
        if (z && hVar.c.isEmpty()) {
            i iVar = this.d;
            h hVar2 = (h) iVar.f2155a.remove(hVar.b);
            if (hVar2 != null) {
                if (hVar2.c.isEmpty()) {
                    iVar.b.remove(hVar2.f2154a);
                    iVar.f = true;
                } else {
                    throw new IllegalStateException();
                }
            }
            this.d.b();
        }
        ArrayList arrayList = (ArrayList) this.e.get(gVar.f2153a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                j jVar = (j) arrayList.get(size);
                jVar.f2156a.remove(gVar);
                jVar.b -= gVar.c;
            }
        }
        j jVar2 = this.b;
        jVar2.f2156a.remove(gVar);
        jVar2.b -= gVar.c;
    }

    public final void a() throws Throwable {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.d.f2155a.values().iterator();
        while (it.hasNext()) {
            for (g gVar : ((h) it.next()).c) {
                if (gVar.e.length() != gVar.c) {
                    linkedList.add(gVar);
                }
            }
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            a((g) it2.next(), false);
        }
        this.d.a();
        this.d.b();
    }

    public final synchronized long a(String str) {
        h hVar;
        hVar = (h) this.d.f2155a.get(str);
        return hVar == null ? -1L : hVar.d;
    }
}
