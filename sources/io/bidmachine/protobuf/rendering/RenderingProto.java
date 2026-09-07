package io.bidmachine.protobuf.rendering;

import androidx.constraintlayout.widget.Constraints;
import androidx.exifinterface.media.ExifInterface;
import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.ExtensionRegistry;
import com.explorestack.protobuf.ExtensionRegistryLite;
import com.explorestack.protobuf.GeneratedMessageV3;
import com.explorestack.protobuf.WrappersProto;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;

/* JADX INFO: loaded from: classes12.dex */
public final class RenderingProto {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n-bidmachine/protobuf/rendering/rendering.proto\u0012\u0013bidmachine.protobuf\u001a\u001egoogle/protobuf/wrappers.proto\"\u0099*\n\tRendering\u0012?\n\u000borientation\u0018\u0001 \u0001(\u000e2*.bidmachine.protobuf.Rendering.Orientation\u0012<\n\ncache_type\u0018\u0002 \u0001(\u000e2(.bidmachine.protobuf.Rendering.CacheType\u00124\n\u0006phases\u0018\u0003 \u0003(\u000b2$.bidmachine.protobuf.Rendering.Phase\u0012G\n\rcustom_params\u0018\u0004 \u0003(\u000b20.bidmachine.protobuf.Rendering.CustomParamsEntry\u0012J\n\rsk_ad_network\u0018\u0005 \u0001(\u000b23.bidmachine.protobuf.Rendering.SKStoreConfiguration\u0012R\n\u0015product_configuration\u0018\u0006 \u0001(\u000b23.bidmachine.protobuf.Rendering.ProductConfiguration\u001a¾\u001c\n\u0005Phase\u0012\u0010\n\bsequence\u0018\u0001 \u0001(\u0005\u0012\u0018\n\u0010background_color\u0018\u0002 \u0001(\t\u0012?\n\u0003ads\u0018\u0003 \u0003(\u000b22.bidmachine.protobuf.Rendering.Phase.ViewComponent\u0012D\n\bcontrols\u0018\u0004 \u0003(\u000b22.bidmachine.protobuf.Rendering.Phase.ViewComponent\u0012E\n\u0007methods\u0018\u0005 \u0003(\u000b24.bidmachine.protobuf.Rendering.Phase.MethodComponent\u0012:\n\u0006events\u0018\u0006 \u0003(\u000b2*.bidmachine.protobuf.Rendering.Phase.Event\u0012M\n\rcustom_params\u0018\u0007 \u0003(\u000b26.bidmachine.protobuf.Rendering.Phase.CustomParamsEntry\u001aÙ\u000e\n\rViewComponent\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012R\n\u0004type\u0018\u0002 \u0001(\u000e2D.bidmachine.protobuf.Rendering.Phase.ViewComponent.ViewComponentType\u0012\u000e\n\u0006source\u0018\u0003 \u0001(\t\u0012\u0013\n\u000bplaceholder\u0018\u0004 \u0001(\t\u0012[\n\rcustom_params\u0018\u0005 \u0003(\u000b2D.bidmachine.protobuf.Rendering.Phase.ViewComponent.CustomParamsEntry\u0012I\n\u0006layout\u0018\u0006 \u0001(\u000b29.bidmachine.protobuf.Rendering.Phase.ViewComponent.Layout\u0012Q\n\nappearance\u0018\u0007 \u0001(\u000b2=.bidmachine.protobuf.Rendering.Phase.ViewComponent.Appearance\u0012N\n\tmeasurers\u0018\b \u0003(\u000b2;.bidmachine.protobuf.Rendering.Phase.ViewComponent.Measurer\u001a3\n\u0011CustomParamsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\u001a¡\u0004\n\u0006Layout\u0012Y\n\u000bconstraints\u0018\u0001 \u0003(\u000b2D.bidmachine.protobuf.Rendering.Phase.ViewComponent.Layout.Constraint\u001a»\u0003\n\nConstraint\u0012b\n\rsource_anchor\u0018\u0001 \u0001(\u000e2K.bidmachine.protobuf.Rendering.Phase.ViewComponent.Layout.Constraint.Anchor\u0012b\n\rtarget_anchor\u0018\u0002 \u0001(\u000e2K.bidmachine.protobuf.Rendering.Phase.ViewComponent.Layout.Constraint.Anchor\u0012\u000e\n\u0006target\u0018\u0003 \u0001(\t\u0012\r\n\u0005value\u0018\u0004 \u0001(\u0001\u0012\u0012\n\nmultiplier\u0018\u0005 \u0001(\u0001\"±\u0001\n\u0006Anchor\u0012\u0012\n\u000eANCHOR_INVALID\u0010\u0000\u0012\u000f\n\u000bANCHOR_LEFT\u0010\u0001\u0012\u0010\n\fANCHOR_RIGHT\u0010\u0002\u0012\u000e\n\nANCHOR_TOP\u0010\u0003\u0012\u0011\n\rANCHOR_BOTTOM\u0010\u0004\u0012\u0013\n\u000fANCHOR_CENTER_X\u0010\u0005\u0012\u0013\n\u000fANCHOR_CENTER_Y\u0010\u0006\u0012\u0010\n\fANCHOR_WIDTH\u0010\u0007\u0012\u0011\n\rANCHOR_HEIGHT\u0010\b\u001aÔ\u0001\n\nAppearance\u0012\u0012\n\nfont_style\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007visible\u0018\u0002 \u0001(\b\u0012\u000f\n\u0007opacity\u0018\u0003 \u0001(\u0001\u0012\u0010\n\boutlined\u0018\u0004 \u0001(\b\u0012\u0014\n\fstroke_width\u0018\u0005 \u0001(\u0001\u0012\u0014\n\fstroke_color\u0018\u0006 \u0001(\t\u0012\u0014\n\fshadow_color\u0018\u0007 \u0001(\t\u0012\u0018\n\u0010background_color\u0018\b \u0001(\t\u0012\u0011\n\tclickable\u0018\t \u0001(\b\u0012\u000f\n\u0007padding\u0018\n \u0001(\t\u001a¬\u0001\n\bMeasurer\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012_\n\nparameters\u0018\u0002 \u0003(\u000b2K.bidmachine.protobuf.Rendering.Phase.ViewComponent.Measurer.ParametersEntry\u001a1\n\u000fParametersEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\"\u0096\u0003\n\u0011ViewComponentType\u0012\u001f\n\u001bVIEW_COMPONENT_TYPE_INVALID\u0010\u0000\u0012\u001d\n\u0019VIEW_COMPONENT_TYPE_VIDEO\u0010\u0001\u0012\u001d\n\u0019VIEW_COMPONENT_TYPE_MRAID\u0010\u0002\u0012\u001d\n\u0019VIEW_COMPONENT_TYPE_IMAGE\u0010\u0003\u0012!\n\u001dVIEW_COMPONENT_TYPE_COUNTDOWN\u0010\u0004\u0012 \n\u001cVIEW_COMPONENT_TYPE_PROGRESS\u0010\u0005\u0012&\n\"VIEW_COMPONENT_TYPE_COUNTDOWN_TEXT\u0010\u0006\u0012\u001c\n\u0018VIEW_COMPONENT_TYPE_MUTE\u0010\u0007\u0012\u001e\n\u001aVIEW_COMPONENT_TYPE_UNMUTE\u0010\b\u0012\u001d\n\u0019VIEW_COMPONENT_TYPE_CROSS\u0010\t\u0012\u001c\n\u0018VIEW_COMPONENT_TYPE_SKIP\u0010\n\u0012\u001b\n\u0017VIEW_COMPONENT_TYPE_CTA\u0010\u000b\u001a\u001f\n\u000fMethodComponent\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u001aý\t\n\u0005Event\u0012B\n\u0004name\u0018\u0001 \u0001(\u000e24.bidmachine.protobuf.Rendering.Phase.Event.EventName\u0012\u000e\n\u0006source\u0018\u0002 \u0001(\t\u0012>\n\u0005tasks\u0018\u0003 \u0003(\u000b2/.bidmachine.protobuf.Rendering.Phase.Event.Task\u001aÞ\u0004\n\u0004Task\u0012F\n\u0004name\u0018\u0001 \u0001(\u000e28.bidmachine.protobuf.Rendering.Phase.Event.Task.TaskName\u0012\u000e\n\u0006target\u0018\u0002 \u0001(\t\u0012\r\n\u0005value\u0018\u0003 \u0001(\t\"î\u0003\n\bTaskName\u0012\u0015\n\u0011TASK_NAME_INVALID\u0010\u0000\u0012\u0013\n\u000fTASK_NAME_START\u0010\u0001\u0012\u0012\n\u000eTASK_NAME_MUTE\u0010\u0002\u0012\u0014\n\u0010TASK_NAME_UNMUTE\u0010\u0003\u0012\u0013\n\u000fTASK_NAME_TRACK\u0010\u0004\u0012\u0013\n\u000fTASK_NAME_CLOSE\u0010\u0005\u0012\u0012\n\u000eTASK_NAME_SKIP\u0010\u0006\u0012\u0012\n\u000eTASK_NAME_OPEN\u0010\u0007\u0012\u0012\n\u000eTASK_NAME_SHOW\u0010\b\u0012\u0012\n\u000eTASK_NAME_HIDE\u0010\t\u0012\u0016\n\u0012TASK_NAME_PROGRESS\u0010\n\u0012\u0016\n\u0012TASK_NAME_SCHEDULE\u0010\u000b\u0012\u001d\n\u0019TASK_NAME_LOCK_VISIBILITY\u0010\f\u0012\u001f\n\u001bTASK_NAME_UNLOCK_VISIBILITY\u0010\r\u0012\u001a\n\u0016TASK_NAME_SHOW_OVERLAY\u0010\u000e\u0012\u001a\n\u0016TASK_NAME_HIDE_OVERLAY\u0010\u000f\u0012\u0019\n\u0015TASK_NAME_NOTIFY_OPEN\u0010\u0010\u0012\u001c\n\u0018TASK_NAME_SIMULATE_CLICK\u0010\u0011\u0012\u001b\n\u0017TASK_NAME_PRIVACY_SHEET\u0010\u0012\u0012\u0014\n\u0010TASK_NAME_REPEAT\u0010\u0013\"þ\u0003\n\tEventName\u0012\u0016\n\u0012EVENT_NAME_INVALID\u0010\u0000\u0012\u001c\n\u0018EVENT_NAME_ON_IMPRESSION\u0010\u0001\u0012\u0017\n\u0013EVENT_NAME_ON_CLICK\u0010\u0002\u0012\u001a\n\u0016EVENT_NAME_ON_PROGRESS\u0010\u0003\u0012\u001a\n\u0016EVENT_NAME_ON_NAVIGATE\u0010\u0004\u0012\u0016\n\u0012EVENT_NAME_ON_MUTE\u0010\u0005\u0012\u0018\n\u0014EVENT_NAME_ON_UNMUTE\u0010\u0006\u0012\u0017\n\u0013EVENT_NAME_ON_PAUSE\u0010\u0007\u0012\u0018\n\u0014EVENT_NAME_ON_RESUME\u0010\b\u0012\u0016\n\u0012EVENT_NAME_ON_SKIP\u0010\t\u0012\u0017\n\u0013EVENT_NAME_ON_CLOSE\u0010\n\u0012\u0017\n\u0013EVENT_NAME_ON_START\u0010\u000b\u0012 \n\u001cEVENT_NAME_ON_FIRST_QUARTILE\u0010\f\u0012\u001a\n\u0016EVENT_NAME_ON_MIDPOINT\u0010\r\u0012 \n\u001cEVENT_NAME_ON_THIRD_QUARTILE\u0010\u000e\u0012\u001a\n\u0016EVENT_NAME_ON_COMPLETE\u0010\u000f\u0012\"\n\u001eEVENT_NAME_ON_USE_CUSTOM_CLOSE\u0010\u0010\u0012\u001b\n\u0017EVENT_NAME_ON_SCHEDULED\u0010\u0011\u001a3\n\u0011CustomParamsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\u001a3\n\u0011CustomParamsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\u001aí\u0006\n\u0014SKStoreConfiguration\u0012-\n\u0007version\u0018\u0001 \u0001(\u000b2\u001c.google.protobuf.StringValue\u0012:\n\u0014adnetwork_identifier\u0018\u0002 \u0001(\u000b2\u001c.google.protobuf.StringValue\u00127\n\u0011source_identifier\u0018\u0003 \u0001(\u000b2\u001c.google.protobuf.StringValue\u0012;\n\u0015adcampaign_identifier\u0018\u0004 \u0001(\u000b2\u001c.google.protobuf.StringValue\u0012I\n#advertised_appstore_item_identifier\u0018\u0005 \u0001(\u000b2\u001c.google.protobuf.StringValue\u00125\n\u000fproduct_page_id\u0018\u0006 \u0001(\u000b2\u001c.google.protobuf.StringValue\u0012P\n\nfidelities\u0018\u0007 \u0003(\u000b2<.bidmachine.protobuf.Rendering.SKStoreConfiguration.Fidelity\u0012+\n\u0005nonce\u0018\b \u0001(\u000b2\u001c.google.protobuf.StringValue\u0012E\n\u001fsource_appstore_item_identifier\u0018\t \u0001(\u000b2\u001c.google.protobuf.StringValue\u0012/\n\ttimestamp\u0018\n \u0001(\u000b2\u001c.google.protobuf.StringValue\u0012/\n\tsignature\u0018\u000b \u0001(\u000b2\u001c.google.protobuf.StringValue\u001aÉ\u0001\n\bFidelity\u0012.\n\bfidelity\u0018\u0001 \u0001(\u000b2\u001c.google.protobuf.StringValue\u0012/\n\tsignature\u0018\u0002 \u0001(\u000b2\u001c.google.protobuf.StringValue\u0012+\n\u0005nonce\u0018\u0003 \u0001(\u000b2\u001c.google.protobuf.StringValue\u0012/\n\ttimestamp\u0018\u0004 \u0001(\u000b2\u001c.google.protobuf.StringValue\u001a\u009a\u0001\n\u0014ProductConfiguration\u0012;\n\u0017allow_storekit_subclass\u0018\u0001 \u0001(\u000b2\u001a.google.protobuf.BoolValue\u0012E\n!should_remove_store_after_present\u0018\u0002 \u0001(\u000b2\u001a.google.protobuf.BoolValue\"s\n\u000bOrientation\u0012\u0017\n\u0013ORIENTATION_INVALID\u0010\u0000\u0012\u0018\n\u0014ORIENTATION_PORTRAIT\u0010\u0001\u0012\u0019\n\u0015ORIENTATION_LANDSCAPE\u0010\u0002\u0012\u0016\n\u0012ORIENTATION_SYSTEM\u0010\u0003\"v\n\tCacheType\u0012\u0016\n\u0012CACHE_TYPE_INVALID\u0010\u0000\u0012\u0018\n\u0014CACHE_TYPE_FULL_LOAD\u0010\u0001\u0012\u001b\n\u0017CACHE_TYPE_PARTIAL_LOAD\u0010\u0002\u0012\u001a\n\u0016CACHE_TYPE_STREAM_LOAD\u0010\u0003B:\n io.bidmachine.protobuf.renderingB\u000eRenderingProtoP\u0001¢\u0002\u0003BDMb\u0006proto3"}, new Descriptors.FileDescriptor[]{WrappersProto.getDescriptor()});
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_CustomParamsEntry_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_CustomParamsEntry_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_Phase_CustomParamsEntry_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_Phase_CustomParamsEntry_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_Phase_Event_Task_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_Phase_Event_Task_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_Phase_Event_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_Phase_Event_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_Phase_MethodComponent_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_Phase_MethodComponent_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Appearance_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Appearance_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_CustomParamsEntry_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_CustomParamsEntry_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_Constraint_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_Constraint_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Measurer_ParametersEntry_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Measurer_ParametersEntry_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Measurer_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Measurer_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_Phase_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_Phase_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_ProductConfiguration_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_ProductConfiguration_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_Fidelity_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_Fidelity_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_bidmachine_protobuf_Rendering_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_bidmachine_protobuf_Rendering_fieldAccessorTable;

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private RenderingProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_bidmachine_protobuf_Rendering_descriptor = descriptor2;
        internal_static_bidmachine_protobuf_Rendering_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{ExifInterface.TAG_ORIENTATION, "CacheType", "Phases", "CustomParams", "SkAdNetwork", "ProductConfiguration"});
        Descriptors.Descriptor descriptor3 = descriptor2.getNestedTypes().get(0);
        internal_static_bidmachine_protobuf_Rendering_Phase_descriptor = descriptor3;
        internal_static_bidmachine_protobuf_Rendering_Phase_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Sequence", "BackgroundColor", "Ads", "Controls", "Methods", "Events", "CustomParams"});
        Descriptors.Descriptor descriptor4 = descriptor3.getNestedTypes().get(0);
        internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_descriptor = descriptor4;
        internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Name", "Type", "Source", "Placeholder", "CustomParams", "Layout", "Appearance", "Measurers"});
        Descriptors.Descriptor descriptor5 = descriptor4.getNestedTypes().get(0);
        internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_CustomParamsEntry_descriptor = descriptor5;
        internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_CustomParamsEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor6 = descriptor4.getNestedTypes().get(1);
        internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_descriptor = descriptor6;
        internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor6, new String[]{Constraints.TAG});
        Descriptors.Descriptor descriptor7 = descriptor6.getNestedTypes().get(0);
        internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_Constraint_descriptor = descriptor7;
        internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Layout_Constraint_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor7, new String[]{"SourceAnchor", "TargetAnchor", "Target", "Value", "Multiplier"});
        Descriptors.Descriptor descriptor8 = descriptor4.getNestedTypes().get(2);
        internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Appearance_descriptor = descriptor8;
        internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Appearance_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor8, new String[]{"FontStyle", "Visible", "Opacity", "Outlined", "StrokeWidth", "StrokeColor", "ShadowColor", "BackgroundColor", "Clickable", "Padding"});
        Descriptors.Descriptor descriptor9 = descriptor4.getNestedTypes().get(3);
        internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Measurer_descriptor = descriptor9;
        internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Measurer_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor9, new String[]{"Name", "Parameters"});
        Descriptors.Descriptor descriptor10 = descriptor9.getNestedTypes().get(0);
        internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Measurer_ParametersEntry_descriptor = descriptor10;
        internal_static_bidmachine_protobuf_Rendering_Phase_ViewComponent_Measurer_ParametersEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor10, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor11 = descriptor3.getNestedTypes().get(1);
        internal_static_bidmachine_protobuf_Rendering_Phase_MethodComponent_descriptor = descriptor11;
        internal_static_bidmachine_protobuf_Rendering_Phase_MethodComponent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor11, new String[]{"Name"});
        Descriptors.Descriptor descriptor12 = descriptor3.getNestedTypes().get(2);
        internal_static_bidmachine_protobuf_Rendering_Phase_Event_descriptor = descriptor12;
        internal_static_bidmachine_protobuf_Rendering_Phase_Event_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor12, new String[]{"Name", "Source", "Tasks"});
        Descriptors.Descriptor descriptor13 = descriptor12.getNestedTypes().get(0);
        internal_static_bidmachine_protobuf_Rendering_Phase_Event_Task_descriptor = descriptor13;
        internal_static_bidmachine_protobuf_Rendering_Phase_Event_Task_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor13, new String[]{"Name", "Target", "Value"});
        Descriptors.Descriptor descriptor14 = descriptor3.getNestedTypes().get(3);
        internal_static_bidmachine_protobuf_Rendering_Phase_CustomParamsEntry_descriptor = descriptor14;
        internal_static_bidmachine_protobuf_Rendering_Phase_CustomParamsEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor14, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor15 = descriptor2.getNestedTypes().get(1);
        internal_static_bidmachine_protobuf_Rendering_CustomParamsEntry_descriptor = descriptor15;
        internal_static_bidmachine_protobuf_Rendering_CustomParamsEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor15, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor16 = descriptor2.getNestedTypes().get(2);
        internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_descriptor = descriptor16;
        internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor16, new String[]{"Version", "AdnetworkIdentifier", "SourceIdentifier", "AdcampaignIdentifier", "AdvertisedAppstoreItemIdentifier", "ProductPageId", "Fidelities", "Nonce", "SourceAppstoreItemIdentifier", RtspHeaders.TIMESTAMP, "Signature"});
        Descriptors.Descriptor descriptor17 = descriptor16.getNestedTypes().get(0);
        internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_Fidelity_descriptor = descriptor17;
        internal_static_bidmachine_protobuf_Rendering_SKStoreConfiguration_Fidelity_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor17, new String[]{"Fidelity", "Signature", "Nonce", RtspHeaders.TIMESTAMP});
        Descriptors.Descriptor descriptor18 = descriptor2.getNestedTypes().get(3);
        internal_static_bidmachine_protobuf_Rendering_ProductConfiguration_descriptor = descriptor18;
        internal_static_bidmachine_protobuf_Rendering_ProductConfiguration_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor18, new String[]{"AllowStorekitSubclass", "ShouldRemoveStoreAfterPresent"});
        WrappersProto.getDescriptor();
    }
}
