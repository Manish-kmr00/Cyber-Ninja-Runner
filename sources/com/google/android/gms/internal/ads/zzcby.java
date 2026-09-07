package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcby extends zzcam implements TextureView.SurfaceTextureListener, zzcaw {
    private final zzcbg zzc;
    private final zzcbh zzd;
    private final zzcbf zze;
    private final zzdre zzf;
    private zzcal zzg;
    private Surface zzh;
    private zzcax zzi;
    private String zzj;
    private String[] zzk;
    private boolean zzl;
    private int zzm;
    private zzcbe zzn;
    private final boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private int zzr;
    private int zzs;
    private float zzt;

    public zzcby(Context context, zzcbh zzcbhVar, zzcbg zzcbgVar, boolean z, boolean z2, zzcbf zzcbfVar, zzdre zzdreVar) {
        super(context);
        this.zzm = 1;
        this.zzc = zzcbgVar;
        this.zzd = zzcbhVar;
        this.zzo = z;
        this.zze = zzcbfVar;
        zzcbhVar.zza(this);
        this.zzf = zzdreVar;
    }

    public static /* synthetic */ void zzG(zzcby zzcbyVar) {
        zzcal zzcalVar = zzcbyVar.zzg;
        if (zzcalVar != null) {
            zzcalVar.zzi();
        }
    }

    public static /* synthetic */ void zzH(zzcby zzcbyVar, int i) {
        zzcal zzcalVar = zzcbyVar.zzg;
        if (zzcalVar != null) {
            zzcalVar.onWindowVisibilityChanged(i);
        }
    }

    public static /* synthetic */ void zzI(zzcby zzcbyVar, String str) {
        zzcal zzcalVar = zzcbyVar.zzg;
        if (zzcalVar != null) {
            zzcalVar.zzb("ExoPlayerAdapter error", str);
        }
    }

    public static /* synthetic */ void zzJ(zzcby zzcbyVar) {
        zzcal zzcalVar = zzcbyVar.zzg;
        if (zzcalVar != null) {
            zzcalVar.zze();
        }
    }

    public static /* synthetic */ void zzK(zzcby zzcbyVar) {
        zzcal zzcalVar = zzcbyVar.zzg;
        if (zzcalVar != null) {
            zzcalVar.zza();
        }
    }

    public static /* synthetic */ void zzL(zzcby zzcbyVar) {
        zzcal zzcalVar = zzcbyVar.zzg;
        if (zzcalVar != null) {
            zzcalVar.zzh();
        }
    }

    public static /* synthetic */ void zzM(zzcby zzcbyVar) {
        float fZza = zzcbyVar.zzb.zza();
        zzcax zzcaxVar = zzcbyVar.zzi;
        if (zzcaxVar == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Trying to set volume before player is initialized.");
            return;
        }
        try {
            zzcaxVar.zzT(fZza, false);
        } catch (IOException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("", e);
        }
    }

    public static /* synthetic */ void zzN(zzcby zzcbyVar) {
        zzcal zzcalVar = zzcbyVar.zzg;
        if (zzcalVar != null) {
            zzcalVar.zzd();
        }
    }

    public static /* synthetic */ void zzO(zzcby zzcbyVar, int i, int i2) {
        zzcal zzcalVar = zzcbyVar.zzg;
        if (zzcalVar != null) {
            zzcalVar.zzj(i, i2);
        }
    }

    public static /* synthetic */ void zzP(zzcby zzcbyVar) {
        zzcal zzcalVar = zzcbyVar.zzg;
        if (zzcalVar != null) {
            zzcalVar.zzf();
        }
    }

    public static /* synthetic */ void zzQ(zzcby zzcbyVar, String str) {
        zzcal zzcalVar = zzcbyVar.zzg;
        if (zzcalVar != null) {
            zzcalVar.zzc("ExoPlayerAdapter exception", str);
        }
    }

    public static /* synthetic */ void zzS(zzcby zzcbyVar) {
        zzcal zzcalVar = zzcbyVar.zzg;
        if (zzcalVar != null) {
            zzcalVar.zzg();
        }
    }

    private static String zzT(String str, Exception exc) {
        return str + RemoteSettings.FORWARD_SLASH_STRING + exc.getClass().getCanonicalName() + ":" + exc.getMessage();
    }

    private final void zzU() {
        zzcax zzcaxVar = this.zzi;
        if (zzcaxVar != null) {
            zzcaxVar.zzQ(true);
        }
    }

    private final void zzV() {
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbx
            @Override // java.lang.Runnable
            public final void run() {
                zzcby.zzP(this.zza);
            }
        });
        zzn();
        this.zzd.zzb();
        if (this.zzq) {
            zzp();
        }
    }

    private final void zzW(boolean z, Integer num) {
        zzcax zzcaxVar = this.zzi;
        if (zzcaxVar != null && !z) {
            zzcaxVar.zzP(num);
            return;
        }
        if (this.zzj == null || this.zzh == null) {
            return;
        }
        if (z) {
            if (!zzad()) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("No valid ExoPlayerAdapter exists when switch source.");
                return;
            } else {
                zzcaxVar.zzU();
                zzY();
            }
        }
        if (this.zzj.startsWith("cache:")) {
            zzccs zzccsVarZzo = this.zzc.zzo(this.zzj);
            if (zzccsVarZzo instanceof zzcdb) {
                zzcax zzcaxVarZza = ((zzcdb) zzccsVarZzo).zza();
                this.zzi = zzcaxVarZza;
                zzcaxVarZza.zzP(num);
                if (!this.zzi.zzV()) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Precached video player has been released.");
                    return;
                }
            } else {
                if (!(zzccsVarZzo instanceof zzccy)) {
                    String strValueOf = String.valueOf(this.zzj);
                    int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Stream cache miss: ".concat(strValueOf));
                    return;
                }
                zzccy zzccyVar = (zzccy) zzccsVarZzo;
                String strZzF = zzF();
                ByteBuffer byteBufferZzl = zzccyVar.zzl();
                boolean zZzm = zzccyVar.zzm();
                String strZzk = zzccyVar.zzk();
                if (strZzk == null) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Stream cache URL is null.");
                    return;
                } else {
                    zzcax zzcaxVarZzE = zzE(num);
                    this.zzi = zzcaxVarZzE;
                    zzcaxVarZzE.zzG(new Uri[]{Uri.parse(strZzk)}, strZzF, byteBufferZzl, zZzm);
                }
            }
        } else {
            this.zzi = zzE(num);
            String strZzF2 = zzF();
            Uri[] uriArr = new Uri[this.zzk.length];
            int i5 = 0;
            while (true) {
                String[] strArr = this.zzk;
                if (i5 >= strArr.length) {
                    break;
                }
                uriArr[i5] = Uri.parse(strArr[i5]);
                i5++;
            }
            this.zzi.zzF(uriArr, strZzF2);
        }
        this.zzi.zzL(this);
        zzZ(this.zzh, false);
        if (this.zzi.zzV()) {
            int iZzt = this.zzi.zzt();
            this.zzm = iZzt;
            if (iZzt == 3) {
                zzV();
            }
        }
    }

    private final void zzX() {
        zzcax zzcaxVar = this.zzi;
        if (zzcaxVar != null) {
            zzcaxVar.zzQ(false);
        }
    }

    private final void zzY() {
        if (this.zzi != null) {
            zzZ(null, true);
            zzcax zzcaxVar = this.zzi;
            if (zzcaxVar != null) {
                zzcaxVar.zzL(null);
                this.zzi.zzH();
                this.zzi = null;
            }
            this.zzm = 1;
            this.zzl = false;
            this.zzp = false;
            this.zzq = false;
        }
    }

    private final void zzZ(Surface surface, boolean z) {
        zzcax zzcaxVar = this.zzi;
        if (zzcaxVar == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Trying to set surface before player is initialized.");
            return;
        }
        try {
            zzcaxVar.zzS(surface, z);
        } catch (IOException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("", e);
        }
    }

    private final void zzaa() {
        zzab(this.zzr, this.zzs);
    }

    private final void zzab(int i, int i2) {
        float f = i2 > 0 ? i / i2 : 1.0f;
        if (this.zzt != f) {
            this.zzt = f;
            requestLayout();
        }
    }

    private final boolean zzac() {
        return zzad() && this.zzm != 1;
    }

    private final boolean zzad() {
        zzcax zzcaxVar = this.zzi;
        return (zzcaxVar == null || !zzcaxVar.zzV() || this.zzl) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcam, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.h, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.TextureView, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setSurfaceTextureListener(this);
    }

    @Override // com.google.android.gms.internal.ads.zzcam, android.view.View
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.zzt;
        if (f != 0.0f && this.zzn == null) {
            float f2 = measuredWidth;
            float f3 = f2 / measuredHeight;
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            if (f < f3) {
                measuredWidth = (int) (measuredHeight * f);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzcbe zzcbeVar = this.zzn;
        if (zzcbeVar != null) {
            zzcbeVar.zzc(measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzdre zzdreVar;
        if (this.zzo) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zznm)).booleanValue() && (zzdreVar = this.zzf) != null) {
                zzdrd zzdrdVarZza = zzdreVar.zza();
                zzdrdVarZza.zzb("action", "svp_aepv");
                zzdrdVarZza.zzj();
            }
            zzcbe zzcbeVar = new zzcbe(getContext());
            this.zzn = zzcbeVar;
            zzcbeVar.zzd(surfaceTexture, i, i2);
            zzcbe zzcbeVar2 = this.zzn;
            zzcbeVar2.start();
            SurfaceTexture surfaceTextureZzb = zzcbeVar2.zzb();
            if (surfaceTextureZzb != null) {
                surfaceTexture = surfaceTextureZzb;
            } else {
                this.zzn.zze();
                this.zzn = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzh = surface;
        if (this.zzi == null) {
            zzW(false, null);
        } else {
            zzZ(surface, true);
            if (!this.zze.zza) {
                zzU();
            }
        }
        if (this.zzr == 0 || this.zzs == 0) {
            zzab(i, i2);
        } else {
            zzaa();
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbu
            @Override // java.lang.Runnable
            public final void run() {
                zzcby.zzL(this.zza);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzo();
        zzcbe zzcbeVar = this.zzn;
        if (zzcbeVar != null) {
            zzcbeVar.zze();
            this.zzn = null;
        }
        if (this.zzi != null) {
            zzX();
            Surface surface = this.zzh;
            if (surface != null) {
                surface.release();
            }
            this.zzh = null;
            zzZ(null, true);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbq
            @Override // java.lang.Runnable
            public final void run() {
                zzcby.zzG(this.zza);
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i, final int i2) {
        zzcbe zzcbeVar = this.zzn;
        if (zzcbeVar != null) {
            zzcbeVar.zzc(i, i2);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbp
            @Override // java.lang.Runnable
            public final void run() {
                zzcby.zzO(this.zza, i, i2);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzf(this);
        this.zza.zza(surfaceTexture, this.zzg);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i) {
        com.google.android.gms.ads.internal.util.zze.zza("AdExoPlayerView3 window visibility changed to " + i);
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbo
            @Override // java.lang.Runnable
            public final void run() {
                zzcby.zzH(this.zza, i);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzA(int i) {
        zzcax zzcaxVar = this.zzi;
        if (zzcaxVar != null) {
            zzcaxVar.zzN(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzB(int i) {
        zzcax zzcaxVar = this.zzi;
        if (zzcaxVar != null) {
            zzcaxVar.zzR(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaw
    public final void zzD(int i, int i2) {
        this.zzr = i;
        this.zzs = i2;
        zzaa();
    }

    final zzcax zzE(Integer num) {
        zzcbf zzcbfVar = this.zze;
        zzcbg zzcbgVar = this.zzc;
        zzcdt zzcdtVar = new zzcdt(zzcbgVar.getContext(), zzcbfVar, zzcbgVar, num);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("ExoPlayerAdapter initialized.");
        return zzcdtVar;
    }

    final String zzF() {
        zzcbg zzcbgVar = this.zzc;
        return com.google.android.gms.ads.internal.zzv.zzq().zzc(zzcbgVar.getContext(), zzcbgVar.zzm().afmaVersion);
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final int zza() {
        if (zzac()) {
            return (int) this.zzi.zzy();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final int zzb() {
        zzcax zzcaxVar = this.zzi;
        if (zzcaxVar != null) {
            return zzcaxVar.zzr();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final int zzc() {
        if (zzac()) {
            return (int) this.zzi.zzz();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final int zzd() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final int zze() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final long zzf() {
        zzcax zzcaxVar = this.zzi;
        if (zzcaxVar != null) {
            return zzcaxVar.zzx();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final long zzg() {
        zzcax zzcaxVar = this.zzi;
        if (zzcaxVar != null) {
            return zzcaxVar.zzA();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final long zzh() {
        zzcax zzcaxVar = this.zzi;
        if (zzcaxVar != null) {
            return zzcaxVar.zzB();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcaw
    public final void zzi(final boolean z, final long j) {
        if (this.zzc != null) {
            zzbzk.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbr
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzc.zzv(z, j);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final String zzj() {
        return "ExoPlayer/2".concat(true != this.zzo ? "" : " spherical");
    }

    @Override // com.google.android.gms.internal.ads.zzcaw
    public final void zzk(String str, Exception exc) {
        final String strZzT = zzT(str, exc);
        String strConcat = "ExoPlayerAdapter error: ".concat(strZzT);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj(strConcat);
        this.zzl = true;
        if (this.zze.zza) {
            zzX();
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbv
            @Override // java.lang.Runnable
            public final void run() {
                zzcby.zzI(this.zza, strZzT);
            }
        });
        com.google.android.gms.ads.internal.zzv.zzp().zzv(exc, "AdExoPlayerView.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcaw
    public final void zzl(String str, Exception exc) {
        final String strZzT = zzT("onLoadException", exc);
        String strConcat = "ExoPlayerAdapter exception: ".concat(strZzT);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj(strConcat);
        com.google.android.gms.ads.internal.zzv.zzp().zzv(exc, "AdExoPlayerView.onException");
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbs
            @Override // java.lang.Runnable
            public final void run() {
                zzcby.zzQ(this.zza, strZzT);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcaw
    public final void zzm(int i) {
        if (this.zzm != i) {
            this.zzm = i;
            if (i == 3) {
                zzV();
                return;
            }
            if (i != 4) {
                return;
            }
            if (this.zze.zza) {
                zzX();
            }
            this.zzd.zze();
            this.zzb.zzc();
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbw
                @Override // java.lang.Runnable
                public final void run() {
                    zzcby.zzK(this.zza);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam, com.google.android.gms.internal.ads.zzcbj
    public final void zzn() {
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbn
            @Override // java.lang.Runnable
            public final void run() {
                zzcby.zzM(this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzo() {
        if (zzac()) {
            if (this.zze.zza) {
                zzX();
            }
            this.zzi.zzO(false);
            this.zzd.zze();
            this.zzb.zzc();
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbt
                @Override // java.lang.Runnable
                public final void run() {
                    zzcby.zzN(this.zza);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzp() {
        if (!zzac()) {
            this.zzq = true;
            return;
        }
        if (this.zze.zza) {
            zzU();
        }
        this.zzi.zzO(true);
        this.zzd.zzc();
        this.zzb.zzb();
        this.zza.zzb();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbm
            @Override // java.lang.Runnable
            public final void run() {
                zzcby.zzJ(this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzq(int i) {
        if (zzac()) {
            this.zzi.zzI(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzr(zzcal zzcalVar) {
        this.zzg = zzcalVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzs(String str) {
        if (str != null) {
            zzC(str, null, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzt() {
        if (zzad()) {
            this.zzi.zzU();
            zzY();
        }
        zzcbh zzcbhVar = this.zzd;
        zzcbhVar.zze();
        this.zzb.zzc();
        zzcbhVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzu(float f, float f2) {
        zzcbe zzcbeVar = this.zzn;
        if (zzcbeVar != null) {
            zzcbeVar.zzf(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaw
    public final void zzv() {
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbl
            @Override // java.lang.Runnable
            public final void run() {
                zzcby.zzS(this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final Integer zzw() {
        zzcax zzcaxVar = this.zzi;
        if (zzcaxVar != null) {
            return zzcaxVar.zzC();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzx(int i) {
        zzcax zzcaxVar = this.zzi;
        if (zzcaxVar != null) {
            zzcaxVar.zzJ(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzy(int i) {
        zzcax zzcaxVar = this.zzi;
        if (zzcaxVar != null) {
            zzcaxVar.zzK(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzz(int i) {
        zzcax zzcaxVar = this.zzi;
        if (zzcaxVar != null) {
            zzcaxVar.zzM(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzC(String str, String[] strArr, Integer num) {
        if (str == null) {
            return;
        }
        if (strArr == null) {
            this.zzk = new String[]{str};
        } else {
            this.zzk = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        String str2 = this.zzj;
        boolean z = this.zze.zzk && str2 != null && !str.equals(str2) && this.zzm == 4;
        this.zzj = str;
        zzW(z, num);
    }
}
