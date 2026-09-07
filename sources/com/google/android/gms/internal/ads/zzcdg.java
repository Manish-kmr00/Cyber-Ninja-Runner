package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcdg extends zzfx {
    private final Context zza;
    private final zzge zzb;
    private final String zzc;
    private final int zzd;
    private final boolean zze;
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzbas zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private long zzn;
    private ListenableFuture zzo;
    private final AtomicLong zzp;
    private final zzcdq zzq;

    public zzcdg(Context context, zzge zzgeVar, String str, int i, zzhe zzheVar, zzcdq zzcdqVar) {
        super(false);
        this.zza = context;
        this.zzb = zzgeVar;
        this.zzq = zzcdqVar;
        this.zzc = str;
        this.zzd = i;
        this.zzj = false;
        this.zzk = false;
        this.zzl = false;
        this.zzm = false;
        this.zzn = 0L;
        this.zzp = new AtomicLong(-1L);
        this.zzo = null;
        this.zze = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcc)).booleanValue();
        zzf(zzheVar);
    }

    private final boolean zzr() {
        if (!this.zze) {
            return false;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeA)).booleanValue() || this.zzl) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeB)).booleanValue() && !this.zzm;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to read closed GcacheDataSource.");
        }
        InputStream inputStream = this.zzf;
        int iZza = inputStream != null ? inputStream.read(bArr, i, i2) : this.zzb.zza(bArr, i, i2);
        if (!this.zze || this.zzf != null) {
            zzg(iZza);
        }
        return iZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.StringBuilder] */
    @Override // com.google.android.gms.internal.ads.zzge
    public final long zzb(zzgj zzgjVar) throws Throwable {
        zzbap zzbapVarZzb;
        Long l;
        boolean z;
        boolean z2;
        long jElapsedRealtime;
        String string = "ms";
        if (this.zzg) {
            throw new IOException("Attempt to open an already open GcacheDataSource.");
        }
        ?? r2 = 1;
        this.zzg = true;
        Uri uri = zzgjVar.zza;
        this.zzh = uri;
        ?? sb = this.zze;
        if (sb == 0) {
            zzj(zzgjVar);
        }
        this.zzi = zzbas.zza(uri);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzex)).booleanValue()) {
            if (this.zzi != null) {
                this.zzi.zzh = zzgjVar.zze;
                this.zzi.zzi = zzfun.zzc(this.zzc);
                this.zzi.zzj = this.zzd;
                zzbapVarZzb = com.google.android.gms.ads.internal.zzv.zzc().zzb(this.zzi);
            } else {
                zzbapVarZzb = null;
            }
            if (zzbapVarZzb != null && zzbapVarZzb.zze()) {
                this.zzj = zzbapVarZzb.zzd();
                this.zzl = zzbapVarZzb.zzg();
                this.zzm = zzbapVarZzb.zzf();
                this.zzn = zzbapVarZzb.zza();
                this.zzk = true;
                if (!zzr()) {
                    this.zzf = zzbapVarZzb.zzc();
                    if (this.zze) {
                        zzj(zzgjVar);
                    }
                    return -1L;
                }
            }
        } else if (this.zzi != null) {
            this.zzi.zzh = zzgjVar.zze;
            this.zzi.zzi = zzfun.zzc(this.zzc);
            this.zzi.zzj = this.zzd;
            if (this.zzi.zzg) {
                l = (Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzez);
            } else {
                l = (Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzey);
            }
            long jLongValue = l.longValue();
            long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime();
            com.google.android.gms.ads.internal.zzv.zzd();
            Future futureZza = zzbbd.zza(this.zza, this.zzi);
            try {
                try {
                    zzbbe zzbbeVar = (zzbbe) futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                    try {
                        this.zzj = zzbbeVar.zzd();
                        this.zzl = zzbbeVar.zzf();
                        this.zzm = zzbbeVar.zze();
                        this.zzn = zzbbeVar.zza();
                        if (!zzr()) {
                            this.zzf = zzbbeVar.zzc();
                            if (sb != 0) {
                                zzj(zzgjVar);
                            }
                            long jElapsedRealtime3 = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime2;
                            zzcdt.zzab(this.zzq.zza, true, jElapsedRealtime3);
                            this.zzk = true;
                            com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + jElapsedRealtime3 + "ms");
                            return -1L;
                        }
                        long jElapsedRealtime4 = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime2;
                        zzcdt.zzab(this.zzq.zza, true, jElapsedRealtime4);
                        this.zzk = true;
                        string = "Cache connection took " + jElapsedRealtime4 + "ms";
                    } catch (InterruptedException unused) {
                        z2 = true;
                        futureZza.cancel(true);
                        Thread.currentThread().interrupt();
                        jElapsedRealtime = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime2;
                        zzcdt.zzab(this.zzq.zza, z2, jElapsedRealtime);
                        this.zzk = z2;
                        sb = new StringBuilder("Cache connection took ");
                        sb.append(jElapsedRealtime);
                        sb.append("ms");
                        string = sb.toString();
                    } catch (ExecutionException | TimeoutException unused2) {
                        z = true;
                        futureZza.cancel(true);
                        jElapsedRealtime = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime2;
                        zzcdt.zzab(this.zzq.zza, z, jElapsedRealtime);
                        this.zzk = z;
                        sb = new StringBuilder("Cache connection took ");
                        sb.append(jElapsedRealtime);
                        sb.append("ms");
                        string = sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        long jElapsedRealtime5 = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime2;
                        zzcdt.zzab(this.zzq.zza, r2, jElapsedRealtime5);
                        this.zzk = r2;
                        com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + jElapsedRealtime5 + string);
                        throw th;
                    }
                } catch (InterruptedException unused3) {
                    z2 = false;
                } catch (ExecutionException | TimeoutException unused4) {
                    z = false;
                } catch (Throwable th2) {
                    th = th2;
                    r2 = 0;
                }
                com.google.android.gms.ads.internal.util.zze.zza(string);
            } catch (Throwable th3) {
                th = th3;
                r2 = sb;
            }
        }
        this.zzk = false;
        if (this.zzi != null) {
            zzgh zzghVarZza = zzgjVar.zza();
            zzghVarZza.zzd(Uri.parse(this.zzi.zza));
            zzgjVar = zzghVarZza.zze();
        }
        return this.zzb.zzb(zzgjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final Uri zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd() throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to close an already closed GcacheDataSource.");
        }
        this.zzg = false;
        this.zzh = null;
        boolean z = (this.zze && this.zzf == null) ? false : true;
        InputStream inputStream = this.zzf;
        if (inputStream != null) {
            IOUtils.closeQuietly(inputStream);
            this.zzf = null;
        } else {
            this.zzb.zzd();
        }
        if (z) {
            zzh();
        }
    }

    public final long zzk() {
        return this.zzn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long zzl() {
        if (this.zzi != null) {
            AtomicLong atomicLong = this.zzp;
            if (atomicLong.get() != -1) {
                return atomicLong.get();
            }
            synchronized (this) {
                if (this.zzo == null) {
                    this.zzo = zzbzk.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzcdf
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return Long.valueOf(com.google.android.gms.ads.internal.zzv.zzc().zza(this.zza.zzi));
                        }
                    });
                }
            }
            if (this.zzo.isDone()) {
                try {
                    this.zzp.compareAndSet(-1L, ((Long) this.zzo.get()).longValue());
                    return this.zzp.get();
                } catch (InterruptedException | ExecutionException unused) {
                }
            }
        }
        return -1L;
    }

    public final boolean zzn() {
        return this.zzj;
    }

    public final boolean zzo() {
        return this.zzm;
    }

    public final boolean zzp() {
        return this.zzl;
    }

    public final boolean zzq() {
        return this.zzk;
    }
}
