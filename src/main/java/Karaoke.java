import Scanner.Lexer;
import Scanner.Token;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class Karaoke {

    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Usage: karaoke [script]");
            System.exit(64);
        } else if (args.length == 1) {
            runFile(args[0]);
        } else {
            runPrompt();
        }
    }

    private static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes, Charset.defaultCharset()));
    }

    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        for (;;) {
            System.out.print("> ");
            String line = reader.readLine();
            if (Objects.equals(line, "")) break;
            run(line);
        }
    }

    private static void run(String source) {
        Lexer scanner = new Lexer(source);
        List<Token> tokens = scanner.tokenize();
        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}