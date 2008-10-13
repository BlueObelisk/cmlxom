package org.xmlcml.euclid;

import java.io.File;

/**
 * 
 * <p>
 * Constants
 * </p>
 * 
 * @author Peter Murray-Rust
 * @version 5.0
 * 
 */
public interface EuclidConstants {

    /** constant */
    char C_COLON = ':';

    /** constant */
    char C_SPACE = ' ';

    /** constant */
    char C_NL = '\n';

    /** constant */
    char C_NBSP = (char) 160;

    /** constant */
    char C_QUOT = '"';

    /** constant */
    char C_SLASH = '/';

    /** constant */
    char C_TAB = '\t';

    /** constant */
    char C_RETURN = '\r';

    /** constant */
    char C_NEWLINE = '\n';

    /** constant */
    char C_FORMFEED = '\f';

    /** constant */
    char C_LBRAK = '(';

    /** constant */
    char C_RBRAK = ')';

    /** constant */
    char C_SHRIEK = '!';

    /** constant */
    char C_POUND = '£';

    /** constant */
    char C_DOLLAR = '$';

    /** constant */
    char C_PERCENT = '%';

    /** constant */
    char C_CARET = '^';

    /** constant */
    char C_AMP = '&';

    /** constant */
    char C_STAR = '*';

    /** constant */
    char C_UNDER = '_';

    /** constant */
    char C_MINUS = '-';

    /** constant */
    char C_PLUS = '+';

    /** constant */
    char C_EQUALS = '=';

    /** constant */
    char C_LCURLY = '{';

    /** constant */
    char C_RCURLY = '}';

    /** constant */
    char C_LSQUARE = '[';

    /** constant */
    char C_RSQUARE = ']';

    /** constant */
    char C_TILDE = '~';

    /** constant */
    char C_HASH = '#';

    /** constant */
    char C_SEMICOLON = ';';

    /** constant */
    char C_ATSIGN = '@';

    /** constant */
    char C_APOS = '\'';

    /** constant */
    char C_COMMA = ',';

    /** constant */
//    char C_CUBED = (char);

    /** constant */
    char C_PERIOD = '.';

    /** constant */
    char C_QUERY = '?';

    /** constant */
    char C_LANGLE = '<';

    /** constant */
    char C_RANGLE = '>';

    /** constant */
    char C_PIPE = '|';

    /** constant */
    char C_BACKSLASH = '\\';

    
    /** constant */
    String S_BACKSLASH = "\\";
    
    /** constant */
    String S_COLON = ":";

    /** constant */
    String S_EMPTY = "";

    /** constant */
    String S_SPACE = " ";

    /** constant */
    String S_NL = "\n";

    /** constant */
    String S_QUOT = "\"";

    /** constant */
    String S_SLASH = "/";

    /** constant */
    String S_WHITEREGEX = S_BACKSLASH+"s+"; // java regex for any whitespace

    /** constant */
    String S_TAB = "\t";

    /** constant */
    String S_RETURN = "\r";

    /** constant */
    String S_NEWLINE = "\n";

    /** constant */
    String S_FORMFEED = "\f";

    /** constant */
    String WHITESPACE = S_SPACE + S_TAB + S_RETURN + S_NEWLINE + S_FORMFEED;

    /** constant */
    String S_LBRAK = "(";

    /** constant */
    String S_RBRAK = ")";

    /** constant */
    String S_SHRIEK = "!";

    /** constant */
    String S_POUND = "£";

    /** constant */
    String S_DOLLAR = "$";

    /** constant */
    String S_PERCENT = "%";

    /** constant */
    String S_CARET = "^";

    /** constant */
    String S_AMP = "&";

    /** constant */
    String S_STAR = "*";

    /** constant */
    String S_UNDER = "_";

    /** constant */
    String S_MINUS = "-";

    /** constant */
    String S_PLUS = "+";

    /** constant */
    String S_EQUALS = "=";

    /** constant */
    String S_LCURLY = "{";

    /** constant */
    String S_RCURLY = "}";

    /** constant */
    String S_LSQUARE = "[";

    /** constant */
    String S_RSQUARE = "]";

    /** constant */
    String S_TILDE = "~";

    /** constant */
    String S_HASH = "#";

    /** constant */
    String S_SEMICOLON = ";";

    /** constant */
    String S_ATSIGN = "@";

    /** constant */
    String S_APOS = "'";

    /** constant */
    String S_COMMA = ",";

    /** constant */
    String S_PERIOD = ".";

    /** constant */
    String S_QUERY = "?";

    /** constant */
    String S_LANGLE = "<";

    /** constant */
    String S_RANGLE = ">";

    /** constant */
    String S_PIPE = "|";


    /** constant */
    String NONWHITEPUNC = S_LBRAK + S_RBRAK + S_SHRIEK + S_QUOT + S_POUND
            + S_DOLLAR + S_PERCENT + S_CARET + S_AMP + S_STAR + S_UNDER
            + S_MINUS + S_PLUS + S_EQUALS + S_LCURLY + S_RCURLY + S_LSQUARE
            + S_RSQUARE + S_TILDE + S_HASH + S_COLON + S_SEMICOLON + S_ATSIGN
            + S_APOS + S_COMMA + S_PERIOD + S_SLASH + S_QUERY + S_LANGLE
            + S_RANGLE + S_PIPE + S_BACKSLASH;

    /** constant */
    String PUNC = WHITESPACE + NONWHITEPUNC;

    /** convenience */
    String F_S = File.separator;

    /** URL separator */
    String U_S = S_SLASH;

    /** */
    double EPS = 1.0E-14;
    /** */
    double ONE_THIRD = 1.0/3.0;
    /** */
    double TWO_THIRDS = 2.0/3.0;
}