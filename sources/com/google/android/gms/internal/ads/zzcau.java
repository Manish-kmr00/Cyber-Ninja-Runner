package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.internal.Preconditions;
import com.json.b9;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.HashMap;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
@ParametersAreNonnullByDefault
public final class zzcau extends FrameLayout implements zzcal {
    final zzcbi zza;
    private final zzcbg zzb;
    private final FrameLayout zzc;
    private final View zzd;
    private final zzbcx zze;
    private final long zzf;
    private final zzcam zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;

    public zzcau(Context context, zzcbg zzcbgVar, int i, boolean z, zzbcx zzbcxVar, zzcbf zzcbfVar, zzdre zzdreVar) {
        super(context);
        this.zzb = zzcbgVar;
        this.zze = zzbcxVar;
        FrameLayout frameLayout = new FrameLayout(context);
        this.zzc = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzcbgVar.zzj());
        zzcan zzcanVar = zzcbgVar.zzj().zza;
        zzcbh zzcbhVar = new zzcbh(context, zzcbgVar.zzm(), zzcbgVar.zzs(), zzbcxVar, zzcbgVar.zzk());
        zzcam zzceaVar = i == 3 ? new zzcea(context, zzcbhVar) : i == 2 ? new zzcby(context, zzcbhVar, zzcbgVar, z, zzcay.zza(zzcbgVar), zzcbfVar, zzdreVar) : new zzcak(context, zzcbgVar, z, zzcay.zza(zzcbgVar), zzcbfVar, new zzcbh(context, zzcbgVar.zzm(), zzcbgVar.zzs(), zzbcxVar, zzcbgVar.zzk()), zzdreVar);
        this.zzg = zzceaVar;
        View view = new View(context);
        this.zzd = view;
        view.setBackgroundColor(0);
        frameLayout.addView(zzceaVar, new FrameLayout.LayoutParams(-1, -1, 17));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzV)).booleanValue()) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(view);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzS)).booleanValue()) {
            zzp();
        }
        this.zzq = new ImageView(context);
        this.zzf = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzX)).longValue();
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzU)).booleanValue();
        this.zzk = zBooleanValue;
        if (zzbcxVar != null) {
            zzbcxVar.zzd("spinner_used", true != zBooleanValue ? "0" : "1");
        }
        this.zza = new zzcbi(this);
        zzceaVar.zzr(this);
    }

    private final void zzJ() {
        zzcbg zzcbgVar = this.zzb;
        if (zzcbgVar.zzi() == null || !this.zzi || this.zzj) {
            return;
        }
        zzcbgVar.zzi().getWindow().clearFlags(128);
        this.zzi = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzK(String str, String... strArr) {
        HashMap map = new HashMap();
        Integer numZzl = zzl();
        if (numZzl != null) {
            map.put("playerId", numZzl.toString());
        }
        map.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                map.put(str2, str3);
                str2 = null;
            }
        }
        this.zzb.zzd("onVideoEvent", map);
    }

    private final boolean zzL() {
        return this.zzq.getParent() != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.h, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final void finalize() throws Throwable {
        try {
            this.zza.zza();
            final zzcam zzcamVar = this.zzg;
            if (zzcamVar != null) {
                zzgcd zzgcdVar = zzbzk.zzf;
                Objects.requireNonNull(zzcamVar);
                zzgcdVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcao
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcamVar.zzt();
                    }
                });
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zza.zzb();
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcaq
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzK("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcal
    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zza.zzb();
            z = true;
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
            z = false;
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcat(this, z));
    }

    public final void zzA(int i) {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null) {
            return;
        }
        zzcamVar.zzz(i);
    }

    public final void zzB(int i) {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null) {
            return;
        }
        zzcamVar.zzA(i);
    }

    public final void zzC(int i) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzV)).booleanValue()) {
            this.zzc.setBackgroundColor(i);
            this.zzd.setBackgroundColor(i);
        }
    }

    public final void zzD(int i) {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null) {
            return;
        }
        zzcamVar.zzB(i);
    }

    public final void zzE(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzF(int i, int i2, int i3, int i4) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Set video bounds to x:" + i + ";y:" + i2 + ";w:" + i3 + ";h:" + i4);
        }
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.zzc.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void zzG(float f) {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null) {
            return;
        }
        zzcamVar.zzb.zze(f);
        zzcamVar.zzn();
    }

    public final void zzH(float f, float f2) {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar != null) {
            zzcamVar.zzu(f, f2);
        }
    }

    public final void zzI() {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null) {
            return;
        }
        zzcamVar.zzb.zzd(false);
        zzcamVar.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzcal
    public final void zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzce)).booleanValue()) {
            this.zza.zza();
        }
        zzK(b9.h.g0, new String[0]);
        zzJ();
    }

    @Override // com.google.android.gms.internal.ads.zzcal
    public final void zzb(String str, String str2) {
        zzK("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcal
    public final void zzc(String str, String str2) {
        zzK("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcal
    public final void zzd() {
        zzK("pause", new String[0]);
        zzJ();
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcal
    public final void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzce)).booleanValue()) {
            this.zza.zzb();
        }
        zzcbg zzcbgVar = this.zzb;
        if (zzcbgVar.zzi() != null && !this.zzi) {
            boolean z = (zzcbgVar.zzi().getWindow().getAttributes().flags & 128) != 0;
            this.zzj = z;
            if (!z) {
                zzcbgVar.zzi().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcal
    public final void zzf() {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar != null && this.zzm == 0) {
            zzK("canplaythrough", "duration", String.valueOf(zzcamVar.zzc() / 1000.0f), "videoWidth", String.valueOf(zzcamVar.zze()), "videoHeight", String.valueOf(zzcamVar.zzd()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcal
    public final void zzg() {
        this.zzd.setVisibility(4);
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcap
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzK("firstFrameRendered", new String[0]);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcal
    public final void zzh() {
        this.zza.zzb();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcar(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcal
    public final void zzi() {
        if (this.zzr && this.zzp != null && !zzL()) {
            ImageView imageView = this.zzq;
            imageView.setImageBitmap(this.zzp);
            imageView.invalidate();
            FrameLayout frameLayout = this.zzc;
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(imageView);
        }
        this.zza.zza();
        this.zzm = this.zzl;
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcas(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcal
    public final void zzj(int i, int i2) {
        if (this.zzk) {
            int iMax = Math.max(i / ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzW)).intValue(), 1);
            int iMax2 = Math.max(i2 / ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzW)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap != null && bitmap.getWidth() == iMax && this.zzp.getHeight() == iMax2) {
                return;
            }
            this.zzp = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
            this.zzr = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcal
    public final void zzk() {
        if (this.zzh && zzL()) {
            this.zzc.removeView(this.zzq);
        }
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null || this.zzp == null) {
            return;
        }
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime();
        if (zzcamVar.getBitmap(this.zzp) != null) {
            this.zzr = true;
        }
        long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - jElapsedRealtime;
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Spinner frame grab took " + jElapsedRealtime2 + "ms");
        }
        if (jElapsedRealtime2 > this.zzf) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Spinner frame grab crossed jank threshold! Suspending spinner.");
            this.zzk = false;
            this.zzp = null;
            zzbcx zzbcxVar = this.zze;
            if (zzbcxVar != null) {
                zzbcxVar.zzd("spinner_jank", Long.toString(jElapsedRealtime2));
            }
        }
    }

    public final Integer zzl() {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar != null) {
            return zzcamVar.zzw();
        }
        return null;
    }

    public final void zzp() {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null) {
            return;
        }
        TextView textView = new TextView(zzcamVar.getContext());
        Resources resourcesZze = com.google.android.gms.ads.internal.zzv.zzp().zze();
        textView.setText(String.valueOf(resourcesZze == null ? "AdMob - " : resourcesZze.getString(R.string.watermark_label_prefix)).concat(zzcamVar.zzj()));
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
        FrameLayout frameLayout = this.zzc;
        frameLayout.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        frameLayout.bringChildToFront(textView);
    }

    public final void zzq() {
        this.zza.zza();
        zzcam zzcamVar = this.zzg;
        if (zzcamVar != null) {
            zzcamVar.zzt();
        }
        zzJ();
    }

    public final void zzr(Integer num) {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null) {
            return;
        }
        if (TextUtils.isEmpty(this.zzn)) {
            zzK("no_src", new String[0]);
        } else {
            zzcamVar.zzC(this.zzn, this.zzo, num);
        }
    }

    public final void zzs() {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null) {
            return;
        }
        zzcamVar.zzb.zzd(true);
        zzcamVar.zzn();
    }

    final void zzt() {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null) {
            return;
        }
        long jZza = zzcamVar.zza();
        if (this.zzl == jZza || jZza <= 0) {
            return;
        }
        float f = jZza / 1000.0f;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcc)).booleanValue()) {
            zzK("timeupdate", "time", String.valueOf(f), "totalBytes", String.valueOf(zzcamVar.zzh()), "qoeCachedBytes", String.valueOf(zzcamVar.zzf()), "qoeLoadedBytes", String.valueOf(zzcamVar.zzg()), "droppedFrames", String.valueOf(zzcamVar.zzb()), "reportTime", String.valueOf(com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis()));
        } else {
            zzK("timeupdate", "time", String.valueOf(f));
        }
        this.zzl = jZza;
    }

    public final void zzu() {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null) {
            return;
        }
        zzcamVar.zzo();
    }

    public final void zzv() {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null) {
            return;
        }
        zzcamVar.zzp();
    }

    public final void zzw(int i) {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null) {
            return;
        }
        zzcamVar.zzq(i);
    }

    public final void zzx(MotionEvent motionEvent) {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null) {
            return;
        }
        zzcamVar.dispatchTouchEvent(motionEvent);
    }

    public final void zzy(int i) {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null) {
            return;
        }
        zzcamVar.zzx(i);
    }

    public final void zzz(int i) {
        zzcam zzcamVar = this.zzg;
        if (zzcamVar == null) {
            return;
        }
        zzcamVar.zzy(i);
    }
}
