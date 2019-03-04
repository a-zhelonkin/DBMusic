package com.futurteam.dbmusic.db.repositories;

import com.futurteam.dbmusic.db.domains.Partner;
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
public final class PartnersRepository extends AbstractRepository<Partner> {

    @NotNull
    private static final String TABLE_NAME = "partners";

    @NotNull
    @Language("SQL")
    private static final String CREATE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
            + "id NUMBER NOT NULL AUTO_INCREMENT,"
            + "name VARCHAR(256) NOT NULL,"
            + "price DOUBLE NOT NULL,"
            + "PRIMARY KEY (id))";

    @NotNull
    @Language("SQL")
    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (name, price) VALUES(?,?)";

    public PartnersRepository(@NotNull final Connection connection) {
        super(connection);
    }

    @Override
    public void add(@NotNull final Partner partner) {
        try (@NotNull val preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, partner.getName());
            preparedStatement.setDouble(2, partner.getPrice());
            preparedStatement.executeUpdate();

            @NotNull val resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                partner.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            log.error("Cannot add partner", e);
        }
    }

    @Nullable
    @Override
    protected Partner create(@NotNull final ResultSet resultSet) {
        try {
            @NotNull val partner = new Partner();
            partner.setId(resultSet.getInt("id"));
            partner.setName(resultSet.getString("name"));
            partner.setPrice(resultSet.getDouble("price"));
            return partner;
        } catch (SQLException e) {
            log.error("Cannot create partner", e);
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
