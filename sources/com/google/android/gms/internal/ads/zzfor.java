package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfor {
    final zzfou zza;
    final boolean zzb;

    private zzfor(zzfou zzfouVar) {
        this.zza = zzfouVar;
        this.zzb = zzfouVar != null;
    }

    public static zzfor zzb(Context context, String str, String str2) {
        zzfou zzfosVar;
        try {
            try {
                try {
                    IBinder iBinderInstantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
                    IBinder iBinder = iBinderInstantiate;
                    if (iBinderInstantiate == null) {
                        zzfosVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderInstantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                        zzfosVar = iInterfaceQueryLocalInterface instanceof zzfou ? (zzfou) iInterfaceQueryLocalInterface : new zzfos(iBinderInstantiate);
                    }
                    zzfou zzfouVar = zzfosVar;
                    zzfosVar.zze(ObjectWrapper.wrap(context), str, null);
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new zzfor(zzfosVar);
                } catch (Exception e) {
                    throw new zzfnt(e);
                }
            } catch (RemoteException | zzfnt | NullPointerException | SecurityException unused) {
                Log.d("GASS", "Cannot dynamite load clearcut");
                return new zzfor(new zzfov());
            }
        } catch (Exception e2) {
            throw new zzfnt(e2);
        }
    }

    public static zzfor zzc() {
        zzfov zzfovVar = new zzfov();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzfor(zzfovVar);
    }

    public final zzfop zza(byte[] bArr) {
        return new zzfop(this, bArr, null);
    }
}
