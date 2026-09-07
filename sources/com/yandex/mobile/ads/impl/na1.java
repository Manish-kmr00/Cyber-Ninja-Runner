package com.yandex.mobile.ads.impl;

import android.media.MediaCodec;
import android.media.MediaDrmResetException;
import android.media.ResourceBusyException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class na1 {
    /* JADX WARN: Code duplicated, block: B:44:0x008e  */
    private static pc2.a a(Throwable th) {
        pc2.a aVar;
        pc2.a aVar2;
        boolean z;
        if (th instanceof uh1) {
            Throwable cause = th.getCause();
            if (cause == null || !(((z = cause instanceof MediaCodec.CodecException)) || (cause instanceof IllegalStateException) || (cause instanceof IllegalArgumentException))) {
                aVar2 = null;
            } else {
                StackTraceElement[] stackTrace = cause.getStackTrace();
                Intrinsics.checkNotNull(stackTrace);
                if (!(stackTrace.length == 0) && stackTrace[0].isNativeMethod() && Intrinsics.areEqual(stackTrace[0].getClassName(), "android.media.MediaCodec")) {
                    String methodName = stackTrace[0].getMethodName();
                    if (methodName == null) {
                        methodName = "";
                    }
                    if (Intrinsics.areEqual(methodName, "native_dequeueOutputBuffer")) {
                        aVar2 = pc2.a.b;
                    } else if (Intrinsics.areEqual(methodName, "native_dequeueInputBuffer")) {
                        aVar2 = pc2.a.c;
                    } else if (Intrinsics.areEqual(methodName, "native_stop")) {
                        aVar2 = pc2.a.d;
                    } else if (Intrinsics.areEqual(methodName, "native_setSurface")) {
                        aVar2 = pc2.a.e;
                    } else if (Intrinsics.areEqual(methodName, "releaseOutputBuffer")) {
                        aVar2 = pc2.a.f;
                    } else if (Intrinsics.areEqual(methodName, "native_queueSecureInputBuffer")) {
                        aVar2 = pc2.a.g;
                    } else if (z) {
                        aVar2 = pc2.a.h;
                    } else {
                        aVar2 = null;
                    }
                } else {
                    aVar2 = null;
                }
            }
            if (aVar2 != null) {
                return aVar2;
            }
            Throwable cause2 = th.getCause();
            pc2.a aVarA = cause2 != null ? a(cause2) : null;
            if (aVarA != null) {
                return aVarA;
            }
            aVar = pc2.a.E;
        } else if (th instanceof aj0) {
            aVar = pc2.a.j;
        } else if (th instanceof ov0.b) {
            aVar = pc2.a.k;
        } else if (th instanceof iv0.b) {
            aVar = pc2.a.l;
        } else if (th instanceof MediaCodec.CryptoException) {
            aVar = pc2.a.o;
        } else if (th instanceof d40.a) {
            Throwable cause3 = ((d40.a) th).getCause();
            if (cause3 == null) {
                aVar = pc2.a.q;
            } else if ((cause3 instanceof MediaDrmResetException) || (cause3 instanceof ResourceBusyException)) {
                aVar = pc2.a.p;
            } else {
                aVar = ((cause3 instanceof MediaCodec.CryptoException) || (cause3 instanceof wq0)) ? pc2.a.o : pc2.a.q;
            }
        } else if (th instanceof qh0) {
            int i = ((qh0) th).e;
            if (i == 401) {
                aVar = pc2.a.s;
            } else if (i != 403) {
                aVar = i != 404 ? pc2.a.v : pc2.a.u;
            } else {
                aVar = pc2.a.t;
            }
        } else if (th instanceof oh0) {
            aVar = ((oh0) th).getCause() instanceof SSLHandshakeException ? pc2.a.w : pc2.a.x;
        } else if (th instanceof ag1) {
            aVar = pc2.a.y;
        } else if (th instanceof ds0.g) {
            aVar = pc2.a.z;
        } else if ((th instanceof vh.a) || (th instanceof vh.b) || (th instanceof ez.h)) {
            aVar = pc2.a.A;
        } else if (th instanceof i32) {
            aVar = pc2.a.B;
        } else {
            aVar = ((th instanceof rm.a) || (th instanceof um.a)) ? pc2.a.C : pc2.a.F;
        }
        return aVar;
    }

    public static pc2 a(j60 throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        return new pc2(a((Throwable) throwable), throwable);
    }
}
