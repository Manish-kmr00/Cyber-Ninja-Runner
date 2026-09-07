package com.fyber.inneractive.sdk.mraid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.b0;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.web.C3284x;
import com.fyber.inneractive.sdk.web.DialogInterfaceOnClickListenerC3285y;
import com.fyber.inneractive.sdk.web.I;
import com.fyber.inneractive.sdk.web.RunnableC3282v;
import java.io.File;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class v extends AbstractC3122e {
    public v(LinkedHashMap linkedHashMap, I i, h0 h0Var) {
        super(linkedHashMap, i, h0Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3123f
    public final void a() {
        String str = (String) this.b.get("uri");
        if (str != null) {
            String externalStorageState = "";
            if (!"".equals(str)) {
                I i = this.c;
                Context contextA = AbstractC3251o.a(i.b);
                try {
                    externalStorageState = Environment.getExternalStorageState();
                } catch (Throwable unused) {
                }
                if (!"mounted".equals(externalStorageState) || AbstractC3251o.f2370a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    i.a(k.STORE_PICTURE, "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
                    IAlog.a("Error downloading file. Please check if the Android permission is not granted, or maybe the device does not have an SD card mounted? ", new Object[0]);
                    return;
                }
                if (contextA instanceof Activity) {
                    new AlertDialog.Builder(AbstractC3251o.a(i.b)).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).setPositiveButton("Okay", new DialogInterfaceOnClickListenerC3285y(i, str)).setCancelable(true).show();
                    return;
                }
                com.fyber.inneractive.sdk.util.r.b.post(new RunnableC3282v("Downloading image to Picture gallery..."));
                new File(Environment.getExternalStorageDirectory(), "Pictures").mkdirs();
                com.fyber.inneractive.sdk.flow.x xVar = i.s;
                IAConfigManager.O.s.b(new b0(new C3284x(i), str, xVar != null ? xVar.c : null));
                return;
            }
        }
        this.c.a(k.STORE_PICTURE, "Image can't be stored with null or empty URL");
        IAlog.a("Mraid Store Picture -Invalid URI ", new Object[0]);
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3122e
    public final String c() {
        return (String) this.b.get("uri");
    }
}
