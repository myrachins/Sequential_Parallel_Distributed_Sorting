# Sequential, Parallel, Distributed Sorting

## This task is a part of the discipline "Software Construction", SE, HSE

## Structure of the project
* `/docs` - the task and video
* `/bats` - bats files for testing
* `/out/artifacts` - jars
* `/Sequential_Parallel_Distributed_Sorting_Client` - client application
* `/Sequential_Parallel_Distributed_Sorting_Server` - server application
* `/Sequential_Parallel_Distributed_Sorting_Library` - library for sorting
* readme.md

## Description
- Ways of sorting list with integer numbers using merge sort.
   - Ordinary sort.
   - Multi thread approach.
   - Delegating sort to the client applications.

More details about the task could be found in `/docs`.

## Example of execution
You can simply use `.bat` files for testing. Otherwise execute jar files from `/out/artifacts` directory.
- `java -jar server.jar 100 10 localhost 4444`
    - n = 100, m = 10, server_address = localhost, server_port = 4444 
- `java -jar client.jar localhost 4444`
    - server_address = localhost, server_port = 4444 

## Team
- Rachinskiy Maxim