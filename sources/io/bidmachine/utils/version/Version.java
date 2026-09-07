package io.bidmachine.utils.version;

import android.text.TextUtils;
import com.smaato.sdk.core.dns.DnsName;
import java.util.Objects;

/* JADX INFO: loaded from: classes9.dex */
public class Version implements Comparable<Version> {
    private final int major;
    private final int minor;
    private final int patch;

    public Version(int i, int i2, int i3) {
        this.major = i;
        this.minor = i2;
        this.patch = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Version version = (Version) obj;
        return this.major == version.major && this.minor == version.minor && this.patch == version.patch;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.major), Integer.valueOf(this.minor), Integer.valueOf(this.patch));
    }

    public String toString() {
        return this.major + "." + this.minor + "." + this.patch;
    }

    @Override // java.lang.Comparable
    public int compareTo(Version version) {
        int iCompare = Integer.compare(this.major, version.major);
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Integer.compare(this.minor, version.minor);
        return iCompare2 != 0 ? iCompare2 : Integer.compare(this.patch, version.patch);
    }

    public boolean isAfter(Version version) {
        return compareTo(version) > 0;
    }

    public boolean isAfterOrEquals(Version version) {
        return compareTo(version) >= 0;
    }

    public boolean isBefore(Version version) {
        return compareTo(version) < 0;
    }

    public boolean isBeforeOrEquals(Version version) {
        return compareTo(version) <= 0;
    }

    public static Version parseVersion(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(DnsName.ESCAPED_DOT);
            if (strArrSplit.length == 0) {
                return null;
            }
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < strArrSplit.length; i4++) {
                if (i4 == 0) {
                    i = Integer.parseInt(strArrSplit[0]);
                } else if (i4 == 1) {
                    i2 = Integer.parseInt(strArrSplit[1]);
                } else if (i4 == 2) {
                    i3 = Integer.parseInt(strArrSplit[2]);
                } else {
                    i3 = (i3 * 100) + Integer.parseInt(strArrSplit[i4]);
                }
            }
            return new Version(i, i2, i3);
        } catch (Throwable unused) {
            return null;
        }
    }
}
