package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdni extends zzcqg {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdfm zze;
    private final zzdcg zzf;
    private final zzcvp zzg;
    private final zzcww zzh;
    private final zzcrb zzi;
    private final zzbwa zzj;
    private final zzfnc zzk;
    private final zzfbi zzl;
    private boolean zzm;

    zzdni(zzcqf zzcqfVar, Context context, zzcel zzcelVar, zzdfm zzdfmVar, zzdcg zzdcgVar, zzcvp zzcvpVar, zzcww zzcwwVar, zzcrb zzcrbVar, zzfau zzfauVar, zzfnc zzfncVar, zzfbi zzfbiVar) {
        super(zzcqfVar);
        this.zzm = false;
        this.zzc = context;
        this.zze = zzdfmVar;
        this.zzd = new WeakReference(zzcelVar);
        this.zzf = zzdcgVar;
        this.zzg = zzcvpVar;
        this.zzh = zzcwwVar;
        this.zzi = zzcrbVar;
        this.zzk = zzfncVar;
        zzbvw zzbvwVar = zzfauVar.zzl;
        this.zzj = new zzbwu(zzbvwVar != null ? zzbvwVar.zza : "", zzbvwVar != null ? zzbvwVar.zzb : 1);
        this.zzl = zzfbiVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcel zzcelVar = (zzcel) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgH)).booleanValue()) {
                if (!this.zzm && zzcelVar != null) {
                    zzgcd zzgcdVar = zzbzk.zzf;
                    Objects.requireNonNull(zzcelVar);
                    zzgcdVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdnh
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

    public final Bundle zza() {
        return this.zzh.zzb();
    }

    public final zzbwa zzc() {
        return this.zzj;
    }

    public final zzfbi zzd() {
        return this.zzl;
    }

    public final boolean zze() {
        return this.zzi.zzg();
    }

    public final boolean zzf() {
        return this.zzm;
    }

    public final boolean zzg() {
        zzcel zzcelVar = (zzcel) this.zzd.get();
        return (zzcelVar == null || zzcelVar.zzaG()) ? false : true;
    }

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
    public final boolean zzh(boolean z, Activity activity) {
        Context context;
        com.google.android.gms.ads.internal.zzv.zzq();
        zzdfm zzdfmVar = this.zze;
        if (!com.google.android.gms.ads.internal.util.zzs.zzO(zzdfmVar.zza())) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaQ)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zzq();
                if (com.google.android.gms.ads.internal.util.zzs.zzH(this.zzc)) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://goo.gle/admob-interstitial-policies");
                    this.zzg.zzb();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaR)).booleanValue()) {
                        this.zzk.zza(this.zza.zzb.zzb.zzb);
                    }
                    return false;
                }
            }
        }
        if (this.zzm) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("The rewarded ad have been showed.");
            this.zzg.zza(zzfcq.zzd(10, null, null));
            return false;
        }
        this.zzm = true;
        zzdcg zzdcgVar = this.zzf;
        zzdcgVar.zzb();
        if (activity == null) {
            context = activity;
            context = this.zzc;
        }
        try {
            context = activity;
            zzdfmVar.zzb(z, context, this.zzg);
            zzdcgVar.zza();
            return true;
        } catch (zzdfl e) {
            this.zzg.zzc(e);
            return false;
        }
    }
}
