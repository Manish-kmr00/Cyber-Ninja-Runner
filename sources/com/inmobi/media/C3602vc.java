package com.inmobi.media;

import com.inmobi.unifiedId.InMobiUnifiedIdInterface;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.vc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3602vc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3644yc f3461a;
    public final LinkedHashSet b;

    public C3602vc(C3644yc networkRequest, LinkedHashSet inMobiUnifiedIdInterfaceSet) {
        Intrinsics.checkNotNullParameter(networkRequest, "networkRequest");
        Intrinsics.checkNotNullParameter(inMobiUnifiedIdInterfaceSet, "inMobiUnifiedIdInterfaceSet");
        this.f3461a = networkRequest;
        this.b = inMobiUnifiedIdInterfaceSet;
    }

    public final void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        synchronized (AbstractC3588uc.class) {
            if (this.f3461a.A.get()) {
                return;
            }
            AbstractC3588uc.a();
            AbstractC3296a5.b(AbstractC3616wc.a(jSONObject, AbstractC3296a5.b()));
            JSONObject jSONObjectA = AbstractC3616wc.a(AbstractC3296a5.b());
            for (InMobiUnifiedIdInterface inMobiUnifiedIdInterface : this.b) {
                if (jSONObjectA == null) {
                    AbstractC3616wc.a(inMobiUnifiedIdInterface, null, new Error(InMobiUnifiedIdInterface.NO_LOCAL_DATA_PRESENT));
                } else {
                    AbstractC3616wc.a(inMobiUnifiedIdInterface, jSONObjectA, null);
                }
            }
            this.b.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(P8 p8) {
        I3 i3;
        synchronized (AbstractC3588uc.class) {
            if (p8 != null) {
                try {
                    i3 = p8.f3168a;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                i3 = null;
            }
            Objects.toString(i3);
            Objects.toString(p8 != null ? p8.f3168a : null);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (p8 != null) {
                linkedHashMap.put("errorCode", p8.f3168a);
            }
            Ob ob = Ob.f3160a;
            Ob.b("UnifiedIdNetworkResponseFailure", linkedHashMap, Sb.SDK);
            if (this.f3461a.A.get()) {
                return;
            }
            AbstractC3588uc.a();
            a();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0033 A[Catch: all -> 0x0050, JSONException -> 0x0052, Merged into TryCatch #0 {all -> 0x0050, JSONException -> 0x0052, blocks: (B:4:0x000d, B:6:0x0013, B:8:0x001d, B:9:0x0023, B:11:0x0029, B:12:0x0033, B:13:0x0039, B:15:0x003f, B:20:0x0053), top: B:25:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:15:0x003f A[Catch: all -> 0x0050, JSONException -> 0x0052, LOOP:0: B:13:0x0039->B:15:0x003f, LOOP_END, Merged into TryCatch #0 {all -> 0x0050, JSONException -> 0x0052, blocks: (B:4:0x000d, B:6:0x0013, B:8:0x001d, B:9:0x0023, B:11:0x0029, B:12:0x0033, B:13:0x0039, B:15:0x003f, B:20:0x0053), top: B:25:0x000b }, TRY_LEAVE] */
    public final void a() {
        Iterator it;
        JSONObject jSONObjectA = AbstractC3616wc.a(AbstractC3296a5.b());
        try {
            if (jSONObjectA != null) {
                if (jSONObjectA.has("ufids") && jSONObjectA.getJSONArray("ufids").length() > 0) {
                    Iterator it2 = this.b.iterator();
                    while (it2.hasNext()) {
                        AbstractC3616wc.a((InMobiUnifiedIdInterface) it2.next(), jSONObjectA, null);
                    }
                } else {
                    it = this.b.iterator();
                    while (it.hasNext()) {
                        AbstractC3616wc.a((InMobiUnifiedIdInterface) it.next(), null, new Error(InMobiUnifiedIdInterface.NETWORK_FAILURE_AND_NO_LOCAL_DATA_PRESENT));
                    }
                }
            } else {
                it = this.b.iterator();
                while (it.hasNext()) {
                    AbstractC3616wc.a((InMobiUnifiedIdInterface) it.next(), null, new Error(InMobiUnifiedIdInterface.NETWORK_FAILURE_AND_NO_LOCAL_DATA_PRESENT));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            this.b.clear();
        }
    }
}
