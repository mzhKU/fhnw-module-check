# WebEngineering Module, Graded Exercise

## Commit Proposal

Matriculation Number: 05-721-436

Project idea short description: FHNW Module Rating Platform

As is known, modules at the FHNW vary in quality. The website lists modules available
at the FHNW and students can up/downvote them.
To create new modules or professors, login is required.


## Project confirmation

re-confirming afte re-setup of the repo. D. König


## Project delivery <to be filled by student>

How to start the project: (if other than `grailsw run-app`)

How to test the project:  (if other than `grailsw test-app`)

Hand-written, static HTML 
project description:      (if other than `index.html` in project root directory)

External contributions:

Other comments: 
There would be a lot to do and I really hope to find time for it:
- the most important thing that you can only vote once
- rate modules by documents, assignments, time requirements
- ratings should be by semester
- commenting and discussion of modules

I'm particular proud of:
- it has security
- the teaching domain combining the module and the professor domain

## Project grading 

Anemic [index.html](index.html) found. It is valid and it does contain _semantic_ elements. More information
could have been put there, like how to login (what are the different credentials?) and that _wrappers_
scripts have been modified (making in my environment `./grailsw run-app` resp. `./grailsw test-app` failing).

Application works fine. Validation on **Module** and **Student** could be improved: their name could be _empty_ and their deletion
does NOT work because of their eventual reference in **Rating**.

#### Features

* **Spring Security**
* **CRUD** operations for four domain classes 
* Data setup in bootstrap.

#### Engineering

* Very good git log, good distribution over the available time.
* **HTML** validity has some issues
* Comments are practically NOT present
* Naming is good
* NOT much external dependencies than the ones coming along with the framework

Congratulations! You took advantage of framework's features to implement a functional, 
security-enabled, database-backed, web application from scratch on your own.

Grade: **5.4**