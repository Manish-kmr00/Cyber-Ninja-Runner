package com.yandex.div.core.util.mask;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextDiff.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/core/util/mask/TextDiff;", "", "start", "", "added", "removed", "(III)V", "getAdded", "()I", "getRemoved", "getStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class TextDiff {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int added;
    private final int removed;
    private final int start;

    public static /* synthetic */ TextDiff copy$default(TextDiff textDiff, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = textDiff.start;
        }
        if ((i4 & 2) != 0) {
            i2 = textDiff.added;
        }
        if ((i4 & 4) != 0) {
            i3 = textDiff.removed;
        }
        return textDiff.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAdded() {
        return this.added;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRemoved() {
        return this.removed;
    }

    public final TextDiff copy(int start, int added, int removed) {
        return new TextDiff(start, added, removed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextDiff)) {
            return false;
        }
        TextDiff textDiff = (TextDiff) other;
        return this.start == textDiff.start && this.added == textDiff.added && this.removed == textDiff.removed;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.start) * 31) + Integer.hashCode(this.added)) * 31) + Integer.hashCode(this.removed);
    }

    public String toString() {
        return "TextDiff(start=" + this.start + ", added=" + this.added + ", removed=" + this.removed + ')';
    }

    public TextDiff(int i, int i2, int i3) {
        this.start = i;
        this.added = i2;
        this.removed = i3;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getAdded() {
        return this.added;
    }

    public final int getRemoved() {
        return this.removed;
    }

    /* JADX INFO: compiled from: TextDiff.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/yandex/div/core/util/mask/TextDiff$Companion;", "", "()V", "build", "Lcom/yandex/div/core/util/mask/TextDiff;", "left", "", "right", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TextDiff build(String left, String right) {
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(right, "right");
            if (left.length() > right.length()) {
                TextDiff textDiffBuild = build(right, left);
                return new TextDiff(textDiffBuild.getStart(), textDiffBuild.getRemoved(), textDiffBuild.getAdded());
            }
            int length = right.length() - 1;
            int length2 = right.length() - left.length();
            int i = 0;
            while (i < length && i < left.length() && left.charAt(i) == right.charAt(i)) {
                i++;
            }
            while (true) {
                int i2 = length - length2;
                if (i2 < i || left.charAt(i2) != right.charAt(length)) {
                    break;
                }
                length--;
            }
            int i3 = (length + 1) - i;
            return new TextDiff(i, i3, i3 - length2);
        }
    }
}
