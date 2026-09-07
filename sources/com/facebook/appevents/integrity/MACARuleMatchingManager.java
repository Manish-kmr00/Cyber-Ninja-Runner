package com.facebook.appevents.integrity;

import android.os.Build;
import android.os.Bundle;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.facebook.FacebookSdk;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.json.mediationsdk.metadata.a;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: MACARuleMatchingManager.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J&\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010\u001c\u001a\u00020\fH\u0002J\u001a\u0010\u001d\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\""}, d2 = {"Lcom/facebook/appevents/integrity/MACARuleMatchingManager;", "", "()V", "MACARules", "Lorg/json/JSONArray;", "enabled", "", UserMetadata.KEYDATA_FILENAME, "", "", "[Ljava/lang/String;", a.j, "", "generateInfo", "params", "Landroid/os/Bundle;", "event", "getKey", "logic", "Lorg/json/JSONObject;", "getMatchPropertyIDs", "getStringArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "isMatchCCRule", "ruleString", "data", "loadMACARules", "processParameters", "removeGeneratedInfo", "stringComparison", "variable", "values", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MACARuleMatchingManager {
    private static JSONArray MACARules;
    private static boolean enabled;
    public static final MACARuleMatchingManager INSTANCE = new MACARuleMatchingManager();
    private static String[] keys = {"event", "_locale", "_appVersion", "_deviceOS", "_platform", "_deviceModel", "_nativeAppID", "_nativeAppShortVersion", "_timezone", "_carrier", "_deviceOSTypeName", "_deviceOSVersion", "_remainingDiskGB"};

    private MACARuleMatchingManager() {
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            INSTANCE.loadMACARules();
            if (MACARules != null) {
                enabled = true;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    private final void loadMACARules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null) {
                return;
            }
            MACARules = fetchedAppSettingsQueryAppSettings.getMACARuleMatchingSetting();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final String getKey(JSONObject logic) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(logic, "logic");
            Iterator<String> itKeys = logic.keys();
            if (itKeys.hasNext()) {
                return itKeys.next();
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:112:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:121:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:133:0x0225  */
    /* JADX WARN: Code duplicated, block: B:143:0x0254  */
    /* JADX WARN: Code duplicated, block: B:148:0x0261 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:149:0x0262 A[Catch: all -> 0x03fc, TryCatch #0 {all -> 0x03fc, blocks: (B:5:0x000a, B:8:0x001d, B:13:0x0041, B:12:0x0039, B:22:0x0067, B:25:0x006f, B:29:0x007c, B:32:0x0086, B:34:0x008c, B:36:0x0097, B:37:0x00a6, B:38:0x00ab, B:39:0x00ac, B:40:0x00b1, B:41:0x00b2, B:44:0x00bc, B:47:0x00cc, B:149:0x0262, B:151:0x0268, B:154:0x0272, B:155:0x0276, B:157:0x027c, B:159:0x0284, B:161:0x0293, B:164:0x02a4, B:165:0x02a9, B:166:0x02aa, B:167:0x02af, B:50:0x00d6, B:53:0x00e0, B:55:0x00e6, B:57:0x00f3, B:58:0x0104, B:59:0x0109, B:60:0x010a, B:61:0x010f, B:62:0x0110, B:173:0x02bd, B:175:0x02c3, B:178:0x02ce, B:179:0x02d2, B:181:0x02d8, B:183:0x02e0, B:185:0x02ef, B:188:0x0300, B:189:0x0305, B:190:0x0306, B:191:0x030b, B:65:0x011a, B:68:0x0124, B:70:0x012a, B:72:0x0135, B:73:0x0144, B:74:0x0149, B:75:0x014a, B:76:0x014f, B:77:0x0150, B:125:0x01fe, B:80:0x015a, B:119:0x01e3, B:83:0x0164, B:110:0x01be, B:86:0x016e, B:89:0x0178, B:141:0x0244, B:92:0x0182, B:95:0x018c, B:232:0x03b7, B:98:0x0196, B:131:0x0215, B:101:0x01a0, B:104:0x01aa, B:137:0x0230, B:107:0x01b4, B:113:0x01cf, B:116:0x01d9, B:122:0x01f4, B:128:0x020b, B:134:0x0226, B:138:0x023a, B:144:0x0255, B:168:0x02b0, B:192:0x030c, B:195:0x0316, B:197:0x031c, B:199:0x0327, B:202:0x0338, B:203:0x033d, B:204:0x033e, B:205:0x0343, B:206:0x0344, B:209:0x034e, B:210:0x035c, B:226:0x03a2, B:213:0x0366, B:216:0x0371, B:217:0x0382, B:220:0x038d, B:221:0x0396, B:227:0x03ab, B:233:0x03c0, B:236:0x03c9, B:238:0x03cf, B:240:0x03dc, B:243:0x03ef, B:244:0x03f4, B:245:0x03f5, B:246:0x03fa, B:18:0x0054), top: B:251:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:154:0x0272 A[Catch: all -> 0x03fc, TryCatch #0 {all -> 0x03fc, blocks: (B:5:0x000a, B:8:0x001d, B:13:0x0041, B:12:0x0039, B:22:0x0067, B:25:0x006f, B:29:0x007c, B:32:0x0086, B:34:0x008c, B:36:0x0097, B:37:0x00a6, B:38:0x00ab, B:39:0x00ac, B:40:0x00b1, B:41:0x00b2, B:44:0x00bc, B:47:0x00cc, B:149:0x0262, B:151:0x0268, B:154:0x0272, B:155:0x0276, B:157:0x027c, B:159:0x0284, B:161:0x0293, B:164:0x02a4, B:165:0x02a9, B:166:0x02aa, B:167:0x02af, B:50:0x00d6, B:53:0x00e0, B:55:0x00e6, B:57:0x00f3, B:58:0x0104, B:59:0x0109, B:60:0x010a, B:61:0x010f, B:62:0x0110, B:173:0x02bd, B:175:0x02c3, B:178:0x02ce, B:179:0x02d2, B:181:0x02d8, B:183:0x02e0, B:185:0x02ef, B:188:0x0300, B:189:0x0305, B:190:0x0306, B:191:0x030b, B:65:0x011a, B:68:0x0124, B:70:0x012a, B:72:0x0135, B:73:0x0144, B:74:0x0149, B:75:0x014a, B:76:0x014f, B:77:0x0150, B:125:0x01fe, B:80:0x015a, B:119:0x01e3, B:83:0x0164, B:110:0x01be, B:86:0x016e, B:89:0x0178, B:141:0x0244, B:92:0x0182, B:95:0x018c, B:232:0x03b7, B:98:0x0196, B:131:0x0215, B:101:0x01a0, B:104:0x01aa, B:137:0x0230, B:107:0x01b4, B:113:0x01cf, B:116:0x01d9, B:122:0x01f4, B:128:0x020b, B:134:0x0226, B:138:0x023a, B:144:0x0255, B:168:0x02b0, B:192:0x030c, B:195:0x0316, B:197:0x031c, B:199:0x0327, B:202:0x0338, B:203:0x033d, B:204:0x033e, B:205:0x0343, B:206:0x0344, B:209:0x034e, B:210:0x035c, B:226:0x03a2, B:213:0x0366, B:216:0x0371, B:217:0x0382, B:220:0x038d, B:221:0x0396, B:227:0x03ab, B:233:0x03c0, B:236:0x03c9, B:238:0x03cf, B:240:0x03dc, B:243:0x03ef, B:244:0x03f4, B:245:0x03f5, B:246:0x03fa, B:18:0x0054), top: B:251:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:157:0x027c A[Catch: all -> 0x03fc, TryCatch #0 {all -> 0x03fc, blocks: (B:5:0x000a, B:8:0x001d, B:13:0x0041, B:12:0x0039, B:22:0x0067, B:25:0x006f, B:29:0x007c, B:32:0x0086, B:34:0x008c, B:36:0x0097, B:37:0x00a6, B:38:0x00ab, B:39:0x00ac, B:40:0x00b1, B:41:0x00b2, B:44:0x00bc, B:47:0x00cc, B:149:0x0262, B:151:0x0268, B:154:0x0272, B:155:0x0276, B:157:0x027c, B:159:0x0284, B:161:0x0293, B:164:0x02a4, B:165:0x02a9, B:166:0x02aa, B:167:0x02af, B:50:0x00d6, B:53:0x00e0, B:55:0x00e6, B:57:0x00f3, B:58:0x0104, B:59:0x0109, B:60:0x010a, B:61:0x010f, B:62:0x0110, B:173:0x02bd, B:175:0x02c3, B:178:0x02ce, B:179:0x02d2, B:181:0x02d8, B:183:0x02e0, B:185:0x02ef, B:188:0x0300, B:189:0x0305, B:190:0x0306, B:191:0x030b, B:65:0x011a, B:68:0x0124, B:70:0x012a, B:72:0x0135, B:73:0x0144, B:74:0x0149, B:75:0x014a, B:76:0x014f, B:77:0x0150, B:125:0x01fe, B:80:0x015a, B:119:0x01e3, B:83:0x0164, B:110:0x01be, B:86:0x016e, B:89:0x0178, B:141:0x0244, B:92:0x0182, B:95:0x018c, B:232:0x03b7, B:98:0x0196, B:131:0x0215, B:101:0x01a0, B:104:0x01aa, B:137:0x0230, B:107:0x01b4, B:113:0x01cf, B:116:0x01d9, B:122:0x01f4, B:128:0x020b, B:134:0x0226, B:138:0x023a, B:144:0x0255, B:168:0x02b0, B:192:0x030c, B:195:0x0316, B:197:0x031c, B:199:0x0327, B:202:0x0338, B:203:0x033d, B:204:0x033e, B:205:0x0343, B:206:0x0344, B:209:0x034e, B:210:0x035c, B:226:0x03a2, B:213:0x0366, B:216:0x0371, B:217:0x0382, B:220:0x038d, B:221:0x0396, B:227:0x03ab, B:233:0x03c0, B:236:0x03c9, B:238:0x03cf, B:240:0x03dc, B:243:0x03ef, B:244:0x03f4, B:245:0x03f5, B:246:0x03fa, B:18:0x0054), top: B:251:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:159:0x0284 A[Catch: all -> 0x03fc, TryCatch #0 {all -> 0x03fc, blocks: (B:5:0x000a, B:8:0x001d, B:13:0x0041, B:12:0x0039, B:22:0x0067, B:25:0x006f, B:29:0x007c, B:32:0x0086, B:34:0x008c, B:36:0x0097, B:37:0x00a6, B:38:0x00ab, B:39:0x00ac, B:40:0x00b1, B:41:0x00b2, B:44:0x00bc, B:47:0x00cc, B:149:0x0262, B:151:0x0268, B:154:0x0272, B:155:0x0276, B:157:0x027c, B:159:0x0284, B:161:0x0293, B:164:0x02a4, B:165:0x02a9, B:166:0x02aa, B:167:0x02af, B:50:0x00d6, B:53:0x00e0, B:55:0x00e6, B:57:0x00f3, B:58:0x0104, B:59:0x0109, B:60:0x010a, B:61:0x010f, B:62:0x0110, B:173:0x02bd, B:175:0x02c3, B:178:0x02ce, B:179:0x02d2, B:181:0x02d8, B:183:0x02e0, B:185:0x02ef, B:188:0x0300, B:189:0x0305, B:190:0x0306, B:191:0x030b, B:65:0x011a, B:68:0x0124, B:70:0x012a, B:72:0x0135, B:73:0x0144, B:74:0x0149, B:75:0x014a, B:76:0x014f, B:77:0x0150, B:125:0x01fe, B:80:0x015a, B:119:0x01e3, B:83:0x0164, B:110:0x01be, B:86:0x016e, B:89:0x0178, B:141:0x0244, B:92:0x0182, B:95:0x018c, B:232:0x03b7, B:98:0x0196, B:131:0x0215, B:101:0x01a0, B:104:0x01aa, B:137:0x0230, B:107:0x01b4, B:113:0x01cf, B:116:0x01d9, B:122:0x01f4, B:128:0x020b, B:134:0x0226, B:138:0x023a, B:144:0x0255, B:168:0x02b0, B:192:0x030c, B:195:0x0316, B:197:0x031c, B:199:0x0327, B:202:0x0338, B:203:0x033d, B:204:0x033e, B:205:0x0343, B:206:0x0344, B:209:0x034e, B:210:0x035c, B:226:0x03a2, B:213:0x0366, B:216:0x0371, B:217:0x0382, B:220:0x038d, B:221:0x0396, B:227:0x03ab, B:233:0x03c0, B:236:0x03c9, B:238:0x03cf, B:240:0x03dc, B:243:0x03ef, B:244:0x03f4, B:245:0x03f5, B:246:0x03fa, B:18:0x0054), top: B:251:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:161:0x0293 A[Catch: all -> 0x03fc, TryCatch #0 {all -> 0x03fc, blocks: (B:5:0x000a, B:8:0x001d, B:13:0x0041, B:12:0x0039, B:22:0x0067, B:25:0x006f, B:29:0x007c, B:32:0x0086, B:34:0x008c, B:36:0x0097, B:37:0x00a6, B:38:0x00ab, B:39:0x00ac, B:40:0x00b1, B:41:0x00b2, B:44:0x00bc, B:47:0x00cc, B:149:0x0262, B:151:0x0268, B:154:0x0272, B:155:0x0276, B:157:0x027c, B:159:0x0284, B:161:0x0293, B:164:0x02a4, B:165:0x02a9, B:166:0x02aa, B:167:0x02af, B:50:0x00d6, B:53:0x00e0, B:55:0x00e6, B:57:0x00f3, B:58:0x0104, B:59:0x0109, B:60:0x010a, B:61:0x010f, B:62:0x0110, B:173:0x02bd, B:175:0x02c3, B:178:0x02ce, B:179:0x02d2, B:181:0x02d8, B:183:0x02e0, B:185:0x02ef, B:188:0x0300, B:189:0x0305, B:190:0x0306, B:191:0x030b, B:65:0x011a, B:68:0x0124, B:70:0x012a, B:72:0x0135, B:73:0x0144, B:74:0x0149, B:75:0x014a, B:76:0x014f, B:77:0x0150, B:125:0x01fe, B:80:0x015a, B:119:0x01e3, B:83:0x0164, B:110:0x01be, B:86:0x016e, B:89:0x0178, B:141:0x0244, B:92:0x0182, B:95:0x018c, B:232:0x03b7, B:98:0x0196, B:131:0x0215, B:101:0x01a0, B:104:0x01aa, B:137:0x0230, B:107:0x01b4, B:113:0x01cf, B:116:0x01d9, B:122:0x01f4, B:128:0x020b, B:134:0x0226, B:138:0x023a, B:144:0x0255, B:168:0x02b0, B:192:0x030c, B:195:0x0316, B:197:0x031c, B:199:0x0327, B:202:0x0338, B:203:0x033d, B:204:0x033e, B:205:0x0343, B:206:0x0344, B:209:0x034e, B:210:0x035c, B:226:0x03a2, B:213:0x0366, B:216:0x0371, B:217:0x0382, B:220:0x038d, B:221:0x0396, B:227:0x03ab, B:233:0x03c0, B:236:0x03c9, B:238:0x03cf, B:240:0x03dc, B:243:0x03ef, B:244:0x03f4, B:245:0x03f5, B:246:0x03fa, B:18:0x0054), top: B:251:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:172:0x02bc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:173:0x02bd A[Catch: all -> 0x03fc, TryCatch #0 {all -> 0x03fc, blocks: (B:5:0x000a, B:8:0x001d, B:13:0x0041, B:12:0x0039, B:22:0x0067, B:25:0x006f, B:29:0x007c, B:32:0x0086, B:34:0x008c, B:36:0x0097, B:37:0x00a6, B:38:0x00ab, B:39:0x00ac, B:40:0x00b1, B:41:0x00b2, B:44:0x00bc, B:47:0x00cc, B:149:0x0262, B:151:0x0268, B:154:0x0272, B:155:0x0276, B:157:0x027c, B:159:0x0284, B:161:0x0293, B:164:0x02a4, B:165:0x02a9, B:166:0x02aa, B:167:0x02af, B:50:0x00d6, B:53:0x00e0, B:55:0x00e6, B:57:0x00f3, B:58:0x0104, B:59:0x0109, B:60:0x010a, B:61:0x010f, B:62:0x0110, B:173:0x02bd, B:175:0x02c3, B:178:0x02ce, B:179:0x02d2, B:181:0x02d8, B:183:0x02e0, B:185:0x02ef, B:188:0x0300, B:189:0x0305, B:190:0x0306, B:191:0x030b, B:65:0x011a, B:68:0x0124, B:70:0x012a, B:72:0x0135, B:73:0x0144, B:74:0x0149, B:75:0x014a, B:76:0x014f, B:77:0x0150, B:125:0x01fe, B:80:0x015a, B:119:0x01e3, B:83:0x0164, B:110:0x01be, B:86:0x016e, B:89:0x0178, B:141:0x0244, B:92:0x0182, B:95:0x018c, B:232:0x03b7, B:98:0x0196, B:131:0x0215, B:101:0x01a0, B:104:0x01aa, B:137:0x0230, B:107:0x01b4, B:113:0x01cf, B:116:0x01d9, B:122:0x01f4, B:128:0x020b, B:134:0x0226, B:138:0x023a, B:144:0x0255, B:168:0x02b0, B:192:0x030c, B:195:0x0316, B:197:0x031c, B:199:0x0327, B:202:0x0338, B:203:0x033d, B:204:0x033e, B:205:0x0343, B:206:0x0344, B:209:0x034e, B:210:0x035c, B:226:0x03a2, B:213:0x0366, B:216:0x0371, B:217:0x0382, B:220:0x038d, B:221:0x0396, B:227:0x03ab, B:233:0x03c0, B:236:0x03c9, B:238:0x03cf, B:240:0x03dc, B:243:0x03ef, B:244:0x03f4, B:245:0x03f5, B:246:0x03fa, B:18:0x0054), top: B:251:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:181:0x02d8 A[Catch: all -> 0x03fc, TryCatch #0 {all -> 0x03fc, blocks: (B:5:0x000a, B:8:0x001d, B:13:0x0041, B:12:0x0039, B:22:0x0067, B:25:0x006f, B:29:0x007c, B:32:0x0086, B:34:0x008c, B:36:0x0097, B:37:0x00a6, B:38:0x00ab, B:39:0x00ac, B:40:0x00b1, B:41:0x00b2, B:44:0x00bc, B:47:0x00cc, B:149:0x0262, B:151:0x0268, B:154:0x0272, B:155:0x0276, B:157:0x027c, B:159:0x0284, B:161:0x0293, B:164:0x02a4, B:165:0x02a9, B:166:0x02aa, B:167:0x02af, B:50:0x00d6, B:53:0x00e0, B:55:0x00e6, B:57:0x00f3, B:58:0x0104, B:59:0x0109, B:60:0x010a, B:61:0x010f, B:62:0x0110, B:173:0x02bd, B:175:0x02c3, B:178:0x02ce, B:179:0x02d2, B:181:0x02d8, B:183:0x02e0, B:185:0x02ef, B:188:0x0300, B:189:0x0305, B:190:0x0306, B:191:0x030b, B:65:0x011a, B:68:0x0124, B:70:0x012a, B:72:0x0135, B:73:0x0144, B:74:0x0149, B:75:0x014a, B:76:0x014f, B:77:0x0150, B:125:0x01fe, B:80:0x015a, B:119:0x01e3, B:83:0x0164, B:110:0x01be, B:86:0x016e, B:89:0x0178, B:141:0x0244, B:92:0x0182, B:95:0x018c, B:232:0x03b7, B:98:0x0196, B:131:0x0215, B:101:0x01a0, B:104:0x01aa, B:137:0x0230, B:107:0x01b4, B:113:0x01cf, B:116:0x01d9, B:122:0x01f4, B:128:0x020b, B:134:0x0226, B:138:0x023a, B:144:0x0255, B:168:0x02b0, B:192:0x030c, B:195:0x0316, B:197:0x031c, B:199:0x0327, B:202:0x0338, B:203:0x033d, B:204:0x033e, B:205:0x0343, B:206:0x0344, B:209:0x034e, B:210:0x035c, B:226:0x03a2, B:213:0x0366, B:216:0x0371, B:217:0x0382, B:220:0x038d, B:221:0x0396, B:227:0x03ab, B:233:0x03c0, B:236:0x03c9, B:238:0x03cf, B:240:0x03dc, B:243:0x03ef, B:244:0x03f4, B:245:0x03f5, B:246:0x03fa, B:18:0x0054), top: B:251:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:183:0x02e0 A[Catch: all -> 0x03fc, TryCatch #0 {all -> 0x03fc, blocks: (B:5:0x000a, B:8:0x001d, B:13:0x0041, B:12:0x0039, B:22:0x0067, B:25:0x006f, B:29:0x007c, B:32:0x0086, B:34:0x008c, B:36:0x0097, B:37:0x00a6, B:38:0x00ab, B:39:0x00ac, B:40:0x00b1, B:41:0x00b2, B:44:0x00bc, B:47:0x00cc, B:149:0x0262, B:151:0x0268, B:154:0x0272, B:155:0x0276, B:157:0x027c, B:159:0x0284, B:161:0x0293, B:164:0x02a4, B:165:0x02a9, B:166:0x02aa, B:167:0x02af, B:50:0x00d6, B:53:0x00e0, B:55:0x00e6, B:57:0x00f3, B:58:0x0104, B:59:0x0109, B:60:0x010a, B:61:0x010f, B:62:0x0110, B:173:0x02bd, B:175:0x02c3, B:178:0x02ce, B:179:0x02d2, B:181:0x02d8, B:183:0x02e0, B:185:0x02ef, B:188:0x0300, B:189:0x0305, B:190:0x0306, B:191:0x030b, B:65:0x011a, B:68:0x0124, B:70:0x012a, B:72:0x0135, B:73:0x0144, B:74:0x0149, B:75:0x014a, B:76:0x014f, B:77:0x0150, B:125:0x01fe, B:80:0x015a, B:119:0x01e3, B:83:0x0164, B:110:0x01be, B:86:0x016e, B:89:0x0178, B:141:0x0244, B:92:0x0182, B:95:0x018c, B:232:0x03b7, B:98:0x0196, B:131:0x0215, B:101:0x01a0, B:104:0x01aa, B:137:0x0230, B:107:0x01b4, B:113:0x01cf, B:116:0x01d9, B:122:0x01f4, B:128:0x020b, B:134:0x0226, B:138:0x023a, B:144:0x0255, B:168:0x02b0, B:192:0x030c, B:195:0x0316, B:197:0x031c, B:199:0x0327, B:202:0x0338, B:203:0x033d, B:204:0x033e, B:205:0x0343, B:206:0x0344, B:209:0x034e, B:210:0x035c, B:226:0x03a2, B:213:0x0366, B:216:0x0371, B:217:0x0382, B:220:0x038d, B:221:0x0396, B:227:0x03ab, B:233:0x03c0, B:236:0x03c9, B:238:0x03cf, B:240:0x03dc, B:243:0x03ef, B:244:0x03f4, B:245:0x03f5, B:246:0x03fa, B:18:0x0054), top: B:251:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:185:0x02ef A[Catch: all -> 0x03fc, TryCatch #0 {all -> 0x03fc, blocks: (B:5:0x000a, B:8:0x001d, B:13:0x0041, B:12:0x0039, B:22:0x0067, B:25:0x006f, B:29:0x007c, B:32:0x0086, B:34:0x008c, B:36:0x0097, B:37:0x00a6, B:38:0x00ab, B:39:0x00ac, B:40:0x00b1, B:41:0x00b2, B:44:0x00bc, B:47:0x00cc, B:149:0x0262, B:151:0x0268, B:154:0x0272, B:155:0x0276, B:157:0x027c, B:159:0x0284, B:161:0x0293, B:164:0x02a4, B:165:0x02a9, B:166:0x02aa, B:167:0x02af, B:50:0x00d6, B:53:0x00e0, B:55:0x00e6, B:57:0x00f3, B:58:0x0104, B:59:0x0109, B:60:0x010a, B:61:0x010f, B:62:0x0110, B:173:0x02bd, B:175:0x02c3, B:178:0x02ce, B:179:0x02d2, B:181:0x02d8, B:183:0x02e0, B:185:0x02ef, B:188:0x0300, B:189:0x0305, B:190:0x0306, B:191:0x030b, B:65:0x011a, B:68:0x0124, B:70:0x012a, B:72:0x0135, B:73:0x0144, B:74:0x0149, B:75:0x014a, B:76:0x014f, B:77:0x0150, B:125:0x01fe, B:80:0x015a, B:119:0x01e3, B:83:0x0164, B:110:0x01be, B:86:0x016e, B:89:0x0178, B:141:0x0244, B:92:0x0182, B:95:0x018c, B:232:0x03b7, B:98:0x0196, B:131:0x0215, B:101:0x01a0, B:104:0x01aa, B:137:0x0230, B:107:0x01b4, B:113:0x01cf, B:116:0x01d9, B:122:0x01f4, B:128:0x020b, B:134:0x0226, B:138:0x023a, B:144:0x0255, B:168:0x02b0, B:192:0x030c, B:195:0x0316, B:197:0x031c, B:199:0x0327, B:202:0x0338, B:203:0x033d, B:204:0x033e, B:205:0x0343, B:206:0x0344, B:209:0x034e, B:210:0x035c, B:226:0x03a2, B:213:0x0366, B:216:0x0371, B:217:0x0382, B:220:0x038d, B:221:0x0396, B:227:0x03ab, B:233:0x03c0, B:236:0x03c9, B:238:0x03cf, B:240:0x03dc, B:243:0x03ef, B:244:0x03f4, B:245:0x03f5, B:246:0x03fa, B:18:0x0054), top: B:251:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:225:0x03a1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:226:0x03a2 A[Catch: all -> 0x03fc, TryCatch #0 {all -> 0x03fc, blocks: (B:5:0x000a, B:8:0x001d, B:13:0x0041, B:12:0x0039, B:22:0x0067, B:25:0x006f, B:29:0x007c, B:32:0x0086, B:34:0x008c, B:36:0x0097, B:37:0x00a6, B:38:0x00ab, B:39:0x00ac, B:40:0x00b1, B:41:0x00b2, B:44:0x00bc, B:47:0x00cc, B:149:0x0262, B:151:0x0268, B:154:0x0272, B:155:0x0276, B:157:0x027c, B:159:0x0284, B:161:0x0293, B:164:0x02a4, B:165:0x02a9, B:166:0x02aa, B:167:0x02af, B:50:0x00d6, B:53:0x00e0, B:55:0x00e6, B:57:0x00f3, B:58:0x0104, B:59:0x0109, B:60:0x010a, B:61:0x010f, B:62:0x0110, B:173:0x02bd, B:175:0x02c3, B:178:0x02ce, B:179:0x02d2, B:181:0x02d8, B:183:0x02e0, B:185:0x02ef, B:188:0x0300, B:189:0x0305, B:190:0x0306, B:191:0x030b, B:65:0x011a, B:68:0x0124, B:70:0x012a, B:72:0x0135, B:73:0x0144, B:74:0x0149, B:75:0x014a, B:76:0x014f, B:77:0x0150, B:125:0x01fe, B:80:0x015a, B:119:0x01e3, B:83:0x0164, B:110:0x01be, B:86:0x016e, B:89:0x0178, B:141:0x0244, B:92:0x0182, B:95:0x018c, B:232:0x03b7, B:98:0x0196, B:131:0x0215, B:101:0x01a0, B:104:0x01aa, B:137:0x0230, B:107:0x01b4, B:113:0x01cf, B:116:0x01d9, B:122:0x01f4, B:128:0x020b, B:134:0x0226, B:138:0x023a, B:144:0x0255, B:168:0x02b0, B:192:0x030c, B:195:0x0316, B:197:0x031c, B:199:0x0327, B:202:0x0338, B:203:0x033d, B:204:0x033e, B:205:0x0343, B:206:0x0344, B:209:0x034e, B:210:0x035c, B:226:0x03a2, B:213:0x0366, B:216:0x0371, B:217:0x0382, B:220:0x038d, B:221:0x0396, B:227:0x03ab, B:233:0x03c0, B:236:0x03c9, B:238:0x03cf, B:240:0x03dc, B:243:0x03ef, B:244:0x03f4, B:245:0x03f5, B:246:0x03fa, B:18:0x0054), top: B:251:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:231:0x03b6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:232:0x03b7 A[Catch: all -> 0x03fc, TryCatch #0 {all -> 0x03fc, blocks: (B:5:0x000a, B:8:0x001d, B:13:0x0041, B:12:0x0039, B:22:0x0067, B:25:0x006f, B:29:0x007c, B:32:0x0086, B:34:0x008c, B:36:0x0097, B:37:0x00a6, B:38:0x00ab, B:39:0x00ac, B:40:0x00b1, B:41:0x00b2, B:44:0x00bc, B:47:0x00cc, B:149:0x0262, B:151:0x0268, B:154:0x0272, B:155:0x0276, B:157:0x027c, B:159:0x0284, B:161:0x0293, B:164:0x02a4, B:165:0x02a9, B:166:0x02aa, B:167:0x02af, B:50:0x00d6, B:53:0x00e0, B:55:0x00e6, B:57:0x00f3, B:58:0x0104, B:59:0x0109, B:60:0x010a, B:61:0x010f, B:62:0x0110, B:173:0x02bd, B:175:0x02c3, B:178:0x02ce, B:179:0x02d2, B:181:0x02d8, B:183:0x02e0, B:185:0x02ef, B:188:0x0300, B:189:0x0305, B:190:0x0306, B:191:0x030b, B:65:0x011a, B:68:0x0124, B:70:0x012a, B:72:0x0135, B:73:0x0144, B:74:0x0149, B:75:0x014a, B:76:0x014f, B:77:0x0150, B:125:0x01fe, B:80:0x015a, B:119:0x01e3, B:83:0x0164, B:110:0x01be, B:86:0x016e, B:89:0x0178, B:141:0x0244, B:92:0x0182, B:95:0x018c, B:232:0x03b7, B:98:0x0196, B:131:0x0215, B:101:0x01a0, B:104:0x01aa, B:137:0x0230, B:107:0x01b4, B:113:0x01cf, B:116:0x01d9, B:122:0x01f4, B:128:0x020b, B:134:0x0226, B:138:0x023a, B:144:0x0255, B:168:0x02b0, B:192:0x030c, B:195:0x0316, B:197:0x031c, B:199:0x0327, B:202:0x0338, B:203:0x033d, B:204:0x033e, B:205:0x0343, B:206:0x0344, B:209:0x034e, B:210:0x035c, B:226:0x03a2, B:213:0x0366, B:216:0x0371, B:217:0x0382, B:220:0x038d, B:221:0x0396, B:227:0x03ab, B:233:0x03c0, B:236:0x03c9, B:238:0x03cf, B:240:0x03dc, B:243:0x03ef, B:244:0x03f4, B:245:0x03f5, B:246:0x03fa, B:18:0x0054), top: B:251:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:252:0x02a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:253:0x02a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:255:0x02aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:256:? A[LOOP:0: B:155:0x0276->B:256:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:258:0x0306 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:0x0300 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:260:0x02fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:261:? A[LOOP:1: B:179:0x02d2->B:261:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:282:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:285:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:290:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:294:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    public static final boolean stringComparison(String variable, JSONObject values, Bundle data) {
        Object obj;
        ArrayList<String> arrayList;
        String lowerCase;
        String string;
        String lowerCase2;
        ArrayList<String> arrayList2;
        String lowerCase3;
        String string2;
        String lowerCase4;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(variable, "variable");
            Intrinsics.checkNotNullParameter(values, "values");
            String key = getKey(values);
            if (key == null) {
                return false;
            }
            String string3 = values.get(key).toString();
            ArrayList<String> stringArrayList = getStringArrayList(values.optJSONArray(key));
            Boolean boolValueOf = null;
            if (Intrinsics.areEqual(key, "exists")) {
                if (data != null) {
                    boolValueOf = Boolean.valueOf(data.containsKey(variable));
                }
                return Intrinsics.areEqual(boolValueOf, Boolean.valueOf(Boolean.parseBoolean(string3)));
            }
            if (data == null) {
                obj = null;
            } else {
                String lowerCase5 = variable.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase5, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                obj = data.get(lowerCase5);
            }
            if (obj == null) {
                obj = data == null ? null : data.get(variable);
                if (obj == null) {
                    return false;
                }
            }
            switch (key.hashCode()) {
                case -1729128927:
                    if (!key.equals("i_not_contains")) {
                        return false;
                    }
                    String string4 = obj.toString();
                    if (string4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase6 = string4.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase6, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    String str = lowerCase6;
                    if (string3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase7 = string3.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase7, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    return !StringsKt.contains$default((CharSequence) str, (CharSequence) lowerCase7, false, 2, (Object) null);
                case -1179774633:
                    if (!key.equals("is_any")) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    return stringArrayList.contains(obj.toString());
                case -1039699439:
                    if (!key.equals("not_in")) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    return stringArrayList.contains(obj.toString());
                case -969266188:
                    if (key.equals("starts_with")) {
                        return StringsKt.startsWith$default(obj.toString(), string3, false, 2, (Object) null);
                    }
                    return false;
                case -966353971:
                    if (key.equals("regex_match")) {
                        return new Regex(string3).matches(obj.toString());
                    }
                    return false;
                case -665609109:
                    if (!key.equals("is_not_any")) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    return stringArrayList.contains(obj.toString());
                case -567445985:
                    if (key.equals("contains")) {
                        return StringsKt.contains$default((CharSequence) obj.toString(), (CharSequence) string3, false, 2, (Object) null);
                    }
                    return false;
                case -327990090:
                    if (!key.equals("i_str_neq")) {
                        return false;
                    }
                    String string5 = obj.toString();
                    if (string5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase8 = string5.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase8, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    if (string3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase9 = string3.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase9, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    if (Intrinsics.areEqual(lowerCase8, lowerCase9)) {
                        return false;
                    }
                case -159812115:
                    if (!key.equals("i_is_any")) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    arrayList = stringArrayList;
                    if (!(arrayList instanceof Collection) && arrayList.isEmpty()) {
                        return false;
                    }
                    for (String str2 : arrayList) {
                        if (str2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        lowerCase = str2.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                        string = obj.toString();
                        if (string != null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        lowerCase2 = string.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                        if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                        }
                    }
                    return false;
                case -92753547:
                    if (!key.equals("i_str_not_in")) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    arrayList2 = stringArrayList;
                    if ((arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                        for (String str3 : arrayList2) {
                            if (str3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            lowerCase3 = str3.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase3, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                            string2 = obj.toString();
                            if (string2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            lowerCase4 = string2.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase4, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                            if (Intrinsics.areEqual(lowerCase3, lowerCase4)) {
                                return false;
                            }
                        }
                    }
                case 60:
                    if (!key.equals("<")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) < Double.parseDouble(string3)) {
                        return false;
                    }
                case 61:
                    if (!key.equals("=")) {
                        return false;
                    }
                    return Intrinsics.areEqual(obj.toString(), string3);
                case 62:
                    if (!key.equals(">")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) > Double.parseDouble(string3)) {
                        return false;
                    }
                case 1084:
                    if (!key.equals("!=")) {
                        return false;
                    }
                    if (Intrinsics.areEqual(obj.toString(), string3)) {
                        return false;
                    }
                case 1921:
                    if (!key.equals("<=")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) > Double.parseDouble(string3)) {
                        return false;
                    }
                case 1952:
                    if (!key.equals("==")) {
                        return false;
                    }
                    return Intrinsics.areEqual(obj.toString(), string3);
                case 1983:
                    if (!key.equals(">=")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) < Double.parseDouble(string3)) {
                        return false;
                    }
                case 3244:
                    if (!key.equals("eq")) {
                        return false;
                    }
                    return Intrinsics.areEqual(obj.toString(), string3);
                case 3294:
                    if (!key.equals(UserDataStore.GENDER)) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) < Double.parseDouble(string3)) {
                        return false;
                    }
                case 3309:
                    if (!key.equals("gt")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) > Double.parseDouble(string3)) {
                        return false;
                    }
                case 3365:
                    if (!key.equals(ScarConstants.IN_SIGNAL_KEY)) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    return stringArrayList.contains(obj.toString());
                case 3449:
                    if (!key.equals("le")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) > Double.parseDouble(string3)) {
                        return false;
                    }
                case 3464:
                    if (!key.equals("lt")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) < Double.parseDouble(string3)) {
                        return false;
                    }
                case IronSourceConstants.BN_AUCTION_RESPONSE_WATERFALL /* 3511 */:
                    if (!key.equals("ne")) {
                        return false;
                    }
                    if (Intrinsics.areEqual(obj.toString(), string3)) {
                        return false;
                    }
                case 102680:
                    if (!key.equals("gte")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) < Double.parseDouble(string3)) {
                        return false;
                    }
                case 107485:
                    if (!key.equals("lte")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) > Double.parseDouble(string3)) {
                        return false;
                    }
                case 108954:
                    if (!key.equals("neq")) {
                        return false;
                    }
                    if (Intrinsics.areEqual(obj.toString(), string3)) {
                        return false;
                    }
                case 127966736:
                    if (!key.equals("i_str_eq")) {
                        return false;
                    }
                    String string6 = obj.toString();
                    if (string6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase10 = string6.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase10, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    if (string3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase11 = string3.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase11, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    return Intrinsics.areEqual(lowerCase10, lowerCase11);
                case 127966857:
                    if (!key.equals("i_str_in")) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    arrayList = stringArrayList;
                    if (!(arrayList instanceof Collection)) {
                        break;
                    }
                    while (r9.hasNext()) {
                        if (str2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        lowerCase = str2.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                        string = obj.toString();
                        if (string != null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        lowerCase2 = string.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                        if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                        }
                    }
                    return false;
                case 363990325:
                    if (!key.equals("i_contains")) {
                        return false;
                    }
                    String string7 = obj.toString();
                    if (string7 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase12 = string7.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase12, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    String str4 = lowerCase12;
                    if (string3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase13 = string3.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase13, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    return StringsKt.contains$default((CharSequence) str4, (CharSequence) lowerCase13, false, 2, (Object) null);
                case 1091487233:
                    if (!key.equals("i_is_not_any")) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    arrayList2 = stringArrayList;
                    if (arrayList2 instanceof Collection) {
                        while (r9.hasNext()) {
                            if (str3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            lowerCase3 = str3.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase3, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                            string2 = obj.toString();
                            if (string2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            lowerCase4 = string2.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase4, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                            if (Intrinsics.areEqual(lowerCase3, lowerCase4)) {
                                return false;
                            }
                        }
                    } else {
                        while (r9.hasNext()) {
                            if (str3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            lowerCase3 = str3.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase3, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                            string2 = obj.toString();
                            if (string2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            lowerCase4 = string2.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase4, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                            if (Intrinsics.areEqual(lowerCase3, lowerCase4)) {
                                return false;
                            }
                        }
                    }
                case 1918401035:
                    if (!key.equals("not_contains") || StringsKt.contains$default((CharSequence) obj.toString(), (CharSequence) string3, false, 2, (Object) null)) {
                        return false;
                    }
                case 1961112862:
                    if (!key.equals("i_starts_with")) {
                        return false;
                    }
                    String string8 = obj.toString();
                    if (string8 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase14 = string8.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase14, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    if (string3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase15 = string3.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase15, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    return StringsKt.startsWith$default(lowerCase14, lowerCase15, false, 2, (Object) null);
                default:
                    return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return false;
        }
    }

    @JvmStatic
    public static final ArrayList<String> getStringArrayList(JSONArray jsonArray) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) || jsonArray == null) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            int length = jsonArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    arrayList.add(jsonArray.get(i).toString());
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final boolean isMatchCCRule(String ruleString, Bundle data) {
        int length;
        if (!CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) && ruleString != null && data != null) {
            try {
                JSONObject jSONObject = new JSONObject(ruleString);
                String key = getKey(jSONObject);
                if (key == null) {
                    return false;
                }
                Object obj = jSONObject.get(key);
                int iHashCode = key.hashCode();
                if (iHashCode != 3555) {
                    if (iHashCode != 96727) {
                        if (iHashCode == 109267 && key.equals("not")) {
                            return !isMatchCCRule(obj.toString(), data);
                        }
                    } else if (key.equals("and")) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray == null) {
                            return false;
                        }
                        int length2 = jSONArray.length();
                        if (length2 > 0) {
                            int i = 0;
                            while (true) {
                                int i2 = i + 1;
                                if (!isMatchCCRule(jSONArray.get(i).toString(), data)) {
                                    return false;
                                }
                                if (i2 < length2) {
                                    i = i2;
                                }
                            }
                        }
                        return true;
                    }
                } else if (key.equals("or")) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    if (jSONArray2 != null && (length = jSONArray2.length()) > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            if (isMatchCCRule(jSONArray2.get(i3).toString(), data)) {
                                return true;
                            }
                            if (i4 < length) {
                                i3 = i4;
                            }
                        }
                    }
                    return false;
                }
                JSONObject jSONObject2 = (JSONObject) obj;
                if (jSONObject2 == null) {
                    return false;
                }
                return stringComparison(key, jSONObject2, data);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            }
        }
        return false;
    }

    @JvmStatic
    public static final String getMatchPropertyIDs(Bundle params) {
        String strOptString;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            JSONArray jSONArray = MACARules;
            if (jSONArray == null) {
                return "[]";
            }
            Integer numValueOf = jSONArray == null ? null : Integer.valueOf(jSONArray.length());
            if (numValueOf != null && numValueOf.intValue() == 0) {
                return "[]";
            }
            JSONArray jSONArray2 = MACARules;
            if (jSONArray2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray2.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    String strOptString2 = jSONArray2.optString(i);
                    if (strOptString2 != null) {
                        JSONObject jSONObject = new JSONObject(strOptString2);
                        long jOptLong = jSONObject.optLong("id");
                        if (jOptLong != 0 && (strOptString = jSONObject.optString("rule")) != null && isMatchCCRule(strOptString, params)) {
                            arrayList.add(Long.valueOf(jOptLong));
                        }
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            String string = new JSONArray((Collection) arrayList).toString();
            Intrinsics.checkNotNullExpressionValue(string, "JSONArray(res).toString()");
            return string;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final void processParameters(Bundle params, String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!enabled || params == null) {
                return;
            }
            try {
                generateInfo(params, event);
                params.putString("_audiencePropertyIds", getMatchPropertyIDs(params));
                params.putString("cs_maca", "1");
                removeGeneratedInfo(params);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    @JvmStatic
    public static final void generateInfo(Bundle params, String event) {
        String language;
        String country;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(event, "event");
            params.putString("event", event);
            StringBuilder sb = new StringBuilder();
            Locale locale = Utility.INSTANCE.getLocale();
            String str = "";
            if (locale == null || (language = locale.getLanguage()) == null) {
                language = "";
            }
            StringBuilder sbAppend = sb.append(language).append('_');
            Locale locale2 = Utility.INSTANCE.getLocale();
            if (locale2 == null || (country = locale2.getCountry()) == null) {
                country = "";
            }
            params.putString("_locale", sbAppend.append(country).toString());
            String versionName = Utility.INSTANCE.getVersionName();
            if (versionName == null) {
                versionName = "";
            }
            params.putString("_appVersion", versionName);
            params.putString("_deviceOS", "ANDROID");
            params.putString("_platform", DTBMetricsConfiguration.APSMETRICS_LEVEL2_KEY);
            String str2 = Build.MODEL;
            if (str2 == null) {
                str2 = "";
            }
            params.putString("_deviceModel", str2);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            params.putString("_nativeAppID", FacebookSdk.getApplicationId());
            String versionName2 = Utility.INSTANCE.getVersionName();
            if (versionName2 != null) {
                str = versionName2;
            }
            params.putString("_nativeAppShortVersion", str);
            params.putString("_timezone", Utility.INSTANCE.getDeviceTimeZoneName());
            params.putString("_carrier", Utility.INSTANCE.getCarrierName());
            params.putString("_deviceOSTypeName", "ANDROID");
            params.putString("_deviceOSVersion", Build.VERSION.RELEASE);
            params.putLong("_remainingDiskGB", Utility.INSTANCE.getAvailableExternalStorageGB());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    @JvmStatic
    public static final void removeGeneratedInfo(Bundle params) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            String[] strArr = keys;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                i++;
                params.remove(str);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }
}
