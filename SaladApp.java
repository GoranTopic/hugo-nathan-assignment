     *  WordSalad methods, and as a parameter to other WordSalad
                    multi = null;
                    multi = null;









     *  Load FILE    - loads the contents of FILE into the single WS
     *  Chop N       - chop WS into N salads storing in MULT
     * @param input the source to read commands from.
public class SaladApp {
package week09;
    public static void main(String[] args) {
    private void write(String filename) {
     *  Write FILE   - writes the contents of the single WS to FILE
import java.io.*;
import java.util.*;
                        multi = single.distribute(s.nextInt());
     */
     */
     */
     */
     */
     */
     */
        return "\nEnter commands to manipulate the current WordSalads:\n\n" +
     *  Write the contents of the single WordSalad to a file on one
    }
    }
    }
    }
    }
                default:
        while (input.hasNextLine()) {
                    }
                    }
                    }
                    }
                    }
                    }
        try {
        try {
     * @param filename the name of the file to read words from.
     * </pre>
                case "join": case "j":
                case "recombine": case "r":
                    single = WordSalad.merge(multi);
        SaladApp app = new SaladApp();
            output.close();
                    single = WordSalad.join(multi);
     *  line separated by spaces.
                    break;
                    break;
                    break;
                    break;
                    break;
                    break;
                    break;
                    break;
            "Join         - join multiple WS blocks into a single WS\n" +
            "Chop N       - chop WS into N blocks\n" +
                output.write(i.next() + (i.hasNext() ? " " : "\n"));
     *  Distribute N - distribute WS into N salads storing in MULT
                    System.err.println(info());
     *  input parameter as follows:
        Scanner s = new Scanner(input);
            "\nSingle: " + single + "\nMulti: " + Arrays.deepToString(multi);
}
        System.err.println(app.info());
                        multi = null;
     *  Merge        - merge salads from MULT and store in WS
    /**
    /**
    /**
    /**
    /**
    /**
    /**
     *  preloads it with some words, and then calls the handleLine
        List<String> wordList = new LinkedList<>();
     *  calling some WordSalad methods, and as a parameter to other
     *  distribute, or split when the single WordSalad is null will
            String command = s.next().toLowerCase();
            "Merge        - merge multiple WS blocks into a single WS\n" +
            FileWriter output = new FileWriter(new File(filename));
    private WordSalad[] multi;
     *  Recombine N  - recombine MULT salads into WS using parameter N
                    if (s.hasNext()) {
                    if (s.hasNext()) {
    private void load(String filename) {
                case "merge": case "m":
        Scanner input = new Scanner(System.in);
     *  Note: No error checking is done, so for example calling chop,
                case "write": case "w":
                        write(s.next());
     *  cause an exception.
                        multi = single.chop(s.nextInt());
     *  Split N      - split WS and store in MULT using parameter N
            "Load FILE    - loads the contents of FILE into WS\n" +
                    return;
                        multi = single.split(s.nextInt());
        System.out.println("Single: " + single);
/**
            System.err.println(e.getMessage());
            System.err.println(e.getMessage());
                case "split": case "s":
     * 
     * <pre>
        System.out.println("Multi: " + Arrays.deepToString(multi));
                        load(s.next());
    private WordSalad single;
            "Split N      - split WS into multiple blocks using parameter N\n" +
            switch (command) {
     *  A WordSalad object used to hold the result of calling some
 * @author Iain Hewson
            while (i.hasNext()) {
 */
     *
     *
     *
     *
     *
     *
                case "load": case "l":
            while (words.hasNext()) {
        app.load("words.txt");
     *  WordSalad methods.
                        single = null;
                        single = null;
                        single = null;
     *  A collection of WordSalad objects used to hold the result of
                wordList.add(words.next());
                case "distribute": case "d":
     * @param args The command line arguments are not used.
                case "chop": case "c":
            app.handleLine(input.nextLine());
                    if (s.hasNextInt()) {
                    if (s.hasNextInt()) {
                    if (s.hasNextInt()) {
                    if (s.hasNextInt()) {
     *  methods.
 *
 *
        } catch (Exception e) {
        } catch (Exception e) {
            "Recombine N  - recombine multiple WS blocks using parameter N\n" +
     *  Entry point of the program.  Creates a SaladApp instance,
        if (s.hasNext()) {
            single = new WordSalad(wordList);
    public void handleLine(String input) {
            Scanner words = new Scanner(new File(filename));
     *  Manipulates the single WordSalad (WS) and the array of
     * @param filename the name of the file to write to.
     *  Returns a message outlining commands and current state.
        }
        }
        }
        }
     *  multiple WordSalads (MULT) according to commands read from the
     * @return current state of application and what the commands are.
            }
            }
            }
 * See http://cs.otago.ac.nz/cosc241/pdf/asgn.pdf
                        single = WordSalad.recombine(multi, s.nextInt());
            Iterator<String> i = single.iterator();
 * Application class for the COSC241 assignment.
    private String info() {
            "Distribute N - distribute WS into N blocks\n" +
     *  Join         - join salads from MULT and store in WS
     *  Load words from a file into the single WordSalad.
     *  method to deal with input read from stdin.
            "Write FILE   - writes the current WS to FILE\n" +
