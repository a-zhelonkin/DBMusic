package com.futurteam.dbmusic.db.repositories;

import com.futurteam.dbmusic.db.domains.Album;
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
public final class AlbumsRepository extends AbstractRepository<Album> {

    @NotNull
    private static final String TABLE_NAME = "albums";

    @NotNull
    @Language("SQL")
    private static final String CREATE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
            + "id NUMBER NOT NULL AUTO_INCREMENT,"
            + "genre VARCHAR(20) NOT NULL,"
            + "release_date DATE NOT NULL,"
            + "songs_count NUMBER NOT NULL,"
            + "PRIMARY KEY (id))";

    @NotNull
    @Language("SQL")
    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (genre, release_date, songs_count) VALUES(?,?,?)";

    public AlbumsRepository(@NotNull final Connection connection) {
        super(connection);
    }

    @Override
    public void add(@NotNull final Album album) {
        try (@NotNull val preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, album.getGenre());
            preparedStatement.setDate(2, album.getReleaseDate());
            preparedStatement.setInt(3, album.getSongsCount());
            preparedStatement.executeUpdate();

            @NotNull val resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                album.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            log.error("Cannot add album", e);
        }
    }

    @Nullable
    @Override
    protected Album create(@NotNull final ResultSet resultSet) {
        try {
            @NotNull val album = new Album();
            album.setId(resultSet.getInt("id"));
            album.setName(resultSet.getString("genre"));
            album.setGenre(resultSet.getString("genre"));
            album.setReleaseDate(resultSet.getDate("foundation_date"));
            album.setSongsCount(resultSet.getInt("country"));
            return album;
        } catch (SQLException e) {
            log.error("Cannot create album", e);
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
