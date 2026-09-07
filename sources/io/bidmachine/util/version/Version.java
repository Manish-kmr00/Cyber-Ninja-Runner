package io.bidmachine.util.version;

import com.smaato.sdk.core.dns.DnsName;
import com.yandex.div.core.DivActionHandler;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: Version.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0000H\u0096\u0002J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\t\u0010\n\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0000J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0000J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0000J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0000J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lio/bidmachine/util/version/Version;", "", "major", "", "minor", DivActionHandler.DivActionReason.PATCH, "(III)V", "compareTo", "other", "component1", "component2", "component3", "copy", "equals", "", "", "hashCode", "isAfter", "version", "isAfterOrEquals", "isBefore", "isBeforeOrEquals", "toString", "", "Companion", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final /* data */ class Version implements Comparable<Version> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int major;
    private final int minor;
    private final int patch;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int getMajor() {
        return this.major;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getMinor() {
        return this.minor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final int getPatch() {
        return this.patch;
    }

    public static /* synthetic */ Version copy$default(Version version, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = version.major;
        }
        if ((i4 & 2) != 0) {
            i2 = version.minor;
        }
        if ((i4 & 4) != 0) {
            i3 = version.patch;
        }
        return version.copy(i, i2, i3);
    }

    @JvmStatic
    public static final Version parseVersion(String str) {
        return INSTANCE.parseVersion(str);
    }

    public final Version copy(int major, int minor, int patch) {
        return new Version(major, minor, patch);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Version)) {
            return false;
        }
        Version version = (Version) other;
        return this.major == version.major && this.minor == version.minor && this.patch == version.patch;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.major) * 31) + Integer.hashCode(this.minor)) * 31) + Integer.hashCode(this.patch);
    }

    public Version(int i, int i2, int i3) {
        this.major = i;
        this.minor = i2;
        this.patch = i3;
    }

    public String toString() {
        return new StringBuilder().append(this.major).append('.').append(this.minor).append('.').append(this.patch).toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(Version other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iCompare = Intrinsics.compare(this.major, other.major);
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Intrinsics.compare(this.minor, other.minor);
        return iCompare2 != 0 ? iCompare2 : Intrinsics.compare(this.patch, other.patch);
    }

    public final boolean isAfter(Version version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return compareTo(version) > 0;
    }

    public final boolean isAfterOrEquals(Version version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return compareTo(version) >= 0;
    }

    public final boolean isBefore(Version version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return compareTo(version) < 0;
    }

    public final boolean isBeforeOrEquals(Version version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return compareTo(version) <= 0;
    }

    /* JADX INFO: compiled from: Version.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lio/bidmachine/util/version/Version$Companion;", "", "()V", "parseVersion", "Lio/bidmachine/util/version/Version;", "versionString", "", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Version parseVersion(String versionString) {
            List listEmptyList;
            String str = versionString;
            if (str != null && str.length() != 0) {
                try {
                    List<String> listSplit = new Regex(DnsName.ESCAPED_DOT).split(versionString, 0);
                    if (!listSplit.isEmpty()) {
                        ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                        while (true) {
                            if (listIterator.hasPrevious()) {
                                if (listIterator.previous().length() != 0) {
                                    listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                                    break;
                                }
                            } else {
                                listEmptyList = CollectionsKt.emptyList();
                                break;
                            }
                        }
                    } else {
                        listEmptyList = CollectionsKt.emptyList();
                        break;
                    }
                    String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
                    if (strArr.length == 0) {
                        return null;
                    }
                    int length = strArr.length;
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    for (int i4 = 0; i4 < length; i4++) {
                        if (i4 == 0) {
                            i = Integer.parseInt(strArr[0]);
                        } else if (i4 == 1) {
                            i2 = Integer.parseInt(strArr[1]);
                        } else if (i4 == 2) {
                            i3 = Integer.parseInt(strArr[2]);
                        } else {
                            i3 = (i3 * 100) + Integer.parseInt(strArr[i4]);
                        }
                    }
                    return new Version(i, i2, i3);
                } catch (Throwable unused) {
                }
            }
            return null;
        }
    }
}
