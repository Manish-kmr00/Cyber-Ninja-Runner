package io.appmetrica.analytics.impl;

import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public abstract class F5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f11135a = CollectionUtils.createSortedListWithoutRepetitions("id", SDKAnalyticsEvents.PARAMETER_SESSION_ID, "session_type", "number_in_session", "type", "global_number", "time", "event_description");
}
