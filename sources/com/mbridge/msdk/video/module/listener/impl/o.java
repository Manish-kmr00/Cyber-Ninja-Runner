package com.mbridge.msdk.video.module.listener.impl;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import java.util.Map;

/* JADX INFO: compiled from: VideoViewStatisticsListener.java */
/* JADX INFO: loaded from: classes12.dex */
public class o extends k {
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    protected int t;
    private Map<Integer, String> u;
    private MBridgeVideoView.u v;
    private int w;

    /* JADX INFO: compiled from: VideoViewStatisticsListener.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5850a;

        a(Object obj) {
            this.f5850a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f5850a;
            if (obj instanceof String) {
                o.this.b((String) obj);
            }
        }
    }

    public o(CampaignEx campaignEx, com.mbridge.msdk.videocommon.entity.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, com.mbridge.msdk.video.module.listener.a aVar2, int i, boolean z) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i, z);
        this.s = false;
        this.t = 0;
        this.w = -1;
        if (this.f5843a) {
            this.u = campaignEx.getAdvImpList();
        }
        this.t = campaignEx.getVideoCompleteTime();
    }

    /* JADX WARN: Code duplicated, block: B:75:0x0148 A[Catch: all -> 0x0168, TryCatch #0 {all -> 0x0168, blocks: (B:18:0x0026, B:19:0x002e, B:21:0x003d, B:23:0x0048, B:22:0x0045, B:24:0x0059, B:80:0x0162, B:25:0x0061, B:27:0x0074, B:29:0x0078, B:31:0x007e, B:33:0x0083, B:35:0x0087, B:38:0x0098, B:40:0x009c, B:41:0x00a0, B:43:0x00bc, B:44:0x00c5, B:46:0x00c9, B:51:0x00d1, B:52:0x00d5, B:53:0x00e9, B:56:0x00ef, B:58:0x00f3, B:60:0x00fc, B:62:0x0100, B:64:0x0112, B:66:0x0116, B:67:0x0126, B:69:0x012a, B:70:0x0134, B:72:0x013e, B:74:0x0142, B:75:0x0148, B:77:0x014c, B:79:0x0150), top: B:85:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x014c A[Catch: all -> 0x0168, TryCatch #0 {all -> 0x0168, blocks: (B:18:0x0026, B:19:0x002e, B:21:0x003d, B:23:0x0048, B:22:0x0045, B:24:0x0059, B:80:0x0162, B:25:0x0061, B:27:0x0074, B:29:0x0078, B:31:0x007e, B:33:0x0083, B:35:0x0087, B:38:0x0098, B:40:0x009c, B:41:0x00a0, B:43:0x00bc, B:44:0x00c5, B:46:0x00c9, B:51:0x00d1, B:52:0x00d5, B:53:0x00e9, B:56:0x00ef, B:58:0x00f3, B:60:0x00fc, B:62:0x0100, B:64:0x0112, B:66:0x0116, B:67:0x0126, B:69:0x012a, B:70:0x0134, B:72:0x013e, B:74:0x0142, B:75:0x0148, B:77:0x014c, B:79:0x0150), top: B:85:0x0006 }] */
    @Override // com.mbridge.msdk.video.module.listener.impl.k, com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i, Object obj) {
        int i2;
        CampaignEx campaignEx;
        try {
            if (i != 2) {
                int videoLength = 0;
                if (i != 20) {
                    if (i != 130) {
                        if (i == 6) {
                            if (this.f5843a && !this.p) {
                                this.p = true;
                                l();
                                com.mbridge.msdk.video.module.report.b.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.b);
                            }
                        } else if (i != 7) {
                            if (i == 15) {
                                j();
                                h();
                                i();
                                if (q0.a().a("i_l_s_t_r_i", false) && !this.q) {
                                    this.q = true;
                                    MBridgeVideoView.u uVar = this.v;
                                    if (uVar != null) {
                                        uVar.a();
                                    }
                                }
                                if (obj == null || !(obj instanceof MBridgeVideoView.v)) {
                                    i2 = 0;
                                } else {
                                    int i3 = ((MBridgeVideoView.v) obj).f5837a;
                                    videoLength = ((MBridgeVideoView.v) obj).b;
                                    i2 = i3;
                                }
                                if (videoLength == 0 && (campaignEx = this.b) != null) {
                                    videoLength = campaignEx.getVideoLength();
                                }
                                com.mbridge.msdk.video.module.report.b.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, i2, videoLength, this.j);
                                com.mbridge.msdk.video.module.report.b.a(this.b, this.u, this.g, i2);
                                if (!this.r) {
                                    this.r = true;
                                    com.mbridge.msdk.video.module.report.b.a(this.b, this.g);
                                }
                                if (!this.s) {
                                    int i4 = this.t;
                                    if (i4 != 0) {
                                        videoLength = i4;
                                    }
                                    if (i2 >= videoLength) {
                                        this.s = true;
                                        i = 17;
                                    }
                                }
                                o0.b("NotifyListener", "onPlayProgress:" + i2);
                                this.w = i2;
                            } else if (i != 16) {
                                switch (i) {
                                    case 11:
                                        a();
                                        l();
                                        break;
                                    case 12:
                                        a aVar = new a(obj);
                                        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
                                            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(aVar);
                                        } else {
                                            aVar.run();
                                        }
                                        l();
                                        c();
                                        b();
                                        e();
                                        a();
                                        break;
                                    case 13:
                                        c();
                                        b();
                                        break;
                                }
                            } else if (this.f5843a) {
                                this.p = true;
                                l();
                                com.mbridge.msdk.video.module.report.b.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.b);
                            }
                        } else if (this.f5843a && obj != null && (obj instanceof Integer)) {
                            int iIntValue = ((Integer) obj).intValue();
                            if (iIntValue == 2) {
                                if (!this.o) {
                                    this.o = true;
                                    com.mbridge.msdk.video.module.report.b.e(com.mbridge.msdk.foundation.controller.c.m().d(), this.b);
                                }
                            } else if (iIntValue == 1 && !this.n) {
                                this.n = true;
                                com.mbridge.msdk.video.module.report.b.f(com.mbridge.msdk.foundation.controller.c.m().d(), this.b);
                            }
                        }
                    } else if (obj instanceof Integer) {
                        this.t = ((Integer) obj).intValue();
                    }
                } else if (q0.a().a("i_l_s_t_r_i", false) && (obj instanceof MBridgeVideoView.u)) {
                    this.v = (MBridgeVideoView.u) obj;
                }
            } else if (this.f5843a) {
                this.p = true;
                l();
                com.mbridge.msdk.video.module.report.b.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.b);
            }
            this.i.a(i, obj);
        } catch (Throwable th) {
            o0.b("NotifyListener", th.getMessage(), th);
        }
    }
}
