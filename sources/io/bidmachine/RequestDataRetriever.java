package io.bidmachine;

import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.adcom.ConnectionType;
import com.explorestack.protobuf.adcom.Context;
import io.bidmachine.protobuf.sdk.App;
import io.bidmachine.utils.ProtoUtils;

/* JADX INFO: loaded from: classes9.dex */
public class RequestDataRetriever {
    public static Context collectContext(android.content.Context context, BidMachineImpl bidMachineImpl, UserRestrictionParams userRestrictionParams, TargetingParams targetingParams, SessionAdParams sessionAdParams, ConnectionType connectionType, AdsType adsType) {
        Context.Builder builderNewBuilder = Context.newBuilder();
        Context.App.Builder builderNewBuilder2 = Context.App.newBuilder();
        Publisher publisher = bidMachineImpl.getPublisher();
        if (publisher != null) {
            publisher.build(builderNewBuilder2);
        }
        bidMachineImpl.getAppParams().build(context, builderNewBuilder2);
        targetingParams.build(builderNewBuilder2);
        App.Builder builderNewBuilder3 = App.newBuilder();
        targetingParams.fillAppExtension(builderNewBuilder3);
        builderNewBuilder3.setInstallTime(ProtoUtils.msToProtobufTimestamp(InstallInfoProvider.getInstallTimeMs()));
        builderNewBuilder3.setFirstLaunchTime(ProtoUtils.msToProtobufTimestamp(bidMachineImpl.obtainFirstLaunchTimeMs(context)));
        builderNewBuilder2.addExtProto(Any.pack(builderNewBuilder3.build()));
        builderNewBuilder.setApp(builderNewBuilder2);
        BlockedParams blockedParams = targetingParams.getBlockedParams();
        if (blockedParams != null) {
            Context.Restrictions.Builder builderNewBuilder4 = Context.Restrictions.newBuilder();
            blockedParams.build(builderNewBuilder4);
            builderNewBuilder.setRestrictions(builderNewBuilder4);
        }
        Context.User.Builder builderNewBuilder5 = Context.User.newBuilder();
        userRestrictionParams.build(builderNewBuilder5);
        if (userRestrictionParams.canSendUserInfo()) {
            targetingParams.build(builderNewBuilder5);
        }
        Struct.Builder builderNewBuilder6 = Struct.newBuilder();
        if (sessionAdParams != null) {
            sessionAdParams.fillUserExtension(builderNewBuilder6);
        }
        bidMachineImpl.getSessionParams().build(context, builderNewBuilder5, adsType);
        if (builderNewBuilder6.getFieldsCount() > 0) {
            builderNewBuilder5.setExt(builderNewBuilder6.build());
        }
        builderNewBuilder.setUser(builderNewBuilder5);
        Context.Regs.Builder builderNewBuilder7 = Context.Regs.newBuilder();
        userRestrictionParams.build(builderNewBuilder7);
        builderNewBuilder.setRegs(builderNewBuilder7);
        bidMachineImpl.getDeviceParams().build(context, builderNewBuilder, targetingParams, bidMachineImpl.getTargetingParams(), userRestrictionParams, connectionType);
        return builderNewBuilder.build();
    }
}
