package com.inmobi.media;

import android.graphics.Bitmap;
import com.inmobi.adquality.models.AdQualityControl;
import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class X implements D9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Z f3231a;
    public final /* synthetic */ F1 b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ C3543ra d;

    public X(Z z, F1 f1, boolean z2, C3543ra c3543ra) {
        this.f3231a = z;
        this.b = f1;
        this.c = z2;
        this.d = c3543ra;
    }

    @Override // com.inmobi.media.D9
    public final void a(Object obj) {
        String beacon;
        Bitmap bitmap = (Bitmap) obj;
        Z z = this.f3231a;
        F1 process = this.b;
        boolean z2 = this.c;
        C3543ra c3543ra = this.d;
        z.getClass();
        Intrinsics.checkNotNullParameter(process, "process");
        z.a("Screen shot result received - isReporting - " + z2);
        z.f.remove(process);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap != null) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (bitmap != null && c3543ra != null) {
            c3543ra.f3417a.b("window.mraidview.broadcastEvent('ScreenshotSuccess')");
        }
        if (z2) {
            String str = z.j;
            Intrinsics.checkNotNull(byteArray);
            z.a(str, byteArray, true);
        } else {
            AdQualityControl adQualityControl = z.g;
            if (adQualityControl != null && (beacon = adQualityControl.getBeacon()) != null) {
                z.a("saving to file - beacon - ".concat(beacon));
                Intrinsics.checkNotNull(byteArray);
                z.a(beacon, byteArray, false);
            }
        }
        z.l.set(false);
    }

    @Override // com.inmobi.media.D9
    public final void onError(Exception exc) {
        Z z = this.f3231a;
        F1 process = this.b;
        z.getClass();
        Intrinsics.checkNotNullParameter(process, "process");
        z.a(exc, "error in running process - ".concat(process.getClass().getSimpleName()));
        z.f.remove(process);
        z.a(true);
    }
}
