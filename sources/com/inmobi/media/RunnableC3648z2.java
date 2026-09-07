package com.inmobi.media;

import android.os.Message;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.z2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class RunnableC3648z2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandlerC3494o2 f3493a;
    public final A2 b;
    public final A2 c;

    public RunnableC3648z2(HandlerC3494o2 callback, A2 request, A2 a2) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(request, "request");
        this.f3493a = callback;
        this.b = request;
        this.c = a2;
    }

    public final boolean a(A2 a2, int i, LinkedHashMap linkedHashMap) throws InterruptedException {
        if (i <= a2.z) {
            Thread.sleep(a2.A * 1000);
            return false;
        }
        Iterator it = a2.y.entrySet().iterator();
        while (it.hasNext()) {
            C2 response = (C2) linkedHashMap.get((String) ((Map.Entry) it.next()).getKey());
            if (response != null) {
                HandlerC3494o2 handlerC3494o2 = this.f3493a;
                Intrinsics.checkNotNullParameter(response, "response");
                Message messageObtain = Message.obtain();
                messageObtain.what = 6;
                messageObtain.obj = response;
                handlerC3494o2.sendMessage(messageObtain);
            }
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (InterruptedException unused) {
            Intrinsics.checkNotNullExpressionValue("z2", "TAG");
        }
    }

    public final void a() {
        LinkedHashMap linkedHashMap;
        List list;
        String str;
        A2 mRequest;
        int i = 0;
        int i2 = 0;
        do {
            A2 mRequest2 = this.b;
            if (i2 > mRequest2.z) {
                break;
            }
            Intrinsics.checkNotNullParameter(mRequest2, "mRequest");
            G2 g2 = new G2(mRequest2, mRequest2.b());
            linkedHashMap = g2.c;
            if (g2.a() && (mRequest = this.c) != null) {
                while (i <= mRequest.z) {
                    Intrinsics.checkNotNullParameter(mRequest, "mRequest");
                    G2 g3 = new G2(mRequest, mRequest.b());
                    LinkedHashMap linkedHashMap2 = g3.c;
                    if (!g3.a()) {
                        a(mRequest, linkedHashMap2);
                        if (mRequest.y.isEmpty()) {
                            break;
                        }
                        i++;
                        if (a(mRequest, i, linkedHashMap2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                HandlerC3494o2 handlerC3494o2 = this.f3493a;
                String accountId = mRequest.B;
                Intrinsics.checkNotNullParameter(accountId, "accountId");
                Message messageObtain = Message.obtain();
                messageObtain.what = 4;
                messageObtain.obj = accountId;
                handlerC3494o2.sendMessage(messageObtain);
                return;
            }
            if (this.b.C) {
                HandlerC3494o2 handlerC3494o3 = this.f3493a;
                Map map = g2.f3076a.e;
                Object ipAddress = (map == null || (list = (List) map.get("cip")) == null || (str = (String) CollectionsKt.firstOrNull(list)) == null) ? D2.f3046a : new E2(str);
                Intrinsics.checkNotNullParameter(ipAddress, "ipAddress");
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 7;
                messageObtain2.obj = ipAddress;
                handlerC3494o3.sendMessage(messageObtain2);
            }
            a(this.b, linkedHashMap);
            if (this.b.y.isEmpty()) {
                break;
            } else {
                i2++;
            }
        } while (!a(this.b, i2, linkedHashMap));
        HandlerC3494o2 handlerC3494o4 = this.f3493a;
        String accountId2 = this.b.B;
        Intrinsics.checkNotNullParameter(accountId2, "accountId");
        Message messageObtain3 = Message.obtain();
        messageObtain3.what = 4;
        messageObtain3.obj = accountId2;
        handlerC3494o4.sendMessage(messageObtain3);
    }

    public final void a(A2 a2, LinkedHashMap linkedHashMap) {
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            C2 response = (C2) entry.getValue();
            String configType = (String) entry.getKey();
            if (response.c == null) {
                HandlerC3494o2 handlerC3494o2 = this.f3493a;
                Intrinsics.checkNotNullParameter(response, "response");
                Message messageObtain = Message.obtain();
                messageObtain.what = 6;
                messageObtain.obj = response;
                handlerC3494o2.sendMessage(messageObtain);
                a2.getClass();
                Intrinsics.checkNotNullParameter(configType, "configType");
                a2.y.remove(configType);
            }
        }
    }
}
