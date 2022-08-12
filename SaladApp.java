     */
     */
     */
     */
     */
     */
     */
                case "distribute": case "d":









     * @param args The command line arguments are not used.
            "Distribute N - distribute WS into N blocks\n" +
                        multi = single.chop(s.nextInt());
                default:
     *  Entry point of the program.  Creates a SaladApp instance,
        SaladApp app = new SaladApp();
                        multi = single.distribute(s.nextInt());
                        multi = null;
                    }
                    }
                    }
                    }
                    }
                    }
        while (input.hasNextLine()) {
     *  Load FILE    - loads the contents of FILE into the single WS
        System.err.println(app.info());
     *  Returns a message outlining commands and current state.
     *  method to deal with input read from stdin.
     * @param input the source to read commands from.
     *  preloads it with some words, and then calls the handleLine
     *  cause an exception.
            while (i.hasNext()) {
     *
     *
     *
     *
     *
     *
            "Recombine N  - recombine multiple WS blocks using parameter N\n" +
 */
                    return;
     *  multiple WordSalads (MULT) according to commands read from the
     *  methods.
package week09;
import java.io.*;
                case "merge": case "m":
     *  Manipulates the single WordSalad (WS) and the array of
     *  Write FILE   - writes the contents of the single WS to FILE
 * See http://cs.otago.ac.nz/cosc241/pdf/asgn.pdf
     *  input parameter as follows:
            "\nSingle: " + single + "\nMulti: " + Arrays.deepToString(multi);
            "Load FILE    - loads the contents of FILE into WS\n" +
                        single = null;
                        single = null;
                        single = null;
                case "load": case "l":
            "Split N      - split WS into multiple blocks using parameter N\n" +
    public void handleLine(String input) {
            }
            }
            }
                    if (s.hasNextInt()) {
                    if (s.hasNextInt()) {
                    if (s.hasNextInt()) {
                    if (s.hasNextInt()) {
                        load(s.next());
    private void write(String filename) {
        System.out.println("Single: " + single);
     *  Recombine N  - recombine MULT salads into WS using parameter N
            "Chop N       - chop WS into N blocks\n" +
     *  WordSalad methods, and as a parameter to other WordSalad
                        write(s.next());
            FileWriter output = new FileWriter(new File(filename));
            Iterator<String> i = single.iterator();
 *
 *
 * @author Iain Hewson
    public static void main(String[] args) {
            "Merge        - merge multiple WS blocks into a single WS\n" +
     *  Distribute N - distribute WS into N salads storing in MULT
     *  Write the contents of the single WordSalad to a file on one
     *  calling some WordSalad methods, and as a parameter to other
                    break;
                    break;
                    break;
                    break;
                    break;
                    break;
                    break;
                    break;
                case "recombine": case "r":
import java.util.*;
                output.write(i.next() + (i.hasNext() ? " " : "\n"));
            "Join         - join multiple WS blocks into a single WS\n" +
        Scanner s = new Scanner(input);
    private WordSalad[] multi;
        }
        }
        }
        }
     *  Load words from a file into the single WordSalad.
            "Write FILE   - writes the current WS to FILE\n" +
     * 
        try {
        try {
                    System.err.println(info());
    private WordSalad single;
}
            switch (command) {
                wordList.add(words.next());
            single = new WordSalad(wordList);
                case "write": case "w":
 * Application class for the COSC241 assignment.
                case "join": case "j":
     *  A collection of WordSalad objects used to hold the result of
        if (s.hasNext()) {
     *  Merge        - merge salads from MULT and store in WS
            System.err.println(e.getMessage());
            System.err.println(e.getMessage());
            while (words.hasNext()) {
        return "\nEnter commands to manipulate the current WordSalads:\n\n" +
     *  Chop N       - chop WS into N salads storing in MULT
    private String info() {
        Scanner input = new Scanner(System.in);
            Scanner words = new Scanner(new File(filename));
        System.out.println("Multi: " + Arrays.deepToString(multi));
     *  Join         - join salads from MULT and store in WS
            app.handleLine(input.nextLine());
    private void load(String filename) {
                    single = WordSalad.join(multi);
     * @return current state of application and what the commands are.
/**
     *  A WordSalad object used to hold the result of calling some
     * @param filename the name of the file to write to.
            String command = s.next().toLowerCase();
        List<String> wordList = new LinkedList<>();
                case "chop": case "c":
                case "split": case "s":
                        single = WordSalad.recombine(multi, s.nextInt());
     *  WordSalad methods.
                    if (s.hasNext()) {
                    if (s.hasNext()) {
     * </pre>
     *  Note: No error checking is done, so for example calling chop,
     *  distribute, or split when the single WordSalad is null will
public class SaladApp {
        } catch (Exception e) {
        } catch (Exception e) {
    }
    }
    }
    }
    }
     *  Split N      - split WS and store in MULT using parameter N
            output.close();
     * @param filename the name of the file to read words from.
        app.load("words.txt");
    /**
    /**
    /**
    /**
    /**
    /**
    /**
     *  line separated by spaces.
     * <pre>
                        multi = single.split(s.nextInt());
                    multi = null;
                    multi = null;
                    single = WordSalad.merge(multi);
