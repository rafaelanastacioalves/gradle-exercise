package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 * Credits to the solution of exercise 4.10 from Udacity's Gradle Course.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class ApplicationTest {


    private final String LOG_TAG = getClass().getCanonicalName();

    @Test
    public void testVerifyAsyncResponse() {
        EndpointsAsyncTask asyncTaskCompat = new EndpointsAsyncTask(new EndpointsAsyncTaskCallBack () {
            @Override
            public void onTaskSuccess(String result) {

                    assertNotNull("It is null!", result);
                    assertNotSame("It's empty!", "", result);
                Log.i(LOG_TAG,"Checked via interface. The result was: " + result);

            }
        });

        asyncTaskCompat.execute();


    }

}



