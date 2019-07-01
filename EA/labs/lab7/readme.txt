a- using lazy collection
To fetch this data from the database took 27973 milliseconds.

b- when batch = 10
To fetch this data from the database took 22559 milliseconds.

b- when batch = 5
To fetch this data from the database took 18666 milliseconds.

b- when batch = 50
To fetch this data from the database took 16452 milliseconds.

c- when using subselect
To fetch this data from the database took 6936 milliseconds.

d- when using join with direct query
To fetch this data from the database took 39253 milliseconds.

d- when using join with named query
To fetch this data from the database took 52625 milliseconds.

e- when using join with entity graph
To fetch this data from the database using entity graph took 6520 milliseconds.

from I saw, I can conclude that using the entity graph is the best strategy performance wise.

