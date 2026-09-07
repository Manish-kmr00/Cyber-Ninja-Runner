package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import com.json.b9;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbrw extends zzbsc {
    private String zza;
    private boolean zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final Object zzi;
    private final zzcel zzj;
    private final Activity zzk;
    private zzcgf zzl;
    private ImageView zzm;
    private LinearLayout zzn;
    private final zzbsd zzo;
    private PopupWindow zzp;
    private RelativeLayout zzq;
    private ViewGroup zzr;

    static {
        CollectionUtils.setOf(b9.e.c, "top-right", "top-center", "center", b9.e.e, b9.e.d, "bottom-center");
    }

    public zzbrw(zzcel zzcelVar, zzbsd zzbsdVar) {
        super(zzcelVar, "resize");
        this.zza = "top-right";
        this.zzb = true;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = -1;
        this.zzi = new Object();
        this.zzj = zzcelVar;
        this.zzk = zzcelVar.zzi();
        this.zzo = zzbsdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zzm(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkU)).booleanValue()) {
            this.zzq.removeView((View) this.zzj);
            this.zzp.dismiss();
        } else {
            this.zzp.dismiss();
            this.zzq.removeView((View) this.zzj);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkV)).booleanValue()) {
            View view = (View) this.zzj;
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
        ViewGroup viewGroup = this.zzr;
        if (viewGroup != null) {
            viewGroup.removeView(this.zzm);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkW)).booleanValue()) {
                try {
                    ViewGroup viewGroup2 = this.zzr;
                    zzcel zzcelVar = this.zzj;
                    viewGroup2.addView((View) zzcelVar);
                    zzcelVar.zzaj(this.zzl);
                } catch (IllegalStateException e) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to add webview back to view hierarchy.", e);
                }
            } else {
                ViewGroup viewGroup3 = this.zzr;
                zzcel zzcelVar2 = this.zzj;
                viewGroup3.addView((View) zzcelVar2);
                zzcelVar2.zzaj(this.zzl);
            }
        }
        if (z) {
            zzl("default");
            zzbsd zzbsdVar = this.zzo;
            if (zzbsdVar != null) {
                zzbsdVar.zzb();
            }
        }
        this.zzp = null;
        this.zzq = null;
        this.zzr = null;
        this.zzn = null;
    }

    public final void zzb(final boolean z) {
        synchronized (this.zzi) {
            if (this.zzp != null) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkT)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    zzm(z);
                } else {
                    zzbzk.zzf.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbru
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzm(z);
                        }
                    });
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:85:0x0181  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zzc(Map map) {
        int i;
        byte b;
        int i2;
        int i3;
        int i4;
        int i5;
        synchronized (this.zzi) {
            Activity activity = this.zzk;
            if (activity == null) {
                zzh("Not an activity context. Cannot resize.");
                return;
            }
            zzcel zzcelVar = this.zzj;
            if (zzcelVar.zzO() == null) {
                zzh("Webview is not yet available, size is not set.");
                return;
            }
            if (zzcelVar.zzO().zzi()) {
                zzh("Is interstitial. Cannot resize an interstitial.");
                return;
            }
            if (zzcelVar.zzaF()) {
                zzh("Cannot resize an expanded banner.");
                return;
            }
            if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
                com.google.android.gms.ads.internal.zzv.zzq();
                this.zzh = com.google.android.gms.ads.internal.util.zzs.zzP((String) map.get("width"));
            }
            if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
                com.google.android.gms.ads.internal.zzv.zzq();
                this.zze = com.google.android.gms.ads.internal.util.zzs.zzP((String) map.get("height"));
            }
            if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
                com.google.android.gms.ads.internal.zzv.zzq();
                this.zzf = com.google.android.gms.ads.internal.util.zzs.zzP((String) map.get("offsetX"));
            }
            if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
                com.google.android.gms.ads.internal.zzv.zzq();
                this.zzg = com.google.android.gms.ads.internal.util.zzs.zzP((String) map.get("offsetY"));
            }
            if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
                this.zzb = Boolean.parseBoolean((String) map.get("allowOffscreen"));
            }
            String str = (String) map.get("customClosePosition");
            if (!TextUtils.isEmpty(str)) {
                this.zza = str;
            }
            if (this.zzh < 0 || this.zze < 0) {
                zzh("Invalid width and height options. Cannot resize.");
                return;
            }
            Window window = activity.getWindow();
            if (window != null && window.getDecorView() != null) {
                com.google.android.gms.ads.internal.zzv.zzq();
                int[] iArrZzW = com.google.android.gms.ads.internal.util.zzs.zzW(activity);
                com.google.android.gms.ads.internal.zzv.zzq();
                int[] iArrZzS = com.google.android.gms.ads.internal.util.zzs.zzS(activity);
                int i6 = iArrZzW[0];
                int i7 = iArrZzW[1];
                int i8 = this.zzh;
                int[] iArr = null;
                if (i8 < 50 || i8 > i6) {
                    int i9 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Width is too small or too large.");
                } else {
                    int i10 = this.zze;
                    if (i10 < 50 || i10 > i7) {
                        int i11 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Height is too small or too large.");
                    } else if (i10 == i7 && i8 == i6) {
                        int i12 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot resize to a full-screen ad.");
                    } else if (this.zzb) {
                        switch (this.zza) {
                            case "center":
                                b = 2;
                                break;
                            case "top-left":
                                b = 0;
                                break;
                            case "bottom-left":
                                b = 3;
                                break;
                            case "bottom-right":
                                b = 5;
                                break;
                            case "bottom-center":
                                b = 4;
                                break;
                            case "top-center":
                                b = 1;
                                break;
                            default:
                                b = -1;
                                break;
                        }
                        if (b == 0) {
                            i2 = this.zzc + this.zzf;
                            i3 = this.zzd;
                        } else if (b != 1) {
                            if (b != 2) {
                                if (b == 3) {
                                    i2 = this.zzc + this.zzf;
                                    i5 = this.zzd;
                                } else if (b == 4) {
                                    i2 = ((this.zzc + this.zzf) + (i8 >> 1)) - 25;
                                    i5 = this.zzd;
                                } else if (b != 5) {
                                    i2 = ((this.zzc + this.zzf) + i8) - 50;
                                    i3 = this.zzd;
                                } else {
                                    i2 = ((this.zzc + this.zzf) + i8) - 50;
                                    i5 = this.zzd;
                                }
                                i4 = ((i5 + this.zzg) + i10) - 50;
                            } else {
                                i2 = ((this.zzc + this.zzf) + (i8 >> 1)) - 25;
                                i4 = ((this.zzd + this.zzg) + (i10 >> 1)) - 25;
                            }
                            if (i2 >= 0 && i2 + 50 <= i6 && i4 >= iArrZzS[0] && i4 + 50 <= iArrZzS[1]) {
                                iArr = new int[]{this.zzc + this.zzf, this.zzd + this.zzg};
                            }
                        } else {
                            i2 = ((this.zzc + this.zzf) + (i8 >> 1)) - 25;
                            i3 = this.zzd;
                        }
                        i4 = i3 + this.zzg;
                        if (i2 >= 0) {
                            iArr = new int[]{this.zzc + this.zzf, this.zzd + this.zzg};
                        }
                    } else {
                        com.google.android.gms.ads.internal.zzv.zzq();
                        int[] iArrZzW2 = com.google.android.gms.ads.internal.util.zzs.zzW(activity);
                        com.google.android.gms.ads.internal.zzv.zzq();
                        int[] iArrZzS2 = com.google.android.gms.ads.internal.util.zzs.zzS(activity);
                        int i13 = iArrZzW2[0];
                        int i14 = this.zzc + this.zzf;
                        int i15 = this.zzd + this.zzg;
                        if (i14 < 0) {
                            i = 0;
                        } else {
                            int i16 = this.zzh;
                            i = i14 + i16 > i13 ? i13 - i16 : i14;
                        }
                        int i17 = iArrZzS2[0];
                        if (i15 < i17) {
                            i15 = i17;
                        } else {
                            int i18 = this.zze;
                            int i19 = i15 + i18;
                            int i20 = iArrZzS2[1];
                            if (i19 > i20) {
                                i15 = i20 - i18;
                            }
                        }
                        iArr = new int[]{i, i15};
                    }
                }
                if (iArr == null) {
                    zzh("Resize location out of screen or close button is not visible.");
                    return;
                }
                com.google.android.gms.ads.internal.client.zzbb.zzb();
                int iZzy = com.google.android.gms.ads.internal.util.client.zzf.zzy(activity, this.zzh);
                com.google.android.gms.ads.internal.client.zzbb.zzb();
                int iZzy2 = com.google.android.gms.ads.internal.util.client.zzf.zzy(activity, this.zze);
                ViewParent parent = ((View) zzcelVar).getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    zzh("Webview is detached, probably in the middle of a resize or expand.");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeView((View) zzcelVar);
                PopupWindow popupWindow = this.zzp;
                if (popupWindow == null) {
                    this.zzr = viewGroup;
                    com.google.android.gms.ads.internal.zzv.zzq();
                    ((View) zzcelVar).setDrawingCacheEnabled(true);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((View) zzcelVar).getDrawingCache());
                    ((View) zzcelVar).setDrawingCacheEnabled(false);
                    ImageView imageView = new ImageView(activity);
                    this.zzm = imageView;
                    imageView.setImageBitmap(bitmapCreateBitmap);
                    this.zzl = zzcelVar.zzO();
                    this.zzr.addView(this.zzm);
                } else {
                    popupWindow.dismiss();
                }
                RelativeLayout relativeLayout = new RelativeLayout(activity);
                this.zzq = relativeLayout;
                relativeLayout.setBackgroundColor(0);
                this.zzq.setLayoutParams(new ViewGroup.LayoutParams(iZzy, iZzy2));
                com.google.android.gms.ads.internal.zzv.zzq();
                PopupWindow popupWindow2 = new PopupWindow((View) this.zzq, iZzy, iZzy2, false);
                this.zzp = popupWindow2;
                popupWindow2.setOutsideTouchable(false);
                this.zzp.setTouchable(true);
                this.zzp.setClippingEnabled(!this.zzb);
                byte b2 = -1;
                this.zzq.addView((View) zzcelVar, -1, -1);
                this.zzn = new LinearLayout(activity);
                com.google.android.gms.ads.internal.client.zzbb.zzb();
                int iZzy3 = com.google.android.gms.ads.internal.util.client.zzf.zzy(activity, 50);
                com.google.android.gms.ads.internal.client.zzbb.zzb();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iZzy3, com.google.android.gms.ads.internal.util.client.zzf.zzy(activity, 50));
                String str2 = this.zza;
                switch (str2.hashCode()) {
                    case -1364013995:
                        if (str2.equals("center")) {
                            b2 = 2;
                        }
                        break;
                    case -1012429441:
                        if (str2.equals(b9.e.c)) {
                            b2 = 0;
                        }
                        break;
                    case -655373719:
                        if (str2.equals(b9.e.e)) {
                            b2 = 3;
                        }
                        break;
                    case 1163912186:
                        if (str2.equals(b9.e.d)) {
                            b2 = 5;
                        }
                        break;
                    case 1288627767:
                        if (str2.equals("bottom-center")) {
                            b2 = 4;
                        }
                        break;
                    case 1755462605:
                        if (str2.equals("top-center")) {
                            b2 = 1;
                        }
                        break;
                }
                if (b2 == 0) {
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                } else if (b2 == 1) {
                    layoutParams.addRule(10);
                    layoutParams.addRule(14);
                } else if (b2 == 2) {
                    layoutParams.addRule(13);
                } else if (b2 == 3) {
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                } else if (b2 == 4) {
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                } else if (b2 != 5) {
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                } else {
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                }
                this.zzn.setOnClickListener(new zzbrv(this));
                this.zzn.setContentDescription("Close button");
                this.zzq.addView(this.zzn, layoutParams);
                try {
                    PopupWindow popupWindow3 = this.zzp;
                    View decorView = window.getDecorView();
                    com.google.android.gms.ads.internal.client.zzbb.zzb();
                    int iZzy4 = com.google.android.gms.ads.internal.util.client.zzf.zzy(activity, iArr[0]);
                    com.google.android.gms.ads.internal.client.zzbb.zzb();
                    popupWindow3.showAtLocation(decorView, 0, iZzy4, com.google.android.gms.ads.internal.util.client.zzf.zzy(activity, iArr[1]));
                    int i21 = iArr[0];
                    int i22 = iArr[1];
                    zzbsd zzbsdVar = this.zzo;
                    if (zzbsdVar != null) {
                        zzbsdVar.zza(i21, i22, this.zzh, this.zze);
                    }
                    this.zzj.zzaj(zzcgf.zzb(iZzy, iZzy2));
                    int i23 = iArr[0];
                    int i24 = iArr[1];
                    com.google.android.gms.ads.internal.zzv.zzq();
                    zzk(i23, i24 - com.google.android.gms.ads.internal.util.zzs.zzS(this.zzk)[0], this.zzh, this.zze);
                    zzl("resized");
                    return;
                } catch (RuntimeException e) {
                    zzh("Cannot show popup window: " + e.getMessage());
                    RelativeLayout relativeLayout2 = this.zzq;
                    zzcel zzcelVar2 = this.zzj;
                    relativeLayout2.removeView((View) zzcelVar2);
                    ViewGroup viewGroup2 = this.zzr;
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(this.zzm);
                        this.zzr.addView((View) zzcelVar2);
                        zzcelVar2.zzaj(this.zzl);
                    }
                    return;
                }
            }
            zzh("Activity context is not ready, cannot get window or decor view.");
        }
    }

    public final void zzd(int i, int i2, boolean z) {
        synchronized (this.zzi) {
            this.zzc = i;
            this.zzd = i2;
        }
    }

    public final void zze(int i, int i2) {
        this.zzc = i;
        this.zzd = i2;
    }

    public final boolean zzf() {
        boolean z;
        synchronized (this.zzi) {
            z = this.zzp != null;
        }
        return z;
    }
}
