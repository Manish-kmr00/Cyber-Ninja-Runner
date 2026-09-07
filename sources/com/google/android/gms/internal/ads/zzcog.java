package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public class zzcog {
    private final zzcqe zza;
    private final View zzb;
    private final zzfav zzc;
    private final zzcel zzd;

    public zzcog(View view, zzcel zzcelVar, zzcqe zzcqeVar, zzfav zzfavVar) {
        this.zzb = view;
        this.zzd = zzcelVar;
        this.zza = zzcqeVar;
        this.zzc = zzfavVar;
    }

    public final View zza() {
        return this.zzb;
    }

    public final zzcel zzb() {
        return this.zzd;
    }

    public final zzcqe zzc() {
        return this.zza;
    }

    public zzcwo zzd(Set set) {
        return new zzcwo(set);
    }

    public final zzfav zze() {
        return this.zzc;
    }
}
