package sg.bigo.ads.common.p;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a {
    protected sg.bigo.ads.common.h.a.a b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map<String, C0872a> f13235a = new ConcurrentHashMap();
    private final List<C0872a> e = new CopyOnWriteArrayList();
    private long f = -1;
    final Handler c = new Handler(Looper.getMainLooper());
    final byte[] d = new byte[0];

    /* JADX INFO: renamed from: sg.bigo.ads.common.p.a$a, reason: collision with other inner class name */
    class C0872a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f13243a;
        final String b;
        volatile boolean c;
        private final boolean e;
        private final List<g> f;

        private C0872a(String str, String str2, boolean z, g gVar) {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            this.c = false;
            this.f13243a = str;
            this.b = str2;
            this.e = z;
            arrayList.add(gVar);
        }

        /* synthetic */ C0872a(a aVar, String str, String str2, boolean z, g gVar, byte b) {
            this(str, str2, z, gVar);
        }

        static /* synthetic */ void a(C0872a c0872a, Context context, int i, String str, String str2) {
            synchronized (a.this.d) {
                sg.bigo.ads.common.t.a.a(0, 5, a.this.a(), "Failed to download image: " + c0872a.f13243a);
                Iterator<g> it = c0872a.f.iterator();
                while (it.hasNext()) {
                    it.next().a(i, str, str2);
                }
                a.this.f13235a.remove(c0872a.f13243a);
                a.this.c(context);
            }
        }

        static /* synthetic */ void a(C0872a c0872a, Context context, final Bitmap bitmap, final String str, final long j, final String str2) {
            synchronized (a.this.d) {
                sg.bigo.ads.common.t.a.a(0, 4, a.this.a(), "Succeed to download image: " + c0872a.f13243a);
                for (final g gVar : c0872a.f) {
                    a.this.c.post(new Runnable() { // from class: sg.bigo.ads.common.p.a.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            gVar.a(bitmap, new f(1, str, j, str2, C0872a.this.f13243a));
                        }
                    });
                }
                a.this.f13235a.remove(c0872a.f13243a);
                a.this.c(context);
            }
        }

        final void a(Executor executor, final Context context) {
            if (this.c) {
                return;
            }
            this.c = true;
            sg.bigo.ads.common.u.b.a aVar = new sg.bigo.ads.common.u.b.a(sg.bigo.ads.common.y.a.a(), new sg.bigo.ads.common.u.b.d(this.f13243a), this.e, context);
            if (executor == null) {
                executor = sg.bigo.ads.common.u.a.e.h();
            }
            aVar.k = executor;
            sg.bigo.ads.common.u.g.a(aVar, new sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.a, sg.bigo.ads.common.u.c.a>() { // from class: sg.bigo.ads.common.p.a.a.2
                @Override // sg.bigo.ads.common.u.b
                public final /* bridge */ /* synthetic */ sg.bigo.ads.common.u.c.c a(sg.bigo.ads.common.u.c.a aVar2) {
                    return aVar2;
                }

                @Override // sg.bigo.ads.common.u.b
                public final /* synthetic */ void a(sg.bigo.ads.common.u.b.c cVar, sg.bigo.ads.common.u.c.c cVar2) {
                    sg.bigo.ads.common.u.c.a aVar2 = (sg.bigo.ads.common.u.c.a) cVar2;
                    C0872a.this.c = false;
                    String strA = aVar2.a("Content-Type");
                    sg.bigo.ads.common.t.a.a(0, 4, a.this.a(), "Content-Type:".concat(String.valueOf(strA)));
                    if (Build.VERSION.SDK_INT == 28 && "image/webp".equalsIgnoreCase(strA)) {
                        C0872a.a(C0872a.this, context, IronSourceConstants.RV_AD_UNIT_CAPPED, "Not support parsing webp images in Android P.", strA);
                        return;
                    }
                    String strA2 = a.a(C0872a.this.f13243a, C0872a.this.b);
                    a aVar3 = a.this;
                    Context context2 = context;
                    InputStream inputStream = aVar2.b;
                    sg.bigo.ads.common.c cVarA = inputStream == null ? null : aVar3.a(aVar3.a(inputStream, strA2, context2).getPath(), context2);
                    if (cVarA == null) {
                        C0872a.a(C0872a.this, context, 1304, "Failed to parse image.", strA);
                        return;
                    }
                    sg.bigo.ads.common.t.a.a(0, 4, a.this.a(), "mimeType:" + cVarA.b);
                    if (q.a((CharSequence) cVarA.b)) {
                        cVarA.b = strA;
                    }
                    a.this.a(context, strA2, cVarA);
                    C0872a.a(C0872a.this, context, cVarA.f13132a, cVarA.b, sg.bigo.ads.common.utils.f.a(a.this.c(context, strA2), 2), cVarA.c);
                    a.this.d(context);
                }

                @Override // sg.bigo.ads.common.u.b
                public final /* synthetic */ void a(sg.bigo.ads.common.u.b.c cVar, sg.bigo.ads.common.u.h hVar) {
                    C0872a.this.c = false;
                    C0872a.a(C0872a.this, context, hVar.f13280a, hVar.getMessage(), "");
                }
            });
        }

        final void a(g gVar) {
            synchronized (a.this.d) {
                this.f.add(gVar);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f13243a.equals(((C0872a) obj).f13243a);
        }
    }

    static String a(String str, String str2) {
        return !TextUtils.isEmpty(str2) ? str2 : String.valueOf(str.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Executor executor, String str, String str2, boolean z, g gVar) {
        String str3;
        String str4;
        int i;
        if (!URLUtil.isNetworkUrl(str)) {
            str3 = "Unknown scheme.";
            str4 = "";
            i = 1301;
        } else {
            if (!this.b.b()) {
                sg.bigo.ads.common.t.a.a(0, 3, a(), "Obtain the bitmap through network.");
                synchronized (this.d) {
                    if (this.f13235a.containsKey(str)) {
                        sg.bigo.ads.common.t.a.a(0, 3, a(), "The target url is already in the requesting list: ".concat(String.valueOf(str)));
                        C0872a c0872a = this.f13235a.get(str);
                        if (c0872a != null) {
                            c0872a.a(gVar);
                        }
                    } else {
                        C0872a c0872a2 = new C0872a(this, str, str2, z, gVar, (byte) 0);
                        int iIndexOf = this.e.indexOf(c0872a2);
                        if (iIndexOf >= 0) {
                            sg.bigo.ads.common.t.a.a(0, 3, a(), "The target url is already in the waiting list: ".concat(String.valueOf(str)));
                            C0872a c0872a3 = this.e.get(iIndexOf);
                            c0872a3.a(gVar);
                            if (executor != null) {
                                this.e.remove(c0872a3);
                                a(context, executor, c0872a3);
                            }
                        } else if (executor != null) {
                            a(context, executor, c0872a2);
                        } else {
                            this.e.add(c0872a2);
                            c(context);
                        }
                    }
                }
                return;
            }
            str3 = "Unable to download image.";
            str4 = "";
            i = IronSourceConstants.RV_AUCTION_SUCCESS;
        }
        gVar.a(i, str3, str4);
    }

    private synchronized void a(final Context context, final Executor executor, final C0872a c0872a) {
        if (executor == null || c0872a == null) {
            return;
        }
        this.f13235a.put(c0872a.f13243a, c0872a);
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.common.p.a.3
            @Override // java.lang.Runnable
            public final void run() {
                c0872a.a(executor, context);
            }
        });
    }

    static /* synthetic */ void a(a aVar, Context context) {
        File[] fileArrListFiles;
        if (sg.bigo.ads.common.n.d.b()) {
            return;
        }
        sg.bigo.ads.common.t.a.a(0, 3, aVar.a(), "Start check and delete expired images.");
        File file = new File(aVar.b(context));
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: sg.bigo.ads.common.p.a.6
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file2, File file3) {
                long jLastModified = file2.lastModified() - file3.lastModified();
                if (jLastModified > 0) {
                    return -1;
                }
                return jLastModified == 0 ? 0 : 1;
            }
        });
        long jCurrentTimeMillis = System.currentTimeMillis() - aVar.b.d;
        for (int i = 0; i < fileArrListFiles.length; i++) {
            File file2 = fileArrListFiles[i];
            if (i >= aVar.b() || file2.lastModified() <= jCurrentTimeMillis) {
                file2.delete();
            }
        }
    }

    final File a(InputStream inputStream, String str, Context context) throws Throwable {
        FileOutputStream fileOutputStream;
        Throwable th;
        String strB = b(context);
        sg.bigo.ads.common.utils.f.a(strB, str);
        File file = new File(strB, str);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
                fileOutputStream.flush();
                sg.bigo.ads.common.utils.g.a((Closeable) inputStream);
                sg.bigo.ads.common.utils.g.a(fileOutputStream);
            } catch (IOException unused) {
                fileOutputStream2 = fileOutputStream;
                sg.bigo.ads.common.utils.g.a((Closeable) inputStream);
                sg.bigo.ads.common.utils.g.a(fileOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                sg.bigo.ads.common.utils.g.a((Closeable) inputStream);
                sg.bigo.ads.common.utils.g.a(fileOutputStream);
                throw th;
            }
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
        }
        return file;
    }

    protected abstract String a();

    protected abstract sg.bigo.ads.common.c a(Context context, String str);

    final sg.bigo.ads.common.c a(String str, Context context) {
        return this instanceof d ? sg.bigo.ads.common.utils.d.b(str) : sg.bigo.ads.common.utils.d.b(str, context);
    }

    protected abstract void a(Context context);

    protected abstract void a(Context context, String str, sg.bigo.ads.common.c cVar);

    public final void a(final Context context, final Executor executor, final String str, final boolean z, final g gVar) {
        String strA = a(str, (String) null);
        final sg.bigo.ads.common.c cVarA = a(context, strA);
        if (cVarA != null) {
            if (!cVarA.f13132a.isRecycled()) {
                sg.bigo.ads.common.t.a.a(0, 3, a(), "Get bitmap from cache, mimeType=" + cVarA.b);
                this.c.post(new Runnable() { // from class: sg.bigo.ads.common.p.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        gVar.a(cVarA.f13132a, new f(2, cVarA.b, 0L, cVarA.c, str));
                    }
                });
                return;
            }
            b(context, strA);
        }
        if (!sg.bigo.ads.common.utils.f.b(c(context, strA))) {
            a(context, executor, str, null, z, gVar);
            return;
        }
        final String strA2 = a(str, (String) null);
        final String strC = c(context, strA2);
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.common.p.a.2
            final /* synthetic */ String g = null;

            @Override // java.lang.Runnable
            public final void run() {
                final sg.bigo.ads.common.c cVarA2 = a.this.a(strC, context);
                if (cVarA2 == null) {
                    a.this.a(context, executor, str, this.g, z, gVar);
                    return;
                }
                a.this.a(context, strA2, cVarA2);
                final long jA = sg.bigo.ads.common.utils.f.a(strC, 2);
                sg.bigo.ads.common.t.a.a(0, 3, a.this.a(), "Obtain the bitmap from local file, mimeType=" + cVarA2.b);
                a.this.c.post(new Runnable() { // from class: sg.bigo.ads.common.p.a.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        gVar.a(cVarA2.f13132a, new f(0, cVarA2.b, jA, cVarA2.c, str));
                    }
                });
                new File(strC).setLastModified(System.currentTimeMillis());
                a.this.d(context);
            }
        });
    }

    public final void a(sg.bigo.ads.common.h.a.a aVar) {
        this.b = aVar;
    }

    public final boolean a(String str) {
        boolean zContainsKey;
        synchronized (this.d) {
            zContainsKey = this.f13235a.containsKey(str);
            if (!zContainsKey) {
                Iterator<C0872a> it = this.e.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().f13243a, str)) {
                        zContainsKey = true;
                        break;
                    }
                }
            }
        }
        return zContainsKey;
    }

    protected abstract int b();

    protected abstract String b(Context context);

    protected abstract void b(Context context, String str);

    protected abstract String c(Context context, String str);

    final synchronized void c(final Context context) {
        if (this.e.isEmpty()) {
            return;
        }
        sg.bigo.ads.common.t.a.a(0, 3, a(), "scheduleDownload");
        while (this.f13235a.size() < this.b.f13191a) {
            if (this.e.isEmpty()) {
                return;
            }
            final C0872a c0872aRemove = this.e.remove(0);
            this.f13235a.put(c0872aRemove.f13243a, c0872aRemove);
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.common.p.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    c0872aRemove.a(null, context);
                }
            });
        }
        sg.bigo.ads.common.t.a.a(0, 3, a(), "Current size of waiting list: " + this.e.size());
    }

    public final synchronized void d(final Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f > 3600000) {
            this.f = jCurrentTimeMillis;
            sg.bigo.ads.common.n.d.a(0, new Runnable() { // from class: sg.bigo.ads.common.p.a.5
                @Override // java.lang.Runnable
                public final void run() {
                    a.a(a.this, context);
                }
            });
        }
    }

    public final boolean d(Context context, String str) {
        String strA = a(str, (String) null);
        return a(context, strA) != null || sg.bigo.ads.common.utils.f.b(c(context, strA));
    }

    public final void e(Context context) {
        synchronized (this.d) {
            this.e.clear();
            this.f13235a.clear();
            a(context);
        }
    }
}
