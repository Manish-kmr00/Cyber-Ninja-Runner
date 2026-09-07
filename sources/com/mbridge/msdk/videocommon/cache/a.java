package com.mbridge.msdk.videocommon.cache;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.videocommon.setting.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: VideoCampaignCache.java */
/* JADX INFO: loaded from: classes11.dex */
public class a {
    private static final String b = "com.mbridge.msdk.videocommon.cache.a";
    private static a c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f5957a;

    /* JADX INFO: renamed from: com.mbridge.msdk.videocommon.cache.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VideoCampaignCache.java */
    class RunnableC0522a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5958a;
        final /* synthetic */ CampaignEx b;

        RunnableC0522a(String str, CampaignEx campaignEx) {
            this.f5958a = str;
            this.b = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.f5958a, this.b);
        }
    }

    private a() {
        try {
            Context contextD = c.m().d();
            if (contextD != null) {
                this.f5957a = e.a(g.a(contextD));
            } else {
                o0.b(b, "RewardCampaignCache get Context is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public List<CampaignEx> b(String str, int i, boolean z) {
        return b(str, i, z, "");
    }

    public CopyOnWriteArrayList<CampaignEx> c(String str, int i) {
        List<CampaignEx> listA;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            if (TextUtils.isEmpty(str) || (listA = this.f5957a.a(str, 0, 0, i)) == null) {
                return null;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            try {
                for (CampaignEx campaignEx : listA) {
                    if (campaignEx != null) {
                        copyOnWriteArrayList2.add(campaignEx);
                    }
                }
                return copyOnWriteArrayList2;
            } catch (Exception e) {
                e = e;
                copyOnWriteArrayList = copyOnWriteArrayList2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        e.printStackTrace();
        return copyOnWriteArrayList;
    }

    public CopyOnWriteArrayList<CampaignEx> b(String str, int i, boolean z, String str2) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            com.mbridge.msdk.videocommon.setting.a aVarC = b.b().c();
            long jE = aVarC != null ? aVarC.e() : 0L;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            List<CampaignEx> listA = z ? this.f5957a.a(str, 0, 0, i, str2) : this.f5957a.a(str, 0, 0, i, false);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (listA == null) {
                return null;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            try {
                for (CampaignEx campaignEx : listA) {
                    if (campaignEx != null && (campaignEx.getReadyState() == 0 || campaignEx.getLoadTimeoutState() == 1)) {
                        long plct = campaignEx.getPlct() * 1000;
                        long timestamp = jCurrentTimeMillis - campaignEx.getTimestamp();
                        if ((plct > 0 && plct >= timestamp) || (plct <= 0 && jE >= timestamp)) {
                            copyOnWriteArrayList2.add(campaignEx);
                        }
                    }
                }
                return copyOnWriteArrayList2;
            } catch (Exception e) {
                e = e;
                copyOnWriteArrayList = copyOnWriteArrayList2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        e.printStackTrace();
        return copyOnWriteArrayList;
    }

    public void a(String str, List<CampaignEx> list, String str2, int i) {
        e eVar;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || TextUtils.isEmpty(str2) || (eVar = this.f5957a) == null) {
            return;
        }
        eVar.a(str, list, str2, i);
    }

    public void a(String str, List<CampaignEx> list) {
        e eVar;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || (eVar = this.f5957a) == null) {
            return;
        }
        eVar.b(str, list);
    }

    public void a(String str, List<CampaignEx> list, String str2) {
        e eVar;
        try {
            if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || (eVar = this.f5957a) == null) {
                return;
            }
            eVar.a(str, list, str2);
        } catch (Exception e) {
            o0.b(b, e.getMessage());
        }
    }

    public List<CampaignEx> c(String str, int i, boolean z) {
        return c(str, i, z, "");
    }

    public List<CampaignEx> c(String str, int i, boolean z, String str2) {
        long jA0;
        List<CampaignEx> listA;
        ArrayList arrayList = null;
        try {
            com.mbridge.msdk.setting.g gVarD = h.b().d(c.m().b());
            if (gVarD != null) {
                jA0 = gVarD.a0();
            } else {
                jA0 = h.b().a().a0();
            }
            long j = jA0 * 1000;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (z) {
                listA = this.f5957a.a(str, 0, 0, i, str2);
            } else {
                listA = this.f5957a.a(str, 0, 0, i, false);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (listA == null) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (CampaignEx campaignEx : listA) {
                    if (campaignEx != null && campaignEx.getReadyState() == 0) {
                        long plctb = campaignEx.getPlctb() * 1000;
                        long timestamp = jCurrentTimeMillis - campaignEx.getTimestamp();
                        if ((plctb <= 0 && j >= timestamp) || (plctb > 0 && plctb >= timestamp)) {
                            arrayList2.add(campaignEx);
                        }
                    }
                }
                return arrayList2;
            } catch (Exception e) {
                e = e;
                arrayList = arrayList2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        e.printStackTrace();
        return arrayList;
    }

    public void a(String str, String str2) {
        if (this.f5957a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f5957a.a(str, str2);
    }

    public List<CampaignEx> a(List<CampaignEx> list) {
        ArrayList arrayList = null;
        if (list == null) {
            return null;
        }
        try {
            com.mbridge.msdk.videocommon.setting.a aVarC = b.b().c();
            long jE = aVarC != null ? aVarC.e() : 0L;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (list.size() <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (CampaignEx campaignEx : list) {
                    if (campaignEx != null) {
                        long plct = campaignEx.getPlct() * 1000;
                        long timestamp = jCurrentTimeMillis - campaignEx.getTimestamp();
                        if ((plct > 0 && plct >= timestamp) || (plct <= 0 && jE >= timestamp)) {
                            arrayList2.add(campaignEx);
                        }
                    }
                }
                return arrayList2;
            } catch (Exception e) {
                e = e;
                arrayList = arrayList2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        e.printStackTrace();
        return arrayList;
    }

    public void b(String str, CampaignEx campaignEx) {
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new RunnableC0522a(str, campaignEx));
    }

    public void b(String str) {
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> concurrentHashMapF;
        try {
            if (TextUtils.isEmpty(str) || (concurrentHashMapF = this.f5957a.f(str)) == null || concurrentHashMapF.size() <= 0) {
                return;
            }
            com.mbridge.msdk.setting.g gVarD = h.b().d(c.m().b());
            if (gVarD == null) {
                gVarD = h.b().a();
            }
            long jA0 = gVarD != null ? gVarD.a0() : 0L;
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (com.mbridge.msdk.foundation.entity.c cVar : concurrentHashMapF.values()) {
                if (cVar != null) {
                    long jE = cVar.e();
                    if (jE <= 0) {
                        jE = jA0;
                    }
                    if (cVar.f() + (jE * 1000) < jCurrentTimeMillis && !TextUtils.isEmpty(cVar.a())) {
                        o0.b("HBOPTIMIZE", "不在有效期范围内 删除" + cVar.a());
                        c(str, cVar.a());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<com.mbridge.msdk.foundation.entity.c> a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return this.f5957a.d(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int a(String str, int i, boolean z, String str2) {
        List<CampaignEx> listA;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            if (z) {
                listA = this.f5957a.a(str, 0, 0, i, str2);
            } else {
                listA = this.f5957a.a(str, 0, 0, i, false);
            }
            if (listA == null) {
                return 0;
            }
            for (CampaignEx campaignEx : listA) {
                if (campaignEx != null && campaignEx.getReadyState() == 0) {
                    arrayList.add(campaignEx);
                }
            }
            return arrayList.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public synchronized void c(String str, String str2) {
        try {
            this.f5957a.f(str2, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CampaignEx> a(String str, int i, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f5957a.a(str, 0, 0, i, z);
        } catch (Exception e) {
            o0.b(b, e.getLocalizedMessage());
            return null;
        }
    }

    public void b(String str, String str2) {
        e eVar = this.f5957a;
        if (eVar != null) {
            eVar.c(str, str2);
        }
    }

    public synchronized void b(String str, int i) {
        try {
            com.mbridge.msdk.setting.g gVarD = h.b().d(c.m().b());
            if (gVarD == null) {
                gVarD = h.b().a();
            }
            int iF = gVarD.f();
            if (iF == 0) {
                return;
            }
            boolean z = true;
            List<CampaignEx> listB = this.f5957a.b(str, i, iF == 2);
            if (listB != null && listB.size() > 0) {
                for (CampaignEx campaignEx : listB) {
                    com.mbridge.msdk.videocommon.a.e(campaignEx.getCampaignUnitId() + "_" + campaignEx.getId() + "_" + campaignEx.getRequestIdNotice() + "_" + campaignEx.getCMPTEntryUrl());
                }
            }
            e eVar = this.f5957a;
            if (iF != 2) {
                z = false;
            }
            eVar.a(str, i, z);
        } catch (Exception e) {
            o0.b(b, e.getMessage());
        }
    }

    public void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (campaignEx.isBidCampaign()) {
                    com.mbridge.msdk.foundation.same.buffer.b.c(str, campaignEx.getRequestId());
                }
                String localRequestId = campaignEx.getLocalRequestId();
                if (!TextUtils.isEmpty(localRequestId)) {
                    boolean z = true;
                    if (campaignEx.getSecondRequestIndex() != 1 && !localRequestId.contains("label_second")) {
                        z = false;
                    }
                    if (localRequestId.contains("label_second")) {
                        localRequestId = localRequestId.replace("label_second", "");
                    }
                    if (z) {
                        this.f5957a.a(str, localRequestId, localRequestId + "label_second");
                        return;
                    } else {
                        this.f5957a.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
                        return;
                    }
                }
                this.f5957a.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(String str, CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String localRequestId = campaignEx.getLocalRequestId();
                if (!TextUtils.isEmpty(localRequestId)) {
                    boolean z = true;
                    if (campaignEx.getSecondRequestIndex() != 1 && !localRequestId.contains("label_second")) {
                        z = false;
                    }
                    if (localRequestId.contains("label_second")) {
                        localRequestId = localRequestId.replace("label_second", "");
                    }
                    if (z) {
                        this.f5957a.a(str, localRequestId, localRequestId + "label_second");
                        return;
                    } else {
                        this.f5957a.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
                        return;
                    }
                }
                this.f5957a.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getId())) {
                    return;
                }
                this.f5957a.d(campaignEx.getId(), campaignEx.getRequestId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(String str, int i) {
        int size;
        try {
            List<com.mbridge.msdk.foundation.entity.c> listD = this.f5957a.d(str);
            if (listD == null || listD.size() <= 0 || (size = listD.size() - i) <= 0) {
                return;
            }
            for (int i2 = 0; i2 < size; i2++) {
                c(str, listD.get(i2).a());
                com.mbridge.msdk.foundation.same.buffer.b.c(str, listD.get(i2).a());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String str, String str2, List<CampaignEx> list) {
        try {
            if (TextUtils.isEmpty(str2) || list == null || list.size() <= 0) {
                return;
            }
            this.f5957a.a(list, str, str2, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void a(long j, String str) {
        try {
            this.f5957a.b(j, str);
        } catch (Exception e) {
            e.printStackTrace();
            o0.b(b, e.getMessage());
        }
    }
}
