package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgva {
    public static final zzgva zza = new zzgva(new zzgvb());
    public static final zzgva zzb = new zzgva(new zzgvf());
    private final zzguy zzc;

    static {
        new zzgva(new zzgvh());
        new zzgva(new zzgvg());
        new zzgva(new zzgvc());
        new zzgva(new zzgve());
        new zzgva(new zzgvd());
    }

    public zzgva(zzgvi zzgviVar) {
        this.zzc = !zzgkp.zzb() ? "The Android Project".equals(System.getProperty("java.vendor")) ? new zzguv(zzgviVar, null) : new zzguw(zzgviVar, null) : new zzgux(zzgviVar, null);
    }

    public static List zzb(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        return this.zzc.zza(str);
    }
}
