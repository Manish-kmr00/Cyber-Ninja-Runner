package com.json;

import android.text.TextUtils;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.IronSourceSegment;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.json.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceLogger;
import com.json.mediationsdk.logger.IronSourceLoggerManager;
import com.json.mediationsdk.p;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import com.unity3d.mediation.LevelPlay;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class vt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IronSource.AD_UNIT, q1> f4542a = new HashMap();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4543a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[LevelPlay.AdFormat.values().length];
            b = iArr;
            try {
                iArr[LevelPlay.AdFormat.REWARDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[LevelPlay.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[LevelPlay.AdFormat.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[LevelPlay.AdFormat.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[IronSource.AD_UNIT.values().length];
            f4543a = iArr2;
            try {
                iArr2[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4543a[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4543a[IronSource.AD_UNIT.NATIVE_AD.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4543a[IronSource.AD_UNIT.BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IronSource.AD_UNIT f4544a;

        public b(IronSource.AD_UNIT ad_unit) {
            this.f4544a = ad_unit;
        }

        private String b() {
            IronSource.AD_UNIT ad_unit = this.f4544a;
            return ad_unit != null ? ad_unit.name() : "";
        }

        public String a() {
            return a(null);
        }

        public String a(String str) {
            return a(str, null);
        }

        public String a(String str, String str2) {
            String str3 = b() + (TextUtils.isEmpty(str2) ? "" : " - " + str2);
            return TextUtils.isEmpty(str) ? str3 : str3 + " - " + str;
        }
    }

    public static IronSourceSegment a() {
        return p.m().t();
    }

    private static q1 a(w1 w1Var) {
        Map<IronSource.AD_UNIT, q1> map = f4542a;
        if (map.containsKey(w1Var.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String())) {
            return map.get(w1Var.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String());
        }
        q1 q1Var = new q1();
        map.put(w1Var.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String(), q1Var);
        return q1Var;
    }

    public static s2 a(w1 w1Var, int i) {
        return a(w1Var).a(w1Var.getAdProperties().getAdUnitId(), w1Var.m(), i);
    }

    public static b a(IronSource.AD_UNIT ad_unit) {
        return new b(ad_unit);
    }

    public static String a(LevelPlay.AdFormat adFormat) {
        int i = a.b[adFormat.ordinal()];
        if (i == 1) {
            return "rewarded";
        }
        if (i == 2) {
            return "interstitial";
        }
        if (i != 3) {
            return i != 4 ? "" : "nativeAd";
        }
        return "banner";
    }

    public static void a(int i, JSONObject jSONObject) {
        ar.i().a(new zb(i, mk.a(IronSourceUtils.getMediationAdditionalData(false), jSONObject)));
    }

    public static void a(Exception exc) {
        IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "Exception", exc);
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        try {
            jSONObjectJsonObjectInit.put("reason", exc.getMessage());
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        a(IronSourceConstants.TROUBLESHOOTING_LOAD_ARM_DATA_PARSE_ERROR, jSONObjectJsonObjectInit);
    }

    public static void a(Throwable th) {
        IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "SafeRunnable", th);
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        try {
            jSONObjectJsonObjectInit.put("reason", th.getMessage());
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        a(IronSourceConstants.TROUBLESHOOTING_SDK_INTERNAL_ERROR, jSONObjectJsonObjectInit);
    }

    public static boolean a(AdapterBaseInterface adapterBaseInterface, IronSource.AD_UNIT ad_unit, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (ContextProvider.getInstance().getCurrentActiveActivity() != null || !(adapterBaseInterface instanceof AdapterSettingsInterface) || !((AdapterSettingsInterface) adapterBaseInterface).isUsingActivityBeforeImpression(ad_unit)) {
            return false;
        }
        ironLog.verbose(str + " - is using activity before impression and activity is null");
        return true;
    }

    public static int b(IronSource.AD_UNIT ad_unit) {
        s7.e eVar;
        int i = a.f4543a[ad_unit.ordinal()];
        if (i == 1) {
            eVar = s7.e.REWARDED_VIDEO;
        } else if (i == 2) {
            eVar = s7.e.INTERSTITIAL;
        } else if (i != 3) {
            eVar = i != 4 ? s7.e.NOT_SUPPORTED : s7.e.BANNER;
        } else {
            eVar = s7.e.NATIVE_AD;
        }
        return eVar.a();
    }
}
