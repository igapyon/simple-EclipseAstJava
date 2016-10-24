package simple.eclipse.ast.java;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class SimpleJavaReader {
	public static void main(final String[] args) throws IOException {
		final ASTParser parser = ASTParser.newParser(AST.JLS8);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(
				FileUtils.readFileToString(
						new File("./src/simple/eclipse/ast/java/SimpleJavaReader.java"), "UTF-8")
						.toCharArray());

		final CompilationUnit node = (CompilationUnit) parser.createAST(null);
		final SimpleVisitor visitor = new SimpleVisitor();
		node.accept(visitor);
	}
}
