package com.fyber.inneractive.sdk.config;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.fyber.inneractive.sdk.external.InvalidAppIdException;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.unity3d.services.UnityAdsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3076f implements com.fyber.inneractive.sdk.cache.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1693a = false;

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String a() {
        String str = IAConfigManager.O.c;
        StringBuilder sb = new StringBuilder("https://");
        int i = AbstractC3081k.f1710a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.baseConfigUrl");
        if (TextUtils.isEmpty(property)) {
            sb.append("cdn2.inner-active.mobi/ia-sdk-config/apps/");
        } else {
            sb.append(property);
        }
        String string = sb.append(str).append('/').append(str).append(".json").toString();
        IAlog.d("%s: %s", "APP_CONFIG_REQUEST", string);
        return string;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String b() {
        return "IALastModifiedFromHeader";
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String c() {
        return "inneractive.config";
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final boolean d() {
        String string = AbstractC3251o.f2370a.getSharedPreferences("IAConfigurationPreferences", 0).getString("cached.config.appid", null);
        return string != null && string.equalsIgnoreCase(IAConfigManager.O.c);
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final void a(Object obj) {
        I i = (I) obj;
        if (i == null || i.f1672a == null) {
            return;
        }
        AbstractC3251o.f2370a.getSharedPreferences("IAConfigurationPreferences", 0).edit().putString("cached.config.appid", i.f1672a).apply();
    }

    public final void a(String str, Throwable th) {
        String strSubstring;
        String name;
        String localizedMessage;
        if (this.f1693a) {
            return;
        }
        this.f1693a = true;
        if (TextUtils.isEmpty(str)) {
            strSubstring = "Empty Json Data";
        } else {
            strSubstring = str.length() > 501 ? str.substring(0, 500) : str.substring(0, str.length() - 1);
        }
        String str2 = strSubstring;
        if (th != null) {
            name = th.getClass().getName();
            localizedMessage = th.getLocalizedMessage();
        } else {
            name = "Bad remote configuration";
            localizedMessage = UnityAdsConstants.Messages.MSG_INTERNAL_ERROR;
        }
        String str3 = name;
        String str4 = IAConfigManager.O.c;
        C3146w c3146w = new C3146w(EnumC3143t.FATAL_CONFIGURATION_ERROR);
        if (localizedMessage == null) {
            localizedMessage = "No message";
        }
        String str5 = localizedMessage;
        if (TextUtils.isEmpty(str4)) {
            str4 = "EMPTY_APP_ID";
        }
        c3146w.a("exception", str3, "message", str5, "data", str2, RemoteConfigConstants.RequestFieldKey.APP_ID, str4).a((String) null);
    }

    /* JADX WARN: Code duplicated, block: B:108:0x01be  */
    /* JADX WARN: Code duplicated, block: B:111:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:112:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:114:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:115:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:118:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:120:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:121:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:123:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:124:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:127:0x0206  */
    /* JADX WARN: Code duplicated, block: B:128:0x0209  */
    /* JADX WARN: Code duplicated, block: B:130:0x020c  */
    /* JADX WARN: Code duplicated, block: B:131:0x020f  */
    /* JADX WARN: Code duplicated, block: B:134:0x0220  */
    /* JADX WARN: Code duplicated, block: B:135:0x0222  */
    /* JADX WARN: Code duplicated, block: B:138:0x0232  */
    /* JADX WARN: Code duplicated, block: B:139:0x0235  */
    /* JADX WARN: Code duplicated, block: B:141:0x0238  */
    /* JADX WARN: Code duplicated, block: B:142:0x023b  */
    /* JADX WARN: Code duplicated, block: B:145:0x024e  */
    /* JADX WARN: Code duplicated, block: B:146:0x0251  */
    /* JADX WARN: Code duplicated, block: B:148:0x0254  */
    /* JADX WARN: Code duplicated, block: B:149:0x0257  */
    /* JADX WARN: Code duplicated, block: B:152:0x026d  */
    /* JADX WARN: Code duplicated, block: B:153:0x0270  */
    /* JADX WARN: Code duplicated, block: B:155:0x0273  */
    /* JADX WARN: Code duplicated, block: B:156:0x0276  */
    /* JADX WARN: Code duplicated, block: B:159:0x0287  */
    /* JADX WARN: Code duplicated, block: B:160:0x0289  */
    /* JADX WARN: Code duplicated, block: B:163:0x029d  */
    /* JADX WARN: Code duplicated, block: B:164:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:166:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:167:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:170:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:173:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:174:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:176:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:177:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:180:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:181:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:183:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:184:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:187:0x030c  */
    /* JADX WARN: Code duplicated, block: B:196:0x0337  */
    /* JADX WARN: Code duplicated, block: B:197:0x033a  */
    /* JADX WARN: Code duplicated, block: B:200:0x033f  */
    /* JADX WARN: Code duplicated, block: B:201:0x0342  */
    /* JADX WARN: Code duplicated, block: B:204:0x0347  */
    /* JADX WARN: Code duplicated, block: B:205:0x034a  */
    /* JADX WARN: Code duplicated, block: B:208:0x036b  */
    /* JADX WARN: Code duplicated, block: B:209:0x036e  */
    /* JADX WARN: Code duplicated, block: B:211:0x0371  */
    /* JADX WARN: Code duplicated, block: B:212:0x0374  */
    /* JADX WARN: Code duplicated, block: B:214:0x0377  */
    /* JADX WARN: Code duplicated, block: B:215:0x037a  */
    /* JADX WARN: Code duplicated, block: B:222:0x039c  */
    /* JADX WARN: Code duplicated, block: B:225:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:226:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:228:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:229:0x03af  */
    /* JADX WARN: Code duplicated, block: B:231:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:232:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:239:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:242:0x03df  */
    /* JADX WARN: Code duplicated, block: B:243:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:245:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:246:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:248:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:249:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:256:0x040b  */
    /* JADX WARN: Code duplicated, block: B:280:0x0161 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x009c  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:57:0x0100  */
    /* JADX WARN: Code duplicated, block: B:59:0x0103  */
    /* JADX WARN: Code duplicated, block: B:60:0x0108  */
    /* JADX WARN: Code duplicated, block: B:63:0x011e  */
    /* JADX WARN: Code duplicated, block: B:64:0x0121  */
    /* JADX WARN: Code duplicated, block: B:66:0x0124  */
    /* JADX WARN: Code duplicated, block: B:67:0x0127  */
    /* JADX WARN: Code duplicated, block: B:88:0x016d  */
    public static I a(com.fyber.inneractive.sdk.config.remote.e eVar) {
        boolean z;
        com.fyber.inneractive.sdk.config.remote.b bVar;
        Iterator it;
        Iterator it2;
        com.fyber.inneractive.sdk.config.remote.j jVar;
        com.fyber.inneractive.sdk.config.remote.f fVar;
        Set set;
        com.fyber.inneractive.sdk.config.remote.f fVar2;
        Set set2;
        com.fyber.inneractive.sdk.config.remote.f fVar3;
        Set set3;
        W w;
        com.fyber.inneractive.sdk.config.remote.k kVar;
        com.fyber.inneractive.sdk.config.remote.k kVar2;
        com.fyber.inneractive.sdk.config.remote.k kVar3;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        Integer num8;
        boolean z2;
        Set set4;
        Set set5;
        Set set6;
        Set<Vendor> set7;
        UnitDisplayType unitDisplayType;
        UnitDisplayType unitDisplayType2;
        V v;
        com.fyber.inneractive.sdk.config.remote.j jVar2;
        com.fyber.inneractive.sdk.config.remote.j jVar3;
        com.fyber.inneractive.sdk.config.remote.j jVar4;
        UnitDisplayType unitDisplayType3;
        Boolean bool;
        Boolean bool2;
        Object objA;
        Integer num9;
        Integer num10;
        Integer num11;
        Integer num12;
        Integer num13;
        int iIntValue;
        Boolean bool3;
        Boolean bool4;
        Orientation orientation;
        Orientation orientation2;
        Integer num14;
        Integer num15;
        Integer num16;
        int iIntValue2;
        Integer num17;
        Integer num18;
        Integer num19;
        Skip skip;
        Skip skip2;
        TapAction tapAction;
        TapAction tapAction2;
        ArrayList arrayList;
        com.fyber.inneractive.sdk.config.remote.j jVarA;
        ArrayList arrayList2;
        UnitDisplayType unitDisplayType4;
        com.fyber.inneractive.sdk.config.remote.b bVar2;
        com.fyber.inneractive.sdk.config.remote.b bVar3;
        M m;
        UnitDisplayType unitDisplayType5;
        Integer num20;
        Integer num21;
        Integer num22;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        Integer num23;
        Integer num24;
        Integer num25;
        UnitDisplayType unitDisplayType6;
        String strB;
        com.fyber.inneractive.sdk.config.remote.e eVar2 = eVar;
        I i = new I();
        i.c = eVar2.c;
        com.fyber.inneractive.sdk.config.remote.a aVar = eVar2.f1718a;
        i.b = aVar.b;
        i.f1672a = aVar.f1716a;
        Iterator it3 = eVar2.b.iterator();
        while (it3.hasNext()) {
            com.fyber.inneractive.sdk.config.remote.h hVar = (com.fyber.inneractive.sdk.config.remote.h) it3.next();
            HashMap map = i.d;
            String str = hVar.f1721a;
            com.fyber.inneractive.sdk.config.remote.a aVar2 = eVar2.f1718a;
            HashMap map2 = i.e;
            K k = i.f;
            S s = new S();
            int i2 = 2;
            com.fyber.inneractive.sdk.config.remote.c[] cVarArr = {aVar2, hVar};
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    z = true;
                    break;
                }
                com.fyber.inneractive.sdk.config.remote.c cVar = cVarArr[i3];
                if (cVar != null && (strB = cVar.b()) != null && strB.equals("false")) {
                    z = false;
                    break;
                }
                i3++;
                i2 = 2;
            }
            s.b = z;
            Iterator it4 = hVar.g.iterator();
            while (it4.hasNext()) {
                com.fyber.inneractive.sdk.config.remote.i iVar = (com.fyber.inneractive.sdk.config.remote.i) it4.next();
                T t = new T();
                String str2 = iVar.f1722a;
                if (str2 != null) {
                    String str3 = iVar.b;
                    if (str3 != null) {
                        t.f1681a = str2;
                        t.b = str3;
                        com.fyber.inneractive.sdk.config.remote.g gVar = iVar.e;
                        if (gVar != null) {
                            Q q = new Q();
                            UnitDisplayType unitDisplayType7 = gVar.f1720a;
                            if (unitDisplayType7 == UnitDisplayType.DEFAULT) {
                                q.f1679a = unitDisplayType7;
                                t.e = q;
                                bVar = iVar.c;
                                if (bVar != null) {
                                    bVar2 = hVar.c;
                                    bVar3 = aVar2.e;
                                    m = new M();
                                    it = it3;
                                    unitDisplayType5 = bVar.f1717a;
                                    it2 = it4;
                                    if (unitDisplayType5 != UnitDisplayType.BANNER || unitDisplayType5 == UnitDisplayType.MRECT || unitDisplayType5.isFullscreenUnit()) {
                                        m.b = bVar.f1717a;
                                        Integer num26 = bVar.c;
                                        if (bVar2 != null) {
                                            num20 = bVar2.c;
                                        } else {
                                            num20 = null;
                                        }
                                        if (bVar3 != null) {
                                            num21 = bVar3.c;
                                        } else {
                                            num21 = null;
                                        }
                                        num22 = (Integer) a((Object) null, num26, num20, num21);
                                        if (num22 != null && num22.intValue() >= 5 && num22.intValue() <= 60) {
                                            m.f1676a = num22;
                                        }
                                        bool5 = Boolean.TRUE;
                                        Boolean bool8 = bVar.b;
                                        if (bVar2 != null) {
                                            bool6 = bVar2.b;
                                        } else {
                                            bool6 = null;
                                        }
                                        if (bVar3 != null) {
                                            bool7 = bVar3.b;
                                        } else {
                                            bool7 = null;
                                        }
                                        Boolean bool9 = (Boolean) a(bool5, bool8, bool6, bool7);
                                        bool9.getClass();
                                        m.c = bool9;
                                        Integer num27 = bVar.d;
                                        if (bVar2 != null) {
                                            num23 = bVar2.d;
                                        } else {
                                            num23 = null;
                                        }
                                        if (bVar3 != null) {
                                            num24 = bVar3.d;
                                        } else {
                                            num24 = null;
                                        }
                                        num25 = (Integer) a((Object) null, num27, num23, num24);
                                        if (num25 != null && num25.intValue() >= 5 && num25.intValue() <= 60) {
                                            m.d = num25;
                                        }
                                        if (m.d == null && !m.c.booleanValue() && ((unitDisplayType6 = bVar.f1717a) == UnitDisplayType.INTERSTITIAL || unitDisplayType6 == UnitDisplayType.REWARDED)) {
                                            m.c = bool5;
                                        }
                                        t.c = m;
                                    } else {
                                        it3 = it;
                                        it4 = it2;
                                    }
                                } else {
                                    i = i;
                                    it = it3;
                                    map = map;
                                    it2 = it4;
                                }
                                jVar = iVar.f;
                                if (jVar != null) {
                                    unitDisplayType = jVar.j;
                                    unitDisplayType2 = UnitDisplayType.REWARDED;
                                    if (unitDisplayType == unitDisplayType2 && iVar.c == null) {
                                        M m2 = new M();
                                        t.c = m2;
                                        m2.c = Boolean.FALSE;
                                        m2.d = -1;
                                        M m3 = t.c;
                                        m3.b = unitDisplayType2;
                                        m3.f1676a = -1;
                                    }
                                    v = new V();
                                    jVar2 = iVar.f;
                                    jVar3 = hVar.e;
                                    jVar4 = aVar2.d;
                                    unitDisplayType3 = jVar2.j;
                                    if (unitDisplayType3 == UnitDisplayType.LANDSCAPE && unitDisplayType3 != UnitDisplayType.SQUARE && unitDisplayType3 != (unitDisplayType4 = UnitDisplayType.INTERSTITIAL) && unitDisplayType3 != UnitDisplayType.VERTICAL && unitDisplayType3 != unitDisplayType2 && unitDisplayType3 != UnitDisplayType.MRECT) {
                                        if (t.e != null) {
                                            v.j = unitDisplayType4;
                                        }
                                        it3 = it;
                                        it4 = it2;
                                        i = i;
                                        map = map;
                                    } else {
                                        v.j = unitDisplayType3;
                                    }
                                    Boolean bool10 = jVar2.f1723a;
                                    if (jVar3 != null) {
                                        bool = jVar3.f1723a;
                                    } else {
                                        bool = null;
                                    }
                                    if (jVar4 != null) {
                                        bool2 = jVar4.f1723a;
                                    } else {
                                        bool2 = null;
                                    }
                                    objA = a((Object) null, bool10, bool, bool2);
                                    if (objA != null) {
                                        v.f1682a = (Boolean) objA;
                                        Integer num28 = jVar2.b;
                                        if (jVar3 != null) {
                                            num9 = jVar3.b;
                                        } else {
                                            num9 = null;
                                        }
                                        if (jVar4 != null) {
                                            num10 = jVar4.b;
                                        } else {
                                            num10 = null;
                                        }
                                        v.b = (Integer) a((Object) 5000, num28, num9, num10);
                                        Integer num29 = jVar2.c;
                                        if (jVar3 != null) {
                                            num11 = jVar3.c;
                                        } else {
                                            num11 = null;
                                        }
                                        if (jVar4 != null) {
                                            num12 = jVar4.c;
                                        } else {
                                            num12 = null;
                                        }
                                        num13 = (Integer) a((Object) 0, num29, num11, num12);
                                        if (num13.intValue() < 0) {
                                            iIntValue = 0;
                                        } else {
                                            iIntValue = num13.intValue();
                                        }
                                        v.c = Integer.valueOf(iIntValue);
                                        Boolean bool11 = Boolean.TRUE;
                                        Boolean bool12 = jVar2.e;
                                        if (jVar3 != null) {
                                            bool3 = jVar3.e;
                                        } else {
                                            bool3 = null;
                                        }
                                        if (jVar4 != null) {
                                            bool4 = jVar4.e;
                                        } else {
                                            bool4 = null;
                                        }
                                        v.d = (Boolean) a(bool11, bool12, bool3, bool4);
                                        Orientation orientation3 = Orientation.USER;
                                        Orientation orientation4 = jVar2.g;
                                        if (jVar3 != null) {
                                            orientation = jVar3.g;
                                        } else {
                                            orientation = null;
                                        }
                                        if (jVar4 != null) {
                                            orientation2 = jVar4.g;
                                        } else {
                                            orientation2 = null;
                                        }
                                        v.e = (Orientation) a(orientation3, orientation4, orientation, orientation2);
                                        Integer num30 = jVar2.i;
                                        if (jVar3 != null) {
                                            num14 = jVar3.i;
                                        } else {
                                            num14 = null;
                                        }
                                        if (jVar4 != null) {
                                            num15 = jVar4.i;
                                        } else {
                                            num15 = null;
                                        }
                                        num16 = (Integer) a((Object) 0, num30, num14, num15);
                                        if (num16.intValue() < 0) {
                                            iIntValue2 = 0;
                                        } else {
                                            iIntValue2 = num16.intValue();
                                        }
                                        v.f = Integer.valueOf(iIntValue2);
                                        Integer num31 = jVar2.h;
                                        if (jVar3 != null) {
                                            num17 = jVar3.h;
                                        } else {
                                            num17 = null;
                                        }
                                        if (jVar4 != null) {
                                            num18 = jVar4.h;
                                        } else {
                                            num18 = null;
                                        }
                                        num19 = (Integer) a((Object) 2048, num31, num17, num18);
                                        if (num19.intValue() > v.b.intValue()) {
                                            num19 = v.b;
                                        }
                                        v.g = num19;
                                        Skip skip3 = Skip._0;
                                        Skip skip4 = jVar2.d;
                                        if (jVar3 != null) {
                                            skip = jVar3.d;
                                        } else {
                                            skip = null;
                                        }
                                        if (jVar4 != null) {
                                            skip2 = jVar4.d;
                                        } else {
                                            skip2 = null;
                                        }
                                        v.h = (Skip) a(skip3, skip4, skip, skip2);
                                        TapAction tapAction3 = TapAction.DO_NOTHING;
                                        TapAction tapAction4 = jVar2.f;
                                        if (jVar3 != null) {
                                            tapAction = jVar3.f;
                                        } else {
                                            tapAction = null;
                                        }
                                        if (jVar4 != null) {
                                            tapAction2 = jVar4.f;
                                        } else {
                                            tapAction2 = null;
                                        }
                                        v.i = (TapAction) a(tapAction3, tapAction4, tapAction, tapAction2);
                                        arrayList = new ArrayList();
                                        jVarA = new com.fyber.inneractive.sdk.config.remote.d[]{iVar}[0].a();
                                        if (jVarA != null && (arrayList2 = jVarA.k) != null && arrayList2.size() > 0) {
                                            arrayList = jVarA.k;
                                        }
                                        v.k = arrayList;
                                        t.f = v;
                                    }
                                    it3 = it;
                                    it4 = it2;
                                    i = i;
                                    map = map;
                                }
                                P p = new P();
                                HashSet hashSet = new HashSet();
                                fVar = iVar.d;
                                if (fVar != null) {
                                    set = fVar.f1719a;
                                } else {
                                    set = null;
                                }
                                fVar2 = hVar.d;
                                if (fVar2 != null) {
                                    set2 = fVar2.f1719a;
                                } else {
                                    set2 = null;
                                }
                                fVar3 = aVar2.c;
                                if (fVar3 != null) {
                                    set3 = fVar3.f1719a;
                                } else {
                                    set3 = null;
                                }
                                p.f1678a = (Set) a(hashSet, set, set2, set3);
                                t.d = p;
                                w = new W();
                                kVar = iVar.g;
                                kVar2 = hVar.f;
                                kVar3 = aVar2.f;
                                if (kVar != null) {
                                    num = kVar.f1724a;
                                } else {
                                    num = null;
                                }
                                if (kVar2 != null) {
                                    num2 = kVar2.f1724a;
                                } else {
                                    num2 = null;
                                }
                                if (kVar3 != null) {
                                    num3 = kVar3.f1724a;
                                } else {
                                    num3 = null;
                                }
                                num4 = (Integer) a((Object) 1, num, num2, num3);
                                if (num4.intValue() > 0 && num4.intValue() > 100) {
                                    w.f1683a = 1;
                                } else {
                                    w.f1683a = num4;
                                }
                                if (kVar != null) {
                                    num5 = kVar.b;
                                } else {
                                    num5 = null;
                                }
                                if (kVar2 != null) {
                                    num6 = kVar2.b;
                                } else {
                                    num6 = null;
                                }
                                if (kVar3 != null) {
                                    num7 = kVar3.b;
                                } else {
                                    num7 = null;
                                }
                                num8 = (Integer) a((Object) 0, num5, num6, num7);
                                if (num8.intValue() >= 0 && num8.intValue() > 100) {
                                    z2 = false;
                                    w.b = 0;
                                } else {
                                    z2 = false;
                                    w.b = num8;
                                }
                                HashSet hashSet2 = new HashSet();
                                if (kVar != null) {
                                    set4 = kVar.c;
                                } else {
                                    set4 = null;
                                }
                                if (kVar2 != null) {
                                    set5 = kVar2.c;
                                } else {
                                    set5 = null;
                                }
                                if (kVar3 != null) {
                                    set6 = kVar3.c;
                                } else {
                                    set6 = null;
                                }
                                set7 = (Set) a(hashSet2, set4, set5, set6);
                                w.c = set7;
                                t.g = w;
                                if (k != null && set7 != null) {
                                    for (Vendor vendor : set7) {
                                        if (vendor == null && !k.f1674a.contains(vendor)) {
                                            k.f1674a.add(vendor);
                                        }
                                    }
                                }
                                s.f1680a.add(t);
                                map2.put(t.f1681a, t);
                                it3 = it;
                                it4 = it2;
                                i = i;
                                map = map;
                            }
                        } else {
                            bVar = iVar.c;
                            if (bVar != null) {
                                bVar2 = hVar.c;
                                bVar3 = aVar2.e;
                                m = new M();
                                it = it3;
                                unitDisplayType5 = bVar.f1717a;
                                it2 = it4;
                                if (unitDisplayType5 != UnitDisplayType.BANNER) {
                                }
                                m.b = bVar.f1717a;
                                Integer num210 = bVar.c;
                                if (bVar2 != null) {
                                    num20 = bVar2.c;
                                } else {
                                    num20 = null;
                                }
                                if (bVar3 != null) {
                                    num21 = bVar3.c;
                                } else {
                                    num21 = null;
                                }
                                num22 = (Integer) a((Object) null, num210, num20, num21);
                                if (num22 != null) {
                                    m.f1676a = num22;
                                }
                                bool5 = Boolean.TRUE;
                                Boolean bool13 = bVar.b;
                                if (bVar2 != null) {
                                    bool6 = bVar2.b;
                                } else {
                                    bool6 = null;
                                }
                                if (bVar3 != null) {
                                    bool7 = bVar3.b;
                                } else {
                                    bool7 = null;
                                }
                                Boolean bool14 = (Boolean) a(bool5, bool13, bool6, bool7);
                                bool14.getClass();
                                m.c = bool14;
                                Integer num211 = bVar.d;
                                if (bVar2 != null) {
                                    num23 = bVar2.d;
                                } else {
                                    num23 = null;
                                }
                                if (bVar3 != null) {
                                    num24 = bVar3.d;
                                } else {
                                    num24 = null;
                                }
                                num25 = (Integer) a((Object) null, num211, num23, num24);
                                if (num25 != null) {
                                    m.d = num25;
                                }
                                if (m.d == null) {
                                    m.c = bool5;
                                }
                                t.c = m;
                            } else {
                                i = i;
                                it = it3;
                                map = map;
                                it2 = it4;
                            }
                            jVar = iVar.f;
                            if (jVar != null) {
                                unitDisplayType = jVar.j;
                                unitDisplayType2 = UnitDisplayType.REWARDED;
                                if (unitDisplayType == unitDisplayType2) {
                                    M m4 = new M();
                                    t.c = m4;
                                    m4.c = Boolean.FALSE;
                                    m4.d = -1;
                                    M m5 = t.c;
                                    m5.b = unitDisplayType2;
                                    m5.f1676a = -1;
                                }
                                v = new V();
                                jVar2 = iVar.f;
                                jVar3 = hVar.e;
                                jVar4 = aVar2.d;
                                unitDisplayType3 = jVar2.j;
                                if (unitDisplayType3 == UnitDisplayType.LANDSCAPE) {
                                    v.j = unitDisplayType3;
                                    Boolean bool15 = jVar2.f1723a;
                                    if (jVar3 != null) {
                                        bool = jVar3.f1723a;
                                    } else {
                                        bool = null;
                                    }
                                    if (jVar4 != null) {
                                        bool2 = jVar4.f1723a;
                                    } else {
                                        bool2 = null;
                                    }
                                    objA = a((Object) null, bool15, bool, bool2);
                                    if (objA != null) {
                                        v.f1682a = (Boolean) objA;
                                        Integer num212 = jVar2.b;
                                        if (jVar3 != null) {
                                            num9 = jVar3.b;
                                        } else {
                                            num9 = null;
                                        }
                                        if (jVar4 != null) {
                                            num10 = jVar4.b;
                                        } else {
                                            num10 = null;
                                        }
                                        v.b = (Integer) a((Object) 5000, num212, num9, num10);
                                        Integer num213 = jVar2.c;
                                        if (jVar3 != null) {
                                            num11 = jVar3.c;
                                        } else {
                                            num11 = null;
                                        }
                                        if (jVar4 != null) {
                                            num12 = jVar4.c;
                                        } else {
                                            num12 = null;
                                        }
                                        num13 = (Integer) a((Object) 0, num213, num11, num12);
                                        if (num13.intValue() < 0) {
                                            iIntValue = 0;
                                        } else {
                                            iIntValue = num13.intValue();
                                        }
                                        v.c = Integer.valueOf(iIntValue);
                                        Boolean bool16 = Boolean.TRUE;
                                        Boolean bool17 = jVar2.e;
                                        if (jVar3 != null) {
                                            bool3 = jVar3.e;
                                        } else {
                                            bool3 = null;
                                        }
                                        if (jVar4 != null) {
                                            bool4 = jVar4.e;
                                        } else {
                                            bool4 = null;
                                        }
                                        v.d = (Boolean) a(bool16, bool17, bool3, bool4);
                                        Orientation orientation5 = Orientation.USER;
                                        Orientation orientation6 = jVar2.g;
                                        if (jVar3 != null) {
                                            orientation = jVar3.g;
                                        } else {
                                            orientation = null;
                                        }
                                        if (jVar4 != null) {
                                            orientation2 = jVar4.g;
                                        } else {
                                            orientation2 = null;
                                        }
                                        v.e = (Orientation) a(orientation5, orientation6, orientation, orientation2);
                                        Integer num32 = jVar2.i;
                                        if (jVar3 != null) {
                                            num14 = jVar3.i;
                                        } else {
                                            num14 = null;
                                        }
                                        if (jVar4 != null) {
                                            num15 = jVar4.i;
                                        } else {
                                            num15 = null;
                                        }
                                        num16 = (Integer) a((Object) 0, num32, num14, num15);
                                        if (num16.intValue() < 0) {
                                            iIntValue2 = 0;
                                        } else {
                                            iIntValue2 = num16.intValue();
                                        }
                                        v.f = Integer.valueOf(iIntValue2);
                                        Integer num33 = jVar2.h;
                                        if (jVar3 != null) {
                                            num17 = jVar3.h;
                                        } else {
                                            num17 = null;
                                        }
                                        if (jVar4 != null) {
                                            num18 = jVar4.h;
                                        } else {
                                            num18 = null;
                                        }
                                        num19 = (Integer) a((Object) 2048, num33, num17, num18);
                                        if (num19.intValue() > v.b.intValue()) {
                                            num19 = v.b;
                                        }
                                        v.g = num19;
                                        Skip skip5 = Skip._0;
                                        Skip skip6 = jVar2.d;
                                        if (jVar3 != null) {
                                            skip = jVar3.d;
                                        } else {
                                            skip = null;
                                        }
                                        if (jVar4 != null) {
                                            skip2 = jVar4.d;
                                        } else {
                                            skip2 = null;
                                        }
                                        v.h = (Skip) a(skip5, skip6, skip, skip2);
                                        TapAction tapAction5 = TapAction.DO_NOTHING;
                                        TapAction tapAction6 = jVar2.f;
                                        if (jVar3 != null) {
                                            tapAction = jVar3.f;
                                        } else {
                                            tapAction = null;
                                        }
                                        if (jVar4 != null) {
                                            tapAction2 = jVar4.f;
                                        } else {
                                            tapAction2 = null;
                                        }
                                        v.i = (TapAction) a(tapAction5, tapAction6, tapAction, tapAction2);
                                        arrayList = new ArrayList();
                                        jVarA = new com.fyber.inneractive.sdk.config.remote.d[]{iVar}[0].a();
                                        if (jVarA != null) {
                                            arrayList = jVarA.k;
                                        }
                                        v.k = arrayList;
                                        t.f = v;
                                    }
                                } else {
                                    v.j = unitDisplayType3;
                                    Boolean bool18 = jVar2.f1723a;
                                    if (jVar3 != null) {
                                        bool = jVar3.f1723a;
                                    } else {
                                        bool = null;
                                    }
                                    if (jVar4 != null) {
                                        bool2 = jVar4.f1723a;
                                    } else {
                                        bool2 = null;
                                    }
                                    objA = a((Object) null, bool18, bool, bool2);
                                    if (objA != null) {
                                        v.f1682a = (Boolean) objA;
                                        Integer num214 = jVar2.b;
                                        if (jVar3 != null) {
                                            num9 = jVar3.b;
                                        } else {
                                            num9 = null;
                                        }
                                        if (jVar4 != null) {
                                            num10 = jVar4.b;
                                        } else {
                                            num10 = null;
                                        }
                                        v.b = (Integer) a((Object) 5000, num214, num9, num10);
                                        Integer num215 = jVar2.c;
                                        if (jVar3 != null) {
                                            num11 = jVar3.c;
                                        } else {
                                            num11 = null;
                                        }
                                        if (jVar4 != null) {
                                            num12 = jVar4.c;
                                        } else {
                                            num12 = null;
                                        }
                                        num13 = (Integer) a((Object) 0, num215, num11, num12);
                                        if (num13.intValue() < 0) {
                                            iIntValue = 0;
                                        } else {
                                            iIntValue = num13.intValue();
                                        }
                                        v.c = Integer.valueOf(iIntValue);
                                        Boolean bool19 = Boolean.TRUE;
                                        Boolean bool110 = jVar2.e;
                                        if (jVar3 != null) {
                                            bool3 = jVar3.e;
                                        } else {
                                            bool3 = null;
                                        }
                                        if (jVar4 != null) {
                                            bool4 = jVar4.e;
                                        } else {
                                            bool4 = null;
                                        }
                                        v.d = (Boolean) a(bool19, bool110, bool3, bool4);
                                        Orientation orientation7 = Orientation.USER;
                                        Orientation orientation8 = jVar2.g;
                                        if (jVar3 != null) {
                                            orientation = jVar3.g;
                                        } else {
                                            orientation = null;
                                        }
                                        if (jVar4 != null) {
                                            orientation2 = jVar4.g;
                                        } else {
                                            orientation2 = null;
                                        }
                                        v.e = (Orientation) a(orientation7, orientation8, orientation, orientation2);
                                        Integer num34 = jVar2.i;
                                        if (jVar3 != null) {
                                            num14 = jVar3.i;
                                        } else {
                                            num14 = null;
                                        }
                                        if (jVar4 != null) {
                                            num15 = jVar4.i;
                                        } else {
                                            num15 = null;
                                        }
                                        num16 = (Integer) a((Object) 0, num34, num14, num15);
                                        if (num16.intValue() < 0) {
                                            iIntValue2 = 0;
                                        } else {
                                            iIntValue2 = num16.intValue();
                                        }
                                        v.f = Integer.valueOf(iIntValue2);
                                        Integer num35 = jVar2.h;
                                        if (jVar3 != null) {
                                            num17 = jVar3.h;
                                        } else {
                                            num17 = null;
                                        }
                                        if (jVar4 != null) {
                                            num18 = jVar4.h;
                                        } else {
                                            num18 = null;
                                        }
                                        num19 = (Integer) a((Object) 2048, num35, num17, num18);
                                        if (num19.intValue() > v.b.intValue()) {
                                            num19 = v.b;
                                        }
                                        v.g = num19;
                                        Skip skip7 = Skip._0;
                                        Skip skip8 = jVar2.d;
                                        if (jVar3 != null) {
                                            skip = jVar3.d;
                                        } else {
                                            skip = null;
                                        }
                                        if (jVar4 != null) {
                                            skip2 = jVar4.d;
                                        } else {
                                            skip2 = null;
                                        }
                                        v.h = (Skip) a(skip7, skip8, skip, skip2);
                                        TapAction tapAction7 = TapAction.DO_NOTHING;
                                        TapAction tapAction8 = jVar2.f;
                                        if (jVar3 != null) {
                                            tapAction = jVar3.f;
                                        } else {
                                            tapAction = null;
                                        }
                                        if (jVar4 != null) {
                                            tapAction2 = jVar4.f;
                                        } else {
                                            tapAction2 = null;
                                        }
                                        v.i = (TapAction) a(tapAction7, tapAction8, tapAction, tapAction2);
                                        arrayList = new ArrayList();
                                        jVarA = new com.fyber.inneractive.sdk.config.remote.d[]{iVar}[0].a();
                                        if (jVarA != null) {
                                            arrayList = jVarA.k;
                                        }
                                        v.k = arrayList;
                                        t.f = v;
                                    }
                                }
                                it3 = it;
                                it4 = it2;
                                i = i;
                                map = map;
                            }
                            P p2 = new P();
                            HashSet hashSet3 = new HashSet();
                            fVar = iVar.d;
                            if (fVar != null) {
                                set = fVar.f1719a;
                            } else {
                                set = null;
                            }
                            fVar2 = hVar.d;
                            if (fVar2 != null) {
                                set2 = fVar2.f1719a;
                            } else {
                                set2 = null;
                            }
                            fVar3 = aVar2.c;
                            if (fVar3 != null) {
                                set3 = fVar3.f1719a;
                            } else {
                                set3 = null;
                            }
                            p2.f1678a = (Set) a(hashSet3, set, set2, set3);
                            t.d = p2;
                            w = new W();
                            kVar = iVar.g;
                            kVar2 = hVar.f;
                            kVar3 = aVar2.f;
                            if (kVar != null) {
                                num = kVar.f1724a;
                            } else {
                                num = null;
                            }
                            if (kVar2 != null) {
                                num2 = kVar2.f1724a;
                            } else {
                                num2 = null;
                            }
                            if (kVar3 != null) {
                                num3 = kVar3.f1724a;
                            } else {
                                num3 = null;
                            }
                            num4 = (Integer) a((Object) 1, num, num2, num3);
                            if (num4.intValue() > 0) {
                                w.f1683a = num4;
                            } else {
                                w.f1683a = num4;
                            }
                            if (kVar != null) {
                                num5 = kVar.b;
                            } else {
                                num5 = null;
                            }
                            if (kVar2 != null) {
                                num6 = kVar2.b;
                            } else {
                                num6 = null;
                            }
                            if (kVar3 != null) {
                                num7 = kVar3.b;
                            } else {
                                num7 = null;
                            }
                            num8 = (Integer) a((Object) 0, num5, num6, num7);
                            if (num8.intValue() >= 0) {
                                z2 = false;
                                w.b = num8;
                            } else {
                                z2 = false;
                                w.b = num8;
                            }
                            HashSet hashSet4 = new HashSet();
                            if (kVar != null) {
                                set4 = kVar.c;
                            } else {
                                set4 = null;
                            }
                            if (kVar2 != null) {
                                set5 = kVar2.c;
                            } else {
                                set5 = null;
                            }
                            if (kVar3 != null) {
                                set6 = kVar3.c;
                            } else {
                                set6 = null;
                            }
                            set7 = (Set) a(hashSet4, set4, set5, set6);
                            w.c = set7;
                            t.g = w;
                            if (k != null) {
                                while (r0.hasNext()) {
                                    if (vendor == null) {
                                    }
                                }
                            }
                            s.f1680a.add(t);
                            map2.put(t.f1681a, t);
                            it3 = it;
                            it4 = it2;
                            i = i;
                            map = map;
                        }
                    }
                }
            }
            map.put(str, s);
            eVar2 = eVar;
        }
        return i;
    }

    public static Object a(Object obj, Object... objArr) {
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                return obj2;
            }
        }
        return obj;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final Object a(String str) {
        try {
            IAConfigManager iAConfigManager = IAConfigManager.O;
            iAConfigManager.D.f();
            com.fyber.inneractive.sdk.config.remote.e eVarA = com.fyber.inneractive.sdk.config.remote.e.a(new JSONObject(str));
            String str2 = iAConfigManager.c;
            if (eVarA != null && str2.equals(eVarA.f1718a.f1716a)) {
                return a(eVarA);
            }
            IAlog.b("internal error while parsing local configuration", new Object[0]);
            if (eVarA != null && !str2.equals(eVarA.f1718a.f1716a)) {
                throw new InvalidAppIdException();
            }
            a(str, (Throwable) null);
            return null;
        } catch (Throwable th) {
            a(str, th);
            IAlog.b("Exception Error while parsing local configuration", new Object[0]);
            throw th;
        }
    }
}
