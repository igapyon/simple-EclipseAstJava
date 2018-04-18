package igapyon.app;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class SimpleVisitor extends ASTVisitor {
	@Override
	public boolean visit(final MethodDeclaration node) {
		System.out.println("visit(MethodDeclaration)" + node.toString());
		return super.visit(node);
	}
}
