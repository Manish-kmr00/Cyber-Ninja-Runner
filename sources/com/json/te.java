package com.json;

import com.facebook.login.LoginLogger;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/ironsource/te;", "", "Lcom/ironsource/ue;", "handler", "", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public interface te {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/ironsource/te$a;", "Lcom/ironsource/te;", "Lcom/ironsource/ue;", "handler", "", "a", "Lcom/ironsource/qe;", LoginLogger.EVENT_EXTRAS_FAILURE, "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/ironsource/qe;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/ironsource/qe;", "<init>", "(Lcom/ironsource/qe;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class a implements te {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final qe failure;

        public a(qe failure) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            this.failure = failure;
        }

        public static /* synthetic */ a a(a aVar, qe qeVar, int i, Object obj) {
            if ((i & 1) != 0) {
                qeVar = aVar.failure;
            }
            return aVar.a(qeVar);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final qe getFailure() {
            return this.failure;
        }

        public final a a(qe failure) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            return new a(failure);
        }

        @Override // com.json.te
        public void a(ue handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            handler.a(this.failure);
        }

        public final qe b() {
            return this.failure;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof a) && Intrinsics.areEqual(this.failure, ((a) other).failure);
        }

        public int hashCode() {
            return this.failure.hashCode();
        }

        public String toString() {
            return "Failure(failure=" + this.failure + ')';
        }
    }

    default void a(ue handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
    }
}
