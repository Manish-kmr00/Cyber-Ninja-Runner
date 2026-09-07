package com.yandex.mobile.ads.impl;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class qq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f10043a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final HashMap d;

    static {
        HashMap map = new HashMap();
        d = map;
        gu0.a(-984833, map, "aliceblue", -332841, "antiquewhite");
        gu0.a(-16711681, map, "aqua", -8388652, "aquamarine");
        gu0.a(-983041, map, "azure", -657956, "beige");
        gu0.a(-6972, map, "bisque", ViewCompat.MEASURED_STATE_MASK, "black");
        gu0.a(-5171, map, "blanchedalmond", -16776961, "blue");
        gu0.a(-7722014, map, "blueviolet", -5952982, "brown");
        gu0.a(-2180985, map, "burlywood", -10510688, "cadetblue");
        gu0.a(-8388864, map, "chartreuse", -2987746, "chocolate");
        gu0.a(-32944, map, "coral", -10185235, "cornflowerblue");
        gu0.a(-1828, map, "cornsilk", -2354116, "crimson");
        gu0.a(-16711681, map, "cyan", -16777077, "darkblue");
        gu0.a(-16741493, map, "darkcyan", -4684277, "darkgoldenrod");
        gu0.a(-5658199, map, "darkgray", -16751616, "darkgreen");
        gu0.a(-5658199, map, "darkgrey", -4343957, "darkkhaki");
        gu0.a(-7667573, map, "darkmagenta", -11179217, "darkolivegreen");
        gu0.a(-29696, map, "darkorange", -6737204, "darkorchid");
        gu0.a(-7667712, map, "darkred", -1468806, "darksalmon");
        gu0.a(-7357297, map, "darkseagreen", -12042869, "darkslateblue");
        gu0.a(-13676721, map, "darkslategray", -13676721, "darkslategrey");
        gu0.a(-16724271, map, "darkturquoise", -7077677, "darkviolet");
        gu0.a(-60269, map, "deeppink", -16728065, "deepskyblue");
        gu0.a(-9868951, map, "dimgray", -9868951, "dimgrey");
        gu0.a(-14774017, map, "dodgerblue", -5103070, "firebrick");
        gu0.a(-1296, map, "floralwhite", -14513374, "forestgreen");
        gu0.a(-65281, map, "fuchsia", -2302756, "gainsboro");
        gu0.a(-460545, map, "ghostwhite", -10496, "gold");
        gu0.a(-2448096, map, "goldenrod", -8355712, "gray");
        gu0.a(-16744448, map, "green", -5374161, "greenyellow");
        gu0.a(-8355712, map, "grey", -983056, "honeydew");
        gu0.a(-38476, map, "hotpink", -3318692, "indianred");
        gu0.a(-11861886, map, "indigo", -16, "ivory");
        gu0.a(-989556, map, "khaki", -1644806, "lavender");
        gu0.a(-3851, map, "lavenderblush", -8586240, "lawngreen");
        gu0.a(-1331, map, "lemonchiffon", -5383962, "lightblue");
        gu0.a(-1015680, map, "lightcoral", -2031617, "lightcyan");
        gu0.a(-329006, map, "lightgoldenrodyellow", -2894893, "lightgray");
        gu0.a(-7278960, map, "lightgreen", -2894893, "lightgrey");
        gu0.a(-18751, map, "lightpink", -24454, "lightsalmon");
        gu0.a(-14634326, map, "lightseagreen", -7876870, "lightskyblue");
        gu0.a(-8943463, map, "lightslategray", -8943463, "lightslategrey");
        gu0.a(-5192482, map, "lightsteelblue", -32, "lightyellow");
        gu0.a(-16711936, map, "lime", -13447886, "limegreen");
        gu0.a(-331546, map, "linen", -65281, "magenta");
        gu0.a(-8388608, map, "maroon", -10039894, "mediumaquamarine");
        gu0.a(-16777011, map, "mediumblue", -4565549, "mediumorchid");
        gu0.a(-7114533, map, "mediumpurple", -12799119, "mediumseagreen");
        gu0.a(-8689426, map, "mediumslateblue", -16713062, "mediumspringgreen");
        gu0.a(-12004916, map, "mediumturquoise", -3730043, "mediumvioletred");
        gu0.a(-15132304, map, "midnightblue", -655366, "mintcream");
        gu0.a(-6943, map, "mistyrose", -6987, "moccasin");
        gu0.a(-8531, map, "navajowhite", -16777088, "navy");
        gu0.a(-133658, map, "oldlace", -8355840, "olive");
        gu0.a(-9728477, map, "olivedrab", -23296, "orange");
        gu0.a(-47872, map, "orangered", -2461482, "orchid");
        gu0.a(-1120086, map, "palegoldenrod", -6751336, "palegreen");
        gu0.a(-5247250, map, "paleturquoise", -2396013, "palevioletred");
        gu0.a(-4139, map, "papayawhip", -9543, "peachpuff");
        gu0.a(-3308225, map, "peru", -16181, "pink");
        gu0.a(-2252579, map, "plum", -5185306, "powderblue");
        gu0.a(-8388480, map, "purple", -10079335, "rebeccapurple");
        gu0.a(SupportMenu.CATEGORY_MASK, map, "red", -4419697, "rosybrown");
        gu0.a(-12490271, map, "royalblue", -7650029, "saddlebrown");
        gu0.a(-360334, map, "salmon", -744352, "sandybrown");
        gu0.a(-13726889, map, "seagreen", -2578, "seashell");
        gu0.a(-6270419, map, "sienna", -4144960, "silver");
        gu0.a(-7876885, map, "skyblue", -9807155, "slateblue");
        gu0.a(-9404272, map, "slategray", -9404272, "slategrey");
        gu0.a(-1286, map, "snow", -16711809, "springgreen");
        gu0.a(-12156236, map, "steelblue", -2968436, "tan");
        gu0.a(-16744320, map, "teal", -2572328, "thistle");
        gu0.a(-40121, map, "tomato", 0, com.ironsource.b9.h.T);
        gu0.a(-12525360, map, "turquoise", -1146130, "violet");
        gu0.a(-663885, map, "wheat", -1, "white");
        gu0.a(-657931, map, "whitesmoke", InputDeviceCompat.SOURCE_ANY, "yellow");
        map.put("yellowgreen", -6632142);
    }

    public static int b(String str) {
        return a(str, false);
    }

    private static int a(String str, boolean z) {
        int i;
        if (!TextUtils.isEmpty(str)) {
            String strReplace = str.replace(" ", "");
            if (strReplace.charAt(0) == '#') {
                int i2 = (int) Long.parseLong(strReplace.substring(1), 16);
                if (strReplace.length() == 7) {
                    return (-16777216) | i2;
                }
                if (strReplace.length() == 9) {
                    return ((i2 & 255) << 24) | (i2 >>> 8);
                }
                throw new IllegalArgumentException();
            }
            if (strReplace.startsWith("rgba")) {
                Matcher matcher = (z ? c : b).matcher(strReplace);
                if (matcher.matches()) {
                    if (z) {
                        String strGroup = matcher.group(4);
                        strGroup.getClass();
                        i = (int) (Float.parseFloat(strGroup) * 255.0f);
                    } else {
                        String strGroup2 = matcher.group(4);
                        strGroup2.getClass();
                        i = Integer.parseInt(strGroup2, 10);
                    }
                    String strGroup3 = matcher.group(1);
                    strGroup3.getClass();
                    int i3 = Integer.parseInt(strGroup3, 10);
                    String strGroup4 = matcher.group(2);
                    strGroup4.getClass();
                    int i4 = Integer.parseInt(strGroup4, 10);
                    String strGroup5 = matcher.group(3);
                    strGroup5.getClass();
                    return Color.argb(i, i3, i4, Integer.parseInt(strGroup5, 10));
                }
            } else if (strReplace.startsWith("rgb")) {
                Matcher matcher2 = f10043a.matcher(strReplace);
                if (matcher2.matches()) {
                    String strGroup6 = matcher2.group(1);
                    strGroup6.getClass();
                    int i5 = Integer.parseInt(strGroup6, 10);
                    String strGroup7 = matcher2.group(2);
                    strGroup7.getClass();
                    int i6 = Integer.parseInt(strGroup7, 10);
                    String strGroup8 = matcher2.group(3);
                    strGroup8.getClass();
                    return Color.rgb(i5, i6, Integer.parseInt(strGroup8, 10));
                }
            } else {
                Integer num = (Integer) d.get(fg.b(strReplace));
                if (num != null) {
                    return num.intValue();
                }
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public static int a(String str) {
        return a(str, true);
    }
}
