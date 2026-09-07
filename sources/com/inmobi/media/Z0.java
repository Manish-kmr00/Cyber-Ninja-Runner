package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class Z0 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3250a;
    public final Y0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z0(Looper looper, C3335d1 assetStore) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
        Intrinsics.checkNotNullParameter(assetStore, "assetStore");
        this.f3250a = new WeakReference(assetStore);
        this.b = new Y0(this);
    }

    public final void a() {
        try {
            sendEmptyMessage(1);
        } catch (Exception unused) {
            C3335d1 c3335d1 = C3335d1.f3289a;
            Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            if (C3335d1.m.get()) {
                C3335d1 c3335d1 = (C3335d1) this.f3250a.get();
                int i = msg.what;
                if (i == 1) {
                    if (c3335d1 != null) {
                        AdConfig.AssetCacheConfig assetCache = C3335d1.c;
                        if (assetCache == null) {
                            LinkedHashMap linkedHashMap = C3578u2.f3440a;
                            Config configA = C3549s2.a("ads", C3517pb.b(), null);
                            Intrinsics.checkNotNull(configA, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
                            assetCache = ((AdConfig) configA).getAssetCache();
                        }
                        ArrayList<C3417j> arrayListB = AbstractC3415ib.a().b();
                        if (arrayListB.isEmpty()) {
                            Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
                            C3335d1.d();
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
                        C3417j c3417j = (C3417j) arrayListB.get(0);
                        for (C3417j c3417j2 : arrayListB) {
                            if (!C3335d1.k.containsKey(c3417j.b)) {
                                c3417j = c3417j2;
                                break;
                            }
                        }
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 1;
                        long jCurrentTimeMillis = System.currentTimeMillis() - c3417j.e;
                        try {
                            if (jCurrentTimeMillis < assetCache.getRetryInterval() * 1000) {
                                sendMessageDelayed(messageObtain, ((long) (assetCache.getRetryInterval() * 1000)) - jCurrentTimeMillis);
                            } else if (C3335d1.k.containsKey(c3417j.b)) {
                                sendMessageDelayed(messageObtain, assetCache.getRetryInterval() * 1000);
                            } else {
                                Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
                                Message messageObtain2 = Message.obtain();
                                messageObtain2.what = 2;
                                messageObtain2.obj = c3417j.b;
                                sendMessage(messageObtain2);
                            }
                            return;
                        } catch (Exception unused) {
                            C3335d1 c3335d2 = C3335d1.f3289a;
                            Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
                            return;
                        }
                    }
                    return;
                }
                if (i != 2) {
                    if (i == 3) {
                        a();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    if (c3335d1 != null) {
                        Object obj = msg.obj;
                        C3417j asset = obj instanceof C3417j ? (C3417j) obj : null;
                        if (asset != null) {
                            W0 w0A = AbstractC3415ib.a();
                            w0A.getClass();
                            Intrinsics.checkNotNullParameter(asset, "asset");
                            w0A.a("id = ?", new String[]{String.valueOf(asset.f3343a)});
                        }
                    }
                    a();
                    return;
                }
                if (c3335d1 != null) {
                    Object obj2 = msg.obj;
                    String str = obj2 instanceof String ? (String) obj2 : null;
                    if (str == null) {
                        return;
                    }
                    C3417j c3417jB = AbstractC3415ib.a().b(str);
                    if (c3417jB == null) {
                        a();
                        return;
                    }
                    if (c3417jB.a()) {
                        Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
                        try {
                            sendEmptyMessage(3);
                        } catch (Exception unused2) {
                            C3335d1 c3335d3 = C3335d1.f3289a;
                            Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
                        }
                        c3335d1.a(c3417jB, (byte) -1);
                        return;
                    }
                    AdConfig.AssetCacheConfig assetCacheConfig = C3335d1.c;
                    if (assetCacheConfig != null) {
                        assetCacheConfig.getMaxRetries();
                    }
                    if (c3417jB.d <= 0) {
                        c3417jB.l = (byte) 6;
                        c3335d1.a(c3417jB, (byte) 6);
                        try {
                            Message messageObtain3 = Message.obtain();
                            messageObtain3.what = 4;
                            messageObtain3.obj = c3417jB;
                            sendMessage(messageObtain3);
                            return;
                        } catch (Exception unused3) {
                            C3335d1 c3335d4 = C3335d1.f3289a;
                            Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
                            return;
                        }
                    }
                    boolean z = W8.f3228a;
                    if (W8.a(false) != null) {
                        c3335d1.a(c3417jB, c3417jB.l);
                        C3335d1.d();
                        return;
                    } else if (C3335d1.a(c3417jB, this.b)) {
                        Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
                        Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
                        return;
                    } else {
                        Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
                        a();
                        return;
                    }
                }
                return;
                C3335d1 c3335d5 = C3335d1.f3289a;
                Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
                C3339d5 c3339d5 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e, "event"));
            }
        } catch (Exception e) {
            C3335d1 c3335d6 = C3335d1.f3289a;
            Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
            C3339d5 c3339d6 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }
}
