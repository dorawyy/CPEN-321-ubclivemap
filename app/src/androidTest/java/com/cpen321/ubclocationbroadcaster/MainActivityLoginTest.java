package com.cpen321.ubclocationbroadcaster;

import androidx.test.espresso.intent.rule.IntentsTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.fail;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainActivityLoginTest {
    @Rule
    public IntentsTestRule<MainActivity> mActivityTestRule = new IntentsTestRule<MainActivity>(MainActivity.class);
    private String entered_username = "test_user1";
    private String entered_password = "password";
    private String wrong_password = "wrong_password";

    @Before
    public void setUp() throws Exception {
        //unused
    }

    /** SIGN IN TESTS (with account) **/

    /** testing sign in with wrong username and password, expecting to get an ERROR message **/
    @Test
    public void testSignInWithWrongPassword() throws Exception{
        onView(withId(R.id.username_button)).perform(typeText(entered_username));
        onView(withId(R.id.password_button)).perform(typeText(wrong_password));
        closeSoftKeyboard();
        onView(withId(R.id.sign_in_button)).perform(click());

        try {
            onView(withText("ERROR: Invalid password.")).inRoot(withDecorView(not(is(mActivityTestRule
                    .getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
        } catch(Exception e) {
            fail("Exception thrown.");
        }
    }

    /** testing if correct username/password leads to the corresponding intent, expecting to get a success message **/
    @Test
    public void testSignIn() {
        onView(withId(R.id.username_button)).perform(typeText(entered_username));
        onView(withId(R.id.password_button)).perform(typeText(entered_password));
        closeSoftKeyboard();
        onView(withId(R.id.sign_in_button)).perform(click());

        try {
            onView(withText("Login Succeeded!")).inRoot(withDecorView(not(is(mActivityTestRule
                    .getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception thrown.");
        }
    }

    @After
    public void tearDown() throws Exception {
        //unused
    }
}