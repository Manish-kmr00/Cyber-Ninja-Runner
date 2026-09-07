package com.inmobi.media;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
public final class H6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3088a;
    public final int b;
    public final int c;
    public final long d;
    public final L4 e;
    public final String f = "H6";
    public S8 g;

    public H6(String str, int i, int i2, long j, L4 l4) {
        this.f3088a = str;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = l4;
    }

    public final void a() {
        String str = this.f3088a;
        if (str == null) {
            L4 l4 = this.e;
            if (l4 != null) {
                String TAG = this.f;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).b(TAG, "MRAID Js Url provided is invalid.");
                return;
            }
            return;
        }
        S8 s8 = new S8(str, this.e);
        s8.t = false;
        s8.u = false;
        s8.x = false;
        this.g = s8;
        ((ScheduledThreadPoolExecutor) S3.b.getValue()).submit(new Runnable() { // from class: com.inmobi.media.H6$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                H6.a(this.f$0);
            }
        });
    }

    public static final void a(H6 this$0) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        S8 mRequest = this$0.g;
        Context contextD = C3517pb.d();
        if (contextD != null) {
            if ((System.currentTimeMillis() / ((long) 1000)) - new A9(contextD, "mraid_js_store").b() <= this$0.d || mRequest == null) {
                return;
            }
            int i = 0;
            while (i <= this$0.b) {
                L4 l4 = this$0.e;
                if (l4 != null) {
                    String TAG = this$0.f;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4).a(TAG, "Attempting to get MRAID Js.");
                }
                Intrinsics.checkNotNullParameter(mRequest, "mRequest");
                T8 t8B = mRequest.b();
                Context contextD2 = C3517pb.d();
                if (t8B.b()) {
                    L4 l5 = this$0.e;
                    if (l5 != null) {
                        String TAG2 = this$0.f;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        ((M4) l5).b(TAG2, "Getting MRAID Js from server failed.");
                    }
                    i++;
                    if (i > this$0.b) {
                        return;
                    }
                    try {
                        Thread.sleep(this$0.c * 1000);
                    } catch (InterruptedException e) {
                        L4 l6 = this$0.e;
                        if (l6 != null) {
                            String TAG3 = this$0.f;
                            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                            ((M4) l6).a(TAG3, "MRAID Js client interrupted while sleeping.", e);
                        }
                    }
                } else if (contextD2 != null) {
                    A9 a9 = new A9(contextD2, "mraid_js_store");
                    Map map = t8B.e;
                    String strA = null;
                    List list = map != null ? (List) map.get("Content-Encoding") : null;
                    if (Intrinsics.areEqual(list != null ? (String) list.get(0) : null, "gzip")) {
                        L4 l7 = this$0.e;
                        if (l7 != null) {
                            String TAG4 = this$0.f;
                            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                            ((M4) l7).a(TAG4, "Response is GZIP-compressed, uncompressing it");
                        }
                        boolean z = W8.f3228a;
                        byte[] bArr2 = t8B.b;
                        if (bArr2 != null && bArr2.length != 0) {
                            Intrinsics.checkNotNull(bArr2);
                            bArr = new byte[bArr2.length];
                            byte[] bArr3 = t8B.b;
                            Intrinsics.checkNotNull(bArr3);
                            System.arraycopy(bArr3, 0, bArr, 0, bArr3.length);
                        } else {
                            bArr = new byte[0];
                        }
                        byte[] bArrA = W8.a(bArr);
                        if (bArrA != null) {
                            try {
                                String str = new String(bArrA, Charsets.UTF_8);
                                L4 l8 = this$0.e;
                                if (l8 != null) {
                                    String TAG5 = this$0.f;
                                    Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                                    ((M4) l8).a(TAG5, "Getting MRAID Js from server succeeded.");
                                }
                                strA = str;
                            } catch (UnsupportedEncodingException e2) {
                                L4 l9 = this$0.e;
                                if (l9 != null) {
                                    String str2 = this$0.f;
                                    ((M4) l9).b(str2, O5.a(str2, "TAG", "Failed to get MRAID JS \n").append(e2.getMessage()).toString());
                                }
                            }
                        }
                    } else {
                        L4 l10 = this$0.e;
                        if (l10 != null) {
                            String TAG6 = this$0.f;
                            Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                            ((M4) l10).a(TAG6, "Getting MRAID Js from server succeeded.");
                        }
                        strA = t8B.a();
                    }
                    if (strA != null) {
                        a9.b("mraid_js_string", strA);
                        return;
                    }
                    return;
                }
            }
        }
    }
}
