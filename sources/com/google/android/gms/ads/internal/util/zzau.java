package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.webkit.internal.AssetHelper;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzdtz;
import com.google.android.gms.internal.ads.zzdud;
import com.google.android.gms.internal.ads.zzgcd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzau {
    private final Context zza;
    private final zzdud zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private int zzg;
    private int zzh;
    private PointF zzi;
    private PointF zzj;
    private Handler zzk;
    private Runnable zzl;

    public zzau(Context context) {
        this.zzg = 0;
        this.zzl = new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzaf
            @Override // java.lang.Runnable
            public final void run() {
                zzau.zzi(this.zza);
            }
        };
        this.zza = context;
        this.zzh = ViewConfiguration.get(context).getScaledTouchSlop();
        com.google.android.gms.ads.internal.zzv.zzu().zzb();
        this.zzk = com.google.android.gms.ads.internal.zzv.zzu().zza();
        this.zzb = com.google.android.gms.ads.internal.zzv.zzt().zza();
    }

    public static /* synthetic */ void zza(zzau zzauVar) {
        zzay zzayVarZzt = com.google.android.gms.ads.internal.zzv.zzt();
        String str = zzauVar.zzd;
        String str2 = zzauVar.zze;
        String str3 = zzauVar.zzf;
        boolean zZzm = zzayVarZzt.zzm();
        Context context = zzauVar.zza;
        zzayVarZzt.zzh(zzayVarZzt.zzj(context, str, str2));
        if (!zzayVarZzt.zzm()) {
            zzayVarZzt.zzd(context, str, str2);
            return;
        }
        if (!zZzm && !TextUtils.isEmpty(str3)) {
            zzayVarZzt.zze(context, str2, str3, str);
        }
        int i = zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Device is linked for debug signals.");
        zzayVarZzt.zzi(context, "The device is successfully linked for troubleshooting.", false, true);
    }

    public static /* synthetic */ void zzc(final zzau zzauVar, int i, int i2, int i3, int i4, int i5, DialogInterface dialogInterface, int i6) {
        if (i6 != i) {
            if (i6 == i2) {
                int i7 = zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Debug mode [Creative Preview] selected.");
                zzbzk.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzag
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzau.zzj(this.zza);
                    }
                });
                return;
            }
            if (i6 == i3) {
                int i8 = zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Debug mode [Troubleshooting] selected.");
                zzbzk.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzat
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzau.zza(this.zza);
                    }
                });
                return;
            }
            if (i6 == i4) {
                zzdud zzdudVar = zzauVar.zzb;
                final zzgcd zzgcdVar = zzbzk.zzf;
                zzgcd zzgcdVar2 = zzbzk.zza;
                if (zzdudVar.zzq()) {
                    zzgcdVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzar
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.google.android.gms.ads.internal.zzv.zzt().zzc(this.zza.zza);
                        }
                    });
                    return;
                } else {
                    zzgcdVar2.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzas
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzau.zzl(this.zza, zzgcdVar);
                        }
                    });
                    return;
                }
            }
            if (i6 == i5) {
                zzdud zzdudVar2 = zzauVar.zzb;
                final zzgcd zzgcdVar3 = zzbzk.zzf;
                zzgcd zzgcdVar4 = zzbzk.zza;
                if (zzdudVar2.zzq()) {
                    zzgcdVar3.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzae
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzau zzauVar2 = this.zza;
                            zzauVar2.zzs(zzauVar2.zza);
                        }
                    });
                    return;
                } else {
                    zzgcdVar4.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzal
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzau.zzd(this.zza, zzgcdVar3);
                        }
                    });
                    return;
                }
            }
            return;
        }
        Context context = zzauVar.zza;
        if (!(context instanceof Activity)) {
            int i9 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Can not create dialog without Activity Context");
            return;
        }
        String str = zzauVar.zzc;
        final String str2 = "No debug information";
        if (!TextUtils.isEmpty(str)) {
            Uri uriBuild = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
            StringBuilder sb = new StringBuilder();
            com.google.android.gms.ads.internal.zzv.zzq();
            Map mapZzQ = zzs.zzQ(uriBuild);
            for (String str3 : mapZzQ.keySet()) {
                sb.append(str3);
                sb.append(" = ");
                sb.append((String) mapZzQ.get(str3));
                sb.append("\n\n");
            }
            String strTrim = sb.toString().trim();
            if (!TextUtils.isEmpty(strTrim)) {
                str2 = strTrim;
            }
        }
        com.google.android.gms.ads.internal.zzv.zzq();
        AlertDialog.Builder builderZzL = zzs.zzL(context);
        builderZzL.setMessage(str2);
        builderZzL.setTitle("Ad Information");
        builderZzL.setPositiveButton("Share", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzah
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i10) {
                zzau.zzg(this.zza, str2, dialogInterface2, i10);
            }
        });
        builderZzL.setNegativeButton("Close", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzai
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i10) {
            }
        });
        builderZzL.create().show();
    }

    public static /* synthetic */ void zzd(final zzau zzauVar, zzgcd zzgcdVar) {
        zzay zzayVarZzt = com.google.android.gms.ads.internal.zzv.zzt();
        Context context = zzauVar.zza;
        if (zzayVarZzt.zzj(context, zzauVar.zzd, zzauVar.zze)) {
            zzgcdVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzak
                @Override // java.lang.Runnable
                public final void run() {
                    zzau zzauVar2 = this.zza;
                    zzauVar2.zzs(zzauVar2.zza);
                }
            });
        } else {
            com.google.android.gms.ads.internal.zzv.zzt().zzd(context, zzauVar.zzd, zzauVar.zze);
        }
    }

    public static /* synthetic */ void zzf(zzau zzauVar, AtomicInteger atomicInteger, int i, int i2, int i3, DialogInterface dialogInterface, int i4) {
        if (atomicInteger.get() != i) {
            if (atomicInteger.get() == i2) {
                zzauVar.zzb.zzm(zzdtz.SHAKE);
            } else if (atomicInteger.get() == i3) {
                zzauVar.zzb.zzm(zzdtz.FLICK);
            } else {
                zzauVar.zzb.zzm(zzdtz.NONE);
            }
        }
        zzauVar.zzr();
    }

    public static /* synthetic */ void zzg(zzau zzauVar, String str, DialogInterface dialogInterface, int i) {
        com.google.android.gms.ads.internal.zzv.zzq();
        zzs.zzU(zzauVar.zza, Intent.createChooser(new Intent("android.intent.action.SEND").setType(AssetHelper.DEFAULT_MIME_TYPE).putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    public static /* synthetic */ void zzi(zzau zzauVar) {
        zzauVar.zzg = 4;
        zzauVar.zzr();
    }

    public static /* synthetic */ void zzj(zzau zzauVar) {
        zzay zzayVarZzt = com.google.android.gms.ads.internal.zzv.zzt();
        Context context = zzauVar.zza;
        String str = zzauVar.zzd;
        String str2 = zzauVar.zze;
        if (!zzayVarZzt.zzk(context, str, str2)) {
            zzayVarZzt.zzi(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if ("2".equals(zzayVarZzt.zza)) {
            int i = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Creative is not pushed for this device.");
            zzayVarZzt.zzi(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(zzayVarZzt.zza)) {
            int i2 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("The app is not linked for creative preview.");
            zzayVarZzt.zzd(context, str, str2);
        } else if ("0".equals(zzayVarZzt.zza)) {
            int i3 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Device is linked for in app preview.");
            zzayVarZzt.zzi(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public static /* synthetic */ void zzl(final zzau zzauVar, zzgcd zzgcdVar) {
        zzay zzayVarZzt = com.google.android.gms.ads.internal.zzv.zzt();
        Context context = zzauVar.zza;
        if (zzayVarZzt.zzj(context, zzauVar.zzd, zzauVar.zze)) {
            zzgcdVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzaj
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.gms.ads.internal.zzv.zzt().zzc(this.zza.zza);
                }
            });
        } else {
            com.google.android.gms.ads.internal.zzv.zzt().zzd(context, zzauVar.zzd, zzauVar.zze);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(Context context) {
        final int i;
        ArrayList arrayList = new ArrayList();
        int iZzu = zzu(arrayList, "None", true);
        final int iZzu2 = zzu(arrayList, "Shake", true);
        final int iZzu3 = zzu(arrayList, "Flick", true);
        int iOrdinal = this.zzb.zza().ordinal();
        if (iOrdinal != 1) {
            i = iOrdinal != 2 ? iZzu : iZzu3;
        } else {
            i = iZzu2;
        }
        com.google.android.gms.ads.internal.zzv.zzq();
        AlertDialog.Builder builderZzL = zzs.zzL(context);
        final AtomicInteger atomicInteger = new AtomicInteger(i);
        builderZzL.setTitle("Setup gesture");
        builderZzL.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), i, new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzan
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                atomicInteger.set(i2);
            }
        });
        builderZzL.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzao
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.zza.zzr();
            }
        });
        builderZzL.setPositiveButton("Save", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzap
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                zzau.zzf(this.zza, atomicInteger, i, iZzu2, iZzu3, dialogInterface, i2);
            }
        });
        builderZzL.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.ads.internal.util.zzaq
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.zza.zzr();
            }
        });
        builderZzL.create().show();
    }

    private final boolean zzt(float f, float f2, float f3, float f4) {
        return Math.abs(this.zzi.x - f) < ((float) this.zzh) && Math.abs(this.zzi.y - f2) < ((float) this.zzh) && Math.abs(this.zzj.x - f3) < ((float) this.zzh) && Math.abs(this.zzj.y - f4) < ((float) this.zzh);
    }

    private static final int zzu(List list, String str, boolean z) {
        if (!z) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.zzc);
        sb.append(",DebugSignal: ");
        sb.append(this.zzf);
        sb.append(",AFMA Version: ");
        sb.append(this.zze);
        sb.append(",Ad Unit ID: ");
        sb.append(this.zzd);
        sb.append("}");
        return sb.toString();
    }

    public final void zzm(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.zzg = 0;
            this.zzi = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i = this.zzg;
        if (i == -1) {
            return;
        }
        if (i == 0) {
            if (actionMasked == 5) {
                this.zzg = 5;
                this.zzj = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                this.zzk.postDelayed(this.zzl, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeT)).longValue());
                return;
            }
            return;
        }
        if (i == 5) {
            if (pointerCount == 2) {
                if (actionMasked != 2) {
                    return;
                }
                boolean z = false;
                for (int i2 = 0; i2 < historySize; i2++) {
                    z |= !zzt(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2));
                }
                if (zzt(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z) {
                    return;
                }
            }
            this.zzg = -1;
            this.zzk.removeCallbacks(this.zzl);
        }
    }

    public final void zzn(String str) {
        this.zzd = str;
    }

    public final void zzo(String str) {
        this.zze = str;
    }

    public final void zzp(String str) {
        this.zzc = str;
    }

    public final void zzq(String str) {
        this.zzf = str;
    }

    public final void zzr() {
        try {
            Context context = this.zza;
            if (!(context instanceof Activity)) {
                int i = zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = "Creative preview (enabled)";
            if (true == TextUtils.isEmpty(com.google.android.gms.ads.internal.zzv.zzt().zzb())) {
                str = "Creative preview";
            }
            String str2 = true != com.google.android.gms.ads.internal.zzv.zzt().zzm() ? "Troubleshooting" : "Troubleshooting (enabled)";
            ArrayList arrayList = new ArrayList();
            final int iZzu = zzu(arrayList, "Ad information", true);
            final int iZzu2 = zzu(arrayList, str, true);
            final int iZzu3 = zzu(arrayList, str2, true);
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzjn)).booleanValue();
            final int iZzu4 = zzu(arrayList, "Open ad inspector", zBooleanValue);
            final int iZzu5 = zzu(arrayList, "Ad inspector settings", zBooleanValue);
            com.google.android.gms.ads.internal.zzv.zzq();
            AlertDialog.Builder builderZzL = zzs.zzL(context);
            builderZzL.setTitle("Select a debug mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzam
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    zzau.zzc(this.zza, iZzu, iZzu2, iZzu3, iZzu4, iZzu5, dialogInterface, i2);
                }
            });
            builderZzL.create().show();
        } catch (WindowManager.BadTokenException e) {
            zze.zzb("", e);
        }
    }

    public zzau(Context context, String str) {
        this(context);
        this.zzc = str;
    }
}
