package sg.bigo.ads.common.h.b;

import android.content.Context;
import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.foundation.download.core.IDownloadTask;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f13199a;
    private InputStream b;
    private final File c;
    private final Context d;

    public d(Context context, a aVar) {
        this.d = context;
        this.f13199a = aVar;
        this.c = new File(aVar.b.c, sg.bigo.ads.common.utils.f.c(aVar.b.d));
    }

    private void a() throws Throwable {
        String str = "the download task error and download state is not loading.";
        a("startDownloadTask");
        if (this.b == null) {
            b("downloadStream is null");
            return;
        }
        this.f13199a.e = h.d;
        f.a().a(this.f13199a.f13197a);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(this.b);
        byte[] bArr = new byte[1048576];
        boolean z = false;
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.c, "rwd");
                try {
                    long j = this.f13199a.b.g;
                    randomAccessFile2.seek(j);
                    sg.bigo.ads.common.t.a.a(0, 3, IDownloadTask.TAG, this.f13199a.f13197a + " startDownloadTask.");
                    while (this.f13199a.e == h.d) {
                        int i = bufferedInputStream.read(bArr, 0, 1048576);
                        if (i == -1) {
                            if (j <= 0 || this.c.length() != j || this.f13199a.e != h.d) {
                                break;
                            }
                            this.c.renameTo(new File(this.f13199a.b.c, this.f13199a.b.d));
                            this.f13199a.e = h.f;
                            z = true;
                            f.a().a(this.f13199a.f13197a);
                            a("download is over.");
                            sg.bigo.ads.common.utils.g.a(randomAccessFile2);
                            sg.bigo.ads.common.utils.g.a((Closeable) bufferedInputStream);
                            sg.bigo.ads.common.utils.g.a((Closeable) this.b);
                        }
                        randomAccessFile2.write(bArr, 0, i);
                        j += (long) i;
                        this.f13199a.b(j);
                        f.a().a(this.f13199a.f13197a);
                    }
                    if (!q.a((CharSequence) "")) {
                        str = "";
                    } else if (this.f13199a.b.g <= 0 || this.c.length() <= 0) {
                        str = "the download file has a invalid size.";
                    } else if (this.f13199a.e == h.d) {
                        str = "the download stream has not been read completely.";
                    }
                    b("Failed to download due to: ".concat(String.valueOf(str)));
                    sg.bigo.ads.common.utils.g.a(randomAccessFile2);
                    sg.bigo.ads.common.utils.g.a((Closeable) bufferedInputStream);
                    sg.bigo.ads.common.utils.g.a((Closeable) this.b);
                } catch (Exception e) {
                    e = e;
                    randomAccessFile = randomAccessFile2;
                    String message = e.getMessage();
                    if (!z) {
                        if (!q.a((CharSequence) message)) {
                            str = message;
                        } else if (this.f13199a.b.g <= 0 || this.c.length() <= 0) {
                            str = "the download file has a invalid size.";
                        } else if (this.f13199a.e == h.d) {
                            str = "the download stream has not been read completely.";
                        }
                        b("Failed to download due to: ".concat(String.valueOf(str)));
                    }
                    sg.bigo.ads.common.utils.g.a(randomAccessFile);
                    sg.bigo.ads.common.utils.g.a((Closeable) bufferedInputStream);
                    sg.bigo.ads.common.utils.g.a((Closeable) this.b);
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (!z) {
                        if (!q.a((CharSequence) "")) {
                            str = "";
                        } else if (this.f13199a.b.g <= 0 || this.c.length() <= 0) {
                            str = "the download file has a invalid size.";
                        } else if (this.f13199a.e == h.d) {
                            str = "the download stream has not been read completely.";
                        }
                        b("Failed to download due to: ".concat(String.valueOf(str)));
                    }
                    sg.bigo.ads.common.utils.g.a(randomAccessFile);
                    sg.bigo.ads.common.utils.g.a((Closeable) bufferedInputStream);
                    sg.bigo.ads.common.utils.g.a((Closeable) this.b);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private void a(String str) {
        sg.bigo.ads.common.t.a.a(0, 3, IDownloadTask.TAG, str + ",taskId=" + this.f13199a.f13197a + ", downloadinfo = " + this.f13199a.toString());
    }

    private void b(String str) {
        sg.bigo.ads.common.t.a.a(0, IDownloadTask.TAG, str + " , " + this.f13199a.f13197a + " has a error ! " + this.f13199a.toString());
        this.f13199a.f = str;
        this.f13199a.e = h.g;
        f.a().a(this.f13199a.f13197a);
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        while (true) {
            sg.bigo.ads.common.u.b.a aVar = new sg.bigo.ads.common.u.b.a(sg.bigo.ads.common.y.a.a(), new sg.bigo.ads.common.u.b.d(this.f13199a.b.b), this.f13199a.b.q, this.d);
            aVar.k = sg.bigo.ads.common.u.a.e.h();
            String str = "bytes=" + this.f13199a.b.g + "-";
            aVar.a("Range", str);
            a("Range = ".concat(String.valueOf(str)));
            sg.bigo.ads.common.u.c<sg.bigo.ads.common.u.c.a> cVarA = sg.bigo.ads.common.u.g.a(aVar);
            if (cVarA.f13274a != 0) {
                sg.bigo.ads.common.u.c.b bVarA = sg.bigo.ads.common.u.c.b.a(((sg.bigo.ads.common.u.c.a) cVarA.f13274a).a(HttpHeaders.CONTENT_RANGE));
                long jA = bVarA != null ? bVarA.b : 0L;
                if (jA <= 0) {
                    jA = ((sg.bigo.ads.common.u.c.a) cVarA.f13274a).a();
                }
                this.f13199a.a(jA);
                this.b = ((sg.bigo.ads.common.u.c.a) cVarA.f13274a).b;
                this.f13199a.b.p = ((sg.bigo.ads.common.u.c.a) cVarA.f13274a).a("Content-Type");
                if (!this.c.exists()) {
                    break;
                }
                long j = this.f13199a.b.g;
                long j2 = bVarA != null ? bVarA.f13276a : 0L;
                if (j <= 0 || j != j2) {
                    a("Delete tmp file.");
                    if (!sg.bigo.ads.common.utils.f.a(this.c)) {
                        b("Failed to delete temp file.");
                        return;
                    }
                    this.f13199a.b(0L);
                    if (j2 <= 0) {
                        break;
                    }
                    sg.bigo.ads.common.utils.g.a((Closeable) this.b);
                    this.b = null;
                } else {
                    this.f13199a.b.o = true;
                }
                this.f13199a.e = h.c;
                f.a().a(this.f13199a.f13197a);
                a();
            }
            b(cVarA.b != null ? "Failed to request url. Error code: " + cVarA.b.f13280a + ", error msg: " + cVarA.b.getMessage() : "Failed to request url.");
            return;
        }
        if (!sg.bigo.ads.common.utils.f.c(this.c)) {
            b("Failed to create temp file.");
            return;
        }
        this.f13199a.e = h.c;
        f.a().a(this.f13199a.f13197a);
        a();
    }
}
