package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Parcel;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import com.udacity.gradle.builditbigger.EndpointsAsyncTaskCallBack;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 * Credits to the solution of exercise 4.10 from Udacity's Gradle Course.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class ApplicationTest {



    @Before
    public void createLogHistory() {

    }

    @MediumTest
    public void testVerifyEchoResponse() {
        EndpointsAsyncTask asyncTaskCompat = new EndpointsAsyncTask(new EndpointsAsyncTaskCallBack () {
            @Override
            public void onTaskSuccess(String result) {

                    assertNotNull("It is null!", result);
                    assertNotSame("It's empty!", "", result);

            }
        });

        asyncTaskCompat.execute();



    }

}



