package net.pubnative.lite.sdk.utils.svgparser.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class CSSFontFeatureSettings {
    static CSSFontFeatureSettings CAPS_ALL_OFF = null;
    static CSSFontFeatureSettings EAST_ASIAN_ALL_OFF = null;
    public static final String FEATURE_AFRC = "afrc";
    private static final String FEATURE_C2PC = "c2pc";
    private static final String FEATURE_C2SC = "c2sc";
    public static final String FEATURE_CALT = "calt";
    public static final String FEATURE_CLIG = "clig";
    public static final String FEATURE_DLIG = "dlig";
    public static final String FEATURE_FRAC = "frac";
    public static final String FEATURE_FWID = "fwid";
    public static final String FEATURE_HLIG = "hlig";
    public static final String FEATURE_JP04 = "jp04";
    public static final String FEATURE_JP78 = "jp78";
    public static final String FEATURE_JP83 = "jp83";
    public static final String FEATURE_JP90 = "jp90";
    public static final String FEATURE_KERN = "kern";
    public static final String FEATURE_LIGA = "liga";
    public static final String FEATURE_LNUM = "lnum";
    private static final String FEATURE_OFF = "off";
    private static final String FEATURE_ON = "on";
    public static final String FEATURE_ONUM = "onum";
    public static final String FEATURE_ORDN = "ordn";
    private static final String FEATURE_PCAP = "pcap";
    public static final String FEATURE_PNUM = "pnum";
    public static final String FEATURE_PWID = "pwid";
    public static final String FEATURE_RUBY = "ruby";
    private static final String FEATURE_SMCP = "smcp";
    public static final String FEATURE_SMPL = "smpl";
    private static final String FEATURE_SUBS = "subs";
    private static final String FEATURE_SUPS = "sups";
    private static final String FEATURE_TITL = "titl";
    public static final String FEATURE_TNUM = "tnum";
    public static final String FEATURE_TRAD = "trad";
    private static final String FEATURE_UNIC = "unic";
    public static final String FEATURE_ZERO = "zero";
    private static final String FONT_VARIANT_ALL_PETITE_CAPS = "all-petite-caps";
    private static final String FONT_VARIANT_ALL_SMALL_CAPS = "all-small-caps";
    private static final String FONT_VARIANT_AUTO = "auto";
    private static final String FONT_VARIANT_COMMON_LIGATURES = "common-ligatures";
    private static final String FONT_VARIANT_CONTEXTUAL_LIGATURES = "contextual";
    private static final String FONT_VARIANT_DIAGONAL_FRACTIONS = "diagonal-fractions";
    private static final String FONT_VARIANT_DISCRETIONARY_LIGATURES = "discretionary-ligatures";
    private static final String FONT_VARIANT_FULL_WIDTH = "full-width";
    private static final String FONT_VARIANT_HISTORICAL_LIGATURES = "historical-ligatures";
    private static final String FONT_VARIANT_JIS04 = "jis04";
    private static final String FONT_VARIANT_JIS78 = "jis78";
    private static final String FONT_VARIANT_JIS83 = "jis83";
    private static final String FONT_VARIANT_JIS90 = "jis90";
    private static final String FONT_VARIANT_LINING_NUMS = "lining-nums";
    private static final String FONT_VARIANT_NONE = "none";
    static final String FONT_VARIANT_NORMAL = "normal";
    private static final String FONT_VARIANT_NO_COMMON_LIGATURES = "no-common-ligatures";
    private static final String FONT_VARIANT_NO_CONTEXTUAL_LIGATURES = "no-contextual";
    private static final String FONT_VARIANT_NO_DISCRETIONARY_LIGATURES = "no-discretionary-ligatures";
    private static final String FONT_VARIANT_NO_HISTORICAL_LIGATURES = "no-historical-ligatures";
    private static final String FONT_VARIANT_OLDSTYLE_NUMS = "oldstyle-nums";
    private static final String FONT_VARIANT_ORDINAL = "ordinal";
    private static final String FONT_VARIANT_PETITE_CAPS = "petite-caps";
    private static final String FONT_VARIANT_PROPORTIONAL_NUMS = "proportional-nums";
    private static final String FONT_VARIANT_PROPORTIONAL_WIDTH = "proportional-width";
    private static final String FONT_VARIANT_RUBY = "ruby";
    private static final String FONT_VARIANT_SIMPLIFIED = "simplified";
    private static final String FONT_VARIANT_SLASHED_ZERO = "slashed-zero";
    static final String FONT_VARIANT_SMALL_CAPS = "small-caps";
    private static final String FONT_VARIANT_STACKED_FRACTIONS = "stacked-fractions";
    private static final String FONT_VARIANT_SUB = "sub";
    private static final String FONT_VARIANT_SUPER = "super";
    private static final String FONT_VARIANT_TABULAR_NUMS = "tabular-nums";
    private static final String FONT_VARIANT_TITLING_CAPS = "titling-caps";
    private static final String FONT_VARIANT_TRADITIONAL = "traditional";
    private static final String FONT_VARIANT_UNICASE = "unicase";
    static CSSFontFeatureSettings LIGATURES_NORMAL = null;
    static CSSFontFeatureSettings NUMERIC_ALL_OFF = null;
    static CSSFontFeatureSettings POSITION_ALL_OFF = null;
    private static final String TOKEN_ERROR = "ERR";
    private static final int VALUE_OFF = 0;
    private static final int VALUE_ON = 1;
    private final HashMap<String, Integer> settings;
    public static final CSSFontFeatureSettings FONT_FEATURE_SETTINGS_NORMAL = makeDefaultSettings();
    public static final CSSFontFeatureSettings ERROR = new CSSFontFeatureSettings((HashMap<String, Integer>) null);
    private static CSSFontFeatureSettings LIGATURES_ALL_OFF = null;
    private static CSSFontFeatureSettings CAPS_SMALL_CAPS = null;

    static {
        LIGATURES_NORMAL = null;
        POSITION_ALL_OFF = null;
        CAPS_ALL_OFF = null;
        NUMERIC_ALL_OFF = null;
        EAST_ASIAN_ALL_OFF = null;
        CSSFontFeatureSettings cSSFontFeatureSettings = new CSSFontFeatureSettings();
        LIGATURES_NORMAL = cSSFontFeatureSettings;
        cSSFontFeatureSettings.settings.put(FEATURE_LIGA, 1);
        LIGATURES_NORMAL.settings.put(FEATURE_CLIG, 1);
        LIGATURES_NORMAL.settings.put(FEATURE_DLIG, 0);
        LIGATURES_NORMAL.settings.put(FEATURE_HLIG, 0);
        LIGATURES_NORMAL.settings.put(FEATURE_CALT, 1);
        CSSFontFeatureSettings cSSFontFeatureSettings2 = new CSSFontFeatureSettings();
        POSITION_ALL_OFF = cSSFontFeatureSettings2;
        cSSFontFeatureSettings2.settings.put("subs", 0);
        POSITION_ALL_OFF.settings.put(FEATURE_SUPS, 0);
        CSSFontFeatureSettings cSSFontFeatureSettings3 = new CSSFontFeatureSettings();
        CAPS_ALL_OFF = cSSFontFeatureSettings3;
        cSSFontFeatureSettings3.settings.put(FEATURE_SMCP, 0);
        CAPS_ALL_OFF.settings.put(FEATURE_C2SC, 0);
        CAPS_ALL_OFF.settings.put(FEATURE_PCAP, 0);
        CAPS_ALL_OFF.settings.put(FEATURE_C2PC, 0);
        CAPS_ALL_OFF.settings.put(FEATURE_UNIC, 0);
        CAPS_ALL_OFF.settings.put(FEATURE_TITL, 0);
        CSSFontFeatureSettings cSSFontFeatureSettings4 = new CSSFontFeatureSettings();
        NUMERIC_ALL_OFF = cSSFontFeatureSettings4;
        cSSFontFeatureSettings4.settings.put(FEATURE_LNUM, 0);
        NUMERIC_ALL_OFF.settings.put(FEATURE_ONUM, 0);
        NUMERIC_ALL_OFF.settings.put(FEATURE_PNUM, 0);
        NUMERIC_ALL_OFF.settings.put(FEATURE_TNUM, 0);
        NUMERIC_ALL_OFF.settings.put(FEATURE_FRAC, 0);
        NUMERIC_ALL_OFF.settings.put(FEATURE_AFRC, 0);
        NUMERIC_ALL_OFF.settings.put(FEATURE_ORDN, 0);
        NUMERIC_ALL_OFF.settings.put(FEATURE_ZERO, 0);
        CSSFontFeatureSettings cSSFontFeatureSettings5 = new CSSFontFeatureSettings();
        EAST_ASIAN_ALL_OFF = cSSFontFeatureSettings5;
        cSSFontFeatureSettings5.settings.put(FEATURE_JP78, 0);
        EAST_ASIAN_ALL_OFF.settings.put(FEATURE_JP83, 0);
        EAST_ASIAN_ALL_OFF.settings.put(FEATURE_JP90, 0);
        EAST_ASIAN_ALL_OFF.settings.put(FEATURE_JP04, 0);
        EAST_ASIAN_ALL_OFF.settings.put(FEATURE_SMPL, 0);
        EAST_ASIAN_ALL_OFF.settings.put(FEATURE_TRAD, 0);
        EAST_ASIAN_ALL_OFF.settings.put(FEATURE_FWID, 0);
        EAST_ASIAN_ALL_OFF.settings.put(FEATURE_PWID, 0);
        EAST_ASIAN_ALL_OFF.settings.put("ruby", 0);
    }

    private static class FontFeatureEntry {
        String name;
        int val;

        public FontFeatureEntry(String str, int i) {
            this.name = str;
            this.val = i;
        }
    }

    public CSSFontFeatureSettings() {
        this.settings = new HashMap<>();
    }

    private CSSFontFeatureSettings(HashMap<String, Integer> map) {
        this.settings = map;
    }

    public CSSFontFeatureSettings(CSSFontFeatureSettings cSSFontFeatureSettings) {
        this.settings = new HashMap<>(cSSFontFeatureSettings.settings);
    }

    public void applySettings(CSSFontFeatureSettings cSSFontFeatureSettings) {
        if (cSSFontFeatureSettings == null) {
            return;
        }
        this.settings.putAll(cSSFontFeatureSettings.settings);
    }

    public void applyKerning(Style.FontKerning fontKerning) {
        if (fontKerning == Style.FontKerning.none) {
            this.settings.put(FEATURE_KERN, 0);
        } else {
            this.settings.put(FEATURE_KERN, 1);
        }
    }

    public boolean hasSettings() {
        return this.settings.size() > 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : this.settings.entrySet()) {
            if (sb.length() > 0) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append("'");
            sb.append(entry.getKey());
            sb.append("' ");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    static CSSFontFeatureSettings parseFontFeatureSettings(String str) {
        CSSFontFeatureSettings cSSFontFeatureSettings = new CSSFontFeatureSettings();
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        while (!textScanner.empty()) {
            FontFeatureEntry fontFeatureEntryNextFeatureEntry = nextFeatureEntry(textScanner);
            if (fontFeatureEntryNextFeatureEntry == null) {
                return null;
            }
            cSSFontFeatureSettings.settings.put(fontFeatureEntryNextFeatureEntry.name, Integer.valueOf(fontFeatureEntryNextFeatureEntry.val));
            textScanner.skipCommaWhitespace();
        }
        return cSSFontFeatureSettings;
    }

    private static FontFeatureEntry nextFeatureEntry(TextScanner textScanner) {
        int iIntValue;
        textScanner.skipWhitespace();
        String strNextQuotedString = textScanner.nextQuotedString();
        if (strNextQuotedString == null || strNextQuotedString.length() != 4) {
            return null;
        }
        textScanner.skipWhitespace();
        if (textScanner.empty()) {
            iIntValue = 1;
        } else {
            iIntValue = 0;
            Integer numNextInteger = textScanner.nextInteger(false);
            if (numNextInteger == null) {
                if (!textScanner.consume("off")) {
                    textScanner.consume("on");
                    iIntValue = 1;
                }
            } else {
                iIntValue = numNextInteger.intValue();
            }
        }
        return new FontFeatureEntry(strNextQuotedString, iIntValue);
    }

    static Style.FontKerning parseFontKerning(String str) {
        str.hashCode();
        switch (str) {
            case "normal":
                return Style.FontKerning.normal;
            case "auto":
                return Style.FontKerning.auto;
            case "none":
                return Style.FontKerning.none;
            default:
                return null;
        }
    }

    private static List<String> extractTokensAsList(String str) {
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        if (textScanner.empty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (!textScanner.empty()) {
            arrayList.add(textScanner.nextToken());
            textScanner.skipWhitespace();
        }
        return arrayList;
    }

    private static int containsWhich(List<String> list, String str, String str2) {
        if (list.remove(str)) {
            return (list.contains(str) || list.contains(str2)) ? 3 : 1;
        }
        if (list.remove(str2)) {
            return list.contains(str2) ? 3 : 2;
        }
        return 0;
    }

    private static int containsOnce(List<String> list, String str) {
        if (list.remove(str)) {
            return list.contains(str) ? 2 : 1;
        }
        return 0;
    }

    private static String containsOneOf(List<String> list, String... strArr) {
        String str = null;
        for (String str2 : strArr) {
            if (str == null && list.remove(str2)) {
                str = str2;
            }
            if (list.contains(str2)) {
                return TOKEN_ERROR;
            }
        }
        return str;
    }

    static CSSFontFeatureSettings parseVariantLigatures(String str) {
        if (str.equals("normal")) {
            return LIGATURES_NORMAL;
        }
        if (str.equals("none")) {
            ensureLigaturesNone();
            return LIGATURES_ALL_OFF;
        }
        List<String> listExtractTokensAsList = extractTokensAsList(str);
        if (listExtractTokensAsList == null) {
            return null;
        }
        ensureLigaturesNone();
        CSSFontFeatureSettings variantLigaturesSpecial = parseVariantLigaturesSpecial(listExtractTokensAsList);
        if (variantLigaturesSpecial == null || variantLigaturesSpecial == ERROR || listExtractTokensAsList.size() > 0) {
            return null;
        }
        return variantLigaturesSpecial;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0039 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x003b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x003e  */
    /* JADX WARN: Code duplicated, block: B:19:0x0041  */
    /* JADX WARN: Code duplicated, block: B:20:0x004b  */
    /* JADX WARN: Code duplicated, block: B:24:0x0061 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x0066  */
    /* JADX WARN: Code duplicated, block: B:29:0x0069  */
    /* JADX WARN: Code duplicated, block: B:30:0x0073  */
    /* JADX WARN: Code duplicated, block: B:34:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x008b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x008d  */
    /* JADX WARN: Code duplicated, block: B:37:0x008f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0092  */
    /* JADX WARN: Code duplicated, block: B:40:0x009c  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    private static CSSFontFeatureSettings parseVariantLigaturesSpecial(List<String> list) {
        boolean z;
        int iContainsWhich;
        int iContainsWhich2;
        int iContainsWhich3;
        ensureLigaturesNone();
        CSSFontFeatureSettings cSSFontFeatureSettings = new CSSFontFeatureSettings(LIGATURES_ALL_OFF);
        int iContainsWhich4 = containsWhich(list, FONT_VARIANT_COMMON_LIGATURES, FONT_VARIANT_NO_COMMON_LIGATURES);
        boolean z2 = true;
        if (iContainsWhich4 == 1) {
            cSSFontFeatureSettings.addSettings(FEATURE_CLIG, FEATURE_LIGA, 1);
        } else {
            if (iContainsWhich4 == 2) {
                cSSFontFeatureSettings.addSettings(FEATURE_CLIG, FEATURE_LIGA, 0);
            } else {
                if (iContainsWhich4 == 3) {
                    return ERROR;
                }
                z = false;
            }
            iContainsWhich = containsWhich(list, FONT_VARIANT_DISCRETIONARY_LIGATURES, FONT_VARIANT_NO_DISCRETIONARY_LIGATURES);
            if (iContainsWhich != 1) {
                cSSFontFeatureSettings.settings.put(FEATURE_DLIG, 1);
            } else {
                if (iContainsWhich != 2) {
                    cSSFontFeatureSettings.settings.put(FEATURE_DLIG, 0);
                } else if (iContainsWhich == 3) {
                    return ERROR;
                }
                iContainsWhich2 = containsWhich(list, FONT_VARIANT_HISTORICAL_LIGATURES, FONT_VARIANT_NO_HISTORICAL_LIGATURES);
                if (iContainsWhich2 != 1) {
                    cSSFontFeatureSettings.settings.put(FEATURE_HLIG, 1);
                } else {
                    if (iContainsWhich2 != 2) {
                        cSSFontFeatureSettings.settings.put(FEATURE_HLIG, 0);
                    } else if (iContainsWhich2 == 3) {
                        return ERROR;
                    }
                    iContainsWhich3 = containsWhich(list, FONT_VARIANT_CONTEXTUAL_LIGATURES, FONT_VARIANT_NO_CONTEXTUAL_LIGATURES);
                    if (iContainsWhich3 != 1) {
                        cSSFontFeatureSettings.settings.put(FEATURE_CALT, 1);
                    } else if (iContainsWhich3 != 2) {
                        cSSFontFeatureSettings.settings.put(FEATURE_CALT, 0);
                    } else {
                        if (iContainsWhich3 != 3) {
                            return ERROR;
                        }
                        z2 = z;
                    }
                    if (z2) {
                        return cSSFontFeatureSettings;
                    }
                    return null;
                }
                z = true;
                iContainsWhich3 = containsWhich(list, FONT_VARIANT_CONTEXTUAL_LIGATURES, FONT_VARIANT_NO_CONTEXTUAL_LIGATURES);
                if (iContainsWhich3 != 1) {
                    cSSFontFeatureSettings.settings.put(FEATURE_CALT, 1);
                } else if (iContainsWhich3 != 2) {
                    cSSFontFeatureSettings.settings.put(FEATURE_CALT, 0);
                } else {
                    if (iContainsWhich3 != 3) {
                        return ERROR;
                    }
                    z2 = z;
                }
                if (z2) {
                    return cSSFontFeatureSettings;
                }
                return null;
            }
            z = true;
            iContainsWhich2 = containsWhich(list, FONT_VARIANT_HISTORICAL_LIGATURES, FONT_VARIANT_NO_HISTORICAL_LIGATURES);
            if (iContainsWhich2 != 1) {
                cSSFontFeatureSettings.settings.put(FEATURE_HLIG, 1);
            } else {
                if (iContainsWhich2 != 2) {
                    cSSFontFeatureSettings.settings.put(FEATURE_HLIG, 0);
                } else if (iContainsWhich2 == 3) {
                    return ERROR;
                }
                iContainsWhich3 = containsWhich(list, FONT_VARIANT_CONTEXTUAL_LIGATURES, FONT_VARIANT_NO_CONTEXTUAL_LIGATURES);
                if (iContainsWhich3 != 1) {
                    cSSFontFeatureSettings.settings.put(FEATURE_CALT, 1);
                } else if (iContainsWhich3 != 2) {
                    cSSFontFeatureSettings.settings.put(FEATURE_CALT, 0);
                } else {
                    if (iContainsWhich3 != 3) {
                        return ERROR;
                    }
                    z2 = z;
                }
                if (z2) {
                    return cSSFontFeatureSettings;
                }
                return null;
            }
            z = true;
            iContainsWhich3 = containsWhich(list, FONT_VARIANT_CONTEXTUAL_LIGATURES, FONT_VARIANT_NO_CONTEXTUAL_LIGATURES);
            if (iContainsWhich3 != 1) {
                cSSFontFeatureSettings.settings.put(FEATURE_CALT, 1);
            } else if (iContainsWhich3 != 2) {
                cSSFontFeatureSettings.settings.put(FEATURE_CALT, 0);
            } else {
                if (iContainsWhich3 != 3) {
                    return ERROR;
                }
                z2 = z;
            }
            if (z2) {
                return cSSFontFeatureSettings;
            }
            return null;
        }
        z = true;
        iContainsWhich = containsWhich(list, FONT_VARIANT_DISCRETIONARY_LIGATURES, FONT_VARIANT_NO_DISCRETIONARY_LIGATURES);
        if (iContainsWhich != 1) {
            cSSFontFeatureSettings.settings.put(FEATURE_DLIG, 1);
        } else {
            if (iContainsWhich != 2) {
                cSSFontFeatureSettings.settings.put(FEATURE_DLIG, 0);
            } else if (iContainsWhich == 3) {
                return ERROR;
            }
            iContainsWhich2 = containsWhich(list, FONT_VARIANT_HISTORICAL_LIGATURES, FONT_VARIANT_NO_HISTORICAL_LIGATURES);
            if (iContainsWhich2 != 1) {
                cSSFontFeatureSettings.settings.put(FEATURE_HLIG, 1);
            } else {
                if (iContainsWhich2 != 2) {
                    cSSFontFeatureSettings.settings.put(FEATURE_HLIG, 0);
                } else if (iContainsWhich2 == 3) {
                    return ERROR;
                }
                iContainsWhich3 = containsWhich(list, FONT_VARIANT_CONTEXTUAL_LIGATURES, FONT_VARIANT_NO_CONTEXTUAL_LIGATURES);
                if (iContainsWhich3 != 1) {
                    cSSFontFeatureSettings.settings.put(FEATURE_CALT, 1);
                } else if (iContainsWhich3 != 2) {
                    cSSFontFeatureSettings.settings.put(FEATURE_CALT, 0);
                } else {
                    if (iContainsWhich3 != 3) {
                        return ERROR;
                    }
                    z2 = z;
                }
                if (z2) {
                    return cSSFontFeatureSettings;
                }
                return null;
            }
            z = true;
            iContainsWhich3 = containsWhich(list, FONT_VARIANT_CONTEXTUAL_LIGATURES, FONT_VARIANT_NO_CONTEXTUAL_LIGATURES);
            if (iContainsWhich3 != 1) {
                cSSFontFeatureSettings.settings.put(FEATURE_CALT, 1);
            } else if (iContainsWhich3 != 2) {
                cSSFontFeatureSettings.settings.put(FEATURE_CALT, 0);
            } else {
                if (iContainsWhich3 != 3) {
                    return ERROR;
                }
                z2 = z;
            }
            if (z2) {
                return cSSFontFeatureSettings;
            }
            return null;
        }
        z = true;
        iContainsWhich2 = containsWhich(list, FONT_VARIANT_HISTORICAL_LIGATURES, FONT_VARIANT_NO_HISTORICAL_LIGATURES);
        if (iContainsWhich2 != 1) {
            cSSFontFeatureSettings.settings.put(FEATURE_HLIG, 1);
        } else {
            if (iContainsWhich2 != 2) {
                cSSFontFeatureSettings.settings.put(FEATURE_HLIG, 0);
            } else if (iContainsWhich2 == 3) {
                return ERROR;
            }
            iContainsWhich3 = containsWhich(list, FONT_VARIANT_CONTEXTUAL_LIGATURES, FONT_VARIANT_NO_CONTEXTUAL_LIGATURES);
            if (iContainsWhich3 != 1) {
                cSSFontFeatureSettings.settings.put(FEATURE_CALT, 1);
            } else if (iContainsWhich3 != 2) {
                cSSFontFeatureSettings.settings.put(FEATURE_CALT, 0);
            } else {
                if (iContainsWhich3 != 3) {
                    return ERROR;
                }
                z2 = z;
            }
            if (z2) {
                return cSSFontFeatureSettings;
            }
            return null;
        }
        z = true;
        iContainsWhich3 = containsWhich(list, FONT_VARIANT_CONTEXTUAL_LIGATURES, FONT_VARIANT_NO_CONTEXTUAL_LIGATURES);
        if (iContainsWhich3 != 1) {
            cSSFontFeatureSettings.settings.put(FEATURE_CALT, 1);
        } else if (iContainsWhich3 != 2) {
            cSSFontFeatureSettings.settings.put(FEATURE_CALT, 0);
        } else {
            if (iContainsWhich3 != 3) {
                return ERROR;
            }
            z2 = z;
        }
        if (z2) {
            return cSSFontFeatureSettings;
        }
        return null;
    }

    private void addSettings(String str, String str2, int i) {
        this.settings.put(str, Integer.valueOf(i));
        this.settings.put(str2, Integer.valueOf(i));
    }

    static CSSFontFeatureSettings parseVariantPosition(String str) {
        if (str.equals("normal")) {
            return POSITION_ALL_OFF;
        }
        CSSFontFeatureSettings cSSFontFeatureSettings = new CSSFontFeatureSettings(POSITION_ALL_OFF);
        str.hashCode();
        if (str.equals("sub")) {
            cSSFontFeatureSettings.settings.put("subs", 1);
        } else {
            if (!str.equals(FONT_VARIANT_SUPER)) {
                return null;
            }
            cSSFontFeatureSettings.settings.put(FEATURE_SUPS, 1);
        }
        return cSSFontFeatureSettings;
    }

    private static CSSFontFeatureSettings parseVariantPositionSpecial(List<String> list) {
        CSSFontFeatureSettings cSSFontFeatureSettings = new CSSFontFeatureSettings(POSITION_ALL_OFF);
        int iContainsWhich = containsWhich(list, "sub", FONT_VARIANT_SUPER);
        if (iContainsWhich == 1) {
            cSSFontFeatureSettings.settings.put("subs", 1);
            return cSSFontFeatureSettings;
        }
        if (iContainsWhich == 2) {
            cSSFontFeatureSettings.settings.put(FEATURE_SUPS, 1);
            return cSSFontFeatureSettings;
        }
        if (iContainsWhich != 3) {
            return null;
        }
        return ERROR;
    }

    static CSSFontFeatureSettings parseVariantCaps(String str) {
        if (str.equals("normal")) {
            return CAPS_ALL_OFF;
        }
        CSSFontFeatureSettings cSSFontFeatureSettings = new CSSFontFeatureSettings(CAPS_ALL_OFF);
        if (setCapsFeature(cSSFontFeatureSettings, str)) {
            return cSSFontFeatureSettings;
        }
        return null;
    }

    private static boolean setCapsFeature(CSSFontFeatureSettings cSSFontFeatureSettings, String str) {
        str.hashCode();
        switch (str) {
            case "titling-caps":
                cSSFontFeatureSettings.settings.put(FEATURE_TITL, 1);
                return true;
            case "all-small-caps":
                cSSFontFeatureSettings.addSettings(FEATURE_SMCP, FEATURE_C2SC, 1);
                return true;
            case "unicase":
                cSSFontFeatureSettings.settings.put(FEATURE_UNIC, 1);
                return true;
            case "petite-caps":
                cSSFontFeatureSettings.settings.put(FEATURE_PCAP, 1);
                return true;
            case "all-petite-caps":
                cSSFontFeatureSettings.addSettings(FEATURE_PCAP, FEATURE_C2PC, 1);
                return true;
            case "small-caps":
                cSSFontFeatureSettings.settings.put(FEATURE_SMCP, 1);
                return true;
            default:
                return false;
        }
    }

    private static CSSFontFeatureSettings parseVariantCapsSpecial(List<String> list) {
        CSSFontFeatureSettings cSSFontFeatureSettings = new CSSFontFeatureSettings(CAPS_ALL_OFF);
        String strContainsOneOf = containsOneOf(list, FONT_VARIANT_SMALL_CAPS, FONT_VARIANT_ALL_SMALL_CAPS, FONT_VARIANT_PETITE_CAPS, FONT_VARIANT_ALL_PETITE_CAPS, FONT_VARIANT_UNICASE, FONT_VARIANT_TITLING_CAPS);
        if (strContainsOneOf == TOKEN_ERROR) {
            return ERROR;
        }
        if (strContainsOneOf == null) {
            return null;
        }
        setCapsFeature(cSSFontFeatureSettings, strContainsOneOf);
        return cSSFontFeatureSettings;
    }

    static CSSFontFeatureSettings parseVariantNumeric(String str) {
        CSSFontFeatureSettings variantNumericSpecial;
        if (str.equals("normal")) {
            return NUMERIC_ALL_OFF;
        }
        List<String> listExtractTokensAsList = extractTokensAsList(str);
        if (listExtractTokensAsList == null || (variantNumericSpecial = parseVariantNumericSpecial(listExtractTokensAsList)) == null || variantNumericSpecial == ERROR || listExtractTokensAsList.size() > 0) {
            return null;
        }
        return variantNumericSpecial;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x0041 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0044  */
    /* JADX WARN: Code duplicated, block: B:19:0x0047  */
    /* JADX WARN: Code duplicated, block: B:20:0x0053  */
    /* JADX WARN: Code duplicated, block: B:24:0x0069 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x006b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x006e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0071  */
    /* JADX WARN: Code duplicated, block: B:30:0x007d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0091 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x0094  */
    /* JADX WARN: Code duplicated, block: B:38:0x0097  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ab A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:43:0x00af  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c0 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:? A[RETURN, SYNTHETIC] */
    private static CSSFontFeatureSettings parseVariantNumericSpecial(List<String> list) {
        boolean z;
        int iContainsWhich;
        int iContainsWhich2;
        int iContainsOnce;
        int iContainsOnce2;
        CSSFontFeatureSettings cSSFontFeatureSettings = new CSSFontFeatureSettings(NUMERIC_ALL_OFF);
        int iContainsWhich3 = containsWhich(list, FONT_VARIANT_LINING_NUMS, FONT_VARIANT_OLDSTYLE_NUMS);
        boolean z2 = true;
        if (iContainsWhich3 == 1) {
            cSSFontFeatureSettings.settings.put(FEATURE_LNUM, 1);
        } else {
            if (iContainsWhich3 == 2) {
                cSSFontFeatureSettings.settings.put(FEATURE_ONUM, 1);
            } else {
                if (iContainsWhich3 == 3) {
                    return ERROR;
                }
                z = false;
            }
            iContainsWhich = containsWhich(list, FONT_VARIANT_PROPORTIONAL_NUMS, FONT_VARIANT_TABULAR_NUMS);
            if (iContainsWhich != 1) {
                cSSFontFeatureSettings.settings.put(FEATURE_PNUM, 1);
            } else {
                if (iContainsWhich != 2) {
                    cSSFontFeatureSettings.settings.put(FEATURE_TNUM, 1);
                } else if (iContainsWhich == 3) {
                    return ERROR;
                }
                iContainsWhich2 = containsWhich(list, FONT_VARIANT_DIAGONAL_FRACTIONS, FONT_VARIANT_STACKED_FRACTIONS);
                if (iContainsWhich2 != 1) {
                    cSSFontFeatureSettings.settings.put(FEATURE_FRAC, 1);
                } else {
                    if (iContainsWhich2 != 2) {
                        cSSFontFeatureSettings.settings.put(FEATURE_AFRC, 1);
                    } else if (iContainsWhich2 == 3) {
                        return ERROR;
                    }
                    iContainsOnce = containsOnce(list, "ordinal");
                    if (iContainsOnce != 1) {
                        cSSFontFeatureSettings.settings.put(FEATURE_ORDN, 1);
                        z = true;
                    } else if (iContainsOnce == 2) {
                        return ERROR;
                    }
                    iContainsOnce2 = containsOnce(list, FONT_VARIANT_SLASHED_ZERO);
                    if (iContainsOnce2 != 1) {
                        cSSFontFeatureSettings.settings.put(FEATURE_ZERO, 1);
                    } else {
                        if (iContainsOnce2 != 2) {
                            return ERROR;
                        }
                        z2 = z;
                    }
                    if (z2) {
                        return cSSFontFeatureSettings;
                    }
                    return null;
                }
                z = true;
                iContainsOnce = containsOnce(list, "ordinal");
                if (iContainsOnce != 1) {
                    cSSFontFeatureSettings.settings.put(FEATURE_ORDN, 1);
                    z = true;
                } else if (iContainsOnce == 2) {
                    return ERROR;
                }
                iContainsOnce2 = containsOnce(list, FONT_VARIANT_SLASHED_ZERO);
                if (iContainsOnce2 != 1) {
                    cSSFontFeatureSettings.settings.put(FEATURE_ZERO, 1);
                } else {
                    if (iContainsOnce2 != 2) {
                        return ERROR;
                    }
                    z2 = z;
                }
                if (z2) {
                    return cSSFontFeatureSettings;
                }
                return null;
            }
            z = true;
            iContainsWhich2 = containsWhich(list, FONT_VARIANT_DIAGONAL_FRACTIONS, FONT_VARIANT_STACKED_FRACTIONS);
            if (iContainsWhich2 != 1) {
                cSSFontFeatureSettings.settings.put(FEATURE_FRAC, 1);
            } else {
                if (iContainsWhich2 != 2) {
                    cSSFontFeatureSettings.settings.put(FEATURE_AFRC, 1);
                } else if (iContainsWhich2 == 3) {
                    return ERROR;
                }
                iContainsOnce = containsOnce(list, "ordinal");
                if (iContainsOnce != 1) {
                    cSSFontFeatureSettings.settings.put(FEATURE_ORDN, 1);
                    z = true;
                } else if (iContainsOnce == 2) {
                    return ERROR;
                }
                iContainsOnce2 = containsOnce(list, FONT_VARIANT_SLASHED_ZERO);
                if (iContainsOnce2 != 1) {
                    cSSFontFeatureSettings.settings.put(FEATURE_ZERO, 1);
                } else {
                    if (iContainsOnce2 != 2) {
                        return ERROR;
                    }
                    z2 = z;
                }
                if (z2) {
                    return cSSFontFeatureSettings;
                }
                return null;
            }
            z = true;
            iContainsOnce = containsOnce(list, "ordinal");
            if (iContainsOnce != 1) {
                cSSFontFeatureSettings.settings.put(FEATURE_ORDN, 1);
                z = true;
            } else if (iContainsOnce == 2) {
                return ERROR;
            }
            iContainsOnce2 = containsOnce(list, FONT_VARIANT_SLASHED_ZERO);
            if (iContainsOnce2 != 1) {
                cSSFontFeatureSettings.settings.put(FEATURE_ZERO, 1);
            } else {
                if (iContainsOnce2 != 2) {
                    return ERROR;
                }
                z2 = z;
            }
            if (z2) {
                return cSSFontFeatureSettings;
            }
            return null;
        }
        z = true;
        iContainsWhich = containsWhich(list, FONT_VARIANT_PROPORTIONAL_NUMS, FONT_VARIANT_TABULAR_NUMS);
        if (iContainsWhich != 1) {
            cSSFontFeatureSettings.settings.put(FEATURE_PNUM, 1);
        } else {
            if (iContainsWhich != 2) {
                cSSFontFeatureSettings.settings.put(FEATURE_TNUM, 1);
            } else if (iContainsWhich == 3) {
                return ERROR;
            }
            iContainsWhich2 = containsWhich(list, FONT_VARIANT_DIAGONAL_FRACTIONS, FONT_VARIANT_STACKED_FRACTIONS);
            if (iContainsWhich2 != 1) {
                cSSFontFeatureSettings.settings.put(FEATURE_FRAC, 1);
            } else {
                if (iContainsWhich2 != 2) {
                    cSSFontFeatureSettings.settings.put(FEATURE_AFRC, 1);
                } else if (iContainsWhich2 == 3) {
                    return ERROR;
                }
                iContainsOnce = containsOnce(list, "ordinal");
                if (iContainsOnce != 1) {
                    cSSFontFeatureSettings.settings.put(FEATURE_ORDN, 1);
                    z = true;
                } else if (iContainsOnce == 2) {
                    return ERROR;
                }
                iContainsOnce2 = containsOnce(list, FONT_VARIANT_SLASHED_ZERO);
                if (iContainsOnce2 != 1) {
                    cSSFontFeatureSettings.settings.put(FEATURE_ZERO, 1);
                } else {
                    if (iContainsOnce2 != 2) {
                        return ERROR;
                    }
                    z2 = z;
                }
                if (z2) {
                    return cSSFontFeatureSettings;
                }
                return null;
            }
            z = true;
            iContainsOnce = containsOnce(list, "ordinal");
            if (iContainsOnce != 1) {
                cSSFontFeatureSettings.settings.put(FEATURE_ORDN, 1);
                z = true;
            } else if (iContainsOnce == 2) {
                return ERROR;
            }
            iContainsOnce2 = containsOnce(list, FONT_VARIANT_SLASHED_ZERO);
            if (iContainsOnce2 != 1) {
                cSSFontFeatureSettings.settings.put(FEATURE_ZERO, 1);
            } else {
                if (iContainsOnce2 != 2) {
                    return ERROR;
                }
                z2 = z;
            }
            if (z2) {
                return cSSFontFeatureSettings;
            }
            return null;
        }
        z = true;
        iContainsWhich2 = containsWhich(list, FONT_VARIANT_DIAGONAL_FRACTIONS, FONT_VARIANT_STACKED_FRACTIONS);
        if (iContainsWhich2 != 1) {
            cSSFontFeatureSettings.settings.put(FEATURE_FRAC, 1);
        } else {
            if (iContainsWhich2 != 2) {
                cSSFontFeatureSettings.settings.put(FEATURE_AFRC, 1);
            } else if (iContainsWhich2 == 3) {
                return ERROR;
            }
            iContainsOnce = containsOnce(list, "ordinal");
            if (iContainsOnce != 1) {
                cSSFontFeatureSettings.settings.put(FEATURE_ORDN, 1);
                z = true;
            } else if (iContainsOnce == 2) {
                return ERROR;
            }
            iContainsOnce2 = containsOnce(list, FONT_VARIANT_SLASHED_ZERO);
            if (iContainsOnce2 != 1) {
                cSSFontFeatureSettings.settings.put(FEATURE_ZERO, 1);
            } else {
                if (iContainsOnce2 != 2) {
                    return ERROR;
                }
                z2 = z;
            }
            if (z2) {
                return cSSFontFeatureSettings;
            }
            return null;
        }
        z = true;
        iContainsOnce = containsOnce(list, "ordinal");
        if (iContainsOnce != 1) {
            cSSFontFeatureSettings.settings.put(FEATURE_ORDN, 1);
            z = true;
        } else if (iContainsOnce == 2) {
            return ERROR;
        }
        iContainsOnce2 = containsOnce(list, FONT_VARIANT_SLASHED_ZERO);
        if (iContainsOnce2 != 1) {
            cSSFontFeatureSettings.settings.put(FEATURE_ZERO, 1);
        } else {
            if (iContainsOnce2 != 2) {
                return ERROR;
            }
            z2 = z;
        }
        if (z2) {
            return cSSFontFeatureSettings;
        }
        return null;
    }

    static CSSFontFeatureSettings parseEastAsian(String str) {
        CSSFontFeatureSettings variantEastAsianSpecial;
        if (str.equals("normal")) {
            return EAST_ASIAN_ALL_OFF;
        }
        List<String> listExtractTokensAsList = extractTokensAsList(str);
        if (listExtractTokensAsList == null || (variantEastAsianSpecial = parseVariantEastAsianSpecial(listExtractTokensAsList)) == null || variantEastAsianSpecial == ERROR || listExtractTokensAsList.size() > 0) {
            return null;
        }
        return variantEastAsianSpecial;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:58:0x00e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f3 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    private static CSSFontFeatureSettings parseVariantEastAsianSpecial(List<String> list) {
        int iContainsOnce;
        CSSFontFeatureSettings cSSFontFeatureSettings = new CSSFontFeatureSettings(EAST_ASIAN_ALL_OFF);
        boolean z = false;
        boolean z2 = true;
        String strContainsOneOf = containsOneOf(list, FONT_VARIANT_JIS78, FONT_VARIANT_JIS83, FONT_VARIANT_JIS90, FONT_VARIANT_JIS04, FONT_VARIANT_SIMPLIFIED, FONT_VARIANT_TRADITIONAL);
        if (strContainsOneOf != null) {
            strContainsOneOf.hashCode();
            switch (strContainsOneOf) {
                case "traditional":
                    cSSFontFeatureSettings.settings.put(FEATURE_TRAD, 1);
                    z = true;
                    break;
                case "simplified":
                    cSSFontFeatureSettings.settings.put(FEATURE_SMPL, 1);
                    z = true;
                    break;
                case "ERR":
                    return ERROR;
                case "jis04":
                    cSSFontFeatureSettings.settings.put(FEATURE_JP04, 1);
                    z = true;
                    break;
                case "jis78":
                    cSSFontFeatureSettings.settings.put(FEATURE_JP78, 1);
                    z = true;
                    break;
                case "jis83":
                    cSSFontFeatureSettings.settings.put(FEATURE_JP83, 1);
                    z = true;
                    break;
                case "jis90":
                    cSSFontFeatureSettings.settings.put(FEATURE_JP90, 1);
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
        }
        int iContainsWhich = containsWhich(list, FONT_VARIANT_FULL_WIDTH, FONT_VARIANT_PROPORTIONAL_WIDTH);
        if (iContainsWhich == 1) {
            cSSFontFeatureSettings.settings.put(FEATURE_FWID, 1);
        } else {
            if (iContainsWhich == 2) {
                cSSFontFeatureSettings.settings.put(FEATURE_PWID, 1);
            } else if (iContainsWhich == 3) {
                return ERROR;
            }
            iContainsOnce = containsOnce(list, "ruby");
            if (iContainsOnce != 1) {
                cSSFontFeatureSettings.settings.put("ruby", 1);
            } else {
                if (iContainsOnce != 2) {
                    return ERROR;
                }
                z2 = z;
            }
            if (z2) {
                return cSSFontFeatureSettings;
            }
            return null;
        }
        z = true;
        iContainsOnce = containsOnce(list, "ruby");
        if (iContainsOnce != 1) {
            cSSFontFeatureSettings.settings.put("ruby", 1);
        } else {
            if (iContainsOnce != 2) {
                return ERROR;
            }
            z2 = z;
        }
        if (z2) {
            return cSSFontFeatureSettings;
        }
        return null;
    }

    static void parseFontVariant(Style style, String str) {
        CSSFontFeatureSettings variantLigaturesSpecial;
        CSSFontFeatureSettings cSSFontFeatureSettings;
        CSSFontFeatureSettings variantPositionSpecial;
        CSSFontFeatureSettings variantCapsSpecial;
        CSSFontFeatureSettings variantNumericSpecial;
        if (str.equals("normal")) {
            style.fontVariantLigatures = LIGATURES_NORMAL;
            style.fontVariantPosition = POSITION_ALL_OFF;
            style.fontVariantCaps = CAPS_ALL_OFF;
            style.fontVariantNumeric = NUMERIC_ALL_OFF;
            style.fontVariantEastAsian = EAST_ASIAN_ALL_OFF;
            style.specifiedFlags |= 34084860461056L;
            return;
        }
        if (str.equals("none")) {
            ensureLigaturesNone();
            style.fontVariantLigatures = LIGATURES_ALL_OFF;
            style.fontVariantPosition = POSITION_ALL_OFF;
            style.fontVariantCaps = CAPS_ALL_OFF;
            style.fontVariantNumeric = NUMERIC_ALL_OFF;
            style.fontVariantEastAsian = EAST_ASIAN_ALL_OFF;
            style.specifiedFlags |= 34084860461056L;
            return;
        }
        List<String> listExtractTokensAsList = extractTokensAsList(str);
        if (listExtractTokensAsList == null || (variantLigaturesSpecial = parseVariantLigaturesSpecial(listExtractTokensAsList)) == (cSSFontFeatureSettings = ERROR)) {
            return;
        }
        CSSFontFeatureSettings variantEastAsianSpecial = null;
        if (listExtractTokensAsList.size() > 0) {
            variantPositionSpecial = parseVariantPositionSpecial(listExtractTokensAsList);
            if (variantPositionSpecial == cSSFontFeatureSettings) {
                return;
            }
        } else {
            variantPositionSpecial = null;
        }
        if (listExtractTokensAsList.size() > 0) {
            variantCapsSpecial = parseVariantCapsSpecial(listExtractTokensAsList);
            if (variantCapsSpecial == cSSFontFeatureSettings) {
                return;
            }
        } else {
            variantCapsSpecial = null;
        }
        if (listExtractTokensAsList.size() > 0) {
            variantNumericSpecial = parseVariantNumericSpecial(listExtractTokensAsList);
            if (variantNumericSpecial == cSSFontFeatureSettings) {
                return;
            }
        } else {
            variantNumericSpecial = null;
        }
        if (listExtractTokensAsList.size() <= 0 || (variantEastAsianSpecial = parseVariantEastAsianSpecial(listExtractTokensAsList)) != cSSFontFeatureSettings) {
            if (variantLigaturesSpecial != null) {
                style.fontVariantLigatures = variantLigaturesSpecial;
                style.specifiedFlags |= 1099511627776L;
            }
            if (variantPositionSpecial != null) {
                style.fontVariantPosition = variantPositionSpecial;
                style.specifiedFlags |= 2199023255552L;
            }
            if (variantCapsSpecial != null) {
                style.fontVariantCaps = variantCapsSpecial;
                style.specifiedFlags |= 4398046511104L;
            }
            if (variantNumericSpecial != null) {
                style.fontVariantNumeric = variantNumericSpecial;
                style.specifiedFlags |= 8796093022208L;
            }
            if (variantEastAsianSpecial != null) {
                style.fontVariantEastAsian = variantEastAsianSpecial;
                style.specifiedFlags |= 17592186044416L;
            }
        }
    }

    private static final CSSFontFeatureSettings makeDefaultSettings() {
        CSSFontFeatureSettings cSSFontFeatureSettings = new CSSFontFeatureSettings();
        cSSFontFeatureSettings.settings.put("rlig", 1);
        cSSFontFeatureSettings.settings.put(FEATURE_LIGA, 1);
        cSSFontFeatureSettings.settings.put(FEATURE_CLIG, 1);
        cSSFontFeatureSettings.settings.put(FEATURE_CALT, 1);
        cSSFontFeatureSettings.settings.put("locl", 1);
        cSSFontFeatureSettings.settings.put("ccmp", 1);
        cSSFontFeatureSettings.settings.put("mark", 1);
        cSSFontFeatureSettings.settings.put("mkmk", 1);
        return cSSFontFeatureSettings;
    }

    private static void ensureLigaturesNone() {
        if (LIGATURES_ALL_OFF != null) {
            return;
        }
        CSSFontFeatureSettings cSSFontFeatureSettings = new CSSFontFeatureSettings();
        cSSFontFeatureSettings.settings.put(FEATURE_LIGA, 0);
        cSSFontFeatureSettings.settings.put(FEATURE_CLIG, 0);
        cSSFontFeatureSettings.settings.put(FEATURE_DLIG, 0);
        cSSFontFeatureSettings.settings.put(FEATURE_HLIG, 0);
        cSSFontFeatureSettings.settings.put(FEATURE_CALT, 0);
        LIGATURES_ALL_OFF = cSSFontFeatureSettings;
    }

    private void ensurePositionNormal() {
        if (POSITION_ALL_OFF == null) {
            CSSFontFeatureSettings cSSFontFeatureSettings = new CSSFontFeatureSettings();
            cSSFontFeatureSettings.settings.put("subs", 0);
            cSSFontFeatureSettings.settings.put(FEATURE_SUPS, 0);
            POSITION_ALL_OFF = cSSFontFeatureSettings;
        }
    }

    static CSSFontFeatureSettings makeSmallCaps() {
        if (CAPS_SMALL_CAPS == null) {
            CSSFontFeatureSettings cSSFontFeatureSettings = new CSSFontFeatureSettings();
            CAPS_SMALL_CAPS = cSSFontFeatureSettings;
            cSSFontFeatureSettings.settings.put(FEATURE_SMCP, 1);
            CAPS_SMALL_CAPS.settings.put(FEATURE_C2SC, 0);
            CAPS_SMALL_CAPS.settings.put(FEATURE_PCAP, 0);
            CAPS_SMALL_CAPS.settings.put(FEATURE_C2PC, 0);
            CAPS_SMALL_CAPS.settings.put(FEATURE_UNIC, 0);
            CAPS_SMALL_CAPS.settings.put(FEATURE_TITL, 0);
        }
        return CAPS_SMALL_CAPS;
    }
}
