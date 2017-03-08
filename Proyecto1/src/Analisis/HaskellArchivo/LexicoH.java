/* The following code was generated by JFlex 1.6.1 */

package Analisis.HaskellArchivo;
import java_cup.runtime.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>src/Analisis/HaskellArchivo/LexicoH.jflex</tt>
 */
public class LexicoH implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
    55, 55, 55, 55, 55, 55, 55, 55, 55, 10,  5,  7,  8,  6, 55, 55, 
    55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 
    10, 44, 11, 55, 45, 55, 40,  4, 50, 51, 37, 35, 52, 36, 55, 38, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 54, 53, 43, 42, 41, 55, 
    55, 25,  2, 24, 15, 23, 34, 32, 33, 28,  2,  2, 22, 13, 29, 14, 
    21, 18, 19, 17, 20, 26, 31,  2, 30,  2,  2, 46, 12, 47, 55,  3, 
    55, 25,  2, 24, 15, 23, 34, 32, 33, 28,  2,  2, 22, 13, 29, 14, 
    21, 18, 19, 17, 20, 26, 31,  2, 30,  2,  2, 48, 39, 49, 55, 55, 
    55, 55, 55, 55, 55,  7, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 
    55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 
    55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 
    55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 
    55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 
    55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 
    55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 
    55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\3\1\4\2\5\1\3\2\2"+
    "\1\0\10\2\1\0\1\2\1\6\1\7\1\10\1\11"+
    "\2\3\1\12\1\13\1\14\1\3\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\5\0"+
    "\1\27\1\0\1\2\1\0\2\2\1\0\11\2\1\0"+
    "\1\2\1\0\1\30\1\2\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\3\0\1\42"+
    "\2\43\1\0\2\2\1\44\1\0\1\44\4\2\1\45"+
    "\1\46\1\2\1\0\1\2\1\47\1\0\2\2\2\50"+
    "\1\0\1\2\3\0\2\51\1\52\2\53\1\2\1\54"+
    "\2\2\2\55\2\56\1\2\2\57\1\60\1\0\1\61"+
    "\4\2\1\62\2\63\1\2\1\64\1\2\1\65\1\2"+
    "\1\66";

  private static int [] zzUnpackAction() {
    int [] result = new int[142];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\70\0\160\0\250\0\340\0\250\0\u0118\0\250"+
    "\0\u0150\0\u0188\0\u01c0\0\u01f8\0\u0230\0\u0268\0\u02a0\0\u02d8"+
    "\0\u0310\0\u0348\0\u0380\0\u03b8\0\u03f0\0\u0428\0\u0460\0\250"+
    "\0\250\0\250\0\u0498\0\u04d0\0\u0508\0\u0540\0\u0578\0\u05b0"+
    "\0\250\0\250\0\250\0\250\0\250\0\250\0\250\0\250"+
    "\0\250\0\250\0\u05e8\0\u0620\0\u0658\0\u0690\0\u0150\0\u0150"+
    "\0\u06c8\0\u0700\0\u0738\0\u0770\0\u07a8\0\u07e0\0\u0818\0\u0850"+
    "\0\u0888\0\u08c0\0\u08f8\0\u0930\0\u0968\0\u09a0\0\u09d8\0\u0a10"+
    "\0\u0a48\0\u0a80\0\250\0\u0ab8\0\160\0\250\0\250\0\250"+
    "\0\250\0\250\0\250\0\250\0\250\0\250\0\u0af0\0\u0b28"+
    "\0\u0b60\0\160\0\250\0\160\0\u0b98\0\u0bd0\0\u0c08\0\250"+
    "\0\u0c40\0\160\0\u0c78\0\u0cb0\0\u0ce8\0\u0d20\0\160\0\160"+
    "\0\u0d58\0\u0d90\0\u0dc8\0\160\0\u0e00\0\u0e38\0\u0e70\0\250"+
    "\0\160\0\u0ea8\0\u0ee0\0\u0f18\0\u0f50\0\u0f88\0\250\0\160"+
    "\0\160\0\250\0\160\0\u0fc0\0\160\0\u0ff8\0\u1030\0\250"+
    "\0\160\0\250\0\160\0\u1068\0\250\0\160\0\250\0\u10a0"+
    "\0\250\0\u10d8\0\u1110\0\u1148\0\u1180\0\250\0\250\0\160"+
    "\0\u11b8\0\160\0\u11f0\0\160\0\u1228\0\160";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[142];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\0\1\2\1\3\1\4\1\5\1\6\1\7\1\4"+
    "\1\10\1\0\1\10\1\11\1\4\1\12\1\3\1\13"+
    "\1\14\1\15\1\3\1\16\1\17\1\20\1\21\1\22"+
    "\1\23\1\24\1\3\1\25\1\26\6\3\1\27\1\30"+
    "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40"+
    "\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50"+
    "\1\51\1\52\1\4\1\0\1\2\67\0\3\3\11\0"+
    "\3\3\1\0\12\3\1\0\7\3\115\0\5\53\5\0"+
    "\3\53\1\54\2\53\2\55\3\53\1\56\42\53\5\0"+
    "\1\10\62\0\4\57\1\0\6\57\1\60\1\61\53\57"+
    "\1\0\3\3\11\0\3\3\1\0\10\3\1\62\1\3"+
    "\1\63\1\64\6\3\26\0\3\3\11\0\3\3\1\0"+
    "\6\3\1\65\3\3\1\0\7\3\57\0\1\66\36\0"+
    "\3\3\11\0\3\3\1\0\11\3\1\67\1\0\7\3"+
    "\26\0\3\3\11\0\3\3\1\0\6\3\1\70\3\3"+
    "\1\0\7\3\26\0\3\3\11\0\3\3\1\0\12\3"+
    "\1\0\5\3\1\71\1\3\26\0\3\3\11\0\3\3"+
    "\1\0\2\3\1\72\5\3\1\73\1\3\1\0\7\3"+
    "\26\0\3\3\11\0\3\3\1\0\6\3\1\74\3\3"+
    "\1\0\7\3\26\0\3\3\11\0\3\3\1\0\5\3"+
    "\1\75\4\3\1\0\1\3\1\76\5\3\26\0\3\3"+
    "\11\0\3\3\1\0\10\3\1\77\1\3\1\0\7\3"+
    "\26\0\3\3\11\0\3\3\1\100\1\101\11\3\1\0"+
    "\7\3\42\0\1\102\24\0\1\103\26\0\3\3\11\0"+
    "\1\104\2\3\1\0\12\3\1\0\6\3\1\105\70\0"+
    "\1\106\73\0\1\107\70\0\1\110\71\0\1\111\67\0"+
    "\1\112\67\0\1\113\67\0\1\114\1\0\1\115\17\0"+
    "\1\116\67\0\1\116\11\0\1\117\55\0\1\116\15\0"+
    "\1\120\51\0\1\116\11\0\1\121\51\0\13\57\1\60"+
    "\1\61\53\57\1\0\3\3\11\0\3\3\1\0\12\3"+
    "\1\0\2\3\1\122\4\3\62\0\1\123\33\0\3\3"+
    "\11\0\3\3\1\0\12\3\1\0\1\3\1\124\5\3"+
    "\26\0\3\3\11\0\3\3\1\125\1\126\6\3\1\127"+
    "\2\3\1\0\7\3\42\0\1\130\12\0\1\131\40\0"+
    "\3\3\11\0\1\132\2\3\1\0\7\3\1\133\2\3"+
    "\1\0\7\3\26\0\3\3\11\0\3\3\1\0\12\3"+
    "\1\0\3\3\1\134\3\3\26\0\3\3\11\0\3\3"+
    "\1\0\6\3\1\135\3\3\1\0\7\3\26\0\3\3"+
    "\11\0\1\3\1\136\1\3\1\0\12\3\1\0\7\3"+
    "\26\0\3\3\11\0\3\3\1\0\2\3\1\137\7\3"+
    "\1\0\7\3\26\0\3\3\11\0\3\3\1\0\3\3"+
    "\1\140\6\3\1\0\1\3\1\141\5\3\26\0\3\3"+
    "\11\0\3\3\1\142\1\143\11\3\1\0\7\3\26\0"+
    "\3\3\11\0\2\3\1\144\1\0\12\3\1\0\7\3"+
    "\26\0\3\3\11\0\3\3\1\145\1\146\4\3\1\147"+
    "\4\3\1\0\7\3\55\0\1\150\40\0\3\3\11\0"+
    "\3\3\1\0\7\3\1\151\2\3\1\0\7\3\52\0"+
    "\1\152\43\0\3\3\11\0\3\3\1\0\4\3\1\153"+
    "\5\3\1\0\7\3\44\0\1\154\73\0\1\155\70\0"+
    "\1\156\73\0\1\157\40\0\3\3\11\0\3\3\1\0"+
    "\7\3\1\160\2\3\1\0\7\3\26\0\3\3\11\0"+
    "\3\3\1\0\7\3\1\161\2\3\1\0\7\3\55\0"+
    "\1\162\40\0\3\3\11\0\3\3\1\0\7\3\1\163"+
    "\2\3\1\0\7\3\26\0\3\3\11\0\3\3\1\0"+
    "\6\3\1\164\3\3\1\0\7\3\26\0\3\3\11\0"+
    "\3\3\1\0\12\3\1\0\1\3\1\165\5\3\26\0"+
    "\3\3\11\0\2\3\1\166\1\0\12\3\1\0\7\3"+
    "\26\0\3\3\11\0\3\3\1\0\12\3\1\0\4\3"+
    "\1\167\2\3\54\0\1\170\41\0\3\3\11\0\3\3"+
    "\1\0\6\3\1\171\3\3\1\0\7\3\54\0\1\172"+
    "\41\0\3\3\11\0\3\3\1\0\6\3\1\173\3\3"+
    "\1\0\7\3\26\0\3\3\11\0\3\3\1\0\7\3"+
    "\1\174\2\3\1\0\7\3\50\0\1\175\45\0\3\3"+
    "\11\0\3\3\1\0\2\3\1\176\7\3\1\0\7\3"+
    "\31\0\1\177\107\0\1\200\47\0\1\201\64\0\3\3"+
    "\11\0\3\3\1\0\2\3\1\202\7\3\1\0\7\3"+
    "\26\0\3\3\11\0\3\3\1\0\11\3\1\203\1\0"+
    "\7\3\26\0\3\3\11\0\3\3\1\0\3\3\1\204"+
    "\6\3\1\0\7\3\26\0\3\3\11\0\3\3\1\0"+
    "\11\3\1\205\1\0\7\3\31\0\1\206\64\0\3\3"+
    "\11\0\3\3\1\207\1\210\11\3\1\0\7\3\26\0"+
    "\3\3\11\0\3\3\1\0\7\3\1\211\2\3\1\0"+
    "\7\3\26\0\3\3\11\0\3\3\1\0\12\3\1\0"+
    "\5\3\1\212\1\3\26\0\3\3\11\0\3\3\1\0"+
    "\5\3\1\213\4\3\1\0\7\3\26\0\3\3\11\0"+
    "\3\3\1\0\3\3\1\214\6\3\1\0\7\3\26\0"+
    "\3\3\11\0\3\3\1\0\10\3\1\215\1\3\1\0"+
    "\7\3\26\0\3\3\11\0\3\3\1\0\2\3\1\216"+
    "\7\3\1\0\7\3\25\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4704];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\1\1\11\1\1\1\11\1\1\1\11\3\1"+
    "\1\0\10\1\1\0\2\1\3\11\6\1\12\11\5\0"+
    "\1\1\1\0\1\1\1\0\2\1\1\0\11\1\1\0"+
    "\1\1\1\0\1\11\2\1\11\11\3\0\1\1\1\11"+
    "\1\1\1\0\2\1\1\11\1\0\10\1\1\0\2\1"+
    "\1\0\2\1\1\11\1\1\1\0\1\1\3\0\1\11"+
    "\2\1\1\11\5\1\1\11\1\1\1\11\2\1\1\11"+
    "\1\1\1\11\1\0\1\11\4\1\2\11\7\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[142];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
StringBuffer string=new StringBuffer();


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public LexicoH(java.io.Reader in) {
    this.zzReader = in;
  }



  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(TSHaskell.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return new Symbol (TSHaskell.num, yycolumn, yyline, yytext());
            }
          case 55: break;
          case 2: 
            { return new Symbol (TSHaskell.id, yycolumn, yyline, yytext());
            }
          case 56: break;
          case 3: 
            { /*errores lexicos*/
            }
          case 57: break;
          case 4: 
            { return new Symbol (TSHaskell.eol, yycolumn, yyline, yytext());
            }
          case 58: break;
          case 5: 
            { /*se ignora*/
            }
          case 59: break;
          case 6: 
            { return new Symbol (TSHaskell.suma, yycolumn, yyline, yytext());
            }
          case 60: break;
          case 7: 
            { return new Symbol (TSHaskell.resta, yycolumn, yyline, yytext());
            }
          case 61: break;
          case 8: 
            { return new Symbol (TSHaskell.mult, yycolumn, yyline, yytext());
            }
          case 62: break;
          case 9: 
            { return new Symbol (TSHaskell.div, yycolumn, yyline, yytext());
            }
          case 63: break;
          case 10: 
            { return new Symbol (TSHaskell.mayor, yycolumn, yyline, yytext());
            }
          case 64: break;
          case 11: 
            { return new Symbol (TSHaskell.igual, yycolumn, yyline, yytext());
            }
          case 65: break;
          case 12: 
            { return new Symbol (TSHaskell.menor, yycolumn, yyline, yytext());
            }
          case 66: break;
          case 13: 
            { return new Symbol (TSHaskell.dolar, yycolumn, yyline, yytext());
            }
          case 67: break;
          case 14: 
            { return new Symbol (TSHaskell.corchetea, yycolumn, yyline, yytext());
            }
          case 68: break;
          case 15: 
            { return new Symbol (TSHaskell.corchetec, yycolumn, yyline, yytext());
            }
          case 69: break;
          case 16: 
            { return new Symbol (TSHaskell.llavea, yycolumn, yyline, yytext());
            }
          case 70: break;
          case 17: 
            { return new Symbol (TSHaskell.llavec, yycolumn, yyline, yytext());
            }
          case 71: break;
          case 18: 
            { return new Symbol (TSHaskell.parentesisa, yycolumn, yyline, yytext());
            }
          case 72: break;
          case 19: 
            { return new Symbol (TSHaskell.parentesisc, yycolumn, yyline, yytext());
            }
          case 73: break;
          case 20: 
            { return new Symbol (TSHaskell.coma, yycolumn, yyline, yytext());
            }
          case 74: break;
          case 21: 
            { return new Symbol (TSHaskell.puntoycoma, yycolumn, yyline, yytext());
            }
          case 75: break;
          case 22: 
            { return new Symbol (TSHaskell.dospuntos, yycolumn, yyline, yytext());
            }
          case 76: break;
          case 23: 
            { return new Symbol(TSHaskell.cadena, yycolumn, yyline, yytext().replace("\"", ""));
            }
          case 77: break;
          case 24: 
            { return new Symbol (TSHaskell.si, yycolumn, yyline, yytext());
            }
          case 78: break;
          case 25: 
            { return new Symbol (TSHaskell.concatenacion, yycolumn, yyline, yytext());
            }
          case 79: break;
          case 26: 
            { return new Symbol (TSHaskell.o, yycolumn, yyline, yytext());
            }
          case 80: break;
          case 27: 
            { return new Symbol (TSHaskell.y, yycolumn, yyline, yytext());
            }
          case 81: break;
          case 28: 
            { return new Symbol (TSHaskell.mayorigual, yycolumn, yyline, yytext());
            }
          case 82: break;
          case 29: 
            { return new Symbol (TSHaskell.igualacion, yycolumn, yyline, yytext());
            }
          case 83: break;
          case 30: 
            { return new Symbol (TSHaskell.menorigual, yycolumn, yyline, yytext());
            }
          case 84: break;
          case 31: 
            { return new Symbol (TSHaskell.distinto, yycolumn, yyline, yytext());
            }
          case 85: break;
          case 32: 
            { return new Symbol (TSHaskell.acceso, yycolumn, yyline, yytext());
            }
          case 86: break;
          case 33: 
            { return new Symbol (TSHaskell.caracter, yycolumn, yyline, yytext());
            }
          case 87: break;
          case 34: 
            { return new Symbol (TSHaskell.max, yycolumn, yyline, yytext());
            }
          case 88: break;
          case 35: 
            { return new Symbol (TSHaskell.min, yycolumn, yyline, yytext());
            }
          case 89: break;
          case 36: 
            { return new Symbol (TSHaskell.sum, yycolumn, yyline, yytext());
            }
          case 90: break;
          case 37: 
            { return new Symbol (TSHaskell.par, yycolumn, yyline, yytext());
            }
          case 91: break;
          case 38: 
            { return new Symbol (TSHaskell.let, yycolumn, yyline, yytext());
            }
          case 92: break;
          case 39: 
            { return new Symbol (TSHaskell.fin, yycolumn, yyline, yytext());
            }
          case 93: break;
          case 40: 
            { return new Symbol (TSHaskell.asc, yycolumn, yyline, yytext());
            }
          case 94: break;
          case 41: 
            { return new Symbol (TSHaskell.desc, yycolumn, yyline, yytext());
            }
          case 95: break;
          case 42: 
            { return new Symbol (TSHaskell.decc, yycolumn, yyline, yytext());
            }
          case 96: break;
          case 43: 
            { return new Symbol (TSHaskell.succ, yycolumn, yyline, yytext());
            }
          case 97: break;
          case 44: 
            { return new Symbol (TSHaskell.entonces, yycolumn, yyline, yytext());
            }
          case 98: break;
          case 45: 
            { return new Symbol (TSHaskell.sino, yycolumn, yyline, yytext());
            }
          case 99: break;
          case 46: 
            { return new Symbol (TSHaskell.caso, yycolumn, yyline, yytext());
            }
          case 100: break;
          case 47: 
            { return new Symbol (TSHaskell.impr, yycolumn, yyline, yytext());
            }
          case 101: break;
          case 48: 
            { return new Symbol (TSHaskell.mod, yycolumn, yyline, yytext());
            }
          case 102: break;
          case 49: 
            { return new Symbol (TSHaskell.pot, yycolumn, yyline, yytext());
            }
          case 103: break;
          case 50: 
            { return new Symbol (TSHaskell.sqrt, yycolumn, yyline, yytext());
            }
          case 104: break;
          case 51: 
            { return new Symbol (TSHaskell.revers, yycolumn, yyline, yytext());
            }
          case 105: break;
          case 52: 
            { return new Symbol (TSHaskell.length, yycolumn, yyline, yytext());
            }
          case 106: break;
          case 53: 
            { return new Symbol (TSHaskell.product, yycolumn, yyline, yytext());
            }
          case 107: break;
          case 54: 
            { return new Symbol (TSHaskell.calcular, yycolumn, yyline, yytext());
            }
          case 108: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
