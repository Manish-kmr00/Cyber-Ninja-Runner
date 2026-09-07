package com.mbridge.msdk.thrid.okhttp.internal;

import com.mbridge.msdk.thrid.okhttp.a0;
import com.mbridge.msdk.thrid.okhttp.h;
import com.mbridge.msdk.thrid.okhttp.i;
import com.mbridge.msdk.thrid.okhttp.internal.connection.g;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okhttp.y;
import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: Internal.java */
/* JADX INFO: loaded from: classes10.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f5510a;

    public abstract int a(y.a aVar);

    public abstract com.mbridge.msdk.thrid.okhttp.internal.connection.c a(h hVar, com.mbridge.msdk.thrid.okhttp.a aVar, g gVar, a0 a0Var);

    public abstract com.mbridge.msdk.thrid.okhttp.internal.connection.d a(h hVar);

    @Nullable
    public abstract IOException a(com.mbridge.msdk.thrid.okhttp.d dVar, @Nullable IOException iOException);

    public abstract Socket a(h hVar, com.mbridge.msdk.thrid.okhttp.a aVar, g gVar);

    public abstract void a(i iVar, SSLSocket sSLSocket, boolean z);

    public abstract void a(p.a aVar, String str);

    public abstract void a(p.a aVar, String str, String str2);

    public abstract boolean a(com.mbridge.msdk.thrid.okhttp.a aVar, com.mbridge.msdk.thrid.okhttp.a aVar2);

    public abstract boolean a(h hVar, com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar);

    public abstract void b(h hVar, com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar);
}
