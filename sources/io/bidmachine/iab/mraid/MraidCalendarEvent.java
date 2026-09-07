package io.bidmachine.iab.mraid;

import java.util.Date;
import java.util.Objects;

/* JADX INFO: loaded from: classes13.dex */
public final class MraidCalendarEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12197a;
    private final Date b;
    private String c;
    private String d;
    private Date e;
    private String f;
    private String g;
    private String h;

    MraidCalendarEvent(String str, Date date) {
        this.f12197a = str;
        this.b = date;
    }

    void a(Date date) {
        this.e = date;
    }

    void b(String str) {
        this.h = str;
    }

    void c(String str) {
        this.f = str;
    }

    void d(String str) {
        this.d = str;
    }

    void e(String str) {
        this.g = str;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MraidCalendarEvent)) {
            return false;
        }
        MraidCalendarEvent mraidCalendarEvent = (MraidCalendarEvent) o;
        return Objects.equals(this.f12197a, mraidCalendarEvent.f12197a) && Objects.equals(this.b, mraidCalendarEvent.b) && Objects.equals(this.c, mraidCalendarEvent.c) && Objects.equals(this.d, mraidCalendarEvent.d) && Objects.equals(this.e, mraidCalendarEvent.e) && Objects.equals(this.f, mraidCalendarEvent.f) && Objects.equals(this.g, mraidCalendarEvent.g) && Objects.equals(this.h, mraidCalendarEvent.h);
    }

    public String getDescription() {
        return this.f12197a;
    }

    public Date getEnd() {
        return this.e;
    }

    public String getLocation() {
        return this.c;
    }

    public String getRecurrence() {
        return this.h;
    }

    public Date getStart() {
        return this.b;
    }

    public String getStatus() {
        return this.f;
    }

    public String getSummary() {
        return this.d;
    }

    public String getTransparency() {
        return this.g;
    }

    public int hashCode() {
        return Objects.hash(this.f12197a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    public String toString() {
        return "MraidCalendarEvent{description='" + this.f12197a + "', start=" + this.b + ", location='" + this.c + "', summary='" + this.d + "', end=" + this.e + ", status='" + this.f + "', transparency='" + this.g + "', recurrence='" + this.h + "'}";
    }

    void a(String str) {
        this.c = str;
    }
}
