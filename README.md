# embedded-etcd-jmxtrans
This is an extension of embedded-jmxtrans where the instance can be configured from a remote key-value store based on etcd. The idea is the same behind embedded-jmxtrans-war
The embedded-jmxtrans instance is started on init(), and could be stoped using the stop() method. 
The configuration can be provided in the classic embedded-jmxtrans ways or retrieved from a remote etcd KV store structure.  

The KV store structure is accessed through the embedded-jmxtrans ConfigurationParser and it's refreshed at regular time intervals.

## Usage
There are two ways you can use this project:
* Configured in a classic embedded-jmxtrans way it's a ready to go embedded "agent"
* Configured through an external etcd key value store it's a powerful centrally managed jmxtrans solution.

The reason to build this project in the first place was to build something that worked with the kv store, so that is the way you can get the most out of it (see documentation).

## Documentation

* [Documentation](https://github.com/golorins/embedded-jmxtrans-war/wiki)
