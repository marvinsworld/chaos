//package com.ewan.fel.api;
//
//import com.greenpineyu.fel.FelEngine;
//import com.greenpineyu.fel.exception.ParseException;
//import com.greenpineyu.fel.parser.AntlrParser;
//import com.greenpineyu.fel.parser.FelNode;
//import com.greenpineyu.fel.parser.FelParser;
//import com.greenpineyu.fel.parser.NodeAdaptor;
//import org.antlr.runtime.ANTLRInputStream;
//import org.antlr.runtime.CommonTokenStream;
//import org.antlr.runtime.RecognitionException;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//
///**
// * Created by ewan on 17/11/26.
// */
//public class AntlrParserAPI extends AntlrParser {
//    public AntlrParserAPI(FelEngine engine) {
//        super(engine);
//    }
//
//    public FelNode parse(String exp) {
//        if(exp != null && !"".equals(exp)) {
//            ByteArrayInputStream is = new ByteArrayInputStream(exp.getBytes());
//            ANTLRInputStream input = null;
//
//            try {
//                input = new ANTLRInputStream(is);
//            } catch (IOException var10) {
//                var10.printStackTrace();
//            }
//
//            FelLexerAPI lexer = new FelLexerAPI(input);
//            CommonTokenStream tokens = new CommonTokenStream(lexer);
//            FelParser parser = new FelParser(tokens);
//            parser.setTreeAdaptor(new NodeAdaptor());
//            FelParser.program_return r = null;
//
//            try {
//                r = parser.program();
//            } catch (RecognitionException var9) {
//                throw new ParseException(var9.getMessage(), var9);
//            }
//
//            if(r != null) {
//                Object tree = r.getTree();
//                if(tree instanceof FelNode) {
//                    this.initFun((FelNode)tree);
//                    return (FelNode)tree;
//                }
//            }
//
//            return null;
//        } else {
//            return null;
//        }
//    }
//}
