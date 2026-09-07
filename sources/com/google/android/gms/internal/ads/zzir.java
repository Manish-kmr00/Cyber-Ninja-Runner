package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzir {
    final Context zza;
    zzdg zzb;
    zzfuo zzc;
    zzfuo zzd;
    zzfuo zze;
    zzfuo zzf;
    zzfuo zzg;
    zzftl zzh;
    Looper zzi;
    int zzj;
    zze zzk;
    int zzl;
    boolean zzm;
    zzma zzn;
    long zzo;
    long zzp;
    boolean zzq;
    boolean zzr;
    String zzs;
    zzib zzt;

    public zzir(final Context context, zzcdr zzcdrVar) {
        zzik zzikVar = new zzik(zzcdrVar);
        zzil zzilVar = new zzil(context);
        zzfuo zzfuoVar = new zzfuo() { // from class: com.google.android.gms.internal.ads.zzim
            @Override // com.google.android.gms.internal.ads.zzfuo
            public final Object zza() {
                return new zzyn(context);
            }
        };
        zzfuo zzfuoVar2 = new zzfuo() { // from class: com.google.android.gms.internal.ads.zzin
            @Override // com.google.android.gms.internal.ads.zzfuo
            public final Object zza() {
                return new zzie();
            }
        };
        zzio zzioVar = new zzio(context);
        zzftl zzftlVar = new zzftl() { // from class: com.google.android.gms.internal.ads.zzip
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                return new zzol((zzdg) obj);
            }
        };
        context.getClass();
        this.zza = context;
        this.zzc = zzikVar;
        this.zzd = zzilVar;
        this.zze = zzfuoVar;
        this.zzf = zzfuoVar2;
        this.zzg = zzioVar;
        this.zzh = zzftlVar;
        this.zzi = zzeu.zzz();
        this.zzk = zze.zza;
        this.zzl = 1;
        this.zzm = true;
        this.zzn = zzma.zzb;
        this.zzt = new zzib(0.97f, 1.03f, 1000L, 1.0E-7f, zzeu.zzs(20L), zzeu.zzs(500L), 0.999f, null);
        this.zzb = zzdg.zza;
        this.zzo = 500L;
        this.zzp = 2000L;
        this.zzq = true;
        this.zzs = "";
        this.zzj = -1000;
        if (zzeu.zza >= 35) {
            int i = zzih.zza;
        }
    }

    static /* synthetic */ zzux zza(Context context) {
        return new zzul(context, new zzacw());
    }
}
