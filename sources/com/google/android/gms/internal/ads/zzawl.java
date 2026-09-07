package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzawl extends zzaxo {
    private final Activity zzh;
    private final View zzi;

    public zzawl(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2, View view, Activity activity) {
        super(zzawbVar, "pU4fz37mUnFskzkjpWeE6FeP4zxun0Vi/cHUa+ShQyzwB7kVjKkTqY+tD4Acjs+V", "Xr6iV2TsXBCx3do6H/9RIpbcZekNyEQeKhEDMIoivd0=", zzarzVar, i, 62);
        this.zzi = view;
        this.zzh = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        View view = this.zzi;
        if (view == null) {
            return;
        }
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcP)).booleanValue();
        Object[] objArr = (Object[]) this.zze.invoke(null, view, this.zzh, Boolean.valueOf(zBooleanValue));
        zzarz zzarzVar = this.zzd;
        synchronized (zzarzVar) {
            zzarzVar.zzc(((Long) objArr[0]).longValue());
            zzarzVar.zze(((Long) objArr[1]).longValue());
            if (zBooleanValue) {
                zzarzVar.zzd((String) objArr[2]);
            }
        }
    }
}
