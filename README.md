# Artificial Intelligence -  HillClimbing Algorithm in Java
Implementation of Hill Climbing Algorithm for 8Puzzle & 8Queens Problem

##Description

This code contains 4 type of Local Search Algorithm implementation:

- Steepest Ascent Hill Climbing
- First Choice Hill Climbing
- Random-Restart Hill Climbing
- Simulated Annealing

This code shows statistics of running algorithm in console and if you want, you can also show states in terminal with below code:
    
```
GameGenerator gamegenerator = new GameGenerator();
gamegenerator.printGame(__YOUR_STATE__);
```     
    
    
   
In addition if you have Matlab installed on your system, after running the program you can run the run file in logfiles directory from root to see Cost Per Try of each algorithm
    
Here is a exmaple of a Run: 

- Logs:
    
```sh
=======================Statistics========================
                       For 1000 Attempts                    
              Random Restart Hill Climbing               
=========================================================
  Algorithm           : Hill Climbing                    
  Problem             : 8Puzzle                          
  Steepest Ascent     : %34.599998                             
  Steepest Ascent Cost:   4.670520                             
  First Choice        : %34.599998                             
  First Choice Cost   :   4.670520                             
  Simulated Annealing : %100.000000                             
  SA Cost             :   1642.791016                             
  Execution time      : 2669 ms                            
=========================================================
=======================Statistics========================
                       For 100 Attempts                    
              Random Restart Hill Climbing               
=========================================================
  Algorithm           : Hill Climbing                    
  Problem             : 8Queens                          
  Steepest Ascent     : %9.000000                             
  Steepest Ascent Cost:   3.888889                             
  First Choice        : %10.600000                             
  First Choice Cost   :   6.000000                             
  Simulated Annealing : %100.000000                             
  SA Cost             :   1739.849976                             
  Execution time      : 81030 ms                            
=========================================================
```

- MATLAB Graphs:

![FCP](http://s9.picofile.com/file/8346870000/SA_P.png)

![FCP](http://s9.picofile.com/file/8346870068/SimA_P.png)

![FCP](http://s8.picofile.com/file/8346869984/FC_P.png)

![FCP](http://s9.picofile.com/file/8346870018/SA_Q.png)

![FCP](http://s9.picofile.com/file/8346869992/FC_Q.png)

![FCP](http://s9.picofile.com/file/8346870076/SimA_Q.png)





