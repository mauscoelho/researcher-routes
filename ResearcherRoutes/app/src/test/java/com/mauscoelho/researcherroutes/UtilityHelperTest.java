package com.mauscoelho.researcherroutes;



import com.mauscoelho.researcherroutes.network.util.UtilityHelper;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;


@RunWith(RobolectricTestRunner.class)
public class UtilityHelperTest {

    UtilityHelper utilityHelper;

    @Before
    public void setup(){
        utilityHelper = new UtilityHelper();
    }

    @Test(expected = NullPointerException.class)
    public void getJsonByStopName_whenStopNameIsNull_returnsNullPointerException() {
        final String STOP_NAME_NULL = null;

        JSONObject jsonObject = utilityHelper.getJsonByStopName(STOP_NAME_NULL);

    }

    @Test
    public void getJsonByStopName_whenStopNameIsValid_returnsJsonObject() throws JSONException {
        final String FAILDED_TEST_MESSAGE = "JSONObject recovered should equal the expected JSONObject";
        final String STOP_NAME_VALID = "18";

        JSONObject expectedJSONObject = new JSONObject("{\n" +
                "\"params\": {\n" +
                "\"stopName\": \"%" + STOP_NAME_VALID + "%\"\n" +
                "}\n" +
                "}");

        JSONObject actualJSONObject = utilityHelper.getJsonByStopName(STOP_NAME_VALID);
        Assert.assertEquals(FAILDED_TEST_MESSAGE, expectedJSONObject.toString(), actualJSONObject.toString());
    }


    @Test
    public void getJsonObjectByRouteID_whenRouteIdIsValid_returnsJsonObject() throws JSONException {
        final String FAILDED_TEST_MESSAGE = "JSONObject recovered should equal the expected JSONObject";
        final int ROUTE_ID_VALID = 18;

        JSONObject expectedJSONObject = new JSONObject("{\n" +
                "\"params\": {\n" +
                "\"routeId\": " + ROUTE_ID_VALID + "\n" +
                "}\n" +
                "}");

        JSONObject actualJSONObject = utilityHelper.getJsonRouteId(ROUTE_ID_VALID);
        Assert.assertEquals(FAILDED_TEST_MESSAGE, expectedJSONObject.toString(), actualJSONObject.toString());
    }



}