package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcca implements zzge {
    private final Context zza;
    private final zzge zzb;
    private final String zzc;
    private final int zzd;
    private final boolean zze;
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzbas zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private zzgj zzl;

    public zzcca(Context context, zzge zzgeVar, String str, int i, zzhe zzheVar, zzcbz zzcbzVar) {
        this.zza = context;
        this.zzb = zzgeVar;
        this.zzc = str;
        this.zzd = i;
        new AtomicLong(-1L);
        this.zze = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcc)).booleanValue();
    }

    private final boolean zzg() {
        if (!this.zze) {
            return false;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeA)).booleanValue() || this.zzj) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeB)).booleanValue() && !this.zzk;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        }
        InputStream inputStream = this.zzf;
        return inputStream != null ? inputStream.read(bArr, i, i2) : this.zzb.zza(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long zzb(zzgj zzgjVar) throws IOException {
        Long l;
        if (this.zzg) {
            throw new IOException("Attempt to open an already open CacheDataSource.");
        }
        this.zzg = true;
        Uri uri = zzgjVar.zza;
        this.zzh = uri;
        this.zzl = zzgjVar;
        this.zzi = zzbas.zza(uri);
        zzbap zzbapVarZzb = null;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzex)).booleanValue()) {
            if (this.zzi != null) {
                this.zzi.zzh = zzgjVar.zze;
                this.zzi.zzi = zzfun.zzc(this.zzc);
                this.zzi.zzj = this.zzd;
                zzbapVarZzb = com.google.android.gms.ads.internal.zzv.zzc().zzb(this.zzi);
            }
            if (zzbapVarZzb != null && zzbapVarZzb.zze()) {
                this.zzj = zzbapVarZzb.zzg();
                this.zzk = zzbapVarZzb.zzf();
                if (!zzg()) {
                    this.zzf = zzbapVarZzb.zzc();
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
            com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime();
            com.google.android.gms.ads.internal.zzv.zzd();
            Future futureZza = zzbbd.zza(this.zza, this.zzi);
            try {
                try {
                    zzbbe zzbbeVar = (zzbbe) futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                    zzbbeVar.zzd();
                    this.zzj = zzbbeVar.zzf();
                    this.zzk = zzbbeVar.zze();
                    zzbbeVar.zza();
                    if (!zzg()) {
                        this.zzf = zzbbeVar.zzc();
                    }
                } catch (InterruptedException unused) {
                    futureZza.cancel(false);
                    Thread.currentThread().interrupt();
                } catch (ExecutionException | TimeoutException unused2) {
                    futureZza.cancel(false);
                }
            } catch (Throwable unused3) {
            }
            com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime();
            throw null;
        }
        if (this.zzi != null) {
            zzgh zzghVarZza = zzgjVar.zza();
            zzghVarZza.zzd(Uri.parse(this.zzi.zza));
            this.zzl = zzghVarZza.zze();
        }
        return this.zzb.zzb(this.zzl);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final Uri zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd() throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to close an already closed CacheDataSource.");
        }
        this.zzg = false;
        this.zzh = null;
        InputStream inputStream = this.zzf;
        if (inputStream == null) {
            this.zzb.zzd();
        } else {
            IOUtils.closeQuietly(inputStream);
            this.zzf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzf(zzhe zzheVar) {
    }
}
