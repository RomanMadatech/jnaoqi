package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;
import java.util.List;
import java.util.Map;
import com.aldebaran.qimessaging.*;

import java.util.List;

/**
 * Created by erwan and emile on 01/05/2014.
 */
public class ALEngagementZones extends ALModule {

    public ALEngagementZones(Session session) {
        super(session);
    }

    /**
    * Get the first distance used for the delimitation of the engagement zones (nearest limit)
    * 
    * @return Current first distance (in meters) used for delimitation (nearest limit)
    */
    public Float getFirstLimitDistance() throws CallError, InterruptedException {
        return (Float)service.call("getFirstLimitDistance").get();
    }

    /**
    * Gets extractor running status
    * 
    * @return True if the extractor is currently processing images, False if not
    */
    public Boolean isProcessing() throws CallError, InterruptedException {
        return (Boolean)service.call("isProcessing").get();
    }

    /**
    * Get the angle used for the delimitation of the engagement zones
    * 
    * @return Current angle used for delimitation
    */
    public Float getLimitAngle() throws CallError, InterruptedException {
        return (Float)service.call("getLimitAngle").get();
    }

    /**
    * Set the first distance used for the delimitation of the engagement zones (nearest limit)
    * 
    * @param distance  New first distance (in meters) for delimitation (nearest limit), it should be positive and smaller than the second distance
    */
    public void setFirstLimitDistance(Float distance) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setFirstLimitDistance", distance);
        else
            service.call("setFirstLimitDistance", distance).get();
    }

    /**
    * Set the second distance used for the delimitation of the engagement zones (furthest limit)
    * 
    * @param distance  New second distance (in meters) for delimitation (furthest limit), it should be positive and bigger than the first distance
    */
    public void setSecondLimitDistance(Float distance) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setSecondLimitDistance", distance);
        else
            service.call("setSecondLimitDistance", distance).get();
    }

    /**
    * Get the second distance used for the delimitation of the engagement zones (furthest limit)
    * 
    * @return Current second distance (in meters) used for delimitation (furthest limit)
    */
    public Float getSecondLimitDistance() throws CallError, InterruptedException {
        return (Float)service.call("getSecondLimitDistance").get();
    }

    /**
    * Set the angle used for the delimitation of the engagement zones
    * 
    * @param angle  New angle (in degrees) for delimitation, it should be below 180
    */
    public void setLimitAngle(Float angle) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setLimitAngle", angle);
        else
            service.call("setLimitAngle", angle).get();
    }

    /**
    * Computes the engagement zone in which an object is from its position in FRAME_ROBOT
    * 
    * @param x  X coordinate of the object in FRAME_ROBOT
    * @param y  Y coordinate of the object in FRAME_ROBOT
    * @param z  Z coordinate of the object in FRAME_ROBOT
    * @return Engagement zone of the object
    */
    public Integer computeEngagementZone(Float x, Float y, Float z) throws CallError, InterruptedException {
        return (Integer)service.call("computeEngagementZone", x, y, z).get();
    }

    /**
    * Computes the engagement zone in which an object is from its anglular position in the camera image, its distance from the robot, and the position of the camera in FRAME_ROBOT
    * 
    * @param xAngle  X angular coordinate of the object in the image
    * @param yAngle  Y angular coordinate of the object in the image
    * @param distance  distance of the object from the robot
    * @param cameraPositionRobot  camera position in FRAME_ROBOT
    * @return Engagement zone of the object
    */
    public Integer computeEngagementZone(Float xAngle, Float yAngle, Float distance, java.lang.Object cameraPositionRobot) throws CallError, InterruptedException {
        return (Integer)service.call("computeEngagementZone", xAngle, yAngle, distance, cameraPositionRobot).get();
    }

    /**
    * 
    * 
    */
    public Boolean isStatsEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isStatsEnabled").get();
    }

    /**
    * 
    * 
    */
    public void clearStats() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("clearStats");
        else
            service.call("clearStats").get();
    }

    /**
    * 
    * 
    */
    public Boolean isTraceEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isTraceEnabled").get();
    }

    /**
    * Exits and unregisters the module.
    * 
    */
    public void exit() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
    * Returns the version of the module.
    * 
    * @return A string containing the version of the module.
    */
    public String version() throws CallError, InterruptedException {
        return (String)service.call("version").get();
    }

    /**
    * Just a ping. Always returns true
    * 
    * @return returns true
    */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean)service.call("ping").get();
    }

    /**
    * Retrieves the module's method list.
    * 
    * @return An array of method names.
    */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>)service.call("getMethodList").get();
    }

    /**
    * Retrieves a method's description.
    * 
    * @param methodName  The name of the method.
    * @return A structure containing the method's description.
    */
    public java.lang.Object getMethodHelp(String methodName) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getMethodHelp", methodName).get();
    }

    /**
    * Retrieves the module's description.
    * 
    * @return A structure describing the module.
    */
    public java.lang.Object getModuleHelp() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getModuleHelp").get();
    }

    /**
    * Wait for the end of a long running method that was called using 'post'
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @param timeoutPeriod  The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
    * @return True if the timeout period terminated. False if the method returned.
    */
    public Boolean wait(Integer id, Integer timeoutPeriod) throws CallError, InterruptedException {
        return (Boolean)service.call("wait", id, timeoutPeriod).get();
    }

    /**
    * Returns true if the method is currently running.
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return True if the method is currently running
    */
    public Boolean isRunning(Integer id) throws CallError, InterruptedException {
        return (Boolean)service.call("isRunning", id).get();
    }

    /**
    * returns true if the method is currently running
    * 
    * @param id  the ID of the method to wait for
    */
    public void stop(Integer id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stop", id);
        else
            service.call("stop", id).get();
    }

    /**
    * Gets the name of the parent broker.
    * 
    * @return The name of the parent broker.
    */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String)service.call("getBrokerName").get();
    }

    /**
    * Gets the method usage string. This summarises how to use the method.
    * 
    * @param name  The name of the method.
    * @return A string that summarises the usage of the method.
    */
    public String getUsage(String name) throws CallError, InterruptedException {
        return (String)service.call("getUsage", name).get();
    }

    /**
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    * @param period  Refresh period (in milliseconds) if relevant.
    * @param precision  Precision of the extractor if relevant.
    */
    public void subscribe(String name, Integer period, Float precision) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("subscribe", name, period, precision);
        else
            service.call("subscribe", name, period, precision).get();
    }

    /**
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    */
    public void subscribe(String name) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("subscribe", name);
        else
            service.call("subscribe", name).get();
    }

    /**
    * Unsubscribes from the extractor.
    * 
    * @param name  Name of the module which had subscribed.
    */
    public void unsubscribe(String name) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("unsubscribe", name);
        else
            service.call("unsubscribe", name).get();
    }

    /**
    * Updates the period if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param period  Refresh period (in milliseconds).
    */
    public void updatePeriod(String name, Integer period) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("updatePeriod", name, period);
        else
            service.call("updatePeriod", name, period).get();
    }

    /**
    * Updates the precision if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param precision  Precision of the extractor.
    */
    public void updatePrecision(String name, Float precision) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("updatePrecision", name, precision);
        else
            service.call("updatePrecision", name, precision).get();
    }

    /**
    * Gets the current period.
    * 
    * @return Refresh period (in milliseconds).
    */
    public Integer getCurrentPeriod() throws CallError, InterruptedException {
        return (Integer)service.call("getCurrentPeriod").get();
    }

    /**
    * Gets the current precision.
    * 
    * @return Precision of the extractor.
    */
    public Float getCurrentPrecision() throws CallError, InterruptedException {
        return (Float)service.call("getCurrentPrecision").get();
    }

    /**
    * Gets the period for a specific subscription.
    * 
    * @param name  Name of the module which has subscribed.
    * @return Refresh period (in milliseconds).
    */
    public Integer getMyPeriod(String name) throws CallError, InterruptedException {
        return (Integer)service.call("getMyPeriod", name).get();
    }

    /**
    * Gets the precision for a specific subscription.
    * 
    * @param name  name of the module which has subscribed
    * @return precision of the extractor
    */
    public Float getMyPrecision(String name) throws CallError, InterruptedException {
        return (Float)service.call("getMyPrecision", name).get();
    }

    /**
    * Gets the parameters given by the module.
    * 
    * @return Array of names and parameters of all subscribers.
    */
    public java.lang.Object getSubscribersInfo() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getSubscribersInfo").get();
    }

    /**
    * Get the list of values updated in ALMemory.
    * 
    * @return Array of values updated by this extractor in ALMemory
    */
    public List<String> getOutputNames() throws CallError, InterruptedException {
        return (List<String>)service.call("getOutputNames").get();
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public List<String> getEventList() throws CallError, InterruptedException {
        return (List<String>)service.call("getEventList").get();
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public List<String> getMemoryKeyList() throws CallError, InterruptedException {
        return (List<String>)service.call("getMemoryKeyList").get();
    }

    /**
    * Gets extractor pause status
    * 
    * @return True if the extractor is paused, False if not
    */
    public Boolean isPaused() throws CallError, InterruptedException {
        return (Boolean)service.call("isPaused").get();
    }

    /**
    * Changes the pause status of the extractor
    * 
    * @param status  New pause satus
    */
    public void pause(Boolean status) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("pause", status);
        else
            service.call("pause", status).get();
    }

}
    