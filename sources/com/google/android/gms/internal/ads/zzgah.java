package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
abstract class zzgah<V> extends zzgcw implements ListenableFuture<V> {
    private static final zza zza;
    static final Object zze = new Object();
    static final zzgcb zzf = new zzgcb(zzgag.class);
    static final boolean zzg;
    public static final /* synthetic */ int zzh = 0;
    private volatile zzgag.zzd listeners;
    private volatile Object value;
    private volatile zze waiters;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
    abstract class zza {
        /* synthetic */ zza(zzgal zzgalVar) {
        }

        abstract zzgag.zzd zza(zzgah zzgahVar, zzgag.zzd zzdVar);

        abstract zze zzb(zzgah zzgahVar, zze zzeVar);

        abstract void zzc(zze zzeVar, zze zzeVar2);

        abstract void zzd(zze zzeVar, Thread thread);

        abstract boolean zze(zzgah zzgahVar, zzgag.zzd zzdVar, zzgag.zzd zzdVar2);

        abstract boolean zzf(zzgah zzgahVar, Object obj, Object obj2);

        abstract boolean zzg(zzgah zzgahVar, zze zzeVar, zze zzeVar2);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
    final class zzb extends zza {
        private static final AtomicReferenceFieldUpdater<zze, Thread> zza = AtomicReferenceFieldUpdater.newUpdater(zze.class, Thread.class, "thread");
        private static final AtomicReferenceFieldUpdater<zze, zze> zzb = AtomicReferenceFieldUpdater.newUpdater(zze.class, zze.class, "next");
        private static final AtomicReferenceFieldUpdater<? super zzgah<?>, zze> zzc;
        private static final AtomicReferenceFieldUpdater<? super zzgah<?>, zzgag.zzd> zzd;
        private static final AtomicReferenceFieldUpdater<? super zzgah<?>, Object> zze;

        static {
            int i = zzgah.zzh;
            zzc = AtomicReferenceFieldUpdater.newUpdater(zzgah.class, zze.class, "waiters");
            zzd = AtomicReferenceFieldUpdater.newUpdater(zzgah.class, zzgag.zzd.class, "listeners");
            zze = AtomicReferenceFieldUpdater.newUpdater(zzgah.class, Object.class, "value");
        }

        private zzb() {
            throw null;
        }

        /* synthetic */ zzb(zzgal zzgalVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final zzgag.zzd zza(zzgah zzgahVar, zzgag.zzd zzdVar) {
            return zzd.getAndSet(zzgahVar, zzdVar);
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final zze zzb(zzgah zzgahVar, zze zzeVar) {
            return zzc.getAndSet(zzgahVar, zzeVar);
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final void zzc(zze zzeVar, zze zzeVar2) {
            zzb.lazySet(zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final void zzd(zze zzeVar, Thread thread) {
            zza.lazySet(zzeVar, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final boolean zze(zzgah zzgahVar, zzgag.zzd zzdVar, zzgag.zzd zzdVar2) {
            return zzgai.zza(zzd, zzgahVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final boolean zzf(zzgah zzgahVar, Object obj, Object obj2) {
            return zzgai.zza(zze, zzgahVar, obj, obj2);
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final boolean zzg(zzgah zzgahVar, zze zzeVar, zze zzeVar2) {
            return zzgai.zza(zzc, zzgahVar, zzeVar, zzeVar2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
    final class zzc extends zza {
        private zzc() {
            throw null;
        }

        /* synthetic */ zzc(zzgal zzgalVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final zzgag.zzd zza(zzgah zzgahVar, zzgag.zzd zzdVar) {
            zzgag.zzd zzdVar2;
            synchronized (zzgahVar) {
                zzdVar2 = zzgahVar.listeners;
                if (zzdVar2 != zzdVar) {
                    zzgahVar.listeners = zzdVar;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final zze zzb(zzgah zzgahVar, zze zzeVar) {
            zze zzeVar2;
            synchronized (zzgahVar) {
                zzeVar2 = zzgahVar.waiters;
                if (zzeVar2 != zzeVar) {
                    zzgahVar.waiters = zzeVar;
                }
            }
            return zzeVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final void zzc(zze zzeVar, zze zzeVar2) {
            zzeVar.next = zzeVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final void zzd(zze zzeVar, Thread thread) {
            zzeVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final boolean zze(zzgah zzgahVar, zzgag.zzd zzdVar, zzgag.zzd zzdVar2) {
            synchronized (zzgahVar) {
                if (zzgahVar.listeners != zzdVar) {
                    return false;
                }
                zzgahVar.listeners = zzdVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final boolean zzf(zzgah zzgahVar, Object obj, Object obj2) {
            synchronized (zzgahVar) {
                if (zzgahVar.value != obj) {
                    return false;
                }
                zzgahVar.value = obj2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final boolean zzg(zzgah zzgahVar, zze zzeVar, zze zzeVar2) {
            synchronized (zzgahVar) {
                if (zzgahVar.waiters != zzeVar) {
                    return false;
                }
                zzgahVar.waiters = zzeVar2;
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
    final class zzd extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;
        public static final /* synthetic */ int zzg = 0;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: com.google.android.gms.internal.ads.zzgak
                        @Override // java.security.PrivilegedExceptionAction
                        public final Object run() throws IllegalAccessException {
                            int i = zzgah.zzd.zzg;
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                if (Unsafe.class.isInstance(obj)) {
                                    return (Unsafe) Unsafe.class.cast(obj);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
                }
                try {
                    zzc = unsafe.objectFieldOffset(zzgah.class.getDeclaredField("waiters"));
                    zzb = unsafe.objectFieldOffset(zzgah.class.getDeclaredField("listeners"));
                    zzd = unsafe.objectFieldOffset(zzgah.class.getDeclaredField("value"));
                    zze = unsafe.objectFieldOffset(zze.class.getDeclaredField("thread"));
                    zzf = unsafe.objectFieldOffset(zze.class.getDeclaredField("next"));
                    zza = unsafe;
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        }

        private zzd() {
            throw null;
        }

        /* synthetic */ zzd(zzgal zzgalVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final zzgag.zzd zza(zzgah zzgahVar, zzgag.zzd zzdVar) {
            zzgag.zzd zzdVar2;
            do {
                zzdVar2 = zzgahVar.listeners;
                if (zzdVar == zzdVar2) {
                    break;
                }
            } while (!zze(zzgahVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final zze zzb(zzgah zzgahVar, zze zzeVar) {
            zze zzeVar2;
            do {
                zzeVar2 = zzgahVar.waiters;
                if (zzeVar == zzeVar2) {
                    break;
                }
            } while (!zzg(zzgahVar, zzeVar2, zzeVar));
            return zzeVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final void zzc(zze zzeVar, zze zzeVar2) {
            zza.putObject(zzeVar, zzf, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final void zzd(zze zzeVar, Thread thread) {
            zza.putObject(zzeVar, zze, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final boolean zze(zzgah zzgahVar, zzgag.zzd zzdVar, zzgag.zzd zzdVar2) {
            return zzgaj.zza(zza, zzgahVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final boolean zzf(zzgah zzgahVar, Object obj, Object obj2) {
            return zzgaj.zza(zza, zzgahVar, zzd, obj, obj2);
        }

        @Override // com.google.android.gms.internal.ads.zzgah.zza
        final boolean zzg(zzgah zzgahVar, zze zzeVar, zze zzeVar2) {
            return zzgaj.zza(zza, zzgahVar, zzc, zzeVar, zzeVar2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
    final class zze {
        static final zze zza = new zze(false);
        volatile zze next;
        volatile Thread thread;

        zze() {
            zzgah.zzA(this, Thread.currentThread());
        }

        zze(boolean z) {
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zzcVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        zzg = z;
        zzgal zzgalVar = null;
        try {
            zzcVar = new zzd(zzgalVar);
            th = null;
            th2 = null;
        } catch (Error | Exception e) {
            try {
                th2 = null;
                th = e;
                zzcVar = new zzb(zzgalVar);
            } catch (Error | Exception e2) {
                th = e;
                th2 = e2;
                zzcVar = new zzc(zzgalVar);
            }
        }
        zza = zzcVar;
        if (th2 != null) {
            zzgcb zzgcbVar = zzf;
            zzgcbVar.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "UnsafeAtomicHelper is broken!", th);
            zzgcbVar.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "AtomicReferenceFieldUpdaterAtomicHelper is broken!", th2);
        }
    }

    zzgah() {
    }

    static /* synthetic */ void zzA(zze zzeVar, Thread thread) {
        zza.zzd(zzeVar, thread);
    }

    static boolean zzD(zzgah zzgahVar, Object obj, Object obj2) {
        return zza.zzf(zzgahVar, obj, obj2);
    }

    private final void zza(zze zzeVar) {
        zzeVar.thread = null;
        while (true) {
            zze zzeVar2 = this.waiters;
            if (zzeVar2 != zze.zza) {
                zze zzeVar3 = null;
                while (zzeVar2 != null) {
                    zze zzeVar4 = zzeVar2.next;
                    if (zzeVar2.thread != null) {
                        zzeVar3 = zzeVar2;
                    } else if (zzeVar3 != null) {
                        zzeVar3.next = zzeVar4;
                        if (zzeVar3.thread == null) {
                        }
                    } else if (!zza.zzg(this, zzeVar2, zzeVar4)) {
                    }
                    zzeVar2 = zzeVar4;
                }
                return;
            }
            return;
        }
    }

    final void zzB() {
        for (zze zzeVarZzb = zza.zzb(this, zze.zza); zzeVarZzb != null; zzeVarZzb = zzeVarZzb.next) {
            Thread thread = zzeVarZzb.thread;
            if (thread != null) {
                zzeVarZzb.thread = null;
                LockSupport.unpark(thread);
            }
        }
    }

    final boolean zzC(zzgag.zzd zzdVar, zzgag.zzd zzdVar2) {
        return zza.zze(this, zzdVar, zzdVar2);
    }

    final zzgag.zzd zzq(zzgag.zzd zzdVar) {
        return zza.zza(this, zzdVar);
    }

    final zzgag.zzd zzr() {
        return this.listeners;
    }

    final Object zzu() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && zzgag.zzm(obj2)) {
            return zzgag.zzh(obj2);
        }
        zze zzeVar = this.waiters;
        if (zzeVar != zze.zza) {
            zze zzeVar2 = new zze();
            do {
                zza zzaVar = zza;
                zzaVar.zzc(zzeVar2, zzeVar);
                if (zzaVar.zzg(this, zzeVar, zzeVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zza(zzeVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & zzgag.zzm(obj)));
                    return zzgag.zzh(obj);
                }
                zzeVar = this.waiters;
            } while (zzeVar != zze.zza);
        }
        return zzgag.zzh(Objects.requireNonNull(this.value));
    }

    final Object zzv(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        boolean z = true;
        if ((obj != null) && zzgag.zzm(obj)) {
            return zzgag.zzh(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            zze zzeVar = this.waiters;
            if (zzeVar != zze.zza) {
                zze zzeVar2 = new zze();
                while (true) {
                    zza zzaVar = zza;
                    zzaVar.zzc(zzeVar2, zzeVar);
                    if (zzaVar.zzg(this, zzeVar, zzeVar2)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                zza(zzeVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && zzgag.zzm(obj2)) {
                                return zzgag.zzh(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        zza(zzeVar2);
                        break;
                    }
                    zzeVar = this.waiters;
                    if (zzeVar == zze.zza) {
                    }
                }
            }
            return zzgag.zzh(Objects.requireNonNull(this.value));
        }
        while (nanos > 0) {
            Object obj3 = this.value;
            if ((obj3 != null) && zzgag.zzm(obj3)) {
                return zzgag.zzh(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
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

    final Object zzw() {
        return this.value;
    }
}
