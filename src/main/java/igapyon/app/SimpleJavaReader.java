package igapyon.app;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class SimpleJavaReader {
    public static void main(String[] args) throws IOException {
        new SimpleJavaReader().process();
    }

    public void process() throws IOException {
        final ASTParser parser = ASTParser.newParser(AST.JLS10);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        parser.setSource(
                FileUtils.readFileToString(new File("./src/main/java/igapyon/app/SimpleJavaReader.java"), "UTF-8")
                        .toCharArray());

        final CompilationUnit node = (CompilationUnit) parser.createAST(null);
        final SimpleVisitor visitor = new SimpleVisitor();
        node.accept(visitor);
    }
}
