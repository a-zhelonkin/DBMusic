package com.futurteam.dbmusic.db.repositories;

import com.futurteam.dbmusic.db.domains.Song;
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
public final class SongsRepository extends AbstractRepository<Song> {

    @NotNull
    private static final String TABLE_NAME = "songs";

    @NotNull
    @Language("SQL")
    private static final String CREATE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
            + "id NUMBER NOT NULL AUTO_INCREMENT,"
            + "name VARCHAR(256) NOT NULL,"
            + "genre VARCHAR(256) NOT NULL,"
            + "release_date DATE NOT NULL,"
            + "PRIMARY KEY (id))";

    @NotNull
    @Language("SQL")
    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (name, genre, release_date) VALUES(?,?,?)";

    public SongsRepository(@NotNull final Connection connection) {
        super(connection);
    }

    @Override
    public void add(@NotNull final Song song) {
        try (@NotNull val preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, song.getName());
            preparedStatement.setString(2, song.getGenre());
            preparedStatement.setDate(3, song.getReleaseDate());
            preparedStatement.executeUpdate();

            @NotNull val resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                song.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            log.error("Cannot add song", e);
        }
    }

    @Nullable
    @Override
    protected Song create(@NotNull final ResultSet resultSet) {
        try {
            @NotNull val song = new Song();
            song.setId(resultSet.getInt("id"));
            song.setName(resultSet.getString("name"));
            song.setGenre(resultSet.getString("genre"));
            song.setReleaseDate(resultSet.getDate("release_date"));
            return song;
        } catch (SQLException e) {
            log.error("Cannot create song", e);
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
