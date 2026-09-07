package com.google.android.gms.internal.play_billing;

import com.json.b9;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes11.dex */
public class zzq implements zzeu {
    static final zzf zzb;
    public static final /* synthetic */ int zzf = 0;
    private static final Object zzh;
    volatile Object zzc;
    volatile zzj zzd;
    volatile zzo zze;
    static final boolean zza = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger zzg = Logger.getLogger(zzq.class.getName());

    static {
        zzf zznVar;
        try {
            zznVar = new zzl(AtomicReferenceFieldUpdater.newUpdater(zzo.class, Thread.class, "zzb"), AtomicReferenceFieldUpdater.newUpdater(zzo.class, zzo.class, "zzc"), AtomicReferenceFieldUpdater.newUpdater(zzq.class, zzo.class, "zze"), AtomicReferenceFieldUpdater.newUpdater(zzq.class, zzj.class, "zzd"), AtomicReferenceFieldUpdater.newUpdater(zzq.class, Object.class, "zzc"));
            th = null;
        } catch (Throwable th) {
            th = th;
            zznVar = new zzn();
        }
        Throwable th2 = th;
        zzb = zznVar;
        if (th2 != null) {
            zzg.logp(Level.SEVERE, "com.android.billingclient.util.concurrent.AbstractResolvableFuture", "<clinit>", "SafeAtomicHelper is broken!", th2);
        }
        zzh = new Object();
    }

    protected zzq() {
    }

    static void zzc(zzq zzqVar) {
        zzo zzoVar;
        zzj zzjVar;
        do {
            zzoVar = zzqVar.zze;
        } while (!zzb.zze(zzqVar, zzoVar, zzo.zza));
        while (zzoVar != null) {
            Thread thread = zzoVar.zzb;
            if (thread != null) {
                zzoVar.zzb = null;
                LockSupport.unpark(thread);
            }
            zzoVar = zzoVar.zzc;
        }
        do {
            zzjVar = zzqVar.zzd;
        } while (!zzb.zzc(zzqVar, zzjVar, zzj.zza));
        zzj zzjVar2 = null;
        while (zzjVar != null) {
            zzj zzjVar3 = zzjVar.zzd;
            zzjVar.zzd = zzjVar2;
            zzjVar2 = zzjVar;
            zzjVar = zzjVar3;
        }
        while (zzjVar2 != null) {
            Runnable runnable = zzjVar2.zzb;
            zzj zzjVar4 = zzjVar2.zzd;
            if (runnable instanceof zzm) {
                zzq zzqVar2 = ((zzm) runnable).zza;
                throw null;
            }
            zzf(runnable, zzjVar2.zzc);
            zzjVar2 = zzjVar4;
        }
    }

    private final void zze(StringBuilder sb) {
        V v;
        boolean z = false;
        while (true) {
            try {
                try {
                    v = get();
                    break;
                } catch (CancellationException unused) {
                    sb.append("CANCELLED");
                    return;
                } catch (RuntimeException e) {
                    sb.append("UNKNOWN, cause=[");
                    sb.append(e.getClass());
                    sb.append(" thrown from get()]");
                    return;
                } catch (ExecutionException e2) {
                    sb.append("FAILURE, cause=[");
                    sb.append(e2.getCause());
                    sb.append(b9.i.e);
                    return;
                }
            } catch (InterruptedException unused2) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        sb.append(v == this ? "this future" : String.valueOf(v));
        sb.append(b9.i.e);
    }

    private static void zzf(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            zzg.logp(Level.SEVERE, "com.android.billingclient.util.concurrent.AbstractResolvableFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e);
        }
    }

    private final void zzg(zzo zzoVar) {
        zzoVar.zzb = null;
        while (true) {
            zzo zzoVar2 = this.zze;
            if (zzoVar2 != zzo.zza) {
                zzo zzoVar3 = null;
                while (zzoVar2 != null) {
                    zzo zzoVar4 = zzoVar2.zzc;
                    if (zzoVar2.zzb != null) {
                        zzoVar3 = zzoVar2;
                    } else if (zzoVar3 != null) {
                        zzoVar3.zzc = zzoVar4;
                        if (zzoVar3.zzb == null) {
                        }
                    } else if (!zzb.zze(this, zzoVar2, zzoVar4)) {
                    }
                    zzoVar2 = zzoVar4;
                }
                return;
            }
            return;
        }
    }

    private static final Object zzh(Object obj) throws ExecutionException {
        if (obj instanceof zzg) {
            Throwable th = ((zzg) obj).zzc;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzi) {
            throw new ExecutionException(((zzi) obj).zza);
        }
        if (obj == zzh) {
            return null;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        zzg zzgVar;
        Object obj = this.zzc;
        if ((obj instanceof zzm) | (obj == null)) {
            if (zza) {
                zzgVar = new zzg(z, new CancellationException("Future.cancel() was called."));
            } else {
                zzgVar = z ? zzg.zza : zzg.zzb;
            }
            while (!zzb.zzd(this, obj, zzgVar)) {
                obj = this.zzc;
                if (!(obj instanceof zzm)) {
                }
            }
            zzc(this);
            if (!(obj instanceof zzm)) {
                return true;
            }
            zzeu zzeuVar = ((zzm) obj).zzb;
            throw null;
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.zzc;
        if ((obj2 != null) && (!(obj2 instanceof zzm))) {
            return zzh(obj2);
        }
        zzo zzoVar = this.zze;
        if (zzoVar != zzo.zza) {
            zzo zzoVar2 = new zzo();
            do {
                zzf zzfVar = zzb;
                zzfVar.zza(zzoVar2, zzoVar);
                if (zzfVar.zze(this, zzoVar, zzoVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zzg(zzoVar2);
                            throw new InterruptedException();
                        }
                        obj = this.zzc;
                    } while (!((obj != null) & (!(obj instanceof zzm))));
                    return zzh(obj);
                }
                zzoVar = this.zze;
            } while (zzoVar != zzo.zza);
        }
        return zzh(this.zzc);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zzc instanceof zzg;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.zzc;
        return (obj != null) & (!(obj instanceof zzm));
    }

    public final String toString() {
        String strConcat;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.zzc instanceof zzg) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zze(sb);
        } else {
            try {
                strConcat = zza();
            } catch (RuntimeException e) {
                strConcat = "Exception thrown from implementation: ".concat(String.valueOf(String.valueOf(e.getClass())));
            }
            if (strConcat != null && !strConcat.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strConcat);
                sb.append(b9.i.e);
            } else if (isDone()) {
                zze(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append(b9.i.e);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String zza() {
        Object obj = this.zzc;
        if (obj instanceof zzm) {
            zzeu zzeuVar = ((zzm) obj).zzb;
            return "setFuture=[null]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected boolean zzd(Object obj) {
        if (obj == null) {
            obj = zzh;
        }
        if (!zzb.zzd(this, null, obj)) {
            return false;
        }
        zzc(this);
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeu
    public final void zzb(Runnable runnable, Executor executor) {
        executor.getClass();
        zzj zzjVar = this.zzd;
        if (zzjVar != zzj.zza) {
            zzj zzjVar2 = new zzj(runnable, executor);
            do {
                zzjVar2.zzd = zzjVar;
                if (zzb.zzc(this, zzjVar, zzjVar2)) {
                    return;
                } else {
                    zzjVar = this.zzd;
                }
            } while (zzjVar != zzj.zza);
        }
        zzf(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.zzc;
            boolean z = true;
            if ((obj != null) & (!(obj instanceof zzm))) {
                return zzh(obj);
            }
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                zzo zzoVar = this.zze;
                if (zzoVar != zzo.zza) {
                    zzo zzoVar2 = new zzo();
                    while (true) {
                        zzf zzfVar = zzb;
                        zzfVar.zza(zzoVar2, zzoVar);
                        if (zzfVar.zze(this, zzoVar, zzoVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (Thread.interrupted()) {
                                    zzg(zzoVar2);
                                    throw new InterruptedException();
                                }
                                Object obj2 = this.zzc;
                                if (!((obj2 != null) & (!(obj2 instanceof zzm)))) {
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    return zzh(obj2);
                                }
                            } while (nanos >= 1000);
                            zzg(zzoVar2);
                            break;
                        }
                        zzoVar = this.zze;
                        if (zzoVar == zzo.zza) {
                        }
                    }
                }
                return zzh(this.zzc);
            }
            while (nanos > 0) {
                Object obj3 = this.zzc;
                if (!((obj3 != null) & (!(obj3 instanceof zzm)))) {
                    if (!Thread.interrupted()) {
                        nanos = jNanoTime - System.nanoTime();
                    } else {
                        throw new InterruptedException();
                    }
                } else {
                    return zzh(obj3);
                }
            }
            String string = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String strConcat = "Waited " + j + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
            if (nanos + 1000 < 0) {
                String strConcat2 = strConcat.concat(" (plus ");
                long j2 = -nanos;
                long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(jConvert);
                if (jConvert != 0 && nanos2 <= 1000) {
                    z = false;
                }
                if (jConvert > 0) {
                    String strConcat3 = strConcat2 + jConvert + " " + lowerCase;
                    if (z) {
                        strConcat3 = strConcat3.concat(StringUtils.COMMA);
                    }
                    strConcat2 = strConcat3.concat(" ");
                }
                if (z) {
                    strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
                }
                strConcat = strConcat2.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(strConcat + " for " + string);
        }
        throw new InterruptedException();
    }
}
