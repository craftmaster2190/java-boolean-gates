package com.craftmaster2190.javaBooleanGates;

public class JavaBooleanGates {
  public static void main(String... args) {

    System.out.println(stringifyTruthTable("BUFFER A", (a, b) -> a));
    System.out.println(stringifyTruthTable("NOT A", (a, b) -> !a));
    System.out.println(stringifyTruthTable("AND", (a, b) -> a && b));
    System.out.println(stringifyTruthTable("OR", (a, b) -> a || b));
    System.out.println(stringifyTruthTable("NAND", (a, b) -> !(a && b)));
    System.out.println(stringifyTruthTable("NAND 2", (a, b) -> !a || !b));
    System.out.println(stringifyTruthTable("NAND 3", (a, b) -> a ? !b : true));
    System.out.println(stringifyTruthTable("NOR", (a, b) -> !(a || b)));
    System.out.println(stringifyTruthTable("NOR 2", (a, b) -> !a && !b));
    System.out.println(stringifyTruthTable("NOR 3", (a, b) -> !a ? !b : false));
    System.out.println(stringifyTruthTable("XOR", (a, b) -> a ^ b));
    System.out.println(stringifyTruthTable("XOR 2", (a, b) -> a != b));
    System.out.println(stringifyTruthTable("XNOR", (a, b) -> a == b));
    System.out.println(stringifyTruthTable("XNOR 2", (a, b) -> !a ^ b));

  }

  static String stringifyTruthTable(String name, BooleanGate booleanGate) {
    return new StringBuilder(118)
        .append(name + "\n")
        .append("_____________\n")
        .append("| A | B | Q |\n")
        .append("-------------\n")
        .append("| 0 | 0 | " + booleanToDigit(booleanGate.apply(false, false)) + " |\n")
        .append("| 0 | 1 | " + booleanToDigit(booleanGate.apply(false, true)) + " |\n")
        .append("| 1 | 0 | " + booleanToDigit(booleanGate.apply(true, false)) + " |\n")
        .append("| 1 | 1 | " + booleanToDigit(booleanGate.apply(true, true)) + " |\n")
        .append("‾‾‾‾‾‾‾‾‾‾‾‾‾\n\n")
        .toString();
  }

  static String booleanToDigit(boolean bool) {
    return bool ? "1" : "0";
  }

  interface BooleanGate {
    boolean apply(boolean a, boolean b);
  }
}
