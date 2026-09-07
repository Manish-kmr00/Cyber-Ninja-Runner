package com.inmobi.unifiedId;

import android.content.Context;
import com.adjust.sdk.Constants;
import com.inmobi.ads.exceptions.SdkNotInitializedException;
import com.inmobi.commons.core.configs.SignalsConfig;
import com.inmobi.media.AbstractC3296a5;
import com.inmobi.media.AbstractC3588uc;
import com.inmobi.media.AbstractC3616wc;
import com.inmobi.media.B4;
import com.inmobi.media.C3324c4;
import com.inmobi.media.C3517pb;
import com.inmobi.media.C3532qc;
import com.inmobi.media.C3578u2;
import com.inmobi.media.I9;
import com.inmobi.media.J5;
import com.inmobi.media.K5;
import com.inmobi.media.Ob;
import com.inmobi.media.Sb;
import com.yandex.div.core.timer.TimerController;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/inmobi/unifiedId/InMobiUnifiedIdService;", "", "Lcom/inmobi/unifiedId/InMobiUserDataModel;", "inMobiUserDataModel", "", Constants.PUSH, "(Lcom/inmobi/unifiedId/InMobiUserDataModel;)V", "Lcom/inmobi/unifiedId/InMobiUnifiedIdInterface;", "inMobiUnifiedIdInterface", "fetchUnifiedIds", "(Lcom/inmobi/unifiedId/InMobiUnifiedIdInterface;)V", "fetchUnifiedIdsInternal$media_release", "fetchUnifiedIdsInternal", TimerController.RESET_COMMAND, "()V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPushCalled", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isPushCalled$annotations", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InMobiUnifiedIdService {
    public static final InMobiUnifiedIdService INSTANCE = new InMobiUnifiedIdService();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f3499a = new AtomicBoolean();

    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    /* JADX WARN: Code duplicated, block: B:33:0x0067  */
    /* JADX WARN: Code duplicated, block: B:36:0x0072  */
    /* JADX WARN: Code duplicated, block: B:37:0x0076  */
    /* JADX WARN: Code duplicated, block: B:39:0x007c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0085 A[Catch: JSONException -> 0x0098, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0098, blocks: (B:41:0x007f, B:43:0x0085), top: B:62:0x007f }] */
    /* JADX WARN: Code duplicated, block: B:45:0x008a  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:56:0x00af  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:62:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:? A[RETURN, SYNTHETIC] */
    public static final void a(InMobiUnifiedIdInterface inMobiUnifiedIdInterface) {
        JSONArray jSONArray;
        Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
        JSONObject ufids = AbstractC3296a5.b();
        if (ufids != null) {
            try {
                JSONArray jSONArray2 = ufids.has("ufids") ? ufids.getJSONArray("ufids") : null;
                if (jSONArray2 != null && jSONArray2.length() != 0 && ufids != null) {
                    Intrinsics.checkNotNullParameter(ufids, "ufids");
                    boolean z = true;
                    try {
                        if (ufids.has("ufids")) {
                            JSONArray jSONArray3 = ufids.getJSONArray("ufids");
                            int length = jSONArray3.length();
                            boolean z2 = true;
                            for (int i = 0; i < length; i++) {
                                try {
                                    z2 &= System.currentTimeMillis() <= jSONArray3.getJSONObject(i).getLong("expiry");
                                } catch (JSONException unused) {
                                    z = z2;
                                    Objects.toString(ufids);
                                    if (!z) {
                                        JSONObject jSONObject = AbstractC3588uc.f3447a;
                                        if (inMobiUnifiedIdInterface != null) {
                                            AbstractC3588uc.b.add(inMobiUnifiedIdInterface);
                                        }
                                        if (AbstractC3588uc.b()) {
                                            Objects.toString(inMobiUnifiedIdInterface);
                                            return;
                                        } else {
                                            AbstractC3588uc.d();
                                            return;
                                        }
                                    }
                                    if (inMobiUnifiedIdInterface != null) {
                                        if (ufids != null) {
                                            try {
                                                if (ufids.has("ufids")) {
                                                    jSONArray = ufids.getJSONArray("ufids");
                                                } else {
                                                    jSONArray = null;
                                                }
                                                if (jSONArray != null) {
                                                    AbstractC3616wc.a(inMobiUnifiedIdInterface, ufids, null);
                                                    return;
                                                }
                                            } catch (JSONException unused2) {
                                            }
                                        }
                                        if (f3499a.get()) {
                                            AbstractC3616wc.a(inMobiUnifiedIdInterface, null, new Error(InMobiUnifiedIdInterface.PUSH_NEEDS_TO_BE_CALLED_FIRST));
                                            return;
                                        }
                                        AbstractC3588uc.b.add(inMobiUnifiedIdInterface);
                                        if (AbstractC3588uc.b()) {
                                            Objects.toString(inMobiUnifiedIdInterface);
                                        } else {
                                            AbstractC3588uc.d();
                                        }
                                    }
                                }
                            }
                            z = z2;
                        }
                    } catch (JSONException unused3) {
                    }
                    if (!z) {
                        JSONObject jSONObject2 = AbstractC3588uc.f3447a;
                        if (inMobiUnifiedIdInterface != null) {
                            AbstractC3588uc.b.add(inMobiUnifiedIdInterface);
                        }
                        if (AbstractC3588uc.b()) {
                            Objects.toString(inMobiUnifiedIdInterface);
                            return;
                        } else {
                            AbstractC3588uc.d();
                            return;
                        }
                    }
                }
            } catch (JSONException unused4) {
            }
        }
        if (inMobiUnifiedIdInterface != null) {
            if (ufids != null) {
                if (ufids.has("ufids")) {
                    jSONArray = ufids.getJSONArray("ufids");
                } else {
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() != 0) {
                    AbstractC3616wc.a(inMobiUnifiedIdInterface, ufids, null);
                    return;
                }
            }
            if (f3499a.get()) {
                AbstractC3616wc.a(inMobiUnifiedIdInterface, null, new Error(InMobiUnifiedIdInterface.PUSH_NEEDS_TO_BE_CALLED_FIRST));
                return;
            }
            AbstractC3588uc.b.add(inMobiUnifiedIdInterface);
            if (AbstractC3588uc.b()) {
                Objects.toString(inMobiUnifiedIdInterface);
            } else {
                AbstractC3588uc.d();
            }
        }
    }

    public static final void b(InMobiUnifiedIdInterface inMobiUnifiedIdInterface) {
        fetchUnifiedIdsInternal$media_release(inMobiUnifiedIdInterface);
    }

    @JvmStatic
    public static final void fetchUnifiedIds(final InMobiUnifiedIdInterface inMobiUnifiedIdInterface) {
        Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
        if (C3517pb.q()) {
            C3517pb.a(new Runnable() { // from class: com.inmobi.unifiedId.InMobiUnifiedIdService$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    InMobiUnifiedIdService.b(inMobiUnifiedIdInterface);
                }
            });
        } else {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            throw new SdkNotInitializedException("InMobiUnifiedIdService");
        }
    }

    @JvmStatic
    public static final void fetchUnifiedIdsInternal$media_release(InMobiUnifiedIdInterface inMobiUnifiedIdInterface) {
        boolean zBooleanValue;
        Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
        HashMap map = new HashMap();
        Ob ob = Ob.f3160a;
        Ob.b("FetchApiInvoked", map, Sb.SDK);
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        boolean enabled = ((SignalsConfig) B4.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getUnifiedIdServiceConfig().getEnabled();
        if (!enabled) {
            reset();
        }
        if (!enabled) {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            AbstractC3616wc.a(inMobiUnifiedIdInterface, null, new Error(InMobiUnifiedIdInterface.UNIFIED_SERVICE_IS_NOT_ENABLED));
            return;
        }
        Boolean boolC = C3532qc.f3412a.c();
        boolean zBooleanValue2 = boolC != null ? boolC.booleanValue() : true;
        if (zBooleanValue2) {
            reset();
        }
        if (zBooleanValue2) {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            AbstractC3616wc.a(inMobiUnifiedIdInterface, null, new Error(InMobiUnifiedIdInterface.USER_HAS_OPTED_OUT));
            return;
        }
        Boolean bool = I9.b;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            Context contextD = C3517pb.d();
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                K5 k5A = J5.a(contextD, "user_info_store");
                Intrinsics.checkNotNullParameter("user_age_restricted", "key");
                I9.b = Boolean.valueOf(k5A.f3112a.getBoolean("user_age_restricted", false));
            }
            Boolean bool2 = I9.b;
            zBooleanValue = bool2 != null ? bool2.booleanValue() : false;
        }
        if (zBooleanValue) {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            AbstractC3616wc.a(inMobiUnifiedIdInterface, null, new Error(InMobiUnifiedIdInterface.USER_HAS_AGE_RESTRICTION));
            return;
        }
        synchronized (AbstractC3588uc.class) {
            if (AbstractC3588uc.b()) {
                if (inMobiUnifiedIdInterface != null) {
                    AbstractC3588uc.b.add(inMobiUnifiedIdInterface);
                }
                if (AbstractC3588uc.b()) {
                    Objects.toString(inMobiUnifiedIdInterface);
                } else {
                    AbstractC3588uc.d();
                }
            } else {
                a(inMobiUnifiedIdInterface);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void isPushCalled$annotations() {
    }

    @JvmStatic
    public static final void push(final InMobiUserDataModel inMobiUserDataModel) {
        Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
        Objects.toString(inMobiUserDataModel);
        if (C3517pb.q()) {
            C3517pb.a(new Runnable() { // from class: com.inmobi.unifiedId.InMobiUnifiedIdService$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    InMobiUnifiedIdService.a(inMobiUserDataModel);
                }
            });
        } else {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            throw new SdkNotInitializedException("InMobiUnifiedIdService");
        }
    }

    @JvmStatic
    public static final void reset() {
        Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
        if (C3517pb.q()) {
            C3517pb.a(new Runnable() { // from class: com.inmobi.unifiedId.InMobiUnifiedIdService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    InMobiUnifiedIdService.a();
                }
            });
        } else {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            throw new SdkNotInitializedException("InMobiUnifiedIdService");
        }
    }

    public final AtomicBoolean isPushCalled() {
        return f3499a;
    }

    public static final void a(InMobiUserDataModel inMobiUserDataModel) {
        boolean zBooleanValue;
        InMobiUserDataModel inMobiUserDataModel2;
        Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
        Objects.toString(inMobiUserDataModel);
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        boolean enabled = ((SignalsConfig) B4.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getUnifiedIdServiceConfig().getEnabled();
        if (!enabled) {
            reset();
        }
        if (!enabled) {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            return;
        }
        Boolean boolC = C3532qc.f3412a.c();
        boolean zBooleanValue2 = boolC != null ? boolC.booleanValue() : true;
        if (zBooleanValue2) {
            reset();
        }
        if (zBooleanValue2) {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            return;
        }
        Boolean bool = I9.b;
        boolean zAreEqual = false;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            Context contextD = C3517pb.d();
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                K5 k5A = J5.a(contextD, "user_info_store");
                Intrinsics.checkNotNullParameter("user_age_restricted", "key");
                I9.b = Boolean.valueOf(k5A.f3112a.getBoolean("user_age_restricted", false));
            }
            Boolean bool2 = I9.b;
            zBooleanValue = bool2 != null ? bool2.booleanValue() : false;
        }
        if (zBooleanValue) {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            return;
        }
        InMobiUserDataModel inMobiUserDataModel3 = C3324c4.f3281a;
        if (inMobiUserDataModel == null && C3324c4.f3281a == null) {
            zAreEqual = true;
        } else if (inMobiUserDataModel != null && (inMobiUserDataModel2 = C3324c4.f3281a) != null) {
            zAreEqual = Intrinsics.areEqual(inMobiUserDataModel, inMobiUserDataModel2);
        }
        if (zAreEqual && f3499a.get()) {
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
            return;
        }
        synchronized (C3324c4.class) {
            Objects.toString(C3324c4.f3281a);
            Objects.toString(inMobiUserDataModel);
            C3324c4.f3281a = inMobiUserDataModel;
        }
        f3499a.set(true);
        AbstractC3588uc.c();
    }

    public static final void a() {
        Intrinsics.checkNotNullExpressionValue("InMobiUnifiedIdService", "TAG");
        f3499a.set(false);
        synchronized (C3324c4.class) {
            Objects.toString(C3324c4.f3281a);
            C3324c4.f3281a = null;
        }
        AbstractC3588uc.e();
        AbstractC3296a5.b(null);
        AbstractC3296a5.a(null);
        AbstractC3296a5.d = false;
        AbstractC3296a5.c = false;
    }
}
