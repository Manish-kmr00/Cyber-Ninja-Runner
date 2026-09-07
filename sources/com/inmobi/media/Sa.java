package com.inmobi.media;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class Sa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pa f3194a;
    public final Qa b;

    public Sa(Pa request, Qa qa) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.f3194a = request;
        this.b = qa;
    }

    /* JADX WARN: Type inference failed for: r9v6, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    public static final void a(Sa this$0, Va response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(response, "$response");
        Pa request = this$0.f3194a;
        request.getClass();
        Intrinsics.checkNotNullParameter(response, "response");
        R8 r8 = request.l;
        if (r8 != null) {
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(response, "<this>");
            T8 response2 = new T8();
            byte[] value = response.c;
            if (value != null) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (value.length == 0) {
                    response2.b = new byte[0];
                } else {
                    byte[] bArr = new byte[value.length];
                    response2.b = bArr;
                    System.arraycopy(value, 0, bArr, 0, value.length);
                }
            }
            response2.e = response.b;
            response2.d = response.e;
            response2.c = response.f3220a;
            S8 request2 = r8.f3183a;
            Intrinsics.checkNotNullParameter(response2, "response");
            Intrinsics.checkNotNullParameter(request2, "request");
            r8.b.invoke(response2);
        }
        request.l = null;
        Set set = Ra.f3184a;
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            Ra.f3184a.remove(request);
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3194a.getClass();
        int i = O8.f3157a;
        final Va vaA = O8.a(this.f3194a, this.b);
        P8 p8 = vaA.f3220a;
        if ((p8 != null ? p8.f3168a : null) != I3.m) {
            ExecutorC3596v6 executorC3596v6 = (ExecutorC3596v6) S3.d.getValue();
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.Sa$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Sa.a(this.f$0, vaA);
                }
            };
            executorC3596v6.getClass();
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            executorC3596v6.f3456a.post(runnable);
            this.f3194a.getClass();
        }
    }
}
