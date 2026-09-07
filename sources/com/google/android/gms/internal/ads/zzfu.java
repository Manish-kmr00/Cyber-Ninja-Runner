package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfu {
    private final zzft zza;
    private final ArrayDeque zzb = new ArrayDeque();
    private final ArrayDeque zzc = new ArrayDeque();
    private final PriorityQueue zzd = new PriorityQueue();
    private int zze = -1;
    private zzfs zzf;

    public zzfu(zzft zzftVar) {
        this.zza = zzftVar;
    }

    private final void zzf(int i) {
        List list;
        while (true) {
            PriorityQueue priorityQueue = this.zzd;
            if (priorityQueue.size() <= i) {
                return;
            }
            zzfs zzfsVar = (zzfs) priorityQueue.poll();
            int i2 = zzeu.zza;
            int i3 = 0;
            while (true) {
                list = zzfsVar.zza;
                if (i3 >= list.size()) {
                    break;
                }
                this.zza.zza(zzfsVar.zzb, (zzek) list.get(i3));
                this.zzb.push((zzek) list.get(i3));
                i3++;
            }
            list.clear();
            zzfs zzfsVar2 = this.zzf;
            if (zzfsVar2 != null && zzfsVar2.zzb == zzfsVar.zzb) {
                this.zzf = null;
            }
            this.zzc.push(zzfsVar);
        }
    }

    public final int zza() {
        return this.zze;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        if (r7 < r0.zzb) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzb(long r7, com.google.android.gms.internal.ads.zzek r9) {
        /*
            r6 = this;
            int r0 = r6.zze
            if (r0 == 0) goto La2
            r1 = -1
            if (r0 == r1) goto L24
            java.util.PriorityQueue r0 = r6.zzd
            int r2 = r0.size()
            int r3 = r6.zze
            if (r2 < r3) goto L24
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzfs r0 = (com.google.android.gms.internal.ads.zzfs) r0
            int r2 = com.google.android.gms.internal.ads.zzeu.zza
            r2 = r0
            com.google.android.gms.internal.ads.zzfs r2 = (com.google.android.gms.internal.ads.zzfs) r2
            long r2 = r0.zzb
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 >= 0) goto L24
            goto La2
        L24:
            java.util.ArrayDeque r0 = r6.zzb
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L32
            com.google.android.gms.internal.ads.zzek r0 = new com.google.android.gms.internal.ads.zzek
            r0.<init>()
            goto L38
        L32:
            java.lang.Object r0 = r0.pop()
            com.google.android.gms.internal.ads.zzek r0 = (com.google.android.gms.internal.ads.zzek) r0
        L38:
            int r2 = r9.zza()
            r0.zzI(r2)
            byte[] r2 = r9.zzN()
            int r9 = r9.zzc()
            byte[] r3 = r0.zzN()
            int r4 = r0.zza()
            r5 = 0
            java.lang.System.arraycopy(r2, r9, r3, r5, r4)
            com.google.android.gms.internal.ads.zzfs r9 = r6.zzf
            if (r9 == 0) goto L64
            long r2 = r9.zzb
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 == 0) goto L5e
            goto L64
        L5e:
            java.util.List r7 = r9.zza
            r7.add(r0)
            return
        L64:
            java.util.ArrayDeque r9 = r6.zzc
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto L72
            com.google.android.gms.internal.ads.zzfs r9 = new com.google.android.gms.internal.ads.zzfs
            r9.<init>()
            goto L78
        L72:
            java.lang.Object r9 = r9.pop()
            com.google.android.gms.internal.ads.zzfs r9 = (com.google.android.gms.internal.ads.zzfs) r9
        L78:
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 == 0) goto L82
            r5 = 1
        L82:
            com.google.android.gms.internal.ads.zzdc.zzd(r5)
            java.util.List r2 = r9.zza
            boolean r3 = r2.isEmpty()
            com.google.android.gms.internal.ads.zzdc.zzf(r3)
            r9.zzb = r7
            r2.add(r0)
            java.util.PriorityQueue r7 = r6.zzd
            r7.add(r9)
            r6.zzf = r9
            int r7 = r6.zze
            if (r7 == r1) goto La1
            r6.zzf(r7)
        La1:
            return
        La2:
            com.google.android.gms.internal.ads.zzft r0 = r6.zza
            r0.zza(r7, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfu.zzb(long, com.google.android.gms.internal.ads.zzek):void");
    }

    public final void zzc() {
        this.zzd.clear();
    }

    public final void zzd() {
        zzf(0);
    }

    public final void zze(int i) {
        zzdc.zzf(i >= 0);
        this.zze = i;
        zzf(i);
    }
}
