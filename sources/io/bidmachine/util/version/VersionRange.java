package io.bidmachine.util.version;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.json.b9;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: VersionRange.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\rB)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0003J\u0013\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/bidmachine/util/version/VersionRange;", "", TypedValues.TransitionType.S_FROM, "Lio/bidmachine/util/version/Version;", "to", "isInclusiveFrom", "", "isInclusiveTo", "(Lio/bidmachine/util/version/Version;Lio/bidmachine/util/version/Version;ZZ)V", "contains", "version", "equals", "other", "Companion", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VersionRange {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Version from;
    private final boolean isInclusiveFrom;
    private final boolean isInclusiveTo;
    private final Version to;

    @JvmStatic
    public static final boolean isAfter(Version version, Version version2, boolean z) {
        return INSTANCE.isAfter(version, version2, z);
    }

    @JvmStatic
    public static final boolean isBefore(Version version, Version version2, boolean z) {
        return INSTANCE.isBefore(version, version2, z);
    }

    @JvmStatic
    public static final VersionRange parseVersionRange(String str) {
        return INSTANCE.parseVersionRange(str);
    }

    public VersionRange(Version version, Version version2, boolean z, boolean z2) {
        this.from = version;
        this.to = version2;
        this.isInclusiveFrom = z;
        this.isInclusiveTo = z2;
    }

    public final boolean contains(Version version) {
        Version version2;
        Intrinsics.checkNotNullParameter(version, "version");
        Version version3 = this.from;
        if (version3 != null && this.to != null) {
            Companion companion = INSTANCE;
            if (companion.isAfter(version3, version, this.isInclusiveFrom) && companion.isBefore(this.to, version, this.isInclusiveTo)) {
                return true;
            }
        }
        Version version4 = this.from;
        if (version4 != null && this.to == null && INSTANCE.isAfter(version4, version, this.isInclusiveFrom)) {
            return true;
        }
        if (this.from == null && (version2 = this.to) != null && INSTANCE.isBefore(version2, version, this.isInclusiveTo)) {
            return true;
        }
        return this.from == null && this.to == null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(getClass(), other.getClass())) {
            return false;
        }
        VersionRange versionRange = (VersionRange) other;
        return this.isInclusiveFrom == versionRange.isInclusiveFrom && this.isInclusiveTo == versionRange.isInclusiveTo && Intrinsics.areEqual(this.from, versionRange.from) && Intrinsics.areEqual(this.to, versionRange.to);
    }

    /* JADX INFO: compiled from: VersionRange.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¨\u0006\u000e"}, d2 = {"Lio/bidmachine/util/version/VersionRange$Companion;", "", "()V", "isAfter", "", OutlinedTextFieldKt.BorderId, "Lio/bidmachine/util/version/Version;", "version", "isInclusive", "isBefore", "parseVersionRange", "Lio/bidmachine/util/version/VersionRange;", "versionRangeString", "", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final VersionRange parseVersionRange(String versionRangeString) {
            List listEmptyList;
            String str = versionRangeString;
            if (str != null && str.length() != 0) {
                try {
                    boolean zStartsWith$default = StringsKt.startsWith$default(versionRangeString, b9.i.d, false, 2, (Object) null);
                    boolean zStartsWith$default2 = StringsKt.startsWith$default(versionRangeString, "(", false, 2, (Object) null);
                    if (zStartsWith$default || zStartsWith$default2) {
                        versionRangeString = versionRangeString.substring(1);
                        Intrinsics.checkNotNullExpressionValue(versionRangeString, "this as java.lang.String).substring(startIndex)");
                    } else {
                        zStartsWith$default = true;
                    }
                    boolean zEndsWith$default = StringsKt.endsWith$default(versionRangeString, b9.i.e, false, 2, (Object) null);
                    boolean zEndsWith$default2 = StringsKt.endsWith$default(versionRangeString, ")", false, 2, (Object) null);
                    if (zEndsWith$default || zEndsWith$default2) {
                        versionRangeString = versionRangeString.substring(0, versionRangeString.length() - 1);
                        Intrinsics.checkNotNullExpressionValue(versionRangeString, "this as java.lang.String…ing(startIndex, endIndex)");
                    } else {
                        zEndsWith$default = true;
                    }
                    List<String> listSplit = new Regex("-").split(versionRangeString, 0);
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
                    if (strArr.length < 2) {
                        Version version = Version.INSTANCE.parseVersion(versionRangeString);
                        if (version != null) {
                            return new VersionRange(version, version, zStartsWith$default, zEndsWith$default);
                        }
                        return null;
                    }
                    return new VersionRange(Version.INSTANCE.parseVersion(strArr[0]), Version.INSTANCE.parseVersion(strArr[1]), zStartsWith$default, zEndsWith$default);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        @JvmStatic
        public final boolean isAfter(Version border, Version version, boolean isInclusive) {
            Intrinsics.checkNotNullParameter(border, "border");
            Intrinsics.checkNotNullParameter(version, "version");
            return (isInclusive && version.isAfterOrEquals(border)) || (!isInclusive && version.isAfter(border));
        }

        @JvmStatic
        public final boolean isBefore(Version border, Version version, boolean isInclusive) {
            Intrinsics.checkNotNullParameter(border, "border");
            Intrinsics.checkNotNullParameter(version, "version");
            return (isInclusive && version.isBeforeOrEquals(border)) || (!isInclusive && version.isBefore(border));
        }
    }
}
