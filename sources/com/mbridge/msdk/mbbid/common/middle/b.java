package com.mbridge.msdk.mbbid.common.middle;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.utils.d;
import com.mbridge.msdk.foundation.same.net.wrapper.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.mbbid.out.BidListennning;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.reflect.Method;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: compiled from: RequesManager.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5177a;
    private String b;
    private String c;
    private BidListennning e;
    private BidResponsedEx f;
    private int g;
    private long i;
    private long j;
    private boolean k;
    private int l;
    private boolean h = false;
    private Context d = com.mbridge.msdk.foundation.controller.c.m().d();

    public b(String str, String str2, String str3) {
        this.f5177a = str;
        this.b = str2;
        this.c = str3;
    }

    public void b(boolean z) {
        this.k = z;
    }

    public void b(int i) {
        this.l = i;
    }

    /* JADX INFO: compiled from: RequesManager.java */
    class a extends com.mbridge.msdk.mbbid.common.middle.a {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2, String str3) {
            super(str, str2);
            this.b = str3;
        }

        @Override // com.mbridge.msdk.mbbid.common.net.c
        public void a(BidResponsedEx bidResponsedEx) {
            b.this.h = false;
            b.this.f = bidResponsedEx;
            com.mbridge.msdk.mbbid.common.report.a.a(b.this.d, b.this.b, bidResponsedEx.getBidId(), this.b, bidResponsedEx.getBidToken());
            b.this.a(bidResponsedEx);
        }

        @Override // com.mbridge.msdk.mbbid.common.net.c
        public void a(int i, String str) {
            b.this.h = false;
            com.mbridge.msdk.mbbid.common.report.a.a(b.this.d, b.this.b, str, this.b);
            b.this.a(str);
        }
    }

    public void b(long j) {
        this.j = j;
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(long j) {
        this.i = j;
    }

    public void a(boolean z) {
        try {
            if (!this.h) {
                this.h = true;
                if (this.d == null) {
                    a("context is null");
                }
                com.mbridge.msdk.mbbid.common.net.a aVar = new com.mbridge.msdk.mbbid.common.net.a(this.d);
                e eVar = new e();
                String strB = com.mbridge.msdk.foundation.controller.c.m().b();
                eVar.a("app_id", strB);
                eVar.a("sign", SameMD5.getMD5(strB + com.mbridge.msdk.foundation.controller.c.m().c()));
                eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.b);
                if (TextUtils.isEmpty(this.f5177a)) {
                    this.f5177a = "";
                }
                eVar.a(Reporting.Key.PLACEMENT_ID, this.f5177a);
                if (com.mbridge.msdk.util.b.a()) {
                    eVar.a("install_ids", c.a());
                }
                eVar.a("bid_floor", this.c);
                eVar.a(e.h, t0.a(this.d, this.b));
                eVar.a(e.g, com.mbridge.msdk.foundation.same.buffer.b.a(this.b, ""));
                String str = "1";
                eVar.a("req_type", this.k ? "1" : "2");
                eVar.a("orientation", k0.F(this.d) + "");
                int i = this.g;
                if (i == 296) {
                    if (this.i > 0 && this.j > 0) {
                        eVar.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_UNIT_SIZE, this.j + VastAttributes.HORIZONTAL_POSITION + this.i);
                        try {
                            int i2 = BannerUtils.f5165a;
                            Method method = BannerUtils.class.getMethod("getCloseIds", String.class);
                            if (method.invoke(null, this.b) instanceof String) {
                                eVar.a("close_id", method.invoke(null, this.b).toString());
                            }
                        } catch (Exception unused) {
                            a("banner module is miss");
                            return;
                        }
                    } else {
                        a("bid required param is missing or error");
                        return;
                    }
                } else if (i == 297) {
                    if (this.i > 0 && this.j > 0) {
                        eVar.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_UNIT_SIZE, this.j + VastAttributes.HORIZONTAL_POSITION + this.i);
                        eVar.a("orientation", this.l + "");
                    } else {
                        a("ad display area is too small");
                        return;
                    }
                } else if (i != 298) {
                    if (!z) {
                        str = "0";
                    }
                    eVar.a("rw_plus", str);
                } else if (this.i > 0 && this.j > 0) {
                    eVar.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_UNIT_SIZE, this.j + VastAttributes.HORIZONTAL_POSITION + this.i);
                } else {
                    a("bid required param is missing or error");
                    return;
                }
                String md5 = SameMD5.getMD5(t0.d());
                eVar.a(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md5);
                a aVar2 = new a(this.f5177a, this.b, md5);
                aVar2.setUnitId(this.b);
                aVar2.setPlacementId(this.f5177a);
                aVar.get(1, d.h().a(false, ""), eVar, aVar2, "bid_request", 30000L);
                return;
            }
            a("current unit is biding");
        } catch (Throwable th) {
            a(th.getMessage());
        }
    }

    public void a(BidListennning bidListennning) {
        this.e = bidListennning;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        BidListennning bidListennning = this.e;
        if (bidListennning != null) {
            bidListennning.onFailed(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BidResponsed bidResponsed) {
        BidListennning bidListennning = this.e;
        if (bidListennning != null) {
            bidListennning.onSuccessed(bidResponsed);
        }
    }
}
