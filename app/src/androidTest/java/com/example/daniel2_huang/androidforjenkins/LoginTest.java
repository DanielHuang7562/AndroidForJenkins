package com.example.daniel2_huang.androidforjenkins;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Daniel2_Huang on 2016/9/28.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginTest {

    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkLoginSuccess() throws InterruptedException{

        onView(withId(R.id.editText)).perform(typeText("daniel2_huang"),closeSoftKeyboard());
        onView(withId(R.id.editText2)).perform(typeText("11111111"),closeSoftKeyboard());
        onView(withId(R.id.confimButton)).perform(click());
        onView(withId(R.id.accountName)).check(matches(withText("Daniel2_Huang")));
    }

    @Test
    public void checkLoginFail() throws InterruptedException{

        onView(withId(R.id.editText)).perform(typeText("daniel2_huang"),closeSoftKeyboard());
        onView(withId(R.id.editText2)).perform(typeText("111111"),closeSoftKeyboard());
        onView(withId(R.id.confimButton)).perform(click());
        onView(withText("登入失敗")).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }

}
