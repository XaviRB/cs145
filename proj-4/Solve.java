import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static my.LinkedList.*;
import my.Stack;
import my.Queue;
import my.Container;

// Automatically solve a maze
//
// This program solves a simple rectangular maze.  The user passes two arguments
// to the program.  The first is the type of container to use when looking for a
// solution to the maze.  Either a stack (-s) or a queue (-q).  The second
// argument is the name of a file that contains a maze.  The specifics of the
// maze file format are described in the Maze java file.
public class Solve {


    // Command-line options
    //
    // Note the System.exit in Option's constructor.  If the CLI is incomplete
    // or incorrect, the constructor prints a usage statement and exits the
    // process.
    enum SearchType {STACK, QUEUE};

    static class Options {
        SearchType st;
        String     mazefile;
        String     pathfile;
        String     logfile;

        // Usage Statement
        //
        public static void printUsage() {
            System.err.println("Usage: java Solve [-s|-q] filename");
            System.err.println(" -s Use a stack while looking for a solution");
            System.err.println(" -q Use a queue while looking for a solution");
        }

        // Constructor
        //
        public Options(String[] args) {

            if(args.length != 2 &&
                (!args[0].equals("-q") || !args[0].equals("-s"))) {
                printUsage();
                System.exit(1);
            }
            else {
                st       = (args[0].equals("-q")) ? SearchType.QUEUE : SearchType.STACK;
                mazefile = args[1];
                pathfile = mazefile + ".path";
                logfile  = mazefile + ".log";
            }
        }
     }

    // Main
    // This function is the main entry point to the program.  It verifies the
    // arguments to the program and, assuming the arguments are valid, creates
    // the necessary arguments to the input-processing-output parts of the
    // program
    //
    // Note the use of try-with-resource.  This is a Java control structure that
    // closes the file resources when the program leaves the try-block.
    public static void main(String[] args)
        throws FileNotFoundException, IOException {

        Options opts = new Options(args);

        try(FileInputStream input  = new FileInputStream(new File(opts.mazefile));
            PrintStream     log    = new PrintStream(new File(opts.logfile));
            PrintStream     output = new PrintStream(new File(opts.pathfile))) {

            Maze m = Maze.read(input);
            List<Maze.Position> path = solve(m, log, newContiner(opts.st));
            printPath(path, output);
        }

    }

    // Print the discovered path
    //
    public static void printPath(List<Maze.Position> path, PrintStream output) {
        if (path != null) {
            while(!empty(path)) {
                output.println(item(path));
                path = next(path);
            }
        }
    }

    // Solve the maze
    // This function solves the maze and returns a list containing the positions
    // on the solution if one exists.  If no solution exists, it returns null.
    //
    // The log file is filled with the positions that were considered by the
    // solve function.  These will include all of the points on the final path
    // plus those that were considered and rejected.
    //
    //For my solve method I have a manual start for the log just so I could start
    //with the right coords from there I have pathway that takes the maze position and
    //I also find the position of the neighbors. Then I follow the length of the neighbors
    //and check where im at in the list I also use checker to check all the neighbors and that says
    //true or false if thoese neighors have been cheked or not
    //Then if I meet all those critieras I then copy the the old
    //pathway prepend it to newpathway.I then write the points of where I've been then I add the
    //position to the newpathway. Then this is done till it reaches the end.
    public static List<Maze.Position> solve(Maze m, PrintStream log, Container<List<Maze.Position>> c) {
	c.add(new List<Maze.Position>());
        append(c.peek(), m.start());

	log.println(m.start());
	List<Maze.Position> checked = new List<Maze.Position>();

	while(!c.empty() && !m.isFinish(item(c.peek()))) {
		List<Maze.Position> pathway   = c.remove();
		List<Maze.Position> neighbors = m.neighborsOf(item(pathway))
		append(checked, item(pathway));

		for(int j = 0; j < length(neighbors); j++){
			if(!checker(checked, at(neighbors, j) )){
				List<Maze.Position> newPathway = copy(pathway);
				prepend(newPathway, at(neighbors, j));
				log.println(item(pathway));

				c.add(newPathway);
			}
		}
          }
        return c.remove();
    }


    // Create a new container for the type of search requested.
    public static Container<List<Maze.Position>> newContiner (SearchType st) {
        Container<List<Maze.Position>> c = null;
        switch(st) {
        case QUEUE:
            c = new Queue<List<Maze.Position>>();
            break;
        case STACK:
            c = new Stack<List<Maze.Position>>();
            break;
        }
        return c;
   }
}
