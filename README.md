<h1> Tango Assessment</h1>
<p>
 	Mathematically, we hypothesized the result is the contestant switching their original choice will result a double chance to win the price, and the paradigm of solving is do a paradigm shift to think the game process reversely. Base on that, a simulation was built to imitate the game, and play the game 2000 times and analyze the result.
</p>
<p>	
	In the simulation, the input data of each game is the winning briefcase, the contestant’s original choice and do they choose to switch. An exclusive or logic (XOR) is performed in the game checking process. From the simulation, we obtain the winning rate of the contestant chose switch is 68.1%, and the winning rate of staying is 33.8%. The ratio of these rates is approximately 1:2. Also, the simulation provides the cumulative winning rate, which is 51%, close to a half, shows the game is fair, and the algorithm is preformed correctly. This program also provides a visualization of the results by plotting them into a choice vs. winning rate bar chart. and 3 pie charts for the winning rates.
</p>
<p>
	The result of the simulation matches the mathematical hypothesis,  explicitly shows switch the original choice will result a double probability to win. This program is also friendly to add more features to the current specifications, by modifying the constants, and change the data type of the parameters, specifically, a boolean to an integer. 
</p>
<p>
To run this program:
Run the simulation: Create a java project and import these java files into the project. Run the App.java file will print out the data in command line, also it creates a file with those data. 
Run the visualization: After run the simulation, place the resulted *.txt file with the python file into the same directory, and don't forget to install numpy and matplotlib with your python. Run the python file will show the plots in pop-up windows.

Do not copy briefcase_simulation_result_1.txt into the java project src folder, it is a sample run result for the reference of the report. You will get a new txt file after you run the simulation.
</p>
<p>
There is also an Android project for this small game. Goto: <a href="https://github.com/johnianzhang/Tango_Briefcase_Game">https://github.com/johnianzhang/Tango_Briefcase_Game</a>
</p>
