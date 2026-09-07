package io.bidmachine.rendering.internal.event;

import android.text.TextUtils;
import io.bidmachine.rendering.internal.m;
import io.bidmachine.rendering.model.EventTaskParams;
import io.bidmachine.rendering.model.EventTaskType;
import io.bidmachine.rendering.model.EventType;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.utils.PrivacySheetParamsParser;
import io.bidmachine.rendering.utils.Utils;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class b implements io.bidmachine.rendering.internal.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12363a;
    private final c b;
    private final Map c;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12364a;

        static {
            int[] iArr = new int[EventTaskType.values().length];
            f12364a = iArr;
            try {
                iArr[EventTaskType.Track.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12364a[EventTaskType.Open.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12364a[EventTaskType.NotifyOpen.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12364a[EventTaskType.Skip.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12364a[EventTaskType.Close.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12364a[EventTaskType.Mute.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12364a[EventTaskType.UnMute.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12364a[EventTaskType.Show.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12364a[EventTaskType.Hide.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12364a[EventTaskType.Progress.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12364a[EventTaskType.Schedule.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f12364a[EventTaskType.Start.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f12364a[EventTaskType.LockVisibility.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f12364a[EventTaskType.UnlockVisibility.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f12364a[EventTaskType.SimulateClick.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f12364a[EventTaskType.OpenPrivacySheet.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public b(String str, c cVar, Map map) {
        this.f12363a = str;
        this.b = cVar;
        this.c = map == null ? new EnumMap(EventType.class) : map;
    }

    private void a(EventType eventType, EventTaskParams eventTaskParams, Object... objArr) {
        a(eventType, eventTaskParams.getEventTaskType(), eventTaskParams.getTarget(), eventTaskParams.getValue(), objArr);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void b() {
        a(EventType.OnResume, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void c() {
        a(EventType.OnUnMute, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void d() {
        a(EventType.OnThirdQuartile, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void e() {
        a(EventType.OnSkip, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void f() {
        a(EventType.OnMute, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public String g() {
        return this.f12363a;
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void h() {
        a(EventType.OnPause, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void i() {
        a(EventType.OnClick, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void j() {
        a(EventType.OnMidpoint, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void k() {
        a(EventType.OnScheduled, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void l() {
        a(EventType.OnFirstQuartile, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void m() {
        a(EventType.OnStart, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void n() {
        a(EventType.OnImpression, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void onClose() {
        a(EventType.OnClose, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void onUseCustomClose(boolean z) {
        a(EventType.OnUseCustomClose, Boolean.valueOf(z));
    }

    private void a(EventType eventType, EventTaskType eventTaskType, String str, Object obj, Object... objArr) {
        try {
            switch (a.f12364a[eventTaskType.ordinal()]) {
                case 1:
                    String string = Utils.toString(obj);
                    if (string != null) {
                        a(eventType, eventTaskType, "%s", string);
                        this.b.h(string);
                    } else {
                        a(eventType, eventTaskType, "track url");
                    }
                    break;
                case 2:
                    String string2 = Utils.toString(obj);
                    if (TextUtils.isEmpty(string2) && objArr != null && objArr.length >= 1) {
                        string2 = Utils.toString(objArr[0]);
                    }
                    if (!TextUtils.isEmpty(string2)) {
                        a(eventType, eventTaskType, "%s", string2);
                        this.b.d(string2);
                    } else {
                        a(eventType, eventTaskType, "open url");
                    }
                    break;
                case 3:
                    String string3 = Utils.toString(obj);
                    if (TextUtils.isEmpty(string3) && objArr != null && objArr.length >= 1) {
                        string3 = Utils.toString(objArr[0]);
                    }
                    if (!TextUtils.isEmpty(string3)) {
                        a(eventType, eventTaskType, "%s", string3);
                        this.b.e(string3);
                    } else {
                        a(eventType, eventTaskType, "notify open url");
                    }
                    break;
                case 4:
                    a(eventType, eventTaskType);
                    this.b.f();
                    break;
                case 5:
                    a(eventType, eventTaskType);
                    this.b.b();
                    break;
                case 6:
                    a(eventType, eventTaskType, "target - %s", str);
                    this.b.c(str);
                    break;
                case 7:
                    a(eventType, eventTaskType, "target - %s", str);
                    this.b.i(str);
                    break;
                case 8:
                    a(eventType, eventTaskType, "target - %s", str);
                    this.b.a(str);
                    break;
                case 9:
                    a(eventType, eventTaskType, "target - %s", str);
                    this.b.b(str);
                    break;
                case 10:
                    if (objArr != null && objArr.length >= 2) {
                        Long l = Utils.toLong(objArr[0]);
                        Long l2 = Utils.toLong(objArr[1]);
                        if (l != null && l2 != null) {
                            this.b.a(str, l.longValue(), l2.longValue(), (l2.longValue() * 100.0f) / l.longValue());
                        }
                        a(eventType, eventTaskType, "maxProgressMs, currentProgressMs");
                    }
                    a(eventType, eventTaskType, "progress parameters");
                    break;
                case 11:
                    Long l3 = Utils.toLong(obj);
                    if (l3 != null) {
                        a(eventType, eventTaskType, "target - %s, timeMs - %s", str, l3);
                        this.b.a(str, l3.longValue());
                    } else {
                        a(eventType, eventTaskType, "schedule time");
                    }
                    break;
                case 12:
                    String string4 = Utils.toString(obj);
                    if (string4 != null) {
                        a(eventType, eventTaskType, "target - %s, value - %s", str, string4);
                        this.b.a(str, string4);
                        break;
                    }
                    break;
                case 13:
                    Boolean bool = Utils.toBoolean(obj);
                    if (bool == null && objArr != null && objArr.length >= 1) {
                        bool = Utils.toBoolean(objArr[0]);
                    }
                    if (bool != null) {
                        a(eventType, eventTaskType, "target - %s, lockVisibility - %s", str, bool);
                        this.b.a(str, bool.booleanValue());
                    } else {
                        a(eventType, eventTaskType, "visibility value");
                    }
                    break;
                case 14:
                    a(eventType, eventTaskType, "target - %s", str);
                    this.b.f(str);
                    break;
                case 15:
                    a(eventType, eventTaskType, "target - %s", str);
                    this.b.g(str);
                    break;
                case 16:
                    String string5 = Utils.toString(obj);
                    if (!TextUtils.isEmpty(string5)) {
                        PrivacySheetParams json = PrivacySheetParamsParser.parseJson(string5);
                        if (json != null) {
                            a(eventType, eventTaskType, "%s", string5);
                            this.b.a(json);
                        } else {
                            a(eventType, eventTaskType, "value");
                        }
                    } else {
                        a(eventType, eventTaskType, "value");
                    }
                    break;
            }
        } catch (Throwable th) {
            m.b(th);
        }
    }

    private void a(EventType eventType, Object... objArr) {
        List list = (List) this.c.get(eventType);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a(eventType, (EventTaskParams) it.next(), objArr);
        }
    }

    private void a(EventType eventType, EventTaskType eventTaskType) {
        a(eventType, eventTaskType, null, new Object[0]);
    }

    private void a(EventType eventType, EventTaskType eventTaskType, String str, Object... objArr) {
        if (m.a()) {
            if (str == null || objArr == null) {
                m.b("Event", "Event - %s (source - %s), Task - %s", eventType.getKey(), g(), eventTaskType.getKey());
                return;
            }
            try {
                m.b("Event", "Event - %s (source - %s), Task - %s (%s)", eventType.getKey(), g(), eventTaskType.getKey(), String.format(str, objArr));
            } catch (Throwable th) {
                m.b(th);
            }
        }
    }

    private static void a(EventType eventType, EventTaskType eventTaskType, String str) {
        m.a("Event", "Could not find required params (%s) for execute task (%s, %s)", str, eventType, eventTaskType);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void a() {
        a(EventType.OnComplete, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void a(String str) {
        a(EventType.OnNavigate, str);
    }

    @Override // io.bidmachine.rendering.internal.event.a
    public void a(long j, long j2) {
        a(EventType.OnProgress, Long.valueOf(j), Long.valueOf(j2));
    }
}
