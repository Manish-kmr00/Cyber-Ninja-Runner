package com.mbridge.msdk.foundation.same.report.metrics;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.tracker.m;
import com.mbridge.msdk.tracker.network.toolbox.i;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.analytics.brandsafety.l;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SameMetricsReport.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private Map<String, String> c(String str, c cVar) {
        return (cVar == null || TextUtils.isEmpty(str)) ? new HashMap() : cVar.b(str);
    }

    private Map<String, String> d(String str, c cVar) {
        e eVar = new e();
        try {
            if (str.equals("2000125")) {
                eVar.a("duration", Long.valueOf(cVar.a("2000123")));
            } else if (str.equals("2000126")) {
                eVar.a("duration", Long.valueOf(cVar.a("2000125")));
            } else if (str.equals("2000127")) {
                eVar.a("duration", Long.valueOf(cVar.a("2000123")));
            } else if (str.equals("2000154")) {
                eVar.a("duration", Long.valueOf(cVar.a("2000126")));
            } else if (str.equals("2000047") || str.equals("2000048")) {
                eVar.a("duration", Long.valueOf(cVar.a("2000123")));
            } else if (str.equals("2000155")) {
                eVar.a("duration", Long.valueOf(cVar.a("2000154")));
            } else if (str.equals("2000146")) {
                eVar.a("duration", Long.valueOf(cVar.a("2000130")));
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return eVar.a();
    }

    public void a(String str, m mVar, c cVar, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        Map<String, String> mapD;
        HashMap map = new HashMap();
        if (cVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            cVar.i(str);
            Map<String, String> mapB = b(str, cVar);
            if (mapB != null) {
                map.putAll(mapB);
            }
            Map<String, String> mapA = a(str, cVar.w(), mVar);
            if (mapA != null) {
                map.putAll(mapA);
            }
            if (Arrays.asList(b.d).contains(str) && (mapD = d(str, cVar)) != null) {
                map.putAll(mapD);
            }
            Map<String, String> mapA2 = a(str, cVar);
            if (mapA2 != null) {
                map.putAll(mapA2);
            }
            if (!map.containsKey("lrid") || TextUtils.isEmpty(map.get("lrid"))) {
                map.put("lrid", cVar.o());
            }
            if (map.containsKey("lrid")) {
                String str2 = map.get("lrid");
                if (!TextUtils.isEmpty(str2) && str2.contains("label_second")) {
                    map.put("lrid", str2.replace("label_second", ""));
                }
            }
            if (map.containsKey("n_lrid")) {
                String str3 = map.get("n_lrid");
                if (!TextUtils.isEmpty(str3) && str3.contains("label_second")) {
                    map.put("n_lrid", str3.replace("n_lrid", ""));
                }
            }
            Map<String, String> mapC = c(str, cVar);
            if (mapC != null) {
                map.putAll(mapC);
            }
            String str4 = "1";
            if (cVar.c() == null || !cVar.c().equals("1") || !Arrays.asList(b.b).contains(str) || cVar.a() == 296) {
                if (Arrays.asList(b.m).contains(str)) {
                    map.put("use_local_dns", i.b().e() ? "1" : "0");
                    if (!i.b().d()) {
                        str4 = "0";
                    }
                    map.put("local_dns_available", str4);
                }
                com.mbridge.msdk.tracker.e eVarA = a(str, map);
                if (mVar != null && eVarA != null) {
                    mVar.d(eVarA);
                }
                if (aVar != null) {
                    aVar.a();
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void b(String str, m mVar, c cVar, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        if (cVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap map = new HashMap();
            cVar.i(str);
            Map<String, String> mapA = a(str, cVar.w(), mVar);
            if (mapA != null) {
                map.putAll(mapA);
            }
            Map<String, String> mapA2 = a(str, cVar);
            if (mapA2 != null) {
                map.putAll(mapA2);
            }
            Map<String, String> mapC = c(str, cVar);
            if (mapC != null) {
                map.putAll(mapC);
            }
            com.mbridge.msdk.tracker.e eVarA = a(str, map);
            if (mVar != null && eVarA != null) {
                mVar.d(eVarA);
            }
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0051  */
    /* JADX WARN: Code duplicated, block: B:286:0x0783 A[Catch: Exception -> 0x080c, TryCatch #2 {Exception -> 0x080c, blocks: (B:3:0x001b, B:5:0x0027, B:8:0x002e, B:10:0x003a, B:38:0x00a4, B:40:0x00aa, B:47:0x00c6, B:49:0x00cc, B:51:0x00d1, B:54:0x00f2, B:56:0x00f8, B:63:0x0125, B:65:0x0129, B:66:0x012c, B:67:0x0130, B:69:0x0136, B:72:0x013f, B:74:0x016d, B:76:0x01ca, B:78:0x01d4, B:80:0x01e7, B:81:0x01f0, B:83:0x0203, B:85:0x0212, B:86:0x021f, B:89:0x0227, B:91:0x022d, B:93:0x0233, B:94:0x0254, B:95:0x025f, B:97:0x0269, B:99:0x026f, B:102:0x02a2, B:104:0x02aa, B:106:0x02b0, B:107:0x02d1, B:108:0x02dc, B:110:0x02e4, B:112:0x02ea, B:113:0x030b, B:114:0x0316, B:116:0x031e, B:118:0x0324, B:119:0x0345, B:120:0x0350, B:123:0x0365, B:125:0x036f, B:126:0x0375, B:127:0x037a, B:129:0x0380, B:131:0x038e, B:134:0x039e, B:136:0x03a4, B:143:0x03f0, B:145:0x03fa, B:148:0x0406, B:150:0x040c, B:151:0x0427, B:152:0x042b, B:154:0x0431, B:155:0x044c, B:156:0x044f, B:158:0x0459, B:160:0x0467, B:161:0x048a, B:162:0x0493, B:165:0x049c, B:167:0x04a2, B:173:0x04e5, B:177:0x04f1, B:179:0x0508, B:181:0x0530, B:183:0x0537, B:185:0x055f, B:187:0x0563, B:189:0x0573, B:190:0x0578, B:192:0x0582, B:193:0x058b, B:195:0x0591, B:196:0x059e, B:198:0x05bc, B:200:0x05c3, B:201:0x05d0, B:203:0x05da, B:204:0x05e3, B:206:0x05eb, B:208:0x05f2, B:209:0x05ff, B:211:0x0609, B:212:0x0612, B:213:0x061f, B:215:0x0627, B:219:0x063b, B:222:0x0649, B:224:0x066f, B:226:0x0675, B:228:0x067a, B:227:0x0678, B:229:0x0681, B:231:0x0689, B:233:0x068f, B:235:0x0694, B:234:0x0692, B:236:0x069b, B:239:0x06a5, B:241:0x06ad, B:242:0x06b5, B:244:0x06c1, B:246:0x06c7, B:248:0x06cc, B:250:0x06db, B:252:0x06e1, B:254:0x06e6, B:258:0x06f7, B:262:0x0717, B:264:0x0720, B:267:0x073b, B:269:0x0747, B:275:0x0755, B:277:0x0761, B:279:0x076b, B:286:0x0783, B:288:0x0796, B:290:0x079c, B:292:0x07a1, B:291:0x079f, B:287:0x078d, B:280:0x0774, B:282:0x077a, B:302:0x07dc, B:293:0x07a9, B:295:0x07b7, B:297:0x07ca, B:299:0x07d0, B:301:0x07d5, B:300:0x07d3, B:296:0x07c1, B:265:0x072b, B:261:0x0713, B:253:0x06e4, B:247:0x06ca, B:184:0x0558, B:180:0x0529, B:168:0x04bd, B:169:0x04c1, B:171:0x04c7, B:172:0x04e2, B:137:0x03c1, B:138:0x03c7, B:140:0x03cf, B:141:0x03ea, B:100:0x0292, B:82:0x01fa, B:75:0x01ac, B:41:0x00b2, B:43:0x00b8, B:46:0x00c3, B:44:0x00bd, B:19:0x005e, B:23:0x0072, B:26:0x007b, B:28:0x0081, B:31:0x008c, B:33:0x0092, B:29:0x0086, B:35:0x0098, B:18:0x0055, B:11:0x003f, B:13:0x0045, B:58:0x0104, B:60:0x011f), top: B:314:0x001b, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:287:0x078d A[Catch: Exception -> 0x080c, TryCatch #2 {Exception -> 0x080c, blocks: (B:3:0x001b, B:5:0x0027, B:8:0x002e, B:10:0x003a, B:38:0x00a4, B:40:0x00aa, B:47:0x00c6, B:49:0x00cc, B:51:0x00d1, B:54:0x00f2, B:56:0x00f8, B:63:0x0125, B:65:0x0129, B:66:0x012c, B:67:0x0130, B:69:0x0136, B:72:0x013f, B:74:0x016d, B:76:0x01ca, B:78:0x01d4, B:80:0x01e7, B:81:0x01f0, B:83:0x0203, B:85:0x0212, B:86:0x021f, B:89:0x0227, B:91:0x022d, B:93:0x0233, B:94:0x0254, B:95:0x025f, B:97:0x0269, B:99:0x026f, B:102:0x02a2, B:104:0x02aa, B:106:0x02b0, B:107:0x02d1, B:108:0x02dc, B:110:0x02e4, B:112:0x02ea, B:113:0x030b, B:114:0x0316, B:116:0x031e, B:118:0x0324, B:119:0x0345, B:120:0x0350, B:123:0x0365, B:125:0x036f, B:126:0x0375, B:127:0x037a, B:129:0x0380, B:131:0x038e, B:134:0x039e, B:136:0x03a4, B:143:0x03f0, B:145:0x03fa, B:148:0x0406, B:150:0x040c, B:151:0x0427, B:152:0x042b, B:154:0x0431, B:155:0x044c, B:156:0x044f, B:158:0x0459, B:160:0x0467, B:161:0x048a, B:162:0x0493, B:165:0x049c, B:167:0x04a2, B:173:0x04e5, B:177:0x04f1, B:179:0x0508, B:181:0x0530, B:183:0x0537, B:185:0x055f, B:187:0x0563, B:189:0x0573, B:190:0x0578, B:192:0x0582, B:193:0x058b, B:195:0x0591, B:196:0x059e, B:198:0x05bc, B:200:0x05c3, B:201:0x05d0, B:203:0x05da, B:204:0x05e3, B:206:0x05eb, B:208:0x05f2, B:209:0x05ff, B:211:0x0609, B:212:0x0612, B:213:0x061f, B:215:0x0627, B:219:0x063b, B:222:0x0649, B:224:0x066f, B:226:0x0675, B:228:0x067a, B:227:0x0678, B:229:0x0681, B:231:0x0689, B:233:0x068f, B:235:0x0694, B:234:0x0692, B:236:0x069b, B:239:0x06a5, B:241:0x06ad, B:242:0x06b5, B:244:0x06c1, B:246:0x06c7, B:248:0x06cc, B:250:0x06db, B:252:0x06e1, B:254:0x06e6, B:258:0x06f7, B:262:0x0717, B:264:0x0720, B:267:0x073b, B:269:0x0747, B:275:0x0755, B:277:0x0761, B:279:0x076b, B:286:0x0783, B:288:0x0796, B:290:0x079c, B:292:0x07a1, B:291:0x079f, B:287:0x078d, B:280:0x0774, B:282:0x077a, B:302:0x07dc, B:293:0x07a9, B:295:0x07b7, B:297:0x07ca, B:299:0x07d0, B:301:0x07d5, B:300:0x07d3, B:296:0x07c1, B:265:0x072b, B:261:0x0713, B:253:0x06e4, B:247:0x06ca, B:184:0x0558, B:180:0x0529, B:168:0x04bd, B:169:0x04c1, B:171:0x04c7, B:172:0x04e2, B:137:0x03c1, B:138:0x03c7, B:140:0x03cf, B:141:0x03ea, B:100:0x0292, B:82:0x01fa, B:75:0x01ac, B:41:0x00b2, B:43:0x00b8, B:46:0x00c3, B:44:0x00bd, B:19:0x005e, B:23:0x0072, B:26:0x007b, B:28:0x0081, B:31:0x008c, B:33:0x0092, B:29:0x0086, B:35:0x0098, B:18:0x0055, B:11:0x003f, B:13:0x0045, B:58:0x0104, B:60:0x011f), top: B:314:0x001b, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:290:0x079c A[Catch: Exception -> 0x080c, TryCatch #2 {Exception -> 0x080c, blocks: (B:3:0x001b, B:5:0x0027, B:8:0x002e, B:10:0x003a, B:38:0x00a4, B:40:0x00aa, B:47:0x00c6, B:49:0x00cc, B:51:0x00d1, B:54:0x00f2, B:56:0x00f8, B:63:0x0125, B:65:0x0129, B:66:0x012c, B:67:0x0130, B:69:0x0136, B:72:0x013f, B:74:0x016d, B:76:0x01ca, B:78:0x01d4, B:80:0x01e7, B:81:0x01f0, B:83:0x0203, B:85:0x0212, B:86:0x021f, B:89:0x0227, B:91:0x022d, B:93:0x0233, B:94:0x0254, B:95:0x025f, B:97:0x0269, B:99:0x026f, B:102:0x02a2, B:104:0x02aa, B:106:0x02b0, B:107:0x02d1, B:108:0x02dc, B:110:0x02e4, B:112:0x02ea, B:113:0x030b, B:114:0x0316, B:116:0x031e, B:118:0x0324, B:119:0x0345, B:120:0x0350, B:123:0x0365, B:125:0x036f, B:126:0x0375, B:127:0x037a, B:129:0x0380, B:131:0x038e, B:134:0x039e, B:136:0x03a4, B:143:0x03f0, B:145:0x03fa, B:148:0x0406, B:150:0x040c, B:151:0x0427, B:152:0x042b, B:154:0x0431, B:155:0x044c, B:156:0x044f, B:158:0x0459, B:160:0x0467, B:161:0x048a, B:162:0x0493, B:165:0x049c, B:167:0x04a2, B:173:0x04e5, B:177:0x04f1, B:179:0x0508, B:181:0x0530, B:183:0x0537, B:185:0x055f, B:187:0x0563, B:189:0x0573, B:190:0x0578, B:192:0x0582, B:193:0x058b, B:195:0x0591, B:196:0x059e, B:198:0x05bc, B:200:0x05c3, B:201:0x05d0, B:203:0x05da, B:204:0x05e3, B:206:0x05eb, B:208:0x05f2, B:209:0x05ff, B:211:0x0609, B:212:0x0612, B:213:0x061f, B:215:0x0627, B:219:0x063b, B:222:0x0649, B:224:0x066f, B:226:0x0675, B:228:0x067a, B:227:0x0678, B:229:0x0681, B:231:0x0689, B:233:0x068f, B:235:0x0694, B:234:0x0692, B:236:0x069b, B:239:0x06a5, B:241:0x06ad, B:242:0x06b5, B:244:0x06c1, B:246:0x06c7, B:248:0x06cc, B:250:0x06db, B:252:0x06e1, B:254:0x06e6, B:258:0x06f7, B:262:0x0717, B:264:0x0720, B:267:0x073b, B:269:0x0747, B:275:0x0755, B:277:0x0761, B:279:0x076b, B:286:0x0783, B:288:0x0796, B:290:0x079c, B:292:0x07a1, B:291:0x079f, B:287:0x078d, B:280:0x0774, B:282:0x077a, B:302:0x07dc, B:293:0x07a9, B:295:0x07b7, B:297:0x07ca, B:299:0x07d0, B:301:0x07d5, B:300:0x07d3, B:296:0x07c1, B:265:0x072b, B:261:0x0713, B:253:0x06e4, B:247:0x06ca, B:184:0x0558, B:180:0x0529, B:168:0x04bd, B:169:0x04c1, B:171:0x04c7, B:172:0x04e2, B:137:0x03c1, B:138:0x03c7, B:140:0x03cf, B:141:0x03ea, B:100:0x0292, B:82:0x01fa, B:75:0x01ac, B:41:0x00b2, B:43:0x00b8, B:46:0x00c3, B:44:0x00bd, B:19:0x005e, B:23:0x0072, B:26:0x007b, B:28:0x0081, B:31:0x008c, B:33:0x0092, B:29:0x0086, B:35:0x0098, B:18:0x0055, B:11:0x003f, B:13:0x0045, B:58:0x0104, B:60:0x011f), top: B:314:0x001b, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:291:0x079f A[Catch: Exception -> 0x080c, TryCatch #2 {Exception -> 0x080c, blocks: (B:3:0x001b, B:5:0x0027, B:8:0x002e, B:10:0x003a, B:38:0x00a4, B:40:0x00aa, B:47:0x00c6, B:49:0x00cc, B:51:0x00d1, B:54:0x00f2, B:56:0x00f8, B:63:0x0125, B:65:0x0129, B:66:0x012c, B:67:0x0130, B:69:0x0136, B:72:0x013f, B:74:0x016d, B:76:0x01ca, B:78:0x01d4, B:80:0x01e7, B:81:0x01f0, B:83:0x0203, B:85:0x0212, B:86:0x021f, B:89:0x0227, B:91:0x022d, B:93:0x0233, B:94:0x0254, B:95:0x025f, B:97:0x0269, B:99:0x026f, B:102:0x02a2, B:104:0x02aa, B:106:0x02b0, B:107:0x02d1, B:108:0x02dc, B:110:0x02e4, B:112:0x02ea, B:113:0x030b, B:114:0x0316, B:116:0x031e, B:118:0x0324, B:119:0x0345, B:120:0x0350, B:123:0x0365, B:125:0x036f, B:126:0x0375, B:127:0x037a, B:129:0x0380, B:131:0x038e, B:134:0x039e, B:136:0x03a4, B:143:0x03f0, B:145:0x03fa, B:148:0x0406, B:150:0x040c, B:151:0x0427, B:152:0x042b, B:154:0x0431, B:155:0x044c, B:156:0x044f, B:158:0x0459, B:160:0x0467, B:161:0x048a, B:162:0x0493, B:165:0x049c, B:167:0x04a2, B:173:0x04e5, B:177:0x04f1, B:179:0x0508, B:181:0x0530, B:183:0x0537, B:185:0x055f, B:187:0x0563, B:189:0x0573, B:190:0x0578, B:192:0x0582, B:193:0x058b, B:195:0x0591, B:196:0x059e, B:198:0x05bc, B:200:0x05c3, B:201:0x05d0, B:203:0x05da, B:204:0x05e3, B:206:0x05eb, B:208:0x05f2, B:209:0x05ff, B:211:0x0609, B:212:0x0612, B:213:0x061f, B:215:0x0627, B:219:0x063b, B:222:0x0649, B:224:0x066f, B:226:0x0675, B:228:0x067a, B:227:0x0678, B:229:0x0681, B:231:0x0689, B:233:0x068f, B:235:0x0694, B:234:0x0692, B:236:0x069b, B:239:0x06a5, B:241:0x06ad, B:242:0x06b5, B:244:0x06c1, B:246:0x06c7, B:248:0x06cc, B:250:0x06db, B:252:0x06e1, B:254:0x06e6, B:258:0x06f7, B:262:0x0717, B:264:0x0720, B:267:0x073b, B:269:0x0747, B:275:0x0755, B:277:0x0761, B:279:0x076b, B:286:0x0783, B:288:0x0796, B:290:0x079c, B:292:0x07a1, B:291:0x079f, B:287:0x078d, B:280:0x0774, B:282:0x077a, B:302:0x07dc, B:293:0x07a9, B:295:0x07b7, B:297:0x07ca, B:299:0x07d0, B:301:0x07d5, B:300:0x07d3, B:296:0x07c1, B:265:0x072b, B:261:0x0713, B:253:0x06e4, B:247:0x06ca, B:184:0x0558, B:180:0x0529, B:168:0x04bd, B:169:0x04c1, B:171:0x04c7, B:172:0x04e2, B:137:0x03c1, B:138:0x03c7, B:140:0x03cf, B:141:0x03ea, B:100:0x0292, B:82:0x01fa, B:75:0x01ac, B:41:0x00b2, B:43:0x00b8, B:46:0x00c3, B:44:0x00bd, B:19:0x005e, B:23:0x0072, B:26:0x007b, B:28:0x0081, B:31:0x008c, B:33:0x0092, B:29:0x0086, B:35:0x0098, B:18:0x0055, B:11:0x003f, B:13:0x0045, B:58:0x0104, B:60:0x011f), top: B:314:0x001b, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:307:0x0811  */
    /* JADX WARN: Code duplicated, block: B:40:0x00aa A[Catch: Exception -> 0x080c, TryCatch #2 {Exception -> 0x080c, blocks: (B:3:0x001b, B:5:0x0027, B:8:0x002e, B:10:0x003a, B:38:0x00a4, B:40:0x00aa, B:47:0x00c6, B:49:0x00cc, B:51:0x00d1, B:54:0x00f2, B:56:0x00f8, B:63:0x0125, B:65:0x0129, B:66:0x012c, B:67:0x0130, B:69:0x0136, B:72:0x013f, B:74:0x016d, B:76:0x01ca, B:78:0x01d4, B:80:0x01e7, B:81:0x01f0, B:83:0x0203, B:85:0x0212, B:86:0x021f, B:89:0x0227, B:91:0x022d, B:93:0x0233, B:94:0x0254, B:95:0x025f, B:97:0x0269, B:99:0x026f, B:102:0x02a2, B:104:0x02aa, B:106:0x02b0, B:107:0x02d1, B:108:0x02dc, B:110:0x02e4, B:112:0x02ea, B:113:0x030b, B:114:0x0316, B:116:0x031e, B:118:0x0324, B:119:0x0345, B:120:0x0350, B:123:0x0365, B:125:0x036f, B:126:0x0375, B:127:0x037a, B:129:0x0380, B:131:0x038e, B:134:0x039e, B:136:0x03a4, B:143:0x03f0, B:145:0x03fa, B:148:0x0406, B:150:0x040c, B:151:0x0427, B:152:0x042b, B:154:0x0431, B:155:0x044c, B:156:0x044f, B:158:0x0459, B:160:0x0467, B:161:0x048a, B:162:0x0493, B:165:0x049c, B:167:0x04a2, B:173:0x04e5, B:177:0x04f1, B:179:0x0508, B:181:0x0530, B:183:0x0537, B:185:0x055f, B:187:0x0563, B:189:0x0573, B:190:0x0578, B:192:0x0582, B:193:0x058b, B:195:0x0591, B:196:0x059e, B:198:0x05bc, B:200:0x05c3, B:201:0x05d0, B:203:0x05da, B:204:0x05e3, B:206:0x05eb, B:208:0x05f2, B:209:0x05ff, B:211:0x0609, B:212:0x0612, B:213:0x061f, B:215:0x0627, B:219:0x063b, B:222:0x0649, B:224:0x066f, B:226:0x0675, B:228:0x067a, B:227:0x0678, B:229:0x0681, B:231:0x0689, B:233:0x068f, B:235:0x0694, B:234:0x0692, B:236:0x069b, B:239:0x06a5, B:241:0x06ad, B:242:0x06b5, B:244:0x06c1, B:246:0x06c7, B:248:0x06cc, B:250:0x06db, B:252:0x06e1, B:254:0x06e6, B:258:0x06f7, B:262:0x0717, B:264:0x0720, B:267:0x073b, B:269:0x0747, B:275:0x0755, B:277:0x0761, B:279:0x076b, B:286:0x0783, B:288:0x0796, B:290:0x079c, B:292:0x07a1, B:291:0x079f, B:287:0x078d, B:280:0x0774, B:282:0x077a, B:302:0x07dc, B:293:0x07a9, B:295:0x07b7, B:297:0x07ca, B:299:0x07d0, B:301:0x07d5, B:300:0x07d3, B:296:0x07c1, B:265:0x072b, B:261:0x0713, B:253:0x06e4, B:247:0x06ca, B:184:0x0558, B:180:0x0529, B:168:0x04bd, B:169:0x04c1, B:171:0x04c7, B:172:0x04e2, B:137:0x03c1, B:138:0x03c7, B:140:0x03cf, B:141:0x03ea, B:100:0x0292, B:82:0x01fa, B:75:0x01ac, B:41:0x00b2, B:43:0x00b8, B:46:0x00c3, B:44:0x00bd, B:19:0x005e, B:23:0x0072, B:26:0x007b, B:28:0x0081, B:31:0x008c, B:33:0x0092, B:29:0x0086, B:35:0x0098, B:18:0x0055, B:11:0x003f, B:13:0x0045, B:58:0x0104, B:60:0x011f), top: B:314:0x001b, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b2 A[Catch: Exception -> 0x080c, TryCatch #2 {Exception -> 0x080c, blocks: (B:3:0x001b, B:5:0x0027, B:8:0x002e, B:10:0x003a, B:38:0x00a4, B:40:0x00aa, B:47:0x00c6, B:49:0x00cc, B:51:0x00d1, B:54:0x00f2, B:56:0x00f8, B:63:0x0125, B:65:0x0129, B:66:0x012c, B:67:0x0130, B:69:0x0136, B:72:0x013f, B:74:0x016d, B:76:0x01ca, B:78:0x01d4, B:80:0x01e7, B:81:0x01f0, B:83:0x0203, B:85:0x0212, B:86:0x021f, B:89:0x0227, B:91:0x022d, B:93:0x0233, B:94:0x0254, B:95:0x025f, B:97:0x0269, B:99:0x026f, B:102:0x02a2, B:104:0x02aa, B:106:0x02b0, B:107:0x02d1, B:108:0x02dc, B:110:0x02e4, B:112:0x02ea, B:113:0x030b, B:114:0x0316, B:116:0x031e, B:118:0x0324, B:119:0x0345, B:120:0x0350, B:123:0x0365, B:125:0x036f, B:126:0x0375, B:127:0x037a, B:129:0x0380, B:131:0x038e, B:134:0x039e, B:136:0x03a4, B:143:0x03f0, B:145:0x03fa, B:148:0x0406, B:150:0x040c, B:151:0x0427, B:152:0x042b, B:154:0x0431, B:155:0x044c, B:156:0x044f, B:158:0x0459, B:160:0x0467, B:161:0x048a, B:162:0x0493, B:165:0x049c, B:167:0x04a2, B:173:0x04e5, B:177:0x04f1, B:179:0x0508, B:181:0x0530, B:183:0x0537, B:185:0x055f, B:187:0x0563, B:189:0x0573, B:190:0x0578, B:192:0x0582, B:193:0x058b, B:195:0x0591, B:196:0x059e, B:198:0x05bc, B:200:0x05c3, B:201:0x05d0, B:203:0x05da, B:204:0x05e3, B:206:0x05eb, B:208:0x05f2, B:209:0x05ff, B:211:0x0609, B:212:0x0612, B:213:0x061f, B:215:0x0627, B:219:0x063b, B:222:0x0649, B:224:0x066f, B:226:0x0675, B:228:0x067a, B:227:0x0678, B:229:0x0681, B:231:0x0689, B:233:0x068f, B:235:0x0694, B:234:0x0692, B:236:0x069b, B:239:0x06a5, B:241:0x06ad, B:242:0x06b5, B:244:0x06c1, B:246:0x06c7, B:248:0x06cc, B:250:0x06db, B:252:0x06e1, B:254:0x06e6, B:258:0x06f7, B:262:0x0717, B:264:0x0720, B:267:0x073b, B:269:0x0747, B:275:0x0755, B:277:0x0761, B:279:0x076b, B:286:0x0783, B:288:0x0796, B:290:0x079c, B:292:0x07a1, B:291:0x079f, B:287:0x078d, B:280:0x0774, B:282:0x077a, B:302:0x07dc, B:293:0x07a9, B:295:0x07b7, B:297:0x07ca, B:299:0x07d0, B:301:0x07d5, B:300:0x07d3, B:296:0x07c1, B:265:0x072b, B:261:0x0713, B:253:0x06e4, B:247:0x06ca, B:184:0x0558, B:180:0x0529, B:168:0x04bd, B:169:0x04c1, B:171:0x04c7, B:172:0x04e2, B:137:0x03c1, B:138:0x03c7, B:140:0x03cf, B:141:0x03ea, B:100:0x0292, B:82:0x01fa, B:75:0x01ac, B:41:0x00b2, B:43:0x00b8, B:46:0x00c3, B:44:0x00bd, B:19:0x005e, B:23:0x0072, B:26:0x007b, B:28:0x0081, B:31:0x008c, B:33:0x0092, B:29:0x0086, B:35:0x0098, B:18:0x0055, B:11:0x003f, B:13:0x0045, B:58:0x0104, B:60:0x011f), top: B:314:0x001b, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b8 A[Catch: Exception -> 0x080c, TryCatch #2 {Exception -> 0x080c, blocks: (B:3:0x001b, B:5:0x0027, B:8:0x002e, B:10:0x003a, B:38:0x00a4, B:40:0x00aa, B:47:0x00c6, B:49:0x00cc, B:51:0x00d1, B:54:0x00f2, B:56:0x00f8, B:63:0x0125, B:65:0x0129, B:66:0x012c, B:67:0x0130, B:69:0x0136, B:72:0x013f, B:74:0x016d, B:76:0x01ca, B:78:0x01d4, B:80:0x01e7, B:81:0x01f0, B:83:0x0203, B:85:0x0212, B:86:0x021f, B:89:0x0227, B:91:0x022d, B:93:0x0233, B:94:0x0254, B:95:0x025f, B:97:0x0269, B:99:0x026f, B:102:0x02a2, B:104:0x02aa, B:106:0x02b0, B:107:0x02d1, B:108:0x02dc, B:110:0x02e4, B:112:0x02ea, B:113:0x030b, B:114:0x0316, B:116:0x031e, B:118:0x0324, B:119:0x0345, B:120:0x0350, B:123:0x0365, B:125:0x036f, B:126:0x0375, B:127:0x037a, B:129:0x0380, B:131:0x038e, B:134:0x039e, B:136:0x03a4, B:143:0x03f0, B:145:0x03fa, B:148:0x0406, B:150:0x040c, B:151:0x0427, B:152:0x042b, B:154:0x0431, B:155:0x044c, B:156:0x044f, B:158:0x0459, B:160:0x0467, B:161:0x048a, B:162:0x0493, B:165:0x049c, B:167:0x04a2, B:173:0x04e5, B:177:0x04f1, B:179:0x0508, B:181:0x0530, B:183:0x0537, B:185:0x055f, B:187:0x0563, B:189:0x0573, B:190:0x0578, B:192:0x0582, B:193:0x058b, B:195:0x0591, B:196:0x059e, B:198:0x05bc, B:200:0x05c3, B:201:0x05d0, B:203:0x05da, B:204:0x05e3, B:206:0x05eb, B:208:0x05f2, B:209:0x05ff, B:211:0x0609, B:212:0x0612, B:213:0x061f, B:215:0x0627, B:219:0x063b, B:222:0x0649, B:224:0x066f, B:226:0x0675, B:228:0x067a, B:227:0x0678, B:229:0x0681, B:231:0x0689, B:233:0x068f, B:235:0x0694, B:234:0x0692, B:236:0x069b, B:239:0x06a5, B:241:0x06ad, B:242:0x06b5, B:244:0x06c1, B:246:0x06c7, B:248:0x06cc, B:250:0x06db, B:252:0x06e1, B:254:0x06e6, B:258:0x06f7, B:262:0x0717, B:264:0x0720, B:267:0x073b, B:269:0x0747, B:275:0x0755, B:277:0x0761, B:279:0x076b, B:286:0x0783, B:288:0x0796, B:290:0x079c, B:292:0x07a1, B:291:0x079f, B:287:0x078d, B:280:0x0774, B:282:0x077a, B:302:0x07dc, B:293:0x07a9, B:295:0x07b7, B:297:0x07ca, B:299:0x07d0, B:301:0x07d5, B:300:0x07d3, B:296:0x07c1, B:265:0x072b, B:261:0x0713, B:253:0x06e4, B:247:0x06ca, B:184:0x0558, B:180:0x0529, B:168:0x04bd, B:169:0x04c1, B:171:0x04c7, B:172:0x04e2, B:137:0x03c1, B:138:0x03c7, B:140:0x03cf, B:141:0x03ea, B:100:0x0292, B:82:0x01fa, B:75:0x01ac, B:41:0x00b2, B:43:0x00b8, B:46:0x00c3, B:44:0x00bd, B:19:0x005e, B:23:0x0072, B:26:0x007b, B:28:0x0081, B:31:0x008c, B:33:0x0092, B:29:0x0086, B:35:0x0098, B:18:0x0055, B:11:0x003f, B:13:0x0045, B:58:0x0104, B:60:0x011f), top: B:314:0x001b, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00bd A[Catch: Exception -> 0x080c, TryCatch #2 {Exception -> 0x080c, blocks: (B:3:0x001b, B:5:0x0027, B:8:0x002e, B:10:0x003a, B:38:0x00a4, B:40:0x00aa, B:47:0x00c6, B:49:0x00cc, B:51:0x00d1, B:54:0x00f2, B:56:0x00f8, B:63:0x0125, B:65:0x0129, B:66:0x012c, B:67:0x0130, B:69:0x0136, B:72:0x013f, B:74:0x016d, B:76:0x01ca, B:78:0x01d4, B:80:0x01e7, B:81:0x01f0, B:83:0x0203, B:85:0x0212, B:86:0x021f, B:89:0x0227, B:91:0x022d, B:93:0x0233, B:94:0x0254, B:95:0x025f, B:97:0x0269, B:99:0x026f, B:102:0x02a2, B:104:0x02aa, B:106:0x02b0, B:107:0x02d1, B:108:0x02dc, B:110:0x02e4, B:112:0x02ea, B:113:0x030b, B:114:0x0316, B:116:0x031e, B:118:0x0324, B:119:0x0345, B:120:0x0350, B:123:0x0365, B:125:0x036f, B:126:0x0375, B:127:0x037a, B:129:0x0380, B:131:0x038e, B:134:0x039e, B:136:0x03a4, B:143:0x03f0, B:145:0x03fa, B:148:0x0406, B:150:0x040c, B:151:0x0427, B:152:0x042b, B:154:0x0431, B:155:0x044c, B:156:0x044f, B:158:0x0459, B:160:0x0467, B:161:0x048a, B:162:0x0493, B:165:0x049c, B:167:0x04a2, B:173:0x04e5, B:177:0x04f1, B:179:0x0508, B:181:0x0530, B:183:0x0537, B:185:0x055f, B:187:0x0563, B:189:0x0573, B:190:0x0578, B:192:0x0582, B:193:0x058b, B:195:0x0591, B:196:0x059e, B:198:0x05bc, B:200:0x05c3, B:201:0x05d0, B:203:0x05da, B:204:0x05e3, B:206:0x05eb, B:208:0x05f2, B:209:0x05ff, B:211:0x0609, B:212:0x0612, B:213:0x061f, B:215:0x0627, B:219:0x063b, B:222:0x0649, B:224:0x066f, B:226:0x0675, B:228:0x067a, B:227:0x0678, B:229:0x0681, B:231:0x0689, B:233:0x068f, B:235:0x0694, B:234:0x0692, B:236:0x069b, B:239:0x06a5, B:241:0x06ad, B:242:0x06b5, B:244:0x06c1, B:246:0x06c7, B:248:0x06cc, B:250:0x06db, B:252:0x06e1, B:254:0x06e6, B:258:0x06f7, B:262:0x0717, B:264:0x0720, B:267:0x073b, B:269:0x0747, B:275:0x0755, B:277:0x0761, B:279:0x076b, B:286:0x0783, B:288:0x0796, B:290:0x079c, B:292:0x07a1, B:291:0x079f, B:287:0x078d, B:280:0x0774, B:282:0x077a, B:302:0x07dc, B:293:0x07a9, B:295:0x07b7, B:297:0x07ca, B:299:0x07d0, B:301:0x07d5, B:300:0x07d3, B:296:0x07c1, B:265:0x072b, B:261:0x0713, B:253:0x06e4, B:247:0x06ca, B:184:0x0558, B:180:0x0529, B:168:0x04bd, B:169:0x04c1, B:171:0x04c7, B:172:0x04e2, B:137:0x03c1, B:138:0x03c7, B:140:0x03cf, B:141:0x03ea, B:100:0x0292, B:82:0x01fa, B:75:0x01ac, B:41:0x00b2, B:43:0x00b8, B:46:0x00c3, B:44:0x00bd, B:19:0x005e, B:23:0x0072, B:26:0x007b, B:28:0x0081, B:31:0x008c, B:33:0x0092, B:29:0x0086, B:35:0x0098, B:18:0x0055, B:11:0x003f, B:13:0x0045, B:58:0x0104, B:60:0x011f), top: B:314:0x001b, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c3 A[Catch: Exception -> 0x080c, TryCatch #2 {Exception -> 0x080c, blocks: (B:3:0x001b, B:5:0x0027, B:8:0x002e, B:10:0x003a, B:38:0x00a4, B:40:0x00aa, B:47:0x00c6, B:49:0x00cc, B:51:0x00d1, B:54:0x00f2, B:56:0x00f8, B:63:0x0125, B:65:0x0129, B:66:0x012c, B:67:0x0130, B:69:0x0136, B:72:0x013f, B:74:0x016d, B:76:0x01ca, B:78:0x01d4, B:80:0x01e7, B:81:0x01f0, B:83:0x0203, B:85:0x0212, B:86:0x021f, B:89:0x0227, B:91:0x022d, B:93:0x0233, B:94:0x0254, B:95:0x025f, B:97:0x0269, B:99:0x026f, B:102:0x02a2, B:104:0x02aa, B:106:0x02b0, B:107:0x02d1, B:108:0x02dc, B:110:0x02e4, B:112:0x02ea, B:113:0x030b, B:114:0x0316, B:116:0x031e, B:118:0x0324, B:119:0x0345, B:120:0x0350, B:123:0x0365, B:125:0x036f, B:126:0x0375, B:127:0x037a, B:129:0x0380, B:131:0x038e, B:134:0x039e, B:136:0x03a4, B:143:0x03f0, B:145:0x03fa, B:148:0x0406, B:150:0x040c, B:151:0x0427, B:152:0x042b, B:154:0x0431, B:155:0x044c, B:156:0x044f, B:158:0x0459, B:160:0x0467, B:161:0x048a, B:162:0x0493, B:165:0x049c, B:167:0x04a2, B:173:0x04e5, B:177:0x04f1, B:179:0x0508, B:181:0x0530, B:183:0x0537, B:185:0x055f, B:187:0x0563, B:189:0x0573, B:190:0x0578, B:192:0x0582, B:193:0x058b, B:195:0x0591, B:196:0x059e, B:198:0x05bc, B:200:0x05c3, B:201:0x05d0, B:203:0x05da, B:204:0x05e3, B:206:0x05eb, B:208:0x05f2, B:209:0x05ff, B:211:0x0609, B:212:0x0612, B:213:0x061f, B:215:0x0627, B:219:0x063b, B:222:0x0649, B:224:0x066f, B:226:0x0675, B:228:0x067a, B:227:0x0678, B:229:0x0681, B:231:0x0689, B:233:0x068f, B:235:0x0694, B:234:0x0692, B:236:0x069b, B:239:0x06a5, B:241:0x06ad, B:242:0x06b5, B:244:0x06c1, B:246:0x06c7, B:248:0x06cc, B:250:0x06db, B:252:0x06e1, B:254:0x06e6, B:258:0x06f7, B:262:0x0717, B:264:0x0720, B:267:0x073b, B:269:0x0747, B:275:0x0755, B:277:0x0761, B:279:0x076b, B:286:0x0783, B:288:0x0796, B:290:0x079c, B:292:0x07a1, B:291:0x079f, B:287:0x078d, B:280:0x0774, B:282:0x077a, B:302:0x07dc, B:293:0x07a9, B:295:0x07b7, B:297:0x07ca, B:299:0x07d0, B:301:0x07d5, B:300:0x07d3, B:296:0x07c1, B:265:0x072b, B:261:0x0713, B:253:0x06e4, B:247:0x06ca, B:184:0x0558, B:180:0x0529, B:168:0x04bd, B:169:0x04c1, B:171:0x04c7, B:172:0x04e2, B:137:0x03c1, B:138:0x03c7, B:140:0x03cf, B:141:0x03ea, B:100:0x0292, B:82:0x01fa, B:75:0x01ac, B:41:0x00b2, B:43:0x00b8, B:46:0x00c3, B:44:0x00bd, B:19:0x005e, B:23:0x0072, B:26:0x007b, B:28:0x0081, B:31:0x008c, B:33:0x0092, B:29:0x0086, B:35:0x0098, B:18:0x0055, B:11:0x003f, B:13:0x0045, B:58:0x0104, B:60:0x011f), top: B:314:0x001b, inners: #1, #3 }] */
    private Map<String, String> b(String str, c cVar) {
        String str2;
        String str3;
        boolean z;
        boolean zContains;
        int i;
        List<CampaignEx> listG;
        String str4 = "rid_n";
        String str5 = "cid";
        String str6 = CampaignEx.JSON_KEY_EC_TEMP_ID;
        e eVar = new e();
        try {
            if (Arrays.asList(b.g).contains(str)) {
                return eVar.a();
            }
            if (cVar == null) {
                eVar.a("metrics_data_reason", "metrics 上报时意外为空");
                return eVar.a();
            }
            List arrayList = new ArrayList();
            try {
                if (cVar.i() == null || cVar.i().getAdType() != 295) {
                    if (Arrays.asList(b.f).contains(str)) {
                        try {
                            if (!"m_download_start".equals(str) && !"m_download_end".equals(str)) {
                                List<CampaignEx> listJ = cVar.j() != null ? cVar.j() : cVar.g();
                                if (listJ != null && listJ.size() > 0) {
                                    arrayList.addAll(listJ);
                                }
                            } else {
                                arrayList = a(cVar, str);
                            }
                        } catch (Exception e) {
                            e = e;
                            if (MBridgeConstans.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    } else if (cVar.i() != null) {
                        arrayList.add(cVar.i());
                    } else {
                        if (cVar.j() != null) {
                            listG = cVar.j();
                        } else {
                            listG = cVar.g();
                        }
                        if (listG != null) {
                            arrayList.addAll(listG);
                        }
                    }
                } else if (cVar.i() != null) {
                    arrayList.add(cVar.i());
                } else {
                    if (cVar.j() != null) {
                        listG = cVar.j();
                    } else {
                        listG = cVar.g();
                    }
                    if (listG != null) {
                        arrayList.addAll(listG);
                    }
                }
            } catch (Throwable th) {
                o0.b("SameMetricsReport", th.getMessage());
            }
            if (arrayList.isEmpty()) {
                return eVar.a();
            }
            Map<String, Map<String, String>> mapR = cVar.r();
            String str7 = cVar.o() + str;
            if (mapR.containsKey(str7) && mapR.get(str7) != null && mapR.get(str7).containsKey("126_exclude")) {
                try {
                    String str8 = mapR.get(str7).get("126_exclude");
                    mapR.get(str7).remove("126_exclude");
                    if ("1".equals(str8)) {
                        return eVar.a();
                    }
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CampaignEx campaignEx = (CampaignEx) it.next();
                if (campaignEx != null) {
                    eVar.a(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(campaignEx.getFilterCallBackState()));
                    eVar.a("r_index", Integer.valueOf(campaignEx.getSecondRequestIndex()));
                    eVar.a("s_show_index", Integer.valueOf(campaignEx.getSecondShowIndex()));
                    ArrayList<Integer> rsIgnoreCheckRule = campaignEx.getRsIgnoreCheckRule();
                    if (rsIgnoreCheckRule != null) {
                        eVar.a("ignore_video", Integer.valueOf(!rsIgnoreCheckRule.contains(0) ? 1 : 0));
                        eVar.a("ignore_template", Integer.valueOf(!rsIgnoreCheckRule.contains(1) ? 1 : 0));
                        eVar.a("ignore_ec", Integer.valueOf(!rsIgnoreCheckRule.contains(2) ? 1 : 0));
                    } else {
                        eVar.a("ignore_video", 1);
                        eVar.a("ignore_template", 1);
                        eVar.a("ignore_ec", 1);
                    }
                    if (!TextUtils.isEmpty(campaignEx.getNLRid())) {
                        eVar.a("n_lrid", campaignEx.getNLRid());
                        if (!TextUtils.isEmpty(campaignEx.getNRid())) {
                            eVar.a("n_rid", campaignEx.getNRid());
                        }
                        eVar.a("lrid", campaignEx.getLocalRequestId());
                    } else {
                        eVar.a("lrid", campaignEx.getLocalRequestId());
                    }
                    eVar.a(l.x, campaignEx.getRequestId());
                    if (campaignEx.getMof_tplid() != 0) {
                        eVar.a("stid", Integer.valueOf(campaignEx.getMof_tplid()));
                    }
                    CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
                    if (rewardTemplateMode != null && rewardTemplateMode.f() != 0) {
                        if (eVar.a("vtid")) {
                            eVar.a("vtid", eVar.b("vtid") + StringUtils.COMMA + rewardTemplateMode.f());
                        } else {
                            eVar.a("vtid", Integer.valueOf(rewardTemplateMode.f()));
                        }
                    }
                    if (campaignEx.getCreativeId() != 0) {
                        if (eVar.a("crid")) {
                            eVar.a("crid", eVar.b("crid") + StringUtils.COMMA + campaignEx.getCreativeId());
                        } else {
                            eVar.a("crid", Long.valueOf(campaignEx.getCreativeId()));
                        }
                    }
                    if (campaignEx.getVidCrtvId() != 0) {
                        if (eVar.a("video_crid")) {
                            eVar.a("video_crid", eVar.b("video_crid") + StringUtils.COMMA + campaignEx.getVidCrtvId());
                        } else {
                            eVar.a("video_crid", Long.valueOf(campaignEx.getVidCrtvId()));
                        }
                    }
                    if (campaignEx.getEcCrtvId() != 0) {
                        if (eVar.a("endcard_crid")) {
                            eVar.a("endcard_crid", eVar.b("endcard_crid") + StringUtils.COMMA + campaignEx.getEcCrtvId());
                        } else {
                            eVar.a("endcard_crid", Long.valueOf(campaignEx.getEcCrtvId()));
                        }
                    }
                    if (campaignEx.getEcTemplateId() != 0) {
                        if (eVar.a(str6)) {
                            eVar.a(str6, eVar.b(str6) + StringUtils.COMMA + campaignEx.getEcTemplateId());
                        } else {
                            eVar.a(str6, Long.valueOf(campaignEx.getEcTemplateId()));
                        }
                    }
                    eVar.a("bid_tk", campaignEx.getBidToken());
                    if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
                        if (t0.i(campaignEx.getMof_template_url())) {
                            eVar.a("sdyv", "1");
                        } else {
                            eVar.a("sdyv", "2");
                        }
                    }
                    if (campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        str2 = str6;
                    } else if (t0.i(campaignEx.getRewardTemplateMode().e())) {
                        if (eVar.a("vdyv")) {
                            str2 = str6;
                            eVar.a("vdyv", eVar.b("vdyv") + ",1");
                        } else {
                            str2 = str6;
                            eVar.a("vdyv", "1");
                        }
                    } else {
                        str2 = str6;
                        if (eVar.a("vdyv")) {
                            eVar.a("vdyv", eVar.b("vdyv") + ",2");
                        } else {
                            eVar.a("vdyv", "2");
                        }
                    }
                    if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
                        if (t0.i(campaignEx.getendcard_url())) {
                            if (eVar.a("edyv")) {
                                eVar.a("edyv", eVar.b("edyv") + ",1");
                            } else {
                                eVar.a("edyv", "1");
                            }
                        } else if (eVar.a("edyv")) {
                            eVar.a("edyv", eVar.b("edyv") + ",2");
                        } else {
                            eVar.a("edyv", "2");
                        }
                    }
                    if (!TextUtils.isEmpty(campaignEx.getExt_data())) {
                        JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(campaignEx.getExt_data());
                        if (eVar.a(POBConstants.KEY_DSPID)) {
                            eVar.a(POBConstants.KEY_DSPID, eVar.b(POBConstants.KEY_DSPID) + StringUtils.COMMA + jSONObjectJsonObjectInit.optString("par_dspid"));
                        } else {
                            eVar.a(POBConstants.KEY_DSPID, jSONObjectJsonObjectInit.optString("par_dspid"));
                        }
                    }
                    if (campaignEx.getPlayable_ads_without_video() == 2) {
                        if (eVar.a("only_ec")) {
                            eVar.a("only_ec", eVar.b("only_ec") + ",2");
                        } else {
                            eVar.a("only_ec", "2");
                        }
                    } else if (eVar.a("only_ec")) {
                        eVar.a("only_ec", eVar.b("only_ec") + ",1");
                    } else {
                        eVar.a("only_ec", "1");
                    }
                    eVar.a(CampaignEx.JSON_KEY_HB, campaignEx.isBidCampaign() ? "1" : "0");
                    eVar.a(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
                    String str9 = str5;
                    if (eVar.a(str9)) {
                        eVar.a(str9, eVar.b(str9) + StringUtils.COMMA + campaignEx.getId());
                    } else {
                        eVar.a(str9, campaignEx.getId());
                    }
                    String str10 = str4;
                    if (eVar.a(str10)) {
                        eVar.a(str10, eVar.b(str10) + StringUtils.COMMA + campaignEx.getRequestIdNotice());
                    } else {
                        eVar.a(str10, campaignEx.getRequestIdNotice());
                    }
                    HashMap<String, String> map = com.mbridge.msdk.foundation.controller.a.r;
                    if (map != null) {
                        String str11 = map.get(campaignEx.getCampaignUnitId());
                        if (!TextUtils.isEmpty(str11)) {
                            eVar.a("u_stid", str11);
                        }
                    }
                    if (!TextUtils.isEmpty(campaignEx.getCampaignUnitId())) {
                        eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, campaignEx.getCampaignUnitId());
                    }
                    if (campaignEx.getAdType() != 0) {
                        eVar.a("adtp", Integer.valueOf(campaignEx.getAdType()));
                    }
                    eVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(campaignEx.isBidCampaign() ? 1 : 0));
                    eVar.a(CampaignEx.URL_KEY_EXP_IDS, campaignEx.getExpIds());
                    if ("2000047".contains(str)) {
                        if (campaignEx.getTyped() != -1) {
                            eVar.a("type_d", Integer.valueOf(campaignEx.getTyped()));
                        }
                        if (!TextUtils.isEmpty(campaignEx.getReasond())) {
                            eVar.a("reason_d", campaignEx.getReasond());
                        }
                    }
                    if ("2000048".contains(str)) {
                        if (campaignEx.getTyped() != -1) {
                            eVar.a("type", Integer.valueOf(campaignEx.getTyped()));
                        }
                        if (!TextUtils.isEmpty(campaignEx.getReasond())) {
                            eVar.a("reason", campaignEx.getReasond());
                        }
                        eVar.a(CampaignEx.JSON_KEY_RETARGET_TYPE, Integer.valueOf(campaignEx.getRtinsType()));
                    }
                    if (campaignEx.getAdType() == 94 || campaignEx.getAdType() == 287) {
                        if (Arrays.asList(b.j).contains(str)) {
                            eVar.a(CampaignEx.KEY_SHOW_INDEX, Integer.valueOf(campaignEx.getShowIndex()));
                            eVar.a("trigger_show_type", Integer.valueOf(campaignEx.getShowType()));
                            if (Arrays.asList(b.l).contains(str)) {
                                eVar.a("temp_display_type", Integer.valueOf(campaignEx.isTemplateRenderSucc() ? a.e : a.f));
                            }
                            if (str.equals("2000147")) {
                                eVar.a("temp_display_type", Integer.valueOf(campaignEx.isECTemplateRenderSucc() ? a.e : a.f));
                            }
                        }
                        if (TextUtils.equals(str, "2000130")) {
                            String strE = "";
                            if (campaignEx.getRewardTemplateMode() != null) {
                                strE = campaignEx.getRewardTemplateMode().e();
                            }
                            String str12 = campaignEx.getendcard_url();
                            eVar.a("ec_full_screen_click", Integer.valueOf((TextUtils.isEmpty(str12) || !str12.contains("alecfc=1")) ? a.h : a.g));
                            eVar.a("temp_full_screen_click", Integer.valueOf((TextUtils.isEmpty(strE) || !strE.contains("alecfc=1")) ? a.h : a.g));
                            boolean z2 = campaignEx.getPlayable_ads_without_video() == 2;
                            str3 = str9;
                            com.mbridge.msdk.videocommon.setting.c cVarC = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), cVar.w());
                            eVar.a("video_skip_result", Integer.valueOf(cVarC == null ? 2 : cVarC.E()));
                            if (z2) {
                                eVar.a(CampaignEx.VIDEO_END_TYPE, 2);
                            } else {
                                eVar.a(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
                            }
                        } else {
                            str3 = str9;
                        }
                        if (Arrays.asList(b.k).contains(str)) {
                            int clickTempSource = campaignEx.getClickTempSource();
                            if (clickTempSource == 1) {
                                if (campaignEx.getRewardTemplateMode().e().contains("alecfc=1")) {
                                    eVar.a("full_screen_click", Integer.valueOf(a.g));
                                } else {
                                    eVar.a("full_screen_click", Integer.valueOf(a.h));
                                }
                                eVar.a("temp_display_type", Integer.valueOf(campaignEx.isTemplateRenderSucc() ? a.e : a.f));
                            } else if (clickTempSource == 2) {
                                String str13 = campaignEx.getendcard_url();
                                if (campaignEx.getMof_tplid() == 501 && !TextUtils.isEmpty(campaignEx.getMof_template_url())) {
                                    zContains = campaignEx.getMof_template_url().contains("alecfc=1");
                                } else {
                                    if (TextUtils.isEmpty(str13)) {
                                        z = false;
                                    } else {
                                        zContains = str13.contains("alecfc=1");
                                    }
                                    if (z) {
                                        eVar.a("full_screen_click", Integer.valueOf(a.g));
                                    } else {
                                        eVar.a("full_screen_click", Integer.valueOf(a.h));
                                    }
                                    if (campaignEx.isECTemplateRenderSucc()) {
                                        i = a.e;
                                    } else {
                                        i = a.f;
                                    }
                                    eVar.a("temp_display_type", Integer.valueOf(i));
                                }
                                z = zContains;
                                if (z) {
                                    eVar.a("full_screen_click", Integer.valueOf(a.g));
                                } else {
                                    eVar.a("full_screen_click", Integer.valueOf(a.h));
                                }
                                if (campaignEx.isECTemplateRenderSucc()) {
                                    i = a.e;
                                } else {
                                    i = a.f;
                                }
                                eVar.a("temp_display_type", Integer.valueOf(i));
                            }
                            eVar.a(CampaignEx.KEY_CLICK_TEMP_SOURCE, Integer.valueOf(campaignEx.getClickTempSource()));
                            eVar.a("trigger_click_type", Integer.valueOf(campaignEx.getClickType()));
                            eVar.a(CampaignEx.KEY_TRIGGER_CLICK_SOURCE, Integer.valueOf(campaignEx.getTriggerClickSource()));
                        }
                        str4 = str10;
                        it = it;
                        str6 = str2;
                        str5 = str3;
                    } else {
                        it = it;
                        str6 = str2;
                        str5 = str9;
                        str4 = str10;
                    }
                }
            }
            return eVar.a();
        } catch (Exception e3) {
            e = e3;
        }
        if (MBridgeConstans.DEBUG) {
            e.printStackTrace();
        }
        return eVar.a();
    }

    private com.mbridge.msdk.tracker.e a(String str, Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        com.mbridge.msdk.tracker.e eVar = new com.mbridge.msdk.tracker.e(str);
        try {
            JSONObject jSONObject = new JSONObject(map);
            Boolean boolA = com.mbridge.msdk.foundation.same.b.b().a();
            if (boolA != null) {
                jSONObject.put("r_v_r", boolA.booleanValue() ? 1 : 0);
            }
            eVar.a(jSONObject);
            eVar.b(0);
            eVar.a(0);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return eVar;
    }

    private Map<String, String> a(String str, String str2, m mVar) {
        e eVar = new e();
        try {
            g gVarD = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (gVarD == null) {
                gVarD = h.b().a();
            }
            if (!TextUtils.isEmpty(gVarD.k0())) {
                eVar.a("as_rid", gVarD.k0());
            }
            String strJ = gVarD.J();
            JSONArray jSONArrayI = gVarD.I();
            if (jSONArrayI != null) {
                for (int i = 0; i < jSONArrayI.length(); i++) {
                    if (str.equals(jSONArrayI.getString(i))) {
                        strJ = "1.0";
                        break;
                    }
                }
            }
            if (!TextUtils.isEmpty(strJ)) {
                eVar.a("log_rate", strJ);
            } else {
                eVar.a("log_rate", -1);
            }
            if (!TextUtils.isEmpty(str2)) {
                com.mbridge.msdk.setting.l lVarD = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b(), str2);
                if (lVarD != null && !TextUtils.isEmpty(lVarD.I())) {
                    eVar.a("us_rid", lVarD.I());
                }
                if (lVarD != null && !TextUtils.isEmpty(lVarD.a())) {
                    eVar.a("u_stid", lVarD.a());
                }
                e eVarB = d.b().b(str2);
                if (eVarB != null) {
                    if (mVar != null && mVar.c() != null) {
                        try {
                            mVar.c().put("r_stid", eVarB.b("r_stid"));
                            eVarB.c("r_stid");
                        } catch (JSONException unused) {
                        }
                    }
                    eVar.a(eVarB);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return eVar.a();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0052  */
    /* JADX WARN: Code duplicated, block: B:22:0x0056 A[Catch: Exception -> 0x009a, TryCatch #0 {Exception -> 0x009a, blocks: (B:4:0x0007, B:6:0x0022, B:8:0x0028, B:10:0x0038, B:22:0x0056, B:24:0x005c, B:27:0x0067, B:29:0x006d, B:25:0x0061, B:30:0x0071, B:32:0x0077, B:33:0x007f, B:35:0x0085, B:38:0x0090, B:40:0x0096, B:36:0x008a, B:11:0x003f, B:13:0x0043, B:16:0x004b, B:18:0x004f), top: B:47:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x005c A[Catch: Exception -> 0x009a, TryCatch #0 {Exception -> 0x009a, blocks: (B:4:0x0007, B:6:0x0022, B:8:0x0028, B:10:0x0038, B:22:0x0056, B:24:0x005c, B:27:0x0067, B:29:0x006d, B:25:0x0061, B:30:0x0071, B:32:0x0077, B:33:0x007f, B:35:0x0085, B:38:0x0090, B:40:0x0096, B:36:0x008a, B:11:0x003f, B:13:0x0043, B:16:0x004b, B:18:0x004f), top: B:47:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0061 A[Catch: Exception -> 0x009a, TryCatch #0 {Exception -> 0x009a, blocks: (B:4:0x0007, B:6:0x0022, B:8:0x0028, B:10:0x0038, B:22:0x0056, B:24:0x005c, B:27:0x0067, B:29:0x006d, B:25:0x0061, B:30:0x0071, B:32:0x0077, B:33:0x007f, B:35:0x0085, B:38:0x0090, B:40:0x0096, B:36:0x008a, B:11:0x003f, B:13:0x0043, B:16:0x004b, B:18:0x004f), top: B:47:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0071 A[Catch: Exception -> 0x009a, TryCatch #0 {Exception -> 0x009a, blocks: (B:4:0x0007, B:6:0x0022, B:8:0x0028, B:10:0x0038, B:22:0x0056, B:24:0x005c, B:27:0x0067, B:29:0x006d, B:25:0x0061, B:30:0x0071, B:32:0x0077, B:33:0x007f, B:35:0x0085, B:38:0x0090, B:40:0x0096, B:36:0x008a, B:11:0x003f, B:13:0x0043, B:16:0x004b, B:18:0x004f), top: B:47:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0077 A[Catch: Exception -> 0x009a, TryCatch #0 {Exception -> 0x009a, blocks: (B:4:0x0007, B:6:0x0022, B:8:0x0028, B:10:0x0038, B:22:0x0056, B:24:0x005c, B:27:0x0067, B:29:0x006d, B:25:0x0061, B:30:0x0071, B:32:0x0077, B:33:0x007f, B:35:0x0085, B:38:0x0090, B:40:0x0096, B:36:0x008a, B:11:0x003f, B:13:0x0043, B:16:0x004b, B:18:0x004f), top: B:47:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x007f A[Catch: Exception -> 0x009a, TryCatch #0 {Exception -> 0x009a, blocks: (B:4:0x0007, B:6:0x0022, B:8:0x0028, B:10:0x0038, B:22:0x0056, B:24:0x005c, B:27:0x0067, B:29:0x006d, B:25:0x0061, B:30:0x0071, B:32:0x0077, B:33:0x007f, B:35:0x0085, B:38:0x0090, B:40:0x0096, B:36:0x008a, B:11:0x003f, B:13:0x0043, B:16:0x004b, B:18:0x004f), top: B:47:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0085 A[Catch: Exception -> 0x009a, TryCatch #0 {Exception -> 0x009a, blocks: (B:4:0x0007, B:6:0x0022, B:8:0x0028, B:10:0x0038, B:22:0x0056, B:24:0x005c, B:27:0x0067, B:29:0x006d, B:25:0x0061, B:30:0x0071, B:32:0x0077, B:33:0x007f, B:35:0x0085, B:38:0x0090, B:40:0x0096, B:36:0x008a, B:11:0x003f, B:13:0x0043, B:16:0x004b, B:18:0x004f), top: B:47:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x008a A[Catch: Exception -> 0x009a, TryCatch #0 {Exception -> 0x009a, blocks: (B:4:0x0007, B:6:0x0022, B:8:0x0028, B:10:0x0038, B:22:0x0056, B:24:0x005c, B:27:0x0067, B:29:0x006d, B:25:0x0061, B:30:0x0071, B:32:0x0077, B:33:0x007f, B:35:0x0085, B:38:0x0090, B:40:0x0096, B:36:0x008a, B:11:0x003f, B:13:0x0043, B:16:0x004b, B:18:0x004f), top: B:47:0x0007, inners: #1 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004d -> B:19:0x0052). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004f -> B:19:0x0052). Please report as a decompilation issue!!! */
    private List<CampaignEx> a(c cVar, String str) {
        int iIntValue;
        List<CampaignEx> listG;
        List<CampaignEx> listG2;
        ArrayList arrayList = new ArrayList();
        if (cVar != null) {
            try {
                String str2 = cVar.o() + str;
                Map<String, Map<String, String>> mapR = cVar.r();
                if (mapR == null || !mapR.containsKey(str2)) {
                    iIntValue = -1;
                    if (iIntValue == 1) {
                        if (cVar.j() != null) {
                            listG2 = cVar.j();
                        } else {
                            listG2 = cVar.g();
                        }
                        if (listG2 != null && listG2.size() > 0) {
                            arrayList.addAll(listG2);
                        }
                    } else if (cVar.i() != null) {
                        arrayList.add(cVar.i());
                    } else {
                        if (cVar.j() != null) {
                            listG = cVar.j();
                        } else {
                            listG = cVar.g();
                        }
                        if (listG != null && listG.size() > 0) {
                            arrayList.addAll(listG);
                        }
                    }
                } else {
                    try {
                        Object obj = mapR.get(str2).get("resource_type");
                        if (obj instanceof String) {
                            iIntValue = Integer.parseInt((String) obj);
                        } else if (obj instanceof Integer) {
                            iIntValue = ((Integer) obj).intValue();
                        } else {
                            iIntValue = -1;
                        }
                    } catch (NumberFormatException e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    if (iIntValue == 1) {
                        if (cVar.j() != null) {
                            listG2 = cVar.j();
                        } else {
                            listG2 = cVar.g();
                        }
                        if (listG2 != null) {
                            arrayList.addAll(listG2);
                        }
                    } else if (cVar.i() != null) {
                        arrayList.add(cVar.i());
                    } else {
                        if (cVar.j() != null) {
                            listG = cVar.j();
                        } else {
                            listG = cVar.g();
                        }
                        if (listG != null) {
                            arrayList.addAll(listG);
                        }
                    }
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public Map<String, String> a(String str, c cVar) {
        HashMap map = new HashMap();
        try {
            if (Arrays.asList(b.e).contains(str)) {
                String strC = "";
                if (cVar != null) {
                    strC = cVar.c();
                }
                map.put("auto_load", strC);
            }
            if (cVar != null) {
                Map<String, Map<String, String>> mapR = cVar.r();
                String str2 = cVar.o() + str;
                if (mapR.containsKey(str2) && mapR.get(str2) != null) {
                    map.putAll(mapR.get(str2));
                }
                try {
                    Map<String, Map<String, String>> mapQ = cVar.q();
                    String str3 = cVar.o() + "_" + cVar.l() + "_" + str;
                    if (mapQ.containsKey(str3) && mapQ.get(str3) != null) {
                        map.putAll(mapQ.get(str3));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
        return map;
    }
}
