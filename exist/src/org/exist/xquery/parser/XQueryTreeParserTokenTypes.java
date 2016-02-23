// $ANTLR 2.7.7 (2006-11-01): "XQueryTree.g" -> "XQueryTreeParser.java"$

	package org.exist.xquery.parser;

	import antlr.debug.misc.*;
	import java.io.StringReader;
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Iterator;
	import java.util.Map;
	import java.util.Set;
	import java.util.TreeSet;
	import java.util.HashMap;
	import java.util.Stack;
	import org.exist.storage.BrokerPool;
	import org.exist.storage.DBBroker;
	import org.exist.storage.analysis.Tokenizer;
	import org.exist.EXistException;
	import org.exist.Namespaces;
	import org.exist.dom.DocumentSet;
	import org.exist.dom.DocumentImpl;
	import org.exist.dom.QName;
	import org.exist.security.PermissionDeniedException;
	import org.exist.util.XMLChar;
	import org.exist.xquery.*;
	import org.exist.xquery.value.*;
	import org.exist.xquery.functions.fn.*;
	import org.exist.xquery.update.*;
	import org.exist.storage.ElementValue;
	import org.exist.xquery.functions.map.MapExpr;
	import org.exist.xquery.functions.map.MapLookup;

public interface XQueryTreeParserTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int QNAME = 4;
	int PREDICATE = 5;
	int FLWOR = 6;
	int PARENTHESIZED = 7;
	int ABSOLUTE_SLASH = 8;
	int ABSOLUTE_DSLASH = 9;
	int WILDCARD = 10;
	int PREFIX_WILDCARD = 11;
	int FUNCTION = 12;
	int DYNAMIC_FCALL = 13;
	int UNARY_MINUS = 14;
	int UNARY_PLUS = 15;
	int XPOINTER = 16;
	int XPOINTER_ID = 17;
	int VARIABLE_REF = 18;
	int VARIABLE_BINDING = 19;
	int ELEMENT = 20;
	int ATTRIBUTE = 21;
	int ATTRIBUTE_CONTENT = 22;
	int TEXT = 23;
	int VERSION_DECL = 24;
	int NAMESPACE_DECL = 25;
	int DEF_NAMESPACE_DECL = 26;
	int DEF_COLLATION_DECL = 27;
	int DEF_FUNCTION_NS_DECL = 28;
	int ANNOT_DECL = 29;
	int GLOBAL_VAR = 30;
	int FUNCTION_DECL = 31;
	int FUNCTION_INLINE = 32;
	int FUNCTION_TEST = 33;
	int MAP_TEST = 34;
	int MAP_LOOKUP = 35;
	int PROLOG = 36;
	int OPTION = 37;
	int ATOMIC_TYPE = 38;
	int MODULE = 39;
	int ORDER_BY = 40;
	int GROUP_BY = 41;
	int POSITIONAL_VAR = 42;
	int CATCH_ERROR_CODE = 43;
	int CATCH_ERROR_DESC = 44;
	int CATCH_ERROR_VAL = 45;
	int MODULE_DECL = 46;
	int MODULE_IMPORT = 47;
	int SCHEMA_IMPORT = 48;
	int ATTRIBUTE_TEST = 49;
	int COMP_ELEM_CONSTRUCTOR = 50;
	int COMP_ATTR_CONSTRUCTOR = 51;
	int COMP_TEXT_CONSTRUCTOR = 52;
	int COMP_COMMENT_CONSTRUCTOR = 53;
	int COMP_PI_CONSTRUCTOR = 54;
	int COMP_NS_CONSTRUCTOR = 55;
	int COMP_DOC_CONSTRUCTOR = 56;
	int PRAGMA = 57;
	int GTEQ = 58;
	int SEQUENCE = 59;
	int LITERAL_xpointer = 60;
	int LPAREN = 61;
	int RPAREN = 62;
	int NCNAME = 63;
	int LITERAL_xquery = 64;
	int LITERAL_version = 65;
	int SEMICOLON = 66;
	int LITERAL_module = 67;
	int LITERAL_namespace = 68;
	int EQ = 69;
	int STRING_LITERAL = 70;
	int LITERAL_declare = 71;
	int LITERAL_default = 72;
	// "boundary-space" = 73
	int LITERAL_ordering = 74;
	int LITERAL_construction = 75;
	// "base-uri" = 76
	// "copy-namespaces" = 77
	int LITERAL_option = 78;
	int LITERAL_function = 79;
	int LITERAL_variable = 80;
	int MOD = 81;
	int LITERAL_import = 82;
	int LITERAL_encoding = 83;
	int LITERAL_collation = 84;
	int LITERAL_element = 85;
	int LITERAL_order = 86;
	int LITERAL_empty = 87;
	int LITERAL_greatest = 88;
	int LITERAL_least = 89;
	int LITERAL_preserve = 90;
	int LITERAL_strip = 91;
	int LITERAL_ordered = 92;
	int LITERAL_unordered = 93;
	int COMMA = 94;
	// "no-preserve" = 95
	int LITERAL_inherit = 96;
	// "no-inherit" = 97
	int DOLLAR = 98;
	int LCURLY = 99;
	int RCURLY = 100;
	int COLON = 101;
	int LITERAL_external = 102;
	int LITERAL_schema = 103;
	// ":" = 104
	int LITERAL_as = 105;
	int LITERAL_at = 106;
	// "empty-sequence" = 107
	int QUESTION = 108;
	int STAR = 109;
	int PLUS = 110;
	int LITERAL_item = 111;
	int LITERAL_map = 112;
	int LITERAL_for = 113;
	int LITERAL_let = 114;
	int LITERAL_try = 115;
	int LITERAL_some = 116;
	int LITERAL_every = 117;
	int LITERAL_if = 118;
	int LITERAL_switch = 119;
	int LITERAL_typeswitch = 120;
	int LITERAL_update = 121;
	int LITERAL_replace = 122;
	int LITERAL_value = 123;
	int LITERAL_insert = 124;
	int LITERAL_delete = 125;
	int LITERAL_rename = 126;
	int LITERAL_with = 127;
	int LITERAL_into = 128;
	int LITERAL_preceding = 129;
	int LITERAL_following = 130;
	int LITERAL_catch = 131;
	int UNION = 132;
	int LITERAL_where = 133;
	int LITERAL_return = 134;
	int LITERAL_in = 135;
	int LITERAL_by = 136;
	int LITERAL_stable = 137;
	int LITERAL_ascending = 138;
	int LITERAL_descending = 139;
	int LITERAL_group = 140;
	int LITERAL_satisfies = 141;
	int LITERAL_case = 142;
	int LITERAL_then = 143;
	int LITERAL_else = 144;
	int LITERAL_or = 145;
	int LITERAL_and = 146;
	int LITERAL_instance = 147;
	int LITERAL_of = 148;
	int LITERAL_treat = 149;
	int LITERAL_castable = 150;
	int LITERAL_cast = 151;
	int BEFORE = 152;
	int AFTER = 153;
	int LITERAL_eq = 154;
	int LITERAL_ne = 155;
	int LITERAL_lt = 156;
	int LITERAL_le = 157;
	int LITERAL_gt = 158;
	int LITERAL_ge = 159;
	int GT = 160;
	int NEQ = 161;
	int LT = 162;
	int LTEQ = 163;
	int LITERAL_is = 164;
	int LITERAL_isnot = 165;
	int ANDEQ = 166;
	int OREQ = 167;
	int CONCAT = 168;
	int LITERAL_to = 169;
	int MINUS = 170;
	int LITERAL_div = 171;
	int LITERAL_idiv = 172;
	int LITERAL_mod = 173;
	int PRAGMA_START = 174;
	int PRAGMA_END = 175;
	int LITERAL_union = 176;
	int LITERAL_intersect = 177;
	int LITERAL_except = 178;
	int SLASH = 179;
	int DSLASH = 180;
	int BANG = 181;
	int LITERAL_text = 182;
	int LITERAL_node = 183;
	int LITERAL_attribute = 184;
	int LITERAL_comment = 185;
	// "processing-instruction" = 186
	// "document-node" = 187
	int LITERAL_document = 188;
	int HASH = 189;
	int SELF = 190;
	int XML_COMMENT = 191;
	int XML_PI = 192;
	int LPPAREN = 193;
	int RPPAREN = 194;
	int AT = 195;
	int PARENT = 196;
	int LITERAL_child = 197;
	int LITERAL_self = 198;
	int LITERAL_descendant = 199;
	// "descendant-or-self" = 200
	// "following-sibling" = 201
	int LITERAL_parent = 202;
	int LITERAL_ancestor = 203;
	// "ancestor-or-self" = 204
	// "preceding-sibling" = 205
	int DOUBLE_LITERAL = 206;
	int DECIMAL_LITERAL = 207;
	int INTEGER_LITERAL = 208;
	// "schema-element" = 209
	int END_TAG_START = 210;
	int QUOT = 211;
	int APOS = 212;
	int QUOT_ATTRIBUTE_CONTENT = 213;
	int ESCAPE_QUOT = 214;
	int APOS_ATTRIBUTE_CONTENT = 215;
	int ESCAPE_APOS = 216;
	int ELEMENT_CONTENT = 217;
	int XML_COMMENT_END = 218;
	int XML_PI_END = 219;
	int XML_CDATA = 220;
	int LITERAL_collection = 221;
	int LITERAL_validate = 222;
	int XML_PI_START = 223;
	int XML_CDATA_START = 224;
	int XML_CDATA_END = 225;
	int LETTER = 226;
	int DIGITS = 227;
	int HEX_DIGITS = 228;
	int NMSTART = 229;
	int NMCHAR = 230;
	int WS = 231;
	int XQDOC_COMMENT = 232;
	int EXPR_COMMENT = 233;
	int PREDEFINED_ENTITY_REF = 234;
	int CHAR_REF = 235;
	int S = 236;
	int NEXT_TOKEN = 237;
	int CHAR = 238;
	int BASECHAR = 239;
	int IDEOGRAPHIC = 240;
	int COMBINING_CHAR = 241;
	int DIGIT = 242;
	int EXTENDER = 243;
}
