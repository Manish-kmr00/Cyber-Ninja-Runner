package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzoo implements zzox {
    public static final zzfuo zza = new zzfuo() { // from class: com.google.android.gms.internal.ads.zzom
        @Override // com.google.android.gms.internal.ads.zzfuo
        public final Object zza() {
            return zzoo.zzn();
        }
    };
    private static final Random zzb = new Random();
    private final zzbk zzc;
    private final zzbj zzd;
    private final HashMap zze;
    private zzow zzf;
    private zzbl zzg;
    private String zzh;
    private long zzi;

    public zzoo() {
        throw null;
    }

    public zzoo(zzfuo zzfuoVar) {
        this.zzc = new zzbk();
        this.zzd = new zzbj();
        this.zze = new HashMap();
        this.zzg = zzbl.zza;
        this.zzi = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzl() {
        zzon zzonVar = (zzon) this.zze.get(this.zzh);
        return (zzonVar == null || zzonVar.zzd == -1) ? this.zzi + 1 : zzonVar.zzd;
    }

    private final zzon zzm(int i, zzuy zzuyVar) {
        HashMap map = this.zze;
        long j = Long.MAX_VALUE;
        zzon zzonVar = null;
        for (zzon zzonVar2 : map.values()) {
            zzonVar2.zzg(i, zzuyVar);
            if (zzonVar2.zzj(i, zzuyVar)) {
                long j2 = zzonVar2.zzd;
                if (j2 == -1 || j2 < j) {
                    zzonVar = zzonVar2;
                    j = j2;
                } else if (j2 == j) {
                    int i2 = zzeu.zza;
                    if (zzonVar.zze != null && zzonVar2.zze != null) {
                        zzonVar = zzonVar2;
                    }
                }
            }
        }
        if (zzonVar != null) {
            return zzonVar;
        }
        String strZzn = zzn();
        zzon zzonVar3 = new zzon(this, strZzn, i, zzuyVar);
        map.put(strZzn, zzonVar3);
        return zzonVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzn() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final void zzo(zzon zzonVar) {
        if (zzonVar.zzd != -1) {
            this.zzi = zzonVar.zzd;
        }
        this.zzh = null;
    }

    @RequiresNonNull({ServiceSpecificExtraArgs.CastExtraArgs.LISTENER})
    private final void zzp(zzmh zzmhVar) {
        if (zzmhVar.zzb.zzo()) {
            String str = this.zzh;
            if (str != null) {
                zzon zzonVar = (zzon) this.zze.get(str);
                zzonVar.getClass();
                zzo(zzonVar);
                return;
            }
            return;
        }
        zzon zzonVar2 = (zzon) this.zze.get(this.zzh);
        int i = zzmhVar.zzc;
        zzuy zzuyVar = zzmhVar.zzd;
        zzon zzonVarZzm = zzm(i, zzuyVar);
        this.zzh = zzonVarZzm.zzb;
        zzi(zzmhVar);
        if (zzuyVar == null || !zzuyVar.zzb()) {
            return;
        }
        if (zzonVar2 != null) {
            if (zzonVar2.zzd == zzuyVar.zzd && zzonVar2.zze != null && zzonVar2.zze.zzb == zzuyVar.zzb && zzonVar2.zze.zzc == zzuyVar.zzc) {
                return;
            }
        }
        String unused = zzm(i, new zzuy(zzuyVar.zza, zzuyVar.zzd)).zzb;
        String unused2 = zzonVarZzm.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzox
    public final synchronized String zze() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzox
    public final synchronized String zzf(zzbl zzblVar, zzuy zzuyVar) {
        return zzm(zzblVar.zzn(zzuyVar.zza, this.zzd).zzc, zzuyVar).zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzox
    public final synchronized void zzg(zzmh zzmhVar) {
        zzow zzowVar;
        String str = this.zzh;
        if (str != null) {
            zzon zzonVar = (zzon) this.zze.get(str);
            if (zzonVar == null) {
                throw null;
            }
            zzo(zzonVar);
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzon zzonVar2 = (zzon) it.next();
            it.remove();
            if (zzonVar2.zzf && (zzowVar = this.zzf) != null) {
                zzowVar.zzv(zzmhVar, zzonVar2.zzb, false);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzox
    public final void zzh(zzow zzowVar) {
        this.zzf = zzowVar;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003b A[Catch: all -> 0x00b5, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001d, B:14:0x0029, B:16:0x0033, B:18:0x003b, B:20:0x0045, B:23:0x004e, B:25:0x0054, B:27:0x0069, B:28:0x0085, B:30:0x008b, B:31:0x0091, B:33:0x009d, B:35:0x00a3, B:41:0x00b4), top: B:45:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0045 A[Catch: all -> 0x00b5, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001d, B:14:0x0029, B:16:0x0033, B:18:0x003b, B:20:0x0045, B:23:0x004e, B:25:0x0054, B:27:0x0069, B:28:0x0085, B:30:0x008b, B:31:0x0091, B:33:0x009d, B:35:0x00a3, B:41:0x00b4), top: B:45:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0069 A[Catch: all -> 0x00b5, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001d, B:14:0x0029, B:16:0x0033, B:18:0x003b, B:20:0x0045, B:23:0x004e, B:25:0x0054, B:27:0x0069, B:28:0x0085, B:30:0x008b, B:31:0x0091, B:33:0x009d, B:35:0x00a3, B:41:0x00b4), top: B:45:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x008b A[Catch: all -> 0x00b5, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001d, B:14:0x0029, B:16:0x0033, B:18:0x003b, B:20:0x0045, B:23:0x004e, B:25:0x0054, B:27:0x0069, B:28:0x0085, B:30:0x008b, B:31:0x0091, B:33:0x009d, B:35:0x00a3, B:41:0x00b4), top: B:45:0x0001 }] */
    @Override // com.google.android.gms.internal.ads.zzox
    public final synchronized void zzi(zzmh zzmhVar) {
        int i;
        zzon zzonVarZzm;
        Object obj;
        int i2;
        zzon zzonVarZzm2;
        zzon zzonVar;
        if (this.zzf == null) {
            throw null;
        }
        zzbl zzblVar = zzmhVar.zzb;
        if (!zzblVar.zzo()) {
            zzuy zzuyVar = zzmhVar.zzd;
            if (zzuyVar == null) {
                i = zzmhVar.zzc;
                zzonVarZzm = zzm(i, zzuyVar);
                if (this.zzh == null) {
                    this.zzh = zzonVarZzm.zzb;
                }
                if (zzuyVar != null) {
                    obj = zzuyVar.zza;
                    long j = zzuyVar.zzd;
                    i2 = zzuyVar.zzb;
                    zzonVarZzm2 = zzm(i, new zzuy(obj, j, i2));
                    if (!zzonVarZzm2.zzf) {
                        zzonVarZzm2.zzf = true;
                        zzbj zzbjVar = this.zzd;
                        zzblVar.zzn(obj, zzbjVar);
                        zzbjVar.zzg(i2);
                        Math.max(0L, zzeu.zzv(0L) + zzeu.zzv(0L));
                        String unused = zzonVarZzm2.zzb;
                    }
                }
                if (!zzonVarZzm.zzf) {
                    zzonVarZzm.zzf = true;
                    String unused2 = zzonVarZzm.zzb;
                }
                if (zzonVarZzm.zzb.equals(this.zzh)) {
                    zzonVarZzm.zzg = true;
                    this.zzf.zzu(zzmhVar, zzonVarZzm.zzb);
                }
            } else if (zzuyVar.zzd >= zzl() && ((zzonVar = (zzon) this.zze.get(this.zzh)) == null || zzonVar.zzd != -1 || zzonVar.zzc == zzmhVar.zzc)) {
                i = zzmhVar.zzc;
                zzonVarZzm = zzm(i, zzuyVar);
                if (this.zzh == null) {
                    this.zzh = zzonVarZzm.zzb;
                }
                if (zzuyVar != null && zzuyVar.zzb()) {
                    obj = zzuyVar.zza;
                    long j2 = zzuyVar.zzd;
                    i2 = zzuyVar.zzb;
                    zzonVarZzm2 = zzm(i, new zzuy(obj, j2, i2));
                    if (!zzonVarZzm2.zzf) {
                        zzonVarZzm2.zzf = true;
                        zzbj zzbjVar2 = this.zzd;
                        zzblVar.zzn(obj, zzbjVar2);
                        zzbjVar2.zzg(i2);
                        Math.max(0L, zzeu.zzv(0L) + zzeu.zzv(0L));
                        String unused3 = zzonVarZzm2.zzb;
                    }
                }
                if (!zzonVarZzm.zzf) {
                    zzonVarZzm.zzf = true;
                    String unused4 = zzonVarZzm.zzb;
                }
                if (zzonVarZzm.zzb.equals(this.zzh) && !zzonVarZzm.zzg) {
                    zzonVarZzm.zzg = true;
                    this.zzf.zzu(zzmhVar, zzonVarZzm.zzb);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzox
    public final synchronized void zzj(zzmh zzmhVar, int i) {
        if (this.zzf == null) {
            throw null;
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzon zzonVar = (zzon) it.next();
            if (zzonVar.zzk(zzmhVar)) {
                it.remove();
                if (zzonVar.zzf) {
                    boolean zEquals = zzonVar.zzb.equals(this.zzh);
                    boolean z = false;
                    if (i == 0 && zEquals && zzonVar.zzg) {
                        z = true;
                    }
                    if (zEquals) {
                        zzo(zzonVar);
                    }
                    this.zzf.zzv(zzmhVar, zzonVar.zzb, z);
                }
            }
        }
        zzp(zzmhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzox
    public final synchronized void zzk(zzmh zzmhVar) {
        if (this.zzf == null) {
            throw null;
        }
        zzbl zzblVar = this.zzg;
        this.zzg = zzmhVar.zzb;
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzon zzonVar = (zzon) it.next();
            if (!zzonVar.zzl(zzblVar, this.zzg) || zzonVar.zzk(zzmhVar)) {
                it.remove();
                if (zzonVar.zzf) {
                    if (zzonVar.zzb.equals(this.zzh)) {
                        zzo(zzonVar);
                    }
                    this.zzf.zzv(zzmhVar, zzonVar.zzb, false);
                }
            }
        }
        zzp(zzmhVar);
    }
}
