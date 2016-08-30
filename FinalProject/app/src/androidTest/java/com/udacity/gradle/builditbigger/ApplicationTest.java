package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.v4.util.Pair;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 * Credits to the solution of exercise 4.10 from Udacity's Gradle Course.
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mMainActivity;
    private Button mButton;
    private TextView mTextView;

    public ApplicationTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);
        mMainActivity = getActivity();

    }

    @MediumTest
    public void testVerifyEchoResponse() {
        EndpointsAsyncTask asyncTaskCompat = new EndpointsAsyncTask();
        asyncTaskCompat.execute(new Pair<Context, String>(mMainActivity, "whathever"));
        try {
            assertNotNull("It is null!", (String) asyncTaskCompat.get());
            assertNotSame("It's empty!", "", asyncTaskCompat.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



    }


}
