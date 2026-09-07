package com.mbridge.msdk.foundation.same.net;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.o0;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: SocketManager.java */
/* JADX INFO: loaded from: classes6.dex */
public class f {
    private static volatile AtomicInteger b = new AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f4983a;

    /* JADX INFO: compiled from: SocketManager.java */
    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
            threadNewThread.setName("SocketThreadPool");
            return threadNewThread;
        }
    }

    /* JADX INFO: compiled from: SocketManager.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f4985a;

        b(c cVar) {
            this.f4985a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4985a.a();
        }
    }

    /* JADX INFO: compiled from: SocketManager.java */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static f f4987a = new f(null);
    }

    /* synthetic */ f(a aVar) {
        this();
    }

    public static f b() {
        return d.f4987a;
    }

    private f() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(), new ThreadPoolExecutor.DiscardPolicy());
        this.f4983a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public byte[] a(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public String a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i = gZIPInputStream.read(bArr2, 0, 1024);
            if (i > 0) {
                byteArrayOutputStream.write(bArr2, 0, i);
            } else {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toString();
            }
        }
    }

    public void a(String str, int i, String str2, boolean z, com.mbridge.msdk.foundation.same.net.b bVar) {
        this.f4983a.execute(new b(new c(str, i, str2, z, bVar)));
    }

    /* JADX INFO: compiled from: SocketManager.java */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ByteBuffer f4986a;
        private String b;
        private boolean c;
        private com.mbridge.msdk.foundation.same.net.b d;
        private OutputStream e;
        private int f;
        private Socket g;
        private String h;

        c(String str, int i, String str2, boolean z, com.mbridge.msdk.foundation.same.net.b bVar) {
            this.b = str;
            this.f = i;
            this.h = str2;
            this.c = z;
            this.d = bVar;
        }

        public void a() {
            int length;
            try {
                Socket socket = new Socket(this.b, this.f);
                this.g = socket;
                socket.setSoTimeout(15000);
                boolean z = this.b.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().j) || this.b.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().l);
                o0.b("SocketManager", "Socket connect : " + this.b + " : " + this.f + " isAnalytics : " + z);
                this.e = this.g.getOutputStream();
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[8]);
                this.f4986a = byteBufferWrap;
                ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                byteBufferWrap.order(byteOrder);
                this.f4986a.put((byte) 2);
                if (TextUtils.isEmpty(this.h)) {
                    this.f4986a.put((byte) 1);
                } else {
                    this.f4986a.put(this.c ? (byte) 3 : (byte) 2);
                }
                this.f4986a.putShort((short) f.b.getAndIncrement());
                if (TextUtils.isEmpty(this.h)) {
                    this.f4986a.putInt(0);
                    this.e.write(this.f4986a.array());
                    length = 0;
                } else {
                    byte[] bArrA = this.c ? f.this.a(this.h) : this.h.getBytes();
                    length = bArrA.length;
                    this.f4986a.putInt(length);
                    this.e.write(this.f4986a.array());
                    this.e.write(bArrA);
                }
                this.e.flush();
                o0.a("SocketManager", "Socket Request : header : " + Arrays.toString(this.f4986a.array()) + " length : " + length);
                InputStream inputStream = this.g.getInputStream();
                byte[] bArr = new byte[8];
                inputStream.read(bArr, 0, 8);
                ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr);
                this.f4986a = byteBufferWrap2;
                byteBufferWrap2.order(byteOrder);
                int i = this.f4986a.getInt(4);
                byte b = bArr[1];
                boolean z2 = b == 3;
                boolean z3 = b == 2;
                o0.b("SocketManager", "Socket Response : header : " + Arrays.toString(bArr) + " length : " + i + " isGzip : " + z2);
                byte[] bArr2 = new byte[i];
                new DataInputStream(this.g.getInputStream()).readFully(bArr2);
                if (!z2 && i > 2 && ((bArr2[0] << 8) | (bArr2[1] & 255)) == 8075) {
                    z2 = true;
                }
                com.mbridge.msdk.foundation.same.net.b bVar = this.d;
                if (bVar == null) {
                    Socket socket2 = this.g;
                    if (socket2 != null) {
                        try {
                            socket2.close();
                            this.f4986a = null;
                            this.e.close();
                            return;
                        } catch (IOException e) {
                            o0.b("SocketManager", e.getMessage());
                            return;
                        }
                    }
                    return;
                }
                if (z3 && i == 0) {
                    bVar.onSuccess(e.a(null, new com.mbridge.msdk.foundation.same.net.toolbox.a(204, null, null)));
                    Socket socket3 = this.g;
                    if (socket3 != null) {
                        try {
                            socket3.close();
                            this.f4986a = null;
                            this.e.close();
                            return;
                        } catch (IOException e2) {
                            o0.b("SocketManager", e2.getMessage());
                            return;
                        }
                    }
                    return;
                }
                if (i < 1) {
                    a("The response data less than 1");
                    Socket socket4 = this.g;
                    if (socket4 != null) {
                        try {
                            socket4.close();
                            this.f4986a = null;
                            this.e.close();
                            return;
                        } catch (IOException e3) {
                            o0.b("SocketManager", e3.getMessage());
                            return;
                        }
                    }
                    return;
                }
                if (z) {
                    if (bArr2[0] == 1) {
                        bVar.onSuccess(e.a(null, new com.mbridge.msdk.foundation.same.net.toolbox.a(200, null, null)));
                    } else {
                        a("The server returns fail");
                    }
                    Socket socket5 = this.g;
                    if (socket5 != null) {
                        try {
                            socket5.close();
                            this.f4986a = null;
                            this.e.close();
                            return;
                        } catch (IOException e4) {
                            o0.b("SocketManager", e4.getMessage());
                            return;
                        }
                    }
                    return;
                }
                try {
                    String strA = z2 ? f.this.a(bArr2) : new String(bArr2);
                    JSONObject jSONObjectJsonObjectInit = !TextUtils.isEmpty(strA) ? MintegralNetworkBridge.jsonObjectInit(strA) : null;
                    o0.b("SocketManager", "Socket Response length : " + i + " " + strA.length());
                    this.d.onSuccess(e.a(jSONObjectJsonObjectInit, new com.mbridge.msdk.foundation.same.net.toolbox.a(200, null, null)));
                } catch (Throwable th) {
                    String message = th.getMessage();
                    o0.b("SocketManager", th.getMessage());
                    if (TextUtils.isEmpty(message)) {
                        message = "The JSON data is illegal";
                    }
                    a(message);
                }
                inputStream.close();
                Socket socket6 = this.g;
                if (socket6 != null) {
                    try {
                        socket6.close();
                        this.f4986a = null;
                        this.e.close();
                    } catch (IOException e5) {
                        o0.b("SocketManager", e5.getMessage());
                    }
                }
            } catch (Throwable th2) {
                try {
                    String message2 = th2.getMessage();
                    o0.a("SocketManager", "Socket exception: " + message2);
                    a(message2);
                } finally {
                    Socket socket7 = this.g;
                    if (socket7 != null) {
                        try {
                            socket7.close();
                            this.f4986a = null;
                            this.e.close();
                        } catch (IOException e6) {
                            o0.b("SocketManager", e6.getMessage());
                        }
                    }
                }
            }
        }

        private void a(String str) {
            if (this.d != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "Unknown exception";
                }
                this.d.onError(new com.mbridge.msdk.foundation.same.net.exception.a(13, new com.mbridge.msdk.foundation.same.net.toolbox.a(404, str.getBytes(), null)));
            }
        }
    }
}
