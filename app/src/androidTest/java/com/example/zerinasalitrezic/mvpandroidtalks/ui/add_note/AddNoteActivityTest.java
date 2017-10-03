package com.example.zerinasalitrezic.mvpandroidtalks.ui.add_note;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.zerinasalitrezic.mvpandroidtalks.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Zerina Salitrezic on 08/09/2017.
 */

@RunWith(AndroidJUnit4.class)
public class AddNoteActivityTest {

    @Rule
    public ActivityTestRule<AddNoteActivity> rule = new ActivityTestRule<>(AddNoteActivity.class);

    @Test
    public void checkAreViewsDisplayed() throws Exception {
        onView(withId(R.id.title)).check(matches(isDisplayed()));
        onView(withId(R.id.description)).check(matches(isDisplayed()));
        onView(withId(R.id.save)).check(matches(isDisplayed()));
    }

    @Test
    public void typeTextOnDescription() throws Exception {
        onView(withId(R.id.description)).perform(typeText("Some description")).check(matches(withText("Some description")));
    }

    @Test
    public void addForm() throws Exception {
        onView(withId(R.id.title)).perform(typeText("Some title"));
        onView(withId(R.id.description)).perform(typeText("Some description"));
        onView(withId(R.id.save)).perform(click());
    }
}