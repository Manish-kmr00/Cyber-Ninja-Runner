package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import com.json.b9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzka extends zzg implements zzit {
    public static final /* synthetic */ int zzd = 0;
    private final zzdf zzA;
    private int zzB;
    private int zzC;
    private boolean zzD;
    private zzma zzE;
    private zzis zzF;
    private zzbd zzG;
    private zzat zzH;
    private Object zzI;
    private Surface zzJ;
    private int zzK;
    private zzel zzL;
    private zze zzM;
    private float zzN;
    private boolean zzO;
    private boolean zzP;
    private boolean zzQ;
    private int zzR;
    private zzat zzS;
    private zzlm zzT;
    private int zzU;
    private long zzV;
    private final zzje zzW;
    private zzwv zzX;
    final zzyw zzb;
    final zzbd zzc;
    private final zzdj zze = new zzdj(zzdg.zza);
    private final Context zzf;
    private final zzbh zzg;
    private final zzlu[] zzh;
    private final zzlu[] zzi;
    private final zzyv zzj;
    private final zzdq zzk;
    private final zzkn zzl;
    private final zzdw zzm;
    private final CopyOnWriteArraySet zzn;
    private final zzbj zzo;
    private final List zzp;
    private final boolean zzq;
    private final zzmg zzr;
    private final Looper zzs;
    private final zzzd zzt;
    private final zzdg zzu;
    private final zzjw zzv;
    private final zzjx zzw;
    private final zzme zzx;
    private final zzmf zzy;
    private final long zzz;

    static {
        zzaq.zzb("media3.exoplayer");
    }

    /* JADX WARN: Failed to calculate best type for var: r33v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r33v0 'this'  ??, new type: com.google.android.gms.internal.ads.zzka
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r33v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r33v0 'this'  ??, new type: com.google.android.gms.internal.ads.zzka
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r33v0 'this'  com.google.android.gms.internal.ads.zzka, new type: com.google.android.gms.internal.ads.zzka
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 5 more
     */
    public zzka(zzir zzirVar, zzbh zzbhVar) {
        zzir zzirVar2;
        try {
            zzdx.zze("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.6.0] [" + zzeu.zzb + b9.i.e);
            this.zzf = zzirVar.zza.getApplicationContext();
            this.zzr = (zzmg) zzirVar.zzh.apply(zzirVar.zzb);
            this.zzR = zzirVar.zzj;
            this.zzM = zzirVar.zzk;
            this.zzK = zzirVar.zzl;
            this.zzO = false;
            this.zzz = zzirVar.zzp;
            zzjz zzjzVar = null;
            zzjw zzjwVar = new zzjw(this, zzjzVar);
            this.zzv = zzjwVar;
            this.zzw = new zzjx(zzjzVar);
            Handler handler = new Handler(zzirVar.zzi);
            zzcdr zzcdrVar = ((zzik) zzirVar.zzc).zza;
            zzlu[] zzluVarArrZzac = zzcdt.zzac(zzcdrVar.zza, handler, zzjwVar, zzjwVar, zzjwVar, zzjwVar);
            this.zzh = zzluVarArrZzac;
            int length = zzluVarArrZzac.length;
            this.zzi = new zzlu[2];
            int i = 0;
            while (true) {
                zzlu[] zzluVarArr = this.zzi;
                int length2 = zzluVarArr.length;
                if (i >= 2) {
                    break;
                }
                zzlu zzluVar = this.zzh[i];
                zzluVarArr[i] = null;
                i++;
            }
            zzyv zzyvVar = (zzyv) zzirVar.zze.zza();
            this.zzj = zzyvVar;
            zzir.zza(((zzil) zzirVar.zzd).zza);
            zzzh zzzhVarZzh = zzzh.zzh(((zzio) zzirVar.zzg).zza);
            this.zzt = zzzhVarZzh;
            this.zzq = zzirVar.zzm;
            this.zzE = zzirVar.zzn;
            Looper looper = zzirVar.zzi;
            this.zzs = looper;
            zzdg zzdgVar = zzirVar.zzb;
            this.zzu = zzdgVar;
            this.zzg = zzbhVar;
            zzdw zzdwVar = new zzdw(looper, zzdgVar, new zzdu(this) { // from class: com.google.android.gms.internal.ads.zzjd
                @Override // com.google.android.gms.internal.ads.zzdu
                public final void zza(Object obj, zzv zzvVar) {
                }
            });
            this.zzm = zzdwVar;
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzn = copyOnWriteArraySet;
            this.zzp = new ArrayList();
            this.zzX = new zzwv(0);
            this.zzF = zzis.zza;
            int length3 = this.zzh.length;
            zzyw zzywVar = new zzyw(new zzly[2], new zzyp[2], zzbt.zza, null);
            this.zzb = zzywVar;
            this.zzo = new zzbj();
            zzbc zzbcVar = new zzbc();
            zzbcVar.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            zzyvVar.zzn();
            zzbcVar.zzd(29, true);
            zzbcVar.zzd(23, false);
            zzbcVar.zzd(25, false);
            zzbcVar.zzd(33, false);
            zzbcVar.zzd(26, false);
            zzbcVar.zzd(34, false);
            zzbd zzbdVarZze = zzbcVar.zze();
            this.zzc = zzbdVarZze;
            zzbc zzbcVar2 = new zzbc();
            zzbcVar2.zzb(zzbdVarZze);
            zzbcVar2.zza(4);
            zzbcVar2.zza(10);
            this.zzG = zzbcVar2.zze();
            this.zzk = zzdgVar.zzd(looper, null);
            zzje zzjeVar = new zzje(this);
            this.zzW = zzjeVar;
            this.zzT = zzlm.zzh(zzywVar);
            this.zzr.zzT(zzbhVar, looper);
            final zzoz zzozVar = new zzoz(zzirVar.zzs);
            zzkn zzknVar = new zzkn(this.zzf, this.zzh, this.zzi, zzyvVar, zzywVar, (zzkr) zzirVar.zzf.zza(), zzzhVarZzh, 0, false, this.zzr, this.zzE, zzirVar.zzt, zzirVar.zzo, false, false, looper, zzdgVar, zzjeVar, zzozVar, null, this.zzF);
            this.zzl = zzknVar;
            Looper looperZze = zzknVar.zze();
            this.zzN = 1.0f;
            this.zzH = zzat.zza;
            this.zzS = zzat.zza;
            this.zzU = -1;
            int i2 = zzcv.zza;
            this.zzP = true;
            zzmg zzmgVar = this.zzr;
            if (zzmgVar == null) {
                throw null;
            }
            zzdwVar.zzb(zzmgVar);
            zzzhVarZzh.zzf(new Handler(looper), this.zzr);
            copyOnWriteArraySet.add(this.zzv);
            if (zzeu.zza >= 31) {
                final Context context = this.zzf;
                zzirVar2 = zzirVar;
                final boolean z = zzirVar2.zzq;
                zzdgVar.zzd(zzknVar.zze(), null).zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjs
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzov zzovVarZzb = zzov.zzb(context);
                        if (zzovVarZzb == null) {
                            zzdx.zzf("ExoPlayerImpl", "MediaMetricsService unavailable.");
                            return;
                        }
                        if (z) {
                            this.zzz(zzovVarZzb);
                        }
                        zzozVar.zzb(zzovVarZzb.zza());
                    }
                });
            } else {
                zzirVar2 = zzirVar;
            }
            zzdf zzdfVar = new zzdf(0, looperZze, looper, zzdgVar, new zzjf(this));
            this.zzA = zzdfVar;
            zzdfVar.zzb(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjg
                @Override // java.lang.Runnable
                public final void run() {
                    zzka.zzI(this.zza);
                }
            });
            new zzhs(zzirVar2.zza, looperZze, zzirVar2.zzi, this.zzv, zzdgVar);
            this.zzx = new zzme(zzirVar2.zza, looperZze, zzdgVar);
            this.zzy = new zzmf(zzirVar2.zza, looperZze, zzdgVar);
            int i3 = zzo.zza;
            zzcd zzcdVar = zzcd.zza;
            this.zzL = zzel.zza;
            zzknVar.zzq(this.zzM, false);
            zzac(r0, 3, this.zzM);
            zzac(2, 4, Integer.valueOf(this.zzK));
            zzac(2, 5, 0);
            zzac(1, 9, Boolean.valueOf(this.zzO));
            zzac(2, 7, this.zzw);
            zzac(6, 8, this.zzw);
            zzac(-1, 16, Integer.valueOf(this.zzR));
            this.zze.zze();
        } catch (Throwable th) {
            this.zze.zze();
            throw th;
        }
    }

    public static /* synthetic */ void zzI(zzka zzkaVar) {
        int i = zzeu.zza;
        zzkaVar.zzA.zzc(Integer.valueOf(zzcj.zzc(zzkaVar.zzf).generateAudioSessionId()));
    }

    public static /* synthetic */ void zzJ(zzka zzkaVar, zzkk zzkkVar) {
        boolean z;
        long j;
        int i = zzkaVar.zzB - zzkkVar.zzb;
        zzkaVar.zzB = i;
        boolean z2 = true;
        if (zzkkVar.zzc) {
            zzkaVar.zzC = zzkkVar.zzd;
            zzkaVar.zzD = true;
        }
        if (i == 0) {
            zzbl zzblVar = zzkkVar.zza.zza;
            if (!zzkaVar.zzT.zza.zzo() && zzblVar.zzo()) {
                zzkaVar.zzU = -1;
                zzkaVar.zzV = 0L;
            }
            if (!zzblVar.zzo()) {
                List listZzw = ((zzls) zzblVar).zzw();
                int size = listZzw.size();
                List list = zzkaVar.zzp;
                zzdc.zzf(size == list.size());
                for (int i2 = 0; i2 < listZzw.size(); i2++) {
                    ((zzjy) list.get(i2)).zzc((zzbl) listZzw.get(i2));
                }
            }
            long j2 = -9223372036854775807L;
            if (zzkaVar.zzD) {
                if (zzkkVar.zza.zzb.equals(zzkaVar.zzT.zzb) && zzkkVar.zza.zzd == zzkaVar.zzT.zzs) {
                    z2 = false;
                }
                if (z2) {
                    if (zzblVar.zzo() || zzkkVar.zza.zzb.zzb()) {
                        j = zzkkVar.zza.zzd;
                    } else {
                        zzlm zzlmVar = zzkkVar.zza;
                        zzuy zzuyVar = zzlmVar.zzb;
                        j = zzlmVar.zzd;
                        zzkaVar.zzV(zzblVar, zzuyVar, j);
                    }
                    z = z2;
                    j2 = j;
                } else {
                    z = z2;
                }
            } else {
                z = false;
            }
            zzkaVar.zzD = false;
            zzkaVar.zzaf(zzkkVar.zza, 1, z, zzkaVar.zzC, j2, -1, false);
        }
    }

    public static /* synthetic */ void zzK(zzka zzkaVar, int i, final int i2) {
        zzkaVar.zzah();
        Integer numValueOf = Integer.valueOf(i2);
        zzkaVar.zzac(1, 10, numValueOf);
        zzkaVar.zzac(2, 10, numValueOf);
        zzdt zzdtVar = new zzdt() { // from class: com.google.android.gms.internal.ads.zzjh
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                int i3 = zzka.zzd;
                ((zzbe) obj).zza(i2);
            }
        };
        zzdw zzdwVar = zzkaVar.zzm;
        zzdwVar.zzd(21, zzdtVar);
        zzdwVar.zzc();
    }

    static /* bridge */ /* synthetic */ void zzO(zzka zzkaVar, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzkaVar.zzad(surface);
        zzkaVar.zzJ = surface;
    }

    private final int zzR(zzlm zzlmVar) {
        zzbl zzblVar = zzlmVar.zza;
        return zzblVar.zzo() ? this.zzU : zzblVar.zzn(zzlmVar.zzb.zza, this.zzo).zzc;
    }

    private final long zzS(zzlm zzlmVar) {
        zzuy zzuyVar = zzlmVar.zzb;
        if (!zzuyVar.zzb()) {
            return zzeu.zzv(zzT(zzlmVar));
        }
        zzbl zzblVar = zzlmVar.zza;
        zzblVar.zzn(zzuyVar.zza, this.zzo);
        long j = zzlmVar.zzc;
        if (j != -9223372036854775807L) {
            return zzeu.zzv(0L) + zzeu.zzv(j);
        }
        long j2 = zzblVar.zze(zzR(zzlmVar), this.zza, 0L).zzl;
        return zzeu.zzv(0L);
    }

    private final long zzT(zzlm zzlmVar) {
        zzbl zzblVar = zzlmVar.zza;
        if (zzblVar.zzo()) {
            return zzeu.zzs(this.zzV);
        }
        boolean z = zzlmVar.zzp;
        long j = zzlmVar.zzs;
        zzuy zzuyVar = zzlmVar.zzb;
        if (zzuyVar.zzb()) {
            return j;
        }
        zzV(zzblVar, zzuyVar, j);
        return j;
    }

    private static long zzU(zzlm zzlmVar) {
        zzbk zzbkVar = new zzbk();
        zzbj zzbjVar = new zzbj();
        zzbl zzblVar = zzlmVar.zza;
        zzblVar.zzn(zzlmVar.zzb.zza, zzbjVar);
        long j = zzlmVar.zzc;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = zzblVar.zze(zzbjVar.zzc, zzbkVar, 0L).zzl;
        return 0L;
    }

    private final long zzV(zzbl zzblVar, zzuy zzuyVar, long j) {
        zzblVar.zzn(zzuyVar.zza, this.zzo);
        return j;
    }

    private final Pair zzW(zzbl zzblVar, int i, long j) {
        if (zzblVar.zzo()) {
            this.zzU = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.zzV = j;
            return null;
        }
        if (i == -1 || i >= zzblVar.zzc()) {
            i = zzblVar.zzg(false);
            long j2 = zzblVar.zze(i, this.zza, 0L).zzl;
            j = zzeu.zzv(0L);
        }
        return zzblVar.zzl(this.zza, this.zzo, i, zzeu.zzs(j));
    }

    private static zzlm zzX(zzlm zzlmVar, int i) {
        zzlm zzlmVarZzf = zzlmVar.zzf(i);
        return (i == 1 || i == 4) ? zzlmVarZzf.zza(false) : zzlmVarZzf;
    }

    private final zzlm zzY(zzlm zzlmVar, zzbl zzblVar, Pair pair) {
        zzdc.zzd(zzblVar.zzo() || pair != null);
        zzbl zzblVar2 = zzlmVar.zza;
        long jZzS = zzS(zzlmVar);
        zzlm zzlmVarZzg = zzlmVar.zzg(zzblVar);
        if (zzblVar.zzo()) {
            zzuy zzuyVarZzi = zzlm.zzi();
            long jZzs = zzeu.zzs(this.zzV);
            zzlm zzlmVarZzb = zzlmVarZzg.zzc(zzuyVarZzi, jZzs, jZzs, jZzs, 0L, zzxd.zza, this.zzb, zzfww.zzn()).zzb(zzuyVarZzi);
            zzlmVarZzb.zzq = zzlmVarZzb.zzs;
            return zzlmVarZzb;
        }
        zzuy zzuyVar = zzlmVarZzg.zzb;
        Object obj = zzuyVar.zza;
        int i = zzeu.zza;
        boolean zEquals = obj.equals(pair.first);
        zzuy zzuyVar2 = !zEquals ? new zzuy(pair.first, -1L) : zzuyVar;
        long jLongValue = ((Long) pair.second).longValue();
        long jZzs2 = zzeu.zzs(jZzS);
        if (!zzblVar2.zzo()) {
            zzblVar2.zzn(obj, this.zzo);
        }
        if (!zEquals || jLongValue < jZzs2) {
            zzuy zzuyVar3 = zzuyVar2;
            zzdc.zzf(!zzuyVar3.zzb());
            zzlm zzlmVarZzb2 = zzlmVarZzg.zzc(zzuyVar3, jLongValue, jLongValue, jLongValue, 0L, !zEquals ? zzxd.zza : zzlmVarZzg.zzh, !zEquals ? this.zzb : zzlmVarZzg.zzi, !zEquals ? zzfww.zzn() : zzlmVarZzg.zzj).zzb(zzuyVar3);
            zzlmVarZzb2.zzq = jLongValue;
            return zzlmVarZzb2;
        }
        if (jLongValue != jZzs2) {
            zzuy zzuyVar4 = zzuyVar2;
            zzdc.zzf(!zzuyVar4.zzb());
            long jMax = Math.max(0L, zzlmVarZzg.zzr - (jLongValue - jZzs2));
            long j = zzlmVarZzg.zzq;
            if (zzlmVarZzg.zzk.equals(zzuyVar)) {
                j = jLongValue + jMax;
            }
            zzlm zzlmVarZzc = zzlmVarZzg.zzc(zzuyVar4, jLongValue, jLongValue, jLongValue, jMax, zzlmVarZzg.zzh, zzlmVarZzg.zzi, zzlmVarZzg.zzj);
            zzlmVarZzc.zzq = j;
            return zzlmVarZzc;
        }
        int iZza = zzblVar.zza(zzlmVarZzg.zzk.zza);
        if (iZza != -1) {
            zzbj zzbjVar = this.zzo;
            if (zzblVar.zzd(iZza, zzbjVar, false).zzc == zzblVar.zzn(zzuyVar2.zza, zzbjVar).zzc) {
                return zzlmVarZzg;
            }
        }
        Object obj2 = zzuyVar2.zza;
        zzbj zzbjVar2 = this.zzo;
        zzblVar.zzn(obj2, zzbjVar2);
        long jZzf = zzuyVar2.zzb() ? zzbjVar2.zzf(zzuyVar2.zzb, zzuyVar2.zzc) : zzbjVar2.zzd;
        zzlm zzlmVarZzb3 = zzlmVarZzg.zzc(zzuyVar2, zzlmVarZzg.zzs, zzlmVarZzg.zzs, zzlmVarZzg.zzd, jZzf - zzlmVarZzg.zzs, zzlmVarZzg.zzh, zzlmVarZzg.zzi, zzlmVarZzg.zzj).zzb(zzuyVar2);
        zzlmVarZzb3.zzq = jZzf;
        return zzlmVarZzb3;
    }

    private final zzlq zzZ(zzlp zzlpVar) {
        int iZzR = zzR(this.zzT);
        zzbl zzblVar = this.zzT.zza;
        if (iZzR == -1) {
            iZzR = 0;
        }
        zzdg zzdgVar = this.zzu;
        zzkn zzknVar = this.zzl;
        return new zzlq(zzknVar, zzlpVar, zzblVar, iZzR, zzdgVar, zzknVar.zze());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ void zzaa(final zzkk zzkkVar) {
        this.zzk.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjj
            @Override // java.lang.Runnable
            public final void run() {
                zzka.zzJ(this.zza, zzkkVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzab(final int i, final int i2) {
        if (i == this.zzL.zzb() && i2 == this.zzL.zza()) {
            return;
        }
        this.zzL = new zzel(i, i2);
        zzdw zzdwVar = this.zzm;
        zzdwVar.zzd(24, new zzdt() { // from class: com.google.android.gms.internal.ads.zzja
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                int i3 = zzka.zzd;
                ((zzbe) obj).zzp(i, i2);
            }
        });
        zzdwVar.zzc();
        zzac(2, 14, new zzel(i, i2));
    }

    private final void zzac(int i, int i2, Object obj) {
        zzlu[] zzluVarArr = this.zzh;
        int length = zzluVarArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            zzlu zzluVar = zzluVarArr[i3];
            if (i == -1 || zzluVar.zzb() == i) {
                zzlq zzlqVarZzZ = zzZ(zzluVar);
                zzlqVarZzZ.zzf(i2);
                zzlqVarZzZ.zze(obj);
                zzlqVarZzZ.zzd();
            }
        }
        zzlu[] zzluVarArr2 = this.zzi;
        int length2 = zzluVarArr2.length;
        for (int i4 = 0; i4 < 2; i4++) {
            zzlu zzluVar2 = zzluVarArr2[i4];
            if (zzluVar2 != null && (i == -1 || zzluVar2.zzb() == i)) {
                zzlq zzlqVarZzZ2 = zzZ(zzluVar2);
                zzlqVarZzZ2.zzf(i2);
                zzlqVarZzZ2.zze(obj);
                zzlqVarZzZ2.zzd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzad(Object obj) {
        Object obj2 = this.zzI;
        boolean z = false;
        if (obj2 != null && obj2 != obj) {
            z = true;
        }
        boolean zZzv = this.zzl.zzv(obj, z ? this.zzz : -9223372036854775807L);
        if (z) {
            Object obj3 = this.zzI;
            Surface surface = this.zzJ;
            if (obj3 == surface) {
                surface.release();
                this.zzJ = null;
            }
        }
        this.zzI = obj;
        if (zZzv) {
            return;
        }
        zzae(zzii.zzd(new zzko(3), 1003));
    }

    private final void zzae(zzii zziiVar) {
        zzlm zzlmVar = this.zzT;
        zzlm zzlmVarZzb = zzlmVar.zzb(zzlmVar.zzb);
        zzlmVarZzb.zzq = zzlmVarZzb.zzs;
        zzlmVarZzb.zzr = 0L;
        zzlm zzlmVarZzX = zzX(zzlmVarZzb, 1);
        if (zziiVar != null) {
            zzlmVarZzX = zzlmVarZzX.zze(zziiVar);
        }
        this.zzB++;
        this.zzl.zzt();
        zzaf(zzlmVarZzX, 0, false, 5, -9223372036854775807L, -1, false);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x029b  */
    /* JADX WARN: Code duplicated, block: B:103:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:105:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:107:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:108:0x02df  */
    /* JADX WARN: Code duplicated, block: B:111:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:113:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:116:0x0302  */
    /* JADX WARN: Code duplicated, block: B:118:0x0316  */
    /* JADX WARN: Code duplicated, block: B:120:0x0326  */
    /* JADX WARN: Code duplicated, block: B:123:0x0335  */
    /* JADX WARN: Code duplicated, block: B:126:0x0343  */
    /* JADX WARN: Code duplicated, block: B:131:0x0356  */
    /* JADX WARN: Code duplicated, block: B:134:0x0367  */
    /* JADX WARN: Code duplicated, block: B:137:0x037c  */
    /* JADX WARN: Code duplicated, block: B:140:0x0392  */
    /* JADX WARN: Code duplicated, block: B:143:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:145:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:146:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:150:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:151:0x03db  */
    /* JADX WARN: Code duplicated, block: B:153:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:154:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:157:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:158:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:160:0x040e  */
    /* JADX WARN: Code duplicated, block: B:163:0x0419  */
    /* JADX WARN: Code duplicated, block: B:165:0x042d  */
    /* JADX WARN: Code duplicated, block: B:166:0x042f  */
    /* JADX WARN: Code duplicated, block: B:170:0x043e  */
    /* JADX WARN: Code duplicated, block: B:173:0x044e  */
    /* JADX WARN: Code duplicated, block: B:176:0x0466 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:178:0x046a  */
    /* JADX WARN: Code duplicated, block: B:181:0x0470 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:183:0x0474  */
    /* JADX WARN: Code duplicated, block: B:186:0x047b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:191:0x0485  */
    /* JADX WARN: Code duplicated, block: B:194:0x048b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:196:0x048f  */
    /* JADX WARN: Code duplicated, block: B:199:0x0497 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:204:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:207:0x04ae A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:209:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:212:0x04ba A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:214:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:217:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:41:0x0103  */
    /* JADX WARN: Code duplicated, block: B:43:0x0109  */
    /* JADX WARN: Code duplicated, block: B:48:0x0117  */
    /* JADX WARN: Code duplicated, block: B:51:0x0126  */
    /* JADX WARN: Code duplicated, block: B:54:0x0133 A[LOOP:1: B:52:0x012d->B:54:0x0133, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:59:0x0150  */
    /* JADX WARN: Code duplicated, block: B:60:0x0153  */
    /* JADX WARN: Code duplicated, block: B:63:0x017e  */
    /* JADX WARN: Code duplicated, block: B:64:0x0180  */
    /* JADX WARN: Code duplicated, block: B:67:0x0187  */
    /* JADX WARN: Code duplicated, block: B:68:0x0189  */
    /* JADX WARN: Code duplicated, block: B:71:0x018e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0197  */
    /* JADX WARN: Code duplicated, block: B:75:0x0199  */
    /* JADX WARN: Code duplicated, block: B:77:0x019c  */
    /* JADX WARN: Code duplicated, block: B:79:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:81:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:87:0x0205  */
    /* JADX WARN: Code duplicated, block: B:89:0x020a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0211  */
    /* JADX WARN: Code duplicated, block: B:91:0x0214  */
    /* JADX WARN: Code duplicated, block: B:93:0x021c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0223  */
    /* JADX WARN: Code duplicated, block: B:98:0x024f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0280  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [com.google.android.gms.internal.ads.zzbl] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [boolean, int] */
    private final void zzaf(final zzlm zzlmVar, final int i, boolean z, int i2, long j, int i3, boolean z2) {
        zzlm zzlmVar2;
        zzbl zzblVar;
        final int i4;
        boolean z3;
        Pair pair;
        boolean z4;
        boolean z5;
        int i5;
        boolean zBooleanValue;
        final int iIntValue;
        final zzap zzapVar;
        zzlm zzlmVar3;
        zzar zzarVarZza;
        List list;
        int i6;
        zzav zzavVar;
        int i7;
        zzbl zzblVarZzo;
        zzat zzatVarZzw;
        boolean zEquals;
        boolean z6;
        boolean z7;
        boolean z8;
        zzii zziiVar;
        zzii zziiVar2;
        zzyw zzywVar;
        zzyw zzywVar2;
        zzbd zzbdVar;
        zzg zzgVar;
        zzbl zzblVarZzo2;
        zzbd zzbdVar2;
        boolean z9;
        zzbl zzblVarZzo3;
        ?? r6;
        int iZzk;
        int i8;
        boolean z10;
        ?? Zzo;
        int iZze;
        ?? r4;
        zzbl zzblVarZzo4;
        zzlm zzlmVar4;
        long j2;
        zzbl zzblVarZzo5;
        boolean z11;
        boolean zZzo;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        int i9;
        boolean z18;
        zzbd zzbdVarZze;
        zzdw zzdwVar;
        zzbj zzbjVar;
        int i10;
        Object obj;
        zzap zzapVar2;
        Object obj2;
        int i11;
        long jZzU;
        long jZzU2;
        int iZze2;
        Object obj3;
        zzap zzapVar3;
        Object obj4;
        int i12;
        long jZzv;
        long jZzv2;
        zzuy zzuyVar;
        int i13 = i2;
        zzlm zzlmVar5 = this.zzT;
        this.zzT = zzlmVar;
        zzbl zzblVar2 = zzlmVar5.zza;
        zzbl zzblVar3 = zzlmVar.zza;
        boolean zEquals2 = zzblVar2.equals(zzblVar3);
        if (!zzblVar3.zzo() || !zzblVar2.zzo()) {
            if (zzblVar3.zzo() != zzblVar2.zzo()) {
                pair = new Pair(true, 3);
            } else {
                zzuy zzuyVar2 = zzlmVar5.zzb;
                Object obj5 = zzuyVar2.zza;
                zzbj zzbjVar2 = this.zzo;
                int i14 = zzblVar2.zzn(obj5, zzbjVar2).zzc;
                zzbk zzbkVar = this.zza;
                Object obj6 = zzblVar2.zze(i14, zzbkVar, 0L).zzb;
                zzuy zzuyVar3 = zzlmVar.zzb;
                zzlmVar2 = zzlmVar5;
                zzblVar = zzblVar2;
                if (obj6.equals(zzblVar3.zze(zzblVar3.zzn(zzuyVar3.zza, zzbjVar2).zzc, zzbkVar, 0L).zzb)) {
                    if (!z) {
                        i4 = i13;
                        z3 = false;
                    } else if (i13 != 0) {
                        i4 = i13;
                        z3 = true;
                    } else if (zzuyVar2.zzd < zzuyVar3.zzd) {
                        pair = new Pair(true, 0);
                        z3 = true;
                        i4 = 0;
                    } else {
                        z3 = true;
                        i4 = 0;
                    }
                    pair = new Pair(false, -1);
                } else {
                    if (z) {
                        if (i13 == 0) {
                            i13 = 0;
                            z4 = true;
                            i5 = 1;
                        } else {
                            z4 = true;
                            z5 = true;
                        }
                        pair = new Pair(true, Integer.valueOf(i5));
                        boolean z19 = z4;
                        i4 = i13;
                        z3 = z19;
                    } else {
                        z4 = false;
                        z5 = false;
                    }
                    if (z4 && i13 == 1) {
                        z4 = z5;
                        i5 = 2;
                    } else {
                        if (zEquals2) {
                            throw new IllegalStateException();
                        }
                        i5 = 3;
                    }
                    pair = new Pair(true, Integer.valueOf(i5));
                    boolean z110 = z4;
                    i4 = i13;
                    z3 = z110;
                }
            }
            zBooleanValue = ((Boolean) pair.first).booleanValue();
            iIntValue = ((Integer) pair.second).intValue();
            if (zBooleanValue) {
                if (zzblVar3.zzo()) {
                    zzapVar = null;
                } else {
                    zzapVar = zzblVar3.zze(zzblVar3.zzn(zzlmVar.zzb.zza, this.zzo).zzc, this.zza, 0L).zzd;
                }
                this.zzS = zzat.zza;
            } else {
                zzapVar = null;
            }
            zzlmVar3 = zzlmVar2;
            if (zBooleanValue || !zzlmVar3.zzj.equals(zzlmVar.zzj)) {
                zzarVarZza = this.zzS.zza();
                list = zzlmVar.zzj;
                for (i6 = 0; i6 < list.size(); i6++) {
                    zzavVar = (zzav) list.get(i6);
                    for (i7 = 0; i7 < zzavVar.zza(); i7++) {
                        zzavVar.zzb(i7).zza(zzarVarZza);
                    }
                }
                this.zzS = zzarVarZza.zzw();
            }
            zzblVarZzo = zzo();
            if (zzblVarZzo.zzo()) {
                zzatVarZzw = this.zzS;
            } else {
                zzap zzapVar4 = zzblVarZzo.zze(zze(), this.zza, 0L).zzd;
                zzar zzarVarZza2 = this.zzS.zza();
                zzarVarZza2.zzb(zzapVar4.zzd);
                zzatVarZzw = zzarVarZza2.zzw();
            }
            zEquals = zzatVarZzw.equals(this.zzH);
            this.zzH = zzatVarZzw;
            if (zzlmVar3.zzl != zzlmVar.zzl) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (zzlmVar3.zze != zzlmVar.zze) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 || z6) {
                zzag();
            }
            if (zzlmVar3.zzg != zzlmVar.zzg) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (!zEquals2) {
                this.zzm.zzd(0, new zzdt() { // from class: com.google.android.gms.internal.ads.zziu
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj7) {
                        int i15 = zzka.zzd;
                        ((zzbe) obj7).zzq(zzlmVar.zza, i);
                    }
                });
            }
            if (z3) {
                zzbjVar = new zzbj();
                if (zzblVar.zzo()) {
                    i10 = i3;
                    obj = null;
                    zzapVar2 = null;
                    obj2 = null;
                    i11 = -1;
                } else {
                    Object obj7 = zzlmVar3.zzb.zza;
                    zzbl zzblVar4 = zzblVar;
                    zzblVar4.zzn(obj7, zzbjVar);
                    int i15 = zzbjVar.zzc;
                    int iZza = zzblVar4.zza(obj7);
                    zzbk zzbkVar2 = this.zza;
                    Object obj8 = zzblVar4.zze(i15, zzbkVar2, 0L).zzb;
                    zzapVar2 = zzbkVar2.zzd;
                    i10 = i15;
                    obj = obj8;
                    obj2 = obj7;
                    i11 = iZza;
                }
                if (i4 == 0) {
                    zzuyVar = zzlmVar3.zzb;
                    if (zzuyVar.zzb()) {
                        jZzU = zzbjVar.zzf(zzuyVar.zzb, zzuyVar.zzc);
                        jZzU2 = zzU(zzlmVar3);
                    } else {
                        if (zzuyVar.zze != -1) {
                            jZzU = zzU(this.zzT);
                        } else {
                            jZzU = zzbjVar.zzd;
                        }
                        jZzU2 = jZzU;
                    }
                } else if (zzlmVar3.zzb.zzb()) {
                    jZzU = zzlmVar3.zzs;
                    jZzU2 = zzU(zzlmVar3);
                } else {
                    jZzU = zzlmVar3.zzs;
                    jZzU2 = jZzU;
                }
                int i16 = zzeu.zza;
                zzuy zzuyVar4 = zzlmVar3.zzb;
                final zzbf zzbfVar = new zzbf(obj, i10, zzapVar2, obj2, i11, zzeu.zzv(jZzU), zzeu.zzv(jZzU2), zzuyVar4.zzb, zzuyVar4.zzc);
                iZze2 = zze();
                if (this.zzT.zza.zzo()) {
                    obj3 = null;
                    zzapVar3 = null;
                    obj4 = null;
                    i12 = -1;
                } else {
                    zzlm zzlmVar6 = this.zzT;
                    Object obj9 = zzlmVar6.zzb.zza;
                    zzlmVar6.zza.zzn(obj9, this.zzo);
                    int iZza2 = this.zzT.zza.zza(obj9);
                    zzbl zzblVar5 = this.zzT.zza;
                    zzbk zzbkVar3 = this.zza;
                    i12 = iZza2;
                    obj3 = zzblVar5.zze(iZze2, zzbkVar3, 0L).zzb;
                    zzapVar3 = zzbkVar3.zzd;
                    obj4 = obj9;
                }
                jZzv = zzeu.zzv(j);
                if (this.zzT.zzb.zzb()) {
                    jZzv2 = zzeu.zzv(zzU(this.zzT));
                } else {
                    jZzv2 = jZzv;
                }
                zzuy zzuyVar5 = this.zzT.zzb;
                final zzbf zzbfVar2 = new zzbf(obj3, iZze2, zzapVar3, obj4, i12, jZzv, jZzv2, zzuyVar5.zzb, zzuyVar5.zzc);
                this.zzm.zzd(11, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjn
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj10) {
                        int i17 = zzka.zzd;
                        ((zzbe) obj10).zzn(zzbfVar, zzbfVar2, i4);
                    }
                });
            } else {
                z6 = z6;
                zEquals = zEquals;
                z7 = z7;
                z8 = z8;
            }
            if (zBooleanValue) {
                this.zzm.zzd(1, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjo
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj10) {
                        int i17 = zzka.zzd;
                        ((zzbe) obj10).zze(zzapVar, iIntValue);
                    }
                });
            }
            zziiVar = zzlmVar3.zzf;
            zziiVar2 = zzlmVar.zzf;
            if (zziiVar != zziiVar2) {
                zzdwVar = this.zzm;
                zzdwVar.zzd(10, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjp
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj10) {
                        int i17 = zzka.zzd;
                        ((zzbe) obj10).zzl(zzlmVar.zzf);
                    }
                });
                if (zziiVar2 != null) {
                    zzdwVar.zzd(10, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjq
                        @Override // com.google.android.gms.internal.ads.zzdt
                        public final void zza(Object obj10) {
                            int i17 = zzka.zzd;
                            ((zzbe) obj10).zzk(zzlmVar.zzf);
                        }
                    });
                }
            }
            zzywVar = zzlmVar3.zzi;
            zzywVar2 = zzlmVar.zzi;
            if (zzywVar != zzywVar2) {
                this.zzj.zzp(zzywVar2.zze);
                this.zzm.zzd(2, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjr
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj10) {
                        int i17 = zzka.zzd;
                        ((zzbe) obj10).zzr(zzlmVar.zzi.zzd);
                    }
                });
            }
            if (!zEquals) {
                final zzat zzatVar = this.zzH;
                this.zzm.zzd(14, new zzdt() { // from class: com.google.android.gms.internal.ads.zziv
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj10) {
                        int i17 = zzka.zzd;
                        ((zzbe) obj10).zzf(zzatVar);
                    }
                });
            }
            if (z8) {
                this.zzm.zzd(3, new zzdt() { // from class: com.google.android.gms.internal.ads.zziw
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj10) {
                        int i17 = zzka.zzd;
                        ((zzbe) obj10).zzc(zzlmVar.zzg);
                    }
                });
            }
            if (z7 || z6) {
                this.zzm.zzd(-1, new zzdt() { // from class: com.google.android.gms.internal.ads.zzix
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj10) {
                        int i17 = zzka.zzd;
                        zzlm zzlmVar7 = zzlmVar;
                        ((zzbe) obj10).zzm(zzlmVar7.zzl, zzlmVar7.zze);
                    }
                });
            }
            if (z7) {
                this.zzm.zzd(4, new zzdt() { // from class: com.google.android.gms.internal.ads.zziy
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj10) {
                        int i17 = zzka.zzd;
                        ((zzbe) obj10).zzi(zzlmVar.zze);
                    }
                });
            }
            if (z6 || zzlmVar3.zzm != zzlmVar.zzm) {
                this.zzm.zzd(5, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjc
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj10) {
                        int i17 = zzka.zzd;
                        zzlm zzlmVar7 = zzlmVar;
                        ((zzbe) obj10).zzg(zzlmVar7.zzl, zzlmVar7.zzm);
                    }
                });
            }
            if (zzlmVar3.zzn != zzlmVar.zzn) {
                this.zzm.zzd(6, new zzdt() { // from class: com.google.android.gms.internal.ads.zzji
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj10) {
                        int i17 = zzka.zzd;
                        ((zzbe) obj10).zzj(zzlmVar.zzn);
                    }
                });
            }
            if (zzlmVar3.zzj() != zzlmVar.zzj()) {
                this.zzm.zzd(7, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjl
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj10) {
                        int i17 = zzka.zzd;
                        ((zzbe) obj10).zzd(zzlmVar.zzj());
                    }
                });
            }
            if (!zzlmVar3.zzo.equals(zzlmVar.zzo)) {
                this.zzm.zzd(12, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjm
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj10) {
                        int i17 = zzka.zzd;
                        ((zzbe) obj10).zzh(zzlmVar.zzo);
                    }
                });
            }
            zzbdVar = this.zzG;
            zzbh zzbhVar = this.zzg;
            zzbd zzbdVar3 = this.zzc;
            int i17 = zzeu.zza;
            boolean zZzx = zzbhVar.zzx();
            zzgVar = (zzg) zzbhVar;
            zzblVarZzo2 = zzgVar.zzo();
            if (!zzblVarZzo2.zzo()) {
                zzbdVar2 = zzbdVar;
                z9 = zzblVarZzo2.zze(zzgVar.zze(), zzgVar.zza, 0L).zzh;
                zzblVarZzo3 = zzgVar.zzo();
                if (zzblVarZzo3.zzo()) {
                    i8 = -1;
                    r6 = 0;
                    z10 = false;
                } else {
                    int iZze3 = zzgVar.zze();
                    zzgVar.zzi();
                    zzgVar.zzw();
                    r6 = 0;
                    r6 = 0;
                    iZzk = zzblVarZzo3.zzk(iZze3, 0, false);
                    i8 = -1;
                    if (iZzk != -1) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                }
                Zzo = zzgVar.zzo();
                if (Zzo.zzo()) {
                    r4 = r6;
                } else {
                    iZze = zzgVar.zze();
                    zzgVar.zzi();
                    zzgVar.zzw();
                    if (Zzo.zzj(iZze, r6, r6) != i8) {
                        r4 = 1;
                    } else {
                        r4 = r6;
                    }
                }
                zzblVarZzo4 = zzgVar.zzo();
                if (!zzblVarZzo4.zzo()) {
                    zzlmVar4 = zzlmVar3;
                    j2 = 0;
                    boolean z20 = zzblVarZzo4.zze(zzgVar.zze(), zzgVar.zza, 0L).zzb();
                    zzblVarZzo5 = zzgVar.zzo();
                    if (zzblVarZzo5.zzo() && zzblVarZzo5.zze(zzgVar.zze(), zzgVar.zza, j2).zzi) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    zZzo = zzbhVar.zzo().zzo();
                    zzbc zzbcVar = new zzbc();
                    zzbcVar.zzb(zzbdVar3);
                    boolean z21 = !zZzx;
                    zzbcVar.zzd(4, z21);
                    if (z9 || zZzx) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    zzbcVar.zzd(5, z12);
                    if (z10 || zZzx) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    zzbcVar.zzd(6, z13);
                    if (!zZzo || (!(z10 || !z20 || z9) || zZzx)) {
                        z14 = false;
                    } else {
                        z14 = true;
                    }
                    zzbcVar.zzd(7, z14);
                    if (r4 != 0 || zZzx) {
                        z15 = false;
                    } else {
                        z15 = true;
                    }
                    zzbcVar.zzd(8, z15);
                    if (!zZzo || ((r4 == 0 && !(z20 && z11)) || zZzx)) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    zzbcVar.zzd(9, z16);
                    zzbcVar.zzd(10, z21);
                    if (z9 || zZzx) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    zzbcVar.zzd(11, z17);
                    if (z9 || zZzx) {
                        i9 = 12;
                        z18 = false;
                    } else {
                        i9 = 12;
                        z18 = true;
                    }
                    zzbcVar.zzd(i9, z18);
                    zzbdVarZze = zzbcVar.zze();
                    this.zzG = zzbdVarZze;
                    if (!zzbdVarZze.equals(zzbdVar2)) {
                        this.zzm.zzd(13, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjk
                            @Override // com.google.android.gms.internal.ads.zzdt
                            public final void zza(Object obj10) {
                                ((zzbe) obj10).zzb(this.zza.zzG);
                            }
                        });
                    }
                    this.zzm.zzc();
                    boolean z22 = zzlmVar4.zzp;
                    boolean z23 = zzlmVar.zzp;
                }
                zzlmVar4 = zzlmVar3;
                j2 = 0;
                zzblVarZzo5 = zzgVar.zzo();
                if (zzblVarZzo5.zzo()) {
                    z11 = false;
                } else {
                    z11 = false;
                }
                zZzo = zzbhVar.zzo().zzo();
                zzbc zzbcVar2 = new zzbc();
                zzbcVar2.zzb(zzbdVar3);
                boolean z24 = !zZzx;
                zzbcVar2.zzd(4, z24);
                if (z9) {
                    z12 = false;
                } else {
                    z12 = false;
                }
                zzbcVar2.zzd(5, z12);
                if (z10) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                zzbcVar2.zzd(6, z13);
                if (zZzo) {
                    z14 = false;
                } else {
                    z14 = false;
                }
                zzbcVar2.zzd(7, z14);
                if (r4 != 0) {
                    z15 = false;
                } else {
                    z15 = false;
                }
                zzbcVar2.zzd(8, z15);
                if (zZzo) {
                    z16 = false;
                } else {
                    z16 = false;
                }
                zzbcVar2.zzd(9, z16);
                zzbcVar2.zzd(10, z24);
                if (z9) {
                    z17 = false;
                } else {
                    z17 = false;
                }
                zzbcVar2.zzd(11, z17);
                if (z9) {
                    i9 = 12;
                    z18 = false;
                } else {
                    i9 = 12;
                    z18 = false;
                }
                zzbcVar2.zzd(i9, z18);
                zzbdVarZze = zzbcVar2.zze();
                this.zzG = zzbdVarZze;
                if (!zzbdVarZze.equals(zzbdVar2)) {
                    this.zzm.zzd(13, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjk
                        @Override // com.google.android.gms.internal.ads.zzdt
                        public final void zza(Object obj10) {
                            ((zzbe) obj10).zzb(this.zza.zzG);
                        }
                    });
                }
                this.zzm.zzc();
                boolean z25 = zzlmVar4.zzp;
                boolean z26 = zzlmVar.zzp;
            }
            zzbdVar2 = zzbdVar;
            zzblVarZzo3 = zzgVar.zzo();
            if (zzblVarZzo3.zzo()) {
                i8 = -1;
                r6 = 0;
                z10 = false;
            } else {
                int iZze4 = zzgVar.zze();
                zzgVar.zzi();
                zzgVar.zzw();
                r6 = 0;
                r6 = 0;
                iZzk = zzblVarZzo3.zzk(iZze4, 0, false);
                i8 = -1;
                if (iZzk != -1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            }
            Zzo = zzgVar.zzo();
            if (Zzo.zzo()) {
                r4 = r6;
            } else {
                iZze = zzgVar.zze();
                zzgVar.zzi();
                zzgVar.zzw();
                if (Zzo.zzj(iZze, r6, r6) != i8) {
                    r4 = 1;
                } else {
                    r4 = r6;
                }
            }
            zzblVarZzo4 = zzgVar.zzo();
            if (!zzblVarZzo4.zzo()) {
                zzlmVar4 = zzlmVar3;
                j2 = 0;
                if (zzblVarZzo4.zze(zzgVar.zze(), zzgVar.zza, 0L).zzb()) {
                }
                zzblVarZzo5 = zzgVar.zzo();
                if (zzblVarZzo5.zzo()) {
                    z11 = false;
                } else {
                    z11 = false;
                }
                zZzo = zzbhVar.zzo().zzo();
                zzbc zzbcVar3 = new zzbc();
                zzbcVar3.zzb(zzbdVar3);
                boolean z27 = !zZzx;
                zzbcVar3.zzd(4, z27);
                if (z9) {
                    z12 = false;
                } else {
                    z12 = false;
                }
                zzbcVar3.zzd(5, z12);
                if (z10) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                zzbcVar3.zzd(6, z13);
                if (zZzo) {
                    z14 = false;
                } else {
                    z14 = false;
                }
                zzbcVar3.zzd(7, z14);
                if (r4 != 0) {
                    z15 = false;
                } else {
                    z15 = false;
                }
                zzbcVar3.zzd(8, z15);
                if (zZzo) {
                    z16 = false;
                } else {
                    z16 = false;
                }
                zzbcVar3.zzd(9, z16);
                zzbcVar3.zzd(10, z27);
                if (z9) {
                    z17 = false;
                } else {
                    z17 = false;
                }
                zzbcVar3.zzd(11, z17);
                if (z9) {
                    i9 = 12;
                    z18 = false;
                } else {
                    i9 = 12;
                    z18 = false;
                }
                zzbcVar3.zzd(i9, z18);
                zzbdVarZze = zzbcVar3.zze();
                this.zzG = zzbdVarZze;
                if (!zzbdVarZze.equals(zzbdVar2)) {
                    this.zzm.zzd(13, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjk
                        @Override // com.google.android.gms.internal.ads.zzdt
                        public final void zza(Object obj10) {
                            ((zzbe) obj10).zzb(this.zza.zzG);
                        }
                    });
                }
                this.zzm.zzc();
                boolean z28 = zzlmVar4.zzp;
                boolean z29 = zzlmVar.zzp;
            }
            zzlmVar4 = zzlmVar3;
            j2 = 0;
            zzblVarZzo5 = zzgVar.zzo();
            if (zzblVarZzo5.zzo()) {
                z11 = false;
            } else {
                z11 = false;
            }
            zZzo = zzbhVar.zzo().zzo();
            zzbc zzbcVar4 = new zzbc();
            zzbcVar4.zzb(zzbdVar3);
            boolean z210 = !zZzx;
            zzbcVar4.zzd(4, z210);
            if (z9) {
                z12 = false;
            } else {
                z12 = false;
            }
            zzbcVar4.zzd(5, z12);
            if (z10) {
                z13 = false;
            } else {
                z13 = false;
            }
            zzbcVar4.zzd(6, z13);
            if (zZzo) {
                z14 = false;
            } else {
                z14 = false;
            }
            zzbcVar4.zzd(7, z14);
            if (r4 != 0) {
                z15 = false;
            } else {
                z15 = false;
            }
            zzbcVar4.zzd(8, z15);
            if (zZzo) {
                z16 = false;
            } else {
                z16 = false;
            }
            zzbcVar4.zzd(9, z16);
            zzbcVar4.zzd(10, z210);
            if (z9) {
                z17 = false;
            } else {
                z17 = false;
            }
            zzbcVar4.zzd(11, z17);
            if (z9) {
                i9 = 12;
                z18 = false;
            } else {
                i9 = 12;
                z18 = false;
            }
            zzbcVar4.zzd(i9, z18);
            zzbdVarZze = zzbcVar4.zze();
            this.zzG = zzbdVarZze;
            if (!zzbdVarZze.equals(zzbdVar2)) {
                this.zzm.zzd(13, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjk
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj10) {
                        ((zzbe) obj10).zzb(this.zza.zzG);
                    }
                });
            }
            this.zzm.zzc();
            boolean z211 = zzlmVar4.zzp;
            boolean z212 = zzlmVar.zzp;
        }
        pair = new Pair(false, -1);
        zzlmVar2 = zzlmVar5;
        zzblVar = zzblVar2;
        i4 = i13;
        z3 = z;
        zBooleanValue = ((Boolean) pair.first).booleanValue();
        iIntValue = ((Integer) pair.second).intValue();
        if (zBooleanValue) {
            if (zzblVar3.zzo()) {
                zzapVar = zzblVar3.zze(zzblVar3.zzn(zzlmVar.zzb.zza, this.zzo).zzc, this.zza, 0L).zzd;
            } else {
                zzapVar = null;
            }
            this.zzS = zzat.zza;
        } else {
            zzapVar = null;
        }
        zzlmVar3 = zzlmVar2;
        if (zBooleanValue) {
            zzarVarZza = this.zzS.zza();
            list = zzlmVar.zzj;
            while (i6 < list.size()) {
                zzavVar = (zzav) list.get(i6);
                while (i7 < zzavVar.zza()) {
                    zzavVar.zzb(i7).zza(zzarVarZza);
                }
            }
            this.zzS = zzarVarZza.zzw();
        } else {
            zzarVarZza = this.zzS.zza();
            list = zzlmVar.zzj;
            while (i6 < list.size()) {
                zzavVar = (zzav) list.get(i6);
                while (i7 < zzavVar.zza()) {
                    zzavVar.zzb(i7).zza(zzarVarZza);
                }
            }
            this.zzS = zzarVarZza.zzw();
        }
        zzblVarZzo = zzo();
        if (zzblVarZzo.zzo()) {
            zzatVarZzw = this.zzS;
        } else {
            zzap zzapVar5 = zzblVarZzo.zze(zze(), this.zza, 0L).zzd;
            zzar zzarVarZza3 = this.zzS.zza();
            zzarVarZza3.zzb(zzapVar5.zzd);
            zzatVarZzw = zzarVarZza3.zzw();
        }
        zEquals = zzatVarZzw.equals(this.zzH);
        this.zzH = zzatVarZzw;
        if (zzlmVar3.zzl != zzlmVar.zzl) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (zzlmVar3.zze != zzlmVar.zze) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            zzag();
        } else {
            zzag();
        }
        if (zzlmVar3.zzg != zzlmVar.zzg) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (!zEquals2) {
            this.zzm.zzd(0, new zzdt() { // from class: com.google.android.gms.internal.ads.zziu
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj10) {
                    int i18 = zzka.zzd;
                    ((zzbe) obj10).zzq(zzlmVar.zza, i);
                }
            });
        }
        if (z3) {
            zzbjVar = new zzbj();
            if (zzblVar.zzo()) {
                Object obj10 = zzlmVar3.zzb.zza;
                zzbl zzblVar6 = zzblVar;
                zzblVar6.zzn(obj10, zzbjVar);
                int i18 = zzbjVar.zzc;
                int iZza3 = zzblVar6.zza(obj10);
                zzbk zzbkVar4 = this.zza;
                Object obj11 = zzblVar6.zze(i18, zzbkVar4, 0L).zzb;
                zzapVar2 = zzbkVar4.zzd;
                i10 = i18;
                obj = obj11;
                obj2 = obj10;
                i11 = iZza3;
            } else {
                i10 = i3;
                obj = null;
                zzapVar2 = null;
                obj2 = null;
                i11 = -1;
            }
            if (i4 == 0) {
                zzuyVar = zzlmVar3.zzb;
                if (zzuyVar.zzb()) {
                    jZzU = zzbjVar.zzf(zzuyVar.zzb, zzuyVar.zzc);
                    jZzU2 = zzU(zzlmVar3);
                } else {
                    if (zzuyVar.zze != -1) {
                        jZzU = zzU(this.zzT);
                    } else {
                        jZzU = zzbjVar.zzd;
                    }
                    jZzU2 = jZzU;
                }
            } else if (zzlmVar3.zzb.zzb()) {
                jZzU = zzlmVar3.zzs;
                jZzU2 = zzU(zzlmVar3);
            } else {
                jZzU = zzlmVar3.zzs;
                jZzU2 = jZzU;
            }
            int i19 = zzeu.zza;
            zzuy zzuyVar6 = zzlmVar3.zzb;
            final zzbf zzbfVar3 = new zzbf(obj, i10, zzapVar2, obj2, i11, zzeu.zzv(jZzU), zzeu.zzv(jZzU2), zzuyVar6.zzb, zzuyVar6.zzc);
            iZze2 = zze();
            if (this.zzT.zza.zzo()) {
                zzlm zzlmVar7 = this.zzT;
                Object obj12 = zzlmVar7.zzb.zza;
                zzlmVar7.zza.zzn(obj12, this.zzo);
                int iZza4 = this.zzT.zza.zza(obj12);
                zzbl zzblVar7 = this.zzT.zza;
                zzbk zzbkVar5 = this.zza;
                i12 = iZza4;
                obj3 = zzblVar7.zze(iZze2, zzbkVar5, 0L).zzb;
                zzapVar3 = zzbkVar5.zzd;
                obj4 = obj12;
            } else {
                obj3 = null;
                zzapVar3 = null;
                obj4 = null;
                i12 = -1;
            }
            jZzv = zzeu.zzv(j);
            if (this.zzT.zzb.zzb()) {
                jZzv2 = zzeu.zzv(zzU(this.zzT));
            } else {
                jZzv2 = jZzv;
            }
            zzuy zzuyVar7 = this.zzT.zzb;
            final zzbf zzbfVar4 = new zzbf(obj3, iZze2, zzapVar3, obj4, i12, jZzv, jZzv2, zzuyVar7.zzb, zzuyVar7.zzc);
            this.zzm.zzd(11, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjn
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj13) {
                    int i110 = zzka.zzd;
                    ((zzbe) obj13).zzn(zzbfVar3, zzbfVar4, i4);
                }
            });
        } else {
            z6 = z6;
            zEquals = zEquals;
            z7 = z7;
            z8 = z8;
        }
        if (zBooleanValue) {
            this.zzm.zzd(1, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjo
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj13) {
                    int i110 = zzka.zzd;
                    ((zzbe) obj13).zze(zzapVar, iIntValue);
                }
            });
        }
        zziiVar = zzlmVar3.zzf;
        zziiVar2 = zzlmVar.zzf;
        if (zziiVar != zziiVar2) {
            zzdwVar = this.zzm;
            zzdwVar.zzd(10, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjp
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj13) {
                    int i110 = zzka.zzd;
                    ((zzbe) obj13).zzl(zzlmVar.zzf);
                }
            });
            if (zziiVar2 != null) {
                zzdwVar.zzd(10, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjq
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj13) {
                        int i110 = zzka.zzd;
                        ((zzbe) obj13).zzk(zzlmVar.zzf);
                    }
                });
            }
        }
        zzywVar = zzlmVar3.zzi;
        zzywVar2 = zzlmVar.zzi;
        if (zzywVar != zzywVar2) {
            this.zzj.zzp(zzywVar2.zze);
            this.zzm.zzd(2, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjr
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj13) {
                    int i110 = zzka.zzd;
                    ((zzbe) obj13).zzr(zzlmVar.zzi.zzd);
                }
            });
        }
        if (!zEquals) {
            final zzat zzatVar2 = this.zzH;
            this.zzm.zzd(14, new zzdt() { // from class: com.google.android.gms.internal.ads.zziv
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj13) {
                    int i110 = zzka.zzd;
                    ((zzbe) obj13).zzf(zzatVar2);
                }
            });
        }
        if (z8) {
            this.zzm.zzd(3, new zzdt() { // from class: com.google.android.gms.internal.ads.zziw
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj13) {
                    int i110 = zzka.zzd;
                    ((zzbe) obj13).zzc(zzlmVar.zzg);
                }
            });
        }
        if (z7) {
            this.zzm.zzd(-1, new zzdt() { // from class: com.google.android.gms.internal.ads.zzix
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj13) {
                    int i110 = zzka.zzd;
                    zzlm zzlmVar8 = zzlmVar;
                    ((zzbe) obj13).zzm(zzlmVar8.zzl, zzlmVar8.zze);
                }
            });
        } else {
            this.zzm.zzd(-1, new zzdt() { // from class: com.google.android.gms.internal.ads.zzix
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj13) {
                    int i110 = zzka.zzd;
                    zzlm zzlmVar8 = zzlmVar;
                    ((zzbe) obj13).zzm(zzlmVar8.zzl, zzlmVar8.zze);
                }
            });
        }
        if (z7) {
            this.zzm.zzd(4, new zzdt() { // from class: com.google.android.gms.internal.ads.zziy
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj13) {
                    int i110 = zzka.zzd;
                    ((zzbe) obj13).zzi(zzlmVar.zze);
                }
            });
        }
        if (z6) {
            this.zzm.zzd(5, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjc
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj13) {
                    int i110 = zzka.zzd;
                    zzlm zzlmVar8 = zzlmVar;
                    ((zzbe) obj13).zzg(zzlmVar8.zzl, zzlmVar8.zzm);
                }
            });
        } else {
            this.zzm.zzd(5, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjc
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj13) {
                    int i110 = zzka.zzd;
                    zzlm zzlmVar8 = zzlmVar;
                    ((zzbe) obj13).zzg(zzlmVar8.zzl, zzlmVar8.zzm);
                }
            });
        }
        if (zzlmVar3.zzn != zzlmVar.zzn) {
            this.zzm.zzd(6, new zzdt() { // from class: com.google.android.gms.internal.ads.zzji
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj13) {
                    int i110 = zzka.zzd;
                    ((zzbe) obj13).zzj(zzlmVar.zzn);
                }
            });
        }
        if (zzlmVar3.zzj() != zzlmVar.zzj()) {
            this.zzm.zzd(7, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjl
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj13) {
                    int i110 = zzka.zzd;
                    ((zzbe) obj13).zzd(zzlmVar.zzj());
                }
            });
        }
        if (!zzlmVar3.zzo.equals(zzlmVar.zzo)) {
            this.zzm.zzd(12, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjm
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj13) {
                    int i110 = zzka.zzd;
                    ((zzbe) obj13).zzh(zzlmVar.zzo);
                }
            });
        }
        zzbdVar = this.zzG;
        zzbh zzbhVar2 = this.zzg;
        zzbd zzbdVar4 = this.zzc;
        int i110 = zzeu.zza;
        boolean zZzx2 = zzbhVar2.zzx();
        zzgVar = (zzg) zzbhVar2;
        zzblVarZzo2 = zzgVar.zzo();
        if (!zzblVarZzo2.zzo()) {
            zzbdVar2 = zzbdVar;
            if (zzblVarZzo2.zze(zzgVar.zze(), zzgVar.zza, 0L).zzh) {
            }
            zzblVarZzo3 = zzgVar.zzo();
            if (zzblVarZzo3.zzo()) {
                i8 = -1;
                r6 = 0;
                z10 = false;
            } else {
                int iZze5 = zzgVar.zze();
                zzgVar.zzi();
                zzgVar.zzw();
                r6 = 0;
                r6 = 0;
                iZzk = zzblVarZzo3.zzk(iZze5, 0, false);
                i8 = -1;
                if (iZzk != -1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            }
            Zzo = zzgVar.zzo();
            if (Zzo.zzo()) {
                r4 = r6;
            } else {
                iZze = zzgVar.zze();
                zzgVar.zzi();
                zzgVar.zzw();
                if (Zzo.zzj(iZze, r6, r6) != i8) {
                    r4 = 1;
                } else {
                    r4 = r6;
                }
            }
            zzblVarZzo4 = zzgVar.zzo();
            if (!zzblVarZzo4.zzo()) {
                zzlmVar4 = zzlmVar3;
                j2 = 0;
                if (zzblVarZzo4.zze(zzgVar.zze(), zzgVar.zza, 0L).zzb()) {
                }
                zzblVarZzo5 = zzgVar.zzo();
                if (zzblVarZzo5.zzo()) {
                    z11 = false;
                } else {
                    z11 = false;
                }
                zZzo = zzbhVar2.zzo().zzo();
                zzbc zzbcVar5 = new zzbc();
                zzbcVar5.zzb(zzbdVar4);
                boolean z213 = !zZzx2;
                zzbcVar5.zzd(4, z213);
                if (z9) {
                    z12 = false;
                } else {
                    z12 = false;
                }
                zzbcVar5.zzd(5, z12);
                if (z10) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                zzbcVar5.zzd(6, z13);
                if (zZzo) {
                    z14 = false;
                } else {
                    z14 = false;
                }
                zzbcVar5.zzd(7, z14);
                if (r4 != 0) {
                    z15 = false;
                } else {
                    z15 = false;
                }
                zzbcVar5.zzd(8, z15);
                if (zZzo) {
                    z16 = false;
                } else {
                    z16 = false;
                }
                zzbcVar5.zzd(9, z16);
                zzbcVar5.zzd(10, z213);
                if (z9) {
                    z17 = false;
                } else {
                    z17 = false;
                }
                zzbcVar5.zzd(11, z17);
                if (z9) {
                    i9 = 12;
                    z18 = false;
                } else {
                    i9 = 12;
                    z18 = false;
                }
                zzbcVar5.zzd(i9, z18);
                zzbdVarZze = zzbcVar5.zze();
                this.zzG = zzbdVarZze;
                if (!zzbdVarZze.equals(zzbdVar2)) {
                    this.zzm.zzd(13, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjk
                        @Override // com.google.android.gms.internal.ads.zzdt
                        public final void zza(Object obj13) {
                            ((zzbe) obj13).zzb(this.zza.zzG);
                        }
                    });
                }
                this.zzm.zzc();
                boolean z214 = zzlmVar4.zzp;
                boolean z215 = zzlmVar.zzp;
            }
            zzlmVar4 = zzlmVar3;
            j2 = 0;
            zzblVarZzo5 = zzgVar.zzo();
            if (zzblVarZzo5.zzo()) {
                z11 = false;
            } else {
                z11 = false;
            }
            zZzo = zzbhVar2.zzo().zzo();
            zzbc zzbcVar6 = new zzbc();
            zzbcVar6.zzb(zzbdVar4);
            boolean z216 = !zZzx2;
            zzbcVar6.zzd(4, z216);
            if (z9) {
                z12 = false;
            } else {
                z12 = false;
            }
            zzbcVar6.zzd(5, z12);
            if (z10) {
                z13 = false;
            } else {
                z13 = false;
            }
            zzbcVar6.zzd(6, z13);
            if (zZzo) {
                z14 = false;
            } else {
                z14 = false;
            }
            zzbcVar6.zzd(7, z14);
            if (r4 != 0) {
                z15 = false;
            } else {
                z15 = false;
            }
            zzbcVar6.zzd(8, z15);
            if (zZzo) {
                z16 = false;
            } else {
                z16 = false;
            }
            zzbcVar6.zzd(9, z16);
            zzbcVar6.zzd(10, z216);
            if (z9) {
                z17 = false;
            } else {
                z17 = false;
            }
            zzbcVar6.zzd(11, z17);
            if (z9) {
                i9 = 12;
                z18 = false;
            } else {
                i9 = 12;
                z18 = false;
            }
            zzbcVar6.zzd(i9, z18);
            zzbdVarZze = zzbcVar6.zze();
            this.zzG = zzbdVarZze;
            if (!zzbdVarZze.equals(zzbdVar2)) {
                this.zzm.zzd(13, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjk
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj13) {
                        ((zzbe) obj13).zzb(this.zza.zzG);
                    }
                });
            }
            this.zzm.zzc();
            boolean z217 = zzlmVar4.zzp;
            boolean z218 = zzlmVar.zzp;
        }
        zzbdVar2 = zzbdVar;
        zzblVarZzo3 = zzgVar.zzo();
        if (zzblVarZzo3.zzo()) {
            i8 = -1;
            r6 = 0;
            z10 = false;
        } else {
            int iZze6 = zzgVar.zze();
            zzgVar.zzi();
            zzgVar.zzw();
            r6 = 0;
            r6 = 0;
            iZzk = zzblVarZzo3.zzk(iZze6, 0, false);
            i8 = -1;
            if (iZzk != -1) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        Zzo = zzgVar.zzo();
        if (Zzo.zzo()) {
            r4 = r6;
        } else {
            iZze = zzgVar.zze();
            zzgVar.zzi();
            zzgVar.zzw();
            if (Zzo.zzj(iZze, r6, r6) != i8) {
                r4 = 1;
            } else {
                r4 = r6;
            }
        }
        zzblVarZzo4 = zzgVar.zzo();
        if (!zzblVarZzo4.zzo()) {
            zzlmVar4 = zzlmVar3;
            j2 = 0;
            if (zzblVarZzo4.zze(zzgVar.zze(), zzgVar.zza, 0L).zzb()) {
            }
            zzblVarZzo5 = zzgVar.zzo();
            if (zzblVarZzo5.zzo()) {
                z11 = false;
            } else {
                z11 = false;
            }
            zZzo = zzbhVar2.zzo().zzo();
            zzbc zzbcVar7 = new zzbc();
            zzbcVar7.zzb(zzbdVar4);
            boolean z219 = !zZzx2;
            zzbcVar7.zzd(4, z219);
            if (z9) {
                z12 = false;
            } else {
                z12 = false;
            }
            zzbcVar7.zzd(5, z12);
            if (z10) {
                z13 = false;
            } else {
                z13 = false;
            }
            zzbcVar7.zzd(6, z13);
            if (zZzo) {
                z14 = false;
            } else {
                z14 = false;
            }
            zzbcVar7.zzd(7, z14);
            if (r4 != 0) {
                z15 = false;
            } else {
                z15 = false;
            }
            zzbcVar7.zzd(8, z15);
            if (zZzo) {
                z16 = false;
            } else {
                z16 = false;
            }
            zzbcVar7.zzd(9, z16);
            zzbcVar7.zzd(10, z219);
            if (z9) {
                z17 = false;
            } else {
                z17 = false;
            }
            zzbcVar7.zzd(11, z17);
            if (z9) {
                i9 = 12;
                z18 = false;
            } else {
                i9 = 12;
                z18 = false;
            }
            zzbcVar7.zzd(i9, z18);
            zzbdVarZze = zzbcVar7.zze();
            this.zzG = zzbdVarZze;
            if (!zzbdVarZze.equals(zzbdVar2)) {
                this.zzm.zzd(13, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjk
                    @Override // com.google.android.gms.internal.ads.zzdt
                    public final void zza(Object obj13) {
                        ((zzbe) obj13).zzb(this.zza.zzG);
                    }
                });
            }
            this.zzm.zzc();
            boolean z2110 = zzlmVar4.zzp;
            boolean z2111 = zzlmVar.zzp;
        }
        zzlmVar4 = zzlmVar3;
        j2 = 0;
        zzblVarZzo5 = zzgVar.zzo();
        if (zzblVarZzo5.zzo()) {
            z11 = false;
        } else {
            z11 = false;
        }
        zZzo = zzbhVar2.zzo().zzo();
        zzbc zzbcVar8 = new zzbc();
        zzbcVar8.zzb(zzbdVar4);
        boolean z2112 = !zZzx2;
        zzbcVar8.zzd(4, z2112);
        if (z9) {
            z12 = false;
        } else {
            z12 = false;
        }
        zzbcVar8.zzd(5, z12);
        if (z10) {
            z13 = false;
        } else {
            z13 = false;
        }
        zzbcVar8.zzd(6, z13);
        if (zZzo) {
            z14 = false;
        } else {
            z14 = false;
        }
        zzbcVar8.zzd(7, z14);
        if (r4 != 0) {
            z15 = false;
        } else {
            z15 = false;
        }
        zzbcVar8.zzd(8, z15);
        if (zZzo) {
            z16 = false;
        } else {
            z16 = false;
        }
        zzbcVar8.zzd(9, z16);
        zzbcVar8.zzd(10, z2112);
        if (z9) {
            z17 = false;
        } else {
            z17 = false;
        }
        zzbcVar8.zzd(11, z17);
        if (z9) {
            i9 = 12;
            z18 = false;
        } else {
            i9 = 12;
            z18 = false;
        }
        zzbcVar8.zzd(i9, z18);
        zzbdVarZze = zzbcVar8.zze();
        this.zzG = zzbdVarZze;
        if (!zzbdVarZze.equals(zzbdVar2)) {
            this.zzm.zzd(13, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjk
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj13) {
                    ((zzbe) obj13).zzb(this.zza.zzG);
                }
            });
        }
        this.zzm.zzc();
        boolean z2113 = zzlmVar4.zzp;
        boolean z2114 = zzlmVar.zzp;
    }

    private final void zzag() {
        int iZzg = zzg();
        if (iZzg != 2 && iZzg != 3) {
            this.zzx.zza(false);
            this.zzy.zza(false);
        } else {
            zzah();
            boolean z = this.zzT.zzp;
            this.zzx.zza(zzv());
            this.zzy.zza(zzv());
        }
    }

    private final void zzah() {
        this.zze.zzb();
        Looper looper = this.zzs;
        if (Thread.currentThread() != looper.getThread()) {
            Object[] objArr = {Thread.currentThread().getName(), looper.getThread().getName()};
            int i = zzeu.zza;
            String str = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", objArr);
            if (this.zzP) {
                throw new IllegalStateException(str);
            }
            zzdx.zzg("ExoPlayerImpl", str, this.zzQ ? null : new IllegalStateException());
            this.zzQ = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzit
    public final void zzA() {
        zzdx.zze("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.6.0] [" + zzeu.zzb + "] [" + zzaq.zza() + b9.i.e);
        zzah();
        this.zzx.zza(false);
        this.zzy.zza(false);
        if (!this.zzl.zzu()) {
            zzdw zzdwVar = this.zzm;
            zzdwVar.zzd(10, new zzdt() { // from class: com.google.android.gms.internal.ads.zzjb
                @Override // com.google.android.gms.internal.ads.zzdt
                public final void zza(Object obj) {
                    int i = zzka.zzd;
                    ((zzbe) obj).zzk(zzii.zzd(new zzko(1), 1003));
                }
            });
            zzdwVar.zzc();
        }
        this.zzm.zze();
        this.zzk.zzf(null);
        zzzd zzzdVar = this.zzt;
        zzmg zzmgVar = this.zzr;
        zzzdVar.zzg(zzmgVar);
        boolean z = this.zzT.zzp;
        zzlm zzlmVarZzX = zzX(this.zzT, 1);
        this.zzT = zzlmVarZzX;
        zzlm zzlmVarZzb = zzlmVarZzX.zzb(zzlmVarZzX.zzb);
        this.zzT = zzlmVarZzb;
        zzlmVarZzb.zzq = zzlmVarZzb.zzs;
        this.zzT.zzr = 0L;
        zzmgVar.zzR();
        Surface surface = this.zzJ;
        if (surface != null) {
            surface.release();
            this.zzJ = null;
        }
        int i = zzcv.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzit
    public final void zzB(zzmj zzmjVar) {
        zzah();
        this.zzr.zzS(zzmjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzit
    public final void zzC(zzva zzvaVar) {
        zzah();
        List listSingletonList = Collections.singletonList(zzvaVar);
        zzah();
        zzah();
        zzR(this.zzT);
        zzl();
        this.zzB++;
        List list = this.zzp;
        if (!list.isEmpty()) {
            int size = list.size();
            for (int i = size - 1; i >= 0; i--) {
                list.remove(i);
            }
            this.zzX = this.zzX.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < listSingletonList.size(); i2++) {
            zzlj zzljVar = new zzlj((zzva) listSingletonList.get(i2), this.zzq);
            arrayList.add(zzljVar);
            list.add(i2, new zzjy(zzljVar.zzb, zzljVar.zza));
        }
        this.zzX = this.zzX.zzg(0, arrayList.size());
        zzls zzlsVar = new zzls(list, this.zzX);
        if (!zzlsVar.zzo() && zzlsVar.zzc() < 0) {
            throw new zzaa(zzlsVar, -1, -9223372036854775807L);
        }
        int iZzg = zzlsVar.zzg(false);
        zzlm zzlmVarZzY = zzY(this.zzT, zzlsVar, zzW(zzlsVar, iZzg, -9223372036854775807L));
        int i3 = zzlmVarZzY.zze;
        if (iZzg != -1 && i3 != 1) {
            i3 = 4;
            if (!zzlsVar.zzo() && iZzg < zzlsVar.zzc()) {
                i3 = 2;
            }
        }
        zzlm zzlmVarZzX = zzX(zzlmVarZzY, i3);
        this.zzl.zzw(arrayList, iZzg, zzeu.zzs(-9223372036854775807L), this.zzX);
        zzaf(zzlmVarZzX, 0, (this.zzT.zzb.zza.equals(zzlmVarZzX.zzb.zza) || this.zzT.zza.zzo()) ? false : true, 4, zzT(zzlmVarZzX), -1, false);
    }

    public final zzii zzE() {
        zzah();
        return this.zzT.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzg
    protected final void zzb(int i, long j, int i2, boolean z) {
        zzah();
        if (i == -1) {
            return;
        }
        zzdc.zzd(i >= 0);
        zzbl zzblVar = this.zzT.zza;
        if (zzblVar.zzo() || i < zzblVar.zzc()) {
            this.zzr.zzv();
            this.zzB++;
            if (zzx()) {
                zzdx.zzf("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                zzkk zzkkVar = new zzkk(this.zzT);
                zzkkVar.zza(1);
                this.zzW.zza.zzaa(zzkkVar);
                return;
            }
            zzlm zzlmVarZzX = this.zzT;
            int i3 = zzlmVarZzX.zze;
            if (i3 == 3 || (i3 == 4 && !zzblVar.zzo())) {
                zzlmVarZzX = zzX(this.zzT, 2);
            }
            int iZze = zze();
            zzlm zzlmVarZzY = zzY(zzlmVarZzX, zzblVar, zzW(zzblVar, i, j));
            this.zzl.zzo(zzblVar, i, zzeu.zzs(j));
            zzaf(zzlmVarZzY, 0, true, 1, zzT(zzlmVarZzY), iZze, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzc() {
        zzah();
        if (zzx()) {
            return this.zzT.zzb.zzb;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzd() {
        zzah();
        if (zzx()) {
            return this.zzT.zzb.zzc;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zze() {
        zzah();
        int iZzR = zzR(this.zzT);
        if (iZzR == -1) {
            return 0;
        }
        return iZzR;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzf() {
        zzah();
        if (this.zzT.zza.zzo()) {
            return 0;
        }
        zzlm zzlmVar = this.zzT;
        return zzlmVar.zza.zza(zzlmVar.zzb.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzg() {
        zzah();
        return this.zzT.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzh() {
        zzah();
        return this.zzT.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzi() {
        zzah();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzj() {
        zzah();
        if (zzx()) {
            zzlm zzlmVar = this.zzT;
            return zzlmVar.zzk.equals(zzlmVar.zzb) ? zzeu.zzv(this.zzT.zzq) : zzm();
        }
        zzah();
        if (this.zzT.zza.zzo()) {
            return this.zzV;
        }
        zzlm zzlmVar2 = this.zzT;
        long j = 0;
        if (zzlmVar2.zzk.zzd != zzlmVar2.zzb.zzd) {
            return zzeu.zzv(zzlmVar2.zza.zze(zze(), this.zza, 0L).zzm);
        }
        long j2 = zzlmVar2.zzq;
        if (this.zzT.zzk.zzb()) {
            zzlm zzlmVar3 = this.zzT;
            zzlmVar3.zza.zzn(zzlmVar3.zzk.zza, this.zzo).zzg(this.zzT.zzk.zzb);
        } else {
            j = j2;
        }
        zzlm zzlmVar4 = this.zzT;
        zzV(zzlmVar4.zza, zzlmVar4.zzk, j);
        return zzeu.zzv(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzk() {
        zzah();
        return zzS(this.zzT);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzl() {
        zzah();
        return zzeu.zzv(zzT(this.zzT));
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzm() {
        zzah();
        if (!zzx()) {
            zzbl zzblVarZzo = zzo();
            if (zzblVarZzo.zzo()) {
                return -9223372036854775807L;
            }
            return zzeu.zzv(zzblVarZzo.zze(zze(), this.zza, 0L).zzm);
        }
        zzlm zzlmVar = this.zzT;
        zzuy zzuyVar = zzlmVar.zzb;
        zzbl zzblVar = zzlmVar.zza;
        Object obj = zzuyVar.zza;
        zzbj zzbjVar = this.zzo;
        zzblVar.zzn(obj, zzbjVar);
        return zzeu.zzv(zzbjVar.zzf(zzuyVar.zzb, zzuyVar.zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzn() {
        zzah();
        return zzeu.zzv(this.zzT.zzr);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final zzbl zzo() {
        zzah();
        return this.zzT.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final zzbt zzp() {
        zzah();
        return this.zzT.zzi.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzq() {
        zzah();
        zzlm zzlmVar = this.zzT;
        if (zzlmVar.zze != 1) {
            return;
        }
        zzlm zzlmVarZze = zzlmVar.zze(null);
        zzlm zzlmVarZzX = zzX(zzlmVarZze, true != zzlmVarZze.zza.zzo() ? 2 : 4);
        this.zzB++;
        this.zzl.zzn();
        zzaf(zzlmVarZzX, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzr(boolean z) {
        zzah();
        zzlm zzlmVar = this.zzT;
        int i = zzlmVar.zzn;
        int i2 = 0;
        if (i == 1) {
            if (z) {
                i = 1;
            } else {
                i = 1;
                i2 = 1;
            }
        }
        if (zzlmVar.zzl == z && i == i2 && zzlmVar.zzm == 1) {
            return;
        }
        this.zzB++;
        boolean z2 = zzlmVar.zzp;
        zzlm zzlmVarZzd = zzlmVar.zzd(z, 1, i2);
        this.zzl.zzr(z, 1, i2);
        zzaf(zzlmVarZzd, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzs(Surface surface) {
        zzah();
        zzad(surface);
        int i = surface == null ? 0 : -1;
        zzab(i, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzt(float f) {
        zzah();
        int i = zzeu.zza;
        final float fMax = Math.max(0.0f, Math.min(f, 1.0f));
        if (this.zzN == fMax) {
            return;
        }
        this.zzN = fMax;
        this.zzl.zzs(fMax);
        zzdw zzdwVar = this.zzm;
        zzdwVar.zzd(22, new zzdt() { // from class: com.google.android.gms.internal.ads.zziz
            @Override // com.google.android.gms.internal.ads.zzdt
            public final void zza(Object obj) {
                int i2 = zzka.zzd;
                ((zzbe) obj).zzt(fMax);
            }
        });
        zzdwVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzu() {
        zzah();
        zzae(null);
        int i = zzcv.zza;
        zzfww zzfwwVarZzn = zzfww.zzn();
        long j = this.zzT.zzs;
        zzfww.zzl(zzfwwVarZzn);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final boolean zzv() {
        zzah();
        return this.zzT.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final boolean zzw() {
        zzah();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final boolean zzx() {
        zzah();
        return this.zzT.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzit
    public final int zzy() {
        zzah();
        int length = this.zzh.length;
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzit
    public final void zzz(zzmj zzmjVar) {
        this.zzr.zzu(zzmjVar);
    }
}
