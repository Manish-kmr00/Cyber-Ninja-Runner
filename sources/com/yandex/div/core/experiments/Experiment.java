package com.yandex.div.core.experiments;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LONGTAP_ACTIONS_PASS_TO_CHILD_ENABLED' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: Experiment.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/yandex/div/core/experiments/Experiment;", "", "key", "", "defaultValue", "", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getDefaultValue", "()Z", "getKey", "()Ljava/lang/String;", "TAP_BEACONS_ENABLED", "VISIBILITY_BEACONS_ENABLED", "SWIPE_OUT_BEACONS_ENABLED", "LONGTAP_ACTIONS_PASS_TO_CHILD_ENABLED", "IGNORE_ACTION_MENU_ITEMS_ENABLED", "HYPHENATION_SUPPORT_ENABLED", "VISUAL_ERRORS_ENABLED", "ACCESSIBILITY_ENABLED", "VIEW_POOL_ENABLED", "VIEW_POOL_PROFILING_ENABLED", "VIEW_POOL_OPTIMIZATION_DEBUG", "RESOURCE_CACHE_ENABLED", "SHOW_RENDERING_TIME", "MULTIPLE_STATE_CHANGE_ENABLED", "BIND_ON_ATTACH_ENABLED", "COMPLEX_REBIND_ENABLED", "PAGER_PAGE_CLIP_ENABLED", "PERMANENT_DEBUG_PANEL_ENABLED", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Experiment {
    public static final Experiment COMPLEX_REBIND_ENABLED;
    public static final Experiment HYPHENATION_SUPPORT_ENABLED;
    public static final Experiment IGNORE_ACTION_MENU_ITEMS_ENABLED;
    public static final Experiment LONGTAP_ACTIONS_PASS_TO_CHILD_ENABLED;
    public static final Experiment MULTIPLE_STATE_CHANGE_ENABLED;
    public static final Experiment VIEW_POOL_OPTIMIZATION_DEBUG;
    public static final Experiment VIEW_POOL_PROFILING_ENABLED;
    public static final Experiment VISUAL_ERRORS_ENABLED;
    private final boolean defaultValue;
    private final String key;
    public static final Experiment TAP_BEACONS_ENABLED = new Experiment("TAP_BEACONS_ENABLED", 0, "tap_beacons_enabled", false, 2, null);
    public static final Experiment VISIBILITY_BEACONS_ENABLED = new Experiment("VISIBILITY_BEACONS_ENABLED", 1, "visibility_beacons_enabled", false, 2, null);
    public static final Experiment SWIPE_OUT_BEACONS_ENABLED = new Experiment("SWIPE_OUT_BEACONS_ENABLED", 2, "swipe_out_beacons_enabled", true);
    public static final Experiment ACCESSIBILITY_ENABLED = new Experiment("ACCESSIBILITY_ENABLED", 7, "accessibility_enabled", true);
    public static final Experiment VIEW_POOL_ENABLED = new Experiment("VIEW_POOL_ENABLED", 8, "view_pool_enabled", true);
    public static final Experiment RESOURCE_CACHE_ENABLED = new Experiment("RESOURCE_CACHE_ENABLED", 11, "resource_cache_enabled", true);
    public static final Experiment SHOW_RENDERING_TIME = new Experiment("SHOW_RENDERING_TIME", 12, "demo_activity_rendering_time_enabled", false);
    public static final Experiment BIND_ON_ATTACH_ENABLED = new Experiment("BIND_ON_ATTACH_ENABLED", 14, "bind_on_attach_enabled", false, 2, null);
    public static final Experiment PAGER_PAGE_CLIP_ENABLED = new Experiment("PAGER_PAGE_CLIP_ENABLED", 16, "pager_page_children_enabled", true);
    public static final Experiment PERMANENT_DEBUG_PANEL_ENABLED = new Experiment("PERMANENT_DEBUG_PANEL_ENABLED", 17, "permanent_debug_panel_enabled", false);
    private static final /* synthetic */ Experiment[] $VALUES = $values();

    private static final /* synthetic */ Experiment[] $values() {
        return new Experiment[]{TAP_BEACONS_ENABLED, VISIBILITY_BEACONS_ENABLED, SWIPE_OUT_BEACONS_ENABLED, LONGTAP_ACTIONS_PASS_TO_CHILD_ENABLED, IGNORE_ACTION_MENU_ITEMS_ENABLED, HYPHENATION_SUPPORT_ENABLED, VISUAL_ERRORS_ENABLED, ACCESSIBILITY_ENABLED, VIEW_POOL_ENABLED, VIEW_POOL_PROFILING_ENABLED, VIEW_POOL_OPTIMIZATION_DEBUG, RESOURCE_CACHE_ENABLED, SHOW_RENDERING_TIME, MULTIPLE_STATE_CHANGE_ENABLED, BIND_ON_ATTACH_ENABLED, COMPLEX_REBIND_ENABLED, PAGER_PAGE_CLIP_ENABLED, PERMANENT_DEBUG_PANEL_ENABLED};
    }

    public static Experiment valueOf(String str) {
        return (Experiment) Enum.valueOf(Experiment.class, str);
    }

    public static Experiment[] values() {
        return (Experiment[]) $VALUES.clone();
    }

    private Experiment(String str, int i, String str2, boolean z) {
        super(str, i);
        this.key = str2;
        this.defaultValue = z;
    }

    /* synthetic */ Experiment(String str, int i, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, (i2 & 2) != 0 ? false : z);
    }

    public final boolean getDefaultValue() {
        return this.defaultValue;
    }

    public final String getKey() {
        return this.key;
    }

    static {
        int i = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z = false;
        LONGTAP_ACTIONS_PASS_TO_CHILD_ENABLED = new Experiment("LONGTAP_ACTIONS_PASS_TO_CHILD_ENABLED", 3, "longtap_actions_pass_to_child", z, i, defaultConstructorMarker);
        int i2 = 2;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        boolean z2 = false;
        IGNORE_ACTION_MENU_ITEMS_ENABLED = new Experiment("IGNORE_ACTION_MENU_ITEMS_ENABLED", 4, "override_context_menu_handler", z2, i2, defaultConstructorMarker2);
        HYPHENATION_SUPPORT_ENABLED = new Experiment("HYPHENATION_SUPPORT_ENABLED", 5, "support_hyphenation", z, i, defaultConstructorMarker);
        VISUAL_ERRORS_ENABLED = new Experiment("VISUAL_ERRORS_ENABLED", 6, "visual_errors", z2, i2, defaultConstructorMarker2);
        VIEW_POOL_PROFILING_ENABLED = new Experiment("VIEW_POOL_PROFILING_ENABLED", 9, "view_pool_profiling_enabled", z, i, defaultConstructorMarker);
        VIEW_POOL_OPTIMIZATION_DEBUG = new Experiment("VIEW_POOL_OPTIMIZATION_DEBUG", 10, "view_pool_optimization_debug", z2, i2, defaultConstructorMarker2);
        int i3 = 2;
        DefaultConstructorMarker defaultConstructorMarker3 = null;
        boolean z3 = false;
        MULTIPLE_STATE_CHANGE_ENABLED = new Experiment("MULTIPLE_STATE_CHANGE_ENABLED", 13, "multiple_state_change_enabled", z3, i3, defaultConstructorMarker3);
        COMPLEX_REBIND_ENABLED = new Experiment("COMPLEX_REBIND_ENABLED", 15, "complex_rebind_enabled", z3, i3, defaultConstructorMarker3);
    }
}
