package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzhx implements zzlu, zzlx {
    private final int zzb;
    private zzly zzd;
    private int zze;
    private zzoz zzf;
    private zzdg zzg;
    private int zzh;
    private zzws zzi;
    private zzz[] zzj;
    private long zzk;
    private long zzl;
    private boolean zzn;
    private boolean zzo;
    private zzuy zzq;
    private zzlw zzr;
    private final Object zza = new Object();
    private final zzkp zzc = new zzkp();
    private long zzm = Long.MIN_VALUE;
    private zzbl zzp = zzbl.zza;

    public zzhx(int i) {
        this.zzb = i;
    }

    private final void zzZ(long j, boolean z) throws zzii {
        this.zzn = false;
        this.zzl = j;
        this.zzm = j;
        zzz(j, z);
    }

    protected void zzA() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzB() {
        zzlw zzlwVar;
        synchronized (this.zza) {
            zzlwVar = this.zzr;
        }
        if (zzlwVar != null) {
            zzlwVar.zza(this);
        }
    }

    protected void zzC() {
    }

    protected void zzD() throws zzii {
    }

    protected void zzE() {
    }

    protected void zzF(zzz[] zzzVarArr, long j, long j2, zzuy zzuyVar) throws zzii {
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzG() {
        zzdc.zzf(this.zzh == 0);
        zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzH(zzz[] zzzVarArr, zzws zzwsVar, long j, long j2, zzuy zzuyVar) throws zzii {
        zzdc.zzf(!this.zzn);
        this.zzi = zzwsVar;
        this.zzq = zzuyVar;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j;
        }
        this.zzj = zzzVarArr;
        this.zzk = j2;
        zzF(zzzVarArr, j, j2, zzuyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzI() {
        zzdc.zzf(this.zzh == 0);
        zzkp zzkpVar = this.zzc;
        zzkpVar.zzb = null;
        zzkpVar.zza = null;
        zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzJ(long j) throws zzii {
        zzZ(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzK() {
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void zzL(zzlw zzlwVar) {
        synchronized (this.zza) {
            this.zzr = zzlwVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public /* synthetic */ void zzM(float f, float f2) {
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzN(zzbl zzblVar) {
        if (Objects.equals(this.zzp, zzblVar)) {
            return;
        }
        this.zzp = zzblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzO() throws zzii {
        zzdc.zzf(this.zzh == 1);
        this.zzh = 2;
        zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzP() {
        zzdc.zzf(this.zzh == 2);
        this.zzh = 1;
        zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final boolean zzQ() {
        return this.zzm == Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final boolean zzR() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzlx
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final int zzcT() {
        return this.zzh;
    }

    protected final int zzcU(zzkp zzkpVar, zzhn zzhnVar, int i) {
        zzws zzwsVar = this.zzi;
        zzwsVar.getClass();
        int iZza = zzwsVar.zza(zzkpVar, zzhnVar, i);
        if (iZza == -4) {
            if (zzhnVar.zzf()) {
                this.zzm = Long.MIN_VALUE;
                return this.zzn ? -4 : -3;
            }
            long j = zzhnVar.zze + this.zzk;
            zzhnVar.zze = j;
            this.zzm = Math.max(this.zzm, j);
        } else if (iZza == -5) {
            zzz zzzVar = zzkpVar.zza;
            zzzVar.getClass();
            long j2 = zzzVar.zzt;
            if (j2 != Long.MAX_VALUE) {
                zzx zzxVarZzb = zzzVar.zzb();
                zzxVarZzb.zzah(j2 + this.zzk);
                zzkpVar.zza = zzxVarZzb.zzaj();
                return -5;
            }
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final long zzcV() {
        return this.zzm;
    }

    protected final zzii zzcW(Throwable th, zzz zzzVar, boolean z, int i) {
        int iZzY = 4;
        if (zzzVar != null && !this.zzo) {
            this.zzo = true;
            try {
                iZzY = zzY(zzzVar) & 7;
            } catch (zzii unused) {
            } finally {
                this.zzo = false;
            }
        }
        return zzii.zzb(th, zzU(), this.zze, zzzVar, iZzY, this.zzq, z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public int zze() throws zzii {
        return 0;
    }

    protected final long zzf() {
        return this.zzl;
    }

    protected final zzbl zzh() {
        return this.zzp;
    }

    protected final zzkp zzk() {
        zzkp zzkpVar = this.zzc;
        zzkpVar.zzb = null;
        zzkpVar.zza = null;
        return zzkpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public zzkv zzl() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final zzlx zzm() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final zzws zzp() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void zzq() {
        synchronized (this.zza) {
            this.zzr = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzr() {
        zzdc.zzf(this.zzh == 1);
        zzkp zzkpVar = this.zzc;
        zzkpVar.zzb = null;
        zzkpVar.zza = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzx();
        this.zzq = null;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzs(zzly zzlyVar, zzz[] zzzVarArr, zzws zzwsVar, long j, boolean z, boolean z2, long j2, long j3, zzuy zzuyVar) throws zzii {
        zzdc.zzf(this.zzh == 0);
        this.zzd = zzlyVar;
        this.zzq = zzuyVar;
        this.zzh = 1;
        zzy(z, z2);
        zzH(zzzVarArr, zzwsVar, j2, j3, zzuyVar);
        zzZ(j2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public /* synthetic */ void zzt() {
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public void zzu(int i, Object obj) throws zzii {
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzv(int i, zzoz zzozVar, zzdg zzdgVar) {
        this.zze = i;
        this.zzf = zzozVar;
        this.zzg = zzdgVar;
    }

    protected void zzx() {
        throw null;
    }

    protected void zzy(boolean z, boolean z2) throws zzii {
    }

    protected void zzz(long j, boolean z) throws zzii {
        throw null;
    }

    protected final boolean zzS() {
        if (zzQ()) {
            return this.zzn;
        }
        zzws zzwsVar = this.zzi;
        zzwsVar.getClass();
        return zzwsVar.zze();
    }

    protected final zzz[] zzT() {
        zzz[] zzzVarArr = this.zzj;
        zzzVarArr.getClass();
        return zzzVarArr;
    }

    protected final int zzd(long j) {
        zzws zzwsVar = this.zzi;
        zzwsVar.getClass();
        return zzwsVar.zzb(j - this.zzk);
    }

    protected final zzdg zzi() {
        zzdg zzdgVar = this.zzg;
        zzdgVar.getClass();
        return zzdgVar;
    }

    protected final zzly zzn() {
        zzly zzlyVar = this.zzd;
        zzlyVar.getClass();
        return zzlyVar;
    }

    protected final zzoz zzo() {
        zzoz zzozVar = this.zzf;
        zzozVar.getClass();
        return zzozVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzw() throws IOException {
        zzws zzwsVar = this.zzi;
        zzwsVar.getClass();
        zzwsVar.zzd();
    }
}
