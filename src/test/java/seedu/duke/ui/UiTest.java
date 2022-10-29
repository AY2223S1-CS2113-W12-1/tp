package seedu.duke.ui;

import org.junit.jupiter.api.Test;
import seedu.duke.user.UserModuleMapping;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UiTest {
    @Test
    public void testGreeting() {
        String expectedGreeting = "                        _____ ______ _____  \n"
                + "                       / ____|  ____|  __ \\ \n"
                + "   ___  __ _ ___ _   _| (___ | |__  | |__) |\n"
                + "  / _ \\/ _` / __| | | |\\___ \\|  __| |  ___/ \n"
                + " |  __/ (_| \\__ \\ |_| |____) | |____| |     \n"
                + "  \\___|\\__,_|___/\\__, |_____/|______|_|     \n"
                + "                  __/ |                     \n"
                + "                 |___/                      \n"
                + "Hello! Welcome to easySEP, your personal companion for planning your student exchange :-)\n"
                + "How may I help you today?\n"
                + "____________________________________________________________________________\n";
        assertEquals(expectedGreeting, Ui.greetUser());
    }

    @Test
    public void testGoodbye() {
        String expectedGoodbye = "____________________________________________________________________________\n"
                + "Goodbye. Hope to see you again soon!\n"
                + "____________________________________________________________________________\n";
        assertEquals(expectedGoodbye, Ui.sayByeToUser());
    }

    @Test
    public void testGetUserInputWithWhiteSpaces() {
        String input = "   /create    ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("/create", Ui.getUserInput());
    }

    @Test
    public void testPrintCommands() {
        String expected = "____________________________________________________________________________\n"
                + "     " + "COMMAND   " + "FORMAT                                                " + "PURPOSE\n"
                + "     " + "--------  " + "--------------------------------------                " + "-------\n"
                + "     " + "add       " + "/add u/{UNIVERSITY_NAME} m/{MODULE_CODE}              "
                + "Adds input Partner University module code to input university list\n"
                + "     " + "add       " + "/add u/{UNIVERSITY_NAME} m/{MODULE_CODE}              "
                + "Adds a lesson for the input module code to the timetable for the input\n"
                + "     " + "          " + "d/{DAY_OF_THE_WEEK} st/{START_TIME} en/{END_TIME}\n"
                + "     " + "create    " + "/create u/UNIVERSITY_NAME_IN_UNDERSCORES              "
                + "Creates an empty module list for the input university\n"
                + "     " + "delete    " + "/delete u/{UNIVERSITY_NAME}                           "
                + "Deletes input university list\n"
                + "     " + "delete    " + "/delete u/{UNIVERSITY_NAME} m/{MODULE_CODE}           "
                + "Deletes input module from the university list\n"
                + "     " + "delete    " + "/delete u/{UNIVERSITY_NAME} m/{MODULE_CODE}           "
                + "Deletes input lesson from the university's timetable\n"
                + "     " + "          " + "d/{DAY_OF_THE_WEEK} st/{START_TIME} en/{END_TIME}\n"
                + "     " + "exit      " + "/exit                                                 "
                + "Terminates the program\n"
                + "     " + "favourite " + "/favourite add/{UNIVERSITY_NAME}                      "
                + "Adds a university list to the user's favourites\n"
                + "     " + "favourite " + "/favourite del/{UNIVERSITY_NAME}                      "
                + "Deletes a university list from the user's favourites\n"
                + "     " + "favourite " + "/favourite VIEW                                       "
                + "Displays the user's favourite university lists\n"
                + "     " + "help      " + "/help                                                 "
                + "Displays eligible user commands for the program\n"
                + "     " + "list      " + "/list MODULES                                         "
                + "Lists all existing university modules mappings that are approved in the format:\n"
                + "                                                                     "
                + "[Partner University Module Code] [Partner University Module Title] "
                + "[Partner University Module Credits] | [NUS Module Code] [NUS Module Title] "
                + "[NUS Module Credits] in NUS\n"
                + "     " + "list      " + "/list UNIVERSITIES                                    "
                + "Lists all universities with module mappings available in database\n"
                + "     " + "list      " + "/list m/{MODULE_CODE}                                 "
                + "Lists all module mappings for input NUS module code in database\n"
                + "     " + "list      " + "/list u/{UNIVERSITY_NAME}                             "
                + "Lists all module mappings offered by input university in database\n"
                + "     " + "view      " + "/view LISTS                                           "
                + "Displays all existing university lists that have been created by the user\n"
                + "     " + "view      " + "/view u/{UNIVERSITY_NAME}                             "
                + "Displays all the modules that have been added to the user's input university's list in the format:\n"
                + "                                                                     "
                + "[Home University Module Code] [Home University Module Title] | "
                + "[Partner University Module Code] [Partner University Module Title] | [Equivalent NUS Credits]\n"
                + "     " + "view      " + "/view TIMETABLES                                      "
                + "Displays all timetables for list of universities created by user\n"
                + "     " + "view      " + "/view DELETE_HISTORY                                  "
                + "Displays up to 5 most recent modules that the user has deleted\n\n"
                + "     " + "Note: Words in curly brackets are parameters that you should input as a user\n"
                + "     " + "Note: There should not be spaces in parameters, replace with underscore instead\n"
                + "____________________________________________________________________________\n";
        assertEquals(expected, Ui.printCommands());
    }

    @Test
    public void testPrintModule() {
        UserModuleMapping dummy = new UserModuleMapping("CPSC123", "Intro to AI",
                "CS3243", "Introduction to Artificial Intelligence", "4",
                "test", "test", "test");
        String expected = "NUS: " + "CS3243" + " " + "Introduction to Artificial Intelligence"
                + " | Partner University: " + "test " + "CPSC123" + " " + "Intro to AI"
                + " | Equivalent NUS Credits: " + "4 MCs";
        assertEquals(expected, Ui.printModule(dummy));
    }

    @Test
    public void testPrintModuleAddedAcknowledgement() {
        UserModuleMapping dummy = new UserModuleMapping("CPSC123", "Intro to AI",
                "CS3243", "Introduction to Artificial Intelligence", "4",
                "test", "test", "test");
        String expected = "____________________________________________________________________________\n"
                + "Success! You added:\n" + "NUS: " + "CS3243" + " "
                + "Introduction to Artificial Intelligence" + " | Partner University: " + "test " + "CPSC123" + " "
                + "Intro to AI" + " | Equivalent NUS Credits: " + "4 MCs"
                + "\n" + "____________________________________________________________________________\n";
        assertEquals(expected, Ui.printModuleAddedAcknowledgement(dummy));
    }

    @Test
    public void testPrintModuleUpdatedAcknowledgement() {
        UserModuleMapping dummy = new UserModuleMapping("CPSC123", "Intro to AI",
                "CS3243", "Introduction to Artificial Intelligence", "4",
                "test", "test", "test");
        dummy.setComment("A+ or nothing");
        String expected = "____________________________________________________________________________\n"
                + "Success! You updated:\n" + "NUS: " + "CS3243" + " "
                + "Introduction to Artificial Intelligence" + " | Partner University: " + "test " + "CPSC123" + " "
                + "Intro to AI" + " | Equivalent NUS Credits: " + "4 MCs" + "\n"
                + "With the following comment: " + dummy.getComment() + "\n"
                + "____________________________________________________________________________\n";
        assertEquals(expected, Ui.printModuleUpdatedAcknowledgement(dummy));

    }

    @Test
    public void testPrintModuleDeletedAcknowledgement() {
        UserModuleMapping dummy = new UserModuleMapping("CPSC123", "Intro to AI",
                "CS3243", "Introduction to Artificial Intelligence", "4",
                "test", "test", "test");
        String expected = "____________________________________________________________________________\n"
                + "Success! You deleted:\n" + "NUS: " + "CS3243" + " "
                + "Introduction to Artificial Intelligence" + " | Partner University: "
                + "test " + "CPSC123" + " " + "Intro to AI" + " | Equivalent NUS Credits: " + "4 MCs"
                + "\n" + "____________________________________________________________________________\n";
        assertEquals(expected, Ui.printModuleDeletedAcknowledgement(dummy));
    }

    @Test
    public void testPrintPuListCreatedAcknowledgement() {
        String expected = "____________________________________________________________________________\n"
                + "Success! You have created a new list for " + "Stanford University" + "\n"
                + "____________________________________________________________________________\n";
        assertEquals(expected, Ui.printPuListCreatedAcknowledgement("Stanford University"));
    }

    @Test
    public void testPrintPuListDeletedAcknowledgement() {
        String expected = "____________________________________________________________________________\n"
                + "Success! You deleted the list for " + "Stanford University" + "\n"
                + "____________________________________________________________________________\n";
        assertEquals(expected, Ui.printPuListDeletedAcknowledgement("Stanford University"));
    }

    @Test
    public void testPrintModulesInList() {
        ArrayList<UserModuleMapping> modules = new ArrayList<UserModuleMapping>();
        UserModuleMapping dummy1 = new UserModuleMapping("CPSC123", "Intro to AI",
                "CS3243", "Introduction to Artificial Intelligence", "4",
                "test", "test", "test");
        UserModuleMapping dummy2 = new UserModuleMapping("CPSC456", "ML",
                "CS3244", "Machine Learning", "4",
                "test", "test", "test");
        modules.add(dummy1);
        modules.add(dummy2);
        String expected = "____________________________________________________________________________\n" + "1. "
                + "NUS: " + "CS3243" + " " + "Introduction to Artificial Intelligence"
                + " | Partner University: " + "test " + "CPSC123" + " " + "Intro to AI"
                + " | Equivalent NUS Credits: " + "4 MCs"
                + "\n" + "2. " + "NUS: " + "CS3244" + " " + "Machine Learning"
                + " | Partner University: " + "test " + "CPSC456" + " " + "ML"
                + " | Equivalent NUS Credits: " + "4 MCs" + "\n"
                + "____________________________________________________________________________\n";
        assertEquals(expected, Ui.printModulesInUserList(modules));
    }
}
