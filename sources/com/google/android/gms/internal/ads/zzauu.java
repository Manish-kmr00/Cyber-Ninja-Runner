package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public abstract class zzauu implements zzaut {
    protected static volatile zzawb zza;
    protected MotionEvent zzb;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected DisplayMetrics zzq;
    protected zzavt zzr;
    private double zzs;
    private double zzt;
    protected final LinkedList zzc = new LinkedList();
    protected long zzd = 0;
    protected long zze = 0;
    protected long zzf = 0;
    protected long zzg = 0;
    protected long zzh = 0;
    protected long zzi = 0;
    protected long zzj = 0;
    private boolean zzu = false;
    protected boolean zzp = false;

    protected zzauu(Context context) {
        try {
            zzatw.zze();
            this.zzq = context.getResources().getDisplayMetrics();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzda)).booleanValue()) {
                this.zzr = new zzavt();
            }
        } catch (Throwable unused) {
        }
    }

    private final void zzm() {
        this.zzh = 0L;
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzg = 0L;
        this.zzi = 0L;
        this.zzj = 0L;
        LinkedList linkedList = this.zzc;
        if (linkedList.isEmpty()) {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        } else {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            linkedList.clear();
        }
        this.zzb = null;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b4 A[Catch: Exception -> 0x00ee, TryCatch #0 {Exception -> 0x00ee, blocks: (B:45:0x00a7, B:48:0x00b4, B:57:0x00d8, B:58:0x00e8), top: B:73:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:52:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e8 A[Catch: Exception -> 0x00ee, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ee, blocks: (B:45:0x00a7, B:48:0x00b4, B:57:0x00d8, B:58:0x00e8), top: B:73:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private final String zzp(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        zzaus zzausVarZzd;
        String str2;
        int i2;
        Exception exc;
        int i3;
        int i4;
        long jCurrentTimeMillis;
        String strZzb;
        int i5;
        int i6;
        zzarz zzarzVarZzc;
        int i7;
        int i8;
        int i9 = i;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcM)).booleanValue();
        zzarz zzarzVarZzb = null;
        if (zBooleanValue) {
            zzausVarZzd = zza != null ? zza.zzd() : null;
            str2 = ApsMetricsDataMap.APSMETRICS_FIELD_BIDEVENT;
        } else {
            zzausVarZzd = null;
            str2 = null;
        }
        int i10 = 1;
        try {
            if (i9 == 3) {
                zzarzVarZzb = zzb(context, view, activity);
                try {
                    this.zzu = true;
                    i8 = 1002;
                } catch (Exception e) {
                    exc = e;
                    i2 = 3;
                    i10 = 1;
                    if (!zBooleanValue) {
                    }
                    jCurrentTimeMillis = System.currentTimeMillis();
                    if (zzarzVarZzb != null) {
                        try {
                            if (((zzasu) zzarzVarZzb.zzbr()).zzaY() == 0) {
                                strZzb = Integer.toString(5);
                            } else {
                                zzasu zzasuVar = (zzasu) zzarzVarZzb.zzbr();
                                int i11 = zzatw.zzc;
                                strZzb = zzatw.zzb(zzasuVar.zzaV(), str);
                                if (zBooleanValue) {
                                    if (i9 == i2) {
                                        i5 = 1006;
                                    } else if (i9 == i3) {
                                        i5 = 1010;
                                    } else {
                                        i5 = 1004;
                                    }
                                    zzausVarZzd.zzc(i5, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
                                }
                            }
                        } catch (Exception e2) {
                            strZzb = Integer.toString(7);
                            if (zBooleanValue && zzausVarZzd != null) {
                                if (i9 == i2) {
                                    i6 = 1007;
                                } else {
                                    i6 = i9 == i3 ? 1011 : 1005;
                                }
                                zzausVarZzd.zzc(i6, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, e2);
                            }
                        }
                    } else {
                        strZzb = Integer.toString(5);
                    }
                    return strZzb;
                }
            } else {
                if (i9 == 2) {
                    zzarzVarZzc = zzi(context, view, activity);
                    i7 = 1008;
                } else {
                    zzarzVarZzc = zzc(context, null);
                    i7 = 1000;
                }
                zzarzVarZzb = zzarzVarZzc;
                i8 = i7;
            }
            if (!zBooleanValue || zzausVarZzd == null) {
                i2 = 3;
            } else {
                i2 = 3;
                try {
                    zzausVarZzd.zzc(i8, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2, null);
                } catch (Exception e3) {
                    e = e3;
                    exc = e;
                    if (!zBooleanValue && zzausVarZzd != null) {
                        if (i9 == i2) {
                            i4 = 1003;
                            i3 = 2;
                        } else {
                            i3 = 2;
                            if (i9 == 2) {
                                i4 = 1009;
                            } else {
                                i4 = 1001;
                                i9 = i10;
                            }
                        }
                        zzausVarZzd.zzc(i4, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2, exc);
                    }
                    jCurrentTimeMillis = System.currentTimeMillis();
                    if (zzarzVarZzb != null) {
                        strZzb = Integer.toString(5);
                    } else if (((zzasu) zzarzVarZzb.zzbr()).zzaY() == 0) {
                        strZzb = Integer.toString(5);
                    } else {
                        zzasu zzasuVar2 = (zzasu) zzarzVarZzb.zzbr();
                        int i12 = zzatw.zzc;
                        strZzb = zzatw.zzb(zzasuVar2.zzaV(), str);
                        if (zBooleanValue) {
                            if (i9 == i2) {
                                i5 = 1006;
                            } else if (i9 == i3) {
                                i5 = 1010;
                            } else {
                                i5 = 1004;
                            }
                            zzausVarZzd.zzc(i5, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
                        }
                    }
                    return strZzb;
                }
            }
        } catch (Exception e4) {
            e = e4;
            i2 = 3;
        }
        i3 = 2;
        jCurrentTimeMillis = System.currentTimeMillis();
        if (zzarzVarZzb != null) {
            strZzb = Integer.toString(5);
        } else if (((zzasu) zzarzVarZzb.zzbr()).zzaY() == 0) {
            strZzb = Integer.toString(5);
        } else {
            zzasu zzasuVar3 = (zzasu) zzarzVarZzb.zzbr();
            int i13 = zzatw.zzc;
            strZzb = zzatw.zzb(zzasuVar3.zzaV(), str);
            if (zBooleanValue && zzausVarZzd != null) {
                if (i9 == i2) {
                    i5 = 1006;
                } else if (i9 == i3) {
                    i5 = 1010;
                } else {
                    i5 = 1004;
                }
                zzausVarZzd.zzc(i5, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
            }
        }
        return strZzb;
    }

    protected abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzavr;

    protected abstract zzarz zzb(Context context, View view, Activity activity);

    protected abstract zzarz zzc(Context context, zzarm zzarmVar);

    @Override // com.google.android.gms.internal.ads.zzaut
    public final String zzd(Context context, String str, View view) {
        return zzp(context, str, 3, view, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final String zze(Context context, String str, View view, Activity activity) {
        return zzp(context, str, 3, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final String zzf(Context context) {
        if (zzawe.zzc()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return zzp(context, null, 1, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final String zzg(Context context) {
        return "19";
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final String zzh(Context context, View view, Activity activity) {
        return zzp(context, null, 2, view, activity, null);
    }

    protected abstract zzarz zzi(Context context, View view, Activity activity);

    protected abstract zzawd zzj(MotionEvent motionEvent) throws zzavr;

    @Override // com.google.android.gms.internal.ads.zzaut
    public final synchronized void zzk(MotionEvent motionEvent) {
        Long l;
        if (this.zzu) {
            zzm();
            this.zzu = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzk = 0.0d;
            this.zzs = motionEvent.getRawX();
            this.zzt = motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            double d = rawX - this.zzs;
            double d2 = rawY - this.zzt;
            this.zzk += Math.sqrt((d * d) + (d2 * d2));
            this.zzs = rawX;
            this.zzt = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            try {
                if (action2 == 1) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    this.zzb = motionEventObtain;
                    LinkedList linkedList = this.zzc;
                    linkedList.add(motionEventObtain);
                    if (linkedList.size() > 6) {
                        ((MotionEvent) linkedList.remove()).recycle();
                    }
                    this.zzf++;
                    this.zzh = zza(new Throwable().getStackTrace());
                } else if (action2 == 2) {
                    this.zze += (long) (motionEvent.getHistorySize() + 1);
                    zzawd zzawdVarZzj = zzj(motionEvent);
                    Long l2 = zzawdVarZzj.zzd;
                    if (l2 != null && zzawdVarZzj.zzg != null) {
                        this.zzi += l2.longValue() + zzawdVarZzj.zzg.longValue();
                    }
                    if (this.zzq != null && (l = zzawdVarZzj.zze) != null && zzawdVarZzj.zzh != null) {
                        this.zzj += l.longValue() + zzawdVarZzj.zzh.longValue();
                    }
                } else if (action2 == 3) {
                    this.zzg++;
                }
            } catch (zzavr unused) {
            }
        } else {
            this.zzl = motionEvent.getX();
            this.zzm = motionEvent.getY();
            this.zzn = motionEvent.getRawX();
            this.zzo = motionEvent.getRawY();
            this.zzd++;
        }
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final synchronized void zzl(int i, int i2, int i3) {
        if (this.zzb != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcK)).booleanValue()) {
                zzm();
            } else {
                this.zzb.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzq;
        if (displayMetrics != null) {
            this.zzb = MotionEvent.obtain(0L, i3, 1, i * displayMetrics.density, i2 * this.zzq.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzb = null;
        }
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzavt zzavtVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzda)).booleanValue() || (zzavtVar = this.zzr) == null) {
            return;
        }
        zzavtVar.zzb(Arrays.asList(stackTraceElementArr));
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public void zzo(View view) {
    }
}
