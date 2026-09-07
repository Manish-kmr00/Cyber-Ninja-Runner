package com.mbridge.msdk.foundation.same.report;

import android.util.Log;
import com.mbridge.msdk.tracker.network.t;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: SocketStack.java */
/* JADX INFO: loaded from: classes11.dex */
public class m extends com.mbridge.msdk.tracker.network.toolbox.a {
    private static final AtomicInteger b = new AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte f5020a;

    public m(byte b2) {
        this.f5020a = b2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v3 */
    @Override // com.mbridge.msdk.tracker.network.toolbox.a
    public com.mbridge.msdk.tracker.network.toolbox.g a(t<?> tVar, Map<String, String> map) throws IOException {
        ?? r0;
        ByteBuffer byteBuffer;
        ByteBuffer byteBufferWrap;
        if (com.mbridge.msdk.tracker.a.f5612a) {
            Log.d("TrackManager_Volley", "SocketStack executeRequest " + tVar.t() + ":" + tVar.k());
        }
        Socket socket = null;
        try {
            Socket socket2 = new Socket(tVar.t(), tVar.k());
            try {
                socket2.setSoTimeout(tVar.q());
                OutputStream outputStream = socket2.getOutputStream();
                try {
                    if (outputStream == null) {
                        throw new IOException("create outputStream exception");
                    }
                    byteBufferWrap = ByteBuffer.wrap(new byte[8]);
                    try {
                        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                        byteBufferWrap.order(byteOrder);
                        byteBufferWrap.put(this.f5020a);
                        byte[] bArrB = tVar.b();
                        if (bArrB == null || bArrB.length == 0) {
                            byteBufferWrap.put((byte) 1);
                        } else {
                            byteBufferWrap.put((byte) 3);
                        }
                        byteBufferWrap.putShort((short) b.getAndIncrement());
                        if (bArrB == null || bArrB.length == 0) {
                            byteBufferWrap.putInt(0);
                            outputStream.write(byteBufferWrap.array());
                        } else {
                            byte[] bArrA = a(bArrB);
                            byteBufferWrap.putInt(bArrA == null ? 0 : bArrA.length);
                            outputStream.write(byteBufferWrap.array());
                            outputStream.write(bArrA);
                        }
                        outputStream.flush();
                        byte[] bArr = new byte[8];
                        socket2.getInputStream().read(bArr, 0, 8);
                        ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr);
                        try {
                            byteBufferWrap2.order(byteOrder);
                            int i = byteBufferWrap2.getInt(4);
                            boolean z = bArr[1] == 2;
                            byte[] bArr2 = new byte[i];
                            new DataInputStream(socket2.getInputStream()).readFully(bArr2);
                            if (z && i == 0) {
                                com.mbridge.msdk.tracker.network.toolbox.g gVar = new com.mbridge.msdk.tracker.network.toolbox.g(204, new ArrayList(), i, null);
                                a(outputStream);
                                a(socket2);
                                a(byteBufferWrap);
                                a(byteBufferWrap2);
                                return gVar;
                            }
                            if (i < 1) {
                                com.mbridge.msdk.tracker.network.toolbox.g gVar2 = new com.mbridge.msdk.tracker.network.toolbox.g(500, new ArrayList(), 0, null);
                                a(outputStream);
                                a(socket2);
                                a(byteBufferWrap);
                                a(byteBufferWrap2);
                                return gVar2;
                            }
                            if (bArr2[0] == 1) {
                                com.mbridge.msdk.tracker.network.toolbox.g gVar3 = new com.mbridge.msdk.tracker.network.toolbox.g(200, new ArrayList(), i, null);
                                a(outputStream);
                                a(socket2);
                                a(byteBufferWrap);
                                a(byteBufferWrap2);
                                return gVar3;
                            }
                            com.mbridge.msdk.tracker.network.toolbox.g gVar4 = new com.mbridge.msdk.tracker.network.toolbox.g(500, new ArrayList(), 0, null);
                            a(outputStream);
                            a(socket2);
                            a(byteBufferWrap);
                            a(byteBufferWrap2);
                            return gVar4;
                        } catch (Throwable th) {
                            byteBuffer = byteBufferWrap2;
                            th = th;
                            socket = outputStream;
                            r0 = socket;
                            socket = socket2;
                            try {
                                throw new IOException(th);
                            } catch (Throwable th2) {
                                a((OutputStream) r0);
                                a(socket);
                                a(byteBufferWrap);
                                a(byteBuffer);
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        byteBuffer = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    byteBufferWrap = null;
                    socket = outputStream;
                    byteBuffer = null;
                }
            } catch (Throwable th5) {
                th = th5;
                byteBuffer = null;
                byteBufferWrap = null;
            }
        } catch (Throwable th6) {
            th = th6;
            r0 = 0;
            byteBuffer = null;
            byteBufferWrap = null;
        }
    }

    public byte[] a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    private static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception unused) {
            }
        }
    }

    private void a(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            try {
                byteBuffer.clear();
            } catch (Exception unused) {
            }
        }
    }
}
