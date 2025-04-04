package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.ReadOnlyMedLogger;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * Manages storage of MedLogger data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private MedLoggerStorage medLoggerStorage;
    private UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code MedLoggerStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(MedLoggerStorage medLoggerStorage, UserPrefsStorage userPrefsStorage) {
        this.medLoggerStorage = medLoggerStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataLoadingException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ MedLogger methods ==============================

    @Override
    public Path getMedLoggerFilePath() {
        return medLoggerStorage.getMedLoggerFilePath();
    }

    @Override
    public Optional<ReadOnlyMedLogger> readMedLogger() throws DataLoadingException {
        return readMedLogger(medLoggerStorage.getMedLoggerFilePath());
    }

    @Override
    public Optional<ReadOnlyMedLogger> readMedLogger(Path filePath) throws DataLoadingException {
        logger.fine("Attempting to read data from file: " + filePath);
        return medLoggerStorage.readMedLogger(filePath);
    }

    @Override
    public void saveMedLogger(ReadOnlyMedLogger medLogger) throws IOException {
        saveMedLogger(medLogger, medLoggerStorage.getMedLoggerFilePath());
    }

    @Override
    public void saveMedLogger(ReadOnlyMedLogger medLogger, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        medLoggerStorage.saveMedLogger(medLogger, filePath);
    }

}
