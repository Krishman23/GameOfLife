# GameOfLife
Conway's Game of Life

Introduction:

This application- The Game of Life, is a cellular automation simulation invented by the British mathematician
John Horton Conway in 1970. Furthermore on : https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life.

Rules of the Game
The board (or playing field) for the Game of Life is a two dimensional grid of cells. Each cell is
considered to be either “alive” or “dead”. The next generation of the grid is calculated using
these rules:

1. Any live cell with fewer than two live neighbors dies, as if caused by under
population.
2. Any live cell with more than three live neighbors dies, as if by overcrowding.
3. Any live cell with two or three live neighbors lives on to the next generation.
4. Any dead cell with exactly three live neighbors becomes a live cell.
5. A cell’s neighbors are those cells which are horizontally, vertically or
diagonally adjacent. Most cells will have eight neighbors. Cells placed on the
edge of the grid will have fewer.

Deploying the Code: (example of deployment in tomcat server) 

 This project is  is based on Spring MVC web application with maven and Junit tools using : Spring Tool Suite, Version: 3.8.2.RELEASE, Platform: Eclipse Neon.1 (4.6.1) and Tomcat server.
1. Pull the git code, 
2. Do the maven build. using command : mvn clean install 

	Or if you are using development tools like eclipse, right click project and select maven build.
	(may need to write goal as package in maven configuration) 
3. After the build, open the project window and open target folder, copy the .war file.
	(Keep note of file name, shall be used for loading web-app) 
4. Copy and paste the .war file into webapp folder for tomcat.
5. Open tomcat folder till bin folder and startup
6. Once the tomcat is started, open browser with location: 
	localhost:\<your port\> /\<name of war	file without .war\>

Discussion in solutions/ Algorithm:

As this application is modeled as web-application. 
It had common model: Dimension, 3 Controllers for HomeController, DimensionController, GameOfLifeController, and 2 services.
The services are being tested using junit testing. 

On load, a form for entering Row and Column will be displayed through home.jsp. (default 8x6)

On submission of first page, it goes to DimensionController that validated form, if one of the field is empty, shall return to home page with proper message. Then it will call service method to initialize the array with all the dead element. And then loads tableView.jsp with all the grid of dead element and iteration and speed field.

One can click one each element and then make it live. and then should put the iteration count to make next generation. (default iteration: 1, speed : 500ms.)

On submission of second page: loads gameoflifecontroller, it retrieves the 2 dimensional array grid  and then passed to service method to retrieve next generation.

Process of Finding next Generation 

Lets us recall the rule:

 Generation (X) |           Number of Live Neighbour     | Next Generation (X+1) 
-----------------------------------------------------------------------------------
     Live               |  less than eq 1 or greater than eq 4   |  Dead
     Live                  |              eq 2 or eq 3              |  Live
     Dead                  |                  eq 3                  |  Live 
	 

Step 1:
        Retreive the 2D grid.

Step 2:
        Retreive 8 neighbouring points. 
		
		i. for a point [i][j] of current generation, 
			the neighbours would be all the points that will have + / -  1 [i] and [j] coordinates 
			i.e. [i-1][j-1], [i-1][j], [i-1][j+1], [i][j-1], [i][j+1], [i+1][j-1],[i+1][j], [i+1][j+1].
			this can be done, by doing nested loop for each position [i][j] iterating for each of the above coordinate.
			
		ii. Since our condition is dead and alive, I assumed dead as 0 and alive as 1 so the total live neighbors is the sum of all neighbors value.
		
		iii. boundary condition: 
				if i-1<0, start from i, if j-1<0 start from j.
				if i+1>row, go till from i, if j+1>col go till j.
		
Step 3: 
       Iterate step 2 for all positions.
			

	 









