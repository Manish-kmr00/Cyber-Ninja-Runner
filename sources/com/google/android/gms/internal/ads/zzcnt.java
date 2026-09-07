package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcnt extends zzcqg {
    private final zzcel zzc;
    private final int zzd;
    private final Context zze;
    private final zzcnh zzf;
    private final zzdfm zzg;
    private final zzdcg zzh;
    private final zzcvp zzi;
    private final boolean zzj;
    private final zzbze zzk;
    private boolean zzl;

    zzcnt(zzcqf zzcqfVar, Context context, zzcel zzcelVar, int i, zzcnh zzcnhVar, zzdfm zzdfmVar, zzdcg zzdcgVar, zzcvp zzcvpVar, zzbze zzbzeVar) {
        super(zzcqfVar);
        this.zzl = false;
        this.zzc = zzcelVar;
        this.zze = context;
        this.zzd = i;
        this.zzf = zzcnhVar;
        this.zzg = zzdfmVar;
        this.zzh = zzdcgVar;
        this.zzi = zzcvpVar;
        this.zzj = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfx)).booleanValue();
        this.zzk = zzbzeVar;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcqg
    public final void zzb() {
        super.zzb();
        zzcel zzcelVar = this.zzc;
        if (zzcelVar != null) {
            zzcelVar.destroy();
        }
    }

    public final void zzc(zzazu zzazuVar) {
        zzcel zzcelVar = this.zzc;
        if (zzcelVar != null) {
            zzcelVar.zzak(zzazuVar);
        }
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
    public final void zzd(Activity activity, zzbah zzbahVar, boolean z) throws RemoteException {
        zzcel zzcelVar;
        zzfau zzfauVarZzD;
        Context context = activity;
        if (activity == null) {
            context = this.zze;
        }
        boolean z2 = this.zzj;
        if (z2) {
            this.zzh.zzb();
        }
        com.google.android.gms.ads.internal.zzv.zzq();
        zzdfm zzdfmVar = this.zzg;
        if (!com.google.android.gms.ads.internal.util.zzs.zzO(zzdfmVar.zza())) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaQ)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zzq();
                if (com.google.android.gms.ads.internal.util.zzs.zzH(context)) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://goo.gle/admob-interstitial-policies");
                    this.zzi.zzb();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaR)).booleanValue()) {
                        new zzfnc(context.getApplicationContext(), com.google.android.gms.ads.internal.zzv.zzu().zzb()).zza(this.zza.zzb.zzb.zzb);
                        return;
                    }
                    return;
                }
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlX)).booleanValue() && (zzcelVar = this.zzc) != null && (zzfauVarZzD = zzcelVar.zzD()) != null && zzfauVarZzD.zzar && zzfauVarZzD.zzas != this.zzk.zzb()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("The app open consent form has been shown.");
            this.zzi.zza(zzfcq.zzd(12, "The consent form has already been shown.", null));
            return;
        }
        if (this.zzl) {
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("App open interstitial ad is already visible.");
            this.zzi.zza(zzfcq.zzd(10, null, null));
        }
        if (this.zzl) {
            return;
        }
        try {
            zzdfmVar.zzb(z, context, this.zzi);
            if (z2) {
                this.zzh.zza();
            }
            this.zzl = true;
        } catch (zzdfl e) {
            this.zzi.zzc(e);
        }
    }

    public final void zze(long j, int i) {
        this.zzf.zza(j, i);
    }
}
