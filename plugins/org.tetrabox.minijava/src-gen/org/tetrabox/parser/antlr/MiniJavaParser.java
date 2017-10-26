/*
 * generated by Xtext 2.12.0
 */
package org.tetrabox.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.tetrabox.parser.antlr.internal.InternalMiniJavaParser;
import org.tetrabox.services.MiniJavaGrammarAccess;

public class MiniJavaParser extends AbstractAntlrParser {

	@Inject
	private MiniJavaGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalMiniJavaParser createParser(XtextTokenStream stream) {
		return new InternalMiniJavaParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Domainmodel";
	}

	public MiniJavaGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(MiniJavaGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
