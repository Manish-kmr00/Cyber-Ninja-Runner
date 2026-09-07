package io.bidmachine.rendering.model;

import android.graphics.Bitmap;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB%\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J-\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lio/bidmachine/rendering/model/PrivacySheetParams;", "", "", "component1", "component2", "", "Lio/bidmachine/rendering/model/PrivacySheetParams$Action;", "component3", "title", "subtitle", "actions", "copy", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getSubtitle", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/util/List;", "getActions", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Action", "ActionType", "bidmachine-android-rendering_d_2_4_0"}, k = 1, mv = {1, 7, 1})
public final /* data */ class PrivacySheetParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String title;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String subtitle;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final List actions;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010#B-\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\"\u0010$J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0004HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R(\u0010!\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lio/bidmachine/rendering/model/PrivacySheetParams$Action;", "", "Lio/bidmachine/rendering/model/PrivacySheetParams$ActionType;", "component1", "", "component2", "component3", "type", "title", "data", "copy", "toString", "", "hashCode", "other", "", "equals", "a", "Lio/bidmachine/rendering/model/PrivacySheetParams$ActionType;", "getType", "()Lio/bidmachine/rendering/model/PrivacySheetParams$ActionType;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "getData", "Landroid/graphics/Bitmap;", "<set-?>", "d", "Landroid/graphics/Bitmap;", "getIcon", "()Landroid/graphics/Bitmap;", "icon", "<init>", "(Lio/bidmachine/rendering/model/PrivacySheetParams$ActionType;Ljava/lang/String;Ljava/lang/String;)V", "(Lio/bidmachine/rendering/model/PrivacySheetParams$ActionType;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "bidmachine-android-rendering_d_2_4_0"}, k = 1, mv = {1, 7, 1})
    public static final /* data */ class Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final ActionType type;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final String title;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final String data;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private Bitmap icon;

        public Action(ActionType type, String title, String data) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(data, "data");
            this.type = type;
            this.title = title;
            this.data = data;
        }

        public static /* synthetic */ Action copy$default(Action action, ActionType actionType, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                actionType = action.type;
            }
            if ((i & 2) != 0) {
                str = action.title;
            }
            if ((i & 4) != 0) {
                str2 = action.data;
            }
            return action.copy(actionType, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ActionType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getData() {
            return this.data;
        }

        public final Action copy(ActionType type, String title, String data) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(data, "data");
            return new Action(type, title, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Action)) {
                return false;
            }
            Action action = (Action) other;
            return this.type == action.type && Intrinsics.areEqual(this.title, action.title) && Intrinsics.areEqual(this.data, action.data);
        }

        public final String getData() {
            return this.data;
        }

        public final Bitmap getIcon() {
            return this.icon;
        }

        public final String getTitle() {
            return this.title;
        }

        public final ActionType getType() {
            return this.type;
        }

        public int hashCode() {
            return (((this.type.hashCode() * 31) + this.title.hashCode()) * 31) + this.data.hashCode();
        }

        public String toString() {
            return "Action(type=" + this.type + ", title=" + this.title + ", data=" + this.data + ')';
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Action(ActionType type, String title, String data, Bitmap bitmap) {
            this(type, title, data);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(data, "data");
            this.icon = bitmap;
        }

        public /* synthetic */ Action(ActionType actionType, String str, String str2, Bitmap bitmap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(actionType, str, str2, (i & 8) != 0 ? null : bitmap);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lio/bidmachine/rendering/model/PrivacySheetParams$ActionType;", "", "(Ljava/lang/String;I)V", "REDIRECT", "COPY_TO_CLIPBOARD", "bidmachine-android-rendering_d_2_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum ActionType {
        REDIRECT,
        COPY_TO_CLIPBOARD
    }

    public PrivacySheetParams(String title, String subtitle, List<Action> actions) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.title = title;
        this.subtitle = subtitle;
        this.actions = actions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PrivacySheetParams copy$default(PrivacySheetParams privacySheetParams, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = privacySheetParams.title;
        }
        if ((i & 2) != 0) {
            str2 = privacySheetParams.subtitle;
        }
        if ((i & 4) != 0) {
            list = privacySheetParams.actions;
        }
        return privacySheetParams.copy(str, str2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    public final List<Action> component3() {
        return this.actions;
    }

    public final PrivacySheetParams copy(String title, String subtitle, List<Action> actions) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(actions, "actions");
        return new PrivacySheetParams(title, subtitle, actions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrivacySheetParams)) {
            return false;
        }
        PrivacySheetParams privacySheetParams = (PrivacySheetParams) other;
        return Intrinsics.areEqual(this.title, privacySheetParams.title) && Intrinsics.areEqual(this.subtitle, privacySheetParams.subtitle) && Intrinsics.areEqual(this.actions, privacySheetParams.actions);
    }

    public final List<Action> getActions() {
        return this.actions;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.actions.hashCode();
    }

    public String toString() {
        return "PrivacySheetParams(title=" + this.title + ", subtitle=" + this.subtitle + ", actions=" + this.actions + ')';
    }
}
