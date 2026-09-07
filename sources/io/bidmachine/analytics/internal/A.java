package io.bidmachine.analytics.internal;

import android.content.Context;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.impressionData.ImpressionDataListener;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class A extends AbstractC4629e {
    public static final a j = new a(null);
    private final String h = "isimp";
    private b i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements ImpressionDataListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InterfaceC4630f f12041a;

        public b(InterfaceC4630f interfaceC4630f) {
            this.f12041a = interfaceC4630f;
        }

        @Override // com.json.mediationsdk.impressionData.ImpressionDataListener
        public void onImpressionSuccess(ImpressionData impressionData) {
            if (impressionData == null) {
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                JSONObject allData = impressionData.getAllData();
                if (allData == null || allData.length() <= 0) {
                    this.f12041a.a(new q0("isimp", q0.a.MONITOR_NO_CONTENT, null, 4, null));
                    return;
                }
                try {
                    this.f12041a.a(s0.a(allData));
                } catch (Throwable th) {
                    this.f12041a.a(new q0("isimp", q0.a.MONITOR_BAD_CONTENT, s0.a(th)));
                }
                Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7904constructorimpl(ResultKt.createFailure(th2));
            }
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
            Object obj = map.get(ImpressionData.IMPRESSION_DATA_KEY_AD_NETWORK);
            if (obj != null && (string = obj.toString()) != null) {
                return new AbstractC4629e.b(0, fFloatValue, string, 1, null);
            }
        }
        return null;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4629e
    public AbstractC4629e.a c(Map map) {
        String string;
        String upperCase;
        Object obj = map.get(ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT);
        if (obj == null || (string = obj.toString()) == null || (upperCase = string.toUpperCase(Locale.US)) == null) {
            return null;
        }
        int iHashCode = upperCase.hashCode();
        if (iHashCode == -1466654086) {
            if (upperCase.equals("NATIVEAD")) {
                return AbstractC4629e.a.NATIVE;
            }
            return null;
        }
        if (iHashCode == -1372958932) {
            if (upperCase.equals("INTERSTITIAL")) {
                return AbstractC4629e.a.INTERSTITIAL;
            }
            return null;
        }
        if (iHashCode == 1666382058) {
            if (upperCase.equals("REWARDED_VIDEO")) {
                return AbstractC4629e.a.REWARDED;
            }
            return null;
        }
        if (iHashCode == 1951953708 && upperCase.equals("BANNER")) {
            return AbstractC4629e.a.BANNER;
        }
        return null;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public void d(Context context) {
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public void e(Context context) {
        b bVar = this.i;
        if (bVar != null) {
            IronSource.removeImpressionDataListener(bVar);
        }
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4629e, io.bidmachine.analytics.internal.AbstractC4634j
    public void f(Context context) {
        super.f(context);
        b bVar = this.i;
        if (bVar != null) {
            IronSource.addImpressionDataListener(bVar);
        }
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(AbstractC4631g.a aVar) {
        super.b(aVar);
        this.i = new b(this);
    }
}
