                output.write(i.next() + (i.hasNext() ? " " : "\n"));
    public void handleLine(String input) {
    }
    }
    }
    }
    }
     *  Load words from a file into the single WordSalad.
                        single = WordSalad.recombine(multi, s.nextInt());
public class SaladApp {
            Scanner words = new Scanner(new File(filename));
            "Distribute N - distribute WS into N blocks\n" +
 *
 *
                    return;
     * 
            "Recombine N  - recombine multiple WS blocks using parameter N\n" +
            "Merge        - merge multiple WS blocks into a single WS\n" +
                    if (s.hasNext()) {
                    if (s.hasNext()) {
            single = new WordSalad(wordList);
import java.util.*;
     *  multiple WordSalads (MULT) according to commands read from the
        if (s.hasNext()) {
                    single = WordSalad.join(multi);
 * Application class for the COSC241 assignment.
                case "chop": case "c":
            switch (command) {
     *  Split N      - split WS and store in MULT using parameter N
            "Join         - join multiple WS blocks into a single WS\n" +
     *  Recombine N  - recombine MULT salads into WS using parameter N
     *  calling some WordSalad methods, and as a parameter to other
            output.close();
     *  Manipulates the single WordSalad (WS) and the array of
            while (i.hasNext()) {
                        multi = single.split(s.nextInt());
                case "merge": case "m":
     * </pre>
                case "load": case "l":
import java.io.*;
        return "\nEnter commands to manipulate the current WordSalads:\n\n" +
     *  WordSalad methods.
        Scanner input = new Scanner(System.in);
                        write(s.next());
                    break;
                    break;
                    break;
                    break;
                    break;
                    break;
                    break;
                    break;
     *  Note: No error checking is done, so for example calling chop,
     * @return current state of application and what the commands are.
     * <pre>
    private String info() {
        while (input.hasNextLine()) {
     *  WordSalad methods, and as a parameter to other WordSalad
            "Write FILE   - writes the current WS to FILE\n" +
     *  method to deal with input read from stdin.
     *  Merge        - merge salads from MULT and store in WS
            app.handleLine(input.nextLine());
}
                    multi = null;
                    multi = null;
                case "split": case "s":
     *  Chop N       - chop WS into N salads storing in MULT
    private WordSalad[] multi;
                        multi = null;
                case "distribute": case "d":
    public static void main(String[] args) {
            Iterator<String> i = single.iterator();
     */
     */
     */
     */
     */
     */
     */
     *  Returns a message outlining commands and current state.
            String command = s.next().toLowerCase();
     *  methods.
/**
                case "join": case "j":
        app.load("words.txt");
    private void load(String filename) {
     *  distribute, or split when the single WordSalad is null will
        System.out.println("Multi: " + Arrays.deepToString(multi));
        System.out.println("Single: " + single);
            }
            }
            }
            "Split N      - split WS into multiple blocks using parameter N\n" +
package week09;
 * See http://cs.otago.ac.nz/cosc241/pdf/asgn.pdf
    private WordSalad single;
                wordList.add(words.next());
     * @param filename the name of the file to read words from.
     *  Write FILE   - writes the contents of the single WS to FILE
 * @author Iain Hewson
                case "write": case "w":
                    if (s.hasNextInt()) {
                    if (s.hasNextInt()) {
                    if (s.hasNextInt()) {
                    if (s.hasNextInt()) {
                        load(s.next());
     *  line separated by spaces.
        } catch (Exception e) {
        } catch (Exception e) {
    /**
    /**
    /**
    /**
    /**
    /**
    /**









                        multi = single.distribute(s.nextInt());
                    }
                    }
                    }
                    }
                    }
                    }
     *  Load FILE    - loads the contents of FILE into the single WS
     *  preloads it with some words, and then calls the handleLine
            "Load FILE    - loads the contents of FILE into WS\n" +
     * @param input the source to read commands from.
        System.err.println(app.info());
                default:
     *  Distribute N - distribute WS into N salads storing in MULT
            "\nSingle: " + single + "\nMulti: " + Arrays.deepToString(multi);
 */
     *  A collection of WordSalad objects used to hold the result of
     * @param filename the name of the file to write to.
     *  Write the contents of the single WordSalad to a file on one
     *  Entry point of the program.  Creates a SaladApp instance,
     *  input parameter as follows:
     * @param args The command line arguments are not used.
    private void write(String filename) {
     *  A WordSalad object used to hold the result of calling some
            System.err.println(e.getMessage());
            System.err.println(e.getMessage());
                    System.err.println(info());
     *
     *
     *
     *
     *
     *
        }
        }
        }
        }
                    single = WordSalad.merge(multi);
        List<String> wordList = new LinkedList<>();
                case "recombine": case "r":
     *  cause an exception.
        SaladApp app = new SaladApp();
                        single = null;
                        single = null;
                        single = null;
        try {
        try {
            FileWriter output = new FileWriter(new File(filename));
                        multi = single.chop(s.nextInt());
            while (words.hasNext()) {
        Scanner s = new Scanner(input);
            "Chop N       - chop WS into N blocks\n" +
     *  Join         - join salads from MULT and store in WS
