package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.util.p;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedContentIndex;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes12.dex */
public final class i {
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.c c;
    public boolean f;
    public p g;
    public final Cipher d = null;
    public final SecretKeySpec e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f2155a = new HashMap();
    public final SparseArray b = new SparseArray();

    public i(File file) {
        this.c = new com.fyber.inneractive.sdk.player.exoplayer2.util.c(new File(file, CachedContentIndex.FILE_NAME));
    }

    public final void a() {
        LinkedList linkedList = new LinkedList();
        for (h hVar : this.f2155a.values()) {
            if (hVar.c.isEmpty()) {
                linkedList.add(hVar.b);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            h hVar2 = (h) this.f2155a.remove((String) it.next());
            if (hVar2 != null) {
                if (!hVar2.c.isEmpty()) {
                    throw new IllegalStateException();
                }
                this.b.remove(hVar2.f2154a);
                this.f = true;
            }
        }
    }

    public final void b() throws Throwable {
        DataOutputStream dataOutputStream;
        IOException e;
        Throwable th;
        if (!this.f) {
            return;
        }
        DataOutputStream dataOutputStream2 = null;
        try {
            com.fyber.inneractive.sdk.player.exoplayer2.util.b bVarB = this.c.b();
            p pVar = this.g;
            if (pVar == null) {
                this.g = new p(bVarB);
            } else {
                pVar.a(bVarB);
            }
            dataOutputStream = new DataOutputStream(this.g);
            try {
                dataOutputStream.writeInt(1);
                dataOutputStream.writeInt(this.d != null ? 1 : 0);
                if (this.d != null) {
                    byte[] bArr = new byte[16];
                    new Random().nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        this.d.init(1, this.e, new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream2 = new DataOutputStream(new CipherOutputStream(this.g, this.d));
                    } catch (InvalidAlgorithmParameterException e2) {
                        e = e2;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e3) {
                        e = e3;
                        throw new IllegalStateException(e);
                    }
                } else {
                    dataOutputStream2 = dataOutputStream;
                }
                dataOutputStream2.writeInt(this.f2155a.size());
                int i = 0;
                for (h hVar : this.f2155a.values()) {
                    dataOutputStream2.writeInt(hVar.f2154a);
                    dataOutputStream2.writeUTF(hVar.b);
                    dataOutputStream2.writeLong(hVar.d);
                    int iHashCode = (hVar.b.hashCode() + (hVar.f2154a * 31)) * 31;
                    long j = hVar.d;
                    i += iHashCode + ((int) (j ^ (j >>> 32)));
                }
                dataOutputStream2.writeInt(i);
                com.fyber.inneractive.sdk.player.exoplayer2.util.c cVar = this.c;
                cVar.getClass();
                dataOutputStream2.close();
                cVar.b.delete();
                int i2 = z.f2192a;
                this.f = false;
            } catch (IOException e4) {
                e = e4;
                try {
                    throw new a(e);
                } catch (Throwable th2) {
                    DataOutputStream dataOutputStream3 = dataOutputStream;
                    th = th2;
                    dataOutputStream2 = dataOutputStream3;
                    Throwable th3 = th;
                    dataOutputStream = dataOutputStream2;
                    th = th3;
                    z.a(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                z.a(dataOutputStream);
                throw th;
            }
        } catch (IOException e5) {
            dataOutputStream = dataOutputStream2;
            e = e5;
        } catch (Throwable th5) {
            th = th5;
            Throwable th6 = th;
            dataOutputStream = dataOutputStream2;
            th = th6;
            z.a(dataOutputStream);
            throw th;
        }
    }

    public final h a(String str, long j) {
        SparseArray sparseArray = this.b;
        int size = sparseArray.size();
        int i = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            iKeyAt = i;
        }
        h hVar = new h(iKeyAt, str, j);
        this.f2155a.put(str, hVar);
        this.b.put(iKeyAt, str);
        this.f = true;
        return hVar;
    }
}
