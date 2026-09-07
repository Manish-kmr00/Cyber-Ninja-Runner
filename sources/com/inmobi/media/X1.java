package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class X1 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public L4 f3232a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X1(Looper looper) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
    }

    public final void a(T1 click) {
        L4 l4 = this.f3232a;
        if (l4 != null) {
            String strF = C3364f2.f();
            ((M4) l4).a(strF, O5.a(strF, "access$getTAG$p(...)", "Retry attemps exhausted for click (").append(click.b).append(')').toString());
        }
        b(click);
        C3364f2.f3308a.a(click, "RETRY_EXHAUSTED");
        U1 u1B = AbstractC3415ib.b();
        u1B.getClass();
        Intrinsics.checkNotNullParameter(click, "click");
        u1B.a("id = ?", new String[]{String.valueOf(click.f3198a)});
        C3364f2.e.remove(click);
    }

    public final void b(T1 t1) {
        int iIndexOf = CollectionsKt.indexOf((List<? extends T1>) C3364f2.e, t1);
        if (-1 != iIndexOf) {
            T1 t2 = (T1) C3364f2.e.get(iIndexOf == C3364f2.e.size() + (-1) ? 0 : iIndexOf + 1);
            Message messageObtain = Message.obtain();
            messageObtain.what = t2.e ? 3 : 2;
            messageObtain.obj = t2;
            AdConfig.ImaiConfig imaiConfig = C3364f2.g;
            long pingInterval = (imaiConfig != null ? imaiConfig.getPingInterval() : 0) * 1000;
            if (System.currentTimeMillis() - t2.g < pingInterval) {
                sendMessageDelayed(messageObtain, pingInterval);
            } else {
                sendMessage(messageObtain);
            }
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (C3364f2.h.get()) {
            try {
                int i = msg.what;
                int i2 = 3;
                if (i == 1) {
                    if (C3364f2.f3308a.g()) {
                        AdConfig.ImaiConfig imaiConfig = C3364f2.g;
                        U1 u1B = AbstractC3415ib.b();
                        if (imaiConfig == null) {
                            L4 l4 = this.f3232a;
                            if (l4 != null) {
                                String strF = C3364f2.f();
                                Intrinsics.checkNotNullExpressionValue(strF, "access$getTAG$p(...)");
                                ((M4) l4).b(strF, "Unhandled message due to ImaiConfig Null");
                                return;
                            }
                            return;
                        }
                        C3364f2.e = u1B.a(imaiConfig.getMaxEventBatch(), imaiConfig.getPingInterval());
                        if (C3364f2.e.isEmpty()) {
                            if (D1.a((D1) u1B) == 0) {
                                C3364f2.f.set(false);
                                return;
                            }
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 1;
                            sendMessageDelayed(messageObtain, imaiConfig.getPingInterval() * 1000);
                            return;
                        }
                        L4 l5 = this.f3232a;
                        if (l5 != null) {
                            String strF2 = C3364f2.f();
                            Intrinsics.checkNotNullExpressionValue(strF2, "access$getTAG$p(...)");
                            ((M4) l5).a(strF2, "Processing following click batch");
                        }
                        for (T1 t1 : C3364f2.e) {
                            Intrinsics.checkNotNullExpressionValue(C3364f2.f(), "access$getTAG$p(...)");
                            String str = t1.b;
                        }
                        T1 t2 = (T1) C3364f2.e.get(0);
                        Message messageObtain2 = Message.obtain();
                        if (!t2.e) {
                            i2 = 2;
                        }
                        messageObtain2.what = i2;
                        messageObtain2.obj = t2;
                        long jCurrentTimeMillis = System.currentTimeMillis() - t2.g;
                        if (jCurrentTimeMillis < imaiConfig.getPingInterval() * 1000) {
                            sendMessageDelayed(messageObtain2, ((long) (imaiConfig.getPingInterval() * 1000)) - jCurrentTimeMillis);
                            return;
                        } else {
                            sendMessage(messageObtain2);
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    boolean z = W8.f3228a;
                    if (W8.a(false) != null) {
                        C3364f2.f.set(false);
                        C3364f2.a(C3364f2.f3308a);
                        return;
                    }
                    Object obj = msg.obj;
                    AdConfig.ImaiConfig imaiConfig2 = C3364f2.g;
                    if ((obj instanceof T1) && imaiConfig2 != null) {
                        if (((T1) obj).f != 0) {
                            T1 t3 = (T1) obj;
                            long pingCacheExpiry = imaiConfig2.getPingCacheExpiry();
                            t3.getClass();
                            if (System.currentTimeMillis() - t3.h <= pingCacheExpiry * ((long) 1000)) {
                                int maxRetries = (imaiConfig2.getMaxRetries() - ((T1) obj).f) + 1;
                                if (maxRetries == 0) {
                                    L4 l6 = this.f3232a;
                                    if (l6 != null) {
                                        String strF3 = C3364f2.f();
                                        Intrinsics.checkNotNullExpressionValue(strF3, "access$getTAG$p(...)");
                                        ((M4) l6).a(strF3, "Pinging click (" + ((T1) obj).b + ") over HTTP");
                                    }
                                } else {
                                    L4 l7 = this.f3232a;
                                    if (l7 != null) {
                                        String strF4 = C3364f2.f();
                                        Intrinsics.checkNotNullExpressionValue(strF4, "access$getTAG$p(...)");
                                        ((M4) l7).a(strF4, "Retry attempt #" + maxRetries + " for click (" + ((T1) obj).b + ") over HTTP");
                                    }
                                }
                                new C3293a2(new V1(this), this.f3232a).a((T1) obj);
                                return;
                            }
                        }
                        a((T1) obj);
                        return;
                    }
                    L4 l8 = this.f3232a;
                    if (l8 != null) {
                        String strF5 = C3364f2.f();
                        Intrinsics.checkNotNullExpressionValue(strF5, "access$getTAG$p(...)");
                        ((M4) l8).b(strF5, "Unhandled message due to ImaiConfig Null");
                        return;
                    }
                    return;
                }
                if (i == 3) {
                    boolean z2 = W8.f3228a;
                    if (W8.a(false) != null) {
                        C3364f2.f.set(false);
                        C3364f2.a(C3364f2.f3308a);
                        return;
                    }
                    Object obj2 = msg.obj;
                    AdConfig.ImaiConfig imaiConfig3 = C3364f2.g;
                    if ((obj2 instanceof T1) && imaiConfig3 != null) {
                        if (((T1) obj2).f != 0) {
                            T1 t4 = (T1) obj2;
                            long pingCacheExpiry2 = imaiConfig3.getPingCacheExpiry();
                            t4.getClass();
                            if (System.currentTimeMillis() - t4.h <= pingCacheExpiry2 * ((long) 1000)) {
                                int maxRetries2 = (imaiConfig3.getMaxRetries() - ((T1) obj2).f) + 1;
                                if (maxRetries2 == 0) {
                                    L4 l9 = this.f3232a;
                                    if (l9 != null) {
                                        String strF6 = C3364f2.f();
                                        Intrinsics.checkNotNullExpressionValue(strF6, "access$getTAG$p(...)");
                                        ((M4) l9).a(strF6, "Pinging click (" + ((T1) obj2).b + ") in WebView");
                                    }
                                } else {
                                    L4 l10 = this.f3232a;
                                    if (l10 != null) {
                                        String strF7 = C3364f2.f();
                                        Intrinsics.checkNotNullExpressionValue(strF7, "access$getTAG$p(...)");
                                        ((M4) l10).b(strF7, "Retry attempt #" + maxRetries2 + " for click (" + ((T1) obj2).b + ") using WebView");
                                    }
                                }
                                new Z1(new W1(this), this.f3232a).a((T1) obj2);
                                return;
                            }
                        }
                        a((T1) obj2);
                        return;
                    }
                    L4 l11 = this.f3232a;
                    if (l11 != null) {
                        String strF8 = C3364f2.f();
                        Intrinsics.checkNotNullExpressionValue(strF8, "access$getTAG$p(...)");
                        ((M4) l11).b(strF8, "Unhandled message due to ImaiConfig Null");
                        return;
                    }
                    return;
                }
                if (i != 4) {
                    L4 l12 = this.f3232a;
                    if (l12 != null) {
                        String strF9 = C3364f2.f();
                        Intrinsics.checkNotNullExpressionValue(strF9, "access$getTAG$p(...)");
                        ((M4) l12).b(strF9, "Unhandled message ( " + msg.what + " ) in pingHandler");
                        return;
                    }
                    return;
                }
                Object obj3 = msg.obj;
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.inmobi.ads.core.Click");
                T1 click = (T1) obj3;
                L4 l13 = this.f3232a;
                if (l13 != null) {
                    String strF10 = C3364f2.f();
                    Intrinsics.checkNotNullExpressionValue(strF10, "access$getTAG$p(...)");
                    ((M4) l13).a(strF10, "Processing click (" + click.b + ") completed");
                }
                C3364f2.b(C3364f2.f3308a, click);
                U1 u1B2 = AbstractC3415ib.b();
                u1B2.getClass();
                Intrinsics.checkNotNullParameter(click, "click");
                u1B2.a("id = ?", new String[]{String.valueOf(click.f3198a)});
                C3364f2.e.remove(click);
                if (!C3364f2.e.isEmpty()) {
                    T1 t5 = (T1) C3364f2.e.get(0);
                    Message messageObtain3 = Message.obtain();
                    if (t5 == null || !t5.e) {
                        i2 = 2;
                    }
                    messageObtain3.what = i2;
                    messageObtain3.obj = t5;
                    sendMessage(messageObtain3);
                    return;
                }
                U1 u1B3 = AbstractC3415ib.b();
                u1B3.getClass();
                if (D1.a((D1) u1B3) != 0) {
                    Message messageObtain4 = Message.obtain();
                    messageObtain4.what = 1;
                    sendMessage(messageObtain4);
                } else {
                    L4 l14 = this.f3232a;
                    if (l14 != null) {
                        String strF11 = C3364f2.f();
                        Intrinsics.checkNotNullExpressionValue(strF11, "access$getTAG$p(...)");
                        ((M4) l14).a(strF11, "Done processing all clicks!");
                    }
                    C3364f2.f.set(false);
                }
            } catch (Exception e) {
                L4 l15 = this.f3232a;
                if (l15 != null) {
                    String strF12 = C3364f2.f();
                    ((M4) l15).b(strF12, ld.a(e, O5.a(strF12, "access$getTAG$p(...)", "SDK encountered unexpected error in processing ping; ")));
                }
            }
        }
    }
}
