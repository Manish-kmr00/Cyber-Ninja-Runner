package com.inmobi.media;

import android.content.Context;
import android.location.Location;
import com.facebook.AuthenticationTokenClaims;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes6.dex */
public abstract class I9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f3097a = Integer.MIN_VALUE;
    public static Boolean b = null;
    public static String c = null;
    public static String d = null;
    public static String e = null;
    public static String f = null;
    public static String g = null;
    public static String h = null;
    public static int i = Integer.MIN_VALUE;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public static Location n;

    public static void a(final boolean z) {
        b = Boolean.valueOf(z);
        final Context contextD = C3517pb.d();
        if (contextD != null) {
            C3517pb.a(new Runnable() { // from class: com.inmobi.media.I9$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    I9.a(contextD, z);
                }
            });
        }
    }

    public static Location b() {
        Location location = n;
        if (location != null) {
            return location;
        }
        Context contextD = C3517pb.d();
        Location location2 = null;
        if (contextD == null) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = K5.b;
        K5 k5A = J5.a(contextD, "user_info_store");
        Intrinsics.checkNotNullParameter(AuthenticationTokenClaims.JSON_KEY_USER_LOCATION, "key");
        String string = k5A.f3112a.getString(AuthenticationTokenClaims.JSON_KEY_USER_LOCATION, null);
        if (string == null) {
            return null;
        }
        Location location3 = new Location("");
        try {
            String[] strArr = (String[]) new Regex(StringUtils.COMMA).split(string, 0).toArray(new String[0]);
            location3.setLatitude(Double.parseDouble(strArr[0]));
            location3.setLongitude(Double.parseDouble(strArr[1]));
            location3.setAccuracy(Float.parseFloat(strArr[2]));
            location3.setTime(Long.parseLong(strArr[3]));
            location2 = location3;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
        }
        n = location2;
        return location2;
    }

    public static boolean c() {
        Boolean bool = b;
        if (bool != null) {
            return bool.booleanValue();
        }
        Context contextD = C3517pb.d();
        if (contextD != null) {
            ConcurrentHashMap concurrentHashMap = K5.b;
            K5 k5A = J5.a(contextD, "user_info_store");
            Intrinsics.checkNotNullParameter("user_age_restricted", "key");
            b = Boolean.valueOf(k5A.f3112a.getBoolean("user_age_restricted", false));
        }
        Boolean bool2 = b;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return false;
    }

    public static final void a(Context it, boolean z) {
        Intrinsics.checkNotNullParameter(it, "$it");
        ConcurrentHashMap concurrentHashMap = K5.b;
        J5.a(it, "user_info_store").a("user_age_restricted", z);
    }

    /* JADX WARN: Code duplicated, block: B:83:0x0130  */
    public static HashMap a() {
        String string;
        String str;
        HashMap map = new HashMap();
        int i2 = f3097a;
        int i3 = Integer.MIN_VALUE;
        if (i2 == Integer.MIN_VALUE) {
            Context contextD = C3517pb.d();
            if (contextD == null) {
                i2 = Integer.MIN_VALUE;
            } else {
                ConcurrentHashMap concurrentHashMap = K5.b;
                K5 k5A = J5.a(contextD, "user_info_store");
                Intrinsics.checkNotNullParameter("user_age", "key");
                i2 = k5A.f3112a.getInt("user_age", Integer.MIN_VALUE);
            }
            f3097a = i2;
        }
        if (i2 > 0) {
            map.put("u-age", String.valueOf(i2));
        }
        int i4 = i;
        if (i4 == Integer.MIN_VALUE) {
            Context contextD2 = C3517pb.d();
            if (contextD2 != null) {
                ConcurrentHashMap concurrentHashMap2 = K5.b;
                K5 k5A2 = J5.a(contextD2, "user_info_store");
                Intrinsics.checkNotNullParameter("user_yob", "key");
                i3 = k5A2.f3112a.getInt("user_yob", Integer.MIN_VALUE);
            }
            i = i3;
            i4 = i3;
        }
        if (i4 > 0) {
            map.put("u-yearofbirth", String.valueOf(i4));
        }
        String string2 = f;
        String string3 = null;
        if (string2 == null) {
            Context contextD3 = C3517pb.d();
            if (contextD3 == null) {
                string2 = null;
            } else {
                ConcurrentHashMap concurrentHashMap3 = K5.b;
                K5 k5A3 = J5.a(contextD3, "user_info_store");
                Intrinsics.checkNotNullParameter("user_city_code", "key");
                string2 = k5A3.f3112a.getString("user_city_code", null);
            }
            f = string2;
        }
        String string4 = g;
        if (string4 == null) {
            Context contextD4 = C3517pb.d();
            if (contextD4 == null) {
                string4 = null;
            } else {
                ConcurrentHashMap concurrentHashMap4 = K5.b;
                K5 k5A4 = J5.a(contextD4, "user_info_store");
                Intrinsics.checkNotNullParameter("user_state_code", "key");
                string4 = k5A4.f3112a.getString("user_state_code", null);
            }
            g = string4;
        }
        String string5 = h;
        if (string5 == null) {
            Context contextD5 = C3517pb.d();
            if (contextD5 == null) {
                string5 = null;
            } else {
                ConcurrentHashMap concurrentHashMap5 = K5.b;
                K5 k5A5 = J5.a(contextD5, "user_info_store");
                Intrinsics.checkNotNullParameter("user_country_code", "key");
                string5 = k5A5.f3112a.getString("user_country_code", null);
            }
            h = string5;
        }
        if (string2 != null) {
            int length = string2.length() - 1;
            int i5 = 0;
            boolean z = false;
            while (i5 <= length) {
                boolean z2 = Intrinsics.compare((int) string2.charAt(!z ? i5 : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i5++;
                } else {
                    z = true;
                }
            }
            if (string2.subSequence(i5, length + 1).toString().length() > 0) {
                int length2 = string2.length() - 1;
                int i6 = 0;
                boolean z3 = false;
                while (i6 <= length2) {
                    boolean z4 = Intrinsics.compare((int) string2.charAt(!z3 ? i6 : length2), 32) <= 0;
                    if (z3) {
                        if (!z4) {
                            break;
                        }
                        length2--;
                    } else if (z4) {
                        i6++;
                    } else {
                        z3 = true;
                    }
                }
                string = Q6.a(length2, 1, string2, i6);
            } else {
                string = "";
            }
        } else {
            string = "";
        }
        if (string4 != null) {
            int length3 = string4.length() - 1;
            int i7 = 0;
            boolean z5 = false;
            while (i7 <= length3) {
                boolean z6 = Intrinsics.compare((int) string4.charAt(!z5 ? i7 : length3), 32) <= 0;
                if (z5) {
                    if (!z6) {
                        break;
                    }
                    length3--;
                } else if (z6) {
                    i7++;
                } else {
                    z5 = true;
                }
            }
            if (string4.subSequence(i7, length3 + 1).toString().length() > 0) {
                StringBuilder sbAppend = new StringBuilder().append(string).append('-');
                int length4 = string4.length() - 1;
                int i8 = 0;
                boolean z7 = false;
                while (i8 <= length4) {
                    boolean z8 = Intrinsics.compare((int) string4.charAt(!z7 ? i8 : length4), 32) <= 0;
                    if (z7) {
                        if (!z8) {
                            break;
                        }
                        length4--;
                    } else if (z8) {
                        i8++;
                    } else {
                        z7 = true;
                    }
                }
                string = sbAppend.append(string4.subSequence(i8, length4 + 1).toString()).toString();
            }
        }
        if (string5 != null) {
            int length5 = string5.length() - 1;
            int i9 = 0;
            boolean z9 = false;
            while (i9 <= length5) {
                boolean z10 = Intrinsics.compare((int) string5.charAt(!z9 ? i9 : length5), 32) <= 0;
                if (z9) {
                    if (!z10) {
                        break;
                    }
                    length5--;
                } else if (z10) {
                    i9++;
                } else {
                    z9 = true;
                }
            }
            if (string5.subSequence(i9, length5 + 1).toString().length() > 0) {
                StringBuilder sbAppend2 = new StringBuilder().append(string).append('-');
                int length6 = string5.length() - 1;
                int i10 = 0;
                boolean z11 = false;
                while (i10 <= length6) {
                    boolean z12 = Intrinsics.compare((int) string5.charAt(!z11 ? i10 : length6), 32) <= 0;
                    if (z11) {
                        if (!z12) {
                            break;
                        }
                        length6--;
                    } else if (z12) {
                        i10++;
                    } else {
                        z11 = true;
                    }
                }
                string = sbAppend2.append(string5.subSequence(i10, length6 + 1).toString()).toString();
            }
        }
        int length7 = string.length() - 1;
        int i11 = 0;
        boolean z13 = false;
        while (i11 <= length7) {
            boolean z14 = Intrinsics.compare((int) string.charAt(!z13 ? i11 : length7), 32) <= 0;
            if (z13) {
                if (!z14) {
                    break;
                }
                length7--;
            } else if (z14) {
                i11++;
            } else {
                z13 = true;
            }
        }
        if (string.subSequence(i11, length7 + 1).toString().length() > 0) {
            map.put("u-location", string);
        }
        String string6 = c;
        if (string6 == null) {
            Context contextD6 = C3517pb.d();
            if (contextD6 == null) {
                string6 = null;
            } else {
                ConcurrentHashMap concurrentHashMap6 = K5.b;
                K5 k5A6 = J5.a(contextD6, "user_info_store");
                Intrinsics.checkNotNullParameter("user_age_group", "key");
                string6 = k5A6.f3112a.getString("user_age_group", null);
            }
            c = string6;
        }
        if (string6 != null) {
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String lowerCase = string6.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            map.put("u-agegroup", lowerCase);
        }
        String string7 = d;
        if (string7 == null) {
            Context contextD7 = C3517pb.d();
            if (contextD7 == null) {
                string7 = null;
            } else {
                ConcurrentHashMap concurrentHashMap7 = K5.b;
                K5 k5A7 = J5.a(contextD7, "user_info_store");
                Intrinsics.checkNotNullParameter("user_area_code", "key");
                string7 = k5A7.f3112a.getString("user_area_code", null);
            }
            d = string7;
        }
        if (string7 != null) {
            map.put("u-areacode", string7);
        }
        String string8 = e;
        if (string8 == null) {
            Context contextD8 = C3517pb.d();
            if (contextD8 == null) {
                string8 = null;
            } else {
                ConcurrentHashMap concurrentHashMap8 = K5.b;
                K5 k5A8 = J5.a(contextD8, "user_info_store");
                Intrinsics.checkNotNullParameter("user_post_code", "key");
                string8 = k5A8.f3112a.getString("user_post_code", null);
            }
            e = string8;
        }
        if (string8 != null) {
            map.put("u-postalcode", string8);
        }
        String string9 = j;
        if (string9 == null) {
            Context contextD9 = C3517pb.d();
            if (contextD9 == null) {
                string9 = null;
            } else {
                ConcurrentHashMap concurrentHashMap9 = K5.b;
                K5 k5A9 = J5.a(contextD9, "user_info_store");
                Intrinsics.checkNotNullParameter(AuthenticationTokenClaims.JSON_KEY_USER_GENDER, "key");
                string9 = k5A9.f3112a.getString(AuthenticationTokenClaims.JSON_KEY_USER_GENDER, null);
            }
            j = string9;
        }
        if (string9 != null) {
            map.put("u-gender", string9);
        }
        String string10 = k;
        if (string10 == null) {
            Context contextD10 = C3517pb.d();
            if (contextD10 == null) {
                string10 = null;
            } else {
                ConcurrentHashMap concurrentHashMap10 = K5.b;
                K5 k5A10 = J5.a(contextD10, "user_info_store");
                Intrinsics.checkNotNullParameter("user_education", "key");
                string10 = k5A10.f3112a.getString("user_education", null);
            }
            k = string10;
        }
        if (string10 != null) {
            map.put("u-education", string10);
        }
        String string11 = l;
        if (string11 == null) {
            Context contextD11 = C3517pb.d();
            if (contextD11 == null) {
                string11 = null;
            } else {
                ConcurrentHashMap concurrentHashMap11 = K5.b;
                K5 k5A11 = J5.a(contextD11, "user_info_store");
                Intrinsics.checkNotNullParameter("user_language", "key");
                string11 = k5A11.f3112a.getString("user_language", null);
            }
            l = string11;
        }
        if (string11 != null) {
            map.put("u-language", string11);
        }
        String str2 = m;
        if (str2 == null) {
            Context contextD12 = C3517pb.d();
            if (contextD12 != null) {
                ConcurrentHashMap concurrentHashMap12 = K5.b;
                K5 k5A12 = J5.a(contextD12, "user_info_store");
                Intrinsics.checkNotNullParameter("user_interest", "key");
                string3 = k5A12.f3112a.getString("user_interest", null);
            }
            m = string3;
            str2 = string3;
        }
        if (str2 != null) {
            map.put("u-interests", str2);
        }
        if (c()) {
            str = "1";
        } else {
            str = "0";
        }
        map.put("u-age-restricted", str);
        return map;
    }
}
