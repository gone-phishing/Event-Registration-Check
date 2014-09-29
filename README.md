Event-Registration-Check
========================

Filter registered users from a pool of users and add on-spot registrations.
The application prefetches all the id's of registered users from a file called 'Registrations.txt' and then waits for an id to be entered to match with the existent userbase.
An id can be entered manually or by scanning it from a bar code scanner(for quick access). 
Any id can fall under 4 test cases:

*Registered and so allow to enter
*Not registered but want to register
*Already scanned and registered
*Already scanned and not registered

All cases are taken into account and count of all users entering is maintained. Any new registrant is added to a separate file called 'new_reg.txt'

The application is stopped by entering the keyword 'exit' which alongwith exiting the application, adds the complete list of names from the buffer space to the respective files and also produces a dump of all the id's entering the room with the total count value.
