package com.futurteam.dbmusic.db.repositories.base;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractRepository<TEntity> {

    @NotNull
    @Language("SQL")
    private static final String SQL_GET_ALL_PATTERN = "select * from %s order by id";
    @NotNull
    @Language("SQL")
    private static final String SQL_GET_BY_ID_PATTERN = "select * from %s where id = %d";
    @NotNull
    @Language("SQL")
    private static final String SQL_DELETE_BY_ID_PATTERN = "delete from %s where id = %d";

    @NotNull
    protected final Connection connection;

    public abstract void add(@NotNull final TEntity entity);

    @Nullable
    protected abstract TEntity create(@NotNull final ResultSet resultSet);

    @NotNull
    protected abstract String getTableName();

    @NotNull
    protected abstract String getTableCreate();

    public final void createTable() {
        try (@NotNull val preparedStatement = connection.prepareStatement(getTableCreate())) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error("Cannot create songs table", e);
        }
    }

    @NotNull
    public Collection<TEntity> get() {
        @NotNull val sql = String.format(SQL_GET_ALL_PATTERN, getTableName());
        @NotNull val list = new ArrayList<TEntity>();

        try (@NotNull val statement = connection.createStatement();
             @NotNull val resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                @NotNull val e = create(resultSet);
                if (e == null) {
                    continue;
                }

                list.add(e);
            }
        } catch (SQLException e) {
            log.error("Cannot get entities", e);
        }

        return list;
    }

    @Nullable
    public TEntity get(final int id) {
        @NotNull val sql = String.format(SQL_GET_BY_ID_PATTERN, getTableName(), id);

        try (@NotNull val statement = connection.createStatement();
             @NotNull val resultSet = statement.executeQuery(sql)) {

            if (resultSet.next()) {
                return create(resultSet);
            }
        } catch (SQLException e) {
            log.error("Cannot get entity", e);
        }

        return null;
    }

    public void remove(final int id) {
        @NotNull val sql = String.format(SQL_DELETE_BY_ID_PATTERN, getTableName(), id);

        try (@NotNull val statement = connection.createStatement()) {
            statement.executeQuery(sql);
        } catch (SQLException e) {
            log.error("Cannot get entity", e);
        }
    }

}
