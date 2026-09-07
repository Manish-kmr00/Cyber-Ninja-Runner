package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzawn extends zzaxo {
    public zzawn(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2) {
        super(zzawbVar, "fKVfiHZPk3J/7s88V7DzlZpEiXT6V6JMDKZcc8OXmSTlXSMCJqbgkpAjwt4Hv42+", "vXYwSfgYAf7Qju1dl2aLGAb3jpSjakcmzbZlMMTwaIs=", zzarzVar, i, 49);
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzarz zzarzVar = this.zzd;
        zzarzVar.zzY(3);
        try {
            int i = 1;
            if (true == ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue()) {
                i = 2;
            }
            zzarzVar.zzY(i);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
