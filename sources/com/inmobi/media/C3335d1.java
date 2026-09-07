package com.inmobi.media;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.webkit.URLUtil;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.safedk.android.internal.partials.InMobiFilesBridge;
import com.safedk.android.internal.partials.InMobiNetworkBridge;
import com.squareup.picasso.Callback;
import com.squareup.picasso.RequestCreator;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.inmobi.media.d1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3335d1 implements InterfaceC3564t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3335d1 f3289a;
    public static final Object b;
    public static AdConfig.AssetCacheConfig c;
    public static AdConfig.VastVideoConfig d;
    public static final ExecutorService e;
    public static final ThreadPoolExecutor f;
    public static Z0 g;
    public static HandlerThread h;
    public static final AtomicBoolean i;
    public static final AtomicBoolean j;
    public static final ConcurrentHashMap k;
    public static final ArrayList l;
    public static final AtomicBoolean m;
    public static final C3307b1 n;
    public static final C3321c1 o;

    @Override // com.inmobi.media.InterfaceC3564t2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (!(config instanceof AdConfig)) {
            c = null;
            d = null;
        } else {
            AdConfig adConfig = (AdConfig) config;
            c = adConfig.getAssetCache();
            d = adConfig.getVastVideo();
        }
    }

    public final void b(C3417j c3417j) {
        String locationOnDisk = c3417j.c;
        AdConfig.AssetCacheConfig assetCacheConfig = c;
        if (locationOnDisk == null || locationOnDisk.length() == 0 || assetCacheConfig == null) {
            return;
        }
        File file = new File(locationOnDisk);
        long jMin = Math.min((c3417j.g - c3417j.e) + System.currentTimeMillis(), (assetCacheConfig.getTimeToLive() * ((long) 1000)) + System.currentTimeMillis());
        int iNextInt = new Random().nextInt() & Integer.MAX_VALUE;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        String url = c3417j.b;
        int maxRetries = assetCacheConfig.getMaxRetries();
        long j2 = c3417j.h;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(locationOnDisk, "locationOnDisk");
        if (url == null) {
            url = "";
        }
        C3417j c3417j2 = new C3417j(iNextInt, url, locationOnDisk, maxRetries, jCurrentTimeMillis, jCurrentTimeMillis2, jMin, j2);
        c3417j2.e = System.currentTimeMillis();
        AbstractC3415ib.a().a(c3417j2);
        long j3 = c3417j.e;
        c3417j2.j = AbstractC3445l.a(c3417j, file, j3, j3);
        c3417j2.i = true;
        a(c3417j2, (byte) -1);
    }

    public final synchronized void c(String str) {
        int size = l.size();
        for (int i2 = 0; i2 < size; i2++) {
            C3431k c3431k = (C3431k) l.get(i2);
            Iterator it = c3431k.h.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((C3372fa) it.next()).b, str)) {
                    c3431k.b++;
                    break;
                }
            }
        }
    }

    public final synchronized void d(String str) {
        int size = l.size();
        for (int i2 = 0; i2 < size; i2++) {
            C3431k c3431k = (C3431k) l.get(i2);
            Set set = c3431k.h;
            HashSet hashSet = c3431k.e;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((C3372fa) it.next()).b, str)) {
                    if (!hashSet.contains(str)) {
                        c3431k.e.add(str);
                        c3431k.f3351a++;
                        break;
                    }
                    break;
                }
            }
        }
    }

    public final synchronized void e() {
        ArrayList arrayList = new ArrayList();
        int size = l.size();
        for (int i2 = 0; i2 < size; i2++) {
            C3431k c3431k = (C3431k) l.get(i2);
            if (c3431k.f3351a == c3431k.h.size()) {
                try {
                    InterfaceC3349e1 interfaceC3349e1 = (InterfaceC3349e1) c3431k.d.get();
                    if (interfaceC3349e1 != null) {
                        interfaceC3349e1.a(c3431k);
                    }
                    arrayList.add(c3431k);
                } catch (Exception e2) {
                    Intrinsics.checkNotNullExpressionValue("d1", "TAG");
                    C3339d5 c3339d5 = C3339d5.f3292a;
                    C3339d5.c.a(I4.a(e2, "event"));
                }
            }
        }
        b(arrayList);
    }

    static {
        C3335d1 c3335d1 = new C3335d1();
        f3289a = c3335d1;
        b = new Object();
        i = new AtomicBoolean(false);
        j = new AtomicBoolean(false);
        l = new ArrayList();
        m = new AtomicBoolean(true);
        n = C3307b1.f3271a;
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        Config configA = C3549s2.a("ads", C3517pb.b(), c3335d1);
        Intrinsics.checkNotNull(configA, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
        AdConfig adConfig = (AdConfig) configA;
        c = adConfig.getAssetCache();
        d = adConfig.getVastVideo();
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool(new V4("d1".concat("-AP")));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewCachedThreadPool, "newCachedThreadPool(...)");
        e = executorServiceNewCachedThreadPool;
        int i2 = S3.f3188a;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 5L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new V4("d1".concat("-AD")));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f = threadPoolExecutor;
        HandlerThread handlerThread = new HandlerThread("assetFetcher");
        h = handlerThread;
        U3.a(handlerThread, "assetFetcher");
        HandlerThread handlerThread2 = h;
        Intrinsics.checkNotNull(handlerThread2);
        Looper looper = handlerThread2.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
        g = new Z0(looper, c3335d1);
        k = new ConcurrentHashMap(2, 0.9f, 2);
        o = new C3321c1();
    }

    public final synchronized void a(C3417j c3417j) {
        int size = l.size();
        for (int i2 = 0; i2 < size; i2++) {
            C3431k c3431k = (C3431k) l.get(i2);
            Iterator it = c3431k.h.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((C3372fa) it.next()).b, c3417j.b)) {
                    if (!c3431k.g.contains(c3417j)) {
                        c3431k.g.add(c3417j);
                        break;
                    }
                    break;
                }
            }
        }
    }

    public final void c() {
        if (m.get()) {
            j.set(false);
            boolean z = W8.f3228a;
            if (W8.a(false) != null) {
                P6 p6F = C3517pb.f();
                C3307b1 c3307b1 = n;
                p6F.a(c3307b1);
                C3517pb.f().a(new int[]{10, 2, 1}, c3307b1);
                return;
            }
            synchronized (b) {
                if (i.compareAndSet(false, true)) {
                    if (h == null) {
                        HandlerThread handlerThread = new HandlerThread("assetFetcher");
                        h = handlerThread;
                        U3.a(handlerThread, "assetFetcher");
                    }
                    if (g == null) {
                        HandlerThread handlerThread2 = h;
                        Intrinsics.checkNotNull(handlerThread2);
                        Looper looper = handlerThread2.getLooper();
                        Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
                        g = new Z0(looper, this);
                    }
                    if (AbstractC3415ib.a().b().isEmpty()) {
                        Intrinsics.checkNotNullExpressionValue("d1", "TAG");
                        d();
                    } else {
                        Intrinsics.checkNotNullExpressionValue("d1", "TAG");
                        P6 p6F2 = C3517pb.f();
                        C3307b1 c3307b2 = n;
                        p6F2.a(c3307b2);
                        C3517pb.f().a(new int[]{10, 2, 1}, c3307b2);
                        Z0 z0 = g;
                        Intrinsics.checkNotNull(z0);
                        z0.sendEmptyMessage(1);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public static void d() {
        if (m.get()) {
            synchronized (b) {
                i.set(false);
                k.clear();
                HandlerThread handlerThread = h;
                if (handlerThread != null) {
                    handlerThread.getLooper().quit();
                    handlerThread.interrupt();
                    h = null;
                    g = null;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:128:0x0158 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x0126 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x00c2 A[Catch: all -> 0x01c4, Exception -> 0x01c9, IOException -> 0x01db, ProtocolException -> 0x01eb, MalformedURLException -> 0x01fb, FileNotFoundException -> 0x020b, SocketTimeoutException -> 0x021b, TryCatch #6 {FileNotFoundException -> 0x020b, MalformedURLException -> 0x01fb, ProtocolException -> 0x01eb, SocketTimeoutException -> 0x021b, IOException -> 0x01db, Exception -> 0x01c9, all -> 0x01c4, blocks: (B:15:0x005f, B:17:0x008e, B:19:0x009e, B:21:0x00a5, B:23:0x00ab, B:24:0x00ae, B:25:0x00b2, B:27:0x00b6, B:28:0x00c2, B:30:0x00ce, B:32:0x00d5, B:34:0x00e3, B:36:0x00f4, B:38:0x00fa, B:39:0x00fd), top: B:117:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00ce A[Catch: all -> 0x01c4, Exception -> 0x01c9, IOException -> 0x01db, ProtocolException -> 0x01eb, MalformedURLException -> 0x01fb, FileNotFoundException -> 0x020b, SocketTimeoutException -> 0x021b, TryCatch #6 {FileNotFoundException -> 0x020b, MalformedURLException -> 0x01fb, ProtocolException -> 0x01eb, SocketTimeoutException -> 0x021b, IOException -> 0x01db, Exception -> 0x01c9, all -> 0x01c4, blocks: (B:15:0x005f, B:17:0x008e, B:19:0x009e, B:21:0x00a5, B:23:0x00ab, B:24:0x00ae, B:25:0x00b2, B:27:0x00b6, B:28:0x00c2, B:30:0x00ce, B:32:0x00d5, B:34:0x00e3, B:36:0x00f4, B:38:0x00fa, B:39:0x00fd), top: B:117:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00d5 A[Catch: all -> 0x01c4, Exception -> 0x01c9, IOException -> 0x01db, ProtocolException -> 0x01eb, MalformedURLException -> 0x01fb, FileNotFoundException -> 0x020b, SocketTimeoutException -> 0x021b, TRY_LEAVE, TryCatch #6 {FileNotFoundException -> 0x020b, MalformedURLException -> 0x01fb, ProtocolException -> 0x01eb, SocketTimeoutException -> 0x021b, IOException -> 0x01db, Exception -> 0x01c9, all -> 0x01c4, blocks: (B:15:0x005f, B:17:0x008e, B:19:0x009e, B:21:0x00a5, B:23:0x00ab, B:24:0x00ae, B:25:0x00b2, B:27:0x00b6, B:28:0x00c2, B:30:0x00ce, B:32:0x00d5, B:34:0x00e3, B:36:0x00f4, B:38:0x00fa, B:39:0x00fd), top: B:117:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:45:0x011d A[Catch: Exception -> 0x0138, IOException -> 0x013c, ProtocolException -> 0x0140, MalformedURLException -> 0x0144, FileNotFoundException -> 0x0148, SocketTimeoutException -> 0x014c, all -> 0x0194, TryCatch #8 {FileNotFoundException -> 0x0148, MalformedURLException -> 0x0144, ProtocolException -> 0x0140, SocketTimeoutException -> 0x014c, IOException -> 0x013c, Exception -> 0x0138, all -> 0x0194, blocks: (B:42:0x010c, B:43:0x0115, B:45:0x011d, B:47:0x0126, B:54:0x0150, B:55:0x0158), top: B:121:0x010c }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0150 A[Catch: Exception -> 0x0138, IOException -> 0x013c, ProtocolException -> 0x0140, MalformedURLException -> 0x0144, FileNotFoundException -> 0x0148, SocketTimeoutException -> 0x014c, all -> 0x0194, LOOP:1: B:43:0x0115->B:54:0x0150, LOOP_END, TryCatch #8 {FileNotFoundException -> 0x0148, MalformedURLException -> 0x0144, ProtocolException -> 0x0140, SocketTimeoutException -> 0x014c, IOException -> 0x013c, Exception -> 0x0138, all -> 0x0194, blocks: (B:42:0x010c, B:43:0x0115, B:45:0x011d, B:47:0x0126, B:54:0x0150, B:55:0x0158), top: B:121:0x010c }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v59 */
    public static boolean a(C3417j asset, X0 x0) throws Throwable {
        ?? r1;
        InputStream inputStreamUrlConnectionGetInputStream;
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        InputStream inputStream4;
        InputStream inputStream5;
        InputStream inputStream6;
        ?? r2;
        InputStream inputStream7;
        byte b2;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        BufferedOutputStream bufferedOutputStream3;
        BufferedOutputStream bufferedOutputStream4;
        BufferedOutputStream bufferedOutputStream5;
        BufferedOutputStream bufferedOutputStream6;
        ?? r3;
        long contentLength;
        File fileA;
        BufferedOutputStream bufferedOutputStream7;
        BufferedOutputStream bufferedOutputStream8;
        byte[] bArr;
        Ref.IntRef intRef;
        long j2;
        int i2;
        long j3;
        C3417j c3417j = (C3417j) k.putIfAbsent(asset.b, asset);
        AdConfig.VastVideoConfig vastVideoConfig = d;
        if (c3417j != null || vastVideoConfig == null) {
            return false;
        }
        C3461m c3461m = new C3461m(x0);
        long vastMaxAssetSize = vastVideoConfig.getVastMaxAssetSize();
        ?? allowedContentType = vastVideoConfig.getAllowedContentType();
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(allowedContentType, "allowedContentType");
        Intrinsics.checkNotNullExpressionValue("m", "TAG");
        if (W8.a(false) != null) {
            asset.l = (byte) 5;
            x0.a(asset);
        } else if (!Intrinsics.areEqual(asset.b, "") && URLUtil.isValidUrl(asset.b)) {
            String[] strArr = (String[]) allowedContentType.toArray(new String[0]);
            try {
                try {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    URLConnection uRLConnectionOpenConnection = new URL(asset.b).openConnection();
                    Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(60000);
                    httpURLConnection.setReadTimeout(60000);
                    int iHttpUrlConnectionGetResponseCode = InMobiNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
                    Intrinsics.checkNotNullExpressionValue("m", "TAG");
                    if (iHttpUrlConnectionGetResponseCode < 400) {
                        String contentType = httpURLConnection.getContentType();
                        Intrinsics.checkNotNullExpressionValue("m", "TAG");
                        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                        for (String str : strArr) {
                            Intrinsics.checkNotNullExpressionValue("m", "TAG");
                            if (contentType != null && StringsKt.equals(str, contentType, true)) {
                                booleanRef.element = true;
                                break;
                            }
                        }
                        if (!booleanRef.element) {
                            asset.l = (byte) 3;
                            asset.d = 0;
                            c3461m.f3371a.a(asset);
                        } else {
                            contentLength = httpURLConnection.getContentLength();
                            if (contentLength >= 0) {
                                Intrinsics.checkNotNullExpressionValue("m", "TAG");
                                if (contentLength > vastMaxAssetSize) {
                                    asset.l = (byte) 4;
                                    asset.d = 0;
                                    c3461m.f3371a.a(asset);
                                }
                            }
                            httpURLConnection.connect();
                            fileA = C3517pb.f3400a.a(asset.b);
                            if (fileA.exists() && fileA.delete()) {
                                Intrinsics.checkNotNullExpressionValue("m", "TAG");
                            }
                            inputStreamUrlConnectionGetInputStream = InMobiNetworkBridge.urlConnectionGetInputStream(httpURLConnection);
                            try {
                                bufferedOutputStream7 = new BufferedOutputStream(InMobiFilesBridge.fileOutputStreamCtor(fileA));
                                try {
                                    bArr = new byte[1024];
                                    intRef = new Ref.IntRef();
                                    j2 = 0;
                                    while (true) {
                                        i2 = inputStreamUrlConnectionGetInputStream.read(bArr);
                                        intRef.element = i2;
                                        if (i2 <= 0) {
                                            j3 = jElapsedRealtime;
                                            j2 += (long) i2;
                                            if (j2 > vastMaxAssetSize) {
                                                asset.l = (byte) 4;
                                                asset.d = 0;
                                                C3461m.a(fileA, httpURLConnection, bufferedOutputStream7);
                                                c3461m.f3371a.a(asset);
                                                bufferedOutputStream8 = bufferedOutputStream7;
                                                inputStream7 = inputStreamUrlConnectionGetInputStream;
                                                break;
                                            }
                                            bufferedOutputStream7.write(bArr, 0, i2);
                                            jElapsedRealtime = j3;
                                        } else {
                                            long j4 = jElapsedRealtime;
                                            bufferedOutputStream7.flush();
                                            InMobiNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                                            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                            T8 t8 = new T8();
                                            t8.e = httpURLConnection.getHeaderFields();
                                            bufferedOutputStream8 = bufferedOutputStream7;
                                            inputStream7 = inputStreamUrlConnectionGetInputStream;
                                            try {
                                                asset.j = AbstractC3445l.a(asset, fileA, j4, jElapsedRealtime2);
                                                asset.k = jElapsedRealtime2 - j4;
                                                X0 x1 = c3461m.f3371a;
                                                String absolutePath = fileA.getAbsolutePath();
                                                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                                                x1.a(t8, absolutePath, asset);
                                                break;
                                            } catch (FileNotFoundException unused) {
                                                bufferedOutputStream6 = bufferedOutputStream8;
                                                Intrinsics.checkNotNullExpressionValue("m", "TAG");
                                                asset.a((byte) 2);
                                                c3461m.f3371a.a(asset);
                                                allowedContentType = bufferedOutputStream6;
                                                r3 = allowedContentType;
                                            } catch (MalformedURLException unused2) {
                                                bufferedOutputStream5 = bufferedOutputStream8;
                                                Intrinsics.checkNotNullExpressionValue("m", "TAG");
                                                asset.a((byte) 1);
                                                c3461m.f3371a.a(asset);
                                                allowedContentType = bufferedOutputStream5;
                                                r3 = allowedContentType;
                                            } catch (ProtocolException unused3) {
                                                bufferedOutputStream4 = bufferedOutputStream8;
                                                Intrinsics.checkNotNullExpressionValue("m", "TAG");
                                                asset.a((byte) 5);
                                                c3461m.f3371a.a(asset);
                                                allowedContentType = bufferedOutputStream4;
                                                r3 = allowedContentType;
                                            } catch (SocketTimeoutException unused4) {
                                                bufferedOutputStream3 = bufferedOutputStream8;
                                                Intrinsics.checkNotNullExpressionValue("m", "TAG");
                                                asset.a((byte) 2);
                                                c3461m.f3371a.a(asset);
                                                allowedContentType = bufferedOutputStream3;
                                                r3 = allowedContentType;
                                            } catch (IOException unused5) {
                                                bufferedOutputStream2 = bufferedOutputStream8;
                                                Intrinsics.checkNotNullExpressionValue("m", "TAG");
                                                asset.a((byte) 5);
                                                c3461m.f3371a.a(asset);
                                                allowedContentType = bufferedOutputStream2;
                                                r3 = allowedContentType;
                                            } catch (Exception unused6) {
                                                bufferedOutputStream = bufferedOutputStream8;
                                                b2 = 0;
                                                asset.a(b2);
                                                c3461m.f3371a.a(asset);
                                                allowedContentType = bufferedOutputStream;
                                                r3 = allowedContentType;
                                            } catch (Throwable th) {
                                                th = th;
                                                r2 = bufferedOutputStream8;
                                                inputStreamUrlConnectionGetInputStream = inputStream7;
                                                r1 = r2;
                                                W8.a((Closeable) inputStreamUrlConnectionGetInputStream);
                                                W8.a((Closeable) r1);
                                                throw th;
                                            }
                                        }
                                    }
                                    r3 = bufferedOutputStream8;
                                } catch (FileNotFoundException unused7) {
                                    bufferedOutputStream8 = bufferedOutputStream7;
                                    inputStream7 = inputStreamUrlConnectionGetInputStream;
                                } catch (MalformedURLException unused8) {
                                    bufferedOutputStream8 = bufferedOutputStream7;
                                    inputStream7 = inputStreamUrlConnectionGetInputStream;
                                } catch (ProtocolException unused9) {
                                    bufferedOutputStream8 = bufferedOutputStream7;
                                    inputStream7 = inputStreamUrlConnectionGetInputStream;
                                } catch (SocketTimeoutException unused10) {
                                    bufferedOutputStream8 = bufferedOutputStream7;
                                    inputStream7 = inputStreamUrlConnectionGetInputStream;
                                } catch (IOException unused11) {
                                    bufferedOutputStream8 = bufferedOutputStream7;
                                    inputStream7 = inputStreamUrlConnectionGetInputStream;
                                } catch (Exception unused12) {
                                    bufferedOutputStream8 = bufferedOutputStream7;
                                    inputStream7 = inputStreamUrlConnectionGetInputStream;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedOutputStream8 = bufferedOutputStream7;
                                    inputStream7 = inputStreamUrlConnectionGetInputStream;
                                }
                            } catch (FileNotFoundException unused13) {
                                inputStream6 = inputStreamUrlConnectionGetInputStream;
                                inputStream7 = inputStream6;
                                bufferedOutputStream6 = null;
                                Intrinsics.checkNotNullExpressionValue("m", "TAG");
                                asset.a((byte) 2);
                                c3461m.f3371a.a(asset);
                                allowedContentType = bufferedOutputStream6;
                                r3 = allowedContentType;
                                W8.a((Closeable) inputStream7);
                                W8.a((Closeable) r3);
                                return true;
                            } catch (MalformedURLException unused14) {
                                inputStream5 = inputStreamUrlConnectionGetInputStream;
                                inputStream7 = inputStream5;
                                bufferedOutputStream5 = null;
                                Intrinsics.checkNotNullExpressionValue("m", "TAG");
                                asset.a((byte) 1);
                                c3461m.f3371a.a(asset);
                                allowedContentType = bufferedOutputStream5;
                                r3 = allowedContentType;
                                W8.a((Closeable) inputStream7);
                                W8.a((Closeable) r3);
                                return true;
                            } catch (ProtocolException unused15) {
                                inputStream4 = inputStreamUrlConnectionGetInputStream;
                                inputStream7 = inputStream4;
                                bufferedOutputStream4 = null;
                                Intrinsics.checkNotNullExpressionValue("m", "TAG");
                                asset.a((byte) 5);
                                c3461m.f3371a.a(asset);
                                allowedContentType = bufferedOutputStream4;
                                r3 = allowedContentType;
                                W8.a((Closeable) inputStream7);
                                W8.a((Closeable) r3);
                                return true;
                            } catch (SocketTimeoutException unused16) {
                                inputStream3 = inputStreamUrlConnectionGetInputStream;
                                inputStream7 = inputStream3;
                                bufferedOutputStream3 = null;
                                Intrinsics.checkNotNullExpressionValue("m", "TAG");
                                asset.a((byte) 2);
                                c3461m.f3371a.a(asset);
                                allowedContentType = bufferedOutputStream3;
                                r3 = allowedContentType;
                                W8.a((Closeable) inputStream7);
                                W8.a((Closeable) r3);
                                return true;
                            } catch (IOException unused17) {
                                inputStream2 = inputStreamUrlConnectionGetInputStream;
                                inputStream7 = inputStream2;
                                bufferedOutputStream2 = null;
                                Intrinsics.checkNotNullExpressionValue("m", "TAG");
                                asset.a((byte) 5);
                                c3461m.f3371a.a(asset);
                                allowedContentType = bufferedOutputStream2;
                                r3 = allowedContentType;
                                W8.a((Closeable) inputStream7);
                                W8.a((Closeable) r3);
                                return true;
                            } catch (Exception unused18) {
                                inputStream = inputStreamUrlConnectionGetInputStream;
                                inputStream7 = inputStream;
                                b2 = 0;
                                bufferedOutputStream = null;
                                asset.a(b2);
                                c3461m.f3371a.a(asset);
                                allowedContentType = bufferedOutputStream;
                                r3 = allowedContentType;
                                W8.a((Closeable) inputStream7);
                                W8.a((Closeable) r3);
                                return true;
                            } catch (Throwable th3) {
                                th = th3;
                                r1 = 0;
                                W8.a((Closeable) inputStreamUrlConnectionGetInputStream);
                                W8.a((Closeable) r1);
                                throw th;
                            }
                            W8.a((Closeable) inputStream7);
                            W8.a((Closeable) r3);
                            return true;
                        }
                    } else {
                        contentLength = httpURLConnection.getContentLength();
                        if (contentLength >= 0) {
                            Intrinsics.checkNotNullExpressionValue("m", "TAG");
                            if (contentLength > vastMaxAssetSize) {
                                asset.l = (byte) 4;
                                asset.d = 0;
                                c3461m.f3371a.a(asset);
                            }
                        }
                        httpURLConnection.connect();
                        fileA = C3517pb.f3400a.a(asset.b);
                        if (fileA.exists()) {
                            Intrinsics.checkNotNullExpressionValue("m", "TAG");
                        }
                        inputStreamUrlConnectionGetInputStream = InMobiNetworkBridge.urlConnectionGetInputStream(httpURLConnection);
                        bufferedOutputStream7 = new BufferedOutputStream(InMobiFilesBridge.fileOutputStreamCtor(fileA));
                        bArr = new byte[1024];
                        intRef = new Ref.IntRef();
                        j2 = 0;
                        while (true) {
                            i2 = inputStreamUrlConnectionGetInputStream.read(bArr);
                            intRef.element = i2;
                            if (i2 <= 0) {
                                long j5 = jElapsedRealtime;
                                bufferedOutputStream7.flush();
                                InMobiNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                                long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                                T8 t9 = new T8();
                                t9.e = httpURLConnection.getHeaderFields();
                                bufferedOutputStream8 = bufferedOutputStream7;
                                inputStream7 = inputStreamUrlConnectionGetInputStream;
                                asset.j = AbstractC3445l.a(asset, fileA, j5, jElapsedRealtime3);
                                asset.k = jElapsedRealtime3 - j5;
                                X0 x2 = c3461m.f3371a;
                                String absolutePath2 = fileA.getAbsolutePath();
                                Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
                                x2.a(t9, absolutePath2, asset);
                                break;
                            }
                            j3 = jElapsedRealtime;
                            j2 += (long) i2;
                            if (j2 > vastMaxAssetSize) {
                                asset.l = (byte) 4;
                                asset.d = 0;
                                C3461m.a(fileA, httpURLConnection, bufferedOutputStream7);
                                c3461m.f3371a.a(asset);
                                bufferedOutputStream8 = bufferedOutputStream7;
                                inputStream7 = inputStreamUrlConnectionGetInputStream;
                                break;
                            }
                            bufferedOutputStream7.write(bArr, 0, i2);
                            jElapsedRealtime = j3;
                        }
                        r3 = bufferedOutputStream8;
                        W8.a((Closeable) inputStream7);
                        W8.a((Closeable) r3);
                        return true;
                    }
                    boolean z = W8.f3228a;
                } catch (FileNotFoundException unused19) {
                    inputStream6 = null;
                } catch (MalformedURLException unused20) {
                    inputStream5 = null;
                } catch (ProtocolException unused21) {
                    inputStream4 = null;
                } catch (SocketTimeoutException unused22) {
                    inputStream3 = null;
                } catch (IOException unused23) {
                    inputStream2 = null;
                } catch (Exception unused24) {
                    inputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    r1 = 0;
                    inputStreamUrlConnectionGetInputStream = null;
                }
            } catch (Throwable th5) {
                th = th5;
                r2 = allowedContentType;
            }
        } else {
            asset.a((byte) 1);
            x0.a(asset);
            return true;
        }
        return true;
    }

    public final synchronized void b(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            l.remove(arrayList.get(i2));
        }
    }

    public static void b() {
        ArrayList arrayListA = AbstractC3415ib.a().a();
        long length = 0;
        if (!arrayListA.isEmpty()) {
            Iterator it = arrayListA.iterator();
            while (it.hasNext()) {
                String str = ((C3417j) it.next()).c;
                if (str != null) {
                    length += new File(str).length();
                }
            }
        }
        AdConfig.AssetCacheConfig assetCacheConfig = c;
        Unit unit = null;
        if (assetCacheConfig != null) {
            Intrinsics.checkNotNullExpressionValue("d1", "TAG");
            assetCacheConfig.getMaxCacheSize();
            Intrinsics.checkNotNullExpressionValue("d1", "TAG");
            if (length > assetCacheConfig.getMaxCacheSize()) {
                W0 w0A = AbstractC3415ib.a();
                w0A.getClass();
                ArrayList arrayListA2 = D1.a(w0A, null, null, null, null, "ts ASC ", 1, 15);
                C3417j asset = arrayListA2.isEmpty() ? null : (C3417j) arrayListA2.get(0);
                if (asset != null) {
                    if (m.get()) {
                        W0 w0A2 = AbstractC3415ib.a();
                        w0A2.getClass();
                        Intrinsics.checkNotNullParameter(asset, "asset");
                        w0A2.a("id = ?", new String[]{String.valueOf(asset.f3343a)});
                        String str2 = asset.c;
                        if (str2 != null) {
                            File file = new File(str2);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    }
                    b();
                }
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            Intrinsics.checkNotNullExpressionValue("d1", "TAG");
        }
    }

    public static final void b(C3431k assetBatch) {
        Intrinsics.checkNotNullParameter(assetBatch, "$assetBatch");
        synchronized (f3289a) {
            ArrayList arrayList = l;
            if (!arrayList.contains(assetBatch)) {
                arrayList.add(assetBatch);
            }
        }
        Intrinsics.checkNotNullExpressionValue("d1", "TAG");
        assetBatch.h.size();
        Iterator it = assetBatch.h.iterator();
        while (it.hasNext()) {
            String str = ((C3372fa) it.next()).b;
            C3335d1 c3335d1 = f3289a;
            Intrinsics.checkNotNullExpressionValue("d1", "TAG");
            C3417j c3417jA = AbstractC3415ib.a().a(str);
            if (c3417jA != null && c3417jA.a()) {
                Intrinsics.checkNotNullExpressionValue("d1", "TAG");
                c3335d1.b(c3417jA);
            } else {
                a(str);
            }
        }
    }

    public static final void b(C3431k assetBatch, String adType) {
        Intrinsics.checkNotNullParameter(assetBatch, "$assetBatch");
        Intrinsics.checkNotNullParameter(adType, "$adType");
        synchronized (f3289a) {
            ArrayList arrayList = l;
            if (!arrayList.contains(assetBatch)) {
                arrayList.add(assetBatch);
            }
        }
        Intrinsics.checkNotNullExpressionValue("d1", "TAG");
        assetBatch.h.size();
        ArrayList<String> arrayList2 = new ArrayList();
        ArrayList<String> arrayList3 = new ArrayList();
        for (C3372fa c3372fa : assetBatch.h) {
            String str = c3372fa.b;
            int length = str.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i2 : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i2++;
                } else {
                    z = true;
                }
            }
            if (str.subSequence(i2, length + 1).toString().length() > 0 && c3372fa.f3316a == 2) {
                arrayList2.add(c3372fa.b);
            } else {
                arrayList3.add(c3372fa.b);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(arrayList2.size());
        for (String str2 : arrayList2) {
            try {
                Intrinsics.checkNotNullExpressionValue("d1", "TAG");
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                Context contextD = C3517pb.d();
                if (contextD != null) {
                    C3627x9 c3627x9 = C3627x9.f3477a;
                    RequestCreator requestCreatorLoad = c3627x9.a(contextD).load(str2);
                    Object objA = c3627x9.a(new C3292a1(countDownLatch, str2, jElapsedRealtime, adType));
                    requestCreatorLoad.fetch(objA instanceof Callback ? (Callback) objA : null);
                }
            } catch (Exception unused) {
                countDownLatch.countDown();
            }
        }
        try {
            countDownLatch.await();
            Intrinsics.checkNotNullExpressionValue("d1", "TAG");
        } catch (InterruptedException unused2) {
        }
        C3335d1 c3335d1 = f3289a;
        c3335d1.e();
        c3335d1.a((byte) 0);
        for (String str3 : arrayList3) {
            C3335d1 c3335d2 = f3289a;
            Intrinsics.checkNotNullExpressionValue("d1", "TAG");
            C3417j c3417jA = AbstractC3415ib.a().a(str3);
            if (c3417jA != null && c3417jA.a()) {
                Intrinsics.checkNotNullExpressionValue("d1", "TAG");
                c3335d2.b(c3417jA);
            } else {
                a(str3);
            }
        }
    }

    public final synchronized void a(C3417j c3417j, byte b2) {
        a(c3417j);
        k.remove(c3417j.b);
        if (b2 == -1) {
            d(c3417j.b);
            e();
        } else {
            c(c3417j.b);
            a(b2);
        }
    }

    public final synchronized void a(byte b2) {
        ArrayList arrayList = new ArrayList();
        int size = l.size();
        for (int i2 = 0; i2 < size; i2++) {
            C3431k c3431k = (C3431k) l.get(i2);
            if (c3431k.b > 0) {
                try {
                    InterfaceC3349e1 interfaceC3349e1 = (InterfaceC3349e1) c3431k.d.get();
                    if (interfaceC3349e1 != null) {
                        interfaceC3349e1.a(c3431k, b2);
                    }
                    arrayList.add(c3431k);
                } catch (Exception e2) {
                    Intrinsics.checkNotNullExpressionValue("d1", "TAG");
                    C3339d5 c3339d5 = C3339d5.f3292a;
                    C3339d5.c.a(I4.a(e2, "event"));
                }
            }
        }
        b(arrayList);
    }

    public static void a() {
        if (m.get()) {
            synchronized (b) {
                ArrayList<C3417j> arrayListA = AbstractC3415ib.a().a();
                if (arrayListA.isEmpty()) {
                    return;
                }
                for (C3417j asset : arrayListA) {
                    asset.getClass();
                    if (System.currentTimeMillis() > asset.g && m.get()) {
                        W0 w0A = AbstractC3415ib.a();
                        w0A.getClass();
                        Intrinsics.checkNotNullParameter(asset, "asset");
                        w0A.a("id = ?", new String[]{String.valueOf(asset.f3343a)});
                        String str = asset.c;
                        if (str != null) {
                            File file = new File(str);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    }
                }
                b();
                a(arrayListA);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public static void a(ArrayList arrayList) {
        File[] fileArrListFiles;
        File fileB = C3517pb.f3400a.b(C3517pb.d());
        if (!fileB.exists() || (fileArrListFiles = fileB.listFiles()) == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            Iterator it = arrayList.iterator();
            do {
                if (!it.hasNext()) {
                    Intrinsics.checkNotNullExpressionValue("d1", "TAG");
                    file.getAbsolutePath();
                    file.delete();
                    break;
                }
            } while (!Intrinsics.areEqual(file.getAbsolutePath(), ((C3417j) it.next()).c));
        }
    }

    public static final void b(String remoteUrl) {
        Intrinsics.checkNotNullParameter(remoteUrl, "$remoteUrl");
        C3417j c3417jA = AbstractC3415ib.a().a(remoteUrl);
        if (c3417jA != null) {
            if (c3417jA.a()) {
                f3289a.b(c3417jA);
            } else if (a(c3417jA, o)) {
                Intrinsics.checkNotNullExpressionValue("d1", "TAG");
            } else {
                Intrinsics.checkNotNullExpressionValue("d1", "TAG");
            }
        }
    }

    public static void a(final C3431k assetBatch) {
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        if (m.get()) {
            e.execute(new Runnable() { // from class: com.inmobi.media.d1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3335d1.b(assetBatch);
                }
            });
        }
    }

    public static void a(final C3431k assetBatch, final String adType) {
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        Intrinsics.checkNotNullParameter(adType, "adType");
        if (m.get()) {
            e.execute(new Runnable() { // from class: com.inmobi.media.d1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    C3335d1.b(assetBatch, adType);
                }
            });
        }
    }

    public static void a(final String url) {
        C3417j asset;
        AdConfig.AssetCacheConfig assetCacheConfig = c;
        if (assetCacheConfig != null) {
            int iNextInt = new Random().nextInt() & Integer.MAX_VALUE;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            int maxRetries = assetCacheConfig.getMaxRetries();
            long timeToLive = assetCacheConfig.getTimeToLive();
            Intrinsics.checkNotNullParameter(url, "url");
            asset = new C3417j(iNextInt, url == null ? "" : url, null, maxRetries, jCurrentTimeMillis, jCurrentTimeMillis2, System.currentTimeMillis() + timeToLive, 0L);
        } else {
            asset = null;
        }
        if (AbstractC3415ib.a().a(url) == null && asset != null) {
            W0 w0A = AbstractC3415ib.a();
            synchronized (w0A) {
                Intrinsics.checkNotNullParameter(asset, "asset");
                w0A.a(asset, "url = ?", new String[]{asset.b});
            }
        }
        f.execute(new Runnable() { // from class: com.inmobi.media.d1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3335d1.b(url);
            }
        });
    }
}
