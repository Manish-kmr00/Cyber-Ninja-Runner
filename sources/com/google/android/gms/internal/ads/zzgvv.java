package com.google.android.gms.internal.ads;

import _COROUTINE.ArtificialStackFrames;
import com.google.android.gms.internal.ads.zzgvv;
import com.google.android.gms.internal.ads.zzgvw;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public abstract class zzgvv<MessageType extends zzgvw<MessageType, BuilderType>, BuilderType extends zzgvv<MessageType, BuilderType>> implements zzgzf {
    private String zza(String str) {
        return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
    }

    private static <T> void zzb(Iterable<T> iterable, List<? super T> list) {
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size);
            } else if (list instanceof zzgzr) {
                ((zzgzr) list).zze(list.size() + size);
            }
        }
        int size2 = list.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj : iterable) {
                if (obj == null) {
                    zzc(list, size2);
                }
                list.add(obj);
            }
            return;
        }
        List list2 = (List) iterable;
        int size3 = list2.size();
        for (int i = 0; i < size3; i++) {
            ArtificialStackFrames artificialStackFrames = (Object) list2.get(i);
            if (artificialStackFrames == null) {
                zzc(list, size2);
            }
            list.add(artificialStackFrames);
        }
    }

    protected static zzhak zzbb(zzgzg zzgzgVar) {
        return new zzhak(zzgzgVar);
    }

    @Deprecated
    protected static <T> void zzbc(Iterable<T> iterable, Collection<? super T> collection) {
        zzbd(iterable, (List) collection);
    }

    protected static <T> void zzbd(Iterable<T> iterable, List<? super T> list) {
        byte[] bArr = zzgyi.zzb;
        iterable.getClass();
        if (!(iterable instanceof zzgys)) {
            if (iterable instanceof zzgzp) {
                list.addAll((Collection) iterable);
                return;
            } else {
                zzb(iterable, list);
                return;
            }
        }
        List listZza = ((zzgys) iterable).zza();
        zzgys zzgysVar = (zzgys) list;
        int size = list.size();
        for (Object obj : listZza) {
            if (obj == null) {
                String str = "Element at index " + (zzgysVar.size() - size) + " is null.";
                int size2 = zzgysVar.size();
                while (true) {
                    size2--;
                    if (size2 < size) {
                        throw new NullPointerException(str);
                    }
                    zzgysVar.remove(size2);
                }
            } else if (obj instanceof zzgwn) {
                zzgysVar.zzb();
            } else if (obj instanceof byte[]) {
                byte[] bArr2 = (byte[]) obj;
                zzgwn.zzv(bArr2, 0, bArr2.length);
                zzgysVar.zzb();
            } else {
                zzgysVar.add((String) obj);
            }
        }
    }

    private static void zzc(List<?> list, int i) {
        String str = "Element at index " + (list.size() - i) + " is null.";
        int size = list.size();
        while (true) {
            size--;
            if (size < i) {
                throw new NullPointerException(str);
            }
            list.remove(size);
        }
    }

    @Override // 
    public abstract BuilderType zzaP();

    protected abstract BuilderType zzaD(MessageType messagetype);

    public BuilderType zzaE(zzgwn zzgwnVar) throws zzgyk {
        try {
            zzgwt zzgwtVarZzl = zzgwnVar.zzl();
            zzaR(zzgwtVarZzl);
            zzgwtVarZzl.zzy(0);
            return this;
        } catch (zzgyk e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("ByteString"), e2);
        }
    }

    /* JADX INFO: renamed from: zzaF, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaR(zzgwt zzgwtVar) throws IOException {
        int i = zzgxf.zzb;
        int i2 = zzgzq.zza;
        return (BuilderType) zzaW(zzgwtVar, zzgxf.zza);
    }

    /* JADX INFO: renamed from: zzaG, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaS(zzgzg zzgzgVar) {
        if (zzbt().getClass().isInstance(zzgzgVar)) {
            return (BuilderType) zzaD((zzgvw) zzgzgVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public BuilderType zzaH(InputStream inputStream) throws IOException {
        zzgwt zzgwtVarZzG = zzgwt.zzG(inputStream, 4096);
        zzaR(zzgwtVarZzG);
        zzgwtVarZzG.zzy(0);
        return this;
    }

    /* JADX INFO: renamed from: zzaI, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaU(byte[] bArr) throws zzgyk {
        return (BuilderType) zzaZ(bArr, 0, bArr.length);
    }

    public BuilderType zzaJ(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        try {
            zzgwt zzgwtVarZzl = zzgwnVar.zzl();
            zzaW(zzgwtVarZzl, zzgxfVar);
            zzgwtVarZzl.zzy(0);
            return this;
        } catch (zzgyk e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("ByteString"), e2);
        }
    }

    @Override // 
    /* JADX INFO: renamed from: zzaK, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType zzaW(zzgwt zzgwtVar, zzgxf zzgxfVar) throws IOException;

    public BuilderType zzaL(InputStream inputStream, zzgxf zzgxfVar) throws IOException {
        zzgwt zzgwtVarZzG = zzgwt.zzG(inputStream, 4096);
        zzaW(zzgwtVarZzG, zzgxfVar);
        zzgwtVarZzG.zzy(0);
        return this;
    }

    /* JADX INFO: renamed from: zzaM, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaY(byte[] bArr, zzgxf zzgxfVar) throws zzgyk {
        return (BuilderType) zzba(bArr, 0, bArr.length, zzgxfVar);
    }

    @Override // 
    /* JADX INFO: renamed from: zzaN, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaZ(byte[] bArr, int i, int i2) throws zzgyk {
        try {
            zzgwt zzgwtVarZzH = zzgwt.zzH(bArr, i, i2, false);
            zzaR(zzgwtVarZzH);
            zzgwtVarZzH.zzy(0);
            return this;
        } catch (zzgyk e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    @Override // 
    /* JADX INFO: renamed from: zzaO, reason: merged with bridge method [inline-methods] */
    public BuilderType zzba(byte[] bArr, int i, int i2, zzgxf zzgxfVar) throws zzgyk {
        try {
            zzgwt zzgwtVarZzH = zzgwt.zzH(bArr, i, i2, false);
            zzaW(zzgwtVarZzH, zzgxfVar);
            zzgwtVarZzH.zzy(0);
            return this;
        } catch (zzgyk e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public /* bridge */ /* synthetic */ zzgzf zzaQ(zzgwn zzgwnVar) throws zzgyk {
        zzaE(zzgwnVar);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgzf zzaT(InputStream inputStream) throws IOException {
        zzaH(inputStream);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgzf zzaV(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        zzaJ(zzgwnVar, zzgxfVar);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgzf zzaX(InputStream inputStream, zzgxf zzgxfVar) throws IOException {
        zzaL(inputStream, zzgxfVar);
        return this;
    }

    public boolean zzbe(InputStream inputStream) throws IOException {
        int i = zzgxf.zzb;
        int i2 = zzgzq.zza;
        return zzbf(inputStream, zzgxf.zza);
    }

    public boolean zzbf(InputStream inputStream, zzgxf zzgxfVar) throws IOException {
        int i = inputStream.read();
        if (i == -1) {
            return false;
        }
        zzaL(new zzgvu(inputStream, zzgwt.zzE(i, inputStream)), zzgxfVar);
        return true;
    }
}
