package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzapj implements Comparable {
    private final zzapu zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    private final zzapn zzf;
    private Integer zzg;
    private zzapm zzh;
    private boolean zzi;
    private zzaos zzj;
    private zzapi zzk;
    private final zzaox zzl;

    public zzapj(int i, String str, zzapn zzapnVar) {
        Uri uri;
        String host;
        this.zza = zzapu.zza ? new zzapu() : null;
        this.zze = new Object();
        int iHashCode = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i;
        this.zzc = str;
        this.zzf = zzapnVar;
        this.zzl = new zzaox();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.zzd = iHashCode;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzapj) obj).zzg.intValue();
    }

    public final String toString() {
        String strValueOf = String.valueOf(Integer.toHexString(this.zzd));
        zzw();
        return "[ ] " + this.zzc + " " + "0x".concat(strValueOf) + " NORMAL " + this.zzg;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzl.zzb();
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzaos zzd() {
        return this.zzj;
    }

    public final zzapj zze(zzaos zzaosVar) {
        this.zzj = zzaosVar;
        return this;
    }

    public final zzapj zzf(zzapm zzapmVar) {
        this.zzh = zzapmVar;
        return this;
    }

    public final zzapj zzg(int i) {
        this.zzg = Integer.valueOf(i);
        return this;
    }

    protected abstract zzapp zzh(zzapf zzapfVar);

    public final String zzj() {
        int i = this.zzb;
        String str = this.zzc;
        if (i == 0) {
            return str;
        }
        return Integer.toString(1) + "-" + str;
    }

    public final String zzk() {
        return this.zzc;
    }

    public Map zzl() throws zzaor {
        return Collections.emptyMap();
    }

    public final void zzm(String str) {
        if (zzapu.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzn(zzaps zzapsVar) {
        zzapn zzapnVar;
        synchronized (this.zze) {
            zzapnVar = this.zzf;
        }
        zzapnVar.zza(zzapsVar);
    }

    protected abstract void zzo(Object obj);

    final void zzp(String str) {
        zzapm zzapmVar = this.zzh;
        if (zzapmVar != null) {
            zzapmVar.zzb(this);
        }
        if (zzapu.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzaph(this, str, id));
                return;
            }
            zzapu zzapuVar = this.zza;
            zzapuVar.zza(str, id);
            zzapuVar.zzb(toString());
        }
    }

    public final void zzq() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    final void zzr() {
        zzapi zzapiVar;
        synchronized (this.zze) {
            zzapiVar = this.zzk;
        }
        if (zzapiVar != null) {
            zzapiVar.zza(this);
        }
    }

    final void zzs(zzapp zzappVar) {
        zzapi zzapiVar;
        synchronized (this.zze) {
            zzapiVar = this.zzk;
        }
        if (zzapiVar != null) {
            zzapiVar.zzb(this, zzappVar);
        }
    }

    final void zzt(int i) {
        zzapm zzapmVar = this.zzh;
        if (zzapmVar != null) {
            zzapmVar.zzc(this, i);
        }
    }

    final void zzu(zzapi zzapiVar) {
        synchronized (this.zze) {
            this.zzk = zzapiVar;
        }
    }

    public final boolean zzv() {
        boolean z;
        synchronized (this.zze) {
            z = this.zzi;
        }
        return z;
    }

    public final boolean zzw() {
        synchronized (this.zze) {
        }
        return false;
    }

    public byte[] zzx() throws zzaor {
        return null;
    }

    public final zzaox zzy() {
        return this.zzl;
    }
}
