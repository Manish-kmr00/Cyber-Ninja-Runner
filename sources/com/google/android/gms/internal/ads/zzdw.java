package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzdw {
    private final zzdg zza;
    private final zzdq zzb;
    private final zzdu zzc;
    private final CopyOnWriteArraySet zzd;
    private final ArrayDeque zze;
    private final ArrayDeque zzf;
    private final Object zzg;
    private boolean zzh;
    private boolean zzi;

    public zzdw(Looper looper, zzdg zzdgVar, zzdu zzduVar) {
        this(new CopyOnWriteArraySet(), looper, zzdgVar, zzduVar, true);
    }

    public static /* synthetic */ boolean zzg(zzdw zzdwVar, Message message) {
        Iterator it = zzdwVar.zzd.iterator();
        while (it.hasNext()) {
            ((zzdv) it.next()).zzb(zzdwVar.zzc);
            if (zzdwVar.zzb.zzh(1)) {
                break;
            }
        }
        return true;
    }

    private final void zzh() {
        if (this.zzi) {
            zzdc.zzf(Thread.currentThread() == this.zzb.zza().getThread());
        }
    }

    public final zzdw zza(Looper looper, zzdu zzduVar) {
        return new zzdw(this.zzd, looper, this.zza, zzduVar, this.zzi);
    }

    public final void zzb(Object obj) {
        synchronized (this.zzg) {
            if (this.zzh) {
                return;
            }
            this.zzd.add(new zzdv(obj));
        }
    }

    public final void zzc() {
        zzh();
        ArrayDeque arrayDeque = this.zzf;
        if (arrayDeque.isEmpty()) {
            return;
        }
        zzdq zzdqVar = this.zzb;
        if (!zzdqVar.zzh(1)) {
            zzdqVar.zzl(zzdqVar.zzb(1));
        }
        ArrayDeque arrayDeque2 = this.zze;
        boolean zIsEmpty = arrayDeque2.isEmpty();
        arrayDeque2.addAll(arrayDeque);
        arrayDeque.clear();
        if (zIsEmpty) {
            while (!arrayDeque2.isEmpty()) {
                ((Runnable) arrayDeque2.peekFirst()).run();
                arrayDeque2.removeFirst();
            }
        }
    }

    public final void zzd(final int i, final zzdt zzdtVar) {
        zzh();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.zzd);
        this.zzf.add(new Runnable() { // from class: com.google.android.gms.internal.ads.zzds
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    zzdt zzdtVar2 = zzdtVar;
                    ((zzdv) it.next()).zza(i, zzdtVar2);
                }
            }
        });
    }

    public final void zze() {
        zzh();
        synchronized (this.zzg) {
            this.zzh = true;
        }
        CopyOnWriteArraySet copyOnWriteArraySet = this.zzd;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((zzdv) it.next()).zzc(this.zzc);
        }
        copyOnWriteArraySet.clear();
    }

    public final void zzf(Object obj) {
        zzh();
        CopyOnWriteArraySet<zzdv> copyOnWriteArraySet = this.zzd;
        for (zzdv zzdvVar : copyOnWriteArraySet) {
            if (zzdvVar.zza.equals(obj)) {
                zzdvVar.zzc(this.zzc);
                copyOnWriteArraySet.remove(zzdvVar);
            }
        }
    }

    private zzdw(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, zzdg zzdgVar, zzdu zzduVar, boolean z) {
        this.zza = zzdgVar;
        this.zzd = copyOnWriteArraySet;
        this.zzc = zzduVar;
        this.zzg = new Object();
        this.zze = new ArrayDeque();
        this.zzf = new ArrayDeque();
        this.zzb = zzdgVar.zzd(looper, new Handler.Callback() { // from class: com.google.android.gms.internal.ads.zzdr
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                zzdw.zzg(this.zza, message);
                return true;
            }
        });
        this.zzi = z;
    }
}
