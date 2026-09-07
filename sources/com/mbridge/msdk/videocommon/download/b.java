package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: DownLoadManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static volatile b f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5962a = false;
    private ConcurrentHashMap<String, l> b = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, CopyOnWriteArrayList<Map<String, a>>> c;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> d;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<a>> e;

    private b() {
    }

    public static b getInstance() {
        if (f == null) {
            synchronized (b.class) {
                if (f == null) {
                    f = new b();
                }
            }
        }
        return f;
    }

    public a a(String str, String str2) {
        l lVarC = c(str);
        if (lVarC != null) {
            return lVarC.a(str2);
        }
        return null;
    }

    public CopyOnWriteArrayList<CampaignEx> b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap = this.d;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.d.get(str);
    }

    public l c(String str) {
        ConcurrentHashMap<String, l> concurrentHashMap = this.b;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.b.get(str);
    }

    public l createUnitCache(Context context, String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, int i, com.mbridge.msdk.videocommon.listener.a aVar) {
        l lVar;
        if (TextUtils.isEmpty(str) || copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return null;
        }
        if (this.b.containsKey(str)) {
            lVar = this.b.get(str);
            if (lVar == null) {
                lVar = new l(context, copyOnWriteArrayList, str, i);
                this.b.put(str, lVar);
            }
            if (i == 94 || i == 287) {
                lVar.a(copyOnWriteArrayList.get(0).getRequestId() + "_" + copyOnWriteArrayList.get(0).getSecondRequestIndex(), aVar);
            } else {
                lVar.a(aVar);
            }
            lVar.b(copyOnWriteArrayList);
        } else {
            lVar = new l(context, copyOnWriteArrayList, str, i);
            if (i == 94 || i == 287) {
                lVar.a(copyOnWriteArrayList.get(0).getRequestId() + "_" + copyOnWriteArrayList.get(0).getSecondRequestIndex(), aVar);
            } else {
                lVar.a(aVar);
            }
            this.b.put(str, lVar);
        }
        return lVar;
    }

    public void load(String str) {
        l lVarC = c(str);
        if (lVarC != null) {
            lVarC.d();
        }
    }

    public boolean b(int i, String str, boolean z) {
        try {
            l lVarC = c(str);
            return (lVarC == null || lVarC.b(i, z) == null) ? false : true;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public CopyOnWriteArrayList<a> a(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap = this.e;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.e.get(str);
    }

    public void c(String str, String str2) {
        l lVarC = c(str);
        if (lVarC != null) {
            try {
                lVarC.b(str2);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("DownLoadManager", e.getMessage());
                }
            }
        }
    }

    public a a(int i, String str, boolean z) {
        l lVarC = c(str);
        if (lVarC != null) {
            return lVarC.a(i, z);
        }
        return null;
    }

    public boolean a(int i, String str, boolean z, int i2, boolean z2, int i3, List<CampaignEx> list) {
        return a(i, str, z, i2, z2, i3, list, false, null);
    }

    public boolean a(int i, String str, List<CampaignEx> list) {
        l lVarC = c(str);
        if (lVarC == null) {
            lVarC = createUnitCache(com.mbridge.msdk.foundation.controller.c.m().d(), str, (CopyOnWriteArrayList<CampaignEx>) list, i, (com.mbridge.msdk.videocommon.listener.a) null);
        }
        if (lVarC != null) {
            return lVarC.a(list, str);
        }
        return false;
    }

    public void b(boolean z) {
        this.f5962a = z;
        ConcurrentHashMap<String, l> concurrentHashMap = this.b;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, l>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                l value = it.next().getValue();
                if (value != null) {
                    value.e();
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:90:0x018d  */
    public boolean a(int i, String str, boolean z, int i2, boolean z2, int i3, List<CampaignEx> list, boolean z3, com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        l lVarC;
        boolean z4;
        CampaignEx campaignEx;
        boolean z5 = false;
        if (list != null) {
            try {
                if (list.size() != 0 && (lVarC = c(str)) != null) {
                    List<a> listA = lVarC.a(str, i, z, list, z3, eVar);
                    if (listA != null && listA.size() != 0) {
                        if (z2) {
                            if (list.size() <= 0 || (campaignEx = list.get(0)) == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                z4 = false;
                            } else {
                                o0.c("DownLoadManager", "Is not check video download status with TPL");
                                z4 = true;
                            }
                            try {
                                if (i3 == 0) {
                                    ArrayList arrayList = new ArrayList();
                                    for (a aVar : listA) {
                                        for (CampaignEx campaignEx2 : list) {
                                            if (aVar != null && aVar.c() != null && campaignEx2 != null && campaignEx2.getId().equals(aVar.c().getId()) && campaignEx2.getRequestId().equals(aVar.c().getRequestId())) {
                                                arrayList.add(aVar);
                                            }
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        z5 = true;
                                    } else {
                                        z5 = z4;
                                    }
                                } else {
                                    ArrayList arrayList2 = new ArrayList();
                                    for (a aVar2 : listA) {
                                        for (CampaignEx campaignEx3 : list) {
                                            if (aVar2 != null && aVar2.c() != null && campaignEx3 != null && campaignEx3.getId().equals(aVar2.c().getId()) && campaignEx3.getRequestId().equals(aVar2.c().getRequestId())) {
                                                arrayList2.add(aVar2);
                                            }
                                        }
                                    }
                                    if (arrayList2.size() >= i2) {
                                        z5 = true;
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                z5 = z4;
                                if (MBridgeConstans.DEBUG) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            ArrayList arrayList3 = new ArrayList();
                            for (a aVar3 : listA) {
                                for (CampaignEx campaignEx4 : list) {
                                    if (aVar3 != null && aVar3.c() != null && campaignEx4 != null && campaignEx4.getId().equals(aVar3.c().getId()) && campaignEx4.getRequestId().equals(aVar3.c().getRequestId())) {
                                        arrayList3.add(aVar3);
                                    }
                                }
                            }
                            if (arrayList3.size() > 0) {
                                z5 = true;
                            }
                        }
                    }
                    if (z5) {
                        if (this.c == null) {
                            this.c = new ConcurrentHashMap<>();
                        }
                        if (this.e == null) {
                            this.e = new ConcurrentHashMap<>();
                        }
                        if (this.d == null) {
                            this.d = new ConcurrentHashMap<>();
                        }
                        if (listA != null && listA.size() > 0) {
                            CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                            CopyOnWriteArrayList<a> copyOnWriteArrayList3 = new CopyOnWriteArrayList<>();
                            for (a aVar4 : listA) {
                                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                                CampaignEx campaignExC = aVar4.c();
                                concurrentHashMap.put(campaignExC.getId() + campaignExC.getVideoUrlEncode() + campaignExC.getBidToken(), aVar4);
                                copyOnWriteArrayList.add(concurrentHashMap);
                                copyOnWriteArrayList2.add(campaignExC);
                                copyOnWriteArrayList3.add(aVar4);
                            }
                            a(str, copyOnWriteArrayList, copyOnWriteArrayList2, copyOnWriteArrayList3);
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return z5;
    }

    public int b(String str, String str2) {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayListC;
        a value;
        CampaignEx campaignExC;
        ConcurrentHashMap<String, l> concurrentHashMap = this.b;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, l>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                l value2 = it.next().getValue();
                if (value2 != null && (copyOnWriteArrayListC = value2.c()) != null) {
                    int size = copyOnWriteArrayListC.size();
                    for (int i = 0; i < size; i++) {
                        Map<String, a> map = copyOnWriteArrayListC.get(i);
                        if (map != null) {
                            Iterator<Map.Entry<String, a>> it2 = map.entrySet().iterator();
                            if (it2.hasNext() && (value = it2.next().getValue()) != null && (campaignExC = value.c()) != null) {
                                String videoUrlEncode = campaignExC.getVideoUrlEncode();
                                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(videoUrlEncode) && str2.equals(videoUrlEncode)) {
                                    return value.j();
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public l createUnitCache(Context context, String str, CampaignEx campaignEx, int i, com.mbridge.msdk.videocommon.listener.a aVar) {
        l lVar;
        if (TextUtils.isEmpty(str) || campaignEx == null) {
            return null;
        }
        if (this.b.containsKey(str)) {
            lVar = this.b.get(str);
            if (lVar == null) {
                lVar = new l(context, campaignEx, str, i);
                this.b.put(str, lVar);
            }
            if (i != 94 && i != 287) {
                lVar.a(aVar);
            } else {
                lVar.a(campaignEx.getRequestId() + "_" + campaignEx.getSecondRequestIndex(), aVar);
            }
            lVar.f(campaignEx);
        } else {
            lVar = new l(context, campaignEx, str, i);
            if (i != 94 && i != 287) {
                lVar.a(aVar);
            } else {
                lVar.a(campaignEx.getRequestId() + "_" + campaignEx.getSecondRequestIndex(), aVar);
            }
            this.b.put(str, lVar);
        }
        return lVar;
    }

    private void a(String str, CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2, CopyOnWriteArrayList<a> copyOnWriteArrayList3) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList4;
        if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
            CampaignEx campaignEx = copyOnWriteArrayList2.get(0);
            if (campaignEx.getSecondRequestIndex() == 1 && (concurrentHashMap = this.d) != null && (copyOnWriteArrayList4 = concurrentHashMap.get(str)) != null && copyOnWriteArrayList4.size() > 0 && copyOnWriteArrayList4.get(0).getLocalRequestId().equals(campaignEx.getLocalRequestId())) {
                return;
            }
        }
        ConcurrentHashMap<String, CopyOnWriteArrayList<Map<String, a>>> concurrentHashMap2 = this.c;
        if (concurrentHashMap2 == null) {
            this.c = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap2.remove(str);
        }
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap3 = this.e;
        if (concurrentHashMap3 == null) {
            this.e = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap3.remove(str);
        }
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap4 = this.d;
        if (concurrentHashMap4 == null) {
            this.d = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap4.remove(str);
        }
        this.c.put(str, copyOnWriteArrayList);
        this.d.put(str, copyOnWriteArrayList2);
        this.e.put(str, copyOnWriteArrayList3);
    }

    public void a(boolean z) {
        if (z) {
            if (this.f5962a) {
                return;
            }
        } else {
            this.f5962a = false;
        }
        ConcurrentHashMap<String, l> concurrentHashMap = this.b;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, l>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().d();
            }
        }
    }

    public void a() {
        ConcurrentHashMap<String, l> concurrentHashMap = this.b;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, l> entry : concurrentHashMap.entrySet()) {
                a(entry.getValue(), entry.getKey());
            }
        }
    }

    private void a(l lVar, String str) {
        try {
            com.mbridge.msdk.videocommon.setting.c cVarC = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), str);
            if (cVarC == null) {
                return;
            }
            if (cVarC.l() == 2) {
                lVar.e();
            } else {
                lVar.d();
            }
        } catch (Exception e) {
            o0.b("DownLoadManager", e.getMessage());
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                com.mbridge.msdk.setting.l lVarE = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), str);
                if (lVarE == null) {
                    lVarE = com.mbridge.msdk.setting.l.j(str);
                }
                if (lVarE.q() == 2) {
                    lVar.e();
                } else {
                    lVar.d();
                }
            } catch (Exception e2) {
                o0.b("DownLoadManager", e2.getMessage());
            }
        }
    }
}
