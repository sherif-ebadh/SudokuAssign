
<b>Implementation of a Sudoku Web Service</b><br />
implement a RESTful web service that can validate successive moves on a Sudoku board. It should also be able to recognise and
indicate if the Sudoku is finished with the current move.
<br />
A detailed explanation of the Sudoku rules at
https://en.wikipedia.org/wiki/Sudoku (first paragraph).
<br />
<br />
<b>Runing the application</b><br />
Use the system cmd for windows or Terminal for Linux, got to the project folder.
<br />
Using Maven you can run the application using mvn spring-boot:run. 
Or you can build an executable JAR file with mvn clean package and run the JAR by typing:
<br />
  <pre>java -jar target/sudoku-task-0.0.1-SNAPSHOT.jar</pre>
<br />
<b>How to use the application</b><br />
Use the following URL   http://localhost:8080/sudoku/num/1/row/0/col/3
<br />
<b>where</b><br /> 
<ul>
<li>num: is the candidate value which is a  Number from 0 to 9.</li>
<li>row: the row cell for the candidate value which is a  Number from 0 to 9.</li>
<li>col: the col cell for the candidate value which is a  Number from 0 to 9.</li>
</ul>
<br />
<b>the response looks like :</b>
<br />
{"isSolved":false,
"isValidCandidate":true,
"isPossibleSolution":true,
"currentBoard":[[7,0,0,1,4,0,5,3,0],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],
[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],}
<br />
The response in Json Format will include the following :
<br />
isSolved: True if the Sudoku solved.
isValidCandidate: True if the candidate is valid for given positoin.
isPossibleSolution:True if the candidate is possible solution  other wise false .
currentBoard: current Sudoku board.
<br />
The given Sudoku Matrix in the controller:
<br />
[7,0,0,0,4,0,5,3,0]
[0,0,5,0,0,8,0,1,0]
[0,0,8,5,0,9,0,4,0]
[5,3,9,0,6,0,0,0,1]
[0,0,0,0,1,0,0,0,5]
[8,0,0,7,2,0,9,0,0]
[9,0,7,4,0,0,0,0,0]
[0,0,0,0,5,7,0,0,0]
[6,0,0,0,0,0,0,5,0]

The Expected solution:

[7,9,2,1,4,6,5,3,8]
[4,6,5,2,3,8,7,1,9]
[3,1,8,5,7,9,6,4,2]
[5,3,9,8,6,4,2,7,1]
[2,7,6,9,1,3,4,8,5]
[8,4,1,7,2,5,9,6,3]
[9,5,7,4,8,1,3,2,6]
[1,2,3,6,5,7,8,9,4]
[6,8,4,3,9,2,1,5,7]
