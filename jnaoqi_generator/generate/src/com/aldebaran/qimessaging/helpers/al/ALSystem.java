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
public class ALSystem extends ALModule {

    public ALSystem(Session session) {
        super(session);
    }

    /**
    * Set the robot status LED
    * 
    * @param state  state to set
    */
    public void _setStatusLed(Integer state) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setStatusLed", state);
        else
            service.call("_setStatusLed", state).get();
    }

    /**
    * List of the faulty boards
    * 
    * @return A vector with the name of the faulty boards
    */
    public List<String> _boardFirmwareUpdateError() throws CallError, InterruptedException {
        return (List<String>)service.call("_boardFirmwareUpdateError").get();
    }

    /**
    * Execute operations for safe naoqi stop
    * 
    */
    public void _prepareNaoqiStop() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_prepareNaoqiStop");
        else
            service.call("_prepareNaoqiStop").get();
    }

    /**
    * Load system notification and data
    * 
    */
    public void _initializeSystemNotification() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_initializeSystemNotification");
        else
            service.call("_initializeSystemNotification").get();
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
    * Display free disk space
    * 
    * @param all  Show all mount partions.
    * @return A vector with all partions' infos
    */
    public List<Tuple4<String, String, Long, Long>> diskFree(Boolean all) throws CallError, InterruptedException {
        return (List<Tuple4<String, String, Long, Long>>)service.call("diskFree", all).get();
    }

    /**
    * System hostname
    * 
    * @return name of the robot
    */
    public String robotName() throws CallError, InterruptedException {
        return (String)service.call("robotName").get();
    }

    /**
    * Set system hostname
    * 
    * @param name  name to use
    * @return whether the operation was successful
    */
    public Boolean setRobotName(String name) throws CallError, InterruptedException {
        return (Boolean)service.call("setRobotName", name).get();
    }

    /**
    * Robot icon
    * 
    * @return icon of the robot
    */
    public java.lang.Object robotIcon() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("robotIcon").get();
    }

    /**
    * Shutdown robot
    * 
    */
    public void shutdown() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("shutdown");
        else
            service.call("shutdown").get();
    }

    /**
    * Reboot robot
    * 
    */
    public void reboot() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("reboot");
        else
            service.call("reboot").get();
    }

    /**
    * Running system version
    * 
    * @return running system version
    */
    public String systemVersion() throws CallError, InterruptedException {
        return (String)service.call("systemVersion").get();
    }

    /**
    * Running system version
    * 
    * @return information about the system version
    */
    public Tuple3<String, String, String> systemInfo() throws CallError, InterruptedException {
        return (Tuple3<String, String, String>)service.call("systemInfo").get();
    }

    /**
    * Amount of available memory in heap
    * 
    * @return amount of available memory in heap
    */
    public Integer freeMemory() throws CallError, InterruptedException {
        return (Integer)service.call("freeMemory").get();
    }

    /**
    * Amount of total memory in heap
    * 
    * @return amount of total memory in heap
    */
    public Integer totalMemory() throws CallError, InterruptedException {
        return (Integer)service.call("totalMemory").get();
    }

    /**
    * Current timezone
    * 
    * @return current timezone
    */
    public String timezone() throws CallError, InterruptedException {
        return (String)service.call("timezone").get();
    }

    /**
    * Set current timezone
    * 
    * @param timezone  timezone to use
    * @return whether the operation was successful
    */
    public Boolean setTimezone(String timezone) throws CallError, InterruptedException {
        return (Boolean)service.call("setTimezone", timezone).get();
    }

    /**
    * Previous system version before software update (empty if this is not the 1st boot after a software update)
    * 
    * @return Previous system version before software update.
    */
    public String previousSystemVersion() throws CallError, InterruptedException {
        return (String)service.call("previousSystemVersion").get();
    }

    /**
    * Change the user password.
    * 
    * @param old password  The current password of the user.
    * @param new password  The new user password.
    */
    public void changePassword(String oldPassword, String newPassword) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("changePassword", oldPassword, newPassword);
        else
            service.call("changePassword", oldPassword, newPassword).get();
    }

    /**
    * Change the user password.
    * 
    * @param image  Local path to a valid image.
    * @param checksum  Local path to a md5 checksum file, or empty string for no verification
    */
    public void upgrade(String image, String checksum) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("upgrade", image, checksum);
        else
            service.call("upgrade", image, checksum).get();
    }

}
    