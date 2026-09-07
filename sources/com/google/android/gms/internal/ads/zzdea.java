package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdea extends zzcqg {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdcg zze;
    private final zzdfm zzf;
    private final zzcrb zzg;
    private final zzfnc zzh;
    private final zzcvp zzi;
    private final zzbze zzj;
    private boolean zzk;

    zzdea(zzcqf zzcqfVar, Context context, @Nullable zzcel zzcelVar, zzdcg zzdcgVar, zzdfm zzdfmVar, zzcrb zzcrbVar, zzfnc zzfncVar, zzcvp zzcvpVar, zzbze zzbzeVar) {
        super(zzcqfVar);
        this.zzk = false;
        this.zzc = context;
        this.zzd = new WeakReference(zzcelVar);
        this.zze = zzdcgVar;
        this.zzf = zzdfmVar;
        this.zzg = zzcrbVar;
        this.zzh = zzfncVar;
        this.zzi = zzcvpVar;
        this.zzj = zzbzeVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcel zzcelVar = (zzcel) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgH)).booleanValue()) {
                if (!this.zzk && zzcelVar != null) {
                    zzgcd zzgcdVar = zzbzk.zzf;
                    Objects.requireNonNull(zzcelVar);
                    zzgcdVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzddz
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcelVar.destroy();
                        }
                    });
                }
            } else if (zzcelVar != null) {
                zzcelVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean zza() {
        return this.zzg.zzg();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x005f  */
    /* JADX WARN: Code duplicated, block: B:13:0x007a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:21:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:26:0x00bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x00c1  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean zzc(boolean z, @Nullable Activity activity) {
        Context context;
        zzfau zzfauVarZzD;
        zzdcg zzdcgVar = this.zze;
        zzdcgVar.zzb();
        com.google.android.gms.ads.internal.zzv.zzq();
        zzdfm zzdfmVar = this.zzf;
        if (com.google.android.gms.ads.internal.util.zzs.zzO(zzdfmVar.zza())) {
            zzcel zzcelVar = (zzcel) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlX)).booleanValue()) {
                if (this.zzk) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("The interstitial ad has been shown.");
                    this.zzi.zza(zzfcq.zzd(10, null, null));
                }
                context = activity;
                if (!this.zzk) {
                    if (activity == null) {
                        context = this.zzc;
                    }
                    zzdfmVar.zzb(z, context, this.zzi);
                    zzdcgVar.zza();
                    this.zzk = true;
                    return true;
                }
            } else {
                if (this.zzk) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("The interstitial ad has been shown.");
                    this.zzi.zza(zzfcq.zzd(10, null, null));
                }
                context = activity;
                if (!this.zzk) {
                    if (activity == null) {
                        context = this.zzc;
                    }
                    zzdfmVar.zzb(z, context, this.zzi);
                    zzdcgVar.zza();
                    this.zzk = true;
                    return true;
                }
            }
        } else if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaQ)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zzq();
            if (com.google.android.gms.ads.internal.util.zzs.zzH(this.zzc)) {
                int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://goo.gle/admob-interstitial-policies");
                this.zzi.zzb();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaR)).booleanValue()) {
                    this.zzh.zza(this.zza.zzb.zzb.zzb);
                }
            } else {
                zzcel zzcelVar2 = (zzcel) this.zzd.get();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlX)).booleanValue() || zzcelVar2 == null || (zzfauVarZzD = zzcelVar2.zzD()) == null || !zzfauVarZzD.zzar || zzfauVarZzD.zzas == this.zzj.zzb()) {
                    if (this.zzk) {
                        int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("The interstitial ad has been shown.");
                        this.zzi.zza(zzfcq.zzd(10, null, null));
                    }
                    context = activity;
                    if (!this.zzk) {
                        if (activity == null) {
                            context = this.zzc;
                        }
                        try {
                            zzdfmVar.zzb(z, context, this.zzi);
                            zzdcgVar.zza();
                            this.zzk = true;
                            return true;
                        } catch (zzdfl e) {
                            this.zzi.zzc(e);
                        }
                    }
                } else {
                    int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("The interstitial consent form has been shown.");
                    this.zzi.zza(zzfcq.zzd(12, "The consent form has already been shown.", null));
                }
            }
        } else {
            zzcel zzcelVar3 = (zzcel) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlX)).booleanValue()) {
                if (this.zzk) {
                    int i6 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("The interstitial ad has been shown.");
                    this.zzi.zza(zzfcq.zzd(10, null, null));
                }
                context = activity;
                if (!this.zzk) {
                    if (activity == null) {
                        context = this.zzc;
                    }
                    zzdfmVar.zzb(z, context, this.zzi);
                    zzdcgVar.zza();
                    this.zzk = true;
                    return true;
                }
            } else {
                if (this.zzk) {
                    int i7 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("The interstitial ad has been shown.");
                    this.zzi.zza(zzfcq.zzd(10, null, null));
                }
                context = activity;
                if (!this.zzk) {
                    if (activity == null) {
                        context = this.zzc;
                    }
                    zzdfmVar.zzb(z, context, this.zzi);
                    zzdcgVar.zza();
                    this.zzk = true;
                    return true;
                }
            }
        }
        return false;
    }
}
