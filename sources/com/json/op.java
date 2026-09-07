package com.json;

import android.content.Context;
import android.text.TextUtils;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.model.BasePlacement;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mediationsdk.utils.IronSourceUtils;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes9.dex */
public class op implements bg, bg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4128a = "CappingManager.IS_DELIVERY_ENABLED";
    private static final String b = "CappingManager.IS_CAPPING_ENABLED";
    private static final String c = "CappingManager.IS_PACING_ENABLED";
    private static final String d = "CappingManager.MAX_NUMBER_OF_SHOWS";
    private static final String e = "CappingManager.CAPPING_TYPE";
    private static final String f = "CappingManager.SECONDS_BETWEEN_SHOWS";
    private static final String g = "CappingManager.CURRENT_NUMBER_OF_SHOWS";
    private static final String h = "CappingManager.CAPPING_TIME_THRESHOLD";
    private static final String i = "CappingManager.TIME_OF_THE_PREVIOUS_SHOW";

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4129a;

        static {
            int[] iArr = new int[pp.values().length];
            f4129a = iArr;
            try {
                iArr[pp.PER_DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4129a[pp.PER_HOUR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        CAPPED_PER_DELIVERY,
        CAPPED_PER_COUNT,
        CAPPED_PER_PACE,
        NOT_CAPPED
    }

    private long a(pp ppVar) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        int i2 = a.f4129a[ppVar.ordinal()];
        if (i2 == 1) {
            calendar.set(14, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.set(11, 0);
            calendar.add(6, 1);
        } else if (i2 == 2) {
            calendar.set(14, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.add(11, 1);
        }
        return calendar.getTimeInMillis();
    }

    private String a(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return IronSourceConstants.REWARDED_VIDEO_AD_UNIT;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return "Interstitial";
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return "Banner";
        }
        return ad_unit == IronSource.AD_UNIT.NATIVE_AD ? IronSourceConstants.NATIVE_AD_UNIT : ad_unit.toString();
    }

    private String a(String str, String str2, String str3) {
        return str + "_" + str2 + "_" + str3;
    }

    private void a(Context context, String str, String str2) {
        pp ppVar;
        int i2 = 0;
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, c, str2), false)) {
            IronSourceUtils.saveLongToSharedPrefs(context, a(str, i, str2), System.currentTimeMillis());
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, b, str2), false)) {
            String strA = a(str, g, str2);
            int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(context, strA, 0);
            if (intFromSharedPrefs == 0) {
                String stringFromSharedPrefs = IronSourceUtils.getStringFromSharedPrefs(context, a(str, e, str2), pp.PER_DAY.toString());
                pp[] ppVarArrValues = pp.values();
                int length = ppVarArrValues.length;
                while (true) {
                    if (i2 >= length) {
                        ppVar = null;
                        break;
                    }
                    ppVar = ppVarArrValues[i2];
                    if (ppVar.f4164a.equals(stringFromSharedPrefs)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                IronSourceUtils.saveLongToSharedPrefs(context, a(str, h, str2), a(ppVar));
            }
            IronSourceUtils.saveIntToSharedPrefs(context, strA, intFromSharedPrefs + 1);
        }
    }

    private void a(Context context, String str, String str2, lp lpVar) {
        boolean zE = lpVar.e();
        IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, f4128a, str2), zE);
        if (zE) {
            boolean zD = lpVar.d();
            IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, b, str2), zD);
            if (zD) {
                IronSourceUtils.saveIntToSharedPrefs(context, a(str, d, str2), lpVar.b());
                IronSourceUtils.saveStringToSharedPrefs(context, a(str, e, str2), lpVar.a().toString());
            }
            boolean zF = lpVar.f();
            IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, c, str2), zF);
            if (zF) {
                IronSourceUtils.saveIntToSharedPrefs(context, a(str, f, str2), lpVar.c());
            }
        }
    }

    private b b(Context context, String str, String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, f4128a, str2), true)) {
            return b.CAPPED_PER_DELIVERY;
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, c, str2), false)) {
            if (jCurrentTimeMillis - IronSourceUtils.getLongFromSharedPrefs(context, a(str, i, str2), 0L) < IronSourceUtils.getIntFromSharedPrefs(context, a(str, f, str2), 0) * 1000) {
                return b.CAPPED_PER_PACE;
            }
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, b, str2), false)) {
            int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(context, a(str, d, str2), 0);
            String strA = a(str, g, str2);
            int intFromSharedPrefs2 = IronSourceUtils.getIntFromSharedPrefs(context, strA, 0);
            String strA2 = a(str, h, str2);
            if (jCurrentTimeMillis >= IronSourceUtils.getLongFromSharedPrefs(context, strA2, 0L)) {
                IronSourceUtils.saveIntToSharedPrefs(context, strA, 0);
                IronSourceUtils.saveLongToSharedPrefs(context, strA2, 0L);
            } else if (intFromSharedPrefs2 >= intFromSharedPrefs) {
                return b.CAPPED_PER_COUNT;
            }
        }
        return b.NOT_CAPPED;
    }

    @Override // com.json.bg
    public synchronized b a(Context context, BasePlacement basePlacement, IronSource.AD_UNIT ad_unit) {
        try {
            if (context == null) {
                return b.NOT_CAPPED;
            }
            if (basePlacement == null) {
                return b.NOT_CAPPED;
            }
            String strA = a(ad_unit);
            if (basePlacement.getPlacementName() == null) {
                return b.NOT_CAPPED;
            }
            if (basePlacement.getPlacementAvailabilitySettings() == null) {
                return b.NOT_CAPPED;
            }
            return b(context, strA, basePlacement.getPlacementName());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.ironsource.bg.a
    public synchronized void a(Context context, String str, IronSource.AD_UNIT ad_unit) {
        if (context == null) {
            return;
        }
        if (str == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(context, a(ad_unit), str);
    }

    @Override // com.json.bg
    public synchronized boolean b(Context context, BasePlacement basePlacement, IronSource.AD_UNIT ad_unit) {
        return a(context, basePlacement, ad_unit) != b.NOT_CAPPED;
    }

    @Override // com.ironsource.bg.a
    public synchronized void c(Context context, BasePlacement basePlacement, IronSource.AD_UNIT ad_unit) {
        if (context == null || basePlacement == null) {
            return;
        }
        lp placementAvailabilitySettings = basePlacement.getPlacementAvailabilitySettings();
        if (placementAvailabilitySettings == null) {
            return;
        }
        a(context, a(ad_unit), basePlacement.getPlacementName(), placementAvailabilitySettings);
    }
}
