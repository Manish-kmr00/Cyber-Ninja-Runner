package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbrz extends zzbsc {
    private final Map zza;
    private final Context zzb;

    public zzbrz(zzcel zzcelVar, Map map) {
        super(zzcelVar, "storePicture");
        this.zza = map;
        this.zzb = zzcelVar.zzi();
    }

    public final void zzb() {
        Context context = this.zzb;
        if (context == null) {
            zzh("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.zzv.zzq();
        if (!new zzbbq(context).zzc()) {
            zzh("Feature is not supported by the device.");
            return;
        }
        String str = (String) this.zza.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzh("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            zzh("Invalid image url: ".concat(String.valueOf(str)));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        com.google.android.gms.ads.internal.zzv.zzq();
        if (TextUtils.isEmpty(lastPathSegment) || !lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
            zzh("Image type not recognized: ".concat(String.valueOf(lastPathSegment)));
            return;
        }
        Resources resourcesZze = com.google.android.gms.ads.internal.zzv.zzp().zze();
        com.google.android.gms.ads.internal.zzv.zzq();
        AlertDialog.Builder builderZzL = com.google.android.gms.ads.internal.util.zzs.zzL(context);
        builderZzL.setTitle(resourcesZze != null ? resourcesZze.getString(R.string.s1) : "Save image");
        builderZzL.setMessage(resourcesZze != null ? resourcesZze.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
        builderZzL.setPositiveButton(resourcesZze != null ? resourcesZze.getString(R.string.s3) : "Accept", new zzbrx(this, str, lastPathSegment));
        builderZzL.setNegativeButton(resourcesZze != null ? resourcesZze.getString(R.string.s4) : "Decline", new zzbry(this));
        builderZzL.create().show();
    }
}
