package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.person.Person;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' Med Logger file path.
     */
    Path getMedLoggerFilePath();

    /**
     * Sets the user prefs' Med Logger file path.
     */
    void setMedLoggerFilePath(Path medLoggerFilePath);

    /**
     * Replaces Med Logger data with the data in {@code medLogger}.
     */
    void setMedLogger(ReadOnlyMedLogger medLogger);

    /** Returns the MedLogger */
    ReadOnlyMedLogger getMedLogger();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the Med Logger.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the Med Logger.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the Med Logger.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the Med Logger.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the Med Logger.
     */
    void setPerson(Person target, Person editedPerson);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    void updateSubFilteredPersonList(int n);
    int size();
}
