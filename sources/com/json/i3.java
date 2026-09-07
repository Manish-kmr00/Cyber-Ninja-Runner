package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0017\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b$\u0010%J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\"\u0010\r\u001a\u00020\f2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0016J#\u0010\r\u001a\u00020\f2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000e\"\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0010J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0006\u0010!\"\u0004\b\r\u0010\"¨\u0006&"}, d2 = {"Lcom/ironsource/i3;", "Lcom/ironsource/q3;", "", "Lcom/ironsource/n3;", "list", "Lorg/json/JSONObject;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "Lcom/unity3d/ironsourceads/internal/analytics/EventCode;", "code", "", "arrayList", "", "a", "", "analyticsEventEntity", "([Lcom/ironsource/n3;)V", "Lcom/ironsource/l3;", "Lcom/ironsource/l3;", "eventBaseData", "Lcom/ironsource/rf;", "Lcom/ironsource/rf;", "eventsManager", "Lcom/ironsource/lm;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/lm;", "eventsMapper", "Lcom/ironsource/q9;", "d", "Lcom/ironsource/q9;", "currentTimeProvider", "e", "Ljava/util/List;", "()Ljava/util/List;", "(Ljava/util/List;)V", "additionalData", "<init>", "(Lcom/ironsource/l3;Lcom/ironsource/rf;Lcom/ironsource/lm;Lcom/ironsource/q9;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public class i3 implements q3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final l3 eventBaseData;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final rf eventsManager;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final lm<Integer, Integer> eventsMapper;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final q9 currentTimeProvider;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private List<n3> additionalData;

    public i3(l3 eventBaseData, rf eventsManager, lm<Integer, Integer> eventsMapper, q9 currentTimeProvider) {
        Intrinsics.checkNotNullParameter(eventBaseData, "eventBaseData");
        Intrinsics.checkNotNullParameter(eventsManager, "eventsManager");
        Intrinsics.checkNotNullParameter(eventsMapper, "eventsMapper");
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        this.eventBaseData = eventBaseData;
        this.eventsManager = eventsManager;
        this.eventsMapper = eventsMapper;
        this.currentTimeProvider = currentTimeProvider;
        this.additionalData = new ArrayList();
    }

    public /* synthetic */ i3(l3 l3Var, rf rfVar, lm lmVar, q9 q9Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l3Var, rfVar, lmVar, (i & 8) != 0 ? new q9.a() : q9Var);
    }

    private final JSONObject b(List<? extends n3> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends n3> it = list.iterator();
        while (it.hasNext()) {
            it.next().a(linkedHashMap);
        }
        return new JSONObject(linkedHashMap);
    }

    @Override // com.json.q3
    public void a() {
        this.additionalData.clear();
    }

    @Override // com.json.q3
    public void a(int code, List<n3> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "arrayList");
        try {
            Iterator<T> it = this.eventBaseData.a().iterator();
            while (it.hasNext()) {
                arrayList.add((n3) it.next());
            }
            Iterator<n3> it2 = this.additionalData.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
            this.eventsManager.a(new zb(this.eventsMapper.a(Integer.valueOf(code)).intValue(), this.currentTimeProvider.a(), b(arrayList)));
        } catch (Exception e) {
            o9.d().a(e);
            System.out.println((Object) ("LogRemote | Exception: " + e.getMessage()));
        }
    }

    public final void a(List<n3> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.additionalData = list;
    }

    @Override // com.json.q3
    public void a(n3... analyticsEventEntity) {
        Intrinsics.checkNotNullParameter(analyticsEventEntity, "analyticsEventEntity");
        for (n3 n3Var : analyticsEventEntity) {
            this.additionalData.add(n3Var);
        }
    }

    public final List<n3> b() {
        return this.additionalData;
    }
}
