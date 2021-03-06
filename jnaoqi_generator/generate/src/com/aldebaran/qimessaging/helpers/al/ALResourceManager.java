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
public class ALResourceManager extends ALModule {

    public ALResourceManager(Session session) {
        super(session);
    }

    /**
    * True if a resource is in another parent resource
    * 
    * @param resourceGroupName  Group name. Ex: Arm
    * @param resourceName  Resource name
    */
    public void createResourcesList(List<String> resourceGroupName, String resourceName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("createResourcesList", resourceGroupName, resourceName);
        else
            service.call("createResourcesList", resourceGroupName, resourceName).get();
    }

    /**
    * The tree of the resources owners.
    * 
    */
    public java.lang.Object ownersGet() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("ownersGet").get();
    }

    /**
    * Get tree of resources
    * 
    */
    public java.lang.Object getResources() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getResources").get();
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
    * Wait resource
    * 
    * @param resourceName  Resource name
    * @param ownerName  Module name
    * @param callbackName  callback name
    * @param timeoutSeconds  Timeout in seconds
    */
    public void waitForResource(String resourceName, String ownerName, String callbackName, Integer timeoutSeconds) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("waitForResource", resourceName, ownerName, callbackName, timeoutSeconds);
        else
            service.call("waitForResource", resourceName, ownerName, callbackName, timeoutSeconds).get();
    }

    /**
    * Wait and acquire a resource
    * 
    * @param resourceName  Resource name
    * @param moduleName  Module name
    * @param callbackName  callback name
    * @param timeoutSeconds  Timeout in seconds
    */
    public void acquireResource(String resourceName, String moduleName, String callbackName, Integer timeoutSeconds) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("acquireResource", resourceName, moduleName, callbackName, timeoutSeconds);
        else
            service.call("acquireResource", resourceName, moduleName, callbackName, timeoutSeconds).get();
    }

    /**
    * Wait resource
    * 
    */
    public List<String> waitForOptionalResourcesTree(List<String> param1, String param2, String param3, Integer param4, List<String> param5) throws CallError, InterruptedException {
        return (List<String>)service.call("waitForOptionalResourcesTree", param1, param2, param3, param4, param5).get();
    }

    /**
    * Wait for resource tree. Parent and children are not in conflict. Local function
    * 
    * @param resourceName  Resource name
    * @param moduleName  Module name
    * @param callbackName  callback name
    * @param timeoutSeconds  Timeout in seconds
    */
    public void waitForResourcesTree(List<String> resourceName, String moduleName, String callbackName, Integer timeoutSeconds) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("waitForResourcesTree", resourceName, moduleName, callbackName, timeoutSeconds);
        else
            service.call("waitForResourcesTree", resourceName, moduleName, callbackName, timeoutSeconds).get();
    }

    /**
    * Wait for resource tree. Parent and children are not in conflict. Local function
    * 
    * @param resourceName  Resource name
    * @param moduleName  Module name
    * @param callbackName  callback name
    * @param timeoutSeconds  Timeout in seconds
    */
    public void acquireResourcesTree(List<String> resourceName, String moduleName, String callbackName, Integer timeoutSeconds) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("acquireResourcesTree", resourceName, moduleName, callbackName, timeoutSeconds);
        else
            service.call("acquireResourcesTree", resourceName, moduleName, callbackName, timeoutSeconds).get();
    }

    /**
    * True if all the specified resources are owned by the owner
    * 
    * @param resourceNameList  Resource name
    * @param ownerName  Owner pointer with hierarchy
    * @return True if all the specify resources are owned by the owner
    */
    public Boolean areResourcesOwnedBy(List<String> resourceNameList, String ownerName) throws CallError, InterruptedException {
        return (Boolean)service.call("areResourcesOwnedBy", resourceNameList, ownerName).get();
    }

    /**
    * Release resource
    * 
    * @param resourceName  Resource name
    * @param ownerName  Existing owner name
    */
    public void releaseResource(String resourceName, String ownerName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("releaseResource", resourceName, ownerName);
        else
            service.call("releaseResource", resourceName, ownerName).get();
    }

    /**
    * Release  resources list
    * 
    * @param resourceNames  Resource names
    * @param ownerName  Owner name
    */
    public void releaseResources(List<String> resourceNames, String ownerName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("releaseResources", resourceNames, ownerName);
        else
            service.call("releaseResources", resourceNames, ownerName).get();
    }

    /**
    * Enable or disable a state resource
    * 
    * @param resourceName  The name of the resource that you wish enable of disable. e.g. Standing
    * @param enabled  True to enable, false to disable
    */
    public void enableStateResource(String resourceName, Boolean enabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableStateResource", resourceName, enabled);
        else
            service.call("enableStateResource", resourceName, enabled).get();
    }

    /**
    * check if all the state resource in the list are free
    * 
    * @param resourceName  Resource name
    */
    public Boolean checkStateResourceFree(List<String> resourceName) throws CallError, InterruptedException {
        return (Boolean)service.call("checkStateResourceFree", resourceName).get();
    }

    /**
    * True if all resources are free
    * 
    * @param resourceNames  Resource names
    * @return True if all the specify resources are free
    */
    public Boolean areResourcesFree(List<String> resourceNames) throws CallError, InterruptedException {
        return (Boolean)service.call("areResourcesFree", resourceNames).get();
    }

    /**
    * True if the resource is free
    * 
    * @param resourceNames  Resource name
    * @return True if the specify resources is free
    */
    public Boolean isResourceFree(String resourceNames) throws CallError, InterruptedException {
        return (Boolean)service.call("isResourceFree", resourceNames).get();
    }

    /**
    * Create a resource
    * 
    * @param resourceName  Resource name to create
    * @param parentResourceName  Parent resource name or empty string for root resource
    */
    public void createResource(String resourceName, String parentResourceName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("createResource", resourceName, parentResourceName);
        else
            service.call("createResource", resourceName, parentResourceName).get();
    }

    /**
    * Delete a root resource
    * 
    * @param resourceName  Resource name to delete
    * @param deleteChildResources  DEPRECATED: Delete child resources if true
    */
    public void deleteResource(String resourceName, Boolean deleteChildResources) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("deleteResource", resourceName, deleteChildResources);
        else
            service.call("deleteResource", resourceName, deleteChildResources).get();
    }

    /**
    * True if a resource is in another parent resource
    * 
    * @param resourceGroupName  Group name. Ex: Arm
    * @param resourceName  Resource name
    */
    public Boolean isInGroup(String resourceGroupName, String resourceName) throws CallError, InterruptedException {
        return (Boolean)service.call("isInGroup", resourceGroupName, resourceName).get();
    }

}
    