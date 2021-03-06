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
public class ALLauncher extends ALModule {

    public ALLauncher(Session session) {
        super(session);
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
    * Loads dynamicaly a module
    * 
    * @param moduleName  the name of the module to launch or the name of the python script to evaluate
    * @return list of modules loaded
    */
    public List<String> launchLocal(String moduleName) throws CallError, InterruptedException {
        return (List<String>)service.call("launchLocal", moduleName).get();
    }

    /**
    * runs an executable and connect it to current broker (executable)
    * 
    * @param moduleName  the name of the module to launch or the name of the script file to execute
    * @return true if ok
    */
    public Boolean launchExecutable(String moduleName) throws CallError, InterruptedException {
        return (Boolean)service.call("launchExecutable", moduleName).get();
    }

    /**
    * runs an executable and connect it to current broker (executable)
    * 
    * @param executablePath  the name of the module to launch or the name of the script file to execute
    * @param arguments  any optional argument to be passed to the executable.
    * @return the pid of the process spawned
    */
    public Integer _launch(String executablePath, List<String> arguments) throws CallError, InterruptedException {
        return (Integer)service.call("_launch", executablePath, arguments).get();
    }

    /**
    * Runs an executable with custom arguments, and waits for it to end.
    * 
    * @param executablePath  the name of the module to launch or the name of the script file to execute
    * @param arguments  any optional argument to be passed to the executable.
    * @return the exit code of the program launched
    */
    public Integer _launchWait(String executablePath, List<String> arguments) throws CallError, InterruptedException {
        return (Integer)service.call("_launchWait", executablePath, arguments).get();
    }

    /**
    * runs a script connected the current broker
    * 
    * @param moduleName  the name of the script to launch (python)
    * @return true if ok
    */
    public Boolean launchScript(String moduleName) throws CallError, InterruptedException {
        return (Boolean)service.call("launchScript", moduleName).get();
    }

    /**
    * Import a python module
    * 
    * @param moduleName  the name of the module to launch
    * @return true if ok
    */
    public Boolean launchPythonModule(String moduleName) throws CallError, InterruptedException {
        return (Boolean)service.call("launchPythonModule", moduleName).get();
    }

    /**
    * Tests the existence of an active module in the global system (in same executable or in another executable of the distributed system)
    * 
    * @param strPartOfModuleName  a part of the name of the module to test existence
    * @return the returned value is true if this module is present
    */
    public Boolean isModulePresent(String strPartOfModuleName) throws CallError, InterruptedException {
        return (Boolean)service.call("isModulePresent", strPartOfModuleName).get();
    }

    /**
    * get the list of modules loaded on the robot and connected on the robot
    * 
    * @return array of present modules
    */
    public List<String> getGlobalModuleList() throws CallError, InterruptedException {
        return (List<String>)service.call("getGlobalModuleList").get();
    }

}
    