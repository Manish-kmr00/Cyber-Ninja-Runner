package sg.bigo.ads.core.player.a;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class d {
    ServerSocket b;
    public int c;
    private Thread f;
    private h g;
    private final Object d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final sg.bigo.ads.common.n.e f13682a = new sg.bigo.ads.common.n.e("Play", 3, 0);
    private final Map<String, e> e = new ConcurrentHashMap();

    final class a implements Runnable {
        private final Socket b;

        public a(Socket socket) {
            this.b = socket;
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            d dVar = d.this;
            Socket socket = this.b;
            try {
                try {
                    try {
                        sg.bigo.ads.core.player.a.b bVarA = sg.bigo.ads.core.player.a.b.a(socket.getInputStream());
                        if (bVarA == null) {
                            d.a(socket);
                            sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar.b());
                            return;
                        }
                        sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Request to cache proxy:request=".concat(String.valueOf(bVarA)));
                        String strF = q.f(bVarA.f13680a);
                        if (!"ping".equals(strF)) {
                            if (!TextUtils.isEmpty(strF)) {
                                final e eVarA = dVar.a(strF);
                                try {
                                    if (eVarA.a()) {
                                        try {
                                            if (SystemClock.elapsedRealtime() - eVarA.e > 300000) {
                                                int andSet = eVarA.f.getAndSet(0);
                                                eVarA.e = SystemClock.elapsedRealtime();
                                                sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "reset resetRetryCount=".concat(String.valueOf(andSet)));
                                            }
                                            eVarA.f13685a.incrementAndGet();
                                            if (eVarA.c != null && eVarA.c.j != 1 && !eVarA.c.b() && SystemClock.elapsedRealtime() - eVarA.d > 15000 && eVarA.f.getAndIncrement() < 3) {
                                                sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "keepDownloadTaskAlive retryCount=" + eVarA.f.get());
                                                eVarA.d = SystemClock.elapsedRealtime();
                                                sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.player.a.e.1
                                                    AnonymousClass1() {
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        sg.bigo.ads.core.player.b.a().g.a(e.this.c, true);
                                                    }
                                                });
                                            }
                                            c cVar = eVarA.b;
                                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
                                            String strF2 = q.f(bVarA.f13680a);
                                            MimeTypeMap singleton = MimeTypeMap.getSingleton();
                                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(strF2);
                                            String mimeTypeFromExtension = TextUtils.isEmpty(fileExtensionFromUrl) ? null : singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
                                            boolean zIsEmpty = TextUtils.isEmpty(mimeTypeFromExtension);
                                            long jA = cVar.f13681a.c() ? cVar.f13681a.a() : cVar.f13681a.b.i;
                                            boolean z = jA >= 0;
                                            long j = bVarA.c ? jA - bVarA.b : jA;
                                            boolean z2 = z && bVarA.c;
                                            try {
                                                StringBuilder sbAppend = new StringBuilder().append(bVarA.c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n").append("Accept-Ranges: bytes\n");
                                                String strA = "";
                                                if (z) {
                                                    strA = c.a("Content-Length: %d\n", Long.valueOf(j));
                                                }
                                                String string = sbAppend.append(strA).append(z2 ? c.a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(bVarA.b), Long.valueOf(jA - 1), Long.valueOf(jA)) : strA).append(!zIsEmpty ? c.a("Content-Type: %s\n", mimeTypeFromExtension) : "").append("\n").toString();
                                                sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "newResponseHeaders =".concat(String.valueOf(string)));
                                                bufferedOutputStream.write(string.getBytes("UTF-8"));
                                                cVar.a(bufferedOutputStream, bVarA.b);
                                                eVarA.b();
                                            } catch (Throwable th) {
                                                th = th;
                                                eVarA.b();
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } else {
                                        sg.bigo.ads.common.t.a.a(0, "ProxyCache", "startProcessRequest failed");
                                        eVarA.b();
                                    }
                                } catch (SocketException unused) {
                                    sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Closing socket… Socket is closed by client.");
                                    d.a(socket);
                                    sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar.b());
                                    return;
                                } catch (IOException e) {
                                    e = e;
                                    sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error processing request, error message is : " + e.toString());
                                    d.a(socket);
                                    sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar.b());
                                } catch (j e2) {
                                    e = e2;
                                    sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error processing request, error message is : " + e.toString());
                                    d.a(socket);
                                    sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar.b());
                                }
                            }
                            d.a(socket);
                            sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar.b());
                        }
                        try {
                            OutputStream outputStream = socket.getOutputStream();
                            outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
                            outputStream.write("ping ok".getBytes());
                        } catch (IOException e3) {
                            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Pinger#responseToPing, error message is : " + e3.toString());
                        }
                        d.a(socket);
                        sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar.b());
                    } catch (SocketException unused2) {
                    } catch (j e4) {
                        e = e4;
                        sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error processing request, error message is : " + e.toString());
                        d.a(socket);
                        sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar.b());
                    } catch (Throwable th3) {
                        th = th3;
                        d.a(socket);
                        sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar.b());
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error processing request, error message is : " + e.toString());
                    d.a(socket);
                    sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar.b());
                }
            } catch (Throwable th4) {
                th = th4;
                d.a(socket);
                sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar.b());
                throw th;
            }
        }
    }

    final class b implements Runnable {
        private final CountDownLatch b;

        public b(CountDownLatch countDownLatch) {
            this.b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.countDown();
            d dVar = d.this;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Socket socketAccept = dVar.b.accept();
                    sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Accept new socket socket=".concat(String.valueOf(socketAccept)));
                    dVar.f13682a.f13228a.submit(dVar.new a(socketAccept));
                } catch (Throwable th) {
                    sg.bigo.ads.core.d.b.a(3005, 10111, th.toString());
                    sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error during waiting connection, error message is : " + th.toString());
                    return;
                }
            }
        }
    }

    public d() {
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.b = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.c = localPort;
            f.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new b(countDownLatch));
            this.f = thread;
            thread.setName("BGAd-Conn");
            this.f.start();
            countDownLatch.await();
            this.g = new h("127.0.0.1", this.c);
            sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Proxy cache server started. Is it alive? " + a());
        } catch (IOException | InterruptedException e) {
            this.f13682a.f13228a.shutdown();
            sg.bigo.ads.core.d.b.a(3005, 10110, "Error starting local proxy server, error message is : " + e.toString());
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error starting local proxy server, error message is : " + e.toString());
        }
    }

    static void a(Socket socket) {
        String str;
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException unused) {
            str = "Releasing input stream… Socket is closed by client.";
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", str);
        } catch (IOException e) {
            str = "Error closing socket input stream, error message is " + e.getMessage();
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", str);
        }
        try {
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException e2) {
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Failed to close socket on proxy side: {}. It seems client have already closed connection." + e2.getMessage());
        }
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e3) {
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error closing socket" + e3.getMessage());
        }
    }

    final e a(String str) {
        e eVar;
        synchronized (this.d) {
            eVar = this.e.get(str);
            if (eVar == null) {
                eVar = new e(str);
                this.e.put(str, eVar);
            }
        }
        return eVar;
    }

    public final boolean a() {
        h hVar = this.g;
        return hVar != null && hVar.a();
    }

    final int b() {
        int i;
        synchronized (this.d) {
            Iterator<e> it = this.e.values().iterator();
            i = 0;
            while (it.hasNext()) {
                i += it.next().f13685a.get();
            }
        }
        return i;
    }
}
