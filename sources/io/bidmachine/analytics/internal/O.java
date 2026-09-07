package io.bidmachine.analytics.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
public final class O extends AbstractC4629e {
    public static final a k = new a(null);
    private d i;
    private final String h = "mimp";
    private final Lazy j = LazyKt.lazy(e.f12057a);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class b implements AppLovinCommunicatorSubscriber {
        @Override // com.applovin.communicator.AppLovinCommunicatorEntity
        public String getCommunicatorId() {
            return "";
        }

        @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
        public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        }
    }

    private static final class c implements AppLovinCommunicatorSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InterfaceC4630f f12054a;
        private final Lazy b = LazyKt.lazy(a.f12055a);

        static final class a extends Lambda implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f12055a = new a();

            a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return UUID.randomUUID().toString();
            }
        }

        public c(InterfaceC4630f interfaceC4630f) {
            this.f12054a = interfaceC4630f;
        }

        private final String a() {
            return (String) this.b.getValue();
        }

        @Override // com.applovin.communicator.AppLovinCommunicatorEntity
        public String getCommunicatorId() {
            return a();
        }

        @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
        public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
            Object q0Var;
            try {
                Result.Companion companion = Result.INSTANCE;
                if (appLovinCommunicatorMessage != null && Intrinsics.areEqual("max_revenue_events", appLovinCommunicatorMessage.getTopic())) {
                    Bundle messageData = appLovinCommunicatorMessage.getMessageData();
                    if (messageData == null || messageData.size() <= 0) {
                        this.f12054a.a(new q0("mimp", q0.a.MONITOR_NO_CONTENT, null, 4, null));
                        return;
                    }
                    try {
                        this.f12054a.a(s0.a(messageData));
                        q0Var = Unit.INSTANCE;
                    } catch (Throwable th) {
                        q0Var = new q0("mimp", q0.a.MONITOR_BAD_CONTENT, s0.a(th));
                    }
                    Result.m7904constructorimpl(q0Var);
                }
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7904constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    public static final class d implements AppLovinBroadcastManager.Receiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile boolean f12056a;
        private volatile AppLovinCommunicatorSubscriber b;

        public final void a(boolean z) {
            this.f12056a = z;
        }

        @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
        public void onReceive(Intent intent, Map map) {
            AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber;
            if (this.f12056a && (intent instanceof AppLovinCommunicatorMessage) && (appLovinCommunicatorSubscriber = this.b) != null) {
                appLovinCommunicatorSubscriber.onMessageReceived((AppLovinCommunicatorMessage) intent);
            }
        }

        public final void a(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
            this.b = appLovinCommunicatorSubscriber;
        }
    }

    static final class e extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f12057a = new e();

        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return new b();
        }
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public String a() {
        return this.h;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4629e
    public AbstractC4629e.b b(Map map) {
        String string;
        Float fA = a0.a(map.get("revenue"));
        if (fA != null) {
            float fFloatValue = fA.floatValue();
            Object obj = map.get(BrandSafetyEvent.ad);
            if (obj != null && (string = obj.toString()) != null) {
                return new AbstractC4629e.b(0, fFloatValue, string, 1, null);
            }
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.bidmachine.analytics.internal.AbstractC4629e
    public AbstractC4629e.a c(Map map) {
        String string;
        String upperCase;
        Object obj = map.get("ad_format");
        if (obj == null || (string = obj.toString()) == null || (upperCase = string.toUpperCase(Locale.US)) == null) {
            return null;
        }
        switch (upperCase.hashCode()) {
            case -2053424887:
                if (!upperCase.equals(BrandSafetyUtils.n)) {
                    return null;
                }
                return AbstractC4629e.a.BANNER;
            case -1999289321:
                if (upperCase.equals("NATIVE")) {
                    return AbstractC4629e.a.NATIVE;
                }
                return null;
            case -1372958932:
                if (!upperCase.equals("INTERSTITIAL")) {
                    return null;
                }
                return AbstractC4629e.a.INTERSTITIAL;
            case 2374915:
                if (!upperCase.equals(BrandSafetyUtils.o)) {
                    return null;
                }
                return AbstractC4629e.a.BANNER;
            case 69823676:
                if (!upperCase.equals(BrandSafetyUtils.j)) {
                    return null;
                }
                return AbstractC4629e.a.INTERSTITIAL;
            case 543046670:
                if (!upperCase.equals(BrandSafetyUtils.k)) {
                    return null;
                }
                return AbstractC4629e.a.REWARDED;
            case 1854800829:
                if (!upperCase.equals("REWARDED_INTERSTITIAL")) {
                    return null;
                }
                return AbstractC4629e.a.REWARDED;
            case 1951953708:
                if (!upperCase.equals("BANNER")) {
                    return null;
                }
                return AbstractC4629e.a.BANNER;
            default:
                return null;
        }
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public void d(Context context) {
        d dVar = new d();
        AppLovinBroadcastManager.registerReceiver(dVar, new IntentFilter("max_revenue_events"));
        this.i = dVar;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public void e(Context context) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a(false);
        }
        AppLovinCommunicator.getInstance(context).unsubscribe(c(), "max_revenue_events");
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4629e, io.bidmachine.analytics.internal.AbstractC4634j
    public void f(Context context) {
        super.f(context);
        d dVar = this.i;
        if (dVar != null) {
            dVar.a(true);
        }
        AppLovinCommunicator.getInstance(context).subscribe(c(), "max_revenue_events");
    }

    private final AppLovinCommunicatorSubscriber c() {
        return (AppLovinCommunicatorSubscriber) this.j.getValue();
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    /* JADX INFO: renamed from: a */
    public void b(AbstractC4631g.a aVar) {
        super.b(aVar);
        d dVar = this.i;
        if (dVar == null) {
            return;
        }
        dVar.a(new c(this));
    }
}
