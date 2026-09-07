package com.ogury.core.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdvertisingIdClient.kt */
/* JADX INFO: loaded from: classes12.dex */
public final class c {
    public static a a(Context context) throws Exception {
        a aVar;
        a aVar2;
        a aVar3;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("Cannot be called from the main thread".toString());
        }
        b bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        boolean z = true;
        if (context.bindService(intent, bVar, 1)) {
            try {
                if (bVar.b) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                bVar.b = true;
                IBinder iBinderTake = bVar.f7487a.take();
                Intrinsics.checkNotNull(iBinderTake, "null cannot be cast to non-null type android.os.IBinder");
                d dVar = new d(iBinderTake, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                aVar = new a(dVar.a(), dVar.b());
                context.unbindService(bVar);
            } catch (Exception unused) {
                context.unbindService(bVar);
                aVar = null;
            } catch (Throwable th) {
                context.unbindService(bVar);
                throw th;
            }
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar;
        }
        b bVar2 = new b();
        Intent intent2 = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent2.setPackage("com.huawei.hwid");
        if (context.bindService(intent2, bVar2, 1)) {
            try {
                if (bVar2.b) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                bVar2.b = true;
                IBinder iBinderTake2 = bVar2.f7487a.take();
                Intrinsics.checkNotNull(iBinderTake2, "null cannot be cast to non-null type android.os.IBinder");
                d dVar2 = new d(iBinderTake2, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                aVar2 = new a(dVar2.a(), dVar2.b());
                context.unbindService(bVar2);
            } catch (Exception unused2) {
                context.unbindService(bVar2);
                aVar2 = null;
            } catch (Throwable th2) {
                context.unbindService(bVar2);
                throw th2;
            }
        } else {
            aVar2 = null;
        }
        if (aVar2 != null) {
            return aVar2;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            String string = Settings.Secure.getString(contentResolver, "advertising_id");
            if (Settings.Secure.getInt(contentResolver, CommonUrlParts.LIMIT_AD_TRACKING) != 0) {
                z = false;
            }
            if (string == null) {
                throw new IllegalStateException("Amazon Fire TV Ad Id is null".toString());
            }
            aVar3 = new a(string, z);
            if (aVar3 != null) {
                return aVar3;
            }
            return null;
        } catch (Exception unused3) {
            aVar3 = null;
        }
    }
}
