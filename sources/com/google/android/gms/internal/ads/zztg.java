package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public abstract class zztg extends zzhx {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    private zzsz zzA;
    private int zzB;
    private boolean zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private long zzH;
    private long zzI;
    private int zzJ;
    private int zzK;
    private ByteBuffer zzL;
    private boolean zzM;
    private boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private int zzS;
    private int zzT;
    private int zzU;
    private boolean zzV;
    private boolean zzW;
    private boolean zzX;
    private long zzY;
    private long zzZ;
    protected zzhy zza;
    private boolean zzaa;
    private boolean zzab;
    private boolean zzac;
    private zzte zzad;
    private long zzae;
    private boolean zzaf;
    private boolean zzag;
    private zzrz zzah;
    private zzrz zzai;
    private final zzsu zzc;
    private final zzti zzd;
    private final float zze;
    private final zzhn zzf;
    private final zzhn zzg;
    private final zzhn zzh;
    private final zzsn zzi;
    private final MediaCodec.BufferInfo zzj;
    private final ArrayDeque zzk;
    private final zzrm zzl;
    private zzz zzm;
    private zzz zzn;
    private zzlt zzo;
    private MediaCrypto zzp;
    private long zzq;
    private float zzr;
    private float zzs;
    private zzsw zzt;
    private zzz zzu;
    private MediaFormat zzv;
    private boolean zzw;
    private float zzx;
    private ArrayDeque zzy;
    private zztc zzz;

    public zztg(int i, zzsu zzsuVar, zzti zztiVar, boolean z, float f) {
        super(i);
        this.zzc = zzsuVar;
        zztiVar.getClass();
        this.zzd = zztiVar;
        this.zze = f;
        this.zzf = new zzhn(0, 0);
        this.zzg = new zzhn(0, 0);
        this.zzh = new zzhn(2, 0);
        zzsn zzsnVar = new zzsn();
        this.zzi = zzsnVar;
        this.zzj = new MediaCodec.BufferInfo();
        this.zzr = 1.0f;
        this.zzs = 1.0f;
        this.zzq = -9223372036854775807L;
        this.zzk = new ArrayDeque();
        this.zzad = zzte.zza;
        zzsnVar.zzj(0);
        zzsnVar.zzc.order(ByteOrder.nativeOrder());
        this.zzl = new zzrm();
        this.zzx = -1.0f;
        this.zzB = 0;
        this.zzS = 0;
        this.zzJ = -1;
        this.zzK = -1;
        this.zzI = -9223372036854775807L;
        this.zzY = -9223372036854775807L;
        this.zzZ = -9223372036854775807L;
        this.zzae = -9223372036854775807L;
        this.zzH = -9223372036854775807L;
        this.zzT = 0;
        this.zzU = 0;
        this.zza = new zzhy();
    }

    protected static boolean zzaQ(zzz zzzVar) {
        return zzzVar.zzL == 0;
    }

    private final void zzaR() {
        this.zzK = -1;
        this.zzL = null;
    }

    private final void zzaS(zzte zzteVar) {
        this.zzad = zzteVar;
        if (zzteVar.zzd != -9223372036854775807L) {
            this.zzaf = true;
        }
    }

    private final boolean zzaU() throws zzii {
        if (this.zzV) {
            this.zzT = 1;
            if (this.zzD) {
                this.zzU = 3;
                return false;
            }
            this.zzU = 2;
        } else {
            zzaT();
        }
        return true;
    }

    private final boolean zzaV() {
        return this.zzK >= 0;
    }

    private final boolean zzaW(long j, long j2) {
        if (j2 >= j) {
            return false;
        }
        zzz zzzVar = this.zzn;
        if (zzzVar == null || !Objects.equals(zzzVar.zzo, "audio/opus")) {
            return true;
        }
        return !zzadx.zzf(j, j2);
    }

    private final boolean zzaX(int i) throws zzii {
        zzkp zzkpVarZzk = zzk();
        zzhn zzhnVar = this.zzf;
        zzhnVar.zzb();
        int iZzcU = zzcU(zzkpVarZzk, zzhnVar, i | 4);
        if (iZzcU == -5) {
            zzac(zzkpVarZzk);
            return true;
        }
        if (iZzcU != -4 || !zzhnVar.zzf()) {
            return false;
        }
        this.zzaa = true;
        zzai();
        return false;
    }

    private final boolean zzaY(long j) {
        return this.zzq == -9223372036854775807L || zzi().zzb() - j < this.zzq;
    }

    private final boolean zzaZ(zzz zzzVar) throws zzii {
        int i = zzeu.zza;
        if (this.zzt != null && this.zzU != 3 && zzcT() != 0) {
            float f = this.zzs;
            zzzVar.getClass();
            float fZzZ = zzZ(f, zzzVar, zzT());
            float f2 = this.zzx;
            if (f2 != fZzZ) {
                if (fZzZ == -1.0f) {
                    zzae();
                    return false;
                }
                if (f2 != -1.0f || fZzZ > this.zze) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", fZzZ);
                    zzsw zzswVar = this.zzt;
                    zzswVar.getClass();
                    zzswVar.zzq(bundle);
                    this.zzx = fZzZ;
                }
            }
        }
        return true;
    }

    private final void zzad() {
        this.zzQ = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzP = false;
        this.zzO = false;
        this.zzl.zzb();
    }

    private final void zzae() throws zzii {
        if (this.zzV) {
            this.zzT = 1;
            this.zzU = 3;
        } else {
            zzaG();
            zzaD();
        }
    }

    private final void zzah() {
        try {
            zzsw zzswVar = this.zzt;
            zzdc.zzb(zzswVar);
            zzswVar.zzj();
        } finally {
            zzaH();
        }
    }

    private final void zzao() {
        this.zzJ = -1;
        this.zzg.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    protected void zzC() {
        try {
            zzad();
            zzaG();
        } finally {
            this.zzai = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if (r7 >= r5) goto L16;
     */
    @Override // com.google.android.gms.internal.ads.zzhx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void zzF(com.google.android.gms.internal.ads.zzz[] r13, long r14, long r16, com.google.android.gms.internal.ads.zzuy r18) throws com.google.android.gms.internal.ads.zzii {
        /*
            r12 = this;
            r0 = r12
            com.google.android.gms.internal.ads.zzte r1 = r0.zzad
            long r1 = r1.zzd
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L27
            com.google.android.gms.internal.ads.zzte r1 = new com.google.android.gms.internal.ads.zzte
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaS(r1)
            boolean r1 = r0.zzag
            if (r1 == 0) goto L5b
            r12.zzap()
            return
        L27:
            java.util.ArrayDeque r1 = r0.zzk
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L5c
            long r5 = r0.zzY
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 == 0) goto L3f
            long r7 = r0.zzae
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 == 0) goto L5c
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 < 0) goto L5c
        L3f:
            com.google.android.gms.internal.ads.zzte r1 = new com.google.android.gms.internal.ads.zzte
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaS(r1)
            com.google.android.gms.internal.ads.zzte r1 = r0.zzad
            long r1 = r1.zzd
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L5b
            r12.zzap()
        L5b:
            return
        L5c:
            com.google.android.gms.internal.ads.zzte r9 = new com.google.android.gms.internal.ads.zzte
            long r3 = r0.zzY
            r2 = r9
            r5 = r14
            r7 = r16
            r2.<init>(r3, r5, r7)
            r1.add(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztg.zzF(com.google.android.gms.internal.ads.zzz[], long, long, com.google.android.gms.internal.ads.zzuy):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhx, com.google.android.gms.internal.ads.zzlu
    public void zzM(float f, float f2) throws zzii {
        this.zzr = f;
        this.zzs = f2;
        zzaZ(this.zzu);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 16181. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @Override // com.google.android.gms.internal.ads.zzlu
    public void zzV(long r27, long r29) throws com.google.android.gms.internal.ads.zzii {
        /*
            Method dump skipped, instruction units count: 1618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztg.zzV(long, long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public boolean zzW() {
        return this.zzab;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public boolean zzX() {
        if (this.zzm == null) {
            return false;
        }
        if (zzS() || zzaV()) {
            return true;
        }
        return this.zzI != -9223372036854775807L && zzi().zzb() < this.zzI;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final int zzY(zzz zzzVar) throws zzii {
        try {
            return zzaa(this.zzd, zzzVar);
        } catch (zztn e) {
            throw zzcW(e, zzzVar, false, 4002);
        }
    }

    protected float zzZ(float f, zzz zzzVar, zzz[] zzzVarArr) {
        throw null;
    }

    protected zzsy zzaA(Throwable th, zzsz zzszVar) {
        return new zzsy(th, zzszVar);
    }

    protected final zzsz zzaB() {
        return this.zzA;
    }

    public final void zzaC() {
        this.zzag = true;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 15681. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    protected final void zzaD() throws com.google.android.gms.internal.ads.zzii {
        /*
            Method dump skipped, instruction units count: 1568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztg.zzaD():void");
    }

    protected void zzaE(long j) {
        this.zzae = j;
        while (true) {
            ArrayDeque arrayDeque = this.zzk;
            if (arrayDeque.isEmpty() || j < ((zzte) arrayDeque.peek()).zzb) {
                return;
            }
            zzte zzteVar = (zzte) arrayDeque.poll();
            zzteVar.getClass();
            zzaS(zzteVar);
            zzap();
        }
    }

    protected void zzaF(zzhn zzhnVar) throws zzii {
    }

    protected final void zzaG() {
        try {
            zzsw zzswVar = this.zzt;
            if (zzswVar != null) {
                zzswVar.zzm();
                this.zza.zzb++;
                zzsz zzszVar = this.zzA;
                if (zzszVar == null) {
                    throw null;
                }
                zzam(zzszVar.zza);
            }
            this.zzt = null;
            this.zzp = null;
            this.zzah = null;
            zzaI();
        } catch (Throwable th) {
            this.zzt = null;
            this.zzp = null;
            this.zzah = null;
            zzaI();
            throw th;
        }
    }

    protected void zzaH() {
        zzao();
        zzaR();
        this.zzI = -9223372036854775807L;
        this.zzW = false;
        this.zzH = -9223372036854775807L;
        this.zzV = false;
        this.zzE = false;
        this.zzF = false;
        this.zzM = false;
        this.zzN = false;
        this.zzY = -9223372036854775807L;
        this.zzZ = -9223372036854775807L;
        this.zzae = -9223372036854775807L;
        this.zzT = 0;
        this.zzU = 0;
        this.zzS = this.zzR ? 1 : 0;
    }

    protected final void zzaI() {
        zzaH();
        this.zzy = null;
        this.zzA = null;
        this.zzu = null;
        this.zzv = null;
        this.zzw = false;
        this.zzX = false;
        this.zzx = -1.0f;
        this.zzB = 0;
        this.zzC = false;
        this.zzD = false;
        this.zzG = false;
        this.zzR = false;
        this.zzS = 0;
    }

    protected final boolean zzaJ() throws zzii {
        boolean zZzaK = zzaK();
        if (zZzaK) {
            zzaD();
        }
        return zZzaK;
    }

    protected final boolean zzaK() {
        if (this.zzt == null) {
            return false;
        }
        int i = this.zzU;
        if (i == 3 || ((this.zzC && !this.zzX) || (this.zzD && this.zzW))) {
            zzaG();
            return true;
        }
        if (i == 2) {
            int i2 = zzeu.zza;
            try {
                zzaT();
            } catch (zzii e) {
                zzdx.zzg("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                zzaG();
                return true;
            }
        }
        zzah();
        return false;
    }

    protected final boolean zzaL() {
        return this.zzO;
    }

    protected final boolean zzaM(zzz zzzVar) {
        return this.zzai == null && zzas(zzzVar);
    }

    protected boolean zzaN(zzz zzzVar) throws zzii {
        return true;
    }

    protected boolean zzaO(zzhn zzhnVar) {
        return false;
    }

    protected boolean zzaP(zzsz zzszVar) {
        return true;
    }

    protected abstract int zzaa(zzti zztiVar, zzz zzzVar) throws zztn;

    protected zzhz zzab(zzsz zzszVar, zzz zzzVar, zzz zzzVar2) {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00b7  */
    protected zzhz zzac(zzkp zzkpVar) throws zzii {
        int i;
        boolean z = true;
        this.zzac = true;
        zzz zzzVarZzaj = zzkpVar.zza;
        zzzVarZzaj.getClass();
        String str = zzzVarZzaj.zzo;
        if (str == null) {
            throw zzcW(new IllegalArgumentException("Sample MIME type is null."), zzzVarZzaj, false, 4005);
        }
        if (Objects.equals(str, "video/av01") && !zzzVarZzaj.zzr.isEmpty()) {
            zzx zzxVarZzb = zzzVarZzaj.zzb();
            zzxVarZzb.zzP(null);
            zzzVarZzaj = zzxVarZzb.zzaj();
        }
        zzz zzzVar = zzzVarZzaj;
        this.zzai = zzkpVar.zzb;
        this.zzm = zzzVar;
        if (this.zzO) {
            this.zzQ = true;
            return null;
        }
        zzsw zzswVar = this.zzt;
        if (zzswVar == null) {
            this.zzy = null;
            zzaD();
            return null;
        }
        zzsz zzszVar = this.zzA;
        zzszVar.getClass();
        zzz zzzVar2 = this.zzu;
        zzzVar2.getClass();
        zzrz zzrzVar = this.zzah;
        zzrz zzrzVar2 = this.zzai;
        if (zzrzVar != zzrzVar2) {
            zzae();
            return new zzhz(zzszVar.zza, zzzVar2, zzzVar, 0, 128);
        }
        boolean z2 = zzrzVar2 != zzrzVar;
        if (z2) {
            int i2 = zzeu.zza;
        }
        zzhz zzhzVarZzab = zzab(zzszVar, zzzVar2, zzzVar);
        int i3 = zzhzVarZzab.zzd;
        if (i3 != 0) {
            i = 2;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (zzaZ(zzzVar)) {
                        this.zzu = zzzVar;
                        if (!z2 || zzaU()) {
                        }
                    } else {
                        i = 16;
                    }
                } else if (zzaZ(zzzVar)) {
                    this.zzR = true;
                    this.zzS = 1;
                    int i4 = this.zzB;
                    if (i4 != 2 && (i4 != 1 || zzzVar.zzv != zzzVar2.zzv || zzzVar.zzw != zzzVar2.zzw)) {
                        z = false;
                    }
                    this.zzE = z;
                    this.zzu = zzzVar;
                    if (!z2 || zzaU()) {
                    }
                } else {
                    i = 16;
                }
            } else if (zzaZ(zzzVar)) {
                this.zzu = zzzVar;
                if (z2) {
                    if (zzaU()) {
                    }
                } else if (this.zzV) {
                    this.zzT = 1;
                    if (this.zzD) {
                        this.zzU = 3;
                    } else {
                        this.zzU = 1;
                    }
                }
            } else {
                i = 16;
            }
            return (i3 != 0 || (this.zzt == zzswVar && this.zzU != 3)) ? zzhzVarZzab : new zzhz(zzszVar.zza, zzzVar2, zzzVar, 0, i);
        }
        zzae();
        i = 0;
        if (i3 != 0) {
        }
    }

    protected abstract zzst zzaf(zzsz zzszVar, zzz zzzVar, MediaCrypto mediaCrypto, float f);

    protected abstract List zzag(zzti zztiVar, zzz zzzVar, boolean z) throws zztn;

    protected void zzaj(zzhn zzhnVar) throws zzii {
        throw null;
    }

    protected void zzak(Exception exc) {
        throw null;
    }

    protected void zzal(String str, zzst zzstVar, long j, long j2) {
        throw null;
    }

    protected void zzam(String str) {
        throw null;
    }

    protected void zzan(zzz zzzVar, MediaFormat mediaFormat) throws zzii {
        throw null;
    }

    protected void zzap() {
    }

    protected void zzaq() throws zzii {
        throw null;
    }

    protected abstract boolean zzar(long j, long j2, zzsw zzswVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzz zzzVar) throws zzii;

    protected boolean zzas(zzz zzzVar) {
        return false;
    }

    protected final float zzat() {
        return this.zzr;
    }

    protected int zzau(zzhn zzhnVar) {
        return 0;
    }

    protected final long zzav() {
        return this.zzad.zzd;
    }

    protected final long zzaw() {
        return this.zzad.zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzlt zzay() {
        return this.zzo;
    }

    protected final zzsw zzaz() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzhx, com.google.android.gms.internal.ads.zzlx
    public final int zze() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zzhx, com.google.android.gms.internal.ads.zzlp
    public void zzu(int i, Object obj) throws zzii {
        if (i == 11) {
            zzlt zzltVar = (zzlt) obj;
            zzltVar.getClass();
            this.zzo = zzltVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    protected void zzx() {
        this.zzm = null;
        zzaS(zzte.zza);
        this.zzk.clear();
        zzaK();
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    protected void zzy(boolean z, boolean z2) throws zzii {
        this.zza = new zzhy();
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    protected void zzz(long j, boolean z) throws zzii {
        this.zzaa = false;
        this.zzab = false;
        if (this.zzO) {
            this.zzi.zzb();
            this.zzh.zzb();
            this.zzP = false;
            this.zzl.zzb();
        } else {
            zzaJ();
        }
        zzeq zzeqVar = this.zzad.zze;
        if (zzeqVar.zza() > 0) {
            this.zzac = true;
        }
        zzeqVar.zze();
        this.zzk.clear();
    }

    private final void zzaT() throws zzii {
        zzrz zzrzVar = this.zzai;
        zzrzVar.getClass();
        this.zzah = zzrzVar;
        this.zzT = 0;
        this.zzU = 0;
    }

    private final void zzai() throws zzii {
        int i = this.zzU;
        if (i == 1) {
            zzah();
            return;
        }
        if (i == 2) {
            zzah();
            zzaT();
        } else if (i != 3) {
            this.zzab = true;
            zzaq();
        } else {
            zzaG();
            zzaD();
        }
    }
}
