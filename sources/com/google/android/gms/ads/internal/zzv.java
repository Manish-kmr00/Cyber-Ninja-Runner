package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.ads.internal.overlay.zzad;
import com.google.android.gms.ads.internal.overlay.zzae;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.zzaa;
import com.google.android.gms.ads.internal.util.zzab;
import com.google.android.gms.ads.internal.util.zzay;
import com.google.android.gms.ads.internal.util.zzbt;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zzci;
import com.google.android.gms.ads.internal.util.zzx;
import com.google.android.gms.ads.internal.util.zzy;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbco;
import com.google.android.gms.internal.ads.zzbdh;
import com.google.android.gms.internal.ads.zzbnr;
import com.google.android.gms.internal.ads.zzbot;
import com.google.android.gms.internal.ads.zzbvf;
import com.google.android.gms.internal.ads.zzbxw;
import com.google.android.gms.internal.ads.zzbza;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzcey;
import com.google.android.gms.internal.ads.zzebu;
import com.google.android.gms.internal.ads.zzebv;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzv {
    private static final zzv zza = new zzv();
    private final zzbxw zzA;
    private final zzci zzB;
    private final zzccl zzC;
    private final zzbzx zzD;
    private final com.google.android.gms.ads.internal.overlay.zza zzb;
    private final com.google.android.gms.ads.internal.overlay.zzn zzc;
    private final com.google.android.gms.ads.internal.util.zzs zzd;
    private final zzcey zze;
    private final zzaa zzf;
    private final zzazb zzg;
    private final zzbza zzh;
    private final zzab zzi;
    private final zzbao zzj;
    private final Clock zzk;
    private final zzf zzl;
    private final zzbco zzm;
    private final zzbdh zzn;
    private final zzay zzo;
    private final zzbvf zzp;
    private final zzbzq zzq;
    private final zzbnr zzr;
    private final zzz zzs;
    private final zzbt zzt;
    private final zzad zzu;
    private final zzae zzv;
    private final zzbot zzw;
    private final zzbu zzx;
    private final zzebv zzy;
    private final zzbbd zzz;

    protected zzv() {
        com.google.android.gms.ads.internal.overlay.zza zzaVar = new com.google.android.gms.ads.internal.overlay.zza();
        com.google.android.gms.ads.internal.overlay.zzn zznVar = new com.google.android.gms.ads.internal.overlay.zzn();
        com.google.android.gms.ads.internal.util.zzs zzsVar = new com.google.android.gms.ads.internal.util.zzs();
        zzcey zzceyVar = new zzcey();
        int i = Build.VERSION.SDK_INT;
        zzaa zzyVar = i >= 30 ? new zzy() : i >= 28 ? new zzx() : i >= 26 ? new com.google.android.gms.ads.internal.util.zzv() : new com.google.android.gms.ads.internal.util.zzu();
        zzazb zzazbVar = new zzazb();
        zzbza zzbzaVar = new zzbza();
        zzab zzabVar = new zzab();
        zzbao zzbaoVar = new zzbao();
        Clock defaultClock = DefaultClock.getInstance();
        zzf zzfVar = new zzf();
        zzbco zzbcoVar = new zzbco();
        zzbdh zzbdhVar = new zzbdh();
        zzay zzayVar = new zzay();
        zzbvf zzbvfVar = new zzbvf();
        zzbzq zzbzqVar = new zzbzq();
        zzbnr zzbnrVar = new zzbnr();
        zzz zzzVar = new zzz();
        zzbt zzbtVar = new zzbt();
        zzad zzadVar = new zzad();
        zzae zzaeVar = new zzae();
        zzbot zzbotVar = new zzbot();
        zzbu zzbuVar = new zzbu();
        zzebu zzebuVar = new zzebu();
        zzbbd zzbbdVar = new zzbbd();
        zzbxw zzbxwVar = new zzbxw();
        zzci zzciVar = new zzci();
        zzccl zzcclVar = new zzccl();
        zzbzx zzbzxVar = new zzbzx();
        this.zzb = zzaVar;
        this.zzc = zznVar;
        this.zzd = zzsVar;
        this.zze = zzceyVar;
        this.zzf = zzyVar;
        this.zzg = zzazbVar;
        this.zzh = zzbzaVar;
        this.zzi = zzabVar;
        this.zzj = zzbaoVar;
        this.zzk = defaultClock;
        this.zzl = zzfVar;
        this.zzm = zzbcoVar;
        this.zzn = zzbdhVar;
        this.zzo = zzayVar;
        this.zzp = zzbvfVar;
        this.zzq = zzbzqVar;
        this.zzr = zzbnrVar;
        this.zzt = zzbtVar;
        this.zzs = zzzVar;
        this.zzu = zzadVar;
        this.zzv = zzaeVar;
        this.zzw = zzbotVar;
        this.zzx = zzbuVar;
        this.zzy = zzebuVar;
        this.zzz = zzbbdVar;
        this.zzA = zzbxwVar;
        this.zzB = zzciVar;
        this.zzC = zzcclVar;
        this.zzD = zzbzxVar;
    }

    public static zzcey zzA() {
        return zza.zze;
    }

    public static zzebv zzB() {
        return zza.zzy;
    }

    public static Clock zzC() {
        return zza.zzk;
    }

    public static zzf zza() {
        return zza.zzl;
    }

    public static zzazb zzb() {
        return zza.zzg;
    }

    public static zzbao zzc() {
        return zza.zzj;
    }

    public static zzbbd zzd() {
        return zza.zzz;
    }

    public static zzbco zze() {
        return zza.zzm;
    }

    public static zzbdh zzf() {
        return zza.zzn;
    }

    public static zzbnr zzg() {
        return zza.zzr;
    }

    public static zzbot zzh() {
        return zza.zzw;
    }

    public static com.google.android.gms.ads.internal.overlay.zza zzi() {
        return zza.zzb;
    }

    public static com.google.android.gms.ads.internal.overlay.zzn zzj() {
        return zza.zzc;
    }

    public static zzz zzk() {
        return zza.zzs;
    }

    public static zzad zzl() {
        return zza.zzu;
    }

    public static zzae zzm() {
        return zza.zzv;
    }

    public static zzbvf zzn() {
        return zza.zzp;
    }

    public static zzbxw zzo() {
        return zza.zzA;
    }

    public static zzbza zzp() {
        return zza.zzh;
    }

    public static com.google.android.gms.ads.internal.util.zzs zzq() {
        return zza.zzd;
    }

    public static zzaa zzr() {
        return zza.zzf;
    }

    public static zzab zzs() {
        return zza.zzi;
    }

    public static zzay zzt() {
        return zza.zzo;
    }

    public static zzbt zzu() {
        return zza.zzt;
    }

    public static zzbu zzv() {
        return zza.zzx;
    }

    public static zzci zzw() {
        return zza.zzB;
    }

    public static zzbzq zzx() {
        return zza.zzq;
    }

    public static zzbzx zzy() {
        return zza.zzD;
    }

    public static zzccl zzz() {
        return zza.zzC;
    }
}
