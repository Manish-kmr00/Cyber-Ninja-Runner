package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class o {
    public static final i.a.AbstractC0600a a(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (e instanceof UnknownHostException) {
            return i.a.AbstractC0600a.q.c;
        }
        if (e instanceof SocketException) {
            return i.a.AbstractC0600a.C0602i.c;
        }
        if (e instanceof SSLHandshakeException) {
            return i.a.AbstractC0600a.j.c;
        }
        if (e instanceof IOException) {
            return i.a.AbstractC0600a.f.c;
        }
        if (e instanceof SecurityException) {
            return i.a.AbstractC0600a.g.c;
        }
        if (e instanceof p) {
            return i.a.AbstractC0600a.m.c;
        }
        return e instanceof NumberFormatException ? i.a.AbstractC0600a.l.c : i.a.AbstractC0600a.r.c;
    }
}
