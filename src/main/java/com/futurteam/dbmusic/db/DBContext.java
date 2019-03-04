package com.futurteam.dbmusic.db;

import com.futurteam.dbmusic.db.repositories.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

public final class DBContext implements AutoCloseable {

    @NotNull
    private static final String DRIVER = "org.h2.Driver";

    @NotNull
    private static final String DB_URL = "jdbc:h2:file:./dbmusic";

    @NotNull
    private final Connection connection;

    @Nullable
    private AlbumsRepository albumsRepository;
    @Nullable
    private ArtistsRepository artistsRepository;
    @Nullable
    private DistributorsRepository distributorsRepository;
    @Nullable
    private PartnersRepository partnersRepository;
    @Nullable
    private SongsRepository songsRepository;

    public DBContext(@NotNull final String username, @NotNull final String password) throws Throwable {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        Class.forName(DRIVER);

        connection = DriverManager.getConnection(DB_URL);
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    @NotNull
    public AlbumsRepository getAlbumsRepository() {
        if (albumsRepository == null) {
            albumsRepository = new AlbumsRepository(connection);
            albumsRepository.createTable();
        }

        return albumsRepository;
    }

    @NotNull
    public ArtistsRepository getArtistsRepository() {
        if (artistsRepository == null) {
            artistsRepository = new ArtistsRepository(connection);
            artistsRepository.createTable();
        }

        return artistsRepository;
    }

    @NotNull
    public DistributorsRepository getDistributorsRepository() {
        if (distributorsRepository == null) {
            distributorsRepository = new DistributorsRepository(connection);
            distributorsRepository.createTable();
        }

        return distributorsRepository;
    }

    @NotNull
    public PartnersRepository getPartnersRepository() {
        if (partnersRepository == null) {
            partnersRepository = new PartnersRepository(connection);
            partnersRepository.createTable();
        }

        return partnersRepository;
    }

    @NotNull
    public SongsRepository getSongsRepository() {
        if (songsRepository == null) {
            songsRepository = new SongsRepository(connection);
            songsRepository.createTable();
        }

        return songsRepository;
    }
}
