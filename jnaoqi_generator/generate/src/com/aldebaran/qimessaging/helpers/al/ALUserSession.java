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
public class ALUserSession extends ALModule {

    public ALUserSession(Session session) {
        super(session);
    }

    /**
    * Declare a source of data that is querialbe with user session.
    * 
    * @param source_name  The string name of the data source.
    * @param proxy_name  The string name of the module that will answer the query callback
    */
    public void _registerUserDataSource(String source_name, String proxy_name) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_registerUserDataSource", source_name, proxy_name);
        else
            service.call("_registerUserDataSource", source_name, proxy_name).get();
    }

    /**
    * Get some data about a user.  Will throw if it does not exist
    * 
    * @param uid  The int ID of the user whose data to get.
    * @param data_name  The key of the data to get.
    * @return A map keyed by source_name of ALValues of the data.
    */
    public Map<String, java.lang.Object> getUserData(Integer uid, String data_name) throws CallError, InterruptedException {
        return (Map<String, java.lang.Object>)service.call("getUserData", uid, data_name).get();
    }

    /**
    * Unbind a user from another source.
    * 
    * @param uid  The int ID of the user
    * @param binding_name  The string name of the binding source.
    */
    public void _unbindUser(Integer uid, String binding_name) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_unbindUser", uid, binding_name);
        else
            service.call("_unbindUser", uid, binding_name).get();
    }

    /**
    * Get the a specific source a user is bound to.
    * 
    * @param uid  The int ID of the user.
    * @param binding_name  The string name of the binding source.
    * @return The string value of the binding ID for the user.
    */
    public String getUserBinding(Integer uid, String binding_name) throws CallError, InterruptedException {
        return (String)service.call("getUserBinding", uid, binding_name).get();
    }

    /**
    * Get the sources a user is bound to.
    * 
    * @param binding_name  The string name of the binding source.
    * @param binding_value  The string ID of the user at the binding source.
    * @return The int IDs of the users with the passed binding_value.
    */
    public List<Integer> findUsersWithBinding(String binding_name, String binding_value) throws CallError, InterruptedException {
        return (List<Integer>)service.call("findUsersWithBinding", binding_name, binding_value).get();
    }

    /**
    * Undeclare a source of data, the query callback will no longer be raised for it.
    * 
    * @param source_name  The string name of the data source.
    */
    public void _unregisterUserDataSource(String source_name) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_unregisterUserDataSource", source_name);
        else
            service.call("_unregisterUserDataSource", source_name).get();
    }

    /**
    * Check if a data source has been registered.
    * 
    * @param source_name  The string name of the data source.
    * @return A bool, true if the source has been registered
    */
    public Boolean doesUserDataSourceExist(String source_name) throws CallError, InterruptedException {
        return (Boolean)service.call("doesUserDataSourceExist", source_name).get();
    }

    /**
    * Get the sources a user is bound to.
    * 
    * @param uid  The int ID of the user.
    * @return A map of string binding names and their string values.
    */
    public Map<String, String> getUserBindings(Integer uid) throws CallError, InterruptedException {
        return (Map<String, String>)service.call("getUserBindings", uid).get();
    }

    /**
    * Check what data sources have been registered.
    * 
    * @return A list of strings of each registered data source.
    */
    public List<String> getUserDataSources() throws CallError, InterruptedException {
        return (List<String>)service.call("getUserDataSources").get();
    }

    /**
    * Get some data about a user.  Will throw if it does not exist
    * 
    * @param uid  The int ID of the user whose data to get.
    * @param data_name  The key of the data to get.
    * @param source_name  The string name of the data source.
    * @return ALValue of the data.
    */
    public java.lang.Object getUserData(Integer uid, String data_name, String source_name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getUserData", uid, data_name, source_name).get();
    }

    /**
    * Set some data about a user.  Will throw if user does not exist
    * 
    * @param uid  The int ID of the user whose data to set.
    * @param data_name  The key of the data to set.
    * @param source_name  The string name of the data source.
    * @param data  ALValue of the data.
    */
    public void setUserData(Integer uid, String data_name, String source_name, java.lang.Object data) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setUserData", uid, data_name, source_name, data);
        else
            service.call("setUserData", uid, data_name, source_name, data).get();
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
    * Get the version of the database.
    * 
    * @return The int version of the database.
    */
    public Integer _getDatabaseVersion() throws CallError, InterruptedException {
        return (Integer)service.call("_getDatabaseVersion").get();
    }

    /**
    * Create new users in the database.
    * 
    * @param num_users  An int to specify how many users to create.
    * @return A list of the int ID of each user created.
    */
    public List<Integer> _createUsers(Integer num_users) throws CallError, InterruptedException {
        return (List<Integer>)service.call("_createUsers", num_users).get();
    }

    /**
    * Delete users from the database.
    * 
    * @param user_list  A list of the int ID of each user to delete.
    */
    public void _deleteUsers(List<Integer> user_list) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_deleteUsers", user_list);
        else
            service.call("_deleteUsers", user_list).get();
    }

    /**
    * Check if users exist in db.
    * 
    * @param user_list  A list of int ID of the users to check.
    * @return A bool, true if all users exist.
    */
    public Boolean doUsersExist(List<Integer> user_list) throws CallError, InterruptedException {
        return (Boolean)service.call("doUsersExist", user_list).get();
    }

    /**
    * Get a full list of the users.
    * 
    * @return A list of int user IDs.
    */
    public List<Integer> getUserList() throws CallError, InterruptedException {
        return (List<Integer>)service.call("getUserList").get();
    }

    /**
    * Get the count of users in db.
    * 
    * @return An int of how many users exist
    */
    public Integer getNumUsers() throws CallError, InterruptedException {
        return (Integer)service.call("getNumUsers").get();
    }

    /**
    * Get which user has the robot's focus.
    * 
    * @return The int ID of the focused user. -1 if no focused user.
    */
    public Integer getFocusedUser() throws CallError, InterruptedException {
        return (Integer)service.call("getFocusedUser").get();
    }

    /**
    * Set which user has the robot's focus.
    * 
    * @param focused_user  The int ID of the focused user. -1 if no focused user. Will throw if the user does not exist.
    */
    public void _setFocusedUser(Integer focused_user) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setFocusedUser", focused_user);
        else
            service.call("_setFocusedUser", focused_user).get();
    }

    /**
    * Get which users have an open session.
    * 
    * @return A list of int IDs of each user with an open session.
    */
    public List<Integer> getOpenUserSessions() throws CallError, InterruptedException {
        return (List<Integer>)service.call("getOpenUserSessions").get();
    }

    /**
    * Check if users have an open session.
    * 
    * @param user_list  A list of int IDs of each user to check.
    * @return A bool, true if all users have open sessions.
    */
    public Boolean areUserSessionsOpen(List<Integer> user_list) throws CallError, InterruptedException {
        return (Boolean)service.call("areUserSessionsOpen", user_list).get();
    }

    /**
    * Open sessions for users.
    * 
    * @param user_list  A list of int ID of users to open sessions for. UserSession/SessionsOpened will be raised with the list of int IDs of each user whose session changed. Already open users are ignored. Will throw if the user does not exist.
    * @return A list of int IDs of each user whose session changed from closed to open.
    */
    public List<Integer> _openUserSessions(List<Integer> user_list) throws CallError, InterruptedException {
        return (List<Integer>)service.call("_openUserSessions", user_list).get();
    }

    /**
    * Close sessions for users.
    * 
    * @param user_list  A list of int ID of users to close sessions for. UserSession/SessionsClosed will be raised with the list of int IDs of each user whose session changed. Already closed users are ignored. Will throw if the user does not exist.
    * @return A list of int IDs of each user whose session changed from open to closed.
    */
    public List<Integer> _closeUserSessions(List<Integer> user_list) throws CallError, InterruptedException {
        return (List<Integer>)service.call("_closeUserSessions", user_list).get();
    }

    /**
    * The list of binding sources  that have been applied to UserSession
    * 
    * @return A list of strings, one for each binding source.
    */
    public List<String> getBindingSources() throws CallError, InterruptedException {
        return (List<String>)service.call("getBindingSources").get();
    }

    /**
    * Query if a particular has been applied to UserSession
    * 
    * @param binding_name  The string name of the binding source.
    * @return A bool, true if a binding source exists.
    */
    public Boolean doesBindingSourceExist(String binding_name) throws CallError, InterruptedException {
        return (Boolean)service.call("doesBindingSourceExist", binding_name).get();
    }

    /**
    * Bind a user to another source.
    * 
    * @param uid  The int ID of the user
    * @param binding_name  The string name of the binding source.
    * @param binding_value  The string ID of the user at the binding source.
    */
    public void _bindUser(Integer uid, String binding_name, String binding_value) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_bindUser", uid, binding_name, binding_value);
        else
            service.call("_bindUser", uid, binding_name, binding_value).get();
    }

}
    