package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzekt implements zzesv {
    private final zzgcd zza;
    private final Context zzb;
    private final zzfbp zzc;
    private final View zzd;

    public zzekt(zzgcd zzgcdVar, Context context, zzfbp zzfbpVar, ViewGroup viewGroup) {
        this.zza = zzgcdVar;
        this.zzb = context;
        this.zzc = zzfbpVar;
        this.zzd = viewGroup;
    }

    public static /* synthetic */ zzeku zzc(zzekt zzektVar) {
        ArrayList arrayList = new ArrayList();
        View view = zzektVar.zzd;
        while (view != null) {
            Object parent = view.getParent();
            if (parent == null) {
                break;
            }
            int iIndexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", iIndexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzeku(zzektVar.zzb, zzektVar.zzc.zze, arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 3;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        zzbci.zza(this.zzb);
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeks
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzekt.zzc(this.zza);
            }
        });
    }
}
