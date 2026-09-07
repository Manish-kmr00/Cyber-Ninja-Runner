package com.moloco.sdk.acm;

import androidx.core.app.NotificationCompat;
import com.json.b9;
import com.moloco.sdk.acm.services.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0019\b\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/moloco/sdk/acm/TimerEvent;", "Lcom/moloco/sdk/acm/c;", "", "startTimer", "stopTimer", "", "key", "value", "withTag", "Lcom/moloco/sdk/acm/services/f;", NotificationCompat.CATEGORY_STOPWATCH, "Lcom/moloco/sdk/acm/services/f;", "", "timeInMillis", "J", "", "Lcom/moloco/sdk/acm/EventTag;", "eventTags", "Ljava/util/List;", "getEventTags", "()Ljava/util/List;", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "getTime", "()J", "time", b9.h.j0, "<init>", "(Ljava/lang/String;Lcom/moloco/sdk/acm/services/f;)V", "Companion", "a", "moloco-android-client-metrics_release"}, k = 1, mv = {1, 8, 0})
public final class TimerEvent implements c {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_TAGS_PER_EVENT = 10;
    private static final int MAX_TAG_CHAR_LEN = 50;
    private final List<EventTag> eventTags;
    private final String name;
    private final com.moloco.sdk.acm.services.f stopwatch;
    private long timeInMillis;

    /* JADX INFO: renamed from: com.moloco.sdk.acm.TimerEvent$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TimerEvent a(String eventName) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            return new TimerEvent(eventName, new com.moloco.sdk.acm.services.f(new h()), null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ TimerEvent(String str, com.moloco.sdk.acm.services.f fVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fVar);
    }

    @Override // com.moloco.sdk.acm.c
    public List<EventTag> getEventTags() {
        return this.eventTags;
    }

    @Override // com.moloco.sdk.acm.c
    public String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: getTime, reason: from getter */
    public final long getTimeInMillis() {
        return this.timeInMillis;
    }

    public final void startTimer() {
        this.stopwatch.c();
    }

    public final void stopTimer() {
        if (this.timeInMillis == 0) {
            this.timeInMillis = this.stopwatch.a();
        }
    }

    private TimerEvent(String str, com.moloco.sdk.acm.services.f fVar) {
        this.stopwatch = fVar;
        this.eventTags = new ArrayList();
        this.name = str;
    }

    @Override // com.moloco.sdk.acm.c
    public TimerEvent withTag(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (getEventTags().size() < 10 && key.length() <= 50 && value.length() <= 50) {
            getEventTags().add(new EventTag(key, value));
        }
        return this;
    }
}
