package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import com.json.b9;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzgag<V> extends zzgah<V> {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
    /* JADX INFO: loaded from: classes12.dex */
    final class zza {
        static final zza zza;
        static final zza zzb;
        final boolean zzc;
        final Throwable zzd;

        static {
            if (zzgah.zzg) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zza(false, null);
                zza = new zza(true, null);
            }
        }

        zza(boolean z, Throwable th) {
            this.zzc = z;
            this.zzd = th;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
    /* JADX INFO: loaded from: classes12.dex */
    final class zzb<V> implements Runnable {
        final zzgag<V> zza;
        final ListenableFuture<? extends V> zzb;

        zzb(zzgag zzgagVar, ListenableFuture listenableFuture) {
            this.zza = zzgagVar;
            this.zzb = listenableFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.zza.zzw() != this) {
                return;
            }
            if (zzgah.zzD(this.zza, this, zzgag.zze(this.zzb))) {
                zzgag.zzF(this.zza, false);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
    /* JADX INFO: loaded from: classes12.dex */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.ads.zzgag.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
    /* JADX INFO: loaded from: classes12.dex */
    final class zzd {
        static final zzd zza = new zzd();
        zzd next;
        final Runnable zzb;
        final Executor zzc;

        zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
    /* JADX INFO: loaded from: classes12.dex */
    interface zze<V> extends ListenableFuture<V> {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
    /* JADX INFO: loaded from: classes12.dex */
    abstract class zzf<V> extends zzgag<V> implements zze<V> {
        zzf() {
        }
    }

    protected zzgag() {
    }

    private final void zzE(StringBuilder sb) {
        try {
            Object objZzf = zzf(this);
            sb.append("SUCCESS, result=[");
            if (objZzf == null) {
                sb.append("null");
            } else if (objZzf == this) {
                sb.append("this future");
            } else {
                sb.append(objZzf.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objZzf)));
            }
            sb.append(b9.i.e);
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append(b9.i.e);
        } catch (Exception e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzF(zzgag zzgagVar, boolean z) {
        zzd zzdVar = null;
        while (true) {
            zzgagVar.zzB();
            if (z) {
                zzgagVar.zzk();
            }
            zzgagVar.zzb();
            zzd zzdVar2 = zzdVar;
            zzd zzdVarZzq = zzgagVar.zzq(zzd.zza);
            zzd zzdVar3 = zzdVar2;
            while (zzdVarZzq != null) {
                zzd zzdVar4 = zzdVarZzq.next;
                zzdVarZzq.next = zzdVar3;
                zzdVar3 = zzdVarZzq;
                zzdVarZzq = zzdVar4;
            }
            while (zzdVar3 != null) {
                zzdVar = zzdVar3.next;
                Runnable runnable = (Runnable) Objects.requireNonNull(zzdVar3.zzb);
                if (runnable instanceof zzb) {
                    zzb zzbVar = (zzb) runnable;
                    zzgagVar = zzbVar.zza;
                    if (zzgagVar.zzw() == zzbVar && zzD(zzgagVar, zzbVar, zze(zzbVar.zzb))) {
                        z = false;
                    }
                } else {
                    zzG(runnable, (Executor) Objects.requireNonNull(zzdVar3.zzc));
                }
                zzdVar3 = zzdVar;
            }
            return;
        }
    }

    private static void zzG(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            zzf.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object zze(ListenableFuture listenableFuture) {
        Throwable thZzi;
        if (listenableFuture instanceof zze) {
            Object objZzw = ((zzgag) listenableFuture).zzw();
            if (objZzw instanceof zza) {
                zza zzaVar = (zza) objZzw;
                if (zzaVar.zzc) {
                    Throwable th = zzaVar.zzd;
                    objZzw = th != null ? new zza(false, th) : zza.zzb;
                }
            }
            return Objects.requireNonNull(objZzw);
        }
        if ((listenableFuture instanceof zzgcw) && (thZzi = ((zzgcw) listenableFuture).zzi()) != null) {
            return new zzc(thZzi);
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        if ((!zzg) && zIsCancelled) {
            return Objects.requireNonNull(zza.zzb);
        }
        try {
            Object objZzf = zzf(listenableFuture);
            if (!zIsCancelled) {
                return objZzf == null ? zze : objZzf;
            }
            return new zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(listenableFuture)));
        } catch (Error e) {
            e = e;
            return new zzc(e);
        } catch (CancellationException e2) {
            return !zIsCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(String.valueOf(listenableFuture))), e2)) : new zza(false, e2);
        } catch (ExecutionException e3) {
            return zIsCancelled ? new zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(String.valueOf(listenableFuture))), e3)) : new zzc(e3.getCause());
        } catch (Exception e4) {
            e = e4;
            return new zzc(e);
        }
    }

    private static Object zzf(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
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
        return obj;
    }

    static Object zzh(Object obj) throws ExecutionException {
        if (obj instanceof zza) {
            Throwable th = ((zza) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zze) {
            return null;
        }
        return obj;
    }

    static boolean zzm(Object obj) {
        return !(obj instanceof zzb);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        zzd zzdVarZzr;
        zzftw.zzc(runnable, "Runnable was null.");
        zzftw.zzc(executor, "Executor was null.");
        if (!isDone() && (zzdVarZzr = zzr()) != zzd.zza) {
            zzd zzdVar = new zzd(runnable, executor);
            do {
                zzdVar.next = zzdVarZzr;
                if (zzC(zzdVarZzr, zzdVar)) {
                    return;
                } else {
                    zzdVarZzr = zzr();
                }
            } while (zzdVarZzr != zzd.zza);
        }
        zzG(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Object objRequireNonNull;
        Object objZzw = zzw();
        if (!(objZzw instanceof zzb) && !(objZzw == null)) {
            return false;
        }
        if (zzg) {
            objRequireNonNull = new zza(z, new CancellationException("Future.cancel() was called."));
        } else {
            objRequireNonNull = Objects.requireNonNull(z ? zza.zza : zza.zzb);
        }
        zzgag<V> zzgagVar = this;
        boolean z2 = false;
        while (true) {
            if (zzD(zzgagVar, objZzw, objRequireNonNull)) {
                zzF(zzgagVar, z);
                if (objZzw instanceof zzb) {
                    ListenableFuture<? extends V> listenableFuture = ((zzb) objZzw).zzb;
                    if (listenableFuture instanceof zze) {
                        zzgagVar = (zzgag) listenableFuture;
                        objZzw = zzgagVar.zzw();
                        if ((objZzw == null) | (objZzw instanceof zzb)) {
                            z2 = true;
                        }
                    } else {
                        listenableFuture.cancel(z);
                    }
                }
                return true;
            }
            objZzw = zzgagVar.zzw();
            if (zzm(objZzw)) {
                return z2;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        return zzu();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return zzw() instanceof zza;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object objZzw = zzw();
        return (objZzw != null) & zzm(objZzw);
    }

    public String toString() {
        String strConcat;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzE(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object objZzw = zzw();
            if (objZzw instanceof zzb) {
                sb.append(", setFuture=[");
                ListenableFuture<? extends V> listenableFuture = ((zzb) objZzw).zzb;
                try {
                    if (listenableFuture == this) {
                        sb.append("this future");
                    } else {
                        sb.append(listenableFuture);
                    }
                } catch (Throwable th) {
                    zzgcl.zzb(th);
                    sb.append("Exception thrown from implementation: ");
                    sb.append(th.getClass());
                }
                sb.append(b9.i.e);
            } else {
                try {
                    strConcat = zzfun.zza(zza());
                } catch (Throwable th2) {
                    zzgcl.zzb(th2);
                    strConcat = "Exception thrown from implementation: ".concat(String.valueOf(String.valueOf(th2.getClass())));
                }
                if (strConcat != null) {
                    sb.append(", info=[");
                    sb.append(strConcat);
                    sb.append(b9.i.e);
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                zzE(sb);
            }
        }
        sb.append(b9.i.e);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String zza() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected void zzb() {
    }

    protected boolean zzc(Object obj) {
        if (obj == null) {
            obj = zze;
        }
        if (!zzD(this, null, obj)) {
            return false;
        }
        zzF(this, false);
        return true;
    }

    protected boolean zzd(Throwable th) {
        th.getClass();
        if (!zzD(this, null, new zzc(th))) {
            return false;
        }
        zzF(this, false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgcw
    protected final Throwable zzi() {
        if (!(this instanceof zze)) {
            return null;
        }
        Object objZzw = zzw();
        if (objZzw instanceof zzc) {
            return ((zzc) objZzw).zzb;
        }
        return null;
    }

    protected void zzk() {
    }

    final void zzl(Future future) {
        if ((future != null) && isCancelled()) {
            future.cancel(zzo());
        }
    }

    protected final boolean zzo() {
        Object objZzw = zzw();
        return (objZzw instanceof zza) && ((zza) objZzw).zzc;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return zzv(j, timeUnit);
    }

    protected final boolean zzn(ListenableFuture listenableFuture) {
        zzc zzcVar;
        listenableFuture.getClass();
        Object objZzw = zzw();
        if (objZzw == null) {
            if (listenableFuture.isDone()) {
                if (!zzD(this, null, zze(listenableFuture))) {
                    return false;
                }
                zzF(this, false);
                return true;
            }
            zzb zzbVar = new zzb(this, listenableFuture);
            if (zzD(this, null, zzbVar)) {
                try {
                    listenableFuture.addListener(zzbVar, zzgbg.INSTANCE);
                } catch (Throwable th) {
                    try {
                        zzcVar = new zzc(th);
                    } catch (Error | Exception unused) {
                        zzcVar = zzc.zza;
                    }
                    zzD(this, zzbVar, zzcVar);
                }
                return true;
            }
            objZzw = zzw();
        }
        if (objZzw instanceof zza) {
            listenableFuture.cancel(((zza) objZzw).zzc);
        }
        return false;
    }
}
