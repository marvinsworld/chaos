//package com.ewan.fel.api;
//
//import com.greenpineyu.fel.function.Dollar;
//import com.greenpineyu.fel.function.FunMgr;
//import com.greenpineyu.fel.function.Function;
//import com.greenpineyu.fel.function.operator.Add;
//import com.greenpineyu.fel.function.operator.And;
//import com.greenpineyu.fel.function.operator.CollectionGet;
//import com.greenpineyu.fel.function.operator.Cond;
//import com.greenpineyu.fel.function.operator.Div;
//import com.greenpineyu.fel.function.operator.Dot;
//import com.greenpineyu.fel.function.operator.Mod;
//import com.greenpineyu.fel.function.operator.Mul;
//import com.greenpineyu.fel.function.operator.NotOper;
//import com.greenpineyu.fel.function.operator.Or;
//import com.greenpineyu.fel.function.operator.Sub;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by ewan on 17/11/26.
// */
//public class FunMgrAPI extends FunMgr {
//
//    private Map<String, Function> userFunMap;
//    private Map<String, Function> funcMap = new HashMap();
//
//    public FunMgrAPI() {
//        this.addFun(new Dot());
//        this.addFun(new CollectionGet());
//        this.addFun(new Cond());
//        this.addFun(new Dollar());
//        this.addFun(new NotOper());
//        this.addFun(new Add());
//        this.addFun(new Sub());
//        //this.addFun(new Equal());
//        //this.addFun(new NotEqual());
//        this.addFun(new Mul());
//        this.addFun(new Div());
//        this.addFun(new Mod());
//        //this.addFun(new LessThen());
//        //this.addFun(new LessThenEqual());
//        //this.addFun(new GreaterThan());
//        //this.addFun(new GreaterThenEqual());
//        this.addFun(new And());
//        this.addFun(new Or());
//
//        this.addFun(new GreaterThenEqualAPI());
//
//        this.userFunMap = new HashMap();
//    }
//
//    private void addFun(Function fun) {
//        this.funcMap.put(fun.getName(), fun);
//    }
//
//    public Function getFun(String funName) {
//        if (funName != null) {
//            String newFunName = this.getLowerCaseName(funName);
//            Function userFun = (Function) this.userFunMap.get(newFunName);
//            return userFun != null ? userFun : (Function) this.funcMap.get(newFunName);
//        } else {
//            return null;
//        }
//    }
//
//    private String getLowerCaseName(String funName) {
//        return funName.toLowerCase();
//    }
//
//    public void add(Function fun) {
//        if (fun != null) {
//            String name = fun.getName();
//            if (name == null || "".equals(name)) {
//                throw new IllegalArgumentException("函数名称不能为空");
//            }
//
//            this.userFunMap.put(this.getLowerCaseName(name), fun);
//        }
//
//    }
//
//    public void remove(String name) {
//        if (name != null) {
//            this.userFunMap.remove(this.getLowerCaseName(name));
//        }
//
//    }
//}
