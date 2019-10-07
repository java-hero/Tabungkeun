package org.d3ifcool.tabungkeun;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class TambahPengeluaranActivityTest {
    @Rule
    public ActivityTestRule<TambahPengeluaranActivity> mTambahPengeluaranActivity = new ActivityTestRule<>(TambahPengeluaranActivity.class);

    @Test
    public void TestPengeluaran (){
        Espresso.onView(withId(R.id.etNamaPengeluaran)).perform(typeText("danusan pedro"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.etJumlahPengeluaran)).perform(typeText("10000"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.btnTambahPengeluaran));
    }

}