package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbou;
import com.google.android.gms.internal.ads.zzboy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public class LiteSdkInfo extends zzcu {
    public LiteSdkInfo(Context context) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public zzboy getAdapterCreator() {
        return new zzbou();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public zzex getLiteSdkVersion() {
        return new zzex(ModuleDescriptor.MODULE_VERSION, 251410000, "24.2.0");
    }
}
