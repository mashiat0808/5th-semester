
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {
    private static final String NEWLINE = "<br />";
    private static final String LT_ENTITY = "&lt;";
    private static final String GT_ENTITY = "&gt;";
    private static final String AMP_ENTITY = "&amp;";

    private static final String FILE_PATH = "sample.txt";

    public String toHtml() throws Exception {
        String text = readFile(FILE_PATH);
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    private String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    private String basicHtmlEncode(String source) {
        List<String> result = new ArrayList<>();
        List<String> convertedLine = new ArrayList<>();
        encodeCharacters(source, result, convertedLine);
        addNewLine(result, convertedLine);
        return String.join(NEWLINE, result);
    }

    private void encodeCharacters(String source, List<String> result, List<String> convertedLine) {
        int i = 0;
        String characterToConvert = stashNextCharacterAndAdvancePointer(source, i);
        i++;

        while (i <= source.length()) {
            switch (characterToConvert) {
                case "<":
                    convertedLine.add(LT_ENTITY);
                    break;
                case ">":
                    convertedLine.add(GT_ENTITY);
                    break;
                case "&":
                    convertedLine.add(AMP_ENTITY);
                    break;
                case "\n":
                    addNewLine(result, convertedLine);
                    break;
                default:
                    pushCharacterToOutput(convertedLine, characterToConvert);
            }

            if (i >= source.length()) {
                break;
            }

            characterToConvert = stashNextCharacterAndAdvancePointer(source, i);
            i++;
        }
    }


    private String stashNextCharacterAndAdvancePointer(String source, int index) {
        char c = source.charAt(index);
        return String.valueOf(c);
    }

    private void addNewLine(List<String> result, List<String> convertedLine) {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine.clear();
    }

    private void pushCharacterToOutput(List<String> convertedLine, String characterToConvert) {
        convertedLine.add(characterToConvert);
    }
}
