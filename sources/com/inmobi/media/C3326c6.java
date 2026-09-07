package com.inmobi.media;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.inmobi.ads.InMobiAdRequestStatus;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.c6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3326c6 extends AbstractC3518pc {
    public final byte[] d;
    public final long e;
    public final L4 f;
    public final WeakReference g;
    public short h;
    public String i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3326c6(C0 adUnit, C3343d9 oAManager, byte[] response, long j, L4 l4) {
        super(adUnit, (byte) 3);
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(oAManager, "oAManager");
        Intrinsics.checkNotNullParameter(response, "response");
        this.d = response;
        this.e = j;
        this.f = l4;
        this.g = new WeakReference(oAManager);
    }

    @Override // com.inmobi.media.AbstractC3518pc
    public final void a(Object obj) {
        C3418j0 c3418j0 = (C3418j0) obj;
        L4 l4 = this.f;
        if (l4 != null) {
            ((M4) l4).c("LoadWithResponseWorker", "onComplete");
        }
        C3343d9 c3343d9 = (C3343d9) this.g.get();
        if (c3343d9 == null) {
            L4 l5 = this.f;
            if (l5 != null) {
                ((M4) l5).b("LoadWithResponseWorker", "oAManager is null");
                return;
            }
            return;
        }
        if (c3418j0 != null) {
            L4 l6 = this.f;
            if (l6 != null) {
                ((M4) l6).c("LoadWithResponseWorker", "loading response");
            }
            c3343d9.f3294a.b(c3418j0);
            return;
        }
        short s = this.h;
        if (s != 0) {
            HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to("errorCode", Short.valueOf(s)));
            String str = this.i;
            if (str != null) {
                mapHashMapOf.put("reason", str);
            }
            c3343d9.f3294a.b((Map<String, Object>) mapHashMapOf);
        }
        c3343d9.f3294a.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
        L4 l7 = this.f;
        if (l7 != null) {
            ((M4) l7).b("LoadWithResponseWorker", "adSet null. fail with error code - " + ((int) this.h));
        }
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void c() {
        C0 c0;
        super.c();
        L4 l4 = this.f;
        if (l4 != null) {
            ((M4) l4).b("LoadWithResponseWorker", "Encountered OOM");
        }
        C3343d9 c3343d9 = (C3343d9) this.g.get();
        if (c3343d9 == null || (c0 = c3343d9.f3294a) == null) {
            return;
        }
        c0.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY), (short) 2146);
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void a() {
        L4 l4 = this.f;
        if (l4 != null) {
            ((M4) l4).c("LoadWithResponseWorker", "execute task start");
        }
        C3343d9 c3343d9 = (C3343d9) this.g.get();
        if (c3343d9 == null) {
            L4 l5 = this.f;
            if (l5 != null) {
                ((M4) l5).b("LoadWithResponseWorker", "OAManager null. failing.");
            }
            this.h = (short) 2142;
            b(null);
            return;
        }
        L4 l6 = this.f;
        if (l6 != null) {
            ((M4) l6).a("LoadWithResponseWorker", "getting network response from byte array");
        }
        byte[] value = this.d;
        Intrinsics.checkNotNullParameter(value, "response");
        T8 mResponse = new T8();
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.length == 0) {
            mResponse.b = new byte[0];
        } else {
            byte[] bArr = new byte[value.length];
            mResponse.b = bArr;
            System.arraycopy(value, 0, bArr, 0, value.length);
        }
        Intrinsics.checkNotNullParameter(mResponse, "mResponse");
        P8 p8 = mResponse.c;
        if (p8 != null) {
            switch (E.f3052a[p8.f3168a.ordinal()]) {
                case 1:
                    new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE);
                    break;
                case 2:
                    InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_INVALID);
                    P8 p9 = mResponse.c;
                    String str = p9 != null ? p9.b : null;
                    if (str != null) {
                        inMobiAdRequestStatus.setCustomMessage(str);
                    }
                    break;
                case 3:
                    new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_TIMED_OUT);
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.SERVER_ERROR);
                    break;
                case 9:
                    new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.GDPR_COMPLIANCE_ENFORCED);
                    break;
                default:
                    new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
                    break;
            }
        }
        try {
            L4 l7 = this.f;
            if (l7 != null) {
                ((M4) l7).a("LoadWithResponseWorker", "start parsing response");
            }
            JSONObject jsonResponse = new JSONObject(mResponse.a());
            long j = jsonResponse.getLong("placementId");
            if (this.e == j) {
                L4 l8 = this.f;
                if (l8 != null) {
                    ((M4) l8).e(SDKConstants.PARAM_PLACEMENT_ID, String.valueOf(j));
                }
                L4 l9 = this.f;
                if (l9 != null) {
                    ((M4) l9).a("LoadWithResponseWorker", "placement id match - success");
                }
                C3462m0 c3462m0P = c3343d9.f3294a.p();
                c3462m0P.getClass();
                Intrinsics.checkNotNullParameter(jsonResponse, "jsonResponse");
                b(c3462m0P.a(jsonResponse));
                return;
            }
            L4 l10 = this.f;
            if (l10 != null) {
                ((M4) l10).b("LoadWithResponseWorker", "Placement Id of Request and response doesn't match");
            }
            this.h = (short) 2144;
            throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), this.h);
        } catch (C3603w e) {
            this.h = e.b;
            L4 l11 = this.f;
            if (l11 != null) {
                String strE = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
                ((M4) l11).a(strE, "Exception while parsing OAResponse", e);
            }
            b(null);
        } catch (JSONException e2) {
            this.h = (short) 2145;
            this.i = e2.getMessage();
            L4 l12 = this.f;
            if (l12 != null) {
                String strE2 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE2, "<get-TAG>(...)");
                ((M4) l12).a(strE2, "Exception while parsing OAResponse", e2);
            }
            b(null);
        }
    }
}
