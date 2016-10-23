package simple.eclipse.ast.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class SimpleJavaReader {
	public static void main(final String[] args) throws IOException {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream("./src/simple/eclipse/ast/java/SimpleJavaReader.java"), "UTF-8"));
		final StringBuffer buf = new StringBuffer();
		for (;;) {
			String line = reader.readLine();
			if (line == null)
				break;
			buf.append(line);
		}
		reader.close();

		final ASTParser parser = ASTParser.newParser(AST.JLS8);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(buf.toString().toCharArray());

		final CompilationUnit node = (CompilationUnit) parser.createAST(null);
		final SimpleVisitor visitor = new SimpleVisitor();
		node.accept(visitor);
	}
}
