package com.futurteam.dbmusic.db.repositories;

import com.futurteam.dbmusic.db.domains.Distributor;
import com.futurteam.dbmusic.db.repositories.base.AbstractRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public final class DistributorsRepository extends AbstractRepository<Distributor> {

    @NotNull
    private static final String TABLE_NAME = "distributors";

    @NotNull
    @Language("SQL")
    private static final String CREATE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
            + "id NUMBER NOT NULL AUTO_INCREMENT,"
            + "name VARCHAR(256) NOT NULL,"
            + "founder VARCHAR(256) NOT NULL,"
            + "PRIMARY KEY (id))";

    @NotNull
    @Language("SQL")
    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (name, founder) VALUES(?,?)";

    public DistributorsRepository(@NotNull final Connection connection) {
        super(connection);
    }

    @Override
    public void add(@NotNull final Distributor distributor) {
        try (@NotNull val preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, distributor.getName());
            preparedStatement.setString(2, distributor.getFounder());
            preparedStatement.executeUpdate();

            @NotNull val resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                distributor.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            log.error("Cannot add distributor", e);
        }
    }

    @Nullable
    @Override
    protected Distributor create(@NotNull final ResultSet resultSet) {
        try {
            @NotNull val distributor = new Distributor();
            distributor.setId(resultSet.getInt("id"));
            distributor.setName(resultSet.getString("name"));
            distributor.setFounder(resultSet.getString("founder"));
            return distributor;
        } catch (SQLException e) {
            log.error("Cannot create distributor", e);
            return null;
        }
    }

    @NotNull
    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @NotNull
    @Override
    protected String getTableCreate() {
        return CREATE;
    }

}
