package com.inmobi.media;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class N2 {
    public static final List j;
    public long b;
    public int d;
    public int g;
    public int h;
    public int i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3142a = "";
    public long c = -1;
    public long e = -1;
    public int f = -1;

    static {
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, "bid", "its", "vtm", "plid", "catid", "hcd", "hsv", "hcv"});
        j = listListOf;
        listListOf.size();
    }
}
