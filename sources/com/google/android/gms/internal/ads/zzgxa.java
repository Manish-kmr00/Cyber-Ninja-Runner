package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public abstract class zzgxa extends zzgwe {
    private static final Logger zza = Logger.getLogger(zzgxa.class.getName());
    private static final boolean zzb = zzhas.zzA();
    public static final /* synthetic */ int zzf = 0;
    zzgxb zze;

    private zzgxa() {
        throw null;
    }

    /* synthetic */ zzgxa(zzgwz zzgwzVar) {
    }

    static int zzA(zzgzg zzgzgVar, zzgzz zzgzzVar) {
        int iZzaM = ((zzgvw) zzgzgVar).zzaM(zzgzzVar);
        return zzD(iZzaM) + iZzaM;
    }

    static int zzB(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int zzC(String str) {
        int length;
        try {
            length = zzhax.zze(str);
        } catch (zzhaw unused) {
            length = str.getBytes(zzgyi.zza).length;
        }
        return zzD(length) + length;
    }

    public static int zzD(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzE(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    @Deprecated
    static int zzy(int i, zzgzg zzgzgVar, zzgzz zzgzzVar) {
        int iZzD = zzD(i << 3);
        return iZzD + iZzD + ((zzgvw) zzgzgVar).zzaM(zzgzzVar);
    }

    public static int zzz(zzgzg zzgzgVar) {
        int iZzaY = zzgzgVar.zzaY();
        return zzD(iZzaY) + iZzaY;
    }

    public final void zzF() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zzG(String str, zzhaw zzhawVar) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzhawVar);
        byte[] bytes = str.getBytes(zzgyi.zza);
        try {
            int length = bytes.length;
            zzu(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzgwx(e);
        }
    }

    public abstract void zzK() throws IOException;

    public abstract void zzL(byte b) throws IOException;

    public abstract void zzM(int i, boolean z) throws IOException;

    public abstract void zzN(int i, zzgwn zzgwnVar) throws IOException;

    @Override // com.google.android.gms.internal.ads.zzgwe
    public abstract void zza(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzk(long j) throws IOException;

    public abstract void zzl(int i, int i2) throws IOException;

    public abstract void zzm(int i) throws IOException;

    abstract void zzn(int i, zzgzg zzgzgVar, zzgzz zzgzzVar) throws IOException;

    public abstract void zzo(int i, zzgzg zzgzgVar) throws IOException;

    public abstract void zzp(int i, zzgwn zzgwnVar) throws IOException;

    public abstract void zzq(int i, String str) throws IOException;

    public abstract void zzs(int i, int i2) throws IOException;

    public abstract void zzt(int i, int i2) throws IOException;

    public abstract void zzu(int i) throws IOException;

    public abstract void zzv(int i, long j) throws IOException;

    public abstract void zzw(long j) throws IOException;
}
