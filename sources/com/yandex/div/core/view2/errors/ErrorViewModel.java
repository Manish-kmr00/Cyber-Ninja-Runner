package com.yandex.div.core.view2.errors;

import com.yandex.div.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorViewModel.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0010\u001a\u00020\bHÂ\u0003J\t\u0010\u0011\u001a\u00020\bHÂ\u0003J;\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\bJ\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yandex/div/core/view2/errors/ErrorViewModel;", "", "showDetails", "", "errorCount", "", "warningCount", "errorDetails", "", "warningDetails", "(ZIILjava/lang/String;Ljava/lang/String;)V", "getShowDetails", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "getCounterBackground", "getCounterText", "getDetails", "hashCode", "toString", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class ErrorViewModel {
    private final int errorCount;
    private final String errorDetails;
    private final boolean showDetails;
    private final int warningCount;
    private final String warningDetails;

    public ErrorViewModel() {
        this(false, 0, 0, null, null, 31, null);
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getErrorCount() {
        return this.errorCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final int getWarningCount() {
        return this.warningCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final String getErrorDetails() {
        return this.errorDetails;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final String getWarningDetails() {
        return this.warningDetails;
    }

    public static /* synthetic */ ErrorViewModel copy$default(ErrorViewModel errorViewModel, boolean z, int i, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = errorViewModel.showDetails;
        }
        if ((i3 & 2) != 0) {
            i = errorViewModel.errorCount;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = errorViewModel.warningCount;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            str = errorViewModel.errorDetails;
        }
        String str3 = str;
        if ((i3 & 16) != 0) {
            str2 = errorViewModel.warningDetails;
        }
        return errorViewModel.copy(z, i4, i5, str3, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowDetails() {
        return this.showDetails;
    }

    public final ErrorViewModel copy(boolean showDetails, int errorCount, int warningCount, String errorDetails, String warningDetails) {
        Intrinsics.checkNotNullParameter(errorDetails, "errorDetails");
        Intrinsics.checkNotNullParameter(warningDetails, "warningDetails");
        return new ErrorViewModel(showDetails, errorCount, warningCount, errorDetails, warningDetails);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorViewModel)) {
            return false;
        }
        ErrorViewModel errorViewModel = (ErrorViewModel) other;
        return this.showDetails == errorViewModel.showDetails && this.errorCount == errorViewModel.errorCount && this.warningCount == errorViewModel.warningCount && Intrinsics.areEqual(this.errorDetails, errorViewModel.errorDetails) && Intrinsics.areEqual(this.warningDetails, errorViewModel.warningDetails);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z = this.showDetails;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((r0 * 31) + Integer.hashCode(this.errorCount)) * 31) + Integer.hashCode(this.warningCount)) * 31) + this.errorDetails.hashCode()) * 31) + this.warningDetails.hashCode();
    }

    public String toString() {
        return "ErrorViewModel(showDetails=" + this.showDetails + ", errorCount=" + this.errorCount + ", warningCount=" + this.warningCount + ", errorDetails=" + this.errorDetails + ", warningDetails=" + this.warningDetails + ')';
    }

    public ErrorViewModel(boolean z, int i, int i2, String errorDetails, String warningDetails) {
        Intrinsics.checkNotNullParameter(errorDetails, "errorDetails");
        Intrinsics.checkNotNullParameter(warningDetails, "warningDetails");
        this.showDetails = z;
        this.errorCount = i;
        this.warningCount = i2;
        this.errorDetails = errorDetails;
        this.warningDetails = warningDetails;
    }

    public /* synthetic */ ErrorViewModel(boolean z, int i, int i2, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? 0 : i, (i3 & 4) == 0 ? i2 : 0, (i3 & 8) != 0 ? "" : str, (i3 & 16) != 0 ? "" : str2);
    }

    public final boolean getShowDetails() {
        return this.showDetails;
    }

    public final String getDetails() {
        if (this.errorCount > 0 && this.warningCount > 0) {
            return this.errorDetails + "\n\n" + this.warningDetails;
        }
        if (this.warningCount > 0) {
            return this.warningDetails;
        }
        return this.errorDetails;
    }

    public final int getCounterBackground() {
        int i = this.warningCount;
        if (i > 0 && this.errorCount > 0) {
            return R.drawable.warning_error_counter_background;
        }
        if (i == 0 && this.errorCount == 0) {
            return R.drawable.neutral_counter_background;
        }
        if (i > 0) {
            return R.drawable.warning_counter_background;
        }
        return R.drawable.error_counter_background;
    }

    public final String getCounterText() {
        int i = this.errorCount;
        if (i > 0 && this.warningCount > 0) {
            return new StringBuilder().append(this.errorCount).append('/').append(this.warningCount).toString();
        }
        int i2 = this.warningCount;
        if (i2 > 0) {
            return String.valueOf(i2);
        }
        if (i > 0) {
            return String.valueOf(i);
        }
        return "";
    }
}
