package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.HashSet;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzbq {
    private int zza;
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private zzfww zzi;
    private zzfww zzj;
    private zzfww zzk;
    private int zzl;
    private int zzm;
    private zzfww zzn;
    private zzbp zzo;
    private zzfww zzp;
    private boolean zzq;
    private HashMap zzr;
    private HashSet zzs;

    public zzbq() {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = Integer.MAX_VALUE;
        this.zzf = Integer.MAX_VALUE;
        this.zzg = true;
        this.zzh = true;
        this.zzi = zzfww.zzn();
        this.zzj = zzfww.zzn();
        this.zzk = zzfww.zzn();
        this.zzl = Integer.MAX_VALUE;
        this.zzm = Integer.MAX_VALUE;
        this.zzn = zzfww.zzn();
        this.zzo = zzbp.zza;
        this.zzp = zzfww.zzn();
        this.zzq = true;
        this.zzr = new HashMap();
        this.zzs = new HashSet();
    }

    @EnsuresNonNull({"preferredVideoMimeTypes", "preferredVideoLanguages", "preferredAudioLanguages", "preferredAudioMimeTypes", "audioOffloadPreferences", "preferredTextLanguages", "overrides", "disabledTrackTypes"})
    private final void zzu(zzbr zzbrVar) {
        this.zza = zzbrVar.zza;
        this.zzb = zzbrVar.zzb;
        this.zzc = zzbrVar.zzc;
        this.zzd = zzbrVar.zzd;
        int i = zzbrVar.zze;
        int i2 = zzbrVar.zzf;
        int i3 = zzbrVar.zzg;
        int i4 = zzbrVar.zzh;
        this.zze = zzbrVar.zzi;
        this.zzf = zzbrVar.zzj;
        this.zzg = zzbrVar.zzk;
        this.zzh = zzbrVar.zzl;
        this.zzi = zzbrVar.zzm;
        this.zzj = zzbrVar.zzn;
        int i5 = zzbrVar.zzo;
        this.zzk = zzbrVar.zzp;
        int i6 = zzbrVar.zzq;
        this.zzl = zzbrVar.zzr;
        this.zzm = zzbrVar.zzs;
        this.zzn = zzbrVar.zzt;
        this.zzo = zzbrVar.zzu;
        this.zzp = zzbrVar.zzv;
        int i7 = zzbrVar.zzw;
        this.zzq = zzbrVar.zzx;
        int i8 = zzbrVar.zzy;
        boolean z = zzbrVar.zzz;
        boolean z2 = zzbrVar.zzA;
        boolean z3 = zzbrVar.zzB;
        boolean z4 = zzbrVar.zzC;
        this.zzs = new HashSet(zzbrVar.zzE);
        this.zzr = new HashMap(zzbrVar.zzD);
    }

    protected final zzbq zzj(zzbr zzbrVar) {
        zzu(zzbrVar);
        return this;
    }

    protected zzbq(zzbr zzbrVar) {
        zzu(zzbrVar);
    }
}
