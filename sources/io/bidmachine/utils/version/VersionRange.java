package io.bidmachine.utils.version;

import android.text.TextUtils;
import com.json.b9;
import java.util.Objects;

/* JADX INFO: loaded from: classes9.dex */
public class VersionRange {
    private final Version from;
    private final boolean isInclusiveFrom;
    private final boolean isInclusiveTo;
    private final Version to;

    public VersionRange(Version version, Version version2, boolean z, boolean z2) {
        this.from = version;
        this.to = version2;
        this.isInclusiveFrom = z;
        this.isInclusiveTo = z2;
    }

    public boolean contains(Version version) {
        Version version2;
        Version version3 = this.from;
        if (version3 != null && this.to != null && isAfter(version3, version, this.isInclusiveFrom) && isBefore(this.to, version, this.isInclusiveTo)) {
            return true;
        }
        Version version4 = this.from;
        if (version4 != null && this.to == null && isAfter(version4, version, this.isInclusiveFrom)) {
            return true;
        }
        if (this.from == null && (version2 = this.to) != null && isBefore(version2, version, this.isInclusiveTo)) {
            return true;
        }
        return this.from == null && this.to == null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VersionRange versionRange = (VersionRange) obj;
        return this.isInclusiveFrom == versionRange.isInclusiveFrom && this.isInclusiveTo == versionRange.isInclusiveTo && Objects.equals(this.from, versionRange.from) && Objects.equals(this.to, versionRange.to);
    }

    public static VersionRange parseVersionRange(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            boolean zStartsWith = str.startsWith(b9.i.d);
            boolean zStartsWith2 = str.startsWith("(");
            if (zStartsWith || zStartsWith2) {
                str = str.substring(1);
            } else {
                zStartsWith = true;
            }
            boolean zEndsWith = str.endsWith(b9.i.e);
            boolean zEndsWith2 = str.endsWith(")");
            if (zEndsWith || zEndsWith2) {
                str = str.substring(0, str.length() - 1);
            } else {
                zEndsWith = true;
            }
            String[] strArrSplit = str.split("-");
            if (strArrSplit.length < 2) {
                Version version = Version.parseVersion(str);
                if (version != null) {
                    return new VersionRange(version, version, zStartsWith, zEndsWith);
                }
                return null;
            }
            return new VersionRange(Version.parseVersion(strArrSplit[0]), Version.parseVersion(strArrSplit[1]), zStartsWith, zEndsWith);
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean isAfter(Version version, Version version2, boolean z) {
        return (z && version2.isAfterOrEquals(version)) || (!z && version2.isAfter(version));
    }

    static boolean isBefore(Version version, Version version2, boolean z) {
        return (z && version2.isBeforeOrEquals(version)) || (!z && version2.isBefore(version));
    }
}
