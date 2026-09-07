package com.yandex.div.state.db;

import kotlin.Metadata;

/* JADX INFO: compiled from: DB.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/state/db/StateSchema;", "", "()V", "SQL_CREATE_INDICES_TABLE_QUERY", "", "SQL_CREATE_TABLE_QUERY", "SQL_DELETE_ALL_EXCEPT_CARD_ID_QUERY_TEMPLATE", "SQL_DELETE_ALL_MODIFIED_BEFORE_QUERY_TEMPLATE", "SQL_DELETE_ALL_QUERY", "SQL_DELETE_BY_CARD_ID_QUERY_TEMPLATE", "SQL_DELETE_CARD_ROOT_STATE_QUERY_TEMPLATE", "SQL_DROP_TABLE_QUERY", "SQL_GET_ROOT_STATE_ID_QUERY_TEMPLATE", "SQL_GET_STATES_QUERY_TEMPLATE", "SQL_UPSERT_QUERY_TEMPLATE", "div-states_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class StateSchema {
    public static final StateSchema INSTANCE = new StateSchema();
    public static final String SQL_CREATE_INDICES_TABLE_QUERY = "CREATE UNIQUE INDEX IF NOT EXISTS `index_div_card_states_card_id_path` ON `div_card_states` (`card_id`, `path`)";
    public static final String SQL_CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `div_card_states` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `card_id` TEXT NOT NULL, `path` TEXT NOT NULL, `state_id` TEXT NOT NULL, `modification_time` INTEGER NOT NULL)";
    public static final String SQL_DELETE_ALL_EXCEPT_CARD_ID_QUERY_TEMPLATE = "DELETE FROM div_card_states WHERE card_id NOT IN (%s)";
    public static final String SQL_DELETE_ALL_MODIFIED_BEFORE_QUERY_TEMPLATE = "DELETE FROM div_card_states WHERE modification_time < ?";
    public static final String SQL_DELETE_ALL_QUERY = "DELETE FROM div_card_states";
    public static final String SQL_DELETE_BY_CARD_ID_QUERY_TEMPLATE = "DELETE FROM div_card_states WHERE card_id=?";
    public static final String SQL_DELETE_CARD_ROOT_STATE_QUERY_TEMPLATE = "DELETE FROM div_card_states WHERE card_id=? AND path='/'";
    public static final String SQL_DROP_TABLE_QUERY = "DROP TABLE IF EXISTS div_card_states";
    public static final String SQL_GET_ROOT_STATE_ID_QUERY_TEMPLATE = "SELECT state_id FROM div_card_states WHERE card_id=? AND path='/'";
    public static final String SQL_GET_STATES_QUERY_TEMPLATE = "SELECT path, state_id FROM div_card_states WHERE card_id=?";
    public static final String SQL_UPSERT_QUERY_TEMPLATE = "INSERT OR REPLACE INTO `div_card_states` (`card_id`,`path`,`state_id`,`modification_time`) VALUES (?,?,?,?)";

    private StateSchema() {
    }
}
