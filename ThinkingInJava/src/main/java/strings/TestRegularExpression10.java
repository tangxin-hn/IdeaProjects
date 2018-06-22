package strings;

// strings/TestRegularExpression10.java
// TIJ4 Chapter Strings, Exercise 10, page 533
/* For the phrase "Java now has regular expressions" evaluate whether the following
* expressions will find a match:
* 	^Java
* 	\Berg.*
*	n.w\s+h(a|i)s
*	S?
*	S+
*	s{4}
*	s{1}.
* 	s{0,3}
*/
// Use args: "Java now has regular expressions", "^Java", "\Berg.*", "n.w\s+h(a|i)s",
//	"s?", "s+", "s{4}", "s{1}.", "s{0,3}"
import java.util.regex.*;

public class TestRegularExpression10 {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Usage:\njava TestRegularExpression " +
                    "characterSequence regularExpression+");
            System.exit(0);
        }
        System.out.println("Input: \"" + args[0] + "\"");
        for(String arg : args) {
            System.out.println("Regular expression: \"" + arg + "\"");
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            if(!m.find())
                System.out.println("No match found for " + "\"" + arg + "\"");
            m.reset();
            while(m.find()) {
                System.out.println("Match \"" + m.group() + "\" at position " +
                        m.start() + ((m.end() - m.start() < 2) ? "" :  ("-" + (m.end() - 1))));
            }
        }
    }
}





