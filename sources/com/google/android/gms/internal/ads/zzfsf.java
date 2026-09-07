package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfsf {
    public static final /* synthetic */ int zzb = 0;
    private static final zzfsx zzc = new zzfsx("OverlayDisplayService");
    private static final Intent zzd = new Intent("com.google.android.play.core.lmd.BIND_OVERLAY_DISPLAY_SERVICE").setPackage("com.android.vending");
    final zzfsw zza;
    private final String zze;

    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.android.gms.internal.ads.zzfsb] */
    zzfsf(Context context) {
        if (zzfsz.zza(context)) {
            this.zza = new zzfsw(context.getApplicationContext(), zzc, "OverlayDisplayService", zzd, new Object() { // from class: com.google.android.gms.internal.ads.zzfsb
            });
        } else {
            this.zza = null;
        }
        this.zze = context.getPackageName();
    }

    public static /* synthetic */ void zza(zzfsf zzfsfVar, zzfsm zzfsmVar, int i, zzfsk zzfskVar) {
        try {
            zzfsw zzfswVar = zzfsfVar.zza;
            if (zzfswVar == null) {
                throw null;
            }
            zzfqw zzfqwVar = (zzfqw) zzfswVar.zzc();
            if (zzfqwVar == null) {
                return;
            }
            String str = zzfsfVar.zze;
            final Bundle bundle = new Bundle();
            bundle.putString("callerPackage", str);
            bundle.putInt("displayMode", i);
            zzi(zzfsmVar.zzb(), new Consumer() { // from class: com.google.android.gms.internal.ads.zzfrq
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i2 = zzfsf.zzb;
                    bundle.putString("sessionToken", (String) obj);
                }
            });
            zzi(zzfsmVar.zza(), new Consumer() { // from class: com.google.android.gms.internal.ads.zzfrw
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i2 = zzfsf.zzb;
                    bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_ID, (String) obj);
                }
            });
            zzfqwVar.zzg(bundle, new zzfse(zzfsfVar, zzfskVar));
        } catch (RemoteException e) {
            zzc.zzb(e, "switchDisplayMode overlay display to %d from: %s", Integer.valueOf(i), zzfsfVar.zze);
        }
    }

    public static /* synthetic */ void zzb(zzfsf zzfsfVar, zzfrm zzfrmVar, zzfsk zzfskVar) {
        try {
            zzfsw zzfswVar = zzfsfVar.zza;
            if (zzfswVar == null) {
                throw null;
            }
            zzfqw zzfqwVar = (zzfqw) zzfswVar.zzc();
            if (zzfqwVar == null) {
                return;
            }
            String str = zzfsfVar.zze;
            final Bundle bundle = new Bundle();
            bundle.putString("callerPackage", str);
            zzi(zzfrmVar.zzb(), new Consumer() { // from class: com.google.android.gms.internal.ads.zzfry
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i = zzfsf.zzb;
                    bundle.putString("sessionToken", (String) obj);
                }
            });
            zzi(zzfrmVar.zza(), new Consumer() { // from class: com.google.android.gms.internal.ads.zzfrz
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i = zzfsf.zzb;
                    bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_ID, (String) obj);
                }
            });
            zzfqwVar.zze(bundle, new zzfse(zzfsfVar, zzfskVar));
        } catch (RemoteException e) {
            zzc.zzb(e, "dismiss overlay display from: %s", zzfsfVar.zze);
        }
    }

    public static /* synthetic */ void zzc(zzfsf zzfsfVar, zzfsh zzfshVar, zzfsk zzfskVar) {
        try {
            zzfsw zzfswVar = zzfsfVar.zza;
            if (zzfswVar == null) {
                throw null;
            }
            zzfqw zzfqwVar = (zzfqw) zzfswVar.zzc();
            if (zzfqwVar == null) {
                return;
            }
            String str = zzfsfVar.zze;
            final Bundle bundle = new Bundle();
            bundle.putString("callerPackage", str);
            bundle.putBinder("windowToken", zzfshVar.zzf());
            zzi(zzfshVar.zzg(), new Consumer() { // from class: com.google.android.gms.internal.ads.zzfsd
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i = zzfsf.zzb;
                    bundle.putString("adFieldEnifd", (String) obj);
                }
            });
            bundle.putInt("layoutGravity", zzfshVar.zzc());
            bundle.putFloat("layoutVerticalMargin", zzfshVar.zza());
            bundle.putInt("displayMode", 0);
            bundle.putInt("triggerMode", 0);
            bundle.putInt("windowWidthPx", zzfshVar.zze());
            zzi(null, new Consumer() { // from class: com.google.android.gms.internal.ads.zzfrr
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i = zzfsf.zzb;
                    bundle.putString("deeplinkUrl", (String) obj);
                }
            });
            zzi(null, new Consumer() { // from class: com.google.android.gms.internal.ads.zzfrs
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i = zzfsf.zzb;
                    bundle.putString("sessionToken", (String) obj);
                }
            });
            zzi(zzfshVar.zzh(), new Consumer() { // from class: com.google.android.gms.internal.ads.zzfrt
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i = zzfsf.zzb;
                    bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_ID, (String) obj);
                }
            });
            zzi(null, new Consumer() { // from class: com.google.android.gms.internal.ads.zzfru
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i = zzfsf.zzb;
                    bundle.putString("thirdPartyAuthCallerId", (String) obj);
                }
            });
            bundle.putBoolean("stableSessionToken", true);
            zzfqwVar.zzf(str, bundle, new zzfse(zzfsfVar, zzfskVar));
        } catch (RemoteException e) {
            zzc.zzb(e, "show overlay display from: %s", zzfsfVar.zze);
        }
    }

    static /* synthetic */ boolean zzh(String str) {
        return !zzk(str);
    }

    private static void zzi(String str, Consumer consumer) {
        if (zzk(str)) {
            return;
        }
        str.getClass();
        consumer.accept(str.trim());
    }

    private static boolean zzj(zzfsk zzfskVar, String str, List list) {
        if (list.stream().anyMatch(new Predicate() { // from class: com.google.android.gms.internal.ads.zzfsc
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return zzfsf.zzh((String) obj);
            }
        })) {
            return true;
        }
        zzc.zza(str, new Object[0]);
        zzfsi zzfsiVarZzc = zzfsj.zzc();
        zzfsiVarZzc.zzb(8160);
        zzfskVar.zza(zzfsiVarZzc.zzc());
        return false;
    }

    private static boolean zzk(String str) {
        return zzfun.zzc(str).trim().isEmpty();
    }

    final void zzd() {
        zzfsw zzfswVar = this.zza;
        if (zzfswVar == null) {
            return;
        }
        zzc.zzc("unbind LMD display overlay service", new Object[0]);
        zzfswVar.zzn();
    }

    final void zze(final zzfrm zzfrmVar, final zzfsk zzfskVar) {
        zzfsw zzfswVar = this.zza;
        if (zzfswVar == null) {
            zzc.zza("error: %s", "Play Store not found.");
        } else if (zzj(zzfskVar, "Failed to apply OverlayDisplayDismissRequest: missing appId and sessionToken.", Arrays.asList(zzfrmVar.zzb(), zzfrmVar.zza()))) {
            zzfswVar.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfrv
                @Override // java.lang.Runnable
                public final void run() {
                    zzfsf.zzb(this.zza, zzfrmVar, zzfskVar);
                }
            });
        }
    }

    final void zzf(final zzfsh zzfshVar, final zzfsk zzfskVar) {
        zzfsw zzfswVar = this.zza;
        if (zzfswVar == null) {
            zzc.zza("error: %s", "Play Store not found.");
        } else if (zzj(zzfskVar, "Failed to apply OverlayDisplayShowRequest: missing appId and sessionToken.", Arrays.asList(null, zzfshVar.zzh()))) {
            zzfswVar.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfsa
                @Override // java.lang.Runnable
                public final void run() {
                    zzfsf.zzc(this.zza, zzfshVar, zzfskVar);
                }
            });
        }
    }

    final void zzg(final zzfsm zzfsmVar, final zzfsk zzfskVar, final int i) {
        zzfsw zzfswVar = this.zza;
        if (zzfswVar == null) {
            zzc.zza("error: %s", "Play Store not found.");
        } else if (zzj(zzfskVar, "Failed to apply OverlayDisplayUpdateRequest: missing appId and sessionToken.", Arrays.asList(zzfsmVar.zzb(), zzfsmVar.zza()))) {
            zzfswVar.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfrx
                @Override // java.lang.Runnable
                public final void run() {
                    zzfsf.zza(this.zza, zzfsmVar, i, zzfskVar);
                }
            });
        }
    }
}
