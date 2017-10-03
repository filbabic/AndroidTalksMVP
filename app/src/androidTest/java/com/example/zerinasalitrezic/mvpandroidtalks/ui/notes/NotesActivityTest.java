package com.example.zerinasalitrezic.mvpandroidtalks.ui.notes;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.zerinasalitrezic.mvpandroidtalks.R;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.add_note.AddNoteActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Zerina Salitrezic on 08/09/2017.
 */

@RunWith(AndroidJUnit4.class)
public class NotesActivityTest {

    @Rule
    public ActivityTestRule<NotesActivity> activityTestRule =
            new ActivityTestRule<>(NotesActivity.class);

//    @Rule
//    public IntentsTestRule<NotesActivity> mActivityRule = new IntentsTestRule<>(NotesActivity.class);

    @Test
    public void clickAddShouldOpenAddNoteUi() throws Exception {
        onView(withId(R.id.add_button)).perform(click());
        onView(withId(R.id.title)).check(matches(isDisplayed()));
        onView(withId(R.id.description)).check(matches(isDisplayed()));
        onView(withId(R.id.save)).check(matches(isDisplayed()));
    }

    @Test
    public void clickAddShouldOpenFillAndSaveNoteAndCheckExistingNewNote() throws Exception {
        onView(withId(R.id.add_button)).perform(click());
        onView(withId(R.id.title)).perform(typeText("Some title"));
        onView(withId(R.id.description)).perform(typeText("Some description"), closeSoftKeyboard());
        onView(withId(R.id.save)).perform(click());
        onView(withText("Some title")).check(matches(isDisplayed()));
    }

    @Test
    public void someTest() throws Exception {
        onView(withId(R.id.add_button)).perform(click());
    }

    @Test
    public void triggerIntentTest() throws Exception {
        Intents.init();
        onView(withId(R.id.add_button)).perform(click());
        intended(hasComponent(AddNoteActivity.class.getName()));
        Intents.release();
    }

    @Test
    public void longClickShouldOpenDialogForDelete() throws Exception {
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(1, longClick()));
        onView(withText(R.string.delete_note_message)).check(matches(isDisplayed()));
    }
}