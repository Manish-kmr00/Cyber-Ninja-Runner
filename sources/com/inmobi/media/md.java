package com.inmobi.media;

import android.content.Context;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import com.inmobi.commons.core.configs.AdConfig;
import com.pubmatic.sdk.common.POBCommonConstants;
import io.ktor.http.ContentDisposition;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class md {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final md f3377a = new md();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final AdConfig.WebAssetCacheConfig c;
    public static final jd d;

    static {
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        AdConfig.WebAssetCacheConfig webAssetCache = ((AdConfig) B4.a("ads", "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null)).getWebAssetCache();
        c = webAssetCache;
        Context contextD = C3517pb.d();
        d = contextD != null ? new jd(contextD, webAssetCache) : null;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x022b  */
    /* JADX WARN: Code duplicated, block: B:114:0x024b  */
    /* JADX WARN: Code duplicated, block: B:135:0x0199 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00fa A[Catch: Exception -> 0x01ff, TimeoutException -> 0x0207, TryCatch #11 {TimeoutException -> 0x0207, Exception -> 0x01ff, blocks: (B:38:0x00cb, B:40:0x00d9, B:42:0x00e6, B:45:0x00fa, B:55:0x0149, B:58:0x0177, B:46:0x0105, B:49:0x010d, B:50:0x0117, B:53:0x0130, B:54:0x013a, B:41:0x00e0), top: B:137:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0105 A[Catch: Exception -> 0x01ff, TimeoutException -> 0x0207, TryCatch #11 {TimeoutException -> 0x0207, Exception -> 0x01ff, blocks: (B:38:0x00cb, B:40:0x00d9, B:42:0x00e6, B:45:0x00fa, B:55:0x0149, B:58:0x0177, B:46:0x0105, B:49:0x010d, B:50:0x0117, B:53:0x0130, B:54:0x013a, B:41:0x00e0), top: B:137:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:48:0x010b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x010d A[Catch: Exception -> 0x01ff, TimeoutException -> 0x0207, TryCatch #11 {TimeoutException -> 0x0207, Exception -> 0x01ff, blocks: (B:38:0x00cb, B:40:0x00d9, B:42:0x00e6, B:45:0x00fa, B:55:0x0149, B:58:0x0177, B:46:0x0105, B:49:0x010d, B:50:0x0117, B:53:0x0130, B:54:0x013a, B:41:0x00e0), top: B:137:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:52:0x012e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0130 A[Catch: Exception -> 0x01ff, TimeoutException -> 0x0207, TryCatch #11 {TimeoutException -> 0x0207, Exception -> 0x01ff, blocks: (B:38:0x00cb, B:40:0x00d9, B:42:0x00e6, B:45:0x00fa, B:55:0x0149, B:58:0x0177, B:46:0x0105, B:49:0x010d, B:50:0x0117, B:53:0x0130, B:54:0x013a, B:41:0x00e0), top: B:137:0x00cb }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0171  */
    /* JADX WARN: Code duplicated, block: B:64:0x0184  */
    /* JADX WARN: Code duplicated, block: B:65:0x0185 A[Catch: Exception -> 0x01d1, TimeoutException -> 0x01d9, TRY_LEAVE, TryCatch #18 {TimeoutException -> 0x01d9, Exception -> 0x01d1, blocks: (B:62:0x0181, B:65:0x0185), top: B:124:0x0181 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:89:0x01e5 A[Catch: TimeoutException -> 0x01dd, Exception -> 0x01fd, TryCatch #14 {TimeoutException -> 0x01dd, Exception -> 0x01fd, blocks: (B:87:0x01e1, B:89:0x01e5, B:90:0x01ee, B:77:0x01bb), top: B:132:0x016f }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01ee A[Catch: TimeoutException -> 0x01dd, Exception -> 0x01fd, TRY_LEAVE, TryCatch #14 {TimeoutException -> 0x01dd, Exception -> 0x01fd, blocks: (B:87:0x01e1, B:89:0x01e5, B:90:0x01ee, B:77:0x01bb), top: B:132:0x016f }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    public final WebResourceResponse a(final String url, final L4 l4) {
        ?? r6;
        String str;
        String mimeTypeFromExtension;
        String str2;
        Object obj;
        Pair pair;
        boolean zBooleanValue;
        FutureTask futureTask;
        InputStream inputStreamA;
        Va response;
        byte[] bArr;
        byte[] bArr2;
        long length;
        P8 p8;
        Object objValueOf;
        ?? r3 = "latency";
        String str3 = "errorCode";
        String str4 = "Found in cache in After FutureTask created: ";
        Intrinsics.checkNotNullParameter(url, "url");
        jd jdVar = d;
        if (jdVar == null || jdVar.f3350a == null) {
            if (l4 == null) {
                return null;
            }
            ((M4) l4).b("WebResourceHandler", "WebAsset Cache Helper was not Initialized. " + jdVar + " for URL: " + url);
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("url", url);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(url);
            if (AbstractC3420j2.a(fileExtensionFromUrl)) {
                str = "errorCode";
                try {
                    mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
                } catch (TimeoutException unused) {
                    str4 = "ResourceCacheMiss";
                    str3 = str;
                    linkedHashMap.put(str3, (short) 2193);
                    r6 = r3;
                    if (l4 != null) {
                        ((M4) l4).b("WebResourceHandler", "Timeout exception occurred for url: ".concat(url));
                        r6 = r3;
                    }
                    linkedHashMap.put(r6, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                    Ob ob = Ob.f3160a;
                    Ob.b(str4, linkedHashMap, Sb.SDK);
                    return null;
                } catch (Exception e) {
                    e = e;
                    str4 = "ResourceCacheMiss";
                    str3 = str;
                    linkedHashMap.put(str3, (short) 2195);
                    r6 = r3;
                    if (l4 != null) {
                        ((M4) l4).b("WebResourceHandler", ld.a(e, new StringBuilder("Unhandled exception occurred: ")));
                        r6 = r3;
                    }
                    linkedHashMap.put(r6, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                    Ob ob2 = Ob.f3160a;
                    Ob.b(str4, linkedHashMap, Sb.SDK);
                    return null;
                }
            } else {
                str = "errorCode";
                mimeTypeFromExtension = null;
            }
            if (mimeTypeFromExtension == null || mimeTypeFromExtension.length() == 0) {
                mimeTypeFromExtension = POBCommonConstants.CONTENT_TYPE_HTML;
            }
            if (l4 != null) {
                ((M4) l4).a("WebResourceHandler", "mimeType is " + mimeTypeFromExtension + " for " + url);
            }
            InputStream inputStreamA2 = jdVar.a(url, l4);
            if (inputStreamA2 != null) {
                if (l4 != null) {
                    ((M4) l4).a("WebResourceHandler", "Found in cache: ".concat(url));
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("url", url);
                Ob ob3 = Ob.f3160a;
                Ob.b("ResourceCacheHit", linkedHashMap2, Sb.SDK);
                return AbstractC3420j2.a(inputStreamA2, mimeTypeFromExtension);
            }
            ConcurrentHashMap concurrentHashMap = b;
            FutureTask futureTask2 = (FutureTask) concurrentHashMap.get(url);
            try {
                try {
                    if (futureTask2 != null) {
                        str2 = "ResourceCacheMiss";
                        try {
                            pair = TuplesKt.to(Boolean.TRUE, futureTask2);
                            if (pair != null) {
                                obj = "latency";
                            }
                            zBooleanValue = ((Boolean) pair.component1()).booleanValue();
                            futureTask = (FutureTask) pair.component2();
                            if (zBooleanValue) {
                                inputStreamA = jdVar.a(url, l4);
                                if (inputStreamA != null) {
                                    if (l4 != null) {
                                        ((M4) l4).a("WebResourceHandler", "Found in cache in After FutureTask created: ".concat(url));
                                    }
                                    concurrentHashMap.remove(url);
                                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                                    linkedHashMap3.put("url", url);
                                    Ob ob4 = Ob.f3160a;
                                    Ob.b("ResourceCacheHit", linkedHashMap3, Sb.SDK);
                                    return AbstractC3420j2.a(inputStreamA, mimeTypeFromExtension);
                                }
                                if (l4 != null) {
                                    ((M4) l4).c("WebResourceHandler", "request for ".concat(url));
                                }
                                futureTask.run();
                                concurrentHashMap.remove(url);
                                linkedHashMap.put("networkType", C3435k3.q());
                            } else if (l4 != null) {
                                ((M4) l4).c("WebResourceHandler", "waiting for existing request for ".concat(url));
                            }
                            AdConfig.WebAssetCacheConfig webAssetCacheConfig = c;
                            response = (Va) futureTask.get(((long) webAssetCacheConfig.getTimeout()) * ((long) Math.max(1, webAssetCacheConfig.getMaxRetries())), TimeUnit.MILLISECONDS);
                            Intrinsics.checkNotNull(response);
                            Intrinsics.checkNotNullParameter(response, "response");
                            bArr = response.c;
                            r3 = response.d;
                            if (r3 == 0 && r3.intValue() == 200 && bArr != null) {
                                try {
                                    if (bArr.length != 0) {
                                        str4 = str2;
                                        r3 = obj;
                                        p8 = response.f3220a;
                                        if (p8 != null) {
                                            objValueOf = Integer.valueOf(p8.f3168a.f3094a);
                                        } else {
                                            objValueOf = (short) 2194;
                                        }
                                        str3 = str;
                                        try {
                                            linkedHashMap.put(str3, objValueOf);
                                            r6 = r3;
                                        } catch (TimeoutException unused2) {
                                            linkedHashMap.put(str3, (short) 2193);
                                            r6 = r3;
                                            if (l4 != null) {
                                                ((M4) l4).b("WebResourceHandler", "Timeout exception occurred for url: ".concat(url));
                                                r6 = r3;
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            linkedHashMap.put(str3, (short) 2195);
                                            r6 = r3;
                                            if (l4 != null) {
                                                ((M4) l4).b("WebResourceHandler", ld.a(e, new StringBuilder("Unhandled exception occurred: ")));
                                                r6 = r3;
                                            }
                                        }
                                    } else {
                                        r3 = obj;
                                        try {
                                            linkedHashMap.put(r3, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                                            bArr2 = response.c;
                                            if (bArr2 != null) {
                                                try {
                                                    length = ((long) bArr2.length) / 1024;
                                                } catch (TimeoutException unused3) {
                                                    str3 = str;
                                                    str4 = str2;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    str3 = str;
                                                    str4 = str2;
                                                    linkedHashMap.put(str3, (short) 2195);
                                                    r6 = r3;
                                                    if (l4 != null) {
                                                        ((M4) l4).b("WebResourceHandler", ld.a(e, new StringBuilder("Unhandled exception occurred: ")));
                                                        r6 = r3;
                                                    }
                                                    linkedHashMap.put(r6, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                                                    Ob ob5 = Ob.f3160a;
                                                    Ob.b(str4, linkedHashMap, Sb.SDK);
                                                    return null;
                                                }
                                            } else {
                                                length = 0;
                                            }
                                            linkedHashMap.put(ContentDisposition.Parameters.Size, Long.valueOf(length));
                                            Ob ob6 = Ob.f3160a;
                                            Ob.b(str2, linkedHashMap, Sb.SDK);
                                            return AbstractC3420j2.a(new ByteArrayInputStream(response.c), mimeTypeFromExtension);
                                        } catch (TimeoutException unused4) {
                                            str4 = str2;
                                            str3 = str;
                                        } catch (Exception e4) {
                                            e = e4;
                                            str4 = str2;
                                            str3 = str;
                                            linkedHashMap.put(str3, (short) 2195);
                                            r6 = r3;
                                            if (l4 != null) {
                                                ((M4) l4).b("WebResourceHandler", ld.a(e, new StringBuilder("Unhandled exception occurred: ")));
                                                r6 = r3;
                                            }
                                            linkedHashMap.put(r6, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                                            Ob ob7 = Ob.f3160a;
                                            Ob.b(str4, linkedHashMap, Sb.SDK);
                                            return null;
                                        }
                                    }
                                } catch (TimeoutException unused5) {
                                    str4 = str2;
                                    r3 = obj;
                                } catch (Exception e5) {
                                    e = e5;
                                    str4 = str2;
                                    r3 = obj;
                                }
                            } else {
                                str4 = str2;
                                r3 = obj;
                                p8 = response.f3220a;
                                if (p8 != null) {
                                    objValueOf = Integer.valueOf(p8.f3168a.f3094a);
                                } else {
                                    objValueOf = (short) 2194;
                                }
                                str3 = str;
                                linkedHashMap.put(str3, objValueOf);
                                r6 = r3;
                            }
                        } catch (TimeoutException unused6) {
                            str3 = str;
                            str4 = str2;
                        } catch (Exception e6) {
                            e = e6;
                            str3 = str;
                            str4 = str2;
                            linkedHashMap.put(str3, (short) 2195);
                            r6 = r3;
                            if (l4 != null) {
                                ((M4) l4).b("WebResourceHandler", ld.a(e, new StringBuilder("Unhandled exception occurred: ")));
                                r6 = r3;
                            }
                            linkedHashMap.put(r6, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                            Ob ob8 = Ob.f3160a;
                            Ob.b(str4, linkedHashMap, Sb.SDK);
                            return null;
                        }
                        linkedHashMap.put(r6, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        Ob ob9 = Ob.f3160a;
                        Ob.b(str4, linkedHashMap, Sb.SDK);
                        return null;
                    }
                    str2 = "ResourceCacheMiss";
                    if (r3 == 0) {
                        str4 = str2;
                        r3 = obj;
                        p8 = response.f3220a;
                        if (p8 != null) {
                            objValueOf = Integer.valueOf(p8.f3168a.f3094a);
                        } else {
                            objValueOf = (short) 2194;
                        }
                        str3 = str;
                        linkedHashMap.put(str3, objValueOf);
                        r6 = r3;
                    } else {
                        if (bArr.length != 0) {
                            r3 = obj;
                            linkedHashMap.put(r3, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                            bArr2 = response.c;
                            if (bArr2 != null) {
                                length = ((long) bArr2.length) / 1024;
                            } else {
                                length = 0;
                            }
                            linkedHashMap.put(ContentDisposition.Parameters.Size, Long.valueOf(length));
                            Ob ob10 = Ob.f3160a;
                            Ob.b(str2, linkedHashMap, Sb.SDK);
                            return AbstractC3420j2.a(new ByteArrayInputStream(response.c), mimeTypeFromExtension);
                        }
                        str4 = str2;
                        r3 = obj;
                        p8 = response.f3220a;
                        if (p8 != null) {
                            objValueOf = Integer.valueOf(p8.f3168a.f3094a);
                        } else {
                            objValueOf = (short) 2194;
                        }
                        str3 = str;
                        linkedHashMap.put(str3, objValueOf);
                        r6 = r3;
                        str3 = str;
                        linkedHashMap.put(str3, (short) 2193);
                        r6 = r3;
                        if (l4 != null) {
                            ((M4) l4).b("WebResourceHandler", "Timeout exception occurred for url: ".concat(url));
                            r6 = r3;
                        }
                    }
                } catch (TimeoutException unused7) {
                } catch (Exception e7) {
                    e = e7;
                }
                FutureTask futureTask3 = new FutureTask(new Callable() { // from class: com.inmobi.media.md$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return md.a(this.f$0, url, l4);
                    }
                });
                FutureTask futureTask4 = (FutureTask) concurrentHashMap.putIfAbsent(url, futureTask3);
                pair = futureTask4 == null ? TuplesKt.to(Boolean.FALSE, futureTask3) : TuplesKt.to(Boolean.TRUE, futureTask4);
                zBooleanValue = ((Boolean) pair.component1()).booleanValue();
                futureTask = (FutureTask) pair.component2();
                if (zBooleanValue) {
                    inputStreamA = jdVar.a(url, l4);
                    if (inputStreamA != null) {
                        if (l4 != null) {
                            ((M4) l4).a("WebResourceHandler", "Found in cache in After FutureTask created: ".concat(url));
                        }
                        concurrentHashMap.remove(url);
                        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                        linkedHashMap4.put("url", url);
                        Ob ob11 = Ob.f3160a;
                        Ob.b("ResourceCacheHit", linkedHashMap4, Sb.SDK);
                        return AbstractC3420j2.a(inputStreamA, mimeTypeFromExtension);
                    }
                    if (l4 != null) {
                        ((M4) l4).c("WebResourceHandler", "request for ".concat(url));
                    }
                    futureTask.run();
                    concurrentHashMap.remove(url);
                    linkedHashMap.put("networkType", C3435k3.q());
                } else if (l4 != null) {
                    ((M4) l4).c("WebResourceHandler", "waiting for existing request for ".concat(url));
                }
                AdConfig.WebAssetCacheConfig webAssetCacheConfig2 = c;
                response = (Va) futureTask.get(((long) webAssetCacheConfig2.getTimeout()) * ((long) Math.max(1, webAssetCacheConfig2.getMaxRetries())), TimeUnit.MILLISECONDS);
                Intrinsics.checkNotNull(response);
                Intrinsics.checkNotNullParameter(response, "response");
                bArr = response.c;
                r3 = response.d;
            } catch (TimeoutException unused8) {
                str3 = str;
                str4 = str2;
                r3 = obj;
            } catch (Exception e8) {
                e = e8;
                str3 = str;
                str4 = str2;
                r3 = obj;
                linkedHashMap.put(str3, (short) 2195);
                r6 = r3;
                if (l4 != null) {
                    ((M4) l4).b("WebResourceHandler", ld.a(e, new StringBuilder("Unhandled exception occurred: ")));
                    r6 = r3;
                }
                linkedHashMap.put(r6, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                Ob ob12 = Ob.f3160a;
                Ob.b(str4, linkedHashMap, Sb.SDK);
                return null;
            }
            obj = "latency";
            linkedHashMap.put(r6, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            Ob ob13 = Ob.f3160a;
            Ob.b(str4, linkedHashMap, Sb.SDK);
            return null;
        } catch (TimeoutException unused9) {
            str4 = "ResourceCacheMiss";
        } catch (Exception e9) {
            e = e9;
            str4 = "ResourceCacheMiss";
        }
    }

    public static final Va a(md this_run, String url, L4 l4) throws Throwable {
        C3536r3 c3536r3;
        Va response;
        P8 p8;
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(url, "$url");
        this_run.getClass();
        if (l4 != null) {
            ((M4) l4).c("WebResourceHandler", S.a("downloadResourceFile(): ", url));
        }
        Ma method = Ma.GET;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        La la = new La(url, method);
        AdConfig.WebAssetCacheConfig webAssetCacheConfig = c;
        la.h = Integer.valueOf(webAssetCacheConfig.getTimeout());
        la.i = Integer.valueOf(webAssetCacheConfig.getTimeout());
        Oa retryPolicy = new Oa(webAssetCacheConfig.getMaxRetries(), 500);
        Intrinsics.checkNotNullParameter(retryPolicy, "retryPolicy");
        la.g = retryPolicy;
        Pa request = new Pa(la);
        Intrinsics.checkNotNullParameter(request, "request");
        do {
            c3536r3 = null;
            response = O8.a(request, (Function2) null);
            p8 = response.f3220a;
        } while ((p8 != null ? p8.f3168a : null) == I3.m);
        Intrinsics.checkNotNullParameter(response, "response");
        byte[] bArr = response.c;
        Integer num = response.d;
        if (num != null && num.intValue() == 200 && bArr != null && bArr.length != 0) {
            if (l4 != null) {
                ((M4) l4).c("WebResourceHandler", "onSuccessfulResponse: ".concat(url));
            }
            jd jdVar = d;
            if (jdVar != null) {
                String data = Q8.a(response.c);
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(data, "data");
                if (jdVar.f3350a != null) {
                    try {
                        String strValueOf = String.valueOf(url.hashCode());
                        C3536r3 c3536r4 = jdVar.f3350a;
                        if (c3536r4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("diskLruCache");
                        } else {
                            c3536r3 = c3536r4;
                        }
                        C3495o3 c3495o3A = c3536r3.a(strValueOf);
                        if (c3495o3A != null) {
                            c3495o3A.a(url, 0);
                            c3495o3A.a(data, 1);
                            if (c3495o3A.c) {
                                C3536r3.a(c3495o3A.d, c3495o3A, false);
                                c3495o3A.d.d(c3495o3A.f3385a.f3397a);
                            } else {
                                C3536r3.a(c3495o3A.d, c3495o3A, true);
                            }
                        } else if (l4 != null) {
                            ((M4) l4).a("WebAssetLRUCacheHelper", "Failed to write to cache diskLruCache with: diskLruCache.editor is null for ".concat(url));
                        }
                    } catch (Exception e) {
                        if (l4 != null) {
                            ((M4) l4).a("WebAssetLRUCacheHelper", "Failed to write to cache diskLruCache with: " + e.getMessage() + " for " + url);
                        }
                    }
                } else if (l4 != null) {
                    ((M4) l4).a("WebAssetLRUCacheHelper", "Disk Cache Failed to Initialize. Failed writeToCache: ".concat(url));
                }
            }
        }
        return response;
    }
}
