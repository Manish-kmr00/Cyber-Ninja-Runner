package io.bidmachine.protobuf.sdk;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface MonitorOrBuilder extends MessageOrBuilder {
    String getName();

    ByteString getNameBytes();

    Monitor.Record getRecords(int i);

    int getRecordsCount();

    List<Monitor.Record> getRecordsList();

    Monitor.RecordOrBuilder getRecordsOrBuilder(int i);

    List<? extends Monitor.RecordOrBuilder> getRecordsOrBuilderList();
}
