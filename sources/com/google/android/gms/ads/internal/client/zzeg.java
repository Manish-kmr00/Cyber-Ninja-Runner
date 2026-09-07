package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeg {
    private String zzg;
    private String zzi;
    private String zzj;
    private boolean zzl;
    private String zzm;
    private final HashSet zza = new HashSet();
    private final Bundle zzb = new Bundle();
    private final HashMap zzc = new HashMap();
    private final HashSet zzd = new HashSet();
    private final Bundle zze = new Bundle();
    private final HashSet zzf = new HashSet();
    private final List zzh = new ArrayList();
    private int zzk = -1;
    private int zzn = 60000;

    public final void zzA(String str) {
        this.zzi = str;
    }

    public final void zzB(String str) {
        this.zzj = str;
    }

    @Deprecated
    public final void zzC(boolean z) {
        this.zzk = z ? 1 : 0;
    }

    public final void zzn(String str) {
        this.zzf.add(str);
    }

    public final void zzo(Class cls, Bundle bundle) {
        Bundle bundle2 = this.zzb;
        if (bundle2.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            bundle2.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        Bundle bundle3 = bundle2.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        Preconditions.checkNotNull(bundle3);
        bundle3.putBundle(cls.getName(), bundle);
    }

    public final void zzp(String str, String str2) {
        this.zze.putString(str, str2);
    }

    public final void zzq(String str) {
        this.zza.add(str);
    }

    public final void zzr(Class cls, Bundle bundle) {
        this.zzb.putBundle(cls.getName(), bundle);
    }

    public final void zzs(String str) {
        this.zzd.add(str);
    }

    public final void zzt(String str) {
        this.zzd.remove(AdRequest.DEVICE_ID_EMULATOR);
    }

    public final void zzu(String str) {
        this.zzm = str;
    }

    public final void zzv(String str) {
        this.zzg = str;
    }

    public final void zzw(int i) {
        this.zzn = i;
    }

    @Deprecated
    public final void zzx(boolean z) {
        this.zzl = z;
    }

    public final void zzy(List list) {
        List list2 = this.zzh;
        list2.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (TextUtils.isEmpty(str)) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("neighboring content URL should not be null or empty");
            } else {
                list2.add(str);
            }
        }
    }

    public final void zzz(Bundle bundle) {
        this.zzb.putAll(bundle);
    }
}
