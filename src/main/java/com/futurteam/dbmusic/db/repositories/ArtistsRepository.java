package com.futurteam.dbmusic.db.repositories;

import com.futurteam.dbmusic.db.domains.Artist;
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
public final class ArtistsRepository extends AbstractRepository<Artist> {

    @NotNull
    private static final String TABLE_NAME = "artists";

    @NotNull
    @Language("SQL")
    private static final String CREATE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
            + "id NUMBER NOT NULL AUTO_INCREMENT,"
            + "name VARCHAR(256) NOT NULL,"
            + "genre VARCHAR(256) NOT NULL,"
            + "foundation_date DATE NOT NULL,"
            + "country VARCHAR(256) NOT NULL,"
            + "label VARCHAR(256) NOT NULL,"
            + "PRIMARY KEY (id))";

    @NotNull
    @Language("SQL")
    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (name, genre, foundation_date, country, label) VALUES(?,?,?,?,?)";

    public ArtistsRepository(@NotNull final Connection connection) {
        super(connection);
    }

    @Override
    public void add(@NotNull final Artist artist) {
        try (@NotNull val preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, artist.getName());
            preparedStatement.setString(2, artist.getGenre());
            preparedStatement.setDate(3, artist.getFoundationDate());
            preparedStatement.setString(4, artist.getCountry());
            preparedStatement.setString(5, artist.getLabel());
            preparedStatement.executeUpdate();

            @NotNull val resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                artist.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            log.error("Cannot add artist", e);
        }
    }

    @Nullable
    @Override
    protected Artist create(@NotNull final ResultSet resultSet) {
        try {
            @NotNull val artist = new Artist();
            artist.setId(resultSet.getInt("id"));
            artist.setName(resultSet.getString("name"));
            artist.setGenre(resultSet.getString("genre"));
            artist.setFoundationDate(resultSet.getDate("foundation_date"));
            artist.setCountry(resultSet.getString("country"));
            artist.setLabel(resultSet.getString("label"));
            return artist;
        } catch (SQLException e) {
            log.error("Cannot create artist", e);
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
