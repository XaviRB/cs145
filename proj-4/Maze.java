import static my.LinkedList.*;
import java.util.Scanner;

// Maze
// Mazes are a grid of cells with walls randomly scattered between adjacent
// cells.  Paths move horizontal and vertical.  Diagonal is not allowed.  The
// file format is a series of 1s and 0s.  The first set of DIMxDIM data are the
// vertical movements where a 1 indicated moving down is valid.  In the next
// DIMxDIM data a 1 indicates moving right is valid.
//
// Each cell has a linked list of Position objects that represent the
// neighboring positions of that cell.  For example, cell (10,10) might have a
// neighborhood of [(9,10), (11, 10)].  These are the cells that are reachable
// from (10,10).
public class Maze {

    public static final int DIM = 25;

    // Position
    // Instances of this class represent a position within the Maze.
    public static class Position {
        public final int X;
        public final int Y;

        // Very simple constructor
        public Position(int x, int y) {
            X = x;
            Y = y;
        }

        // To String method to make printing easier.
        public String toString() {
            return "(" + X + "," + Y + ")";
        }

        // Comparison method
        // Note:  This is a bit complicated because of Java's OO and polymorphic
        // behavior.  Any object can be compared to any other object.  There are
        // a few cases to consider: o is null, o is not a Position, and o is a
        // Position so casting works.
        public boolean equals(Object o) {
            return o != null &&
                (o instanceof Position) &&
                ((Position)o).X == X &&
                ((Position)o).Y == Y;
        }
    }

    // Neighborhoods
    // Note: This is an ArrayList because we cannot make arrays of generic types
    // in Java.  If you are curious, Java treats arrays as covariant, but it
    // treats generics as invariant.  If that doesn't make sense, Java made some
    // bad OO decisions early in its development.
    List<List<List<Position>>> neighbors;

    // Constructor
    // An empty maze is one were all of the cells are isolated.  This is a 2d
    // ArrayList of empty neighborhoods.
    public Maze() {
        neighbors = new List<List<List<Position>>>();
        for(int y = 0; y < DIM; ++y) {
            append(neighbors, new List<List<Position>>());
            for(int x = 0; x < DIM; ++x) {
                append(at(neighbors, y), new List<Position>());
            }
        }
    }

    // Neighbors Of
    // Returns the list of neighbors for the cell at the given position.
    public List<Position> neighborsOf(int x, int y) {
        List<Position> n = null;

        if(0 <= x && x < DIM && 0 <= y && y < DIM) {
            n = at(at(neighbors, y), x);
        }

        return n;
    }

    public List<Position> neighborsOf(Position p) {
        return neighborsOf(p.X, p.Y);
    }

    // Start
    // Returns the starting position of this maze.
    public Position start() {
        return new Position(0,0);
    }

    // Is Finish
    // Predicate function to check if a position is a the goal
    public boolean isFinish(int x, int y) {
        return x == DIM-1 && y == DIM-1;
    }

    public boolean isFinish(Position p) {
        return isFinish(p.X, p.Y);
    }

    // STATIC METHODS

    // Read the vertical section of the input file format.
    public static void readVertical (Maze m, Scanner input) {
        for(int y = 0; y < DIM; ++y) {
            for(int x = 0; x < DIM; ++x) {
                if(input.nextInt() == 1) {
                    append(at(at(m.neighbors,y ), x),   new Position(x, y+1));
                    append(at(at(m.neighbors,y+1),x), new Position(x, y));
                }
            }
        }
    }

    // Read the horizontal section of the input file format.
    public static void readHorizontal(Maze m, Scanner input) {
        for(int y = 0; y < DIM; ++y) {
            for(int x = 0; x < DIM; ++x) {
                if(input.nextInt() == 1) {
                    append(at(at(m.neighbors,y),x  ), new Position(x+1, y));
                    append(at(at(m.neighbors,y),x+1), new Position(x  , y));
                }
            }
        }
    }

    // Read a maze form the provided input stream.
    public static Maze read(java.io.InputStream in) {
        Scanner input = new Scanner(in);

        Maze m = new Maze();
        readVertical(m, input);
        readHorizontal(m, input);

        return m;
    }
}
