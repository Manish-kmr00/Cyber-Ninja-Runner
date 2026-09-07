package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class R4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3602vc f3180a;
    public final C3644yc b;

    public R4(C3602vc c3602vc, C3644yc request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.f3180a = c3602vc;
        this.b = request;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 0;
        while (true) {
            C3644yc c3644yc = this.b;
            if (i > c3644yc.y) {
                return;
            }
            T8 t8B = c3644yc.b();
            if (this.b.A.get()) {
                return;
            }
            if (t8B.b()) {
                Intrinsics.checkNotNullExpressionValue("R4", "TAG");
                P8 p8 = t8B.c;
                if (i == this.b.y) {
                    this.f3180a.a(p8);
                    return;
                }
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(t8B.a());
                    if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
                        this.f3180a.a(jSONObject);
                        return;
                    } else {
                        this.f3180a.a(new A5().a(jSONObject, JSONObject.class));
                        return;
                    }
                } catch (Exception e) {
                    Intrinsics.checkNotNullExpressionValue("R4", "TAG");
                    if (i == this.b.y) {
                        C3602vc c3602vc = this.f3180a;
                        I3 i3 = I3.l;
                        String message = e.getMessage();
                        if (message == null) {
                            message = "Exception while parsing the response";
                        }
                        c3602vc.a(new P8(i3, message));
                        return;
                    }
                }
            }
            try {
                Thread.sleep(this.b.z * 1000);
            } catch (InterruptedException unused) {
                Intrinsics.checkNotNullExpressionValue("R4", "TAG");
            }
            if (this.b.A.get()) {
                return;
            } else {
                i++;
            }
        }
    }
}
