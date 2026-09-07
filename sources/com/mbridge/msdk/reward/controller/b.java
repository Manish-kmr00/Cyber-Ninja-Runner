package com.mbridge.msdk.reward.controller;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: RewardVideoControllerHandler.java */
/* JADX INFO: loaded from: classes13.dex */
public class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f5376a;

    public b(a aVar) {
        super(Looper.getMainLooper());
        this.f5376a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        Object obj = message.obj;
        com.mbridge.msdk.foundation.same.report.metrics.c cVarA = this.f5376a.a(message);
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListI = this.f5376a.i();
        List<CampaignEx> listH = this.f5376a.h();
        com.mbridge.msdk.reward.adapter.c cVarN = this.f5376a.n();
        boolean zS = this.f5376a.s();
        String strL = this.f5376a.l();
        String strP = this.f5376a.p();
        a.h hVarK = this.f5376a.k();
        InterVideoOutListener interVideoOutListenerO = this.f5376a.o();
        boolean zR = this.f5376a.r();
        MBridgeIds mBridgeIdsG = this.f5376a.g();
        boolean zT = this.f5376a.t();
        switch (i) {
            case 8:
                if (copyOnWriteArrayListI != null && copyOnWriteArrayListI.size() > 0) {
                    boolean z = (listH == null || listH.size() <= 0) ? false : !TextUtils.isEmpty(listH.get(0).getCMPTEntryUrl());
                    int nscpt = copyOnWriteArrayListI.get(0).getNscpt();
                    if (cVarN != null && cVarN.a(copyOnWriteArrayListI, z, nscpt)) {
                        if (hVarK != null && zS) {
                            hVarK.c(strL, strP, cVarA);
                            break;
                        }
                    } else if (hVarK != null && zS) {
                        com.mbridge.msdk.videocommon.a.a(strP);
                        com.mbridge.msdk.videocommon.a.a();
                        com.mbridge.msdk.foundation.error.b bVarA = com.mbridge.msdk.foundation.error.a.a(880010, "load timeout");
                        if (cVarA != null) {
                            cVarA.a(bVarA);
                        }
                        hVarK.a(bVarA, cVarA);
                        break;
                    }
                }
                break;
            case 9:
                if (interVideoOutListenerO != null && zS) {
                    if (zR) {
                        this.f5376a.a();
                    }
                    interVideoOutListenerO.onVideoLoadSuccess(mBridgeIdsG);
                    break;
                }
                break;
            case 16:
            case 18:
                if (interVideoOutListenerO != null && zS) {
                    String string = obj instanceof String ? obj.toString() : "";
                    if (cVarA != null && cVarA.p() != null) {
                        string = cVarA.p().g();
                    }
                    com.mbridge.msdk.videocommon.a.a(strP);
                    com.mbridge.msdk.videocommon.a.a();
                    if (zR) {
                        this.f5376a.a();
                    }
                    interVideoOutListenerO.onVideoLoadFail(mBridgeIdsG, string);
                    break;
                }
                break;
            case 17:
                if (interVideoOutListenerO != null && zS) {
                    if (zR) {
                        this.f5376a.a();
                    }
                    interVideoOutListenerO.onLoadSuccess(mBridgeIdsG);
                    break;
                }
                break;
            case 1001001:
                this.f5376a.a(false, d.b().a(0, zT ? 287 : 94, strP, true, 1));
                break;
            case 1001002:
                if (cVarN != null) {
                    if (!cVarN.l()) {
                        if (!cVarN.g(false)) {
                            if (cVarN.g(true)) {
                                if (!cVarN.l()) {
                                    cVarN.h(true);
                                } else if (hVarK != null) {
                                    cVarN.f(true);
                                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListH = cVarN.h();
                                    if (copyOnWriteArrayListH != null && copyOnWriteArrayListH.size() == 0) {
                                        copyOnWriteArrayListH = cVarN.f();
                                    }
                                    this.f5376a.a(copyOnWriteArrayListH);
                                    com.mbridge.msdk.foundation.same.report.metrics.c cVarA2 = this.f5376a.a(copyOnWriteArrayListH, cVarA);
                                    if (cVarA2 != null) {
                                        cVarA2.b(copyOnWriteArrayListH);
                                    }
                                    hVarK.d(strL, strP, cVarA2);
                                }
                            }
                        } else if (!cVarN.l()) {
                            cVarN.h(false);
                            if (cVarN.g(true)) {
                                if (!cVarN.l()) {
                                    cVarN.h(true);
                                } else if (hVarK != null) {
                                    cVarN.f(true);
                                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListH2 = cVarN.h();
                                    if (copyOnWriteArrayListH2 != null && copyOnWriteArrayListH2.size() == 0) {
                                        copyOnWriteArrayListH2 = cVarN.f();
                                    }
                                    this.f5376a.a(copyOnWriteArrayListH2);
                                    com.mbridge.msdk.foundation.same.report.metrics.c cVarA3 = this.f5376a.a(copyOnWriteArrayListH2, cVarA);
                                    if (cVarA3 != null) {
                                        cVarA3.b(copyOnWriteArrayListH2);
                                    }
                                    hVarK.d(strL, strP, cVarA3);
                                }
                            }
                        } else if (hVarK != null) {
                            cVarN.f(false);
                            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListH3 = cVarN.h();
                            if (copyOnWriteArrayListH3 != null && copyOnWriteArrayListH3.size() == 0) {
                                copyOnWriteArrayListH3 = cVarN.f();
                            }
                            this.f5376a.a(copyOnWriteArrayListH3);
                            com.mbridge.msdk.foundation.same.report.metrics.c cVarA4 = this.f5376a.a(copyOnWriteArrayListH3, cVarA);
                            if (cVarA4 != null) {
                                cVarA4.b(copyOnWriteArrayListH3);
                            }
                            hVarK.d(strL, strP, cVarA4);
                        }
                    } else if (hVarK != null) {
                        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListH4 = cVarN.h();
                        if (copyOnWriteArrayListH4 != null && copyOnWriteArrayListH4.size() == 0) {
                            copyOnWriteArrayListH4 = cVarN.f();
                        }
                        this.f5376a.a(copyOnWriteArrayListH4);
                        com.mbridge.msdk.foundation.same.report.metrics.c cVarA5 = this.f5376a.a(copyOnWriteArrayListH4, cVarA);
                        if (cVarA5 != null) {
                            cVarA5.b(copyOnWriteArrayListH4);
                        }
                        hVarK.d(strL, strP, cVarA5);
                    }
                }
                break;
        }
    }
}
