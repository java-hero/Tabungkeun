package org.d3ifcool.tabungkeun;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {
    @Rule
    public ActivityTestRule<LoginActivity> mLogintest = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void LoginTest(){
        Espresso.onView(withId(R.id.et_username_login)).perform(typeText("thaliavero@gmail.com"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.et_password_login)).perform(typeText("12345"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.button_login)).perform(click());
    }
}