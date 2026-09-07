package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzedq implements zzecl {
    private final Context zza;
    private final zzcpd zzb;
    private View zzc;
    private zzbph zzd;

    public zzedq(Context context, zzcpd zzcpdVar) {
        this.zza = context;
        this.zzb = zzcpdVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzecl
    public final /* bridge */ /* synthetic */ Object zza(zzfbg zzfbgVar, final zzfau zzfauVar, final zzeci zzeciVar) throws zzefy, zzfbw {
        final View view;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhU)).booleanValue() && zzfauVar.zzag) {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zZzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzfbw(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                }
                if (zZzf) {
                    try {
                        view = (View) zzgbs.zzn(zzgbs.zzh(null), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzedn
                            @Override // com.google.android.gms.internal.ads.zzgaz
                            public final ListenableFuture zza(Object obj) {
                                return zzgbs.zzh(zzcps.zza(this.zza.zza, view, zzfauVar));
                            }
                        }, zzbzk.zzf).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzfbw(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzfbw(e2);
            }
        } else {
            view = this.zzc;
        }
        zzcoa zzcoaVarZza = this.zzb.zza(new zzcqw(zzfbgVar, zzfauVar, zzeciVar.zza), new zzcog(view, null, new zzcqe() { // from class: com.google.android.gms.internal.ads.zzedm
            @Override // com.google.android.gms.internal.ads.zzcqe
            public final com.google.android.gms.ads.internal.client.zzea zza() throws zzfbw {
                try {
                    return ((zzbqx) zzeciVar.zzb).zze();
                } catch (RemoteException e3) {
                    throw new zzfbw(e3);
                }
            }
        }, (zzfav) zzfauVar.zzu.get(0)));
        zzcoaVarZza.zzh().zza(view);
        ((zzedw) zzeciVar.zzc).zzc(zzcoaVarZza.zzj());
        return zzcoaVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final void zzb(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzfbw {
        try {
            zzbqx zzbqxVar = (zzbqx) zzeciVar.zzb;
            zzbqxVar.zzq(zzfauVar.zzZ);
            zzedp zzedpVar = null;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhU)).booleanValue() && zzfauVar.zzag) {
                String str = zzfauVar.zzU;
                String string = zzfauVar.zzv.toString();
                zzfbp zzfbpVar = zzfbgVar.zza.zza;
                zzbqxVar.zzk(str, string, zzfbpVar.zzd, ObjectWrapper.wrap(this.zza), new zzedo(this, zzeciVar, zzedpVar), (zzbpe) zzeciVar.zzc, zzfbpVar.zze);
                return;
            }
            String str2 = zzfauVar.zzU;
            String string2 = zzfauVar.zzv.toString();
            zzfbp zzfbpVar2 = zzfbgVar.zza.zza;
            zzbqxVar.zzj(str2, string2, zzfbpVar2.zzd, ObjectWrapper.wrap(this.zza), new zzedo(this, zzeciVar, zzedpVar), (zzbpe) zzeciVar.zzc, zzfbpVar2.zze);
        } catch (RemoteException e) {
            throw new zzfbw(e);
        }
    }
}
